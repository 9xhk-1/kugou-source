package com.xtc.shareapi.share.interfaces;

/* JADX INFO: loaded from: classes2.dex */
public interface IShareObject extends IBundleSerialize {
    public static final int TYPE_APPEXTEND = 5;
    public static final int TYPE_IMAGE = 2;
    public static final int TYPE_MUSIC = 3;
    public static final int TYPE_TEXT = 1;
    public static final int TYPE_UNKNOWN = 0;
    public static final int TYPE_VIDEO = 4;
    public static final int TYPE_WEB = 6;

    int type();
}
