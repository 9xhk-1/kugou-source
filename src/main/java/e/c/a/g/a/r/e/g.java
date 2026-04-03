package e.c.a.g.a.r.e;

import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.kugou.android.watch.lite.user.login.AccountSimpleEntity;
import com.kugou.android.watch.lite.user.login.UserData;
import com.kugou.common.network.AbsHttpClient;
import com.kugou.common.network.ResponseTypeChecker;
import e.c.a.g.a.s.g0;
import java.util.ArrayList;
import org.apache.http.Header;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class g extends a<UserData> implements AbsHttpClient.IHttpProperty {
    public String b;

    @Override // e.c.a.g.a.r.e.a, com.kugou.common.network.protocol.ResponsePackage
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void getResponseData(UserData userData) {
        if (userData == null || TextUtils.isEmpty(this.b)) {
            throw new NullPointerException("Login resp is Empty");
        }
        e.c.a.g.a.f.m.c.a.i("user_data_json", this.b);
        try {
            JSONObject jSONObject = new JSONObject(this.b);
            if (jSONObject.optString(NotificationCompat.CATEGORY_STATUS) == null) {
                userData.setRespStr(this.b);
                userData.setMessage(jSONObject.getString("data"));
                throw new NullPointerException("Login status is Null");
            }
            userData.setStatus(jSONObject.getInt(NotificationCompat.CATEGORY_STATUS));
            try {
                if (jSONObject.getInt(NotificationCompat.CATEGORY_STATUS) == 1) {
                    JSONObject jSONObject2 = new JSONObject(jSONObject.getString("data"));
                    userData.setUserid(jSONObject2.getLong("userid"));
                    userData.setNickname(jSONObject2.getString("nickname"));
                    if (jSONObject2.has("sex")) {
                        userData.setSex(jSONObject2.getInt("sex"));
                    }
                    userData.setPic(jSONObject2.getString("pic"));
                    if (!TextUtils.isEmpty(jSONObject2.optString("username"))) {
                        userData.setUsername(jSONObject2.getString("username"));
                    }
                    if (!TextUtils.isEmpty(jSONObject2.optString("score"))) {
                        userData.setScore(jSONObject2.getInt("score"));
                    }
                    if (jSONObject2.optInt("vip_type", -1) != -1) {
                        userData.setVip_type(jSONObject2.getInt("vip_type"));
                    }
                    if (!TextUtils.isEmpty(jSONObject2.optString("vip_begin_time"))) {
                        userData.setVip_begin_time(jSONObject2.getString("vip_begin_time"));
                    }
                    if (!TextUtils.isEmpty(jSONObject2.optString("vip_end_time"))) {
                        userData.setVip_end_time(jSONObject2.getString("vip_end_time"));
                    }
                    if (!TextUtils.isEmpty(jSONObject2.optString("svip_end_time"))) {
                        userData.setSuper_Vip_end_time(jSONObject2.getString("svip_end_time"));
                    }
                    if (!TextUtils.isEmpty(jSONObject2.optString("token"))) {
                        userData.setToken(jSONObject2.getString("token"));
                    }
                    if (!TextUtils.isEmpty(jSONObject2.optString("servertime"))) {
                        userData.setServertime(jSONObject2.getString("servertime"));
                    }
                    if (!TextUtils.isEmpty(jSONObject2.optString("birthday"))) {
                        userData.setBirthday(jSONObject2.getString("birthday"));
                    }
                    if (!TextUtils.isEmpty(jSONObject2.optString("birthday"))) {
                        userData.setBirthdayYYYYMMDD(jSONObject2.getString("birthday"));
                    }
                    if (!TextUtils.isEmpty(jSONObject2.optString("birthday_mmdd"))) {
                        userData.setBirthdayMMDD(jSONObject2.optString("birthday_mmdd"));
                    }
                    if (!TextUtils.isEmpty(jSONObject2.optString("city"))) {
                        userData.setCity(jSONObject2.getString("city"));
                    }
                    if (!TextUtils.isEmpty(jSONObject2.optString("last_login_time"))) {
                        userData.setLast_login_time(jSONObject2.getString("last_login_time"));
                    }
                    if (!TextUtils.isEmpty(jSONObject2.optString("login_email"))) {
                        userData.setLogin_email(jSONObject2.getString("login_email"));
                    }
                    if (!TextUtils.isEmpty(jSONObject2.optString("login_mobile"))) {
                        userData.setLogin_mobile(jSONObject2.getString("login_mobile"));
                    }
                    if (!TextUtils.isEmpty(jSONObject2.optString("memo"))) {
                        userData.setMemo(jSONObject2.getString("memo"));
                    }
                    if (!TextUtils.isEmpty(jSONObject2.optString("province"))) {
                        userData.setProvince(jSONObject2.getString("province"));
                    }
                    if (!TextUtils.isEmpty(jSONObject2.optString("question_id"))) {
                        userData.setQuestion_id(jSONObject2.getInt("question_id"));
                    }
                    if (!TextUtils.isEmpty(jSONObject2.optString("reg_time"))) {
                        userData.setReg_time(jSONObject2.getString("reg_time"));
                    }
                    if (!TextUtils.isEmpty(jSONObject2.optString("security_email"))) {
                        userData.setSecurity_email(jSONObject2.getString("security_email"));
                    }
                    if (!TextUtils.isEmpty(jSONObject2.optString("truename"))) {
                        userData.setTruename(jSONObject2.getString("truename"));
                    }
                    if (!TextUtils.isEmpty(jSONObject2.optString("signature"))) {
                        userData.setSignature(jSONObject2.getString("signature"));
                    }
                    if (jSONObject2.has("m_type")) {
                        userData.setMusicType(jSONObject2.getInt("m_type"));
                    }
                    if (jSONObject2.has("y_type")) {
                        userData.setYearType(jSONObject2.optInt("y_type"));
                    }
                    if (jSONObject2.has("m_clearday")) {
                        userData.setMusic_clearday(jSONObject2.getString("m_clearday"));
                    }
                    if (jSONObject2.has("m_begin_time")) {
                        userData.setMusicBegin(jSONObject2.getString("m_begin_time"));
                    }
                    if (jSONObject2.has("m_end_time")) {
                        userData.setMusicEnd(jSONObject2.getString("m_end_time"));
                    }
                    if (jSONObject2.has("first_login")) {
                        userData.setFirst_login(jSONObject2.getInt("first_login"));
                    }
                    if (jSONObject2.has("roam_type")) {
                        userData.setRoamType(jSONObject2.optInt("roam_type"));
                    }
                    if (jSONObject2.has("roam_begin_time")) {
                        userData.setRoamBeginTime(jSONObject2.optString("roam_begin_time"));
                    }
                    if (jSONObject2.has("roam_end_time")) {
                        userData.setRoamEndTime(jSONObject2.optString("roam_end_time"));
                    }
                    if (jSONObject2.has("m_is_old")) {
                        userData.setM_is_old(jSONObject2.getInt("m_is_old"));
                        if (g0.a) {
                            g0.b("xutaici_login", userData.getM_is_old() != 1 ? "是新用户" : "是老用户");
                        }
                    } else if (g0.a) {
                        g0.b("xutaici_login", "没有老用户参数");
                    }
                    if (jSONObject2.has("t1")) {
                        userData.setT1(jSONObject2.getString("t1"));
                    }
                    if (jSONObject2.has("jump_url")) {
                        userData.setJumpUrl(jSONObject2.getString("jump_url"));
                    }
                    if (jSONObject.has("error_code")) {
                        userData.setError_code(jSONObject.getInt("error_code"));
                    }
                } else if (jSONObject.getInt(NotificationCompat.CATEGORY_STATUS) == 0) {
                    userData.setStatus(0);
                    userData.setError_code(jSONObject.getInt("error_code"));
                    userData.setMessage(jSONObject.optString("data"));
                    try {
                        JSONObject jSONObject3 = new JSONObject(jSONObject.optString("data"));
                        if (jSONObject3.has("jump_url")) {
                            userData.setJumpUrl(jSONObject3.getString("jump_url"));
                        }
                        if (jSONObject3.has("info_list")) {
                            ArrayList<AccountSimpleEntity> arrayList = new ArrayList<>();
                            JSONArray jSONArray = jSONObject3.getJSONArray("info_list");
                            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                                JSONObject jSONObject4 = jSONArray.getJSONObject(i2);
                                AccountSimpleEntity accountSimpleEntity = new AccountSimpleEntity();
                                accountSimpleEntity.f(String.valueOf(jSONObject4.optLong("userid")));
                                accountSimpleEntity.d(jSONObject4.optString("nickname"));
                                accountSimpleEntity.g(jSONObject4.optString("username"));
                                accountSimpleEntity.e(jSONObject4.optString("pic"));
                                arrayList.add(accountSimpleEntity);
                            }
                            userData.setAccounts(arrayList);
                        }
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                }
                userData.setRespStr(this.b);
                e.c.a.g.a.f.m.c.a.i("user_data_json", this.b);
            } catch (Exception e3) {
                e = e3;
                throw new NullPointerException("Login resp json format Incorrect:" + e.getMessage());
            }
        } catch (Exception e4) {
            e = e4;
        }
    }

    public void b(String str) {
        this.b = str;
    }

    public void c(int i2) {
    }

    @Override // e.c.a.g.a.r.e.a, com.kugou.common.network.protocol.ResponsePackage
    public ResponseTypeChecker.ResponseType getResponseType() {
        return ResponseTypeChecker.ResponseType.JSON;
    }

    @Override // com.kugou.common.network.AbsHttpClient.IHttpProperty
    public boolean onContentType(String str) {
        return true;
    }

    @Override // e.c.a.g.a.r.e.a, com.kugou.common.network.AbsHttpClient.IHttpException
    public void onHeaderException(int i2, String str, int i3, Header[] headerArr) {
    }

    @Override // com.kugou.common.network.AbsHttpClient.IHttpProperty
    public boolean onHeaders(Header[] headerArr) {
        return true;
    }

    @Override // com.kugou.common.network.AbsHttpClient.IHttpProperty
    public boolean onResponseCode(int i2) {
        c(i2);
        return true;
    }

    @Override // e.c.a.g.a.r.e.a, com.kugou.common.network.protocol.ResponsePackage
    public void setContext(byte[] bArr) {
        if (bArr == null || bArr.length <= 0) {
            return;
        }
        try {
            String str = new String(bArr, "UTF-8");
            this.b = str;
            if (g0.a) {
                g0.e("user info", str);
            }
        } catch (Exception unused) {
        }
    }
}
