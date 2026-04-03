package e.c.e.b.f;

import android.support.annotation.NonNull;

/* JADX INFO: loaded from: classes2.dex */
public interface c {

    public interface a {
        void onIndexChange(int i2, int i3);
    }

    int getCurrentIndex();

    int getNextIndex();

    int getOnCompleteNextIndex();

    int getPreviousIndex();

    int next();

    int onCompleteNext();

    int previous();

    void registerObserver(a aVar);

    void setCurrentIndex(int i2);

    void unregisterObserver(a aVar);

    void updateQueueList(@NonNull d<?> dVar);
}
