package com.stfalcon.androidmvvmhelper.mvvm.fragments;

import android.app.Activity;
import android.content.Intent;
import android.databinding.BaseObservable;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.v4.app.Fragment;

/**
 * Created by troy379 on 16.01.16.
 */
public abstract class FragmentViewModel<F extends BindingFragment>
        extends BaseObservable {

    private F fragment;
    private Activity activity;

    public FragmentViewModel(F fragment) {
        this.fragment = fragment;
        this.activity = this.fragment.getActivity();
    }

    public F getFragment() {
        return fragment;
    }

    public Fragment getParentFragment() {
        return fragment.getParentFragment();
    }

    public Activity getActivity() {
        return activity;
    }

    /**
     * Fragment lifecycle
     */
    public void onViewCreated() {

    }

    public void onStart() {

    }

    public void onStop() {

    }

    public void onDestroy() {
        //realm.close();
    }

    public void onPause() {

    }

    public void onResume() {

    }

    public void onDestroyView() {
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
    }

    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {

    }

    public void onSaveInstanceState(Bundle outState) {
    }

    public void onViewStateRestored(Bundle savedInstanceState) {
    }


    /**
     * -----------------------
     */
}
