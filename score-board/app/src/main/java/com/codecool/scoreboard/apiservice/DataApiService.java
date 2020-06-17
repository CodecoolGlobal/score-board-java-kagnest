package com.codecool.scoreboard.apiservice;

import com.codecool.scoreboard.model.MatchResponse;
import com.codecool.scoreboard.model.TeamResponse;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface DataApiService {

    @GET("lookupteam.php")
    Single<TeamResponse> getTeamById(@Query("id") int teamId);

    @GET("eventspastleague.php?id=4328")
    Observable<List<MatchResponse>> getListOfMatchById();
}
