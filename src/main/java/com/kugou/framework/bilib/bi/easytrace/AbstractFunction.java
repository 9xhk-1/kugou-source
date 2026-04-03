package com.kugou.framework.bilib.bi.easytrace;

/* JADX INFO: loaded from: classes2.dex */
public class AbstractFunction {
    private long castEndTime;
    private long castTime;
    private String category;
    private String dest;
    private int id;
    private String name;

    public AbstractFunction(int i2, String str) {
        this(i2, null, str, null);
    }

    public void begin() {
        if (this.castTime == 0) {
            this.castTime = System.currentTimeMillis();
        }
    }

    public void beginEnd(long j) {
        this.castEndTime = j;
    }

    public void end() {
        this.castTime = 0L;
        this.castEndTime = 0L;
    }

    public long getCastTime() {
        long j = this.castTime;
        if (j == 0) {
            return 0L;
        }
        long j2 = this.castEndTime;
        return j2 == 0 ? (System.currentTimeMillis() - this.castTime) / 1000 : (j2 - j) / 1000;
    }

    public String getCategory() {
        return this.category;
    }

    public String getDest() {
        return this.dest;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public void setCategory(String str) {
        this.category = str;
    }

    public void setDest(String str) {
        this.dest = str;
    }

    public AbstractFunction(int i2, String str, String str2) {
        this(i2, str, str2, null);
    }

    public AbstractFunction(int i2, String str, String str2, String str3) {
        this.id = (short) i2;
        this.name = str2;
        this.category = str;
        this.dest = str3;
    }

    public void begin(long j) {
        this.castTime = j;
    }
}
