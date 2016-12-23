package com.stfalcon.androidmvvmhelper.mvvm.fragments;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by troy379 on 05.01.16.
 */
public abstract class BindingFragment<VM extends FragmentViewModel, B extends ViewDataBinding>
        extends Fragment {

    protected abstract VM onCreateViewModel(B binding);

    private B binding;
    private VM viewModel;

    private Bundle savedInstanceState;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, getLayoutId(), container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.savedInstanceState = savedInstanceState;
        viewModel = onCreateViewModel(binding);
        binding.setVariable(getVariable(), viewModel);
        binding.executePendingBindings();
        viewModel.onViewCreated();
    }

    public B getBinding() {
        return binding;
    }

    public VM getViewModel() {
        return viewModel;
    }

    public Bundle getSavedInstanceState() {
        return savedInstanceState;
    }

    public void resetViewModel() {
        viewModel = onCreateViewModel(binding);
        getBinding().setVariable(getVariable(), viewModel);
    }

    @Override
    public void onStart() {
        viewModel.onStart();
        super.onStart();
    }

    @Override
    public void onStop() {
        viewModel.onStop();
        super.onStop();
    }

    @Override
    public void onPause() {
        viewModel.onPause();
        super.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();
        viewModel.onResume();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (viewModel != null) {
            viewModel.onDestroy();
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if (viewModel != null) {
            viewModel.onSaveInstanceState(outState);
        }
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        if (viewModel != null) {
            viewModel.onViewStateRestored(savedInstanceState);
        }
    }

    @Override
    public void onDestroyView() {
        viewModel.onDestroyView();
        super.onDestroyView();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (viewModel == null) {
            viewModel = onCreateViewModel(binding);
        }
        viewModel.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        viewModel.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    /**
     * Override for set binding variable
     *
     * @return variable id
     */
    public abstract int getVariable();

    /**
     * Override for set layout resource
     *
     * @return layout resource id
     */
    public abstract int getLayoutId();
}
