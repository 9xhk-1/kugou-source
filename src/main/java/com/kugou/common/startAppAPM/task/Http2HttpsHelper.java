package com.kugou.common.startAppAPM.task;

import e.c.a.g.a.f.e.b;
import e.c.a.g.a.f.e.c;

/* JADX INFO: loaded from: classes2.dex */
public final class Http2HttpsHelper {
    public static final Http2HttpsHelper INSTANCE = new Http2HttpsHelper();
    private static final String audio_climax_url;
    private static final String container_kmrcdn_url;

    static {
        c.b bVar = c.a;
        audio_climax_url = bVar.a().b(b.T1, "https://gateway.kugou.com/kmr.service/v1/audio_climax/audio");
        container_kmrcdn_url = bVar.a().b(b.V0, "https://gateway.kugou.com/kmrcdn.service/container/v1/image");
    }

    private Http2HttpsHelper() {
    }

    public final String getAudio_climax_url() {
        return audio_climax_url;
    }

    public final String getContainer_kmrcdn_url() {
        return container_kmrcdn_url;
    }
}
