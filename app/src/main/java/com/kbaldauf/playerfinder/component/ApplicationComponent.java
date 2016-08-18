package com.kbaldauf.playerfinder.component;

import android.content.Context;

import com.kbaldauf.playerfinder.PlayerFinderApplication;
import com.kbaldauf.playerfinder.module.ApplicationModule;

import dagger.Component;

@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {
    void inject(PlayerFinderApplication application);

    Context exposeContext();
}
