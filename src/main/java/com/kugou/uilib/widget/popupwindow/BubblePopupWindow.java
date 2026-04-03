package com.kugou.uilib.widget.popupwindow;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;
import com.kugou.uilib.utils.KGUISystemUtil;
import com.kugou.uilib.widget.popupwindow.widget.ArrowView;

/* JADX INFO: loaded from: classes2.dex */
public class BubblePopupWindow extends BasePopup<BubblePopupWindow> {
    private int[] anchorL;
    private int arrowColor;
    private int[] arrowL;
    public int arrowSize;
    private ArrowView arrowView;
    private LinearLayout mContent;

    public BubblePopupWindow() {
        this.arrowSize = KGUISystemUtil.dp2px(7.0f);
        this.arrowColor = -16777216;
        this.anchorL = new int[2];
        this.arrowL = new int[2];
    }

    public static BubblePopupWindow create() {
        return new BubblePopupWindow();
    }

    @Override // com.kugou.uilib.widget.popupwindow.BasePopup
    public void initAttributes() {
    }

    @Override // com.kugou.uilib.widget.popupwindow.BasePopup
    public void initWindowContentView(View view) {
        this.arrowView = new ArrowView(view.getContext());
        this.mContent = new LinearLayout(view.getContext());
        ArrowView arrowView = this.arrowView;
        int i2 = this.arrowSize;
        arrowView.setLayoutParams(new LinearLayout.LayoutParams(i2 * 2, i2));
        this.arrowView.setArrowColor(this.arrowColor);
        this.mContent.addView(view);
        super.initWindowContentView(this.mContent);
    }

    @Override // com.kugou.uilib.widget.popupwindow.BasePopup
    public void onShowPop(int i2, int i3) {
        if (this.mAnchorView != null) {
            final int i4 = 4;
            int i5 = this.mYGravity;
            int i6 = 0;
            int i7 = 1;
            if (i5 == 1) {
                i4 = 3;
                i6 = 1;
            } else {
                if (i5 == 2) {
                    i4 = 2;
                    i6 = 1;
                } else {
                    int i8 = this.mXGravity;
                    if (i8 == 1) {
                        i4 = 1;
                    } else if (i8 == 2) {
                        i4 = 0;
                    }
                }
                i7 = 0;
            }
            this.mContent.setOrientation(i6);
            this.mContent.removeView(this.arrowView);
            this.mContent.addView(this.arrowView, i7);
            this.arrowView.setOri(i4);
            this.arrowView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.kugou.uilib.widget.popupwindow.BubblePopupWindow.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    BubblePopupWindow.this.arrowView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    BubblePopupWindow bubblePopupWindow = BubblePopupWindow.this;
                    bubblePopupWindow.mAnchorView.getLocationOnScreen(bubblePopupWindow.anchorL);
                    BubblePopupWindow.this.mContent.getLocationOnScreen(BubblePopupWindow.this.arrowL);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) BubblePopupWindow.this.arrowView.getLayoutParams();
                    layoutParams.leftMargin = 0;
                    layoutParams.topMargin = 0;
                    int i9 = i4;
                    if (i9 == 2 || i9 == 3) {
                        int i10 = BubblePopupWindow.this.anchorL[0] - BubblePopupWindow.this.arrowL[0];
                        BubblePopupWindow bubblePopupWindow2 = BubblePopupWindow.this;
                        int i11 = bubblePopupWindow2.mXGravity;
                        if (i11 == 3) {
                            layoutParams.leftMargin = ((bubblePopupWindow2.mAnchorView.getWidth() / 2) - BubblePopupWindow.this.arrowSize) + i10;
                        } else if (i11 == 4) {
                            layoutParams.leftMargin = ((layoutParams.width - (bubblePopupWindow2.mAnchorView.getWidth() / 2)) - BubblePopupWindow.this.arrowSize) + i10;
                        }
                    } else if (i9 == 0 || i9 == 1) {
                        int i12 = BubblePopupWindow.this.anchorL[1];
                        int i13 = BubblePopupWindow.this.arrowL[1];
                        BubblePopupWindow bubblePopupWindow3 = BubblePopupWindow.this;
                        int i14 = bubblePopupWindow3.mYGravity;
                        if (i14 == 3) {
                            layoutParams.topMargin = (bubblePopupWindow3.mAnchorView.getHeight() / 2) - (BubblePopupWindow.this.arrowSize / 2);
                        } else if (i14 == 4) {
                            layoutParams.topMargin = (layoutParams.height - (bubblePopupWindow3.mAnchorView.getHeight() / 2)) - (BubblePopupWindow.this.arrowSize / 2);
                        }
                    }
                    BubblePopupWindow.this.arrowView.setLayoutParams(layoutParams);
                }
            });
        }
    }

    public BubblePopupWindow setArrowColor(int i2) {
        this.arrowColor = i2;
        ArrowView arrowView = this.arrowView;
        if (arrowView != null) {
            arrowView.setArrowColor(i2);
        }
        return this;
    }

    @Override // com.kugou.uilib.widget.popupwindow.BasePopup
    public void showAsDropDown(View view) {
        super.showAsDropDown(view);
    }

    public static BubblePopupWindow create(Context context) {
        return new BubblePopupWindow(context);
    }

    public BubblePopupWindow(Context context) {
        this.arrowSize = KGUISystemUtil.dp2px(7.0f);
        this.arrowColor = -16777216;
        this.anchorL = new int[2];
        this.arrowL = new int[2];
        setContext(context);
        setWidth(-2);
        setHeight(-2);
        setFocusable(true);
        setOutsideTouchable(false);
        setClippingEnabled(false);
        setBackgroundDrawable(new ColorDrawable(0));
    }
}
