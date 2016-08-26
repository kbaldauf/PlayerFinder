package com.kbaldauf.playerfinder.component;

import com.kbaldauf.playerfinder.activity.RosterActivity;
import com.kbaldauf.playerfinder.activity.TeamActivity;
import com.kbaldauf.playerfinder.module.PresenterModule;
import com.kbaldauf.playerfinder.scope.ActivityScope;

import dagger.Component;

@ActivityScope
@Component(dependencies = DataComponent.class, modules = PresenterModule.class)
public interface PresenterComponent {
    void inject(TeamActivity activity);
    void inject(RosterActivity activity);
}
