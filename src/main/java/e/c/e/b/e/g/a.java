package e.c.e.b.e.g;

import com.kugou.common.player.kgplayer.PlayStream;
import com.kugou.common.player.kugouplayer.AudioTypeInfo;
import e.c.e.b.e.d;

/* JADX INFO: loaded from: classes2.dex */
public class a<T> implements d.b<T> {
    public d.b<T> a;

    public a(d.b<T> bVar) {
        this.a = bVar;
    }

    @Override // e.c.e.b.e.d.b
    public void addListener(e.c.e.b.d.a aVar) {
        this.a.addListener(aVar);
    }

    @Override // e.c.e.b.e.d.b
    public void addSyncListener(e.c.e.b.d.a aVar) {
        this.a.addSyncListener(aVar);
    }

    @Override // e.c.e.b.e.d.b
    public int getBufferedPosition() {
        return this.a.getBufferedPosition();
    }

    @Override // e.c.e.b.e.d.b
    public int getCurrentPosition() {
        return this.a.getCurrentPosition();
    }

    @Override // e.c.e.b.e.d.b
    public T getCurrentSong() {
        return this.a.getCurrentSong();
    }

    @Override // e.c.e.b.e.d.b
    public int getDuration() {
        return this.a.getDuration();
    }

    @Override // e.c.e.b.e.d.b
    public int getPlayStatus() {
        return this.a.getPlayStatus();
    }

    @Override // e.c.e.b.e.d.b
    public int getToken() {
        return this.a.getToken();
    }

    @Override // e.c.e.b.e.d.b
    public boolean isBuffering() {
        return this.a.isBuffering();
    }

    @Override // e.c.e.b.e.d.b
    public boolean isCore() {
        return this.a.isCore();
    }

    @Override // e.c.e.b.e.d.b
    public boolean isPlaying() {
        return this.a.isPlaying();
    }

    @Override // e.c.e.b.e.d.b
    public boolean isPrepared() {
        return this.a.isPrepared();
    }

    @Override // e.c.e.b.e.d.b
    public void loadDataSource(T t, boolean z) {
        this.a.loadDataSource(t, z);
    }

    @Override // e.c.e.b.e.d.b
    public void pause() {
        this.a.pause();
    }

    @Override // e.c.e.b.e.d.b
    public void play() {
        this.a.play();
    }

    @Override // e.c.e.b.e.d.b
    public void prepareAsync() {
        this.a.prepareAsync();
    }

    @Override // e.c.e.b.e.d.b
    public void reset() {
        this.a.reset();
    }

    @Override // e.c.e.b.e.d.b
    public void seekTo(int i2) {
        this.a.seekTo(i2);
    }

    @Override // e.c.e.b.e.d.b
    public void setDataSource(String str, long j, long j2, AudioTypeInfo audioTypeInfo) {
        this.a.setDataSource(str, j, j2, audioTypeInfo);
    }

    @Override // e.c.e.b.e.d.b
    public void setDirector(d.c<T> cVar) {
        this.a.setDirector(cVar);
    }

    @Override // e.c.e.b.e.d.b
    public void setPlayControlMember(e.c.e.b.a.a aVar) {
        this.a.setPlayControlMember(aVar);
    }

    @Override // e.c.e.b.e.d.b
    public void setVolume(float f2) {
        this.a.setVolume(f2);
    }

    @Override // e.c.e.b.e.d.b
    public void stop() {
        this.a.stop();
    }

    @Override // e.c.e.b.e.d.b
    public void updateEndPosition(long j) {
        this.a.updateEndPosition(j);
    }

    @Override // e.c.e.b.e.d.b
    public void loadDataSource(T t, boolean z, long j, long j2) {
        this.a.loadDataSource(t, z, j, j2);
    }

    @Override // e.c.e.b.e.d.b
    public void setDataSource(PlayStream playStream, long j, long j2, AudioTypeInfo audioTypeInfo) {
        this.a.setDataSource(playStream, j, j2, audioTypeInfo);
    }
}
