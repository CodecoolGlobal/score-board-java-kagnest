package com.codecool.scoreboard;

public interface BaseView<T> {

    void setPresenter(T presenter);

    void showErrorMessage(String errorMessage);
}
