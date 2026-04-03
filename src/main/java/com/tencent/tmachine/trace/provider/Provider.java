package com.tencent.tmachine.trace.provider;

import com.tencent.tmachine.trace.core.ErrorExtra;
import com.tencent.tmachine.trace.core.IProviderListener;
import f.z.d.g;
import f.z.d.j;

/* JADX INFO: loaded from: classes2.dex */
public class Provider implements IProvider {
    public static final Companion Companion = new Companion(null);
    public static final int PROVIDER_CREATED = 0;
    public static final int PROVIDER_DESTROYED = 8;
    public static final int PROVIDER_DISABLED = 4;
    public static final int PROVIDER_ENABLED = 2;
    public static final int PROVIDER_INITIALIZED = 1;
    private IProviderListener providerListener;
    private int providerStatus;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }
    }

    @Override // com.tencent.tmachine.trace.provider.IProvider
    public boolean destroy() {
        int i2 = this.providerStatus;
        if (i2 == 1 || i2 == 2 || i2 == 4) {
            this.providerStatus = 8;
            IProviderListener iProviderListener = this.providerListener;
            if (iProviderListener != null) {
                iProviderListener.onDestroy(this);
            }
        }
        return true;
    }

    @Override // com.tencent.tmachine.trace.provider.IProvider
    public boolean disable() {
        if (this.providerStatus != 2) {
            return true;
        }
        this.providerStatus = 4;
        IProviderListener iProviderListener = this.providerListener;
        if (iProviderListener == null) {
            return true;
        }
        iProviderListener.onDisable(this);
        return true;
    }

    @Override // com.tencent.tmachine.trace.provider.IProvider
    public boolean enable() {
        int i2 = this.providerStatus;
        if (i2 == 1 || i2 == 4) {
            this.providerStatus = 2;
            IProviderListener iProviderListener = this.providerListener;
            if (iProviderListener != null) {
                iProviderListener.onEnable(this);
            }
        }
        return true;
    }

    @Override // com.tencent.tmachine.trace.provider.IProvider
    public void error(ErrorExtra errorExtra) {
        IProviderListener iProviderListener = this.providerListener;
        if (iProviderListener != null) {
            iProviderListener.onError(this, errorExtra);
        }
    }

    public final IProviderListener getProviderListener() {
        return this.providerListener;
    }

    public final int getProviderStatus() {
        return this.providerStatus;
    }

    @Override // com.tencent.tmachine.trace.provider.IProvider
    public boolean init(IProviderListener iProviderListener) {
        j.f(iProviderListener, "providerListener");
        int i2 = this.providerStatus;
        if (i2 == 0 || i2 == 8) {
            this.providerStatus = 1;
            this.providerListener = iProviderListener;
            if (iProviderListener != null) {
                iProviderListener.onInit(this);
            }
        }
        return true;
    }

    public final void setProviderListener(IProviderListener iProviderListener) {
        this.providerListener = iProviderListener;
    }

    public final void setProviderStatus(int i2) {
        this.providerStatus = i2;
    }
}
