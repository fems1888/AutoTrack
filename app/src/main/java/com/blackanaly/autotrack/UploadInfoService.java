package com.blackanaly.autotrack;

import android.app.IntentService;
import android.app.Notification;
import android.content.Intent;
import android.util.Log;


/*
 * when UploadInfoService is not foreground use context.startService(uploadIntent) will has "Not allowed to start service Intent" exception
 * UploadInfoService only for PRIORITY_THIRTY(MAX), other level control by JobScheduler
 * */
public class UploadInfoService extends IntentService {
    public static final String TAG = "UploadInfoService XXX";

    public UploadInfoService() {
        super(TAG);
    }

    @Override
    protected void onHandleIntent( Intent intent) {
        Log.d(TAG,"UploadInfoService XXX");
        if (intent == null) {
            return;
        }

    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public void onDestroy() {
        Log.d(TAG,"onDestroy XXX");
        super.onDestroy();
    }

}
