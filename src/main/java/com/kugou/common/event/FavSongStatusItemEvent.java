package com.kugou.common.event;

import com.kugou.android.watch.lite.common.music.entity.KGMusic;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class FavSongStatusItemEvent {
    public String extJson;
    public List<? extends KGMusic> mMusics;
    public int state;

    public FavSongStatusItemEvent(int i2, List<? extends KGMusic> list) {
        this.state = 0;
        this.state = i2;
        this.mMusics = list;
    }

    public String toString() {
        return "FavSongStatusItemEvent{state=" + this.state + ", mMusics=" + this.mMusics + ", extJson='" + this.extJson + "'}";
    }

    public FavSongStatusItemEvent(int i2, List<? extends KGMusic> list, String str) {
        this.state = 0;
        this.state = i2;
        this.mMusics = list;
        this.extJson = str;
    }
}
