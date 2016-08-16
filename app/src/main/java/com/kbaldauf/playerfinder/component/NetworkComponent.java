package com.kbaldauf.playerfinder.component;

import com.kbaldauf.playerfinder.activity.RosterActivity;
import com.kbaldauf.playerfinder.activity.TeamActivity;
import com.kbaldauf.playerfinder.module.DataModule;
import com.kbaldauf.playerfinder.module.NetworkModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(dependencies = ApplicationComponent.class, modules = { NetworkModule.class, DataModule.class })
public interface NetworkComponent {
    void inject(TeamActivity activity);
    void inject(RosterActivity activity);
}