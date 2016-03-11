package edu.lclark.githubfragmentapplication.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;

import edu.lclark.githubfragmentapplication.NetworkAsyncTask;
import edu.lclark.githubfragmentapplication.R;
import edu.lclark.githubfragmentapplication.fragments.UserFragment;
import edu.lclark.githubfragmentapplication.models.GithubUser;
import edu.lclark.githubfragmentapplication.models.TabbedDetailAdapter;

public class TabbedDetailActivity extends AppCompatActivity implements NetworkAsyncTask.GithubListener, UserFragment.UserListener {

    private ArrayList<GithubUser> mFollowers;
    private TabbedDetailAdapter adapter;
    private NetworkAsyncTask mAsyncTask;
    private String mUserLogin;
    private TabLayout tabLayout;
    private ViewPager viewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabbed_detail);

        viewPager = (ViewPager) findViewById(R.id.tabbed_detail_viewPager);

        adapter = new TabbedDetailAdapter(mFollowers, getSupportFragmentManager());
        viewPager.setAdapter(adapter);

        tabLayout = (TabLayout) findViewById(R.id.tabbed_detail_tabLayout);

        tabLayout.setupWithViewPager(viewPager);

        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);

        GithubUser user = getIntent().getParcelableExtra(UserFragment.ARG_USER);
        mUserLogin = user.getLogin();

        Toolbar toolbar = (Toolbar) findViewById(R.id.tabbed_detail_toolbar);
        setSupportActionBar(toolbar);

    }

    @Override
    public void onStart() {
        super.onStart();

        if (mAsyncTask == null && (mFollowers == null || mFollowers.isEmpty())) {
            mAsyncTask = new NetworkAsyncTask(this);
            mAsyncTask.execute(mUserLogin);
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        if (mAsyncTask != null && !mAsyncTask.isCancelled()) {
            mAsyncTask.cancel(true);
            mAsyncTask = null;
        }
    }

    @Override
    public void onGithubFollowersRetrieved(@Nullable ArrayList<GithubUser> followers) {
        mFollowers = followers;
        adapter.setUsers(mFollowers);
        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    public void onUserFollowerButtonClicked(GithubUser user) {

    }

    @Override
    public void onTabButtonClick(GithubUser user) {

    }
}
