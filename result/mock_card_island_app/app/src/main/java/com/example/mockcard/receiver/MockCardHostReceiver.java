package com.example.mockcard.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.example.mockcard.provider.MockCardWidgetProvider;

public class MockCardHostReceiver extends BroadcastReceiver {
    private static final String TAG = "MockCardHostReceiver";

    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent == null ? null : intent.getAction();
        Log.d(TAG, "onReceive action=" + action + " snapshot=" + MockCardWidgetProvider.snapshotJson());
    }
}
