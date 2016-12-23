package com.stfalcon.androidmvvmhelper_sample;

import com.stfalcon.androidmvvmhelper_sample.R;
import com.stfalcon.androidmvvmhelper_sample.BR;
import com.stfalcon.androidmvvmhelper.mvvm.activities.BindingActivity;
import com.stfalcon.androidmvvmhelper_sample.databinding.ActivityMainBinding;


/**
 * Created by Anton Bevza on 11/7/16.
 */
public class MainActivity extends BindingActivity<ActivityMainBinding, MainActivityVM> {

    @Override
    public MainActivityVM onCreate() {
        return new MainActivityVM(this);
    }

    @Override
    public int getVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

}