package com.blackanaly.autotrack;

import android.app.AlarmManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.util.Log;


public class ScreenOnOffReceiver extends BroadcastReceiver {
    public static final long ELAPSED_TEN_MINUTE = AlarmManager.INTERVAL_HALF_HOUR/3;
    private static final String TAG = "ScreenOnOffReceiver";
    private Context mContext;
    private long mScreenOffTime;
    public ScreenOnOffReceiver(Context context) {
        mContext = context;
    }
    @Override
    public void onReceive(Context context, Intent intent) {

        String action = intent.getAction();
        Log.d(TAG, "action is XXX" + action);
        if (Intent.ACTION_SCREEN_ON.equals(action)) {
//            ((AnalytocsApplication)context.getApplicationContext()).registerAlarmManager();
        } else if (Intent.ACTION_SCREEN_OFF.equals(action)) {
//            ((AnalytocsApplication)context.getApplicationContext()).unRegisterAlarmManager();
        }
    }
}
