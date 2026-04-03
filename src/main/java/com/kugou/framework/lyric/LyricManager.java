package com.kugou.framework.lyric;

import android.graphics.Paint;
import android.os.HandlerThread;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import com.kugou.framework.lyric.async.AsyncSplitor;
import com.kugou.framework.lyric.debug.LyricDebug;
import com.kugou.framework.lyric.loader.ILyricLoader;
import com.kugou.framework.lyric.loader.KrcLoader;
import com.kugou.framework.lyric.loader.LrcLoader;
import com.kugou.framework.lyric.loader.TxtLoader;
import com.kugou.framework.lyric2.ISurLyricSync;
import com.kugou.framework.lyric4.utils.Utils;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class LyricManager {
    public static final String STR_REPLACE_RESULT_TAG = "'";
    public static final String STR_REPLACE_TAG = "&apos;";
    public static final Object lyrDataLock = new Object();
    private static Looper mWorkLooper = null;
    private static LyricManager manager = null;
    public static boolean switchEscapeCharacter = true;
    private static HandlerThread workThread;
    private ILyricLoader lyricLoader;
    private LyricData sourceData;
    private final Object lyrViewLock = new Object();
    private ArrayList<ILyricView> lyricViews = new ArrayList<>();
    private ILyricCallback lyricCallback = null;
    private final List<LyricDataProcessor> mLyricDataProcessorList = new ArrayList();

    public interface LyricDataProcessor {
        void process(LyricData lyricData, List<ILyricView> list);
    }

    private LyricManager() {
        initWorkLooper();
    }

    public static String getEscapeCharacter(String str) {
        try {
            return !switchEscapeCharacter ? str : str.replace(STR_REPLACE_TAG, STR_REPLACE_RESULT_TAG);
        } catch (Throwable th) {
            th.printStackTrace();
            return str;
        }
    }

    public static synchronized LyricManager getInstance() {
        return getPlayerInstance();
    }

    public static int getLyricVersion() {
        return 20210319;
    }

    public static Looper getLyricWorkLooper() {
        if (mWorkLooper == null) {
            initWorkLooper();
        }
        return mWorkLooper;
    }

    public static synchronized LyricManager getPlayerInstance() {
        if (manager == null) {
            manager = new LyricManager();
        }
        return manager;
    }

    private static void initWorkLooper() {
        if (workThread == null) {
            HandlerThread handlerThread = new HandlerThread("BaseLyricView");
            workThread = handlerThread;
            handlerThread.start();
            mWorkLooper = workThread.getLooper();
        }
    }

    public static synchronized LyricManager newInstance() {
        return new LyricManager();
    }

    private void processLyricData(LyricData lyricData) {
        if (Utils.isEmpty(this.mLyricDataProcessorList)) {
            return;
        }
        synchronized (this.mLyricDataProcessorList) {
            for (LyricDataProcessor lyricDataProcessor : this.mLyricDataProcessorList) {
                if (lyricDataProcessor != null) {
                    lyricDataProcessor.process(lyricData, this.lyricViews);
                }
            }
        }
    }

    public static void setSwitchEscapeCharacter(boolean z) {
        switchEscapeCharacter = z;
    }

    public void addLyricDataProcessor(LyricDataProcessor lyricDataProcessor) {
        synchronized (this.mLyricDataProcessorList) {
            if (!this.mLyricDataProcessorList.contains(lyricDataProcessor)) {
                this.mLyricDataProcessorList.add(lyricDataProcessor);
            }
        }
    }

    public void addLyricView(ILyricView iLyricView) {
        synchronized (this.lyrViewLock) {
            if (iLyricView != null) {
                if (!this.lyricViews.contains(iLyricView)) {
                    this.lyricViews.add(iLyricView);
                    ILyricCallback iLyricCallback = this.lyricCallback;
                    if (iLyricCallback != null) {
                        iLyricCallback.onAddLyricView(iLyricView);
                    }
                    if (this.sourceData != null) {
                        splitLyric(iLyricView);
                        if (!(iLyricView instanceof ISurLyricSync)) {
                            syncLyric(iLyricView, LyricSyncer.sCurrentTime);
                        }
                        iLyricView.refresh();
                    }
                }
            }
        }
    }

    public void clearAllViews() {
        synchronized (this.lyrViewLock) {
            this.lyricViews.clear();
        }
        synchronized (lyrDataLock) {
            LyricSyncer.sCurrentTime = 0L;
            this.sourceData = null;
        }
    }

    public LyricData getLyricData() {
        return this.sourceData;
    }

    public int getLyricViewSize() {
        int size;
        synchronized (this.lyrViewLock) {
            size = this.lyricViews.size();
        }
        return size;
    }

    public LyricInfo loadLyric(String str) {
        return loadLyric(str, true);
    }

    public void refreshAll() {
        synchronized (this.lyrViewLock) {
            int size = this.lyricViews.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.lyricViews.get(i2).refresh();
            }
        }
    }

    public void release() {
        synchronized (this.lyrViewLock) {
            int size = this.lyricViews.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.lyricViews.get(i2).release();
            }
        }
        synchronized (lyrDataLock) {
            LyricSyncer.sCurrentTime = 0L;
            this.sourceData = null;
        }
    }

    public void removeLyricView(ILyricView iLyricView) {
        synchronized (this.lyrViewLock) {
            if (iLyricView != null) {
                if (this.lyricViews.contains(iLyricView)) {
                    iLyricView.release();
                    this.lyricViews.remove(iLyricView);
                    ILyricCallback iLyricCallback = this.lyricCallback;
                    if (iLyricCallback != null) {
                        iLyricCallback.onRemoveLyricView(iLyricView);
                    }
                }
            }
        }
    }

    public void resetRowIndex() {
        synchronized (this.lyrViewLock) {
            int size = this.lyricViews.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.lyricViews.get(i2).resetRowIndex();
            }
        }
    }

    public void setLyricCallback(ILyricCallback iLyricCallback) {
        this.lyricCallback = iLyricCallback;
    }

    public void setLyricData(LyricData lyricData) {
        processLyricData(lyricData);
        synchronized (lyrDataLock) {
            this.sourceData = lyricData;
        }
        splitLyric();
    }

    public boolean splitLyric() {
        synchronized (this.lyrViewLock) {
            if (this.sourceData == null) {
                return false;
            }
            int size = this.lyricViews.size();
            for (int i2 = 0; i2 < size; i2++) {
                splitLyric(this.lyricViews.get(i2));
            }
            return true;
        }
    }

    public void syncLyric(long j) {
        synchronized (this.lyrViewLock) {
            int size = this.lyricViews.size();
            for (int i2 = 0; i2 < size; i2++) {
                syncLyric(this.lyricViews.get(i2), j);
            }
        }
    }

    public LyricInfo loadLyric(byte[] bArr, int i2, boolean z) {
        LyricInfo lyricInfo = new LyricInfo();
        if (bArr == null || bArr.length == 0) {
            lyricInfo.errorInfo = "lyric path is empty";
            lyricInfo.hasError = true;
            return lyricInfo;
        }
        release();
        if (i2 == 1) {
            this.lyricLoader = new KrcLoader();
        } else if (i2 == 2) {
            this.lyricLoader = new LrcLoader();
        } else {
            if (i2 != 3) {
                lyricInfo.errorInfo = "file is not krc or lyc or txt file";
                lyricInfo.hasError = true;
                return lyricInfo;
            }
            this.lyricLoader = new TxtLoader();
        }
        LyricInfo lyricInfoLoad = this.lyricLoader.load(bArr);
        if (lyricInfoLoad == null) {
            lyricInfo.errorInfo = "lyric file load error";
            lyricInfo.hasError = true;
            return lyricInfo;
        }
        processLyricData(lyricInfoLoad.lyricData);
        synchronized (lyrDataLock) {
            this.sourceData = lyricInfoLoad.lyricData;
        }
        if (z) {
            splitLyric();
        }
        return lyricInfoLoad;
    }

    public void syncLyric(ILyricView iLyricView, long j) {
        float textSize;
        float smallTextSize;
        if (iLyricView == null) {
            return;
        }
        if (iLyricView instanceof ISurLyricSync) {
            ((ISurLyricSync) iLyricView).syncLyric2(j);
            return;
        }
        LyricData lyricData = iLyricView.getLyricData();
        Paint pen = iLyricView.getPen();
        float rowHeight = iLyricView.getRowHeight();
        if (iLyricView instanceof FullScreenLyricView) {
            FullScreenLyricView fullScreenLyricView = (FullScreenLyricView) iLyricView;
            float bigTextSize = fullScreenLyricView.getBigTextSize();
            smallTextSize = fullScreenLyricView.getSmallTextSize();
            textSize = bigTextSize;
        } else {
            textSize = iLyricView.getTextSize();
            smallTextSize = textSize;
        }
        LyricSyncer.sync(lyricData, j, pen, rowHeight, textSize, smallTextSize);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void splitLyric(ILyricView iLyricView) {
        float contentWidth;
        synchronized (lyrDataLock) {
            if (iLyricView != 0) {
                LyricData lyricData = this.sourceData;
                if (lyricData != null) {
                    if (iLyricView instanceof ISurLyricSync) {
                        iLyricView.setLyricData(LyricData.from(lyricData));
                    } else if (iLyricView.isLyricSplited()) {
                        if ((iLyricView instanceof View) && iLyricView.getContentWidth() <= 0.0f) {
                            contentWidth = ((WindowManager) ((View) iLyricView).getContext().getSystemService("window")).getDefaultDisplay().getWidth() * 0.8f;
                        } else {
                            contentWidth = iLyricView.getContentWidth();
                        }
                        if (contentWidth > 0.0f && this.sourceData != null) {
                            try {
                                AsyncSplitor.splitDataAsync(iLyricView, contentWidth, iLyricView.getPen(), this.sourceData);
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                        }
                    } else {
                        iLyricView.setLyricData(LyricData.from(this.sourceData));
                    }
                }
            }
        }
    }

    public LyricInfo loadLyric(String str, boolean z) {
        LyricInfo lyricInfo = new LyricInfo();
        LyricDebug.d("filePath: " + str);
        if (TextUtils.isEmpty(str)) {
            lyricInfo.errorInfo = "lyric path is empty";
            lyricInfo.hasError = true;
            return lyricInfo;
        }
        release();
        String lowerCase = str.toLowerCase();
        if (lowerCase.endsWith(".krc")) {
            this.lyricLoader = new KrcLoader();
        } else if (lowerCase.endsWith(".lrc")) {
            this.lyricLoader = new LrcLoader();
        } else if (lowerCase.endsWith(".txt")) {
            this.lyricLoader = new TxtLoader();
        } else {
            lyricInfo.errorInfo = "file is not krc or lyc or txt file";
            lyricInfo.hasError = true;
            return lyricInfo;
        }
        LyricInfo lyricInfoLoad = this.lyricLoader.load(str);
        if (lyricInfoLoad == null) {
            lyricInfo.errorInfo = "lyric file load error";
            lyricInfo.hasError = true;
            return lyricInfo;
        }
        processLyricData(lyricInfoLoad.lyricData);
        synchronized (lyrDataLock) {
            this.sourceData = lyricInfoLoad.lyricData;
        }
        if (z) {
            splitLyric();
        }
        return lyricInfoLoad;
    }
}
