package e.f.a.a.c.c;

/* JADX INFO: loaded from: classes2.dex */
public interface a {
    byte[] getCrashExtraData(boolean z, String str, String str2, String str3, int i2, long j);

    String getCrashExtraMessage(boolean z, String str, String str2, String str3, int i2, long j);

    boolean onCrashHandleEnd(boolean z);

    void onCrashHandleStart(boolean z);

    boolean onCrashSaving(boolean z, String str, String str2, String str3, int i2, long j, String str4, String str5, String str6, String str7);
}
