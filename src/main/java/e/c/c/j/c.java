package e.c.c.j;

import android.content.Context;
import android.os.Build;
import androidx.core.app.NotificationCompat;
import com.kugou.common.apm.sdk.ApmDataKey;
import e.c.c.k.e;
import e.c.c.o.f;
import e.c.c.o.g;
import e.c.c.o.i;
import e.c.c.o.m;
import e.c.c.o.n;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class c implements e<ArrayList<e.c.c.j.e.a>> {
    public static HashMap<String, Object> a(Context context, Map<String, String> map) {
        HashMap<String, Object> map2 = new HashMap<>();
        map2.putAll(map);
        map2.put("net", m.q(context));
        map2.put("sdk", m.u() + "");
        String str = "" + m.x(context);
        map2.put(NotificationCompat.CATEGORY_SYSTEM, n.b(Build.VERSION.RELEASE));
        map2.put("ver", str);
        map2.put("os", e.c.c.b.b);
        map2.put("mod", n.b(Build.MODEL));
        map2.put("uuid", m.v());
        map2.put("uid", e.c.c.b.f1244d);
        map2.put("channelid", e.c.c.b.c);
        map2.put("gitversion", e.c.c.b.f1245e);
        map2.put("md5", new i().e("Kugou2014"));
        map2.put("Kgsign", new i().f(map.get("type") + "" + map.get(ApmDataKey.STATE) + str + map2.get("key"), "utf-8"));
        return map2;
    }

    public final ArrayList<e.c.c.j.e.a> b(List<e.c.c.k.f.b> list) {
        ArrayList<e.c.c.j.e.a> arrayList = new ArrayList<>();
        Iterator<e.c.c.k.f.b> it = list.iterator();
        while (it.hasNext()) {
            String strB = it.next().b();
            g.a("APMSenderAdapter", strB);
            try {
                JSONObject jSONObject = new JSONObject(strB);
                HashMap map = new HashMap();
                Iterator<String> itKeys = jSONObject.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    map.put(next, jSONObject.getString(next));
                }
                arrayList.add(new e.c.c.j.e.a(a(f.a(), map)));
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        g.a("APMSenderAdapter", "resultList size:" + arrayList.size());
        return arrayList;
    }

    @Override // e.c.c.k.e
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public ArrayList<e.c.c.j.e.a> toSenderData(List<e.c.c.k.f.b> list) {
        return b(list);
    }
}
