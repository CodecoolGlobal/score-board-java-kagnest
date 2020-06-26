package com.codecool.scoreboard.mainpage;

import android.os.Bundle;

import com.codecool.scoreboard.R;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import butterknife.BindView;
import butterknife.ButterKnife;

public class EventsActivity extends AppCompatActivity {

    @BindView(R.id.viewPager)
    ViewPager viewPager;

    private FragmentCollectionAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        adapter = new FragmentCollectionAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
    }
}