package com.kugou.common.player.kgplayer;

import android.content.Context;
import android.os.Looper;
import android.os.Message;
import android.view.SurfaceHolder;
import com.kugou.common.player.kugouplayer.AudioInfo;
import com.kugou.common.player.kugouplayer.AudioTypeInfo;
import com.kugou.common.player.kugouplayer.PlayController;
import e.c.e.b.b.b;
import e.c.e.b.e.c;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public abstract class KGPlayer implements PlayState, c {
    public static final int KPLAYER_ACCOMPANY_TRACK = 0;
    public static final int KPLAYER_LAST_TRACK = 99;
    public static final int KPLAYER_MIX_TRACK = 98;
    public static final int KPLAYER_THIRD_TRACK = 2;
    public static final int KPLAYER_VOICE_TRACK = 1;
    public static final int LOOP_INFINITE = -1;
    public static int NO_DEFINED_VIDEO = 0;
    private static final String TAG = "KGPlayer";
    public static int USED_PLUGIN_VIDEO = 1;
    public String dataSource;
    public c.b mOnBufferingUpdateListener;
    public c.InterfaceC0230c mOnCompletionListener;
    public c.d mOnErrorListener;
    public c.e mOnInfoListener;
    public c.f mOnKGPlayerMessageListener;
    public c.g mOnPreparedListener;
    public c.h mOnSeekComplectionListener;
    public OnVideoSizeChangedListener mOnVideoSizeChangedListener;
    public int mBufferSize = 0;
    public int mDuration = 0;
    public boolean isPrepared = false;
    public boolean isBuffering = false;
    public int hasBufferedPercent = 0;

    public interface IKGVideoPlayerListener extends c.a, OnVideoSizeChangedListener {
        @Override // e.c.e.b.e.c.a, e.c.e.b.e.c.b
        /* synthetic */ void onBufferingUpdate(KGPlayer kGPlayer, int i2);

        @Override // e.c.e.b.e.c.a, e.c.e.b.e.c.InterfaceC0230c
        /* synthetic */ void onCompletion(KGPlayer kGPlayer);

        @Override // e.c.e.b.e.c.a, e.c.e.b.e.c.d
        /* synthetic */ void onError(KGPlayer kGPlayer, int i2, int i3);

        @Override // e.c.e.b.e.c.a, e.c.e.b.e.c.e
        /* synthetic */ void onInfo(KGPlayer kGPlayer, int i2, int i3);

        @Override // e.c.e.b.e.c.a, e.c.e.b.e.c.e
        /* synthetic */ void onInfo(KGPlayer kGPlayer, int i2, int i3, String str);

        @Override // e.c.e.b.e.c.a, e.c.e.b.e.c.e
        /* synthetic */ void onInfo(KGPlayer kGPlayer, int i2, int i3, byte[] bArr);

        @Override // e.c.e.b.e.c.a, e.c.e.b.e.c.f
        /* synthetic */ void onPlayerMessageReceived(KGPlayer kGPlayer, Message message);

        @Override // e.c.e.b.e.c.a, e.c.e.b.e.c.g
        /* synthetic */ void onPrepared(KGPlayer kGPlayer);

        @Override // e.c.e.b.e.c.a, e.c.e.b.e.c.h
        /* synthetic */ void onSeekComplete(KGPlayer kGPlayer);
    }

    public interface OnVideoSizeChangedListener {
        void onVideoSizeChanged(KGPlayer kGPlayer, int i2, int i3);
    }

    public abstract void addPreloadDataSource(String str, AudioTypeInfo audioTypeInfo);

    public abstract void disablePlayerListener();

    public abstract void enableExtendAudioTrack(boolean z);

    public abstract void enablePlayerListener();

    public int getAudioInfo(AudioInfo audioInfo) {
        return -1;
    }

    public abstract int getAudioTrackCount();

    public abstract int getBufferSize();

    public abstract int getCurrentPosition();

    @Override // e.c.e.b.e.c
    public int getDuration() {
        return this.mDuration;
    }

    public abstract int getLoopCount();

    public abstract int getPlayStatus();

    public abstract int getRtmpAccompanyPts();

    public abstract int getStreamErrorCode();

    public abstract int getStreamPlayMode();

    public abstract int getStreamStatus();

    public abstract long getTimeMachineVideoTime();

    public abstract int getVideoHeight();

    public abstract int getVideoWidth();

    public boolean isBuffering() {
        return this.isBuffering;
    }

    public abstract boolean isCorePlayer();

    public abstract boolean isExtendAudioTrackEnabled();

    public boolean isLooping() {
        return false;
    }

    public boolean isNetPlay() {
        String str = this.dataSource;
        return str == null || !str.startsWith("/");
    }

    public abstract boolean isPlaying();

    public boolean isPrepared() {
        return this.isPrepared;
    }

    public abstract boolean isStop();

    public void pause() {
        this.isBuffering = false;
    }

    public synchronized void prepare() {
        this.isBuffering = true;
    }

    public synchronized void prepareAsync() {
        this.isBuffering = true;
    }

    public abstract void release();

    public abstract void render();

    public synchronized void reset() {
        this.mDuration = 0;
        this.dataSource = null;
        this.mBufferSize = 0;
        this.isPrepared = false;
        this.isBuffering = false;
    }

    public abstract void seekTo(int i2);

    public void sendCommand(int i2) {
    }

    public abstract void setArea(int i2, int i3, int i4, int i5);

    public abstract void setAudioModeParam(boolean z, int i2);

    public synchronized void setDataSource(String str) {
        if (b.f().debug()) {
            b.f().d(TAG, "setDataSource:" + str);
        }
        this.dataSource = str;
    }

    public abstract void setDisplay(Object obj);

    public void setFileId(String str) {
        if (b.f().debug()) {
            b.f().d(TAG, "setFileId fileId:" + str);
        }
    }

    public abstract void setHardwareDecodeMode(boolean z);

    @Override // e.c.e.b.e.c
    public void setIKGPlayerListener(c.a aVar) {
        setOnCompletionListener(aVar);
        setOnErrorListener(aVar);
        setOnInfoListener(aVar);
        setOnPreparedListener(aVar);
        setOnSeekComplectionListener(aVar);
        setOnBufferingUpdateListener(aVar);
        setOnKGPlayerMessageListener(aVar);
        if (aVar instanceof OnVideoSizeChangedListener) {
            setOnVideoSizeChangedListener((OnVideoSizeChangedListener) aVar);
        } else {
            setOnVideoSizeChangedListener(null);
        }
    }

    public abstract void setLoop(int i2);

    public abstract void setLooper(Looper looper);

    public void setLooping(boolean z) {
    }

    public synchronized void setLyricTimes(int[] iArr, int i2) {
    }

    public void setMvFileIdAndBufferThreshold(String str, int i2) {
        if (b.f().debug()) {
            b.f().d(TAG, "setMvFileIdAndBufferThreshold fileId:" + str + " buffThreshold:" + i2);
        }
    }

    public synchronized void setNoFixTimes(float[] fArr) {
    }

    public void setOnBufferingUpdateListener(c.b bVar) {
        this.mOnBufferingUpdateListener = bVar;
    }

    public void setOnCompletionListener(c.InterfaceC0230c interfaceC0230c) {
        this.mOnCompletionListener = interfaceC0230c;
    }

    public void setOnErrorListener(c.d dVar) {
        this.mOnErrorListener = dVar;
    }

    public void setOnInfoListener(c.e eVar) {
        this.mOnInfoListener = eVar;
    }

    public void setOnKGPlayerMessageListener(c.f fVar) {
        this.mOnKGPlayerMessageListener = fVar;
    }

    public void setOnPreparedListener(c.g gVar) {
        this.mOnPreparedListener = gVar;
    }

    public void setOnSeekComplectionListener(c.h hVar) {
        this.mOnSeekComplectionListener = hVar;
    }

    public void setOnVideoSizeChangedListener(OnVideoSizeChangedListener onVideoSizeChangedListener) {
        this.mOnVideoSizeChangedListener = onVideoSizeChangedListener;
    }

    public synchronized void setOneKeyPlay(String str, String str2, String str3, String str4, String str5, long j, long j2, int i2) {
        if (b.f().debug()) {
            b.f().d(TAG, "setOneKeyPlay:" + str);
        }
    }

    public synchronized void setOnekeyPlayOrigin(boolean z, long j) {
    }

    public void setProxyServer(String str, int i2) {
    }

    public void setRTMPTimeout(int i2) {
    }

    public void setStuckTimeOut(int i2, int i3) {
    }

    public abstract void setSurface(SurfaceHolder surfaceHolder);

    public abstract void setSurfaceInvalid(boolean z);

    public native void setUnicomProxy(String str);

    public void setUnicomProxy(Map<String, String> map) {
    }

    public abstract void setVideoSourceType(boolean z);

    public void setVoiceMoveStep(int i2) {
    }

    public native void setVolume(float f2);

    public abstract void setVolume(int i2, int i3);

    public abstract void setVolumeBalance(float f2, float f3);

    public abstract void setVolumeRate(float f2, float f3);

    public abstract void setWakeMode(Context context, int i2);

    public abstract void start();

    public void stop() {
        this.isBuffering = false;
    }

    public synchronized void setDataSource(String str, AudioTypeInfo audioTypeInfo) {
        if (b.f().debug()) {
            b.f().d(TAG, "setDataSource:" + str);
        }
        this.dataSource = str;
    }

    public synchronized void setDataSource(String str, long j, long j2, AudioTypeInfo audioTypeInfo) {
        if (b.f().debug()) {
            b.f().d(TAG, "setDataSource:" + str);
        }
        this.dataSource = str;
    }

    public synchronized void setDataSource(String str, long j) {
        if (b.f().debug()) {
            b.f().d(TAG, "setDataSource:" + str);
        }
        this.dataSource = str;
    }

    public synchronized void setDataSource(PlayController.PlayParam playParam) {
        if (playParam != null) {
            this.dataSource = playParam.path;
        }
    }

    public synchronized void setDataSource(String str, long j, long j2) {
        if (b.f().debug()) {
            b.f().d(TAG, "setDataSource:" + str);
        }
        this.dataSource = str;
    }

    public synchronized void setDataSource(PlayStream playStream) {
        setDataSource(playStream, 0L, 0L);
    }

    public synchronized void setDataSource(PlayStream playStream, long j) {
        if (b.f().debug()) {
            b.f().d(TAG, "setDataSource:" + playStream);
        }
    }

    public synchronized void setDataSource(PlayStream playStream, long j, long j2, AudioTypeInfo audioTypeInfo) {
        if (b.f().debug()) {
            b.f().d(TAG, "setDataSource:" + playStream);
        }
    }

    public synchronized void setDataSource(PlayStream playStream, long j, long j2) {
        if (b.f().debug()) {
            b.f().d(TAG, "setDataSource:" + playStream);
        }
    }
}
