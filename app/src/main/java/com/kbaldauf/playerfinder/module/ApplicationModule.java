package com.kbaldauf.playerfinder.module;

import android.content.Context;

import com.kbaldauf.playerfinder.PlayerFinderApplication;

import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationModule {

    private final PlayerFinderApplication application;

    public ApplicationModule(PlayerFinderApplication application) {
        this.application = application;
    }

    @Provides
    Context provideApplicationContext() {
        return application;
    }
}
