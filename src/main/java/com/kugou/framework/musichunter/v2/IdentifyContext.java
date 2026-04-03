package com.kugou.framework.musichunter.v2;

import androidx.annotation.IntRange;
import androidx.annotation.Nullable;
import com.kugou.framework.musichunter.FingerprintHandler;
import com.kugou.framework.musichunter.RecognizeResult;
import com.kugou.framework.musichunter.RecordType;
import com.kugou.framework.musichunter.fp2013.Fingerprint2013;
import com.kugou.framework.musichunter.fp2013.FingerprintHumph;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class IdentifyContext {
    public static IdentifyContext mCurContext;
    public RecognizeResult fallBackResult;
    public long finalTime;
    public boolean isLocal;
    public boolean isRequestingSecond;
    public String localPcmName;
    private FingerprintHandler mFingerprintHandler;
    public int maxSlice;

    @Nullable
    public String pcmFileName;
    public final PcmSliceContainer pcmSlices = new PcmSliceContainer();
    public final int recordType;
    public final int taskId;
    public final long uniqueId;

    public static class PcmSliceContainer {
        private final ArrayList<byte[]> pcmSlices = new ArrayList<>();

        public synchronized void addPcmSlice(byte[] bArr) {
            this.pcmSlices.add(bArr);
        }

        public synchronized void clear() {
            this.pcmSlices.clear();
        }

        public synchronized byte[] readPcmBuffer(@IntRange(from = 0) int i2, @IntRange(from = 0) int i3) {
            int i4;
            ArrayList<byte[]> arrayList = this.pcmSlices;
            int size = arrayList.size();
            if (size > i2 && i3 > 0) {
                int i5 = i2;
                int length = 0;
                while (true) {
                    i4 = i2 + i3;
                    if (i5 >= i4 || i5 >= size) {
                        break;
                    }
                    length += arrayList.get(i5).length;
                    i5++;
                }
                byte[] bArr = new byte[length];
                int length2 = 0;
                while (i2 < i4 && i2 < size) {
                    byte[] bArr2 = arrayList.get(i2);
                    System.arraycopy(bArr2, 0, bArr, length2, bArr2.length);
                    length2 += bArr2.length;
                    i2++;
                }
                return bArr;
            }
            return null;
        }
    }

    private IdentifyContext(@IntRange(from = -2147483648L) int i2, @IntRange(from = -2147483648L) long j, @IntRange(from = 0) int i3) {
        this.taskId = i2;
        this.uniqueId = j;
        this.recordType = i3;
    }

    public static IdentifyContext create(@IntRange(from = 0) int i2, @IntRange(from = -2147483648L) int i3, @IntRange(from = -2147483648L) long j, @IntRange(from = 0) long j2, String str) {
        IdentifyContext identifyContext = new IdentifyContext(i3, j, i2);
        identifyContext.finalTime = j2;
        identifyContext.maxSlice = MusicHunterProcessorMgr.maxSlices(i2);
        identifyContext.pcmFileName = str;
        return identifyContext;
    }

    public FingerprintHandler getFingerprintHandler() {
        return this.mFingerprintHandler;
    }

    public void init() {
        FingerprintHumph fingerprintHumph;
        FingerprintHandler fingerprintHandler = this.mFingerprintHandler;
        if (fingerprintHandler != null) {
            fingerprintHandler.close();
        }
        Fingerprint2013 fingerprint2013 = null;
        if (RecordType.isHunterType(this.recordType)) {
            fingerprint2013 = new Fingerprint2013();
            fingerprintHumph = null;
        } else {
            fingerprintHumph = new FingerprintHumph();
        }
        this.mFingerprintHandler = new FingerprintHandler(fingerprint2013, fingerprintHumph, this.recordType);
    }

    public void releaseResource() {
        FingerprintHandler fingerprintHandler = this.mFingerprintHandler;
        if (fingerprintHandler != null) {
            fingerprintHandler.close();
            this.mFingerprintHandler = null;
        }
        this.pcmSlices.clear();
    }
}
