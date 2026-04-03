package com.example.mockcard;

import android.app.Application;

import com.example.mockcard.service.MediaSessionController;
import com.example.mockcard.player.MockPlayerController;

public class MockApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        MediaSessionController.init(this);
        MockPlayerController.init(this);
    }
}
