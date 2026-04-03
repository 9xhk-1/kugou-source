package e.c.e.b.c;

import android.support.annotation.NonNull;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public interface b {

    public interface a {

        /* JADX INFO: renamed from: e.c.e.b.c.b$a$a, reason: collision with other inner class name */
        public static class C0215a implements a {
            public Map<Class, Object> a;

            @Override // e.c.e.b.c.b.a
            public e.c.e.b.c.f.a getPlayerStatusObserver() {
                return null;
            }

            @Override // e.c.e.b.c.b.a, e.c.e.b.c.c, e.c.e.c.a.a
            public e.c.e.b.c.e.c getSongActionHooker() {
                return null;
            }

            @Override // e.c.e.b.c.b.a
            public e.c.e.b.c.f.c getSongStatusObserver() {
                return null;
            }

            @Override // e.c.e.b.c.b.a
            public void init(Map<Class, Object> map) {
                this.a = map;
                map.put(e.c.e.b.c.f.a.class, getPlayerStatusObserver());
                map.put(e.c.e.b.c.f.c.class, getSongStatusObserver());
                map.put(e.c.e.b.c.e.c.class, getSongActionHooker());
            }

            @Override // e.c.e.b.c.b.a
            public <T> void register(Class<?> cls, T t) {
                this.a.put(cls, t);
            }

            @Override // e.c.e.b.c.b.a
            public <T> void unregister(Class<?> cls) {
                this.a.remove(cls);
            }
        }

        e.c.e.b.c.f.a getPlayerStatusObserver();

        e.c.e.b.c.e.c getSongActionHooker();

        e.c.e.b.c.f.c getSongStatusObserver();

        void init(@NonNull Map<Class, Object> map);

        <T> void register(Class<?> cls, T t);

        <T> void unregister(Class<?> cls);
    }

    a getProvider();
}
