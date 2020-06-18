package com.codecool.scoreboard;


import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class FragmentCollectionAdapter extends FragmentStatePagerAdapter {

    public FragmentCollectionAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {

        position = position + 1;

        if (position == 1) {
            return EventsFragment.newInstance("last");
        } else {
            return EventsFragment.newInstance("next");
        }
    }

    @Override
    public int getCount() {
        return 2;
    }
}
