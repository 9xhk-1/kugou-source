package com.kugou.framework.lyric4;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityManager;
import com.kugou.framework.lyric.ILyricView;
import com.kugou.framework.lyric.LyricConstent;
import com.kugou.framework.lyric.LyricData;
import com.kugou.framework.lyric.debug.LyricDebug;
import com.kugou.framework.lyric.loader.language.Language;
import com.kugou.framework.lyric2.ISurLyricSync;
import com.kugou.framework.lyric4.cell.Cell;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public abstract class BaseLyricView extends View implements ILyricView, ISurLyricSync {
    public static final long TAP_LONG_PRESS_TIME_OUT = 300;
    public static final long TAP_TIME_OUT = 500;
    public ValueAnimator animator;
    private boolean checkNeedShowAnimationFlag;
    private boolean disableDoubleTap;
    private volatile long end;
    public boolean isHighContrastTextSet;
    public int lastInsideLineIndex;
    public LyricCutDelegate lyricCutDelegate;
    public AttachInfo mAttachInfo;
    public boolean mCanSlide;
    public boolean mCellClickEnable;
    public boolean mCellLongClickEnable;
    public Paint mDefaultMessagePaint;
    public Paint mDefaultMessageStrokePaint;
    public boolean mDisableTouchEvent;
    private boolean mHasUpdateOnce;
    public boolean mIsCellLayoutValid;
    private boolean mIsDefaultMessageCenter;
    private LyricData mLyricData;
    public String mNewDefaultMsg;
    public OnCellExposeListener mOnCellExposeListener;
    public OnClickInterceptListener mOnClickInterceptListener;
    public OnCellClickListener mOnItemClickListener;
    public OnCellLongClickListener mOnItemLongClickListener;
    public OnLyricDataLoadListener mOnLyricDataLoadListener;
    public OnLyricViewBlankAreaClickListener mOnLyricViewBlankAreaClickListener;
    public OnLyricViewClickListener mOnLyricViewClickListener;
    public OnNewCellClickListener mOnNewCellClickListener;
    public LyricData mOriginalLyricData;
    public boolean mScaleHighLightLine;
    public WeakHandler mWeakHandler;
    private boolean needInitSpan;
    public OnLyricTranslateXListener onLyricTranslateXListener;
    private PreSetDataCallback preSetDataCallback;
    public float scaleRate;
    private volatile long start;
    public boolean supportScroll;

    public interface OnCellClickListener {
        void onItemClick(Cell cell, int i2);
    }

    public interface OnCellExposeListener {
        void onExpose(int i2);
    }

    public interface OnCellLongClickListener {
        void onItemLongClick(Cell cell, int i2, float f2);
    }

    public interface OnClickInterceptListener {
        boolean shouldInterceptEvent();
    }

    public interface OnLyricDataLoadListener {
        void onLyricDataLoaded(LyricData lyricData);
    }

    public interface OnLyricTranslateXListener {
        void onEndTranslateX();

        void onStartTranslateX();
    }

    public interface OnLyricViewBlankAreaClickListener {
        void onLyricViewBlankAreaClick();
    }

    public interface OnLyricViewClickListener {
        void onClick(View view);

        void onDoubleClick();
    }

    public interface OnNewCellClickListener {
        void onClick(Cell cell);
    }

    public interface OnTouchInterceptListener {
        boolean OnTouchIntercept();

        boolean shouldInterceptEvent(MotionEvent motionEvent);
    }

    public interface PreSetDataCallback {
        void onPreSetData(BaseLyricView baseLyricView);
    }

    public static class WeakHandler extends Handler {
        public static final int ANIMATION = 2;
        public static final int GLRENDER = 3;
        public static final int SCROLL_CENTER = 4;
        public static final int TAP = 10;
        public static final String TOUCH_X = "touch_x";
        public static final String TOUCH_Y = "touch_y";
        private WeakReference<BaseLyricView> mViewWeakReference;

        public WeakHandler(Looper looper, BaseLyricView baseLyricView) {
            super(looper);
            this.mViewWeakReference = new WeakReference<>(baseLyricView);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Bundle data;
            BaseLyricView baseLyricView = this.mViewWeakReference.get();
            int i2 = message.what;
            if (i2 == 2) {
                if (baseLyricView != null) {
                    baseLyricView.setRealHighLightZoom(baseLyricView.scaleRate);
                    return;
                }
                return;
            }
            if (i2 != 3) {
                if (i2 != 4) {
                    if (i2 == 10 && baseLyricView != null) {
                        if (baseLyricView.mOnLyricViewBlankAreaClickListener != null && (data = message.getData()) != null) {
                            float f2 = data.getFloat(TOUCH_X, -1.0f);
                            float f3 = data.getFloat(TOUCH_Y, -1.0f);
                            if (f2 > 0.0f && f3 > 0.0f && baseLyricView.isTouchInBlankArea(f2, f3)) {
                                baseLyricView.mOnLyricViewBlankAreaClickListener.onLyricViewBlankAreaClick();
                                return;
                            }
                        }
                        if (baseLyricView.mOnLyricViewClickListener == null || baseLyricView.onClick()) {
                            return;
                        }
                        baseLyricView.mOnLyricViewClickListener.onClick(baseLyricView);
                        return;
                    }
                    return;
                }
            } else if (baseLyricView != null) {
                baseLyricView.changeGLRenderFlag();
            }
            if (baseLyricView != null) {
                baseLyricView.reScrollToCenter();
            }
        }
    }

    public BaseLyricView(Context context) {
        this(context, null);
    }

    private boolean checkChangeLine(int i2, int i3, float f2) {
        return i2 != i3;
    }

    private boolean checkNeedShowAnimtion(int i2, int i3, float f2) {
        return this.mScaleHighLightLine && this.checkNeedShowAnimationFlag && i2 != i3 && i3 == i2 + 1 && this.mLyricData.getRowBeginTime()[i3] - this.mLyricData.getRowBeginTime()[i2] >= 150;
    }

    private void disableHighContrastText(Canvas canvas) {
        if (canvas == null) {
            return;
        }
        Method declaredMethod = null;
        try {
            for (Class<?> superclass = canvas.getClass(); superclass != Object.class; superclass = superclass.getSuperclass()) {
                try {
                    declaredMethod = superclass.getDeclaredMethod("setHighContrastText", Boolean.TYPE);
                } catch (Exception unused) {
                }
            }
            if (declaredMethod != null) {
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(canvas, Boolean.FALSE);
            }
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
        } catch (IllegalArgumentException e3) {
            e3.printStackTrace();
        } catch (InvocationTargetException e4) {
            e4.printStackTrace();
        } catch (Exception e5) {
            e5.printStackTrace();
        }
    }

    private void initView() {
        this.mDefaultMessagePaint.setColor(-1);
        this.mDefaultMessagePaint.setTextSize(this.mAttachInfo.getTextSize());
        this.mWeakHandler = new WeakHandler(Looper.getMainLooper(), this);
        this.isHighContrastTextSet = isHighContrastTextEnable(getContext());
    }

    private boolean isHighContrastTextEnable(Context context) {
        AccessibilityManager accessibilityManager = (AccessibilityManager) context.getSystemService("accessibility");
        if (accessibilityManager == null) {
            return false;
        }
        try {
            Method declaredMethod = accessibilityManager.getClass().getDeclaredMethod("isHighTextContrastEnabled", new Class[0]);
            if (declaredMethod != null) {
                declaredMethod.setAccessible(true);
                Object objInvoke = declaredMethod.invoke(accessibilityManager, new Object[0]);
                if (objInvoke instanceof Boolean) {
                    return ((Boolean) objInvoke).booleanValue();
                }
                return false;
            }
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
        } catch (IllegalArgumentException e3) {
            e3.printStackTrace();
        } catch (InvocationTargetException e4) {
            e4.printStackTrace();
        } catch (Exception e5) {
            e5.printStackTrace();
        }
        return false;
    }

    private boolean isLyricDataValid(LyricData lyricData) {
        return (lyricData == null || lyricData.getWords() == null || lyricData.getWords().length == 0 || lyricData.getRowBeginTime() == null || lyricData.getRowBeginTime().length == 0 || lyricData.getRowDelayTime() == null || lyricData.getRowDelayTime().length == 0 || lyricData.getWordBeginTime() == null || lyricData.getWordBeginTime().length == 0 || lyricData.getWordDelayTime() == null || lyricData.getWordDelayTime().length == 0) ? false : true;
    }

    private void updateAttachInfo(int i2, long j, long[] jArr) {
        int i3;
        long j2;
        int i4 = 100;
        if (i2 >= this.mLyricData.getWordBeginTime().length) {
            int length = this.mLyricData.getWords().length - 1;
            int length2 = this.mLyricData.getWords()[length].length - 1;
            this.mAttachInfo.setCurWordsBeginTimePercentage(100);
            this.mAttachInfo.setCurrentHighLightLine(length);
            this.mAttachInfo.setCurrentHighLightWord(length2);
            this.mAttachInfo.setCurrentHighLightPercentage(100);
            this.mAttachInfo.setLineTotalWords(this.mLyricData.getWords()[length].length);
            return;
        }
        long[] jArr2 = this.mLyricData.getWordBeginTime()[i2];
        if (jArr2 == null) {
            return;
        }
        long j3 = j - jArr[i2];
        int i5 = 0;
        for (int i6 = 0; i6 < jArr2.length && j3 >= jArr2[i6]; i6++) {
            i5 = i6;
        }
        if (i2 > this.mLyricData.getWords().length - 1) {
            int length3 = this.mLyricData.getWords().length - 1;
            int length4 = this.mLyricData.getWords()[length3].length - 1;
            this.mAttachInfo.setCurWordsBeginTimePercentage(100);
            this.mAttachInfo.setCurrentHighLightLine(length3);
            this.mAttachInfo.setCurrentHighLightWord(length4);
            this.mAttachInfo.setCurrentHighLightPercentage(100);
            this.mAttachInfo.setLineTotalWords(this.mLyricData.getWords()[length3].length);
            return;
        }
        int iMin = Math.min(this.mLyricData.getWords()[i2].length - 1, this.mLyricData.getWordBeginTime()[i2].length - 1);
        if (iMin < 0) {
            return;
        }
        if (i5 > iMin) {
            i5 = iMin;
        }
        long j4 = this.mLyricData.getWordDelayTime()[i2][i5];
        if (j4 == 0 || (i3 = (int) (((j3 - this.mLyricData.getWordBeginTime()[i2][i5]) * 100) / j4)) > 100) {
            i3 = 100;
        } else if (i3 < 0) {
            i3 = 0;
        }
        if (j < jArr[i2] + this.mLyricData.getWordBeginTime()[i2][0]) {
            i4 = -1;
        } else if (j <= jArr[i2] + this.mLyricData.getWordBeginTime()[i2][iMin] + this.mLyricData.getWordDelayTime()[i2][iMin]) {
            if (i5 == this.mLyricData.getWordBeginTime()[i2][iMin]) {
                i4 = i3;
            } else {
                LyricDebug.e("currentLine " + i2 + "," + this.mLyricData.getWords()[i2].length + "," + this.mLyricData.getWordBeginTime()[i2].length + "," + this.mLyricData.getWordDelayTime()[i2].length);
                try {
                    j2 = this.mLyricData.getWordBeginTime()[i2][i5 + 1] - this.mLyricData.getWordBeginTime()[i2][i5];
                } catch (Exception e2) {
                    e2.printStackTrace();
                    j2 = 100;
                }
                int i7 = j2 > 0 ? (int) (((j3 - this.mLyricData.getWordBeginTime()[i2][i5]) * 100) / j2) : -1;
                if (i7 <= 100) {
                    i4 = i7;
                }
            }
        }
        this.mAttachInfo.setCurWordsBeginTimePercentage(i4);
        this.mAttachInfo.setCurrentHighLightLine(i2);
        this.mAttachInfo.setCurrentHighLightWord(i5);
        this.mAttachInfo.setCurrentHighLightPercentage(i3);
        this.mAttachInfo.setLineTotalWords(this.mLyricData.getWords()[i2].length);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateProgress(long j) {
        if (isLyricDataValid(this.mLyricData)) {
            if (this.mLyricData.getLyricType() == 3 || !this.supportScroll) {
                this.mAttachInfo.setCurrentHighLightLine(0);
                this.mAttachInfo.setCurrentHighLightWord(0);
                this.mAttachInfo.setCurrentHighLightPercentage(0);
                this.mAttachInfo.setLineTotalWords(this.mLyricData.getWords()[0].length);
                if (this.mHasUpdateOnce) {
                    return;
                }
                updateView();
                this.mHasUpdateOnce = true;
                return;
            }
            this.mHasUpdateOnce = false;
            long[] rowBeginTime = this.mLyricData.getRowBeginTime();
            int iUpdateCurrentLine = updateCurrentLine(j, rowBeginTime, this.mLyricData.getRowDelayTime(), this.mLyricData.getWordBeginTime());
            int currentHighLightLine = this.mAttachInfo.getCurrentHighLightLine();
            updateAttachInfo(iUpdateCurrentLine, j, rowBeginTime);
            int currentHighLightLine2 = this.mAttachInfo.getCurrentHighLightLine();
            if (currentHighLightLine == currentHighLightLine2 + 1) {
                this.checkNeedShowAnimationFlag = false;
                this.mWeakHandler.postDelayed(new Runnable() { // from class: com.kugou.framework.lyric4.BaseLyricView.5
                    @Override // java.lang.Runnable
                    public void run() {
                        BaseLyricView.this.checkNeedShowAnimationFlag = true;
                    }
                }, 40L);
            }
            LyricDebug.d("updateProgress: pre->" + currentHighLightLine + " cur line->" + this.mAttachInfo.getCurrentHighLightLine() + "wordIndex->" + this.mAttachInfo.getCurrentHighLightWord() + " percentage->" + this.mAttachInfo.getCurrentHighLightPercentage());
            float f2 = (float) j;
            if (checkNeedShowAnimtion(currentHighLightLine, currentHighLightLine2, f2)) {
                this.mAttachInfo.setShowHighLight(true);
                startChangeLineAnimation(currentHighLightLine, currentHighLightLine2);
                return;
            }
            if (!this.mScaleHighLightLine && checkChangeLine(currentHighLightLine, currentHighLightLine2, f2)) {
                this.lastInsideLineIndex = 0;
                this.mAttachInfo.setShowHighLight(true);
            } else if (!this.mScaleHighLightLine && checkChangeLineInside(this.mAttachInfo.getCurrentHighLightLine(), this.mAttachInfo.getCurrentHighLightWord())) {
                this.mAttachInfo.setShowHighLight(true);
            }
            updateView();
        }
    }

    public void changeGLRenderFlag() {
    }

    public abstract boolean checkChangeLineInside(int i2, int i3);

    public void cut(final long j, final long j2) {
        this.start = j;
        this.end = j2;
        this.mWeakHandler.post(new Runnable() { // from class: com.kugou.framework.lyric4.BaseLyricView.2
            @Override // java.lang.Runnable
            public void run() {
                if (BaseLyricView.this.mLyricData != null) {
                    BaseLyricView baseLyricView = BaseLyricView.this;
                    baseLyricView.mLyricData = baseLyricView.lyricCutDelegate.cutLyricData(j, j2);
                    BaseLyricView baseLyricView2 = BaseLyricView.this;
                    baseLyricView2.onLyricDataSet(baseLyricView2.mLyricData);
                }
            }
        });
    }

    public void drawDefaultMessage(Canvas canvas) {
        float scrollY;
        String str = LyricConstent.defaultMsg;
        if (!TextUtils.isEmpty(this.mNewDefaultMsg)) {
            str = this.mNewDefaultMsg;
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        int width = getWidth();
        int height = getHeight();
        this.mDefaultMessagePaint.setTextSize(this.mAttachInfo.getTextSize());
        this.mDefaultMessagePaint.setTypeface(this.mAttachInfo.getTypeface());
        if (this.mAttachInfo.isBoldText()) {
            this.mDefaultMessagePaint.setFakeBoldText(true);
        } else {
            this.mDefaultMessagePaint.setFakeBoldText(false);
        }
        float fMeasureText = this.mDefaultMessagePaint.measureText(str);
        Paint.FontMetrics fontMetrics = this.mDefaultMessagePaint.getFontMetrics();
        float f2 = getCellAlignMode() == 1 ? 0.0f : (width - fMeasureText) / 2.0f;
        if (this.mIsDefaultMessageCenter) {
            float f3 = fontMetrics.bottom;
            scrollY = (((height / 2) + ((f3 - fontMetrics.top) / 2.0f)) - f3) - getScrollY();
        } else {
            float f4 = fontMetrics.bottom;
            float f5 = fontMetrics.top;
            scrollY = ((((f4 - f5) / 2.0f) + ((f4 - f5) / 2.0f)) - f4) - getScrollY();
        }
        if (this.mAttachInfo.isStroke()) {
            this.mDefaultMessageStrokePaint.setStyle(Paint.Style.STROKE);
            this.mDefaultMessageStrokePaint.setStrokeWidth(this.mAttachInfo.getStrokePenSize());
            this.mDefaultMessageStrokePaint.setFakeBoldText(true);
            this.mDefaultMessageStrokePaint.setTypeface(this.mAttachInfo.getTypeface());
            this.mDefaultMessageStrokePaint.setColor(this.mAttachInfo.getStrokeColor());
            this.mDefaultMessageStrokePaint.setTextSize(this.mAttachInfo.getTextSize());
            canvas.drawText(str, f2, scrollY, this.mDefaultMessageStrokePaint);
        }
        canvas.drawText(str, f2, scrollY, this.mDefaultMessagePaint);
    }

    public AttachInfo getAttachInfo() {
        return this.mAttachInfo;
    }

    public List<Language> getCanUseType() {
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(Language.Origin);
        LyricData lyricData = this.mLyricData;
        if (lyricData != null) {
            if (lyricData.getTranslateWords() != null) {
                arrayList.add(Language.Translation);
            }
            if (this.mLyricData.getTransliterationWords() != null) {
                arrayList.add(Language.Transliteration);
            }
            if (this.mLyricData.getChineseWords() != null) {
                arrayList.add(Language.Chinese);
            }
        }
        return arrayList;
    }

    public int getCellAlignMode() {
        return this.mAttachInfo.getCellAlignMode();
    }

    @Override // com.kugou.framework.lyric.ILyricView
    public float getContentWidth() {
        return 0.0f;
    }

    @Override // com.kugou.framework.lyric.ILyricView
    public String getCurrentLyrics() {
        return null;
    }

    public Paint getDefaultMessagePaint() {
        this.mDefaultMessagePaint.setTextSize(this.mAttachInfo.getTextSize());
        this.mDefaultMessagePaint.setTypeface(this.mAttachInfo.getTypeface());
        if (this.mAttachInfo.isBoldText()) {
            this.mDefaultMessagePaint.setFakeBoldText(true);
        } else {
            this.mDefaultMessagePaint.setFakeBoldText(false);
        }
        return this.mDefaultMessagePaint;
    }

    public Language getLanguage() {
        return this.mAttachInfo.getLanguage();
    }

    @Override // com.kugou.framework.lyric.ILyricView
    public LyricData getLyricData() {
        return this.mLyricData;
    }

    @Override // com.kugou.framework.lyric.ILyricView
    public Paint getPen() {
        return null;
    }

    public PreSetDataCallback getPreSetDataCallback() {
        return this.preSetDataCallback;
    }

    @Override // com.kugou.framework.lyric.ILyricView
    public float getRowHeight() {
        return 0.0f;
    }

    public int getTextColor() {
        return this.mAttachInfo.getTextColor();
    }

    public int getTextHighLightColor() {
        return this.mAttachInfo.getTextHighLightColor();
    }

    public float getTextHighLightZoom() {
        return this.mAttachInfo.getHighLightTextZoomRate();
    }

    @Override // com.kugou.framework.lyric.ILyricView
    public float getTextSize() {
        return this.mAttachInfo.getTextSize();
    }

    public void handleClickEvent(MotionEvent motionEvent) {
        handleClickEvent(motionEvent, true);
    }

    public boolean isCanSlide() {
        return this.mCanSlide;
    }

    public boolean isCellClickEnable() {
        return this.mCellClickEnable;
    }

    public boolean isCellLongClickEnable() {
        return this.mCellLongClickEnable;
    }

    @Override // com.kugou.framework.lyric.ILyricView
    public boolean isLyrViewShown() {
        return getVisibility() == 0;
    }

    @Override // com.kugou.framework.lyric.ILyricView
    public boolean isLyricLoaded() {
        return this.mLyricData != null;
    }

    @Override // com.kugou.framework.lyric.ILyricView
    public boolean isLyricSplited() {
        return false;
    }

    public boolean isNeedInitSpan() {
        return this.needInitSpan;
    }

    public boolean isTouchInBlankArea(float f2, float f3) {
        return false;
    }

    public boolean onClick() {
        return false;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.isHighContrastTextSet) {
            try {
                disableHighContrastText(canvas);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public abstract void onLyricDataSet(LyricData lyricData);

    public void reScrollToCenter() {
    }

    @Override // com.kugou.framework.lyric.ILyricView
    public void refresh() {
        postInvalidate();
    }

    @Override // com.kugou.framework.lyric.ILyricView
    public void release() {
        this.mWeakHandler.post(new Runnable() { // from class: com.kugou.framework.lyric4.BaseLyricView.3
            @Override // java.lang.Runnable
            public void run() {
                BaseLyricView.this.mLyricData = null;
                BaseLyricView baseLyricView = BaseLyricView.this;
                baseLyricView.mOriginalLyricData = null;
                baseLyricView.mAttachInfo.setHighLightTextZoomRate(1.0f);
                BaseLyricView.this.mAttachInfo.setCurrentHighLightLine(0);
                BaseLyricView.this.mAttachInfo.setCurrentHighLightWord(0);
                BaseLyricView.this.mAttachInfo.setCurrentHighLightPercentage(0);
                BaseLyricView.this.mAttachInfo.setShowHighLight(true);
                BaseLyricView.this.lastInsideLineIndex = 0;
            }
        });
    }

    @Override // com.kugou.framework.lyric.ILyricView
    public void resetRowIndex() {
    }

    public void setBlur(int i2) {
        this.mAttachInfo.setBlur(i2);
    }

    public void setBoldHighLightWord(boolean z) {
        this.mAttachInfo.setBoldHighLightWord(z);
        this.mIsCellLayoutValid = false;
        invalidate();
    }

    public void setBreakFactor(float f2) {
        this.mAttachInfo.setBreakFactor(f2);
    }

    public void setCanSlide(boolean z) {
        this.mCanSlide = z;
    }

    public void setCellAlignMode(int i2) {
        this.mAttachInfo.setCellAlignMode(i2);
        this.mIsCellLayoutValid = false;
        invalidate();
    }

    public void setCellClickEnable(boolean z) {
        this.mCellClickEnable = z;
    }

    public void setCellLineSpacing(int i2) {
        this.mAttachInfo.setLineSpacing(i2);
        this.mIsCellLayoutValid = false;
        invalidate();
    }

    public void setCellLongClickEnable(boolean z) {
        this.mCellLongClickEnable = z;
    }

    public void setCellRowMargin(int i2) {
        this.mAttachInfo.setCellRowMargin(i2);
        this.mIsCellLayoutValid = false;
        invalidate();
    }

    public void setChineseTextSize(int i2) {
        this.mAttachInfo.setChineseTextSize(i2);
        this.mIsCellLayoutValid = false;
        invalidate();
    }

    public void setDefaultMessageCenter(boolean z) {
        this.mIsDefaultMessageCenter = z;
    }

    public void setDefaultMessageStyle(int i2) {
        this.mDefaultMessagePaint.setColor(i2);
    }

    @Override // com.kugou.framework.lyric.ILyricView
    public void setDefaultMsg(String str) {
        LyricConstent.defaultMsg = str;
    }

    public void setDisableDoubleTap(boolean z) {
        this.disableDoubleTap = z;
    }

    public void setDisableTouchEvent(boolean z) {
        this.mDisableTouchEvent = z;
    }

    public void setIsBoldText(boolean z) {
        this.mAttachInfo.setBoldText(z);
        this.mIsCellLayoutValid = false;
        invalidate();
    }

    public void setLanguage(Language language) {
        this.mAttachInfo.setLanguage(language);
        this.mIsCellLayoutValid = false;
        invalidate();
    }

    public void setLyricAlpha(float f2) {
        this.mAttachInfo.setAlpha(f2);
    }

    @Override // com.kugou.framework.lyric.ILyricView
    public void setLyricData(final LyricData lyricData) {
        this.mWeakHandler.post(new Runnable() { // from class: com.kugou.framework.lyric4.BaseLyricView.1
            @Override // java.lang.Runnable
            public void run() {
                if (lyricData == null) {
                    return;
                }
                if (BaseLyricView.this.preSetDataCallback != null) {
                    BaseLyricView.this.preSetDataCallback.onPreSetData(BaseLyricView.this);
                }
                BaseLyricView.this.lyricCutDelegate.setRawData(lyricData);
                BaseLyricView baseLyricView = BaseLyricView.this;
                LyricData lyricDataCutLyricData = baseLyricView.lyricCutDelegate.cutLyricData(baseLyricView.start, BaseLyricView.this.end);
                BaseLyricView baseLyricView2 = BaseLyricView.this;
                baseLyricView2.mOriginalLyricData = lyricDataCutLyricData;
                OnLyricDataLoadListener onLyricDataLoadListener = baseLyricView2.mOnLyricDataLoadListener;
                if (onLyricDataLoadListener != null) {
                    onLyricDataLoadListener.onLyricDataLoaded(lyricData);
                }
                BaseLyricView.this.setLyricDataInternal(lyricDataCutLyricData);
                BaseLyricView baseLyricView3 = BaseLyricView.this;
                baseLyricView3.onLyricDataSet(baseLyricView3.mLyricData);
            }
        });
        if (this.mScaleHighLightLine) {
            this.mWeakHandler.removeMessages(2);
            this.mWeakHandler.sendEmptyMessageDelayed(2, 500L);
        }
    }

    public void setLyricDataInternal(LyricData lyricData) {
        this.mLyricData = lyricData;
        if (lyricData != null) {
            this.mAttachInfo.setLyrType(lyricData.getLyricType());
        }
        this.mAttachInfo.setHighLightTextZoomRate(1.0f);
        this.mAttachInfo.setCurrentHighLightLine(0);
        this.mAttachInfo.setCurrentHighLightWord(0);
        this.mAttachInfo.setCurrentHighLightPercentage(0);
        this.mAttachInfo.setShowHighLight(true);
    }

    public void setMultiTextSize(int i2, int i3, int i4, int i5) {
        this.mAttachInfo.setTextSize(i2);
        this.mAttachInfo.setTranslationTextSize(i4);
        this.mAttachInfo.setTransliterationTextSize(i4);
        this.mAttachInfo.setChineseTextSize(i5);
        this.mIsCellLayoutValid = false;
        invalidate();
    }

    public void setNeedInitSpan(boolean z) {
        this.needInitSpan = z;
    }

    public void setNewDefaultMsg(String str) {
        this.mNewDefaultMsg = str;
        invalidate();
    }

    public void setOnCellClickListener(OnCellClickListener onCellClickListener) {
        this.mOnItemClickListener = onCellClickListener;
    }

    public void setOnCellLongClickListener(OnCellLongClickListener onCellLongClickListener) {
        this.mOnItemLongClickListener = onCellLongClickListener;
    }

    public void setOnClickInterceptListener(OnClickInterceptListener onClickInterceptListener) {
        this.mOnClickInterceptListener = onClickInterceptListener;
    }

    public void setOnLyricDataLoadListener(OnLyricDataLoadListener onLyricDataLoadListener) {
        this.mOnLyricDataLoadListener = onLyricDataLoadListener;
    }

    public void setOnLyricTranslateXListener(OnLyricTranslateXListener onLyricTranslateXListener) {
        this.onLyricTranslateXListener = onLyricTranslateXListener;
    }

    public void setOnLyricViewBlankAreaClickListener(OnLyricViewBlankAreaClickListener onLyricViewBlankAreaClickListener) {
        this.mOnLyricViewBlankAreaClickListener = onLyricViewBlankAreaClickListener;
    }

    public void setOnLyricViewClickListener(OnLyricViewClickListener onLyricViewClickListener) {
        this.mOnLyricViewClickListener = onLyricViewClickListener;
    }

    public void setOnNewCellClickListener(OnNewCellClickListener onNewCellClickListener) {
        this.mOnNewCellClickListener = onNewCellClickListener;
    }

    public void setPreSetDataCallback(PreSetDataCallback preSetDataCallback) {
        this.preSetDataCallback = preSetDataCallback;
    }

    public void setPressColor(int i2) {
        this.mAttachInfo.setPressColor(i2);
    }

    public void setRealHighLightZoom(float f2) {
        this.mAttachInfo.setHighLightTextZoomRate(f2);
        this.mIsCellLayoutValid = false;
        invalidate();
    }

    public void setScaleHighLightWord(boolean z) {
        getAttachInfo().setScaleHighLightWord(z);
        this.mIsCellLayoutValid = false;
        invalidate();
    }

    public void setSelectedLineColor(int i2) {
        this.mAttachInfo.setSelectedLineColor(i2);
        invalidate();
    }

    public void setStroke(boolean z) {
        this.mAttachInfo.setStroke(z);
    }

    public void setStrokePenSize(float f2) {
        getAttachInfo().setStrokePenSize(f2);
        invalidate();
    }

    public void setStrokeStyle(int i2) {
        this.mAttachInfo.setStrokeColor(i2);
    }

    public void setSubLyricMarginTop(int i2) {
        this.mAttachInfo.setSubLyricMarginTop(i2);
        this.mIsCellLayoutValid = false;
        invalidate();
    }

    public void setSupportScroll(boolean z) {
        this.supportScroll = z;
    }

    public void setTextColor(int i2) {
        this.mAttachInfo.setTextColor(i2);
        invalidate();
    }

    public void setTextHighLightColor(int i2) {
        this.mAttachInfo.setTextHighLightColor(i2);
        invalidate();
    }

    public void setTextHighLightZoom(float f2) {
        this.scaleRate = f2;
        setRealHighLightZoom(f2);
    }

    public void setTextPlayLineColor(int i2, boolean z) {
        this.mAttachInfo.setShowPlayingLineLight(z);
        this.mAttachInfo.setTextLineColor(i2);
        this.mAttachInfo.setSelectedLineColor(i2);
        invalidate();
    }

    public void setTextSize(int i2) {
        this.mAttachInfo.setTextSize(i2);
        this.mIsCellLayoutValid = false;
        invalidate();
    }

    public void setTranslationTextSize(int i2) {
        this.mAttachInfo.setTranslationTextSize(i2);
        this.mIsCellLayoutValid = false;
        invalidate();
    }

    public void setTransliterationTextSize(int i2) {
        this.mAttachInfo.setTransliterationTextSize(i2);
        this.mIsCellLayoutValid = false;
        invalidate();
    }

    public void setTxtNoSupportText(String str) {
        this.mAttachInfo.setTxtNoSupportText(str);
    }

    public void setTypeface(Typeface typeface) {
        this.mAttachInfo.setTypeface(typeface);
        this.mIsCellLayoutValid = false;
        invalidate();
    }

    public void showAnimation(boolean z) {
        this.mScaleHighLightLine = z;
        this.mIsCellLayoutValid = false;
        invalidate();
    }

    public abstract void startChangeLineAnimation(int i2, int i3);

    @Override // com.kugou.framework.lyric2.ISurLyricSync
    public void syncLyric2(final long j) {
        this.mWeakHandler.post(new Runnable() { // from class: com.kugou.framework.lyric4.BaseLyricView.4
            @Override // java.lang.Runnable
            public void run() {
                BaseLyricView.this.updateProgress(j);
            }
        });
    }

    public int updateCurrentLine(long j, long[] jArr, long[] jArr2, long[][] jArr3) {
        int length = 0;
        for (int i2 = 0; i2 < jArr.length; i2++) {
            if (i2 >= jArr3.length) {
                length = jArr3.length - 1;
            } else {
                if (i2 == 0) {
                    if (j <= jArr[i2] - 200) {
                        return 0;
                    }
                    length = 0;
                }
                if (j > jArr[i2] + jArr2[i2]) {
                    if (i2 != jArr.length - 1) {
                        length = i2 + 1;
                        if (jArr[length] - (jArr[i2] + jArr2[i2]) <= 400 || j > jArr[length] - 200) {
                        }
                    }
                    return i2;
                }
                int i3 = i2 + 1;
                if (jArr.length <= i3 || j < jArr[i3]) {
                    break;
                }
                length = i3;
            }
        }
        return length;
    }

    public abstract void updateView();

    public BaseLyricView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void handleClickEvent(MotionEvent motionEvent, boolean z) {
        if (motionEvent.getEventTime() - motionEvent.getDownTime() < ViewConfiguration.getLongPressTimeout()) {
            boolean zHasMessages = this.mWeakHandler.hasMessages(10);
            if (zHasMessages) {
                this.mWeakHandler.removeMessages(10);
            }
            if (zHasMessages) {
                OnLyricViewClickListener onLyricViewClickListener = this.mOnLyricViewClickListener;
                if (onLyricViewClickListener != null) {
                    onLyricViewClickListener.onDoubleClick();
                    return;
                }
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putFloat(WeakHandler.TOUCH_X, motionEvent.getX());
            bundle.putFloat(WeakHandler.TOUCH_Y, motionEvent.getY());
            Message messageObtain = Message.obtain();
            messageObtain.what = 10;
            messageObtain.setData(bundle);
            this.mWeakHandler.sendMessageDelayed(messageObtain, (!z || this.disableDoubleTap) ? 0L : ViewConfiguration.getDoubleTapTimeout());
        }
    }

    public BaseLyricView(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.mIsCellLayoutValid = false;
        this.mAttachInfo = new AttachInfo();
        this.mCellClickEnable = true;
        this.mCellLongClickEnable = true;
        this.mCanSlide = true;
        this.mDefaultMessagePaint = new Paint(1);
        this.mDefaultMessageStrokePaint = new Paint(1);
        this.mHasUpdateOnce = false;
        this.mIsDefaultMessageCenter = true;
        this.mScaleHighLightLine = false;
        this.supportScroll = true;
        this.lastInsideLineIndex = 0;
        this.needInitSpan = false;
        this.start = -1L;
        this.end = -1L;
        this.lyricCutDelegate = new LyricCutDelegate();
        this.checkNeedShowAnimationFlag = true;
        initView();
    }
}
