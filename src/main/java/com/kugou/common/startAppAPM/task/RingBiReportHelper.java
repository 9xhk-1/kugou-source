package com.kugou.common.startAppAPM.task;

import android.text.TextUtils;
import android.util.Log;
import com.kugou.android.watch.lite.bi.YoungBITask;
import com.kugou.common.useraccount.entity.SVIPExtInfo;
import com.kugou.common.useraccount.utils.SVIPExtInfoUtil;
import com.kugou.datacollect.bi.use.TraceFullTask;
import e.c.a.g.a.d.d0.a;
import e.c.a.g.a.f.e.b;
import e.c.a.g.a.f.e.c;
import e.c.a.g.a.s.g0;
import f.z.d.j;

/* JADX INFO: loaded from: classes.dex */
public final class RingBiReportHelper {
    public static final RingBiReportHelper INSTANCE = new RingBiReportHelper();
    private static final String TAG;
    private static final boolean forceUseOffset;
    private static final boolean needReport;
    private static final boolean needReport2;
    private static final boolean needReportGrade;
    private static final boolean needReportKadun;
    private static final boolean needReportPause;
    private static final boolean needReportPause2;
    private static final boolean needReportRcm;
    private static final boolean payPageReport;
    private static String userInfo;

    static {
        c.b bVar = c.a;
        needReport = bVar.a().getConfigAsInt(b.r0, 1) == 1;
        userInfo = "";
        TAG = "RingBiReportHelper";
        forceUseOffset = bVar.a().getConfigAsInt(b.t0, 0) == 1;
        needReportRcm = bVar.a().getConfigAsInt(b.s0, 1) == 1;
        needReportKadun = bVar.a().getConfigAsInt(b.v0, 1) == 1;
        needReportPause2 = bVar.a().getConfigAsInt(b.x0, 1) == 1;
        needReportPause = bVar.a().getConfigAsInt(b.w0, 0) == 1;
        needReport2 = bVar.a().getConfigAsInt(b.n0, 1) == 1;
        needReportGrade = bVar.a().getConfigAsInt(b.q0, 1) == 1;
        payPageReport = bVar.a().getConfigAsInt(b.u0, 1) == 1;
    }

    private RingBiReportHelper() {
    }

    public static /* synthetic */ void reportAutoStop$default(RingBiReportHelper ringBiReportHelper, String str, String str2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str2 = null;
        }
        ringBiReportHelper.reportAutoStop(str, str2);
    }

    public static /* synthetic */ void reportHead$default(RingBiReportHelper ringBiReportHelper, String str, String str2, Boolean bool, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str2 = null;
        }
        if ((i2 & 4) != 0) {
            bool = Boolean.FALSE;
        }
        ringBiReportHelper.reportHead(str, str2, bool);
    }

    public static /* synthetic */ void reportHead2$default(RingBiReportHelper ringBiReportHelper, String str, String str2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str2 = null;
        }
        ringBiReportHelper.reportHead2(str, str2);
    }

    public static /* synthetic */ void reportHead3$default(RingBiReportHelper ringBiReportHelper, String str, String str2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str2 = null;
        }
        ringBiReportHelper.reportHead3(str, str2);
    }

    public static /* synthetic */ void reportHead4$default(RingBiReportHelper ringBiReportHelper, String str, String str2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str2 = null;
        }
        ringBiReportHelper.reportHead4(str, str2);
    }

    public static /* synthetic */ void reportHeadGrade$default(RingBiReportHelper ringBiReportHelper, String str, String str2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str2 = null;
        }
        ringBiReportHelper.reportHeadGrade(str, str2);
    }

    public static /* synthetic */ void reportHeadKadun$default(RingBiReportHelper ringBiReportHelper, String str, String str2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str2 = null;
        }
        ringBiReportHelper.reportHeadKadun(str, str2);
    }

    public static /* synthetic */ void reportPayPage$default(RingBiReportHelper ringBiReportHelper, String str, String str2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str2 = null;
        }
        ringBiReportHelper.reportPayPage(str, str2);
    }

    public static /* synthetic */ void reportPlayMore$default(RingBiReportHelper ringBiReportHelper, String str, String str2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str2 = null;
        }
        ringBiReportHelper.reportPlayMore(str, str2);
    }

    public final boolean getForceUseOffset() {
        return forceUseOffset;
    }

    public final boolean getNeedReportPause() {
        return needReportPause;
    }

    public final boolean getNeedReportPause2() {
        return needReportPause2;
    }

    public final String getTAG() {
        return TAG;
    }

    public final String getUserInfo() {
        return userInfo;
    }

    public void reportAutoStop(String str, String str2) {
        try {
            a.a("FeedbackFragment", j.l("page 自动暂停 1,", str));
            boolean z = needReportPause;
            if (z) {
                e.c.a.g.a.e.b.b(new YoungBITask(22020029, "statistics").setType("14").setFo("/自动暂停").setSvar1(str).setSvar2(str2));
            } else if (g0.f()) {
                g0.c("mhs_watch", j.l("TYPE_AUTO_PAUSE needReportPause = ", Boolean.valueOf(z)));
            }
        } catch (Exception e2) {
            Log.e("reportAutoStop", j.l("e = ", e2));
        }
    }

    public void reportHead(String str, String str2, Boolean bool) {
        try {
            boolean z = needReport;
            if (!z) {
                if (g0.f()) {
                    g0.c("mhs_watch", j.l("TYPE_LOGIN needReport = ", Boolean.valueOf(z)));
                    return;
                }
                return;
            }
            if (TextUtils.isEmpty(userInfo)) {
                try {
                    SVIPExtInfo mineSVIPExtInfo = SVIPExtInfoUtil.getMineSVIPExtInfo(true);
                    userInfo = String.valueOf(mineSVIPExtInfo == null ? null : mineSVIPExtInfo.toJson());
                } catch (Exception unused) {
                }
            }
            TraceFullTask svar2 = new YoungBITask(22020029, "statistics").setType("5").setFo("/播放器/更多/铃声页面").setSvar1(str).setSvar2(str2);
            Boolean bool2 = Boolean.TRUE;
            e.c.a.g.a.e.b.b(svar2.setSvar3(j.a(bool, bool2) ? userInfo : ""));
            String str3 = TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("page /播放器/更多/铃声页面 1,");
            sb.append((Object) str);
            sb.append(", 2,");
            sb.append((Object) str2);
            sb.append(", 3 ");
            sb.append(j.a(bool, bool2) ? userInfo : "");
            a.a(str3, sb.toString());
        } catch (Exception e2) {
            Log.e("reportHead", j.l("e = ", e2));
        }
    }

    public void reportHead2(String str, String str2) {
        try {
            a.a(TAG, "page /播放器/播放执行 , 1," + ((Object) str) + ", 2," + ((Object) str2));
            boolean z = needReport;
            if (z) {
                e.c.a.g.a.e.b.b(new YoungBITask(22020029, "statistics").setType("7").setFo("/播放器/播放执行").setSvar1(str).setSvar2(str2));
            } else if (g0.f()) {
                g0.c("mhs_watch", j.l("TYPE_LOGIN needReport = ", Boolean.valueOf(z)));
            }
        } catch (Exception e2) {
            Log.e("reportHead", j.l("e = ", e2));
        }
    }

    public void reportHead3(String str, String str2) {
        try {
            a.a(TAG, "page /首页/为你推荐 1," + ((Object) str) + ",2," + ((Object) str2));
            boolean z = needReportRcm;
            if (z) {
                e.c.a.g.a.e.b.b(new YoungBITask(22020029, "statistics").setType("9").setFo("/首页/为你推荐").setSvar1(str).setSvar2(str2));
            } else if (g0.f()) {
                g0.c("mhs_watch", j.l("TYPE_RCM needReport = ", Boolean.valueOf(z)));
            }
        } catch (Exception e2) {
            Log.e("reportHead", j.l("e = ", e2));
        }
    }

    public void reportHead4(String str, String str2) {
        try {
            a.a(TAG, "page /历史播放数据上云 1," + ((Object) str) + ",2," + ((Object) str2));
            boolean z = needReport;
            if (z) {
                e.c.a.g.a.e.b.b(new YoungBITask(22020029, "statistics").setType("11").setFo("/历史播放数据上云").setSvar1(str).setSvar2(str2));
            } else if (g0.f()) {
                g0.c("mhs_watch", j.l("TYPE_LOGIN needReport = ", Boolean.valueOf(z)));
            }
        } catch (Exception e2) {
            Log.e("reportHead", j.l("e = ", e2));
        }
    }

    public void reportHeadFeedBack(String str) {
        j.e(str, "step");
        boolean z = needReport2;
        if (z) {
            e.c.a.g.a.e.b.b(new YoungBITask(22020029, "statistics").setFo("反馈页面").setType("13").setSvar1(str));
            a.a("FeedbackFragment", j.l("page 反馈页面 1,", str));
        } else if (g0.f()) {
            g0.c("mhs_watch", j.l("TYPE_PIC needReport = ", Boolean.valueOf(z)));
        }
    }

    public final void reportHeadGrade(String str, String str2) {
        a.a("FeedbackFragment", j.l("page 家长管控 1,", str));
        boolean z = needReportGrade;
        if (z) {
            e.c.a.g.a.e.b.b(new YoungBITask(22020029, "statistics").setFo("家长管控").setType("12").setSvar1(str).setSvar2(str2));
        } else if (g0.f()) {
            g0.c("mhs_watch", j.l("TYPE_FAMILY_CONTROLLER needReportGrade = ", Boolean.valueOf(z)));
        }
    }

    public void reportHeadKadun(String str, String str2) {
        try {
            a.a(TAG, "page /卡顿 1," + ((Object) str) + ",2," + ((Object) str2));
            boolean z = needReportKadun;
            if (z) {
                e.c.a.g.a.e.b.b(new YoungBITask(22020029, "statistics").setType("9").setFo("/卡顿").setSvar1(str).setSvar2(str2));
            } else if (g0.f()) {
                g0.c("mhs_watch", j.l("TYPE_LOGIN needReportKadun = ", Boolean.valueOf(z)));
            }
        } catch (Exception e2) {
            Log.e("reportHead", j.l("e = ", e2));
        }
    }

    public void reportPayPage(String str, String str2) {
        try {
            boolean z = payPageReport;
            if (z) {
                e.c.a.g.a.e.b.b(new YoungBITask(22020029, "statistics").setType("15").setFo("/支付/支付页面").setSvar1(str).setSvar2(str2));
            } else if (g0.f()) {
                g0.c("mhs_watch", j.l("CommonReportBi.TYPE_PAY_PAGE needReport = ", Boolean.valueOf(z)));
            }
        } catch (Exception e2) {
            Log.e("reportPayPage", j.l("e = ", e2));
        }
    }

    public void reportPlayMore(String str, String str2) {
        try {
            boolean z = payPageReport;
            if (z) {
                e.c.a.g.a.e.b.b(new YoungBITask(22020029, "statistics").setType("15").setFo("/播放器/更多").setSvar1(str).setSvar2(str2));
            } else if (g0.f()) {
                g0.c("mhs_watch", j.l("CommonReportBi.TYPE_PAY_PAGE needReport = ", Boolean.valueOf(z)));
            }
        } catch (Exception e2) {
            Log.e("reportPayPage", j.l("e = ", e2));
        }
    }

    public final void setUserInfo(String str) {
        j.e(str, "<set-?>");
        userInfo = str;
    }
}
