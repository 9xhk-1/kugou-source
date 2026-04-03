package com.kugou.framework.musichunter.v2;

import androidx.annotation.NonNull;
import com.kugou.framework.bilib.common.LibConfig;
import com.kugou.framework.musichunter.FileUtil;
import com.kugou.framework.musichunter.QingChangIdentifyProtocol;
import com.kugou.framework.musichunter.RecognizeResult;
import com.kugou.framework.musichunter.v2.IdentifyProcessor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class QingChangProcessor extends IdentifyProcessor {
    private List<Integer> requestIntervalList;

    public QingChangProcessor(IdentifyProcessor.Scheduler scheduler, @NonNull IdentifyProcessor.OnProcessFinish onProcessFinish, IdentifyContext identifyContext) {
        super(scheduler, onProcessFinish, identifyContext == null ? IdentifyContext.mCurContext : identifyContext);
        this.requestIntervalList = new ArrayList(Arrays.asList(6, 8, 10, 12, 15));
    }

    @Override // com.kugou.framework.musichunter.v2.IdentifyProcessor
    public RecognizeResult process(PcmData pcmData) {
        if (!this.requestIntervalList.contains(Integer.valueOf(pcmData.index))) {
            return buildInvalidResult(401);
        }
        if (!FileUtil.isExist(getPcmFileName())) {
            return buildInvalidResult(4);
        }
        byte[] fileData = FileUtil.getFileData(getPcmFileName());
        if (fileData == null) {
            if (LibConfig.isDebug()) {
                log("QC pcm为null");
            }
            return buildInvalidResult(402);
        }
        if (LibConfig.isDebug()) {
            log("QC 开始请求");
        }
        RecognizeResult recognizeResultRequestInTime = new QingChangIdentifyProtocol(getUniqueId()).requestInTime(fileData, pcmData.pcmEnd, pcmData.timeLength);
        recognizeResultRequestInTime.setFrom(4);
        return recognizeResultRequestInTime;
    }
}
