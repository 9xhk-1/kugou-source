package com.kugou.android.watch.lite.recommend.entity;

import com.kugou.android.watch.lite.common.INoGuard;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class SheetMusicListResp implements INoGuard {
    public DataBean data;
    public int error_code;
    public int status;

    public static class DataBean implements INoGuard {
        public List<SheetMusicBean> song_data_list;
        public int total;
    }
}
