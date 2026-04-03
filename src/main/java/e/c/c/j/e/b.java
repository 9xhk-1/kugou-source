package e.c.c.j.e;

import android.os.Build;
import com.kugou.framework.bilib.statistics.cscc.DataWrapper;
import e.c.c.o.f;
import e.c.c.o.g;
import e.c.c.o.m;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class b {
    public static String a(int i2) {
        StringBuilder sb = new StringBuilder();
        String strG = e.c.c.l.e.a.f().g();
        String str = e.c.c.b.b;
        boolean z = e.c.c.b.f1246f;
        int iX = m.x(f.a());
        String str2 = e.c.c.b.c;
        String strT = m.t();
        String str3 = Build.MODEL;
        String strJ = m.j(f.a());
        String strL = m.l(f.a());
        String str4 = e.c.c.b.f1247g;
        sb.append(4);
        sb.append(DataWrapper.MARK_SEPERATE);
        sb.append(i2);
        sb.append(DataWrapper.MARK_SEPERATE);
        sb.append(strG);
        sb.append(DataWrapper.MARK_SEPERATE);
        sb.append(z ? 1 : 0);
        sb.append(DataWrapper.MARK_SEPERATE);
        sb.append(str);
        sb.append(DataWrapper.MARK_SEPERATE);
        sb.append(iX);
        sb.append(DataWrapper.MARK_SEPERATE);
        sb.append(str2);
        sb.append(DataWrapper.MARK_SEPERATE);
        sb.append(strT);
        sb.append(DataWrapper.MARK_SEPERATE);
        sb.append(str3);
        sb.append(DataWrapper.MARK_SEPERATE);
        sb.append(strJ);
        sb.append(DataWrapper.MARK_SEPERATE);
        sb.append(strL);
        sb.append(DataWrapper.MARK_SEPERATE);
        sb.append(str4);
        sb.append(DataWrapper.MARK_SEPERATE);
        sb.append("000000000000000000000000000000000000");
        sb.append("\r\n");
        g.a("bisdk", sb.toString());
        return sb.toString();
    }

    public static byte[] b(List<a> list) {
        byte[] bytes = null;
        if (list == null) {
            return null;
        }
        try {
            bytes = a(list.size()).getBytes("UTF-8");
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byteArrayOutputStream.write(bytes);
            for (int i2 = 0; i2 < list.size(); i2++) {
                byte[] bArrB = list.get(i2).b();
                if (bArrB != null) {
                    byteArrayOutputStream.write(bArrB);
                }
            }
        } catch (IOException e3) {
            e3.printStackTrace();
        }
        return byteArrayOutputStream.toByteArray();
    }
}
