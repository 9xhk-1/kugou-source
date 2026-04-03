package com.kugou.framework.lyricanim;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.opengl.GLES20;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.example.animatedlyrics.AnimatedLyricsGLProcessor;
import com.example.animatedlyrics.GLTextureView;
import com.example.animatedlyrics.config.BodyMovinComposition;
import com.example.animatedlyrics.config.Layer;
import com.example.animatedlyrics.config.OpaqueValue;
import com.example.animatedlyrics.config.PathValue;
import com.example.animatedlyrics.config.ScaleValue;
import com.example.animatedlyrics.core.AnimationParam;
import com.example.animatedlyrics.core.LyricEffectParam;
import com.example.animatedlyrics.core.LyricsTextProgram;
import com.kugou.framework.lyric.ILyricView;
import com.kugou.framework.lyric.LyricConstent;
import com.kugou.framework.lyric.LyricData;
import com.kugou.framework.lyric.debug.LyricDebug;
import com.kugou.framework.lyric2.ISurLyricSync;
import com.kugou.framework.lyric4.AttachInfo;
import com.kugou.framework.lyric4.BaseLyricView;
import com.kugou.framework.lyric4.FixLineLyricView;
import com.kugou.framework.lyric4.utils.Utils;
import com.xtc.shareapi.share.shareobject.ShareCloudFileResource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import org.apache.http.HttpStatus;

/* JADX INFO: loaded from: classes2.dex */
public class DuplicateLineLyricView extends FrameLayout implements ILyricView, ISurLyricSync, GLTextureView.Renderer, IBounceView {
    private static final String TAG = "DuplicateLineLyricView";
    private int currentInsideLine;
    private int currentLine;
    private long currentPlayTime;
    private int currentWordIndex;
    private int currentWordPercentage;
    private float fadeOutDuration;
    private int lastInsideLine;
    private int lastLine;
    private int lastWordIndex;
    private boolean loadBounceResFlag;
    private boolean mAdjustSpecialTypeface;
    private List<Bitmap> mAnimBitmaps;
    private int mAnimPixelSize;
    private float mAnimSize;
    private BodyMovinComposition mBounceTextFirstMovin;
    private BodyMovinComposition mBounceTextMovin;
    private float mEndOfLineXTransPercent;
    private int mEndOfLineXTranslate;
    private int mExitJumpTopPositionAbove;
    private float mExitJumpTopPositionAbovePercent;
    private BodyMovinComposition mFadeOutMovin;
    private String[] mFirstLineWords;
    private LyricData mLyricData;
    private AnimatedLyricsGLProcessor mLyricGLProcessor;
    private Paint mLyricPaint;
    private List<LyricRecord> mLyricRecordQueue;
    private GLTextureView mLyricView;
    private int mLyricViewClickCount;
    public BaseLyricView.OnLyricViewClickListener mLyricViewClickListener;
    private int mLyricViewClickTimeOut;
    public BaseLyricView.OnCellLongClickListener mLyricViewLongClickListener;
    private BodyMovinComposition mNormalFirstMovin;
    private int mNormalJumpTopPositionAbove;
    private float mNormalJumpTopPositionAbovePercent;
    private BodyMovinComposition mNormalMovin;
    private OpenGlLyricViewVisibleListener mOpenGlViewListener;
    private FixLineLyricView mOriginLyricView;
    private List<Bitmap> mParticleBitmaps;
    private long mPreludeTime;
    private int mRecordInterval;
    private String[] mSecondLineWords;
    private boolean mShowBounceAnim;
    private int mTextSize;
    private float mTextSizeRatio;
    private float mTextTopMargin;
    private float normalJumpDuration;
    private float[] positions;
    private String[] words;

    public interface OpenGlLyricViewVisibleListener {
        void onVisibleChanged(boolean z);
    }

    public DuplicateLineLyricView(Context context) {
        this(context, null);
    }

    public static /* synthetic */ int access$908(DuplicateLineLyricView duplicateLineLyricView) {
        int i2 = duplicateLineLyricView.mLyricViewClickCount;
        duplicateLineLyricView.mLyricViewClickCount = i2 + 1;
        return i2;
    }

    private void calculatePercentage(long j, String[] strArr, long[] jArr, long[] jArr2) {
        int length = strArr.length;
        int i2 = this.currentWordIndex;
        int i3 = length - 1;
        if (i2 < i3) {
            long j2 = jArr[i2 + 1] - jArr[i2];
            if (j2 <= 0) {
                this.currentWordPercentage = -1;
            } else {
                this.currentWordPercentage = (int) (((j - jArr[i2]) * 100) / j2);
            }
            int i4 = this.currentWordPercentage;
            if (i4 > 100) {
                this.currentWordPercentage = 100;
                return;
            } else {
                if (i4 < 0) {
                    this.currentWordPercentage = -1;
                    return;
                }
                return;
            }
        }
        if (i2 != i3) {
            this.currentWordPercentage = 100;
            return;
        }
        long j3 = jArr2[i2];
        if (j3 == 0) {
            this.currentWordPercentage = 100;
            return;
        }
        int i5 = (int) (((j - jArr[i2]) * 100) / j3);
        this.currentWordPercentage = i5;
        if (i5 > 100) {
            this.currentWordPercentage = 100;
        } else if (i5 < 0) {
            this.currentWordPercentage = -1;
        }
    }

    private void calculatePosition(int i2, int i3) {
        float f2 = i3;
        this.mNormalJumpTopPositionAbovePercent = (this.mNormalJumpTopPositionAbove * 1.0f) / f2;
        this.mExitJumpTopPositionAbovePercent = (this.mExitJumpTopPositionAbove * 1.0f) / f2;
        this.mEndOfLineXTransPercent = (this.mEndOfLineXTranslate * 1.0f) / i2;
        this.mTextSizeRatio = (this.mTextSize * 1.0f) / f2;
        this.mAnimSize = (this.mAnimPixelSize * 1.0f) / f2;
    }

    private void calculatePreludeTime() {
        this.mPreludeTime = LyricDataUtils.calculatePreludeTime(this.mLyricData);
    }

    private boolean checkChanged() {
        return (this.lastLine == this.currentLine && this.lastInsideLine == this.currentInsideLine) ? false : true;
    }

    private boolean checkHasPassPrePlay(long j) {
        long j2 = this.mPreludeTime;
        return j2 != -1 && j >= j2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void drawAnimation(int i2, int i3, float[] fArr, String[] strArr, int i4) {
        if (i2 < 0 || i2 >= fArr.length - 1 || strArr == null) {
            return;
        }
        int i5 = i2 + 2;
        boolean z = i5 >= fArr.length;
        int i6 = i2 + 1;
        float f2 = (fArr[i6] + fArr[i2]) / 2.0f;
        float f3 = i3;
        float f4 = f3 / 100.0f;
        this.mLyricGLProcessor.setAnimationLeftPosition(f2 + (((!z ? (fArr[i5] + fArr[i6]) / 2.0f : f2 + this.mEndOfLineXTransPercent) - f2) * f4));
        float f5 = this.mTextTopMargin;
        float f6 = f5 - (z ? this.mExitJumpTopPositionAbovePercent : this.mNormalJumpTopPositionAbovePercent);
        float f7 = (f5 + (this.mTextSizeRatio / 2.0f)) - (this.mAnimSize / 2.0f);
        float f8 = f7 - f6;
        long j = (long) ((z ? this.fadeOutDuration : this.normalJumpDuration) * f4);
        PathValue pathValue = (z ? this.mFadeOutMovin : this.mNormalMovin).getLayer(0).pathValue;
        if ((z ? this.mFadeOutMovin.getLayer(0).pathValue.getKeyFrame(j, this.mFadeOutMovin.frameRate) : this.mNormalMovin.getLayer(0).pathValue.getKeyFrame(j, this.mNormalMovin.frameRate)) == null) {
            return;
        }
        float layerLargestHeight = f7 - (f8 * (((r10 - r5.startY) * 1.0f) / SingleLyricCell.getLayerLargestHeight(pathValue)));
        AnimationParam animationParam = new AnimationParam();
        if (z) {
            OpaqueValue.OpaqueKeyframe keyFrame = this.mFadeOutMovin.getLayer(0).opaqueValue.getKeyFrame((long) (this.fadeOutDuration * f4), this.mFadeOutMovin.frameRate);
            if (keyFrame == null) {
                return;
            } else {
                animationParam.alpha = keyFrame.endValue / 100.0f;
            }
        }
        int i7 = i2 % 4;
        this.mLyricGLProcessor.setAnimRotateZ((i7 != 0 ? i7 != 1 ? i7 != 2 ? i7 != 3 ? 0 : 90 : 180 : 270 : ShareCloudFileResource.HEIGHT) - ((int) ((f3 * 90.0f) / 100.0f)));
        for (int i8 = 0; i8 < i4; i8++) {
            animationParam.alpha *= 0.5f;
        }
        if (animationParam.alpha < 0.0f) {
            animationParam.alpha = 0.0f;
        }
        this.mLyricGLProcessor.setAnimParam(animationParam);
        this.mLyricGLProcessor.setAnimationTopMargin(layerLargestHeight);
        AnimationParam animationParam2 = new AnimationParam();
        if (strArr.length == 1) {
            animationParam2.alpha = 0.0f;
        } else if (i2 == 0) {
            animationParam2.alpha = f4;
        } else {
            animationParam2.alpha = animationParam.alpha;
        }
        this.mLyricGLProcessor.setParticleParam(animationParam2);
        this.mLyricGLProcessor.setParticleTopMargin((f7 + f6) / 2.0f);
    }

    private void drawDefaultMessage() {
        final String newDefaultMsg = LyricConstent.defaultMsg;
        if (!TextUtils.isEmpty(this.mOriginLyricView.getNewDefaultMsg())) {
            newDefaultMsg = this.mOriginLyricView.getNewDefaultMsg();
        }
        this.mLyricView.queueEvent(new Runnable() { // from class: com.kugou.framework.lyricanim.DuplicateLineLyricView.2
            @Override // java.lang.Runnable
            public void run() {
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                for (int i2 = 0; i2 < newDefaultMsg.length(); i2++) {
                    arrayList.add(TextBitmapUtils.convertString2Bitmap(String.valueOf(newDefaultMsg.charAt(i2)), DuplicateLineLyricView.this.mLyricPaint));
                    LyricEffectParam lyricEffectParam = new LyricEffectParam();
                    lyricEffectParam.colorTint = true;
                    lyricEffectParam.uplayColor = DuplicateLineLyricView.this.mLyricPaint.getColor();
                    lyricEffectParam.highlightColor = DuplicateLineLyricView.this.mOriginLyricView.getAttachInfo().getTextHighLightColor();
                    lyricEffectParam.colorCutPoint = 1.0f;
                    arrayList2.add(lyricEffectParam);
                }
                DuplicateLineLyricView.this.mLyricGLProcessor.setTextBitmaps(arrayList, (List) null);
                DuplicateLineLyricView.this.mLyricGLProcessor.setFirstParams(arrayList2);
                DuplicateLineLyricView.this.mLyricGLProcessor.setAnimIndex(-1);
            }
        });
        this.mLyricView.requestRender();
    }

    private void drawLyricLinesContent(final String[] strArr, final String[] strArr2) {
        this.mLyricView.queueEvent(new Runnable() { // from class: com.kugou.framework.lyricanim.DuplicateLineLyricView.3
            @Override // java.lang.Runnable
            public void run() {
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                ArrayList arrayList3 = new ArrayList();
                arrayList3.clear();
                int i2 = 0;
                int i3 = 0;
                while (true) {
                    String[] strArr3 = strArr;
                    if (i3 >= strArr3.length) {
                        break;
                    }
                    arrayList.add(TextBitmapUtils.convertString2Bitmap(strArr3[i3], DuplicateLineLyricView.this.mLyricPaint, DuplicateLineLyricView.this.mAdjustSpecialTypeface));
                    LyricEffectParam lyricEffectParam = new LyricEffectParam();
                    lyricEffectParam.colorTint = true;
                    lyricEffectParam.colorCutPoint = 1.0f;
                    lyricEffectParam.uplayColor = DuplicateLineLyricView.this.mLyricPaint.getColor();
                    lyricEffectParam.highlightColor = DuplicateLineLyricView.this.mOriginLyricView.getAttachInfo().getTextHighLightColor();
                    arrayList3.add(lyricEffectParam);
                    i3++;
                }
                if (strArr2 != null) {
                    while (true) {
                        String[] strArr4 = strArr2;
                        if (i2 >= strArr4.length) {
                            break;
                        }
                        arrayList2.add(TextBitmapUtils.convertString2Bitmap(strArr4[i2], DuplicateLineLyricView.this.mLyricPaint, DuplicateLineLyricView.this.mAdjustSpecialTypeface));
                        i2++;
                    }
                }
                AnimatedLyricsGLProcessor animatedLyricsGLProcessor = DuplicateLineLyricView.this.mLyricGLProcessor;
                if (arrayList2.isEmpty()) {
                    arrayList2 = null;
                }
                animatedLyricsGLProcessor.setTextBitmaps(arrayList, arrayList2);
                DuplicateLineLyricView.this.mLyricGLProcessor.setFirstParams(arrayList3);
            }
        });
        this.mLyricView.requestRender();
    }

    private void initLyricView(Context context) {
        this.mLyricGLProcessor = new AnimatedLyricsGLProcessor(context);
        this.mNormalJumpTopPositionAbove = Utils.dip2px(context, 9.0f);
        this.mExitJumpTopPositionAbove = Utils.dip2px(context, 9.0f);
        this.mEndOfLineXTranslate = Utils.dip2px(context, 16.0f);
        this.mTextSize = 50;
        this.mAnimPixelSize = Utils.dip2px(context, 22.0f);
        this.mLyricGLProcessor.setOnTextLayoutListener(new LyricsTextProgram.OnTextLayoutListener() { // from class: com.kugou.framework.lyricanim.DuplicateLineLyricView.6
            public void onTextLayout(int i2, int i3, float[] fArr, String[] strArr, boolean z) {
                DuplicateLineLyricView.this.positions = fArr;
                DuplicateLineLyricView.this.words = strArr;
                if (z) {
                    DuplicateLineLyricView.this.mLyricRecordQueue.clear();
                }
                LyricRecord lyricRecord = new LyricRecord(i2, i3);
                if (DuplicateLineLyricView.this.mLyricRecordQueue.size() == 40) {
                    DuplicateLineLyricView.this.mLyricRecordQueue.remove(0);
                }
                DuplicateLineLyricView.this.mLyricRecordQueue.add(lyricRecord);
            }
        });
        this.mLyricGLProcessor.setAnimationDrawStartListener(new AnimatedLyricsGLProcessor.OnAnimationDrawStartListener() { // from class: com.kugou.framework.lyricanim.DuplicateLineLyricView.7
            public boolean onAnimDrawStart(int i2, int i3) {
                int size;
                if (DuplicateLineLyricView.this.mLyricRecordQueue.isEmpty() || (size = (DuplicateLineLyricView.this.mLyricRecordQueue.size() - 1) - (DuplicateLineLyricView.this.mRecordInterval * i2)) < 0) {
                    return false;
                }
                LyricRecord lyricRecord = (LyricRecord) DuplicateLineLyricView.this.mLyricRecordQueue.get(size);
                DuplicateLineLyricView duplicateLineLyricView = DuplicateLineLyricView.this;
                duplicateLineLyricView.drawAnimation(lyricRecord.wordIndex, lyricRecord.percent, duplicateLineLyricView.positions, DuplicateLineLyricView.this.words, i2);
                return true;
            }
        });
        this.mLyricView.setOutRenderer(this);
        this.mNormalMovin = BodyMovinComposition.parseFromJson(C.MOVE_ANIM_CONFIG);
        this.mFadeOutMovin = BodyMovinComposition.parseFromJson(C.FADE_OUT_ANIM_CONFIG);
        this.mBounceTextMovin = BodyMovinComposition.parseFromJson(C.BOUNCE_TEXT_ANIM_CONFIG);
        this.mAnimBitmaps = new ArrayList();
        this.mParticleBitmaps = new ArrayList();
        this.mLyricView.setOnClickListener(new View.OnClickListener() { // from class: com.kugou.framework.lyricanim.DuplicateLineLyricView.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DuplicateLineLyricView.access$908(DuplicateLineLyricView.this);
                DuplicateLineLyricView.this.mLyricView.postDelayed(new Runnable() { // from class: com.kugou.framework.lyricanim.DuplicateLineLyricView.8.1
                    @Override // java.lang.Runnable
                    public void run() {
                        BaseLyricView.OnLyricViewClickListener onLyricViewClickListener;
                        if (DuplicateLineLyricView.this.mLyricViewClickCount == 1) {
                            DuplicateLineLyricView duplicateLineLyricView = DuplicateLineLyricView.this;
                            BaseLyricView.OnLyricViewClickListener onLyricViewClickListener2 = duplicateLineLyricView.mLyricViewClickListener;
                            if (onLyricViewClickListener2 != null) {
                                onLyricViewClickListener2.onClick(duplicateLineLyricView.mLyricView);
                            }
                        } else if (DuplicateLineLyricView.this.mLyricViewClickCount == 2 && (onLyricViewClickListener = DuplicateLineLyricView.this.mLyricViewClickListener) != null) {
                            onLyricViewClickListener.onDoubleClick();
                        }
                        DuplicateLineLyricView.this.mLyricView.removeCallbacks(this);
                        DuplicateLineLyricView.this.mLyricViewClickCount = 0;
                    }
                }, DuplicateLineLyricView.this.mLyricViewClickTimeOut);
            }
        });
        this.mLyricView.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.kugou.framework.lyricanim.DuplicateLineLyricView.9
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                DuplicateLineLyricView duplicateLineLyricView = DuplicateLineLyricView.this;
                BaseLyricView.OnCellLongClickListener onCellLongClickListener = duplicateLineLyricView.mLyricViewLongClickListener;
                if (onCellLongClickListener == null) {
                    return false;
                }
                onCellLongClickListener.onItemLongClick(null, duplicateLineLyricView.currentLine, 0.0f);
                return false;
            }
        });
    }

    private boolean isLyricDataValid(LyricData lyricData) {
        return (lyricData == null || lyricData.getWords() == null || lyricData.getWords().length == 0 || lyricData.getRowBeginTime() == null || lyricData.getRowBeginTime().length == 0 || lyricData.getRowDelayTime() == null || lyricData.getRowDelayTime().length == 0 || lyricData.getWordBeginTime() == null || lyricData.getWordBeginTime().length == 0 || lyricData.getWordDelayTime() == null || lyricData.getWordDelayTime().length == 0) ? false : true;
    }

    private int updateCurrentLine(long j, long[] jArr, long[] jArr2, long[][] jArr3) {
        int length = 0;
        for (int i2 = 0; i2 < jArr.length; i2++) {
            if (i2 < jArr3.length) {
                if (i2 == 0) {
                    if (j <= jArr[i2] - 200) {
                        return 0;
                    }
                    length = 0;
                }
                if (j <= jArr[i2] + jArr2[i2]) {
                    break;
                }
                if (i2 != jArr.length - 1) {
                    length = i2 + 1;
                    if (jArr[length] - (jArr[i2] + jArr2[i2]) <= 400 || j > jArr[length] - 400) {
                    }
                }
                return i2;
            }
            length = jArr3.length - 1;
        }
        return length;
    }

    private void updateDuplicateLineInfo() {
        this.currentLine = 0;
        this.currentLine = updateCurrentLine(this.currentPlayTime, this.mLyricData.getRowBeginTime(), this.mLyricData.getRowDelayTime(), this.mLyricData.getWordBeginTime());
        this.currentWordIndex = 0;
        this.currentWordPercentage = -1;
        this.currentInsideLine = 0;
        updateLyricLinesAttachInfo();
    }

    private void updateLyricAnimParams(final String[] strArr, final int i2, final int i3, boolean z) {
        ArrayList arrayList;
        final ArrayList arrayList2 = new ArrayList();
        arrayList2.clear();
        float f2 = 1.0f;
        if (i3 < 0 && strArr != null) {
            for (int i4 = 0; i4 < strArr.length; i4++) {
                LyricEffectParam lyricEffectParam = new LyricEffectParam();
                lyricEffectParam.colorTint = false;
                lyricEffectParam.scaleY = 1.0f;
                lyricEffectParam.scaleX = 1.0f;
                arrayList2.add(lyricEffectParam);
            }
            this.mLyricView.queueEvent(new Runnable() { // from class: com.kugou.framework.lyricanim.DuplicateLineLyricView.4
                @Override // java.lang.Runnable
                public void run() {
                    DuplicateLineLyricView.this.mLyricGLProcessor.setFirstParams(arrayList2);
                    DuplicateLineLyricView.this.mLyricGLProcessor.update(i2, i3, strArr);
                    DuplicateLineLyricView.this.mLyricGLProcessor.setAnimIndex(-1);
                }
            });
            this.mLyricView.requestRender();
            return;
        }
        if (strArr != null) {
            for (int i5 = 0; i5 < strArr.length; i5++) {
                LyricEffectParam lyricEffectParam2 = new LyricEffectParam();
                if (i5 < i2) {
                    lyricEffectParam2.colorTint = true;
                    lyricEffectParam2.uplayColor = this.mLyricPaint.getColor();
                    lyricEffectParam2.highlightColor = this.mOriginLyricView.getAttachInfo().getTextHighLightColor();
                    lyricEffectParam2.colorCutPoint = f2;
                } else if (i5 == i2) {
                    BodyMovinComposition bodyMovinComposition = this.mBounceTextMovin;
                    if (bodyMovinComposition != null) {
                        Layer layer = bodyMovinComposition.getLayer(0);
                        float f3 = i3;
                        arrayList = arrayList2;
                        long j = (long) (((((long) (layer.endFrame * 41.666668f)) * f2) * f3) / 100.0f);
                        ScaleValue.ScaleKeyframe keyFrame = layer.scaleValue.getKeyFrame(j, bodyMovinComposition.frameRate);
                        PathValue.PathKeyframe keyFrame2 = layer.pathValue.getKeyFrame(j, bodyMovinComposition.frameRate);
                        if (this.lastWordIndex == i2) {
                            lyricEffectParam2.colorTint = true;
                            lyricEffectParam2.uplayColor = this.mLyricPaint.getColor();
                            lyricEffectParam2.highlightColor = this.mOriginLyricView.getAttachInfo().getTextHighLightColor();
                            lyricEffectParam2.colorCutPoint = f3 / 100.0f;
                        } else {
                            this.lastWordIndex = i2;
                        }
                        lyricEffectParam2.scaleY = z ? keyFrame.endPointF.y / 100.0f : 1.0f;
                        lyricEffectParam2.scaleX = z ? keyFrame.endPointF.x / 100.0f : 1.0f;
                        lyricEffectParam2.transY = z ? (-keyFrame2.endY) / 26.0f : 0.0f;
                    } else {
                        arrayList = arrayList2;
                    }
                    arrayList2 = arrayList;
                    f2 = 1.0f;
                } else {
                    lyricEffectParam2.colorTint = false;
                    lyricEffectParam2.uplayColor = this.mLyricPaint.getColor();
                    lyricEffectParam2.highlightColor = this.mOriginLyricView.getAttachInfo().getTextHighLightColor();
                    f2 = 1.0f;
                    lyricEffectParam2.colorCutPoint = 1.0f;
                }
                arrayList2.add(lyricEffectParam2);
            }
        }
        final int i6 = (i3 >= 0 && z && this.loadBounceResFlag) ? 0 : -1;
        this.mLyricView.queueEvent(new Runnable() { // from class: com.kugou.framework.lyricanim.DuplicateLineLyricView.5
            @Override // java.lang.Runnable
            public void run() {
                DuplicateLineLyricView.this.mLyricGLProcessor.setFirstParams(arrayList2);
                DuplicateLineLyricView.this.mLyricGLProcessor.update(i2, i3, strArr);
                DuplicateLineLyricView.this.mLyricGLProcessor.setAnimIndex(i6);
            }
        });
        this.mLyricView.requestRender();
    }

    private void updateLyricLinesAttachInfo() {
        int i2;
        int i3;
        boolean z;
        if (this.currentLine >= this.mLyricData.getWordBeginTime().length) {
            this.currentLine = this.mLyricData.getWords().length - 1;
            this.currentInsideLine = 0;
            this.mFirstLineWords = this.mLyricData.getWords()[this.currentLine];
            this.mSecondLineWords = null;
            this.currentWordIndex = this.mLyricData.getWords()[this.currentLine].length - 1;
            this.currentWordPercentage = 100;
            return;
        }
        String[] strArr = this.mLyricData.getWords()[this.currentLine];
        long j = this.currentPlayTime - this.mLyricData.getRowBeginTime()[this.currentLine];
        long[] jArr = this.mLyricData.getWordBeginTime()[this.currentLine];
        long[] jArr2 = this.mLyricData.getWordDelayTime()[this.currentLine];
        int[] iArr = new int[strArr.length];
        int iCheckNewLine = this.mLyricGLProcessor.checkNewLine(this.mTextSizeRatio, strArr, iArr, this.mLyricPaint);
        if (iCheckNewLine <= 0) {
            this.mFirstLineWords = strArr;
            this.currentInsideLine = 0;
            if (this.currentLine < this.mLyricData.getWordBeginTime().length - 1) {
                this.mSecondLineWords = this.mLyricData.getWords()[this.currentLine + 1];
            } else {
                this.mSecondLineWords = null;
            }
            this.currentWordIndex = 0;
            for (int i4 = 0; i4 < this.mFirstLineWords.length && j >= jArr[i4]; i4++) {
                this.currentWordIndex = i4;
            }
            if (this.currentLine > this.mLyricData.getWords().length - 1) {
                this.currentLine = this.mLyricData.getWords().length - 1;
                this.currentWordIndex = this.mLyricData.getWords()[this.currentLine].length - 1;
                this.currentWordPercentage = 100;
                return;
            } else {
                if (this.currentWordIndex > this.mLyricData.getWords()[this.currentLine].length - 1) {
                    this.currentWordIndex = this.mLyricData.getWords()[this.currentLine].length - 1;
                }
                calculatePercentage(j, strArr, this.mLyricData.getWordBeginTime()[this.currentLine], this.mLyricData.getWordDelayTime()[this.currentLine]);
                return;
            }
        }
        if (iArr[0] == 0) {
            this.currentWordIndex = strArr.length - 1;
            this.currentWordPercentage = 100;
            this.currentInsideLine = 0;
            this.mFirstLineWords = (String[]) Arrays.copyOf(strArr, strArr.length);
            if (this.currentLine < this.mLyricData.getWordBeginTime().length - 1) {
                this.mSecondLineWords = this.mLyricData.getWords()[this.currentLine + 1];
                return;
            } else {
                this.mSecondLineWords = null;
                return;
            }
        }
        int i5 = 0;
        int i6 = 0;
        while (true) {
            if (i6 >= iCheckNewLine) {
                i2 = i5;
                i3 = iCheckNewLine;
                z = false;
                break;
            }
            long[] jArrCopyOfRange = Arrays.copyOfRange(jArr, i5, iArr[i6] + 1);
            long[] jArrCopyOfRange2 = Arrays.copyOfRange(jArr2, i5, iArr[i6] + 1);
            String[] strArr2 = (String[]) Arrays.copyOfRange(strArr, i5, iArr[i6] + 1);
            if (j > jArrCopyOfRange[jArrCopyOfRange.length - 1] + jArrCopyOfRange2[jArrCopyOfRange2.length - 1]) {
                i5 = iArr[i6] + 1;
                i6++;
            } else {
                for (int i7 = 0; i7 < strArr2.length && j > jArrCopyOfRange[i7]; i7++) {
                    this.currentWordIndex = i7;
                }
                i2 = i5;
                int i8 = i6;
                i3 = iCheckNewLine;
                calculatePercentage(j, strArr2, jArrCopyOfRange, jArrCopyOfRange2);
                this.currentInsideLine = i8;
                this.mFirstLineWords = (String[]) Arrays.copyOf(strArr2, strArr2.length);
                this.mSecondLineWords = (String[]) Arrays.copyOfRange(strArr, iArr[i8] + 1, strArr.length);
                z = true;
            }
        }
        if (z) {
            return;
        }
        int i9 = i2;
        long[] jArrCopyOfRange3 = Arrays.copyOfRange(jArr, i9, strArr.length);
        long[] jArrCopyOfRange4 = Arrays.copyOfRange(jArr2, i9, strArr.length);
        String[] strArr3 = (String[]) Arrays.copyOfRange(strArr, i9, strArr.length);
        for (int i10 = 0; i10 < strArr3.length && j > jArrCopyOfRange3[i10]; i10++) {
            this.currentWordIndex = i10;
        }
        calculatePercentage(j, strArr3, jArrCopyOfRange3, jArrCopyOfRange4);
        this.currentInsideLine = i3;
        this.mFirstLineWords = (String[]) Arrays.copyOf(strArr3, strArr3.length);
        if (this.currentLine < this.mLyricData.getWordBeginTime().length - 1) {
            this.mSecondLineWords = this.mLyricData.getWords()[this.currentLine + 1];
        } else {
            this.mSecondLineWords = null;
        }
    }

    private void updateLyricView() {
        if (this.mFirstLineWords == null && this.mSecondLineWords == null) {
            drawDefaultMessage();
            return;
        }
        if (checkChanged()) {
            this.lastLine = this.currentLine;
            this.lastInsideLine = this.currentInsideLine;
            drawLyricLinesContent(this.mFirstLineWords, this.mSecondLineWords);
        }
        updateLyricAnimParams(this.mFirstLineWords, this.currentWordIndex, this.currentWordPercentage, checkHasPassPrePlay(this.currentPlayTime));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateProgress(long j) {
        this.currentPlayTime = j;
        if (!isLyricDataValid(this.mLyricData)) {
            drawDefaultMessage();
            return;
        }
        if (this.mLyricView.getVisibility() == 0 && (this.mLyricData.getLyricType() == 3 || this.mLyricData.getLyricType() == 2)) {
            this.mLyricView.setVisibility(4);
            this.mOriginLyricView.setVisibility(0);
            OpenGlLyricViewVisibleListener openGlLyricViewVisibleListener = this.mOpenGlViewListener;
            if (openGlLyricViewVisibleListener != null) {
                openGlLyricViewVisibleListener.onVisibleChanged(false);
                return;
            }
            return;
        }
        if (this.mLyricData.getLyricType() == 3 || this.mLyricData.getLyricType() == 2 || !isShowBounceAnim() || getVisibility() != 0) {
            return;
        }
        updateDuplicateLineInfo();
        LyricDebug.d("updateProgress: line->" + this.currentLine + " word index-> " + this.currentWordIndex + " percentage->" + this.currentWordPercentage);
        updateLyricView();
    }

    public AttachInfo getAttachInfo() {
        return this.mOriginLyricView.getAttachInfo();
    }

    @Override // com.kugou.framework.lyric.ILyricView
    public float getContentWidth() {
        return 0.0f;
    }

    @Override // com.kugou.framework.lyric.ILyricView
    public String getCurrentLyrics() {
        return this.mOriginLyricView.getCurrentLyrics();
    }

    @Override // com.kugou.framework.lyric.ILyricView
    public LyricData getLyricData() {
        return this.mLyricData;
    }

    @Override // com.kugou.framework.lyric.ILyricView
    public Paint getPen() {
        return this.mOriginLyricView.getPen();
    }

    @Override // com.kugou.framework.lyric.ILyricView
    public float getRowHeight() {
        return this.mOriginLyricView.getRowHeight();
    }

    @Override // com.kugou.framework.lyric.ILyricView
    public float getTextSize() {
        return this.mOriginLyricView.getTextSize();
    }

    public GLTextureView getmGlTextureView() {
        return this.mLyricView;
    }

    public FixLineLyricView getmOriginLyricView() {
        return this.mOriginLyricView;
    }

    public boolean isAnimLyricViewShow() {
        return this.mLyricView.getVisibility() == 0;
    }

    @Override // com.kugou.framework.lyric.ILyricView
    public boolean isLyrViewShown() {
        return getVisibility() == 0;
    }

    @Override // com.kugou.framework.lyric.ILyricView
    public boolean isLyricLoaded() {
        return this.mOriginLyricView.isLyricLoaded();
    }

    @Override // com.kugou.framework.lyric.ILyricView
    public boolean isLyricSplited() {
        return false;
    }

    public boolean isShowBounceAnim() {
        return this.mShowBounceAnim;
    }

    public void onDrawFrame() {
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        GLES20.glClear(16384);
        StringBuilder sb = new StringBuilder();
        sb.append("onDrawFrame() called currentWordIndex:");
        sb.append(this.currentWordIndex);
        sb.append(" words:");
        String[] strArr = this.mFirstLineWords;
        sb.append(strArr == null ? "0" : String.valueOf(strArr.length));
        LyricDebug.d(sb.toString());
        this.mLyricGLProcessor.setFontHeightRatio(this.mTextSizeRatio);
        this.mLyricGLProcessor.setAnimSize(this.mAnimSize);
        this.mLyricGLProcessor.onDraw(0L, 0L);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        calculatePosition(i2, i3);
    }

    public void onSurfaceChanged(int i2, int i3) {
        this.mLyricGLProcessor.setViewPortSize(i2, i3);
    }

    public void onSurfaceCreated(int i2, int i3) {
        this.mLyricGLProcessor.prepare();
        this.mLyricGLProcessor.setDogCount(1);
        this.mLyricGLProcessor.setFontHeightRatio(this.mTextSizeRatio);
        this.mLyricGLProcessor.setTextTopMargin(this.mTextTopMargin);
        this.mLyricGLProcessor.setAnimationTopMargin(this.mTextTopMargin);
        this.mLyricGLProcessor.setAnimSize(this.mAnimSize);
        List<Bitmap> list = this.mAnimBitmaps;
        if (list != null && !list.isEmpty()) {
            this.mLyricGLProcessor.setAnimBitmaps(this.mAnimBitmaps);
        }
        List<Bitmap> list2 = this.mParticleBitmaps;
        if (list2 != null && !list2.isEmpty() && this.loadBounceResFlag) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(this.mParticleBitmaps);
            this.mLyricGLProcessor.setParticleBitmaps(arrayList);
        }
        if (isShowBounceAnim()) {
            updateBounceAnimLyricView();
        }
    }

    public void onSurfaceTextureCreate() {
    }

    public void onSurfaceTextureDestroy() {
    }

    @Override // com.kugou.framework.lyric.ILyricView
    public void refresh() {
        this.mOriginLyricView.refresh();
        postInvalidate();
    }

    @Override // com.kugou.framework.lyric.ILyricView
    public void release() {
        if (this.mShowBounceAnim && this.mLyricView.getVisibility() == 4) {
            this.mLyricView.setVisibility(0);
            this.mOriginLyricView.setVisibility(4);
            OpenGlLyricViewVisibleListener openGlLyricViewVisibleListener = this.mOpenGlViewListener;
            if (openGlLyricViewVisibleListener != null) {
                openGlLyricViewVisibleListener.onVisibleChanged(true);
            }
        }
        this.mOriginLyricView.release();
        this.mFirstLineWords = null;
        this.mSecondLineWords = null;
        this.mLyricData = null;
        this.lastLine = -1;
        this.lastInsideLine = 0;
        this.currentPlayTime = 0L;
        this.mLyricView.queueEvent(new Runnable() { // from class: com.kugou.framework.lyricanim.DuplicateLineLyricView.1
            @Override // java.lang.Runnable
            public void run() {
                DuplicateLineLyricView.this.mLyricGLProcessor.setTextBitmaps((List) null, (List) null);
            }
        });
        this.mLyricView.requestRender();
    }

    @Override // com.kugou.framework.lyric.ILyricView
    public void resetRowIndex() {
    }

    public void setAnimSize(int i2) {
        this.mAnimPixelSize = i2;
        calculatePosition(getWidth(), getHeight());
    }

    public void setAnimationBitmaps(int[] iArr) {
        this.mAnimBitmaps.clear();
        for (int i2 : iArr) {
            this.mAnimBitmaps.add(BitmapFactory.decodeResource(getResources(), i2));
        }
        this.mLyricView.queueEvent(new Runnable() { // from class: com.kugou.framework.lyricanim.DuplicateLineLyricView.10
            @Override // java.lang.Runnable
            public void run() {
                DuplicateLineLyricView.this.mLyricGLProcessor.setAnimBitmaps(DuplicateLineLyricView.this.mAnimBitmaps);
            }
        });
        if (isShowBounceAnim()) {
            updateBounceAnimLyricView();
        }
    }

    @Override // com.kugou.framework.lyricanim.IBounceView
    public void setBounceBitmaps(List<Bitmap> list) {
        this.mParticleBitmaps.clear();
        if (list != null) {
            this.mParticleBitmaps.addAll(list);
            this.loadBounceResFlag = true;
            this.mLyricView.queueEvent(new Runnable() { // from class: com.kugou.framework.lyricanim.DuplicateLineLyricView.11
                @Override // java.lang.Runnable
                public void run() {
                    DuplicateLineLyricView.this.mLyricGLProcessor.setParticleBitmaps(DuplicateLineLyricView.this.mParticleBitmaps);
                }
            });
            if (isShowBounceAnim()) {
                updateBounceAnimLyricView();
            }
        }
    }

    public void setCellClickEnable(boolean z) {
        this.mOriginLyricView.setCellClickEnable(z);
    }

    public void setCellRowMargin(int i2) {
        this.mOriginLyricView.setCellRowMargin(i2);
        this.mLyricView.requestRender();
    }

    public void setDefaultMessageStyle(int i2) {
        this.mOriginLyricView.setDefaultMessageStyle(i2);
    }

    @Override // com.kugou.framework.lyric.ILyricView
    public void setDefaultMsg(String str) {
        LyricConstent.defaultMsg = str;
        this.mOriginLyricView.setDefaultMsg(str);
    }

    public void setDisableTouchEvent(boolean z) {
        this.mOriginLyricView.setDisableTouchEvent(z);
    }

    @Override // com.kugou.framework.lyric.ILyricView
    public void setLyricData(LyricData lyricData) {
        this.mLyricData = lyricData;
        this.mOriginLyricView.setLyricData(lyricData);
        this.lastLine = -1;
        this.lastInsideLine = 0;
        calculatePreludeTime();
    }

    public void setNormalWithBounceAnim() {
        this.mShowBounceAnim = true;
        this.mOriginLyricView.setScaleHighLightWord(false);
        LyricData lyricData = this.mLyricData;
        if (lyricData == null || !(lyricData.getLyricType() == 3 || this.mLyricData.getLyricType() == 2)) {
            this.mOriginLyricView.setVisibility(4);
            this.mLyricView.setVisibility(0);
            OpenGlLyricViewVisibleListener openGlLyricViewVisibleListener = this.mOpenGlViewListener;
            if (openGlLyricViewVisibleListener != null) {
                openGlLyricViewVisibleListener.onVisibleChanged(true);
            }
            postDelayed(new Runnable() { // from class: com.kugou.framework.lyricanim.DuplicateLineLyricView.12
                @Override // java.lang.Runnable
                public void run() {
                    DuplicateLineLyricView duplicateLineLyricView = DuplicateLineLyricView.this;
                    duplicateLineLyricView.updateProgress(duplicateLineLyricView.currentPlayTime);
                }
            }, 400L);
            return;
        }
        this.mOriginLyricView.setVisibility(0);
        this.mLyricView.setVisibility(4);
        OpenGlLyricViewVisibleListener openGlLyricViewVisibleListener2 = this.mOpenGlViewListener;
        if (openGlLyricViewVisibleListener2 != null) {
            openGlLyricViewVisibleListener2.onVisibleChanged(false);
        }
    }

    public void setNormalWithoutAnyAnim() {
        this.mShowBounceAnim = false;
        this.mOriginLyricView.setScaleHighLightWord(false);
        this.mOriginLyricView.setVisibility(0);
        this.mLyricView.setVisibility(4);
        OpenGlLyricViewVisibleListener openGlLyricViewVisibleListener = this.mOpenGlViewListener;
        if (openGlLyricViewVisibleListener != null) {
            openGlLyricViewVisibleListener.onVisibleChanged(false);
        }
    }

    public void setOnCellLongClickListener(BaseLyricView.OnCellLongClickListener onCellLongClickListener) {
        this.mOriginLyricView.setOnCellLongClickListener(onCellLongClickListener);
        this.mLyricViewLongClickListener = onCellLongClickListener;
    }

    public void setOnClickInterceptListener(BaseLyricView.OnClickInterceptListener onClickInterceptListener) {
        this.mOriginLyricView.setOnClickInterceptListener(onClickInterceptListener);
    }

    public void setOnLyricViewBlankAreaClickListener(BaseLyricView.OnLyricViewBlankAreaClickListener onLyricViewBlankAreaClickListener) {
        this.mOriginLyricView.setOnLyricViewBlankAreaClickListener(onLyricViewBlankAreaClickListener);
    }

    public void setOnLyricViewClickListener(BaseLyricView.OnLyricViewClickListener onLyricViewClickListener) {
        this.mOriginLyricView.setOnLyricViewClickListener(onLyricViewClickListener);
        this.mLyricViewClickListener = onLyricViewClickListener;
    }

    public void setOpenGlLyricViewVisibleListener(OpenGlLyricViewVisibleListener openGlLyricViewVisibleListener) {
        this.mOpenGlViewListener = openGlLyricViewVisibleListener;
    }

    public void setParticleBitmaps(int[] iArr) {
        this.loadBounceResFlag = false;
        AsyncBounceResLoader.asyncLoadBounceRes(iArr, this);
    }

    public void setPressColor(int i2) {
        this.mOriginLyricView.setPressColor(i2);
    }

    public void setScaleWordAnim() {
        this.mShowBounceAnim = false;
        this.mOriginLyricView.setVisibility(0);
        this.mOriginLyricView.setScaleHighLightWord(true);
        this.mLyricView.setVisibility(4);
        OpenGlLyricViewVisibleListener openGlLyricViewVisibleListener = this.mOpenGlViewListener;
        if (openGlLyricViewVisibleListener != null) {
            openGlLyricViewVisibleListener.onVisibleChanged(false);
        }
    }

    public void setSingleLine(boolean z) {
        this.mOriginLyricView.setSingleLine(z);
    }

    public void setTextColor(int i2) {
        this.mOriginLyricView.setTextColor(i2);
        String[] strArr = this.mFirstLineWords;
        if (strArr != null) {
            updateLyricAnimParams(strArr, this.currentWordIndex, this.currentWordPercentage, checkHasPassPrePlay(this.currentPlayTime));
        }
    }

    public void setTextHighLightColor(int i2) {
        this.mOriginLyricView.setTextHighLightColor(i2);
        String[] strArr = this.mFirstLineWords;
        if (strArr != null) {
            updateLyricAnimParams(strArr, this.currentWordIndex, this.currentWordPercentage, checkHasPassPrePlay(this.currentPlayTime));
        }
    }

    public void setTextSize(int i2) {
        this.mOriginLyricView.setTextSize(i2);
        this.mLyricPaint.setTextSize(i2);
        Paint.FontMetrics fontMetrics = this.mLyricPaint.getFontMetrics();
        this.mTextSize = (int) (fontMetrics.bottom - fontMetrics.top);
        calculatePosition(getWidth(), getHeight());
        if (this.mLyricData != null) {
            updateLyricLinesAttachInfo();
            drawLyricLinesContent(this.mFirstLineWords, this.mSecondLineWords);
            updateLyricAnimParams(this.mFirstLineWords, this.currentWordIndex, this.currentWordPercentage, checkHasPassPrePlay(this.currentPlayTime));
        }
    }

    public void setTypeface(Typeface typeface) {
        this.mOriginLyricView.setTypeface(typeface);
        this.mLyricPaint.setTypeface(typeface);
        Paint.FontMetrics fontMetrics = this.mLyricPaint.getFontMetrics();
        this.mTextSize = (int) (fontMetrics.bottom - fontMetrics.top);
        calculatePosition(getWidth(), getHeight());
        if (this.mLyricData != null) {
            updateLyricLinesAttachInfo();
            drawLyricLinesContent(this.mFirstLineWords, this.mSecondLineWords);
            updateLyricAnimParams(this.mFirstLineWords, this.currentWordIndex, this.currentWordPercentage, checkHasPassPrePlay(this.currentPlayTime));
        }
    }

    @Override // android.view.View
    public void setVisibility(int i2) {
        super.setVisibility(i2);
        updateProgress(this.currentPlayTime);
    }

    @Override // com.kugou.framework.lyric2.ISurLyricSync
    public void syncLyric2(long j) {
        this.mOriginLyricView.syncLyric2(j);
        updateProgress(j);
    }

    public void updateBounceAnimLyricView() {
        String[] strArr = this.mFirstLineWords;
        if (strArr != null) {
            drawLyricLinesContent(strArr, this.mSecondLineWords);
            updateLyricAnimParams(this.mFirstLineWords, this.currentWordIndex, this.currentWordPercentage, checkHasPassPrePlay(this.currentPlayTime));
        }
    }

    public DuplicateLineLyricView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DuplicateLineLyricView(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.lastLine = -1;
        this.lastInsideLine = 0;
        this.mPreludeTime = -1L;
        this.fadeOutDuration = 1000.0f;
        this.normalJumpDuration = 2000.0f;
        this.mAnimSize = 0.2f;
        this.mTextSizeRatio = 0.24f;
        this.mTextTopMargin = 0.2f;
        this.lastWordIndex = -1;
        this.mAdjustSpecialTypeface = false;
        this.mLyricViewClickTimeOut = HttpStatus.SC_BAD_REQUEST;
        this.mLyricViewClickCount = 0;
        this.mRecordInterval = 3;
        this.mLyricRecordQueue = new LinkedList();
        this.loadBounceResFlag = false;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        FixLineLyricView fixLineLyricView = new FixLineLyricView(context);
        this.mOriginLyricView = fixLineLyricView;
        fixLineLyricView.setCellAlignMode(1);
        layoutParams.gravity = 16;
        addView(this.mOriginLyricView, layoutParams);
        GLTextureView gLTextureView = new GLTextureView(getContext());
        this.mLyricView = gLTextureView;
        gLTextureView.setAlpha(0.99f);
        this.mLyricView.setReleaseWhenDetached(false);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
        layoutParams2.gravity = 16;
        addView(this.mLyricView, layoutParams2);
        initLyricView(context);
        Paint paint = new Paint();
        this.mLyricPaint = paint;
        paint.setTypeface(getAttachInfo().getTypeface());
        this.mLyricPaint.setTextSize(getAttachInfo().getTextSize());
        this.mLyricPaint.setColor(getAttachInfo().getTextColor());
    }

    public void setTypeface(Typeface typeface, boolean z) {
        this.mOriginLyricView.setTypeface(typeface);
        this.mAdjustSpecialTypeface = z;
        this.mLyricPaint.setTypeface(typeface);
        Paint.FontMetrics fontMetrics = this.mLyricPaint.getFontMetrics();
        this.mTextSize = (int) (fontMetrics.bottom - fontMetrics.top);
        calculatePosition(getWidth(), getHeight());
        if (this.mLyricData != null) {
            updateLyricLinesAttachInfo();
            drawLyricLinesContent(this.mFirstLineWords, this.mSecondLineWords);
            updateLyricAnimParams(this.mFirstLineWords, this.currentWordIndex, this.currentWordPercentage, checkHasPassPrePlay(this.currentPlayTime));
        }
    }
}
