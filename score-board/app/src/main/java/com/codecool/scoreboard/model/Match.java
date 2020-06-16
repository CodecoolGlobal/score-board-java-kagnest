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
    private String videoURL;
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

    public Match(Parcel parcel) {
        idEvent = parcel.readString();
        event = parcel.readString();
        season = parcel.readString();
        dateEvent = parcel.readString();
        startTime = parcel.readString();
        videoURL = parcel.readString();
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
        dest.writeString(videoURL);
        dest.writeInt(homeScore);
        dest.writeInt(awayScore);
        dest.writeString(homeGoalDetails);
        dest.writeString(homeYellowCards);
        dest.writeString(awayGoalDetails);
        dest.writeString(awayYellowCards);

    }
}
