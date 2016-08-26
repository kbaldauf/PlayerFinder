package com.kbaldauf.playerfinder;

import android.app.Application;
import android.content.Context;
import android.support.annotation.NonNull;

import com.kbaldauf.playerfinder.component.ApplicationComponent;
import com.kbaldauf.playerfinder.component.DaggerApplicationComponent;
import com.kbaldauf.playerfinder.component.DaggerDataComponent;
import com.kbaldauf.playerfinder.component.DaggerNetworkComponent;
import com.kbaldauf.playerfinder.component.DaggerPresenterComponent;
import com.kbaldauf.playerfinder.component.DataComponent;
import com.kbaldauf.playerfinder.component.NetworkComponent;
import com.kbaldauf.playerfinder.component.PresenterComponent;
import com.kbaldauf.playerfinder.module.ApplicationModule;
import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;

import timber.log.Timber;

public class PlayerFinderApplication extends Application {

    private ApplicationComponent applicationComponent;
    private NetworkComponent networkComponent;
    private DataComponent dataComponent;
    private PresenterComponent presenterComponent;
    private RefWatcher refWatcher;

    @Override
    public void onCreate() {
        super.onCreate();
        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }
        refWatcher = LeakCanary.install(this);
        applicationComponent = DaggerApplicationComponent.builder().applicationModule(new ApplicationModule(this)).build();
        networkComponent = DaggerNetworkComponent.builder().applicationComponent(applicationComponent).build();
        dataComponent = DaggerDataComponent.builder().networkComponent(networkComponent).build();
        presenterComponent = DaggerPresenterComponent.builder().dataComponent(dataComponent).build();
    }

    /**
     * Provides a RefWatcher that can be used by LeakCanary to track reference leaks.
     *
     * @return RefWatcher instance.
     */
    public RefWatcher getRefWatcher() {
        return refWatcher;
    }

    /**
     * Provides a ApplicationComponent that can be used to inject application dependencies.
     *
     * @return ApplicationComponent instance.
     */
    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }

    /**
     * Provides a NetworkComponent that can be used to inject network dependencies.
     *
     * @return NetworkComponent instance.
     */
    public NetworkComponent getNetworkComponent() {
        return networkComponent;
    }

    /**
     * Provides a DataComponent that can be used to inject data dependencies.
     *
     * @return DataComponent instance.
     */
    public DataComponent getDataComponent() {
        return dataComponent;
    }

    /**
     * Provides a PresenterComponent that can be used to inject presenter dependencies.
     *
     * @return PresenterComponent instance.
     */
    public PresenterComponent getPresenterComponent() {
        return presenterComponent;
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
