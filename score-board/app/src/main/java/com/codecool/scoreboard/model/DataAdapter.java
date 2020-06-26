package com.codecool.scoreboard.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DataAdapter {

    public static Team convertToTeam(TeamResponse.Teams response) {
        String leagues = createLeaguesText(response);
        return new Team(
                response.getIdTeam(),
                response.getStrTeam(),
                response.getStrAlternate(),
                response.getIntFormedYear(),
                response.getStrSport(),
                leagues,
                response.getStrStadium(),
                response.getStrStadiumThumb(),
                response.getStrStadiumLocation(),
                response.getStrStadiumDescription(),
                response.getStrWebsite(),
                response.getStrDescriptionEN(),
                response.getStrTeamLogo(),
                response.getStrYoutube()
        );
    }

    private static String createLeaguesText(TeamResponse.Teams response) {
        List<String> leaguesList = new ArrayList<>(Arrays.asList(response.getStrLeague(), response.getStrLeague2(),
                response.getStrLeague3(), response.getStrLeague4(), response.getStrLeague5()));
        leaguesList.removeAll(Arrays.asList("", null));

        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < leaguesList.size() - 1) {
            sb.append(leaguesList.get(i));
            sb.append("\n\n");
            i++;
        }
        sb.append(leaguesList.get(i));
        return sb.toString();
    }

    public static Match getMatchObject(MatchResponse matchResponse){
        String homeScore = matchResponse.getIntHomeScore();
        String awayScore = matchResponse.getIntAwayScore();
        if (homeScore == null){
            homeScore = "0";
        }
        if (awayScore == null){
            awayScore = "0";
        }
        Match match = new Match(matchResponse.getIdEvent(),
                matchResponse.getStrEvent(),
                matchResponse.getStrLeague(),
                matchResponse.getStrSeason(),
                matchResponse.getDateEvent(),
                matchResponse.getStrTime(),
                Integer.parseInt(homeScore),
                Integer.parseInt(awayScore),
                matchResponse.getStrHomeGoalDetails(),
                matchResponse.getStrHomeYellowCards(),
                matchResponse.getStrAwayGoalDetails(),
                matchResponse.getStrAwayYellowCards());
        return match;
    }
}
