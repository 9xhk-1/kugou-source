package e.c.a.g.a.d.x;

import android.util.Log;
import com.kugou.android.watch.lite.base.application.KGApplication;
import com.kugou.android.watch.lite.base.player.entity.CommNetSongUrlInfo;
import e.c.a.g.a.s.l0;
import e.c.a.g.a.s.u0;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class k {
    public static final boolean a;

    static {
        a = e.c.a.g.a.f.e.c.c().getConfigAsInt(e.c.a.g.a.f.e.b.p3, 1) == 1;
    }

    public static boolean a(CommNetSongUrlInfo commNetSongUrlInfo) {
        return commNetSongUrlInfo == null || !(commNetSongUrlInfo.getErrorType() == 12 || commNetSongUrlInfo.getErrorType() == 11);
    }

    public static String b(CommNetSongUrlInfo commNetSongUrlInfo, String str) {
        if (commNetSongUrlInfo != null) {
            int errorType = commNetSongUrlInfo.getErrorType();
            if (errorType == 5) {
                return "该网络歌曲不存在，不支持下载";
            }
            if (errorType == 6) {
                return "下载失败，网络异常";
            }
            if (errorType == 11) {
                List<String> failProcess = commNetSongUrlInfo.getFailProcess();
                return (l0.e(failProcess) == 1 && failProcess.contains(CommNetSongUrlInfo.FAIL_PROCESS_BUY)) ? "该歌曲为付费专享歌曲" : "歌曲为VIP专享";
            }
            if (errorType == 12) {
                return "歌曲暂无版权，不支持下载";
            }
            if (errorType == 20028) {
                return "下载过于频繁，暂不能继续下载";
            }
        }
        return str;
    }

    public static String c(CommNetSongUrlInfo commNetSongUrlInfo, String str) {
        if (commNetSongUrlInfo != null) {
            int errorType = commNetSongUrlInfo.getErrorType();
            if (errorType == 5) {
                return "该网络歌曲不存在";
            }
            if (errorType == 6) {
                return (a && u0.n(KGApplication.getContext(), false)) ? str : "网络异常";
            }
            if (errorType == 11) {
                List<String> failProcess = commNetSongUrlInfo.getFailProcess();
                if (failProcess != null) {
                    for (String str2 : failProcess) {
                        Log.d("mhs_watch", "parsePlayErr: " + str2 + ", 试听片段兼容 = " + str2);
                    }
                }
                return (l0.e(failProcess) == 1 && failProcess.contains(CommNetSongUrlInfo.FAIL_PROCESS_BUY)) ? "该歌曲为付费专享歌曲" : "歌曲为VIP专享";
            }
            if (errorType == 12) {
                return "歌曲暂无版权";
            }
            if (errorType == 20028) {
                return "太频繁了，请先休息一下";
            }
        }
        return str;
    }
}
