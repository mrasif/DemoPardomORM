package com.example.asif.demopardomorm.config;



import android.app.Application;

import com.activeandroid.ActiveAndroid;

/**
 * Created by asif on 12/14/17.
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        ActiveAndroid.initialize(this);
    }
}
