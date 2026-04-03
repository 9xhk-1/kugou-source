package com.xtc.shareapi.share.utils;

import android.media.MediaMetadataRetriever;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes2.dex */
public class VideoUtil {
    public static long convertLong(String str, long j) {
        try {
            return Long.parseLong(str);
        } catch (Exception unused) {
            return j;
        }
    }

    public static long getVideoLength(String str) {
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            mediaMetadataRetriever.setDataSource(str);
            String strExtractMetadata = mediaMetadataRetriever.extractMetadata(9);
            if (TextUtils.isEmpty(strExtractMetadata)) {
                return 0L;
            }
            return convertLong(strExtractMetadata, 0L);
        } catch (IllegalArgumentException unused) {
            return 0L;
        }
    }
}
