package com.kbaldauf.playerfinder.presenter;

import com.kbaldauf.playerfinder.view.PlayerFinderView;

/**
 * Base implementation of the PlayerFinderPresenter
 */
public class BasePresenter<V extends PlayerFinderView> implements PlayerFinderPresenter<V> {

    private V view;

    @Override
    public void attachView(V view) {
        // store the given PlayerFinderView in a private member variable
        this.view = view;
    }

    @Override
    public void detachView() {
        // clear the stored PlayerFinderView
        view = null;
    }

    /**
     * Provides subclasses of BasePresenter access to the attached PlayerFinderView
     */
    protected V getView() {
        return view;
    }

    /**
     * Informs subclasses of BasePresenter whether or not a PlayerFinderView is attached
     */
    protected boolean isViewAttached() {
        return view != null;
    }
}
