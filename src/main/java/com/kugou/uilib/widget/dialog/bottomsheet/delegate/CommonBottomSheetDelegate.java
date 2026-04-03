package com.kugou.uilib.widget.dialog.bottomsheet.delegate;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.kugou.uilib.widget.dialog.bottomsheet.KGUIBottomSheet;

/* JADX INFO: loaded from: classes2.dex */
public abstract class CommonBottomSheetDelegate implements InterBottomSheetDelegate {
    public KGUIBottomSheet bottomSheet;
    public Context mContext;
    public View rootView;

    public CommonBottomSheetDelegate(@NonNull Context context) {
        this.mContext = context;
    }

    @Override // com.kugou.uilib.widget.dialog.bottomsheet.delegate.InterBottomSheetDelegate
    public View getContainView() {
        Context context = this.mContext;
        if (context == null) {
            return null;
        }
        this.rootView = LayoutInflater.from(context).inflate(getLayoutId(), (ViewGroup) null, false);
        initView();
        return this.rootView;
    }

    public Context getContext() {
        return this.mContext;
    }

    public abstract int getLayoutId();

    public abstract void initView();

    @Override // com.kugou.uilib.widget.dialog.bottomsheet.delegate.InterBottomSheetDelegate
    public void setBottomSheet(KGUIBottomSheet kGUIBottomSheet) {
        this.bottomSheet = kGUIBottomSheet;
    }
}
