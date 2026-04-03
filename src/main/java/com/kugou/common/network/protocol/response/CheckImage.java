package com.kugou.common.network.protocol.response;

import androidx.exifinterface.media.ExifInterface;

/* JADX INFO: loaded from: classes2.dex */
public class CheckImage implements IResponseTypeChecker {
    @Override // com.kugou.common.network.protocol.response.IResponseTypeChecker
    public boolean checkResponseType(byte[] bArr) {
        if (bArr != null && bArr.length >= 2) {
            int i2 = bArr[0] & ExifInterface.MARKER;
            int i3 = bArr[1] & ExifInterface.MARKER;
            if (i2 == 255 && i3 == 216) {
                return true;
            }
            if (i2 == 137 && i3 == 80) {
                return true;
            }
            if (i2 == 66 && i3 == 77) {
                return true;
            }
            if (i2 == 71 && i3 == 73) {
                return true;
            }
        }
        return false;
    }

    @Override // com.kugou.common.network.protocol.response.IResponseTypeChecker
    public int getCheckType() {
        return 3;
    }
}
