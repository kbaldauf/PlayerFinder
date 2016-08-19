
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

import rx.Single;
import rx.functions.Action1;
import rx.functions.Func1;

public class DataManager {


    private StattleshipClient client;
    private Sport sport;
    private Map<String, Roster> rosters = new HashMap<>();

    @Inject
    public DataManager(StattleshipClient client) {
        this.client = client;
    }

    public boolean hasSportsData() {
        return sport != null;
    }

    public Sport getSportsData() {
        return sport;
    }

    public boolean hasRoster(String slug) {
        return rosters.containsKey(slug);
    }

    public Single<List<Team>> getTeams() {
        Single<List<Team>> observable;
        if (hasSportsData()) {
            observable = Single.just(getSportsData().getTeams());
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
                    });
        }
        return observable;
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
                            rosters.put(slug, roster);
                        }
                    })
                    .map(new Func1<Roster, List<Player>>() {
                        @Override
                        public List<Player> call(Roster roster) {
                            return roster.getPlayers();
                        }
                    });
        }
        return observable;
    }
}
