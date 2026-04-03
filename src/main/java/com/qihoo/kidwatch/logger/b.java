package com.qihoo.kidwatch.logger;

import java.util.LinkedList;

/* JADX INFO: loaded from: classes2.dex */
public final class b<T> {
    private static int b = 200;
    public LinkedList<T> a;

    public b() {
        b = 200;
        this.a = new LinkedList<>();
    }

    public final boolean a() {
        LinkedList<T> linkedList = this.a;
        if (linkedList == null) {
            return true;
        }
        return linkedList.isEmpty();
    }

    public final String toString() {
        return this.a.toString();
    }
}
