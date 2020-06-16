package com.codecool.scoreboard.apiservice;

import com.codecool.scoreboard.model.TeamResponse;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface DataApiService {

    @GET("lookupteam.php")
    Single<TeamResponse> getTeamById(@Query("id") int teamId);

}
