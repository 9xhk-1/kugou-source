package d.a.a.a$b.d;

import android.os.Bundle;
import f.s;
import f.z.c.l;
import f.z.d.k;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class d extends k implements f.z.c.a<s> {
    public final /* synthetic */ List<String> a;
    public final /* synthetic */ l<d.a.a.a$b.c.b.c.b, s> b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public d(List<String> list, l<? super d.a.a.a$b.c.b.c.b, s> lVar) {
        super(0);
        this.a = list;
        this.b = lVar;
    }

    @Override // f.z.c.a
    public s invoke() {
        e.g.b.b.a.a("Facade.CardClientFacade", f.z.d.j.l("observes ids size is: ", Integer.valueOf(this.a.size())));
        ArrayList<String> arrayList = new ArrayList<>();
        for (String str : this.a) {
            f.z.d.j.e(str, "<this>");
            String strSubstring = null;
            if (!(str.length() > 5)) {
                str = null;
            }
            if (str != null) {
                strSubstring = str.substring(5);
                f.z.d.j.d(strSubstring, "(this as java.lang.String).substring(startIndex)");
            }
            if (strSubstring != null) {
                arrayList.add(strSubstring);
            }
        }
        d.a.a.a$b.c.b.c.b bVar = new d.a.a.a$b.c.b.c.b("", "observe");
        new Bundle().putStringArrayList("observe_card_list", arrayList);
        s sVar = s.a;
        f.z.d.j.l(Thread.currentThread().getName(), "Facade.CardClientFacade");
        System.currentTimeMillis();
        this.b.invoke(bVar);
        return sVar;
    }
}
