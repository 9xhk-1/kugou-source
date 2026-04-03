package com.kugou.common.apm.auto.cache;

import e.c.a.g.a.s.g0;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class SessionModel {
    public static volatile SessionModel sessionModel;
    public Map<String, Integer> mapping = new HashMap();

    private SessionModel() {
    }

    public static SessionModel init() {
        if (sessionModel == null) {
            synchronized (SessionModel.class) {
                if (sessionModel == null) {
                    sessionModel = new SessionModel();
                }
            }
        }
        return sessionModel;
    }

    public void clean(String str) {
        this.mapping.put(str, null);
    }

    public int getSubSize(String str) {
        Integer num = this.mapping.get(str);
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public String getType(String str) {
        try {
            return str.split("-")[0];
        } catch (Exception e2) {
            if (g0.a) {
                g0.b("autoapm", "getKey: 不合法session");
            }
            g0.k(e2);
            return "";
        }
    }

    public String makeSession(String str) {
        Integer num = this.mapping.get(str);
        int iValueOf = num == null ? 1 : Integer.valueOf(num.intValue() + 1);
        String str2 = str + "-" + iValueOf;
        this.mapping.put(str, iValueOf);
        return str2;
    }
}
