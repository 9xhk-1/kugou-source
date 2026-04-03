package com.kugou.common.config;

import android.text.TextUtils;
import com.kugou.common.config.v2.UpdateConfigResponseV2;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class KGConfigUpdaterBase {
    public void execute() {
        try {
            UpdateConfigResponseV2 updateConfigResponseV2RequestUpdates = requestUpdates();
            if (!(updateConfigResponseV2RequestUpdates != null && saveConfig(updateConfigResponseV2RequestUpdates.cursorId, updateConfigResponseV2RequestUpdates.profileList))) {
                KGConfigLog.d("KGConfigUpdater", "KGConfigUpdater.execute.saveConfig.failed");
            } else {
                onSaveSuccess(updateConfigResponseV2RequestUpdates);
                KGConfigLog.d("KGConfigUpdater", "KGConfigUpdater.execute.saveConfig.success");
            }
        } catch (Exception e2) {
            onException(e2);
        }
    }

    public abstract int getCursorId();

    public abstract String getPackageChannelId();

    public abstract File getWholeConfigFile();

    public abstract void onException(Exception exc);

    public abstract void onSaveSuccess(UpdateConfigResponseV2 updateConfigResponseV2);

    public abstract UpdateConfigResponseV2 requestUpdates();

    public boolean saveConfig(int i2, List<String> list) throws Throwable {
        String line;
        try {
            if (i2 < getCursorId()) {
                return false;
            }
            File wholeConfigFile = getWholeConfigFile();
            String string = null;
            BufferedReader bufferedReader = null;
            string = null;
            if (wholeConfigFile != null && wholeConfigFile.exists()) {
                StringBuilder sb = new StringBuilder();
                try {
                    BufferedReader bufferedReader2 = new BufferedReader(new FileReader(wholeConfigFile));
                    do {
                        try {
                            line = bufferedReader2.readLine();
                            if (line != null) {
                                sb.append(line);
                            }
                        } catch (Throwable th) {
                            th = th;
                            bufferedReader = bufferedReader2;
                            if (bufferedReader != null) {
                                bufferedReader.close();
                            }
                            throw th;
                        }
                    } while (line != null);
                    bufferedReader2.close();
                    string = sb.toString();
                } catch (Throwable th2) {
                    th = th2;
                }
            }
            if (TextUtils.isEmpty(string)) {
                string = "{}";
            }
            JSONObject jSONObject = new JSONObject(string);
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                JSONObject jSONObject2 = new JSONObject(it.next());
                Iterator<String> itKeys = jSONObject2.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    jSONObject.put(next, jSONObject2.get(next));
                }
            }
            jSONObject.put(BasicKeys.cursorId.key, i2);
            jSONObject.put(BasicKeys.channelid.key, getPackageChannelId());
            return saveDataToCache(i2, jSONObject);
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public abstract boolean saveDataToCache(int i2, JSONObject jSONObject) throws Exception;
}
