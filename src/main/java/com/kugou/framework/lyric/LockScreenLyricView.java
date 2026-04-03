package com.kugou.framework.lyric;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.kugou.uilib.widget.textview.span.TopicHighlightHelper;

/* JADX INFO: loaded from: classes2.dex */
public class LockScreenLyricView extends LyricView {
    private boolean AutoFade;
    private boolean autoChangeSize;
    private boolean autoGrow;
    private int b;
    private float firstMoveTime;
    private boolean fullScreen;
    private int l;
    private int lyricRowNum;
    private boolean mFinalRefresh;
    public int maxRows;
    private boolean needDrawBottom;
    private boolean needDrawTop;
    private int r;
    private float remainWidth;
    private float rowMoveX;
    public Paint smallPen;
    public float smallTextSize;
    public float smallWordHeight;
    private int t;
    private float timeDelay;
    private float timePercent;
    private float widthPercent;

    public LockScreenLyricView(Context context) {
        this(context, null);
    }

    private int countRowNum(float f2, float f3, float f4, float f5) {
        return (int) Math.floor((f2 + f4) / (f3 + f4));
    }

    private String[] getStepColors(int i2, int i3) {
        int i4;
        String strSubstring;
        int i5 = 0;
        String str = String.format("#%06X", Integer.valueOf(i2 & (-1)));
        if (TextUtils.isEmpty(str)) {
            i4 = 255;
            strSubstring = "666666";
        } else {
            i4 = Integer.parseInt(str.replace(TopicHighlightHelper.SHARP, "").substring(0, 2), 16);
            strSubstring = str.replace(TopicHighlightHelper.SHARP, "").substring(2);
        }
        int i6 = i3 + 1;
        String[] strArr = new String[i6];
        double d2 = i4;
        Double.isNaN(d2);
        double d3 = i6;
        Double.isNaN(d3);
        int i7 = (int) ((d2 * 0.8d) / d3);
        while (i5 < i6) {
            int i8 = i5 + 1;
            String hexString = Integer.toHexString(i4 - (i7 * i8));
            if ("0".equals(hexString)) {
                hexString = "11";
            }
            strArr[i5] = TopicHighlightHelper.SHARP + hexString + strSubstring;
            i5 = i8;
        }
        return strArr;
    }

    private void setSmallTextSize(float f2) {
        float f3 = f2 - 6.0f;
        if (f3 > 0.0f) {
            f2 = f3;
        }
        this.smallTextSize = f2;
    }

    public float getBigTextSize() {
        return this.textSize;
    }

    public boolean getDrawBottom() {
        return this.needDrawBottom;
    }

    public boolean getDrawTop() {
        return this.needDrawTop;
    }

    public float getSmallTextSize() {
        return this.autoChangeSize ? this.smallTextSize : getBigTextSize();
    }

    @Override // com.kugou.framework.lyric.LyricView
    public void initPen() {
        super.initPen();
        if (this.smallPen == null) {
            this.smallPen = new Paint();
        }
        this.smallPen.setAntiAlias(true);
        this.smallPen.setStrokeCap(Paint.Cap.ROUND);
        this.smallPen.setTextSize(getSmallTextSize());
        this.smallPen.setTypeface(Typeface.defaultFromStyle(0));
        this.smallWordHeight = getWordHeight(this.smallPen);
    }

    @Override // com.kugou.framework.lyric.LyricView
    public void initSetting() {
        super.initSetting();
        setSmallTextSize(this.textSize);
        this.paddingLeft = 0.0f;
        this.paddingRight = 0.0f;
    }

    public boolean isAutoFade() {
        return this.AutoFade;
    }

    @Override // com.kugou.framework.lyric.LyricView, com.kugou.framework.lyric.ILyricView
    public boolean isLyrViewShown() {
        return isShown();
    }

    @Override // com.kugou.framework.lyric.LyricView, com.kugou.framework.lyric.ILyricView
    public boolean isLyricSplited() {
        return true;
    }

    @Override // com.kugou.framework.lyric.LyricView, android.view.View
    public void onMeasure(int i2, int i3) {
        int size = View.MeasureSpec.getSize(i2);
        int size2 = View.MeasureSpec.getSize(i3);
        if (View.MeasureSpec.getMode(i3) != 1073741824) {
            int i4 = this.lyricRowNum;
            if (!this.fullScreen) {
                int i5 = this.maxRows;
                if (i5 > 0) {
                    i4 = i5;
                }
                size2 = Math.min(size2, (int) Math.ceil((i4 * this.rowHeight) + this.paddingTop + this.paddingBottom));
            }
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

    public void setAutoChangeSize(boolean z) {
        this.autoChangeSize = z;
    }

    public void setAutoFade(boolean z) {
        this.AutoFade = z;
    }

    public void setAutoGrow(boolean z) {
        this.autoGrow = z;
    }

    public void setDrawBottom(boolean z) {
        this.needDrawBottom = z;
    }

    public void setDrawTop(boolean z) {
        this.needDrawTop = z;
    }

    public void setFullScreen(boolean z) {
        this.fullScreen = z;
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (z) {
            layoutParams.height = -1;
        } else {
            layoutParams.height = -2;
        }
        setLayoutParams(layoutParams);
        requestLayout();
    }

    public void setMaxRows(int i2) {
        this.maxRows = i2;
        requestLayout();
    }

    @Override // com.kugou.framework.lyric.LyricView
    public void setTextSize(float f2) {
        setSmallTextSize(f2);
        super.setTextSize(f2);
    }

    @Override // com.kugou.framework.lyric.LyricView
    public void showDefaultMsg(Canvas canvas) {
        this.pen.setShader(null);
        this.pen.setColor(this.backgroundColor);
        canvas.drawText(this.defaultMsg, (getWidth() - this.pen.measureText(this.defaultMsg)) / 2.0f, ((getHeight() + this.wordHeight) / 2.0f) - this.leading, this.pen);
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x02b6 A[Catch: all -> 0x030e, TryCatch #0 {, blocks: (B:4:0x0005, B:9:0x000c, B:11:0x0059, B:12:0x005b, B:16:0x0063, B:18:0x00a4, B:19:0x00a6, B:21:0x00c8, B:23:0x00cc, B:24:0x00d0, B:26:0x00d6, B:29:0x00dc, B:36:0x00e9, B:38:0x00f7, B:40:0x0109, B:42:0x0127, B:44:0x0130, B:45:0x0133, B:46:0x0138, B:51:0x015a, B:53:0x0164, B:55:0x018a, B:56:0x019b, B:58:0x01a4, B:60:0x01aa, B:62:0x01b6, B:64:0x01be, B:65:0x01c0, B:68:0x01c8, B:70:0x01e8, B:72:0x0212, B:73:0x021a, B:79:0x0227, B:81:0x023a, B:83:0x0240, B:85:0x0255, B:87:0x0268, B:88:0x0270, B:91:0x0284, B:84:0x024e, B:80:0x0233, B:92:0x029a, B:93:0x02a2, B:96:0x02aa, B:98:0x02b0, B:100:0x02b6, B:102:0x02cb, B:104:0x02dc, B:105:0x02e4, B:108:0x02f8, B:101:0x02c4, B:61:0x01b2, B:33:0x00e4), top: B:117:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:101:0x02c4 A[Catch: all -> 0x030e, TryCatch #0 {, blocks: (B:4:0x0005, B:9:0x000c, B:11:0x0059, B:12:0x005b, B:16:0x0063, B:18:0x00a4, B:19:0x00a6, B:21:0x00c8, B:23:0x00cc, B:24:0x00d0, B:26:0x00d6, B:29:0x00dc, B:36:0x00e9, B:38:0x00f7, B:40:0x0109, B:42:0x0127, B:44:0x0130, B:45:0x0133, B:46:0x0138, B:51:0x015a, B:53:0x0164, B:55:0x018a, B:56:0x019b, B:58:0x01a4, B:60:0x01aa, B:62:0x01b6, B:64:0x01be, B:65:0x01c0, B:68:0x01c8, B:70:0x01e8, B:72:0x0212, B:73:0x021a, B:79:0x0227, B:81:0x023a, B:83:0x0240, B:85:0x0255, B:87:0x0268, B:88:0x0270, B:91:0x0284, B:84:0x024e, B:80:0x0233, B:92:0x029a, B:93:0x02a2, B:96:0x02aa, B:98:0x02b0, B:100:0x02b6, B:102:0x02cb, B:104:0x02dc, B:105:0x02e4, B:108:0x02f8, B:101:0x02c4, B:61:0x01b2, B:33:0x00e4), top: B:117:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:104:0x02dc A[Catch: all -> 0x030e, LOOP:4: B:103:0x02da->B:104:0x02dc, LOOP_END, TryCatch #0 {, blocks: (B:4:0x0005, B:9:0x000c, B:11:0x0059, B:12:0x005b, B:16:0x0063, B:18:0x00a4, B:19:0x00a6, B:21:0x00c8, B:23:0x00cc, B:24:0x00d0, B:26:0x00d6, B:29:0x00dc, B:36:0x00e9, B:38:0x00f7, B:40:0x0109, B:42:0x0127, B:44:0x0130, B:45:0x0133, B:46:0x0138, B:51:0x015a, B:53:0x0164, B:55:0x018a, B:56:0x019b, B:58:0x01a4, B:60:0x01aa, B:62:0x01b6, B:64:0x01be, B:65:0x01c0, B:68:0x01c8, B:70:0x01e8, B:72:0x0212, B:73:0x021a, B:79:0x0227, B:81:0x023a, B:83:0x0240, B:85:0x0255, B:87:0x0268, B:88:0x0270, B:91:0x0284, B:84:0x024e, B:80:0x0233, B:92:0x029a, B:93:0x02a2, B:96:0x02aa, B:98:0x02b0, B:100:0x02b6, B:102:0x02cb, B:104:0x02dc, B:105:0x02e4, B:108:0x02f8, B:101:0x02c4, B:61:0x01b2, B:33:0x00e4), top: B:117:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:107:0x02f7  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0284 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00dc A[Catch: all -> 0x030e, TryCatch #0 {, blocks: (B:4:0x0005, B:9:0x000c, B:11:0x0059, B:12:0x005b, B:16:0x0063, B:18:0x00a4, B:19:0x00a6, B:21:0x00c8, B:23:0x00cc, B:24:0x00d0, B:26:0x00d6, B:29:0x00dc, B:36:0x00e9, B:38:0x00f7, B:40:0x0109, B:42:0x0127, B:44:0x0130, B:45:0x0133, B:46:0x0138, B:51:0x015a, B:53:0x0164, B:55:0x018a, B:56:0x019b, B:58:0x01a4, B:60:0x01aa, B:62:0x01b6, B:64:0x01be, B:65:0x01c0, B:68:0x01c8, B:70:0x01e8, B:72:0x0212, B:73:0x021a, B:79:0x0227, B:81:0x023a, B:83:0x0240, B:85:0x0255, B:87:0x0268, B:88:0x0270, B:91:0x0284, B:84:0x024e, B:80:0x0233, B:92:0x029a, B:93:0x02a2, B:96:0x02aa, B:98:0x02b0, B:100:0x02b6, B:102:0x02cb, B:104:0x02dc, B:105:0x02e4, B:108:0x02f8, B:101:0x02c4, B:61:0x01b2, B:33:0x00e4), top: B:117:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00e4 A[Catch: all -> 0x030e, TryCatch #0 {, blocks: (B:4:0x0005, B:9:0x000c, B:11:0x0059, B:12:0x005b, B:16:0x0063, B:18:0x00a4, B:19:0x00a6, B:21:0x00c8, B:23:0x00cc, B:24:0x00d0, B:26:0x00d6, B:29:0x00dc, B:36:0x00e9, B:38:0x00f7, B:40:0x0109, B:42:0x0127, B:44:0x0130, B:45:0x0133, B:46:0x0138, B:51:0x015a, B:53:0x0164, B:55:0x018a, B:56:0x019b, B:58:0x01a4, B:60:0x01aa, B:62:0x01b6, B:64:0x01be, B:65:0x01c0, B:68:0x01c8, B:70:0x01e8, B:72:0x0212, B:73:0x021a, B:79:0x0227, B:81:0x023a, B:83:0x0240, B:85:0x0255, B:87:0x0268, B:88:0x0270, B:91:0x0284, B:84:0x024e, B:80:0x0233, B:92:0x029a, B:93:0x02a2, B:96:0x02aa, B:98:0x02b0, B:100:0x02b6, B:102:0x02cb, B:104:0x02dc, B:105:0x02e4, B:108:0x02f8, B:101:0x02c4, B:61:0x01b2, B:33:0x00e4), top: B:117:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00f7 A[Catch: all -> 0x030e, TryCatch #0 {, blocks: (B:4:0x0005, B:9:0x000c, B:11:0x0059, B:12:0x005b, B:16:0x0063, B:18:0x00a4, B:19:0x00a6, B:21:0x00c8, B:23:0x00cc, B:24:0x00d0, B:26:0x00d6, B:29:0x00dc, B:36:0x00e9, B:38:0x00f7, B:40:0x0109, B:42:0x0127, B:44:0x0130, B:45:0x0133, B:46:0x0138, B:51:0x015a, B:53:0x0164, B:55:0x018a, B:56:0x019b, B:58:0x01a4, B:60:0x01aa, B:62:0x01b6, B:64:0x01be, B:65:0x01c0, B:68:0x01c8, B:70:0x01e8, B:72:0x0212, B:73:0x021a, B:79:0x0227, B:81:0x023a, B:83:0x0240, B:85:0x0255, B:87:0x0268, B:88:0x0270, B:91:0x0284, B:84:0x024e, B:80:0x0233, B:92:0x029a, B:93:0x02a2, B:96:0x02aa, B:98:0x02b0, B:100:0x02b6, B:102:0x02cb, B:104:0x02dc, B:105:0x02e4, B:108:0x02f8, B:101:0x02c4, B:61:0x01b2, B:33:0x00e4), top: B:117:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0127 A[Catch: all -> 0x030e, TryCatch #0 {, blocks: (B:4:0x0005, B:9:0x000c, B:11:0x0059, B:12:0x005b, B:16:0x0063, B:18:0x00a4, B:19:0x00a6, B:21:0x00c8, B:23:0x00cc, B:24:0x00d0, B:26:0x00d6, B:29:0x00dc, B:36:0x00e9, B:38:0x00f7, B:40:0x0109, B:42:0x0127, B:44:0x0130, B:45:0x0133, B:46:0x0138, B:51:0x015a, B:53:0x0164, B:55:0x018a, B:56:0x019b, B:58:0x01a4, B:60:0x01aa, B:62:0x01b6, B:64:0x01be, B:65:0x01c0, B:68:0x01c8, B:70:0x01e8, B:72:0x0212, B:73:0x021a, B:79:0x0227, B:81:0x023a, B:83:0x0240, B:85:0x0255, B:87:0x0268, B:88:0x0270, B:91:0x0284, B:84:0x024e, B:80:0x0233, B:92:0x029a, B:93:0x02a2, B:96:0x02aa, B:98:0x02b0, B:100:0x02b6, B:102:0x02cb, B:104:0x02dc, B:105:0x02e4, B:108:0x02f8, B:101:0x02c4, B:61:0x01b2, B:33:0x00e4), top: B:117:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0155  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x015a A[Catch: all -> 0x030e, TryCatch #0 {, blocks: (B:4:0x0005, B:9:0x000c, B:11:0x0059, B:12:0x005b, B:16:0x0063, B:18:0x00a4, B:19:0x00a6, B:21:0x00c8, B:23:0x00cc, B:24:0x00d0, B:26:0x00d6, B:29:0x00dc, B:36:0x00e9, B:38:0x00f7, B:40:0x0109, B:42:0x0127, B:44:0x0130, B:45:0x0133, B:46:0x0138, B:51:0x015a, B:53:0x0164, B:55:0x018a, B:56:0x019b, B:58:0x01a4, B:60:0x01aa, B:62:0x01b6, B:64:0x01be, B:65:0x01c0, B:68:0x01c8, B:70:0x01e8, B:72:0x0212, B:73:0x021a, B:79:0x0227, B:81:0x023a, B:83:0x0240, B:85:0x0255, B:87:0x0268, B:88:0x0270, B:91:0x0284, B:84:0x024e, B:80:0x0233, B:92:0x029a, B:93:0x02a2, B:96:0x02aa, B:98:0x02b0, B:100:0x02b6, B:102:0x02cb, B:104:0x02dc, B:105:0x02e4, B:108:0x02f8, B:101:0x02c4, B:61:0x01b2, B:33:0x00e4), top: B:117:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x01b2 A[Catch: all -> 0x030e, TryCatch #0 {, blocks: (B:4:0x0005, B:9:0x000c, B:11:0x0059, B:12:0x005b, B:16:0x0063, B:18:0x00a4, B:19:0x00a6, B:21:0x00c8, B:23:0x00cc, B:24:0x00d0, B:26:0x00d6, B:29:0x00dc, B:36:0x00e9, B:38:0x00f7, B:40:0x0109, B:42:0x0127, B:44:0x0130, B:45:0x0133, B:46:0x0138, B:51:0x015a, B:53:0x0164, B:55:0x018a, B:56:0x019b, B:58:0x01a4, B:60:0x01aa, B:62:0x01b6, B:64:0x01be, B:65:0x01c0, B:68:0x01c8, B:70:0x01e8, B:72:0x0212, B:73:0x021a, B:79:0x0227, B:81:0x023a, B:83:0x0240, B:85:0x0255, B:87:0x0268, B:88:0x0270, B:91:0x0284, B:84:0x024e, B:80:0x0233, B:92:0x029a, B:93:0x02a2, B:96:0x02aa, B:98:0x02b0, B:100:0x02b6, B:102:0x02cb, B:104:0x02dc, B:105:0x02e4, B:108:0x02f8, B:101:0x02c4, B:61:0x01b2, B:33:0x00e4), top: B:117:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x01c4  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x01e8 A[Catch: all -> 0x030e, TryCatch #0 {, blocks: (B:4:0x0005, B:9:0x000c, B:11:0x0059, B:12:0x005b, B:16:0x0063, B:18:0x00a4, B:19:0x00a6, B:21:0x00c8, B:23:0x00cc, B:24:0x00d0, B:26:0x00d6, B:29:0x00dc, B:36:0x00e9, B:38:0x00f7, B:40:0x0109, B:42:0x0127, B:44:0x0130, B:45:0x0133, B:46:0x0138, B:51:0x015a, B:53:0x0164, B:55:0x018a, B:56:0x019b, B:58:0x01a4, B:60:0x01aa, B:62:0x01b6, B:64:0x01be, B:65:0x01c0, B:68:0x01c8, B:70:0x01e8, B:72:0x0212, B:73:0x021a, B:79:0x0227, B:81:0x023a, B:83:0x0240, B:85:0x0255, B:87:0x0268, B:88:0x0270, B:91:0x0284, B:84:0x024e, B:80:0x0233, B:92:0x029a, B:93:0x02a2, B:96:0x02aa, B:98:0x02b0, B:100:0x02b6, B:102:0x02cb, B:104:0x02dc, B:105:0x02e4, B:108:0x02f8, B:101:0x02c4, B:61:0x01b2, B:33:0x00e4), top: B:117:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x020c  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0220  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0227 A[Catch: all -> 0x030e, TryCatch #0 {, blocks: (B:4:0x0005, B:9:0x000c, B:11:0x0059, B:12:0x005b, B:16:0x0063, B:18:0x00a4, B:19:0x00a6, B:21:0x00c8, B:23:0x00cc, B:24:0x00d0, B:26:0x00d6, B:29:0x00dc, B:36:0x00e9, B:38:0x00f7, B:40:0x0109, B:42:0x0127, B:44:0x0130, B:45:0x0133, B:46:0x0138, B:51:0x015a, B:53:0x0164, B:55:0x018a, B:56:0x019b, B:58:0x01a4, B:60:0x01aa, B:62:0x01b6, B:64:0x01be, B:65:0x01c0, B:68:0x01c8, B:70:0x01e8, B:72:0x0212, B:73:0x021a, B:79:0x0227, B:81:0x023a, B:83:0x0240, B:85:0x0255, B:87:0x0268, B:88:0x0270, B:91:0x0284, B:84:0x024e, B:80:0x0233, B:92:0x029a, B:93:0x02a2, B:96:0x02aa, B:98:0x02b0, B:100:0x02b6, B:102:0x02cb, B:104:0x02dc, B:105:0x02e4, B:108:0x02f8, B:101:0x02c4, B:61:0x01b2, B:33:0x00e4), top: B:117:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0233 A[Catch: all -> 0x030e, TryCatch #0 {, blocks: (B:4:0x0005, B:9:0x000c, B:11:0x0059, B:12:0x005b, B:16:0x0063, B:18:0x00a4, B:19:0x00a6, B:21:0x00c8, B:23:0x00cc, B:24:0x00d0, B:26:0x00d6, B:29:0x00dc, B:36:0x00e9, B:38:0x00f7, B:40:0x0109, B:42:0x0127, B:44:0x0130, B:45:0x0133, B:46:0x0138, B:51:0x015a, B:53:0x0164, B:55:0x018a, B:56:0x019b, B:58:0x01a4, B:60:0x01aa, B:62:0x01b6, B:64:0x01be, B:65:0x01c0, B:68:0x01c8, B:70:0x01e8, B:72:0x0212, B:73:0x021a, B:79:0x0227, B:81:0x023a, B:83:0x0240, B:85:0x0255, B:87:0x0268, B:88:0x0270, B:91:0x0284, B:84:0x024e, B:80:0x0233, B:92:0x029a, B:93:0x02a2, B:96:0x02aa, B:98:0x02b0, B:100:0x02b6, B:102:0x02cb, B:104:0x02dc, B:105:0x02e4, B:108:0x02f8, B:101:0x02c4, B:61:0x01b2, B:33:0x00e4), top: B:117:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0240 A[Catch: all -> 0x030e, TryCatch #0 {, blocks: (B:4:0x0005, B:9:0x000c, B:11:0x0059, B:12:0x005b, B:16:0x0063, B:18:0x00a4, B:19:0x00a6, B:21:0x00c8, B:23:0x00cc, B:24:0x00d0, B:26:0x00d6, B:29:0x00dc, B:36:0x00e9, B:38:0x00f7, B:40:0x0109, B:42:0x0127, B:44:0x0130, B:45:0x0133, B:46:0x0138, B:51:0x015a, B:53:0x0164, B:55:0x018a, B:56:0x019b, B:58:0x01a4, B:60:0x01aa, B:62:0x01b6, B:64:0x01be, B:65:0x01c0, B:68:0x01c8, B:70:0x01e8, B:72:0x0212, B:73:0x021a, B:79:0x0227, B:81:0x023a, B:83:0x0240, B:85:0x0255, B:87:0x0268, B:88:0x0270, B:91:0x0284, B:84:0x024e, B:80:0x0233, B:92:0x029a, B:93:0x02a2, B:96:0x02aa, B:98:0x02b0, B:100:0x02b6, B:102:0x02cb, B:104:0x02dc, B:105:0x02e4, B:108:0x02f8, B:101:0x02c4, B:61:0x01b2, B:33:0x00e4), top: B:117:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x024e A[Catch: all -> 0x030e, TryCatch #0 {, blocks: (B:4:0x0005, B:9:0x000c, B:11:0x0059, B:12:0x005b, B:16:0x0063, B:18:0x00a4, B:19:0x00a6, B:21:0x00c8, B:23:0x00cc, B:24:0x00d0, B:26:0x00d6, B:29:0x00dc, B:36:0x00e9, B:38:0x00f7, B:40:0x0109, B:42:0x0127, B:44:0x0130, B:45:0x0133, B:46:0x0138, B:51:0x015a, B:53:0x0164, B:55:0x018a, B:56:0x019b, B:58:0x01a4, B:60:0x01aa, B:62:0x01b6, B:64:0x01be, B:65:0x01c0, B:68:0x01c8, B:70:0x01e8, B:72:0x0212, B:73:0x021a, B:79:0x0227, B:81:0x023a, B:83:0x0240, B:85:0x0255, B:87:0x0268, B:88:0x0270, B:91:0x0284, B:84:0x024e, B:80:0x0233, B:92:0x029a, B:93:0x02a2, B:96:0x02aa, B:98:0x02b0, B:100:0x02b6, B:102:0x02cb, B:104:0x02dc, B:105:0x02e4, B:108:0x02f8, B:101:0x02c4, B:61:0x01b2, B:33:0x00e4), top: B:117:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0268 A[Catch: all -> 0x030e, LOOP:2: B:86:0x0266->B:87:0x0268, LOOP_END, TryCatch #0 {, blocks: (B:4:0x0005, B:9:0x000c, B:11:0x0059, B:12:0x005b, B:16:0x0063, B:18:0x00a4, B:19:0x00a6, B:21:0x00c8, B:23:0x00cc, B:24:0x00d0, B:26:0x00d6, B:29:0x00dc, B:36:0x00e9, B:38:0x00f7, B:40:0x0109, B:42:0x0127, B:44:0x0130, B:45:0x0133, B:46:0x0138, B:51:0x015a, B:53:0x0164, B:55:0x018a, B:56:0x019b, B:58:0x01a4, B:60:0x01aa, B:62:0x01b6, B:64:0x01be, B:65:0x01c0, B:68:0x01c8, B:70:0x01e8, B:72:0x0212, B:73:0x021a, B:79:0x0227, B:81:0x023a, B:83:0x0240, B:85:0x0255, B:87:0x0268, B:88:0x0270, B:91:0x0284, B:84:0x024e, B:80:0x0233, B:92:0x029a, B:93:0x02a2, B:96:0x02aa, B:98:0x02b0, B:100:0x02b6, B:102:0x02cb, B:104:0x02dc, B:105:0x02e4, B:108:0x02f8, B:101:0x02c4, B:61:0x01b2, B:33:0x00e4), top: B:117:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0283  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x02a8 A[ADDED_TO_REGION] */
    @Override // com.kugou.framework.lyric.LyricView
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized void showLyric(android.graphics.Canvas r35) {
        /*
            Method dump skipped, instruction units count: 787
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kugou.framework.lyric.LockScreenLyricView.showLyric(android.graphics.Canvas):void");
    }

    public LockScreenLyricView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LockScreenLyricView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.maxRows = 3;
        this.widthPercent = 0.75f;
        this.timePercent = 0.3f;
        this.needDrawTop = true;
        this.needDrawBottom = true;
        this.fullScreen = true;
        this.mFinalRefresh = false;
        this.autoChangeSize = true;
        this.autoGrow = true;
        this.AutoFade = true;
    }
}
