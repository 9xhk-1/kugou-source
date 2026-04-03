package e.c.e.b.e;

import android.support.annotation.NonNull;
import com.kugou.common.player.kgplayer.PlayStream;
import com.kugou.common.player.kugouplayer.AudioTypeInfo;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public interface d<T> {

    public static class a<T> {
        public String a;

        public e.c.e.b.e.a<T> a() {
            String str = this.a;
            Objects.requireNonNull(str, "must set the name");
            return new e.c.e.b.e.a<>(str);
        }

        public a<T> b(String str) {
            this.a = str;
            return this;
        }
    }

    public interface b<T> {
        void addListener(e.c.e.b.d.a aVar);

        void addSyncListener(e.c.e.b.d.a aVar);

        int getBufferedPosition();

        int getCurrentPosition();

        T getCurrentSong();

        int getDuration();

        int getPlayStatus();

        int getToken();

        boolean isBuffering();

        boolean isCore();

        boolean isPlaying();

        boolean isPrepared();

        void loadDataSource(T t, boolean z);

        void loadDataSource(T t, boolean z, long j, long j2);

        void pause();

        void play();

        void prepareAsync();

        void reset();

        void seekTo(int i2);

        void setDataSource(PlayStream playStream, long j, long j2, AudioTypeInfo audioTypeInfo);

        void setDataSource(String str, long j, long j2, AudioTypeInfo audioTypeInfo);

        void setDirector(c<T> cVar);

        void setPlayControlMember(e.c.e.b.a.a aVar);

        void setVolume(float f2);

        void stop();

        void updateEndPosition(long j);
    }

    public interface c<T> {
        void loadDataSource(T t, boolean z, long j, long j2);
    }

    /* JADX INFO: renamed from: e.c.e.b.e.d$d, reason: collision with other inner class name */
    public interface InterfaceC0231d {
        int[] getLocalPlaySpeedCache();
    }

    public interface e {
    }

    @NonNull
    b<T> audio();

    @NonNull
    e.c.e.b.c.a extendManager();

    @NonNull
    InterfaceC0231d extra();

    void setAudio(@NonNull b<T> bVar);

    void setExtra(@NonNull InterfaceC0231d interfaceC0231d);

    void setVideo(@NonNull e eVar);

    @NonNull
    e video();
}
