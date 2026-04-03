package com.kugou.common.player.kgplayer;

import android.content.Context;
import android.os.Looper;
import android.os.Message;
import android.view.SurfaceHolder;
import androidx.core.app.NotificationManagerCompat;
import com.kugou.common.player.kugouplayer.AudioInfo;
import com.kugou.common.player.kugouplayer.AudioTypeInfo;
import com.kugou.common.player.kugouplayer.PlayController;
import e.c.e.b.b.b;
import e.c.e.b.e.c;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class KGCorePlayer extends KGPlayer {
    private static final String TAG = "KGCorePlayer";
    private Context mContext;
    private PlayStream mPlayStream;
    private PlayController mPlayer;
    private boolean isStreamSeted = false;
    private PlayController.OnCompletionListener innerCompletionListener = new PlayController.OnCompletionListener() { // from class: com.kugou.common.player.kgplayer.KGCorePlayer.1
        @Override // com.kugou.common.player.kugouplayer.PlayController.OnCompletionListener
        public void onCompletion(PlayController playController) {
            KGCorePlayer kGCorePlayer = KGCorePlayer.this;
            c.InterfaceC0230c interfaceC0230c = kGCorePlayer.mOnCompletionListener;
            if (interfaceC0230c != null) {
                interfaceC0230c.onCompletion(kGCorePlayer);
            }
        }
    };
    private PlayController.OnErrorListener innerErrorListener = new PlayController.OnErrorListener() { // from class: com.kugou.common.player.kgplayer.KGCorePlayer.2
        @Override // com.kugou.common.player.kugouplayer.PlayController.OnErrorListener
        public void onError(PlayController playController, int i2, int i3) {
            KGCorePlayer kGCorePlayer = KGCorePlayer.this;
            kGCorePlayer.isPrepared = false;
            kGCorePlayer.isBuffering = false;
            c.d dVar = kGCorePlayer.mOnErrorListener;
            if (dVar != null) {
                dVar.onError(kGCorePlayer, i2, i3);
            }
        }
    };
    private PlayController.OnPreparedListener innerPreparedListener = new PlayController.OnPreparedListener() { // from class: com.kugou.common.player.kgplayer.KGCorePlayer.3
        @Override // com.kugou.common.player.kugouplayer.PlayController.OnPreparedListener
        public void onPrepared(PlayController playController) {
            KGCorePlayer.this.mDuration = (int) playController.getDuration();
            if (b.f().debug()) {
                b.f().d(KGCorePlayer.TAG, "onBufferingUpdate: mDuration = " + KGCorePlayer.this.mDuration + ", hasBufferedPercent = " + KGCorePlayer.this.hasBufferedPercent);
            }
            KGCorePlayer kGCorePlayer = KGCorePlayer.this;
            kGCorePlayer.isBuffering = false;
            kGCorePlayer.isPrepared = true;
            if (kGCorePlayer.isNetPlay()) {
                PlayStream playStream = KGCorePlayer.this.mPlayStream;
                if (playStream != null) {
                    playStream.notifyBufferUpdate(KGCorePlayer.this.hasBufferedPercent);
                    KGCorePlayer.this.hasBufferedPercent = 0;
                }
            } else {
                KGCorePlayer kGCorePlayer2 = KGCorePlayer.this;
                kGCorePlayer2.mBufferSize = kGCorePlayer2.mDuration;
                c.b bVar = kGCorePlayer2.mOnBufferingUpdateListener;
                if (bVar != null) {
                    bVar.onBufferingUpdate(kGCorePlayer2, 100);
                }
            }
            KGCorePlayer kGCorePlayer3 = KGCorePlayer.this;
            c.g gVar = kGCorePlayer3.mOnPreparedListener;
            if (gVar != null) {
                gVar.onPrepared(kGCorePlayer3);
            }
        }
    };
    private PlayController.OnInfoListener innerInfoListener = new PlayController.OnInfoListener() { // from class: com.kugou.common.player.kgplayer.KGCorePlayer.4
        @Override // com.kugou.common.player.kugouplayer.PlayController.OnInfoListener
        public void onInfo(PlayController playController, int i2, int i3) {
            KGCorePlayer kGCorePlayer = KGCorePlayer.this;
            c.e eVar = kGCorePlayer.mOnInfoListener;
            if (eVar != null) {
                eVar.onInfo(kGCorePlayer, i2, i3);
            }
        }

        @Override // com.kugou.common.player.kugouplayer.PlayController.OnInfoListener
        public void onInfo(PlayController playController, int i2, int i3, String str) {
            KGCorePlayer kGCorePlayer = KGCorePlayer.this;
            c.e eVar = kGCorePlayer.mOnInfoListener;
            if (eVar != null) {
                eVar.onInfo(kGCorePlayer, i2, i3, str);
            }
        }
    };
    private c.b innnerBufferUpdateListener = new c.b() { // from class: com.kugou.common.player.kgplayer.KGCorePlayer.5
        @Override // e.c.e.b.e.c.b
        public void onBufferingUpdate(KGPlayer kGPlayer, int i2) {
            KGCorePlayer kGCorePlayer = KGCorePlayer.this;
            kGCorePlayer.hasBufferedPercent = i2;
            double d2 = i2;
            Double.isNaN(d2);
            double d3 = kGCorePlayer.mDuration;
            Double.isNaN(d3);
            kGCorePlayer.mBufferSize = (int) (((d2 * 1.0d) / 100.0d) * d3);
            if (b.f().debug()) {
                b.f().d(KGCorePlayer.TAG, "onBufferingUpdate: percent = " + i2 + ", mBufferSize = " + KGCorePlayer.this.mBufferSize + ", mDuration = " + KGCorePlayer.this.mDuration);
            }
            KGCorePlayer kGCorePlayer2 = KGCorePlayer.this;
            c.b bVar = kGCorePlayer2.mOnBufferingUpdateListener;
            if (bVar != null) {
                bVar.onBufferingUpdate(kGCorePlayer2, i2);
            }
        }
    };
    private PlayController.OnSeekCompleteListener innerOnSeekCompleteListener = new PlayController.OnSeekCompleteListener() { // from class: com.kugou.common.player.kgplayer.KGCorePlayer.6
        @Override // com.kugou.common.player.kugouplayer.PlayController.OnSeekCompleteListener
        public void onSeekComplete(PlayController playController) {
            KGCorePlayer kGCorePlayer = KGCorePlayer.this;
            kGCorePlayer.isPrepared = true;
            c.h hVar = kGCorePlayer.mOnSeekComplectionListener;
            if (hVar != null) {
                hVar.onSeekComplete(kGCorePlayer);
            }
        }
    };
    private PlayController.OnFirstFrameRenderListener mOnFirstFrameRenderListener = null;
    private PlayController.OnFirstFrameRenderListener innerOnFirstFrameRenderListener = new PlayController.OnFirstFrameRenderListener() { // from class: com.kugou.common.player.kgplayer.KGCorePlayer.7
        @Override // com.kugou.common.player.kugouplayer.PlayController.OnFirstFrameRenderListener
        public void onRendered(PlayController playController) {
            if (KGCorePlayer.this.mOnFirstFrameRenderListener != null) {
                KGCorePlayer.this.mOnFirstFrameRenderListener.onRendered(playController);
            }
        }
    };
    private PlayController.OnKGPlayerMessageListener innerOnKGPlayerMessageListener = new PlayController.OnKGPlayerMessageListener() { // from class: com.kugou.common.player.kgplayer.KGCorePlayer.8
        @Override // com.kugou.common.player.kugouplayer.PlayController.OnKGPlayerMessageListener
        public void onPlayerMessageReceived(PlayController playController, Message message) {
            KGCorePlayer kGCorePlayer = KGCorePlayer.this;
            c.f fVar = kGCorePlayer.mOnKGPlayerMessageListener;
            if (fVar != null) {
                fVar.onPlayerMessageReceived(kGCorePlayer, message);
            }
        }
    };

    private KGCorePlayer(Context context, Looper looper) {
        this.mContext = context;
        this.mPlayer = PlayController.create(looper);
        disablePlayerListener();
        enablePlayerListener();
    }

    public static KGCorePlayer create(Context context) {
        return create(context, null);
    }

    private void resetWithStream(PlayStream playStream) {
        PlayStream playStream2 = this.mPlayStream;
        if (playStream2 != null && playStream2 != playStream) {
            playStream2.setStreamPtr(0L);
        }
        reset();
    }

    @Override // com.kugou.common.player.kgplayer.KGPlayer
    public void addPreloadDataSource(String str, AudioTypeInfo audioTypeInfo) {
        throw new UnsupportedOperationException();
    }

    @Override // com.kugou.common.player.kgplayer.KGPlayer
    public void disablePlayerListener() {
        PlayController playController = this.mPlayer;
        if (playController != null) {
            playController.setOnErrorListener(null);
            this.mPlayer.setOnInfoListener(null);
            this.mPlayer.setOnPreparedListener(null);
            this.mPlayer.setOnCompletionListener(null);
            this.mPlayer.setOnSeekCompleteListener(null);
            this.mPlayer.setOnFirstFrameRenderListener(null);
            this.mPlayer.setOnKGPlayerMessageListener(null);
        }
    }

    @Override // com.kugou.common.player.kgplayer.KGPlayer
    public void enableExtendAudioTrack(boolean z) {
        throw new UnsupportedOperationException();
    }

    @Override // com.kugou.common.player.kgplayer.KGPlayer
    public void enablePlayerListener() {
        PlayController playController = this.mPlayer;
        if (playController != null) {
            playController.setOnErrorListener(this.innerErrorListener);
            this.mPlayer.setOnInfoListener(this.innerInfoListener);
            this.mPlayer.setOnPreparedListener(this.innerPreparedListener);
            this.mPlayer.setOnCompletionListener(this.innerCompletionListener);
            this.mPlayer.setOnSeekCompleteListener(this.innerOnSeekCompleteListener);
            this.mPlayer.setOnFirstFrameRenderListener(this.innerOnFirstFrameRenderListener);
            this.mPlayer.setOnKGPlayerMessageListener(this.innerOnKGPlayerMessageListener);
        }
    }

    @Override // com.kugou.common.player.kgplayer.KGPlayer
    public int getAudioInfo(AudioInfo audioInfo) {
        return this.mPlayer.getAudioInfo(audioInfo);
    }

    @Override // com.kugou.common.player.kgplayer.KGPlayer
    public int getAudioTrackCount() {
        throw new UnsupportedOperationException();
    }

    @Override // com.kugou.common.player.kgplayer.KGPlayer, e.c.e.b.e.c
    public int getBufferSize() {
        return this.mBufferSize;
    }

    @Override // com.kugou.common.player.kgplayer.KGPlayer, e.c.e.b.e.c
    public int getCurrentPosition() {
        return (int) this.mPlayer.getCurrentPosition();
    }

    @Override // com.kugou.common.player.kgplayer.KGPlayer
    public int getLoopCount() {
        return this.mPlayer.getLoopCount();
    }

    public PlayController getPlayController() {
        return this.mPlayer;
    }

    @Override // com.kugou.common.player.kgplayer.KGPlayer, e.c.e.b.e.c
    public int getPlayStatus() {
        return this.mPlayer.getStatus();
    }

    @Override // com.kugou.common.player.kgplayer.KGPlayer
    public int getRtmpAccompanyPts() {
        return this.mPlayer.getRtmpAccompanyPts();
    }

    @Override // com.kugou.common.player.kgplayer.KGPlayer
    public int getStreamErrorCode() {
        return this.mPlayer.getStreamErrorCode();
    }

    @Override // com.kugou.common.player.kgplayer.KGPlayer
    public int getStreamPlayMode() {
        throw new UnsupportedOperationException();
    }

    @Override // com.kugou.common.player.kgplayer.KGPlayer
    public int getStreamStatus() {
        return this.mPlayer.getStreamStatus();
    }

    @Override // com.kugou.common.player.kgplayer.KGPlayer
    public long getTimeMachineVideoTime() {
        throw new UnsupportedOperationException();
    }

    @Override // com.kugou.common.player.kgplayer.KGPlayer
    public int getVideoHeight() {
        throw new UnsupportedOperationException();
    }

    @Override // com.kugou.common.player.kgplayer.KGPlayer
    public int getVideoWidth() {
        throw new UnsupportedOperationException();
    }

    public double getVolumeRadio() {
        if (this.mPlayer != null) {
            return r0.getVolumeRatio();
        }
        return 0.0d;
    }

    public float getVolumnParameters() {
        return this.mPlayer.getVolumnParameters();
    }

    @Override // com.kugou.common.player.kgplayer.KGPlayer
    public boolean isCorePlayer() {
        return true;
    }

    @Override // com.kugou.common.player.kgplayer.KGPlayer
    public boolean isExtendAudioTrackEnabled() {
        throw new UnsupportedOperationException();
    }

    @Override // com.kugou.common.player.kgplayer.KGPlayer
    public boolean isLooping() {
        return this.mPlayer.getLoopCount() == -1;
    }

    @Override // com.kugou.common.player.kgplayer.KGPlayer
    public boolean isNetPlay() {
        if (!this.isStreamSeted) {
            return super.isNetPlay();
        }
        PlayStream playStream = this.mPlayStream;
        return playStream == null || !playStream.isLocalStream();
    }

    @Override // com.kugou.common.player.kgplayer.KGPlayer, e.c.e.b.e.c
    public boolean isPlaying() {
        return this.mPlayer.getStatus() == 5;
    }

    @Override // com.kugou.common.player.kgplayer.KGPlayer
    public boolean isStop() {
        return this.mPlayer.getStatus() == 8;
    }

    @Override // com.kugou.common.player.kgplayer.KGPlayer, e.c.e.b.e.c
    public void pause() {
        super.pause();
        this.mPlayer.pause();
    }

    @Override // com.kugou.common.player.kgplayer.KGPlayer
    public void prepare() {
        super.prepare();
        this.mPlayer.prepareAsync();
    }

    @Override // com.kugou.common.player.kgplayer.KGPlayer, e.c.e.b.e.c
    public void prepareAsync() {
        super.prepareAsync();
        this.mPlayer.prepareAsync();
    }

    @Override // com.kugou.common.player.kgplayer.KGPlayer
    public void release() {
        this.mPlayer.release();
        disablePlayerListener();
    }

    @Override // com.kugou.common.player.kgplayer.KGPlayer
    public void render() {
        this.mPlayer.render();
    }

    @Override // com.kugou.common.player.kgplayer.KGPlayer, e.c.e.b.e.c
    public void reset() {
        super.reset();
        this.mPlayer.stop();
        this.isStreamSeted = false;
        PlayStream playStream = this.mPlayStream;
        if (playStream != null) {
            playStream.setOnBufferUpdateListener(null);
            this.mPlayStream = null;
        }
    }

    @Override // com.kugou.common.player.kgplayer.KGPlayer, e.c.e.b.e.c
    public void seekTo(int i2) {
        int i3 = this.mDuration;
        if (i3 + NotificationManagerCompat.IMPORTANCE_UNSPECIFIED < i2) {
            i2 = i3 + NotificationManagerCompat.IMPORTANCE_UNSPECIFIED;
        }
        if (i2 < 0) {
            i2 = 0;
        }
        this.mPlayer.seekTo(i2);
    }

    @Override // com.kugou.common.player.kgplayer.KGPlayer
    public void sendCommand(int i2) {
        super.sendCommand(i2);
        this.mPlayer.sendCommand(i2);
    }

    @Override // com.kugou.common.player.kgplayer.KGPlayer
    public void setArea(int i2, int i3, int i4, int i5) {
        this.mPlayer.setArea(i2, i3, i4, i5);
    }

    @Override // com.kugou.common.player.kgplayer.KGPlayer
    public void setAudioModeParam(boolean z, int i2) {
        throw new UnsupportedOperationException();
    }

    public void setCanUseSeekByte(boolean z) {
        this.mPlayer.setCanUseSeekByte(z);
    }

    @Override // com.kugou.common.player.kgplayer.KGPlayer
    public void setDataSource(String str) {
        resetWithStream(null);
        super.setDataSource(str);
        this.mPlayer.setDataSource(str);
    }

    @Override // com.kugou.common.player.kgplayer.KGPlayer
    public void setDisplay(Object obj) {
        this.mPlayer.setDisplay(obj);
    }

    public void setFadeIn(boolean z) {
        this.mPlayer.setFadeIn(z);
    }

    @Override // com.kugou.common.player.kgplayer.KGPlayer
    public void setFileId(String str) {
        throw new UnsupportedOperationException();
    }

    @Override // com.kugou.common.player.kgplayer.KGPlayer
    public void setHardwareDecodeMode(boolean z) {
        this.mPlayer.setHardwareDecodeMode(z);
    }

    @Override // com.kugou.common.player.kgplayer.KGPlayer
    public void setLoop(int i2) {
        this.mPlayer.setLoop(i2);
    }

    @Override // com.kugou.common.player.kgplayer.KGPlayer
    public void setLooper(Looper looper) {
        this.mPlayer.setLooper(looper);
    }

    @Override // com.kugou.common.player.kgplayer.KGPlayer
    public void setLooping(boolean z) {
        this.mPlayer.setLoop(-1);
    }

    @Override // com.kugou.common.player.kgplayer.KGPlayer
    public void setMvFileIdAndBufferThreshold(String str, int i2) {
        throw new UnsupportedOperationException();
    }

    @Override // com.kugou.common.player.kgplayer.KGPlayer
    public synchronized void setNoFixTimes(float[] fArr) {
        throw new UnsupportedOperationException();
    }

    public void setOnFirstFrameRenderListener(PlayController.OnFirstFrameRenderListener onFirstFrameRenderListener) {
        this.mOnFirstFrameRenderListener = onFirstFrameRenderListener;
    }

    @Override // com.kugou.common.player.kgplayer.KGPlayer
    public void setOneKeyPlay(String str, String str2, String str3, String str4, String str5, long j, long j2, int i2) {
        throw new UnsupportedOperationException();
    }

    @Override // com.kugou.common.player.kgplayer.KGPlayer
    public synchronized void setOnekeyPlayOrigin(boolean z, long j) {
        throw new UnsupportedOperationException();
    }

    @Override // com.kugou.common.player.kgplayer.KGPlayer
    public void setProxyServer(String str, int i2) {
        this.mPlayer.setProxyServer(str, i2);
    }

    @Override // com.kugou.common.player.kgplayer.KGPlayer
    public void setRTMPTimeout(int i2) {
        this.mPlayer.setRTMPTimeout(i2);
    }

    @Override // com.kugou.common.player.kgplayer.KGPlayer
    public void setStuckTimeOut(int i2, int i3) {
        throw new UnsupportedOperationException();
    }

    @Override // com.kugou.common.player.kgplayer.KGPlayer
    public void setSurface(SurfaceHolder surfaceHolder) {
        this.mPlayer.setSurface(surfaceHolder);
    }

    @Override // com.kugou.common.player.kgplayer.KGPlayer
    public void setSurfaceInvalid(boolean z) {
        throw new UnsupportedOperationException();
    }

    @Override // com.kugou.common.player.kgplayer.KGPlayer
    public void setUnicomProxy(Map<String, String> map) {
        this.mPlayer.setUnicomProxy(map);
    }

    @Override // com.kugou.common.player.kgplayer.KGPlayer
    public void setVideoSourceType(boolean z) {
        this.mPlayer.setVideoSourceType(z);
    }

    @Override // com.kugou.common.player.kgplayer.KGPlayer
    public void setVoiceMoveStep(int i2) {
        this.mPlayer.setVoiceMoveStep(i2);
    }

    @Override // com.kugou.common.player.kgplayer.KGPlayer, e.c.e.b.e.c
    public void setVolume(float f2) {
        this.mPlayer.setVolume(f2);
    }

    @Override // com.kugou.common.player.kgplayer.KGPlayer
    public void setVolumeBalance(float f2, float f3) {
        this.mPlayer.setVolumeBalance(f2, f3);
    }

    @Override // com.kugou.common.player.kgplayer.KGPlayer
    public void setVolumeRate(float f2, float f3) {
        this.mPlayer.setVolumeRate(f2, f3);
    }

    public void setVolumeRatio(double d2) {
        this.mPlayer.setVolumeRatio(d2);
    }

    @Override // com.kugou.common.player.kgplayer.KGPlayer
    public void setWakeMode(Context context, int i2) {
    }

    @Override // com.kugou.common.player.kgplayer.KGPlayer, e.c.e.b.e.c
    public void start() {
        this.mPlayer.start();
    }

    @Override // com.kugou.common.player.kgplayer.KGPlayer, e.c.e.b.e.c
    public void stop() {
        super.stop();
        this.mPlayer.stop();
        this.isStreamSeted = false;
        this.isPrepared = false;
    }

    public static KGCorePlayer create(Context context, Looper looper) {
        KGCorePlayer kGCorePlayer = new KGCorePlayer(context, looper);
        if (kGCorePlayer.mPlayer == null) {
            return null;
        }
        return kGCorePlayer;
    }

    @Override // com.kugou.common.player.kgplayer.KGPlayer
    public void setUnicomProxy(String str) {
        this.mPlayer.setUnicomProxy(str);
    }

    @Override // com.kugou.common.player.kgplayer.KGPlayer
    public void setVolume(int i2, int i3) {
        this.mPlayer.setVolume(i2, i3);
    }

    @Override // com.kugou.common.player.kgplayer.KGPlayer
    public void setDataSource(String str, AudioTypeInfo audioTypeInfo) {
        resetWithStream(null);
        super.setDataSource(str, audioTypeInfo);
        this.mPlayer.setDataSource(str, audioTypeInfo);
    }

    @Override // com.kugou.common.player.kgplayer.KGPlayer, e.c.e.b.e.c
    public synchronized void setDataSource(String str, long j, long j2, AudioTypeInfo audioTypeInfo) {
        resetWithStream(null);
        super.setDataSource(str, j, j2, audioTypeInfo);
        this.mPlayer.setDataSource(str, audioTypeInfo, j, j2);
    }

    @Override // com.kugou.common.player.kgplayer.KGPlayer
    public void setDataSource(String str, long j) {
        resetWithStream(null);
        super.setDataSource(str);
        this.mPlayer.setDataSource(str, j);
    }

    @Override // com.kugou.common.player.kgplayer.KGPlayer
    public synchronized void setDataSource(PlayController.PlayParam playParam) {
        reset();
        super.setDataSource(playParam);
        this.mPlayer.setDataSource(playParam);
    }

    @Override // com.kugou.common.player.kgplayer.KGPlayer, e.c.e.b.e.c
    public void setDataSource(String str, long j, long j2) {
        resetWithStream(null);
        super.setDataSource(str);
        this.mPlayer.setDataSource(str, j, j2);
    }

    @Override // com.kugou.common.player.kgplayer.KGPlayer
    public void setDataSource(PlayStream playStream) {
        setDataSource(playStream, 0L);
    }

    @Override // com.kugou.common.player.kgplayer.KGPlayer
    public void setDataSource(PlayStream playStream, long j) {
        resetWithStream(playStream);
        if (playStream == null) {
            return;
        }
        this.isStreamSeted = true;
        this.mPlayStream = playStream;
        this.mPlayer.setDataSource(playStream.getStreamPtr(), j);
        PlayStream playStream2 = this.mPlayStream;
        if (playStream2 != null) {
            playStream2.setOnBufferUpdateListener(this.innnerBufferUpdateListener);
        }
    }

    @Override // com.kugou.common.player.kgplayer.KGPlayer, e.c.e.b.e.c
    public void setDataSource(PlayStream playStream, long j, long j2, AudioTypeInfo audioTypeInfo) {
        resetWithStream(playStream);
        if (playStream == null) {
            return;
        }
        this.isStreamSeted = true;
        this.mPlayStream = playStream;
        this.mPlayer.setDataSource(playStream.getStreamPtr(), audioTypeInfo, j, j2);
        PlayStream playStream2 = this.mPlayStream;
        if (playStream2 != null) {
            playStream2.setOnBufferUpdateListener(this.innnerBufferUpdateListener);
        }
    }

    @Override // com.kugou.common.player.kgplayer.KGPlayer, e.c.e.b.e.c
    public void setDataSource(PlayStream playStream, long j, long j2) {
        resetWithStream(playStream);
        if (playStream == null) {
            return;
        }
        this.isStreamSeted = true;
        this.mPlayStream = playStream;
        this.mPlayer.setDataSource(playStream.getStreamPtr(), j, j2);
        PlayStream playStream2 = this.mPlayStream;
        if (playStream2 != null) {
            playStream2.setOnBufferUpdateListener(this.innnerBufferUpdateListener);
        }
    }
}
