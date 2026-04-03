package retrofit2;

import okhttp3.SchemeCheckCallBack;

/* JADX INFO: loaded from: classes2.dex */
public class SchemeCallBackModel {
    public static volatile SchemeCallBackModel INSTANCE;
    public SchemeCheckCallBack schemeCheckCallBack;

    public static SchemeCallBackModel init() {
        if (INSTANCE == null) {
            synchronized (SchemeCallBackModel.class) {
                if (INSTANCE == null) {
                    INSTANCE = new SchemeCallBackModel();
                }
            }
        }
        return INSTANCE;
    }

    public SchemeCheckCallBack getSchemeCheckCallBack() {
        return this.schemeCheckCallBack;
    }

    public void setSchemeCheckCallBack(SchemeCheckCallBack schemeCheckCallBack) {
        this.schemeCheckCallBack = schemeCheckCallBack;
    }
}
