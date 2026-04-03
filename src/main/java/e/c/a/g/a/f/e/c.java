package e.c.a.g.a.f.e;

import android.content.Context;
import android.text.TextUtils;
import com.kugou.android.watch.lite.R;
import com.kugou.common.config.BaseConfigManager;
import com.kugou.common.config.ConfigKey;
import e.c.a.g.a.s.g0;
import e.c.a.g.a.s.l1;
import f.c0.e;
import f.f;
import f.g;
import f.z.d.j;
import f.z.d.k;
import f.z.d.n;
import f.z.d.s;

/* JADX INFO: loaded from: classes.dex */
public final class c extends BaseConfigManager {
    public static final b a = new b(null);
    public static final f.d<c> b = f.a(g.SYNCHRONIZED, a.a);

    public static final class a extends k implements f.z.c.a<c> {
        public static final a a = new a();

        public a() {
            super(0);
        }

        @Override // f.z.c.a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final c invoke() {
            return new c(null);
        }
    }

    public static final class b {
        public static final /* synthetic */ e<Object>[] a;

        static {
            n nVar = new n(s.a(b.class), "instance", "getInstance()Lcom/kugou/android/watch/lite/common/config/KGConfigManager;");
            s.c(nVar);
            a = new e[]{nVar};
        }

        public b() {
        }

        public /* synthetic */ b(f.z.d.g gVar) {
            this();
        }

        public final c a() {
            return (c) c.b.getValue();
        }
    }

    public c() {
    }

    public /* synthetic */ c(f.z.d.g gVar) {
        this();
    }

    public static final c c() {
        return a.a();
    }

    public final String b(ConfigKey configKey, String str) {
        String config = super.getConfig(configKey);
        return !TextUtils.isEmpty(config) ? config : str;
    }

    @Override // com.kugou.common.config.BaseConfigManager
    public String getChannel() {
        String strJ = l1.j();
        j.d(strJ, "getChannel()");
        return strJ;
    }

    @Override // com.kugou.common.config.BaseConfigManager
    public String getConfig(ConfigKey configKey) {
        String config = super.getConfig(configKey);
        if (g0.a) {
            StringBuilder sb = new StringBuilder();
            sb.append("getConfig: name=");
            sb.append((Object) (configKey == null ? null : configKey.key));
            sb.append(", value=");
            sb.append((Object) config);
            g0.b(BaseConfigManager.TAG, sb.toString());
        }
        return config == null ? "" : config;
    }

    @Override // com.kugou.common.config.BaseConfigManager
    public boolean getConfigAsBoolean(ConfigKey configKey, boolean z) {
        String config = getConfig(configKey);
        if (!TextUtils.isEmpty(config)) {
            try {
                if (f.e0.n.l("true", config, true)) {
                    return true;
                }
                return j.a("1", config);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return z;
    }

    @Override // com.kugou.common.config.BaseConfigManager
    public float getConfigAsFloat(ConfigKey configKey, float f2) {
        String config = getConfig(configKey);
        if (config.length() > 0) {
            try {
                return Float.parseFloat(config);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return f2;
    }

    @Override // com.kugou.common.config.BaseConfigManager
    public int getConfigAsInt(ConfigKey configKey, int i2) {
        String config = getConfig(configKey);
        if (config.length() > 0) {
            try {
                return Integer.parseInt(config);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return i2;
    }

    @Override // com.kugou.common.config.BaseConfigManager
    public String getConfigFileName() {
        return "config";
    }

    @Override // com.kugou.common.config.BaseConfigManager
    public String getConfigTempName() {
        return "config.tmp";
    }

    @Override // com.kugou.common.config.BaseConfigManager
    public Context getContext() {
        Context contextA = e.c.c.o.f.a();
        j.d(contextA, "getContext()");
        return contextA;
    }

    @Override // com.kugou.common.config.BaseConfigManager
    public int getDefaultFileRawId() {
        return R.raw.config;
    }

    @Override // com.kugou.common.config.BaseConfigManager
    public boolean isCoverInstall() {
        return false;
    }

    @Override // com.kugou.common.config.BaseConfigManager
    public boolean isTest() {
        return false;
    }
}
