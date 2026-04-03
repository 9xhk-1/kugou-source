package com.kugou.common.permission;

/* JADX INFO: loaded from: classes2.dex */
public interface Setting extends SettingService {

    public interface Action {
        void onAction();
    }

    Setting onComeback(Action action);

    void start();
}
