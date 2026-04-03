package e.c.e.c.a;

import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public interface c<T> {

    public interface a {
        void pause();

        void play();

        void seekTo(int i2);

        void setVolume(float f2);

        void updateEndPosition(long j);
    }

    public interface b<T> {
        boolean addListener(e.c.e.c.a.b bVar);

        int getBufferedPosition();

        int getCurrentPosition();

        T getCurrentSong();

        int getDuration();

        int getPlayStatus();

        boolean isBuffering();

        boolean isPlaying();

        boolean isPrepared();

        boolean removeListener(e.c.e.c.a.b bVar);
    }

    /* JADX INFO: renamed from: e.c.e.c.a.c$c, reason: collision with other inner class name */
    public interface InterfaceC0238c<T> {
        void append(List<T> list);

        int getCurrentIndex();

        int getNextIndex();

        int getOnCompleteNextIndex();

        int getPlayMode();

        int getPreviousIndex();

        List<T> getQueue();

        void insert(int i2, List<T> list);

        void next();

        boolean playByIndex(int i2, boolean z);

        void playSongList(List<T> list, int i2, boolean z);

        void previous();

        void setCurrentIndex(int i2);

        void setPlayMode(int i2);

        void setPlayMode(int i2, boolean z);

        void setQueue(List<T> list);

        int size();
    }

    a getIControl();

    b<T> getIInfo();

    InterfaceC0238c<T> getIQueue();
}
