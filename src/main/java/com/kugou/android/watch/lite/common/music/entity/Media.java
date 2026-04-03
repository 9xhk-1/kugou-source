package com.kugou.android.watch.lite.common.music.entity;

import android.os.Parcelable;
import com.kugou.android.watch.lite.base.player.Initiator;

/* JADX INFO: loaded from: classes.dex */
public abstract class Media implements Parcelable {
    public final Initiator initiator = Initiator.espCreate(1024);

    public Initiator getInitiator() {
        return this.initiator;
    }
}
