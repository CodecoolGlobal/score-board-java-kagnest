package com.codecool.scoreboard.mainpage;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.codecool.scoreboard.R;
import com.codecool.scoreboard.apiservice.DataApiService;
import com.codecool.scoreboard.apiservice.RetrofitClient;
import com.codecool.scoreboard.apiservice.UtilsApi;
import com.codecool.scoreboard.model.Event;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Retrofit;


public class EventsFragment extends Fragment implements EventsContract.View {

    private EventsContract.Presenter presenter;
    DataApiService apiService;
    EventListAdapter adapter;
    Retrofit retrofit;
    private static final String CALL_TYPE = "call_type";
    String call;
    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.error_message)
    TextView errorText;
    @BindView(R.id.error_page)
    ConstraintLayout errorPage;

    @BindView(R.id.recyclerEvents)
    RecyclerView recyclerView;

    public EventsFragment() {

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

        View root = inflater.inflate(R.layout.fragment_events, container, false);
        ButterKnife.bind(this, root);
        presenter = new EventPresenter(this);
        apiService = UtilsApi.getApiService();
        if (call.equals("last")) {
            title.setText(R.string.latest_15_events);
            presenter.fetchLastMacthesData();
        } else {
            title.setText(R.string.next_15_events_title);
            presenter.fetchNextMatchesData();
        }

        retrofit = RetrofitClient.getClient();
        apiService = retrofit.create(DataApiService.class);

        return root;
    }


    @Override
    public void setPresenter(EventsContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void showErrorMessage(String errorMessage) {
        errorText.setText(errorMessage);
        errorPage.setVisibility(View.VISIBLE);
    }

    @Override
    public void showList(Event event) {
        adapter = new EventListAdapter(event.getEvents());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    }
}