package com.codecool.scoreboard.mainpage;

import com.codecool.scoreboard.BasePresenter;
import com.codecool.scoreboard.BaseView;
import com.codecool.scoreboard.model.Event;

public interface EventsContract {

    interface View extends BaseView<Presenter> {

        void showList(Event event);
    }

    interface Presenter extends BasePresenter {

        void fetchLastMacthesData();

        void fetchNextMatchesData();

    }
}
