package com.kugou.framework.bilib.bi;

import com.kugou.framework.bilib.bi.easytrace.AbstractFunction;

/* JADX INFO: loaded from: classes2.dex */
public class Function extends AbstractFunction implements Cloneable {
    public static final Function IDENTIFY_START = new Function(20070, "听歌识曲", "统计", "识曲人数");
    public static final Function IDENTIFY_RESULT = new Function(20071, "听歌识曲", "统计", "识曲结果");

    public Function(int i2, String str) {
        super(i2, str);
    }

    public Function(int i2, String str, String str2) {
        super(i2, str, str2);
    }

    /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
    public Function m12clone() {
        try {
            return (Function) super.clone();
        } catch (CloneNotSupportedException e2) {
            e2.printStackTrace();
            return this;
        }
    }

    public Function(int i2, String str, String str2, String str3) {
        super(i2, str, str2, str3);
    }
}
