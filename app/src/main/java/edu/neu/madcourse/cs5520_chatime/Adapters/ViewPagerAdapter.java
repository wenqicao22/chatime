package edu.neu.madcourse.cs5520_chatime.Adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class ViewPagerAdapter extends FragmentPagerAdapter {
    private ArrayList<String> mNames;
    private ArrayList<Fragment> mFragments;

    public ViewPagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
        mNames = new ArrayList<>();
        mFragments = new ArrayList<>();
    }

    public ViewPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    //insert a fragment into the list
    public void addFrag(Fragment f, String name) {
        mFragments.add(f);
        mNames.add(name);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }

    //comment if want to remove the text of the tab
    @Override
    public String getPageTitle(int position) {
        return mNames.get(position);
    }
}
