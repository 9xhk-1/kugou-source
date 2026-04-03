package com.kugou.common.network.quic;

import android.text.TextUtils;
import com.kugou.common.network.protocol.H2QuicVersion;
import com.kugou.common.network.quic.CronetApacheClient;
import h.a.b.d;
import h.a.b.m;
import h.a.b.n;
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.WritableByteChannel;

/* JADX INFO: loaded from: classes2.dex */
public class CronetRequestCallback extends m.b {
    private ByteArrayOutputStream bytesReceived;
    private final Object lock;
    private WritableByteChannel receiveChannel;
    private CronetApacheClient.CronetResponseEntity responseEntity;

    public CronetRequestCallback(Object obj, CronetApacheClient.CronetResponseEntity cronetResponseEntity) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        this.bytesReceived = byteArrayOutputStream;
        this.receiveChannel = Channels.newChannel(byteArrayOutputStream);
        this.lock = obj;
        this.responseEntity = cronetResponseEntity;
    }

    @Override // h.a.b.m.b
    public void onFailed(m mVar, n nVar, d dVar) {
        this.responseEntity.message = dVar.getMessage();
        this.responseEntity.responseBytes = new byte[0];
        synchronized (this.lock) {
            this.lock.notify();
        }
    }

    @Override // h.a.b.m.b
    public void onReadCompleted(m mVar, n nVar, ByteBuffer byteBuffer) throws Exception {
        byteBuffer.flip();
        this.receiveChannel.write(byteBuffer);
        byteBuffer.clear();
        mVar.d(byteBuffer);
    }

    @Override // h.a.b.m.b
    public void onRedirectReceived(m mVar, n nVar, String str) throws Exception {
        mVar.b();
    }

    @Override // h.a.b.m.b
    public void onResponseStarted(m mVar, n nVar) throws Exception {
        mVar.d(ByteBuffer.allocateDirect(32768));
    }

    @Override // h.a.b.m.b
    public void onSucceeded(m mVar, n nVar) {
        this.responseEntity.responseBytes = this.bytesReceived.toByteArray();
        this.responseEntity.code = nVar.b();
        this.responseEntity.headerList = nVar.a();
        this.responseEntity.message = nVar.toString();
        String strD = nVar.d();
        if (TextUtils.isEmpty(strD)) {
            strD = "unknown";
        }
        String lowerCase = strD.toLowerCase();
        if (lowerCase.contains("quic")) {
            this.responseEntity.protocolVersion = new H2QuicVersion("quic", 0, 0);
        } else if (lowerCase.contains(H2QuicVersion.HTTP2)) {
            this.responseEntity.protocolVersion = new H2QuicVersion(H2QuicVersion.HTTP2, 0, 0);
        } else {
            this.responseEntity.protocolVersion = new H2QuicVersion(lowerCase, 0, 0);
        }
        synchronized (this.lock) {
            this.lock.notify();
        }
    }
}
