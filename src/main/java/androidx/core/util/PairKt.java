package androidx.core.util;

import android.annotation.SuppressLint;
import f.i;
import f.z.d.j;

/* JADX INFO: loaded from: classes.dex */
public final class PairKt {
    @SuppressLint({"UnknownNullness"})
    public static final <F, S> F component1(android.util.Pair<F, S> pair) {
        j.f(pair, "$this$component1");
        return (F) pair.first;
    }

    @SuppressLint({"UnknownNullness"})
    public static final <F, S> S component2(android.util.Pair<F, S> pair) {
        j.f(pair, "$this$component2");
        return (S) pair.second;
    }

    public static final <F, S> android.util.Pair<F, S> toAndroidPair(i<? extends F, ? extends S> iVar) {
        j.f(iVar, "$this$toAndroidPair");
        return new android.util.Pair<>(iVar.c(), iVar.d());
    }

    public static final <F, S> i<F, S> toKotlinPair(android.util.Pair<F, S> pair) {
        j.f(pair, "$this$toKotlinPair");
        return new i<>(pair.first, pair.second);
    }
}
