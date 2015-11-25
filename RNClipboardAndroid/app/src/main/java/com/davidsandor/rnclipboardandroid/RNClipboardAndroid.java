package com.davidsandor.rnclipboardandroid;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.util.Log;

import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RNClipboardAndroid extends ReactContextBaseJavaModule {
    public RNClipboardAndroid(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Override
    public String getName() {
        return "RNClipboard";
    }

    @ReactMethod
    public void get(Callback cb) {
        try {
            ReactApplicationContext reactContext = getReactApplicationContext();

            ClipboardManager clipboard = (ClipboardManager)reactContext.getSystemService(reactContext.CLIPBOARD_SERVICE);

            android.content.ClipData clipData = clipboard.getPrimaryClip();

            if(clipData == null){
                cb.invoke("");
                return;
            }

            if (clipData.getItemCount() >= 1) {
                ClipData.Item clipDataItem = clipboard.getPrimaryClip().getItemAt(0);

                String data = "" + clipDataItem.getText();

                cb.invoke(data);
            } else {
                cb.invoke("");
                return;
            }

        } catch(Exception e) {
            Log.w("ClipboardAndroid", "Error in GET operation: " + e.getMessage());
        }
    }

    @ReactMethod
    public void set(String data) {
        try {

            ReactApplicationContext reactContext = getReactApplicationContext();

            ClipboardManager clipboard = (ClipboardManager)reactContext.getSystemService(reactContext.CLIPBOARD_SERVICE);

            ClipData clip = ClipData.newPlainText("text", data);

            clipboard.setPrimaryClip(clip);

        } catch(Exception e) {
            Log.w("ClipboardAndroid", "Error in SET operation: " + e.getMessage());
        }
    }

}
