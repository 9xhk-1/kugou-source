package com.kugou.framework.lyric4.cell.breakline;

import android.graphics.Paint;
import com.kugou.framework.lyric4.span.Span;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public interface BreakLineStrategy {
    LyricLineInfo[] getBreakLineResult(Map<Integer, Span> map, String[] strArr, int i2, Paint paint, float f2);
}
