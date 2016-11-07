package com.kbaldauf.playerfinder.view;

/**
 * Interface exposed to RosterPresenters for updating the roster screen's UI
 */
public interface RosterView extends PlayerFinderView {
    /**
     * Informs the view that the loading spinner should be hidden
     */
    void hideLoadingSpinner();
    /**
     * Informs the view that the network error message should be displayed
     */
    void showErrorMessage();
    /**
     * Informs the view of the player that has been found
     */
    void playerFound(String playerName);
    /**
     * Informs the view that no player has been found for the given uniform number
     */
    void playerNotFound(String number);
    /**
     * Informs the view that the actionbar's title should be updated to the given title
     */
    void updateViewTitle(String title);
}
