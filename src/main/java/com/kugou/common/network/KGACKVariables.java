package com.kugou.common.network;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import com.kugou.android.watch.lite.R;
import com.kugou.android.watch.lite.base.application.KGApplication;
import com.kugou.android.watch.lite.common.INoGuard;
import com.kugou.android.watch.lite.common.network.KGHttpVariables;
import com.kugou.common.network.networkutils.MD5Util;
import e.c.a.g.a.f.e.b;
import e.c.a.g.a.f.e.c;
import e.c.a.g.a.s.l1;
import e.c.a.g.a.s.m;
import java.util.Hashtable;

/* JADX INFO: loaded from: classes2.dex */
public class KGACKVariables extends BaseAckVars implements INoGuard {
    @Override // com.kugou.common.network.BaseAckVars, com.kugou.common.network.AbsAckVars
    public Hashtable<String, String> getAckRequestParams() {
        String config = c.c().getConfig(b.c);
        String config2 = c.c().getConfig(b.f642d);
        long jCurrentTimeMillis = System.currentTimeMillis() / 1000;
        String lowerCase = new MD5Util().getMD5ofStr(config + config2 + 1 + jCurrentTimeMillis).toLowerCase();
        Hashtable<String, String> hashtable = new Hashtable<>();
        hashtable.put("appid", config);
        hashtable.put("clientver", String.valueOf(1));
        hashtable.put("uid", String.valueOf(e.c.a.g.a.r.b.o()));
        hashtable.put("mid", l1.n(KGApplication.getContext()));
        hashtable.put("uuid", m.h());
        hashtable.put("clienttime", String.valueOf(jCurrentTimeMillis));
        hashtable.put("key", lowerCase);
        return hashtable;
    }

    @Override // com.kugou.common.network.BaseAckVars, com.kugou.common.network.AbsAckVars
    public String getAckUrl() {
        return c.c().getConfig(b.a);
    }

    @Override // com.kugou.common.network.BaseAckVars, com.kugou.common.network.AbsAckVars
    public String getBackupAddress() {
        return c.c().getConfig(b.b);
    }

    @Override // com.kugou.common.network.BaseAckVars, com.kugou.common.network.AbsAckVars
    public Context getContext() {
        return KGApplication.getContext();
    }

    @Override // com.kugou.common.network.BaseAckVars, com.kugou.common.network.AbsAckVars
    public int getDefalutRawResource() {
        return R.raw.ack_default;
    }

    @Override // com.kugou.common.network.BaseAckVars, com.kugou.common.network.AbsAckVars
    public AbsHttpClient getHttpClient() {
        return BaseHttpClient.getInstance(getContext(), KGHttpVariables.getInstance());
    }

    @Override // com.kugou.common.network.BaseAckVars, com.kugou.common.network.AbsAckVars
    public String getRetryTime() {
        return null;
    }

    @Override // com.kugou.common.network.BaseAckVars, com.kugou.common.network.AbsAckVars
    public void registerSysReceiver(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        KGApplication.getContext().registerReceiver(broadcastReceiver, intentFilter);
    }
}
