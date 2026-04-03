package com.kugou.common.startAppAPM.task;

import android.text.TextUtils;
import com.kugou.android.watch.lite.common.music.entity.KGMusic;
import com.kugou.common.apm.task.FavMusicAPM;
import com.kugou.common.apm.task.FavPageAPM;
import com.kugou.common.apm.task.LoginRcmAPM;
import com.kugou.common.apm.task.StartAppAPM;
import com.kugou.common.apm.task.VipEntryAPM;
import e.c.a.g.a.f.e.b;
import e.c.a.g.a.f.e.c;
import f.s;
import f.z.d.j;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class ApmReportHelper {
    private static FavPageAPM favPageAPM;
    private static LoginRcmAPM loginRcmAPM;
    private static StartAppAPM startAppAPM;
    private static VipEntryAPM vipEntryAPM;
    public static final ApmReportHelper INSTANCE = new ApmReportHelper();
    private static final Object playApmLock = new Object();
    private static final Map<String, FavMusicAPM> mFavAPMs = new ConcurrentHashMap();

    private ApmReportHelper() {
    }

    public final void clearLoginRcmAPMAPM() {
        loginRcmAPM = null;
    }

    public boolean enablePicReport() {
        return c.a.a().getConfigAsInt(b.k0, 1) == 1;
    }

    public final void failFavAPM(String str, Integer num, String str2) {
        FavMusicAPM favMusicAPMRemove;
        if (TextUtils.isEmpty(str) || (favMusicAPMRemove = mFavAPMs.remove(str)) == null) {
            return;
        }
        favMusicAPMRemove.fail(num, str2);
    }

    public final void failFavPageAPM(Integer num, String str) {
        FavPageAPM favPageAPM2 = favPageAPM;
        if (favPageAPM2 != null) {
            j.c(favPageAPM2);
            favPageAPM2.fail(num, str);
            favPageAPM = null;
        }
    }

    public final void failLoginRcmAPMAPM(Integer num, Integer num2, String str, Integer num3) {
        LoginRcmAPM loginRcmAPM2 = loginRcmAPM;
        if (loginRcmAPM2 != null) {
            j.c(loginRcmAPM2);
            loginRcmAPM2.fail(num, num2, str, num3);
            loginRcmAPM = null;
        }
    }

    public final void failVipEntryAPM(Integer num, String str) {
        VipEntryAPM vipEntryAPM2 = vipEntryAPM;
        if (vipEntryAPM2 != null) {
            j.c(vipEntryAPM2);
            vipEntryAPM2.fail(num, str);
            vipEntryAPM = null;
        }
    }

    public final void favPageAPMSuccess(String str) {
        synchronized (playApmLock) {
            FavPageAPM favPageAPM2 = favPageAPM;
            if (favPageAPM2 != null) {
                j.c(favPageAPM2);
                favPageAPM2.success(str);
                favPageAPM = null;
            }
            s sVar = s.a;
        }
    }

    public final String getJsonErrorMsg(List<? extends KGMusic> list, String str) {
        if (list == null || list.size() == 0) {
            if (TextUtils.isEmpty(str)) {
                return "errorMsg";
            }
            j.c(str);
            return str;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("errormsg", str);
            KGMusic kGMusic = list.get(0);
            if (kGMusic != null) {
                jSONObject.put("hash", kGMusic.getHashValue());
                jSONObject.put("mixid", kGMusic.getMixId());
                jSONObject.put("displayname", kGMusic.getDisplayName());
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        String string = jSONObject.toString();
        j.d(string, "json.toString()");
        return string;
    }

    public final String getUUiqueKey(KGMusic kGMusic, Boolean bool) {
        String strL;
        if (kGMusic == null) {
            return j.l("music_", j.a(bool, Boolean.TRUE) ? "1" : "0");
        }
        long j = kGMusic.mixId;
        if (j == 0) {
            strL = kGMusic.displayName;
            j.d(strL, "music?.displayName");
        } else {
            strL = j.l("", Long.valueOf(j));
        }
        if (TextUtils.isEmpty(strL)) {
            return j.l("music_", j.a(bool, Boolean.TRUE) ? "1" : "0");
        }
        StringBuilder sb = new StringBuilder();
        sb.append(strL);
        sb.append('_');
        sb.append(j.a(bool, Boolean.TRUE) ? "1" : "0");
        return sb.toString();
    }

    public final void loginLoginRcmAPMSuccess(String str, Integer num) {
        synchronized (playApmLock) {
            LoginRcmAPM loginRcmAPM2 = loginRcmAPM;
            if (loginRcmAPM2 != null) {
                j.c(loginRcmAPM2);
                loginRcmAPM2.success(str, num);
                loginRcmAPM = null;
            }
            s sVar = s.a;
        }
    }

    public final void netFinishFavPageAPMLoadTime() {
        FavPageAPM favPageAPM2 = favPageAPM;
        if (favPageAPM2 == null) {
            return;
        }
        favPageAPM2.netFinish();
    }

    public final void netFinishLoginRcmAPMLoadTime() {
        LoginRcmAPM loginRcmAPM2 = loginRcmAPM;
        if (loginRcmAPM2 == null) {
            return;
        }
        loginRcmAPM2.netFinish();
    }

    public final void netStartApmLoadTime() {
        StartAppAPM startAppAPM2 = startAppAPM;
        if (startAppAPM2 == null) {
            return;
        }
        startAppAPM2.netLoadTime();
    }

    public final void startAppSuccess() {
        synchronized (playApmLock) {
            StartAppAPM startAppAPM2 = startAppAPM;
            if (startAppAPM2 != null) {
                j.c(startAppAPM2);
                startAppAPM2.success();
                startAppAPM = null;
            }
            s sVar = s.a;
        }
    }

    public final void startFavAPM(String str) {
        j.e(str, "uniqueKey");
        Map<String, FavMusicAPM> map = mFavAPMs;
        FavMusicAPM favMusicAPMRemove = map.remove(str);
        if (favMusicAPMRemove != null) {
            favMusicAPMRemove.release();
        }
        FavMusicAPM favMusicAPM = new FavMusicAPM();
        favMusicAPM.start();
        map.put(str, favMusicAPM);
    }

    public final void startFavPageAPM() {
        FavPageAPM favPageAPM2 = favPageAPM;
        if (favPageAPM2 != null) {
            j.c(favPageAPM2);
            favPageAPM2.release();
        }
        FavPageAPM favPageAPM3 = new FavPageAPM();
        favPageAPM = favPageAPM3;
        j.c(favPageAPM3);
        favPageAPM3.start();
    }

    public final void startLoginRcmAPM() {
        LoginRcmAPM loginRcmAPM2 = loginRcmAPM;
        if (loginRcmAPM2 != null) {
            j.c(loginRcmAPM2);
            loginRcmAPM2.release();
        }
        LoginRcmAPM loginRcmAPM3 = new LoginRcmAPM();
        loginRcmAPM = loginRcmAPM3;
        j.c(loginRcmAPM3);
        loginRcmAPM3.start();
    }

    public final void startPlayApm() {
        synchronized (playApmLock) {
            StartAppAPM startAppAPM2 = startAppAPM;
            if (startAppAPM2 != null) {
                j.c(startAppAPM2);
                startAppAPM2.release();
            }
            StartAppAPM startAppAPM3 = new StartAppAPM();
            startAppAPM = startAppAPM3;
            j.c(startAppAPM3);
            startAppAPM3.start();
            s sVar = s.a;
        }
    }

    public final void startVipEntryAPM() {
        VipEntryAPM vipEntryAPM2 = vipEntryAPM;
        if (vipEntryAPM2 != null) {
            j.c(vipEntryAPM2);
            vipEntryAPM2.release();
        }
        VipEntryAPM vipEntryAPM3 = new VipEntryAPM();
        vipEntryAPM = vipEntryAPM3;
        j.c(vipEntryAPM3);
        vipEntryAPM3.start();
    }

    public final void successFavAPM(String str, Boolean bool) {
        FavMusicAPM favMusicAPMRemove;
        if (TextUtils.isEmpty(str) || (favMusicAPMRemove = mFavAPMs.remove(str)) == null) {
            return;
        }
        favMusicAPMRemove.netFinish();
        favMusicAPMRemove.success(bool);
    }

    public final void uiFavPageAPMoadTime() {
        FavPageAPM favPageAPM2 = favPageAPM;
        if (favPageAPM2 == null) {
            return;
        }
        favPageAPM2.uiLoadTime();
    }

    public final void uiStartApmLoadTime() {
        StartAppAPM startAppAPM2 = startAppAPM;
        if (startAppAPM2 == null) {
            return;
        }
        startAppAPM2.uiLoadTime();
    }

    public final void uiloginLoginRcmAPMLoadTime() {
        LoginRcmAPM loginRcmAPM2 = loginRcmAPM;
        if (loginRcmAPM2 == null) {
            return;
        }
        loginRcmAPM2.uiLoadTime();
    }

    public final void vipEntryAPMSuccess(String str) {
        VipEntryAPM vipEntryAPM2 = vipEntryAPM;
        if (vipEntryAPM2 != null) {
            j.c(vipEntryAPM2);
            vipEntryAPM2.success(str);
            vipEntryAPM = null;
        }
    }

    public final String getJsonErrorMsg(KGMusic kGMusic, String str) {
        if (kGMusic == null) {
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            j.c(str);
            return str;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("hash", kGMusic.getHashValue());
            jSONObject.put("mixid", kGMusic.getMixId());
            jSONObject.put("displayname", kGMusic.getDisplayName());
            jSONObject.put("errormsg", str);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        String string = jSONObject.toString();
        j.d(string, "json.toString()");
        return string;
    }
}
