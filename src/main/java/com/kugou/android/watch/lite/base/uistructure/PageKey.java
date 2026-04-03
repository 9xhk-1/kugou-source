package com.kugou.android.watch.lite.base.uistructure;

import android.text.TextUtils;
import com.kugou.android.watch.lite.common.INoGuard;
import e.c.a.g.a.f.e.b;
import e.c.a.g.a.f.e.c;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class PageKey implements INoGuard {
    private String fo;
    private int pageId;
    private String pagePath;
    private String pageStack;

    private PageKey(String str, int i2, String str2) {
        this.pagePath = str;
        this.pageId = i2;
        this.pageStack = str2;
    }

    public static PageKey fromJson(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            int iOptInt = jSONObject.optInt("page_id", 0);
            String strOptString = jSONObject.optString("ppage_id", "");
            if (iOptInt > 0) {
                return new PageKey("", iOptInt, strOptString);
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return null;
    }

    public static PageKey make(String str, int i2, String str2) {
        return new PageKey(str, i2, str2);
    }

    public String getFo() {
        return this.fo;
    }

    public int getPageId() {
        return this.pageId;
    }

    public String getPagePath() {
        return this.pagePath;
    }

    public String getPageStack() {
        return this.pageStack;
    }

    public String getPageStackSplit() {
        String str = this.pageStack;
        if (str == null || str.length() == 0) {
            return "";
        }
        String strReplaceAll = this.pageStack.replaceAll("/", ",").replaceAll(this.pageId + "", "");
        if (strReplaceAll.startsWith(",")) {
            strReplaceAll = strReplaceAll.substring(1, strReplaceAll.length());
        }
        if (strReplaceAll.endsWith(",")) {
            strReplaceAll = strReplaceAll.substring(0, strReplaceAll.length() - 1);
        }
        if (strReplaceAll.endsWith(",")) {
            strReplaceAll = strReplaceAll.substring(0, strReplaceAll.length() - 1);
        }
        return c.c().getConfig(b.r).contains(Integer.toString(this.pageId)) ? Integer.toString(356753938) : (TextUtils.isEmpty(strReplaceAll) && this.pageId == 356753938) ? Integer.toString(356753938) : strReplaceAll;
    }

    public void setFo(String str) {
        this.fo = str;
    }

    public String toJson() {
        return "{\"page_id\":" + this.pageId + " ,\"ppage_id\":\"" + getPageStackSplit() + "\" }";
    }

    public static PageKey make(PageKey pageKey, String str) {
        return new PageKey(pageKey.pagePath, pageKey.pageId, pageKey.pageStack, str);
    }

    public PageKey(String str, int i2, String str2, String str3) {
        this.pagePath = str;
        this.pageId = i2;
        this.pageStack = str2;
        this.fo = str3;
    }
}
