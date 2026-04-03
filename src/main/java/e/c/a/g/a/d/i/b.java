package e.c.a.g.a.d.i;

import android.text.TextUtils;
import e.c.a.g.a.s.q;
import e.c.a.g.a.s.q0;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public class b {
    public static final String a;
    public static final String b;

    static {
        String str = e.c.a.g.a.f.f.a.f650f + "/download/";
        a = str;
        b = str;
    }

    public static String a(String str, int i2, long j) {
        e.c.a.g.a.g.d.d dVar = e.c.a.g.a.g.d.d.a;
        e.c.a.g.a.d.f.c.a.a aVarD = dVar.d(i(g(str, i2, j), 2));
        if (aVarD != null && e.c.a.g.a.d.x.d.b(aVarD.i())) {
            return aVarD.i();
        }
        e.c.a.g.a.d.f.c.a.a aVarD2 = dVar.d(i(g(str, i2, j), 1));
        return (aVarD2 == null || !e.c.a.g.a.d.x.d.b(aVarD2.i())) ? "" : aVarD2.i();
    }

    public static boolean b(String str) {
        return e.c.a.g.a.g.d.d.a.d(str) != null;
    }

    public static boolean c(String str, int i2, long j) {
        boolean zD = d(str, i2, j, 2);
        return !zD ? d(str, i2, j, 1) : zD;
    }

    public static boolean d(String str, int i2, long j, int i3) {
        return b(i(g(str, i2, j), i3));
    }

    public static String e(String str) {
        File file = new File(b, "done");
        if (!file.exists()) {
            file.mkdirs();
        }
        return new File(file, str).getAbsolutePath();
    }

    public static String f(String str) {
        String str2 = b;
        if (!q.F(str2)) {
            q.f(str2);
        }
        return new File(str2, str).getAbsolutePath();
    }

    public static String g(String str, int i2, long j) {
        return (str + "-" + i2 + "-" + j).toLowerCase();
    }

    public static String h(String str, String str2, String str3, int i2) {
        String str4;
        if (str3 != null) {
            str3 = str3.length() > 100 ? q0.i(str3) : str3.replaceAll("/", "-");
        }
        String str5 = str + "_LQ";
        if (TextUtils.isEmpty(str)) {
            str5 = str3 + "_LQ";
        }
        if (TextUtils.isEmpty(str2)) {
            str4 = ".mp3";
        } else {
            str4 = "." + str2;
        }
        if (i2 == 2) {
            return str5 + e.c.a.g.a.f.f.a.j;
        }
        return str5 + str4;
    }

    public static String i(String str, int i2) {
        if (i2 == 2) {
            return str.toLowerCase() + "-download" + e.c.a.g.a.f.f.a.j;
        }
        return str.toLowerCase() + "-download" + e.c.a.g.a.f.f.a.f653i;
    }

    public static String j(String str, int i2, long j, int i3) {
        if (i3 == 2) {
            return g(str, i2, j) + "-download" + e.c.a.g.a.f.f.a.j;
        }
        return g(str, i2, j) + "-download" + e.c.a.g.a.f.f.a.f653i;
    }

    public static String k(int i2) {
        if (i2 == 7) {
            return "存储空间不足，请清理空间后重试！";
        }
        if (i2 == 17) {
            return "无法创建文件,请清理空间后重试!";
        }
        if (i2 == 109) {
            return "因网络中断停止下载,请连网后重试!";
        }
        if (i2 == 130 || i2 == 131 || i2 == 133 || i2 == 134) {
            return "无法创建文件,请清理空间后重试!";
        }
        switch (i2) {
            case 102:
            case 103:
                return "服务器连接不畅,请稍后重试或切网络!";
            case 104:
            case 105:
            case 106:
                return "无法创建文件,请清理空间后重试!";
            default:
                switch (i2) {
                    case 111:
                    case 112:
                        return "服务器连接不畅,请稍后重试或切网络!";
                    case 113:
                    case 114:
                        return "文件获取异常,可切换网络后重试!";
                    case 115:
                        return "存储空间不足，请清理空间后重试！";
                    case 116:
                    case 118:
                        return "因切到流量中止下载,请连WiFi重试!";
                    case 117:
                        return "文件下载异常，请切换歌曲并清除缓存后重试";
                    default:
                        switch (i2) {
                            case 126:
                            case 127:
                            case 128:
                                return "服务器连接不畅,请稍后重试或切网络!";
                            default:
                                return "下载失败(" + i2 + ")";
                        }
                }
        }
    }

    public static String l(int i2, int i3) {
        return i2 != 1 ? i2 != 2 ? i2 != 4 ? i2 != 7 ? i2 != 24 ? i2 != 100 ? i2 != 1005 ? i2 != 1008 ? i2 != 1029 ? i2 != 1030 ? String.format("抱歉，歌曲加载失败(%d,%d)", Integer.valueOf(i2), Integer.valueOf(i3)) : "该歌曲需单独购买后畅享" : "会员专属歌曲不能免费试听，付费后畅享" : "本地歌曲文件不存在" : "未找到可用的网络连接" : "未知的播放出错" : "创建音频播放组件失败" : "未知的播放出错" : (i3 == 7 || i3 == 104 || i3 == 106 || i3 == 115) ? "抱歉，存储空间已满" : "抱歉，数据源出错" : "文件不支持" : "本地歌曲文件不存在";
    }
}
