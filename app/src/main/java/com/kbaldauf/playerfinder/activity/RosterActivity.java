package com.kbaldauf.playerfinder.activity;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.kbaldauf.playerfinder.PlayerFinderApplication;
import com.kbaldauf.playerfinder.R;
import com.kbaldauf.playerfinder.model.DataManager;
import com.kbaldauf.playerfinder.model.Player;
import com.kbaldauf.playerfinder.model.Roster;
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

public class RosterActivity extends BaseActivity {

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
    @BindView(R.id.loading_spinner)
    ProgressBar loadingSpinner;
    @BindView(R.id.roster_view_container)
    ViewGroup rosterViewContainer;

    @BindString(R.string.player_not_found)
    String playerNotFound;

    @Inject
    StattleshipClient client;
    @Inject
    DataManager dataManager;

    private Subscription subscription;
    private List<Player> roster;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loadData();
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
        Timber.d("Submit button clicked");
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

    @Override
    protected int getContentView() {
        return R.layout.activity_roster;
    }

    @Override
    protected void bindDependencies() {
        ButterKnife.bind(this);
        PocketKnife.bindExtras(this);
        PlayerFinderApplication.from(this).getNetworkComponent().inject(this);
    }

    @Override
    protected void setupToolbar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(teamSlug);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void loadData() {
        if (dataManager.hasRoster(teamSlug)) {
            Timber.d("Roster already exists in DataManager");
            hideLoadingSpinner(dataManager.getRoster(teamSlug).getPlayers());
        } else {
            Observable<Roster> call = client.getHockeyApi().roster(teamSlug);
            subscription = call
                    .observeOn(AndroidSchedulers.mainThread())
                    .map(new Func1<Roster, Roster>() {
                        @Override
                        public Roster call(Roster roster) {
                            dataManager.addRoster(teamSlug, roster);
                            return roster;
                        }
                    })
                    .map(new Func1<Roster, List<Player>>() {
                        @Override
                        public List<Player> call(Roster roster) {
                            return roster.getPlayers();
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
                            hideLoadingSpinner(players);
                        }
                    });
        }
    }

    private void hideLoadingSpinner(List<Player> players) {
        roster = players;
        loadingSpinner.setVisibility(View.GONE);
        rosterViewContainer.setVisibility(View.VISIBLE);
    }
}
