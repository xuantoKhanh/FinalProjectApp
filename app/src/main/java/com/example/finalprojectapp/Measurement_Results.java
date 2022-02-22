package com.example.finalprojectapp;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class Measurement_Results extends AppCompatActivity {

    private ViewPager2 mViewPager2;
    private BottomNavigationView mBottomNavigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_measurement_results);

        mViewPager2 = findViewById(R.id.viewpager2);
        mBottomNavigationView = findViewById(R.id.bottomNavigationView);


        MyViewPagerAdapter myViewPagerAdapter = new MyViewPagerAdapter(this);
        mViewPager2.setAdapter(myViewPagerAdapter);

        mBottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                if(id == R.id.result){
                    mViewPager2.setCurrentItem(0);
                }else if(id == R.id.history){
                    mViewPager2.setCurrentItem(1);
                }else if(id == R.id.setting){
                    mViewPager2.setCurrentItem(2);
                }

                return true;
            }
        });

        mViewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                switch (position){
                    case 0:
                        mBottomNavigationView.getMenu().findItem(R.id.result).setChecked(true);
                        break;
                    case 1:
                        mBottomNavigationView.getMenu().findItem(R.id.history).setChecked(true);
                        break;
                    case 2:
                        mBottomNavigationView.getMenu().findItem(R.id.setting).setChecked(true);
                        break;
                }
            }
        });

    }
}