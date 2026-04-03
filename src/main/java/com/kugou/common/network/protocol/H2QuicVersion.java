package com.kugou.common.network.protocol;

import java.io.Serializable;
import org.apache.http.ProtocolVersion;

/* JADX INFO: loaded from: classes2.dex */
public class H2QuicVersion extends ProtocolVersion implements Serializable {
    public static final String HTTP2 = "h2";
    public static final String QUIC = "quic";

    public H2QuicVersion(String str, int i2, int i3) {
        super(str, i2, i3);
    }
}
