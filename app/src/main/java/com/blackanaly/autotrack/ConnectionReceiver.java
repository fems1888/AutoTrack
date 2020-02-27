package com.blackanaly.autotrack;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import android.util.Log;


public class ConnectionReceiver extends BroadcastReceiver {
    private static final String TAG = "ConnectionReceiver";

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.e("ConnectionReceiver#","init");
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isAvailable()) {

        }
        Log.e("ConnectionReceiver#",(networkInfo == null)?"NULL":(networkInfo.isAvailable()+""));
    }

}
