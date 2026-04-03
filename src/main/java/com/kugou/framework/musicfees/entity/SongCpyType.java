package com.kugou.framework.musicfees.entity;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes.dex */
@Retention(RetentionPolicy.RUNTIME)
public @interface SongCpyType {
    public static final int DEFALUT_CPY = -1;
    public static final int DEFAULT_NEW_CPY = 0;
    public static final int DEFAULT_OLD_CPY = 1;
}
