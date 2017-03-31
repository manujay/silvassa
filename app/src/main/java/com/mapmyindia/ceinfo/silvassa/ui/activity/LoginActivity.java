package com.mapmyindia.ceinfo.silvassa.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
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
import com.google.gson.reflect.TypeToken;
import com.mapmyindia.ceinfo.silvassa.R;
import com.mapmyindia.ceinfo.silvassa.restcontroller.RestApiClient;
import com.mapmyindia.ceinfo.silvassa.restcontroller.RestAppController;
import com.mapmyindia.ceinfo.silvassa.utils.DialogHandler;
import com.mapmyindia.ceinfo.silvassa.utils.SharedPrefeHelper;
import com.mapmyindia.ceinfo.silvassa.utils.StringUtils;
import com.mapmyindia.ceinfo.silvassa.wsmodel.UserWSModel;
import com.orhanobut.logger.Logger;

import org.json.JSONObject;

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
        String userId = mEditTextUname.getText().toString();
        String paswd = mEditTextPaswd.getText().toString();


        if (StringUtils.isNullOrEmpty(userId)) {
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
            attemptLogin(userId, paswd);
        } else {
//            focusView.requestFocus();
            new DialogHandler(LoginActivity.this).showAlertDialog("Please provide a valid username/password");
        }

//        mEditTextUname.setText("");
//        mEditTextPaswd.setText("");
    }

    private void attemptLogin(String userId, String pwd) {

        showProgress(true);

        UserModel payload = new UserModel();
        payload.setUserId(userId);
        payload.setPassword(pwd);
        payload.setUserName("");
        payload.setDeviceId(SharedPrefeHelper.getDeviceId(this));

        String toJson = new Gson().toJson(payload, UserModel.class);

        RestApiClient client = RestAppController.getRetrofitinstance().create(RestApiClient.class);
        Call<ResponseBody> call = client.mobLogin(toJson);

        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

                showProgress(false);

                if (response.isSuccessful()) {

                    try {
                        JSONObject jsonObject = new JSONObject(response.body().string());

                        if (!jsonObject.getString("message").equalsIgnoreCase("Success")) {
                            Snackbar.make(getWindow().getDecorView(), jsonObject.getString("message"), Snackbar.LENGTH_SHORT).show();
                            return;
                        }

                        if (Integer.parseInt(jsonObject.getString("status")) != 200) {
                            Snackbar.make(getWindow().getDecorView(), jsonObject.getString("message"), Snackbar.LENGTH_SHORT).show();
                            return;
                        }

                        if (null == jsonObject.get("data")) {
                            Snackbar.make(getWindow().getDecorView(), jsonObject.getString("message"), Snackbar.LENGTH_SHORT).show();
                            return;
                        }

                        UserWSModel data = new Gson().fromJson(jsonObject.getString("data"), new TypeToken<UserWSModel>() {
                        }.getType());

                        SharedPrefeHelper.setUserId(LoginActivity.this, data.getUserId());

                        SharedPrefeHelper.setUserInfo(LoginActivity.this, new Gson().toJson(data, UserWSModel.class));

                        Logger.json(new Gson().toJson(data, UserWSModel.class));

                        startActivity(new Intent(LoginActivity.this, SyncSearchActivity.class));

                        finish();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

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
