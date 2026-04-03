package e.c.e.b.e;

import android.support.annotation.NonNull;
import e.c.e.b.e.d;
import e.c.e.b.f.c;
import e.c.e.b.f.d;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public interface e<T> extends d<T> {

    public static class a<T> {
        public String a;

        public e.c.e.b.e.b<T> a() {
            String str = this.a;
            Objects.requireNonNull(str, "must set the name");
            return new e.c.e.b.e.b<>(str);
        }

        public a<T> b(String str) {
            this.a = str;
            return this;
        }
    }

    public interface b<T> {
        void clear();

        int getCurrentIndex();

        e.c.e.b.f.c getMode();

        int getNextIndex();

        int getOnCompleteNextIndex();

        int getPreviousIndex();

        List<T> getQueue();

        e.c.e.b.f.d<T> getQueueList();

        int getSize();

        boolean insert(int i2, List<T> list);

        void next();

        void playByIndex(int i2, boolean z);

        void playSongList(List<T> list, int i2, boolean z);

        void previous();

        void registerObserver(c<T> cVar);

        T remove(int i2);

        void setCurrentIndex(int i2);

        void setMode(e.c.e.b.f.c cVar);

        void setQueue(List<T> list);

        void setQueueList(e.c.e.b.f.d<T> dVar);

        void unregisterObserver(c<T> cVar);
    }

    public interface c<T> extends d.a<T>, c.a {
        @Override // e.c.e.b.f.d.a
        /* synthetic */ void onClear();

        @Override // e.c.e.b.f.c.a
        /* synthetic */ void onIndexChange(int i2, int i3);

        @Override // e.c.e.b.f.d.a
        /* synthetic */ void onInsert(int i2, List<T> list);

        @Override // e.c.e.b.f.d.a
        /* synthetic */ void onQueueChange();

        @Override // e.c.e.b.f.d.a
        /* synthetic */ void onRemove(int i2, T t);

        @Override // e.c.e.b.f.d.a
        /* synthetic */ void onSetQueue(List<T> list);

        @Override // e.c.e.b.f.d.a
        /* synthetic */ void onUpdate(int i2, T t);
    }

    @Override // e.c.e.b.e.d
    @NonNull
    /* synthetic */ d.b<T> audio();

    @Override // e.c.e.b.e.d
    @NonNull
    /* synthetic */ e.c.e.b.c.a extendManager();

    @Override // e.c.e.b.e.d
    @NonNull
    /* synthetic */ d.InterfaceC0231d extra();

    b<T> queue();

    @Override // e.c.e.b.e.d
    /* synthetic */ void setAudio(@NonNull d.b<T> bVar);

    @Override // e.c.e.b.e.d
    /* synthetic */ void setExtra(@NonNull d.InterfaceC0231d interfaceC0231d);

    @Override // e.c.e.b.e.d
    /* synthetic */ void setVideo(@NonNull d.e eVar);

    @Override // e.c.e.b.e.d
    @NonNull
    /* synthetic */ d.e video();
}
