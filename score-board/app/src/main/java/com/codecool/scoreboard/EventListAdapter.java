package com.codecool.scoreboard;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.codecool.scoreboard.model.Match;
import com.codecool.scoreboard.model.MatchResponse;

import java.util.List;

public class EventListAdapter extends RecyclerView.Adapter<EventListAdapter.EventListHolder> {

    List<MatchResponse> events;
    Match match;

    public EventListAdapter(List<MatchResponse> events) {
        this.events = events;
    }

    @NonNull
    @Override
    public EventListHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.event_item, parent, false);
        return new EventListAdapter.EventListHolder(itemView, this);

    }

    @Override
    public void onBindViewHolder(@NonNull EventListHolder holder, int position) {
        MatchResponse matchResponse = events.get(position);
        holder.homeTeam.setText(matchResponse.getStrHomeTeam());
        holder.awayTeam.setText(matchResponse.getStrAwayTeam());
        holder.event.setText(matchResponse.getStrEvent());
        match = new Match(matchResponse.getIdEvent(),
                matchResponse.getStrEvent(),
                matchResponse.getStrLeague(),
                matchResponse.getStrSeason(),
                matchResponse.getDateEvent(),
                matchResponse.getStrTime(),
                Integer.parseInt(matchResponse.getIntHomeScore()),
                Integer.parseInt(matchResponse.getIntAwayScore()),
                matchResponse.getStrHomeGoalDetails(),
                matchResponse.getStrHomeYellowCards(),
                matchResponse.getStrAwayGoalDetails(),
                matchResponse.getStrAwayYellowCards());
    }

    @Override
    public int getItemCount() {
        return events.size();
    }

    public class EventListHolder extends RecyclerView.ViewHolder {
        EventListAdapter adapter;
        final TextView event;
        final TextView homeTeam;
        final TextView awayTeam;
        final Button detailsButton;

        public EventListHolder(@NonNull View itemView, EventListAdapter adapter) {
            super(itemView);
            this.adapter = adapter;
            event = itemView.findViewById(R.id.event);
            homeTeam = itemView.findViewById(R.id.homeTeam);
            awayTeam = itemView.findViewById(R.id.awayTeam);
            detailsButton = itemView.findViewById(R.id.detailsButton);
            detailsButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(itemView.getContext(), MatchDetailsActivity.class);
                    intent.putExtra("match", match);
                    itemView.getContext().startActivity(intent);
                }
            });
        }
    }
}
