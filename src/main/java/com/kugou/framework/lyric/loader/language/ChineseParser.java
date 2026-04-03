package com.kugou.framework.lyric.loader.language;

import android.support.annotation.NonNull;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ChineseParser implements ILanguageParser {
    @Override // com.kugou.framework.lyric.loader.language.ILanguageParser
    public String[][] parse(@NonNull JSONObject jSONObject) {
        String[][] strArr = null;
        try {
            JSONArray jSONArray = jSONObject.getJSONArray("lyricContent");
            int length = jSONArray.length();
            strArr = new String[length][];
            for (int i2 = 0; i2 < length; i2++) {
                JSONArray jSONArray2 = jSONArray.getJSONArray(i2);
                strArr[i2] = new String[jSONArray2.length()];
                for (int i3 = 0; i3 < jSONArray2.length(); i3++) {
                    strArr[i2][i3] = jSONArray2.optString(i3, "");
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return strArr;
    }
}
