package e.c.c.l.e;

import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import e.c.c.o.k;
import java.util.Hashtable;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class c {

    public static class a {
        public int a;
        public int b;
        public String c;

        public boolean a() {
            return this.a == 1;
        }
    }

    public a a(String str) {
        a aVar = new a();
        if (!TextUtils.isEmpty(str)) {
            Hashtable hashtable = new Hashtable();
            hashtable.put("s", str);
            k.c(hashtable, e.c.c.l.e.a.b, e.c.c.l.e.a.c, System.currentTimeMillis() / 1000, true);
            try {
                JSONObject jSONObject = new JSONObject(e.c.c.o.d.a("http://d.kugou.com/v2/gen", hashtable, null));
                aVar.a = jSONObject.getInt(NotificationCompat.CATEGORY_STATUS);
                aVar.b = jSONObject.getInt("errcode");
                if (aVar.a()) {
                    aVar.c = jSONObject.getString("data");
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        return aVar;
    }
}
