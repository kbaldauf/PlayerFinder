package com.kbaldauf.playerfinder.network;


import android.content.Context;

import com.kbaldauf.playerfinder.R;

import javax.inject.Inject;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class StattleshipClient {

    private HockeyEndpointInterface hockeyEndpoint;

    @Inject
    public StattleshipClient(Context context, OkHttpClient client, RxJavaCallAdapterFactory rxAdapter) {


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(context.getString(R.string.stattleship_base_api))
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(rxAdapter)
                .build();
        hockeyEndpoint = retrofit.create(HockeyEndpointInterface.class);
    }

    public HockeyEndpointInterface getHockeyApi() {
        return hockeyEndpoint;
    }
}
