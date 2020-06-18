package com.codecool.scoreboard.teamdetails;

import com.codecool.scoreboard.BasePresenter;
import com.codecool.scoreboard.BaseView;
import com.codecool.scoreboard.model.Team;

public interface TeamContract {

    interface View extends BaseView<Presenter> {

        void showTeam(Team team);

        void showEmptyTeamData();

        void showErrorMessage(String errorMessage);
    }

    interface Presenter extends BasePresenter {
        void getTeamById(String id);
    }
}
