package e.c.a.g.a.r;

import android.text.TextUtils;
import com.kugou.android.watch.lite.user.login.UserData;
import com.kugou.common.useraccount.utils.SVIPExtInfoUtil;
import e.c.a.g.a.f.k.c;
import e.c.a.g.a.s.j0;
import org.greenrobot.eventbus.EventBus;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class a {
    public static boolean a = false;

    /* JADX INFO: renamed from: e.c.a.g.a.r.a$a, reason: collision with other inner class name */
    public class RunnableC0176a implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            synchronized (a.class) {
                if (a.a) {
                    return;
                }
                boolean unused = a.a = true;
                c<UserData> cVarA = e.c.a.g.a.r.d.d.b.a.a();
                if (cVarA.a() != null && cVarA.f()) {
                    UserData userDataA = cVarA.a();
                    b.a(userDataA);
                    SVIPExtInfoUtil.saveSVIPExtInfo(userDataA);
                }
                EventBus.getDefault().post(new e.c.a.g.a.r.d.c());
                boolean unused2 = a.a = false;
            }
        }
    }

    public static String c(int i2, String str) {
        if (30786 == i2) {
            return "密码错误次数达到上限，请明天再试";
        }
        if (34102 == i2) {
            return "当前版本过低，不支持此功能，请升级到最新版本";
        }
        if (20014 == i2) {
            return "当前网络环境登录次数过多，请更换网络环境后重试";
        }
        if (20006 == i2) {
            return "接口验证失败，请检查";
        }
        if (20001 == i2 || 20008 == i2 || 20010 == i2) {
            return "系统错误，请稍后重试";
        }
        if (10404 == i2 || 30704 == i2 || 30705 == i2) {
            return "网络环境不佳，请稍后再试";
        }
        if (30706 == i2) {
            return "登录失败次数太多，请明天重试";
        }
        if (34105 == i2) {
            return "账号已冻结";
        }
        if (34126 == i2) {
            return "同一个手机一天只能注册一次";
        }
        if (30799 == i2) {
            return "手机号当天操作次数达到上限，请明天再试";
        }
        if (20020 == i2) {
            return "验证码失效";
        }
        if (20021 == i2) {
            return "验证码错误";
        }
        if (30707 == i2) {
            return "第三方账号服务接口问题";
        }
        if (30715 == i2) {
            return "当前网络环境注册次数过多，请更换网络环境后重试";
        }
        if (20015 == i2) {
            return "验证码发送次数过多，请明天重试";
        }
        if (30739 == i2) {
            return "用户原绑定手机号不正确";
        }
        if (30740 == i2) {
            return "非第一次设置酷狗密码";
        }
        if (20022 == i2) {
            return "您输入的内容包含违规词汇，请检查";
        }
        if (30712 == i2) {
            return "手机号已注册";
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return str;
    }

    public static String d(int i2) {
        if (20018 == i2) {
            return "登录信息失效，请重新登录";
        }
        if (20002 == i2) {
            return "由于系统升级，功能暂时无法使用，给您带来的不便，敬请谅解！";
        }
        return null;
    }

    public static String e(int i2, String str) {
        String strD = d(i2);
        return TextUtils.isEmpty(strD) ? str : strD;
    }

    public static String f(String str) {
        if (TextUtils.isEmpty(str) || g(str) || "null".equalsIgnoreCase(str)) {
            return null;
        }
        return str;
    }

    public static boolean g(String str) {
        try {
            new JSONObject(str);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static void h() {
        if (a || b.O() || !e.c.a.g.a.f.e.c.c().getConfigAsBoolean(e.c.a.g.a.f.e.b.h4, true)) {
            return;
        }
        j0.b().a(new RunnableC0176a());
    }
}
