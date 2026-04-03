package e.c.c.m;

import com.kugou.datacollect.crash.bean.CrashBean;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class d implements e.c.c.k.e<List<CrashBean>> {
    @Override // e.c.c.k.e
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public List<CrashBean> toSenderData(List<e.c.c.k.f.b> list) {
        ArrayList arrayList = new ArrayList();
        for (e.c.c.k.f.b bVar : list) {
            try {
                CrashBean crashBean = new CrashBean(new JSONObject(bVar.b()));
                crashBean.setCacheBeanId(bVar.c());
                arrayList.add(crashBean);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        return arrayList;
    }
}
