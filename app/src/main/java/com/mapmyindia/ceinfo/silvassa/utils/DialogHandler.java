package com.mapmyindia.ceinfo.silvassa.utils;

import android.app.Dialog;
import android.content.Context;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.mapmyindia.ceinfo.silvassa.R;

/**
 * Created by Mohammad Akram 30-12-2014.
 * <p>
 * Application specific dialogs helper class
 */

public class DialogHandler {

    //    private Dialog mTwoButtonDialog;
    private Dialog mSingleButtonDialog;

    private Context mContext;

    public DialogHandler(Context mContext) {
        // TODO Auto-generated constructor stub
        this.mContext = mContext;
//        mTwoButtonDialog = new Dialog(mContext, R.style.TopBottomDialog);
//        mTwoButtonDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
//        mTwoButtonDialog.setContentView(R.layout.dialog_two_buttons);
//        mTwoButtonDialog.getWindow().setBackgroundDrawableResource(R.color.transparent);

        mSingleButtonDialog = new Dialog(mContext, R.style.TopBottomDialog);
        mSingleButtonDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        mSingleButtonDialog.setContentView(R.layout.dialog_single_button);
        mSingleButtonDialog.getWindow().setBackgroundDrawableResource(R.color.transparent);

        setDialogWidth();
    }

    public void showAlertDialog(String message) {
        if (null != mSingleButtonDialog && !mSingleButtonDialog.isShowing()) {
            TextView tvMessage = (TextView) mSingleButtonDialog.findViewById(R.id.content_message);
            tvMessage.setText(message);
            mSingleButtonDialog.setCancelable(true);
            mSingleButtonDialog.show();
        }
    }

    /**
     *
     */
//    public void showLogoutDialog(final DialogLogoutListener dialogLogoutListener) {
//        if (mTwoButtonDialog != null && !mTwoButtonDialog.isShowing()) {
//            TextView message = (TextView) mTwoButtonDialog.findViewById(R.id.content_message);
//            TextView positiveButton = (TextView) mTwoButtonDialog.findViewById(R.id.positive_button);
//            TextView negativeButton = (TextView) mTwoButtonDialog.findViewById(R.id.ok_button);
//
//            positiveButton.setOnClickListener(new View.OnClickListener() {
//
//                @Override
//                public void onClick(View v) {
//                    if (dialogLogoutListener != null)
//                        dialogLogoutListener.onLogoutClicked();
//
//                    if (mTwoButtonDialog != null && mTwoButtonDialog.isShowing())
//                        mTwoButtonDialog.dismiss();
//                }
//            });
//
//            // on pressing cancel button
//            negativeButton.setOnClickListener(new View.OnClickListener() {
//
//                @Override
//                public void onClick(View v) {
//                    if (mTwoButtonDialog != null && mTwoButtonDialog.isShowing())
//                        mTwoButtonDialog.dismiss();
//                }
//            });
//            mTwoButtonDialog.show();
//        }
//    }
    private void setDialogWidth() {

        WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
        lp.copyFrom(mSingleButtonDialog.getWindow().getAttributes());
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        mSingleButtonDialog.getWindow().setAttributes(lp);
//        mSingleButtonDialog.getWindow().setAttributes(lp);

    }

    /**
     *
     */
    public void showLimitDialog() {
//        if (mSingleButtonDialog != null && !mSingleButtonDialog.isShowing()) {
//
//            TextView negativeButton = (TextView) mSingleButtonDialog.findViewById(R.id.ok_button);
//            negativeButton.setOnClickListener(new View.OnClickListener() {
//
//                @Override
//                public void onClick(View v) {
//                    if (mSingleButtonDialog != null && mSingleButtonDialog.isShowing())
//                        mSingleButtonDialog.dismiss();
//                }
//            });
//            mSingleButtonDialog.show();
//        }
    }
}

