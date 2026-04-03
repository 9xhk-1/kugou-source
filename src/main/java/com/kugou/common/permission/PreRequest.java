package com.kugou.common.permission;

import com.kugou.common.permission.install.InstallRequest;
import com.kugou.common.permission.overlay.OverlayRequest;
import com.kugou.common.permission.particular.ParticularRequest;
import com.kugou.common.permission.runtime.PermissionRequest;
import java.io.File;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class PreRequest {

    public static final class InstallRequestProxy implements InstallRequest {
        private InstallRequest installRequest;

        public InstallRequestProxy(InstallRequest installRequest) {
            this.installRequest = installRequest;
        }

        @Override // com.kugou.common.permission.install.InstallRequest
        @Deprecated
        public InstallRequest file(File file) {
            return this.installRequest.file(file);
        }

        @Override // com.kugou.common.permission.install.InstallRequest
        @Deprecated
        public InstallRequest onDenied(Action<File> action) {
            return this.installRequest.onDenied(action);
        }

        @Override // com.kugou.common.permission.install.InstallRequest
        @Deprecated
        public InstallRequest onGranted(Action<File> action) {
            return this.installRequest.onGranted(action);
        }

        @Override // com.kugou.common.permission.install.InstallRequest
        public InstallRequest rationale(Rationale<File> rationale) {
            return this.installRequest.rationale(rationale);
        }

        @Override // com.kugou.common.permission.install.InstallRequest
        @Deprecated
        public void start() {
            this.installRequest.start();
        }

        @Override // com.kugou.common.permission.install.InstallRequest
        @Deprecated
        public InstallRequest onGranted(GrantAction<File> grantAction) {
            return this.installRequest.onGranted(grantAction);
        }
    }

    public static final class OverlayRequestProxy implements OverlayRequest {
        private OverlayRequest overlayRequest;

        public OverlayRequestProxy(OverlayRequest overlayRequest) {
            this.overlayRequest = overlayRequest;
        }

        @Override // com.kugou.common.permission.overlay.OverlayRequest
        @Deprecated
        public OverlayRequest onDenied(Action<Void> action) {
            return this.overlayRequest.onDenied(action);
        }

        @Override // com.kugou.common.permission.overlay.OverlayRequest
        @Deprecated
        public OverlayRequest onGranted(Action<Void> action) {
            return this.overlayRequest.onGranted(action);
        }

        @Override // com.kugou.common.permission.overlay.OverlayRequest
        public OverlayRequest rationale(Rationale<Void> rationale) {
            return this.overlayRequest.rationale(rationale);
        }

        @Override // com.kugou.common.permission.overlay.OverlayRequest
        @Deprecated
        public void start() {
            this.overlayRequest.start();
        }

        @Override // com.kugou.common.permission.overlay.OverlayRequest
        @Deprecated
        public OverlayRequest onGranted(GrantAction<Void> grantAction) {
            return this.overlayRequest.onGranted(grantAction);
        }
    }

    public static final class ParticularRequestProxy implements ParticularRequest {
        private ParticularRequest particularRequest;

        public ParticularRequestProxy(ParticularRequest particularRequest) {
            this.particularRequest = particularRequest;
        }

        @Override // com.kugou.common.permission.particular.ParticularRequest
        @Deprecated
        public ParticularRequest onDenied(Action<Void> action) {
            return this.particularRequest.onDenied(action);
        }

        @Override // com.kugou.common.permission.particular.ParticularRequest
        @Deprecated
        public ParticularRequest onGranted(Action<Void> action) {
            return this.particularRequest.onGranted(action);
        }

        @Override // com.kugou.common.permission.particular.ParticularRequest
        public ParticularRequest rationale(Rationale<Void> rationale) {
            return this.particularRequest.rationale(rationale);
        }

        @Override // com.kugou.common.permission.particular.ParticularRequest
        @Deprecated
        public void start() {
            this.particularRequest.start();
        }

        @Override // com.kugou.common.permission.particular.ParticularRequest
        @Deprecated
        public ParticularRequest onGranted(GrantAction<Void> grantAction) {
            return this.particularRequest.onGranted(grantAction);
        }
    }

    public static final class PermissionRequestProxy implements PermissionRequest {
        private PermissionRequest permissionRequest;

        public PermissionRequestProxy(PermissionRequest permissionRequest) {
            this.permissionRequest = permissionRequest;
        }

        @Override // com.kugou.common.permission.runtime.PermissionRequest
        @Deprecated
        public PermissionRequest onDenied(Action<List<String>> action) {
            return this.permissionRequest.onDenied(action);
        }

        @Override // com.kugou.common.permission.runtime.PermissionRequest
        @Deprecated
        public PermissionRequest onGranted(Action<List<String>> action) {
            return this.permissionRequest.onGranted(action);
        }

        @Override // com.kugou.common.permission.runtime.PermissionRequest
        @Deprecated
        public PermissionRequest onRequest(Runnable runnable) {
            return this.permissionRequest.onRequest(runnable);
        }

        @Override // com.kugou.common.permission.runtime.PermissionRequest
        @Deprecated
        public PermissionRequest permission(String... strArr) {
            return this.permissionRequest.permission(strArr);
        }

        @Override // com.kugou.common.permission.runtime.PermissionRequest
        public PermissionRequest rationale(Rationale<List<String>> rationale) {
            return this.permissionRequest.rationale(rationale);
        }

        @Override // com.kugou.common.permission.runtime.PermissionRequest
        @Deprecated
        public void start() {
            this.permissionRequest.start();
        }

        @Override // com.kugou.common.permission.runtime.PermissionRequest
        @Deprecated
        public PermissionRequest onGranted(GrantAction<List<String>> grantAction) {
            return this.permissionRequest.onGranted(grantAction);
        }
    }

    public static InstallRequestProxy createInstallRequestProxy(InstallRequest installRequest) {
        return new InstallRequestProxy(installRequest);
    }

    public static OverlayRequestProxy createOverlayRequestProxy(OverlayRequest overlayRequest) {
        return new OverlayRequestProxy(overlayRequest);
    }

    public static ParticularRequestProxy createParticularRequestProxy(ParticularRequest particularRequest) {
        return new ParticularRequestProxy(particularRequest);
    }

    public static PermissionRequestProxy createPermissionRequestProxy(PermissionRequest permissionRequest) {
        return new PermissionRequestProxy(permissionRequest);
    }
}
