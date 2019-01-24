package com.example.android.juetfiles;

import android.app.Application;

import com.firebase.client.Firebase;


public class JUETFiles extends Application{
    @Override
    public void onCreate() {
        super.onCreate();

        Firebase.setAndroidContext(this);

    }
}
