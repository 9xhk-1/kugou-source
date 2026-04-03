package com.xtc.shareapi.share.bean;

import android.os.Bundle;
import com.xtc.shareapi.share.communication.BaseResponse;
import com.xtc.shareapi.share.communication.ShowMessageFromXTC;
import com.xtc.shareapi.share.interfaces.IBundleSerialize;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public class BundleMap implements IBundleSerialize {
    private HashMap<String, String> map;

    @Override // com.xtc.shareapi.share.interfaces.IBundleSerialize
    public BaseResponse checkArgs() {
        ShowMessageFromXTC.Response response = new ShowMessageFromXTC.Response();
        response.setCode(1);
        return response;
    }

    @Override // com.xtc.shareapi.share.interfaces.IBundleSerialize
    public IBundleSerialize fromBundle(Bundle bundle) {
        return new BundleMap();
    }

    public HashMap<String, String> getMap() {
        return this.map;
    }

    public void setMap(HashMap<String, String> map) {
        this.map = map;
    }

    @Override // com.xtc.shareapi.share.interfaces.IBundleSerialize
    public void toBundle(Bundle bundle) {
    }

    public String toString() {
        return "BundleMap{map=" + this.map + '}';
    }
}
