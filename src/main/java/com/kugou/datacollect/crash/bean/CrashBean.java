package com.kugou.datacollect.crash.bean;

import android.content.ContentValues;
import android.text.TextUtils;
import android.util.Log;
import androidx.multidex.MultiDexExtractor;
import com.kugou.common.network.retrystatics.RetryStaticsLOG;
import com.kugou.uilib.widget.textview.span.TopicHighlightHelper;
import e.c.c.o.f;
import e.c.c.o.g;
import e.c.c.o.m;
import java.io.File;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class CrashBean extends ParcelBase {
    public static final String BREAK_LINE = "<br />";
    public static final int STATUS_IS_APP_UPGRADE_FIRST_START = 32;
    public static final int STATUS_UPLOAD_ZIP_FAILED = 8;
    public static final int STATUS_UPLOAD_ZIP_SUCCESSED = 16;
    public static final int STATUS_ZIP_FAILED = 2;
    public static final int STATUS_ZIP_SUCCESSED = 4;
    public String attachFilePath;
    public long cacheBeanId;
    public String className;
    public String crashChannel;
    public String crashGitVersion;
    public String crashOriginGitVersion;
    public long crashProcessId;
    public String crashProcessName;
    public long crashTime;
    public int crashType;
    public String crashVersion;
    public StringBuilder exceptionInfo;
    public StringBuilder exceptionStack;
    public String feature;
    public int flagStatusSend;
    public boolean isAppUpgradeFirstStart;
    public int kanUser;
    public int kgliveUser;
    public String logSendLog;
    public int numTrySend;
    public long preVersion;
    public String saveFilePath;
    public boolean sendCrashTreeResult;
    public boolean sendRateResult;
    public String uploadAttachFileResult;
    public String zipAttachFileLog;

    public CrashBean(int i2) {
        this.className = "";
        this.crashTime = 0L;
        this.crashProcessId = 0L;
        this.crashProcessName = "";
        this.crashType = 0;
        this.attachFilePath = "";
        this.zipAttachFileLog = "";
        this.uploadAttachFileResult = "";
        this.feature = "";
        this.logSendLog = "";
        this.saveFilePath = "";
        this.numTrySend = 0;
        this.isAppUpgradeFirstStart = false;
        this.preVersion = 0L;
        this.crashVersion = String.valueOf(m.x(f.a()));
        this.crashChannel = "crashChannel";
        this.crashGitVersion = "crashGitVersion";
        this.crashOriginGitVersion = "";
        this.sendRateResult = false;
        this.sendCrashTreeResult = false;
        this.exceptionInfo = new StringBuilder();
        this.exceptionStack = new StringBuilder();
        this.crashType = i2;
    }

    public static long getCrashTime(File file) {
        int iLastIndexOf;
        if (file == null) {
            return 0L;
        }
        String name = file.getName();
        if (TextUtils.isEmpty(name) || (iLastIndexOf = name.lastIndexOf(95)) < 0 || iLastIndexOf >= name.length()) {
            return 0L;
        }
        long j = Long.parseLong(name.substring(iLastIndexOf + 1));
        g.b("", "根据文件名解析到的崩溃时间" + j);
        return j;
    }

    public static String scanFeature(Throwable th) {
        if (th == null) {
            return "";
        }
        String name = th.getClass().getName();
        String name2 = th.getClass().getName();
        LinkedList linkedList = new LinkedList();
        while (th != null) {
            linkedList.add(0, th);
            th = th.getCause();
        }
        Iterator it = linkedList.iterator();
        int i2 = 0;
        int i3 = 0;
        while (it.hasNext()) {
            for (StackTraceElement stackTraceElement : ((Throwable) it.next()).getStackTrace()) {
                String str = RetryStaticsLOG.MARK_SEPERATE + stackTraceElement.getClassName() + "." + stackTraceElement.getMethodName();
                if (stackTraceElement.getFileName() != null && !stackTraceElement.getFileName().contains(".java")) {
                    str = str + ":" + stackTraceElement.getLineNumber();
                    name2 = name2 + str;
                    i2++;
                    if (i2 >= 5) {
                        return name2;
                    }
                }
                if (i3 < 8) {
                    name = name + str;
                    i3++;
                }
            }
        }
        return i2 > 3 ? name2 : name;
    }

    public void appendExceptionInfo(StringBuilder sb) {
        this.exceptionInfo.append((CharSequence) sb);
    }

    public void appendLogSendLog(String str) {
        this.logSendLog += str;
    }

    public String generateZipAttachFileName() {
        return getFileName() + MultiDexExtractor.EXTRACTED_SUFFIX;
    }

    public long getCacheBeanId() {
        return this.cacheBeanId;
    }

    public String getFeature() {
        return this.feature;
    }

    public String getFileName() {
        return String.valueOf(this.crashType) + "_" + String.valueOf(this.crashProcessId) + "_" + String.valueOf(this.crashTime);
    }

    public String getParamClassName() {
        return this.className;
    }

    public String getParamContent() {
        String str = "" + ((Object) this.exceptionStack) + BREAK_LINE + BREAK_LINE + ((Object) this.exceptionInfo) + BREAK_LINE + " value2:" + getParamValue2() + "; time:" + getParamCrashTime() + "; crashProcess:" + this.crashProcessName + "; classname: " + getParamClassName() + BREAK_LINE;
        if (!TextUtils.isEmpty(this.logSendLog)) {
            str = str + "logSendLog:" + this.logSendLog + BREAK_LINE;
        }
        if (!TextUtils.isEmpty(this.zipAttachFileLog)) {
            str = str + "; zipAttachFileLog:" + this.zipAttachFileLog + BREAK_LINE;
        }
        return (((((str + " numTrySend=" + this.numTrySend) + "; isAppUpgradeFirstStart=" + this.isAppUpgradeFirstStart + BREAK_LINE) + " saveFilePath=" + this.saveFilePath) + "\ncrashVersion=" + this.crashVersion) + "\ngitVersion=" + this.crashGitVersion) + "\npackageChannelID=" + this.crashChannel;
    }

    public String getParamCrashTime() {
        if (this.crashTime <= 0) {
            return "";
        }
        try {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(this.crashTime));
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public String getParamNdkName() {
        return this.uploadAttachFileResult;
    }

    public String getParamValue1() {
        return String.valueOf(this.crashProcessId);
    }

    public String getParamValue2() {
        return String.valueOf(this.crashType);
    }

    public String getParamValue3() {
        return this.attachFilePath;
    }

    public boolean hasAttachFileAndZipSuccessed() {
        return !TextUtils.isEmpty(this.attachFilePath) && this.attachFilePath.endsWith(MultiDexExtractor.EXTRACTED_SUFFIX);
    }

    public boolean isCCrashType() {
        return this.crashType == 1006;
    }

    public boolean isExceptionStackContains(String str) {
        return this.exceptionStack.indexOf(str) >= 0;
    }

    public boolean isSendCrashTreeResult() {
        return this.sendCrashTreeResult;
    }

    public boolean isSendRateResult() {
        return this.sendRateResult;
    }

    public boolean isUploadAttachFileSuccessed() {
        return !TextUtils.isEmpty(this.uploadAttachFileResult);
    }

    @Override // com.kugou.datacollect.crash.bean.ParcelBase
    public void parcel(Object obj, boolean z) {
        this.className = (String) parcel(obj, "className", this.className, z);
        this.crashTime = ((Long) parcel(obj, "crashTime", Long.valueOf(this.crashTime), z)).longValue();
        this.crashProcessId = ((Long) parcel(obj, "crashProcessId", Long.valueOf(this.crashProcessId), z)).longValue();
        this.crashProcessName = (String) parcel(obj, "crashProcessName", this.crashProcessName, z);
        this.crashType = ((Integer) parcel(obj, "crashType", Integer.valueOf(this.crashType), z)).intValue();
        this.attachFilePath = (String) parcel(obj, "attachFilePath", this.attachFilePath, z);
        this.uploadAttachFileResult = (String) parcel(obj, "uploadAttachFileResult", this.uploadAttachFileResult, z);
        this.exceptionStack = new StringBuilder((String) parcel(obj, "exceptionStack", ((Serializable) getDefaultIfNull(this.exceptionStack, "")).toString(), z));
        this.exceptionInfo = new StringBuilder((String) parcel(obj, "exceptionInfo", ((Serializable) getDefaultIfNull(this.exceptionInfo, "")).toString(), z));
        this.zipAttachFileLog = (String) parcel(obj, "zipAttachFileLog", this.zipAttachFileLog, z);
        this.logSendLog = (String) parcel(obj, "logSendLog", this.logSendLog, z);
        this.saveFilePath = (String) parcel(obj, "saveFilePath", this.saveFilePath, z);
        this.numTrySend = ((Integer) parcel(obj, "numTrySend", Integer.valueOf(this.numTrySend), z)).intValue();
        this.isAppUpgradeFirstStart = ((Boolean) parcel(obj, "isAppUpgradeFirstStart", Boolean.valueOf(this.isAppUpgradeFirstStart), z)).booleanValue();
        this.flagStatusSend = ((Integer) parcel(obj, "flagStatusSend", Integer.valueOf(this.flagStatusSend), z)).intValue();
        this.feature = (String) parcel(obj, "feature", this.feature, z);
        this.crashVersion = (String) parcel(obj, "crashVersion", this.crashVersion, z);
        this.crashChannel = (String) parcel(obj, "crashChannel", this.crashChannel, z);
        this.crashGitVersion = (String) parcel(obj, "crashGitVersion", this.crashGitVersion, z);
        this.kanUser = ((Integer) parcel(obj, "kanUser", Integer.valueOf(this.kanUser), z)).intValue();
        this.kgliveUser = ((Integer) parcel(obj, "kgliveUser", Integer.valueOf(this.kgliveUser), z)).intValue();
        this.preVersion = ((Long) parcel(obj, "preVersion", Long.valueOf(this.preVersion), z)).longValue();
        this.cacheBeanId = ((Long) parcel(obj, "cacheBeanId", Long.valueOf(this.cacheBeanId), z)).longValue();
        this.sendRateResult = ((Boolean) parcel(obj, "cacheBeanId", Boolean.valueOf(this.sendRateResult), z)).booleanValue();
        this.sendCrashTreeResult = ((Boolean) parcel(obj, "cacheBeanId", Boolean.valueOf(this.sendCrashTreeResult), z)).booleanValue();
    }

    public void setCacheBeanId(long j) {
        this.cacheBeanId = j;
    }

    public void setSendCrashTreeResult(boolean z) {
        this.sendCrashTreeResult = z;
    }

    public void setSendRateResult(boolean z) {
        this.sendRateResult = z;
    }

    public void toContentValues(ContentValues contentValues) {
        parcel(contentValues, false);
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        parcel(jSONObject, false);
        return jSONObject;
    }

    public String toString() {
        return TopicHighlightHelper.AT + hashCode() + "[" + toJson() + "]";
    }

    public void appendExceptionInfo(String str) {
        this.exceptionInfo.append(str);
    }

    public CrashBean(int i2, Throwable th) {
        this.className = "";
        this.crashTime = 0L;
        this.crashProcessId = 0L;
        this.crashProcessName = "";
        this.crashType = 0;
        this.attachFilePath = "";
        this.zipAttachFileLog = "";
        this.uploadAttachFileResult = "";
        this.feature = "";
        this.logSendLog = "";
        this.saveFilePath = "";
        this.numTrySend = 0;
        this.isAppUpgradeFirstStart = false;
        this.preVersion = 0L;
        this.crashVersion = String.valueOf(m.x(f.a()));
        this.crashChannel = "crashChannel";
        this.crashGitVersion = "crashGitVersion";
        this.crashOriginGitVersion = "";
        this.sendRateResult = false;
        this.sendCrashTreeResult = false;
        this.exceptionStack = new StringBuilder(Log.getStackTraceString(th));
        this.exceptionInfo = new StringBuilder();
        this.crashType = i2;
        this.feature = scanFeature(th);
    }

    public CrashBean(int i2, String str) {
        this.className = "";
        this.crashTime = 0L;
        this.crashProcessId = 0L;
        this.crashProcessName = "";
        this.crashType = 0;
        this.attachFilePath = "";
        this.zipAttachFileLog = "";
        this.uploadAttachFileResult = "";
        this.feature = "";
        this.logSendLog = "";
        this.saveFilePath = "";
        this.numTrySend = 0;
        this.isAppUpgradeFirstStart = false;
        this.preVersion = 0L;
        this.crashVersion = String.valueOf(m.x(f.a()));
        this.crashChannel = "crashChannel";
        this.crashGitVersion = "crashGitVersion";
        this.crashOriginGitVersion = "";
        this.sendRateResult = false;
        this.sendCrashTreeResult = false;
        this.exceptionStack = new StringBuilder(str);
        this.exceptionInfo = new StringBuilder();
        this.crashType = i2;
    }

    public CrashBean(ContentValues contentValues) {
        this.className = "";
        this.crashTime = 0L;
        this.crashProcessId = 0L;
        this.crashProcessName = "";
        this.crashType = 0;
        this.attachFilePath = "";
        this.zipAttachFileLog = "";
        this.uploadAttachFileResult = "";
        this.feature = "";
        this.logSendLog = "";
        this.saveFilePath = "";
        this.numTrySend = 0;
        this.isAppUpgradeFirstStart = false;
        this.preVersion = 0L;
        this.crashVersion = String.valueOf(m.x(f.a()));
        this.crashChannel = "crashChannel";
        this.crashGitVersion = "crashGitVersion";
        this.crashOriginGitVersion = "";
        this.sendRateResult = false;
        this.sendCrashTreeResult = false;
        parcel(contentValues, true);
    }

    public CrashBean(JSONObject jSONObject) {
        this.className = "";
        this.crashTime = 0L;
        this.crashProcessId = 0L;
        this.crashProcessName = "";
        this.crashType = 0;
        this.attachFilePath = "";
        this.zipAttachFileLog = "";
        this.uploadAttachFileResult = "";
        this.feature = "";
        this.logSendLog = "";
        this.saveFilePath = "";
        this.numTrySend = 0;
        this.isAppUpgradeFirstStart = false;
        this.preVersion = 0L;
        this.crashVersion = String.valueOf(m.x(f.a()));
        this.crashChannel = "crashChannel";
        this.crashGitVersion = "crashGitVersion";
        this.crashOriginGitVersion = "";
        this.sendRateResult = false;
        this.sendCrashTreeResult = false;
        parcel(jSONObject, true);
    }
}
