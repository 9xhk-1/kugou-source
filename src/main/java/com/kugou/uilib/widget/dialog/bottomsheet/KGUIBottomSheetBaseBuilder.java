package com.kugou.uilib.widget.dialog.bottomsheet;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import com.kugou.uilib.R;
import com.kugou.uilib.utils.KGUISystemUtil;
import com.kugou.uilib.widget.dialog.bottomsheet.KGUIBottomSheetBaseBuilder;
import com.kugou.uilib.widget.imageview.round.roundedimageview.Corner;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public abstract class KGUIBottomSheetBaseBuilder<T extends KGUIBottomSheetBaseBuilder> {

    @DrawableRes
    private int backgroundDrawableResource;
    private float backgroundRadius;
    private int bottomSheetHeight;
    private String mCancelText;
    private Context mContext;
    private KGUIBottomSheet mDialog;
    private CharSequence mTitle;
    private View.OnClickListener onCancelClickListener;
    private boolean mAllowDrag = false;
    private boolean mAddCancelBtn = false;
    private ArrayList<Integer> corners = new ArrayList<>();

    @ColorInt
    private int backgroundColor = -1;

    public KGUIBottomSheetBaseBuilder(Context context) {
        this.mContext = context;
    }

    public KGUIBottomSheet build() {
        return build(R.style.MyDialog);
    }

    public boolean hasTitle() {
        CharSequence charSequence = this.mTitle;
        return (charSequence == null || charSequence.length() == 0) ? false : true;
    }

    public T self() {
        return this;
    }

    public T setAddCancelBtn(boolean z) {
        this.mAddCancelBtn = z;
        return (T) self();
    }

    public T setAllowDrag(boolean z) {
        this.mAllowDrag = z;
        return (T) self();
    }

    public T setBottomSheetBackgroundColor(@ColorInt int i2) {
        this.backgroundColor = i2;
        return (T) self();
    }

    public T setBottomSheetBackgroundDrawableResource(@DrawableRes int i2) {
        this.backgroundDrawableResource = i2;
        return (T) self();
    }

    public T setBottomSheetHeight(int i2) {
        this.bottomSheetHeight = i2;
        return (T) self();
    }

    public T setCancelClickListener(View.OnClickListener onClickListener) {
        this.onCancelClickListener = onClickListener;
        return (T) self();
    }

    public T setCancelText(String str) {
        this.mCancelText = str;
        return (T) self();
    }

    public T setCornerRadius(float f2, @Corner int... iArr) {
        this.backgroundRadius = KGUISystemUtil.dp2px(f2);
        for (int i2 : iArr) {
            this.corners.add(Integer.valueOf(i2));
        }
        return (T) self();
    }

    public abstract void setMore(KGUIBottomSheet kGUIBottomSheet);

    public T setTitle(CharSequence charSequence) {
        this.mTitle = charSequence;
        return (T) self();
    }

    public KGUIBottomSheet build(int i2) {
        this.mDialog = new KGUIBottomSheet(this.mContext, i2);
        if (TextUtils.isEmpty(this.mTitle)) {
            this.mDialog.hasTitle(false);
        } else {
            this.mDialog.setCommonTitle(this.mTitle.toString());
        }
        this.mDialog.setAddCancelBtn(this.mAddCancelBtn);
        if (!TextUtils.isEmpty(this.mCancelText)) {
            this.mDialog.setAddCancelBtn(true);
            this.mDialog.setCancelText(this.mCancelText);
        }
        View.OnClickListener onClickListener = this.onCancelClickListener;
        if (onClickListener != null) {
            this.mDialog.setCancelClickListener(onClickListener);
        }
        int i3 = this.bottomSheetHeight;
        if (i3 > 0) {
            this.mDialog.setBottomSheetHeight(i3);
        }
        if (this.backgroundRadius != 0.0f) {
            if (this.corners.size() > 0) {
                int[] iArr = new int[this.corners.size()];
                for (int i4 = 0; i4 < this.corners.size(); i4++) {
                    iArr[i4] = this.corners.get(i4).intValue();
                }
                this.mDialog.setCornerRadius(this.backgroundRadius, iArr);
            } else {
                this.mDialog.setCornerRadius(this.backgroundRadius, new int[0]);
            }
        }
        int i5 = this.backgroundColor;
        if (i5 != 0) {
            this.mDialog.setBottomSheetBackgroundColor(i5);
        }
        int i6 = this.backgroundDrawableResource;
        if (i6 != 0) {
            this.mDialog.setBottomSheetBackgroundDrawableResource(i6);
        }
        this.mDialog.getBehavior().setAllowDrag(this.mAllowDrag);
        setMore(this.mDialog);
        return this.mDialog;
    }
}
