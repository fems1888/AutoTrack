package com.blackanaly.autotrack;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.provider.Settings;

public class Util {
    public static boolean isNetConnected(Context context){
        Context applicationContext = context.getApplicationContext();
        ConnectivityManager connectivityManager = (ConnectivityManager) applicationContext.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        if (networkInfo !=null&&networkInfo.isConnected()){
            return true;
        }else {
            return false;
        }
    }
    public static boolean isNetConnected2(Context context){
        Context applicationContext = context.getApplicationContext();
        ConnectivityManager connectivityManager = (ConnectivityManager) applicationContext.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        if (networkInfo !=null&&networkInfo.isAvailable()){
            return true;
        }else {
            return false;
        }
    }

    public static String getAndroidId(Context context) {
        String ANDROID_ID = Settings.System.getString(context.getContentResolver(), Settings.System.ANDROID_ID);
        return ANDROID_ID;
    }
    private static final String UPLOAD_LOG = "upload_log_pref";
    public static boolean isApkInDebug(Context context) {
        try {
            ApplicationInfo info = context.getApplicationInfo();
            return (info.flags & ApplicationInfo.FLAG_DEBUGGABLE) != 0;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean isBlacksharkDevice(Context context) {
        PackageInfo packageInfo;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(BS_ANALYTICS_NAME, 0);
        }catch (PackageManager.NameNotFoundException e) {
            packageInfo = null;
            e.printStackTrace();
        }
        return packageInfo != null && isSystemPackage(packageInfo);
    }  private static final String BS_ANALYTICS_NAME = "com.blackshark.analytics";
    private static final int FLAG_SYSTEM_APP = ApplicationInfo.FLAG_SYSTEM |
            ApplicationInfo.FLAG_UPDATED_SYSTEM_APP;
    private static boolean isSystemPackage(PackageInfo pkg) {
        return (pkg.applicationInfo.flags & FLAG_SYSTEM_APP) != 0;
    }
    public static boolean isUserExperienceOn(Context context){
        return Settings.Secure.getInt(context.getContentResolver(), UPLOAD_LOG, 0) == 1;
    }

}

