package com.xtc.shareapi.share.bean;

import android.os.Bundle;
import android.util.Log;
import com.xtc.shareapi.share.communication.BaseResponse;
import com.xtc.shareapi.share.communication.ShowMessageFromXTC;
import com.xtc.shareapi.share.constant.OpenApiConstant;
import com.xtc.shareapi.share.interfaces.IBundleSerialize;

/* JADX INFO: loaded from: classes2.dex */
public class DialogBitmapArgs implements IBundleSerialize {
    private int cropHeight;
    private int cropWidth;
    private int cutStart;
    private int cutTop;
    private int height;
    private int type;
    private int width;

    public DialogBitmapArgs() {
    }

    @Override // com.xtc.shareapi.share.interfaces.IBundleSerialize
    public BaseResponse checkArgs() {
        ShowMessageFromXTC.Response response = new ShowMessageFromXTC.Response();
        if (this.type > 0) {
            response.setCode(1);
            return response;
        }
        Log.e("DialogBitmapArgs", "checkArgs fail, the type is false");
        response.setCode(6);
        response.setErrorDesc("share_argument_error,the type is false");
        return response;
    }

    @Override // com.xtc.shareapi.share.interfaces.IBundleSerialize
    public IBundleSerialize fromBundle(Bundle bundle) {
        DialogBitmapArgs dialogBitmapArgs = new DialogBitmapArgs();
        dialogBitmapArgs.setHeight(bundle.getInt(OpenApiConstant.DialogBitmapArgsConstant.DEBRIS_HEIGHT));
        dialogBitmapArgs.setWidth(bundle.getInt(OpenApiConstant.DialogBitmapArgsConstant.DEBRIS_WIDTH));
        dialogBitmapArgs.setCutTop(bundle.getInt(OpenApiConstant.DialogBitmapArgsConstant.DEBRIS_CUT_TOP));
        dialogBitmapArgs.setCropHeight(bundle.getInt(OpenApiConstant.DialogBitmapArgsConstant.DEBRIS_CROP_HEIGHT));
        dialogBitmapArgs.setCutStart(bundle.getInt(OpenApiConstant.DialogBitmapArgsConstant.DEBRIS_CUT_START));
        dialogBitmapArgs.setCropWidth(bundle.getInt(OpenApiConstant.DialogBitmapArgsConstant.DEBRIS_CROP_WIDTH));
        dialogBitmapArgs.setType(bundle.getInt(OpenApiConstant.DialogBitmapArgsConstant.DEBRIS_TYPE));
        return dialogBitmapArgs;
    }

    public int getCropHeight() {
        return this.cropHeight;
    }

    public int getCropWidth() {
        return this.cropWidth;
    }

    public int getCutStart() {
        return this.cutStart;
    }

    public int getCutTop() {
        return this.cutTop;
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

    public void setCropHeight(int i2) {
        this.cropHeight = i2;
    }

    public void setCropWidth(int i2) {
        this.cropWidth = i2;
    }

    public void setCutStart(int i2) {
        this.cutStart = i2;
    }

    public void setCutTop(int i2) {
        this.cutTop = i2;
    }

    public void setHeight(int i2) {
        this.height = i2;
    }

    public void setType(int i2) {
        this.type = i2;
    }

    public void setWidth(int i2) {
        this.width = i2;
    }

    public void setWidthAndHeight(int i2, int i3, int i4) {
        Log.d("DialogBitmapArgs", "type:" + i2);
        if (i2 == 1) {
            setWidth(190);
            setHeight(OpenApiConstant.DialogBitmapArgsConstant.DIALOG_HEIGHT_1);
            return;
        }
        if (i2 == 2) {
            setWidth(304);
            setHeight(190);
            return;
        }
        if (i2 == 3) {
            setWidth(OpenApiConstant.DialogBitmapArgsConstant.DIALOG_WIDTH_3);
            setHeight(220);
        } else if (i2 == 4) {
            Log.d("DialogBitmapArgs", "OpenApiConstant.DialogBitmapArgsConstant.TYPE_DOUBLE_PK:");
            setWidth(OpenApiConstant.DialogBitmapArgsConstant.DIALOG_WIDTH_4);
            setHeight(220);
        } else {
            if (i2 != 5) {
                return;
            }
            setWidth(i3);
            setHeight(i4);
        }
    }

    @Override // com.xtc.shareapi.share.interfaces.IBundleSerialize
    public void toBundle(Bundle bundle) {
        bundle.putInt(OpenApiConstant.DialogBitmapArgsConstant.DEBRIS_HEIGHT, this.height);
        bundle.putInt(OpenApiConstant.DialogBitmapArgsConstant.DEBRIS_WIDTH, this.width);
        bundle.putInt(OpenApiConstant.DialogBitmapArgsConstant.DEBRIS_CUT_TOP, this.cutTop);
        bundle.putInt(OpenApiConstant.DialogBitmapArgsConstant.DEBRIS_CROP_HEIGHT, this.cropHeight);
        bundle.putInt(OpenApiConstant.DialogBitmapArgsConstant.DEBRIS_CUT_START, this.cutStart);
        bundle.putInt(OpenApiConstant.DialogBitmapArgsConstant.DEBRIS_CROP_WIDTH, this.cropWidth);
        bundle.putInt(OpenApiConstant.DialogBitmapArgsConstant.DEBRIS_TYPE, this.type);
    }

    public String toString() {
        return "DialogBitmapArgs{type=" + this.type + ", cutTop=" + this.cutTop + ", cutStart=" + this.cutStart + ", width=" + this.width + ", height=" + this.height + ", cropHeight=" + this.cropHeight + ", cropWidth=" + this.cropWidth + '}';
    }

    public DialogBitmapArgs(int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        this.cutTop = i2;
        this.cutStart = i3;
        this.cropWidth = i4;
        this.cropHeight = i5;
        this.type = i8;
        this.width = i6;
        this.height = i7;
        setWidthAndHeight(i8, i6, i7);
    }

    public DialogBitmapArgs(int i2, int i3, int i4, int i5, int i6) {
        this(i2, i3, i4, i5, 0, 0, i6);
    }
}
