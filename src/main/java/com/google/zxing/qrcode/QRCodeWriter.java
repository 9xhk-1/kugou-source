package com.google.zxing.qrcode;

import com.google.zxing.EncodeHintType;
import com.google.zxing.Writer;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.google.zxing.qrcode.encoder.ByteMatrix;
import com.google.zxing.qrcode.encoder.Encoder;
import com.google.zxing.qrcode.encoder.QRCode;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class QRCodeWriter implements Writer {
    private static final int QUIET_ZONE_SIZE = 4;

    private static BitMatrix renderResult(QRCode qRCode, int i2, int i3, int i4) {
        ByteMatrix matrix = qRCode.getMatrix();
        if (matrix == null) {
            throw new IllegalStateException();
        }
        int width = matrix.getWidth();
        int height = matrix.getHeight();
        int i5 = i4 << 1;
        int i6 = width + i5;
        int i7 = i5 + height;
        int iMax = Math.max(i2, i6);
        int iMax2 = Math.max(i3, i7);
        int iMin = Math.min(iMax / i6, iMax2 / i7);
        int i8 = (iMax - (width * iMin)) / 2;
        int i9 = (iMax2 - (height * iMin)) / 2;
        BitMatrix bitMatrix = new BitMatrix(iMax, iMax2);
        int i10 = 0;
        while (i10 < height) {
            int i11 = i8;
            int i12 = 0;
            while (i12 < width) {
                if (matrix.get(i12, i10) == 1) {
                    bitMatrix.setRegion(i11, i9, iMin, iMin);
                }
                i12++;
                i11 += iMin;
            }
            i10++;
            i9 += iMin;
        }
        return bitMatrix;
    }

    @Override // com.google.zxing.Writer
    public BitMatrix encode(String str, int i2, int i3, int i4) throws WriterException {
        return encode(str, i2, i3, i4, null);
    }

    @Override // com.google.zxing.Writer
    public BitMatrix encode(String str, int i2, int i3, int i4, Map<EncodeHintType, ?> map) throws WriterException {
        if (str.length() == 0) {
            throw new IllegalArgumentException("Found empty contents");
        }
        if (i2 != 12) {
            throw new IllegalArgumentException("Can only encode QR_CODE, but got " + i2);
        }
        if (i3 < 0 || i4 < 0) {
            throw new IllegalArgumentException("Requested dimensions are too small: " + i3 + 'x' + i4);
        }
        ErrorCorrectionLevel errorCorrectionLevel = ErrorCorrectionLevel.L;
        int iIntValue = 4;
        if (map != null) {
            ErrorCorrectionLevel errorCorrectionLevel2 = (ErrorCorrectionLevel) map.get(EncodeHintType.ERROR_CORRECTION);
            if (errorCorrectionLevel2 != null) {
                errorCorrectionLevel = errorCorrectionLevel2;
            }
            Integer num = (Integer) map.get(EncodeHintType.MARGIN);
            if (num != null) {
                iIntValue = num.intValue();
            }
        }
        return renderResult(Encoder.encode(str, errorCorrectionLevel, map), i3, i4, iIntValue);
    }
}
