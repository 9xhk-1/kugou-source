package com.kugou.common.userinfo.protocol;

import android.text.TextUtils;
import e.c.a.g.a.s.g0;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class LoginExtendInfo {
    private Auth auth;
    private BindInfo bindInfo;
    private Fx fx;
    private GradeInfo gradeInfo;
    public long servertime;
    public long userid;

    public static class Auth {
        public String auth_info;
        public int biz_status;
        public String jumpUrl;
        public int star_id;
        public int star_status;
        public int status;
        public int student_status;
        public String talentIconAfterAvatar;
        public String talentIconAfterId;
        public String talentTitle;
        public int talent_status = -1;
        public int titleId;
        public int tme_star_status;

        public static Auth from(Auth auth) {
            if (auth == null) {
                return null;
            }
            Auth auth2 = new Auth();
            auth2.tme_star_status = auth.tme_star_status;
            auth2.star_status = auth.star_status;
            auth2.star_id = auth.star_id;
            auth2.biz_status = auth.biz_status;
            auth2.status = auth.status;
            auth2.auth_info = auth.auth_info;
            auth2.talent_status = auth.talent_status;
            auth2.student_status = auth.student_status;
            auth2.talentIconAfterAvatar = auth.talentIconAfterAvatar;
            auth2.talentIconAfterId = auth.talentIconAfterId;
            auth2.talentTitle = auth.talentTitle;
            auth2.titleId = auth.titleId;
            auth2.jumpUrl = auth.jumpUrl;
            return auth2;
        }
    }

    public static class BindInfo {
        public int is_bind = -1;
        public String text;

        public static BindInfo from(BindInfo bindInfo) {
            if (bindInfo == null) {
                return new BindInfo();
            }
            BindInfo bindInfo2 = new BindInfo();
            bindInfo2.is_bind = bindInfo.is_bind;
            bindInfo2.text = bindInfo.text;
            return bindInfo2;
        }

        public boolean is3Without() {
            return this.is_bind == 0;
        }
    }

    public static class Fx {
        public static final int TYPE_UNKNOWN = -2;
        public int is_star = -2;
        public int biz_type = -2;
        private int follow_star = -2;

        public static Fx from(Fx fx) {
            if (fx == null) {
                return null;
            }
            Fx fx2 = new Fx();
            fx2.is_star = fx.is_star;
            fx2.biz_type = fx.biz_type;
            fx2.follow_star = fx.follow_star;
            return fx2;
        }

        public int getFollowStar() {
            return this.follow_star;
        }

        public boolean isCompetitorUsers() {
            return this.biz_type == 2;
        }

        public boolean isFxUser() {
            int i2 = this.is_star;
            return i2 <= 1 && i2 >= -1 && i2 != -1;
        }

        public boolean isNormalUser() {
            return this.biz_type == 0;
        }

        public boolean isPotentialUsers() {
            return this.biz_type == 1;
        }

        public void setFollowStar(int i2) {
            this.follow_star = i2;
        }
    }

    public static class GradeInfo {
        public int d_sec;
        public long duration;
        public long p_current_point;
        public int p_grade;
        public long p_grade_point;
        public int p_next_grade;
        public long p_next_grade_point;
        public String p_speed_info;

        public static GradeInfo from(GradeInfo gradeInfo) {
            if (gradeInfo == null) {
                return null;
            }
            GradeInfo gradeInfo2 = new GradeInfo();
            gradeInfo2.p_speed_info = gradeInfo.p_speed_info;
            gradeInfo2.p_next_grade_point = gradeInfo.p_next_grade_point;
            gradeInfo2.p_next_grade = gradeInfo.p_next_grade;
            gradeInfo2.p_grade_point = gradeInfo.p_grade_point;
            gradeInfo2.p_grade = gradeInfo.p_grade;
            gradeInfo2.p_current_point = gradeInfo.p_current_point;
            gradeInfo2.d_sec = gradeInfo.d_sec;
            gradeInfo2.duration = gradeInfo.duration;
            return gradeInfo2;
        }

        public float getPSpeed(GradeInfo gradeInfo, boolean z, boolean z2) {
            if (gradeInfo == null || TextUtils.isEmpty(gradeInfo.p_speed_info)) {
                return 1.0f;
            }
            try {
                JSONObject jSONObject = new JSONObject(gradeInfo.p_speed_info);
                return z2 ? Float.parseFloat(jSONObject.optString("p2", "2")) : z ? Float.parseFloat(jSONObject.optString("p1", "1.5")) : Float.parseFloat(jSONObject.optString("p0", "1"));
            } catch (JSONException e2) {
                g0.k(e2);
                return 1.0f;
            }
        }
    }

    public Auth getAuth() {
        return Auth.from(this.auth);
    }

    public BindInfo getBindInfo() {
        return BindInfo.from(this.bindInfo);
    }

    public Fx getFx() {
        return Fx.from(this.fx);
    }

    public GradeInfo getGradeInfo() {
        return GradeInfo.from(this.gradeInfo);
    }

    public long getUserid() {
        return this.userid;
    }

    public void setAuth(Auth auth) {
        this.auth = auth;
    }

    public void setBindInfo(BindInfo bindInfo) {
        this.bindInfo = bindInfo;
    }

    public void setFx(Fx fx) {
        this.fx = fx;
    }

    public void setGradeInfo(GradeInfo gradeInfo) {
        this.gradeInfo = gradeInfo;
    }
}
