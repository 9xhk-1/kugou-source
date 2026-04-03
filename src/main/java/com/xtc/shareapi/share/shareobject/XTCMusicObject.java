package com.xtc.shareapi.share.shareobject;

import android.os.Bundle;
import android.util.Log;
import com.xtc.shareapi.share.communication.BaseResponse;
import com.xtc.shareapi.share.communication.ShowMessageFromXTC;
import com.xtc.shareapi.share.constant.OpenApiConstant;
import com.xtc.shareapi.share.interfaces.IShareObject;

/* JADX INFO: loaded from: classes2.dex */
public class XTCMusicObject implements IShareObject {
    private static final int LENGTH_LIMIT = 1024;
    private static final String TAG = OpenApiConstant.TAG + XTCMusicObject.class.getSimpleName();
    private String author;
    private long duration;
    private String extInfo;
    private String musicHighUrl;
    private String musicLowUrl;
    private String musicName;
    private String musicUrl;
    private String startActivity;

    public XTCMusicObject() {
    }

    @Override // com.xtc.shareapi.share.interfaces.IBundleSerialize
    public BaseResponse checkArgs() {
        String str;
        ShowMessageFromXTC.Response response = new ShowMessageFromXTC.Response();
        String str2 = this.musicUrl;
        if ((str2 == null || str2.length() == 0) && ((this.musicLowUrl == null || this.musicHighUrl.length() == 0) && ((str = this.musicHighUrl) == null || str.length() == 0))) {
            Log.e(TAG, "both arguments are null");
            response.setCode(6);
            response.setErrorDesc("share_argument_error,both arguments are null");
            return response;
        }
        String str3 = this.musicUrl;
        if (str3 != null && str3.length() > 1024) {
            Log.e(TAG, "checkArgs fail, musicUrl is too long");
            response.setCode(6);
            response.setErrorDesc("share_argument_error,musicUrl is too long");
            return response;
        }
        String str4 = this.musicLowUrl;
        if (str4 != null && str4.length() > 1024) {
            Log.e(TAG, "checkArgs fail, musicLowBandUrl is too long");
            response.setCode(6);
            response.setErrorDesc("share_argument_error,musicLowBandUrl is too long");
            return response;
        }
        String str5 = this.musicHighUrl;
        if (str5 != null && str5.length() > 1024) {
            Log.e(TAG, "checkArgs fail, musicHighBandUrl is too long");
            response.setCode(6);
            response.setErrorDesc("share_argument_error,musicHighBandUrl is too long");
            return response;
        }
        String str6 = this.musicName;
        if (str6 != null && str6.length() > 1024) {
            Log.e(TAG, "checkArgs fail, musicName is too long");
            response.setCode(6);
            response.setErrorDesc("share_argument_error,musicName is too long");
            return response;
        }
        String str7 = this.author;
        if (str7 != null && str7.length() > 1024) {
            Log.e(TAG, "checkArgs fail, author name is too long");
            response.setCode(6);
            response.setErrorDesc("share_argument_error,author name is too long");
            return response;
        }
        String str8 = this.startActivity;
        if (str8 != null && str8.length() > 1024) {
            Log.e(TAG, "checkArgs fail, startActivity is too long");
            response.setCode(6);
            response.setErrorDesc("share_argument_error,startActivity is too long");
            return response;
        }
        String str9 = this.extInfo;
        if (str9 == null || str9.length() <= 1024) {
            response.setCode(1);
            return response;
        }
        Log.e(TAG, "checkArgs fail, extInfo is too long");
        response.setCode(6);
        response.setErrorDesc("share_argument_error,extInfo is too long");
        return response;
    }

    public String getAuthor() {
        return this.author;
    }

    public long getDuration() {
        return this.duration;
    }

    public String getExtInfo() {
        return this.extInfo;
    }

    public String getMusicHighUrl() {
        return this.musicHighUrl;
    }

    public String getMusicLowUrl() {
        return this.musicLowUrl;
    }

    public String getMusicName() {
        return this.musicName;
    }

    public String getMusicUrl() {
        return this.musicUrl;
    }

    public String getStartActivity() {
        return this.startActivity;
    }

    public void setAuthor(String str) {
        this.author = str;
    }

    public void setDuration(long j) {
        this.duration = j;
    }

    public void setExtInfo(String str) {
        this.extInfo = str;
    }

    public void setMusicHighUrl(String str) {
        this.musicHighUrl = str;
    }

    public void setMusicLowUrl(String str) {
        this.musicLowUrl = str;
    }

    public void setMusicName(String str) {
        this.musicName = str;
    }

    public void setMusicUrl(String str) {
        this.musicUrl = str;
    }

    public void setStartActivity(String str) {
        this.startActivity = str;
    }

    @Override // com.xtc.shareapi.share.interfaces.IBundleSerialize
    public void toBundle(Bundle bundle) {
        bundle.putString(OpenApiConstant.XTCMusicConstant.BUNDLE_MUSIC_DEFAULT_URL, this.musicUrl);
        bundle.putString(OpenApiConstant.XTCMusicConstant.BUNDLE_MUSIC_HIGH_URL, this.musicHighUrl);
        bundle.putString(OpenApiConstant.XTCMusicConstant.BUNDLE_MUSIC_LOW_URL, this.musicLowUrl);
        bundle.putString(OpenApiConstant.XTCMusicConstant.BUNDLE_MUSIC_AUTHOR, this.author);
        bundle.putLong(OpenApiConstant.XTCMusicConstant.BUNDLE_MUSIC_DURATION, this.duration);
        bundle.putString(OpenApiConstant.XTCMusicConstant.BUNDLE_MUSIC_EXTEND, this.extInfo);
        bundle.putString(OpenApiConstant.XTCMusicConstant.BUNDLE_MUSIC_NAME, this.musicName);
        bundle.putString(OpenApiConstant.XTCMusicConstant.BUNDLE_MUSIC_START_ACTIVITY, this.startActivity);
    }

    public String toString() {
        return "XTCMusicObject{musicUrl='" + this.musicUrl + "', musicLowUrl='" + this.musicLowUrl + "', musicHighUrl='" + this.musicHighUrl + "', extInfo='" + this.extInfo + "', startActivity='" + this.startActivity + "', musicName='" + this.musicName + "', author='" + this.author + "', duration=" + this.duration + '}';
    }

    @Override // com.xtc.shareapi.share.interfaces.IShareObject
    public int type() {
        return 5;
    }

    public XTCMusicObject(String str, String str2, String str3, String str4, String str5, String str6, String str7, long j) {
        this.musicUrl = str;
        this.musicLowUrl = str2;
        this.musicHighUrl = str3;
        this.extInfo = str4;
        this.startActivity = str5;
        this.musicName = str6;
        this.author = str7;
        this.duration = j;
    }

    @Override // com.xtc.shareapi.share.interfaces.IBundleSerialize
    public XTCMusicObject fromBundle(Bundle bundle) {
        XTCMusicObject xTCMusicObject = new XTCMusicObject();
        xTCMusicObject.setMusicUrl(bundle.getString(OpenApiConstant.XTCMusicConstant.BUNDLE_MUSIC_DEFAULT_URL));
        xTCMusicObject.setMusicLowUrl(bundle.getString(OpenApiConstant.XTCMusicConstant.BUNDLE_MUSIC_LOW_URL));
        xTCMusicObject.setMusicHighUrl(bundle.getString(OpenApiConstant.XTCMusicConstant.BUNDLE_MUSIC_HIGH_URL));
        xTCMusicObject.setAuthor(bundle.getString(OpenApiConstant.XTCMusicConstant.BUNDLE_MUSIC_AUTHOR));
        xTCMusicObject.setExtInfo(bundle.getString(OpenApiConstant.XTCMusicConstant.BUNDLE_MUSIC_EXTEND));
        xTCMusicObject.setMusicName(bundle.getString(OpenApiConstant.XTCMusicConstant.BUNDLE_MUSIC_NAME));
        xTCMusicObject.setStartActivity(bundle.getString(OpenApiConstant.XTCMusicConstant.BUNDLE_MUSIC_START_ACTIVITY));
        xTCMusicObject.setDuration(bundle.getLong(OpenApiConstant.XTCMusicConstant.BUNDLE_MUSIC_DURATION));
        return xTCMusicObject;
    }
}
