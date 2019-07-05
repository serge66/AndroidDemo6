package com.example.androiddemo6;

import android.app.Application;

public class MyApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        FlutterMediator.init(this);
    }
}
