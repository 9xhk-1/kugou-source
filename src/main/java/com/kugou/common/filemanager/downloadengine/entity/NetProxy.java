package com.kugou.common.filemanager.downloadengine.entity;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes2.dex */
public class NetProxy {
    private String host;
    private int port;

    public NetProxy(String str, int i2) {
        this.host = str;
        this.port = i2;
    }

    public String getHost() {
        return this.host;
    }

    public int getPort() {
        return this.port;
    }

    public boolean isEmpty() {
        return TextUtils.isEmpty(this.host) || this.port <= 0;
    }
}
