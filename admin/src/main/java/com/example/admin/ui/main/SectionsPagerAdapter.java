package com.example.admin.ui.main;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.admin.R;
import com.example.admin.T_fri;
import com.example.admin.T_mon;
import com.example.admin.T_sat;
import com.example.admin.T_thru;
import com.example.admin.T_tues;
import com.example.admin.T_wed;

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {

    @StringRes
    private static final int[] TAB_TITLES = new int[]{R.string.tab_text_1, R.string.tab_text_2,R.string.tab_text_3, R.string.tab_text_4,R.string.tab_text_5, R.string.tab_text_6};
    private final Context mContext;

    public SectionsPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        // getItem is called to instantiate the fragment for the given page.
        // Return a PlaceholderFragment (defined as a static inner class below).

        if (position==0)
        {
            return new T_mon();
        }

        if (position==1)
        {
            return new T_tues();
        }

        if (position==2)
        {
            return new T_wed();
        }

        if (position==3)
        {
            return new T_thru();
        }
        if (position==4)
        {
            return new T_fri();
        }

        if (position==5)
        {
            return new T_sat();
        }


        return PlaceholderFragment.newInstance(position + 1);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mContext.getResources().getString(TAB_TITLES[position]);
    }

    @Override
    public int getCount() {
        // Show 2 total pages.
        return 6;
    }
}