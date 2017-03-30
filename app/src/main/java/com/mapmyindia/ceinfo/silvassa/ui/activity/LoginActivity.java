package com.mapmyindia.ceinfo.silvassa.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatEditText;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.mapmyindia.ceinfo.silvassa.R;
import com.mapmyindia.ceinfo.silvassa.restcontroller.RestApiClient;
import com.mapmyindia.ceinfo.silvassa.restcontroller.RestAppController;
import com.mapmyindia.ceinfo.silvassa.utils.DialogHandler;
import com.mapmyindia.ceinfo.silvassa.utils.SharedPrefeHelper;
import com.mapmyindia.ceinfo.silvassa.utils.StringUtils;
import com.orhanobut.logger.Logger;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by ceinfo on 27-02-2017.
 */

public class LoginActivity extends AppCompatActivity {

    private static final String TAG = LoginActivity.class.getSimpleName();

    private AppCompatEditText mEditTextUname, mEditTextPaswd;
    private AppCompatButton mButtonLogin;
    private ProgressBar progressBar;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.layout_activity_login);

        findViewByIDs();

    }

    private void findViewByIDs() {
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
//        View focusView = null;
        boolean isvalid = true;
        String username = mEditTextUname.getText().toString();
        String paswd = mEditTextPaswd.getText().toString();


        if (StringUtils.isNullOrEmpty(username)) {
            isvalid = false;
//            mEditTextUname.setError("Please provide a valid username");
//            focusView = mEditTextUname;
        }
        if (StringUtils.isNullOrEmpty(paswd)) {
            isvalid = false;
//            mEditTextPaswd.setError("Please provide a valid username/password");
//            focusView = mEditTextPaswd;
        }

        if (isvalid) {
            attemptLogin(username, paswd);
        } else {
//            focusView.requestFocus();
            new DialogHandler(LoginActivity.this).showAlertDialog("Please provide a valid username/password");
        }

//        mEditTextUname.setText("");
//        mEditTextPaswd.setText("");
    }

    private void attemptLogin(String username, String pwd) {

        showProgress(true);

        UserModel payload = new UserModel();
        payload.setUserId(SharedPrefeHelper.getUserId(this));
        payload.setDeviceId(SharedPrefeHelper.getDeviceId(this));
        payload.setUserName(username);
        payload.setPassword(pwd);

        String toJson = new Gson().toJson(payload, UserModel.class);

        RestApiClient client = RestAppController.getRetrofitinstance().create(RestApiClient.class);
        Call<ResponseBody> call = client.mobLogin(toJson);

        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

                showProgress(false);

                if (response.isSuccessful()) {


                    startActivity(new Intent(LoginActivity.this, SyncSearchActivity.class));
                    finish();

                } else {

                    return;
                }

            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                showProgress(false);
                Logger.e(TAG, " @getZone : FAILURE : " + call.request());
            }
        });
    }

    private void showProgress(boolean show) {
        if (null == progressBar) {
            progressBar = (ProgressBar) findViewById(R.id.progressBar);
        }
        if (show && progressBar.getVisibility() != View.VISIBLE) {
            progressBar.setVisibility(View.VISIBLE);
        } else {
            progressBar.setVisibility(View.GONE);
        }
    }

    public class UserModel {
        @SerializedName("deviceId")
        private String deviceId;
        @SerializedName("userId")
        private String userId;
        @SerializedName("userName")
        private String userName;
        @SerializedName("pass")
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

        public String getDeviceId() {
            return deviceId;
        }

        public void setDeviceId(String deviceId) {
            this.deviceId = deviceId;
        }

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }
    }
}
