package com.kugou.uilib.widget.recyclerview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.NestedScrollingParent2;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.kugou.uilib.R;
import com.kugou.uilib.widget.baseDelegate.IAttrParse;
import com.kugou.uilib.widget.baseDelegate.IViewDelegate;
import com.kugou.uilib.widget.baseDelegate.KGUIDelegateManager;
import com.kugou.uilib.widget.baseDelegate.commImpl.CommonDelegateAttrHelper;
import com.kugou.uilib.widget.baseDelegate.commImpl.CommonDelegateHelper;
import com.kugou.uilib.widget.recyclerview.delegate.base.IRecyclerViewDelegate;
import com.kugou.uilib.widget.recyclerview.delegate.impl.DefaultScrollParent;
import com.kugou.uilib.widget.recyclerview.scroll.IScrollParent;
import com.kugou.uilib.widget.recyclerview.scroll.IScrollableChild;
import com.kugou.uilib.widget.recyclerview.scroll.ScrollCharacter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public abstract class KGUIRecyclerBaseView extends RecyclerView implements IAttrParse, IScrollableChild, NestedScrollingParent2 {
    private List<IRecyclerViewDelegate> functions;
    private KGUIDelegateManager mDelegateManager;
    private boolean mEnableWarpContent;
    private IScrollParent mScrollParent;

    public KGUIRecyclerBaseView(@NonNull Context context) {
        this(context, null, 0);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        Iterator<IRecyclerViewDelegate> it = this.functions.iterator();
        while (it.hasNext()) {
            it.next().dispatchTouchEvent(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public void draw(Canvas canvas) {
        KGUIDelegateManager kGUIDelegateManager = this.mDelegateManager;
        if (kGUIDelegateManager != null) {
            kGUIDelegateManager.preDraw(canvas);
        }
        super.draw(canvas);
        KGUIDelegateManager kGUIDelegateManager2 = this.mDelegateManager;
        if (kGUIDelegateManager2 != null) {
            kGUIDelegateManager2.afterDraw(canvas);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        this.mDelegateManager.drawableStateChanged();
    }

    @Override // com.kugou.uilib.widget.baseDelegate.IAttrParse
    public <E extends IViewDelegate> E getCommonDelegate(Class<E> cls) {
        return (E) CommonDelegateAttrHelper.getCommonDelegate(this, this.mDelegateManager, cls);
    }

    public <T extends IViewDelegate> T getDelegate(Class<T> cls) {
        return (T) this.mDelegateManager.getDelegate(cls);
    }

    @Override // com.kugou.uilib.widget.baseDelegate.IAttrParse
    public abstract List<IRecyclerViewDelegate> getDelegates(TypedArray typedArray);

    public boolean getEnableWarpContent() {
        return this.mEnableWarpContent;
    }

    @Override // com.kugou.uilib.widget.recyclerview.scroll.IScrollableChild
    public boolean isScrollAble(int i2, int i3) {
        RecyclerView.LayoutManager layoutManager = getLayoutManager();
        if (layoutManager instanceof LinearLayoutManager) {
            return ((LinearLayoutManager) layoutManager).getOrientation() == 0 ? i2 < 0 ? !RecyclerHelper.isFirstItemVisible(this) : !RecyclerHelper.isLastItemVisible(this) : i3 < 0 ? !RecyclerHelper.isFirstItemVisible(this) : !RecyclerHelper.isLastItemVisible(this);
        }
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        Iterator<IRecyclerViewDelegate> it = this.functions.iterator();
        while (it.hasNext()) {
            it.next().onInterceptTouchEvent(motionEvent);
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        KGUIDelegateManager kGUIDelegateManager = this.mDelegateManager;
        if (kGUIDelegateManager != null) {
            kGUIDelegateManager.onLayout(z, i2, i3, i4, i5);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public void onMeasure(int i2, int i3) {
        int[] iArrMeasure;
        KGUIDelegateManager kGUIDelegateManager = this.mDelegateManager;
        if (kGUIDelegateManager == null || (iArrMeasure = kGUIDelegateManager.measure(i2, i3)) == null) {
            super.onMeasure(i2, i3);
        } else {
            super.onMeasure(iArrMeasure[0], iArrMeasure[1]);
        }
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedPreScroll(@NonNull View view, int i2, int i3, @NonNull int[] iArr, int i4) {
        IScrollParent iScrollParent = this.mScrollParent;
        if (iScrollParent != null) {
            iScrollParent.onNestedPreScroll(view, i2, i3, iArr, i4);
        }
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedScroll(@NonNull View view, int i2, int i3, int i4, int i5, int i6) {
        IScrollParent iScrollParent = this.mScrollParent;
        if (iScrollParent != null) {
            iScrollParent.onNestedScroll(view, i2, i3, i4, i5, i6);
        }
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedScrollAccepted(@NonNull View view, @NonNull View view2, int i2, int i3) {
        IScrollParent iScrollParent = this.mScrollParent;
        if (iScrollParent != null) {
            iScrollParent.onNestedScrollAccepted(view, view2, i2, i3);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        KGUIDelegateManager kGUIDelegateManager = this.mDelegateManager;
        if (kGUIDelegateManager != null) {
            kGUIDelegateManager.onSizeChanged(i2, i3, i4, i5);
        }
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public boolean onStartNestedScroll(@NonNull View view, @NonNull View view2, int i2, int i3) {
        IScrollParent iScrollParent = this.mScrollParent;
        if (iScrollParent != null) {
            return iScrollParent.onStartNestedScroll(view, view2, i2, i3);
        }
        return false;
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onStopNestedScroll(@NonNull View view, int i2) {
        IScrollParent iScrollParent = this.mScrollParent;
        if (iScrollParent != null) {
            iScrollParent.onStopNestedScroll(view, i2);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        Iterator<IRecyclerViewDelegate> it = this.functions.iterator();
        while (it.hasNext()) {
            it.next().onTouchEvent(motionEvent);
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // com.kugou.uilib.widget.baseDelegate.IAttrParse
    public void parseAttributeSet(@NonNull Context context, AttributeSet attributeSet, int i2) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.KGUIRecyclerBaseView, i2, 0);
        int integer = typedArrayObtainStyledAttributes.getInteger(R.styleable.KGUIRecyclerBaseView_kgui_scroll_character, 0);
        this.mEnableWarpContent = typedArrayObtainStyledAttributes.getBoolean(R.styleable.KGUIRecyclerBaseView_kgui_warp_content_enable, false);
        this.functions = getDelegates(typedArrayObtainStyledAttributes);
        if (integer == ScrollCharacter.PARENT.ordinal()) {
            this.mScrollParent = new DefaultScrollParent(this);
            setNestedScrollingEnabled(true);
        } else if (integer == ScrollCharacter.CHILD.ordinal()) {
            setNestedScrollingEnabled(true);
        }
        Iterator<IRecyclerViewDelegate> it = this.functions.iterator();
        while (it.hasNext()) {
            it.next().init(this, typedArrayObtainStyledAttributes);
        }
        this.mDelegateManager.addList(this.functions);
        typedArrayObtainStyledAttributes.recycle();
    }

    public void setEnableWarpContent(boolean z) {
        this.mEnableWarpContent = z;
        requestLayout();
    }

    public void setNestScrollParentDelegate(IScrollParent iScrollParent) {
        this.mScrollParent = iScrollParent;
    }

    public KGUIRecyclerBaseView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public KGUIRecyclerBaseView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.functions = new ArrayList();
        TypedArray commonTypeArray = CommonDelegateHelper.getCommonTypeArray(context, attributeSet, i2);
        KGUIDelegateManager kGUIDelegateManagerInitCommonDelegate = CommonDelegateHelper.initCommonDelegate(commonTypeArray);
        this.mDelegateManager = kGUIDelegateManagerInitCommonDelegate;
        kGUIDelegateManagerInitCommonDelegate.init(this, commonTypeArray);
        commonTypeArray.recycle();
        parseAttributeSet(context, attributeSet, i2);
    }
}
