package com.blackanaly.autotrack;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Context;
import android.content.IntentFilter;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.blackanaly.sdk.SensorsDataTrackViewOnClick;

public class MainActivity extends AppCompatActivity {
    public static final String UPLOAD_NUM_LIMIT = "upload_num_limit";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                register();
                Toast.makeText(getApplicationContext(),":Ddd",Toast.LENGTH_LONG).show();
            }
        });
        findViewById(R.id.init).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                ((AnalytocsApplication)getApplicationContext()).registerAlarmManager();
                isEventIdIgnoreAgreement(getApplicationContext(),22);
                String androidId = Util.getAndroidId(getApplicationContext());
                boolean isApkInDebug = Util.isApkInDebug(getApplicationContext());
                boolean isBlacksharkDevice = Util.isBlacksharkDevice(getApplicationContext());
                Log.e("androidId = ",androidId+", isApkInDebug = "+isApkInDebug+", isBlacksharkDevice "+ isBlacksharkDevice);
                Toast.makeText(getApplicationContext(),("androidId = "+androidId+", isApkInDebug = "+isApkInDebug),Toast.LENGTH_LONG).show();
            }
        });
        findViewById(R.id.uninit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                ((AnalytocsApplication)getApplicationContext()).unRegisterAlarmManager();
            }
        });


        ContentValues values = new ContentValues();
        values.put(UPLOAD_NUM_LIMIT,1000);

        if (values.containsKey(UPLOAD_NUM_LIMIT) == true){
            Log.e("fc","11");
        }
        if (values.containsKey(UPLOAD_NUM_LIMIT)){
            Log.e("fc","22");
        }
        if (values.containsKey(UPLOAD_NUM_LIMIT) == false){
            Log.e("fc","33");
        }
        if (values.containsKey("dddd") == true){
            Log.e("fc","44");
        }
        if (values.containsKey("dddd") == false){
            Log.e("fc","55");
        }if (values.containsKey("dddd")){
            Log.e("fc","66");
        }

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Log.e("DFD",Thread.currentThread().getName());
            }
        },2000);

        new Thread(){
            @Override
            public void run() {
                super.run();
                Log.e("DFD2",Thread.currentThread().getName());
            }
        }.start();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                Log.e("DFD3",Thread.currentThread().getName());
            }
        });
        thread.start();
    }

    @SensorsDataTrackViewOnClick
    private void register() {
        IntentFilter filter = new IntentFilter();
        filter.addAction("just_one_test");
        TestModeReceiver mTestModeReceiver = new TestModeReceiver();
        registerReceiver(mTestModeReceiver, filter);
    }

    private static boolean isEventIdIgnoreAgreement(Context context, long eventId) {
        try {
            if (eventId>10){
                Log.e("RRR","1");
                return true;
            }
        } catch (Exception e) {
            Log.e("RRR","2");
            e.printStackTrace();
        } finally {
            Log.e("RRR","3");
        }
        return false;
    }
}
