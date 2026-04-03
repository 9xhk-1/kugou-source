package com.google.gson.callback;

/* JADX INFO: loaded from: classes.dex */
public interface ISyncDeserializeCallback<T> {
    void onFailed(MsgDeserialize msgDeserialize);

    void onSuccess(T t, MsgDeserialize msgDeserialize);
}
