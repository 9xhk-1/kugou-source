package e.g.a.b.a.b.a;

import android.os.Bundle;
import androidx.core.app.NotificationCompat;
import e.g.a.b.a.b.b.a.d;
import f.i;
import f.s;
import f.z.d.j;
import f.z.d.k;

/* JADX INFO: loaded from: classes2.dex */
public final class a {
    public static final a a = new a();

    /* JADX INFO: renamed from: e.g.a.b.a.b.a.a$a, reason: collision with other inner class name */
    public static final class C0258a extends k implements f.z.c.a<s> {
        public final /* synthetic */ d a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0258a(d dVar) {
            super(0);
            this.a = dVar;
        }

        @Override // f.z.c.a
        public s invoke() {
            d dVar = this.a;
            j.e(dVar, "updateLayoutCommand");
            e.g.b.b.a.a("Update.SwitchLayoutCommandHandler", "[DEBUG_" + dVar.f() + "] handle command is: " + dVar);
            d.a.a.a$b.a.b bVar = d.a.a.a$b.a.b.a;
            bVar.h(dVar.f(), null);
            bVar.e(dVar.f(), dVar.d());
            bVar.k(dVar.f(), dVar.e());
            dVar.a(System.currentTimeMillis());
            return s.a;
        }
    }

    public static final class b extends k implements f.z.c.a<s> {
        public final /* synthetic */ e.g.a.b.a.b.b.a.c a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(e.g.a.b.a.b.b.a.c cVar) {
            super(0);
            this.a = cVar;
        }

        @Override // f.z.c.a
        public s invoke() throws Throwable {
            e.g.a.b.a.b.b.a.c cVar = this.a;
            j.e(cVar, "toastCommand");
            String strE = cVar.e();
            String strD = cVar.d();
            e.g.b.b.a.a("ToastCommandHandler", "[DEBUG_" + strE + "] handle command is: " + strD);
            Bundle bundle = new Bundle();
            bundle.putString("widget_code", strE);
            bundle.putString("toast", strD);
            d.a.a.a$b.c.b.c.c cVar2 = new d.a.a.a$b.c.b.c.c(strE, bundle);
            j.l(Thread.currentThread().getName(), "ToastCommandHandler");
            new d.a.a.a$b.c.a.c().a(cVar2);
            return s.a;
        }
    }

    public static final class c extends k implements f.z.c.a<s> {
        public final /* synthetic */ e.g.a.b.a.b.b.a.b a;
        public final /* synthetic */ boolean b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(e.g.a.b.a.b.b.a.b bVar, boolean z) {
            super(0);
            this.a = bVar;
            this.b = z;
        }

        @Override // f.z.c.a
        public s invoke() throws Throwable {
            e.g.a.b.a.b.b.a.b bVar = this.a;
            boolean z = this.b;
            j.e(bVar, "cardUpdateCommand");
            String strE = bVar.e();
            e.g.b.b bVar2 = e.g.b.b.a;
            bVar2.a("Update.CardUpdateCommandHandler", "[DEBUG_" + strE + "] handle command: " + bVar);
            d.a.a.a$b.a.b bVar3 = d.a.a.a$b.a.b.a;
            i<byte[], Boolean> iVarG = bVar3.g(strE);
            boolean z2 = !iVarG.d().booleanValue() && z;
            if (z2) {
                byte[] bytes = "".getBytes(f.e0.c.a);
                j.d(bytes, "(this as java.lang.String).getBytes(charset)");
                iVarG = new i<>(bytes, Boolean.FALSE);
            }
            byte[] bArrC = iVarG.c();
            if (bArrC == null) {
                bVar2.b("Update.CardUpdateCommandHandler", "command handle interrupt");
            } else {
                Bundle bundleD = bVar.d().d(strE, bArrC, iVarG.d().booleanValue(), z2);
                if (bundleD == null) {
                    bundleD = null;
                } else {
                    bundleD.putString("layoutName", bVar3.b(strE));
                    bundleD.putBoolean("localUpdate", z2);
                    bVar.a(System.currentTimeMillis());
                    d.a.a.a$b.c.b.c.c cVar = new d.a.a.a$b.c.b.c.c(strE, bundleD);
                    j.l(Thread.currentThread().getName(), "Update.CardUpdateCommandHandler");
                    new d.a.a.a$b.c.a.c().a(cVar);
                }
                if (bundleD == null) {
                    bVar2.a("Update.CardUpdateCommandHandler", "command is not be consumed");
                }
            }
            return s.a;
        }
    }

    public final d a(String str, String str2, byte[] bArr) {
        d dVar = new d(str, str2, bArr);
        dVar.c(Thread.currentThread().getName());
        d.a.a.a$b.c.c.b.a.d(str, new C0258a(dVar));
        e.g.b.b.a.a("CardWidgetAction", "switchLayoutCommand widgetCode:" + str + ", layoutName:" + str2);
        return dVar;
    }

    public final e.g.a.b.a.b.b.a.c b(String str, String str2) {
        j.e(str, NotificationCompat.CATEGORY_MESSAGE);
        j.e(str2, "widgetCode");
        e.g.a.b.a.b.b.a.c cVar = new e.g.a.b.a.b.b.a.c(str2, str);
        cVar.c(Thread.currentThread().getName());
        d.a.a.a$b.c.c.b.a.d(str2, new b(cVar));
        e.g.b.b.a.a("CardWidgetAction", "toast widgetCode is " + str2 + ", msg is " + str);
        return cVar;
    }

    public final e.g.a.b.a.b.b.a.b c(e.g.a.b.a.b.c.a aVar, String str, boolean z) {
        j.e(aVar, "baseDataPack");
        j.e(str, "widgetCode");
        e.g.a.b.a.b.b.a.b bVar = new e.g.a.b.a.b.b.a.b(str, aVar);
        bVar.c(Thread.currentThread().getName());
        d.a.a.a$b.c.c.b.a.d(str, new c(bVar, z));
        e.g.b.b.a.a("CardWidgetAction", "postUpdateCommand widgetCode: " + str + ", data is " + aVar);
        return bVar;
    }

    public final d d(String str, String str2) {
        j.e(str, "widgetCode");
        j.e(str2, "layoutName");
        return a(str, str2, null);
    }
}
