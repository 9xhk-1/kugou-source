package com.kugou.framework.bilib.statis.cscc;

import com.kugou.framework.bilib.LibLog;
import com.kugou.framework.bilib.statistics.cscc.CsccManager;
import com.kugou.framework.bilib.statistics.cscc.entity.CsccEntity;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class CsccManagerUtil {
    public static boolean isPrepared() {
        try {
            return CsccManager.getInstance() != null;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public static boolean sendWithCscc(CsccEntity csccEntity, boolean z) {
        try {
            return CsccManager.getInstance().sendWithCscc(csccEntity, z);
        } catch (Exception e2) {
            if (!LibLog.DEBUG) {
                return false;
            }
            e2.printStackTrace();
            return false;
        }
    }

    public static boolean sendWithCsccsWithoutQueue(List<CsccEntity> list) {
        try {
            return CsccManager.getInstance().sendWithCsccsWithoutQueue(list);
        } catch (Exception e2) {
            if (!LibLog.DEBUG) {
                return false;
            }
            e2.printStackTrace();
            return false;
        }
    }
}
