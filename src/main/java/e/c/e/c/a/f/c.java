package e.c.e.c.a.f;

import android.support.annotation.NonNull;
import e.c.e.c.a.c;

/* JADX INFO: loaded from: classes2.dex */
public class c<T> implements c.b<T> {

    @NonNull
    public final e.c.e.b.e.e<T> a;

    @NonNull
    public final e.c.e.b.g.a<e.c.e.c.a.b> b;

    public c(@NonNull e.c.e.b.e.e<T> eVar, @NonNull e.c.e.b.g.a<e.c.e.c.a.b> aVar) {
        this.a = eVar;
        this.b = aVar;
    }

    @Override // e.c.e.c.a.c.b
    public boolean addListener(e.c.e.c.a.b bVar) {
        return this.b.e(bVar);
    }

    @Override // e.c.e.c.a.c.b
    public int getBufferedPosition() {
        return this.a.audio().getBufferedPosition();
    }

    @Override // e.c.e.c.a.c.b
    public int getCurrentPosition() {
        return this.a.audio().getCurrentPosition();
    }

    @Override // e.c.e.c.a.c.b
    public T getCurrentSong() {
        return this.a.audio().getCurrentSong();
    }

    @Override // e.c.e.c.a.c.b
    public int getDuration() {
        return this.a.audio().getDuration();
    }

    @Override // e.c.e.c.a.c.b
    public int getPlayStatus() {
        return this.a.audio().getPlayStatus();
    }

    @Override // e.c.e.c.a.c.b
    public boolean isBuffering() {
        return this.a.audio().isBuffering();
    }

    @Override // e.c.e.c.a.c.b
    public boolean isPlaying() {
        return this.a.audio().isPlaying();
    }

    @Override // e.c.e.c.a.c.b
    public boolean isPrepared() {
        return this.a.audio().isPrepared();
    }

    @Override // e.c.e.c.a.c.b
    public boolean removeListener(e.c.e.c.a.b bVar) {
        return this.b.f(bVar);
    }
}
