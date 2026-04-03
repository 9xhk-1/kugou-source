package d.a.a.a$b.a.c;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import f.f;
import f.s;
import f.z.d.j;
import f.z.d.k;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class c extends b {
    public final f.d b = f.b(a.a);
    public final SharedPreferences c;

    public static final class a extends k implements f.z.c.a<LinkedHashMap<String, String>> {
        public static final a a = new a();

        public a() {
            super(0);
        }

        @Override // f.z.c.a
        public LinkedHashMap<String, String> invoke() {
            return new LinkedHashMap<>();
        }
    }

    public c() {
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.a);
        j.d(defaultSharedPreferences, "getDefaultSharedPreferences(context)");
        this.c = defaultSharedPreferences;
    }

    @Override // d.a.a.a$b.a.c.b
    public String a(String str) {
        String string;
        j.e(str, "key");
        e.g.b.b.a.a("CardParamCache", "get card param key: " + str + ' ');
        synchronized (c()) {
            if (c().get(str) != null && (string = this.c.getString(str, null)) != null) {
                c().put(str, string);
            }
        }
        return c().get(str);
    }

    @Override // d.a.a.a$b.a.c.b
    public boolean b(String str, String str2) {
        j.e(str, "key");
        e.g.b.b bVar = e.g.b.b.a;
        StringBuilder sb = new StringBuilder();
        sb.append("update key: ");
        sb.append(str);
        sb.append(" value size is null : ");
        sb.append(str2 == null);
        bVar.a("CardParamCache", sb.toString());
        synchronized (c()) {
            c().put(str, str2);
            this.c.edit().putString(str, str2).apply();
            s sVar = s.a;
        }
        return true;
    }

    public final Map<String, String> c() {
        return (Map) this.b.getValue();
    }
}
