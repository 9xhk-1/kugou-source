package com.kugou.framework.lyric2;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.kugou.framework.lyric.LyricManager;
import com.kugou.framework.lyric.debug.LyricDebug;
import com.kugou.framework.lyric2.render.cell.CellUtils;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: classes2.dex */
public abstract class BaseLyricView extends View implements ISurLyricSync {
    private static final int MSG_CALCU = 2;
    private static final int MSG_SCROLL_FINISH = 3;
    private int PlayedStaticColor;
    public final Object allHeightLock;
    public int allRowHeight;
    public int backgroundColor;
    private int cellMargin;
    public float cellRowMargin;
    public float cutFactor;
    public float fontScaleFactor;
    public boolean isNeedDrawStatic;
    public boolean isNeedLayoutAtChanged;
    public AtomicBoolean isScrolling;
    public int lineHeight;
    public int lineHeightPlusCellMargin;
    private AtomicBoolean mIsDrawing;
    private LyricHandler mLyricHandler;
    private Paint mPaint;
    public long mPlayingTime;
    private int normalFadeModeColor;
    private int notPlayColor;
    public OnClickSeekToListener onClickSeekToListener;
    public OnNewLyricSlidingListener onNewLyricSlidingListener;
    private int playLyricHighlightBgColor;
    private int playedColor;
    private Lock ptLock;
    public AtomicBoolean rePosCenterPos;
    public float rectBottom;
    public float rectTop;
    public int scrollRowOffset;
    public int surHeight;
    private int surLyricBg;
    public int surWidth;
    private float textSize;

    public class LyricHandler extends Handler {
        public LyricHandler(Looper looper) {
            super(looper);
            LyricDebug.assertFalse(looper == Looper.getMainLooper());
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i2 = message.what;
            if (i2 == 2) {
                BaseLyricView.this.preDoCalcu();
                return;
            }
            if (i2 != 3) {
                BaseLyricView.this.handleSubMessage(message);
                return;
            }
            OnNewLyricSlidingListener onNewLyricSlidingListener = BaseLyricView.this.onNewLyricSlidingListener;
            if (onNewLyricSlidingListener != null) {
                onNewLyricSlidingListener.scrollTimeOut();
            }
            BaseLyricView.this.isScrolling.set(false);
        }
    }

    public interface OnClickSeekToListener {
        long onSeekTo();
    }

    public interface OnNewLyricSlidingListener {
        void onAutoRollBack();

        void onClickSeekToListener(OnClickSeekToListener onClickSeekToListener);

        void onSlidingMove(long j);

        void onSlidingStart();

        void onSlidingStop(long j);

        void scrollTimeOut();
    }

    public BaseLyricView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.cellMargin = 60;
        this.cellRowMargin = 10.0f;
        this.cutFactor = 0.7f;
        this.fontScaleFactor = 1.1f;
        this.surLyricBg = InputDeviceCompat.SOURCE_ANY;
        this.isNeedLayoutAtChanged = false;
        this.surWidth = 768;
        this.surHeight = 768;
        this.textSize = 50.0f;
        this.lineHeightPlusCellMargin = 0;
        this.rectTop = 0.0f;
        this.rectBottom = 0.0f;
        this.backgroundColor = -2697514;
        this.playedColor = -16776961;
        this.notPlayColor = -1;
        this.playLyricHighlightBgColor = -16711936;
        this.PlayedStaticColor = -1;
        this.normalFadeModeColor = Color.parseColor("#999999");
        this.mLyricHandler = null;
        this.isNeedDrawStatic = true;
        this.isScrolling = new AtomicBoolean(false);
        this.rePosCenterPos = new AtomicBoolean(false);
        this.mIsDrawing = new AtomicBoolean(false);
        this.mPlayingTime = 0L;
        this.scrollRowOffset = 0;
        this.allHeightLock = new Object();
        this.ptLock = new ReentrantLock();
        this.onClickSeekToListener = new OnClickSeekToListener() { // from class: com.kugou.framework.lyric2.BaseLyricView.1
            @Override // com.kugou.framework.lyric2.BaseLyricView.OnClickSeekToListener
            public long onSeekTo() {
                return BaseLyricView.this.getScrollingRowTime();
            }
        };
        this.mLyricHandler = new LyricHandler(LyricManager.getLyricWorkLooper());
        initPaint();
    }

    private void handleDrawLyric(Canvas canvas) {
        try {
            try {
                drawLyric(canvas);
            } catch (Exception e2) {
                e2.printStackTrace();
                LyricDebug.e("handleDrawLyric " + e2.getMessage());
            }
        } finally {
            this.mIsDrawing.set(false);
        }
    }

    private void initPaint() {
        if (this.mPaint == null) {
            this.mPaint = new Paint();
        }
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStrokeCap(Paint.Cap.ROUND);
        this.mPaint.setTextSize(this.textSize);
        this.mPaint.setColor(-1);
        this.mPaint.setTypeface(Typeface.defaultFromStyle(0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void preDoCalcu() {
        if (this.mIsDrawing.get()) {
            LyricDebug.e("aimed is drawing, finish calcu");
            return;
        }
        this.mIsDrawing.set(true);
        try {
            try {
            } catch (Exception unused) {
                LyricDebug.e("calcu error");
                if (!this.mIsDrawing.get()) {
                    return;
                }
            }
            if (!this.ptLock.tryLock()) {
                if (this.mIsDrawing.get()) {
                    this.mIsDrawing.set(false);
                    return;
                }
                return;
            }
            try {
                if (calcuLyric()) {
                    if (!this.isScrolling.get()) {
                        scrollToPlayingRow();
                    } else if (this.rePosCenterPos.get()) {
                        rePosCenterPos();
                        this.rePosCenterPos.set(false);
                    }
                    if (Looper.getMainLooper() == Looper.myLooper()) {
                        if (this.isNeedDrawStatic) {
                            invalidate();
                        } else {
                            invalidate(0, (int) this.rectTop, getWidth(), (int) this.rectBottom);
                        }
                    } else if (this.isNeedDrawStatic) {
                        postInvalidate();
                    } else {
                        postInvalidate(0, (int) this.rectTop, getWidth(), (int) this.rectBottom);
                    }
                }
                if (!this.mIsDrawing.get()) {
                    return;
                }
                this.mIsDrawing.set(false);
            } finally {
                this.ptLock.unlock();
            }
        } catch (Throwable th) {
            if (this.mIsDrawing.get()) {
                this.mIsDrawing.set(false);
            }
            throw th;
        }
    }

    public abstract boolean calcuLyric();

    public abstract void computeLyricScroll();

    public void doCalcu() {
        LyricHandler lyricHandler;
        if (!this.mIsDrawing.get() && (lyricHandler = this.mLyricHandler) != null) {
            lyricHandler.sendEmptyMessage(2);
            return;
        }
        LyricHandler lyricHandler2 = this.mLyricHandler;
        if (lyricHandler2 != null) {
            lyricHandler2.sendEmptyMessageDelayed(2, 10L);
        }
    }

    public abstract void drawLyric(Canvas canvas);

    public float getCellMargin() {
        return isNeedSameRowMargin() ? this.cellRowMargin : this.cellMargin;
    }

    public int getLineHeight() {
        if (this.lineHeight == 0) {
            this.lineHeight = (int) (CellUtils.getWordHeight(getmPaint()) + CellUtils.getLeading(getmPaint()) + this.cellRowMargin);
        }
        return this.lineHeight;
    }

    public int getLineHeightPlusCellMargin() {
        if (this.lineHeightPlusCellMargin == 0) {
            float wordHeight = CellUtils.getWordHeight(getmPaint()) + CellUtils.getLeading(getmPaint()) + this.cellRowMargin;
            this.lineHeightPlusCellMargin = ((int) ((((getCellMargin() + wordHeight) * 3.0f) / 2.0f) + wordHeight)) + 1;
        }
        return this.lineHeightPlusCellMargin;
    }

    public Handler getLyricHandler() {
        return this.mLyricHandler;
    }

    public int getNormalFadeModeColor() {
        return this.normalFadeModeColor;
    }

    public int getNotPlayColor(long j, long j2) {
        return this.notPlayColor;
    }

    public int getPlayLyricHighlightBgColor() {
        return this.playLyricHighlightBgColor;
    }

    public int getPlayedColor(long j, long j2) {
        return this.playedColor;
    }

    public int getPlayedStaticColor() {
        return this.PlayedStaticColor;
    }

    public int getScrollRowOffset() {
        return this.scrollRowOffset;
    }

    public abstract int getScrollTimeNoticeDelay();

    public abstract long getScrollingRowTime();

    public int getSurHeight() {
        return this.surHeight;
    }

    public int getSurLyricBg() {
        return this.surLyricBg;
    }

    public int getSurWidth() {
        return this.surWidth;
    }

    public Paint getmPaint() {
        return this.mPaint;
    }

    public long getmPlayingTime() {
        return this.mPlayingTime;
    }

    public boolean hadScrollMsg() {
        return this.mLyricHandler.hasMessages(3);
    }

    public abstract void handleSubMessage(Message message);

    public boolean isNeedLayoutAtChanged() {
        return this.isNeedLayoutAtChanged;
    }

    public abstract boolean isNeedSameRowMargin();

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        handleDrawLyric(canvas);
    }

    @Override // android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        if (!isNeedLayoutAtChanged()) {
            setViewSize(getWidth(), getHeight());
        } else if (z) {
            setViewSize(getWidth(), getHeight());
        }
    }

    public abstract void rePosCenterPos();

    public void reSendScrollMsg() {
        this.mLyricHandler.removeMessages(3);
        this.mLyricHandler.sendEmptyMessage(3);
    }

    public void scrollLyricView(boolean z) {
        if (!this.isScrolling.get()) {
            this.isScrolling.set(true);
        }
        boolean zHasMessages = this.mLyricHandler.hasMessages(3);
        if (z) {
            if (zHasMessages) {
                this.mLyricHandler.removeMessages(3);
            }
            this.mLyricHandler.sendEmptyMessageDelayed(3, getScrollTimeNoticeDelay());
        }
    }

    public abstract void scrollToPlayingRow();

    @Override // android.view.View
    public void setBackgroundColor(int i2) {
        this.backgroundColor = i2;
        postInvalidate();
    }

    public void setCellMargin(int i2) {
        this.cellMargin = i2;
    }

    public void setIsNeedLayoutAtChanged(boolean z) {
        this.isNeedLayoutAtChanged = z;
    }

    public void setIsScrolling(boolean z) {
        if (z && !this.isScrolling.get()) {
            this.isScrolling.set(true);
        } else {
            if (z || !this.isScrolling.get() || this.mLyricHandler.hasMessages(3)) {
                return;
            }
            this.isScrolling.set(false);
        }
    }

    public void setNormalFadeModeColor(int i2) {
        this.normalFadeModeColor = i2;
    }

    public void setNotPlayColor(int i2) {
        this.notPlayColor = i2;
    }

    public void setPlayLyricHighlightBgColor(int i2) {
        this.playLyricHighlightBgColor = i2;
    }

    public void setPlayedColor(int i2) {
        this.playedColor = i2;
    }

    public void setPlayedStaticColor(int i2) {
        this.PlayedStaticColor = i2;
    }

    public void setScrollRowOffset(int i2) {
        this.scrollRowOffset = i2;
    }

    public void setSlidingListener(OnNewLyricSlidingListener onNewLyricSlidingListener) {
        this.onNewLyricSlidingListener = onNewLyricSlidingListener;
        if (onNewLyricSlidingListener == null) {
            return;
        }
        onNewLyricSlidingListener.onClickSeekToListener(this.onClickSeekToListener);
    }

    public void setSurHeight(int i2) {
        this.surHeight = i2;
    }

    public void setSurLyricBg(int i2) {
        this.surLyricBg = i2;
    }

    public void setSurWidth(int i2) {
        this.surWidth = i2;
    }

    public void setTextSize(float f2) {
        this.textSize = f2;
        this.mPaint.setTextSize(f2);
    }

    public void setViewSize(int i2, int i3) {
        setSurWidth(i2);
        setSurHeight(i3);
        requestLayout();
    }

    public void setmPaint(Paint paint) {
        this.mPaint = paint;
    }

    public void setmPlayingTime(long j) {
        this.mPlayingTime = j;
    }

    @Override // com.kugou.framework.lyric2.ISurLyricSync
    public void syncLyric2(long j) {
        LyricHandler lyricHandler;
        if (this.ptLock.tryLock()) {
            try {
                if (!this.mIsDrawing.get() && (lyricHandler = this.mLyricHandler) != null) {
                    lyricHandler.sendEmptyMessage(2);
                    this.mPlayingTime = j;
                }
            } finally {
                this.ptLock.unlock();
            }
        }
    }

    public BaseLyricView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }
}
