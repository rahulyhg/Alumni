package com.example.ashish.alumini.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.ashish.alumini.activities.PostLogin.PostLoginActivity;
import com.example.ashish.alumini.R;
import com.example.ashish.alumini.fragments.settings.FragmentSettings;
import com.mikepenz.iconics.view.IconicsImageView;
import com.squareup.otto.Bus;

import butterknife.Bind;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link FragmentMenu.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link FragmentMenu#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentMenu extends Fragment {

    /*
    * GLOBAL DECLARATIONS & BUTTERKNIFE INJECTIONS
    *
    * */
    @Bind(R.id.linearLayout_home) LinearLayout mLinearLayoutHome;
    @Bind(R.id.linearLayout_filter) LinearLayout mLinearLayoutFilter;
    @Bind(R.id.linearLayout_jobs) LinearLayout mLinearLayoutJobs;
    @Bind(R.id.linearLayout_settings) LinearLayout mLinearLayoutSettings;

    @Bind(R.id.button_home) IconicsImageView mImageViewMembers;
    @Bind(R.id.button_filter) IconicsImageView mImageViewFilter;
    @Bind(R.id.button_jobs) IconicsImageView mImageViewJobs;
    @Bind(R.id.button_settings) IconicsImageView mImageViewSettings;

    View mLineViewPrevious;
    LinearLayout mLinearLayoutPrevious;
    IconicsImageView mPreviousIconicsImageView;
    View mViewCurrent;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    Bus mBus = new Bus();

    PostLoginActivity mActivity;

    ActionBar mActionBar;




    public FragmentMenu() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentMenu.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentMenu newInstance(String param1, String param2) {
        FragmentMenu fragment = new FragmentMenu();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_menu_bottom, container, false);
        //Butterknife Binding
        ButterKnife.bind(this,view);
        //event bus registering
        mBus.register(getActivity());

        mActivity = (PostLoginActivity) getActivity();
        mActionBar = mActivity.getSupportActionBar();

        mLineViewPrevious = view.findViewById(R.id.view_home);
        mLinearLayoutPrevious = (LinearLayout) view.findViewById(R.id.linearLayout_home);
        mPreviousIconicsImageView = (IconicsImageView) view.findViewById(R.id.button_home) ;


        return view;
    }

    @OnClick(R.id.linearLayout_home)
    public void changeToHomeFragment(){
        setVisibleView(getView().findViewById(R.id.view_home),mImageViewMembers);
        mActivity.changeFragment(new FragmentMembers().newInstance(null,null));
        mActionBar.setTitle("Members");
    }
    @OnClick(R.id.linearLayout_filter)
    public void changeToFilterFragment(){

        setVisibleView(getView().findViewById(R.id.view_filter),mImageViewFilter);
        mActivity.changeFragment(new FragmentFilter().newInstance(null,null));
        mActionBar.setTitle("Filter");
    }
    @OnClick(R.id.linearLayout_jobs)
    public void changeToJobsFragment(){
        setVisibleView(getView().findViewById(R.id.view_jobs),mImageViewJobs);
        mActivity.changeFragment(new FragmentJobs().newInstance(null,null));
        mActionBar.setTitle("Jobs");
    }
    @OnClick(R.id.linearLayout_settings)
    public void changeFragment(){
//        setVisibleView(getView().findViewById(R.id.view_settings),mLinearLayoutSettings);
        setVisibleView(getView().findViewById(R.id.view_settings),mImageViewSettings);
        mActivity.changeFragment(new FragmentSettings().newInstance(null,null));
        mActionBar.setTitle("Settings");
    }



    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onDetach() {
        super.onDetach();

    }



//    public void setVisibleView(View viewUnderLine,LinearLayout layout){
    public void setVisibleView(View viewUnderLine,IconicsImageView imageView){
        //setting the previously clicked view to visibility=gone
        mLineViewPrevious.setVisibility(View.GONE);

        //setting the previously clicked Button to default
        mPreviousIconicsImageView.setColor(getResources().getColor(R.color.black_de));

        //changing color and visibility
        imageView.setColor(getResources().getColor(R.color.appTheme));
        viewUnderLine.setVisibility(View.VISIBLE);

        //updating the previous elements for changing the visibility in next click
        mLineViewPrevious =viewUnderLine;
        mPreviousIconicsImageView = imageView;

        mBus.post(imageView.getId()); // Posting the clicked layout to the BlankFragment activity (PostLoginActivity)
    }
}