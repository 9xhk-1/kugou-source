package com.kugou.framework.lyric.loader;

import com.kugou.framework.lyric.LyricInfo;

/* JADX INFO: loaded from: classes2.dex */
public interface ILyricLoader {
    LyricInfo load(String str);

    LyricInfo load(byte[] bArr);
}
