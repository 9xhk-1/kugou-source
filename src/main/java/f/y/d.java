package f.y;

import f.z.d.j;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes2.dex */
public final class d implements f.d0.b<String> {
    public final BufferedReader a;

    /* JADX WARN: Unexpected interfaces in signature: [java.lang.Object] */
    public static final class a implements Iterator<String> {
        public String a;
        public boolean b;

        public a() {
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public String next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            String str = this.a;
            this.a = null;
            j.c(str);
            return str;
        }

        @Override // java.util.Iterator
        public boolean hasNext() throws IOException {
            if (this.a == null && !this.b) {
                String line = d.this.a.readLine();
                this.a = line;
                if (line == null) {
                    this.b = true;
                }
            }
            return this.a != null;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public d(BufferedReader bufferedReader) {
        j.e(bufferedReader, "reader");
        this.a = bufferedReader;
    }

    @Override // f.d0.b
    public Iterator<String> iterator() {
        return new a();
    }
}
