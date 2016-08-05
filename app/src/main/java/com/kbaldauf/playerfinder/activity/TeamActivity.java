package com.kbaldauf.playerfinder.activity;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.kbaldauf.playerfinder.PlayerFinderApplication;
import com.kbaldauf.playerfinder.R;
import com.kbaldauf.playerfinder.adapter.TeamAdapter;
import com.kbaldauf.playerfinder.model.Hockey;
import com.kbaldauf.playerfinder.model.Team;
import com.kbaldauf.playerfinder.network.StattleshipClient;
import com.yqritc.recyclerviewflexibledivider.HorizontalDividerItemDecoration;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import timber.log.Timber;

public class TeamActivity extends Activity {

    @BindView(R.id.team_list) RecyclerView teamList;

    @Inject StattleshipClient client;

    private Subscription subscription;
    private TeamAdapter teamAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        PlayerFinderApplication.from(this).getNetworkComponent().inject(this);
        teamAdapter = new TeamAdapter(this);
        teamList.setLayoutManager(new LinearLayoutManager(this));
        teamList.addItemDecoration(new HorizontalDividerItemDecoration.Builder(this).color(Color.BLACK).build());
        teamList.setAdapter(teamAdapter);
    }

    @Override
    protected void onResume() {
        super.onResume();

        Observable<Hockey> call = client.getHockeyApi().teams();
        subscription = call
                .observeOn(AndroidSchedulers.mainThread())
                .map(new Func1<Hockey, List<Team>>() {
                    @Override
                    public List<Team> call(Hockey hockey) {
                        return hockey.getTeams();
                    }
                })
                .subscribe(new Subscriber<List<Team>>() {
                    @Override
                    public void onCompleted() {
                        Timber.d("onCompleted");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Timber.e(e, "onError");
                    }

                    @Override
                    public void onNext(List<Team> teams) {
                        Timber.d("onNext");
                        teamAdapter.setData(teams);
                    }
                });
        Timber.d("onResume");
    }

    @Override
    protected void onPause() {
        if (subscription != null && ! subscription.isUnsubscribed()) {
            subscription.unsubscribe();
        }
        super.onPause();
    }
}
