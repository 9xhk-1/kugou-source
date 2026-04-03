package e.c.e.b.c;

import android.support.annotation.NonNull;
import e.c.e.b.c.b;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public interface c extends b.a {

    public static class a extends b.a.C0215a implements c {
        public e.c.e.b.c.e.b getQueueActionHooker() {
            return null;
        }

        @Override // e.c.e.b.c.c
        public e.c.e.b.c.f.b getQueueStatusObserver() {
            return null;
        }

        @Override // e.c.e.b.c.b.a.C0215a, e.c.e.b.c.b.a
        public void init(@NonNull Map<Class, Object> map) {
            super.init(map);
            map.put(e.c.e.b.c.e.b.class, getQueueActionHooker());
            map.put(e.c.e.b.c.f.b.class, getQueueStatusObserver());
        }
    }

    @Override // e.c.e.b.c.b.a
    /* synthetic */ e.c.e.b.c.f.a getPlayerStatusObserver();

    e.c.e.b.c.e.b getQueueActionHooker();

    e.c.e.b.c.f.b getQueueStatusObserver();

    /* synthetic */ e.c.e.b.c.e.c getSongActionHooker();

    @Override // e.c.e.b.c.b.a
    /* synthetic */ e.c.e.b.c.f.c getSongStatusObserver();

    @Override // e.c.e.b.c.b.a
    /* synthetic */ void init(@NonNull Map<Class, Object> map);

    @Override // e.c.e.b.c.b.a
    /* synthetic */ <T> void register(Class<?> cls, T t);

    @Override // e.c.e.b.c.b.a
    /* synthetic */ <T> void unregister(Class<?> cls);
}
