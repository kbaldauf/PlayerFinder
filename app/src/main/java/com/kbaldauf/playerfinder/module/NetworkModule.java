package com.kbaldauf.playerfinder.module;

import android.content.Context;

import com.kbaldauf.playerfinder.network.StattleshipClient;
import com.kbaldauf.playerfinder.network.StattleshipRequestInterceptor;

import dagger.Module;
import dagger.Provides;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import rx.schedulers.Schedulers;

@Module
public class NetworkModule {

    @Provides
    StattleshipRequestInterceptor provideStattleshipRequestInterceptor(Context context) {
        return new StattleshipRequestInterceptor(context);
    }

    @Provides
    Interceptor provideInterceptor(StattleshipRequestInterceptor interceptor) {
        return interceptor;
    }

    @Provides
    OkHttpClient provideStattleshipOkHttpClient(Interceptor interceptor) {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.interceptors().add(interceptor);
        return builder.build();
    }

    @Provides
    RxJavaCallAdapterFactory provideRxJavaCallAdapterFactory() {
        return RxJavaCallAdapterFactory.createWithScheduler(Schedulers.io());
    }

    @Provides
    StattleshipClient provideStattleshipClient(Context context, OkHttpClient client, RxJavaCallAdapterFactory RxAdapter) {
        return new StattleshipClient(context, client, RxAdapter);
    }
}
