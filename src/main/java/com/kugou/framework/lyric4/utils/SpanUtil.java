package com.kugou.framework.lyric4.utils;

import android.graphics.Paint;
import android.text.TextUtils;
import com.kugou.framework.lyric4.span.Span;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class SpanUtil {
    public static float getHeight(float f2, Map<Integer, Span> map) {
        if (!Utils.isEmpty(map)) {
            Iterator<Map.Entry<Integer, Span>> it = map.entrySet().iterator();
            while (it.hasNext()) {
                f2 = Math.max(f2, it.next().getValue().getHeight());
            }
        }
        return f2;
    }

    public static int getLsatIndex(Map<Integer, Span> map) {
        int iMax = 0;
        if (Utils.isEmpty(map)) {
            return 0;
        }
        Iterator<Map.Entry<Integer, Span>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            iMax = Math.max(it.next().getKey().intValue(), iMax);
        }
        return iMax;
    }

    public static boolean hit(float f2, float f3, float f4, float f5, float f6, float f7) {
        return f6 >= f2 && f6 <= f4 && f7 >= f3 && f7 <= f5;
    }

    public static boolean hit(Span span, float f2, float f3) {
        return span != null && hit(span.getLeft(), span.getTop(), span.getRight(), span.getBottom(), f2, f3);
    }

    public static List<Span> mapChangeList(Map<Integer, Span>[] mapArr) {
        ArrayList arrayList = new ArrayList();
        if (!Utils.isEmpty(mapArr)) {
            for (Map<Integer, Span> map : mapArr) {
                if (!Utils.isEmpty(map)) {
                    Iterator<Map.Entry<Integer, Span>> it = map.entrySet().iterator();
                    while (it.hasNext()) {
                        arrayList.add(it.next().getValue());
                    }
                }
            }
        }
        return arrayList;
    }

    public static float measureText(Paint paint, Map<Integer, Span> map, int i2, String str) {
        Span span;
        return (Utils.isEmpty(map) || (span = map.get(Integer.valueOf(i2))) == null || !TextUtils.equals(str, span.getWord())) ? paint.measureText(str) : span.measure(paint) ? span.getWidth() : paint.measureText(str);
    }
}
