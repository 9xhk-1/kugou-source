package com.kugou.common.player.kgplayer;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Looper;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.kugou.common.player.kgplayer.KGPlayer;
import com.kugou.common.player.kugouplayer.AudioTypeInfo;
import e.c.e.b.b.b;
import e.c.e.b.e.c;
import java.io.File;
import java.io.FileInputStream;

/* JADX INFO: loaded from: classes2.dex */
public class KGMediaPlayer extends KGPlayer {
    private static final String TAG = "KGMediaPlayer";
    private int mState;
    private MediaPlayer mediaPlayer;
    private MediaPlayer.OnVideoSizeChangedListener innerVideoChangedListener = new MediaPlayer.OnVideoSizeChangedListener() { // from class: com.kugou.common.player.kgplayer.KGMediaPlayer.1
        @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
        public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i2, int i3) {
            if (b.f().debug()) {
                b.f().d(KGMediaPlayer.TAG, "OnVideoSizeChangedListener width = " + i2 + ", height = " + i3);
            }
            KGMediaPlayer kGMediaPlayer = KGMediaPlayer.this;
            KGPlayer.OnVideoSizeChangedListener onVideoSizeChangedListener = kGMediaPlayer.mOnVideoSizeChangedListener;
            if (onVideoSizeChangedListener != null) {
                onVideoSizeChangedListener.onVideoSizeChanged(kGMediaPlayer, i2, i3);
            }
        }
    };
    private MediaPlayer.OnBufferingUpdateListener innnerBufferingUpdateListener = new MediaPlayer.OnBufferingUpdateListener() { // from class: com.kugou.common.player.kgplayer.KGMediaPlayer.2
        @Override // android.media.MediaPlayer.OnBufferingUpdateListener
        public void onBufferingUpdate(MediaPlayer mediaPlayer, int i2) {
            if (b.f().debug()) {
                b.f().d(KGMediaPlayer.TAG, "onBufferingUpdate percent = " + i2);
            }
            KGMediaPlayer kGMediaPlayer = KGMediaPlayer.this;
            double d2 = i2;
            Double.isNaN(d2);
            double d3 = kGMediaPlayer.mDuration;
            Double.isNaN(d3);
            kGMediaPlayer.mBufferSize = (int) (((d2 * 1.0d) / 100.0d) * d3);
            c.b bVar = kGMediaPlayer.mOnBufferingUpdateListener;
        }
    };
    private MediaPlayer.OnCompletionListener innerCompletionListener = new MediaPlayer.OnCompletionListener() { // from class: com.kugou.common.player.kgplayer.KGMediaPlayer.3
        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            if (b.f().debug()) {
                b.f().d(KGMediaPlayer.TAG, "onCompletion");
            }
            KGMediaPlayer.this.mState = 0;
            KGMediaPlayer kGMediaPlayer = KGMediaPlayer.this;
            c.InterfaceC0230c interfaceC0230c = kGMediaPlayer.mOnCompletionListener;
            if (interfaceC0230c != null) {
                interfaceC0230c.onCompletion(kGMediaPlayer);
            }
        }
    };
    private MediaPlayer.OnErrorListener innerErrorListener = new MediaPlayer.OnErrorListener() { // from class: com.kugou.common.player.kgplayer.KGMediaPlayer.4
        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
            if (b.f().debug()) {
                b.f().d(KGMediaPlayer.TAG, "onError what = " + i2 + ", extra = " + i3);
            }
            KGMediaPlayer.this.mState = 7;
            KGMediaPlayer kGMediaPlayer = KGMediaPlayer.this;
            kGMediaPlayer.isPrepared = false;
            c.d dVar = kGMediaPlayer.mOnErrorListener;
            if (dVar != null) {
                dVar.onError(kGMediaPlayer, i2, i3);
            }
            return false;
        }
    };
    private MediaPlayer.OnPreparedListener innerPreparedListener = new MediaPlayer.OnPreparedListener() { // from class: com.kugou.common.player.kgplayer.KGMediaPlayer.5
        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            if (b.f().debug()) {
                b.f().d(KGMediaPlayer.TAG, "onPrepared");
            }
            KGMediaPlayer.this.mState = 4;
            KGMediaPlayer kGMediaPlayer = KGMediaPlayer.this;
            kGMediaPlayer.isPrepared = true;
            kGMediaPlayer.mDuration = kGMediaPlayer.mediaPlayer.getDuration();
            if (!KGMediaPlayer.this.isNetPlay()) {
                KGMediaPlayer kGMediaPlayer2 = KGMediaPlayer.this;
                kGMediaPlayer2.mBufferSize = kGMediaPlayer2.mDuration;
            }
            KGMediaPlayer kGMediaPlayer3 = KGMediaPlayer.this;
            c.g gVar = kGMediaPlayer3.mOnPreparedListener;
            if (gVar != null) {
                gVar.onPrepared(kGMediaPlayer3);
            }
        }
    };
    private MediaPlayer.OnInfoListener innerInfoListener = new MediaPlayer.OnInfoListener() { // from class: com.kugou.common.player.kgplayer.KGMediaPlayer.6
        @Override // android.media.MediaPlayer.OnInfoListener
        public boolean onInfo(MediaPlayer mediaPlayer, int i2, int i3) {
            if (b.f().debug()) {
                b.f().d(KGMediaPlayer.TAG, "onInfo what = " + i2 + ", extra = " + i3);
            }
            KGMediaPlayer kGMediaPlayer = KGMediaPlayer.this;
            c.e eVar = kGMediaPlayer.mOnInfoListener;
            if (eVar != null) {
                if (i2 == 701) {
                    i2 = 0;
                } else if (i2 == 702) {
                    i2 = 1;
                }
                eVar.onInfo(kGMediaPlayer, i2, i3);
            }
            return false;
        }
    };
    private MediaPlayer.OnSeekCompleteListener innerSeekCompleteListener = new MediaPlayer.OnSeekCompleteListener() { // from class: com.kugou.common.player.kgplayer.KGMediaPlayer.7
        @Override // android.media.MediaPlayer.OnSeekCompleteListener
        public void onSeekComplete(MediaPlayer mediaPlayer) {
            if (b.f().debug()) {
                b.f().d(KGMediaPlayer.TAG, "onSeekComplete");
            }
            KGMediaPlayer kGMediaPlayer = KGMediaPlayer.this;
            kGMediaPlayer.isPrepared = true;
            c.h hVar = kGMediaPlayer.mOnSeekComplectionListener;
            if (hVar != null) {
                hVar.onSeekComplete(kGMediaPlayer);
            }
        }
    };

    public KGMediaPlayer(Context context) {
        this.mState = -1;
        if (b.f().debug()) {
            b.f().d(TAG, "KGMediaPlayer() hashCode = " + getClass().hashCode());
        }
        this.mediaPlayer = new MediaPlayer();
        disablePlayerListener();
        enablePlayerListener();
        this.mState = 0;
        reset();
    }

    private void sendInfoMsg(int i2, int i3) {
        c.e eVar = this.mOnInfoListener;
        if (eVar != null) {
            eVar.onInfo(this, i2, i3);
        }
    }

    @Override // com.kugou.common.player.kgplayer.KGPlayer
    public void addPreloadDataSource(String str, AudioTypeInfo audioTypeInfo) {
    }

    @Override // com.kugou.common.player.kgplayer.KGPlayer
    public void disablePlayerListener() {
        this.mediaPlayer.setOnPreparedListener(null);
        this.mediaPlayer.setOnCompletionListener(null);
        this.mediaPlayer.setOnErrorListener(null);
        this.mediaPlayer.setOnSeekCompleteListener(null);
        this.mediaPlayer.setOnInfoListener(null);
        this.mediaPlayer.setOnBufferingUpdateListener(null);
        this.mediaPlayer.setOnVideoSizeChangedListener(null);
    }

    @Override // com.kugou.common.player.kgplayer.KGPlayer
    public void enableExtendAudioTrack(boolean z) {
    }

    @Override // com.kugou.common.player.kgplayer.KGPlayer
    public void enablePlayerListener() {
        this.mediaPlayer.setOnPreparedListener(this.innerPreparedListener);
        this.mediaPlayer.setOnCompletionListener(this.innerCompletionListener);
        this.mediaPlayer.setOnErrorListener(this.innerErrorListener);
        this.mediaPlayer.setOnSeekCompleteListener(this.innerSeekCompleteListener);
        this.mediaPlayer.setOnInfoListener(this.innerInfoListener);
        this.mediaPlayer.setOnBufferingUpdateListener(this.innnerBufferingUpdateListener);
        this.mediaPlayer.setOnVideoSizeChangedListener(this.innerVideoChangedListener);
    }

    @Override // com.kugou.common.player.kgplayer.KGPlayer
    public int getAudioTrackCount() {
        return 1;
    }

    @Override // com.kugou.common.player.kgplayer.KGPlayer, e.c.e.b.e.c
    public int getBufferSize() {
        return this.mBufferSize;
    }

    @Override // com.kugou.common.player.kgplayer.KGPlayer, e.c.e.b.e.c
    public int getCurrentPosition() {
        try {
            if (this.isPrepared) {
                return this.mediaPlayer.getCurrentPosition();
            }
            return 0;
        } catch (Exception unused) {
            return 0;
        }
    }

    @Override // com.kugou.common.player.kgplayer.KGPlayer
    public int getLoopCount() {
        return 0;
    }

    @Override // com.kugou.common.player.kgplayer.KGPlayer, e.c.e.b.e.c
    public int getPlayStatus() {
        return this.mState;
    }

    @Override // com.kugou.common.player.kgplayer.KGPlayer
    public int getRtmpAccompanyPts() {
        return 0;
    }

    @Override // com.kugou.common.player.kgplayer.KGPlayer
    public int getStreamErrorCode() {
        return 0;
    }

    @Override // com.kugou.common.player.kgplayer.KGPlayer
    public int getStreamPlayMode() {
        return 0;
    }

    @Override // com.kugou.common.player.kgplayer.KGPlayer
    public int getStreamStatus() {
        return 0;
    }

    @Override // com.kugou.common.player.kgplayer.KGPlayer
    public long getTimeMachineVideoTime() {
        return 0L;
    }

    @Override // com.kugou.common.player.kgplayer.KGPlayer
    public int getVideoHeight() {
        try {
            return this.mediaPlayer.getVideoHeight();
        } catch (IllegalStateException e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    @Override // com.kugou.common.player.kgplayer.KGPlayer
    public int getVideoWidth() {
        try {
            return this.mediaPlayer.getVideoWidth();
        } catch (IllegalStateException e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    @Override // com.kugou.common.player.kgplayer.KGPlayer, e.c.e.b.e.c
    public boolean isBuffering() {
        return this.mState == 3;
    }

    @Override // com.kugou.common.player.kgplayer.KGPlayer
    public boolean isCorePlayer() {
        return false;
    }

    @Override // com.kugou.common.player.kgplayer.KGPlayer
    public boolean isExtendAudioTrackEnabled() {
        return false;
    }

    @Override // com.kugou.common.player.kgplayer.KGPlayer
    public boolean isLooping() {
        return this.mediaPlayer.isLooping();
    }

    @Override // com.kugou.common.player.kgplayer.KGPlayer, e.c.e.b.e.c
    public boolean isPlaying() {
        try {
            return this.mediaPlayer.isPlaying();
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // com.kugou.common.player.kgplayer.KGPlayer
    public boolean isStop() {
        try {
            return true ^ this.mediaPlayer.isPlaying();
        } catch (Exception e2) {
            b.f().uploadException(e2);
            return true;
        }
    }

    @Override // com.kugou.common.player.kgplayer.KGPlayer, e.c.e.b.e.c
    public void pause() {
        if (b.f().debug()) {
            b.f().d(TAG, "pause()");
        }
        super.pause();
        try {
            if (isPrepared() && isPlaying()) {
                this.mediaPlayer.pause();
            }
            this.mState = 6;
            sendInfoMsg(2, 6);
        } catch (Exception e2) {
            b.f().uploadException(e2);
        }
    }

    @Override // com.kugou.common.player.kgplayer.KGPlayer
    public void prepare() {
        if (b.f().debug()) {
            b.f().d(TAG, "prepare()");
        }
        super.prepare();
        try {
            this.mediaPlayer.prepareAsync();
            this.mState = 3;
        } catch (Exception e2) {
            b.f().uploadException(e2);
            reset();
        }
    }

    @Override // com.kugou.common.player.kgplayer.KGPlayer, e.c.e.b.e.c
    public void prepareAsync() {
        if (b.f().debug()) {
            b.f().d(TAG, "prepareAsync()");
        }
        super.prepareAsync();
        try {
            this.mediaPlayer.prepareAsync();
            this.mState = 3;
        } catch (Exception e2) {
            b.f().uploadException(e2);
        }
    }

    @Override // com.kugou.common.player.kgplayer.KGPlayer
    public void release() {
        if (b.f().debug()) {
            b.f().d(TAG, "release()");
        }
        this.mediaPlayer.release();
        disablePlayerListener();
        this.mState = 8;
    }

    @Override // com.kugou.common.player.kgplayer.KGPlayer
    public void render() {
    }

    @Override // com.kugou.common.player.kgplayer.KGPlayer, e.c.e.b.e.c
    public void reset() {
        if (b.f().debug()) {
            b.f().d(TAG, "reset()");
        }
        super.reset();
        if (isPrepared() && isPlaying()) {
            stop();
        }
        this.mState = 0;
        this.mediaPlayer.reset();
    }

    @Override // com.kugou.common.player.kgplayer.KGPlayer, e.c.e.b.e.c
    public void seekTo(int i2) {
        if (b.f().debug()) {
            b.f().d(TAG, "seekTo msec = " + i2);
        }
        try {
            this.mediaPlayer.seekTo(i2);
        } catch (Exception e2) {
            b.f().uploadException(e2);
        }
    }

    @Override // com.kugou.common.player.kgplayer.KGPlayer
    public void setArea(int i2, int i3, int i4, int i5) {
    }

    @Override // com.kugou.common.player.kgplayer.KGPlayer
    public void setAudioModeParam(boolean z, int i2) {
    }

    public void setAudioStreamType(int i2) {
        this.mediaPlayer.setAudioStreamType(i2);
    }

    @Override // com.kugou.common.player.kgplayer.KGPlayer
    public void setDataSource(String str) {
        if (b.f().debug()) {
            b.f().d(TAG, "setDataSource() path = " + str);
        }
        try {
            reset();
            super.setDataSource(str);
            this.mediaPlayer.setDataSource(str);
        } catch (Exception e2) {
            b.f().uploadException(e2);
            reset();
        }
    }

    public boolean setDataSourceInByteScope(String str, long j, long j2) throws Throwable {
        FileInputStream fileInputStream;
        Throwable th;
        try {
            reset();
            super.setDataSource(str);
            File file = new File(str);
            if (!file.exists()) {
                this.mediaPlayer.setDataSource(str);
                return false;
            }
            try {
                fileInputStream = new FileInputStream(file);
            } catch (Throwable th2) {
                fileInputStream = null;
                th = th2;
            }
            try {
                this.mediaPlayer.setDataSource(fileInputStream.getFD(), j, j2);
                fileInputStream.close();
                return true;
            } catch (Throwable th3) {
                th = th3;
                if (fileInputStream == null) {
                    throw th;
                }
                fileInputStream.close();
                throw th;
            }
        } catch (Exception e2) {
            b.f().uploadException(e2);
            reset();
            return false;
        }
    }

    @Override // com.kugou.common.player.kgplayer.KGPlayer
    public void setDisplay(Object obj) {
    }

    @Override // com.kugou.common.player.kgplayer.KGPlayer
    public void setHardwareDecodeMode(boolean z) {
    }

    @Override // com.kugou.common.player.kgplayer.KGPlayer
    public void setLoop(int i2) {
    }

    @Override // com.kugou.common.player.kgplayer.KGPlayer
    public void setLooper(Looper looper) {
    }

    @Override // com.kugou.common.player.kgplayer.KGPlayer
    public void setLooping(boolean z) {
        this.mediaPlayer.setLooping(z);
    }

    public void setScreenOnWhilePlaying(boolean z) {
        this.mediaPlayer.setScreenOnWhilePlaying(z);
    }

    @Override // com.kugou.common.player.kgplayer.KGPlayer
    public void setSurface(SurfaceHolder surfaceHolder) {
        if (surfaceHolder != null) {
            try {
                this.mediaPlayer.setDisplay(surfaceHolder);
            } catch (RuntimeException e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // com.kugou.common.player.kgplayer.KGPlayer
    public void setSurfaceInvalid(boolean z) {
    }

    public void setSurfaceNull() {
        this.mediaPlayer.setSurface(null);
    }

    public void setSurfaceT(Surface surface) {
        if (surface != null) {
            try {
                this.mediaPlayer.setSurface(surface);
            } catch (RuntimeException e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // com.kugou.common.player.kgplayer.KGPlayer
    public void setVideoSourceType(boolean z) {
    }

    @Override // com.kugou.common.player.kgplayer.KGPlayer, e.c.e.b.e.c
    public void setVolume(float f2) {
        this.mediaPlayer.setVolume(f2, f2);
    }

    @Override // com.kugou.common.player.kgplayer.KGPlayer
    public void setVolumeBalance(float f2, float f3) {
        this.mediaPlayer.setVolume(f2, f3);
    }

    @Override // com.kugou.common.player.kgplayer.KGPlayer
    public void setVolumeRate(float f2, float f3) {
    }

    @Override // com.kugou.common.player.kgplayer.KGPlayer
    public void setWakeMode(Context context, int i2) {
        this.mediaPlayer.setWakeMode(context, i2);
    }

    @Override // com.kugou.common.player.kgplayer.KGPlayer, e.c.e.b.e.c
    public void start() {
        if (b.f().debug()) {
            b.f().d(TAG, "start()");
        }
        try {
            this.mediaPlayer.start();
            this.mState = 5;
            sendInfoMsg(2, 5);
        } catch (Exception unused) {
        }
    }

    @Override // com.kugou.common.player.kgplayer.KGPlayer, e.c.e.b.e.c
    public void stop() {
        if (b.f().debug()) {
            b.f().d(TAG, "stop()");
        }
        super.stop();
        try {
            if (isPrepared()) {
                this.mediaPlayer.stop();
            }
            this.mState = 8;
            sendInfoMsg(2, 8);
        } catch (Exception e2) {
            b.f().uploadException(e2);
        }
    }

    @Override // com.kugou.common.player.kgplayer.KGPlayer
    public void setVolume(int i2, int i3) {
        float f2 = i2;
        this.mediaPlayer.setVolume(f2, f2);
    }

    @Override // com.kugou.common.player.kgplayer.KGPlayer
    public void setDataSource(String str, long j) {
        if (b.f().debug()) {
            b.f().d(TAG, "setDataSource() path = " + str + ", startMs = " + j);
        }
        try {
            reset();
            super.setDataSource(str);
            this.mediaPlayer.setDataSource(str);
        } catch (Exception e2) {
            b.f().uploadException(e2);
            reset();
        }
    }

    public void setDataSource(Uri uri) {
        if (b.f().debug()) {
            b.f().d(TAG, "setDataSource() uri = " + uri);
        }
        try {
            reset();
            this.mediaPlayer.setDataSource(b.d(), uri);
        } catch (Exception e2) {
            b.f().uploadException(e2);
            reset();
        }
    }

    @Override // com.kugou.common.player.kgplayer.KGPlayer, e.c.e.b.e.c
    public void setDataSource(String str, long j, long j2) {
        if (b.f().debug()) {
            b.f().d(TAG, "setDataSource() path = " + str + ", startMs = " + j + ", endMs = " + j2);
        }
        try {
            reset();
            super.setDataSource(str);
            this.mediaPlayer.setDataSource(str);
        } catch (Exception e2) {
            b.f().uploadException(e2);
            reset();
        }
    }
}
