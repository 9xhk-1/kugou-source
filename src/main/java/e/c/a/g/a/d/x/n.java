package e.c.a.g.a.d.x;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.kugou.android.watch.lite.base.musicfees.mediastore.entity.HashOffset;
import com.kugou.android.watch.lite.base.player.entity.CommNetSongUrlInfo;
import com.kugou.android.watch.lite.base.player.entity.NetSongUrlResponse;
import com.kugou.android.watch.lite.base.player.entity.UrlRequesterInfo;
import com.kugou.android.watch.lite.common.music.entity.SongQuality;
import com.kugou.common.filemanager.downloadengine.TrackerExtraParam;
import com.kugou.common.network.AbsHttpClient;
import com.kugou.common.network.ExceptionParse;
import com.kugou.common.network.KugouNetException;
import e.c.a.g.a.s.g0;
import e.c.a.g.a.s.l1;
import e.c.a.g.a.s.q0;
import e.c.a.g.a.s.u0;
import java.util.Hashtable;
import org.apache.http.HttpStatus;
import org.apache.http.cookie.ClientCookie;

/* JADX INFO: loaded from: classes.dex */
public class n {

    @NonNull
    public final UrlRequesterInfo a;

    public static class b implements AbsHttpClient.IRequestUrlReceiver {
        public String a;

        public b() {
        }

        @Override // com.kugou.common.network.AbsHttpClient.IRequestUrlReceiver
        public String getRequestUrl(String str) {
            return !TextUtils.isEmpty(this.a) ? this.a : str;
        }

        @Override // com.kugou.common.network.AbsHttpClient.IRequestUrlReceiver
        public void onHttpGet(String str) {
            this.a = str;
        }

        @Override // com.kugou.common.network.AbsHttpClient.IRequestUrlReceiver
        public void onHttpPost(String str) {
            this.a = str;
        }

        @Override // com.kugou.common.network.AbsHttpClient.IRequestUrlReceiver
        public void onUrlState(String str, boolean z) {
        }
    }

    public n(@NonNull UrlRequesterInfo urlRequesterInfo) {
        this.a = urlRequesterInfo;
    }

    public static int d(int i2, boolean z) {
        return z ? i2 == SongQuality.QUALITY_LOW.getType() ? 22 : 26 : i2 == SongQuality.QUALITY_LOW.getType() ? 21 : 25;
    }

    public static boolean h(int i2) {
        return i2 == 22 || i2 == 24 || i2 == 26;
    }

    public final CommNetSongUrlInfo a() {
        if (g0.a) {
            StringBuilder sb = new StringBuilder();
            sb.append("试听片段兼容 _getUrl pagekey is null:");
            sb.append(this.a.pageKey == null);
            sb.append(", mInfo = ");
            sb.append(this.a);
            g0.b("siganid-pagekey", sb.toString());
        }
        UrlRequesterInfo urlRequesterInfo = this.a;
        if (urlRequesterInfo.isListenPart) {
            if (g0.a) {
                g0.b("zhpu_track", "charge isListenPart");
            }
            this.a.trackerType = 3;
            return c(true);
        }
        if (urlRequesterInfo.feeOption.b) {
            if (g0.a) {
                g0.b("zhpu_track", "charge ");
            }
            this.a.trackerType = 3;
            return c(false);
        }
        if (g0.a) {
            g0.b("zhpu_track", "free ");
        }
        this.a.trackerType = 4;
        return f(true);
    }

    public final Hashtable<String, Object> b(boolean z) {
        String str;
        String str2;
        TrackerExtraParam.CommonAuth commonAuth;
        e.c.a.g.a.d.x.q.a aVar = this.a.feeOption;
        if (aVar == null || (str = aVar.c) == null) {
            str = "";
        }
        Hashtable<String, Object> hashtable = new Hashtable<>();
        int iD = d(this.a.quality, true);
        int iF = l1.f();
        String strN = l1.n(e.c.c.o.f.a());
        int iG = l1.G();
        int iZ = e.c.a.g.a.r.b.z();
        String strN2 = e.c.a.g.a.r.b.n();
        long jO = e.c.a.g.a.r.b.o();
        hashtable.put("cmd", Integer.valueOf(iD));
        hashtable.put("hash", this.a.getHash());
        if (h(iD)) {
            hashtable.put("mtype", Integer.valueOf(e.c.a.g.a.r.b.i()));
        }
        if (g0.g()) {
            hashtable.put("ssl", 1);
        }
        String config = e.c.a.g.a.f.e.c.c().getConfig(e.c.a.g.a.f.e.b.f643e);
        String config2 = e.c.a.g.a.f.e.c.c().getConfig(e.c.a.g.a.f.e.b.f644f);
        if (TextUtils.isEmpty(config) || TextUtils.isEmpty(config2)) {
            hashtable.put("key", new q0().e(this.a.getHash() + "kgcloudv2" + iF + strN + jO));
        } else {
            hashtable.put("pidversion", config);
            hashtable.put("key", new q0().e(this.a.getHash() + config2 + iF + strN + jO));
        }
        hashtable.put("pid", Integer.valueOf(HttpStatus.SC_LENGTH_REQUIRED));
        hashtable.put("appid", Integer.valueOf(iF));
        hashtable.put("mid", strN);
        hashtable.put(ClientCookie.VERSION_ATTR, Integer.valueOf(iG));
        hashtable.put("token", strN2);
        hashtable.put("vipType", Integer.valueOf(iZ));
        hashtable.put("userid", Long.valueOf(jO));
        e.c.a.g.a.r.g.c.u(hashtable, this.a.pageKey);
        if (jO > 0) {
            hashtable.put("ptype", Integer.valueOf(e.c.a.g.a.d.r.a.c().d(jO)));
        } else {
            hashtable.put("ptype", 0);
        }
        e.c.a.g.a.d.x.q.a aVar2 = this.a.feeOption;
        if (aVar2 == null || (str2 = aVar2.a) == null) {
            str2 = "play";
        }
        hashtable.put("behavior", str2);
        if (!TextUtils.isEmpty(str)) {
            hashtable.put("album_id", str);
        }
        hashtable.put("area_code", e.c.a.g.a.r.b.c());
        e.c.a.g.a.d.x.q.a aVar3 = this.a.feeOption;
        hashtable.put("album_audio_id", Long.valueOf(aVar3 != null ? aVar3.f578d : 0L));
        if (z) {
            hashtable.put("IsFreePart", 1);
        } else {
            TrackerExtraParam trackerExtraParam = this.a.extraParam;
            if (trackerExtraParam != null && (commonAuth = trackerExtraParam.commonAuth) != null) {
                hashtable.put("auth", commonAuth.auth);
                hashtable.put("module_id", Integer.valueOf(commonAuth.moduleId));
                hashtable.put("open_time", commonAuth.openTime);
            }
        }
        hashtable.put("dfid", e.c.a.g.a.s.m.e());
        e.c.a.g.a.r.g.c.a(hashtable, null);
        return hashtable;
    }

    public CommNetSongUrlInfo c(boolean z) {
        HashOffset hashOffset;
        Hashtable<String, Object> hashtableB = b(z);
        if (g0.a) {
            g0.c("wwhLogDM", "getChargeUrl album_audio_id :" + hashtableB.get("album_audio_id"));
        }
        UrlRequesterInfo urlRequesterInfo = this.a;
        e.c.a.g.a.d.x.u.a aVar = new e.c.a.g.a.d.x.u.a(urlRequesterInfo.silent, urlRequesterInfo.isUGC, urlRequesterInfo.doNotCheckIP);
        aVar.setParams(hashtableB);
        NetSongUrlResponse netSongUrlResponse = new NetSongUrlResponse();
        b bVar = new b();
        e.c.a.g.a.d.x.u.b bVar2 = new e.c.a.g.a.d.x.u.b();
        e.c.a.g.a.f.k.k.e eVarA = e.c.a.g.a.f.k.k.e.a();
        try {
            eVarA.setRequestUrlReceiver(bVar);
            eVarA.request(aVar, bVar2);
            bVar2.getResponseData(netSongUrlResponse);
            CommNetSongUrlInfo netSongUrl = netSongUrlResponse.getNetSongUrl();
            if (netSongUrl == null) {
                netSongUrl = new CommNetSongUrlInfo();
                netSongUrl.setErrorJson(netSongUrlResponse.getRespStr());
                netSongUrl.setRequestUrl(aVar.getLastVisitUrl() + aVar.getGetRequestParams());
                netSongUrl.setErrorType(netSongUrlResponse.getErrorType());
                netSongUrl.setErrorMessage(netSongUrlResponse.getErrorMessage());
            } else if (netSongUrl.isUseful() && z && (hashOffset = netSongUrl.getHashOffset()) != null) {
                netSongUrl.setFileSize(((int) (hashOffset.end_byte - hashOffset.start_byte)) + 1);
            }
            netSongUrl.setHash(this.a.getHash());
            netSongUrl.setOriginErrIdentify(netSongUrlResponse.getOriginErrIdentify());
            netSongUrl.setFailProcess(netSongUrlResponse.getFailProcess());
            return netSongUrl;
        } catch (Exception e2) {
            g0.k(e2);
            CommNetSongUrlInfo commNetSongUrlInfoI = i(e2, aVar.getLastVisitUrl() + aVar.getGetRequestParams());
            UrlRequesterInfo urlRequesterInfo2 = this.a;
            if (urlRequesterInfo2.quality != 0) {
                commNetSongUrlInfoI.setHash(urlRequesterInfo2.getHash());
            }
            return commNetSongUrlInfoI;
        }
    }

    public final Hashtable<String, Object> e() {
        String str;
        Hashtable<String, Object> hashtable = new Hashtable<>();
        int iD = d(this.a.quality, false);
        int iG = l1.G();
        hashtable.put("cmd", Integer.valueOf(iD));
        hashtable.put("hash", this.a.getHash());
        String config = e.c.a.g.a.f.e.c.c().getConfig(e.c.a.g.a.f.e.b.f643e);
        String config2 = e.c.a.g.a.f.e.c.c().getConfig(e.c.a.g.a.f.e.b.f644f);
        if (TextUtils.isEmpty(config) || TextUtils.isEmpty(config2)) {
            hashtable.put("key", new q0().e(this.a.getHash() + "kgcloudv2"));
        } else {
            hashtable.put("pidversion", config);
            hashtable.put("key", new q0().e(this.a.getHash() + config2));
        }
        hashtable.put("pid", Integer.valueOf(HttpStatus.SC_LENGTH_REQUIRED));
        hashtable.put("userid", Long.valueOf(e.c.a.g.a.r.b.o()));
        e.c.a.g.a.d.x.q.a aVar = this.a.feeOption;
        if (aVar == null || (str = aVar.a) == null) {
            str = "";
        }
        hashtable.put("behavior", str);
        hashtable.put("appid", Integer.valueOf(l1.f()));
        hashtable.put(ClientCookie.VERSION_ATTR, Integer.valueOf(iG));
        if (g0.g()) {
            hashtable.put("ssl", 1);
        }
        e.c.a.g.a.d.x.q.a aVar2 = this.a.feeOption;
        String str2 = aVar2 != null ? aVar2.c : "";
        if (!TextUtils.isEmpty(str2)) {
            hashtable.put("album_id", str2);
        }
        hashtable.put("area_code", e.c.a.g.a.r.b.c());
        e.c.a.g.a.d.x.q.a aVar3 = this.a.feeOption;
        hashtable.put("album_audio_id", Long.valueOf(aVar3 != null ? aVar3.f578d : 0L));
        hashtable.put("dfid", e.c.a.g.a.s.m.e());
        e.c.a.g.a.r.g.c.u(hashtable, this.a.pageKey);
        e.c.a.g.a.r.g.c.a(hashtable, null);
        return hashtable;
    }

    public CommNetSongUrlInfo f(boolean z) {
        Hashtable<String, Object> hashtableE = e();
        UrlRequesterInfo urlRequesterInfo = this.a;
        e.c.a.g.a.d.x.u.c cVar = new e.c.a.g.a.d.x.u.c(urlRequesterInfo.silent, urlRequesterInfo.isUGC, urlRequesterInfo.doNotCheckIP);
        cVar.setParams(hashtableE);
        NetSongUrlResponse netSongUrlResponse = new NetSongUrlResponse();
        b bVar = new b();
        e.c.a.g.a.d.x.u.d dVar = new e.c.a.g.a.d.x.u.d();
        e.c.a.g.a.f.k.k.e eVarA = e.c.a.g.a.f.k.k.e.a();
        try {
            eVarA.setRequestUrlReceiver(bVar);
            eVarA.request(cVar, dVar);
            dVar.getResponseData(netSongUrlResponse);
            CommNetSongUrlInfo netSongUrl = netSongUrlResponse.getNetSongUrl();
            if (netSongUrl == null && netSongUrlResponse.getErrorType() == 11 && z && e.c.a.g.a.r.b.o() > 0) {
                return c(false);
            }
            if (netSongUrl == null) {
                netSongUrl = new CommNetSongUrlInfo();
                netSongUrl.setErrorJson(netSongUrlResponse.getRespStr());
                netSongUrl.setRequestUrl(cVar.getLastVisitUrl() + cVar.getGetRequestParams());
                netSongUrl.setErrorType(netSongUrlResponse.getErrorType());
                netSongUrl.setErrorMessage(netSongUrlResponse.getErrorMessage());
            }
            netSongUrl.setOriginErrIdentify(netSongUrlResponse.getOriginErrIdentify());
            netSongUrl.setHash(this.a.getHash());
            netSongUrl.setFailProcess(netSongUrlResponse.getFailProcess());
            return netSongUrl;
        } catch (Exception e2) {
            g0.k(e2);
            CommNetSongUrlInfo commNetSongUrlInfoI = i(e2, cVar.getLastVisitUrl() + cVar.getGetRequestParams());
            UrlRequesterInfo urlRequesterInfo2 = this.a;
            if (urlRequesterInfo2.quality != 0) {
                commNetSongUrlInfoI.setHash(urlRequesterInfo2.getHash());
            }
            return commNetSongUrlInfoI;
        }
    }

    public CommNetSongUrlInfo g() {
        this.a.trackerType = 0;
        CommNetSongUrlInfo commNetSongUrlInfoA = a();
        if (g0.a && this.a.trackerType == 0) {
            throw new RuntimeException("must set trackerType in _getUrl()");
        }
        this.a.trackerType = 0;
        return commNetSongUrlInfoA;
    }

    public final CommNetSongUrlInfo i(Exception exc, String str) {
        CommNetSongUrlInfo commNetSongUrlInfo = new CommNetSongUrlInfo();
        commNetSongUrlInfo.setRequestUrl(str);
        int i2 = 6;
        int statusCode = 0;
        if (exc instanceof KugouNetException) {
            KugouNetException kugouNetException = (KugouNetException) exc;
            if (kugouNetException.getError() == 2) {
                i2 = 7;
            } else if (kugouNetException.getError() == 7) {
                statusCode = kugouNetException.getStatusCode();
            }
        } else if ((exc instanceof IllegalStateException) && "can not use kugou net service".equals(exc.getMessage())) {
            i2 = 10;
        }
        u0.B(29, "processException", "UrlRequester-errorType-" + i2, exc);
        commNetSongUrlInfo.setErrorType(i2);
        commNetSongUrlInfo.setNetEID(ExceptionParse.parseResultCode(exc));
        commNetSongUrlInfo.setErrorMessage(exc.toString());
        commNetSongUrlInfo.setStatusCode(statusCode);
        return commNetSongUrlInfo;
    }
}
