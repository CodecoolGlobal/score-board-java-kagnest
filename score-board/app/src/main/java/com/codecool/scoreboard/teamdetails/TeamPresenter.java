package com.codecool.scoreboard.teamdetails;

import com.codecool.scoreboard.ErrorHandlerHelper;
import com.codecool.scoreboard.apiservice.DataApiService;
import com.codecool.scoreboard.apiservice.UtilsApi;
import com.codecool.scoreboard.model.DataAdapter;
import com.codecool.scoreboard.model.Team;
import com.codecool.scoreboard.model.TeamResponse;

import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;


public class TeamPresenter implements TeamContract.Presenter {

    private TeamContract.View view;
    private DataApiService dataApiService;

    public TeamPresenter(TeamContract.View view) {
        this.view = view;
        dataApiService = UtilsApi.getApiService();
    }

    @Override
    public void onAttach() {
        view.setPresenter(this);
    }

    @Override
    public void onDetach() {
        this.view = null;
    }

    public void getTeamById(int id) {
        dataApiService.getTeamById(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<TeamResponse>() {

                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onSuccess(TeamResponse response) {
                        if (!response.getTeams().isEmpty()) {
                            TeamResponse.Teams teamResponse = response.getTeams().get(0);
                            Team team = DataAdapter.convertToTeam(teamResponse);
                            view.showTeam(team);
                        } else {
                            view.showEmptyTeamData();
                        }
                    }

                    @Override
                    public void onError(Throwable error) {
                        error.printStackTrace();
                        String errorMessage = ErrorHandlerHelper.getErrorMessage(error);
                        view.showErrorMessage(errorMessage);
                    }
                });
    }


}
