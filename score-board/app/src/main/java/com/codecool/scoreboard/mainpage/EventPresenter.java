package com.codecool.scoreboard.mainpage;

import com.codecool.scoreboard.ErrorHandlerHelper;
import com.codecool.scoreboard.apiservice.DataApiService;
import com.codecool.scoreboard.apiservice.UtilsApi;
import com.codecool.scoreboard.model.Event;

import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class EventPresenter implements EventsContract.Presenter {

    private EventsContract.View view;
    private DataApiService apiService;

    public EventPresenter(EventsContract.View view) {
        this.view = view;
        apiService = UtilsApi.getApiService();
    }


    public void fetchLastMacthesData() {
        apiService.getListOfLastMatchesById()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<Event>() {
                               @Override
                               public void onSubscribe(Disposable d) {

                               }

                               @Override
                               public void onSuccess(Event event) {
                                   view.showList(event);
                               }

                               @Override
                               public void onError(Throwable error) {
                                   error.printStackTrace();
                                   String errorMessage = ErrorHandlerHelper.getErrorMessage(error);
                                   view.showErrorMessage(errorMessage);

                               }
                           }
                );
    }

    public void fetchNextMatchesData() {
        apiService.getListOfNextMatchesById()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<Event>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onSuccess(Event event) {
                        view.showList(event);
                    }

                    @Override
                    public void onError(Throwable error) {
                        error.printStackTrace();
                        String errorMessage = ErrorHandlerHelper.getErrorMessage(error);
                        view.showErrorMessage(errorMessage);
                    }
                });
    }

    @Override
    public void onAttach() {
        view.setPresenter(this);
    }

    @Override
    public void onDetach() {
        this.view = null;
    }
}
