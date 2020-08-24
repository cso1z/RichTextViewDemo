package com.xyz.richtext;

import android.app.Application;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;

public class CommonApp extends Application {

    protected Handler mainHandler;
    protected static CommonApp instance;

    public CommonApp() {
    }

    public static CommonApp getApplication() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        mainHandler = new Handler(Looper.getMainLooper());
    }


    public void post(Runnable r) {
        if (r != null) {
            mainHandler.post(r);
        }
    }

    public void postDelayed(Runnable r, int delayMillis) {
        if (r != null) {
            mainHandler.postDelayed(r, delayMillis);
        }
    }

    public void removeCallbacks(Runnable r) {
        if (r != null) {
            mainHandler.removeCallbacks(r);
        }
    }

    public void clearAllNotification() {
        NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        manager.cancelAll();
    }

}
