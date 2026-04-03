package e.c.e.b.f;

import android.support.annotation.NonNull;

/* JADX INFO: loaded from: classes2.dex */
public class e extends a {
    public e(@NonNull d<?> dVar) {
        super(dVar);
    }

    @Override // e.c.e.b.f.c
    public int getNextIndex() {
        int currentIndex = getCurrentIndex() + 1;
        if (currentIndex >= a().getSize()) {
            return 0;
        }
        return currentIndex;
    }

    @Override // e.c.e.b.f.c
    public int getPreviousIndex() {
        int currentIndex = getCurrentIndex() - 1;
        return currentIndex < 0 ? a().getSize() - 1 : currentIndex;
    }
}
