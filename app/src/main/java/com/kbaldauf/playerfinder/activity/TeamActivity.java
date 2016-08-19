package com.kbaldauf.playerfinder.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.kbaldauf.playerfinder.PlayerFinderApplication;
import com.kbaldauf.playerfinder.R;
import com.kbaldauf.playerfinder.adapter.TeamAdapter;
import com.kbaldauf.playerfinder.data.DataManager;
import com.kbaldauf.playerfinder.model.Team;
import com.kbaldauf.playerfinder.util.PocketKnifeActivityIntentUtil;
import com.yqritc.recyclerviewflexibledivider.HorizontalDividerItemDecoration;


import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx.Single;
import rx.SingleSubscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import timber.log.Timber;

public class TeamActivity extends BaseActivity {

    @BindView(R.id.team_list)
    RecyclerView teamList;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.loading_spinner)
    ProgressBar loadingSpinner;
    @BindView(R.id.error_message)
    TextView errorMessage;

    @Inject
    DataManager dataManager;

    private Subscription subscription;
    private TeamAdapter teamAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupTeamListAdapter();
    }

    @Override
    protected void onResume() {
        super.onResume();
        loadData();
        Timber.d("onResume");
    }

    @Override
    protected void onPause() {
        if (subscription != null && ! subscription.isUnsubscribed()) {
            subscription.unsubscribe();
        }
        super.onPause();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.team_menu, menu);
        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        if (errorMessage != null && errorMessage.getVisibility() == View.VISIBLE) {
            menu.findItem(R.id.action_done).setVisible(false);
        }
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Timber.d("onOptionsItemSelected: %s", item.toString());
        switch (item.getItemId()) {
            case R.id.action_done:
                Team team = teamAdapter.getSelectedTeam();
                startActivity(new PocketKnifeActivityIntentUtil(this).getRosterActivityIntent(team.getSlug()));
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected int getContentView() {
        return R.layout.activity_team;
    }

    @Override
    protected void bindDependencies() {
        ButterKnife.bind(this);
        PlayerFinderApplication.from(this).getDataComponent().inject(this);
    }

    @Override
    protected void setupToolbar() {
        setSupportActionBar(toolbar);
    }

    private void setupTeamListAdapter() {
        teamAdapter = new TeamAdapter(this);
        teamList.setLayoutManager(new LinearLayoutManager(this));
        teamList.addItemDecoration(new HorizontalDividerItemDecoration.Builder(this).color(Color.BLACK).build());
        teamList.setAdapter(teamAdapter);
    }

    private void loadData() {
        Single<List<Team>> data = dataManager.getTeams();
        subscription = data
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleSubscriber<List<Team>>() {
                    @Override
                    public void onSuccess(List<Team> teams) {
                        Timber.d("onSuccess with %d teams", teams.size());
                        hideSpinner(teams);
                    }

                    @Override
                    public void onError(Throwable error) {
                        Timber.e(error, "onError");
                        showErrorMessage();
                    }
                });
    }

    private void hideSpinner(List<Team> teams) {
        teamAdapter.setData(teams);
        loadingSpinner.setVisibility(View.GONE);
        errorMessage.setVisibility(View.GONE);
        teamList.setVisibility(View.VISIBLE);
    }

    private void showErrorMessage() {
        loadingSpinner.setVisibility(View.GONE);
        teamList.setVisibility(View.GONE);
        errorMessage.setVisibility(View.VISIBLE);
        invalidateOptionsMenu();
    }
}
