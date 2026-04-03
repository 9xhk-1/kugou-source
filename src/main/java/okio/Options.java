package okio;

import java.util.AbstractList;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes2.dex */
public final class Options extends AbstractList<ByteString> implements RandomAccess {
    public final ByteString[] byteStrings;

    private Options(ByteString[] byteStringArr) {
        this.byteStrings = byteStringArr;
    }

    public static Options of(ByteString... byteStringArr) {
        return new Options((ByteString[]) byteStringArr.clone());
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.byteStrings.length;
    }

    @Override // java.util.AbstractList, java.util.List
    public ByteString get(int i2) {
        return this.byteStrings[i2];
    }
}
