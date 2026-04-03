package e.c.a.c;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class a {
    /* JADX WARN: Can't wrap try/catch for region: R(30:8|(1:10)|11|(1:13)|14|(3:138|16|(2:18|(2:19|(2:21|(2:148|23)(1:25))(1:147)))(0))(0)|28|(3:30|(1:33)|34)(1:35)|36|(3:38|128|39)|42|(2:44|(1:46))|47|(1:49)(1:50)|51|(2:53|(1:55))(2:56|(2:58|(1:60))(3:124|141|125))|61|(2:63|(1:65))|132|66|(1:68)(1:69)|70|(2:72|(1:74))|78|136|79|(1:117)(9:83|(1:85)(1:(1:87)(1:88))|89|(3:93|(4:95|(2:108|144)(6:99|100|(1:102)(2:103|(1:105)(1:106))|134|107|145)|109|146)|143)|110|(1:112)|113|130|114)|123|142|125) */
    /* JADX WARN: Code restructure failed: missing block: B:118:0x0333, code lost:
    
        r21 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x0278, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x0279, code lost:
    
        r0.printStackTrace();
     */
    /* JADX WARN: Removed duplicated region for block: B:122:0x033a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.util.ArrayList<com.kugou.android.watch.lite.common.music.entity.KGSong> a(org.json.JSONObject r22) throws java.lang.Exception {
        /*
            Method dump skipped, instruction units count: 846
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: e.c.a.c.a.a(org.json.JSONObject):java.util.ArrayList");
    }

    public static long b(JSONObject jSONObject, String str) {
        try {
            if (jSONObject.has(str)) {
                return Long.valueOf(jSONObject.getString(str)).longValue();
            }
            return 0L;
        } catch (Exception unused) {
            return 0L;
        }
    }
}
