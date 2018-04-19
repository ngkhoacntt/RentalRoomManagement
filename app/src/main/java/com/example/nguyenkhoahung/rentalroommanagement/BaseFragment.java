package com.example.nguyenkhoahung.rentalroommanagement;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.nguyenkhoahung.rentalroommanagement.viewbinder.ViewBinder;



public class BaseFragment extends Fragment {

    private boolean isUserSeen = false;
    private boolean isDisplayed = false;
    private boolean isViewCreated = false;
    private boolean isUsedInViewPager = false;

    private Configuration mConfig;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        onBeforeViewCreated();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        int layout = ViewBinder.getViewLayout(this);
        return inflater.inflate(layout, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ViewBinder.bind(view, this);
        onAfterViewCreated(view);
    }

    public String getName() {
        return null;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (isUsedInViewPager) {
            isViewCreated = true;
            if (isUserSeen && !isDisplayed) {
                isDisplayed = true;
                onUserFirstSight();
            }
        } else {
            onUserFirstSight();
        }
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        //if fragment is used in viewpager
        isUsedInViewPager = true;
        //first time to show
        if (getActivity() == null && isVisibleToUser) {
            isUserSeen = true;
        }

        if (getActivity() != null) {
            if (isVisibleToUser) {
                isUserSeen = true;
                if (isViewCreated && !isDisplayed) {
                    isDisplayed = true;
                    onUserFirstSight();
                    return;
                }

                if (isDisplayed) {
                    onUserVisibleChanged(true);
                }
            } else {
                isUserSeen = false;
                if (isDisplayed) {
                    onUserVisibleChanged(false);
                }
            }
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        if (!isUsedInViewPager) {
            onUserVisibleChanged(false);
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        if (!isUsedInViewPager) {
            onUserVisibleChanged(true);
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        isDisplayed = false;
        isViewCreated = false;
    }

    protected void onUserVisibleChanged(boolean isVisibleToUser) {

    }
    protected void onUserFirstSight() {

    }

    protected void onBeforeViewCreated() {}
    protected void onAfterViewCreated(View view){}
    //protected void onPostInit(){}

    public boolean isUserFirstSight() {
        return isUserSeen;
    }

    public void setConfiguration(Configuration config) {
        mConfig = config;
        mConfig.config();
    }

    public Configuration getConfiguration() {
        return mConfig;
    }
}
