package com.stfalcon.androidmvvmhelper.mvvm.activities;

import android.content.Intent;
import android.content.res.Configuration;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;


/**
 * Created by troy379 on 21.01.16.
 */
public abstract class BindingActivity<B extends ViewDataBinding, VM extends ActivityViewModel>
        extends AppCompatActivity {

    private B binding;
    private VM viewModel;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bind();
    }

    public void bind() {
        binding = DataBindingUtil.setContentView(this, getLayoutResources());
        this.viewModel = viewModel == null ? onCreate() : viewModel;
        binding.setVariable(getVariable(), viewModel);
        binding.executePendingBindings();
    }

    public void resetViewModel() {
        viewModel = null;
        viewModel = onCreate();
        getBinding().setVariable(getVariable(), viewModel);
    }

    public B getBinding() {
        return binding;
    }

    @Override
    protected void onStart() {
        super.onStart();
        viewModel.onStart();
    }

    @Override
    protected void onStop() {
        viewModel.onStop();
        super.onStop();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        viewModel.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    protected void onPause() {
        viewModel.onPause();
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        viewModel.onResume();
    }

    @Override
    public void onBackPressed() {
        if (!viewModel.onBackKeyPress()) {
            super.onBackPressed();
        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        viewModel.onDestroy();
    }

    @Override
    public void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        viewModel.onPostCreate(savedInstanceState);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        viewModel.onOptionsItemSelected(item);
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        viewModel.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        viewModel.onConfigurationChanged(newConfig);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        viewModel.onRestoreInstanceState(savedInstanceState);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        viewModel.onSaveInstanceState(outState);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        viewModel.onCreateOptionsMenu(menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        viewModel.onPrepareOptionsMenu(menu);
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        viewModel.onWindowFocusChanged(hasFocus);
    }

    public abstract VM onCreate();

    public VM getViewModel() {
        return viewModel;
    }

    /**
     * Override for set binding variable
     *
     * @return variable id
     */
    public abstract
    @IdRes
    int getVariable();

    /**
     * Override for set layout resource
     *
     * @return layout resource id
     */
    public abstract
    @LayoutRes
    int getLayoutResources();
}
