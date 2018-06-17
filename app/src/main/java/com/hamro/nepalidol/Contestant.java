package com.hamro.nepalidol;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

public class Contestant extends AppCompatActivity {

    Toolbar toolbar;
    TabLayout tabLayout;
    ViewPager viewPager;
    ViewPagerAdapter viewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contestant);
        toolbar= (Toolbar)findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);
        tabLayout=(TabLayout)findViewById(R.id.tabLayout);
        viewPager=(ViewPager )findViewById(R.id.viewPager);
        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPagerAdapter.addFragments(new FirstContestant(),"Buddha " );
        viewPagerAdapter.addFragments(new SecondContestant(),"Nishan " );
        viewPagerAdapter.addFragments(new FirstContestant(),"Sagar " );
        viewPagerAdapter.addFragments(new SecondContestant(),"Jyoti " );
        viewPagerAdapter.addFragments(new FirstContestant(),"Anjali " );
        viewPagerAdapter.addFragments(new SecondContestant(),"Santosh " );
        viewPagerAdapter.addFragments(new FirstContestant(),"Sotftee " );
        viewPagerAdapter.addFragments(new SecondContestant(),"Suraz " );
        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }
}
