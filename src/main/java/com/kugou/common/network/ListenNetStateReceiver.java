package com.kugou.common.network;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.kugou.android.watch.lite.R;
import com.kugou.android.watch.lite.base.application.KGApplication;
import com.kugou.common.datacollect.UpdateDeviceFingerHelper;
import e.c.a.g.a.f.d.a;
import e.c.a.g.a.f.m.c;
import e.c.a.g.a.s.g0;
import e.c.a.g.a.s.l1;
import e.c.a.g.a.s.p1;
import e.c.a.g.a.s.u0;
import e.c.c.o.f;

/* JADX INFO: loaded from: classes2.dex */
public class ListenNetStateReceiver extends BroadcastReceiver {
    public static final int NET_FAIL = 1;
    public static final int NET_GPRS = 2;
    public static final int NET_WIFI = 3;
    private int mCurNetType = 0;
    private boolean showMobileNetTip = false;

    public void checkNetState(Context context) {
        try {
            if (g0.a) {
                g0.b("ListenNetStateReceiver", "checkNetState: type " + l1.o(context));
            }
            ConnectivityManager connectivityManager = (ConnectivityManager) f.a().getSystemService("connectivity");
            NetworkInfo networkInfo = connectivityManager.getNetworkInfo(1);
            if (networkInfo != null && networkInfo.isConnected()) {
                if (this.mCurNetType != 3) {
                    UpdateDeviceFingerHelper.getInstance().tryUpdate();
                    this.mCurNetType = 3;
                    this.showMobileNetTip = true;
                    return;
                }
                return;
            }
            NetworkInfo networkInfo2 = connectivityManager.getNetworkInfo(0);
            if (networkInfo2 == null || !networkInfo2.isConnected()) {
                this.mCurNetType = 1;
                if (l1.V()) {
                    boolean zE = c.a.e("once_request_mobile_net", false);
                    if (this.showMobileNetTip && !zE && e.c.a.g.a.d.x.f.q()) {
                        e.c.a.g.a.d.x.f.t();
                    }
                } else if (l1.n0()) {
                    p1.f(KGApplication.getContext(), "当前无网络连接，已暂停音频播放");
                    if (e.c.a.g.a.d.x.f.q()) {
                        e.c.a.g.a.d.x.f.t();
                    }
                }
                this.showMobileNetTip = true;
                u0.A(30, "ListenNetStateReceiver", "mCurNetType-" + this.mCurNetType);
                return;
            }
            if (this.mCurNetType != 2) {
                UpdateDeviceFingerHelper.getInstance().tryUpdate();
                this.mCurNetType = 2;
                if (this.showMobileNetTip) {
                    String strO = l1.o(context);
                    if ("4G".equals(strO) || "3G".equals(strO) || "2G".equals(strO)) {
                        if (l1.V()) {
                            if (c.a.e("once_request_mobile_net", false)) {
                                p1.g(KGApplication.getContext(), R.string.show_2g_3g_tips);
                            } else {
                                if (e.c.a.g.a.d.x.f.q()) {
                                    e.c.a.g.a.d.x.f.t();
                                }
                                a.d(new Intent("com.kugou.android.action.traffic.protection"));
                            }
                        } else if (!l1.m0() || !u0.x(context)) {
                            p1.g(KGApplication.getContext(), R.string.show_2g_3g_tips);
                        }
                    }
                }
                this.showMobileNetTip = false;
            }
        } catch (Exception e2) {
            g0.k(e2);
            u0.B(31, "ListenNetStateReceiver", "Exception-mCurNetType-" + this.mCurNetType, e2);
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction())) {
            checkNetState(context);
        }
    }
}
