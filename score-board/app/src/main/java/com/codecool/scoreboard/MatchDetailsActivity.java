package com.codecool.scoreboard;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.codecool.scoreboard.model.Match;

import butterknife.BindView;
import butterknife.ButterKnife;

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

    Match match;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match_details_page);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        match = intent.getParcelableExtra("match");
        displayData(match);
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