package com.codecool.scoreboard;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.codecool.scoreboard.model.MatchResponse;

import java.util.List;

public class EventListAdapter extends RecyclerView.Adapter<EventListAdapter.EventListHolder> {

    List<MatchResponse> events;
    String matchId;

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
        matchId = matchResponse.getIdEvent();
    }

    @Override
    public int getItemCount() {
        return events.size();
    }

    public class EventListHolder extends RecyclerView.ViewHolder {
        final TextView event;
        final TextView homeTeam;
        final TextView awayTeam;
        final Button detailsButton;

        public EventListHolder(@NonNull View itemView, EventListAdapter adapter) {
            super(itemView);
            event = itemView.findViewById(R.id.event);
            homeTeam = itemView.findViewById(R.id.homeTeam);
            awayTeam = itemView.findViewById(R.id.awayTeam);
            detailsButton = itemView.findViewById(R.id.detailsButton);
            detailsButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(itemView.getContext(), MatchDetailsActivity.class);
                    intent.putExtra("matchId", matchId);
                    itemView.getContext().startActivity(intent);
                }
            });
        }
    }
}
