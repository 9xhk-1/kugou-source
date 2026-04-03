package com.kugou.common.filemanager.downloadengine.stat;

import android.support.annotation.IntRange;
import android.text.TextUtils;
import com.kugou.common.network.retrystatics.RetryStaticsLOG;

/* JADX INFO: loaded from: classes2.dex */
public class OnlineStat {
    private String kgRF;
    private int type = -1;
    private int natType = 3;
    private boolean succ = false;
    private boolean tryNext = false;
    private String result = "";
    private int duration = 0;
    private String err = "";
    private String serverIP = "";
    private String clientIP = "";
    private long kgRC = 0;

    public String getClientIP() {
        return this.clientIP;
    }

    public int getDuration() {
        return this.duration;
    }

    public String getErr() {
        return this.err;
    }

    public long getKgRC() {
        return this.kgRC;
    }

    public String getKgRF() {
        return this.kgRF;
    }

    public int getNatType() {
        return this.natType;
    }

    public String getResult() {
        return this.result;
    }

    public String getServerIP() {
        return this.serverIP;
    }

    public int getType() {
        return this.type;
    }

    public boolean isSucc() {
        return this.succ;
    }

    public boolean isTryNext() {
        return this.tryNext;
    }

    public void merge(OnlineStat onlineStat) {
        int i2 = this.type;
        if (i2 == -1 || i2 == onlineStat.type) {
            if (i2 == -1) {
                this.type = onlineStat.type;
                this.natType = onlineStat.natType;
            }
            this.succ = onlineStat.succ;
            this.tryNext = onlineStat.tryNext;
            if (!TextUtils.isEmpty(this.result)) {
                this.result += RetryStaticsLOG.MARK_END;
            }
            this.result += onlineStat.result;
            this.duration += onlineStat.duration;
            if (!TextUtils.isEmpty(this.err)) {
                this.err += RetryStaticsLOG.MARK_END;
            }
            this.err += onlineStat.err;
            if (!TextUtils.isEmpty(this.serverIP)) {
                this.serverIP += RetryStaticsLOG.MARK_END;
            }
            this.serverIP += onlineStat.serverIP;
            if (TextUtils.isEmpty(onlineStat.clientIP)) {
                return;
            }
            this.clientIP = onlineStat.clientIP;
        }
    }

    public void setClientIP(String str) {
        this.clientIP = str;
    }

    public void setDuration(int i2) {
        this.duration = i2;
    }

    public void setErr(String str) {
        this.err = str;
    }

    public void setKgRC(@IntRange(from = 0) long j) {
        this.kgRC = j;
    }

    public void setKgRF(String str) {
        this.kgRF = str;
    }

    public void setNatType(int i2) {
        this.natType = i2;
    }

    public void setResult(String str) {
        this.result = str;
    }

    public void setServerIP(String str) {
        this.serverIP = str;
    }

    public void setSucc(boolean z) {
        this.succ = z;
    }

    public void setTryNext(boolean z) {
        this.tryNext = z;
    }

    public void setType(int i2) {
        this.type = i2;
    }
}
