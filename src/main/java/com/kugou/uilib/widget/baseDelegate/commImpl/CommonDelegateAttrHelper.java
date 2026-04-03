package com.kugou.uilib.widget.baseDelegate.commImpl;

import android.util.Log;
import android.view.View;
import androidx.annotation.Nullable;
import com.kugou.uilib.widget.baseDelegate.IAttrParse;
import com.kugou.uilib.widget.baseDelegate.IViewDelegate;
import com.kugou.uilib.widget.baseDelegate.KGUIDelegateManager;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public class CommonDelegateAttrHelper {
    @Nullable
    public static <E extends IViewDelegate> E getCommonDelegate(View view, KGUIDelegateManager kGUIDelegateManager, Class<E> cls) {
        E e2 = null;
        if (kGUIDelegateManager == null) {
            return null;
        }
        Iterator it = kGUIDelegateManager.getDelegates().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (next.getClass() == cls) {
                e2 = (E) next;
                break;
            }
        }
        if (e2 != null) {
            return e2;
        }
        try {
            E eNewInstance = cls.getConstructor(new Class[0]).newInstance(new Object[0]);
            eNewInstance.init(view);
            try {
                kGUIDelegateManager.add(eNewInstance);
                return eNewInstance;
            } catch (Exception e3) {
                e = e3;
                e2 = eNewInstance;
                e.printStackTrace();
                Log.e("DelegateHelper", "错误的调用KGUI delegate \nView:" + view.toString() + "\n request Class:" + cls.toString());
                return e2;
            }
        } catch (Exception e4) {
            e = e4;
        }
    }

    public static <E extends IViewDelegate> E getDelegate(IAttrParse iAttrParse, Class<E> cls) {
        try {
            return (E) iAttrParse.getCommonDelegate(cls);
        } catch (Exception e2) {
            e2.printStackTrace();
            Log.e("DelegateHelper", "该View不属于KGUI，或未实现getCommonDelegate方法");
            return null;
        }
    }
}
