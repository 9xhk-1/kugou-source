package e.c.a.g.a.r.e.i;

import android.text.TextUtils;
import com.kugou.android.watch.lite.base.application.KGApplication;
import com.kugou.framework.libcommon.netcore.BaseConnection;
import e.c.a.g.a.s.l1;
import e.c.a.g.a.s.m;

/* JADX INFO: loaded from: classes2.dex */
public class e {
    public static String a(String str) {
        String[] strArrSplit;
        if (TextUtils.isEmpty(str) || (strArrSplit = str.split("\\?")) == null || strArrSplit.length > 2 || strArrSplit.length < 1 || TextUtils.isEmpty(strArrSplit[0])) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        long jO = e.c.a.g.a.r.b.o();
        if (jO > 0) {
            sb.append("u=" + String.valueOf(jO));
        }
        String strN = l1.n(KGApplication.getContext());
        if (!TextUtils.isEmpty(strN)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(sb.length() > 0 ? BaseConnection.HTTP_REQ_ENTITY_JOIN : "");
            sb2.append("h1=");
            sb2.append(strN);
            sb.append(sb2.toString());
        }
        String strH = m.h();
        if (!TextUtils.isEmpty(strH)) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append(sb.length() > 0 ? BaseConnection.HTTP_REQ_ENTITY_JOIN : "");
            sb3.append("h2=");
            sb3.append(strH);
            sb.append(sb3.toString());
        }
        StringBuilder sb4 = new StringBuilder();
        sb4.append(strArrSplit[0]);
        sb4.append('?');
        sb4.append((CharSequence) sb);
        if (strArrSplit.length == 2 && !TextUtils.isEmpty(strArrSplit[1])) {
            if (!strArrSplit[1].startsWith(BaseConnection.HTTP_REQ_ENTITY_JOIN)) {
                sb4.append(BaseConnection.HTTP_REQ_ENTITY_JOIN);
            }
            sb4.append(strArrSplit[1]);
        }
        return sb4.toString();
    }
}
