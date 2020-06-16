package com.codecool.scoreboard;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class EventFragmentCollectionAdapter extends FragmentStatePagerAdapter {

    public EventFragmentCollectionAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {

        EventsFragment lastEventsFragment = new EventsFragment();
        Bundle bundle = new Bundle();
        position = position + 1;
        lastEventsFragment.setArguments(bundle);
        return lastEventsFragment;
    }

    @Override
    public int getCount() {
        return 2;
    }
}
