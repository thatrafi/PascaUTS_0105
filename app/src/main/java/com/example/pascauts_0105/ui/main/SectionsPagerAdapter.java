package com.example.pascauts_0105.ui.main;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.pascauts_0105.R;

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {

    @StringRes
    private static final int[] TAB_TITLES = new int[]{R.string.tab_movie, R.string.tab_tvseries};
    private final Context mContext;
    private String Lang;
    private String keyword;

    public SectionsPagerAdapter(Context context,  FragmentManager fm,String Lang,String key) {
        super(fm);
        mContext = context;
        this.Lang = Lang;
        this.keyword = key;
    }

    @Override
    public Fragment getItem(int position) {
        // getItem is called to instantiate the fragment for the given page.
        // Return a PlaceholderFavFragment (defined as a static inner class below).
        return PlaceholderFragment.newInstance(position,this.Lang,this.keyword );
    }



    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mContext.getResources().getString(TAB_TITLES[position]);
    }

    @Override
    public int getCount() {
        // Show 2 total pages.
        return 2;
    }
}