package com.kbaldauf.playerfinder.module;

import android.content.Context;

import com.kbaldauf.playerfinder.network.StattleshipClient;
import com.kbaldauf.playerfinder.network.StattleshipRequestInterceptor;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import rx.schedulers.Schedulers;

@Module
public class NetworkModule {

    @Provides
    @Singleton
    static StattleshipRequestInterceptor provideStattleshipRequestInterceptor(Context context) {
        return new StattleshipRequestInterceptor(context);
    }

    @Provides
    @Singleton
    static Interceptor provideInterceptor(StattleshipRequestInterceptor interceptor) {
        return interceptor;
    }

    @Provides
    @Singleton
    static OkHttpClient provideStattleshipOkHttpClient(Interceptor interceptor) {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.interceptors().add(interceptor);
        return builder.build();
    }

    @Provides
    @Singleton
    static RxJavaCallAdapterFactory provideRxJavaCallAdapterFactory() {
        return RxJavaCallAdapterFactory.createWithScheduler(Schedulers.io());
    }

    @Provides
    @Singleton
    static StattleshipClient provideStattleshipClient(Context context, OkHttpClient client, RxJavaCallAdapterFactory RxAdapter) {
        return new StattleshipClient(context, client, RxAdapter);
    }
}
