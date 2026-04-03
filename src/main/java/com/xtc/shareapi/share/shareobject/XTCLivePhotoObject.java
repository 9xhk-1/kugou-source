package com.xtc.shareapi.share.shareobject;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import com.xtc.shareapi.share.communication.BaseResponse;
import com.xtc.shareapi.share.communication.ShowMessageFromXTC;
import com.xtc.shareapi.share.constant.OpenApiConstant;
import com.xtc.shareapi.share.interfaces.IShareObject;

/* JADX INFO: loaded from: classes2.dex */
public class XTCLivePhotoObject implements IShareObject, Parcelable {
    public String localPhotoPath;
    public String localVideoPath;
    private static final String TAG = OpenApiConstant.TAG + XTCLivePhotoObject.class.getSimpleName();
    public static final Parcelable.Creator<XTCLivePhotoObject> CREATOR = new Parcelable.Creator<XTCLivePhotoObject>() { // from class: com.xtc.shareapi.share.shareobject.XTCLivePhotoObject.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public XTCLivePhotoObject createFromParcel(Parcel parcel) {
            return new XTCLivePhotoObject(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public XTCLivePhotoObject[] newArray(int i2) {
            return new XTCLivePhotoObject[i2];
        }
    };

    public XTCLivePhotoObject() {
    }

    @Override // com.xtc.shareapi.share.interfaces.IBundleSerialize
    public BaseResponse checkArgs() {
        ShowMessageFromXTC.Response response = new ShowMessageFromXTC.Response();
        if (!TextUtils.isEmpty(this.localPhotoPath) && !TextUtils.isEmpty(this.localVideoPath)) {
            response.setCode(1);
            return response;
        }
        Log.e(TAG, "checkArgs fail,localPhotoPath or localVideoPath is empty");
        response.setCode(6);
        response.setErrorDesc("share_argument_error,localPhotoPath or localVideoPath is empty");
        return response;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public void readFromParcel(Parcel parcel) {
        this.localPhotoPath = parcel.readString();
        this.localVideoPath = parcel.readString();
    }

    @Override // com.xtc.shareapi.share.interfaces.IBundleSerialize
    public void toBundle(Bundle bundle) {
        bundle.putString(OpenApiConstant.XTCLivePhotoConstant.BUNDLE_PHOTO_PATH, this.localPhotoPath);
        bundle.putString(OpenApiConstant.XTCLivePhotoConstant.BUNDLE_VIDEO_PATH, this.localVideoPath);
    }

    public String toString() {
        return "XTCLivePhotoObject{localPhotoPath='" + this.localPhotoPath + "', localVideoPath='" + this.localVideoPath + "'}";
    }

    @Override // com.xtc.shareapi.share.interfaces.IShareObject
    public int type() {
        return 7;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.localPhotoPath);
        parcel.writeString(this.localVideoPath);
    }

    public XTCLivePhotoObject(String str, String str2) {
        this.localPhotoPath = str;
        this.localVideoPath = str2;
    }

    @Override // com.xtc.shareapi.share.interfaces.IBundleSerialize
    public XTCLivePhotoObject fromBundle(Bundle bundle) {
        XTCLivePhotoObject xTCLivePhotoObject = new XTCLivePhotoObject();
        xTCLivePhotoObject.localPhotoPath = bundle.getString(OpenApiConstant.XTCLivePhotoConstant.BUNDLE_PHOTO_PATH);
        xTCLivePhotoObject.localVideoPath = bundle.getString(OpenApiConstant.XTCLivePhotoConstant.BUNDLE_VIDEO_PATH);
        return xTCLivePhotoObject;
    }

    public XTCLivePhotoObject(Parcel parcel) {
        this.localPhotoPath = parcel.readString();
        this.localVideoPath = parcel.readString();
    }
}
