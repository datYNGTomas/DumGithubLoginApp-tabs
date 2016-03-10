package edu.lclark.githubfragmentapplication.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import edu.lclark.githubfragmentapplication.models.GithubUser;

public class TabbedDetailFragment extends Fragment {

    public static final String ARG_INDEX = "Index";
    public static final String ARG_USER = "User";

    public static TabbedDetailFragment newInstance(ArrayList<GithubUser> user, int index) {
        TabbedDetailFragment fragment = new TabbedDetailFragment();
        Bundle args = new Bundle();
        args.putParcelableArrayList(ARG_USER, user);
        args.putInt(ARG_INDEX, index);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = super.onCreateView(inflater, container, savedInstanceState);

        Bundle args = getArguments();

        int index = args.getInt(ARG_INDEX);
        ArrayList<GithubUser> user = args.getParcelable(ARG_USER);


        Log.d("TabbedDetailFragment", "Created fragment at index " + index);

        return rootView;
    }
}