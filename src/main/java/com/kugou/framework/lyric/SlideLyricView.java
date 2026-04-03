package com.kugou.framework.lyric;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewConfiguration;
import java.util.Formatter;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public class SlideLyricView extends FullScreenLyricView implements View.OnClickListener {
    private static final int TOUCH_STATE_REST = 0;
    private static final int TOUCH_STATE_SCROLLING = 1;
    private boolean canSlide;
    private long firstTime;
    private float firstY;
    private boolean isShowMiddleLine;
    private boolean isShowTime;
    private Paint linePen;
    private int mTouchState;
    public int middleLineColor;
    private long offsetTime;
    public int rowNum;
    private float slideDistance;
    private SlidingListener slidingListener;
    private int touchSlop;

    public interface SlidingListener {
        long getDuration();

        long getPosition();

        void onSlidingStart();

        void onSlidingStop(long j);
    }

    public SlideLyricView(Context context) {
        this(context, null);
    }

    private String makeTimeString(long j) {
        long j2 = j / 60;
        return new Formatter(new StringBuilder(), Locale.getDefault()).format("%2$d:%5$02d", Long.valueOf(j / 3600), Long.valueOf(j2), Long.valueOf(j2 % 60), Long.valueOf(j), Long.valueOf(j % 60)).toString();
    }

    private void setLyricDataMoving(boolean z) {
        LyricData lyricData = this.lyricData;
        if (lyricData != null) {
            lyricData.setMoving(z);
        }
    }

    private void showTime(Canvas canvas, long j) {
        String strMakeTimeString = makeTimeString(j / 1000);
        this.linePen.setColor(Color.parseColor("#4D000000"));
        float height = getHeight() / 2.0f;
        canvas.drawRect(0.0f, ((height - getWordHeight(this.linePen)) - 1.0f) + 3.0f, this.linePen.measureText(strMakeTimeString) + 6.0f, height - 1.0f, this.linePen);
        this.linePen.setColor(this.middleLineColor);
        canvas.drawText(strMakeTimeString, 3.0f, height - 3.0f, this.linePen);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // com.kugou.framework.lyric.LyricView, android.view.View
    public void onDraw(Canvas canvas) {
        if (this.lyricData == null) {
            showDefaultMsg(canvas);
            return;
        }
        if (this.mTouchState != 1) {
            showLyric(canvas);
            return;
        }
        long duration = this.firstTime + this.offsetTime;
        if (duration < 0) {
            duration = 0;
        } else if (duration > this.slidingListener.getDuration()) {
            duration = this.slidingListener.getDuration();
        }
        LyricSyncer.sync(this.lyricData, duration, this.pen, this.rowHeight, getBigTextSize(), getSmallTextSize());
        showLyric(canvas);
        if (this.isShowMiddleLine) {
            showMiddleLine(canvas);
        }
        if (this.isShowTime) {
            showTime(canvas, duration);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x001c  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouchEvent(android.view.MotionEvent r11) {
        /*
            r10 = this;
            com.kugou.framework.lyric.LyricData r0 = r10.lyricData
            r1 = 0
            if (r0 == 0) goto La2
            boolean r0 = r10.canSlide
            if (r0 != 0) goto Lb
            goto La2
        Lb:
            int r0 = r11.getAction()
            r2 = 1
            if (r0 == 0) goto L51
            if (r0 == r2) goto L1c
            r3 = 2
            if (r0 == r3) goto L61
            r3 = 3
            if (r0 == r3) goto L1c
            goto L9b
        L1c:
            int r0 = r10.mTouchState
            if (r0 != r2) goto L9b
            r10.setLyricDataMoving(r1)
            com.kugou.framework.lyric.SlideLyricView$SlidingListener r11 = r10.slidingListener
            long r4 = r11.getPosition()
            float r8 = r10.getBigTextSize()
            float r9 = r10.getSmallTextSize()
            com.kugou.framework.lyric.LyricManager r11 = com.kugou.framework.lyric.LyricManager.getInstance()
            r11.resetRowIndex()
            com.kugou.framework.lyric.LyricData r3 = r10.lyricData
            android.graphics.Paint r6 = r10.pen
            float r7 = r10.rowHeight
            com.kugou.framework.lyric.LyricSyncer.sync(r3, r4, r6, r7, r8, r9)
            r10.mTouchState = r1
            long r0 = r10.firstTime
            long r3 = r10.offsetTime
            long r0 = r0 + r3
            com.kugou.framework.lyric.SlideLyricView$SlidingListener r11 = r10.slidingListener
            r11.onSlidingStop(r0)
            r10.invalidate()
            return r2
        L51:
            r10.mTouchState = r1
            com.kugou.framework.lyric.SlideLyricView$SlidingListener r0 = r10.slidingListener
            long r3 = r0.getPosition()
            r10.firstTime = r3
            float r0 = r11.getY()
            r10.firstY = r0
        L61:
            float r0 = r11.getY()
            float r3 = r10.firstY
            float r3 = r0 - r3
            float r3 = java.lang.Math.abs(r3)
            int r3 = (int) r3
            int r4 = r10.mTouchState
            if (r4 == r2) goto L7d
            int r4 = r10.touchSlop
            if (r3 <= r4) goto L7d
            r10.mTouchState = r2
            com.kugou.framework.lyric.SlideLyricView$SlidingListener r3 = r10.slidingListener
            r3.onSlidingStart()
        L7d:
            int r3 = r10.mTouchState
            if (r3 != r2) goto L9b
            r10.setLyricDataMoving(r2)
            float r11 = r10.firstY
            float r11 = r11 - r0
            r10.slideDistance = r11
            r0 = 1169915904(0x45bb8000, float:6000.0)
            float r1 = r10.rowHeight
            float r0 = r0 / r1
            float r11 = r11 * r0
            long r0 = (long) r11
            r10.offsetTime = r0
            r10.resetRowIndex()
            r10.invalidate()
            return r2
        L9b:
            r10.mTouchState = r1
            boolean r11 = super.onTouchEvent(r11)
            return r11
        La2:
            r10.mTouchState = r1
            boolean r11 = super.onTouchEvent(r11)
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kugou.framework.lyric.SlideLyricView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public void setCanSlide(boolean z) {
        this.canSlide = z;
    }

    public void setLongClickYCoordinate(float f2, boolean z) {
        this.mYCoordinate = f2;
        this.mClicked = z;
        this.mHasCallBack = false;
        invalidate();
    }

    public void setMiddleLineColor(int i2) {
        this.middleLineColor = i2;
    }

    public void setShowMiddleLine(boolean z) {
        this.isShowMiddleLine = z;
    }

    public void setSlidingListener(SlidingListener slidingListener) {
        this.slidingListener = slidingListener;
    }

    public void setshowTime(boolean z) {
        this.isShowTime = z;
    }

    public void showMiddleLine(Canvas canvas) {
        this.linePen.setColor(this.middleLineColor);
        canvas.drawLine(0.0f, getHeight() / 2.0f, getWidth(), getHeight() / 2.0f, this.linePen);
    }

    public SlideLyricView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SlideLyricView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.mTouchState = 0;
        this.canSlide = true;
        this.isShowMiddleLine = true;
        this.isShowTime = true;
        this.touchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        setOnClickListener(this);
        this.middleLineColor = this.backgroundColor;
        Paint paint = new Paint();
        this.linePen = paint;
        paint.setAntiAlias(true);
        this.linePen.setTextSize(25.0f);
        this.linePen.setStrokeWidth(1.0f);
        this.linePen.setTypeface(Typeface.defaultFromStyle(0));
    }
}
