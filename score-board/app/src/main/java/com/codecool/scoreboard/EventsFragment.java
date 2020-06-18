package com.codecool.scoreboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.codecool.scoreboard.apiservice.DataApiService;
import com.codecool.scoreboard.apiservice.RetrofitClient;
import com.codecool.scoreboard.apiservice.UtilsApi;
import com.codecool.scoreboard.model.Event;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;


public class EventsFragment extends Fragment {

    DataApiService apiService;
    CompositeDisposable compositeDisposable = new CompositeDisposable();
    EventListAdapter adapter;
    private static final String CALL_TYPE = "call_type";
    String call;
    @BindView(R.id.title)
    TextView title;

    @BindView(R.id.recyclerEvents)
    RecyclerView recyclerView;

    public EventsFragment() {
        // Required empty public constructor
    }

    public static EventsFragment newInstance(String call) {
        EventsFragment fragment = new EventsFragment();
        Bundle args = new Bundle();
        args.putString(CALL_TYPE, call);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
             call = getArguments().getString(CALL_TYPE);
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_events, container, false);
        ButterKnife.bind(this, root);
        apiService = UtilsApi.getApiService();
        if (call.equals("last")){
            title.setText(R.string.latest_15_events);
            fetchLastMacthesData();
        } else {
            title.setText(R.string.next_15_events_title);
            fetchNextMatchesData();
        }
        return root;
    }

    private void fetchLastMacthesData() {
        compositeDisposable.add(apiService.getListOfLastMatchesById()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Event>() {
                               @Override
                               public void accept(Event event) throws Exception {
                                   adapter = new EventListAdapter(event.getEvents());
                                   recyclerView.setAdapter(adapter);
                                   recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                               }
                           }
                ));
    }

    private void fetchNextMatchesData(){
        apiService.getListOfNextMatchesById()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<Event>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onSuccess(Event event) {
                        adapter = new EventListAdapter(event.getEvents());
                        recyclerView.setAdapter(adapter);
                        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                    }

                    @Override
                    public void onError(Throwable error) {
                        error.printStackTrace();
                        String errorMessage = ErrorHandlerHelper.getErrorMessage(error);
                    }
                });
    }
}