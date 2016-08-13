package com.kbaldauf.playerfinder.network;

import com.kbaldauf.playerfinder.model.Hockey;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

public interface HockeyEndpointInterface {
    @GET("hockey/nhl/teams")
    Observable<Hockey> teams();

    @GET("hockey/nhl/rosters")
    Observable<Hockey> roster(@Query("team_id") String team);
}
