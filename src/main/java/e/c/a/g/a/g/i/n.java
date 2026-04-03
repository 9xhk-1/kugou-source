package e.c.a.g.a.g.i;

import android.text.TextUtils;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import com.kugou.android.watch.lite.base.uistructure.PageKey;
import com.kugou.common.apm.task.FavSongThreadAPM;
import com.kugou.common.network.ResponseTypeChecker;
import com.kugou.common.network.protocol.AbstractRequestPackage;
import e.c.a.g.a.s.g0;
import e.c.a.g.a.s.h1;
import e.c.a.g.a.s.j0;
import e.c.a.g.a.s.r0;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.entity.StringEntity;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class n {
    public long a;
    public int b;
    public int c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f864d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f865e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public StringBuffer f866f;

    public class a implements Runnable {
        public final /* synthetic */ AtomicInteger a;
        public final /* synthetic */ int b;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ PageKey f867d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ boolean f868f;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ List f869h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final /* synthetic */ CountDownLatch f870i;

        public a(AtomicInteger atomicInteger, int i2, PageKey pageKey, boolean z, List list, CountDownLatch countDownLatch) {
            this.a = atomicInteger;
            this.b = i2;
            this.f867d = pageKey;
            this.f868f = z;
            this.f869h = list;
            this.f870i = countDownLatch;
        }

        @Override // java.lang.Runnable
        public void run() {
            while (true) {
                int iIncrementAndGet = this.a.incrementAndGet();
                int i2 = this.b;
                if (iIncrementAndGet > i2) {
                    return;
                }
                n.this.i(this.f867d, this.f868f, iIncrementAndGet, this.f869h, i2);
                this.f870i.countDown();
            }
        }
    }

    public class b extends AbstractRequestPackage {
        public final PageKey b;
        public String a = "";
        public int c = 1;

        public b(PageKey pageKey) {
            this.b = pageKey;
        }

        public final void b() {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("userid", e.c.a.g.a.r.b.o());
                jSONObject.put("token", e.c.a.g.a.r.b.n());
                jSONObject.put("listid", n.this.b);
                jSONObject.put("type", n.this.f864d);
                jSONObject.put("page", this.c);
                jSONObject.put("pagesize", 300);
                jSONObject.put("area_code", e.c.a.g.a.r.b.c());
                e.c.a.g.a.r.g.c.v(jSONObject, this.b);
                jSONObject.put("allplatform", 1);
                jSONObject.put("show_cover", 1);
                this.a = jSONObject.toString();
            } catch (Exception e2) {
                if (g0.f()) {
                    g0.k(e2);
                }
            }
        }

        public void c() {
            this.c++;
        }

        @Override // com.kugou.common.network.protocol.AbstractRequestPackage, com.kugou.common.network.protocol.RequestPackage
        public String getGetRequestParams() {
            this.mParams = e.c.a.g.a.f.k.f.a.f(null, this.a);
            return super.getGetRequestParams();
        }

        @Override // com.kugou.common.network.protocol.RequestPackage
        public HttpEntity getPostRequestEntity() {
            try {
                b();
                return new StringEntity(this.a);
            } catch (UnsupportedEncodingException e2) {
                e2.printStackTrace();
                return null;
            }
        }

        @Override // com.kugou.common.network.protocol.RequestPackage
        public String getRequestModuleName() {
            return "CloudMusic";
        }

        @Override // com.kugou.common.network.protocol.RequestPackage
        public String getRequestType() {
            return "POST";
        }

        @Override // com.kugou.common.network.protocol.RequestPackage
        public String getUrl() {
            return e.c.a.g.a.f.e.c.c().getConfig(e.c.a.g.a.f.e.b.e1);
        }
    }

    public class c extends i<q> {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f872e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f873f;

        public c(n nVar, boolean z) {
            super("", "");
            this.f872e = null;
            this.f873f = z;
        }

        @Override // e.c.a.g.a.r.e.a, com.kugou.common.network.protocol.ResponsePackage
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public void getResponseData(q qVar) {
            String str;
            int iOptInt;
            short s;
            String str2;
            int iOptInt2;
            int i2;
            int iOptInt3;
            int iOptInt4;
            JSONObject jSONObject;
            String str3 = "name";
            this.f851d = false;
            qVar.n(false);
            qVar.o((short) 0);
            try {
                if (g0.a) {
                    g0.c("wwhSync", "get ListFile data :" + this.f872e);
                }
                if (this.f872e == null) {
                    return;
                }
                JSONObject jSONObject2 = new JSONObject(this.f872e);
                if (g0.a) {
                    g0.b("zhpu_cloud", "getlist： " + this.f872e);
                }
                int i3 = 1;
                if (jSONObject2.optInt(NotificationCompat.CATEGORY_STATUS) != 1) {
                    qVar.l(String.valueOf(jSONObject2.optInt("error_code")));
                    return;
                }
                JSONObject jSONObject3 = jSONObject2.getJSONObject("data");
                qVar.o((short) 144);
                qVar.t(jSONObject3.getLong("userid"));
                qVar.s(jSONObject3.getInt("listid"));
                qVar.q(jSONObject3.getInt("count"));
                qVar.p(jSONObject3.getInt("list_ver"));
                JSONArray jSONArrayOptJSONArray = jSONObject3.optJSONArray("info");
                if (jSONArrayOptJSONArray == null) {
                    return;
                }
                int length = jSONArrayOptJSONArray.length();
                int i4 = 0;
                while (i4 < length) {
                    JSONObject jSONObject4 = jSONArrayOptJSONArray.getJSONObject(i4);
                    if (g0.a) {
                        g0.e("young-hqd", "ListFilesResponse getResponseData:info=" + jSONObject4.toString());
                    }
                    int i5 = jSONObject4.getInt("fileid");
                    String string = jSONObject4.getString(str3);
                    int i6 = jSONObject4.getInt("size");
                    int i7 = jSONObject4.getInt("timelen");
                    short s2 = (short) jSONObject4.getInt("bitrate");
                    int i8 = jSONObject4.getInt("sort");
                    boolean z = jSONObject4.optInt("csong") == i3;
                    String strOptString = jSONObject4.optString("mvhash");
                    int iOptInt5 = jSONObject4.optInt("mvtrack");
                    int iOptInt6 = jSONObject4.optInt("mvtype");
                    JSONObject jSONObjectOptJSONObject = jSONObject4.optJSONObject("albuminfo");
                    if (jSONObjectOptJSONObject != null) {
                        String strOptString2 = jSONObjectOptJSONObject.optString(str3);
                        iOptInt = jSONObjectOptJSONObject.optInt("category", -1);
                        str = strOptString2;
                    } else {
                        str = "";
                        iOptInt = -1;
                    }
                    String string2 = jSONObject4.getString("hash");
                    String strOptString3 = jSONObject4.optString("album_id");
                    JSONArray jSONArray = jSONArrayOptJSONArray;
                    long jOptLong = jSONObject4.optLong("mixsongid", 0L);
                    long jOptLong2 = jSONObject4.optLong("collecttime");
                    int i9 = e.c.a.g.a.f.j.b.h.b;
                    if (this.f873f) {
                        String strOptString4 = jSONObject4.optString("media_type");
                        int iOptInt7 = jSONObject4.optInt("media_privilege", e.c.a.g.a.f.j.b.h.b);
                        str2 = strOptString4;
                        int iOptInt8 = jSONObject4.optInt("media_pay_type", 0);
                        s = s2;
                        int iOptInt9 = jSONObject4.optInt("media_fail_process", 0);
                        iOptInt2 = jSONObject4.optInt("media_old_cpy", -1);
                        iOptInt3 = iOptInt9;
                        i2 = iOptInt7;
                        iOptInt4 = iOptInt8;
                    } else {
                        s = s2;
                        String strOptString5 = jSONObject4.optString("medistype");
                        int iOptInt10 = jSONObject4.optInt("media_old_cpy", -1);
                        JSONArray jSONArrayOptJSONArray2 = jSONObject4.optJSONArray("download");
                        if (jSONArrayOptJSONArray2 == null || jSONArrayOptJSONArray2.length() <= 0 || (jSONObject = jSONArrayOptJSONArray2.getJSONObject(0)) == null) {
                            int i10 = i9;
                            str2 = strOptString5;
                            iOptInt2 = iOptInt10;
                            i2 = i10;
                            iOptInt3 = 0;
                            iOptInt4 = 0;
                        } else {
                            iOptInt4 = jSONObject.optInt("pay_type", 0);
                            str2 = strOptString5;
                            iOptInt2 = iOptInt10;
                            i2 = i9;
                            iOptInt3 = jSONObject.optInt("fail_process", 0);
                        }
                    }
                    qVar.b(0, i5, string2, i7, i6, i8, s, string, 0, strOptString, iOptInt5, iOptInt6, strOptString3, jOptLong, iOptInt4, iOptInt3, str2, i2, iOptInt2, jOptLong2, z, r0.d(jSONObject4), str, iOptInt);
                    i4++;
                    length = length;
                    jSONArrayOptJSONArray = jSONArray;
                    str3 = str3;
                    i3 = 1;
                }
                this.f851d = true;
                qVar.n(true);
            } catch (Exception e2) {
                g0.k(e2);
            }
        }

        @Override // e.c.a.g.a.r.e.a, com.kugou.common.network.protocol.ResponsePackage
        public ResponseTypeChecker.ResponseType getResponseType() {
            return ResponseTypeChecker.ResponseType.NOT_EMPTY;
        }

        @Override // e.c.a.g.a.r.e.a, com.kugou.common.network.AbsHttpClient.IHttpException
        public void onContentException(int i2, String str, int i3, byte[] bArr) {
        }

        @Override // e.c.a.g.a.r.e.a, com.kugou.common.network.AbsHttpClient.IHttpException
        public void onHeaderException(int i2, String str, int i3, Header[] headerArr) {
        }

        @Override // e.c.a.g.a.r.e.a, com.kugou.common.network.protocol.ResponsePackage
        public void setContext(byte[] bArr) {
            try {
                this.f872e = new String(bArr);
            } catch (Exception e2) {
                g0.k(e2);
            }
            Log.e("mydebug", "music list size is : " + (bArr.length / 1024));
        }
    }

    public n(long j, int i2, int i3, int i4, int i5) {
        this.f865e = e.c.a.g.a.f.e.c.c().getConfigAsInt(e.c.a.g.a.f.e.b.j0, 0) == 1;
        this.f866f = new StringBuffer();
        this.a = j;
        this.b = i2;
        this.c = i3;
        this.f864d = i5;
    }

    public q d(PageKey pageKey) {
        if (g0.a) {
            g0.c("BLUE", "getFile called " + this.b + ", " + this.c);
        }
        System.currentTimeMillis();
        b bVar = new b(pageKey);
        c cVar = new c(this, this.a == e.c.a.g.a.r.b.o());
        q qVar = new q();
        try {
            e.c.a.g.a.f.k.k.e eVarA = e.c.a.g.a.f.k.k.e.a();
            eVarA.request(bVar, cVar);
            cVar.getResponseData(qVar);
            while (qVar.g() > qVar.h().size()) {
                bVar.c();
                eVarA = e.c.a.g.a.f.k.k.e.a();
                eVarA.request(bVar, cVar);
                cVar.getResponseData(qVar);
                if (!cVar.b()) {
                    break;
                }
            }
            eVarA.getRequestDelay();
            return qVar;
        } catch (Exception e2) {
            g0.k(e2);
            return qVar;
        }
    }

    public q e(PageKey pageKey, int i2, FavSongThreadAPM favSongThreadAPM) {
        boolean z;
        int i3;
        boolean z2 = this.a == e.c.a.g.a.r.b.o();
        CopyOnWriteArrayList<q> copyOnWriteArrayList = new CopyOnWriteArrayList();
        int i4 = i2 % 300 == 0 ? i2 / 300 : (i2 / 300) + 1;
        CountDownLatch countDownLatch = new CountDownLatch(i4);
        int[] iArrF = f();
        int iMin = Math.min(e.c.a.g.a.s.m.m() ? iArrF[0] : iArrF[1], i4);
        AtomicInteger atomicInteger = new AtomicInteger(0);
        if (g0.a) {
            g0.b("GetFile", "getCloudMusicListFilesConcurrency: page=" + i4 + "  thread:" + iMin + ", songCount = " + i2);
        }
        int i5 = 0;
        while (i5 < iMin) {
            j0.b().a(new a(atomicInteger, i4, pageKey, z2, copyOnWriteArrayList, countDownLatch));
            i5++;
            atomicInteger = atomicInteger;
            iMin = iMin;
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException unused) {
        }
        h();
        q qVar = new q();
        qVar.n(true);
        qVar.o((short) 144);
        qVar.r(new ArrayList<>(i2));
        q qVar2 = null;
        boolean z3 = false;
        boolean z4 = true;
        for (q qVar3 : copyOnWriteArrayList) {
            if (g0.f() && qVar3 != null && qVar3.h() != null) {
                Log.e("mhs_watch_fav", "api result = " + qVar3.h().size() + ", data.getmListFileCount()) = " + qVar3.g() + ", data.getmListFMVersion() =" + qVar3.f() + ", data.isSucceed() = " + qVar3.k());
            }
            if (qVar3.k()) {
                qVar.t(qVar3.j());
                qVar.s(qVar3.i());
                qVar.q(qVar3.g());
                qVar.p(qVar3.f());
                qVar.a(qVar3.h());
                z3 = true;
            } else {
                qVar2 = qVar3;
                z4 = false;
            }
        }
        boolean z5 = this.f865e;
        if ((z5 && !z3) || (!z5 && !z4)) {
            qVar.n(false);
            qVar.o((short) 0);
            if (qVar2 != null) {
                try {
                    i3 = Integer.parseInt(qVar2.c());
                    z = true;
                } catch (Exception unused2) {
                    z = true;
                    i3 = 0;
                }
                qVar2.k = z;
                favSongThreadAPM.fail(54, ", 第三个接口，同步歌单数据部分错误 = " + qVar2, Integer.valueOf(i3));
            }
        }
        if (g0.f()) {
            Log.e("mhs_watch_fav", "api result, isSucceed = " + z4 + ", hasPartSuccess = " + z3);
        }
        return qVar;
    }

    public final int[] f() {
        int iMax;
        String config = e.c.a.g.a.f.e.c.c().getConfig(e.c.a.g.a.f.e.b.T3);
        int iMax2 = 3;
        if (TextUtils.isEmpty(config)) {
            iMax = 2;
        } else {
            try {
                String[] strArrT = h1.t(config, "_");
                iMax = Math.max(1, Integer.parseInt(strArrT[0]));
                try {
                    iMax2 = Math.max(1, Integer.parseInt(strArrT[1]));
                } catch (Exception unused) {
                }
            } catch (Exception unused2) {
                iMax = 2;
            }
        }
        return new int[]{iMax, iMax2};
    }

    public final void g(PageKey pageKey, boolean z, int i2, int i3, int i4, boolean z2) {
        try {
            if (z2) {
                this.f866f.append("success\n");
            } else {
                this.f866f.append("fail\n");
            }
            if (pageKey != null) {
                StringBuffer stringBuffer = this.f866f;
                stringBuffer.append("pageKey=");
                stringBuffer.append(pageKey.toJson());
            }
            StringBuffer stringBuffer2 = this.f866f;
            stringBuffer2.append("&pageNumber=");
            stringBuffer2.append(i2);
            stringBuffer2.append("&retryCount=");
            stringBuffer2.append(i4);
            stringBuffer2.append("&totalPage=");
            stringBuffer2.append(i3);
            stringBuffer2.append("&isMySelf=");
            stringBuffer2.append(z);
            stringBuffer2.append("\n");
            if (this.f866f.length() > 700) {
                e.c.a.g.a.g.f.c.a.s(this.f866f.toString(), "");
                this.f866f = new StringBuffer();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void h() {
        try {
            StringBuffer stringBuffer = this.f866f;
            if (stringBuffer != null && stringBuffer.length() > 0) {
                e.c.a.g.a.g.f.c.a.s(this.f866f.toString(), "");
            }
            this.f866f = new StringBuffer();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void i(PageKey pageKey, boolean z, int i2, List<q> list, int i3) {
        boolean z2 = true;
        int i4 = 1;
        while (true) {
            if (i4 > 3) {
                z2 = false;
                break;
            }
            try {
                b bVar = new b(pageKey);
                c cVar = new c(this, z);
                bVar.c = i2;
                e.c.a.g.a.f.k.k.e.a().request(bVar, cVar);
                q qVar = new q();
                cVar.getResponseData(qVar);
                if (qVar.k()) {
                    list.add(qVar);
                    break;
                }
                continue;
            } catch (Exception e2) {
                g0.k(e2);
            }
            i4++;
        }
        if (!z2) {
            e.c.a.g.a.f.m.b.m().Q(3);
            q qVar2 = new q();
            qVar2.n(false);
            list.add(qVar2);
        }
        g(pageKey, z, i2, i3, 3, z2);
        Log.e("mhs_watch_fav", "requestByPage, apiAskStatus = " + ((Object) this.f866f) + ", isSucceed = " + z2);
    }
}
