package com.xtc.shareapi.share.shareobject;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import androidx.appcompat.widget.ActivityChooserView;
import com.xtc.shareapi.share.bean.DialogBitmapArgs;
import com.xtc.shareapi.share.bean.MessageBitmapArgs;
import com.xtc.shareapi.share.communication.BaseResponse;
import com.xtc.shareapi.share.communication.ShowMessageFromXTC;
import com.xtc.shareapi.share.constant.OpenApiConstant;
import com.xtc.shareapi.share.interfaces.IShareObject;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public class XTCImageObject implements IShareObject, Parcelable {
    private static final int CONTENT_LENGTH_LIMIT = 307200;
    private static final int PATH_LENGTH_LIMIT = 512;
    private String description;
    private DialogBitmapArgs dialogBitmapArgs;
    private byte[] imageData;
    private String imagePath;
    private MessageBitmapArgs messageBitmapArgs;
    private String textMessage;
    private static final String TAG = OpenApiConstant.TAG + XTCImageObject.class.getSimpleName();
    public static final Parcelable.Creator<XTCImageObject> CREATOR = new Parcelable.Creator<XTCImageObject>() { // from class: com.xtc.shareapi.share.shareobject.XTCImageObject.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public XTCImageObject createFromParcel(Parcel parcel) {
            return new XTCImageObject(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public XTCImageObject[] newArray(int i2) {
            return new XTCImageObject[i2];
        }
    };

    public XTCImageObject() {
    }

    private int getFileSize(String str) {
        String str2 = TAG;
        Log.d(str2, "image path = " + str);
        File file = new File(str);
        if (file.exists() && file.isFile()) {
            return str.length();
        }
        Log.e(str2, "image not exist or not file!");
        return ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    }

    @Override // com.xtc.shareapi.share.interfaces.IBundleSerialize
    public BaseResponse checkArgs() {
        String str;
        ShowMessageFromXTC.Response response = new ShowMessageFromXTC.Response();
        byte[] bArr = this.imageData;
        if ((bArr == null || bArr.length == 0) && ((str = this.imagePath) == null || str.length() == 0)) {
            Log.e(TAG, "checkArgs fail, all arguments are null");
            response.setCode(6);
            response.setErrorDesc("share_argument_errorall arguments are null");
            return response;
        }
        byte[] bArr2 = this.imageData;
        if (bArr2 != null && bArr2.length > CONTENT_LENGTH_LIMIT) {
            Log.e(TAG, "checkArgs fail, content is too large");
            response.setCode(6);
            response.setErrorDesc("share_argument_error,content is too large");
            return response;
        }
        String str2 = this.imagePath;
        if (str2 != null && str2.length() > 512) {
            Log.e(TAG, "checkArgs fail, path is invalid");
            response.setCode(6);
            response.setErrorDesc("share_argument_error,path is invalid");
            return response;
        }
        String str3 = this.imagePath;
        if (str3 == null || getFileSize(str3) <= 512) {
            response.setCode(1);
            return response;
        }
        Log.e(TAG, "checkArgs fail, image content is too large");
        response.setCode(6);
        response.setErrorDesc("share_argument_error,image content is too large");
        return response;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getDescription() {
        return this.description;
    }

    public DialogBitmapArgs getDialogBitmapArgs() {
        return this.dialogBitmapArgs;
    }

    public byte[] getImageData() {
        return this.imageData;
    }

    public String getImagePath() {
        return this.imagePath;
    }

    public MessageBitmapArgs getMessageBitmapArgs() {
        return this.messageBitmapArgs;
    }

    public String getTextMessage() {
        return this.textMessage;
    }

    public void readFromParcel(Parcel parcel) {
        this.imagePath = parcel.readString();
        this.textMessage = parcel.readString();
        this.description = parcel.readString();
    }

    public void setBitmap(Bitmap bitmap) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG, 85, byteArrayOutputStream);
            this.imageData = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
        } catch (Exception e2) {
            Log.e(TAG, "WXImageObject <init>, exception:" + e2.getMessage());
        }
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public void setDialogBitmapArgs(DialogBitmapArgs dialogBitmapArgs) {
        this.dialogBitmapArgs = dialogBitmapArgs;
    }

    public void setImagePath(String str) {
        this.imagePath = str;
    }

    public void setMessageBitmapArgs(MessageBitmapArgs messageBitmapArgs) {
        this.messageBitmapArgs = messageBitmapArgs;
    }

    public void setTextMessage(String str) {
        this.textMessage = str;
    }

    @Override // com.xtc.shareapi.share.interfaces.IBundleSerialize
    public void toBundle(Bundle bundle) {
        bundle.putByteArray(OpenApiConstant.XTCImageConstant.BUNDLE_IMAGE_DATA, this.imageData);
        bundle.putString(OpenApiConstant.XTCImageConstant.BUNDLE_IMAGE_PATH, this.imagePath);
        bundle.putString(OpenApiConstant.XTCImageConstant.BUNDLE_IMAGE_TEXT_MESSAGE, this.textMessage);
        if (this.dialogBitmapArgs != null) {
            bundle.putString(OpenApiConstant.XTCImageConstant.BUNDLE_IMAGE_DIALOG_BITMAP_ARGS, getDialogBitmapArgs().getClass().getName());
            this.dialogBitmapArgs.toBundle(bundle);
        }
        if (this.messageBitmapArgs != null) {
            Log.d("MessageBitmapArgs", "ssss" + getMessageBitmapArgs());
            bundle.putString(OpenApiConstant.XTCImageConstant.BUNDLE_IMAGE_MESSAGE_BITMAP_ARGS, getMessageBitmapArgs().getClass().getName());
            this.messageBitmapArgs.toBundle(bundle);
        }
    }

    public String toString() {
        return "XTCImageObject{imageData=" + Arrays.toString(this.imageData) + ", imagePath='" + this.imagePath + "', dialogBitmapArgs=" + this.dialogBitmapArgs + ", messageBitmapArgs=" + this.messageBitmapArgs + ", textMessage='" + this.textMessage + "', description='" + this.description + "'}";
    }

    @Override // com.xtc.shareapi.share.interfaces.IShareObject
    public int type() {
        return 2;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.imagePath);
        parcel.writeString(this.textMessage);
        parcel.writeString(this.description);
    }

    public XTCImageObject(String str) {
        this.imagePath = str;
    }

    @Override // com.xtc.shareapi.share.interfaces.IBundleSerialize
    public XTCImageObject fromBundle(Bundle bundle) {
        XTCImageObject xTCImageObject = new XTCImageObject();
        xTCImageObject.imageData = bundle.getByteArray(OpenApiConstant.XTCImageConstant.BUNDLE_IMAGE_DATA);
        xTCImageObject.imagePath = bundle.getString(OpenApiConstant.XTCImageConstant.BUNDLE_IMAGE_PATH);
        xTCImageObject.textMessage = bundle.getString(OpenApiConstant.XTCImageConstant.BUNDLE_IMAGE_TEXT_MESSAGE);
        String string = bundle.getString(OpenApiConstant.XTCImageConstant.BUNDLE_IMAGE_DIALOG_BITMAP_ARGS);
        if (!TextUtils.isEmpty(string)) {
            try {
                xTCImageObject.setDialogBitmapArgs((DialogBitmapArgs) Class.forName(string).newInstance());
                xTCImageObject.setDialogBitmapArgs((DialogBitmapArgs) xTCImageObject.getDialogBitmapArgs().fromBundle(bundle));
            } catch (Exception e2) {
                Log.e(TAG, "error = " + e2.getMessage());
                return xTCImageObject;
            }
        }
        String string2 = bundle.getString(OpenApiConstant.XTCImageConstant.BUNDLE_IMAGE_MESSAGE_BITMAP_ARGS);
        if (!TextUtils.isEmpty(string2)) {
            try {
                xTCImageObject.setMessageBitmapArgs((MessageBitmapArgs) Class.forName(string2).newInstance());
                xTCImageObject.setMessageBitmapArgs((MessageBitmapArgs) xTCImageObject.getMessageBitmapArgs().fromBundle(bundle));
                return xTCImageObject;
            } catch (Exception e3) {
                Log.e(TAG, "error = " + e3.getMessage());
            }
        }
        return xTCImageObject;
    }

    public XTCImageObject(Bitmap bitmap) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG, 85, byteArrayOutputStream);
            this.imageData = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
        } catch (Exception e2) {
            Log.e(TAG, "WXImageObject <init>, exception:" + e2.getMessage());
        }
    }

    public XTCImageObject(Parcel parcel) {
        this.imagePath = parcel.readString();
        this.textMessage = parcel.readString();
        this.description = parcel.readString();
    }
}
