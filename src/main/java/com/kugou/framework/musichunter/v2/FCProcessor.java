package com.kugou.framework.musichunter.v2;

import androidx.annotation.NonNull;
import com.kugou.framework.bilib.common.LibConfig;
import com.kugou.framework.musichunter.FCIdentifyProtocol;
import com.kugou.framework.musichunter.FileUtil;
import com.kugou.framework.musichunter.RecognizeResult;
import com.kugou.framework.musichunter.fp2013.Fingerprint2021;
import com.kugou.framework.musichunter.v2.IdentifyProcessor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class FCProcessor extends IdentifyProcessor {
    private List<Integer> requestIntervalList;

    public FCProcessor(IdentifyProcessor.Scheduler scheduler, @NonNull IdentifyProcessor.OnProcessFinish onProcessFinish, IdentifyContext identifyContext) {
        super(scheduler, onProcessFinish, identifyContext == null ? IdentifyContext.mCurContext : identifyContext);
        this.requestIntervalList = new ArrayList(Arrays.asList(6, 8, 10, 12, 15));
    }

    public byte[] makeFCFingerPrint(byte[] bArr, int i2) {
        if (!Fingerprint2021.loadOK()) {
            return null;
        }
        Fingerprint2021 fingerprint2021 = new Fingerprint2021();
        long jFingerprintInit = fingerprint2021.fingerprintInit(i2);
        byte[] bArr2 = new byte[bArr.length];
        int[] iArrFingerprintGet = fingerprint2021.fingerprintGet(jFingerprintInit, bArr, bArr2);
        byte[] bArr3 = new byte[bArr.length];
        int[] iArrFingerprintFlush = fingerprint2021.fingerprintFlush(jFingerprintInit, bArr3);
        byte[] bArr4 = new byte[iArrFingerprintGet[1] + iArrFingerprintFlush[1]];
        System.arraycopy(bArr2, 0, bArr4, 0, iArrFingerprintGet[1]);
        System.arraycopy(bArr3, 0, bArr4, iArrFingerprintGet[1], iArrFingerprintFlush[1]);
        fingerprint2021.fingerprintFree(jFingerprintInit);
        return bArr4;
    }

    @Override // com.kugou.framework.musichunter.v2.IdentifyProcessor
    public RecognizeResult process(PcmData pcmData) {
        if (!this.requestIntervalList.contains(Integer.valueOf(pcmData.index))) {
            return buildInvalidResult(303);
        }
        if (!FileUtil.isExist(getPcmFileName())) {
            return buildInvalidResult(4);
        }
        byte[] fileData = FileUtil.getFileData(getPcmFileName());
        if (fileData == null) {
            if (LibConfig.isDebug()) {
                log("FC pcm为null");
            }
            return buildInvalidResult(304);
        }
        byte[] bArrMakeFCFingerPrint = makeFCFingerPrint(fileData, 16000);
        if (LibConfig.isDebug()) {
            log("FC 开始请求");
        }
        RecognizeResult recognizeResultRequestInTime = new FCIdentifyProtocol(getUniqueId()).requestInTime(bArrMakeFCFingerPrint, pcmData.index + 1);
        recognizeResultRequestInTime.setFrom(3);
        return recognizeResultRequestInTime;
    }
}
