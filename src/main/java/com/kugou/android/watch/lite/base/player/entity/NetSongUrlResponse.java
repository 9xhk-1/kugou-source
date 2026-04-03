package com.kugou.android.watch.lite.base.player.entity;

import com.kugou.android.watch.lite.common.INoGuard;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class NetSongUrlResponse implements INoGuard {
    private String errorMessage;
    private int errorType;
    private ArrayList<String> failProcess;
    private CommNetSongUrlInfo netSongUrl;
    private String originErrIdentify;
    private String respStr;

    public String getErrorMessage() {
        return this.errorMessage;
    }

    public int getErrorType() {
        return this.errorType;
    }

    public ArrayList<String> getFailProcess() {
        return this.failProcess;
    }

    public CommNetSongUrlInfo getNetSongUrl() {
        return this.netSongUrl;
    }

    public String getOriginErrIdentify() {
        return this.originErrIdentify;
    }

    public String getRespStr() {
        return this.respStr;
    }

    public void setErrorMessage(String str) {
        this.errorMessage = str;
    }

    public void setErrorType(int i2) {
        this.errorType = i2;
    }

    public void setFailProcess(ArrayList<String> arrayList) {
        this.failProcess = arrayList;
    }

    public void setNetSongUrl(CommNetSongUrlInfo commNetSongUrlInfo) {
        this.netSongUrl = commNetSongUrlInfo;
    }

    public void setOriginErrIdentify(String str) {
        this.originErrIdentify = str;
    }

    public void setRespStr(String str) {
        this.respStr = str;
    }
}
