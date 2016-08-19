package com.kbaldauf.playerfinder.network;

import com.kbaldauf.playerfinder.model.Roster;
import com.kbaldauf.playerfinder.model.Sport;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Single;

public interface HockeyEndpointInterface {
    @GET("hockey/nhl/teams")
    Single<Sport> teams();

    @GET("hockey/nhl/rosters")
    Single<Roster> roster(@Query("team_id") String team);
}
