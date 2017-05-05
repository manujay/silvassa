package com.mapmyindia.ceinfo.silvassa.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.v7.widget.AppCompatButton;
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
import com.mapmyindia.ceinfo.silvassa.utils.Connectivity;
import com.mapmyindia.ceinfo.silvassa.utils.PostExecutionThread;
import com.mapmyindia.ceinfo.silvassa.utils.SharedPrefeHelper;
import com.mapmyindia.ceinfo.silvassa.utils.StringUtils;
import com.mapmyindia.ceinfo.silvassa.utils.UIThread;
import com.mapmyindia.ceinfo.silvassa.utils.ViewUtils;
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

public class LoginActivity extends BaseActivity {

    private static final String TAG = LoginActivity.class.getSimpleName();

    private TextInputEditText mEditTextUname, mEditTextPaswd;
    private AppCompatButton mButtonLogin;
    private ProgressBar progressBar;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        boolean isLogin = SharedPrefeHelper.isLogin(this);

        if (isLogin) {
            PostExecutionThread handlerThread = UIThread.getInstance();
            handlerThread.post(new Runnable() {
                @Override
                public void run() {
                    startActivityForIntent(new Intent(LoginActivity.this, SyncSearchActivity.class));
                    finish();
                }
            });
        } else {
            setContentView(R.layout.layout_activity_login);
            findViewByIDs();
        }
    }

    @Override
    public void setmTitle(String mTitle) {

    }

    private void findViewByIDs() {
        mEditTextUname = (TextInputEditText) findViewById(R.id.et_login_username);
        mEditTextPaswd = (TextInputEditText) findViewById(R.id.et_login_password);
        mButtonLogin = (AppCompatButton) findViewById(R.id.et_login_button);

        mEditTextPaswd.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
//                    mButtonLogin.performClick();
                    ViewUtils.hideKeyboardFrom(LoginActivity.this, mEditTextPaswd.getRootView());
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

        /* Set values from existing login*/

        if (!StringUtils.isNullOrEmpty(SharedPrefeHelper.getUserInfo(this))) {

            String fromJson = SharedPrefeHelper.getUserInfo(this);

            UserWSModel userWSModel = new Gson().fromJson(fromJson, new TypeToken<UserWSModel>() {
            }.getType());

            String userId = userWSModel.getUserId();
//            String paswd = userWSModel.getPasword();

            mEditTextUname.setText(userId);
//            mEditTextPaswd.setText(paswd);

        }
    }

    private void doLogin() {
        View focusView = null;
        boolean isvalid = true;
        String userId = mEditTextUname.getText().toString();
        String paswd = mEditTextPaswd.getText().toString();

        if (StringUtils.isNullOrEmpty(userId)) {
            isvalid = false;
            mEditTextUname.setError("Username Can't be Empty");
            focusView = mEditTextUname;
        }

        if (StringUtils.isNullOrEmpty(paswd)) {
            isvalid = false;
            mEditTextPaswd.setError("Username/Password Can't be Empty");
            focusView = mEditTextPaswd;
        }

        if (isvalid) {

//            String fromJson = SharedPrefeHelper.getUserInfo(LoginActivity.this);

//            if (!StringUtils.isNullOrEmpty(fromJson)) {  //offline Login
//
//                UserWSModel userWSModel = new Gson().fromJson(fromJson, new TypeToken<UserWSModel>() {
//                }.getType());
//
//                if (userId.equalsIgnoreCase(userWSModel.getUserId()) && paswd.equalsIgnoreCase(userWSModel.getPasword())) {
//
//                    mEditTextUname.setFocusable(false);
//                    mEditTextPaswd.setFocusable(false);
//
//                    startActivityForIntent(new Intent(LoginActivity.this, SyncSearchActivity.class));
//                    finish();
//
//                } else {
//                    if (!Connectivity.isConnected(LoginActivity.this)) {  //online login
//                        showSnackBar(getWindow().getDecorView(), getString(R.string.error_network));
//                    } else {
//                        attemptLogin(userId, paswd);
//                    }
//                }

//            } else {
            if (!Connectivity.isConnected(LoginActivity.this)) {  //online login
                showSnackBar(getWindow().getDecorView(), getString(R.string.error_network));
            } else {
                attemptLogin(userId, paswd);
            }
//            }


        } else {
            focusView.requestFocus();
//            showToast(LoginActivity.this, "Incorrect Username/Password");
        }

//        mEditTextUname.setText("");
//        mEditTextPaswd.setText("");
    }

    private void attemptLogin(String userId, String pwd) {

        showProgress(true);

        UserModel payload = new UserModel();
        payload.setUserId(userId);
        payload.setPassword(pwd);
        payload.setUserName(SharedPrefeHelper.getUserName(this));
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

                        String message = jsonObject.getString("message");
                        int Status = Integer.parseInt(jsonObject.getString("status"));

                        if (!StringUtils.isNullOrEmpty(message) && Status == 1001) {
                            showToast(LoginActivity.this, "Incorrect Username/Password");
                            return;
                        }

                        if (!StringUtils.isNullOrEmpty(message) && Status != 200) {
                            showSnackBar(getWindow().getDecorView(), message);
                            return;
                        }

                        UserWSModel data = new Gson().fromJson(jsonObject.getString("data"), new TypeToken<UserWSModel>() {
                        }.getType());

                        SharedPrefeHelper.setUserId(LoginActivity.this, data.getUserId());

                        SharedPrefeHelper.setUserName(LoginActivity.this, data.getUsername());

                        SharedPrefeHelper.setUserInfo(LoginActivity.this, new Gson().toJson(data, UserWSModel.class));

                        SharedPrefeHelper.setIsLogin(LoginActivity.this, true);

                        Logger.json(new Gson().toJson(data, UserWSModel.class));

                        startActivityForIntent(new Intent(LoginActivity.this, SyncSearchActivity.class));

                        finish();
                    } catch (Exception e) {
                        Logger.e(TAG, " @attemptLogin : FAILURE : REQUEST " + call.request() + " ERROR: " + e.getLocalizedMessage());
                        e.printStackTrace();
                    }

                } else {
                    showSnackBar(getWindow().getDecorView(), getString(R.string.error_server));
                    return;
                }

            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                showProgress(false);
                showSnackBar(getWindow().getDecorView(), getString(R.string.error_server));
                Logger.e(TAG, " @attemptLogin : FAILURE : REQUEST " + call.request() + " ERROR: " + t.getLocalizedMessage());
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
