package com.kugou.framework.lyric;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import android.view.WindowManager;
import com.kugou.framework.lyric.LyricView;
import com.kugou.framework.lyric.loader.language.Language;

/* JADX INFO: loaded from: classes2.dex */
public class DeskLyricView extends LyricView {
    public static final int ALIGN_MODE_CENTER = 2;
    public static final int ALIGN_MODE_LEFT_RIGHT = 1;
    public int alignMode;
    private int b;
    private float firstMoveTime;
    private boolean isGradient;
    private boolean isHightLight;
    private boolean isLyricSplited;
    private boolean isSingleLine;
    private boolean isTextBorder;
    private int l;
    private Language language;
    private OnLyricDataLoadListener lyricDataLoadListener;
    private boolean mClicked;
    private int mClickedRowIndex;
    private boolean mFinalRefresh;
    private boolean mHasCallBack;
    private LyricView.InterceptLongClickCallback mInterceptLongClickCallback;
    private LyricView.LongClickCallBack mLongClickCallBack;
    private float mYCoordinate;
    private int r;
    private float remainWidth;
    private float rowMoveX;
    private int t;
    private int textBorderColor;
    private float timeDelay;
    private float timePercent;
    private float transFirstMoveTime;
    private float transRemainWidth;
    private float transRowMoveX;
    private float transTimeDelay;
    private float widthPercent;
    private int windowWidth;

    public interface OnLyricDataLoadListener {
        void onLyricDataLoaded(LyricData lyricData);
    }

    public DeskLyricView(Context context) {
        super(context, null);
        this.widthPercent = 0.75f;
        this.timePercent = 0.3f;
        this.isSingleLine = false;
        this.isLyricSplited = true;
        this.language = Language.Origin;
        this.alignMode = 1;
        this.isHightLight = true;
        this.isTextBorder = false;
        this.textBorderColor = Color.parseColor("#BD212121");
        this.isGradient = true;
        this.mFinalRefresh = false;
    }

    private void drawTextBorder(Canvas canvas, float f2, float f3, String str) {
        Shader shader = this.pen.getShader();
        int color = this.pen.getColor();
        Paint.Style style = this.pen.getStyle();
        float strokeWidth = this.pen.getStrokeWidth();
        boolean zIsFakeBoldText = this.pen.isFakeBoldText();
        this.pen.setShader(null);
        this.pen.setColor(this.textBorderColor);
        this.pen.setStyle(Paint.Style.STROKE);
        this.pen.setStrokeWidth(1.0f);
        this.pen.setFakeBoldText(true);
        canvas.drawText(str, f2 - 1.0f, 1.0f + f3, this.pen);
        this.pen.setShader(shader);
        this.pen.setColor(color);
        this.pen.setStyle(style);
        this.pen.setStrokeWidth(strokeWidth);
        this.pen.setFakeBoldText(zIsFakeBoldText);
        canvas.drawText(str, f2, f3, this.pen);
    }

    /* JADX WARN: Removed duplicated region for block: B:107:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0144  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x015b  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0163  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0167  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x016c  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0172  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0174  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x018e  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x01ab  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x01ce  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x01d5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void drawTransLyricView(android.graphics.Canvas r26, int r27, float r28, float r29, float r30, int[] r31, int[] r32, int[] r33, float r34, int r35, int r36, float r37, long r38, float[] r40, com.kugou.framework.lyric.loader.language.Language r41) {
        /*
            Method dump skipped, instruction units count: 580
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kugou.framework.lyric.DeskLyricView.drawTransLyricView(android.graphics.Canvas, int, float, float, float, int[], int[], int[], float, int, int, float, long, float[], com.kugou.framework.lyric.loader.language.Language):void");
    }

    private void drawWhiteBackground(Canvas canvas, float f2, float f3, int i2) {
        LyricView.LongClickCallBack longClickCallBack;
        int top = getTop();
        if (this.mClicked) {
            float f4 = this.mYCoordinate;
            float f5 = top;
            float f6 = f3 / 2.0f;
            float f7 = (f2 - f6) - 13.0f;
            if (f4 - f5 > f7) {
                float f8 = (f2 - 13.0f) + f6;
                if (f4 - f5 >= f8 || shouldInterceptTouchEvent()) {
                    return;
                }
                Paint paint = new Paint();
                paint.setColor(this.mShadowColor);
                paint.setStyle(Paint.Style.FILL);
                canvas.drawRect(0.0f, f7, this.windowWidth, f8, paint);
                if (this.mHasCallBack || (longClickCallBack = this.mLongClickCallBack) == null) {
                    return;
                }
                this.mClickedRowIndex = i2;
                longClickCallBack.longClickCallBack(i2);
                this.mHasCallBack = true;
            }
        }
    }

    private boolean shouldInterceptTouchEvent() {
        LyricView.InterceptLongClickCallback interceptLongClickCallback = this.mInterceptLongClickCallback;
        if (interceptLongClickCallback == null) {
            return false;
        }
        return interceptLongClickCallback.shouldInterceptLongClickEvent();
    }

    @Override // com.kugou.framework.lyric.LyricView, com.kugou.framework.lyric.ILyricView
    public float getContentWidth() {
        return super.getContentWidth() * 0.4f;
    }

    public LyricView.LongClickCallBack getLongClickCallBack() {
        return this.mLongClickCallBack;
    }

    public int getTextBorderColor() {
        return this.textBorderColor;
    }

    public float getYCoordinate() {
        return this.mYCoordinate;
    }

    @Override // com.kugou.framework.lyric.LyricView
    public void initSetting() {
        super.initSetting();
        this.paddingLeft = 0.0f;
        this.paddingRight = 0.0f;
        this.pen.setShadowLayer(1.0f, 1.0f, 1.0f, -16777216);
    }

    @Override // com.kugou.framework.lyric.LyricView, com.kugou.framework.lyric.ILyricView
    public boolean isLyrViewShown() {
        return isShown();
    }

    @Override // com.kugou.framework.lyric.LyricView, com.kugou.framework.lyric.ILyricView
    public boolean isLyricSplited() {
        return this.isLyricSplited;
    }

    @Override // com.kugou.framework.lyric.LyricView, android.view.View
    public void onMeasure(int i2, int i3) {
        this.windowWidth = ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay().getWidth();
        int size = View.MeasureSpec.getSize(i2);
        int size2 = View.MeasureSpec.getSize(i3);
        if (View.MeasureSpec.getMode(i3) != 1073741824) {
            size2 = (int) ((this.rowHeight * 2.0f) + this.paddingTop + this.paddingBottom);
        }
        setMeasuredDimension(size, size2);
    }

    @Override // com.kugou.framework.lyric.LyricView, com.kugou.framework.lyric.ILyricView
    public synchronized void refresh() {
        LyricData lyricData = this.lyricData;
        if (lyricData != null) {
            if (lyricData.isRowChanging() || this.lyricData.isMoving() || this.resetRowIndex) {
                invalidate();
                this.mFinalRefresh = false;
                this.resetRowIndex = false;
            } else if (this.mFinalRefresh) {
                invalidate(this.l, this.t, this.r, this.b);
            } else {
                invalidate();
                this.mFinalRefresh = true;
            }
        }
    }

    @Override // com.kugou.framework.lyric.LyricView, com.kugou.framework.lyric.ILyricView
    public synchronized void release() {
        super.release();
        this.rowMoveX = 0.0f;
        this.firstMoveTime = 0.0f;
    }

    public void setAlignMode(int i2) {
        this.alignMode = i2;
    }

    public void setGradient(boolean z) {
        this.isGradient = z;
    }

    public void setHightLight(boolean z) {
        this.isHightLight = z;
    }

    public void setInterceptLongClickCallback(LyricView.InterceptLongClickCallback interceptLongClickCallback) {
        this.mInterceptLongClickCallback = interceptLongClickCallback;
    }

    public void setLanguage(Language language) {
        if (language == this.language) {
            return;
        }
        this.language = language;
        Language language2 = Language.Origin;
        setSingleLine(language != language2);
        setLyricSplited(language == language2);
        if (this.lyricData != null) {
            LyricManager.getInstance().splitLyric();
        }
        postInvalidate();
        requestLayout();
    }

    public void setLongClickCallBack(LyricView.LongClickCallBack longClickCallBack) {
        this.mLongClickCallBack = longClickCallBack;
    }

    public void setLongClickYCoordinate(float f2, boolean z) {
        this.mYCoordinate = f2;
        this.mClicked = z;
        this.mHasCallBack = false;
        invalidate();
    }

    @Override // com.kugou.framework.lyric.LyricView, com.kugou.framework.lyric.ILyricView
    public void setLyricData(LyricData lyricData) {
        super.setLyricData(lyricData);
        OnLyricDataLoadListener onLyricDataLoadListener = this.lyricDataLoadListener;
        if (onLyricDataLoadListener != null) {
            onLyricDataLoadListener.onLyricDataLoaded(lyricData);
        }
    }

    @Override // com.kugou.framework.lyric.LyricView
    public void setLyricSplited(boolean z) {
        this.isLyricSplited = z;
    }

    public void setOnLyricDataLoadListener(OnLyricDataLoadListener onLyricDataLoadListener) {
        this.lyricDataLoadListener = onLyricDataLoadListener;
    }

    public void setShadowLayer(boolean z) {
        if (z) {
            this.pen.setShadowLayer(1.0f, 1.0f, 1.0f, -16777216);
        } else {
            this.pen.setShadowLayer(0.0f, 1.0f, 1.0f, -16777216);
        }
    }

    public void setSingleLine(boolean z) {
        this.isSingleLine = z;
    }

    public void setTextBorder(boolean z) {
        this.isTextBorder = z;
    }

    public void setTextBorderColor(int i2) {
        this.textBorderColor = i2;
    }

    @Override // com.kugou.framework.lyric.LyricView
    public void showDefaultMsg(Canvas canvas) {
        this.pen.setColor(this.frontColor);
        int width = getWidth();
        int height = getHeight();
        float fMeasureText = (width - this.pen.measureText(this.defaultMsg)) / 2.0f;
        float f2 = ((height + this.wordHeight) / 2.0f) - this.leading;
        int[] iArr = {-1, this.backgroundColor};
        this.pen.setShader(null);
        canvas.drawText(this.defaultMsg, fMeasureText, f2, this.pen);
        this.pen.setShader(new LinearGradient(fMeasureText, f2 - this.wordHeight, fMeasureText, f2, iArr, (float[]) null, Shader.TileMode.MIRROR));
        canvas.drawText(this.defaultMsg, fMeasureText, f2, this.pen);
        if (this.isTextBorder) {
            drawTextBorder(canvas, fMeasureText, f2, this.defaultMsg);
        }
        if (!this.mHasCallBack) {
            this.mHasCallBack = true;
        }
        if (this.mClicked) {
            this.mClicked = false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:67:0x01ef A[Catch: all -> 0x0595, NullPointerException -> 0x05b8, TryCatch #7 {NullPointerException -> 0x05b8, all -> 0x0595, blocks: (B:42:0x0139, B:44:0x0148, B:46:0x015e, B:48:0x0167, B:49:0x016a, B:50:0x0170, B:52:0x018a, B:57:0x019e, B:59:0x01a6, B:61:0x01c7, B:62:0x01d7, B:64:0x01e1, B:66:0x01e7, B:68:0x01f3, B:70:0x01fb, B:71:0x01fd, B:73:0x0204, B:75:0x023c, B:76:0x025b, B:78:0x025f, B:79:0x0262, B:81:0x026e, B:82:0x0277, B:84:0x029a, B:85:0x02c4, B:87:0x02c8, B:88:0x02cb, B:90:0x02d4, B:92:0x02e7, B:93:0x02ef, B:95:0x02fe, B:101:0x0316, B:102:0x0318, B:104:0x0339, B:105:0x035d, B:107:0x0361, B:98:0x0308, B:67:0x01ef, B:54:0x0191, B:108:0x0369, B:110:0x0386, B:112:0x038d, B:113:0x0390, B:114:0x0395, B:116:0x03ae, B:122:0x03c5, B:125:0x03cd, B:127:0x03d5, B:129:0x03f6, B:130:0x0406, B:132:0x0411, B:134:0x041e, B:136:0x0426, B:137:0x0428, B:133:0x041a, B:138:0x042c, B:140:0x0462, B:141:0x0481, B:143:0x0485, B:144:0x0488, B:146:0x0494, B:147:0x049d, B:149:0x04c0, B:150:0x04ea, B:152:0x04ee, B:153:0x04f1, B:155:0x04f8, B:157:0x0509, B:158:0x0511, B:160:0x0520, B:164:0x0533, B:166:0x054f, B:167:0x0570, B:169:0x0574, B:163:0x0529, B:119:0x03b8), top: B:224:0x0139 }] */
    @Override // com.kugou.framework.lyric.LyricView
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized void showLyric(android.graphics.Canvas r36) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 1505
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kugou.framework.lyric.DeskLyricView.showLyric(android.graphics.Canvas):void");
    }

    public DeskLyricView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.widthPercent = 0.75f;
        this.timePercent = 0.3f;
        this.isSingleLine = false;
        this.isLyricSplited = true;
        this.language = Language.Origin;
        this.alignMode = 1;
        this.isHightLight = true;
        this.isTextBorder = false;
        this.textBorderColor = Color.parseColor("#BD212121");
        this.isGradient = true;
        this.mFinalRefresh = false;
    }

    public DeskLyricView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.widthPercent = 0.75f;
        this.timePercent = 0.3f;
        this.isSingleLine = false;
        this.isLyricSplited = true;
        this.language = Language.Origin;
        this.alignMode = 1;
        this.isHightLight = true;
        this.isTextBorder = false;
        this.textBorderColor = Color.parseColor("#BD212121");
        this.isGradient = true;
        this.mFinalRefresh = false;
    }
}
