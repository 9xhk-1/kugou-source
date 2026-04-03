package com.kugou.framework.musichunter.v2;

import androidx.annotation.NonNull;
import com.kugou.framework.bilib.common.LibConfig;
import com.kugou.framework.musichunter.MusicPcmIdentifyProtocol;
import com.kugou.framework.musichunter.RecognizeResult;
import com.kugou.framework.musichunter.v2.IdentifyProcessor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class PcmModelProcessor extends IdentifyProcessor {
    private List<Integer> requestIntervalList;

    public PcmModelProcessor(IdentifyProcessor.Scheduler scheduler, @NonNull IdentifyProcessor.OnProcessFinish onProcessFinish, IdentifyContext identifyContext) {
        super(scheduler, onProcessFinish, identifyContext == null ? IdentifyContext.mCurContext : identifyContext);
        this.requestIntervalList = new ArrayList(Arrays.asList(3, 6, 9, 12, 15));
    }

    @Override // com.kugou.framework.musichunter.v2.IdentifyProcessor
    public RecognizeResult process(PcmData pcmData) {
        if (!this.requestIntervalList.contains(Integer.valueOf(pcmData.index))) {
            if (LibConfig.isDebug()) {
                log(String.format("PCM 第%d片忽略，下标未命中", Integer.valueOf(pcmData.index)));
            }
            return buildInvalidResult(501);
        }
        byte[] pcmBuffer = readPcmBuffer(0, pcmData.index);
        if (pcmBuffer == null) {
            if (LibConfig.isDebug()) {
                log("PCM pcm为null");
            }
            return buildInvalidResult(502);
        }
        if (LibConfig.isDebug()) {
            log("PCM 开始请求");
        }
        RecognizeResult recognizeResultRequestInTime = new MusicPcmIdentifyProtocol(getUniqueId()).requestInTime(pcmBuffer);
        recognizeResultRequestInTime.setFrom(7);
        return recognizeResultRequestInTime;
    }
}
