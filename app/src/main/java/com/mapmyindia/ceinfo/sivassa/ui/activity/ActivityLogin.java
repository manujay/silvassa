package com.mapmyindia.ceinfo.sivassa.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatEditText;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.TextView;

import com.mapmyindia.ceinfo.sivassa.R;
import com.mapmyindia.ceinfo.sivassa.utils.StringUtils;

/**
 * Created by ceinfo on 27-02-2017.
 */

public class ActivityLogin extends AppCompatActivity {

    private static final String TAG = ActivityLogin.class.getSimpleName();

    private AppCompatEditText mEditTextUname, mEditTextPaswd;
    private AppCompatButton mButtonLogin;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_activity_login);
        intitViews();
    }

    private void intitViews() {
        mEditTextUname = (AppCompatEditText) findViewById(R.id.et_login_username);
        mEditTextPaswd = (AppCompatEditText) findViewById(R.id.et_login_password);
        mButtonLogin = (AppCompatButton) findViewById(R.id.et_login_button);

        mEditTextPaswd.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    mButtonLogin.performClick();
                    return true;
                }
                return false;
            }
        });

        mButtonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doLogin();
            }
        });
    }

    private void doLogin() {
        View focusView = null;
        boolean isvalid = true;
        String username = mEditTextUname.getText().toString();
        String paswd = mEditTextPaswd.getText().toString();


        if (StringUtils.isNullOrEmpty(username)) {
            isvalid = false;
            mEditTextUname.setError("Please provide a valid username");
            focusView = mEditTextUname;
        }
        if (StringUtils.isNullOrEmpty(paswd)) {
            isvalid = false;
            mEditTextPaswd.setError("Please provide a valid username/password");
            focusView = mEditTextPaswd;
        }

        if (isvalid) {
            attemptLogin(username, paswd);
        } else {
            focusView.requestFocus();
        }

//        mEditTextUname.setText("");
//        mEditTextPaswd.setText("");
    }

    private void attemptLogin(String username, String pwd) {
        UserModel payload = new UserModel();
        payload.setUserName(username);
        payload.setPassword(pwd);

        startActivity(new Intent(this, ActivitySyncSearch.class));
        finish();
    }


    class UserModel {
        private String userName;
        private String password;

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }
}
