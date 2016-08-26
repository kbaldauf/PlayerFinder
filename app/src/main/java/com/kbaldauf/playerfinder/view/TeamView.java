package com.kbaldauf.playerfinder.view;

import com.kbaldauf.playerfinder.model.Team;

import java.util.List;

/**
 * Interface exposed to TeamPresenters for updating team screen's UI
 */
public interface TeamView extends PlayerFinderView {
    /**
     * Informs the view that the loading spinner should be hidden as the given teams have been found
     */
    void hideLoadingSpinner(List<Team> teams);
    /**
     * Informs the view that the network error message should be displayed
     */
    void showErrorMessage();
}
