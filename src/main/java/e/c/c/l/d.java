package e.c.c.l;

import com.google.protobuf.ByteString;
import com.kugou.datacollect.bi.senter.CsccEntity;
import e.c.c.k.e;
import e.c.c.l.g.a;
import e.c.c.o.g;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class d implements e<b> {
    public a.c.b a = a.c.j();

    public final ArrayList<CsccEntity> a(List<e.c.c.k.f.b> list) {
        ArrayList<CsccEntity> arrayList = new ArrayList<>();
        a.c cVarB = b(list);
        if (cVarB != null) {
            arrayList.add(new CsccEntity(e.c.c.b.a, cVarB.toByteArray(), 1));
        }
        return arrayList;
    }

    public a.c b(List<e.c.c.k.f.b> list) {
        StringBuilder sb = new StringBuilder();
        this.a.k().size();
        for (e.c.c.k.f.b bVar : list) {
            if (bVar.a().equals("10033")) {
                String strB = bVar.b();
                g.a("bisdk", "binopointzlib content : " + strB);
                sb.append(strB);
                sb.append('\r');
                sb.append('\n');
            }
        }
        try {
            byte[] bArrA = e.c.c.o.c.a(sb.toString().getBytes("UTF-8"), -1);
            a.b.C0206b c0206bE = a.b.e();
            c0206bE.m(ByteString.copyFrom(bArrA));
            a.b bVarBuild = c0206bE.build();
            this.a.e();
            this.a.a(bVarBuild);
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
        }
        return this.a.build();
    }

    @Override // e.c.c.k.e
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public b toSenderData(List<e.c.c.k.f.b> list) {
        return new b(list, a(list));
    }
}
