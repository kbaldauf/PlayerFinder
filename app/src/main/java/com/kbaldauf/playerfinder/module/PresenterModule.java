package com.kbaldauf.playerfinder.module;

import com.kbaldauf.playerfinder.data.DataManager;
import com.kbaldauf.playerfinder.presenter.RosterPresenter;
import com.kbaldauf.playerfinder.presenter.TeamPresenter;
import com.kbaldauf.playerfinder.scope.ActivityScope;

import dagger.Module;
import dagger.Provides;

@Module
public class PresenterModule {

    @Provides
    @ActivityScope
    RosterPresenter provideRosterPresenter(DataManager dataManager) {
        return new RosterPresenter(dataManager);
    }

    @Provides
    @ActivityScope
    TeamPresenter provideTeamPresenter(DataManager dataManager) {
        return new TeamPresenter(dataManager);
    }
}
