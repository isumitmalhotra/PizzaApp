package com.sumit.pizzaapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TabLayout tabLayout = findViewById(R.id.tab_layout);
        ViewPager viewPager= findViewById(R.id.view_pager);

        tabLayout.setupWithViewPager(viewPager);

        BestSeller bestSeller = new BestSeller();
        PastaPizza pastaPizza = new PastaPizza();
        VegPizza vegPizza = new VegPizza();
        NonVegPizza nonVegPizza = new NonVegPizza();

        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(),0);
        viewPagerAdapter.addFragment(bestSeller,"Best Sellers");
        viewPagerAdapter.addFragment(pastaPizza,"Pasta Pizza");
        viewPagerAdapter.addFragment(vegPizza,"Veg Pizza");
        viewPagerAdapter.addFragment(nonVegPizza,"Non-Veg Pizza");
        viewPager.setAdapter(viewPagerAdapter);

        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);

    }
}

    class ViewPagerAdapter extends FragmentPagerAdapter{

    private List<Fragment> fragmentList = new ArrayList<>();
    private List<String> fragmentTitles = new ArrayList<>();

    public ViewPagerAdapter(FragmentManager fm , int behaviour){
            super(fm,behaviour);
    }

    void addFragment(Fragment fragment,String titles){
        fragmentList.add(fragment);
        fragmentTitles.add(titles);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return fragmentTitles.get(position);
    }
}