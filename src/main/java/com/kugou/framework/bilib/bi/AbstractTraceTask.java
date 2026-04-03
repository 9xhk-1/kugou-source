package com.kugou.framework.bilib.bi;

import android.os.Build;
import com.kugou.framework.bilib.LibLog;
import com.kugou.framework.bilib.bi.easytrace.EasytraceUtil;
import com.kugou.framework.bilib.bi.easytrace.KeyValueList;
import com.kugou.framework.bilib.common.LibConfig;
import com.kugou.framework.bilib.common.SystemUtils;
import com.kugou.framework.libcommon.MD5Util;
import java.math.BigInteger;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractTraceTask {
    public static final String TIME_FORMAT = "yyyy-MM-dd HH:mm:ss.SSS";
    private static String sChannelID = "";
    public static int sSequence;
    public boolean isPostpone;
    public KeyValueList.KeyValue mLLCKeyValue;
    private boolean mSync = false;
    public boolean isSentToBI = false;
    public KeyValueList mKeyValueList = new KeyValueList();

    public static String imeiToBigInteger(String str) {
        try {
            BigInteger bigInteger = new BigInteger("0");
            BigInteger bigInteger2 = new BigInteger("16");
            String mD5ofStr = MD5Util.getMD5ofStr(str);
            int length = mD5ofStr.length();
            for (int i2 = 0; i2 < length; i2++) {
                bigInteger = bigInteger.add(new BigInteger("" + mD5ofStr.charAt(i2), 16).multiply(bigInteger2.pow((length - 1) - i2)));
            }
            return bigInteger.toString();
        } catch (Exception unused) {
            return "0";
        }
    }

    public abstract void assembleKeyValueList();

    public void buildEnviromentList() {
        this.mKeyValueList.add("lvt", EasytraceUtil.formatTime(System.currentTimeMillis(), TIME_FORMAT));
        this.mKeyValueList.add("tv", LibConfig.getInstance().getVersionCode());
        this.mKeyValueList.add("brand", Build.BRAND);
        int[] screenSize = SystemUtils.getScreenSize();
        this.mKeyValueList.add("wh", screenSize[0] + "*" + screenSize[1]);
        this.mKeyValueList.add("mid", LibConfig.getInstance().getMid(LibConfig.getContext()));
        this.mKeyValueList.add("uuid", LibConfig.getInstance().getUUID());
        this.mKeyValueList.add("pt", "android");
    }

    public boolean isCustomizeSk() {
        return false;
    }

    public boolean isSync() {
        return this.mSync;
    }

    public String recordLine() {
        if (LibLog.DEBUG) {
            LibLog.d("PanBC-trace", "mKeyValueList empty:" + this.mKeyValueList.isEmpty());
        }
        if (this.mKeyValueList.isEmpty()) {
            assembleKeyValueList();
            buildEnviromentList();
        }
        if (LibLog.DEBUG) {
            LibLog.d("PanBC-trace", "isPostpone:" + this.isPostpone);
        }
        if (this.isPostpone) {
            if (LibLog.DEBUG) {
                StringBuilder sb = new StringBuilder();
                sb.append("mLLCKeyValue != null:");
                sb.append(this.mLLCKeyValue != null);
                LibLog.d("PanBC-trace", sb.toString());
            }
            KeyValueList.KeyValue keyValue = this.mLLCKeyValue;
            if (keyValue != null) {
                this.mKeyValueList.remove(keyValue);
            }
            this.mKeyValueList.add("llc", "2");
        }
        return EasytraceUtil.format(this.mKeyValueList);
    }

    public HashMap<String, Object> recordMap() {
        if (LibLog.DEBUG) {
            LibLog.d("PanBC-trace", "mKeyValueList empty:" + this.mKeyValueList.isEmpty());
        }
        if (this.mKeyValueList.isEmpty()) {
            assembleKeyValueList();
            buildEnviromentList();
        }
        if (LibLog.DEBUG) {
            LibLog.d("PanBC-trace", "isPostpone:" + this.isPostpone);
        }
        if (this.isPostpone) {
            if (LibLog.DEBUG) {
                StringBuilder sb = new StringBuilder();
                sb.append("mLLCKeyValue != null:");
                sb.append(this.mLLCKeyValue != null);
                LibLog.d("PanBC-trace", sb.toString());
            }
            KeyValueList.KeyValue keyValue = this.mLLCKeyValue;
            if (keyValue != null) {
                this.mKeyValueList.remove(keyValue);
            }
            this.mKeyValueList.add("llc", "2");
        }
        HashMap<String, Object> map = new HashMap<>();
        for (KeyValueList.KeyValue keyValue2 : this.mKeyValueList.getList()) {
            map.put(keyValue2.getKey(), keyValue2.getValue());
        }
        return map;
    }

    public AbstractTraceTask setPostpone() {
        this.isPostpone = true;
        return this;
    }

    public void setSyncTrace() {
        this.mSync = true;
    }

    public void toggleSyncTrace(boolean z) {
        this.mSync = z;
    }
}
