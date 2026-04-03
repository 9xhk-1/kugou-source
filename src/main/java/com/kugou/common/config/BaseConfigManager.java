package com.kugou.common.config;

import android.content.Context;
import android.text.TextUtils;
import android.util.JsonReader;
import android.util.JsonToken;
import com.kugou.common.config.util.FileUtil;
import com.kugou.common.config.util.PropertiesLoader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public abstract class BaseConfigManager {
    public static final String KG_ASSETS_TEST_FILE = "kgconfigtest.properties";
    public static final String TAG = "ConfigManager";
    public File localConfigFile = null;
    public File localConfigTemp = null;
    private HashMap<ConfigKey, ConfigValue> configs = new HashMap<>();
    public Map<String, String> valueKeyCache = new ConcurrentHashMap();

    public BaseConfigManager() throws Throwable {
        if (isCoverInstall()) {
            onCoverInstall();
        }
        initialize();
    }

    private void addToValueKeyCache(String str, String str2) {
        Map<String, String> map = this.valueKeyCache;
        if (map == null || map.get(str) == null) {
            this.valueKeyCache.put(str, str2);
        }
    }

    private void onCoverInstall() {
        File filesDir = getContext().getFilesDir();
        if (filesDir.exists()) {
            File file = new File(filesDir, getConfigFileName());
            KGConfigLog.e("localConfigFile", "localConfigFile length, BaseConfigManager file:" + file.length());
            KGConfigLog.e("localConfigFile", "localConfigFile length, BaseConfigManager file:" + file.getAbsolutePath());
            KGConfigLog.e("localConfigFile", "old localConfigFile BaseConfigManager deleted, " + FileUtil.deleteFile(file) + " file:" + file.length());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:68:0x0129 A[Catch: Exception -> 0x0125, TRY_LEAVE, TryCatch #6 {Exception -> 0x0125, blocks: (B:64:0x0121, B:68:0x0129), top: B:77:0x0121 }] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0121 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void parseCacheConfig() throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 307
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kugou.common.config.BaseConfigManager.parseCacheConfig():void");
    }

    private void parseDefaultConfig() {
        try {
            JsonReader jsonReader = new JsonReader(new InputStreamReader(getContext().getResources().openRawResource(getDefaultFileRawId()), "UTF-8"));
            if (jsonReader.peek() == JsonToken.BEGIN_OBJECT) {
                jsonReader.beginObject();
                while (jsonReader.hasNext()) {
                    updateConfig(jsonReader.nextName(), jsonReader.nextString());
                }
                jsonReader.endObject();
            }
            jsonReader.close();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void parseProperties(InputStream inputStream) throws IOException {
        try {
            for (Map.Entry<Object, Object> entry : PropertiesLoader.load(new InputStreamReader(inputStream, "UTF-8")).entrySet()) {
                String string = entry.getKey().toString();
                String string2 = entry.getValue().toString();
                KGConfigLog.d("nathaniel", "key:" + string + " value:" + string2);
                updateConfig(string, string2);
            }
        } finally {
            inputStream.close();
        }
    }

    private void updateConfig(String str, String str2) {
        if (this.configs == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.configs.put(new ConfigKey(str), new ConfigValue(str2));
    }

    public void deleteFileWhenCover() {
        File filesDir = getContext().getFilesDir();
        if (!filesDir.exists()) {
            filesDir.mkdirs();
        }
        File file = new File(filesDir, getConfigFileName());
        File file2 = new File(filesDir, getConfigTempName());
        KGConfigLog.d("localConfigFile", "delete localConfigFile" + FileUtil.deleteFile(file));
        FileUtil.deleteFile(file2);
        KGConfigLog.d("localConfigFile", "delete localConfigTemp" + FileUtil.deleteFile(file2));
    }

    public void deleteLocalConfigFile() throws Throwable {
        deleteLocalConfigFileInner(getConfigFileName());
    }

    public void deleteLocalConfigFileInner(String str) throws Throwable {
        boolean zDeleteFile;
        File filesDir = getContext().getFilesDir();
        if (filesDir.exists()) {
            File file = new File(filesDir, str);
            KGConfigLog.e("localConfigFile", "localConfigFile length,  file:" + file.length());
            KGConfigLog.e("localConfigFile", "localConfigFile length,  file:" + file.getAbsolutePath());
            zDeleteFile = FileUtil.deleteFile(file);
            KGConfigLog.e("localConfigFile", "old localConfigFile deleted, " + zDeleteFile + " file:" + file.length());
        } else {
            zDeleteFile = false;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("cursorId ");
        ConfigKey configKey = BasicKeys.cursorId;
        sb.append(getConfigAsInt(configKey));
        KGConfigLog.e("localConfigFile", sb.toString());
        if (zDeleteFile) {
            resetConfigManager();
        }
        KGConfigLog.e("localConfigFile", "after cursorId " + getConfigAsInt(configKey));
    }

    @Deprecated
    public HashMap<ConfigKey, ConfigValue> getAllConfigs() {
        return this.configs;
    }

    public String[] getAllValuesOfConfig(ConfigKey configKey) {
        ConfigValue configValue;
        if (configKey == null || (configValue = this.configs.get(configKey)) == null) {
            return null;
        }
        if (configValue.getAllValues() != null && configValue.getAllValues().length > 0) {
            addToValueKeyCache(configValue.getAllValues()[0], configValue.schemeCode);
        }
        return configValue.getAllValues();
    }

    public abstract String getChannel();

    public String getConfig(ConfigKey configKey) {
        ConfigValue configValue;
        if (configKey == null || (configValue = this.configs.get(configKey)) == null) {
            KGConfigLog.d(TAG, "getConfig empty-" + configKey);
            return "";
        }
        String value = configValue.getValue();
        KGConfigLog.d(TAG, "getConfig-" + configKey + ": " + value);
        addToValueKeyCache(value, configValue.schemeCode);
        return value;
    }

    public boolean getConfigAsBoolean(ConfigKey configKey) {
        return getConfigAsBoolean(configKey, false);
    }

    public float getConfigAsFloat(ConfigKey configKey) {
        return getConfigAsFloat(configKey, 0.0f);
    }

    public int getConfigAsInt(ConfigKey configKey) {
        try {
            return Integer.parseInt(getConfig(configKey));
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    public long getConfigAsLong(ConfigKey configKey) {
        try {
            return Long.parseLong(getConfig(configKey));
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0L;
        }
    }

    public File getConfigFile() {
        return this.localConfigFile;
    }

    public abstract String getConfigFileName();

    public File getConfigTemp() {
        return this.localConfigTemp;
    }

    public abstract String getConfigTempName();

    public int getConfigTryCount(ConfigKey configKey) {
        ConfigValue configValue = this.configs.get(configKey);
        if (configValue != null) {
            return configValue.getTryCount();
        }
        return 0;
    }

    public abstract Context getContext();

    public int getCurIndexOfConfig(ConfigKey configKey) {
        ConfigValue configValue;
        if (configKey == null || (configValue = this.configs.get(configKey)) == null) {
            return -1;
        }
        return configValue.getCurIndex();
    }

    public abstract int getDefaultFileRawId();

    public String getSchemeCode(ConfigKey configKey) {
        ConfigValue configValue;
        if (configKey == null || (configValue = this.configs.get(configKey)) == null) {
            return "";
        }
        addToValueKeyCache(configValue.getValue(), configValue.schemeCode);
        return configValue.schemeCode;
    }

    public String getSchemeCodeByValue(String str) {
        return (str == null || str.length() != 0) ? "" : this.valueKeyCache.get(str);
    }

    public void initialize() throws Throwable {
        File filesDir = getContext().getFilesDir();
        if (!filesDir.exists()) {
            filesDir.mkdirs();
        }
        this.localConfigFile = new File(filesDir, getConfigFileName());
        this.localConfigTemp = new File(filesDir, getConfigTempName());
        parseDefaultConfig();
        parseCacheConfig();
        parseTestProperties();
    }

    public abstract boolean isCoverInstall();

    public abstract boolean isTest();

    public void parseTestProperties() {
        if (isTest()) {
            try {
                parseProperties(getContext().getAssets().open(KG_ASSETS_TEST_FILE));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void resetConfigManager() throws Throwable {
        KGConfigLog.d("BLUE", "resetConfigManager");
        this.configs = new HashMap<>();
        initialize();
    }

    public boolean saveJSONObjectToFile(JSONObject jSONObject) throws Exception {
        File configTemp = getConfigTemp();
        File configFile = getConfigFile();
        if (configTemp != null && configTemp.exists()) {
            FileUtil.deleteFile(configTemp);
        }
        BufferedWriter bufferedWriter = null;
        try {
            BufferedWriter bufferedWriter2 = new BufferedWriter(new FileWriter(configTemp));
            try {
                bufferedWriter2.write(jSONObject.toString());
                bufferedWriter2.close();
                if (configFile != null && configFile.exists()) {
                    FileUtil.deleteFile(configFile);
                }
                return configTemp.renameTo(configFile);
            } catch (Throwable th) {
                th = th;
                bufferedWriter = bufferedWriter2;
                if (bufferedWriter != null) {
                    bufferedWriter.close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public void triggerConfigFail(ConfigKey configKey, String str) {
        ConfigValue configValue = this.configs.get(configKey);
        if (configValue != null) {
            configValue.triggerFail(str);
        }
    }

    public void updateFromCache() throws Throwable {
        parseCacheConfig();
        parseTestProperties();
        KGConfigLog.d(TAG, "更新内存缓存");
    }

    public boolean getConfigAsBoolean(ConfigKey configKey, boolean z) {
        try {
            String config = getConfig(configKey);
            if ("true".equalsIgnoreCase(config)) {
                return true;
            }
            return "1".equals(config);
        } catch (Exception e2) {
            e2.printStackTrace();
            return z;
        }
    }

    public float getConfigAsFloat(ConfigKey configKey, float f2) {
        try {
            return Float.parseFloat(getConfig(configKey));
        } catch (Exception e2) {
            e2.printStackTrace();
            e2.printStackTrace();
            return f2;
        }
    }

    public int getConfigAsInt(ConfigKey configKey, int i2) {
        try {
            return Integer.parseInt(getConfig(configKey));
        } catch (Exception e2) {
            e2.printStackTrace();
            return i2;
        }
    }

    public long getConfigAsLong(ConfigKey configKey, long j) {
        try {
            return Long.parseLong(getConfig(configKey));
        } catch (Exception e2) {
            e2.printStackTrace();
            return j;
        }
    }
}
