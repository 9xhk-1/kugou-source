package androidx.core.content;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import f.s;
import f.z.c.l;
import f.z.d.j;

/* JADX INFO: loaded from: classes.dex */
public final class SharedPreferencesKt {
    @SuppressLint({"ApplySharedPref"})
    public static final void edit(SharedPreferences sharedPreferences, boolean z, l<? super SharedPreferences.Editor, s> lVar) {
        j.f(sharedPreferences, "$this$edit");
        j.f(lVar, "action");
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        j.b(editorEdit, "editor");
        lVar.invoke(editorEdit);
        if (z) {
            editorEdit.commit();
        } else {
            editorEdit.apply();
        }
    }

    public static /* synthetic */ void edit$default(SharedPreferences sharedPreferences, boolean z, l lVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = false;
        }
        j.f(sharedPreferences, "$this$edit");
        j.f(lVar, "action");
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        j.b(editorEdit, "editor");
        lVar.invoke(editorEdit);
        if (z) {
            editorEdit.commit();
        } else {
            editorEdit.apply();
        }
    }
}
