package e.c.a.g.a.d.x.u;

import androidx.core.app.NotificationCompat;
import com.kugou.android.watch.lite.base.player.entity.CommNetSongUrlInfo;
import com.kugou.android.watch.lite.base.player.entity.NetSongUrlResponse;
import com.kugou.common.network.ResponseTypeChecker;
import com.kugou.common.network.ackutils.StringResponsePackage;
import e.c.a.g.a.s.g0;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class d extends StringResponsePackage<NetSongUrlResponse> {
    @Override // com.kugou.common.network.ackutils.StringResponsePackage, com.kugou.common.network.protocol.ResponsePackage
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void getResponseData(NetSongUrlResponse netSongUrlResponse) {
        int iOptInt;
        try {
            netSongUrlResponse.setRespStr(this.mJsonString);
            JSONObject jSONObject = new JSONObject(this.mJsonString);
            int iOptInt2 = jSONObject.optInt(NotificationCompat.CATEGORY_STATUS);
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
                netSongUrlResponse.setErrorMessage("need charge");
                netSongUrlResponse.setErrorType(11);
            } else if (iOptInt2 == 3) {
                netSongUrlResponse.setErrorMessage("forbidden");
                netSongUrlResponse.setErrorType(12);
            } else if (iOptInt2 == 5) {
                netSongUrlResponse.setErrorMessage(strOptString);
            } else {
                if (iOptInt2 == 1) {
                    if (jSONObject.has("url")) {
                        JSONArray jSONArray = jSONObject.getJSONArray("url");
                        if (jSONArray.length() > 0) {
                            commNetSongUrlInfo.setUrl(jSONArray.optString(0).replace("\\", ""));
                            ArrayList arrayList = new ArrayList(jSONArray.length() - 1);
                            for (int i2 = 1; i2 < jSONArray.length(); i2++) {
                                arrayList.add(jSONArray.optString(i2).replace("\\", ""));
                            }
                            commNetSongUrlInfo.setSpareUrls(arrayList);
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
                        if (jSONObject.has("bitRate")) {
                            commNetSongUrlInfo.setBitRate(jSONObject.optInt("bitRate"));
                        }
                    } catch (Exception unused2) {
                    }
                } else {
                    netSongUrlResponse.setErrorMessage("unknown error");
                    netSongUrlResponse.setErrorType(13);
                }
            }
            if (commNetSongUrlInfo.isUseful()) {
                netSongUrlResponse.setNetSongUrl(commNetSongUrlInfo);
            }
        } catch (Exception e2) {
            g0.k(e2);
        }
    }

    @Override // com.kugou.common.network.ackutils.StringResponsePackage, com.kugou.common.network.protocol.ResponsePackage
    public ResponseTypeChecker.ResponseType getResponseType() {
        return ResponseTypeChecker.ResponseType.JSON;
    }
}
