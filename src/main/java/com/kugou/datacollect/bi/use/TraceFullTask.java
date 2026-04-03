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
public class TraceFullTask extends TraceTask {
    public String commentid;
    public String duration;
    public String ehc;
    public String fo;
    public String fs;
    public String ft;
    public a function;
    public String groupid;
    public String hash;
    public String id1;
    public String id2;
    public String id3;
    public String ivar1;
    public String ivar2;
    public String ivar3;
    public String kw;
    public String lyricid;
    public String mixsongid;
    public String mvid;
    public String rankid;
    public String scid;
    public String specialid;
    public String status;
    public String sty;
    public String svar1;
    public String svar2;
    public String svar3;
    public String svar4;
    public String svar5;
    public String svar6;
    public String tab;
    public String time;
    public String type;
    public String userid;
    public String xxid;

    public TraceFullTask(a aVar) {
        super(aVar);
        this.function = aVar;
        this.time = System.currentTimeMillis() + "";
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

    @Override // com.kugou.datacollect.bi.use.TraceTask
    public void putValue(String str, String str2, Hashtable<String, Object> hashtable) {
        if (str2 == null || str2.length() == 0) {
            return;
        }
        hashtable.put(str, str2);
    }

    public TraceFullTask setCommentid(String str) {
        this.commentid = str;
        return this;
    }

    public TraceFullTask setGroupid(String str) {
        this.groupid = str;
        return this;
    }

    public TraceFullTask setHash(String str) {
        this.hash = str;
        return this;
    }

    public TraceFullTask setId1(String str) {
        this.id1 = str;
        return this;
    }

    public TraceFullTask setId2(String str) {
        this.id2 = str;
        return this;
    }

    public TraceFullTask setId3(String str) {
        this.id3 = str;
        return this;
    }

    public TraceFullTask setIvar1(String str) {
        this.ivar1 = str;
        return this;
    }

    public TraceFullTask setIvar2(String str) {
        this.ivar2 = str;
        return this;
    }

    public TraceFullTask setIvar3(String str) {
        this.ivar3 = str;
        return this;
    }

    public TraceFullTask setKw(String str) {
        this.kw = str;
        return this;
    }

    public TraceFullTask setLyricid(String str) {
        this.lyricid = str;
        return this;
    }

    public TraceFullTask setMixsongid(String str) {
        this.mixsongid = str;
        return this;
    }

    public TraceFullTask setMvid(String str) {
        this.mvid = str;
        return this;
    }

    public TraceFullTask setRankid(String str) {
        this.rankid = str;
        return this;
    }

    public TraceFullTask setScid(String str) {
        this.scid = str;
        return this;
    }

    public TraceFullTask setSpecialid(String str) {
        this.specialid = str;
        return this;
    }

    public TraceFullTask setSvar1(String str) {
        this.svar1 = str;
        return this;
    }

    public TraceFullTask setSvar2(String str) {
        this.svar2 = str;
        return this;
    }

    public TraceFullTask setSvar3(String str) {
        this.svar3 = str;
        return this;
    }

    public TraceFullTask setSvar4(String str) {
        this.svar4 = str;
        return this;
    }

    public TraceFullTask setSvar5(String str) {
        this.svar5 = str;
        return this;
    }

    public TraceFullTask setSvar6(String str) {
        this.svar6 = str;
        return this;
    }

    public TraceFullTask setTab(String str) {
        this.tab = str;
        return this;
    }

    public TraceFullTask setUserid(String str) {
        this.userid = str;
        return this;
    }

    public TraceFullTask setXxid(String str) {
        this.xxid = str;
        return this;
    }

    @Override // com.kugou.datacollect.bi.use.TraceTask
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
            putValue("userid", this.userid, hashtable);
            putValue("mixsongid", this.mixsongid, hashtable);
            putValue("hash", this.hash, hashtable);
            putValue("scid", this.scid, hashtable);
            putValue("specialid", this.specialid, hashtable);
            putValue("commentid", this.commentid, hashtable);
            putValue("lyricid", this.lyricid, hashtable);
            putValue("mvid", this.mvid, hashtable);
            putValue("rankid", this.rankid, hashtable);
            putValue("groupid", this.groupid, hashtable);
            putValue("xxid", this.xxid, hashtable);
            putValue("tab", this.tab, hashtable);
            putValue("type", this.type, hashtable);
            putValue(NotificationCompat.CATEGORY_STATUS, this.status, hashtable);
            putValue("sty", this.sty, hashtable);
            putValue(ApmDataKey.FS, this.fs, hashtable);
            putValue("ehc", this.ehc, hashtable);
            putValue("duration", this.duration, hashtable);
            putValue("fo", this.fo, hashtable);
            putValue("kw", this.kw, hashtable);
            putValue("id1", this.id1, hashtable);
            putValue("id2", this.id2, hashtable);
            putValue("id3", this.id3, hashtable);
            putValue("ivar1", this.ivar1, hashtable);
            putValue("ivar2", this.ivar2, hashtable);
            putValue("ivar3", this.ivar3, hashtable);
            putValue("svar1", this.svar1, hashtable);
            putValue("svar2", this.svar2, hashtable);
            putValue("svar3", this.svar3, hashtable);
            putValue("svar4", this.svar4, hashtable);
            putValue("svar5", this.svar5, hashtable);
            putValue("svar6", this.svar6, hashtable);
            return getGetRequestParams(hashtable);
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    @Override // com.kugou.datacollect.bi.use.TraceTask
    public String toString() {
        return "a=" + this.function.a + " r=" + this.function.b + " b=" + this.function.c + " ft=" + this.function.f1264d + " userid=" + this.userid + " mixsongid=" + this.mixsongid + "  hash=" + this.hash + " scid=" + this.scid + " specialid=" + this.specialid + " commentid=" + this.commentid + " lyricid=" + this.lyricid + " mvid=" + this.mvid + " rankid=" + this.rankid + " groupid=" + this.groupid + " xxid=" + this.xxid + " tab=" + this.tab + " type=" + this.type + " status=" + this.status + " sty=" + this.sty + " fs=" + this.fs + " ft=" + this.ft + " ehc=" + this.ehc + " duration=" + this.duration + " fo=" + this.fo + " kw=" + this.kw + " id1=" + this.id1 + " id2=" + this.id2 + " id3=" + this.id3 + " ivar1=" + this.ivar1 + " ivar2=" + this.ivar2 + " ivar3=" + this.ivar3 + " svar1=" + this.svar1 + " svar2=" + this.svar2 + " svar3=" + this.svar3 + " svar4=" + this.svar4 + " svar5=" + this.svar5 + " svar6=" + this.svar6 + " ";
    }

    @Override // com.kugou.datacollect.bi.use.TraceTask
    public TraceFullTask setDuration(String str) {
        this.duration = str;
        return this;
    }

    @Override // com.kugou.datacollect.bi.use.TraceTask
    public TraceFullTask setEhc(String str) {
        this.ehc = str;
        return this;
    }

    @Override // com.kugou.datacollect.bi.use.TraceTask
    public TraceFullTask setFo(String str) {
        this.fo = str;
        return this;
    }

    @Override // com.kugou.datacollect.bi.use.TraceTask
    public TraceFullTask setFs(String str) {
        this.fs = str;
        return this;
    }

    @Override // com.kugou.datacollect.bi.use.TraceTask
    public TraceFullTask setFt(String str) {
        this.ft = str;
        return this;
    }

    @Override // com.kugou.datacollect.bi.use.TraceTask
    public TraceFullTask setStatus(String str) {
        this.status = str;
        return this;
    }

    @Override // com.kugou.datacollect.bi.use.TraceTask
    public TraceFullTask setSty(String str) {
        this.sty = str;
        return this;
    }

    @Override // com.kugou.datacollect.bi.use.TraceTask
    public TraceFullTask setType(String str) {
        this.type = str;
        return this;
    }
}
