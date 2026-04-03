package com.kugou.uilib.widget.popupwindow;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.transition.Transition;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.PopupWindow;
import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import androidx.annotation.IdRes;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.StyleRes;
import androidx.core.widget.PopupWindowCompat;
import com.kugou.uilib.widget.popupwindow.BasePopup;

/* JADX INFO: loaded from: classes2.dex */
public abstract class BasePopup<T extends BasePopup> implements PopupWindow.OnDismissListener {
    private static final float DEFAULT_DIM = 0.7f;
    private static final String TAG = "EasyPopup";
    private ColorDrawable backgroundDrawable;
    public SparseArray<View.OnClickListener> contentViewIds;
    private boolean isBackgroundDim;
    public View mAnchorView;
    private int mAnimationStyle;
    private View mContentView;
    public Context mContext;

    @NonNull
    private ViewGroup mDimView;
    private Transition mEnterTransition;
    private Transition mExitTransition;
    private int mLayoutId;
    private int mOffsetX;
    private int mOffsetY;
    private PopupWindow.OnDismissListener mOnDismissListener;
    private OnRealWHAlreadyListener mOnRealWHAlreadyListener;
    private OnViewListener<T> mOnViewListener;
    private PopupWindow mPopupWindow;
    private boolean mFocusable = true;
    private boolean mOutsideTouchable = true;
    private boolean mClippingEnabled = false;
    public int mWidth = -2;
    public int mHeight = -2;
    private float mDimValue = DEFAULT_DIM;

    @ColorInt
    private int mDimColor = -16777216;
    private boolean mFocusAndOutsideEnable = true;
    public int mYGravity = 2;
    public int mXGravity = 1;
    private int mInputMethodMode = 0;
    private int mSoftInputMode = 1;
    private boolean isNeedReMeasureWH = false;
    private boolean isRealWHAlready = false;
    private boolean isAtAnchorViewMethod = false;

    public interface OnRealWHAlreadyListener {
        void onRealWHAlready(BasePopup basePopup, int i2, int i3, int i4, int i5);
    }

    public interface OnViewListener<T> {
        void initViews(View view, T t);
    }

    @RequiresApi(api = 18)
    private void applyDim(Activity activity) {
        ViewGroup viewGroup = (ViewGroup) activity.getWindow().getDecorView().getRootView();
        ColorDrawable colorDrawable = new ColorDrawable(this.mDimColor);
        colorDrawable.setBounds(0, 0, viewGroup.getWidth(), viewGroup.getHeight());
        colorDrawable.setAlpha((int) (this.mDimValue * 255.0f));
        viewGroup.getOverlay().add(colorDrawable);
    }

    private int calculateX(View view, int i2, int i3, int i4) {
        int width;
        if (i2 != 0) {
            if (i2 != 1) {
                if (i2 == 2) {
                    width = view.getWidth();
                } else {
                    if (i2 != 4) {
                        return i4;
                    }
                    i3 -= view.getWidth();
                }
            }
            return i4 - i3;
        }
        width = (view.getWidth() / 2) - (i3 / 2);
        return i4 + width;
    }

    private int calculateY(View view, int i2, int i3, int i4) {
        int height;
        if (i2 != 0) {
            if (i2 == 1) {
                i3 += view.getHeight();
            } else if (i2 == 3) {
                height = view.getHeight();
            } else if (i2 != 4) {
                return i4;
            }
            return i4 - i3;
        }
        height = (view.getHeight() / 2) + (i3 / 2);
        return i4 - height;
    }

    private void checkIsApply(boolean z) {
        if (this.isAtAnchorViewMethod != z) {
            this.isAtAnchorViewMethod = z;
        }
        if (this.mPopupWindow == null) {
            apply();
        }
    }

    private void clearBackgroundDim() {
        Activity activity;
        if (Build.VERSION.SDK_INT < 18 || !this.isBackgroundDim) {
            return;
        }
        ViewGroup viewGroup = this.mDimView;
        if (viewGroup != null) {
            clearDim(viewGroup);
        } else {
            if (getContentView() == null || (activity = (Activity) getContentView().getContext()) == null) {
                return;
            }
            clearDim(activity);
        }
    }

    @RequiresApi(api = 18)
    private void clearDim(Activity activity) {
        ((ViewGroup) activity.getWindow().getDecorView().getRootView()).getOverlay().clear();
    }

    private void handleBackgroundDim() {
        if (Build.VERSION.SDK_INT < 18 || !this.isBackgroundDim) {
            return;
        }
        ViewGroup viewGroup = this.mDimView;
        if (viewGroup != null) {
            applyDim(viewGroup);
        } else {
            if (getContentView() == null || getContentView().getContext() == null || !(getContentView().getContext() instanceof Activity)) {
                return;
            }
            applyDim((Activity) getContentView().getContext());
        }
    }

    private void handleDismiss() {
        PopupWindow.OnDismissListener onDismissListener = this.mOnDismissListener;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
        }
        clearBackgroundDim();
        PopupWindow popupWindow = this.mPopupWindow;
        if (popupWindow != null && popupWindow.isShowing()) {
            this.mPopupWindow.dismiss();
        }
        onPopupWindowDismiss();
    }

    private void initContentViewAndWH() {
    }

    private void initFocusAndBack() {
        if (this.mFocusAndOutsideEnable) {
            this.mPopupWindow.setFocusable(this.mFocusable);
            this.mPopupWindow.setOutsideTouchable(this.mOutsideTouchable);
            this.mPopupWindow.setBackgroundDrawable(new ColorDrawable(0));
            return;
        }
        this.mPopupWindow.setFocusable(true);
        this.mPopupWindow.setOutsideTouchable(false);
        this.mPopupWindow.setBackgroundDrawable(null);
        this.mPopupWindow.getContentView().setFocusable(true);
        this.mPopupWindow.getContentView().setFocusableInTouchMode(true);
        this.mPopupWindow.getContentView().setOnKeyListener(new View.OnKeyListener() { // from class: com.kugou.uilib.widget.popupwindow.BasePopup.1
            @Override // android.view.View.OnKeyListener
            public boolean onKey(View view, int i2, KeyEvent keyEvent) {
                if (i2 != 4) {
                    return false;
                }
                BasePopup.this.mPopupWindow.dismiss();
                return true;
            }
        });
        this.mPopupWindow.setTouchInterceptor(new View.OnTouchListener() { // from class: com.kugou.uilib.widget.popupwindow.BasePopup.2
            /* JADX WARN: Code restructure failed: missing block: B:9:0x0021, code lost:
            
                if (r0 < r1.mHeight) goto L12;
             */
            @Override // android.view.View.OnTouchListener
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public boolean onTouch(android.view.View r7, android.view.MotionEvent r8) {
                /*
                    r6 = this;
                    float r7 = r8.getX()
                    int r7 = (int) r7
                    float r0 = r8.getY()
                    int r0 = (int) r0
                    int r1 = r8.getAction()
                    r2 = 1
                    java.lang.String r3 = ",mHeight="
                    java.lang.String r4 = "EasyPopup"
                    if (r1 != 0) goto L46
                    if (r7 < 0) goto L23
                    com.kugou.uilib.widget.popupwindow.BasePopup r1 = com.kugou.uilib.widget.popupwindow.BasePopup.this
                    int r5 = r1.mWidth
                    if (r7 >= r5) goto L23
                    if (r0 < 0) goto L23
                    int r7 = r1.mHeight
                    if (r0 < r7) goto L46
                L23:
                    java.lang.StringBuilder r7 = new java.lang.StringBuilder
                    r7.<init>()
                    java.lang.String r8 = "onTouch outside:mWidth="
                    r7.append(r8)
                    com.kugou.uilib.widget.popupwindow.BasePopup r8 = com.kugou.uilib.widget.popupwindow.BasePopup.this
                    int r8 = r8.mWidth
                    r7.append(r8)
                    r7.append(r3)
                    com.kugou.uilib.widget.popupwindow.BasePopup r8 = com.kugou.uilib.widget.popupwindow.BasePopup.this
                    int r8 = r8.mHeight
                    r7.append(r8)
                    java.lang.String r7 = r7.toString()
                    android.util.Log.d(r4, r7)
                    return r2
                L46:
                    int r7 = r8.getAction()
                    r8 = 4
                    if (r7 != r8) goto L70
                    java.lang.StringBuilder r7 = new java.lang.StringBuilder
                    r7.<init>()
                    java.lang.String r8 = "onTouch outside event:mWidth="
                    r7.append(r8)
                    com.kugou.uilib.widget.popupwindow.BasePopup r8 = com.kugou.uilib.widget.popupwindow.BasePopup.this
                    int r8 = r8.mWidth
                    r7.append(r8)
                    r7.append(r3)
                    com.kugou.uilib.widget.popupwindow.BasePopup r8 = com.kugou.uilib.widget.popupwindow.BasePopup.this
                    int r8 = r8.mHeight
                    r7.append(r8)
                    java.lang.String r7 = r7.toString()
                    android.util.Log.d(r4, r7)
                    return r2
                L70:
                    r7 = 0
                    return r7
                */
                throw new UnsupportedOperationException("Method not decompiled: com.kugou.uilib.widget.popupwindow.BasePopup.AnonymousClass2.onTouch(android.view.View, android.view.MotionEvent):boolean");
            }
        });
    }

    private void measureContentView() {
        View contentView = getContentView();
        if (this.mWidth <= 0 || this.mHeight <= 0) {
            contentView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
            if (this.mWidth <= 0) {
                this.mWidth = contentView.getMeasuredWidth();
            }
            if (this.mHeight <= 0) {
                this.mHeight = contentView.getMeasuredHeight();
            }
        }
    }

    private void registerOnGlobalLayoutListener() {
        getContentView().getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.kugou.uilib.widget.popupwindow.BasePopup.3
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                BasePopup.this.getContentView().getViewTreeObserver().removeOnGlobalLayoutListener(this);
                BasePopup basePopup = BasePopup.this;
                basePopup.mWidth = basePopup.getContentView().getWidth();
                BasePopup basePopup2 = BasePopup.this;
                basePopup2.mHeight = basePopup2.getContentView().getHeight();
                BasePopup.this.isRealWHAlready = true;
                BasePopup.this.isNeedReMeasureWH = false;
                if (BasePopup.this.mOnRealWHAlreadyListener != null) {
                    OnRealWHAlreadyListener onRealWHAlreadyListener = BasePopup.this.mOnRealWHAlreadyListener;
                    BasePopup basePopup3 = BasePopup.this;
                    int i2 = basePopup3.mWidth;
                    int i3 = basePopup3.mHeight;
                    View view = basePopup3.mAnchorView;
                    int width = view == null ? 0 : view.getWidth();
                    View view2 = BasePopup.this.mAnchorView;
                    onRealWHAlreadyListener.onRealWHAlready(basePopup3, i2, i3, width, view2 == null ? 0 : view2.getHeight());
                }
                if (BasePopup.this.isShowing() && BasePopup.this.isAtAnchorViewMethod) {
                    BasePopup basePopup4 = BasePopup.this;
                    basePopup4.updateLocation(basePopup4.mWidth, basePopup4.mHeight, basePopup4.mAnchorView, basePopup4.mYGravity, basePopup4.mXGravity, basePopup4.mOffsetX, BasePopup.this.mOffsetY);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateLocation(int i2, int i3, @NonNull View view, int i4, int i5, int i6, int i7) {
        if (this.mPopupWindow == null) {
            return;
        }
        this.mPopupWindow.update(view, calculateX(view, i5, i2, i6), calculateY(view, i4, i3, i7), i2, i3);
    }

    public T apply() {
        if (this.mPopupWindow == null) {
            this.mPopupWindow = new PopupWindow();
        }
        onPopupWindowCreated();
        onPopupWindowViewCreated();
        initContentViewAndWH();
        int i2 = this.mAnimationStyle;
        if (i2 != 0) {
            this.mPopupWindow.setAnimationStyle(i2);
        }
        initFocusAndBack();
        this.mPopupWindow.setOnDismissListener(this);
        if (Build.VERSION.SDK_INT >= 23) {
            Transition transition = this.mEnterTransition;
            if (transition != null) {
                this.mPopupWindow.setEnterTransition(transition);
            }
            Transition transition2 = this.mExitTransition;
            if (transition2 != null) {
                this.mPopupWindow.setExitTransition(transition2);
            }
        }
        this.mPopupWindow.setBackgroundDrawable(this.backgroundDrawable);
        return (T) self();
    }

    public void dismiss() {
        PopupWindow popupWindow = this.mPopupWindow;
        if (popupWindow != null) {
            popupWindow.dismiss();
        }
    }

    /* JADX WARN: Incorrect return type in method signature: <T:Landroid/view/View;>(I)TT; */
    public View findViewById(@IdRes int i2) {
        if (getContentView() != null) {
            return getContentView().findViewById(i2);
        }
        return null;
    }

    public View getContentView() {
        PopupWindow popupWindow = this.mPopupWindow;
        if (popupWindow != null) {
            return popupWindow.getContentView();
        }
        return null;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public int getOffsetX() {
        return this.mOffsetX;
    }

    public int getOffsetY() {
        return this.mOffsetY;
    }

    public PopupWindow getPopupWindow() {
        return this.mPopupWindow;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public int getXGravity() {
        return this.mXGravity;
    }

    public int getYGravity() {
        return this.mYGravity;
    }

    public View inflateContentView() {
        Context context;
        if (this.mContentView == null) {
            if (this.mLayoutId == 0 || (context = this.mContext) == null) {
                throw new IllegalArgumentException("The content view is null,the layoutId=" + this.mLayoutId + ",context=" + this.mContext);
            }
            this.mContentView = LayoutInflater.from(context).inflate(this.mLayoutId, (ViewGroup) null);
        }
        return this.mContentView;
    }

    public abstract void initAttributes();

    public void initViews(View view, T t) {
        OnViewListener<T> onViewListener = this.mOnViewListener;
        if (onViewListener != null) {
            onViewListener.initViews(view, t);
        }
    }

    public void initWindowContentView(View view) {
        this.mPopupWindow.setContentView(view);
    }

    public boolean isRealWHAlready() {
        return this.isRealWHAlready;
    }

    public boolean isShowing() {
        PopupWindow popupWindow = this.mPopupWindow;
        return popupWindow != null && popupWindow.isShowing();
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        handleDismiss();
    }

    public void onPopupWindowCreated() {
        initAttributes();
    }

    public void onPopupWindowDismiss() {
    }

    public void onPopupWindowViewCreated() {
        View viewInflateContentView = inflateContentView();
        this.mContentView = viewInflateContentView;
        initViews(viewInflateContentView, self());
        initWindowContentView(this.mContentView);
        measureContentView();
        this.mPopupWindow.setWidth(-2);
        this.mPopupWindow.setHeight(-2);
        registerOnGlobalLayoutListener();
        if (this.contentViewIds != null) {
            for (int i2 = 0; i2 < this.contentViewIds.size(); i2++) {
                this.mContentView.findViewById(this.contentViewIds.keyAt(i2)).setOnClickListener(this.contentViewIds.valueAt(i2));
            }
        }
        this.mPopupWindow.setInputMethodMode(this.mInputMethodMode);
        this.mPopupWindow.setSoftInputMode(this.mSoftInputMode);
    }

    public void onShowPop(int i2, int i3) {
    }

    public T self() {
        return this;
    }

    public T setAnchorView(View view) {
        this.mAnchorView = view;
        return (T) self();
    }

    public T setAnimationStyle(@StyleRes int i2) {
        this.mAnimationStyle = i2;
        PopupWindow popupWindow = this.mPopupWindow;
        if (popupWindow != null) {
            popupWindow.setAnimationStyle(i2);
        }
        return (T) self();
    }

    public T setBackgroundDimEnable(boolean z) {
        this.isBackgroundDim = z;
        return (T) self();
    }

    public T setBackgroundDrawable(ColorDrawable colorDrawable) {
        this.backgroundDrawable = colorDrawable;
        return (T) self();
    }

    public T setClippingEnabled(boolean z) {
        this.mClippingEnabled = z;
        return (T) self();
    }

    public T setContentView(View view) {
        this.mContentView = view;
        this.mLayoutId = 0;
        return (T) self();
    }

    public T setContentViewClick(@IdRes int i2, View.OnClickListener onClickListener) {
        if (this.contentViewIds == null) {
            this.contentViewIds = new SparseArray<>();
        }
        this.contentViewIds.put(i2, onClickListener);
        return (T) self();
    }

    public T setContext(Context context) {
        this.mContext = context;
        return (T) self();
    }

    public T setDimColor(@ColorInt int i2) {
        this.mDimColor = i2;
        return (T) self();
    }

    public T setDimValue(@FloatRange(from = 0.0d, to = 1.0d) float f2) {
        this.mDimValue = f2;
        return (T) self();
    }

    public T setDimView(@NonNull ViewGroup viewGroup) {
        this.mDimView = viewGroup;
        return (T) self();
    }

    @RequiresApi(api = 23)
    public T setEnterTransition(Transition transition) {
        this.mEnterTransition = transition;
        return (T) self();
    }

    @RequiresApi(api = 23)
    public T setExitTransition(Transition transition) {
        this.mExitTransition = transition;
        return (T) self();
    }

    public T setFocusAndOutsideEnable(boolean z) {
        this.mFocusAndOutsideEnable = z;
        return (T) self();
    }

    public T setFocusable(boolean z) {
        this.mFocusable = z;
        return (T) self();
    }

    public T setHeight(int i2) {
        this.mHeight = i2;
        return (T) self();
    }

    public T setInputMethodMode(int i2) {
        this.mInputMethodMode = i2;
        return (T) self();
    }

    public T setNeedReMeasureWH(boolean z) {
        this.isNeedReMeasureWH = z;
        return (T) self();
    }

    public T setOffsetX(int i2) {
        this.mOffsetX = i2;
        return (T) self();
    }

    public T setOffsetY(int i2) {
        this.mOffsetY = i2;
        return (T) self();
    }

    public T setOnDismissListener(PopupWindow.OnDismissListener onDismissListener) {
        this.mOnDismissListener = onDismissListener;
        return (T) self();
    }

    public T setOnRealWHAlreadyListener(OnRealWHAlreadyListener onRealWHAlreadyListener) {
        this.mOnRealWHAlreadyListener = onRealWHAlreadyListener;
        return (T) self();
    }

    public T setOnViewListener(OnViewListener<T> onViewListener) {
        this.mOnViewListener = onViewListener;
        return (T) self();
    }

    public T setOutsideTouchable(boolean z) {
        this.mOutsideTouchable = z;
        return (T) self();
    }

    public T setSoftInputMode(int i2) {
        this.mSoftInputMode = i2;
        return (T) self();
    }

    public T setWidth(int i2) {
        this.mWidth = i2;
        return (T) self();
    }

    public T setXGravity(int i2) {
        this.mXGravity = i2;
        return (T) self();
    }

    public T setYGravity(int i2) {
        this.mYGravity = i2;
        return (T) self();
    }

    public void showAsDropDown(View view) {
        showAsDropDown(view, 0, 0);
    }

    public void showAtAnchorView(@NonNull View view, int i2, int i3) {
        showAtAnchorView(view, i2, i3, 0, 0);
    }

    public void showAtLocation(View view, int i2, int i3, int i4) {
        checkIsApply(false);
        handleBackgroundDim();
        this.mAnchorView = view;
        this.mOffsetX = i3;
        this.mOffsetY = i4;
        if (this.isNeedReMeasureWH) {
            registerOnGlobalLayoutListener();
        }
        this.mPopupWindow.showAtLocation(view, i2, this.mOffsetX, this.mOffsetY);
    }

    public void showAsDropDown(View view, int i2, int i3) {
        checkIsApply(false);
        handleBackgroundDim();
        this.mAnchorView = view;
        this.mOffsetX = i2;
        this.mOffsetY = i3;
        this.mXGravity = 3;
        this.mYGravity = 2;
        if (this.isNeedReMeasureWH) {
            registerOnGlobalLayoutListener();
        }
        onShowPop(this.mOffsetX, this.mOffsetY);
        this.mPopupWindow.showAsDropDown(view, this.mOffsetX, this.mOffsetY);
    }

    public void showAtAnchorView(@NonNull View view, int i2, int i3, int i4, int i5) {
        checkIsApply(true);
        this.mAnchorView = view;
        this.mOffsetX = i4;
        this.mOffsetY = i5;
        this.mYGravity = i2;
        this.mXGravity = i3;
        handleBackgroundDim();
        int iCalculateX = calculateX(view, i3, this.mWidth, this.mOffsetX);
        int iCalculateY = calculateY(view, i2, this.mHeight, this.mOffsetY);
        if (this.isNeedReMeasureWH) {
            registerOnGlobalLayoutListener();
        }
        onShowPop(iCalculateX, iCalculateY);
        PopupWindowCompat.showAsDropDown(this.mPopupWindow, view, iCalculateX, iCalculateY, 0);
    }

    @RequiresApi(api = 18)
    private void clearDim(ViewGroup viewGroup) {
        viewGroup.getOverlay().clear();
    }

    public T setContentView(@LayoutRes int i2) {
        this.mContentView = null;
        this.mLayoutId = i2;
        return (T) self();
    }

    @RequiresApi(api = 18)
    private void applyDim(ViewGroup viewGroup) {
        ColorDrawable colorDrawable = new ColorDrawable(this.mDimColor);
        colorDrawable.setBounds(0, 0, viewGroup.getWidth(), viewGroup.getHeight());
        colorDrawable.setAlpha((int) (this.mDimValue * 255.0f));
        viewGroup.getOverlay().add(colorDrawable);
    }

    public T setContentView(Context context, @LayoutRes int i2) {
        this.mContext = context;
        this.mContentView = null;
        this.mLayoutId = i2;
        return (T) self();
    }

    public T setContentView(View view, int i2, int i3) {
        this.mContentView = view;
        this.mLayoutId = 0;
        this.mWidth = i2;
        this.mHeight = i3;
        return (T) self();
    }

    @RequiresApi(api = 19)
    public void showAsDropDown(View view, int i2, int i3, int i4) {
        checkIsApply(false);
        handleBackgroundDim();
        this.mAnchorView = view;
        this.mOffsetX = i2;
        this.mOffsetY = i3;
        if (this.isNeedReMeasureWH) {
            registerOnGlobalLayoutListener();
        }
        onShowPop(this.mOffsetX, this.mOffsetY);
        PopupWindowCompat.showAsDropDown(this.mPopupWindow, view, this.mOffsetX, this.mOffsetY, i4);
    }

    public T setContentView(@LayoutRes int i2, int i3, int i4) {
        this.mContentView = null;
        this.mLayoutId = i2;
        this.mWidth = i3;
        this.mHeight = i4;
        return (T) self();
    }

    public T setContentView(Context context, @LayoutRes int i2, int i3, int i4) {
        this.mContext = context;
        this.mContentView = null;
        this.mLayoutId = i2;
        this.mWidth = i3;
        this.mHeight = i4;
        return (T) self();
    }
}
