package com.kugou.common.network;

/* JADX INFO: loaded from: classes2.dex */
public interface INetworkState {
    void onReadEnd();

    void onReadStart();

    void onRequest();

    void onResponse(int i2);

    void onStop();
}
