package com.kbaldauf.playerfinder.network;

import com.kbaldauf.playerfinder.model.Roster;
import com.kbaldauf.playerfinder.model.Sport;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

public interface HockeyEndpointInterface {
    @GET("hockey/nhl/teams")
    Observable<Sport> teams();

    @GET("hockey/nhl/rosters")
    Observable<Roster> roster(@Query("team_id") String team);
}
