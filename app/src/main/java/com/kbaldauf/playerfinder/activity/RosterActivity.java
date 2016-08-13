package com.kbaldauf.playerfinder.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.kbaldauf.playerfinder.PlayerFinderApplication;
import com.kbaldauf.playerfinder.R;
import com.kbaldauf.playerfinder.model.Hockey;
import com.kbaldauf.playerfinder.model.Player;
import com.kbaldauf.playerfinder.network.StattleshipClient;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import pocketknife.BindExtra;
import pocketknife.PocketKnife;
import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import timber.log.Timber;

public class RosterActivity extends AppCompatActivity {

    @BindExtra
    String teamSlug;

    @BindView(R.id.player_name)
    TextView playerName;
    @BindView(R.id.uniform_number)
    EditText uniformNumber;
    @BindView(R.id.submit_button)
    Button submitButton;
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindString(R.string.player_not_found)
    String playerNotFound;

    @Inject
    StattleshipClient client;

    private Subscription subscription;
    private List<Player> roster;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_roster);
        ButterKnife.bind(this);
        PocketKnife.bindExtras(this);
        PlayerFinderApplication.from(this).getNetworkComponent().inject(this);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(teamSlug);

        Observable<Hockey> call = client.getHockeyApi().roster(teamSlug);
        subscription = call
                .observeOn(AndroidSchedulers.mainThread())
                .map(new Func1<Hockey, List<Player>>() {
                    @Override
                    public List<Player> call(Hockey hockey) {
                        return hockey.getPlayers();
                    }
                })
                .subscribe(new Subscriber<List<Player>>() {
                    @Override
                    public void onCompleted() {
                        Timber.d("onCompleted");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Timber.e(e, "onError");
                    }

                    @Override
                    public void onNext(List<Player> players) {
                        Timber.d("onNext");
                        roster = players;
                        submitButton.setEnabled(true);
                    }
                });
    }

    @Override
    protected void onDestroy() {
        if (subscription != null && ! subscription.isUnsubscribed()) {
            subscription.unsubscribe();
        }
        super.onDestroy();
    }

    @OnClick(R.id.submit_button)
    void onClick() {
        String number = uniformNumber.getText().toString();
        if (! TextUtils.isEmpty(number)) {
            for (Player player : roster) {
                if (number.equals(player.getUniformNumber())) {
                    playerName.setText(player.getName());
                    return;
                }
            }
        }
        playerName.setText(String.format(playerNotFound, number));
    }
}
