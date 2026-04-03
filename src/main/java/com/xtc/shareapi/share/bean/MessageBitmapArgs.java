package com.xtc.shareapi.share.bean;

import android.os.Bundle;
import android.util.Log;
import com.xtc.shareapi.share.communication.BaseResponse;
import com.xtc.shareapi.share.communication.ShowMessageFromXTC;
import com.xtc.shareapi.share.constant.OpenApiConstant;
import com.xtc.shareapi.share.interfaces.IBundleSerialize;

/* JADX INFO: loaded from: classes2.dex */
public class MessageBitmapArgs implements IBundleSerialize {
    private int height;
    private int type;
    private int width;

    public MessageBitmapArgs() {
        setWidthAndHeight(1);
    }

    @Override // com.xtc.shareapi.share.interfaces.IBundleSerialize
    public BaseResponse checkArgs() {
        ShowMessageFromXTC.Response response = new ShowMessageFromXTC.Response();
        if (this.type > 0) {
            response.setCode(1);
            return response;
        }
        Log.e("MessageBitmapArgs", "checkArgs fail, the type is false");
        response.setCode(6);
        response.setErrorDesc("share_argument_error,the type is false");
        return response;
    }

    @Override // com.xtc.shareapi.share.interfaces.IBundleSerialize
    public IBundleSerialize fromBundle(Bundle bundle) {
        MessageBitmapArgs messageBitmapArgs = new MessageBitmapArgs();
        messageBitmapArgs.setHeight(bundle.getInt(OpenApiConstant.MessageBitmapArgsConstant.DEBRIS_HEIGHT));
        messageBitmapArgs.setWidth(bundle.getInt(OpenApiConstant.MessageBitmapArgsConstant.DEBRIS_WIDTH));
        messageBitmapArgs.setType(bundle.getInt(OpenApiConstant.MessageBitmapArgsConstant.DEBRIS_TYPE));
        return messageBitmapArgs;
    }

    public int getHeight() {
        return this.height;
    }

    public int getType() {
        return this.type;
    }

    public int getWidth() {
        return this.width;
    }

    public void setHeight(int i2) {
        this.height = i2;
    }

    public void setType(int i2) {
        this.type = i2;
        setWidthAndHeight(i2);
    }

    public void setWidth(int i2) {
        this.width = i2;
    }

    public void setWidthAndHeight(int i2) {
        if (i2 == 1) {
            setWidth(160);
            setHeight(180);
            return;
        }
        if (i2 == 2) {
            setWidth(250);
            setHeight(OpenApiConstant.MessageBitmapArgsConstant.MESSAGE_HEIGHT_2);
        } else if (i2 == 3) {
            setWidth(OpenApiConstant.MessageBitmapArgsConstant.MESSAGE_WIDTH_3);
            setHeight(OpenApiConstant.MessageBitmapArgsConstant.MESSAGE_HEIGHT_3);
        } else {
            if (i2 != 4) {
                return;
            }
            setWidth(142);
            setHeight(160);
        }
    }

    @Override // com.xtc.shareapi.share.interfaces.IBundleSerialize
    public void toBundle(Bundle bundle) {
        bundle.putInt(OpenApiConstant.MessageBitmapArgsConstant.DEBRIS_HEIGHT, this.height);
        bundle.putInt(OpenApiConstant.MessageBitmapArgsConstant.DEBRIS_WIDTH, this.width);
        bundle.putInt(OpenApiConstant.MessageBitmapArgsConstant.DEBRIS_TYPE, this.type);
    }

    public String toString() {
        return "MessageBitmapArgs{type=" + this.type + ", width=" + this.width + ", height=" + this.height + '}';
    }

    public MessageBitmapArgs(int i2) {
        this.type = i2;
        setWidthAndHeight(i2);
    }
}
