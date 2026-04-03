package androidx.core.util;

import android.util.LruCache;
import f.s;
import f.z.c.l;
import f.z.c.p;
import f.z.c.r;
import f.z.d.j;
import f.z.d.k;

/* JADX INFO: loaded from: classes.dex */
public final class LruCacheKt {

    /* JADX INFO: Add missing generic type declarations: [V, K] */
    /* JADX INFO: renamed from: androidx.core.util.LruCacheKt$lruCache$1, reason: invalid class name */
    public static final class AnonymousClass1<K, V> extends k implements p<K, V, Integer> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(2);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final int invoke2(K k, V v) {
            j.f(k, "<anonymous parameter 0>");
            j.f(v, "<anonymous parameter 1>");
            return 1;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // f.z.c.p
        public /* bridge */ /* synthetic */ Integer invoke(Object obj, Object obj2) {
            return Integer.valueOf(invoke2(obj, obj2));
        }
    }

    /* JADX INFO: Add missing generic type declarations: [V, K] */
    /* JADX INFO: renamed from: androidx.core.util.LruCacheKt$lruCache$2, reason: invalid class name */
    public static final class AnonymousClass2<K, V> extends k implements l<K, V> {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        public AnonymousClass2() {
            super(1);
        }

        @Override // f.z.c.l
        public final V invoke(K k) {
            j.f(k, "it");
            return null;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [V, K] */
    /* JADX INFO: renamed from: androidx.core.util.LruCacheKt$lruCache$3, reason: invalid class name */
    public static final class AnonymousClass3<K, V> extends k implements r<Boolean, K, V, V, s> {
        public static final AnonymousClass3 INSTANCE = new AnonymousClass3();

        public AnonymousClass3() {
            super(4);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // f.z.c.r
        public /* bridge */ /* synthetic */ s invoke(Boolean bool, Object obj, Object obj2, Object obj3) {
            invoke(bool.booleanValue(), obj, obj2, obj3);
            return s.a;
        }

        public final void invoke(boolean z, K k, V v, V v2) {
            j.f(k, "<anonymous parameter 1>");
            j.f(v, "<anonymous parameter 2>");
        }
    }

    /* JADX INFO: Add missing generic type declarations: [V, K] */
    /* JADX INFO: renamed from: androidx.core.util.LruCacheKt$lruCache$4, reason: invalid class name */
    public static final class AnonymousClass4<K, V> extends LruCache<K, V> {
        public final /* synthetic */ l $create;
        public final /* synthetic */ int $maxSize;
        public final /* synthetic */ r $onEntryRemoved;
        public final /* synthetic */ p $sizeOf;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass4(p pVar, l lVar, r rVar, int i2, int i3) {
            super(i3);
            this.$sizeOf = pVar;
            this.$create = lVar;
            this.$onEntryRemoved = rVar;
            this.$maxSize = i2;
        }

        @Override // android.util.LruCache
        public V create(K k) {
            j.f(k, "key");
            return (V) this.$create.invoke(k);
        }

        @Override // android.util.LruCache
        public void entryRemoved(boolean z, K k, V v, V v2) {
            j.f(k, "key");
            j.f(v, "oldValue");
            this.$onEntryRemoved.invoke(Boolean.valueOf(z), k, v, v2);
        }

        @Override // android.util.LruCache
        public int sizeOf(K k, V v) {
            j.f(k, "key");
            j.f(v, "value");
            return ((Number) this.$sizeOf.invoke(k, v)).intValue();
        }
    }

    public static final <K, V> LruCache<K, V> lruCache(int i2, p<? super K, ? super V, Integer> pVar, l<? super K, ? extends V> lVar, r<? super Boolean, ? super K, ? super V, ? super V, s> rVar) {
        j.f(pVar, "sizeOf");
        j.f(lVar, "create");
        j.f(rVar, "onEntryRemoved");
        return new AnonymousClass4(pVar, lVar, rVar, i2, i2);
    }

    public static /* synthetic */ LruCache lruCache$default(int i2, p pVar, l lVar, r rVar, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            pVar = AnonymousClass1.INSTANCE;
        }
        p pVar2 = pVar;
        if ((i3 & 4) != 0) {
            lVar = AnonymousClass2.INSTANCE;
        }
        l lVar2 = lVar;
        if ((i3 & 8) != 0) {
            rVar = AnonymousClass3.INSTANCE;
        }
        r rVar2 = rVar;
        j.f(pVar2, "sizeOf");
        j.f(lVar2, "create");
        j.f(rVar2, "onEntryRemoved");
        return new AnonymousClass4(pVar2, lVar2, rVar2, i2, i2);
    }
}
