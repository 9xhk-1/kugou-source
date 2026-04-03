package e.c.a.g.a.f.k;

import android.text.TextUtils;
import com.kugou.common.config.ConfigKey;
import com.kugou.common.network.protocol.AbstractMultiUrlRequestPackage;

/* JADX INFO: loaded from: classes.dex */
public abstract class a extends AbstractMultiUrlRequestPackage {
    @Override // com.kugou.common.network.protocol.AbstractMultiUrlRequestPackage
    public String[] getAllUrls() {
        return e.c.a.g.a.f.e.c.c().getAllValuesOfConfig(new ConfigKey(getConfigKeyString()));
    }

    @Override // com.kugou.common.network.protocol.AbstractMultiUrlRequestPackage
    public String getConfigKeyString() {
        ConfigKey urlConfigKey = getUrlConfigKey();
        if (urlConfigKey == null) {
            return null;
        }
        return urlConfigKey.toString();
    }

    @Override // com.kugou.common.network.protocol.AbstractMultiUrlRequestPackage
    public int getConfigTryCount() {
        return e.c.a.g.a.f.e.c.c().getConfigTryCount(getUrlConfigKey());
    }

    public String getDefaultUrl() {
        return "";
    }

    @Override // com.kugou.common.network.protocol.RequestPackage
    @Deprecated
    public String getUrl() {
        String config = e.c.a.g.a.f.e.c.c().getConfig(new ConfigKey(getConfigKeyString()));
        return TextUtils.isEmpty(config) ? getDefaultUrl() : config;
    }

    public abstract ConfigKey getUrlConfigKey();

    @Override // com.kugou.common.network.protocol.AbstractMultiUrlRequestPackage
    public void triggerConfigFail(String str, String str2) {
        e.c.a.g.a.f.e.c.c().triggerConfigFail(new ConfigKey(str), str2);
    }
}
