package com.blackanaly.autotrack;

import android.app.AlarmManager;
import android.app.Application;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.SystemClock;
import android.util.Log;

import com.blackanaly.sdk.SensorsDataAPI;

import java.util.Timer;
import java.util.TimerTask;

import static android.app.PendingIntent.FLAG_UPDATE_CURRENT;

public class AnalytocsApplication extends Application {
    private PendingIntent mUploadSender = null;Timer timer;
    TimerTask task;
    private ScreenOnOffReceiver mScreenOnOffReceiver;
    public static final long ELAPSED_TEN_MINUTE = AlarmManager.INTERVAL_HALF_HOUR / 30;
    @Override
    public void onCreate() {
        super.onCreate();
        IntentFilter filter2 = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        ConnectionReceiver mConnectionReceiver = new ConnectionReceiver();
        registerReceiver(mConnectionReceiver, filter2);
        SensorsDataAPI.init(this);

        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(Intent.ACTION_SCREEN_OFF);
        intentFilter.addAction(Intent.ACTION_SCREEN_ON);
        mScreenOnOffReceiver = new ScreenOnOffReceiver(getApplicationContext());
        registerReceiver(mScreenOnOffReceiver, intentFilter);
        initCounter();
        registerAlarmManager();
        boolean userExperienceOn = Util.isUserExperienceOn(getApplicationContext());
        Log.e("jhjh","jhjh  "+userExperienceOn);

    }
    protected void unRegisterAlarmManager() {

        timer.cancel();
        timer.purge();
        Log.e("dddd",timer == null?"timer null":"timer not null");
        Log.e("dddd",task == null?"task null":"task not null");
        if (mUploadSender == null) {
            return;
        }
        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        alarmManager.cancel(mUploadSender);

    }
    private CountDownTimer countDownTimer;

    protected void registerAlarmManager() {
        timer = null;
        timer = new Timer(true);
         task = new TimerTask(){
            @Override
            public void run() {
                Log.e("onTick timer","isConnected = "+Util.isNetConnected(getApplicationContext())+ "   isAvailable = "+Util.isNetConnected2(getApplicationContext()));
            }
        };
        timer.schedule(task, ELAPSED_TEN_MINUTE,
                ELAPSED_TEN_MINUTE);

        startCounter();

    }
    private void initCounter() {

        countDownTimer = new CountDownTimer(ELAPSED_TEN_MINUTE,ELAPSED_TEN_MINUTE){
            @Override
            public void onTick(long l) {
            }

            @Override
            public void onFinish() {
                Log.d("onTick countDownTimer","onFinish");
                uploadData();
            }
        };


    }
    private void uploadData() {
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        startCounter();
    }

    public void startCounter() {
        if (countDownTimer == null){
            initCounter();
        }
        countDownTimer.start();

    }
}
