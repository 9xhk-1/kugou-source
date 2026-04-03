package qihoo.platform;

/* JADX INFO: loaded from: classes2.dex */
public enum PlatformManager implements IQihooPlatform {
    INSTANCE { // from class: qihoo.platform.PlatformManager.1
        @Override // qihoo.platform.IQihooPlatform
        public final String getDeviceId() {
            return null;
        }
    };

    /* synthetic */ PlatformManager() {
        this();
    }

    public static PlatformManager getInstance() {
        return INSTANCE;
    }
}
