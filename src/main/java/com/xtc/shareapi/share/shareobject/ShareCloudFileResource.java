package com.xtc.shareapi.share.shareobject;

import android.os.Bundle;
import android.util.Log;
import com.xtc.shareapi.share.communication.BaseResponse;
import com.xtc.shareapi.share.communication.ShowMessageFromXTC;
import com.xtc.shareapi.share.constant.OpenApiConstant;
import com.xtc.shareapi.share.interfaces.IBundleSerialize;

/* JADX INFO: loaded from: classes2.dex */
public class ShareCloudFileResource implements IBundleSerialize {
    private static final int DOWNLOAD_URL_LENGTH_LIMIT = 2048;
    public static final int HEIGHT = 360;
    private static final int KEY_LENGTH_LIMIT = 1024;
    private static final String TAG = OpenApiConstant.TAG + ShareCloudFileResource.class.getSimpleName();
    public static final int WIDTH = 320;
    private String downloadUrl;
    private String key;
    private long urlDeadline;
    private int width = WIDTH;
    private int height = HEIGHT;

    public ShareCloudFileResource() {
    }

    @Override // com.xtc.shareapi.share.interfaces.IBundleSerialize
    public BaseResponse checkArgs() {
        ShowMessageFromXTC.Response response = new ShowMessageFromXTC.Response();
        String str = this.key;
        if (str != null && str.length() > 1024) {
            Log.e(TAG, "checkArgs fail, key is invalid");
            response.setCode(6);
            response.setErrorDesc("checkArgs fail, key is invalid");
            return response;
        }
        String str2 = this.downloadUrl;
        if (str2 != null && str2.length() > 2048) {
            Log.e(TAG, "checkArgs fail, downloadUrl is null");
            response.setCode(6);
            response.setErrorDesc("checkArgs fail, downloadUrl is null");
            return response;
        }
        long j = this.urlDeadline;
        if (j != 0) {
            Log.e(TAG, "checkArgs fail, urlDeadline is 0");
            response.setCode(6);
            response.setErrorDesc("checkArgs fail, urlDeadline is 0");
            return response;
        }
        if (j != 0) {
            Log.e(TAG, "checkArgs fail, urlDeadline is 0");
            response.setCode(6);
            response.setErrorDesc("checkArgs fail, urlDeadline is 0");
            return response;
        }
        if (j == 0) {
            response.setCode(1);
            return response;
        }
        Log.e(TAG, "checkArgs fail, urlDeadline is 0");
        response.setCode(6);
        response.setErrorDesc("checkArgs fail, urlDeadline is 0");
        return response;
    }

    @Override // com.xtc.shareapi.share.interfaces.IBundleSerialize
    public IBundleSerialize fromBundle(Bundle bundle) {
        ShareCloudFileResource shareCloudFileResource = new ShareCloudFileResource();
        shareCloudFileResource.setDownloadUrl(bundle.getString(OpenApiConstant.ShareCloudFileConstant.BUNDLE_FILE_DOWNLOAD_URL));
        shareCloudFileResource.setKey(bundle.getString(OpenApiConstant.ShareCloudFileConstant.BUNDLE_FILE_KEY));
        shareCloudFileResource.setUrlDeadline(bundle.getLong(OpenApiConstant.ShareCloudFileConstant.BUNDLE_FILE_URL_DEADLINE));
        shareCloudFileResource.setWidth(bundle.getInt(OpenApiConstant.ShareCloudFileConstant.BUNDLE_FILE_WIDTH));
        shareCloudFileResource.setHeight(bundle.getInt(OpenApiConstant.ShareCloudFileConstant.BUNDLE_FILE_HEIGHT));
        return shareCloudFileResource;
    }

    public String getDownloadUrl() {
        return this.downloadUrl;
    }

    public int getHeight() {
        return this.height;
    }

    public String getKey() {
        return this.key;
    }

    public long getUrlDeadline() {
        return this.urlDeadline;
    }

    public int getWidth() {
        return this.width;
    }

    public void setDownloadUrl(String str) {
        this.downloadUrl = str;
    }

    public void setHeight(int i2) {
        this.height = i2;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public void setUrlDeadline(long j) {
        this.urlDeadline = j;
    }

    public void setWidth(int i2) {
        this.width = i2;
    }

    @Override // com.xtc.shareapi.share.interfaces.IBundleSerialize
    public void toBundle(Bundle bundle) {
        bundle.putString(OpenApiConstant.ShareCloudFileConstant.BUNDLE_FILE_DOWNLOAD_URL, this.downloadUrl);
        bundle.putString(OpenApiConstant.ShareCloudFileConstant.BUNDLE_FILE_KEY, this.key);
        bundle.putLong(OpenApiConstant.ShareCloudFileConstant.BUNDLE_FILE_URL_DEADLINE, this.urlDeadline);
        bundle.putInt(OpenApiConstant.ShareCloudFileConstant.BUNDLE_FILE_WIDTH, this.width);
        bundle.putInt(OpenApiConstant.ShareCloudFileConstant.BUNDLE_FILE_HEIGHT, this.height);
    }

    public String toString() {
        return "CloudFileResource{key='" + this.key + "', downloadUrl='" + this.downloadUrl + "', urlDeadline=" + this.urlDeadline + ", width=" + this.width + ", height=" + this.height + '}';
    }

    public ShareCloudFileResource(String str, String str2, long j) {
        this.key = str;
        this.downloadUrl = str2;
        this.urlDeadline = j;
    }
}
