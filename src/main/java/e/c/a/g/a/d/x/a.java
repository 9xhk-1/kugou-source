package e.c.a.g.a.d.x;

import com.kugou.android.watch.lite.common.music.entity.KGMusicWrapper;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public interface a {
    void append(List<KGMusicWrapper> list);

    void cancelNotification();

    int getBufferedPosition();

    int getCurrentIndex();

    int getCurrentPosition();

    KGMusicWrapper getCurrentSong();

    int getDuration();

    e.c.a.g.a.d.q.b getMediaSession();

    int getNextIndex();

    int getOnCompleteNextIndex();

    int getPlayMode();

    int getPlayStatus();

    int[] getPosAndDuration();

    int getPreviousIndex();

    List<KGMusicWrapper> getQueue();

    void insert(List<KGMusicWrapper> list, boolean z);

    boolean isBuffering();

    boolean isPlayListenPartMode(boolean z);

    boolean isPlaying();

    boolean isPrepared();

    void next();

    void pause();

    void pauseWhenExit();

    void play();

    boolean playByIndex(int i2, boolean z);

    void playSongList(List<KGMusicWrapper> list, int i2, boolean z);

    void previous();

    void refreshPlayQueue(String str);

    void seekTo(int i2);

    void setCurrentIndex(int i2);

    void setPlayMode(int i2, boolean z);

    void setQueue(List<KGMusicWrapper> list);

    void setVolume(float f2);

    int size();

    void updateEndPosition(long j);

    void updateForegroundState(boolean z);

    void updateListenPart(List<KGMusicWrapper> list);
}
