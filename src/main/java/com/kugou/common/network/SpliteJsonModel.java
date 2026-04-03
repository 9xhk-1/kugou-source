package com.kugou.common.network;

/* JADX INFO: loaded from: classes2.dex */
public class SpliteJsonModel {
    public static volatile SpliteJsonModel INSTANCE;

    public static SpliteJsonModel init() {
        if (INSTANCE == null) {
            synchronized (SpliteJsonModel.class) {
                if (INSTANCE == null) {
                    INSTANCE = new SpliteJsonModel();
                }
            }
        }
        return INSTANCE;
    }
}
