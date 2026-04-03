package e.c.e.c.a;

import android.support.annotation.NonNull;
import e.c.e.b.c.c;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public interface a extends e.c.e.b.c.c {

    /* JADX INFO: renamed from: e.c.e.c.a.a$a, reason: collision with other inner class name */
    public static class C0237a extends c.a implements a {
        public e.c.e.c.a.e.a getMainPlayerHooker() {
            return null;
        }

        @Override // e.c.e.b.c.c.a, e.c.e.b.c.b.a.C0215a, e.c.e.b.c.b.a
        public void init(@NonNull Map<Class, Object> map) {
            super.init(map);
            map.put(e.c.e.c.a.e.a.class, getMainPlayerHooker());
        }
    }

    e.c.e.c.a.e.a getMainPlayerHooker();

    @Override // e.c.e.b.c.c, e.c.e.b.c.b.a
    /* synthetic */ e.c.e.b.c.f.a getPlayerStatusObserver();

    @Override // e.c.e.b.c.c
    /* synthetic */ e.c.e.b.c.e.b getQueueActionHooker();

    @Override // e.c.e.b.c.c
    /* synthetic */ e.c.e.b.c.f.b getQueueStatusObserver();

    /* synthetic */ e.c.e.b.c.e.c getSongActionHooker();

    @Override // e.c.e.b.c.c, e.c.e.b.c.b.a
    /* synthetic */ e.c.e.b.c.f.c getSongStatusObserver();

    @Override // e.c.e.b.c.c, e.c.e.b.c.b.a
    /* synthetic */ void init(@NonNull Map<Class, Object> map);

    @Override // e.c.e.b.c.c, e.c.e.b.c.b.a
    /* synthetic */ <T> void register(Class<?> cls, T t);

    @Override // e.c.e.b.c.c, e.c.e.b.c.b.a
    /* synthetic */ <T> void unregister(Class<?> cls);
}
