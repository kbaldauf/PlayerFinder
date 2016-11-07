package com.kbaldauf.playerfinder.activity;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.kbaldauf.playerfinder.PlayerFinderApplication;
import com.kbaldauf.playerfinder.R;
import com.kbaldauf.playerfinder.presenter.RosterPresenter;
import com.kbaldauf.playerfinder.view.RosterView;

import javax.inject.Inject;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import pocketknife.BindExtra;
import pocketknife.PocketKnife;
import timber.log.Timber;

public class RosterActivity extends BaseActivity implements RosterView {

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
    @BindView(R.id.error_message)
    TextView errorMessage;

    @BindString(R.string.player_not_found)
    String playerNotFound;

    @Inject
    RosterPresenter presenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter.attachView(this);
        presenter.generateViewTitle(teamSlug);
        presenter.loadRoster(teamSlug);
    }

    @Override
    protected void onDestroy() {
        presenter.detachView();
        super.onDestroy();
    }

    @OnClick(R.id.submit_button)
    void onClick() {
        Timber.d("Submit button clicked");
        presenter.findPlayer(uniformNumber.getText().toString());
    }

    @Override
    protected int getContentView() {
        return R.layout.activity_roster;
    }

    @Override
    protected void bindDependencies() {
        ButterKnife.bind(this);
        PocketKnife.bindExtras(this);
        PlayerFinderApplication.from(this).getPresenterComponent().inject(this);
    }

    @Override
    protected void setupToolbar() {
        setSupportActionBar(toolbar);
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setTitle(teamSlug);
            supportActionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public void hideLoadingSpinner() {
        loadingSpinner.setVisibility(View.GONE);
        errorMessage.setVisibility(View.GONE);
        rosterViewContainer.setVisibility(View.VISIBLE);
    }

    @Override
    public void showErrorMessage() {
        loadingSpinner.setVisibility(View.GONE);
        rosterViewContainer.setVisibility(View.GONE);
        errorMessage.setVisibility(View.VISIBLE);
    }

    @Override
    public void playerFound(String name) {
        playerName.setText(name);
    }

    @Override
    public void playerNotFound(String number) {
        playerFound(String.format(playerNotFound, number));
    }

    @Override
    public void updateViewTitle(String title) {
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setTitle(title);
        }
    }
}
