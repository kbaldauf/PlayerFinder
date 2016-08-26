package com.kbaldauf.playerfinder.presenter;

import com.kbaldauf.playerfinder.view.PlayerFinderView;

/**
 * Interface for presenters that can be used with PlayerFinderViews
 */
public interface PlayerFinderPresenter<V extends PlayerFinderView> {

    /**
     * Method used to attach a view to the presenter
     */
    void attachView(V view);
    /**
     * Method used to detach the previously attached view from the presenter
     */
    void detachView();
}
