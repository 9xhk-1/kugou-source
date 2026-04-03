package e.c.e.b.e;

import android.os.Message;
import com.kugou.common.player.kgplayer.KGPlayer;
import com.kugou.common.player.kgplayer.PlayStream;
import com.kugou.common.player.kugouplayer.AudioTypeInfo;

/* JADX INFO: loaded from: classes2.dex */
public interface c {

    public interface a extends g, InterfaceC0230c, d, e, h, b, f {
        /* synthetic */ void onBufferingUpdate(KGPlayer kGPlayer, int i2);

        /* synthetic */ void onCompletion(KGPlayer kGPlayer);

        /* synthetic */ void onError(KGPlayer kGPlayer, int i2, int i3);

        /* synthetic */ void onInfo(KGPlayer kGPlayer, int i2, int i3);

        /* synthetic */ void onInfo(KGPlayer kGPlayer, int i2, int i3, String str);

        /* synthetic */ void onInfo(KGPlayer kGPlayer, int i2, int i3, byte[] bArr);

        /* synthetic */ void onPlayerMessageReceived(KGPlayer kGPlayer, Message message);

        @Override // e.c.e.b.e.c.g
        /* synthetic */ void onPrepared(KGPlayer kGPlayer);

        /* synthetic */ void onSeekComplete(KGPlayer kGPlayer);
    }

    public interface b {
        void onBufferingUpdate(KGPlayer kGPlayer, int i2);
    }

    /* JADX INFO: renamed from: e.c.e.b.e.c$c, reason: collision with other inner class name */
    public interface InterfaceC0230c {
        void onCompletion(KGPlayer kGPlayer);
    }

    public interface d {
        void onError(KGPlayer kGPlayer, int i2, int i3);
    }

    public interface e {
        void onInfo(KGPlayer kGPlayer, int i2, int i3);

        void onInfo(KGPlayer kGPlayer, int i2, int i3, String str);

        void onInfo(KGPlayer kGPlayer, int i2, int i3, byte[] bArr);
    }

    public interface f {
        void onPlayerMessageReceived(KGPlayer kGPlayer, Message message);
    }

    public interface g {
        void onPrepared(KGPlayer kGPlayer);
    }

    public interface h {
        void onSeekComplete(KGPlayer kGPlayer);
    }

    int getBufferSize();

    int getCurrentPosition();

    int getDuration();

    int getPlayStatus();

    boolean isBuffering();

    boolean isPlaying();

    void pause();

    void prepareAsync();

    void reset();

    void seekTo(int i2);

    void setDataSource(PlayStream playStream, long j, long j2);

    void setDataSource(PlayStream playStream, long j, long j2, AudioTypeInfo audioTypeInfo);

    void setDataSource(String str, long j, long j2);

    void setDataSource(String str, long j, long j2, AudioTypeInfo audioTypeInfo);

    void setIKGPlayerListener(a aVar);

    void setVolume(float f2);

    void start();

    void stop();
}
