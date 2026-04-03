package com.kugou.datacollect.bi.use;

import android.os.Build;
import androidx.core.app.NotificationCompat;
import com.kugou.common.apm.sdk.ApmDataKey;
import com.kugou.framework.libcommon.netcore.BaseConnection;
import e.c.c.l.f.a;
import e.c.c.o.f;
import e.c.c.o.m;
import java.util.Hashtable;

/* JADX INFO: loaded from: classes2.dex */
public class TraceTask {
    public String duration;
    public String ehc;
    public String fo;
    public String fs;
    public String ft;
    public a function;
    public String status;
    public String sty;
    public String time = System.currentTimeMillis() + "";
    public String type;

    public TraceTask(a aVar) {
        this.function = aVar;
    }

    public static String getGetRequestParams(Hashtable<String, Object> hashtable) {
        if (hashtable == null) {
            return "";
        }
        try {
            if (hashtable.size() <= 0) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            for (String str : hashtable.keySet()) {
                sb.append(str);
                sb.append(BaseConnection.HTTP_REQ_ENTITY_MERGE);
                sb.append(hashtable.get(str));
                sb.append(BaseConnection.HTTP_REQ_ENTITY_JOIN);
            }
            sb.deleteCharAt(sb.length() - 1);
            return sb.toString();
        } catch (Exception unused) {
            return "";
        }
    }

    public void putValue(String str, String str2, Hashtable<String, Object> hashtable) {
        if (str2 == null || str2.length() == 0) {
            return;
        }
        hashtable.put(str, str2);
    }

    public TraceTask setDuration(String str) {
        this.duration = str;
        return this;
    }

    public TraceTask setEhc(String str) {
        this.ehc = str;
        return this;
    }

    public TraceTask setFo(String str) {
        this.fo = str;
        return this;
    }

    public TraceTask setFs(String str) {
        this.fs = str;
        return this;
    }

    public TraceTask setFt(String str) {
        this.ft = str;
        return this;
    }

    public TraceTask setStatus(String str) {
        this.status = str;
        return this;
    }

    public TraceTask setSty(String str) {
        this.sty = str;
        return this;
    }

    public TraceTask setType(String str) {
        this.type = str;
        return this;
    }

    public String toJson() {
        try {
            Hashtable<String, Object> hashtable = new Hashtable<>();
            hashtable.put("a", this.function.a + "");
            hashtable.put("b", this.function.c);
            hashtable.put("r", this.function.b);
            hashtable.put("ft", this.function.f1264d);
            hashtable.put(NotificationCompat.CATEGORY_SYSTEM, Build.VERSION.RELEASE);
            hashtable.put("model", Build.MODEL);
            hashtable.put("ver", Integer.valueOf(m.x(f.a())));
            hashtable.put("uuid", m.f(f.a()));
            hashtable.put("imei", m.l(f.a()));
            hashtable.put("time", this.time);
            hashtable.put("net", Integer.valueOf(m.m(f.a())));
            hashtable.put("sid", m.e(f.a()));
            hashtable.put("z", 0);
            putValue("type", this.type, hashtable);
            putValue(NotificationCompat.CATEGORY_STATUS, this.status, hashtable);
            putValue("sty", this.sty, hashtable);
            putValue(ApmDataKey.FS, this.fs, hashtable);
            putValue("ehc", this.ehc, hashtable);
            putValue("duration", this.duration, hashtable);
            putValue("fo", this.fo, hashtable);
            return getGetRequestParams(hashtable);
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public String toString() {
        return "a=" + this.function.a + " r=" + this.function.b + " b=" + this.function.c + " ft=" + this.function.f1264d;
    }
}
