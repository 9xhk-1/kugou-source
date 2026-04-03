package e.c.a.g.a.d.x.s.c;

import com.kugou.common.network.RequestDelay;

/* JADX INFO: loaded from: classes.dex */
public interface c {
    void onAvatarDownFailed(int i2, RequestDelay requestDelay);

    void onAvatarDownSuccess(int i2, RequestDelay requestDelay);

    void onLyricDownFailed();

    void onLyricDownSuccess();
}
