package com.kbaldauf.playerfinder;

import android.app.Application;
import android.content.Context;
import android.support.annotation.NonNull;

import com.kbaldauf.playerfinder.component.ApplicationComponent;
import com.kbaldauf.playerfinder.component.DaggerApplicationComponent;
import com.kbaldauf.playerfinder.component.DaggerNetworkComponent;
import com.kbaldauf.playerfinder.component.NetworkComponent;
import com.kbaldauf.playerfinder.module.ApplicationModule;

import timber.log.Timber;

public class PlayerFinderApplication extends Application {

    private ApplicationComponent applicationComponent;
    private NetworkComponent networkComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }
        applicationComponent = DaggerApplicationComponent.builder().applicationModule(new ApplicationModule(this)).build();
        networkComponent = DaggerNetworkComponent.builder().applicationComponent(applicationComponent).build();
    }

    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }

    public NetworkComponent getNetworkComponent() {
        return networkComponent;
    }

    /**
     * Extracts application instance from the given context.
     *
     * @param context Source context.
     * @return PlayerFinderApplication instance.
     */
    public static PlayerFinderApplication from(@NonNull Context context) {
        return (PlayerFinderApplication) context.getApplicationContext();
    }
}
