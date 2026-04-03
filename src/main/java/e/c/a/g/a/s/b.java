package e.c.a.g.a.s;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.kugou.android.watch.lite.common.music.entity.KGSong;
import com.kugou.android.watch.lite.common.music.entity.SingerInfo;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class b {
    @NonNull
    public static KGSong a(JSONObject jSONObject, boolean z, int i2, String str, boolean z2, int i3) throws JSONException {
        JSONObject jSONObjectOptJSONObject;
        KGSong kGSong = new KGSong(str);
        String strOptString = jSONObject.optString("FileName");
        String strOptString2 = jSONObject.optString("OriSongName");
        String strOptString3 = jSONObject.optString("Suffix");
        kGSong.e3(strOptString);
        kGSong.A4("8");
        kGSong.F4(strOptString3);
        kGSong.s4(strOptString2);
        kGSong.n3(jSONObject.optString("AlbumID"));
        r0.i(jSONObject, kGSong);
        kGSong.R2(jSONObject.optString("SingerName"));
        kGSong.I4(jSONObject.optString("Auxiliary"));
        kGSong.o4(jSONObject.getLong("FileSize"));
        kGSong.Q3(jSONObject.optLong("MixSongID", 0L));
        kGSong.c4(jSONObject.optInt("IsOriginal"));
        String strOptString4 = jSONObject.optString("FileHash");
        if (!TextUtils.isEmpty(strOptString4)) {
            kGSong.B3(strOptString4);
            kGSong.A3(300);
        }
        if (z && !TextUtils.isEmpty(kGSong.y2()) && kGSong.y2().contains("歌词")) {
            kGSong.K3(i2 + 1);
        } else {
            kGSong.K3(0);
        }
        kGSong.X2(jSONObject.optInt("Bitrate"));
        kGSong.j3(jSONObject.optString("ExtName"));
        String strOptString5 = jSONObject.optString("AlbumID", "0");
        if (TextUtils.isEmpty(strOptString5)) {
            kGSong.O2(0);
        } else {
            kGSong.O2(Integer.valueOf(strOptString5).intValue());
        }
        kGSong.P2(jSONObject.optString("AlbumName"));
        long j = jSONObject.getLong("Duration");
        kGSong.g3(1000 * j);
        int iOptInt = jSONObject.optInt("PublishAge", -1);
        kGSong.J3((iOptInt == -1 || iOptInt == 255) ? 0 : 1);
        int iOptInt2 = jSONObject.optInt("M4aSize");
        if (iOptInt2 > 0) {
            kGSong.M3(iOptInt2);
        } else if (j > 0) {
            kGSong.M3(((int) j) * 1024 * 4);
        }
        if (!jSONObject.isNull("trans_param") && (jSONObjectOptJSONObject = jSONObject.optJSONObject("trans_param")) != null && e.a(jSONObjectOptJSONObject.optInt("pay_block_tpl", 0))) {
            kGSong.U2(2);
        }
        if (e.c.a.g.a.f.a.s() && !TextUtils.isEmpty(str) && str.equals(e.c.a.g.a.t.e.a.o()) && e.c.a.g.a.f.j.c.d.d(kGSong)) {
            kGSong.z3(r0.c(jSONObject));
        }
        kGSong.C3(jSONObject.optString("HQFileHash"));
        kGSong.p4(jSONObject.optInt("HQFileSize"));
        kGSong.m3(jSONObject.optInt("FailProcess"));
        kGSong.e4(jSONObject.optInt("PayType"));
        kGSong.U3(jSONObject.optString("Type"));
        kGSong.O4(l1.b());
        kGSong.b4(jSONObject.optInt("OldCpy", -1));
        kGSong.M4(2);
        kGSong.l3(1);
        kGSong.X3(jSONObject.optString("MvHash"));
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("SingerId");
        if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
            SingerInfo[] singerInfoArr = new SingerInfo[jSONArrayOptJSONArray.length()];
            for (int i4 = 0; i4 < jSONArrayOptJSONArray.length(); i4++) {
                SingerInfo singerInfo = new SingerInfo();
                singerInfo.d(jSONArrayOptJSONArray.optInt(i4));
                singerInfoArr[i4] = singerInfo;
            }
            kGSong.n4(singerInfoArr);
        }
        try {
            String strOptString6 = jSONObject.optString("SQFileHash");
            if ("00000000000000000000000000000000".equals(strOptString6)) {
                strOptString6 = "";
            }
            kGSong.C4(strOptString6);
            kGSong.D4(jSONObject.optInt("SQFileSize"));
            kGSong.o3(0);
            kGSong.E4(-1);
        } catch (Exception unused) {
        }
        kGSong.b3(jSONObject.optInt("Privilege"));
        kGSong.y3(jSONObject.optInt("Accompany", 0));
        try {
            kGSong.S3(jSONObject.optInt("AlbumPrivilege"), jSONObject.optInt("A320Privilege"), jSONObject.optInt("ASQPrivilege"));
        } catch (Exception unused2) {
        }
        try {
            kGSong.G4(jSONObject.optString("Source"));
            kGSong.H4(jSONObject.getLong("SourceID"));
        } catch (Exception unused3) {
        }
        if (e.c.a.g.a.f.a.b() && e.c.a.g.a.f.j.c.d.d(kGSong)) {
            kGSong.z3(r0.c(jSONObject));
        }
        return kGSong;
    }
}
