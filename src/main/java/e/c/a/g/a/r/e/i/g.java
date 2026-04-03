package e.c.a.g.a.r.e.i;

import android.content.Context;

/* JADX INFO: loaded from: classes2.dex */
public class g {
    public int a;
    public int b;
    public String c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f1180d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f1181e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f1182f;

    public static String a(Context context, int i2, String str) {
        return i2 != 20014 ? i2 != 20015 ? i2 != 30793 ? i2 != 30799 ? i2 != 34111 ? e.c.a.g.a.r.a.f(str) == null ? "发送验证码失败，请稍后再试" : str : "手机号不合法" : "手机号当天操作次数达到上限，请明天再试！" : "手机号不合法" : "您今天的验证次数用光了，请明天重试" : "当前网络环境请求次数过多，请更换网络";
    }

    public static String d(Context context, int i2, String str) {
        return i2 != 20020 ? i2 != 20021 ? a(context, i2, str) : "图文码错误" : "图文码失效";
    }

    public String b() {
        return this.c;
    }

    public int c() {
        return this.b;
    }

    public boolean e() {
        return this.a == 1;
    }

    public void f(String str) {
        this.f1180d = str;
    }

    public void g(int i2) {
        this.f1181e = i2;
    }

    public void h(String str) {
        this.c = str;
    }

    public void i(int i2) {
        this.b = i2;
    }

    public void j(int i2) {
        this.a = i2;
    }

    public String toString() {
        return "VerifiyCodeInfo{status=" + this.a + ", errorCode=" + this.b + ", error='" + this.c + "', captcha='" + this.f1180d + "', count=" + this.f1181e + ", businessid=" + this.f1182f + '}';
    }
}
