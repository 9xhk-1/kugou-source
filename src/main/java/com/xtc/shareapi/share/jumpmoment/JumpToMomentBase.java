package com.xtc.shareapi.share.jumpmoment;

import android.text.TextUtils;
import android.util.Log;
import com.xtc.shareapi.share.bean.PoiBean;
import com.xtc.shareapi.share.communication.BaseResponse;
import com.xtc.shareapi.share.communication.ShowMessageFromXTC;
import com.xtc.shareapi.share.interfaces.IJumpToMomentObject;

/* JADX INFO: loaded from: classes2.dex */
public class JumpToMomentBase implements IJumpToMomentObject {
    private static final String TAG = "Share_JumpToMomentBase";
    private PoiBean poiBean;
    private String text;

    public static String getTAG() {
        return TAG;
    }

    @Override // com.xtc.shareapi.share.interfaces.IJumpToMomentObject
    public BaseResponse checkArgs() {
        ShowMessageFromXTC.Response response = new ShowMessageFromXTC.Response();
        if (!TextUtils.isEmpty(this.text) && this.text.length() > 40) {
            Log.e(TAG, "check fail , text length is more than 40");
            response.setCode(6);
            response.setErrorDesc("check fail , text length is more than 40");
            return response;
        }
        PoiBean poiBean = this.poiBean;
        if (poiBean != null) {
            return poiBean.checkArgs();
        }
        if (TextUtils.isEmpty(this.text) && this.poiBean == null) {
            Log.e(TAG, "check fail , text or poi is at least one ");
            return response;
        }
        response.setCode(1);
        return response;
    }

    public PoiBean getPoiBean() {
        return this.poiBean;
    }

    public String getText() {
        return this.text;
    }

    public void setPoiBean(PoiBean poiBean) {
        this.poiBean = poiBean;
    }

    public void setText(String str) {
        this.text = str;
    }

    @Override // com.xtc.shareapi.share.interfaces.IJumpToMomentObject
    public int type() {
        return 2;
    }
}
