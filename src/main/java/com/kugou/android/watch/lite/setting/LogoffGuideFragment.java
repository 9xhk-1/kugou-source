package com.kugou.android.watch.lite.setting;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.kugou.android.watch.lite.R;
import com.kugou.android.watch.lite.base.fragment.DelegateFragment;
import e.c.a.g.a.f.o.d;
import e.c.c.l.f.b;
import f.z.d.j;

/* JADX INFO: loaded from: classes2.dex */
@b(id = -1)
public final class LogoffGuideFragment extends DelegateFragment {
    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        j.e(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.fragment_logoff_guide, viewGroup, false);
    }

    @Override // com.kugou.android.watch.lite.base.fragment.AbsBaseFragment, com.kugou.android.watch.lite.base.fragment.AbsFrameworkFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        j.e(view, "view");
        super.onViewCreated(view, bundle);
        d.a(view);
        ((TextView) view.findViewById(R.id.tv_logoff_tip)).setText("请注意，注销账号为不可逆操作，注销后账号信息（涉及内容详见酷狗概念版手机端-账号注销）均会被清除。");
        ((TextView) view.findViewById(R.id.tv_logoff_content)).setText("如何注销账号？\n1、手机端（安卓/苹果）下载酷狗概念版并登录当前设备的账号；\n2、点击应用设置，打开账号和绑定设置后即可看到账号注销选择。");
    }
}
