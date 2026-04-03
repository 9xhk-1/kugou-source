package e.c.c.j.d;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a {
    public String START_IDENTIFY_VALUE = "start";
    public String END_IDENTIFY_VALUE = "end";

    public static a init() {
        return b.a();
    }

    public abstract void add(String str, String str2);

    public abstract void add(String str, String str2, String str3);

    public abstract void end(String str);

    public abstract void end(String str, long j);

    public abstract void end(String str, String str2);

    public long getStartTime(String str) {
        throw new RuntimeException("Not support interface");
    }

    public abstract String start(String str);

    public abstract String start(String str, int i2);

    public abstract String start(String str, long j);
}
