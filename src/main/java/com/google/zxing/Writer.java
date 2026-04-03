package com.google.zxing;

import com.google.zxing.common.BitMatrix;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public interface Writer {
    BitMatrix encode(String str, int i2, int i3, int i4) throws WriterException;

    BitMatrix encode(String str, int i2, int i3, int i4, Map<EncodeHintType, ?> map) throws WriterException;
}
