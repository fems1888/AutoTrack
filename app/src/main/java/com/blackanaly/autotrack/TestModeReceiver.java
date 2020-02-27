package com.blackanaly.autotrack;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;


/**
 * use to update event config or upload all event data,just for debug or test
 */
public class TestModeReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        if("just_one_test".equals(intent.getAction())){
            //update event config for test mode
            Log.e("TestModeReceiver##",context.getPackageName());
        }
    }
}
