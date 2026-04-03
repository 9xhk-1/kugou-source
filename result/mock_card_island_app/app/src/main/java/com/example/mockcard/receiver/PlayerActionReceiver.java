package com.example.mockcard.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.example.mockcard.player.MockPlayerController;

public class PlayerActionReceiver extends BroadcastReceiver {
    public static final String ACTION_PREV = "mock_action_notification_previous";
    public static final String ACTION_NEXT = "mock_action_notification_next";
    public static final String ACTION_PLAY = "mock_action_notification_play";

    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent == null || intent.getAction() == null) {
            return;
        }
        switch (intent.getAction()) {
            case ACTION_PREV:
                MockPlayerController.prevSong();
                break;
            case ACTION_NEXT:
                MockPlayerController.nextSong();
                break;
            case ACTION_PLAY:
                MockPlayerController.togglePlay();
                break;
            default:
                break;
        }
    }
}
