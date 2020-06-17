package com.codecool.scoreboard.model;

public class Team {

    private String id;
    private String teamName;
    private String alternateNames;
    private String formedYear;
    private String sportCategory;
    private String league;
    private String stadiumName;
    private String stadiumImage;
    private String stadiumLocation;
    private String stadiumDesc;
    private String website;
    private String description;
    private String teamLogo;
    private String youtubeVideo;

    public Team(String id, String teamName, String alternateNames, String formedYear, String sportCategory, String league, String stadiumName, String stadiumImage, String stadiumLocation, String stadiumDesc, String website, String description, String teamLogo, String youtubeVideo) {
        this.id = id;
        this.teamName = teamName;
        this.alternateNames = alternateNames;
        this.formedYear = formedYear;
        this.sportCategory = sportCategory;
        this.league = league;
        this.stadiumName = stadiumName;
        this.stadiumImage = stadiumImage;
        this.stadiumLocation = stadiumLocation;
        this.stadiumDesc = stadiumDesc;
        this.website = website;
        this.description = description;
        this.teamLogo = teamLogo;
        this.youtubeVideo = youtubeVideo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getAlternateNames() {
        return alternateNames;
    }

    public void setAlternateNames(String alternateNames) {
        this.alternateNames = alternateNames;
    }

    public String getFormedYear() {
        return formedYear;
    }

    public void setFormedYear(String formedYear) {
        this.formedYear = formedYear;
    }

    public String getSportCategory() {
        return sportCategory;
    }

    public void setSportCategory(String sportCategory) {
        this.sportCategory = sportCategory;
    }

    public String getLeague() {
        return league;
    }

    public void setLeague(String league) {
        this.league = league;
    }

    public String getStadiumImage() {
        return stadiumImage;
    }

    public void setStadiumImage(String stadiumImage) {
        this.stadiumImage = stadiumImage;
    }

    public String getStadiumLocation() {
        return stadiumLocation;
    }

    public void setStadiumLocation(String stadiumLocation) {
        this.stadiumLocation = stadiumLocation;
    }

    public String getStadiumName() {
        return stadiumName;
    }

    public String getStadiumDesc() {
        return stadiumDesc;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTeamLogo() {
        return teamLogo;
    }

    public void setTeamLogo(String teamLogo) {
        this.teamLogo = teamLogo;
    }

    public String getYoutubeVideo() {
        return youtubeVideo;
    }

    public void setYoutubeVideo(String youtubeVideo) {
        this.youtubeVideo = youtubeVideo;
    }
}
