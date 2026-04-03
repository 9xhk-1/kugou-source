package com.kugou.framework.lyric;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import com.kugou.framework.lyric.LyricView;
import com.kugou.uilib.widget.textview.span.TopicHighlightHelper;

/* JADX INFO: loaded from: classes2.dex */
public class FullScreenLyricView extends LyricView {
    public static final int ALIGN_MODE_CENTER = 2;
    public static final int ALIGN_MODE_LEFT = 1;
    public static final int ALIGN_MODE_RIGHT = 3;
    public static final int MODE_EVEN = 2;
    public static final int MODE_ODD = 1;
    public int alignMode;
    private boolean autoChangeSize;
    private boolean autoGrow;
    private int b;
    private float firstMoveTime;
    private boolean fullScreen;
    private int l;
    public int lineMode;
    private int lyricRowNum;
    public boolean mClicked;
    public int mClickedRowIndex;
    private boolean mFinalRefresh;
    public boolean mHasCallBack;
    public LyricView.LongClickCallBack mLongClickCallBack;
    public float mYCoordinate;
    public int maxRows;
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
    private int windowWidth;

    public FullScreenLyricView(Context context) {
        this(context, null);
    }

    private int countRowNum(float f2, float f3, float f4) {
        return (int) Math.floor((f2 + f4) / (f3 + f4));
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
                if (f4 - f5 < f8) {
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

    public LyricView.LongClickCallBack getLongClickCallBack() {
        return this.mLongClickCallBack;
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
        this.windowWidth = ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay().getWidth();
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

    public void setAlignMode(int i2) {
        this.alignMode = i2;
    }

    public void setAutoChangeSize(boolean z) {
        this.autoChangeSize = z;
    }

    public void setAutoGrow(boolean z) {
        this.autoGrow = z;
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

    public void setLineMode(int i2) {
        this.lineMode = i2;
    }

    public void setLongClickCallBack(LyricView.LongClickCallBack longClickCallBack) {
        this.mLongClickCallBack = longClickCallBack;
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
        int width = getWidth();
        int height = getHeight();
        float fMeasureText = this.pen.measureText(this.defaultMsg);
        int i2 = this.alignMode;
        canvas.drawText(this.defaultMsg, i2 == 1 ? 0.0f : i2 == 2 ? (width - fMeasureText) / 2.0f : width - fMeasureText, ((height + this.wordHeight) / 2.0f) - this.leading, this.pen);
    }

    /* JADX WARN: Removed duplicated region for block: B:118:0x032c A[Catch: all -> 0x0710, TryCatch #0 {, blocks: (B:4:0x0005, B:9:0x000c, B:11:0x0059, B:12:0x005b, B:16:0x0062, B:18:0x00b2, B:20:0x00b6, B:21:0x00b8, B:23:0x00da, B:25:0x00de, B:26:0x00e2, B:28:0x00e8, B:30:0x00ed, B:37:0x00fa, B:39:0x0108, B:40:0x0111, B:42:0x012f, B:44:0x013c, B:46:0x0141, B:48:0x014b, B:49:0x0156, B:51:0x0173, B:60:0x0189, B:62:0x0193, B:64:0x01a5, B:66:0x01a8, B:68:0x01bf, B:70:0x01c6, B:71:0x01d7, B:73:0x01e0, B:75:0x01e6, B:77:0x01f2, B:79:0x01fa, B:80:0x01fc, B:83:0x0209, B:85:0x0211, B:87:0x0218, B:93:0x0241, B:95:0x0257, B:97:0x0288, B:101:0x02a0, B:103:0x02b2, B:105:0x02d2, B:106:0x02da, B:108:0x02e9, B:115:0x02fb, B:114:0x02f9, B:102:0x02ab, B:116:0x0320, B:118:0x032c, B:120:0x0332, B:122:0x0350, B:123:0x0358, B:125:0x0367, B:132:0x0379, B:131:0x0377, B:260:0x06f9, B:262:0x06fd, B:264:0x0701, B:266:0x0705, B:88:0x021f, B:91:0x022c, B:92:0x0236, B:76:0x01ee, B:57:0x0183, B:34:0x00f5, B:133:0x039d, B:135:0x03af, B:136:0x03b1, B:138:0x03d5, B:140:0x03db, B:141:0x03de, B:143:0x03e6, B:146:0x03ee, B:153:0x03fb, B:155:0x0409, B:157:0x0417, B:159:0x0435, B:161:0x043e, B:163:0x0443, B:165:0x044d, B:166:0x0454, B:168:0x046d, B:177:0x0483, B:179:0x048d, B:181:0x04b4, B:183:0x04ca, B:185:0x04d3, B:187:0x04d9, B:189:0x04e5, B:191:0x04ed, B:192:0x04ef, B:195:0x0500, B:197:0x0508, B:199:0x050f, B:205:0x0539, B:207:0x054d, B:209:0x0574, B:211:0x0595, B:213:0x05a8, B:214:0x05b0, B:216:0x05bf, B:223:0x05d1, B:222:0x05cf, B:228:0x05f4, B:230:0x0607, B:232:0x0627, B:233:0x062f, B:235:0x063e, B:242:0x0650, B:241:0x064e, B:229:0x0600, B:243:0x0675, B:245:0x0681, B:247:0x0689, B:249:0x06a7, B:250:0x06af, B:252:0x06be, B:259:0x06d3, B:258:0x06d1, B:200:0x0516, B:203:0x0524, B:204:0x052e, B:188:0x04e1, B:174:0x047d, B:150:0x03f6), top: B:274:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:164:0x044b  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x0483 A[Catch: all -> 0x0710, TryCatch #0 {, blocks: (B:4:0x0005, B:9:0x000c, B:11:0x0059, B:12:0x005b, B:16:0x0062, B:18:0x00b2, B:20:0x00b6, B:21:0x00b8, B:23:0x00da, B:25:0x00de, B:26:0x00e2, B:28:0x00e8, B:30:0x00ed, B:37:0x00fa, B:39:0x0108, B:40:0x0111, B:42:0x012f, B:44:0x013c, B:46:0x0141, B:48:0x014b, B:49:0x0156, B:51:0x0173, B:60:0x0189, B:62:0x0193, B:64:0x01a5, B:66:0x01a8, B:68:0x01bf, B:70:0x01c6, B:71:0x01d7, B:73:0x01e0, B:75:0x01e6, B:77:0x01f2, B:79:0x01fa, B:80:0x01fc, B:83:0x0209, B:85:0x0211, B:87:0x0218, B:93:0x0241, B:95:0x0257, B:97:0x0288, B:101:0x02a0, B:103:0x02b2, B:105:0x02d2, B:106:0x02da, B:108:0x02e9, B:115:0x02fb, B:114:0x02f9, B:102:0x02ab, B:116:0x0320, B:118:0x032c, B:120:0x0332, B:122:0x0350, B:123:0x0358, B:125:0x0367, B:132:0x0379, B:131:0x0377, B:260:0x06f9, B:262:0x06fd, B:264:0x0701, B:266:0x0705, B:88:0x021f, B:91:0x022c, B:92:0x0236, B:76:0x01ee, B:57:0x0183, B:34:0x00f5, B:133:0x039d, B:135:0x03af, B:136:0x03b1, B:138:0x03d5, B:140:0x03db, B:141:0x03de, B:143:0x03e6, B:146:0x03ee, B:153:0x03fb, B:155:0x0409, B:157:0x0417, B:159:0x0435, B:161:0x043e, B:163:0x0443, B:165:0x044d, B:166:0x0454, B:168:0x046d, B:177:0x0483, B:179:0x048d, B:181:0x04b4, B:183:0x04ca, B:185:0x04d3, B:187:0x04d9, B:189:0x04e5, B:191:0x04ed, B:192:0x04ef, B:195:0x0500, B:197:0x0508, B:199:0x050f, B:205:0x0539, B:207:0x054d, B:209:0x0574, B:211:0x0595, B:213:0x05a8, B:214:0x05b0, B:216:0x05bf, B:223:0x05d1, B:222:0x05cf, B:228:0x05f4, B:230:0x0607, B:232:0x0627, B:233:0x062f, B:235:0x063e, B:242:0x0650, B:241:0x064e, B:229:0x0600, B:243:0x0675, B:245:0x0681, B:247:0x0689, B:249:0x06a7, B:250:0x06af, B:252:0x06be, B:259:0x06d3, B:258:0x06d1, B:200:0x0516, B:203:0x0524, B:204:0x052e, B:188:0x04e1, B:174:0x047d, B:150:0x03f6), top: B:274:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:188:0x04e1 A[Catch: all -> 0x0710, TryCatch #0 {, blocks: (B:4:0x0005, B:9:0x000c, B:11:0x0059, B:12:0x005b, B:16:0x0062, B:18:0x00b2, B:20:0x00b6, B:21:0x00b8, B:23:0x00da, B:25:0x00de, B:26:0x00e2, B:28:0x00e8, B:30:0x00ed, B:37:0x00fa, B:39:0x0108, B:40:0x0111, B:42:0x012f, B:44:0x013c, B:46:0x0141, B:48:0x014b, B:49:0x0156, B:51:0x0173, B:60:0x0189, B:62:0x0193, B:64:0x01a5, B:66:0x01a8, B:68:0x01bf, B:70:0x01c6, B:71:0x01d7, B:73:0x01e0, B:75:0x01e6, B:77:0x01f2, B:79:0x01fa, B:80:0x01fc, B:83:0x0209, B:85:0x0211, B:87:0x0218, B:93:0x0241, B:95:0x0257, B:97:0x0288, B:101:0x02a0, B:103:0x02b2, B:105:0x02d2, B:106:0x02da, B:108:0x02e9, B:115:0x02fb, B:114:0x02f9, B:102:0x02ab, B:116:0x0320, B:118:0x032c, B:120:0x0332, B:122:0x0350, B:123:0x0358, B:125:0x0367, B:132:0x0379, B:131:0x0377, B:260:0x06f9, B:262:0x06fd, B:264:0x0701, B:266:0x0705, B:88:0x021f, B:91:0x022c, B:92:0x0236, B:76:0x01ee, B:57:0x0183, B:34:0x00f5, B:133:0x039d, B:135:0x03af, B:136:0x03b1, B:138:0x03d5, B:140:0x03db, B:141:0x03de, B:143:0x03e6, B:146:0x03ee, B:153:0x03fb, B:155:0x0409, B:157:0x0417, B:159:0x0435, B:161:0x043e, B:163:0x0443, B:165:0x044d, B:166:0x0454, B:168:0x046d, B:177:0x0483, B:179:0x048d, B:181:0x04b4, B:183:0x04ca, B:185:0x04d3, B:187:0x04d9, B:189:0x04e5, B:191:0x04ed, B:192:0x04ef, B:195:0x0500, B:197:0x0508, B:199:0x050f, B:205:0x0539, B:207:0x054d, B:209:0x0574, B:211:0x0595, B:213:0x05a8, B:214:0x05b0, B:216:0x05bf, B:223:0x05d1, B:222:0x05cf, B:228:0x05f4, B:230:0x0607, B:232:0x0627, B:233:0x062f, B:235:0x063e, B:242:0x0650, B:241:0x064e, B:229:0x0600, B:243:0x0675, B:245:0x0681, B:247:0x0689, B:249:0x06a7, B:250:0x06af, B:252:0x06be, B:259:0x06d3, B:258:0x06d1, B:200:0x0516, B:203:0x0524, B:204:0x052e, B:188:0x04e1, B:174:0x047d, B:150:0x03f6), top: B:274:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:194:0x04f9  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x0508 A[Catch: all -> 0x0710, TryCatch #0 {, blocks: (B:4:0x0005, B:9:0x000c, B:11:0x0059, B:12:0x005b, B:16:0x0062, B:18:0x00b2, B:20:0x00b6, B:21:0x00b8, B:23:0x00da, B:25:0x00de, B:26:0x00e2, B:28:0x00e8, B:30:0x00ed, B:37:0x00fa, B:39:0x0108, B:40:0x0111, B:42:0x012f, B:44:0x013c, B:46:0x0141, B:48:0x014b, B:49:0x0156, B:51:0x0173, B:60:0x0189, B:62:0x0193, B:64:0x01a5, B:66:0x01a8, B:68:0x01bf, B:70:0x01c6, B:71:0x01d7, B:73:0x01e0, B:75:0x01e6, B:77:0x01f2, B:79:0x01fa, B:80:0x01fc, B:83:0x0209, B:85:0x0211, B:87:0x0218, B:93:0x0241, B:95:0x0257, B:97:0x0288, B:101:0x02a0, B:103:0x02b2, B:105:0x02d2, B:106:0x02da, B:108:0x02e9, B:115:0x02fb, B:114:0x02f9, B:102:0x02ab, B:116:0x0320, B:118:0x032c, B:120:0x0332, B:122:0x0350, B:123:0x0358, B:125:0x0367, B:132:0x0379, B:131:0x0377, B:260:0x06f9, B:262:0x06fd, B:264:0x0701, B:266:0x0705, B:88:0x021f, B:91:0x022c, B:92:0x0236, B:76:0x01ee, B:57:0x0183, B:34:0x00f5, B:133:0x039d, B:135:0x03af, B:136:0x03b1, B:138:0x03d5, B:140:0x03db, B:141:0x03de, B:143:0x03e6, B:146:0x03ee, B:153:0x03fb, B:155:0x0409, B:157:0x0417, B:159:0x0435, B:161:0x043e, B:163:0x0443, B:165:0x044d, B:166:0x0454, B:168:0x046d, B:177:0x0483, B:179:0x048d, B:181:0x04b4, B:183:0x04ca, B:185:0x04d3, B:187:0x04d9, B:189:0x04e5, B:191:0x04ed, B:192:0x04ef, B:195:0x0500, B:197:0x0508, B:199:0x050f, B:205:0x0539, B:207:0x054d, B:209:0x0574, B:211:0x0595, B:213:0x05a8, B:214:0x05b0, B:216:0x05bf, B:223:0x05d1, B:222:0x05cf, B:228:0x05f4, B:230:0x0607, B:232:0x0627, B:233:0x062f, B:235:0x063e, B:242:0x0650, B:241:0x064e, B:229:0x0600, B:243:0x0675, B:245:0x0681, B:247:0x0689, B:249:0x06a7, B:250:0x06af, B:252:0x06be, B:259:0x06d3, B:258:0x06d1, B:200:0x0516, B:203:0x0524, B:204:0x052e, B:188:0x04e1, B:174:0x047d, B:150:0x03f6), top: B:274:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:201:0x0521  */
    /* JADX WARN: Removed duplicated region for block: B:207:0x054d A[Catch: all -> 0x0710, TryCatch #0 {, blocks: (B:4:0x0005, B:9:0x000c, B:11:0x0059, B:12:0x005b, B:16:0x0062, B:18:0x00b2, B:20:0x00b6, B:21:0x00b8, B:23:0x00da, B:25:0x00de, B:26:0x00e2, B:28:0x00e8, B:30:0x00ed, B:37:0x00fa, B:39:0x0108, B:40:0x0111, B:42:0x012f, B:44:0x013c, B:46:0x0141, B:48:0x014b, B:49:0x0156, B:51:0x0173, B:60:0x0189, B:62:0x0193, B:64:0x01a5, B:66:0x01a8, B:68:0x01bf, B:70:0x01c6, B:71:0x01d7, B:73:0x01e0, B:75:0x01e6, B:77:0x01f2, B:79:0x01fa, B:80:0x01fc, B:83:0x0209, B:85:0x0211, B:87:0x0218, B:93:0x0241, B:95:0x0257, B:97:0x0288, B:101:0x02a0, B:103:0x02b2, B:105:0x02d2, B:106:0x02da, B:108:0x02e9, B:115:0x02fb, B:114:0x02f9, B:102:0x02ab, B:116:0x0320, B:118:0x032c, B:120:0x0332, B:122:0x0350, B:123:0x0358, B:125:0x0367, B:132:0x0379, B:131:0x0377, B:260:0x06f9, B:262:0x06fd, B:264:0x0701, B:266:0x0705, B:88:0x021f, B:91:0x022c, B:92:0x0236, B:76:0x01ee, B:57:0x0183, B:34:0x00f5, B:133:0x039d, B:135:0x03af, B:136:0x03b1, B:138:0x03d5, B:140:0x03db, B:141:0x03de, B:143:0x03e6, B:146:0x03ee, B:153:0x03fb, B:155:0x0409, B:157:0x0417, B:159:0x0435, B:161:0x043e, B:163:0x0443, B:165:0x044d, B:166:0x0454, B:168:0x046d, B:177:0x0483, B:179:0x048d, B:181:0x04b4, B:183:0x04ca, B:185:0x04d3, B:187:0x04d9, B:189:0x04e5, B:191:0x04ed, B:192:0x04ef, B:195:0x0500, B:197:0x0508, B:199:0x050f, B:205:0x0539, B:207:0x054d, B:209:0x0574, B:211:0x0595, B:213:0x05a8, B:214:0x05b0, B:216:0x05bf, B:223:0x05d1, B:222:0x05cf, B:228:0x05f4, B:230:0x0607, B:232:0x0627, B:233:0x062f, B:235:0x063e, B:242:0x0650, B:241:0x064e, B:229:0x0600, B:243:0x0675, B:245:0x0681, B:247:0x0689, B:249:0x06a7, B:250:0x06af, B:252:0x06be, B:259:0x06d3, B:258:0x06d1, B:200:0x0516, B:203:0x0524, B:204:0x052e, B:188:0x04e1, B:174:0x047d, B:150:0x03f6), top: B:274:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:208:0x0571  */
    /* JADX WARN: Removed duplicated region for block: B:211:0x0595 A[Catch: all -> 0x0710, TryCatch #0 {, blocks: (B:4:0x0005, B:9:0x000c, B:11:0x0059, B:12:0x005b, B:16:0x0062, B:18:0x00b2, B:20:0x00b6, B:21:0x00b8, B:23:0x00da, B:25:0x00de, B:26:0x00e2, B:28:0x00e8, B:30:0x00ed, B:37:0x00fa, B:39:0x0108, B:40:0x0111, B:42:0x012f, B:44:0x013c, B:46:0x0141, B:48:0x014b, B:49:0x0156, B:51:0x0173, B:60:0x0189, B:62:0x0193, B:64:0x01a5, B:66:0x01a8, B:68:0x01bf, B:70:0x01c6, B:71:0x01d7, B:73:0x01e0, B:75:0x01e6, B:77:0x01f2, B:79:0x01fa, B:80:0x01fc, B:83:0x0209, B:85:0x0211, B:87:0x0218, B:93:0x0241, B:95:0x0257, B:97:0x0288, B:101:0x02a0, B:103:0x02b2, B:105:0x02d2, B:106:0x02da, B:108:0x02e9, B:115:0x02fb, B:114:0x02f9, B:102:0x02ab, B:116:0x0320, B:118:0x032c, B:120:0x0332, B:122:0x0350, B:123:0x0358, B:125:0x0367, B:132:0x0379, B:131:0x0377, B:260:0x06f9, B:262:0x06fd, B:264:0x0701, B:266:0x0705, B:88:0x021f, B:91:0x022c, B:92:0x0236, B:76:0x01ee, B:57:0x0183, B:34:0x00f5, B:133:0x039d, B:135:0x03af, B:136:0x03b1, B:138:0x03d5, B:140:0x03db, B:141:0x03de, B:143:0x03e6, B:146:0x03ee, B:153:0x03fb, B:155:0x0409, B:157:0x0417, B:159:0x0435, B:161:0x043e, B:163:0x0443, B:165:0x044d, B:166:0x0454, B:168:0x046d, B:177:0x0483, B:179:0x048d, B:181:0x04b4, B:183:0x04ca, B:185:0x04d3, B:187:0x04d9, B:189:0x04e5, B:191:0x04ed, B:192:0x04ef, B:195:0x0500, B:197:0x0508, B:199:0x050f, B:205:0x0539, B:207:0x054d, B:209:0x0574, B:211:0x0595, B:213:0x05a8, B:214:0x05b0, B:216:0x05bf, B:223:0x05d1, B:222:0x05cf, B:228:0x05f4, B:230:0x0607, B:232:0x0627, B:233:0x062f, B:235:0x063e, B:242:0x0650, B:241:0x064e, B:229:0x0600, B:243:0x0675, B:245:0x0681, B:247:0x0689, B:249:0x06a7, B:250:0x06af, B:252:0x06be, B:259:0x06d3, B:258:0x06d1, B:200:0x0516, B:203:0x0524, B:204:0x052e, B:188:0x04e1, B:174:0x047d, B:150:0x03f6), top: B:274:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:226:0x05f1  */
    /* JADX WARN: Removed duplicated region for block: B:245:0x0681 A[Catch: all -> 0x0710, TryCatch #0 {, blocks: (B:4:0x0005, B:9:0x000c, B:11:0x0059, B:12:0x005b, B:16:0x0062, B:18:0x00b2, B:20:0x00b6, B:21:0x00b8, B:23:0x00da, B:25:0x00de, B:26:0x00e2, B:28:0x00e8, B:30:0x00ed, B:37:0x00fa, B:39:0x0108, B:40:0x0111, B:42:0x012f, B:44:0x013c, B:46:0x0141, B:48:0x014b, B:49:0x0156, B:51:0x0173, B:60:0x0189, B:62:0x0193, B:64:0x01a5, B:66:0x01a8, B:68:0x01bf, B:70:0x01c6, B:71:0x01d7, B:73:0x01e0, B:75:0x01e6, B:77:0x01f2, B:79:0x01fa, B:80:0x01fc, B:83:0x0209, B:85:0x0211, B:87:0x0218, B:93:0x0241, B:95:0x0257, B:97:0x0288, B:101:0x02a0, B:103:0x02b2, B:105:0x02d2, B:106:0x02da, B:108:0x02e9, B:115:0x02fb, B:114:0x02f9, B:102:0x02ab, B:116:0x0320, B:118:0x032c, B:120:0x0332, B:122:0x0350, B:123:0x0358, B:125:0x0367, B:132:0x0379, B:131:0x0377, B:260:0x06f9, B:262:0x06fd, B:264:0x0701, B:266:0x0705, B:88:0x021f, B:91:0x022c, B:92:0x0236, B:76:0x01ee, B:57:0x0183, B:34:0x00f5, B:133:0x039d, B:135:0x03af, B:136:0x03b1, B:138:0x03d5, B:140:0x03db, B:141:0x03de, B:143:0x03e6, B:146:0x03ee, B:153:0x03fb, B:155:0x0409, B:157:0x0417, B:159:0x0435, B:161:0x043e, B:163:0x0443, B:165:0x044d, B:166:0x0454, B:168:0x046d, B:177:0x0483, B:179:0x048d, B:181:0x04b4, B:183:0x04ca, B:185:0x04d3, B:187:0x04d9, B:189:0x04e5, B:191:0x04ed, B:192:0x04ef, B:195:0x0500, B:197:0x0508, B:199:0x050f, B:205:0x0539, B:207:0x054d, B:209:0x0574, B:211:0x0595, B:213:0x05a8, B:214:0x05b0, B:216:0x05bf, B:223:0x05d1, B:222:0x05cf, B:228:0x05f4, B:230:0x0607, B:232:0x0627, B:233:0x062f, B:235:0x063e, B:242:0x0650, B:241:0x064e, B:229:0x0600, B:243:0x0675, B:245:0x0681, B:247:0x0689, B:249:0x06a7, B:250:0x06af, B:252:0x06be, B:259:0x06d3, B:258:0x06d1, B:200:0x0516, B:203:0x0524, B:204:0x052e, B:188:0x04e1, B:174:0x047d, B:150:0x03f6), top: B:274:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0149  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0189 A[Catch: all -> 0x0710, TryCatch #0 {, blocks: (B:4:0x0005, B:9:0x000c, B:11:0x0059, B:12:0x005b, B:16:0x0062, B:18:0x00b2, B:20:0x00b6, B:21:0x00b8, B:23:0x00da, B:25:0x00de, B:26:0x00e2, B:28:0x00e8, B:30:0x00ed, B:37:0x00fa, B:39:0x0108, B:40:0x0111, B:42:0x012f, B:44:0x013c, B:46:0x0141, B:48:0x014b, B:49:0x0156, B:51:0x0173, B:60:0x0189, B:62:0x0193, B:64:0x01a5, B:66:0x01a8, B:68:0x01bf, B:70:0x01c6, B:71:0x01d7, B:73:0x01e0, B:75:0x01e6, B:77:0x01f2, B:79:0x01fa, B:80:0x01fc, B:83:0x0209, B:85:0x0211, B:87:0x0218, B:93:0x0241, B:95:0x0257, B:97:0x0288, B:101:0x02a0, B:103:0x02b2, B:105:0x02d2, B:106:0x02da, B:108:0x02e9, B:115:0x02fb, B:114:0x02f9, B:102:0x02ab, B:116:0x0320, B:118:0x032c, B:120:0x0332, B:122:0x0350, B:123:0x0358, B:125:0x0367, B:132:0x0379, B:131:0x0377, B:260:0x06f9, B:262:0x06fd, B:264:0x0701, B:266:0x0705, B:88:0x021f, B:91:0x022c, B:92:0x0236, B:76:0x01ee, B:57:0x0183, B:34:0x00f5, B:133:0x039d, B:135:0x03af, B:136:0x03b1, B:138:0x03d5, B:140:0x03db, B:141:0x03de, B:143:0x03e6, B:146:0x03ee, B:153:0x03fb, B:155:0x0409, B:157:0x0417, B:159:0x0435, B:161:0x043e, B:163:0x0443, B:165:0x044d, B:166:0x0454, B:168:0x046d, B:177:0x0483, B:179:0x048d, B:181:0x04b4, B:183:0x04ca, B:185:0x04d3, B:187:0x04d9, B:189:0x04e5, B:191:0x04ed, B:192:0x04ef, B:195:0x0500, B:197:0x0508, B:199:0x050f, B:205:0x0539, B:207:0x054d, B:209:0x0574, B:211:0x0595, B:213:0x05a8, B:214:0x05b0, B:216:0x05bf, B:223:0x05d1, B:222:0x05cf, B:228:0x05f4, B:230:0x0607, B:232:0x0627, B:233:0x062f, B:235:0x063e, B:242:0x0650, B:241:0x064e, B:229:0x0600, B:243:0x0675, B:245:0x0681, B:247:0x0689, B:249:0x06a7, B:250:0x06af, B:252:0x06be, B:259:0x06d3, B:258:0x06d1, B:200:0x0516, B:203:0x0524, B:204:0x052e, B:188:0x04e1, B:174:0x047d, B:150:0x03f6), top: B:274:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x01ee A[Catch: all -> 0x0710, TryCatch #0 {, blocks: (B:4:0x0005, B:9:0x000c, B:11:0x0059, B:12:0x005b, B:16:0x0062, B:18:0x00b2, B:20:0x00b6, B:21:0x00b8, B:23:0x00da, B:25:0x00de, B:26:0x00e2, B:28:0x00e8, B:30:0x00ed, B:37:0x00fa, B:39:0x0108, B:40:0x0111, B:42:0x012f, B:44:0x013c, B:46:0x0141, B:48:0x014b, B:49:0x0156, B:51:0x0173, B:60:0x0189, B:62:0x0193, B:64:0x01a5, B:66:0x01a8, B:68:0x01bf, B:70:0x01c6, B:71:0x01d7, B:73:0x01e0, B:75:0x01e6, B:77:0x01f2, B:79:0x01fa, B:80:0x01fc, B:83:0x0209, B:85:0x0211, B:87:0x0218, B:93:0x0241, B:95:0x0257, B:97:0x0288, B:101:0x02a0, B:103:0x02b2, B:105:0x02d2, B:106:0x02da, B:108:0x02e9, B:115:0x02fb, B:114:0x02f9, B:102:0x02ab, B:116:0x0320, B:118:0x032c, B:120:0x0332, B:122:0x0350, B:123:0x0358, B:125:0x0367, B:132:0x0379, B:131:0x0377, B:260:0x06f9, B:262:0x06fd, B:264:0x0701, B:266:0x0705, B:88:0x021f, B:91:0x022c, B:92:0x0236, B:76:0x01ee, B:57:0x0183, B:34:0x00f5, B:133:0x039d, B:135:0x03af, B:136:0x03b1, B:138:0x03d5, B:140:0x03db, B:141:0x03de, B:143:0x03e6, B:146:0x03ee, B:153:0x03fb, B:155:0x0409, B:157:0x0417, B:159:0x0435, B:161:0x043e, B:163:0x0443, B:165:0x044d, B:166:0x0454, B:168:0x046d, B:177:0x0483, B:179:0x048d, B:181:0x04b4, B:183:0x04ca, B:185:0x04d3, B:187:0x04d9, B:189:0x04e5, B:191:0x04ed, B:192:0x04ef, B:195:0x0500, B:197:0x0508, B:199:0x050f, B:205:0x0539, B:207:0x054d, B:209:0x0574, B:211:0x0595, B:213:0x05a8, B:214:0x05b0, B:216:0x05bf, B:223:0x05d1, B:222:0x05cf, B:228:0x05f4, B:230:0x0607, B:232:0x0627, B:233:0x062f, B:235:0x063e, B:242:0x0650, B:241:0x064e, B:229:0x0600, B:243:0x0675, B:245:0x0681, B:247:0x0689, B:249:0x06a7, B:250:0x06af, B:252:0x06be, B:259:0x06d3, B:258:0x06d1, B:200:0x0516, B:203:0x0524, B:204:0x052e, B:188:0x04e1, B:174:0x047d, B:150:0x03f6), top: B:274:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0204  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0211 A[Catch: all -> 0x0710, TryCatch #0 {, blocks: (B:4:0x0005, B:9:0x000c, B:11:0x0059, B:12:0x005b, B:16:0x0062, B:18:0x00b2, B:20:0x00b6, B:21:0x00b8, B:23:0x00da, B:25:0x00de, B:26:0x00e2, B:28:0x00e8, B:30:0x00ed, B:37:0x00fa, B:39:0x0108, B:40:0x0111, B:42:0x012f, B:44:0x013c, B:46:0x0141, B:48:0x014b, B:49:0x0156, B:51:0x0173, B:60:0x0189, B:62:0x0193, B:64:0x01a5, B:66:0x01a8, B:68:0x01bf, B:70:0x01c6, B:71:0x01d7, B:73:0x01e0, B:75:0x01e6, B:77:0x01f2, B:79:0x01fa, B:80:0x01fc, B:83:0x0209, B:85:0x0211, B:87:0x0218, B:93:0x0241, B:95:0x0257, B:97:0x0288, B:101:0x02a0, B:103:0x02b2, B:105:0x02d2, B:106:0x02da, B:108:0x02e9, B:115:0x02fb, B:114:0x02f9, B:102:0x02ab, B:116:0x0320, B:118:0x032c, B:120:0x0332, B:122:0x0350, B:123:0x0358, B:125:0x0367, B:132:0x0379, B:131:0x0377, B:260:0x06f9, B:262:0x06fd, B:264:0x0701, B:266:0x0705, B:88:0x021f, B:91:0x022c, B:92:0x0236, B:76:0x01ee, B:57:0x0183, B:34:0x00f5, B:133:0x039d, B:135:0x03af, B:136:0x03b1, B:138:0x03d5, B:140:0x03db, B:141:0x03de, B:143:0x03e6, B:146:0x03ee, B:153:0x03fb, B:155:0x0409, B:157:0x0417, B:159:0x0435, B:161:0x043e, B:163:0x0443, B:165:0x044d, B:166:0x0454, B:168:0x046d, B:177:0x0483, B:179:0x048d, B:181:0x04b4, B:183:0x04ca, B:185:0x04d3, B:187:0x04d9, B:189:0x04e5, B:191:0x04ed, B:192:0x04ef, B:195:0x0500, B:197:0x0508, B:199:0x050f, B:205:0x0539, B:207:0x054d, B:209:0x0574, B:211:0x0595, B:213:0x05a8, B:214:0x05b0, B:216:0x05bf, B:223:0x05d1, B:222:0x05cf, B:228:0x05f4, B:230:0x0607, B:232:0x0627, B:233:0x062f, B:235:0x063e, B:242:0x0650, B:241:0x064e, B:229:0x0600, B:243:0x0675, B:245:0x0681, B:247:0x0689, B:249:0x06a7, B:250:0x06af, B:252:0x06be, B:259:0x06d3, B:258:0x06d1, B:200:0x0516, B:203:0x0524, B:204:0x052e, B:188:0x04e1, B:174:0x047d, B:150:0x03f6), top: B:274:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0229  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0257 A[Catch: all -> 0x0710, TryCatch #0 {, blocks: (B:4:0x0005, B:9:0x000c, B:11:0x0059, B:12:0x005b, B:16:0x0062, B:18:0x00b2, B:20:0x00b6, B:21:0x00b8, B:23:0x00da, B:25:0x00de, B:26:0x00e2, B:28:0x00e8, B:30:0x00ed, B:37:0x00fa, B:39:0x0108, B:40:0x0111, B:42:0x012f, B:44:0x013c, B:46:0x0141, B:48:0x014b, B:49:0x0156, B:51:0x0173, B:60:0x0189, B:62:0x0193, B:64:0x01a5, B:66:0x01a8, B:68:0x01bf, B:70:0x01c6, B:71:0x01d7, B:73:0x01e0, B:75:0x01e6, B:77:0x01f2, B:79:0x01fa, B:80:0x01fc, B:83:0x0209, B:85:0x0211, B:87:0x0218, B:93:0x0241, B:95:0x0257, B:97:0x0288, B:101:0x02a0, B:103:0x02b2, B:105:0x02d2, B:106:0x02da, B:108:0x02e9, B:115:0x02fb, B:114:0x02f9, B:102:0x02ab, B:116:0x0320, B:118:0x032c, B:120:0x0332, B:122:0x0350, B:123:0x0358, B:125:0x0367, B:132:0x0379, B:131:0x0377, B:260:0x06f9, B:262:0x06fd, B:264:0x0701, B:266:0x0705, B:88:0x021f, B:91:0x022c, B:92:0x0236, B:76:0x01ee, B:57:0x0183, B:34:0x00f5, B:133:0x039d, B:135:0x03af, B:136:0x03b1, B:138:0x03d5, B:140:0x03db, B:141:0x03de, B:143:0x03e6, B:146:0x03ee, B:153:0x03fb, B:155:0x0409, B:157:0x0417, B:159:0x0435, B:161:0x043e, B:163:0x0443, B:165:0x044d, B:166:0x0454, B:168:0x046d, B:177:0x0483, B:179:0x048d, B:181:0x04b4, B:183:0x04ca, B:185:0x04d3, B:187:0x04d9, B:189:0x04e5, B:191:0x04ed, B:192:0x04ef, B:195:0x0500, B:197:0x0508, B:199:0x050f, B:205:0x0539, B:207:0x054d, B:209:0x0574, B:211:0x0595, B:213:0x05a8, B:214:0x05b0, B:216:0x05bf, B:223:0x05d1, B:222:0x05cf, B:228:0x05f4, B:230:0x0607, B:232:0x0627, B:233:0x062f, B:235:0x063e, B:242:0x0650, B:241:0x064e, B:229:0x0600, B:243:0x0675, B:245:0x0681, B:247:0x0689, B:249:0x06a7, B:250:0x06af, B:252:0x06be, B:259:0x06d3, B:258:0x06d1, B:200:0x0516, B:203:0x0524, B:204:0x052e, B:188:0x04e1, B:174:0x047d, B:150:0x03f6), top: B:274:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0280  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x029d  */
    @Override // com.kugou.framework.lyric.LyricView
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized void showLyric(android.graphics.Canvas r36) {
        /*
            Method dump skipped, instruction units count: 1813
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kugou.framework.lyric.FullScreenLyricView.showLyric(android.graphics.Canvas):void");
    }

    public FullScreenLyricView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private int countRowNum(float f2, float f3, float f4, float f5) {
        return (int) Math.floor((f2 + f4) / (f3 + f4));
    }

    public FullScreenLyricView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.lineMode = 1;
        this.alignMode = 2;
        this.maxRows = 12;
        this.widthPercent = 0.75f;
        this.timePercent = 0.3f;
        this.fullScreen = true;
        this.mFinalRefresh = false;
        this.autoChangeSize = true;
        this.autoGrow = true;
    }
}
