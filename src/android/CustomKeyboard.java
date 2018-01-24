package com.zenput.customkeyboard;
import android.app.Activity;

import android.content.Context;
import android.content.Intent;
import android.view.Gravity;
import android.widget.FrameLayout;
import android.widget.TextView;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaArgs;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.PluginResult;
import org.json.JSONException;

public class CustomKeyboard extends CordovaPlugin {

    private CallbackContext callbackContext;
    private TextView mTextView = null;
    private FrameLayout mKeyboardLayout;

    @Override
    public boolean execute(String action, CordovaArgs args, CallbackContext callbackContext) throws JSONException {
        if(action.equals("open")) {

            android.content.Context context = CustomKeyboard.this.cordova.getActivity();

            if (mTextView == null) {
                mKeyboardLayout = new FrameLayout(context);
                FrameLayout.LayoutParams tDViewLayoutParams = new FrameLayout.LayoutParams(400, 400, Gravity.BOTTOM | Gravity.LEFT);
                mKeyboardLayout.setLayoutParams(tDViewLayoutParams);


                mTextView = new TextView(context);
                mKeyboardLayout.addView(mTextView);

                CustomKeyboard.this.cordova.getActivity().setContentView(mKeyboardLayout);

                mTextView.requestFocusFromTouch();
            }
            else
            {


            }



        }





        callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.INVALID_ACTION, "Unsupported action: " + action));
        return false;
    }
}