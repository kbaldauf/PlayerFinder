package com.kbaldauf.playerfinder.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import timber.log.Timber;

public abstract class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentView());
        bindDependencies();
        setupToolbar();
        Timber.d("onCreate");
    }

    protected abstract int getContentView();
    // bind/inject view and object dependencies
    protected abstract void bindDependencies();
    protected abstract void setupToolbar();
}
