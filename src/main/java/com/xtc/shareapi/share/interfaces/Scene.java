package com.xtc.shareapi.share.interfaces;

/* JADX INFO: loaded from: classes2.dex */
public interface Scene extends IBundleSerialize {
    public static final int TYPE_CHAT = 1;
    public static final int TYPE_MOMENT = 2;
    public static final int TYPE_TIME_MEMORY = 3;
    public static final int TYPE_YOUTUBE = 4;

    String getAppName();

    String getPackageName();

    String getTargetClassName();

    int getType();
}
