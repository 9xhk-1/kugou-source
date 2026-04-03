package com.kugou.uilib.widget.recyclerview.viewpager;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.core.internal.view.SupportMenu;
import com.kugou.uilib.R;
import com.kugou.uilib.utils.KGUISystemUtil;
import com.kugou.uilib.widget.layout.framelayout.KGUIFrameLayout;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class KGUISwipeTabView extends KGUIFrameLayout {
    private static float INDICATOR_INTERPOLATION_FACTOR = 1.0f;
    public static final int INDICATOR_WIDTH_V9 = KGUISystemUtil.dp2px(9.0f);
    private int currentUiType;
    private boolean isForbiddenSetBackground;
    private boolean isHScrollTab;
    private boolean isLastTabShow;
    private boolean isMsgCenterStyle;
    private boolean mAutoSetBg;
    private View mBottomLine;
    private boolean mBottomLineVisible;
    private int mCurrentSelected;
    private int mCutomHeight;
    private int mCutomWidth;
    private boolean mHideIndicator;
    public int mIndicatorColor;
    public int mIndicatorConerRadius;
    public int mIndicatorHeight;
    public int mIndicatorPaddingBottom;
    public int mIndicatorPaddingleft;
    public final Paint mIndicatorPaint;
    public final RectF mIndicatorRectF;
    private boolean mIndicatorVisible;
    public int mIndicatorWidth;
    public int mIndicatorWidthX;
    private boolean mIsDrag;
    private int mLastPosition;
    private int mLastSelectedPosition;
    private AccelerateInterpolator mLeftEdgeInterpolator;
    private DecelerateInterpolator mRightEdgeInterpolator;
    private GradientDrawable mSelectBgDrawable;
    public int mSelectedPosition;
    public float mSelectionOffset;
    private ValueAnimator mTabChangeAnimator;
    public final View.OnClickListener mTabClickListener;
    private LinearLayout mTabContent;
    public List<TabItemViewHolder> mTabItemList;
    public OnTabSelectedListener mTabSelectedListener;
    private boolean wrapWidth;

    public interface OnTabSelectedListener {
        void onTabSelected(int i2);
    }

    /* JADX INFO: loaded from: classes.dex */
    @Retention(RetentionPolicy.SOURCE)
    public @interface UITYPE {
        public static final int UI_TYPE_COLOR_BLOCK = 1;
        public static final int UI_TYPE_UNDERLINE = 0;
    }

    public KGUISwipeTabView(@NonNull Context context) {
        this(context, null, 0);
    }

    private void initView() {
        this.mTabContent = (LinearLayout) findViewById(R.id.tab_content);
        View viewFindViewById = findViewById(R.id.tab_bottom_line);
        this.mBottomLine = viewFindViewById;
        if (viewFindViewById != null) {
            viewFindViewById.setVisibility(this.mBottomLineVisible ? 0 : 8);
        }
        if (this.mCurrentSelected == -1) {
            setTabIndicatorVisible(false);
        }
        this.mLeftEdgeInterpolator = new AccelerateInterpolator(INDICATOR_INTERPOLATION_FACTOR);
        this.mRightEdgeInterpolator = new DecelerateInterpolator(INDICATOR_INTERPOLATION_FACTOR);
        this.mIndicatorHeight = KGUISystemUtil.dp2px(4.0f);
        this.mIndicatorConerRadius = KGUISystemUtil.dp2px(5.0f);
        this.mIndicatorWidthX = KGUISystemUtil.dp2px(9.0f);
        this.mIndicatorPaddingBottom = KGUISystemUtil.dp2px(3.0f);
    }

    private void startTabChangedAnimation() {
        if (this.mSelectBgDrawable == null) {
            return;
        }
        if (this.mTabChangeAnimator == null) {
            ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(0, 255);
            this.mTabChangeAnimator = valueAnimatorOfInt;
            valueAnimatorOfInt.setDuration(300L);
            this.mTabChangeAnimator.setInterpolator(new LinearInterpolator());
            this.mTabChangeAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kugou.uilib.widget.recyclerview.viewpager.KGUISwipeTabView.2
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    if (KGUISwipeTabView.this.mSelectBgDrawable != null) {
                        KGUISwipeTabView.this.mSelectBgDrawable.setAlpha(((Integer) valueAnimator.getAnimatedValue()).intValue());
                    }
                }
            });
            this.mTabChangeAnimator.addListener(new Animator.AnimatorListener() { // from class: com.kugou.uilib.widget.recyclerview.viewpager.KGUISwipeTabView.3
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    KGUISwipeTabView.this.mSelectBgDrawable.setAlpha(255);
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    KGUISwipeTabView.this.mSelectBgDrawable.setAlpha(0);
                }
            });
        }
        if (this.mTabChangeAnimator.isRunning()) {
            this.mTabChangeAnimator.cancel();
        }
        this.mTabChangeAnimator.start();
    }

    public float getLeftEdge(float f2) {
        return this.mLeftEdgeInterpolator.getInterpolation(f2);
    }

    public float getRightEdge(float f2) {
        return this.mRightEdgeInterpolator.getInterpolation(f2);
    }

    public int getTabIndicatorLeft(View view) {
        if (view == null) {
            return 0;
        }
        int width = view.getWidth();
        int iDp2px = this.mIndicatorWidthX;
        if (iDp2px == 0) {
            iDp2px = KGUISystemUtil.dp2px(INDICATOR_WIDTH_V9);
        }
        return view.getLeft() + ((width - iDp2px) / 2);
    }

    public int getTabIndicatorRight(View view) {
        if (view == null) {
            return 0;
        }
        int width = view.getWidth();
        int iDp2px = this.mIndicatorWidthX;
        if (iDp2px == 0) {
            iDp2px = KGUISystemUtil.dp2px(INDICATOR_WIDTH_V9);
        }
        return view.getRight() - ((width - iDp2px) / 2);
    }

    public GradientDrawable getmNormalBgDrawable() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(KGUISystemUtil.dp2px(45.0f));
        return gradientDrawable;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        int childCount;
        View childAt;
        float rightEdge;
        super.onDraw(canvas);
        if (this.mIndicatorVisible && this.currentUiType == 0 && !this.mHideIndicator && (childCount = this.mTabContent.getChildCount()) > 0 && (childAt = this.mTabContent.getChildAt(this.mSelectedPosition)) != null) {
            int tabIndicatorLeft = getTabIndicatorLeft(childAt);
            int tabIndicatorRight = getTabIndicatorRight(childAt);
            float leftEdge = this.mSelectionOffset;
            if (leftEdge > 0.0f && this.mSelectedPosition < childCount - 1) {
                if (this.mIsDrag) {
                    leftEdge = getLeftEdge(leftEdge);
                    rightEdge = getRightEdge(this.mSelectionOffset);
                } else {
                    rightEdge = leftEdge;
                }
                View childAt2 = this.mTabContent.getChildAt(this.mSelectedPosition + 1);
                tabIndicatorLeft = (int) ((getTabIndicatorLeft(childAt2) * leftEdge) + ((1.0f - leftEdge) * tabIndicatorLeft));
                tabIndicatorRight = (int) ((getTabIndicatorRight(childAt2) * rightEdge) + ((1.0f - rightEdge) * tabIndicatorRight));
            }
            this.mIndicatorPaint.setColor(this.mIndicatorColor);
            this.mIndicatorPaint.setStyle(Paint.Style.FILL);
            this.mIndicatorRectF.set(tabIndicatorLeft + this.mIndicatorPaddingleft, (getHeight() - this.mIndicatorPaddingBottom) - this.mIndicatorHeight, tabIndicatorRight + this.mIndicatorPaddingleft, getHeight() - this.mIndicatorPaddingBottom);
            RectF rectF = this.mIndicatorRectF;
            int i2 = this.mIndicatorConerRadius;
            canvas.drawRoundRect(rectF, i2, i2, this.mIndicatorPaint);
        }
    }

    public void onViewPagerPageChanged(int i2, float f2) {
        int i3;
        this.mSelectedPosition = i2;
        this.mSelectionOffset = f2;
        if (f2 == 0.0f && (i3 = this.mLastPosition) != i2) {
            this.mLastSelectedPosition = i3;
            this.mLastPosition = i2;
            startTabChangedAnimation();
        }
        invalidate();
    }

    public void resetIndicatorStyle() {
    }

    public void setCurrentItem(int i2) {
        boolean z = this.currentUiType == 1 && this.mLastSelectedPosition != i2;
        this.mCurrentSelected = i2;
        this.mLastPosition = i2;
        this.mLastSelectedPosition = i2;
        Iterator<TabItemViewHolder> it = this.mTabItemList.iterator();
        while (it.hasNext()) {
            it.next().onSelectedChange(false);
        }
        this.mTabItemList.get(i2).onSelectedChange(true);
        if (z) {
            startTabChangedAnimation();
        }
    }

    public void setHideIndicator(boolean z) {
        this.mHideIndicator = z;
    }

    public void setOnTabSelectedListener(OnTabSelectedListener onTabSelectedListener) {
        this.mTabSelectedListener = onTabSelectedListener;
    }

    public void setTabIndicatorVisible(boolean z) {
        this.mIndicatorVisible = z;
    }

    public <T extends TabItemViewHolder> void setTabTitles(Class<T> cls, @StringRes int... iArr) {
        if (iArr == null || iArr.length <= 0) {
            return;
        }
        this.mTabItemList.clear();
        for (int i2 = 0; i2 < iArr.length; i2++) {
            String string = getContext().getString(iArr[i2]);
            try {
                T tNewInstance = cls.getConstructor(Context.class, String.class).newInstance(getContext(), string);
                View itemView = tNewInstance.getItemView();
                itemView.setOnClickListener(this.mTabClickListener);
                itemView.setTag(Integer.valueOf(i2));
                if (this.currentUiType == 1) {
                    tNewInstance.getTitleView().setTextSize(0, KGUISystemUtil.dp2px(13.0f));
                    tNewInstance.getTitleView().setPadding(KGUISystemUtil.dp2px(9.0f), KGUISystemUtil.dp2px(3.0f), KGUISystemUtil.dp2px(9.0f), KGUISystemUtil.dp2px(4.0f));
                    tNewInstance.getTitleView().setBackgroundDrawable(getmNormalBgDrawable());
                }
                int iMax = Math.max(itemView.getMeasuredWidth(), this.mCutomWidth);
                int i3 = -1;
                if (this.mCutomWidth > 0) {
                    if (this.currentUiType == 1) {
                        int iMeasureText = ((int) tNewInstance.getTitleView().getPaint().measureText(string)) + KGUISystemUtil.dp2px(26.0f);
                        LinearLayout linearLayout = this.mTabContent;
                        int i4 = this.mCutomHeight;
                        if (i4 != 0) {
                            i3 = i4;
                        }
                        linearLayout.addView(itemView, new LinearLayout.LayoutParams(iMeasureText, i3));
                    } else {
                        LinearLayout linearLayout2 = this.mTabContent;
                        int i5 = this.mCutomHeight;
                        if (i5 != 0) {
                            i3 = i5;
                        }
                        linearLayout2.addView(itemView, new LinearLayout.LayoutParams(iMax, i3));
                    }
                } else if (this.isHScrollTab) {
                    LinearLayout linearLayout3 = this.mTabContent;
                    int i6 = this.mCutomHeight;
                    if (i6 != 0) {
                        i3 = i6;
                    }
                    linearLayout3.addView(itemView, new LinearLayout.LayoutParams(-2, i3));
                } else if (this.isLastTabShow) {
                    LinearLayout linearLayout4 = this.mTabContent;
                    int i7 = this.mCutomHeight;
                    if (i7 != 0) {
                        i3 = i7;
                    }
                    linearLayout4.addView(itemView, new LinearLayout.LayoutParams(-2, i3));
                } else if (this.wrapWidth) {
                    LinearLayout linearLayout5 = this.mTabContent;
                    int i8 = this.mCutomHeight;
                    if (i8 != 0) {
                        i3 = i8;
                    }
                    linearLayout5.addView(itemView, new LinearLayout.LayoutParams(-2, i3));
                } else {
                    LinearLayout linearLayout6 = this.mTabContent;
                    int i9 = this.mCutomHeight;
                    if (i9 != 0) {
                        i3 = i9;
                    }
                    linearLayout6.addView(itemView, new LinearLayout.LayoutParams(0, i3, 1.0f));
                }
                this.mTabItemList.add(tNewInstance);
            } catch (Exception e2) {
                e2.printStackTrace();
                throw new IllegalArgumentException("创建tab item失败请检查");
            }
        }
    }

    public void updateIndicatorByCoordinate(int i2, float f2, int i3) {
        updateIndicatorByCoordinate(i2, f2, i3, false);
    }

    public KGUISwipeTabView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void updateIndicatorByCoordinate(int i2, float f2, int i3, boolean z) {
        if (this.mTabItemList.size() > 0) {
            onViewPagerPageChanged(i2, f2);
        }
    }

    public KGUISwipeTabView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.currentUiType = 0;
        this.mIndicatorVisible = true;
        this.mTabItemList = new ArrayList();
        this.mIndicatorRectF = new RectF();
        this.mIndicatorPaint = new Paint(1);
        this.mIndicatorColor = SupportMenu.CATEGORY_MASK;
        this.mTabClickListener = new View.OnClickListener() { // from class: com.kugou.uilib.widget.recyclerview.viewpager.KGUISwipeTabView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (KGUISwipeTabView.this.isEnabled()) {
                    KGUISwipeTabView kGUISwipeTabView = KGUISwipeTabView.this;
                    kGUISwipeTabView.mLastSelectedPosition = kGUISwipeTabView.mCurrentSelected;
                    KGUISwipeTabView.this.mCurrentSelected = ((Integer) view.getTag()).intValue();
                    KGUISwipeTabView kGUISwipeTabView2 = KGUISwipeTabView.this;
                    OnTabSelectedListener onTabSelectedListener = kGUISwipeTabView2.mTabSelectedListener;
                    if (onTabSelectedListener != null) {
                        onTabSelectedListener.onTabSelected(kGUISwipeTabView2.mCurrentSelected);
                    }
                    for (TabItemViewHolder tabItemViewHolder : KGUISwipeTabView.this.mTabItemList) {
                        tabItemViewHolder.onSelectedChange(tabItemViewHolder.getItemView() == view);
                    }
                }
            }
        };
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.KGUISwipeTabView);
        if (typedArrayObtainStyledAttributes != null) {
            this.mCurrentSelected = typedArrayObtainStyledAttributes.getInt(R.styleable.KGUISwipeTabView_kgui_stv_default_item, 0);
            this.mBottomLineVisible = typedArrayObtainStyledAttributes.getBoolean(R.styleable.KGUISwipeTabView_kgui_bottom_line_visibility, true);
            this.mAutoSetBg = typedArrayObtainStyledAttributes.getBoolean(R.styleable.KGUISwipeTabView_kgui_auto_set_bg, true);
            this.mIsDrag = typedArrayObtainStyledAttributes.getBoolean(R.styleable.KGUISwipeTabView_kgui_drag_indicator, false);
            this.isForbiddenSetBackground = typedArrayObtainStyledAttributes.getBoolean(R.styleable.KGUISwipeTabView_kgui_forbidden_set_bg, false);
            this.isMsgCenterStyle = typedArrayObtainStyledAttributes.getBoolean(R.styleable.KGUISwipeTabView_kgui_is_msgcenter_style, false);
            LayoutInflater.from(getContext()).inflate(typedArrayObtainStyledAttributes.getResourceId(R.styleable.KGUISwipeTabView_kgui_main_layout, R.layout.kgui_common_swipe_tabview_layout), this);
            typedArrayObtainStyledAttributes.recycle();
        }
        initView();
        setWillNotDraw(false);
    }
}
