package com.kugou.common.utils;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import androidx.core.content.ContextCompat;
import com.kugou.common.permission.Permission;
import e.c.a.g.a.d.h.a;
import e.c.a.g.a.f.e.b;
import e.c.a.g.a.f.e.c;
import e.c.a.g.a.s.l1;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public class PermissionsUtil {
    private static PermissionsUtil permissionsUtil;
    public static a sdialog;
    public boolean canShowDilaog;

    public interface OnPermissionDilaogListener {
        void onNo();

        void onYes();
    }

    public PermissionsUtil() {
        this.canShowDilaog = c.c().getConfigAsInt(b.K0, 1) == 1;
    }

    public static PermissionsUtil getInstance() {
        if (permissionsUtil == null) {
            synchronized (PermissionsUtil.class) {
                if (permissionsUtil == null) {
                    permissionsUtil = new PermissionsUtil();
                }
            }
        }
        return permissionsUtil;
    }

    private static boolean isShowDialog() {
        a aVar = sdialog;
        return aVar != null && aVar.isShowing();
    }

    private static boolean lacksPermission(Context context, ArrayList<String> arrayList) {
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            if (ContextCompat.checkSelfPermission(context, it.next()) == -1) {
                return true;
            }
        }
        return false;
    }

    public void showPermissionRequestDialog(Activity activity, String str, final OnPermissionDilaogListener onPermissionDilaogListener, @NonNull String str2) {
        if (isShowDialog()) {
            h.a.a.b.a("mhs_watch", "弹窗正在展示");
            return;
        }
        if (Permission.READ_PHONE_STATE.equals(str2)) {
            if (l1.H()) {
                return;
            }
        } else if (ContextCompat.checkSelfPermission(activity, str2) == 0) {
            if (onPermissionDilaogListener != null) {
                onPermissionDilaogListener.onYes();
                return;
            }
            return;
        }
        a aVar = new a(activity);
        sdialog = aVar;
        aVar.setCancelable(false);
        aVar.setCanceledOnTouchOutside(false);
        aVar.e(str);
        aVar.a("拒绝");
        aVar.b("允许");
        aVar.d(new View.OnClickListener() { // from class: com.kugou.common.utils.PermissionsUtil.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                OnPermissionDilaogListener onPermissionDilaogListener2 = onPermissionDilaogListener;
                if (onPermissionDilaogListener2 != null) {
                    onPermissionDilaogListener2.onYes();
                }
                PermissionsUtil.sdialog = null;
            }
        });
        aVar.c(new View.OnClickListener() { // from class: com.kugou.common.utils.PermissionsUtil.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                OnPermissionDilaogListener onPermissionDilaogListener2 = onPermissionDilaogListener;
                if (onPermissionDilaogListener2 != null) {
                    onPermissionDilaogListener2.onNo();
                }
                PermissionsUtil.sdialog = null;
            }
        });
        aVar.show();
    }

    public void showPermissionRequestDialogCommon(Activity activity, String str, final OnPermissionDilaogListener onPermissionDilaogListener, @NonNull ArrayList<String> arrayList) {
        if (!this.canShowDilaog || activity == null) {
            if (onPermissionDilaogListener != null) {
                onPermissionDilaogListener.onYes();
                return;
            }
            return;
        }
        if (isShowDialog()) {
            h.a.a.b.a("mhs_watch", "弹窗正在展示");
            return;
        }
        if (!lacksPermission(activity, arrayList)) {
            if (onPermissionDilaogListener != null) {
                onPermissionDilaogListener.onYes();
                return;
            }
            return;
        }
        a aVar = new a(activity);
        sdialog = aVar;
        aVar.setCancelable(false);
        aVar.setCanceledOnTouchOutside(false);
        aVar.e(str);
        aVar.a("拒绝");
        aVar.b("允许");
        aVar.d(new View.OnClickListener() { // from class: com.kugou.common.utils.PermissionsUtil.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                OnPermissionDilaogListener onPermissionDilaogListener2 = onPermissionDilaogListener;
                if (onPermissionDilaogListener2 != null) {
                    onPermissionDilaogListener2.onYes();
                }
                PermissionsUtil.sdialog = null;
            }
        });
        aVar.c(new View.OnClickListener() { // from class: com.kugou.common.utils.PermissionsUtil.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                OnPermissionDilaogListener onPermissionDilaogListener2 = onPermissionDilaogListener;
                if (onPermissionDilaogListener2 != null) {
                    onPermissionDilaogListener2.onNo();
                }
                PermissionsUtil.sdialog = null;
            }
        });
        aVar.show();
    }
}
