package com.kugou.common.apm.auto;

import android.os.SystemClock;
import com.kugou.common.apm.auto.cache.SessionModel;
import com.kugou.common.apm.sdk.YoungApmData;
import e.c.a.g.a.s.g0;
import e.c.a.g.a.s.l1;
import e.c.c.f;
import e.c.c.j.d.a;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class YoungApmSessionModelImpl extends a {
    private static final String TAG = "YoungApmSessionModelImpl";
    private final Map<String, YoungApmData> apmDataMap;

    public static class InstanceHolder {
        private static final YoungApmSessionModelImpl sInstance = new YoungApmSessionModelImpl();

        private InstanceHolder() {
        }
    }

    public static long getCurTime() {
        return SystemClock.elapsedRealtime();
    }

    public static YoungApmSessionModelImpl with(String str) {
        return InstanceHolder.sInstance;
    }

    @Override // e.c.c.j.d.a
    public void add(String str, String str2) {
        str2.hashCode();
        switch (str2) {
            case "ui_load_time":
            case "start_time":
            case "net_delay":
            case "all_load_time":
                add(str, str2, Long.toString(getCurTime()));
                break;
        }
    }

    @Override // e.c.c.j.d.a
    public void end(String str) {
        end(str, getCurTime());
    }

    public YoungApmData get(String str) {
        return this.apmDataMap.get(str);
    }

    @Override // e.c.c.j.d.a
    public String start(String str) {
        return start(str, getCurTime());
    }

    private YoungApmSessionModelImpl() {
        this.apmDataMap = new HashMap();
    }

    @Override // e.c.c.j.d.a
    public void end(String str, long j) {
        YoungApmData youngApmDataRemove = this.apmDataMap.remove(str);
        if (youngApmDataRemove == null || !youngApmDataRemove.check()) {
            return;
        }
        youngApmDataRemove.setAllLoadTime(j - youngApmDataRemove.getStartTime());
        if (l1.M()) {
            f.a(youngApmDataRemove);
        }
        if (g0.a) {
            g0.e(TAG, String.format("map size:%s, end with:%s", Integer.valueOf(this.apmDataMap.size()), youngApmDataRemove.toMap()));
        }
    }

    @Override // e.c.c.j.d.a
    public String start(String str, long j) {
        String strMakeSession = SessionModel.init().makeSession(str);
        YoungApmData youngApmData = new YoungApmData(Integer.parseInt(str));
        youngApmData.setStartTime(j);
        this.apmDataMap.put(strMakeSession, youngApmData);
        return strMakeSession;
    }

    @Override // e.c.c.j.d.a
    public void add(String str, String str2, String str3) {
        YoungApmData youngApmData = this.apmDataMap.get(str);
        if (youngApmData == null || !youngApmData.check()) {
            return;
        }
        str2.hashCode();
        switch (str2) {
            case "state_1":
                youngApmData.setState1(str3);
                break;
            case "state_2":
                youngApmData.setState2(str3);
                break;
            case "ui_load_time":
                youngApmData.setUiLoadTime(Long.parseLong(str3) - youngApmData.getStartTime());
                break;
            case "start_time":
                youngApmData.setStartTime(Long.parseLong(str3));
                break;
            case "fs":
                youngApmData.setFs(str3);
                break;
            case "te":
                youngApmData.setTe(str3);
                break;
            case "para":
                youngApmData.setPara(str3);
                break;
            case "state":
                youngApmData.setState(Integer.parseInt(str3));
                break;
            case "position":
                youngApmData.setPosition(str3);
                break;
            case "net_delay":
                youngApmData.setNetDelay(Long.parseLong(str3) - youngApmData.getStartTime());
                break;
            case "all_load_time":
                youngApmData.setAllLoadTime(Long.parseLong(str3) - youngApmData.getStartTime());
                break;
            default:
                youngApmData.add(str2, str3);
                break;
        }
    }

    @Override // e.c.c.j.d.a
    public String start(String str, int i2) {
        throw new IllegalArgumentException("not support this method: start(String type, int subLineMaxNumber)");
    }

    @Override // e.c.c.j.d.a
    public void end(String str, String str2) {
        throw new IllegalArgumentException("not support this method: end(String session, String identification)");
    }
}
