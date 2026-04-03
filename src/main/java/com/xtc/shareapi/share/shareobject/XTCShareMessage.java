package com.xtc.shareapi.share.shareobject;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.xtc.shareapi.share.communication.BaseResponse;
import com.xtc.shareapi.share.communication.ShowMessageFromXTC;
import com.xtc.shareapi.share.constant.OpenApiConstant;
import com.xtc.shareapi.share.interfaces.IShareObject;
import java.io.ByteArrayOutputStream;

/* JADX INFO: loaded from: classes2.dex */
public class XTCShareMessage implements IShareObject {
    private static final int DESCRIPTION_LENGTH_LIMIT = 1024;
    private static final int MESSAGE_ACTION_LENGTH_LIMIT = 2048;
    private static final int MESSAGE_EXT_LENGTH_LIMIT = 2048;
    private static final int MINI_PROGRAM_THUMB_LENGTH = 131072;
    private static final String TAG = OpenApiConstant.TAG + XTCShareMessage.class.getSimpleName();
    private static final int TITLE_LENGTH_LIMIT = 512;
    private String action;
    private int actionType;
    private String description;
    private String ext;
    private IShareObject shareObject;
    private byte[] thumbData;

    public static class Builder {
        public static XTCShareMessage fromBundle(Bundle bundle) {
            XTCShareMessage xTCShareMessage = new XTCShareMessage();
            xTCShareMessage.action = bundle.getString(OpenApiConstant.XTCShareMessageConstant.BUNDLE_MESSAGE_ACTION);
            xTCShareMessage.ext = bundle.getString(OpenApiConstant.XTCShareMessageConstant.BUNDLE_MESSAGE_EXT);
            xTCShareMessage.description = bundle.getString(OpenApiConstant.XTCShareMessageConstant.BUNDLE_MESSAGE_DESC);
            xTCShareMessage.thumbData = bundle.getByteArray(OpenApiConstant.XTCShareMessageConstant.BUNDLE_MESSAGE_THUMB);
            xTCShareMessage.actionType = bundle.getInt(OpenApiConstant.XTCShareMessageConstant.BUNDLE_MESSAGE_ACTION_TYPE);
            String string = bundle.getString(OpenApiConstant.BuilderConstant.KEY_IDENTIFIER);
            Log.d(XTCShareMessage.TAG, "shareObject className = " + string);
            if (!TextUtils.isEmpty(string)) {
                try {
                    xTCShareMessage.setShareObject((IShareObject) Class.forName(string).newInstance());
                    xTCShareMessage.setShareObject((IShareObject) xTCShareMessage.getShareObject().fromBundle(bundle));
                    return xTCShareMessage;
                } catch (Exception e2) {
                    Log.e(XTCShareMessage.TAG, "error = " + e2.getMessage());
                }
            }
            return xTCShareMessage;
        }

        public static Bundle toBundle(XTCShareMessage xTCShareMessage) {
            Bundle bundle = new Bundle();
            bundle.putString(OpenApiConstant.XTCShareMessageConstant.BUNDLE_MESSAGE_EXT, xTCShareMessage.ext);
            bundle.putString(OpenApiConstant.XTCShareMessageConstant.BUNDLE_MESSAGE_DESC, xTCShareMessage.description);
            bundle.putByteArray(OpenApiConstant.XTCShareMessageConstant.BUNDLE_MESSAGE_THUMB, xTCShareMessage.thumbData);
            bundle.putString(OpenApiConstant.XTCShareMessageConstant.BUNDLE_MESSAGE_ACTION, xTCShareMessage.action);
            bundle.putInt(OpenApiConstant.XTCShareMessageConstant.BUNDLE_MESSAGE_ACTION_TYPE, xTCShareMessage.actionType);
            if (xTCShareMessage.shareObject != null) {
                Log.d(XTCShareMessage.TAG, "shareObject = " + xTCShareMessage.getShareObject());
                Log.d(XTCShareMessage.TAG, "shareObject className = " + xTCShareMessage.getShareObject().getClass().getName());
                bundle.putString(OpenApiConstant.BuilderConstant.KEY_IDENTIFIER, xTCShareMessage.getShareObject().getClass().getName());
                xTCShareMessage.shareObject.toBundle(bundle);
            }
            return bundle;
        }
    }

    public XTCShareMessage() {
    }

    public static String getTAG() {
        return TAG;
    }

    @Override // com.xtc.shareapi.share.interfaces.IBundleSerialize
    public BaseResponse checkArgs() {
        ShowMessageFromXTC.Response response = new ShowMessageFromXTC.Response();
        String str = this.description;
        if (str != null && str.length() > 1024) {
            Log.e(TAG, "checkArgs fail, description is invalid");
            response.setCode(6);
            response.setErrorDesc("checkArgs fail, description is invalid");
            return response;
        }
        if (this.shareObject == null) {
            Log.e(TAG, "checkArgs fail, shareObject is null");
            response.setCode(6);
            response.setErrorDesc("checkArgs fail, shareObject is null");
            return response;
        }
        String str2 = this.action;
        if (str2 != null && str2.length() > 2048) {
            Log.e(TAG, "checkArgs fail, messageAction is too long");
            response.setCode(6);
            response.setErrorDesc("checkArgs fail, messageAction is too long");
            return response;
        }
        String str3 = this.ext;
        if (str3 == null || str3.length() <= 2048) {
            return this.shareObject.checkArgs();
        }
        Log.e(TAG, "checkArgs fail, messageExt is too long");
        response.setCode(6);
        response.setErrorDesc("checkArgs fail, messageExt is too long");
        return response;
    }

    public String getAction() {
        return this.action;
    }

    public int getActionType() {
        return this.actionType;
    }

    public String getDescription() {
        return this.description;
    }

    public String getExt() {
        return this.ext;
    }

    public IShareObject getShareObject() {
        return this.shareObject;
    }

    public byte[] getThumbData() {
        return this.thumbData;
    }

    public final int getType() {
        IShareObject iShareObject = this.shareObject;
        if (iShareObject == null) {
            return 0;
        }
        return iShareObject.type();
    }

    public void setAction(String str) {
        this.action = str;
    }

    public void setActionType(int i2) {
        this.actionType = i2;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public void setExt(String str) {
        this.ext = str;
    }

    public void setShareObject(IShareObject iShareObject) {
        this.shareObject = iShareObject;
    }

    public final void setThumbImage(Bitmap bitmap) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG, 85, byteArrayOutputStream);
            this.thumbData = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
        } catch (Exception e2) {
            Log.e(TAG, "bitmapToByteArray exception:" + e2.getMessage());
        }
    }

    @Override // com.xtc.shareapi.share.interfaces.IBundleSerialize
    public void toBundle(Bundle bundle) {
        Builder.toBundle(this);
    }

    public String toString() {
        return "XTCShareMessage{description='" + this.description + "', actionType=" + this.actionType + ", action='" + this.action + "', ext='" + this.ext + "', shareObject=" + this.shareObject + '}';
    }

    @Override // com.xtc.shareapi.share.interfaces.IShareObject
    public int type() {
        return 100;
    }

    public XTCShareMessage(IShareObject iShareObject) {
        this.shareObject = iShareObject;
    }

    @Override // com.xtc.shareapi.share.interfaces.IBundleSerialize
    public XTCShareMessage fromBundle(Bundle bundle) {
        return Builder.fromBundle(bundle);
    }
}
