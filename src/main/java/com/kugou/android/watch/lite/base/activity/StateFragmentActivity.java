package com.kugou.android.watch.lite.base.activity;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import e.c.a.g.a.f.a;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public class StateFragmentActivity extends AppCompatActivity {
    public final boolean a() {
        try {
            Field declaredField = Activity.class.getDeclaredField("mActivityInfo");
            declaredField.setAccessible(true);
            ((ActivityInfo) declaredField.get(this)).screenOrientation = -1;
            declaredField.setAccessible(false);
            return true;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public final boolean b() {
        Exception e2;
        boolean zBooleanValue;
        try {
            TypedArray typedArrayObtainStyledAttributes = obtainStyledAttributes((int[]) Class.forName("com.android.internal.R$styleable").getField("Window").get(null));
            Method method = ActivityInfo.class.getMethod("isTranslucentOrFloating", TypedArray.class);
            method.setAccessible(true);
            zBooleanValue = ((Boolean) method.invoke(null, typedArrayObtainStyledAttributes)).booleanValue();
            try {
                method.setAccessible(false);
            } catch (Exception e3) {
                e2 = e3;
                e2.printStackTrace();
            }
        } catch (Exception e4) {
            e2 = e4;
            zBooleanValue = false;
        }
        return zBooleanValue;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        a.a(this);
        if (Build.VERSION.SDK_INT == 26 && b()) {
            a();
        }
        super.onCreate(bundle);
        e.c.a.g.a.d.j.a.e().a(this);
        Log.d("mhs_8", "acitivity name = " + getLocalClassName());
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        e.c.a.g.a.d.j.a.e().i(this);
    }
}
