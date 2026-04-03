package e.c.a.g.a.r.e;

import android.content.Intent;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.kugou.android.watch.lite.bi.YoungBITask;
import com.kugou.android.watch.lite.user.login.LoginExtraEntity;
import com.kugou.android.watch.lite.user.login.UserData;
import e.c.a.g.a.s.g0;
import e.c.a.g.a.s.j0;
import e.c.a.g.a.s.l1;
import e.c.a.g.a.s.m;
import e.c.a.g.a.s.r1;
import e.c.a.g.a.s.t;
import e.c.c.o.i;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;

/* JADX INFO: loaded from: classes2.dex */
public class h {
    public static final String n = "h";
    public static Object o = new Object();
    public static boolean p;
    public String a;
    public String b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f1174d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f1176f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public LoginExtraEntity f1177g;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f1179i;
    public String j;
    public String k;
    public boolean l;
    public int c = -1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f1175e = 1;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f1178h = -1;
    public d m = null;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (g0.a) {
                g0.b(h.n, "start login");
            }
            h hVar = h.this;
            hVar.m(hVar.f1174d, h.this.a, h.this.f1176f, h.this.b);
            if (g0.a) {
                g0.b(h.n, "end login");
            }
        }
    }

    public interface b {
        @Headers({"retrofit_interceptor_ignore:true"})
        @POST
        Call<String> login(@QueryMap Map<String, String> map, @Body String str);
    }

    public interface c {
        void onLoginRefrash(int i2);
    }

    public interface d {
        void onLoginFailed(UserData userData, int i2);

        void onLoginRisk();

        void onLoginSucceed(UserData userData, int i2);
    }

    public static class e extends Converter.Factory {

        public class a implements Converter<ResponseBody, String> {
            public a(e eVar) {
            }

            @Override // retrofit2.Converter
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public String convert(ResponseBody responseBody) throws IOException {
                return responseBody.string();
            }
        }

        public class b implements Converter<String, RequestBody> {
            public b(e eVar) {
            }

            @Override // retrofit2.Converter
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public RequestBody convert(String str) throws IOException {
                return RequestBody.create(MediaType.get("application/json; charset=UTF-8"), str);
            }
        }

        public e() {
        }

        @Override // retrofit2.Converter.Factory
        public Converter<String, RequestBody> requestBodyConverter(Type type, Annotation[] annotationArr, Annotation[] annotationArr2, Retrofit retrofit) {
            return new b(this);
        }

        @Override // retrofit2.Converter.Factory
        public Converter<ResponseBody, String> responseBodyConverter(Type type, Annotation[] annotationArr, Retrofit retrofit) {
            return new a(this);
        }

        public /* synthetic */ e(a aVar) {
            this();
        }
    }

    public class f extends e.c.a.g.a.r.e.f {
        public String j;

        public f(String str) {
            super(true, true);
            this.j = "";
            this.j = str;
        }

        public String a() {
            try {
                i iVar = new i();
                this.a.put("dfid", m.e());
                this.a.put("plat", 1);
                if (h.this.f1175e == 2 || h.this.f1175e == 5) {
                    this.a.put("userid", h.this.f1176f);
                    HashMap map = new HashMap();
                    map.put("clienttime", Integer.valueOf(this.b));
                    map.put("token", h.this.b);
                    String strA = e.c.a.g.a.r.e.e.a(map);
                    this.a.put("p3", strA);
                    e.c.a.g.a.d.d0.a.a("mhs_watch_loginxlog", "p3=" + strA + ", clienttime  = " + this.b + ", mPassword = " + h.this.b + ", hash = " + map);
                } else if (h.this.f1175e == 1) {
                    this.a.put("username", e.c.a.g.a.r.e.b.a(h.this.a));
                    HashMap map2 = new HashMap();
                    map2.put("clienttime_ms", this.c);
                    map2.put("pwd", iVar.e(h.this.b));
                    String strB = e.c.a.g.a.r.e.e.b(map2);
                    this.a.put("p2", strB);
                    this.a.put("support_third", "3");
                    this.a.put("support_multi", 1);
                    this.a.put("support_verify", 1);
                    this.a.put("key", e.c.a.g.a.r.e.b.b(this.f1168d, this.f1169e, this.f1171g, String.valueOf(this.c)));
                    this.a.put("m_des", 1);
                    e.c.a.g.a.d.d0.a.a("mhs_watch_loginxlog", "p2=" + strB + ", map = " + this.a + ", hash = " + map2);
                } else if (h.this.f1175e == 4) {
                    this.a.put("mobile", h.this.f1179i);
                    HashMap map3 = new HashMap();
                    map3.put("clienttime_ms", this.c);
                    map3.put("code", h.this.j);
                    map3.put("mobile", h.this.f1179i);
                    if (h.this.f1177g != null && !TextUtils.isEmpty(h.this.f1177g.getSelectedUserID())) {
                        map3.put("userid", h.this.f1177g.getSelectedUserID());
                    }
                    if (h.this.f1177g != null && !TextUtils.isEmpty(h.this.f1177g.getVerifyUserID())) {
                        this.a.put("to_verify", 1);
                        map3.put("userid", h.this.f1177g.getVerifyUserID());
                    }
                    if (h.this.f1177g != null && h.this.f1177g.isQuickLogin()) {
                        HashMap map4 = new HashMap();
                        map4.put("clienttime_ms", this.c);
                        map4.put("access_id", h.this.f1177g.getAccessID());
                        map4.put("access_key", h.this.f1177g.getAccessKey());
                        map4.put("comm_oper", Integer.valueOf(h.this.f1177g.getCommOperator()));
                        this.a.put("m_token_1", e.c.a.g.a.r.e.e.b(map4));
                    }
                    if (h.this.f1177g != null && h.this.f1177g.isQuickLogin()) {
                        HashMap map5 = new HashMap();
                        map5.put("clienttime_ms", this.c);
                        map5.put("access_token", h.this.f1177g.getAccessToken());
                        this.a.put("m_token_2", e.c.a.g.a.r.e.e.b(map5));
                    }
                    if (h.this.f1177g != null && h.this.f1177g.isQuickLogin() && h.this.f1177g.getTeleSecurityParam() != null) {
                        HashMap map6 = new HashMap();
                        map6.put("atExpiresIn", h.this.f1177g.getTeleSecurityParam().b);
                        map6.put("loginMode", h.this.f1177g.getTeleSecurityParam().f231f);
                        map6.put("refreshToken", h.this.f1177g.getTeleSecurityParam().f230d);
                        map6.put("rfExpiresIn", h.this.f1177g.getTeleSecurityParam().a);
                        this.a.put("m_param", e.c.a.g.a.r.e.e.b(map6));
                    }
                    this.a.put("force_login", 1);
                    if (!TextUtils.isEmpty(h.this.b)) {
                        map3.put("pwd", iVar.e(h.this.b));
                    }
                    if (h.this.c > 0) {
                        this.a.put("businessid", Integer.valueOf(h.this.c));
                    }
                    String strB2 = e.c.a.g.a.r.e.e.b(map3);
                    this.a.put("p2", strB2);
                    this.a.put("support_multi", 1);
                    this.a.put("key", e.c.a.g.a.r.e.b.b(this.f1168d, this.f1169e, this.f1171g, String.valueOf(this.c)));
                    e.c.a.g.a.d.d0.a.a("mhs_watch_loginxlog", "3, p2=" + strB2 + ", map = " + this.a + ", hash = " + map3);
                }
                this.a.put("dev", TextUtils.isEmpty(l1.q()) ? "" : l1.q());
                String strD = e.c.a.g.a.r.e.b.d(this.a);
                if (!TextUtils.isEmpty(this.j)) {
                    this.j = "\"data\":" + this.j;
                    strD = strD.substring(0, strD.length() - 1) + "," + this.j + "}";
                }
                if (g0.a) {
                    g0.e(h.n, strD);
                }
                return strD;
            } catch (Exception e2) {
                g0.k(e2);
                return null;
            }
        }

        @Override // com.kugou.common.network.protocol.AbstractRequestPackage, com.kugou.common.network.protocol.RequestPackage
        public String getGetRequestParams() {
            return "";
        }

        @Override // com.kugou.common.network.protocol.RequestPackage
        public String getUrl() {
            return null;
        }
    }

    public h() {
        this.k = "";
        this.l = false;
        this.k = "";
        this.l = false;
    }

    public void j() {
        int i2 = this.f1175e;
        e.c.a.g.a.e.b.b(new YoungBITask(2, "login").setType(i2 == 5 ? "1" : i2 == 4 ? "2" : i2 == 2 ? "3" : ""));
    }

    public String[] k() {
        int i2 = this.f1175e;
        if (i2 == 1) {
            return r1.c(e.c.a.g.a.f.e.b.p, "https://login.user.kugou.com/v8/login_by_pwd");
        }
        if (i2 == 2 || i2 == 5) {
            return r1.c(e.c.a.g.a.f.e.b.n, "https://login.user.kugou.com/v4/login_by_token");
        }
        if (i2 == 3) {
            return r1.c(e.c.a.g.a.f.e.b.o, "https://login.user.kugou.com/v5/login_by_openplat");
        }
        if (i2 == 4) {
            return r1.c(e.c.a.g.a.f.e.b.f646h, "https://login.user.kugou.com/v6/login_by_verifycode");
        }
        return null;
    }

    public void l(boolean z, int i2, String str, String str2, String str3) {
        this.f1174d = z;
        this.a = str;
        this.f1176f = str2;
        this.b = str3;
        this.f1175e = i2;
        SystemClock.elapsedRealtime();
        j0.b().a(new a());
    }

    public final void m(boolean z, String str, String str2, String str3) {
        boolean z2;
        if (p) {
            return;
        }
        p = true;
        this.f1174d = z;
        this.a = str;
        this.b = str3;
        this.f1176f = str2;
        if (g0.a) {
            g0.b(n, "登录上传的token:" + str3);
        }
        Retrofit retrofitBuild = new Retrofit.Builder().setModuleName("LOGIN").addConverterFactory(new e(null)).setMultiUrl(k()).build();
        f fVar = new f(this.k);
        UserData userDataNewEmptyInstance = UserData.newEmptyInstance();
        try {
            try {
                e.c.a.g.a.r.g.c cVarZ = e.c.a.g.a.r.g.c.z();
                cVarZ.s();
                Map<String, String> mapE = cVarZ.E();
                String strA = fVar.a();
                mapE.put("signature", r1.f(e.c.a.g.a.f.e.c.c().getConfig(e.c.a.g.a.f.e.b.f642d), mapE, strA));
                String strBody = ((b) retrofitBuild.create(b.class)).login(mapE, strA).execute().body();
                g gVar = new g();
                gVar.b(strBody);
                gVar.getResponseData(userDataNewEmptyInstance);
                if (userDataNewEmptyInstance != null) {
                    if (userDataNewEmptyInstance.getStatus() == 0 && !TextUtils.isEmpty(userDataNewEmptyInstance.getRespStr()) && !TextUtils.isEmpty(userDataNewEmptyInstance.getJumpUrl()) && userDataNewEmptyInstance.getError_code() == 34123) {
                        d dVar = this.m;
                        if (dVar != null) {
                            dVar.onLoginRisk();
                        }
                        if (z2) {
                            return;
                        } else {
                            return;
                        }
                    }
                    if (userDataNewEmptyInstance.getStatus() == 1 && !TextUtils.isEmpty(userDataNewEmptyInstance.getJumpUrl())) {
                        d dVar2 = this.m;
                        if (dVar2 != null) {
                            dVar2.onLoginRisk();
                        }
                        if (g0.a) {
                            g0.b(n, "手机酷狗登录次数");
                            return;
                        }
                        return;
                    }
                }
                if (g0.a) {
                    g0.b(n, "手机酷狗登录次数");
                }
            } catch (Exception e2) {
                String str4 = n;
                Log.d(str4, "login: login fail: " + e2);
                if (g0.a) {
                    g0.b(str4, "手机酷狗登录次数");
                }
            }
            if (g0.a) {
                g0.b(n, "login : result: " + userDataNewEmptyInstance.getRespStr());
            }
            if (userDataNewEmptyInstance == null || TextUtils.isEmpty(userDataNewEmptyInstance.getRespStr())) {
                SystemClock.elapsedRealtime();
                p = false;
                d dVar3 = this.m;
                if (dVar3 != null) {
                    dVar3.onLoginFailed(userDataNewEmptyInstance, this.f1175e);
                    return;
                }
                return;
            }
            if (userDataNewEmptyInstance.getStatus() != 1) {
                if (this.f1175e == 3 && (userDataNewEmptyInstance.getError_code() == 30798 || userDataNewEmptyInstance.getError_code() == 34258)) {
                    SystemClock.elapsedRealtime();
                    q(userDataNewEmptyInstance);
                    p = false;
                    return;
                } else {
                    SystemClock.elapsedRealtime();
                    p = false;
                    q(userDataNewEmptyInstance);
                    return;
                }
            }
            SystemClock.elapsedRealtime();
            p = false;
            try {
                e.c.a.g.a.r.e.e.f(userDataNewEmptyInstance.getT1());
            } catch (Exception e3) {
                g0.k(e3);
                if (g0.a) {
                    g0.c(n, "token 设置失败!");
                }
            }
            if (g0.a) {
                g0.b(n, "登录成功之后获取到的新token:" + userDataNewEmptyInstance.getToken());
            }
            String token = userDataNewEmptyInstance.getToken();
            long userid = userDataNewEmptyInstance.getUserid();
            if (!TextUtils.isEmpty(token) && userid > 0) {
                e.c.a.g.a.f.m.c cVar = e.c.a.g.a.f.m.c.a;
                cVar.j("key_user_login", true);
                cVar.i("key_user_token", token);
                cVar.h("key_user_id", userid);
                cVar.i("key_user_name", userDataNewEmptyInstance.getUsername());
                cVar.i("key_user_nick_name", userDataNewEmptyInstance.getNickname());
                cVar.i("key_user_pic", userDataNewEmptyInstance.getPic());
                cVar.i("key_user_json", t.c(userDataNewEmptyInstance));
            }
            r(z, userDataNewEmptyInstance);
        } finally {
            if (g0.a) {
                g0.b(n, "手机酷狗登录次数");
            }
        }
    }

    public void n(String str, String str2) {
        o(str, str2, null);
    }

    public void o(String str, String str2, String str3) {
        p(str, str2, str3, -1);
    }

    public void p(String str, String str2, String str3, int i2) {
        this.f1175e = 4;
        this.f1179i = str;
        this.j = str2;
        this.c = i2;
        l(false, 4, null, null, str3);
    }

    public final void q(UserData userData) {
        if (this.f1178h > 0) {
            e.c.a.g.a.e.b.b(new YoungBITask(22020014, "statistics").setType(String.valueOf(this.f1178h)).setSvar1(userData != null ? String.valueOf(userData.getError_code()) : null));
        }
        if (g0.a) {
            g0.b(n, "UserLogin 发出登录失败广播");
        }
        e.c.a.g.a.f.d.a.d(new Intent("com.kugou.android.login_faild"));
        String strValueOf = userData == null ? "" : String.valueOf(userData.getError_code());
        if (strValueOf.equals("30702") || strValueOf.equals("30703")) {
            d dVar = this.m;
            if (dVar != null) {
                dVar.onLoginFailed(userData, this.f1175e);
                return;
            }
            return;
        }
        if (this.m != null) {
            userData.setVerifyRealName(this.l);
            this.m.onLoginFailed(userData, this.f1175e);
        }
    }

    public final void r(boolean z, UserData userData) {
        j();
        e.c.a.g.a.f.k.c<UserData> cVarA = e.c.a.g.a.r.d.d.b.a.a();
        if (cVarA.a() != null && cVarA.f()) {
            userData.setBusiVip(cVarA.a().getBusiVip());
        }
        e.c.a.g.a.r.b.U(false);
        e.c.a.g.a.r.b.X(userData.getServertime());
        e.c.a.g.a.r.b.a(userData);
        e.c.a.g.a.r.b.Y(true);
        new e.c.a.f.a().c(false, false, this.f1175e, null, false);
        if (g0.a) {
            g0.c(n, "登录成功广播：USER_LOGIN_SUCCESS_ACTION");
        }
        Intent intent = new Intent("com.kugou.android.user_login_success");
        intent.putExtra("key_login_type", z);
        intent.putExtra("key_login_mode", this.f1175e);
        intent.putExtra("key_login_jump_url", true ^ TextUtils.isEmpty(userData.getJumpUrl()));
        if (g0.a) {
            g0.b(n, "UserLogin 发出登录成功广播");
        }
        synchronized (o) {
            e.c.a.g.a.f.d.a.d(intent);
        }
        if (g0.a) {
            g0.e(n, "登录成功");
        }
        d dVar = this.m;
        if (dVar != null) {
            dVar.onLoginSucceed(userData, this.f1175e);
        }
    }

    public void s(LoginExtraEntity loginExtraEntity) {
        this.f1177g = loginExtraEntity;
    }

    public void t(d dVar) {
        this.m = dVar;
    }

    public h u(int i2) {
        this.f1178h = i2;
        return this;
    }
}
