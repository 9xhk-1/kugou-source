package com.kugou.framework.musichunter;

import com.kugou.framework.musichunter.fp2013.Fingerprint2013;
import com.kugou.framework.musichunter.fp2013.FingerprintHumph;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
public class FingerprintHandler {
    private AtomicInteger count;
    private Fingerprint2013 fp2013;
    private long handler;
    private FingerprintHumph mFingerprintHumph;
    private int recordType;

    public FingerprintHandler(Fingerprint2013 fingerprint2013, FingerprintHumph fingerprintHumph, int i2) {
        this.fp2013 = fingerprint2013;
        this.mFingerprintHumph = fingerprintHumph;
        this.recordType = i2;
        if (RecordType.isHunterType(i2)) {
            long jQueryFingerprintXiaokongInitIntime = this.fp2013.queryFingerprintXiaokongInitIntime();
            this.handler = jQueryFingerprintXiaokongInitIntime;
            this.fp2013.queryFingerprintSetVersion(jQueryFingerprintXiaokongInitIntime, 1);
        } else {
            this.handler = this.mFingerprintHumph.fingerprintInit();
        }
        this.count = new AtomicInteger(1);
    }

    public void close() {
        if (this.handler != 0 && this.count.decrementAndGet() == 0) {
            if (RecordType.isHunterType(this.recordType)) {
                this.fp2013.queryFingerprintXiaokongFree(this.handler);
            } else {
                this.mFingerprintHumph.fingerprintFree(this.handler);
            }
            this.handler = 0L;
        }
    }

    public boolean open() {
        int i2;
        do {
            i2 = this.count.get();
            if (i2 == 0) {
                return false;
            }
        } while (!this.count.compareAndSet(i2, i2 + 1));
        return true;
    }

    public int[] queryFingerprintXiaokong(byte[] bArr, byte[] bArr2, boolean z) {
        if (this.handler == 0) {
            return null;
        }
        return RecordType.isHunterType(this.recordType) ? this.fp2013.queryFingerprintXiaokong(this.handler, bArr, bArr2, z) : this.mFingerprintHumph.fingerprintHumph(this.handler, bArr, bArr2, z);
    }
}
