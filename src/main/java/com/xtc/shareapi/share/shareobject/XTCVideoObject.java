package com.xtc.shareapi.share.shareobject;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import com.xtc.shareapi.share.bean.ParcelableMap;
import com.xtc.shareapi.share.communication.BaseResponse;
import com.xtc.shareapi.share.communication.ShowMessageFromXTC;
import com.xtc.shareapi.share.constant.OpenApiConstant;
import com.xtc.shareapi.share.interfaces.IShareObject;

/* JADX INFO: loaded from: classes2.dex */
public class XTCVideoObject implements IShareObject, Parcelable {
    public static final Parcelable.Creator<XTCVideoObject> CREATOR = new Parcelable.Creator<XTCVideoObject>() { // from class: com.xtc.shareapi.share.shareobject.XTCVideoObject.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public XTCVideoObject createFromParcel(Parcel parcel) {
            return new XTCVideoObject(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public XTCVideoObject[] newArray(int i2) {
            return new XTCVideoObject[i2];
        }
    };
    private static final int LENGTH_LIMIT = 1024;
    private static final String TAG = "Share_XTCVideoObject";
    private static final int THUMBNAIL_PATH_LENGTH_LIMIT = 512;
    private static final int VIDEO_PATH_LENGTH_LIMIT = 512;
    private ParcelableMap customParamMap;
    private long duration;
    private String extInfo;
    private long sourceDeadline;
    private String sourceDownloadUrl;
    private String sourceKey;
    private String startActivity;
    private long thumbnailDeadline;
    private String thumbnailDownloadUrl;
    private String thumbnailKey;
    private String thumbnailPath;
    private String type;
    private long videoDeadline;
    private String videoDownloadUrl;
    private String videoKey;
    private String videoPath;
    private String wangSuUrl;
    private String zone;

    public XTCVideoObject() {
    }

    @Override // com.xtc.shareapi.share.interfaces.IBundleSerialize
    public BaseResponse checkArgs() {
        ShowMessageFromXTC.Response response = new ShowMessageFromXTC.Response();
        Log.d(TAG, "thumbnailDownloadUrl" + this.thumbnailDownloadUrl + "videoDownloadUrl" + this.videoDownloadUrl);
        String str = this.videoPath;
        if (str == null || this.thumbnailPath == null) {
            response.setCode(1);
            return response;
        }
        if (this.thumbnailDownloadUrl == null && this.videoDownloadUrl == null) {
            Log.e(TAG, "checkArgs fail, video is sending");
            response.setCode(12);
            response.setErrorDesc("video_is_sending,video is sending");
            return response;
        }
        if (str.length() > 512) {
            Log.e(TAG, "checkArgs fail, video path is invalid");
            response.setCode(6);
            response.setErrorDesc("share_argument_error,path is invalid");
            return response;
        }
        if (this.thumbnailPath.length() > 512) {
            Log.e(TAG, "checkArgs fail, thumbnail path is invalid");
            response.setCode(6);
            response.setErrorDesc("share_argument_error, thumbnail path is invalid");
            return response;
        }
        String str2 = this.startActivity;
        if (str2 != null && str2.length() > 1024) {
            Log.e(TAG, "checkArgs fail, startActivity is too long");
            response.setCode(6);
            response.setErrorDesc("share_argument_error,startActivity is too long");
            return response;
        }
        String str3 = this.extInfo;
        if (str3 == null || str3.length() <= 1024) {
            response.setCode(1);
            return response;
        }
        Log.e(TAG, "checkArgs fail, extInfo is too long");
        response.setCode(6);
        response.setErrorDesc("share_argument_error,extInfo is too long");
        return response;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public ParcelableMap getCustomParamMap() {
        return this.customParamMap;
    }

    public long getDuration() {
        return this.duration;
    }

    public String getExtInfo() {
        return this.extInfo;
    }

    public long getSourceDeadline() {
        return this.sourceDeadline;
    }

    public String getSourceDownloadUrl() {
        return this.sourceDownloadUrl;
    }

    public String getSourceKey() {
        return this.sourceKey;
    }

    public String getStartActivity() {
        return this.startActivity;
    }

    public long getThumbnailDeadline() {
        return this.thumbnailDeadline;
    }

    public String getThumbnailDownloadUrl() {
        return this.thumbnailDownloadUrl;
    }

    public String getThumbnailKey() {
        return this.thumbnailKey;
    }

    public String getThumbnailPath() {
        return this.thumbnailPath;
    }

    public String getType() {
        return this.type;
    }

    public long getVideoDeadline() {
        return this.videoDeadline;
    }

    public String getVideoDownloadUrl() {
        return this.videoDownloadUrl;
    }

    public String getVideoKey() {
        return this.videoKey;
    }

    public String getVideoPath() {
        return this.videoPath;
    }

    public String getWangSuUrl() {
        return this.wangSuUrl;
    }

    public String getZone() {
        return this.zone;
    }

    public void readFromParcel(Parcel parcel) {
        this.type = parcel.readString();
        this.wangSuUrl = parcel.readString();
        this.zone = parcel.readString();
        this.customParamMap = (ParcelableMap) parcel.readParcelable(ParcelableMap.class.getClassLoader());
        this.thumbnailPath = parcel.readString();
        this.thumbnailDownloadUrl = parcel.readString();
        this.thumbnailDeadline = parcel.readLong();
        this.thumbnailKey = parcel.readString();
        this.videoPath = parcel.readString();
        this.videoDownloadUrl = parcel.readString();
        this.videoDeadline = parcel.readLong();
        this.videoKey = parcel.readString();
        this.sourceDownloadUrl = parcel.readString();
        this.sourceDeadline = parcel.readLong();
        this.sourceKey = parcel.readString();
        this.extInfo = parcel.readString();
        this.startActivity = parcel.readString();
        this.duration = parcel.readLong();
    }

    public void setCustomParamMap(ParcelableMap parcelableMap) {
        this.customParamMap = parcelableMap;
    }

    public void setDuration(long j) {
        this.duration = j;
    }

    public void setExtInfo(String str) {
        this.extInfo = str;
    }

    public void setSourceDeadline(long j) {
        this.sourceDeadline = j;
    }

    public void setSourceDownloadUrl(String str) {
        this.sourceDownloadUrl = str;
    }

    public void setSourceKey(String str) {
        this.sourceKey = str;
    }

    public void setStartActivity(String str) {
        this.startActivity = str;
    }

    public void setThumbnailDeadline(long j) {
        this.thumbnailDeadline = j;
    }

    public void setThumbnailDownloadUrl(String str) {
        this.thumbnailDownloadUrl = str;
    }

    public void setThumbnailKey(String str) {
        this.thumbnailKey = str;
    }

    public void setThumbnailPath(String str) {
        this.thumbnailPath = str;
    }

    public void setType(String str) {
        this.type = str;
    }

    public void setVideoDeadline(long j) {
        this.videoDeadline = j;
    }

    public void setVideoDownloadUrl(String str) {
        this.videoDownloadUrl = str;
    }

    public void setVideoKey(String str) {
        this.videoKey = str;
    }

    public void setVideoPath(String str) {
        this.videoPath = str;
    }

    public void setWangSuUrl(String str) {
        this.wangSuUrl = str;
    }

    public void setZone(String str) {
        this.zone = str;
    }

    @Override // com.xtc.shareapi.share.interfaces.IBundleSerialize
    public void toBundle(Bundle bundle) {
        bundle.putString(OpenApiConstant.XTCVideoConstant.BUNDLE_VIDEO_VIDEO_PATH, this.videoPath);
        bundle.putString(OpenApiConstant.XTCVideoConstant.BUNDLE_VIDEO_THUMBNAIL_PATH, this.thumbnailPath);
        bundle.putString(OpenApiConstant.XTCVideoConstant.BUNDLE_VIDEO_VIDEO_DOWNLOAD_URL, this.videoDownloadUrl);
        bundle.putLong(OpenApiConstant.XTCVideoConstant.BUNDLE_VIDEO_VIDEO_DEADLINE, this.videoDeadline);
        bundle.putString(OpenApiConstant.XTCVideoConstant.BUNDLE_VIDEO_THUMBNAIL_DOWNLOAD_URL, this.thumbnailDownloadUrl);
        bundle.putLong(OpenApiConstant.XTCVideoConstant.BUNDLE_VIDEO_THUMBNAIL_DEADLINE, this.thumbnailDeadline);
        bundle.putString(OpenApiConstant.XTCVideoConstant.BUNDLE_VIDEO_THUMBNAIL_KEY, this.thumbnailKey);
        bundle.putString(OpenApiConstant.XTCVideoConstant.BUNDLE_VIDEO_VIDEO_KEY, this.videoKey);
        bundle.putString(OpenApiConstant.XTCVideoConstant.BUNDLE_VIDEO_EXTINFO, this.extInfo);
        bundle.putString(OpenApiConstant.XTCVideoConstant.BUNDLE_VIDEO_START_ACTIVITY, this.startActivity);
        bundle.putString(OpenApiConstant.XTCVideoConstant.BUNDLE_VIDEO_SOURCE_DOWNLOAD_URL, this.sourceDownloadUrl);
        bundle.putLong(OpenApiConstant.XTCVideoConstant.BUNDLE_VIDEO_SOURCE_DEADLINE, this.sourceDeadline);
        bundle.putString(OpenApiConstant.XTCVideoConstant.BUNDLE_VIDEO_SOURCE_KEY, this.sourceKey);
        bundle.putString(OpenApiConstant.XTCVideoConstant.BUNDLE_VIDEO_TYPE, this.type);
        bundle.putString(OpenApiConstant.XTCVideoConstant.BUNDLE_VIDEO_WANGSU_URL, this.wangSuUrl);
        bundle.putString(OpenApiConstant.XTCVideoConstant.BUNDLE_VIDEO_ZONE, this.zone);
        bundle.putParcelable(OpenApiConstant.XTCVideoConstant.BUNDLE_VIDEO_CUSTOM_PARAM_MAP, this.customParamMap);
        bundle.putLong(OpenApiConstant.XTCVideoConstant.BUNDLE_VIDEO_DURATION, this.duration);
    }

    public String toString() {
        return "XTCVideoObject{type='" + this.type + "', wangSuUrl='" + this.wangSuUrl + "', zone='" + this.zone + "', customParamMap=" + this.customParamMap + ", thumbnailPath='" + this.thumbnailPath + "', thumbnailDownloadUrl='" + this.thumbnailDownloadUrl + "', thumbnailDeadline=" + this.thumbnailDeadline + ", thumbnailKey='" + this.thumbnailKey + "', videoPath='" + this.videoPath + "', videoDownloadUrl='" + this.videoDownloadUrl + "', videoDeadline=" + this.videoDeadline + ", videoKey='" + this.videoKey + "', sourceDownloadUrl='" + this.sourceDownloadUrl + "', sourceDeadline=" + this.sourceDeadline + ", sourceKey='" + this.sourceKey + "', extInfo='" + this.extInfo + "', startActivity='" + this.startActivity + "', duration=" + this.duration + '}';
    }

    @Override // com.xtc.shareapi.share.interfaces.IShareObject
    public int type() {
        return 4;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.type);
        parcel.writeString(this.wangSuUrl);
        parcel.writeString(this.zone);
        parcel.writeParcelable(this.customParamMap, i2);
        parcel.writeString(this.thumbnailPath);
        parcel.writeString(this.thumbnailDownloadUrl);
        parcel.writeLong(this.thumbnailDeadline);
        parcel.writeString(this.thumbnailKey);
        parcel.writeString(this.videoPath);
        parcel.writeString(this.videoDownloadUrl);
        parcel.writeLong(this.videoDeadline);
        parcel.writeString(this.videoKey);
        parcel.writeString(this.sourceDownloadUrl);
        parcel.writeLong(this.sourceDeadline);
        parcel.writeString(this.sourceKey);
        parcel.writeString(this.extInfo);
        parcel.writeString(this.startActivity);
        parcel.writeLong(this.duration);
    }

    public XTCVideoObject(Parcel parcel) {
        this.type = parcel.readString();
        this.wangSuUrl = parcel.readString();
        this.zone = parcel.readString();
        this.customParamMap = (ParcelableMap) parcel.readParcelable(ParcelableMap.class.getClassLoader());
        this.thumbnailPath = parcel.readString();
        this.thumbnailDownloadUrl = parcel.readString();
        this.thumbnailDeadline = parcel.readLong();
        this.thumbnailKey = parcel.readString();
        this.videoPath = parcel.readString();
        this.videoDownloadUrl = parcel.readString();
        this.videoDeadline = parcel.readLong();
        this.videoKey = parcel.readString();
        this.sourceDownloadUrl = parcel.readString();
        this.sourceDeadline = parcel.readLong();
        this.sourceKey = parcel.readString();
        this.extInfo = parcel.readString();
        this.startActivity = parcel.readString();
        this.duration = parcel.readLong();
    }

    @Override // com.xtc.shareapi.share.interfaces.IBundleSerialize
    public XTCVideoObject fromBundle(Bundle bundle) {
        XTCVideoObject xTCVideoObject = new XTCVideoObject();
        xTCVideoObject.setVideoPath(bundle.getString(OpenApiConstant.XTCVideoConstant.BUNDLE_VIDEO_VIDEO_PATH));
        xTCVideoObject.setThumbnailPath(bundle.getString(OpenApiConstant.XTCVideoConstant.BUNDLE_VIDEO_THUMBNAIL_PATH));
        xTCVideoObject.setExtInfo(bundle.getString(OpenApiConstant.XTCVideoConstant.BUNDLE_VIDEO_EXTINFO));
        xTCVideoObject.setStartActivity(bundle.getString(OpenApiConstant.XTCVideoConstant.BUNDLE_VIDEO_START_ACTIVITY));
        xTCVideoObject.setDuration(bundle.getLong(OpenApiConstant.XTCVideoConstant.BUNDLE_VIDEO_DURATION));
        xTCVideoObject.setVideoDownloadUrl(bundle.getString(OpenApiConstant.XTCVideoConstant.BUNDLE_VIDEO_VIDEO_DOWNLOAD_URL));
        xTCVideoObject.setVideoDeadline(bundle.getLong(OpenApiConstant.XTCVideoConstant.BUNDLE_VIDEO_VIDEO_DEADLINE));
        xTCVideoObject.setVideoKey(bundle.getString(OpenApiConstant.XTCVideoConstant.BUNDLE_VIDEO_VIDEO_KEY));
        xTCVideoObject.setThumbnailDownloadUrl(bundle.getString(OpenApiConstant.XTCVideoConstant.BUNDLE_VIDEO_THUMBNAIL_DOWNLOAD_URL));
        xTCVideoObject.setThumbnailDeadline(bundle.getLong(OpenApiConstant.XTCVideoConstant.BUNDLE_VIDEO_THUMBNAIL_DEADLINE));
        xTCVideoObject.setThumbnailKey(bundle.getString(OpenApiConstant.XTCVideoConstant.BUNDLE_VIDEO_THUMBNAIL_KEY));
        xTCVideoObject.setSourceDownloadUrl(bundle.getString(OpenApiConstant.XTCVideoConstant.BUNDLE_VIDEO_SOURCE_DOWNLOAD_URL));
        xTCVideoObject.setSourceDeadline(bundle.getLong(OpenApiConstant.XTCVideoConstant.BUNDLE_VIDEO_SOURCE_DEADLINE));
        xTCVideoObject.setSourceKey(bundle.getString(OpenApiConstant.XTCVideoConstant.BUNDLE_VIDEO_SOURCE_KEY));
        xTCVideoObject.setCustomParamMap((ParcelableMap) bundle.getParcelable(OpenApiConstant.XTCVideoConstant.BUNDLE_VIDEO_CUSTOM_PARAM_MAP));
        xTCVideoObject.setType(bundle.getString(OpenApiConstant.XTCVideoConstant.BUNDLE_VIDEO_TYPE));
        xTCVideoObject.setWangSuUrl(bundle.getString(OpenApiConstant.XTCVideoConstant.BUNDLE_VIDEO_WANGSU_URL));
        xTCVideoObject.setZone(bundle.getString(OpenApiConstant.XTCVideoConstant.BUNDLE_VIDEO_ZONE));
        return xTCVideoObject;
    }
}
