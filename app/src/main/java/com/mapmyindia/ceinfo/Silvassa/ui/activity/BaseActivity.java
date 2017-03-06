package com.mapmyindia.ceinfo.silvassa.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.mapmyindia.ceinfo.silvassa.R;

/**
 * Created by ceinfo on 27-02-2017.
 */

public abstract class BaseActivity extends AppCompatActivity {


    private Toolbar mToolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setToolbar((Toolbar) findViewById(R.id.toolbar));
        setTitle(getResources().getString(R.string.app_name));
    }

    public void setToolbar(Toolbar toolbar) {
        this.mToolbar = toolbar;
    }

    public void setTitle(String title) {
        ((TextView) this.mToolbar.findViewById(R.id.tv_toolbar)).setText(title);
    }

}
