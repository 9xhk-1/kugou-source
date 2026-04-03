package com.kugou.uilib.widget.dialog.builder;

import android.content.Context;
import android.content.DialogInterface;
import android.util.SparseArray;
import android.view.View;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.annotation.IdRes;
import androidx.annotation.LayoutRes;
import androidx.annotation.StringRes;
import com.kugou.uilib.utils.KGUISystemUtil;
import com.kugou.uilib.widget.dialog.KGUIDialog;
import com.kugou.uilib.widget.dialog.builder.BaseDialogBuilder;

/* JADX INFO: loaded from: classes2.dex */
public abstract class BaseDialogBuilder<T extends BaseDialogBuilder> {
    private KGUIDialog mDialog;

    public BaseDialogBuilder(Context context) {
        this.mDialog = new KGUIDialog(context);
    }

    public KGUIDialog create() {
        return this.mDialog;
    }

    public T self() {
        return this;
    }

    public T setBodyLayoutView(@LayoutRes int i2) {
        this.mDialog.contentViewLayoutRes = i2;
        return (T) self();
    }

    public T setBorderColor(@ColorInt int i2) {
        this.mDialog.borderColor = i2;
        return (T) self();
    }

    public T setBorderStrokeWidth(int i2) {
        this.mDialog.borderStrokeWidth = KGUISystemUtil.dp2px(i2);
        return (T) self();
    }

    public T setCancelable(boolean z) {
        this.mDialog.setCancelable(z);
        return (T) self();
    }

    public T setContentViewClick(@IdRes int i2, View.OnClickListener onClickListener) {
        KGUIDialog kGUIDialog = this.mDialog;
        if (kGUIDialog.contentViewIds == null) {
            kGUIDialog.contentViewIds = new SparseArray<>();
        }
        this.mDialog.contentViewIds.put(i2, onClickListener);
        return (T) self();
    }

    public T setCornerRadius(float f2) {
        this.mDialog.backgroundRadius = f2;
        return (T) self();
    }

    public T setDialogBackground(@DrawableRes int i2) {
        this.mDialog.drawableRes = i2;
        return (T) self();
    }

    public T setDialogBackgroundColor(@ColorInt int i2) {
        this.mDialog.colorRes = i2;
        return (T) self();
    }

    public T setDialogBackgroundRadius(int i2) {
        this.mDialog.backgroundRadius = i2;
        return (T) self();
    }

    public T setDialogWidthAndHeight(float f2, float f3) {
        KGUIDialog kGUIDialog = this.mDialog;
        kGUIDialog.dialogWidth = f2;
        kGUIDialog.dialogHeight = f3;
        return (T) self();
    }

    public T setIsShowDialogBtn(boolean z) {
        this.mDialog.isDialogBtnShow = z;
        return (T) self();
    }

    public T setMessage(String str) {
        this.mDialog.mMessage = str;
        return (T) self();
    }

    public T setNegativeBtnShow(boolean z) {
        this.mDialog.isNegativeBtnShow = z;
        return (T) self();
    }

    public T setNegativeButton(View.OnClickListener onClickListener) {
        this.mDialog.onNegativeListener = onClickListener;
        return (T) self();
    }

    public T setOnCancelListener(DialogInterface.OnCancelListener onCancelListener) {
        this.mDialog.setOnCancelListener(onCancelListener);
        return (T) self();
    }

    public BaseDialogBuilder setOnDismissListener(DialogInterface.OnDismissListener onDismissListener) {
        this.mDialog.setOnDismissListener(onDismissListener);
        return this;
    }

    public T setPositiveButton(View.OnClickListener onClickListener) {
        this.mDialog.onPositiveListener = onClickListener;
        return (T) self();
    }

    public T setProgressBarShow(boolean z) {
        this.mDialog.isProgressBarShow = z;
        return (T) self();
    }

    public T setTitle(String str) {
        this.mDialog.mTitle = str;
        return (T) self();
    }

    public T setCornerRadius(float f2, int... iArr) {
        this.mDialog.backgroundRadius = f2;
        for (int i2 : iArr) {
            this.mDialog.corners.add(Integer.valueOf(i2));
        }
        return (T) self();
    }

    public T setMessage(@StringRes int i2) {
        this.mDialog.messageIdRes = i2;
        return (T) self();
    }

    public T setNegativeButton(String str, View.OnClickListener onClickListener) {
        KGUIDialog kGUIDialog = this.mDialog;
        kGUIDialog.negativeText = str;
        kGUIDialog.onNegativeListener = onClickListener;
        return (T) self();
    }

    public T setPositiveButton(String str, View.OnClickListener onClickListener) {
        KGUIDialog kGUIDialog = this.mDialog;
        kGUIDialog.positiveText = str;
        kGUIDialog.onPositiveListener = onClickListener;
        return (T) self();
    }

    public T setTitle(@StringRes int i2) {
        this.mDialog.titleIdRes = i2;
        return (T) self();
    }

    public T setNegativeButton(@StringRes int i2, View.OnClickListener onClickListener) {
        KGUIDialog kGUIDialog = this.mDialog;
        kGUIDialog.negativeIdRes = i2;
        kGUIDialog.onNegativeListener = onClickListener;
        return (T) self();
    }

    public T setPositiveButton(@StringRes int i2, View.OnClickListener onClickListener) {
        KGUIDialog kGUIDialog = this.mDialog;
        kGUIDialog.positiveIdRes = i2;
        kGUIDialog.onPositiveListener = onClickListener;
        return (T) self();
    }
}
