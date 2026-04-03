package com.kugou.common.network.protocol.response;

import com.kugou.common.network.networkutils.json.JsonReader;
import com.kugou.common.network.networkutils.json.JsonToken;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;

/* JADX INFO: loaded from: classes2.dex */
public class CheckJson implements IResponseTypeChecker {
    @Override // com.kugou.common.network.protocol.response.IResponseTypeChecker
    public boolean checkResponseType(byte[] bArr) {
        if (bArr == null || bArr.length <= 0) {
            return false;
        }
        try {
            JsonToken jsonTokenPeek = new JsonReader(new InputStreamReader(new ByteArrayInputStream(bArr), "UTF-8")).peek();
            if (jsonTokenPeek != JsonToken.BEGIN_OBJECT) {
                return jsonTokenPeek == JsonToken.BEGIN_ARRAY;
            }
            return true;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    @Override // com.kugou.common.network.protocol.response.IResponseTypeChecker
    public int getCheckType() {
        return 1;
    }
}
