package com.kbaldauf.playerfinder.network;

import com.kbaldauf.playerfinder.model.Hockey;

import retrofit2.Call;
import retrofit2.http.GET;
import rx.Observable;

public interface HockeyEndpointInterface {
    @GET("hockey/nhl/teams")
    Observable<Hockey> teams();
}
