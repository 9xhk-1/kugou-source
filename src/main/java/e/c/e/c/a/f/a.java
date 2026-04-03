package e.c.e.c.a.f;

import android.support.annotation.NonNull;
import e.c.e.c.a.c;

/* JADX INFO: loaded from: classes2.dex */
public class a<T> implements c.a {

    @NonNull
    public e.c.e.b.e.e<T> a;

    public a(@NonNull e.c.e.b.e.e<T> eVar) {
        this.a = eVar;
    }

    @Override // e.c.e.c.a.c.a
    public void pause() {
        this.a.audio().pause();
    }

    @Override // e.c.e.c.a.c.a
    public void play() {
        this.a.audio().play();
    }

    @Override // e.c.e.c.a.c.a
    public void seekTo(int i2) {
        this.a.audio().seekTo(i2);
    }

    @Override // e.c.e.c.a.c.a
    public void setVolume(float f2) {
        this.a.audio().setVolume(f2);
    }

    @Override // e.c.e.c.a.c.a
    public void updateEndPosition(long j) {
        this.a.audio().updateEndPosition(j);
    }
}
