package edu.lclark.githubfragmentapplication.models;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;

import edu.lclark.githubfragmentapplication.fragments.UserFragment;

public class TabbedDetailAdapter extends FragmentStatePagerAdapter {

    private ArrayList<GithubUser> mUsers;

    public TabbedDetailAdapter(ArrayList<GithubUser> users, FragmentManager fm) {
        super(fm);
        mUsers = users;
    }

    @Override
    public Fragment getItem(int position) {
        return UserFragment.newInstance(mUsers.get(position));
    }


    @Override
    public int getCount() {
        return mUsers == null ? 0 : mUsers.size();
    }

    public void setUsers(ArrayList<GithubUser> followers) {
        mUsers = followers;
        notifyDataSetChanged();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mUsers.get(position).getLogin();
    }
}
