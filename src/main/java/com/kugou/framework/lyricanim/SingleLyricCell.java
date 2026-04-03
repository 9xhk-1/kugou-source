package com.kugou.framework.lyricanim;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Paint;
import android.opengl.GLES20;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
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
import com.kugou.framework.lyric4.utils.Utils;
import com.xtc.shareapi.share.shareobject.ShareCloudFileResource;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class SingleLyricCell extends FrameLayout implements GLTextureView.Renderer, IBounceView {
    private static final int DEFAULT_COLOR = -1;
    private static final int DEFAULT_HIGH_LIGHT_COLOR = -65536;
    private static final String TAG = "SingleLyricCell";
    private int align;
    private float fadeOutDuration;
    private boolean firstWordSpecial;
    private int lastWordIndex;
    private boolean loadBounceResFlag;
    private boolean mAdjustSpecialTypeface;
    private List<Bitmap> mAnimBitmaps;
    private int mAnimDpSize;
    private float mAnimSize;
    private BodyMovinComposition mBounceTextFirstMovin;
    private BodyMovinComposition mBounceTextMovin;
    private float mEndOfLineXTransPercent;
    private int mEndOfLineXTranslate;
    private int mExitJumpTopPositionAbove;
    private float mExitJumpTopPositionAbovePercent;
    private BodyMovinComposition mFadeOutMovin;
    private int mFontSize;
    private GLTextureView mGLTextureView;
    private int mHighLightTextColor;
    private AnimatedLyricsGLProcessor mLyricGLProcessor;
    private List<LyricRecord> mLyricRecordQueue;
    private BodyMovinComposition mNormalFirstMovin;
    private int mNormalJumpTopPositionAbove;
    private float mNormalJumpTopPositionAbovePercent;
    private BodyMovinComposition mNormalMovin;
    private List<Bitmap> mParticleBitmaps;
    private int mRecordInterval;
    private int mTextAnimType;
    private TextRenderListener mTextRenderListener;
    private float mTextSize;
    private float mTextTopMargin;
    private WeakReference<List<Bitmap>> mWeakParticleBitmaps;
    private BodyMovinComposition mZoomTextMovin;
    private boolean newLine;
    private float normalJumpDuration;
    private float[] positions;
    private volatile boolean surfaceCreated;
    private int unPlayColor;
    private String[] words;

    public interface TextRenderListener {
        void onGLCreated();

        void onSurfaceTextureDestroy();

        void onTextRenderChanged();
    }

    public SingleLyricCell(Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void drawAnimation(int i2, int i3, float[] fArr, String[] strArr, int i4) {
        float f2;
        float f3;
        float f4;
        if (i2 < 0 || i2 >= fArr.length - 1 || strArr == null) {
            return;
        }
        boolean z = i2 == 0;
        int i5 = i2 + 2;
        boolean z2 = i5 >= fArr.length;
        int i6 = i2 + 1;
        float f5 = (fArr[i6] + fArr[i2]) / 2.0f;
        float f6 = i3;
        float f7 = f6 / 100.0f;
        float f8 = (!z2 ? (fArr[i5] + fArr[i6]) / 2.0f : this.mEndOfLineXTransPercent + f5) - f5;
        if (this.firstWordSpecial && !z2 && z) {
            if (i3 <= 20) {
                f5 = fArr[i2];
                f3 = (fArr[i6] - fArr[i2]) * f7;
                f4 = 2.5f;
            } else {
                f5 = (fArr[i6] + fArr[i2]) / 2.0f;
                f3 = (((fArr[i5] + fArr[i6]) / 2.0f) - f5) * (f7 - 0.2f);
                f4 = 1.2f;
            }
            f2 = f3 * f4;
        } else {
            f2 = f8 * f7;
        }
        this.mLyricGLProcessor.setAnimationLeftPosition(f5 + f2);
        float f9 = this.mTextTopMargin;
        float f10 = f9 - (z2 ? this.mExitJumpTopPositionAbovePercent : this.mNormalJumpTopPositionAbovePercent);
        float f11 = (f9 + (this.mTextSize / 2.0f)) - (this.mAnimSize / 2.0f);
        float f12 = f11 - f10;
        long j = (long) ((z2 ? this.fadeOutDuration : this.normalJumpDuration) * f7);
        PathValue pathValue = z2 ? this.mFadeOutMovin.getLayer(0).pathValue : this.mNormalMovin.getLayer(0).pathValue;
        if ((z2 ? this.mFadeOutMovin.getLayer(0).pathValue.getKeyFrame(j, this.mFadeOutMovin.frameRate) : this.mNormalMovin.getLayer(0).pathValue.getKeyFrame(j, this.mNormalMovin.frameRate)) == null) {
            return;
        }
        float layerLargestHeight = f11 - (f12 * (((r8 - r10.startY) * 1.0f) / getLayerLargestHeight(pathValue)));
        AnimationParam animationParam = new AnimationParam();
        if (z2) {
            OpaqueValue.OpaqueKeyframe keyFrame = this.mFadeOutMovin.getLayer(0).opaqueValue.getKeyFrame((long) (this.fadeOutDuration * f7), this.mFadeOutMovin.frameRate);
            if (keyFrame == null) {
                return;
            } else {
                animationParam.alpha = keyFrame.endValue / 100.0f;
            }
        }
        int i7 = i2 % 4;
        this.mLyricGLProcessor.setAnimRotateZ((i7 != 0 ? i7 != 1 ? i7 != 2 ? i7 != 3 ? 0 : 90 : 180 : 270 : ShareCloudFileResource.HEIGHT) - ((int) ((f6 * 90.0f) / 100.0f)));
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
            animationParam2.alpha = f7;
        } else {
            animationParam2.alpha = animationParam.alpha;
        }
        this.mLyricGLProcessor.setParticleParam(animationParam2);
        this.mLyricGLProcessor.setParticleTopMargin((f11 + f10) / 2.0f);
    }

    public static int getLayerLargestHeight(PathValue pathValue) {
        if (pathValue.isStatic()) {
            return pathValue.getKeyFrame(0L, 0).startY;
        }
        int iMax = 0;
        for (PathValue.PathKeyframe pathKeyframe : pathValue.getAnimationKeyFrames()) {
            iMax = Math.max(pathKeyframe.startY, iMax);
        }
        return iMax;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setGLAlign() {
        this.mLyricGLProcessor.setTextAlign(this.align);
    }

    public void calculatePosition(int i2, int i3) {
        float f2 = i3;
        this.mNormalJumpTopPositionAbovePercent = (this.mNormalJumpTopPositionAbove * 1.0f) / f2;
        this.mExitJumpTopPositionAbovePercent = (this.mExitJumpTopPositionAbove * 1.0f) / f2;
        this.mEndOfLineXTransPercent = (this.mEndOfLineXTranslate * 1.0f) / i2;
        this.mTextSize = (this.mFontSize * 1.0f) / f2;
        this.mAnimSize = (this.mAnimDpSize * 1.0f) / f2;
    }

    public boolean isSurfaceCreated() {
        return this.surfaceCreated;
    }

    public void onDrawFrame() {
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        GLES20.glClear(16384);
        this.mLyricGLProcessor.setFontHeightRatio(this.mTextSize);
        this.mLyricGLProcessor.setAnimSize(this.mAnimSize);
        if (this.mTextAnimType != 0) {
            this.mLyricGLProcessor.setAnimIndex(-1);
        }
        this.mLyricGLProcessor.onDraw(0L, 0L);
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mGLTextureView.getLayoutParams();
        layoutParams.width = -1;
        layoutParams.height = -1;
        this.mGLTextureView.setLayoutParams(layoutParams);
        calculatePosition(i2, i3);
    }

    public void onSurfaceChanged(int i2, int i3) {
        this.mLyricGLProcessor.setViewPortSize(i2, i3);
    }

    public void onSurfaceCreated(int i2, int i3) {
        this.mLyricGLProcessor.prepare();
        this.mLyricGLProcessor.setDogCount(1);
        this.mLyricGLProcessor.setFontHeightRatio(this.mTextSize);
        List<Bitmap> list = this.mAnimBitmaps;
        if (list != null && !list.isEmpty()) {
            this.mLyricGLProcessor.setAnimBitmaps(this.mAnimBitmaps);
        }
        List<Bitmap> list2 = this.mParticleBitmaps;
        if (list2 != null && !list2.isEmpty() && this.loadBounceResFlag) {
            try {
                this.mLyricGLProcessor.setParticleBitmaps(this.mParticleBitmaps);
            } catch (Exception e2) {
                Log.e(TAG, "onSurfaceCreated e=" + e2);
            }
        }
        this.mLyricGLProcessor.setTextTopMargin(this.mTextTopMargin);
        this.mLyricGLProcessor.setAnimationTopMargin(this.mTextTopMargin);
        this.mLyricGLProcessor.setAnimSize(this.mAnimSize);
        this.mLyricGLProcessor.setTextRenderedRunnable(new Runnable() { // from class: com.kugou.framework.lyricanim.SingleLyricCell.4
            @Override // java.lang.Runnable
            public void run() {
                if (SingleLyricCell.this.mTextRenderListener != null) {
                    SingleLyricCell.this.mTextRenderListener.onTextRenderChanged();
                }
            }
        });
        TextRenderListener textRenderListener = this.mTextRenderListener;
        if (textRenderListener != null) {
            textRenderListener.onGLCreated();
        }
    }

    public void onSurfaceTextureCreate() {
        this.surfaceCreated = true;
    }

    public void onSurfaceTextureDestroy() {
        this.surfaceCreated = false;
        TextRenderListener textRenderListener = this.mTextRenderListener;
        if (textRenderListener != null) {
            textRenderListener.onSurfaceTextureDestroy();
        }
    }

    public void release() {
        this.lastWordIndex = -1;
        if (isSurfaceCreated()) {
            setVisibility(4);
        }
        this.mGLTextureView.queueEvent(new Runnable() { // from class: com.kugou.framework.lyricanim.SingleLyricCell.10
            @Override // java.lang.Runnable
            public void run() {
                SingleLyricCell.this.setGLAlign();
                SingleLyricCell.this.mLyricGLProcessor.setTextBitmaps((List) null, (List) null);
            }
        });
        this.mGLTextureView.requestRender();
    }

    public void setAdjustSpecialTypeface(boolean z) {
        this.mAdjustSpecialTypeface = z;
    }

    public void setAnimSize(int i2) {
        this.mAnimDpSize = i2;
        calculatePosition(getWidth(), getHeight());
    }

    public void setAnimationImageArray(int[] iArr) {
        if (iArr == null) {
            return;
        }
        this.mAnimBitmaps.clear();
        for (int i2 : iArr) {
            this.mAnimBitmaps.add(BitmapFactory.decodeResource(getResources(), i2));
        }
        this.mGLTextureView.queueEvent(new Runnable() { // from class: com.kugou.framework.lyricanim.SingleLyricCell.5
            @Override // java.lang.Runnable
            public void run() {
                SingleLyricCell.this.mLyricGLProcessor.setAnimBitmaps(SingleLyricCell.this.mAnimBitmaps);
            }
        });
    }

    @Override // com.kugou.framework.lyricanim.IBounceView
    public void setBounceBitmaps(List<Bitmap> list) {
        this.mParticleBitmaps.clear();
        if (list != null) {
            this.mParticleBitmaps.addAll(list);
            this.loadBounceResFlag = true;
            this.mWeakParticleBitmaps = new WeakReference<>(this.mParticleBitmaps);
            this.mGLTextureView.queueEvent(new Runnable() { // from class: com.kugou.framework.lyricanim.SingleLyricCell.6
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        List list2 = (List) SingleLyricCell.this.mWeakParticleBitmaps.get();
                        if (list2 != null) {
                            SingleLyricCell.this.mLyricGLProcessor.setParticleBitmaps(list2);
                        }
                    } catch (Exception e2) {
                        Log.e(SingleLyricCell.TAG, "setBounceBitmaps e=" + e2);
                    }
                }
            });
        }
    }

    public void setGLTextureReleaseWhenDetached(boolean z) {
        this.mGLTextureView.setReleaseWhenDetached(z);
    }

    public void setHighLightTextColor(int i2) {
        this.mHighLightTextColor = i2;
    }

    public void setParticleBitmaps(int[] iArr) {
        this.loadBounceResFlag = false;
        AsyncBounceResLoader.asyncLoadBounceRes(iArr, this);
    }

    public void setTextAlign(int i2) {
        this.align = i2;
    }

    public void setTextAnimType(int i2) {
        this.mTextAnimType = i2;
    }

    public void setTextRenderListener(TextRenderListener textRenderListener) {
        this.mTextRenderListener = textRenderListener;
    }

    public void setTextSize(int i2) {
        this.mFontSize = i2;
        calculatePosition(getWidth(), getHeight());
    }

    public void setUnPlayColor(int i2) {
        this.unPlayColor = i2;
    }

    public void updateAnimationParams(final String[] strArr, final int i2, final int i3, final float f2) {
        if (strArr == null) {
            return;
        }
        final ArrayList arrayList = new ArrayList();
        BodyMovinComposition bodyMovinComposition = null;
        int i4 = this.mTextAnimType;
        if (i4 == 0) {
            bodyMovinComposition = this.mBounceTextMovin;
        } else if (i4 == 1) {
            bodyMovinComposition = this.mZoomTextMovin;
        }
        Layer layer = bodyMovinComposition.getLayer(0);
        float f3 = i3;
        long j = (long) (((((long) (layer.endFrame * 41.666668f)) * 1.0f) * f3) / 100.0f);
        ScaleValue.ScaleKeyframe keyFrame = layer.scaleValue.getKeyFrame(j, bodyMovinComposition.frameRate);
        PathValue.PathKeyframe keyFrame2 = layer.pathValue.getKeyFrame(j, bodyMovinComposition.frameRate);
        for (int i5 = 0; i5 < strArr.length; i5++) {
            LyricEffectParam lyricEffectParam = new LyricEffectParam();
            if (i5 < i2) {
                lyricEffectParam.colorTint = true;
                lyricEffectParam.uplayColor = this.unPlayColor;
                lyricEffectParam.highlightColor = this.mHighLightTextColor;
                lyricEffectParam.colorCutPoint = 1.0f;
            } else if (i5 == i2) {
                if (this.lastWordIndex == i2) {
                    lyricEffectParam.colorTint = true;
                    lyricEffectParam.uplayColor = this.unPlayColor;
                    lyricEffectParam.highlightColor = this.mHighLightTextColor;
                    lyricEffectParam.colorCutPoint = f3 / 100.0f;
                } else {
                    this.lastWordIndex = i2;
                }
                lyricEffectParam.scaleY = keyFrame.endPointF.y / 100.0f;
                lyricEffectParam.scaleX = keyFrame.endPointF.x / 100.0f;
                lyricEffectParam.transY = (-keyFrame2.endY) / 26.0f;
            }
            arrayList.add(lyricEffectParam);
        }
        this.mGLTextureView.queueEvent(new Runnable() { // from class: com.kugou.framework.lyricanim.SingleLyricCell.8
            @Override // java.lang.Runnable
            public void run() {
                SingleLyricCell.this.setGLAlign();
                SingleLyricCell.this.mLyricGLProcessor.setFirstParams(arrayList);
                SingleLyricCell.this.mLyricGLProcessor.update(i2, i3, strArr);
                SingleLyricCell.this.mLyricGLProcessor.setAnimIndex(SingleLyricCell.this.loadBounceResFlag ? 0 : -1);
                SingleLyricCell.this.mLyricGLProcessor.setTextZoom(f2);
            }
        });
        this.mGLTextureView.requestRender();
    }

    public void updateCellHeight(int i2) {
        setLayoutParams(new FrameLayout.LayoutParams(-1, i2));
    }

    public void updateInitParams(String[] strArr, final float f2) {
        if (strArr == null) {
            return;
        }
        final ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < strArr.length; i2++) {
            LyricEffectParam lyricEffectParam = new LyricEffectParam();
            lyricEffectParam.colorTint = true;
            lyricEffectParam.uplayColor = this.unPlayColor;
            lyricEffectParam.highlightColor = this.mHighLightTextColor;
            lyricEffectParam.colorCutPoint = 0.0f;
            lyricEffectParam.scaleY = 1.0f;
            lyricEffectParam.scaleX = 1.0f;
            arrayList.add(lyricEffectParam);
        }
        this.mGLTextureView.queueEvent(new Runnable() { // from class: com.kugou.framework.lyricanim.SingleLyricCell.9
            @Override // java.lang.Runnable
            public void run() {
                SingleLyricCell.this.setGLAlign();
                SingleLyricCell.this.mLyricGLProcessor.setFirstParams(arrayList);
                SingleLyricCell.this.mLyricGLProcessor.setAnimIndex(-1);
                SingleLyricCell.this.mLyricGLProcessor.setTextZoom(f2);
            }
        });
        this.mGLTextureView.requestRender();
    }

    public void updateStringContent(final String[] strArr, final Paint paint, final int i2, final int i3) {
        this.mGLTextureView.queueEvent(new Runnable() { // from class: com.kugou.framework.lyricanim.SingleLyricCell.7
            @Override // java.lang.Runnable
            public void run() {
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                if (strArr == null) {
                    return;
                }
                int i4 = 0;
                while (true) {
                    String[] strArr2 = strArr;
                    if (i4 >= strArr2.length) {
                        SingleLyricCell.this.mLyricGLProcessor.setTextBitmaps(arrayList, (List) null);
                        SingleLyricCell.this.setGLAlign();
                        SingleLyricCell.this.mLyricGLProcessor.setFirstParams(arrayList2);
                        SingleLyricCell.this.mLyricGLProcessor.update(i2, i3, strArr);
                        return;
                    }
                    arrayList.add(TextBitmapUtils.convertString2Bitmap(strArr2[i4], paint, SingleLyricCell.this.mAdjustSpecialTypeface));
                    LyricEffectParam lyricEffectParam = new LyricEffectParam();
                    lyricEffectParam.colorTint = true;
                    lyricEffectParam.uplayColor = SingleLyricCell.this.unPlayColor;
                    lyricEffectParam.highlightColor = SingleLyricCell.this.mHighLightTextColor;
                    lyricEffectParam.colorCutPoint = 1.0f;
                    arrayList2.add(lyricEffectParam);
                    i4++;
                }
            }
        });
        this.mGLTextureView.requestRender();
    }

    public SingleLyricCell(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SingleLyricCell(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.fadeOutDuration = 1000.0f;
        this.normalJumpDuration = 2000.0f;
        this.mHighLightTextColor = -65536;
        this.mAnimSize = 0.2f;
        this.mTextSize = 0.24f;
        this.mTextTopMargin = 0.5f;
        this.lastWordIndex = -1;
        this.mTextAnimType = 0;
        this.surfaceCreated = false;
        this.firstWordSpecial = false;
        this.mRecordInterval = 3;
        this.mLyricRecordQueue = new LinkedList();
        this.mAdjustSpecialTypeface = false;
        this.unPlayColor = -1;
        this.loadBounceResFlag = false;
        this.newLine = false;
        this.align = 0;
        GLTextureView gLTextureView = new GLTextureView(getContext());
        this.mGLTextureView = gLTextureView;
        gLTextureView.setAlpha(0.99f);
        addView(this.mGLTextureView);
        this.mGLTextureView.setReleaseWhenDetached(true);
        this.mLyricGLProcessor = new AnimatedLyricsGLProcessor(context);
        this.mGLTextureView.post(new Runnable() { // from class: com.kugou.framework.lyricanim.SingleLyricCell.1
            @Override // java.lang.Runnable
            public void run() {
                SingleLyricCell singleLyricCell = SingleLyricCell.this;
                singleLyricCell.calculatePosition(singleLyricCell.getWidth(), SingleLyricCell.this.getHeight());
            }
        });
        this.mNormalJumpTopPositionAbove = Utils.dip2px(context, 9.0f);
        this.mExitJumpTopPositionAbove = Utils.dip2px(context, 9.0f);
        this.mEndOfLineXTranslate = Utils.dip2px(context, 16.0f);
        this.mFontSize = 50;
        this.mAnimDpSize = Utils.dip2px(context, 22.0f);
        this.mLyricGLProcessor.setOnTextLayoutListener(new LyricsTextProgram.OnTextLayoutListener() { // from class: com.kugou.framework.lyricanim.SingleLyricCell.2
            public void onTextLayout(int i3, int i4, float[] fArr, String[] strArr, boolean z) {
                if (z) {
                    SingleLyricCell.this.mLyricRecordQueue.clear();
                    SingleLyricCell.this.newLine = true;
                }
                SingleLyricCell.this.positions = fArr;
                SingleLyricCell.this.words = strArr;
                if (SingleLyricCell.this.mTextAnimType != 0) {
                    return;
                }
                LyricRecord lyricRecord = new LyricRecord(i3, i4);
                if (SingleLyricCell.this.mLyricRecordQueue.size() == 40) {
                    SingleLyricCell.this.mLyricRecordQueue.remove(0);
                }
                SingleLyricCell.this.mLyricRecordQueue.add(lyricRecord);
            }
        });
        this.mLyricGLProcessor.setAnimationDrawStartListener(new AnimatedLyricsGLProcessor.OnAnimationDrawStartListener() { // from class: com.kugou.framework.lyricanim.SingleLyricCell.3
            public boolean onAnimDrawStart(int i3, int i4) {
                int size;
                if (SingleLyricCell.this.mLyricRecordQueue.isEmpty() || (size = (SingleLyricCell.this.mLyricRecordQueue.size() - 1) - (SingleLyricCell.this.mRecordInterval * i3)) < 0) {
                    return false;
                }
                LyricRecord lyricRecord = (LyricRecord) SingleLyricCell.this.mLyricRecordQueue.get(size);
                SingleLyricCell singleLyricCell = SingleLyricCell.this;
                singleLyricCell.drawAnimation(lyricRecord.wordIndex, lyricRecord.percent, singleLyricCell.positions, SingleLyricCell.this.words, i3);
                return true;
            }
        });
        this.mGLTextureView.setOutRenderer(this);
        this.mNormalMovin = BodyMovinComposition.parseFromJson(C.MOVE_ANIM_CONFIG);
        this.mFadeOutMovin = BodyMovinComposition.parseFromJson(C.FADE_OUT_ANIM_CONFIG);
        this.mBounceTextMovin = BodyMovinComposition.parseFromJson(C.BOUNCE_TEXT_ANIM_CONFIG);
        this.mZoomTextMovin = BodyMovinComposition.parseFromJson(C.ZOOM_TEXT_ANIM_CONFIG);
        this.mAnimBitmaps = new ArrayList();
        this.mParticleBitmaps = new ArrayList();
    }
}
