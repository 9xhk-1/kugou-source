package com.kugou.framework.widget;

import android.view.ViewGroup;
import com.kugou.framework.widget.Workspace2;

/* JADX INFO: loaded from: classes2.dex */
public interface FlowIndicator2 extends Workspace2.OnScreenChangeListener {
    void onScrolled(int i2, int i3, int i4, int i5);

    void setWorkspace(ViewGroup viewGroup);
}
