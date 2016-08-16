package com.kbaldauf.playerfinder.module;

import com.kbaldauf.playerfinder.model.DataManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class DataModule {

    @Provides
    @Singleton
    static DataManager provideDataManager() {
        return new DataManager();
    }
}
