package com.tencent.tmachine.trace.util;

import android.os.Looper;
import androidx.core.app.NotificationCompat;
import com.tencent.tmachine.trace.cpu.data.CpuInfo;
import com.tencent.tmachine.trace.cpu.data.CpuInfoTrace;
import com.tencent.tmachine.trace.looper.data.DispatchRecordTrace;
import com.tencent.tmachine.trace.looper.data.HistoryRecord;
import com.tencent.tmachine.trace.looper.data.KeyPendingMsg;
import com.tencent.tmachine.trace.looper.data.PendingMsgTrace;
import com.tencent.tmachine.trace.looper.data.PendingRecord;
import com.tencent.tmachine.trace.looper.data.RunningRecord;
import com.tencent.tmachine.trace.looper.data.SyncBarrierMsg;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class TraceUtil {
    private static final String TAG = "TraceUtil";

    public static JSONArray cpuTraceToJSON(CpuInfoTrace cpuInfoTrace) {
        if (cpuInfoTrace == null || cpuInfoTrace.getCpuInfoList().size() <= 0) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        for (CpuInfo cpuInfo : cpuInfoTrace.getCpuInfoList()) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("ts", cpuInfo.getTimeStamp());
                jSONObject.put(NotificationCompat.CATEGORY_SYSTEM, cpuInfo.getSysCpuUsagePercent());
                jSONObject.put("proc", cpuInfo.getProcCpuUsagePercent());
                jSONObject.put("main", cpuInfo.getMainThreadRunningPercent());
                jSONArray.put(jSONObject);
            } catch (JSONException e2) {
                TMachineLog.e(TAG, "[cpuTraceToJSON] err=", e2);
            }
        }
        if (jSONArray.length() > 0) {
            return jSONArray;
        }
        return null;
    }

    public static JSONObject dispatchRecordTraceToJSON(DispatchRecordTrace dispatchRecordTrace) {
        if (dispatchRecordTrace == null) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            List<HistoryRecord> historyRecordList = dispatchRecordTrace.getHistoryRecordList();
            if (historyRecordList != null && historyRecordList.size() > 0) {
                JSONArray jSONArray = new JSONArray();
                for (HistoryRecord historyRecord : historyRecordList) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("occurTime", historyRecord.getOccurTime());
                    jSONObject2.put("recType", historyRecord.getRecType());
                    jSONObject2.put("wallTime", historyRecord.getWallTime());
                    jSONObject2.put("cpuTime", historyRecord.getCpuTime());
                    jSONObject2.put("msgCount", historyRecord.getMsgCount());
                    jSONObject2.put("desc", historyRecord.getDesc());
                    jSONObject2.put("msgDesc", historyRecord.getMsgDesc());
                    jSONArray.put(jSONObject2);
                }
                jSONObject.put("history", jSONArray);
            }
            RunningRecord runningRecord = dispatchRecordTrace.getRunningRecord();
            if (runningRecord != null) {
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("occurTime", runningRecord.getOccurTime());
                jSONObject3.put("wallTime", runningRecord.getWallTime());
                jSONObject3.put("stack", getMainThreadJavaStackTrace());
                jSONObject.put("running", jSONObject3);
            }
            List<PendingRecord> pendingRecordList = dispatchRecordTrace.getPendingRecordList();
            if (pendingRecordList != null && pendingRecordList.size() > 0) {
                JSONArray jSONArray2 = new JSONArray();
                for (PendingRecord pendingRecord : pendingRecordList) {
                    JSONObject jSONObject4 = new JSONObject();
                    jSONObject4.put("blockTime", pendingRecord.getBlockTime());
                    jSONObject4.put("msgCount", pendingRecord.getMsgCount());
                    jSONObject4.put("desc", pendingRecord.getDesc());
                    jSONObject4.put("msgDesc", pendingRecord.getMsgDesc());
                    jSONArray2.put(jSONObject4);
                }
                jSONObject.put("pending", jSONArray2);
            }
            if (jSONObject.length() <= 0) {
                return null;
            }
            List<SyncBarrierMsg> syncBarrierMsgList = dispatchRecordTrace.getSyncBarrierMsgList();
            List<KeyPendingMsg> keyPendingMsgList = dispatchRecordTrace.getKeyPendingMsgList();
            jSONObject.put("pendingMsgCnt", dispatchRecordTrace.getPendingMsgCnt());
            jSONObject.put("syncBarrierMsgCnt", syncBarrierMsgList == null ? 0 : syncBarrierMsgList.size());
            jSONObject.put("keyPendingMsgCnt", keyPendingMsgList == null ? 0 : keyPendingMsgList.size());
            return jSONObject;
        } catch (JSONException e2) {
            TMachineLog.e(TAG, "[dispatchRecordTraceToJSON] err=", e2);
            return null;
        }
    }

    private static String getMainThreadJavaStackTrace() {
        StringBuilder sb = new StringBuilder();
        for (StackTraceElement stackTraceElement : Looper.getMainLooper().getThread().getStackTrace()) {
            sb.append(stackTraceElement.toString());
            sb.append("\n");
        }
        return sb.toString();
    }

    public static JSONObject pendingMsgTraceToJSON(PendingMsgTrace pendingMsgTrace) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("pendingMsgCnt", pendingMsgTrace.getPendingMsgCnt());
            jSONObject.put("syncBarrierMsgCnt", pendingMsgTrace.getSyncBarrierMsgList() == null ? 0 : pendingMsgTrace.getSyncBarrierMsgList().size());
            jSONObject.put("keyPendingMsgCnt", pendingMsgTrace.getKeyPendingMsgList() == null ? 0 : pendingMsgTrace.getKeyPendingMsgList().size());
            return jSONObject;
        } catch (JSONException e2) {
            TMachineLog.e(TAG, "[pendingMsgTraceToJSON] err=", e2);
            return null;
        }
    }
}
