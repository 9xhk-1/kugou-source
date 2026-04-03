package com.kugou.uilib.widget.textview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.Choreographer;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.kugou.uilib.R;
import com.kugou.uilib.utils.KGUILog;

/* JADX INFO: loaded from: classes2.dex */
public class KGUIMarqueeTextView3 extends HorizontalScrollView implements Runnable {
    public boolean addedSpace;
    private boolean autoStart;
    public int currentScrollX;
    private String defaultText;
    private int delayTime;
    private int dx;
    private boolean forceStopMarquee;
    private boolean includeFontPadding;
    private View inflatedView;
    public long lastFramTime;
    private Choreographer mChoreographer;
    private CharSequence mCurrentText;
    private OnMarqueeListener mOnMarqueeListener;
    private Choreographer.FrameCallback mRestartCallback;
    private boolean mUseFrameAnimation;
    private boolean mUseSettedMaxWidth;
    private int maxAvailableWidth;
    private float maxFontScale;
    private Runnable startJudgeMarqueeDelayedRunnable;
    private int state;
    private int textColor;
    private float textSizePx;
    public KGUITextView tv;
    public KGUITextView tv2;
    public KGUITextView tv3;
    public KGUITextView tv4;

    public static class MySavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<MySavedState> CREATOR = new Parcelable.Creator<MySavedState>() { // from class: com.kugou.uilib.widget.textview.KGUIMarqueeTextView3.MySavedState.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public MySavedState createFromParcel(Parcel parcel) {
                return new MySavedState(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public MySavedState[] newArray(int i2) {
                return new MySavedState[i2];
            }
        };
        public boolean addedSpace;
        public int delayTime;
        public boolean includeFontPadding;
        public CharSequence mCurrentText;
        public int textColor;

        public MySavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            return "MySavedState{delayTime=" + this.delayTime + ", textColor=" + this.textColor + ", mCurrentText='" + ((Object) this.mCurrentText) + "', includeFontPadding=" + this.includeFontPadding + ", addedSpace=" + this.addedSpace + '}';
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.delayTime);
            parcel.writeInt(this.textColor);
            parcel.writeInt(this.includeFontPadding ? 1 : 0);
            parcel.writeInt(this.addedSpace ? 1 : 0);
            TextUtils.writeToParcel(this.mCurrentText, parcel, i2);
        }

        public MySavedState(Parcel parcel) {
            super(parcel);
            this.delayTime = parcel.readInt();
            this.textColor = parcel.readInt();
            this.includeFontPadding = parcel.readInt() == 1;
            this.addedSpace = parcel.readInt() == 1;
            this.mCurrentText = ((CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel)).toString();
        }
    }

    public interface OnMarqueeListener {
        void endMarquee(View view);

        void startMarquee(boolean z);
    }

    public KGUIMarqueeTextView3(Context context) {
        this(context, null);
    }

    private boolean getIsIfCanMarquee() {
        return getTv1MaxWidth() - ((float) getReducedSpaceWidth()) > ((float) this.maxAvailableWidth);
    }

    private int getReducedSpaceWidth() {
        CharSequence charSequence = this.mCurrentText;
        if (charSequence == null || TextUtils.isEmpty(charSequence.toString()) || this.mCurrentText.length() < 2) {
            return 0;
        }
        if (this.addedSpace && (this.mCurrentText.toString().endsWith(Character.toString((char) 12288)) || this.mCurrentText.toString().endsWith(" "))) {
            return (int) this.tv.getPaint().measureText(this.mCurrentText.toString().substring(this.mCurrentText.length() - 1, this.mCurrentText.length()));
        }
        return 0;
    }

    private float getTv1MaxWidth() {
        return this.tv.getPaint().measureText(this.tv.getText().toString());
    }

    private void init(Context context, AttributeSet attributeSet) {
        float dimension = 20.0f;
        if (context == null || attributeSet == null) {
            this.delayTime = 3000;
        } else {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.KGUIMarqueeTextView3);
            this.delayTime = typedArrayObtainStyledAttributes.getInt(R.styleable.KGUIMarqueeTextView3_kgui_start_marquee_delay_time, 3000);
            this.maxFontScale = typedArrayObtainStyledAttributes.getFloat(R.styleable.KGUIMarqueeTextView3_kgui_max_font_scale, -1.0f);
            int color = typedArrayObtainStyledAttributes.getColor(R.styleable.KGUIMarqueeTextView3_kgui_textcolor, 0);
            dimension = typedArrayObtainStyledAttributes.getDimension(R.styleable.KGUIMarqueeTextView3_kgui_textsize, 20.0f);
            this.textColor = color;
            this.defaultText = typedArrayObtainStyledAttributes.getString(R.styleable.KGUIMarqueeTextView3_kgui_default_text);
            int i2 = R.styleable.KGUIMarqueeTextView3_kgui_includeFontPadding;
            this.includeFontPadding = typedArrayObtainStyledAttributes.getBoolean(i2, true);
            this.addedSpace = typedArrayObtainStyledAttributes.getBoolean(i2, false);
            typedArrayObtainStyledAttributes.recycle();
        }
        View viewInflate = LayoutInflater.from(context).inflate(R.layout.kg_marquee_text_view, (ViewGroup) null);
        this.inflatedView = viewInflate;
        addView(viewInflate);
        this.tv = (KGUITextView) this.inflatedView.findViewById(R.id.tv_text);
        this.tv2 = (KGUITextView) this.inflatedView.findViewById(R.id.tv_text2);
        this.tv3 = (KGUITextView) this.inflatedView.findViewById(R.id.tv_text3);
        this.tv4 = (KGUITextView) this.inflatedView.findViewById(R.id.tv_text4);
        this.mUseSettedMaxWidth = false;
        boolean z = Build.VERSION.SDK_INT >= 16;
        this.mUseFrameAnimation = z;
        if (z) {
            this.mRestartCallback = new Choreographer.FrameCallback() { // from class: com.kugou.uilib.widget.textview.KGUIMarqueeTextView3.2
                @Override // android.view.Choreographer.FrameCallback
                public void doFrame(long j) {
                    KGUIMarqueeTextView3.this.run();
                }
            };
        }
        this.dx = 1;
        if (this.defaultText == null) {
            this.defaultText = "";
        }
        this.mCurrentText = this.defaultText;
        float f2 = getResources().getConfiguration().fontScale;
        float f3 = this.maxFontScale;
        if (f3 > 0.0f && f2 > f3) {
            dimension = (dimension * f3) / f2;
        }
        this.textSizePx = dimension;
        reflashViewAllState();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void judgeCanMarquee() {
        if (this.state != 0 || this.maxAvailableWidth <= 0) {
            return;
        }
        if (getIsIfCanMarquee()) {
            OnMarqueeListener onMarqueeListener = this.mOnMarqueeListener;
            if (onMarqueeListener != null) {
                onMarqueeListener.startMarquee(true);
            }
            startMArquee();
            return;
        }
        OnMarqueeListener onMarqueeListener2 = this.mOnMarqueeListener;
        if (onMarqueeListener2 != null) {
            onMarqueeListener2.startMarquee(false);
        }
    }

    private String kGTrim(String str) {
        if (str == null) {
            return null;
        }
        if (str.endsWith(Character.toString((char) 12288)) || str.endsWith(" ")) {
            return str.substring(0, str.length() - 1);
        }
        return null;
    }

    private void reflashViewAllState() {
        setTextSize(this.textSizePx);
        setTextColor(this.textColor);
        setTextIncludeFontPadding(this.includeFontPadding);
        updateTvsText(this.mCurrentText);
        resetOtherViews();
    }

    private void resetMarqueeState() {
        this.state = 0;
        this.currentScrollX = 0;
        scrollTo(0, 0);
    }

    private void resetOtherViews() {
        if (this.tv2.getVisibility() != 8) {
            ((LinearLayout.LayoutParams) this.tv.getLayoutParams()).rightMargin = 0;
            this.tv2.setVisibility(8);
            this.tv3.setVisibility(8);
            this.tv4.setVisibility(8);
            this.tv.requestLayout();
        }
    }

    private void setTextReal(CharSequence charSequence) {
        removeCallbacks(this.startJudgeMarqueeDelayedRunnable);
        resetMarqueeState();
        resetOtherViews();
        updateTvsText(charSequence);
        setTv1NormalState();
        if (this.autoStart) {
            postDelayed(this.startJudgeMarqueeDelayedRunnable, this.delayTime);
        }
    }

    private void startMArquee() {
        this.state = 1;
        removeCallbacks(this);
        this.tv.getLayoutParams().width = -2;
        this.tv.setEllipsize(null);
        this.tv.invalidate();
        this.tv2.setText(this.mCurrentText);
        this.tv3.setText(this.mCurrentText);
        this.tv4.setText(this.mCurrentText);
        setViewVisible(0, this.tv2, this.tv3, this.tv4);
        this.tv.requestLayout();
        postDelayed(this, 1000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopMarquee() {
        removeCallbacks(this);
        resetOtherViews();
        scrollTo(0, 0);
        this.currentScrollX = 0;
        setTv1NormalState();
        this.state = 4;
        OnMarqueeListener onMarqueeListener = this.mOnMarqueeListener;
        if (onMarqueeListener != null) {
            onMarqueeListener.endMarquee(this);
        }
    }

    private void updateSpaceSize() {
        int i2 = this.maxAvailableWidth;
        if (i2 > 0) {
            this.state = 2;
            int i3 = i2 / 3;
            ((LinearLayout.LayoutParams) this.tv.getLayoutParams()).rightMargin = i3;
            ((LinearLayout.LayoutParams) this.tv2.getLayoutParams()).rightMargin = i3;
            ((LinearLayout.LayoutParams) this.tv3.getLayoutParams()).rightMargin = i3;
            this.tv.requestLayout();
        }
    }

    private void updateTvsText(CharSequence charSequence) {
        this.mCurrentText = charSequence;
        this.tv.setText(charSequence);
        this.tv2.setText(charSequence);
        this.tv3.setText(charSequence);
        this.tv4.setText(charSequence);
    }

    public TextView getADemoTV() {
        return this.tv;
    }

    public String getText() {
        if (this.mCurrentText == null) {
            this.mCurrentText = "";
        }
        return this.mCurrentText.toString();
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        if (!this.mUseSettedMaxWidth || this.maxAvailableWidth <= 0) {
            this.maxAvailableWidth = View.MeasureSpec.getSize(i2);
        }
        if (this.mUseSettedMaxWidth) {
            int size = View.MeasureSpec.getSize(i2);
            int i4 = this.maxAvailableWidth;
            if (size > i4) {
                i2 = View.MeasureSpec.makeMeasureSpec(i4, View.MeasureSpec.getMode(i2));
            }
        }
        super.onMeasure(i2, i3);
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        MySavedState mySavedState = (MySavedState) parcelable;
        super.onRestoreInstanceState(mySavedState.getSuperState());
        this.delayTime = mySavedState.delayTime;
        this.mCurrentText = mySavedState.mCurrentText;
        this.textColor = mySavedState.textColor;
        this.includeFontPadding = mySavedState.includeFontPadding;
        this.addedSpace = mySavedState.addedSpace;
        reflashViewAllState();
        postDelayed(new Runnable() { // from class: com.kugou.uilib.widget.textview.KGUIMarqueeTextView3.3
            @Override // java.lang.Runnable
            public void run() {
                KGUIMarqueeTextView3.this.stopMarquee();
            }
        }, 200L);
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public Parcelable onSaveInstanceState() {
        MySavedState mySavedState = new MySavedState(super.onSaveInstanceState());
        mySavedState.delayTime = this.delayTime;
        mySavedState.mCurrentText = this.mCurrentText;
        mySavedState.textColor = this.textColor;
        mySavedState.includeFontPadding = this.includeFontPadding;
        mySavedState.addedSpace = this.addedSpace;
        return mySavedState;
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    @Override // android.view.View
    public void onVisibilityChanged(View view, int i2) {
        super.onVisibilityChanged(view, i2);
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i2) {
        super.onWindowVisibilityChanged(i2);
    }

    public void release() {
        Choreographer.FrameCallback frameCallback;
        removeCallbacks(this.startJudgeMarqueeDelayedRunnable);
        Choreographer choreographer = this.mChoreographer;
        if (choreographer == null || (frameCallback = this.mRestartCallback) == null) {
            return;
        }
        choreographer.removeFrameCallback(frameCallback);
    }

    @Override // java.lang.Runnable
    @SuppressLint({"NewApi"})
    public void run() {
        int i2 = this.state;
        if (i2 == 1 || i2 == 2) {
            int i3 = this.currentScrollX + this.dx;
            this.currentScrollX = i3;
            scrollTo(i3, 0);
            if (this.state == 1) {
                updateSpaceSize();
            }
            if (this.currentScrollX >= (getTv1MaxWidth() * 3.0f) + this.maxAvailableWidth) {
                stopMarquee();
            } else if (this.forceStopMarquee) {
                this.forceStopMarquee = false;
                stopMarquee();
            }
        }
        int i4 = this.state;
        if (i4 == 1 || i4 == 2) {
            if (!this.mUseFrameAnimation) {
                postDelayed(this, 40L);
                return;
            }
            if (this.mChoreographer == null) {
                this.mChoreographer = Choreographer.getInstance();
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            long j = this.lastFramTime;
            if (jCurrentTimeMillis - j >= 30 || jCurrentTimeMillis - j <= 0) {
                this.mChoreographer.postFrameCallback(this.mRestartCallback);
            } else {
                this.mChoreographer.postFrameCallbackDelayed(this.mRestartCallback, 35 - (jCurrentTimeMillis - j));
                this.lastFramTime = System.currentTimeMillis();
            }
        }
    }

    public void setAutoStart(boolean z) {
        this.autoStart = z;
    }

    public void setFakeBoldText(boolean z) {
        this.tv.getPaint().setFakeBoldText(z);
        this.tv2.getPaint().setFakeBoldText(z);
        this.tv3.getPaint().setFakeBoldText(z);
        this.tv4.getPaint().setFakeBoldText(z);
    }

    public void setMaxWidth(int i2) {
        if (i2 <= 0) {
            if (KGUILog.DEBUG) {
                KGUILog.e("torahlog KGMarqueeTextView3", "setMaxWidth -- maxWidth:" + i2);
                return;
            }
            return;
        }
        this.maxAvailableWidth = i2;
        this.mUseSettedMaxWidth = true;
        invalidate();
        requestLayout();
        int i3 = this.state;
        if (i3 == 0) {
            setTextReal(this.mCurrentText);
            return;
        }
        if (i3 == 4) {
            setTv1NormalState();
            return;
        }
        if (i3 == 1 || i3 == 2) {
            this.state = 1;
            if (getIsIfCanMarquee()) {
                return;
            }
            this.forceStopMarquee = true;
        }
    }

    public void setOnMarqueeListener(OnMarqueeListener onMarqueeListener) {
        this.mOnMarqueeListener = onMarqueeListener;
    }

    public void setShadowLayer(float f2, float f3, float f4, int i2) {
        this.tv.setShadowLayer(f2, f3, f4, i2);
        this.tv2.setShadowLayer(f2, f3, f4, i2);
        this.tv3.setShadowLayer(f2, f3, f4, i2);
        this.tv4.setShadowLayer(f2, f3, f4, i2);
    }

    public void setText(int i2) {
        setText(getContext().getResources().getString(i2));
    }

    public void setTextColor(int i2) {
        this.textColor = i2;
        this.tv.setTextColor(i2);
        this.tv2.setTextColor(i2);
        this.tv3.setTextColor(i2);
        this.tv4.setTextColor(i2);
    }

    public void setTextIncludeFontPadding(boolean z) {
        this.tv.setIncludeFontPadding(z);
        this.tv2.setIncludeFontPadding(z);
        this.tv3.setIncludeFontPadding(z);
        this.tv4.setIncludeFontPadding(z);
    }

    public void setTextSize(float f2) {
        this.textSizePx = f2;
        this.tv.setTextSize(0, f2);
        this.tv2.setTextSize(0, this.textSizePx);
        this.tv3.setTextSize(0, this.textSizePx);
        this.tv4.setTextSize(0, this.textSizePx);
    }

    public void setTv1NormalState() {
        if (this.maxAvailableWidth <= 0 || !getIsIfCanMarquee()) {
            this.tv.getLayoutParams().width = -2;
            this.tv.invalidate();
            this.tv.requestLayout();
        } else {
            this.tv.getLayoutParams().width = this.maxAvailableWidth;
            this.tv.setEllipsize(TextUtils.TruncateAt.END);
            this.tv.invalidate();
            this.tv.requestLayout();
        }
    }

    public void setTypeface(Typeface typeface) {
        this.tv.setTypeface(typeface);
        this.tv2.setTypeface(typeface);
        this.tv3.setTypeface(typeface);
        this.tv4.setTypeface(typeface);
    }

    public void setViewVisible(int i2, View... viewArr) {
        for (View view : viewArr) {
            view.setVisibility(i2);
        }
    }

    public void startDoMarquee() {
        if (this.state == 4) {
            resetMarqueeState();
            resetOtherViews();
            updateTvsText(getText());
            setTv1NormalState();
        }
        if (this.state == 0) {
            postDelayed(this.startJudgeMarqueeDelayedRunnable, this.delayTime);
        }
    }

    public void stopDoMarquee() {
        removeCallbacks(this.startJudgeMarqueeDelayedRunnable);
        if (this.state != 0) {
            resetMarqueeState();
            resetOtherViews();
            updateTvsText(getText());
            setTv1NormalState();
        }
    }

    public KGUIMarqueeTextView3(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void setText(CharSequence charSequence) {
        CharSequence charSequence2 = this.mCurrentText;
        if (charSequence2 == null || charSequence == null || !charSequence2.equals(charSequence)) {
            setTextReal(charSequence);
        }
    }

    public KGUIMarqueeTextView3(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.currentScrollX = 0;
        this.forceStopMarquee = false;
        this.startJudgeMarqueeDelayedRunnable = new Runnable() { // from class: com.kugou.uilib.widget.textview.KGUIMarqueeTextView3.1
            @Override // java.lang.Runnable
            public void run() {
                KGUIMarqueeTextView3.this.judgeCanMarquee();
            }
        };
        this.autoStart = true;
        init(context, attributeSet);
    }
}
