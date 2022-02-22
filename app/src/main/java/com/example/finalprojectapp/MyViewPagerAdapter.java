package com.example.finalprojectapp;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.finalprojectapp.fragment.HistoryFragment;
import com.example.finalprojectapp.fragment.ResultFragment;
import com.example.finalprojectapp.fragment.SettingFragment;

public class MyViewPagerAdapter extends FragmentStateAdapter {
    public MyViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
                return new ResultFragment();
            case 1:
                return new HistoryFragment();
            case 2:
                return new SettingFragment();
            default:
                return new ResultFragment();

        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
