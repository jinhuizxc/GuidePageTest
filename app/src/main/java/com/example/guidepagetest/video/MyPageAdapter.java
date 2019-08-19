package com.example.guidepagetest.video;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * ViewPager适配器
 */
public class MyPageAdapter extends FragmentPagerAdapter {

    private List<Fragment> fragments;
    public MyPageAdapter(FragmentManager fm) {
        super(fm);
    }

    public MyPageAdapter(FragmentManager supportFragmentManager, List<Fragment> fragments) {
        super(supportFragmentManager);
        this.fragments = fragments;
    }

    @Override
    public Fragment getItem(int i) {
        return fragments.get(i);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }
}
