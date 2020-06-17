package com.codecool.scoreboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.codecool.scoreboard.apiservice.DataApiService;
import com.codecool.scoreboard.apiservice.RetrofitClient;
import com.codecool.scoreboard.model.MatchResponse;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

public class EventsFragment extends Fragment {

    DataApiService apiService;
    Retrofit retrofit;
    CompositeDisposable compositeDisposable = new CompositeDisposable();
    EventListAdapter adapter;

    @BindView(R.id.recyclerEvents)
    RecyclerView recyclerView;

    public EventsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_events, container, false);
        ButterKnife.bind(this, root);
        retrofit = RetrofitClient.getClient();
        apiService = retrofit.create(DataApiService.class);

        fetchData();
        return root;
    }

    private void fetchData() {
        compositeDisposable.add(apiService.getListOfMatchById()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<List<MatchResponse>>() {
                               @Override
                               public void accept(List<MatchResponse> matchResponses) throws Exception {
                                   adapter = new EventListAdapter(matchResponses);
                                   recyclerView.setAdapter(adapter);
                               }
                           }
                ));
    }
}