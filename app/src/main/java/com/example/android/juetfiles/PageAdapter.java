package com.example.android.juetfiles;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class PageAdapter extends FragmentPagerAdapter {
    private int numOfTabs;

    PageAdapter(FragmentManager fm, int numOfTabs){
        super(fm);
        this.numOfTabs = numOfTabs;

    }
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new RoomMaintenanceFragment();
            case 1:
                return new LaundryFragment();
            case 2:
                return new LendAndBorrowFragment();
            case 3:
                return new NoticeBoardFragment();
            case 4:
                return new GeneralReportFragment();
            default:
                return  null;

        }
    }

    @Override
    public int getCount() {
        return numOfTabs;
    }
}
