package com.kugou.common.permission;

import android.os.Build;
import com.kugou.common.permission.PreRequest;
import com.kugou.common.permission.install.InstallRequest;
import com.kugou.common.permission.install.NRequestFactory;
import com.kugou.common.permission.install.ORequestFactory;
import com.kugou.common.permission.overlay.LRequestFactory;
import com.kugou.common.permission.overlay.MRequestFactory;
import com.kugou.common.permission.overlay.OverlayRequest;
import com.kugou.common.permission.particular.ParticularRequest;
import com.kugou.common.permission.runtime.PermissionRequest;
import com.kugou.common.permission.runtime.Runtime;
import com.kugou.common.permission.source.Source;

/* JADX INFO: loaded from: classes2.dex */
public class Options {
    private static final InstallRequestFactory INSTALL_REQUEST_FACTORY;
    private static final OverlayRequestFactory OVERLAY_REQUEST_FACTORY;
    private static final ParticularRequestFactory PARTICULAR_REQUEST_FACTORY;
    private Source mSource;

    public interface InstallRequestFactory {
        InstallRequest create(Source source);
    }

    public interface OverlayRequestFactory {
        OverlayRequest create(Source source);
    }

    public interface ParticularRequestFactory {
        ParticularRequest create(Source source);
    }

    static {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 26) {
            INSTALL_REQUEST_FACTORY = new ORequestFactory();
        } else {
            INSTALL_REQUEST_FACTORY = new NRequestFactory();
        }
        if (i2 >= 23) {
            OVERLAY_REQUEST_FACTORY = new MRequestFactory();
        } else {
            OVERLAY_REQUEST_FACTORY = new LRequestFactory();
        }
        if (i2 >= 23) {
            PARTICULAR_REQUEST_FACTORY = new com.kugou.common.permission.particular.MRequestFactory();
        } else {
            PARTICULAR_REQUEST_FACTORY = new com.kugou.common.permission.particular.LRequestFactory();
        }
    }

    public Options(Source source) {
        this.mSource = source;
    }

    public PreRequest.InstallRequestProxy install() {
        return PreRequest.createInstallRequestProxy(INSTALL_REQUEST_FACTORY.create(this.mSource));
    }

    public PreRequest.OverlayRequestProxy overlay() {
        return PreRequest.createOverlayRequestProxy(OVERLAY_REQUEST_FACTORY.create(this.mSource));
    }

    public PreRequest.ParticularRequestProxy particular() {
        return PreRequest.createParticularRequestProxy(PARTICULAR_REQUEST_FACTORY.create(this.mSource));
    }

    @Deprecated
    public PermissionRequest permission(String... strArr) {
        return runtime().permission(strArr);
    }

    public Runtime runtime() {
        return new Runtime(this.mSource);
    }

    @Deprecated
    public PermissionRequest permission(String[]... strArr) {
        return runtime().permission(strArr);
    }
}
