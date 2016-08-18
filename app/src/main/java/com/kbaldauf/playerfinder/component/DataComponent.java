package com.kbaldauf.playerfinder.component;

import com.kbaldauf.playerfinder.activity.RosterActivity;
import com.kbaldauf.playerfinder.activity.TeamActivity;
import com.kbaldauf.playerfinder.module.DataModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(dependencies = NetworkComponent.class, modules = DataModule.class)
public interface DataComponent {
    void inject(TeamActivity activity);
    void inject(RosterActivity activity);
}
