package com.example.mockcard;

import android.app.Application;

import com.example.mockcard.player.MockPlayerController;

public class MockApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        MockPlayerController.init(this);
    }
}
