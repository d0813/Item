package com.example.item.ui.notifications.adapter;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.item.base.BaseAdapter;

import java.util.ArrayList;

public class FagTAbAdapter extends FragmentPagerAdapter {
    private ArrayList<Fragment> fragments;
    private ArrayList<String> titlelist;

    public FagTAbAdapter(@NonNull FragmentManager fm, ArrayList<Fragment> fragments, ArrayList<String> titlelist) {
        super(fm);

        this.fragments = fragments;
        this.titlelist = titlelist;
    }


    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return titlelist.get(position);
    }
}

