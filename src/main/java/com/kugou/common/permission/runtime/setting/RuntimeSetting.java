package com.kugou.common.permission.runtime.setting;

import com.kugou.common.permission.PermissionActivity;
import com.kugou.common.permission.Setting;
import com.kugou.common.permission.source.Source;
import com.kugou.common.permission.util.MainExecutor;

/* JADX INFO: loaded from: classes2.dex */
public class RuntimeSetting implements Setting, PermissionActivity.RequestListener {
    private static final MainExecutor EXECUTOR = new MainExecutor();
    private Setting.Action mComeback;
    private Source mSource;

    public RuntimeSetting(Source source) {
        this.mSource = source;
    }

    @Override // com.kugou.common.permission.SettingService
    public void cancel() {
    }

    @Override // com.kugou.common.permission.SettingService
    public void execute() {
        new RuntimeSettingPage(this.mSource).start(-1);
    }

    @Override // com.kugou.common.permission.Setting
    public Setting onComeback(Setting.Action action) {
        this.mComeback = action;
        return this;
    }

    @Override // com.kugou.common.permission.PermissionActivity.RequestListener
    public void onRequestCallback() {
        EXECUTOR.postDelayed(new Runnable() { // from class: com.kugou.common.permission.runtime.setting.RuntimeSetting.1
            @Override // java.lang.Runnable
            public void run() {
                if (RuntimeSetting.this.mComeback != null) {
                    RuntimeSetting.this.mComeback.onAction();
                }
            }
        }, 100L);
    }

    @Override // com.kugou.common.permission.Setting
    public void start() {
        PermissionActivity.permissionSetting(this.mSource.getContext(), this);
    }

    @Override // com.kugou.common.permission.SettingService
    public void execute(int i2) {
        new RuntimeSettingPage(this.mSource).start(i2);
    }
}
