package e.c.a.g.a.s;

import com.kugou.android.watch.lite.base.musicfees.mediastore.entity.HashOffset;
import com.kugou.android.watch.lite.common.music.entity.KGMusic;
import com.kugou.android.watch.lite.common.music.entity.KGSong;
import com.kugou.android.watch.lite.common.music.entity.MusicTransParamEnenty;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class r0 {

    public interface a {
        MusicTransParamEnenty getMusicTransParamEnenty();

        void setMusicTransParamEnenty(MusicTransParamEnenty musicTransParamEnenty);
    }

    public static boolean a(int i2) {
        return i2 == 1;
    }

    public static boolean b(MusicTransParamEnenty musicTransParamEnenty) {
        return musicTransParamEnenty != null && a(musicTransParamEnenty.getAllQualityFree());
    }

    public static HashOffset c(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("trans_param");
        if (jSONObjectOptJSONObject == null) {
            return null;
        }
        return HashOffset.jsonToHashOffset(jSONObjectOptJSONObject.optJSONObject("hash_offset"));
    }

    public static MusicTransParamEnenty d(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject;
        if (jSONObject == null || (jSONObjectOptJSONObject = jSONObject.optJSONObject("trans_param")) == null) {
            return null;
        }
        MusicTransParamEnenty musicTransParamEnenty = new MusicTransParamEnenty();
        musicTransParamEnenty.setMusicpackAdvance(jSONObjectOptJSONObject.optInt("musicpack_advance", 0));
        musicTransParamEnenty.setAllQualityFree(jSONObjectOptJSONObject.optInt("all_quality_free", 0));
        musicTransParamEnenty.setLimitedFree(jSONObjectOptJSONObject.optInt("limited_free", 0));
        musicTransParamEnenty.setDisplay(jSONObjectOptJSONObject.optInt("display", 0));
        musicTransParamEnenty.setDisplayRate(jSONObjectOptJSONObject.optInt("display_rate", -1));
        musicTransParamEnenty.setPay_block_tpl(jSONObjectOptJSONObject.optInt("pay_block_tpl", -1));
        if (k(jSONObjectOptJSONObject) && jSONObjectOptJSONObject.has("hash_offset")) {
            String strOptString = "";
            if (jSONObject.has("rp_type")) {
                strOptString = jSONObject.optString("rp_type", "");
            } else if (jSONObject.has("musicFeeType")) {
                strOptString = jSONObject.optString("musicFeeType", "");
            } else if (jSONObject.has("type")) {
                strOptString = jSONObject.optString("type", "");
            } else if (jSONObject.has("medistype")) {
                strOptString = jSONObject.optString("medistype", "");
            }
            if (e.c.a.g.a.d.r.h.e(strOptString)) {
                musicTransParamEnenty.setHave_listen_part(1);
            } else {
                musicTransParamEnenty.setHave_listen_part(2);
            }
        }
        return musicTransParamEnenty;
    }

    public static boolean e(MusicTransParamEnenty musicTransParamEnenty) {
        return musicTransParamEnenty != null && (g(musicTransParamEnenty) || f(musicTransParamEnenty));
    }

    public static boolean f(MusicTransParamEnenty musicTransParamEnenty) {
        return musicTransParamEnenty != null && musicTransParamEnenty.getHave_listen_part() == 1;
    }

    public static boolean g(MusicTransParamEnenty musicTransParamEnenty) {
        return musicTransParamEnenty != null && musicTransParamEnenty.getHave_listen_part() == 2;
    }

    public static boolean h(MusicTransParamEnenty musicTransParamEnenty) {
        return musicTransParamEnenty != null && musicTransParamEnenty.getMusicpackAdvance() == 1;
    }

    public static void i(JSONObject jSONObject, a aVar) {
        if (jSONObject == null || aVar == null) {
            return;
        }
        aVar.setMusicTransParamEnenty(d(jSONObject));
    }

    public static boolean j(MusicTransParamEnenty musicTransParamEnenty) {
        return musicTransParamEnenty != null && a(musicTransParamEnenty.getLimitedFree());
    }

    public static boolean k(JSONObject jSONObject) {
        return jSONObject != null && jSONObject.optInt("pay_block_tpl", 1) == 1;
    }

    public static void l(a aVar, MusicTransParamEnenty musicTransParamEnenty) {
        if (musicTransParamEnenty == null || !e.a(musicTransParamEnenty.getPay_block_tpl())) {
            return;
        }
        if (aVar instanceof KGSong) {
            ((KGSong) aVar).U2(2);
        } else if (aVar instanceof KGMusic) {
            ((KGMusic) aVar).setAudioType(2);
        }
    }

    public static boolean m(MusicTransParamEnenty musicTransParamEnenty) {
        return e.c.a.g.a.d.r.g.s(musicTransParamEnenty);
    }
}
