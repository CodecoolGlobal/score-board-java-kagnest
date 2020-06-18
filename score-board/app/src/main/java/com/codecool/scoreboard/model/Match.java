package com.codecool.scoreboard.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import lombok.Data;

@Data
public class Match implements Parcelable {

    public static final Creator<Match> CREATOR = new Creator<Match>() {
        @Override
        public Match createFromParcel(Parcel source) {
            return new Match(source);
        }

        @Override
        public Match[] newArray(int size) {
            return new Match[0];
        }
    };

    @NonNull
    private String idEvent;
    @NonNull
    private String event;
    @NonNull
    private String league;
    @NonNull
    private String season;
    @NonNull
    private String dateEvent;
    @NonNull
    private String startTime;
    @NonNull
    private int homeScore;
    @NonNull
    private int awayScore;
    @NonNull
    private String homeGoalDetails;
    @NonNull
    private String homeYellowCards;
    @NonNull
    private String awayGoalDetails;
    @NonNull
    private String awayYellowCards;

    public Match(@NonNull String idEvent, @NonNull String event, @NonNull String league, @NonNull String season, @NonNull String dateEvent, @NonNull String startTime, int homeScore, int awayScore, @NonNull String homeGoalDetails, @NonNull String homeYellowCards, @NonNull String awayGoalDetails, @NonNull String awayYellowCards) {
        this.idEvent = idEvent;
        this.event = event;
        this.league = league;
        this.season = season;
        this.dateEvent = dateEvent;
        this.startTime = startTime;
        this.homeScore = homeScore;
        this.awayScore = awayScore;
        this.homeGoalDetails = homeGoalDetails;
        this.homeYellowCards = homeYellowCards;
        this.awayGoalDetails = awayGoalDetails;
        this.awayYellowCards = awayYellowCards;
    }

    public Match(Parcel parcel) {
        idEvent = parcel.readString();
        event = parcel.readString();
        league = parcel.readString();
        season = parcel.readString();
        dateEvent = parcel.readString();
        startTime = parcel.readString();
        homeScore = parcel.readInt();
        awayScore = parcel.readInt();
        homeGoalDetails = parcel.readString();
        homeYellowCards = parcel.readString();
        awayGoalDetails = parcel.readString();
        awayYellowCards = parcel.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(idEvent);
        dest.writeString(event);
        dest.writeString(league);
        dest.writeString(season);
        dest.writeString(dateEvent);
        dest.writeString(startTime);
        dest.writeInt(homeScore);
        dest.writeInt(awayScore);
        dest.writeString(homeGoalDetails);
        dest.writeString(homeYellowCards);
        dest.writeString(awayGoalDetails);
        dest.writeString(awayYellowCards);

    }
}
