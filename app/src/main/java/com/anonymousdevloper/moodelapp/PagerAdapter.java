package com.anonymousdevloper.moodelapp;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import androidx.viewpager2.adapter.FragmentStateAdapter;

public class PagerAdapter extends FragmentStateAdapter {


    public PagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
       switch (position){
           case 0:
               return new HomeFragment();

           default:
               return new DashboardFragment();

       }
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
