package com.kugou.uilib.widget.dialog;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.annotation.LayoutRes;
import androidx.annotation.StringRes;
import com.kugou.uilib.R;
import com.kugou.uilib.utils.KGUISystemUtil;
import com.kugou.uilib.widget.baseDelegate.commImpl.CornerDelegate;
import com.kugou.uilib.widget.layout.linearlayout.KGUILinearLayout;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class KGUIDialog extends KGBaseDialog {
    public float backgroundRadius;

    @ColorInt
    public int borderColor;
    public int borderStrokeWidth;
    private Button btnNegative;
    private Button btnPositive;

    @ColorInt
    public int colorRes;
    private View contentView;
    public SparseArray<View.OnClickListener> contentViewIds;

    @LayoutRes
    public int contentViewLayoutRes;
    public ArrayList<Integer> corners;
    public float dialogHeight;
    private KGUILinearLayout dialogRoot;
    public float dialogWidth;

    @DrawableRes
    public int drawableRes;
    private FrameLayout flCustom;
    public boolean isDialogBtnShow;
    public boolean isNegativeBtnShow;
    public boolean isProgressBarShow;
    public String mMessage;
    public String mTitle;
    public View mView;

    @StringRes
    public int messageIdRes;

    @StringRes
    public int negativeIdRes;
    public String negativeText;
    private View.OnClickListener onDefaultClickListener;
    public View.OnClickListener onNegativeListener;
    public View.OnClickListener onPositiveListener;
    private ProgressBar pbLoading;

    @StringRes
    public int positiveIdRes;
    public String positiveText;

    @StringRes
    public int titleIdRes;
    private TextView tvMsg;
    private TextView tvTitle;

    public KGUIDialog(Context context) {
        super(context, R.style.MyDialog);
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.kugou.uilib.widget.dialog.KGUIDialog.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                KGUIDialog.this.cancel();
            }
        };
        this.onDefaultClickListener = onClickListener;
        this.onPositiveListener = onClickListener;
        this.onNegativeListener = onClickListener;
        this.corners = new ArrayList<>();
        this.isDialogBtnShow = true;
        this.isProgressBarShow = false;
        this.isNegativeBtnShow = true;
    }

    public void configWindow(Context context) {
        Window window = getWindow();
        int iDp2px = KGUISystemUtil.dp2px(22.0f);
        window.getDecorView().setPadding(iDp2px, 0, iDp2px, 0);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = -1;
        attributes.height = -2;
        window.setAttributes(attributes);
    }

    public View getContentView() {
        return this.contentView;
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        View viewInflate = LayoutInflater.from(getContext()).inflate(R.layout.kg_base_dialog, (ViewGroup) null, false);
        this.contentView = viewInflate;
        setContentView(viewInflate);
        configWindow(getContext());
        this.flCustom = (FrameLayout) findViewById(R.id.fl_dialog_content);
        this.tvTitle = (TextView) findViewById(R.id.tv_title);
        this.pbLoading = (ProgressBar) findViewById(R.id.pb_loading);
        this.dialogRoot = (KGUILinearLayout) findViewById(R.id.dialog_root);
        this.tvMsg = (TextView) findViewById(R.id.tv_msg);
        this.btnPositive = (Button) findViewById(R.id.btn_positive);
        this.btnNegative = (Button) findViewById(R.id.btn_negative);
    }

    public void onDialogViewCreated() {
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
        show(this);
    }

    private void show(KGUIDialog kGUIDialog) {
        if (!TextUtils.isEmpty(kGUIDialog.mTitle)) {
            kGUIDialog.tvTitle.setText(kGUIDialog.mTitle);
        }
        int i2 = this.titleIdRes;
        if (i2 != 0) {
            kGUIDialog.tvTitle.setText(i2);
        }
        if (TextUtils.isEmpty(kGUIDialog.mTitle) && this.titleIdRes == 0) {
            kGUIDialog.tvTitle.setVisibility(8);
        }
        if (kGUIDialog.contentViewLayoutRes != 0) {
            kGUIDialog.mView = LayoutInflater.from(kGUIDialog.getContext()).inflate(this.contentViewLayoutRes, (ViewGroup) kGUIDialog.flCustom, false);
            if (this.contentViewIds != null) {
                for (int i3 = 0; i3 < this.contentViewIds.size(); i3++) {
                    kGUIDialog.mView.findViewById(this.contentViewIds.keyAt(i3)).setOnClickListener(this.contentViewIds.valueAt(i3));
                }
            }
            kGUIDialog.flCustom.addView(kGUIDialog.mView);
            kGUIDialog.pbLoading.setVisibility(8);
            kGUIDialog.tvMsg.setVisibility(8);
        } else {
            if (!TextUtils.isEmpty(kGUIDialog.mMessage)) {
                kGUIDialog.tvMsg.setText(kGUIDialog.mMessage);
                kGUIDialog.tvMsg.setVisibility(0);
            }
            int i4 = this.messageIdRes;
            if (i4 != 0) {
                kGUIDialog.tvMsg.setText(i4);
                kGUIDialog.tvMsg.setVisibility(0);
            }
            if (this.isProgressBarShow) {
                kGUIDialog.pbLoading.setVisibility(0);
                kGUIDialog.btnPositive.setVisibility(8);
                kGUIDialog.btnNegative.setVisibility(8);
            }
        }
        if (!kGUIDialog.isNegativeBtnShow) {
            kGUIDialog.btnNegative.setVisibility(8);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) kGUIDialog.btnPositive.getLayoutParams();
            layoutParams.setMargins(150, layoutParams.topMargin, 150, layoutParams.bottomMargin);
            kGUIDialog.btnPositive.setLayoutParams(layoutParams);
        } else {
            kGUIDialog.btnNegative.setOnClickListener(kGUIDialog.onNegativeListener);
            if (!TextUtils.isEmpty(kGUIDialog.negativeText)) {
                kGUIDialog.btnNegative.setText(kGUIDialog.negativeText);
            }
            int i5 = this.negativeIdRes;
            if (i5 != 0) {
                kGUIDialog.btnNegative.setText(i5);
            }
        }
        int i6 = this.drawableRes;
        if (i6 != 0) {
            kGUIDialog.dialogRoot.setBackgroundResource(i6);
        }
        int i7 = this.colorRes;
        if (i7 != 0) {
            kGUIDialog.dialogRoot.setBackgroundColor(i7);
        }
        if (this.backgroundRadius != 0.0f) {
            if (this.corners.size() <= 0) {
                ((CornerDelegate) this.dialogRoot.getCommonDelegate(CornerDelegate.class)).setCornerRadius(this.backgroundRadius);
            } else {
                int[] iArr = new int[this.corners.size()];
                for (int i8 = 0; i8 < this.corners.size(); i8++) {
                    iArr[i8] = this.corners.get(i8).intValue();
                }
                ((CornerDelegate) this.dialogRoot.getCommonDelegate(CornerDelegate.class)).setCornerRadius(this.backgroundRadius, iArr);
            }
        }
        if (this.borderStrokeWidth > 0) {
            ((CornerDelegate) this.dialogRoot.getCommonDelegate(CornerDelegate.class)).setBorderStrokeWidth(this.borderStrokeWidth);
            if (this.borderColor != 0) {
                ((CornerDelegate) this.dialogRoot.getCommonDelegate(CornerDelegate.class)).setBorderColor(this.borderColor);
            }
        }
        kGUIDialog.btnPositive.setOnClickListener(kGUIDialog.onPositiveListener);
        if (!TextUtils.isEmpty(kGUIDialog.positiveText)) {
            kGUIDialog.btnPositive.setText(kGUIDialog.positiveText);
        }
        int i9 = this.positiveIdRes;
        if (i9 != 0) {
            kGUIDialog.btnPositive.setText(i9);
        }
        if (this.isDialogBtnShow) {
            return;
        }
        kGUIDialog.btnPositive.setVisibility(8);
        kGUIDialog.btnNegative.setVisibility(8);
    }
}
