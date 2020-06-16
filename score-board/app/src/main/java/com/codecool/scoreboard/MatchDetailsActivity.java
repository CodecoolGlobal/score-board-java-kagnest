package com.codecool.scoreboard;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.codecool.scoreboard.apiservice.DataApiService;
import com.codecool.scoreboard.apiservice.RetrofitClient;
import com.codecool.scoreboard.model.Match;
import com.codecool.scoreboard.model.MatchResponse;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

public class MatchDetailsActivity extends AppCompatActivity {

    @BindView(R.id.event)
    TextView event;

    @BindView(R.id.league)
    TextView league;

    @BindView(R.id.season)
    TextView season;

    @BindView(R.id.date)
    TextView date;

    @BindView(R.id.startTime)
    TextView startTime;

    @BindView(R.id.homeScore)
    TextView homeScore;

    @BindView(R.id.awayScore)
    TextView awayScore;

    @BindView(R.id.homeGoalDetails)
    TextView homeGoalDetails;

    @BindView(R.id.homeYellowCard)
    TextView homeYellowCard;

    @BindView(R.id.awayGoalDetails)
    TextView awayGoalDetails;

    @BindView(R.id.awayYellowCard)
    TextView awayYellowCard;

    String matchId;
    DataApiService apiService;
    Retrofit retrofit;
    CompositeDisposable compositeDisposable = new CompositeDisposable();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match_details_page);
        ButterKnife.bind(this);

        //Intent intent = getIntent();
        //matchId = intent.getStringExtra();

        retrofit = RetrofitClient.getClient();
        apiService = retrofit.create(DataApiService.class);
        fetchData();
    }

    private void fetchData() {
        compositeDisposable.add(apiService.getMatchById(matchId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<MatchResponse>() {
                    @Override
                    public void accept(MatchResponse matchResponse) throws Exception {
                        Match match = new Match(
                                matchResponse.getIdEvent(),
                                matchResponse.getStrEvent(),
                                matchResponse.getStrLeague(),
                                matchResponse.getStrSeason(),
                                matchResponse.getDateEvent(),
                                matchResponse.getStrTime(),
                                Integer.parseInt(matchResponse.getIntHomeScore()),
                                Integer.parseInt(matchResponse.getIntAwayScore()),
                                matchResponse.getStrHomeGoalDetails(),
                                matchResponse.getStrHomeYellowCards(),
                                matchResponse.getStrAwayGoalDetails(),
                                matchResponse.getStrAwayYellowCards()
                        );

                        displayData(match);
                    }
                }));
    }

    private void displayData(Match match) {
        event.setText(match.getEvent());
        league.setText(match.getLeague());
        season.setText(match.getSeason());
        date.setText(match.getDateEvent());
        startTime.setText(match.getStartTime());
        homeScore.setText(match.getHomeScore());
        awayScore.setText(match.getAwayScore());
        homeGoalDetails.setText(match.getHomeGoalDetails());
        homeYellowCard.setText(match.getHomeYellowCards());
        awayGoalDetails.setText(match.getAwayGoalDetails());
        awayYellowCard.setText(match.getAwayYellowCards());
    }


}