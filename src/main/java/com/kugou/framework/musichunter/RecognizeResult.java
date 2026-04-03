package com.kugou.framework.musichunter;

import android.text.TextUtils;
import androidx.annotation.IntRange;
import androidx.core.app.NotificationCompat;
import com.kugou.framework.musichunter.KGHunterSong;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class RecognizeResult {
    public static final RecognizeResult FAKE_INSTANCE = new RecognizeResult(true);
    private String errorInfo;
    private int error_code;
    private boolean exact;
    private int from;
    private int invalidReason;
    public final boolean isFake;
    private boolean isFromFC;
    private boolean isFromSecondLever;
    private boolean isFromVoiceRecognize;
    private boolean isInvalidResult;
    private boolean isSuccess;
    private boolean postPCM;
    private int[] ratings;
    private NetSongResponse response;
    private boolean status;

    public RecognizeResult() {
        this.isFake = false;
    }

    public static RecognizeResult buildInvalidResult2(@IntRange(from = 0) int i2, @IntRange(from = 0) int i3) {
        RecognizeResult recognizeResult = new RecognizeResult();
        recognizeResult.isSuccess = true;
        recognizeResult.isInvalidResult = true;
        recognizeResult.invalidReason = i3;
        recognizeResult.from = i2;
        return recognizeResult;
    }

    private boolean needPostPCM() {
        return this.postPCM;
    }

    private void setFailed(String str, int i2) {
        this.status = false;
        this.error_code = i2;
        this.errorInfo = str;
    }

    private void setResponse() {
    }

    public int getErrorCode() {
        return this.error_code;
    }

    public String getErrorInfo() {
        return this.errorInfo;
    }

    public int getFrom() {
        return this.from;
    }

    public int getMaxRating() {
        int[] iArr = this.ratings;
        if (iArr == null || iArr.length <= 0) {
            return 0;
        }
        return iArr[0];
    }

    public NetSongResponse getResponse() {
        return this.response;
    }

    public boolean getStatus() {
        return this.status;
    }

    public String getSummary() {
        NetSongResponse netSongResponse = this.response;
        String str = "";
        if (netSongResponse != null && netSongResponse.getSongs() != null && !this.response.getSongs().isEmpty() && this.ratings != null) {
            for (int i2 = 0; i2 < this.response.getSongs().size(); i2++) {
                str = str + this.response.getSongs().get(i2).getSongName() + "(" + this.ratings[i2] + ")|";
            }
        }
        return str;
    }

    public boolean isExact() {
        return this.exact;
    }

    public boolean isFromFC() {
        return this.isFromFC;
    }

    public boolean isFromSecondLever() {
        return this.isFromSecondLever;
    }

    public boolean isFromVoiceRecognize() {
        return this.isFromVoiceRecognize;
    }

    public boolean isSuccess() {
        return this.isSuccess;
    }

    public boolean isValid() {
        NetSongResponse netSongResponse;
        return (!this.status || (netSongResponse = this.response) == null || netSongResponse.getSongs() == null || this.response.getSongs().isEmpty()) ? false : true;
    }

    public void parse(String str) {
        int i2;
        String str2;
        String str3;
        ArrayList<KGHunterSong> arrayList;
        String str4;
        JSONArray jSONArray;
        int length;
        JSONArray jSONArray2;
        String str5 = "relate_goods";
        String str6 = "timeoffset";
        String str7 = "privilege";
        String str8 = "level";
        if (TextUtils.isEmpty(str)) {
            setFailed("空结果", 0);
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.getString(NotificationCompat.CATEGORY_STATUS) == null) {
                throw new Exception("JSON 不合法");
            }
            String str9 = "1";
            if (jSONObject.has("postpcm")) {
                this.postPCM = "1".equalsIgnoreCase(jSONObject.getString("postpcm"));
            }
            if (!"1".equalsIgnoreCase(jSONObject.getString(NotificationCompat.CATEGORY_STATUS))) {
                this.error_code = jSONObject.getInt("error_code");
                this.errorInfo = jSONObject.getString("error_description");
                return;
            }
            JSONArray jSONArray3 = jSONObject.getJSONArray("data");
            if (jSONArray3 == null) {
                return;
            }
            int length2 = jSONArray3.length();
            if (length2 > 0) {
                this.status = true;
            }
            NetSongResponse netSongResponse = new NetSongResponse();
            this.response = netSongResponse;
            this.ratings = new int[length2];
            netSongResponse.setRecordcount(length2);
            ArrayList<KGHunterSong> arrayList2 = new ArrayList<>();
            int i3 = 0;
            while (i3 < length2) {
                JSONObject jSONObjectOptJSONObject = jSONArray3.optJSONObject(i3);
                String strOptString = jSONObjectOptJSONObject.optString("singername");
                String strOptString2 = jSONObjectOptJSONObject.optString("songname");
                String strOptString3 = jSONObjectOptJSONObject.optString("trackid");
                int iOptInt = jSONObjectOptJSONObject.optInt("mixsongid");
                JSONArray jSONArray4 = jSONArray3;
                JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("album");
                if (i3 == 0) {
                    i2 = length2;
                    this.response.setGuess(jSONObjectOptJSONObject.optInt("to_show_downgrade_text") == 1);
                } else {
                    i2 = length2;
                }
                ArrayList arrayList3 = new ArrayList();
                String str10 = "";
                if (jSONArrayOptJSONArray == null || jSONArrayOptJSONArray.length() <= 0) {
                    str2 = str6;
                    str3 = str9;
                    arrayList = arrayList2;
                } else {
                    str3 = str9;
                    arrayList = arrayList2;
                    int i4 = 0;
                    while (i4 < jSONArrayOptJSONArray.length()) {
                        String str11 = str6;
                        jSONArrayOptJSONArray.getJSONObject(i4).optString("img");
                        jSONArrayOptJSONArray.getJSONObject(i4).optString("albumid");
                        jSONArrayOptJSONArray.getJSONObject(i4).optString("scid");
                        String strOptString4 = jSONArrayOptJSONArray.getJSONObject(i4).optString("albumname");
                        JSONArray jSONArray5 = jSONArrayOptJSONArray;
                        String strOptString5 = jSONArrayOptJSONArray.getJSONObject(i4).optString("publish_date", "");
                        KGHunterSong.AlbumInfo albumInfo = new KGHunterSong.AlbumInfo();
                        albumInfo.albumname = strOptString4;
                        albumInfo.publishDate = strOptString5;
                        arrayList3.add(albumInfo);
                        i4++;
                        str6 = str11;
                        jSONArrayOptJSONArray = jSONArray5;
                    }
                    str2 = str6;
                }
                int iOptInt2 = jSONObjectOptJSONObject.optInt("rating");
                this.ratings[i3] = iOptInt2;
                if (iOptInt2 == -1) {
                    this.exact = true;
                }
                KGHunterSong kGHunterSong = new KGHunterSong();
                kGHunterSong.setTrackId(strOptString3);
                kGHunterSong.setMixSongId(iOptInt);
                kGHunterSong.setSongName(strOptString2);
                kGHunterSong.setSinger(strOptString);
                kGHunterSong.setAlbums(arrayList3);
                String strOptString6 = jSONObjectOptJSONObject.optString("hash_128");
                String strOptString7 = jSONObjectOptJSONObject.optString("hash_192");
                String strOptString8 = jSONObjectOptJSONObject.optString("hash_320");
                int i5 = i3;
                if (!TextUtils.isEmpty(strOptString6)) {
                    kGHunterSong.setHashValue(strOptString6.toLowerCase());
                    kGHunterSong.setDuration(jSONObjectOptJSONObject.optLong("timelength_128"));
                    long jOptLong = jSONObjectOptJSONObject.optLong("filesize_128");
                    if (jOptLong > 0) {
                        kGHunterSong.setSize(jOptLong);
                    }
                } else if (!TextUtils.isEmpty(strOptString7)) {
                    kGHunterSong.setHashValue(strOptString7.toLowerCase());
                    kGHunterSong.setDuration(jSONObjectOptJSONObject.optLong("timelength_192"));
                    long jOptLong2 = jSONObjectOptJSONObject.optLong("filesize_192");
                    if (jOptLong2 > 0) {
                        kGHunterSong.setSize(jOptLong2);
                    }
                } else {
                    if (TextUtils.isEmpty(strOptString8)) {
                        return;
                    }
                    kGHunterSong.setHashValue(strOptString8.toLowerCase());
                    kGHunterSong.setDuration(jSONObjectOptJSONObject.optLong("timelength_320"));
                    long jOptLong3 = jSONObjectOptJSONObject.optLong("filesize_320");
                    if (jOptLong3 > 0) {
                        kGHunterSong.setSize(jOptLong3);
                    }
                }
                try {
                    int[] iArr = new int[3];
                    iArr[0] = 0;
                    iArr[1] = 0;
                    iArr[2] = 0;
                    if (!jSONObjectOptJSONObject.isNull(str8) && !jSONObjectOptJSONObject.isNull(str7)) {
                        int i6 = jSONObjectOptJSONObject.getInt(str8);
                        iArr[i6 == 4 ? (char) 1 : i6 == 5 ? (char) 2 : (char) 0] = jSONObjectOptJSONObject.getInt(str7);
                        if (!jSONObjectOptJSONObject.isNull(str5) && (length = (jSONArray = jSONObjectOptJSONObject.getJSONArray(str5)).length()) > 0) {
                            int i7 = 0;
                            while (i7 < length) {
                                JSONObject jSONObject2 = jSONArray.getJSONObject(i7);
                                if (jSONObject2.isNull(str8) || jSONObject2.isNull(str7)) {
                                    jSONArray2 = jSONArray;
                                } else {
                                    int i8 = jSONObject2.getInt(str8);
                                    jSONArray2 = jSONArray;
                                    iArr[i8 == 4 ? (char) 1 : i8 == 5 ? (char) 2 : (char) 0] = jSONObject2.getInt(str7);
                                }
                                i7++;
                                jSONArray = jSONArray2;
                            }
                        }
                        try {
                            kGHunterSong.setMusicCharge(iArr[0], iArr[1], iArr[2]);
                        } catch (Exception e2) {
                            e = e2;
                            e.printStackTrace();
                        }
                    }
                } catch (Exception e3) {
                    e = e3;
                }
                String str12 = str2;
                if (jSONObjectOptJSONObject.has(str12)) {
                    try {
                        str4 = str5;
                        Double.isNaN(jSONObjectOptJSONObject.optInt(str12));
                        try {
                            kGHunterSong.setTimeOffset((int) (((r2 * 0.064d) / 60.0d) * 60000.0d));
                        } catch (Exception unused) {
                        }
                    } catch (Exception unused2) {
                        str4 = str5;
                    }
                } else {
                    str4 = str5;
                }
                String strOptString9 = jSONObjectOptJSONObject.optString("isrc", "");
                String strOptString10 = jSONObjectOptJSONObject.optString("upc", "");
                String strOptString11 = jSONObjectOptJSONObject.optString("copyright_owner", "");
                long jOptLong4 = jSONObjectOptJSONObject.optLong("timelength_128", 0L);
                if (jOptLong4 == 0) {
                    jOptLong4 = jSONObjectOptJSONObject.optLong("timelength_320", 0L);
                }
                long jOptLong5 = jOptLong4;
                if (jOptLong5 == 0) {
                    jOptLong5 = jSONObjectOptJSONObject.optLong("timelength_flac", 0L);
                }
                kGHunterSong.setIsrc(strOptString9);
                kGHunterSong.setUpc(strOptString10);
                kGHunterSong.setDuration(jOptLong5);
                kGHunterSong.setCopyrightOwner(strOptString11);
                JSONArray jSONArrayOptJSONArray2 = jSONObjectOptJSONObject.optJSONArray("composer_info");
                ArrayList arrayList4 = new ArrayList();
                String str13 = "author_name";
                String str14 = "is_publish";
                if (jSONArrayOptJSONArray2 != null && jSONArrayOptJSONArray2.length() > 0) {
                    int length3 = jSONArrayOptJSONArray2.length();
                    int i9 = 0;
                    while (i9 < length3) {
                        String str15 = str12;
                        JSONObject jSONObjectOptJSONObject2 = jSONArrayOptJSONArray2.optJSONObject(i9);
                        JSONArray jSONArray6 = jSONArrayOptJSONArray2;
                        String strOptString12 = jSONObjectOptJSONObject2.optString("is_publish", str10);
                        String str16 = str7;
                        String strOptString13 = jSONObjectOptJSONObject2.optString(str13, str10);
                        String str17 = str8;
                        String str18 = str10;
                        String str19 = str4;
                        String str20 = str13;
                        long jOptLong6 = jSONObjectOptJSONObject2.optLong("author_id", 0L);
                        String str21 = str3;
                        if (strOptString12.equals(str21) && !TextUtils.isEmpty(strOptString13)) {
                            KGHunterSong.Composer composer = new KGHunterSong.Composer();
                            composer.authorId = jOptLong6;
                            composer.authorName = strOptString13;
                            composer.isPublish = strOptString12;
                            arrayList4.add(composer);
                        }
                        i9++;
                        str3 = str21;
                        str12 = str15;
                        jSONArrayOptJSONArray2 = jSONArray6;
                        str7 = str16;
                        str4 = str19;
                        str13 = str20;
                        str8 = str17;
                        str10 = str18;
                    }
                }
                String str22 = str12;
                String str23 = str7;
                String str24 = str8;
                String str25 = str10;
                String str26 = str4;
                String str27 = str13;
                String str28 = str3;
                kGHunterSong.setComposers(arrayList4);
                JSONArray jSONArrayOptJSONArray3 = jSONObjectOptJSONObject.optJSONArray("lyrics_info");
                ArrayList arrayList5 = new ArrayList();
                if (jSONArrayOptJSONArray3 != null && jSONArrayOptJSONArray3.length() > 0) {
                    int length4 = jSONArrayOptJSONArray3.length();
                    int i10 = 0;
                    while (i10 < length4) {
                        JSONObject jSONObjectOptJSONObject3 = jSONArrayOptJSONArray3.optJSONObject(i10);
                        String str29 = str25;
                        String strOptString14 = jSONObjectOptJSONObject3.optString(str14, str29);
                        String str30 = str27;
                        String strOptString15 = jSONObjectOptJSONObject3.optString(str30, str29);
                        str25 = str29;
                        String str31 = str14;
                        str27 = str30;
                        long jOptLong7 = jSONObjectOptJSONObject3.optLong("author_id", 0L);
                        if (strOptString14.equals(str28) && !TextUtils.isEmpty(strOptString15)) {
                            KGHunterSong.LyricWriter lyricWriter = new KGHunterSong.LyricWriter();
                            lyricWriter.authorId = jOptLong7;
                            lyricWriter.authorName = strOptString15;
                            lyricWriter.isPublish = strOptString14;
                            arrayList5.add(lyricWriter);
                        }
                        i10++;
                        str14 = str31;
                    }
                }
                kGHunterSong.setLyricWriters(arrayList5);
                ArrayList<KGHunterSong> arrayList6 = arrayList;
                arrayList6.add(kGHunterSong);
                i3 = i5 + 1;
                arrayList2 = arrayList6;
                str9 = str28;
                jSONArray3 = jSONArray4;
                length2 = i2;
                str6 = str22;
                str7 = str23;
                str5 = str26;
                str8 = str24;
            }
            this.response.setSongs(arrayList2);
            this.response.setOriginalContent(str);
        } catch (Exception e4) {
            e4.printStackTrace();
            setFailed("异常：" + e4.getMessage(), 0);
        }
    }

    public void setFrom(int i2) {
        this.from = i2;
    }

    public void setFromFC(boolean z) {
        this.isFromFC = z;
    }

    public void setFromSecondLever(boolean z) {
        this.isFromSecondLever = z;
    }

    public void setFromVoiceRecognize(boolean z) {
        this.isFromVoiceRecognize = z;
    }

    public void setSuccess(boolean z) {
        this.isSuccess = z;
    }

    public RecognizeResult(boolean z) {
        this.isFake = z;
    }
}
