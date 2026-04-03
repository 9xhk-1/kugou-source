package com.kugou.framework.musichunter;

/* JADX INFO: loaded from: classes2.dex */
public class RecordType {
    public static int TAB_CONTINUOUS_IDENTIFY = 2;
    public static int TYPE_HUMMING = 1;
    public static int TYPE_MUSICHUNTER;

    public static boolean isHunterType(int i2) {
        return i2 == TYPE_MUSICHUNTER || i2 == TAB_CONTINUOUS_IDENTIFY;
    }
}
