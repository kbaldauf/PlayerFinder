package com.kbaldauf.playerfinder.presenter;

import com.kbaldauf.playerfinder.data.DataManager;
import com.kbaldauf.playerfinder.model.Team;
import com.kbaldauf.playerfinder.view.TeamView;

import java.util.List;

import javax.inject.Inject;

import rx.Single;
import rx.SingleSubscriber;
import rx.Subscription;
import timber.log.Timber;

/**
 * Presenter that handles interfacing between TeamViews and the DataManager
 */
public class TeamPresenter extends BasePresenter<TeamView> {

    private DataManager manager;
    private Subscription subscription;

    @Inject
    public TeamPresenter(DataManager dataManager) {
        manager = dataManager;
    }

    @Override
    public void attachView(TeamView view) {
        super.attachView(view);
        loadData();
    }

    @Override
    public void detachView() {
        // unsubscribes from the stored subscription to stop the receipt of data after the view has been detached
        if (subscription != null && ! subscription.isUnsubscribed()) {
            subscription.unsubscribe();
        }
        subscription = null;
        super.detachView();
    }

    /**
     * Requests a list of teams from the DataManager than passes the result back to the attached view
     */
    private void loadData() {
        Single<List<Team>> data = manager.getTeams();
        subscription = data
                .subscribe(new SingleSubscriber<List<Team>>() {
                    @Override
                    public void onSuccess(List<Team> teams) {
                        Timber.d("onSuccess with %d teams", teams.size());
                        if (isViewAttached()) {
                            getView().hideLoadingSpinner(teams);
                        }
                    }

                    @Override
                    public void onError(Throwable error) {
                        Timber.e(error, "onError");
                        if (isViewAttached()) {
                            getView().showErrorMessage();
                        }
                    }
                });
    }
}
