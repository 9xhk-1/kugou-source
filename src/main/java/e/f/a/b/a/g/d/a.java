package e.f.a.b.a.g.d;

import android.annotation.SuppressLint;
import android.database.Cursor;
import androidx.core.app.NotificationCompat;
import defpackage.b;
import f.z.d.g;
import f.z.d.j;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class a {
    public static final C0253a m = new C0253a(null);
    public final String a;
    public final long b;
    public final int c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f1467d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f1468e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f1469f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f1470g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f1471h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f1472i;
    public final String j;
    public final String k;
    public final JSONObject l;

    /* JADX INFO: renamed from: e.f.a.b.a.g.d.a$a, reason: collision with other inner class name */
    public static final class C0253a {
        public C0253a() {
        }

        @SuppressLint({"Range"})
        public final a a(Cursor cursor) {
            if (cursor == null) {
                return null;
            }
            String string = cursor.getString(cursor.getColumnIndex("proc"));
            j.b(string, "cursor.getString(cursor.…ble.COLUMN_PROCESS_NAME))");
            long j = cursor.getLong(cursor.getColumnIndex("ts"));
            int i2 = cursor.getInt(cursor.getColumnIndex("reason"));
            String string2 = cursor.getString(cursor.getColumnIndex("reason_str"));
            j.b(string2, "cursor.getString(cursor.…Table.COLUMN_REASON_STR))");
            int i3 = cursor.getInt(cursor.getColumnIndex("sub_reason"));
            String string3 = cursor.getString(cursor.getColumnIndex("sub_reason_str"));
            j.b(string3, "cursor.getString(cursor.…e.COLUMN_SUB_REASON_STR))");
            int i4 = cursor.getInt(cursor.getColumnIndex("is_foreground"));
            int i5 = cursor.getInt(cursor.getColumnIndex(NotificationCompat.CATEGORY_STATUS));
            int i6 = cursor.getInt(cursor.getColumnIndex("importance"));
            String string4 = cursor.getString(cursor.getColumnIndex("importance_str"));
            j.b(string4, "cursor.getString(cursor.…e.COLUMN_IMPORTANCE_STR))");
            String string5 = cursor.getString(cursor.getColumnIndex("att_file"));
            j.b(string5, "cursor.getString(cursor.…able.COLUMN_ATTACH_FILE))");
            return new a(string, j, i2, string2, i3, string3, i4, i5, i6, string4, string5, new JSONObject(cursor.getString(cursor.getColumnIndex("extra"))));
        }

        public /* synthetic */ C0253a(g gVar) {
            this();
        }
    }

    public a(String str, long j, int i2, String str2, int i3, String str3, int i4, int i5, int i6, String str4, String str5, JSONObject jSONObject) {
        j.f(str, "processName");
        j.f(str2, "reasonStr");
        j.f(str3, "subReasonStr");
        j.f(str4, "importanceStr");
        j.f(str5, "attachFile");
        j.f(jSONObject, "extra");
        this.a = str;
        this.b = j;
        this.c = i2;
        this.f1467d = str2;
        this.f1468e = i3;
        this.f1469f = str3;
        this.f1470g = i4;
        this.f1471h = i5;
        this.f1472i = i6;
        this.j = str4;
        this.k = str5;
        this.l = jSONObject;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return j.a(this.a, aVar.a) && this.b == aVar.b && this.c == aVar.c && j.a(this.f1467d, aVar.f1467d) && this.f1468e == aVar.f1468e && j.a(this.f1469f, aVar.f1469f) && this.f1470g == aVar.f1470g && this.f1471h == aVar.f1471h && this.f1472i == aVar.f1472i && j.a(this.j, aVar.j) && j.a(this.k, aVar.k) && j.a(this.l, aVar.l);
    }

    public int hashCode() {
        String str = this.a;
        int iHashCode = (((((str != null ? str.hashCode() : 0) * 31) + b.a(this.b)) * 31) + this.c) * 31;
        String str2 = this.f1467d;
        int iHashCode2 = (((iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + this.f1468e) * 31;
        String str3 = this.f1469f;
        int iHashCode3 = (((((((iHashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31) + this.f1470g) * 31) + this.f1471h) * 31) + this.f1472i) * 31;
        String str4 = this.j;
        int iHashCode4 = (iHashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.k;
        int iHashCode5 = (iHashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        JSONObject jSONObject = this.l;
        return iHashCode5 + (jSONObject != null ? jSONObject.hashCode() : 0);
    }

    public String toString() {
        return "ProcessExitReasonData(processName=" + this.a + ", timestamp=" + this.b + ", reason=" + this.c + ", reasonStr=" + this.f1467d + ", subReason=" + this.f1468e + ", subReasonStr=" + this.f1469f + ", isForeground=" + this.f1470g + ", status=" + this.f1471h + ", importance=" + this.f1472i + ", importanceStr=" + this.j + ", attachFile=" + this.k + ", extra=" + this.l + ")";
    }
}
