package com.xtc.shareapi.share.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import com.xtc.shareapi.R;
import com.xtc.shareapi.share.interfaces.IChooseSceneCallback;

/* JADX INFO: loaded from: classes2.dex */
public class ChooseSceneView extends RelativeLayout implements View.OnClickListener {
    public static final int CANCEL_TYPE = 0;
    public static final int CHAT_TYPE = 1;
    public static final int MOMENT_TYPE = 2;
    private IChooseSceneCallback callback;
    private PopWindowManager popWindowManager;

    public ChooseSceneView(Context context) {
        super(context);
        initView();
    }

    private void dealCallback(int i2) {
        IChooseSceneCallback iChooseSceneCallback = this.callback;
        if (iChooseSceneCallback == null) {
            return;
        }
        iChooseSceneCallback.setOnClickCallback(i2);
    }

    private void hideChooseSceneWindow() {
        PopWindowManager popWindowManager = this.popWindowManager;
        if (popWindowManager != null) {
            popWindowManager.hideChooseSceneWindow();
        }
    }

    private void initView() {
        View viewInflate = LayoutInflater.from(getContext()).inflate(R.layout.window_choose_scene_layout, this);
        AppLinearLayout appLinearLayout = (AppLinearLayout) viewInflate.findViewById(R.id.iv_chat_scene);
        AppLinearLayout appLinearLayout2 = (AppLinearLayout) viewInflate.findViewById(R.id.iv_moment_scene);
        Button button = (Button) viewInflate.findViewById(R.id.bt_cancel_share);
        button.setGravity(17);
        appLinearLayout.setOnClickListener(this);
        appLinearLayout2.setOnClickListener(this);
        button.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.iv_chat_scene) {
            dealCallback(1);
            hideChooseSceneWindow();
        } else if (id == R.id.iv_moment_scene) {
            dealCallback(2);
            hideChooseSceneWindow();
        } else if (id == R.id.bt_cancel_share) {
            dealCallback(0);
            hideChooseSceneWindow();
        } else {
            dealCallback(0);
            hideChooseSceneWindow();
        }
    }

    public void setCallback(IChooseSceneCallback iChooseSceneCallback) {
        this.callback = iChooseSceneCallback;
    }

    public void setPopWindow(PopWindowManager popWindowManager) {
        this.popWindowManager = popWindowManager;
    }
}
