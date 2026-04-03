package com.kugou.common.utils;

import e.c.a.g.a.f.m.c;

/* JADX INFO: loaded from: classes2.dex */
public class PrivacyUtil {
    public static boolean hasAgreed() {
        return !c.a.e("sp_key_show_privacy", true);
    }
}
