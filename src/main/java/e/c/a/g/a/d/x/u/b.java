package e.c.a.g.a.d.x.u;

import android.text.TextUtils;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import com.kugou.android.watch.lite.base.musicfees.mediastore.entity.HashOffset;
import com.kugou.android.watch.lite.base.player.entity.CommNetSongUrlInfo;
import com.kugou.android.watch.lite.base.player.entity.NetSongUrlResponse;
import com.kugou.common.network.ackutils.StringResponsePackage;
import e.c.a.g.a.s.g0;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class b extends StringResponsePackage<NetSongUrlResponse> {
    public static void b(NetSongUrlResponse netSongUrlResponse, String str, String str2) {
        int iOptInt;
        try {
            if (g0.a) {
                g0.e("zzm-log", "mJsonString:" + str);
            }
            netSongUrlResponse.setRespStr(str);
            JSONObject jSONObject = new JSONObject(str);
            if (!TextUtils.isEmpty(str2) && jSONObject.has(str2)) {
                jSONObject = jSONObject.getJSONObject(str2);
            }
            int iOptInt2 = jSONObject.optInt(NotificationCompat.CATEGORY_STATUS);
            if (iOptInt2 != 1) {
                Log.d("zzm-log", "trakcer url status: " + iOptInt2);
            }
            CommNetSongUrlInfo commNetSongUrlInfo = new CommNetSongUrlInfo();
            String strOptString = jSONObject.optString("error");
            try {
                iOptInt = jSONObject.optInt("errcode");
            } catch (Exception unused) {
                iOptInt = 0;
            }
            netSongUrlResponse.setOriginErrIdentify(iOptInt2 + ":" + iOptInt + ":" + strOptString);
            if (iOptInt2 == 0) {
                netSongUrlResponse.setErrorMessage(strOptString);
                if (CommNetSongUrlInfo.ERRSTR_NOTFOUNTFILE.equalsIgnoreCase(strOptString) || CommNetSongUrlInfo.ERRSTR_NOTFOUNTHASH.equalsIgnoreCase(strOptString)) {
                    netSongUrlResponse.setErrorType(5);
                } else if (CommNetSongUrlInfo.ERRSTR_M4ANOTFOUND.equalsIgnoreCase(strOptString)) {
                    netSongUrlResponse.setErrorType(20);
                } else if (CommNetSongUrlInfo.ERRSTR_BADKEY.equalsIgnoreCase(strOptString)) {
                    netSongUrlResponse.setErrorType(22);
                } else if (iOptInt == 20028) {
                    netSongUrlResponse.setErrorType(CommNetSongUrlInfo.TRACK_RISK_ERROR);
                } else {
                    netSongUrlResponse.setErrorType(9);
                }
            } else if (iOptInt2 == 2) {
                netSongUrlResponse.setErrorMessage("need process");
                netSongUrlResponse.setErrorType(11);
                if (jSONObject.has("fail_process")) {
                    JSONArray jSONArray = jSONObject.getJSONArray("fail_process");
                    ArrayList<String> arrayList = new ArrayList<>(jSONArray.length());
                    for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                        arrayList.add(jSONArray.optString(i2));
                    }
                    netSongUrlResponse.setFailProcess(arrayList);
                }
            } else if (iOptInt2 == 3) {
                netSongUrlResponse.setErrorMessage("forbidden");
                netSongUrlResponse.setErrorType(12);
            } else if (iOptInt2 == 5) {
                netSongUrlResponse.setErrorMessage(strOptString);
            } else if (iOptInt2 == 1) {
                if (jSONObject.has("url")) {
                    JSONArray jSONArray2 = jSONObject.getJSONArray("url");
                    if (jSONArray2.length() > 0) {
                        commNetSongUrlInfo.setUrl(jSONArray2.optString(0).replace("\\", ""));
                        ArrayList arrayList2 = new ArrayList(jSONArray2.length() - 1);
                        for (int i3 = 1; i3 < jSONArray2.length(); i3++) {
                            arrayList2.add(jSONArray2.optString(i3).replace("\\", ""));
                        }
                        commNetSongUrlInfo.setSpareUrls(arrayList2);
                    } else {
                        commNetSongUrlInfo.setUrl("");
                        commNetSongUrlInfo.setSpareUrls(new ArrayList<>());
                        netSongUrlResponse.setErrorMessage("empty url array");
                        netSongUrlResponse.setErrorType(8);
                    }
                } else {
                    netSongUrlResponse.setErrorMessage("no url");
                    netSongUrlResponse.setErrorType(8);
                }
                if (jSONObject.has("fileSize")) {
                    commNetSongUrlInfo.setFileSize(Integer.parseInt(jSONObject.optString("fileSize")));
                }
                if (jSONObject.has("extName")) {
                    commNetSongUrlInfo.setExtName(jSONObject.optString("extName"));
                }
                if (jSONObject.has("timeLength")) {
                    commNetSongUrlInfo.setDuration(jSONObject.getLong("timeLength") * 1000);
                }
                try {
                    if (jSONObject.has("hash_offset")) {
                        commNetSongUrlInfo.setHashOffset(HashOffset.jsonToHashOffset(jSONObject.getJSONObject("hash_offset")));
                    }
                } catch (Exception unused2) {
                }
                try {
                    if (jSONObject.has("bitRate")) {
                        commNetSongUrlInfo.setBitRate(jSONObject.optInt("bitRate"));
                    }
                } catch (Exception unused3) {
                }
            } else {
                netSongUrlResponse.setErrorMessage("unknown error");
                netSongUrlResponse.setErrorType(13);
            }
            if (commNetSongUrlInfo.isUseful()) {
                netSongUrlResponse.setNetSongUrl(commNetSongUrlInfo);
            }
        } catch (Exception unused4) {
        }
    }

    @Override // com.kugou.common.network.ackutils.StringResponsePackage, com.kugou.common.network.protocol.ResponsePackage
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void getResponseData(NetSongUrlResponse netSongUrlResponse) {
        b(netSongUrlResponse, this.mJsonString, null);
    }
}
