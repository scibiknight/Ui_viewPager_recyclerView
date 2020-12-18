package com.example.demo3;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;


public class PagerAdaptor extends FragmentPagerAdapter {
    private int tabsNumber;

    public PagerAdaptor(@NonNull FragmentManager fm, int behavior,int tabs) {
        super(fm, behavior);
        this.tabsNumber=tabs;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
    switch (position) {
        case 0:
            return new all_news();
        case 1:
            return new local_news();
        case 2:
            return new district_news();
        case 3:
            return new kerala_news();

        default:return null;
    }    }

    @Override
    public int getCount() {
        return tabsNumber;
    }
}
