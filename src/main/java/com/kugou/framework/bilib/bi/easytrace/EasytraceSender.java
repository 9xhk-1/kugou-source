package com.kugou.framework.bilib.bi.easytrace;

import com.kugou.framework.bilib.LibLog;
import com.kugou.framework.bilib.statis.cscc.CsccManagerUtil;
import com.kugou.framework.bilib.statistics.cscc.entity.CsccConfigId;
import com.kugou.framework.bilib.statistics.cscc.entity.CsccEntity;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public class EasytraceSender {
    private static final String LOGTAG = "EasytraceSender";

    public static boolean send(String str) {
        try {
            byte[] bytes = str.getBytes("UTF-8");
            if (LibLog.DEBUG) {
                LibLog.d(LOGTAG, "zlib before : " + bytes.length);
            }
            if (bytes.length == 0) {
                return true;
            }
            return CsccManagerUtil.sendWithCscc(new CsccEntity(LibLog.DEBUG ? CsccConfigId.SEND_TO_TEST : 0, null, "POST", "", bytes, false, true), true);
        } catch (Error e2) {
            e2.printStackTrace();
            return false;
        } catch (Exception e3) {
            e3.printStackTrace();
            if (LibLog.DEBUG) {
                LibLog.d(LOGTAG, "exception throwed");
            }
            return false;
        }
    }

    public static boolean send(HashMap<String, Object> map, int i2) {
        try {
            if (LibLog.DEBUG) {
                i2 = CsccConfigId.SEND_TO_TEST;
            }
            return CsccManagerUtil.sendWithCscc(new CsccEntity(i2, null, map, false), true);
        } catch (Error e2) {
            e2.printStackTrace();
            return false;
        } catch (Exception e3) {
            e3.printStackTrace();
            if (LibLog.DEBUG) {
                LibLog.d(LOGTAG, "exception throwed");
            }
            return false;
        }
    }
}
