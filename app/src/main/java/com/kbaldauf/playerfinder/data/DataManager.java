
package com.kbaldauf.playerfinder.data;

import com.kbaldauf.playerfinder.model.Player;
import com.kbaldauf.playerfinder.model.Roster;
import com.kbaldauf.playerfinder.model.Sport;
import com.kbaldauf.playerfinder.model.Team;
import com.kbaldauf.playerfinder.network.StattleshipClient;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import rx.Scheduler;
import rx.Single;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

public class DataManager {


    private StattleshipClient client;
    private Scheduler mainScheduler;
    private Sport sport;
    private Map<String, Roster> rosters = new HashMap<>();
    private Map<String, Team> teams = new HashMap<>();

    @Inject
    public DataManager(StattleshipClient client, Scheduler mainScheduler) {
        this.client = client;
        this.mainScheduler = mainScheduler;
    }

    public Single<List<Team>> getTeams() {
        Single<List<Team>> observable;
        if (hasSportsData()) {
            observable = Single.just(sport.getTeams());
        } else {
            Single<Sport> networkObservable = client.getHockeyApi().teams();
            observable = networkObservable
                    .doOnSuccess(new Action1<Sport>() {
                        @Override
                        public void call(Sport s) {
                            // store network response
                            sport = s;
                        }
                    })
                    .map(new Func1<Sport, List<Team>>() {
                        @Override
                        public List<Team> call(Sport sport) {
                            // convert network response to list of teams
                            return sport.getTeams();
                        }
                    })
                    .doOnSuccess(new Action1<List<Team>>() {
                        @Override
                        public void call(List<Team> teamList) {
                            // store team in map with slug key
                            for (Team team : teamList) {
                                teams.put(team.getSlug(), team);
                            }
                        }
                    });
        }

        return observable.compose(this.<List<Team>>applySchedulers());
    }

    public Single<List<Player>> getPlayers(final String slug) {
        Single<List<Player>> observable;
        if (hasRoster(slug)) {
            observable = Single.just(rosters.get(slug).getPlayers());
        } else {
            Single<Roster> networkObservable = client.getHockeyApi().roster(slug);
            observable = networkObservable
                    .doOnSuccess(new Action1<Roster>() {
                        @Override
                        public void call(Roster roster) {
                            // store roster in map with slug key
                            rosters.put(slug, roster);
                        }
                    })
                    .map(new Func1<Roster, List<Player>>() {
                        @Override
                        public List<Player> call(Roster roster) {
                            // convert network response to list of players
                            return roster.getPlayers();
                        }
                    });
        }
        return observable.compose(this.<List<Player>>applySchedulers());
    }

    public Team getTeam(String slug) {
        return teams.get(slug);
    }

    private <T>Single.Transformer<T,T> applySchedulers() {
        return new Single.Transformer<T, T>() {
            @Override
            public Single<T> call(Single<T> single) {
                return single
                        .subscribeOn(Schedulers.io())
                        .observeOn(mainScheduler);
            }
        };
    }

    private boolean hasSportsData() {
        return sport != null;
    }

    private boolean hasRoster(String slug) {
        return rosters.containsKey(slug);
    }
}
