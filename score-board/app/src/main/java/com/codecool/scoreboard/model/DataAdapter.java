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
                response.getStrStadiumDescription(),
                response.getStrWebsite(),
                response.getStrDescriptionEN(),
                response.getStrTeamLogo(),
                response.getStrYoutube()
        );
    }

    private static String createLeaguesText(TeamResponse.Teams response) {
        List<String> leaguesList = new ArrayList<>(Arrays.asList(response.getStrLeague(), response.getIdLeague2(),
                response.getIdLeague3(), response.getIdLeague4(), response.getIdLeague5()));
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
}
