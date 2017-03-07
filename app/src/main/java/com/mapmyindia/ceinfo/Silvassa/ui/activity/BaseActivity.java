package com.mapmyindia.ceinfo.silvassa.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

/**
 * Created by ceinfo on 27-02-2017.
 */

public abstract class BaseActivity extends AppCompatActivity {

    private Toolbar mToolbar;

    public Toolbar getToolbar() {
        return mToolbar;
    }

    public void setToolbar(Toolbar mToolbar) {
        this.mToolbar = mToolbar;
    }

    public abstract void setTitle(String mTitle);
}
