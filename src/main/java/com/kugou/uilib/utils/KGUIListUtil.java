package com.kugou.uilib.utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class KGUIListUtil {
    public static <T> List<T> deDuplication(List<T> list) {
        ArrayList arrayList = new ArrayList();
        if (list == null) {
            return arrayList;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            linkedHashSet.add(it.next());
        }
        arrayList.addAll(linkedHashSet);
        return arrayList;
    }

    public static <T> T getData(List<T> list, int i2) {
        if (isEmpty(list) || i2 >= list.size()) {
            return null;
        }
        return list.get(i2);
    }

    public static boolean isEmpty(Collection collection) {
        return collection == null || collection.isEmpty();
    }

    public static int size(Collection collection) {
        if (collection == null || collection.isEmpty()) {
            return 0;
        }
        return collection.size();
    }
}
