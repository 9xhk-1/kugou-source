package e.c.a.g.a.f.j.b;

/* JADX INFO: loaded from: classes.dex */
public class e {
    public static d a(n nVar) {
        d dVar = new d();
        dVar.c(nVar.getFeeKey());
        dVar.e(nVar.getMixId());
        dVar.i(nVar.getUpdateFeeStatusTime());
        dVar.updateData(nVar);
        return dVar;
    }

    public static String b(n nVar) {
        if (nVar == null) {
            return "";
        }
        return "name=" + nVar.getName() + ",feeKey=" + nVar.getFeeKey() + ",mixid=" + nVar.getMixId() + ",charge=" + nVar.getCharge() + ",feetype=" + nVar.getMusicFeeType() + ",failProcess=" + nVar.getFailProcess() + ",payType=" + nVar.getPayType() + ",musicpkgtag=" + nVar.getMusicTransParamEnenty() + ",oldCpy=" + nVar.getOldCpy() + ",feeUpdateFalg=" + nVar.getUpdataFlag();
    }
}
