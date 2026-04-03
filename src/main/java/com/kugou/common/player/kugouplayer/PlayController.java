package com.kugou.common.player.kugouplayer;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.kugou.common.player.kugouplayer.MVExtractDecode;
import e.c.e.b.b.b;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.nio.charset.Charset;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: classes2.dex */
public class PlayController {
    public static final int KPLAYER_ACCOMPANY_TRACK = 0;
    public static final int KPLAYER_CMD_PLAY_MUTE = 2;
    public static final int KPLAYER_CMD_PLAY_UNMUTE = 3;
    public static final int KPLAYER_CMD_RECEIVE_AUDIO_ONLY = 0;
    public static final int KPLAYER_CMD_RECEIVE_AUDIO_VIDEO = 1;
    public static final int KPLAYER_COMPLETE = 2;
    public static final int KPLAYER_ERROR = 4;
    public static final int KPLAYER_ERROR_BROKEN_FILE = 2;
    public static final int KPLAYER_ERROR_CONNECT_FAILED = 5;
    public static final int KPLAYER_ERROR_CONVERTER_ERROR = 10;
    public static final int KPLAYER_ERROR_CREATE_HARDWARE_DECODE_ERROR = 21;
    public static final int KPLAYER_ERROR_DATASOURCE = 4;
    public static final int KPLAYER_ERROR_DECODEC_INIT_FAILED = 19;
    public static final int KPLAYER_ERROR_DECODE_ERROR = 14;
    public static final int KPLAYER_ERROR_HARDWARE_DECODE_EXCEPTION = 22;
    public static final int KPLAYER_ERROR_HARDWARE_SURFACE_INVALID = 25;
    public static final int KPLAYER_ERROR_HARDWARE_WAIT_SETSURFACE_TIMEOUT = 23;
    public static final int KPLAYER_ERROR_IGNORE = 15;
    public static final int KPLAYER_ERROR_INIT_AUDIOPLAYER_FAIL = 24;
    public static final int KPLAYER_ERROR_INIT_FAILED = 17;
    public static final int KPLAYER_ERROR_NET_CONNET_ERROR = 12;
    public static final int KPLAYER_ERROR_NONE = 0;
    public static final int KPLAYER_ERROR_NOSTREAM = 6;
    public static final int KPLAYER_ERROR_NO_AUDIO = 3;
    public static final int KPLAYER_ERROR_NO_SUCH_FILE = 1;
    public static final int KPLAYER_ERROR_OTHRE_EXCEPTION = 18;
    public static final int KPLAYER_ERROR_PROXY_ERROR = 13;
    public static final int KPLAYER_ERROR_READ_FRAME_ERROR = 9;
    public static final int KPLAYER_ERROR_REALIZEAUDIO_FAILED = 8;
    public static final int KPLAYER_ERROR_TRY_AGAIN = 16;
    public static final int KPLAYER_ERROR_UNKNOWN = 7;
    public static final int KPLAYER_INFO = 5;
    public static final int KPLAYER_INFO_AUDIOTRACK_WRITE_STUCK = 1000;
    public static final int KPLAYER_INFO_AUDIO_BUFFERING_ALARM = 26;
    public static final int KPLAYER_INFO_AUDIO_BUFFERING_ENOUGH = 27;
    public static final int KPLAYER_INFO_AUDIO_STUCK_TIME = 11;
    public static final int KPLAYER_INFO_BUFFERING_END = 1;
    public static final int KPLAYER_INFO_BUFFERING_START = 0;
    public static final int KPLAYER_INFO_CHANGE_TO_AUIDO_MODE = 22;
    public static final int KPLAYER_INFO_CHANGE_TO_LOW_BITRATE = 21;
    public static final int KPLAYER_INFO_CONNECT_SERVER_SUCCESS = 19;
    public static final int KPLAYER_INFO_DECODE_STUCK = 1002;
    public static final int KPLAYER_INFO_GENERAL_MESSAGE = 9;
    public static final int KPLAYER_INFO_IS_REAL_SING = 14;
    public static final int KPLAYER_INFO_KUQUN_MESSAGE = 5;
    public static final int KPLAYER_INFO_LIGHT_RESULT = 20;
    public static final int KPLAYER_INFO_LYRIC_MESSAGE = 4;
    public static final int KPLAYER_INFO_MV_BUFFERING_ALARM = 24;
    public static final int KPLAYER_INFO_MV_BUFFERING_ENOUGH = 25;
    public static final int KPLAYER_INFO_NEXT_VIDEO_STARTPLAY = 18;
    public static final int KPLAYER_INFO_PLAYER_STATUS = 2;
    public static final int KPLAYER_INFO_PLAYSPEED_CHANGED = 13;
    public static final int KPLAYER_INFO_PRELOAD_VIDEO_START = 17;
    public static final int KPLAYER_INFO_READ_DATA_AND_EFFECT_STUCK = 1001;
    public static final int KPLAYER_INFO_RENDER_FINISH = 16;
    public static final int KPLAYER_INFO_RENDER_FIRST_FRAME = 3;
    public static final int KPLAYER_INFO_REPEAT_RELEASE = 23;
    public static final int KPLAYER_INFO_SCREEN_SHOT_DATA = 15;
    public static final int KPLAYER_INFO_VIDEO_BUFFERING_END = 8;
    public static final int KPLAYER_INFO_VIDEO_BUFFERING_START = 7;
    public static final int KPLAYER_INFO_VIDEO_STUCK_DATA = 6;
    public static final int KPLAYER_INFO_VIDEO_STUCK_DURATION = 10;
    public static final int KPLAYER_INFO_VIDEO_STUCK_TIME = 12;
    public static final int KPLAYER_NOP = 0;
    public static final int KPLAYER_PREPARED = 1;
    public static final int KPLAYER_SEEKCOMPLETION = 3;
    public static final int KPLAYER_STARTPLAY = 6;
    public static final int KPLAYER_STATUS_ERROR = 7;
    public static final int KPLAYER_STATUS_IDLE = 0;
    public static final int KPLAYER_STATUS_INITIALIZED = 2;
    public static final int KPLAYER_STATUS_INITIALIZING = 1;
    public static final int KPLAYER_STATUS_PAUSE = 6;
    public static final int KPLAYER_STATUS_PLAYING = 5;
    public static final int KPLAYER_STATUS_PREPARED = 4;
    public static final int KPLAYER_STATUS_PREPARING = 3;
    public static final int KPLAYER_STATUS_STOP = 8;
    public static final int KPLAYER_THIRED_TRACK = 2;
    public static final int KPLAYER_VOICE_TRACK = 1;
    public static final int KPLAYER_VerificationSpeed = 901;
    public static final int KPLAYER_VerificationSpeed2 = 902;
    public static final int PLAYPARAM_MIXMODE_BANGBANGCHANG = 0;
    public static final int PLAYPARAM_MIXMODE_NORMAL = 1;
    private static final String TAG = "KugouPlayer";
    private EventHandler mEventHandler;
    private long mNativeContext;
    private OnCompletionListener mOnCompletionListener;
    private OnErrorListener mOnErrorListener;
    private OnFirstFrameRenderListener mOnFirstFrameRenderListener;
    private OnInfoListener mOnInfoListener;
    private OnKGPlayerMessageListener mOnKGPlayerMessageListener;
    private OnPreparedListener mOnPreparedListener;
    private OnSeekCompleteListener mOnSeekCompleteListener;
    private OnStartPlayListener mOnStartPlayListener;
    private String strDataSource;
    private boolean mLibraryLoadSuccess = false;
    private MVExtractDecode mMVExtractDecode = null;
    private boolean mUseHardwareDecodeMode = false;
    private boolean mIsKugouMV = false;
    private boolean mSeekComplete = false;
    private long mSeekTimeMs = -1;
    private Lock mSeekLock = new ReentrantLock(true);
    private Lock mMvExDeLock = new ReentrantLock(true);

    public static class ConvertParam {
        public int mixMode;
        public String path = null;
        public String dest = null;
        public String dest2 = null;
        public int formatType = 0;
        public Object intervalsExtend = null;
        public Object intervalsThird = null;

        public ConvertParam setDest(String str) {
            this.dest = str;
            return this;
        }

        public ConvertParam setDest2(String str) {
            this.dest2 = str;
            return this;
        }

        public ConvertParam setFormatType(int i2) {
            this.formatType = i2;
            return this;
        }

        public ConvertParam setMixMode(int i2) {
            this.mixMode = i2;
            return this;
        }

        public ConvertParam setPath(String str) {
            this.path = str;
            return this;
        }
    }

    @SuppressLint({"NewApi"})
    public class EventHandler extends Handler {
        private PlayController mPlayController;

        public EventHandler(PlayController playController, Looper looper) {
            super(looper);
            this.mPlayController = playController;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (this.mPlayController.mNativeContext == 0) {
                b.f().iLF(PlayController.TAG, "player went away with unhandled events");
            }
            if (PlayController.this.mOnKGPlayerMessageListener != null) {
                PlayController.this.mOnKGPlayerMessageListener.onPlayerMessageReceived(this.mPlayController, message);
            }
            b.f().iLF("PlayController", "KugouPlayer msg.what = " + message.what + ", msg.arg1 = " + message.arg1 + ", msg.arg2 = " + message.arg2);
            e.c.e.a.a.b bVarF = b.f();
            StringBuilder sb = new StringBuilder();
            sb.append("currentThread:");
            sb.append(Thread.currentThread().getId());
            sb.append(" hashCode:");
            sb.append(hashCode());
            bVarF.iLF("PlayController eeee ", sb.toString());
            switch (message.what) {
                case 0:
                    break;
                case 1:
                    if (PlayController.this.mOnPreparedListener == null) {
                        PlayController.this.start();
                    } else {
                        PlayController.this.mOnPreparedListener.onPrepared(this.mPlayController);
                    }
                    break;
                case 2:
                    b.f().iLF(PlayController.TAG, "onCompletion (" + message.arg1 + "," + Integer.toHexString(message.arg2) + ")");
                    if (PlayController.this.mOnCompletionListener == null) {
                        PlayController.this.stop();
                    } else {
                        PlayController.this.mOnCompletionListener.onCompletion(this.mPlayController);
                        if (PlayController.this.mUseHardwareDecodeMode) {
                            PlayController.this.stop();
                        }
                    }
                    break;
                case 3:
                    b.f().d(PlayController.TAG, "playController seekTime SEEKCOMPLETION currentTime:" + System.currentTimeMillis());
                    long jLongValue = Long.valueOf(String.valueOf(message.obj)).longValue();
                    Log.e(PlayController.TAG, "onSeekCompletion (" + message.arg1 + "," + Integer.toHexString(message.arg2) + "," + jLongValue + ")");
                    PlayController.this.mSeekLock.lock();
                    if (PlayController.this.mSeekTimeMs >= 0 && PlayController.this.mSeekTimeMs != jLongValue) {
                        Log.e(PlayController.TAG, "onSeekCompletion need seek again (new seek:" + PlayController.this.mSeekTimeMs + ", old seek:" + jLongValue + ")");
                        if (PlayController.this.mUseHardwareDecodeMode) {
                            PlayController.this.seekNewTo();
                        }
                        PlayController.this.mSeekLock.unlock();
                    } else {
                        PlayController.this.mSeekComplete = true;
                        PlayController.this.mSeekTimeMs = -1L;
                        PlayController.this.mSeekLock.unlock();
                        Log.e(PlayController.TAG, "onSeekCompletion (" + message.arg1 + "," + Integer.toHexString(message.arg2) + ")");
                        if (PlayController.this.mOnSeekCompleteListener != null) {
                            PlayController.this.mOnSeekCompleteListener.onSeekComplete(this.mPlayController);
                        }
                    }
                    break;
                case 4:
                    Log.e(PlayController.TAG, "Error (" + message.arg1 + "," + Integer.toHexString(message.arg2) + ")");
                    if (message.arg1 == 16 && PlayController.this.mUseHardwareDecodeMode && PlayController.this.mMVExtractDecode != null) {
                        b.f().i("PlayController", "try again once  hashCode:" + hashCode());
                        PlayController.this.mMVExtractDecode.stop();
                        PlayController.this.mMVExtractDecode.start();
                    } else if (message.arg1 != 9 || (!PlayController.this.mUseHardwareDecodeMode && !PlayController.this.mIsKugouMV)) {
                        PlayController.this._stop();
                        if (PlayController.this.mOnErrorListener != null) {
                            PlayController.this.mOnErrorListener.onError(this.mPlayController, message.arg1, message.arg2);
                        }
                    }
                    break;
                case 5:
                    if (message.arg1 != 3 || PlayController.this.mOnFirstFrameRenderListener == null) {
                        int i2 = message.arg1;
                        if (i2 == 4) {
                            PlayController.postLyricSyncInfoFromNative((byte[]) message.obj, PlayController.this.strDataSource);
                            break;
                        } else if (i2 == 5) {
                            byte[] bArr = (byte[]) message.obj;
                            if (bArr != null) {
                                String str = new String(bArr, Charset.forName("UTF-8"));
                                b.f().iLF(PlayController.TAG, "postKuqunInfoFromNative() called with: " + message);
                                if (PlayController.this.mOnInfoListener != null) {
                                    PlayController.this.mOnInfoListener.onInfo(this.mPlayController, message.arg1, message.arg2, str);
                                }
                                break;
                            }
                        } else if (i2 != 6) {
                            if (i2 != 9) {
                                if (PlayController.this.mOnInfoListener != null) {
                                    b.f().d(PlayController.TAG, "onInfo() arg1:" + message.arg1 + ",arg2: " + message.arg2);
                                    PlayController.this.mOnInfoListener.onInfo(this.mPlayController, message.arg1, message.arg2);
                                }
                                break;
                            } else {
                                try {
                                    if (message.obj != null) {
                                        PlayController.postGeneralInfo(message.arg1, message.arg2, new String((byte[]) message.obj, "utf-8"));
                                        break;
                                    }
                                } catch (Exception e2) {
                                    e2.printStackTrace();
                                    return;
                                }
                            }
                        } else if (message.obj != null && PlayController.this.mOnInfoListener != null) {
                            try {
                                String str2 = new String((byte[]) message.obj, "utf-8");
                                b.f().d(PlayController.TAG, str2);
                                PlayController.this.mOnInfoListener.onInfo(this.mPlayController, message.arg1, message.arg2, str2);
                            } catch (UnsupportedEncodingException e3) {
                                e3.printStackTrace();
                                return;
                            }
                            break;
                        }
                    } else {
                        PlayController.this.mOnFirstFrameRenderListener.onRendered(this.mPlayController);
                        break;
                    }
                    break;
                case 6:
                    if (PlayController.this.mOnStartPlayListener != null) {
                        PlayController.this.mOnStartPlayListener.onStartPlay(this.mPlayController);
                    }
                    break;
                default:
                    Log.e(PlayController.TAG, "Unknown message type " + message.what);
                    break;
            }
        }
    }

    public interface OnCompletionListener {
        void onCompletion(PlayController playController);
    }

    public interface OnErrorListener {
        void onError(PlayController playController, int i2, int i3);
    }

    public interface OnFirstFrameRenderListener {
        void onRendered(PlayController playController);
    }

    public interface OnInfoListener {
        void onInfo(PlayController playController, int i2, int i3);

        void onInfo(PlayController playController, int i2, int i3, String str);
    }

    public interface OnKGPlayerMessageListener {
        void onPlayerMessageReceived(PlayController playController, Message message);
    }

    public interface OnPreparedListener {
        void onPrepared(PlayController playController);
    }

    public interface OnSeekCompleteListener {
        void onSeekComplete(PlayController playController);
    }

    public interface OnStartPlayListener {
        void onStartPlay(PlayController playController);
    }

    public static class PlayParam {
        public String path = null;
        public long source = 0;
        public long startMs = 0;
        public long endMs = 0;
        public Object audioTypeInfo = null;
        public Object intervalsExtend = null;
        public Object intervalsThird = null;
        public int mixMode = 0;

        public PlayParam setAudioTypeInfo(AudioTypeInfo audioTypeInfo) {
            this.audioTypeInfo = audioTypeInfo;
            return this;
        }

        public PlayParam setEndMs(long j) {
            this.endMs = j;
            return this;
        }

        public PlayParam setMixMode(int i2) {
            this.mixMode = i2;
            return this;
        }

        public PlayParam setPath(String str) {
            this.path = str;
            return this;
        }

        public PlayParam setSource(long j) {
            this.source = j;
            return this;
        }

        public PlayParam setStartMs(long j) {
            this.startMs = j;
            return this;
        }
    }

    private PlayController(Looper looper) {
        this.mEventHandler = null;
        if (looper != null) {
            this.mEventHandler = new EventHandler(this, looper);
        } else {
            Looper looperMyLooper = Looper.myLooper();
            if (looperMyLooper != null) {
                this.mEventHandler = new EventHandler(this, looperMyLooper);
            } else {
                Looper mainLooper = Looper.getMainLooper();
                if (mainLooper != null) {
                    this.mEventHandler = new EventHandler(this, mainLooper);
                } else {
                    this.mEventHandler = null;
                }
            }
        }
        native_setup(new WeakReference(this));
        setUnSupportedSampleRates(NativeAudioTrack.getUnSupportedSampleRates());
    }

    private native long _getDuration();

    private native void _pause();

    private native void _prepareAsync();

    private native void _release();

    private native void _seekTo(long j);

    private native void _setDataSource(long j, long j2, long j3);

    private native void _setDataSource(long j, Object obj, long j2, long j3);

    private native void _setDataSource(Object obj);

    private native void _setDataSource(String str, long j, long j2);

    private native void _setDataSource(String str, long j, long j2, long j3);

    private native void _setDataSource(String str, Object obj, long j, long j2);

    private native void _setDisplay(Object obj);

    private native void _start();

    /* JADX INFO: Access modifiers changed from: private */
    public native void _stop();

    public static PlayController create(Looper looper) {
        if (!LibraryManager.loadLibrary()) {
            Log.e(TAG, "load library failed!!!");
            return null;
        }
        PlayController playController = new PlayController(looper);
        playController.mLibraryLoadSuccess = true;
        b.f().d("PlayController", "============new PlayController  hashCode:" + playController.hashCode());
        return playController;
    }

    private native long getPosition();

    private void initMVExtractDecode() {
        this.mMvExDeLock.lock();
        if (this.mMVExtractDecode == null) {
            this.mMVExtractDecode = new MVExtractDecode();
            b.f().i("PlayController", "============initMVExtractDecode  PlayController this:" + this + " hashCode:" + hashCode() + " MVExtractDecode:" + this.mMVExtractDecode + " MVExtractDecode.hashCode:" + this.mMVExtractDecode.hashCode());
            this.mMVExtractDecode.setOnMVListener(this, new MVExtractDecode.MVListener() { // from class: com.kugou.common.player.kugouplayer.PlayController.1
                @Override // com.kugou.common.player.kugouplayer.MVExtractDecode.MVListener
                public long getCurPosition(Object obj) {
                    PlayController playController = (PlayController) obj;
                    if (playController != null) {
                        return playController.getCurrentPosition();
                    }
                    return 0L;
                }

                @Override // com.kugou.common.player.kugouplayer.MVExtractDecode.MVListener
                public void onError(int i2, int i3, int i4) {
                    if (i2 != 4 || PlayController.this.mEventHandler == null) {
                        return;
                    }
                    PlayController.this.mEventHandler.sendMessage(PlayController.this.mEventHandler.obtainMessage(4, i3, i4));
                }

                @Override // com.kugou.common.player.kugouplayer.MVExtractDecode.MVListener
                public void onRender(Object obj) {
                    PlayController playController = (PlayController) obj;
                    if (playController != null) {
                        b.f().i("MVListener", "============onRender");
                        playController.render();
                    }
                }
            });
        }
        this.mMvExDeLock.unlock();
    }

    public static native void native_init();

    private native void native_setup(Object obj);

    private static void postEventFromNative(Object obj, int i2, int i3, int i4, long j) {
        EventHandler eventHandler;
        if (b.f().debug()) {
            b.f().d(TAG, "PlayController postEventFromNative prepare msg.what = " + i2 + ",  arg1 = " + i3 + ", arg2 = " + i4);
        }
        PlayController playController = (PlayController) ((WeakReference) obj).get();
        if (playController == null || (eventHandler = playController.mEventHandler) == null) {
            return;
        }
        playController.mEventHandler.sendMessage(eventHandler.obtainMessage(i2, i3, i4, Long.valueOf(j)));
    }

    private static void postEventFromNative2(Object obj, int i2, int i3, int i4, byte[] bArr) {
        EventHandler eventHandler;
        b.f().d(TAG, "PlayController postEventFromNative2 prepare msg.what = " + i2 + ",  arg1 = " + i3 + ", arg2 = " + i4);
        PlayController playController = (PlayController) ((WeakReference) obj).get();
        if (playController == null || (eventHandler = playController.mEventHandler) == null) {
            return;
        }
        playController.mEventHandler.sendMessage(eventHandler.obtainMessage(i2, i3, i4, bArr));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void postGeneralInfo(int i2, int i3, String str) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void postLyricSyncInfoFromNative(byte[] bArr, String str) {
        if (bArr == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void seekNewTo() {
        if (this.mLibraryLoadSuccess) {
            b.f().d(TAG, "PlayController seekNewTo start currentTime:" + System.currentTimeMillis());
            b.f().d(TAG, "PlayController seekNewTo:" + this.mSeekTimeMs);
            if (this.mSeekTimeMs < 0) {
                return;
            }
            if (this.mUseHardwareDecodeMode) {
                this.mMvExDeLock.lock();
                MVExtractDecode mVExtractDecode = this.mMVExtractDecode;
                if (mVExtractDecode != null) {
                    mVExtractDecode.seek(this.mSeekTimeMs * 1000);
                }
                this.mMvExDeLock.unlock();
            }
            b.f().d(TAG, "playController seekNewTo decoder end currentTime:" + System.currentTimeMillis());
            _seekTo(this.mSeekTimeMs);
            b.f().d(TAG, "playController seekNewTo end currentTime:" + System.currentTimeMillis());
        }
    }

    public native int _getAudioInfo(Object obj);

    public native void _setAudioPipe(Object obj);

    public native void _setCanUseSeekByte(boolean z);

    public native void _setSurface(Object obj);

    public native void _setVolumeBalance(float f2, float f3);

    public native void _startConvert(Object obj);

    public void finalize() throws Throwable {
        try {
            try {
                release();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        } finally {
            super.finalize();
        }
    }

    public int getAudioInfo(AudioInfo audioInfo) {
        return _getAudioInfo(audioInfo);
    }

    public long getCurrentPosition() {
        if (!this.mSeekComplete) {
            long j = this.mSeekTimeMs;
            if (j >= 0) {
                return j;
            }
        }
        return getPosition();
    }

    public String getDataSource() {
        return this.strDataSource;
    }

    public long getDuration() {
        if (!this.mUseHardwareDecodeMode || this.mMVExtractDecode == null) {
            return _getDuration();
        }
        this.mMvExDeLock.lock();
        MVExtractDecode mVExtractDecode = this.mMVExtractDecode;
        long duration = mVExtractDecode != null ? mVExtractDecode.getDuration() : 0L;
        this.mMvExDeLock.unlock();
        return duration;
    }

    public native int getLoopCount();

    public native int getRtmpAccompanyPts();

    public native int getStatus();

    public native int getStreamErrorCode();

    public native int getStreamStatus();

    public int getVideoHeight() {
        return 0;
    }

    public int getVideoWidth() {
        return 0;
    }

    public native float getVolumeRatio();

    public native float getVolumnParameters();

    public void pause() {
        if (this.mLibraryLoadSuccess) {
            _pause();
            if (this.mUseHardwareDecodeMode) {
                this.mMvExDeLock.lock();
                MVExtractDecode mVExtractDecode = this.mMVExtractDecode;
                if (mVExtractDecode != null) {
                    mVExtractDecode.pause();
                }
                this.mMvExDeLock.unlock();
            }
        }
    }

    public void prepareAsync() {
        b.f().d(TAG, "playController seekTime prepareAsync currentTime:" + System.currentTimeMillis());
        if (this.mLibraryLoadSuccess) {
            _prepareAsync();
        }
    }

    public synchronized void release() {
        try {
            this.mMvExDeLock.lock();
            MVExtractDecode mVExtractDecode = this.mMVExtractDecode;
            if (mVExtractDecode != null) {
                mVExtractDecode.stop();
                this.mMVExtractDecode.release();
                this.mUseHardwareDecodeMode = false;
                this.mMVExtractDecode = null;
            }
            this.mMvExDeLock.unlock();
            _release();
        } catch (Throwable th) {
            this.mMvExDeLock.unlock();
            throw th;
        }
    }

    public native void render();

    public void seekTo(long j) {
        if (this.mLibraryLoadSuccess) {
            b.f().d(TAG, "PlayController seekTime start currentTime:" + System.currentTimeMillis());
            b.f().d(TAG, "PlayController seekTo:" + j);
            if (j < 0) {
                return;
            }
            this.mSeekLock.lock();
            if (!this.mSeekComplete && this.mUseHardwareDecodeMode) {
                this.mSeekTimeMs = j;
                this.mSeekLock.unlock();
                b.f().d(TAG, "PlayController seeking. save seekTo:" + j);
                return;
            }
            this.mSeekTimeMs = j;
            this.mSeekComplete = false;
            this.mSeekLock.unlock();
            if (this.mUseHardwareDecodeMode) {
                this.mMvExDeLock.lock();
                MVExtractDecode mVExtractDecode = this.mMVExtractDecode;
                if (mVExtractDecode != null) {
                    mVExtractDecode.seek(this.mSeekTimeMs * 1000);
                }
                this.mMvExDeLock.unlock();
            }
            b.f().d(TAG, "playController seekTime decoder end currentTime:" + System.currentTimeMillis());
            _seekTo(this.mSeekTimeMs);
            b.f().d(TAG, "playController seekTime end currentTime:" + System.currentTimeMillis());
        }
    }

    public native void sendCommand(int i2);

    public native void setArea(int i2, int i3, int i4, int i5);

    public native void setAreaWithCut(int i2, int i3, int i4, int i5, int i6, boolean z);

    public void setAudioReceiver(AudioPipe audioPipe) {
        _setAudioPipe(audioPipe);
    }

    public void setCanUseSeekByte(boolean z) {
        _setCanUseSeekByte(z);
    }

    public void setDataSource(long j) {
        setDataSource(j, 0L, 0L);
    }

    public void setDisplay(Object obj) {
        if (this.mUseHardwareDecodeMode) {
            return;
        }
        _setDisplay(obj);
    }

    public native void setFadeIn(boolean z);

    public void setHardwareDecodeMode(boolean z) {
        this.mUseHardwareDecodeMode = z;
        if (z) {
            initMVExtractDecode();
        }
    }

    public native void setLoop(int i2);

    public void setLooper(Looper looper) {
        this.mEventHandler = new EventHandler(this, looper);
    }

    public void setOnCompletionListener(OnCompletionListener onCompletionListener) {
        this.mOnCompletionListener = onCompletionListener;
    }

    public void setOnErrorListener(OnErrorListener onErrorListener) {
        this.mOnErrorListener = onErrorListener;
    }

    public void setOnFirstFrameRenderListener(OnFirstFrameRenderListener onFirstFrameRenderListener) {
        this.mOnFirstFrameRenderListener = onFirstFrameRenderListener;
    }

    public void setOnInfoListener(OnInfoListener onInfoListener) {
        this.mOnInfoListener = onInfoListener;
    }

    public void setOnKGPlayerMessageListener(OnKGPlayerMessageListener onKGPlayerMessageListener) {
        this.mOnKGPlayerMessageListener = onKGPlayerMessageListener;
    }

    public void setOnPreparedListener(OnPreparedListener onPreparedListener) {
        this.mOnPreparedListener = onPreparedListener;
    }

    public void setOnSeekCompleteListener(OnSeekCompleteListener onSeekCompleteListener) {
        this.mOnSeekCompleteListener = onSeekCompleteListener;
    }

    public void setOnStartPlayListener(OnStartPlayListener onStartPlayListener) {
        this.mOnStartPlayListener = onStartPlayListener;
    }

    public native void setProxyServer(String str, int i2);

    public native void setRTMPTimeout(int i2);

    public void setSurface(SurfaceHolder surfaceHolder) {
        MVExtractDecode mVExtractDecode;
        this.mMvExDeLock.lock();
        if (this.mUseHardwareDecodeMode && (mVExtractDecode = this.mMVExtractDecode) != null) {
            mVExtractDecode.setSurface(surfaceHolder);
        }
        this.mMvExDeLock.unlock();
    }

    public native void setUnSupportedSampleRates(long j);

    public native void setUnicomProxy(String str);

    public void setUnicomProxy(Map<String, String> map) {
        StringBuffer stringBuffer = new StringBuffer();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            stringBuffer.append(entry.getKey());
            stringBuffer.append(": ");
            stringBuffer.append(entry.getValue());
            stringBuffer.append("\r\n");
        }
        setUnicomProxy(stringBuffer.toString());
    }

    public void setVideoSourceType(boolean z) {
        this.mIsKugouMV = z;
    }

    public native void setVoiceMoveStep(int i2);

    public native void setVolume(float f2);

    public native void setVolume(int i2, int i3);

    public void setVolumeBalance(float f2, float f3) {
        _setVolumeBalance(f2, f3);
    }

    public native void setVolumeRate(float f2, float f3);

    public native void setVolumeRatio(double d2);

    public void start() {
        if (this.mLibraryLoadSuccess) {
            this.mSeekComplete = true;
            this.mSeekTimeMs = -1L;
            if (this.mUseHardwareDecodeMode) {
                this.mMvExDeLock.lock();
                if (this.mMVExtractDecode != null) {
                    b.f().i("PlayController", "start  hashCode:" + hashCode());
                    this.mMVExtractDecode.start();
                }
                this.mMvExDeLock.unlock();
            }
            _start();
        }
    }

    public native void startConvert(String str, String str2);

    public void startConvert(String str, String str2, int i2) {
        startConvert(str, str2, i2, null);
    }

    public native void startConvert(String str, String str2, int i2, String str3);

    public void stop() {
        if (this.mLibraryLoadSuccess) {
            this.mSeekComplete = true;
            this.mSeekTimeMs = -1L;
            _stop();
            if (this.mUseHardwareDecodeMode) {
                this.mMvExDeLock.lock();
                if (this.mMVExtractDecode != null) {
                    b.f().i("PlayController", "stop  hashCode:" + hashCode());
                    this.mMVExtractDecode.stop();
                }
                this.mMvExDeLock.unlock();
            }
        }
    }

    public void setAudioReceiver(AudioPipe audioPipe, int i2) {
        _setAudioPipe(audioPipe);
    }

    public void setDataSource(long j, AudioTypeInfo audioTypeInfo) {
        setDataSource(j, audioTypeInfo, 0L, 0L);
    }

    public void startConvert(ConvertParam convertParam) {
        _startConvert(convertParam);
    }

    public void setDataSource(long j, long j2) {
        setDataSource(j, j2, 0L);
    }

    public void setDataSource(long j, AudioTypeInfo audioTypeInfo, long j2) {
        setDataSource(j, audioTypeInfo, j2, 0L);
    }

    public void setDataSource(long j, long j2, long j3) {
        if (this.mLibraryLoadSuccess) {
            this.mSeekComplete = true;
            this.mSeekTimeMs = -1L;
            _setDataSource(j, j2, j3);
        }
    }

    public void setSurface(Surface surface) {
        this.mMvExDeLock.lock();
        MVExtractDecode mVExtractDecode = this.mMVExtractDecode;
        if (mVExtractDecode != null) {
            mVExtractDecode.setSurface(surface);
        }
        this.mMvExDeLock.unlock();
    }

    public void setDataSource(long j, AudioTypeInfo audioTypeInfo, long j2, long j3) {
        if (b.f().debug()) {
            b.f().i("PlayController", "AAABB setDataSource  hashCode:" + hashCode() + "streamAddress audioType:" + audioTypeInfo.audioType);
        }
        if (this.mLibraryLoadSuccess) {
            this.mSeekComplete = true;
            this.mSeekTimeMs = -1L;
            _setDataSource(j, audioTypeInfo, j2, j3);
        }
    }

    public void setDataSource(String str) {
        this.strDataSource = str;
        setDataSource(str, 0L, 0L);
    }

    public void setDataSource(String str, AudioTypeInfo audioTypeInfo) {
        this.strDataSource = str;
        setDataSource(str, audioTypeInfo, 0L, 0L);
    }

    public void setDataSource(String str, long j) {
        this.strDataSource = str;
        setDataSource(str, j, 0L);
    }

    public void setDataSource(String str, AudioTypeInfo audioTypeInfo, long j) {
        this.strDataSource = str;
        setDataSource(str, audioTypeInfo, j, 0L);
    }

    public void setDataSource(String str, long j, long j2) {
        long mvMediaSource;
        if (this.mLibraryLoadSuccess) {
            this.mSeekComplete = true;
            this.mSeekTimeMs = -1L;
            if (this.mUseHardwareDecodeMode && this.mMVExtractDecode != null) {
                b.f().i("PlayController", "setDataSource:" + str + " hashCode:" + hashCode());
                this.mMvExDeLock.lock();
                MVExtractDecode mVExtractDecode = this.mMVExtractDecode;
                if (mVExtractDecode != null) {
                    mVExtractDecode.setSourcePath(str, j);
                    this.mMVExtractDecode.start();
                    mvMediaSource = this.mMVExtractDecode.getMvMediaSource();
                } else {
                    mvMediaSource = 0;
                }
                this.mMvExDeLock.unlock();
                _setDataSource(str, mvMediaSource, j, j2);
                if (j > 0) {
                    this.mSeekComplete = false;
                    this.mSeekTimeMs = j;
                    _seekTo(j);
                    return;
                }
                return;
            }
            this.strDataSource = str;
            _setDataSource(str, j, j2);
        }
    }

    public void setDataSource(String str, AudioTypeInfo audioTypeInfo, long j, long j2) {
        if (this.mLibraryLoadSuccess) {
            this.mSeekComplete = true;
            this.mSeekTimeMs = -1L;
            this.strDataSource = str;
            _setDataSource(str, audioTypeInfo, j, j2);
        }
    }

    public void setDataSource(PlayParam playParam) {
        if (this.mLibraryLoadSuccess) {
            this.mSeekComplete = true;
            this.mSeekTimeMs = -1L;
            _setDataSource(playParam);
        }
    }
}
