package com.codecool.scoreboard.apiservice;

import com.codecool.scoreboard.model.Event;
import com.codecool.scoreboard.model.TeamResponse;

import io.reactivex.Observable;
import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface DataApiService {

    @GET("lookupteam.php")
    Single<TeamResponse> getTeamById(@Query("id") String teamId);

    @GET("eventspastleague.php?id=4328")
    Observable<Event> getListOfLastMatchesById();


    @GET("eventsnextleague.php?id=4328")
    Single<Event> getListOfNextMatchesById();
}
