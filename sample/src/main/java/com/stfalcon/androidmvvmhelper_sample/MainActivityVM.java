package com.stfalcon.androidmvvmhelper_sample;

import com.stfalcon.androidmvvmhelper.mvvm.activities.ActivityViewModel;

/**
 * Created by Anton Bevza on 11/7/16.
 */
public class MainActivityVM extends ActivityViewModel<MainActivity> {
    public String text = "Text";

    public MainActivityVM(MainActivity activity) {
        super(activity);
    }
}