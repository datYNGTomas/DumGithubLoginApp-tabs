package edu.lclark.githubfragmentapplication.models;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class TabbedDetailAdapter extends FragmentStatePagerAdapter {

    private final Context mContext;

    public TabbedDetailAdapter(Context mContext, FragmentManager fm) {
        super(fm);
        this.mContext = mContext;
    }

    @Override
    public Fragment getItem(int position) {

        /*while(*//*some how make this work*//*){

            *//* Here we make an array of gitHub users to call with position*//*

        }*/

        return null;
    }

    @Override
    public int getCount() {
        return 0;
    }
}
