package com.kugou.framework.lyric.async;

import android.graphics.Paint;
import android.os.AsyncTask;
import android.support.v4.os.AsyncTaskCompat;
import com.kugou.framework.lyric.ILyricView;
import com.kugou.framework.lyric.LyricData;
import com.kugou.framework.lyric.LyricDataSpliter;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes2.dex */
public class AsyncSplitor {

    public static final class SplitEntity {
        public final float contentWidth;
        public final LyricData lyricData;
        public final WeakReference<ILyricView> lyricViewRefs;
        public final Paint paint;

        public SplitEntity(float f2, Paint paint, LyricData lyricData, ILyricView iLyricView) {
            this.contentWidth = f2;
            this.paint = paint;
            this.lyricData = lyricData;
            this.lyricViewRefs = new WeakReference<>(iLyricView);
        }
    }

    public static void splitDataAsync(ILyricView iLyricView, float f2, Paint paint, LyricData lyricData) {
        AsyncTaskCompat.executeParallel(new AsyncTask<SplitEntity, Void, Boolean>() { // from class: com.kugou.framework.lyric.async.AsyncSplitor.1
            @Override // android.os.AsyncTask
            public Boolean doInBackground(SplitEntity... splitEntityArr) {
                SplitEntity splitEntity;
                if (splitEntityArr == null || splitEntityArr.length != 1 || (splitEntity = splitEntityArr[0]) == null) {
                    return null;
                }
                try {
                    LyricData lyricDataSplitData = LyricDataSpliter.splitData(splitEntity.lyricData, splitEntity.contentWidth, splitEntity.paint);
                    lyricDataSplitData.setTranslateWords(splitEntity.lyricData.getTranslateWords());
                    lyricDataSplitData.setTransliterationWords(splitEntity.lyricData.getTransliterationWords());
                    lyricDataSplitData.setChineseWords(splitEntity.lyricData.getChineseWords());
                    ILyricView iLyricView2 = splitEntity.lyricViewRefs.get();
                    if (iLyricView2 != null) {
                        if (lyricDataSplitData != null) {
                            iLyricView2.setLyricData(lyricDataSplitData);
                        } else {
                            iLyricView2.setLyricData(splitEntity.lyricData);
                        }
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                return null;
            }
        }, new SplitEntity[]{new SplitEntity(f2, paint, lyricData, iLyricView)});
    }
}
