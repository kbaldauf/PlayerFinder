package com.kbaldauf.playerfinder.module;

import com.kbaldauf.playerfinder.data.DataManager;
import com.kbaldauf.playerfinder.network.StattleshipClient;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class DataModule {

    @Provides
    @Singleton
    static DataManager provideDataManager(StattleshipClient client) {
        return new DataManager(client);
    }
}
