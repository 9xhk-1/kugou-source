package e.c.a.g.a.d.f;

import android.database.SQLException;
import androidx.room.Insert;
import androidx.room.RawQuery;
import androidx.room.Update;
import androidx.sqlite.db.SimpleSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteQuery;
import e.c.a.g.a.d.f.c.a.i;
import e.c.a.g.a.s.g0;
import f.d;
import f.f;
import f.z.d.j;
import f.z.d.k;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Semaphore;

/* JADX INFO: loaded from: classes.dex */
public abstract class a<T> {
    public final Semaphore a = new Semaphore(1);
    public final d b = f.b(new C0048a(this));

    /* JADX INFO: renamed from: e.c.a.g.a.d.f.a$a, reason: collision with other inner class name */
    public static final class C0048a extends k implements f.z.c.a<String> {
        public final /* synthetic */ a<T> a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0048a(a<T> aVar) {
            super(0);
            this.a = aVar;
        }

        @Override // f.z.c.a
        public final String invoke() {
            String simpleName;
            Type genericSuperclass = this.a.getClass().getSuperclass().getGenericSuperclass();
            Objects.requireNonNull(genericSuperclass, "null cannot be cast to non-null type java.lang.reflect.ParameterizedType");
            Type type = ((ParameterizedType) genericSuperclass).getActualTypeArguments()[0];
            Objects.requireNonNull(type, "null cannot be cast to non-null type java.lang.Class<*>");
            Class cls = (Class) type;
            try {
                simpleName = ((i) Class.forName(cls.getCanonicalName()).getAnnotation(i.class)).tableName();
            } catch (Exception unused) {
                simpleName = cls.getSimpleName();
            }
            if (g0.a) {
                g0.b("ez", j.l("getTableName: -->", simpleName));
            }
            return simpleName;
        }
    }

    public final int a() {
        return b(new SimpleSQLiteQuery(j.l("delete from ", c())));
    }

    @RawQuery
    public abstract int b(SupportSQLiteQuery supportSQLiteQuery);

    public final String c() {
        Object value = this.b.getValue();
        j.d(value, "<get-tableName>(...)");
        return (String) value;
    }

    public final long d(T t) {
        long jF;
        try {
            try {
                this.a.acquire();
                jF = f(t);
            } catch (SQLException e2) {
                g0.k(e2);
                jF = -1;
            }
            return jF;
        } finally {
            this.a.release();
        }
    }

    @Insert(onConflict = 1)
    public abstract List<Long> e(List<? extends T> list);

    @Insert(onConflict = 1)
    public abstract long f(T t);

    @Update
    public abstract int g(T... tArr);
}
