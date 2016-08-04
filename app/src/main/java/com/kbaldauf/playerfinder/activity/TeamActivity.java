package com.kbaldauf.playerfinder.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.kbaldauf.playerfinder.PlayerFinderApplication;
import com.kbaldauf.playerfinder.R;
import com.kbaldauf.playerfinder.adapter.TeamAdapter;
import com.kbaldauf.playerfinder.model.Hockey;
import com.kbaldauf.playerfinder.network.StattleshipClient;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;

public class TeamActivity extends Activity {

    @BindView(R.id.team_list)
    RecyclerView teamList;

    @Inject
    StattleshipClient client;

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
        teamList.setAdapter(teamAdapter);
    }

    @Override
    protected void onResume() {
        super.onResume();

        Observable<Hockey> call = client.getHockeyApi().teams();
        subscription = call.observeOn(AndroidSchedulers.mainThread()).subscribe(new Subscriber<Hockey>() {
            @Override
            public void onCompleted() {
                Log.d("Hockey Observable", "onCompleted");
            }

            @Override
            public void onError(Throwable e) {
                Log.d("Hockey Observable", "onError", e);
            }

            @Override
            public void onNext(Hockey hockey) {
                Log.d("Hockey Observable", "onNext");
                teamAdapter.setData(hockey.getTeams());

            }
        });
        Log.d("MainActivity", "onResume");
    }

    @Override
    protected void onPause() {
        subscription.unsubscribe();
        super.onPause();
    }
}
