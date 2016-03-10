package edu.lclark.githubfragmentapplication.models;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;

import edu.lclark.githubfragmentapplication.fragments.TabbedDetailFragment;

public class TabbedDetailAdapter extends FragmentStatePagerAdapter {

    private ArrayList<GithubUser> mUsers;

    public TabbedDetailAdapter(ArrayList<GithubUser> users, FragmentManager fm) {
        super(fm);
        mUsers = users;
    }

    @Override
    public Fragment getItem(int position) {

        return TabbedDetailFragment.newInstance(mUsers, position);
    }

    @Override
    public int getCount() {
        return mUsers.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return super.getPageTitle(position);
    }
}
