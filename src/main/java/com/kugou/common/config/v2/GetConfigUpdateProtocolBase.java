package com.kugou.common.config.v2;

import android.text.TextUtils;
import com.kugou.common.config.util.Base64Util;
import e.b.a.d;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public abstract class GetConfigUpdateProtocolBase {
    public String parseConfigData(String str) {
        byte[] bytes = str.getBytes();
        int length = bytes.length / 4;
        int i2 = 0;
        int i3 = length;
        while (i2 < length) {
            byte b = bytes[i2];
            bytes[i2] = bytes[i3];
            bytes[i3] = b;
            i2++;
            i3++;
        }
        int i4 = length * 2;
        int i5 = length * 3;
        int i6 = i5;
        while (i4 < i5) {
            byte b2 = bytes[i4];
            bytes[i4] = bytes[i6];
            bytes[i6] = b2;
            i4++;
            i6++;
        }
        return new String(d.a(Base64Util.decode(new String(bytes))));
    }

    public abstract KGConfigUpdateEntity request(int i2, boolean z, int i3);

    public UpdateConfigResponseV2 requestAll(int i2, boolean z) {
        boolean z2;
        ArrayList arrayList = new ArrayList();
        int i3 = 0;
        do {
            i3++;
            KGConfigUpdateEntity kGConfigUpdateEntityRequest = request(i2, z, i3);
            if (kGConfigUpdateEntityRequest == null) {
                return null;
            }
            if (TextUtils.isEmpty(kGConfigUpdateEntityRequest.data.profile)) {
                z2 = false;
            } else {
                arrayList.add(parseConfigData(kGConfigUpdateEntityRequest.data.profile));
                KGConfigUpdateData kGConfigUpdateData = kGConfigUpdateEntityRequest.data;
                z2 = kGConfigUpdateData.needNextTime;
                i2 = kGConfigUpdateData.cursorId;
            }
        } while (z2);
        return new UpdateConfigResponseV2(i2, arrayList);
    }
}
