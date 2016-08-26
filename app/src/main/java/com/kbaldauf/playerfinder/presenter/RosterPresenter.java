package com.kbaldauf.playerfinder.presenter;

import android.text.TextUtils;

import com.kbaldauf.playerfinder.data.DataManager;
import com.kbaldauf.playerfinder.model.Player;
import com.kbaldauf.playerfinder.view.RosterView;

import java.util.List;

import javax.inject.Inject;

import rx.Single;
import rx.SingleSubscriber;
import rx.Subscription;
import timber.log.Timber;

/**
 * Presenter that handles interfacing between RosterViews and the DataManager
 */
public class RosterPresenter extends BasePresenter<RosterView> {

    private DataManager manager;
    private Subscription subscription;
    private List<Player> roster;

    @Inject
    public RosterPresenter(DataManager dataManager) {
        manager = dataManager;
    }

    @Override
    public void detachView() {
        // unsubscribes from the stored subscription to stop the receipt of data after the view has been detached
        if (subscription != null && ! subscription.isUnsubscribed()) {
            subscription.unsubscribe();
        }
        subscription = null;
        roster = null;
        super.detachView();
    }

    /**
     * Checks to see if the the roster contains a player with the matching uniform number
     * and passes the result back to the attached view
     *
     * @param number the string representation of the uniform number to lookup
     */
    public void findPlayer(String number) {
        if (! TextUtils.isEmpty(number)) {
            for (Player player : roster) {
                if (number.equals(player.getUniformNumber())) {
                    playerFound(player.getName());
                    return;
                }
            }
        }
        playerNotFound(number);
    }

    /**
     * Requests a team's roster from the DataManager than passes the result back to the attached view
     *
     * @param teamSlug the string slug for the desired team
     */
    public void loadRoster(String teamSlug) {
        Single<List<Player>> data = manager.getPlayers(teamSlug);
        subscription = data
                .subscribe(new SingleSubscriber<List<Player>>() {
                    @Override
                    public void onSuccess(List<Player> players) {
                        Timber.d("onSuccess with roster of size %d", players.size());
                        if (isViewAttached()) {
                            roster = players;
                            getView().hideLoadingSpinner();
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

    /**
     * Passes the player's name back to the attached view
     *
     * @param name the string representation of the matching player's name
     */
    private void playerFound(String name) {
        if (isViewAttached()) {
            getView().playerFound(name);
        }
    }

    /**
     * Passes the uniform number that wasn't found back to the attached view
     *
     * @param number the string representation of the searched uniform number
     */
    private void playerNotFound(String number) {
        if (isViewAttached()) {
            getView().playerNotFound(number);
        }
    }
}
