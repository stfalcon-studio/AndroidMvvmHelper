package com.stfalcon.androidmvvmhelper_sample;

import com.stfalcon.androidmvvmhelper.mvvm.activities.ActivityViewModel;
import com.stfalcon.androidmvvmhelper_sample.databinding.ActivityMainBinding;

/**
 * Created by Anton Bevza on 11/7/16.
 */
public class MainActivityVM extends ActivityViewModel<MainActivity, ActivityMainBinding> {
    public String text = "Text";

    public MainActivityVM(MainActivity activity, ActivityMainBinding binding) {
        super(activity, binding);
    }
}