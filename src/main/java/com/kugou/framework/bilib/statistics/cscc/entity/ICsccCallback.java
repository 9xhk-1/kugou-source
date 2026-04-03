package com.kugou.framework.bilib.statistics.cscc.entity;

import android.os.IInterface;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes2.dex */
public interface ICsccCallback extends IInterface {
    void onFailed(String str) throws RemoteException;
}
