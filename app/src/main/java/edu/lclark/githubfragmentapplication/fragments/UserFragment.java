package edu.lclark.githubfragmentapplication.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import edu.lclark.githubfragmentapplication.R;
import edu.lclark.githubfragmentapplication.models.GithubUser;

public class UserFragment extends Fragment {

    public static final String ARG_USER = "UserFragment.User";
    private GithubUser mUser;
    private UserListener mUserListener;

    @Bind(R.id.fragment_user_imageview)
    ImageView mImageView;
    @Bind(R.id.fragment_user_name_textview)
    TextView mNameTextView;
    @Bind(R.id.fragment_user_user_button)
    Button mFollowerButton;


    public interface UserListener {
        void onUserFollowerButtonClicked(GithubUser user);

        void onTabButtonClick(GithubUser user);
    }


    public static UserFragment newInstance(GithubUser user) {
        UserFragment fragment = new UserFragment();
        Bundle args = new Bundle();
        args.putParcelable(ARG_USER, user);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_user, container, false);

        ButterKnife.bind(this, rootView);

        mUser = getArguments().getParcelable(ARG_USER);
        assert mUser != null;
        getActivity().setTitle(mUser.getLogin());

        Picasso.with(getContext()).load(mUser.getAvatar_url()).fit().centerInside().into(mImageView);

        mNameTextView.setText(mUser.getLogin());

        mUserListener = (UserListener) getActivity();

        return rootView;
    }

    @OnClick(R.id.fragment_user_user_button)
    public void onFollowerButtonClick() {
        mUserListener.onUserFollowerButtonClicked(mUser);

    }

    @OnClick(R.id.fragment_user_tab_button)
    public void onTabButtonClick() {
        mUserListener.onTabButtonClick(mUser);
        mFollowerButton.setVisibility(View.GONE);
    }
}
