package com.stfalcon.androidmvvmhelper.mvvm.activities;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.databinding.BaseObservable;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

/**
 * Created by alex on 19.01.16.
 */
public abstract class ActivityViewModel<A extends AppCompatActivity, B extends ViewDataBinding>
        extends BaseObservable {

    protected A activity;
    protected B binding;

    public ActivityViewModel(A activity, B binding) {
        this.activity = activity;
        this.binding = binding;
    }

    public A getActivity() {
        return activity;
    }

    public B getBinding() {
        return binding;
    }

    public void finish() {
        activity.finish();
    }

    /**
     * Activity lifecycle
     */
    public boolean onBackKeyPress() {
        return false;
    }

    public void onStart() {

    }

    public void onStop() {

    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {

    }

    public void onDestroy() {
        //realm.close();
    }

    public void onPause() {

    }

    public void onResume() {

    }

    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {

    }

    public void onPostCreate(Bundle savedInstanceState) {

    }

    public void onOptionsItemSelected(MenuItem item) {

    }

    public void onConfigurationChanged(Configuration newConfig) {

    }

    public void onRestoreInstanceState(Bundle savedInstanceState) {

    }

    public void onSaveInstanceState(Bundle outState){

    }

    public void onCreateOptionsMenu(Menu menu) {

    }

    public void onPrepareOptionsMenu(Menu menu){

    }

    public void onWindowFocusChanged(boolean hasFocus){

    }

    public Context attachBaseContext(Context newBase){
        return newBase;
    }


    /**
     * -----------------------
     */
}