package com.tencent.tmachine.trace.provider.stacktrace;

import defpackage.a;
import f.z.d.j;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public final class StackLink {
    private final ArrayList<String> link;
    private final double timeConsume;

    public StackLink(double d2, ArrayList<String> arrayList) {
        j.f(arrayList, "link");
        this.timeConsume = d2;
        this.link = arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ StackLink copy$default(StackLink stackLink, double d2, ArrayList arrayList, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            d2 = stackLink.timeConsume;
        }
        if ((i2 & 2) != 0) {
            arrayList = stackLink.link;
        }
        return stackLink.copy(d2, arrayList);
    }

    public final double component1() {
        return this.timeConsume;
    }

    public final ArrayList<String> component2() {
        return this.link;
    }

    public final StackLink copy(double d2, ArrayList<String> arrayList) {
        j.f(arrayList, "link");
        return new StackLink(d2, arrayList);
    }

    public final long costTime() {
        double d2 = this.timeConsume;
        double d3 = 1000;
        Double.isNaN(d3);
        return (long) (d2 * d3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof StackLink)) {
            return false;
        }
        StackLink stackLink = (StackLink) obj;
        return Double.compare(this.timeConsume, stackLink.timeConsume) == 0 && j.a(this.link, stackLink.link);
    }

    public final ArrayList<String> getLink() {
        return this.link;
    }

    public final double getTimeConsume() {
        return this.timeConsume;
    }

    public int hashCode() {
        int iA = a.a(this.timeConsume) * 31;
        ArrayList<String> arrayList = this.link;
        return iA + (arrayList != null ? arrayList.hashCode() : 0);
    }

    public String toString() {
        return "StackLink(timeConsume=" + this.timeConsume + ", link=" + this.link + ")";
    }
}
