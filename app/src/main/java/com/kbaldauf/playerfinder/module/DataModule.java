package com.kbaldauf.playerfinder.module;

import com.kbaldauf.playerfinder.data.DataManager;
import com.kbaldauf.playerfinder.network.StattleshipClient;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import rx.Scheduler;
import rx.android.schedulers.AndroidSchedulers;

@Module
public class DataModule {

    @Provides
    @Singleton
    Scheduler provideMainScheduler() {
        return AndroidSchedulers.mainThread();
    }

    @Provides
    @Singleton
    static DataManager provideDataManager(StattleshipClient client, Scheduler mainScheduler) {
        return new DataManager(client, mainScheduler);
    }
}
