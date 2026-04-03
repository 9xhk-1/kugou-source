package com.kugou.android.watch.lite.common.music.entity;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import androidx.appcompat.widget.ActivityChooserModel;
import com.kugou.android.watch.lite.base.musicfees.mediastore.entity.HashOffset;
import com.kugou.android.watch.lite.base.player.entity.CommNetSongUrlInfo;
import e.c.a.g.a.f.j.c.d;
import e.c.a.g.a.s.g0;
import e.c.a.g.a.s.l1;
import e.c.a.g.a.s.r0;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class KGSong implements Parcelable, Serializable, Cloneable, r0.a {
    public static final Parcelable.Creator<KGSong> CREATOR = new a();
    public String A;
    public String A1;
    public String B;
    public int B0;
    public int B1;
    public int C;
    public int C1;
    public String D1;
    public int E;
    public int E0;
    public int E1;
    public int F;
    public int F1;
    public String G;
    public String G0;
    public long G1;
    public boolean H;
    public String H0;
    public int I;
    public int I0;
    public SingerInfo[] I1;
    public int J;
    public long K;
    public String K0;
    public RecSongInfo K1;
    public boolean L;
    public int L0;
    public ExtraInfo L1;
    public String M;
    public int M0;
    public int N;
    public int N0;
    public boolean N1;
    public int O;
    public int O0;
    public MusicCloudInfo O1;
    public String P;
    public int P0;
    public int P1;
    public String Q;
    public int Q0;
    public String R;
    public long R0;
    public long S0;
    public String T0;
    public long T1;
    public int U;
    public int U0;
    public float U1;
    public String V;
    public int V0;
    public int W;
    public String W0;
    public String W1;
    public String X;
    public int X0;
    public long X1;
    public int Y;
    public String Y0;
    public HashOffset Y1;
    public String Z;
    public String Z0;
    public String a;
    public String a0;
    public String a1;
    public long b;
    public String b0;
    public int b1;
    public String c0;
    public String c1;
    public String d0;
    public String d1;
    public String e0;
    public int e1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f114f;
    public String g0;
    public String g1;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f115h;
    public String h0;
    public int h1;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f116i;
    public String i0;
    public MusicTransParamEnenty i1;
    public String j;
    public int j1;
    public int k;
    public int k0;
    public int k1;
    public String l;
    public int l0;
    public int l1;
    public String m;
    public String m0;
    public String m1;
    public long n;
    public int n0;
    public boolean n1;
    public long o;
    public boolean o0;
    public int o1;
    public long p;
    public int p0;
    public CharSequence p1;
    public int q;
    public int q0;
    public CharSequence q1;
    public String r;
    public int r0;
    public CharSequence r1;
    public int s;
    public String s0;
    public int s1;
    public String t;
    public String t0;
    public String t1;
    public String u;
    public boolean u0;
    public String u1;
    public String v;
    public boolean v0;
    public int v1;
    public String w;
    public int w1;
    public String x;
    public int x0;
    public int x1;
    public long y;
    public int y1;
    public long z;
    public String z1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f113d = -1;
    public int D = 0;
    public String S = "0";
    public int T = SongQuality.QUALITY_NONE.getType();
    public String f0 = "";
    public int j0 = 0;
    public int w0 = -1;
    public int y0 = -1;
    public int z0 = 0;
    public boolean A0 = false;
    public int C0 = -1;
    public int D0 = -1;
    public boolean F0 = false;
    public String J0 = "";
    public String f1 = "";
    public int H1 = -1;
    public int J1 = -1;
    public String M1 = "";
    public int Q1 = 0;
    public int R1 = 0;
    public int S1 = 0;
    public int V1 = -100;

    public class a implements Parcelable.Creator<KGSong> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public KGSong createFromParcel(Parcel parcel) {
            KGSong kGSong = new KGSong("未知来源");
            kGSong.f113d = parcel.readLong();
            kGSong.f114f = parcel.readLong();
            kGSong.f115h = parcel.readInt();
            kGSong.f116i = parcel.readString();
            kGSong.j = parcel.readString();
            kGSong.k = parcel.readInt();
            kGSong.q = parcel.readInt();
            kGSong.r = parcel.readString();
            kGSong.s = parcel.readInt();
            kGSong.t = parcel.readString();
            kGSong.u = parcel.readString();
            kGSong.v = parcel.readString();
            kGSong.w = parcel.readString();
            kGSong.x = parcel.readString();
            kGSong.y = parcel.readLong();
            kGSong.z = parcel.readLong();
            kGSong.A = parcel.readString();
            kGSong.B = parcel.readString();
            kGSong.C = parcel.readInt();
            kGSong.D = parcel.readInt();
            kGSong.E = parcel.readInt();
            kGSong.F = parcel.readInt();
            kGSong.G = parcel.readString();
            kGSong.H = parcel.readInt() == 1;
            kGSong.I = parcel.readInt();
            kGSong.J = parcel.readInt();
            kGSong.L = parcel.readInt() == 1;
            kGSong.M = parcel.readString();
            kGSong.N = parcel.readInt();
            kGSong.O = parcel.readInt();
            kGSong.P = parcel.readString();
            kGSong.T = parcel.readInt();
            kGSong.U = parcel.readInt();
            kGSong.Y = parcel.readInt();
            kGSong.Z = parcel.readString();
            kGSong.a0 = parcel.readString();
            kGSong.b0 = parcel.readString();
            kGSong.c0 = parcel.readString();
            kGSong.Q = parcel.readString();
            kGSong.x0 = parcel.readInt();
            kGSong.K = parcel.readLong();
            kGSong.L3(parcel.readString());
            kGSong.W = parcel.readInt();
            kGSong.X = parcel.readString();
            kGSong.z0 = parcel.readInt();
            kGSong.E0 = parcel.readInt();
            kGSong.e0 = parcel.readString();
            kGSong.K0 = parcel.readString();
            kGSong.w0 = parcel.readInt();
            kGSong.u0 = parcel.readInt() == 1;
            kGSong.r0 = parcel.readInt();
            kGSong.O0 = parcel.readInt();
            kGSong.N0 = parcel.readInt();
            kGSong.f0 = parcel.readString();
            kGSong.g0 = parcel.readString();
            kGSong.h0 = parcel.readString();
            kGSong.m0 = parcel.readString();
            kGSong.R0 = parcel.readLong();
            kGSong.A3(parcel.readInt());
            kGSong.b3(parcel.readInt());
            kGSong.f1 = parcel.readString();
            kGSong.g1 = parcel.readString();
            kGSong.h1 = parcel.readInt();
            kGSong.j1 = parcel.readInt();
            kGSong.k1 = parcel.readInt();
            kGSong.L2(parcel.readString());
            kGSong.U0 = parcel.readInt();
            kGSong.S0 = parcel.readLong();
            kGSong.V0 = parcel.readInt();
            kGSong.l1 = parcel.readInt();
            kGSong.l = parcel.readString();
            kGSong.c1 = parcel.readString();
            kGSong.n = parcel.readLong();
            kGSong.p = parcel.readLong();
            kGSong.j0 = parcel.readInt();
            kGSong.k0 = parcel.readInt();
            kGSong.l0 = parcel.readInt();
            kGSong.m1 = parcel.readString();
            kGSong.W0 = parcel.readString();
            kGSong.u1 = parcel.readString();
            kGSong.w1 = parcel.readInt();
            kGSong.x1 = parcel.readInt();
            kGSong.y1 = parcel.readInt();
            kGSong.A1 = parcel.readString();
            kGSong.B1 = parcel.readInt();
            kGSong.t0 = parcel.readString();
            kGSong.F1 = parcel.readInt();
            kGSong.E1 = parcel.readInt();
            kGSong.D1 = parcel.readString();
            kGSong.G1 = parcel.readLong();
            kGSong.P0 = parcel.readInt();
            kGSong.D0 = parcel.readInt();
            kGSong.H1 = parcel.readInt();
            kGSong.v0 = parcel.readInt() == 1;
            kGSong.X0 = parcel.readInt();
            Parcelable[] parcelableArray = parcel.readParcelableArray(SingerInfo.class.getClassLoader());
            if (parcelableArray != null) {
                kGSong.I1 = (SingerInfo[]) Arrays.copyOf(parcelableArray, parcelableArray.length, SingerInfo[].class);
            }
            kGSong.O1 = (MusicCloudInfo) parcel.readParcelable(MusicCloudInfo.class.getClassLoader());
            kGSong.n1 = parcel.readInt() == 1;
            kGSong.P4(parcel.readString());
            kGSong.U2(parcel.readInt());
            kGSong.x4(parcel.readInt());
            kGSong.T2(parcel.readInt());
            kGSong.J1 = parcel.readInt();
            kGSong.K1 = (RecSongInfo) parcel.readParcelable(RecSongInfo.class.getClassLoader());
            kGSong.M1 = parcel.readString();
            kGSong.N1 = parcel.readInt() == 1;
            kGSong.Q0 = parcel.readInt();
            kGSong.a1 = parcel.readString();
            MusicTransParamEnenty.toEntity(parcel, kGSong);
            kGSong.P1 = parcel.readInt();
            kGSong.o = parcel.readLong();
            kGSong.b1 = parcel.readInt();
            kGSong.L1 = (ExtraInfo) parcel.readParcelable(ExtraInfo.class.getClassLoader());
            kGSong.d1 = parcel.readString();
            kGSong.I0 = parcel.readInt();
            kGSong.m = parcel.readString();
            return kGSong;
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public KGSong[] newArray(int i2) {
            return new KGSong[i2];
        }
    }

    public static /* synthetic */ class b {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[SongQuality.values().length];
            a = iArr;
            try {
                iArr[SongQuality.QUALITY_SUPER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[SongQuality.QUALITY_HIGHEST.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[SongQuality.QUALITY_HIGH.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[SongQuality.QUALITY_LOW.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public KGSong(String str) {
        this.K0 = "未知来源";
        this.K0 = str;
    }

    public static SingerInfo[] K2(JSONArray jSONArray) throws JSONException {
        if (jSONArray == null) {
            return null;
        }
        int length = jSONArray.length();
        SingerInfo[] singerInfoArr = new SingerInfo[length];
        for (int i2 = 0; i2 < length; i2++) {
            singerInfoArr[i2] = SingerInfo.a(jSONArray.getJSONObject(i2));
        }
        return singerInfoArr;
    }

    public static KGSong d1(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        KGSong kGSong = new KGSong("未知来源");
        try {
            kGSong.f113d = jSONObject.optLong("id");
            kGSong.f114f = jSONObject.optLong("sysid");
            kGSong.f115h = jSONObject.optInt("type");
            kGSong.f116i = jSONObject.optString("trackName");
            kGSong.j = jSONObject.optString("albumName");
            kGSong.k = jSONObject.optInt("albumId");
            kGSong.l = jSONObject.optString("feeAlbumId");
            kGSong.c1 = jSONObject.optString("channelCommentId");
            kGSong.n = jSONObject.optLong("mixId");
            kGSong.p = jSONObject.optLong("audioId");
            kGSong.q = jSONObject.optInt("trackId");
            kGSong.r = jSONObject.optString("artistName");
            kGSong.s = jSONObject.optInt("artistId");
            kGSong.t = jSONObject.optString("genre");
            kGSong.u = jSONObject.optString("displayName");
            kGSong.v = jSONObject.optString("hashValue");
            kGSong.w = jSONObject.optString("m4aUrl");
            kGSong.x = jSONObject.optString("mvHashValue");
            kGSong.y = jSONObject.optLong("size");
            kGSong.z = jSONObject.optLong("duration");
            kGSong.A = jSONObject.optString("filePath");
            kGSong.B = jSONObject.optString("parentPath");
            kGSong.C = jSONObject.optInt("error");
            kGSong.D = jSONObject.optInt("netType");
            kGSong.E = jSONObject.optInt("playCount");
            kGSong.F = jSONObject.optInt("bitrate");
            kGSong.G = jSONObject.optString("extName");
            kGSong.H = jSONObject.optBoolean("hasMV");
            kGSong.I = jSONObject.optInt("mvTracks");
            kGSong.J = jSONObject.optInt("mvType");
            kGSong.K = jSONObject.optLong("mvMatchTime");
            kGSong.L = jSONObject.optBoolean("isCloud");
            kGSong.M = jSONObject.optString("mimeType");
            kGSong.N = jSONObject.optInt(ActivityChooserModel.ATTRIBUTE_WEIGHT);
            kGSong.O = jSONObject.optInt("fileId");
            kGSong.P = jSONObject.optString("sizeString");
            kGSong.Q = jSONObject.optString("m4aSizeString");
            kGSong.R = jSONObject.optString("highSizeString");
            kGSong.S = jSONObject.optString("sqSizeString");
            kGSong.T = jSONObject.optInt("songQuality");
            kGSong.U = jSONObject.optInt("m4aSize");
            kGSong.V = jSONObject.optString("m4aHash");
            kGSong.W = jSONObject.optInt("size_320");
            kGSong.X = jSONObject.optString("hash_320");
            kGSong.Y = jSONObject.optInt("playlistId");
            kGSong.Z = jSONObject.optString("pinyinName");
            kGSong.a0 = jSONObject.optString("pinyinNameSimple");
            kGSong.b0 = jSONObject.optString("digitName");
            kGSong.c0 = jSONObject.optString("digitNameSimple");
            kGSong.d0 = jSONObject.optString("songeTime");
            kGSong.e0 = jSONObject.optString("sqHash");
            kGSong.f0 = jSONObject.optString("imgUrl");
            kGSong.g0 = jSONObject.optString("topic");
            kGSong.h0 = jSONObject.optString("sourceType");
            kGSong.i0 = jSONObject.optString("kugouId");
            kGSong.j0 = jSONObject.optInt("authorId");
            kGSong.k0 = jSONObject.optInt("specialId");
            kGSong.l0 = jSONObject.optInt("rankId");
            kGSong.m0 = jSONObject.optString("sourceHash");
            kGSong.n0 = jSONObject.optInt("isOriginal");
            kGSong.o0 = jSONObject.optBoolean("isExclusivePublish");
            kGSong.p0 = jSONObject.optInt("first");
            kGSong.q0 = jSONObject.optInt("lyricPosition");
            kGSong.r0 = jSONObject.optInt("sqSize");
            kGSong.s0 = jSONObject.optString("originalFileName");
            kGSong.t0 = jSONObject.optString("songType");
            kGSong.u0 = jSONObject.optBoolean("isDownloaded");
            kGSong.v0 = jSONObject.optBoolean("isFileDownloaded");
            kGSong.w0 = jSONObject.optInt("feeType");
            kGSong.x0 = jSONObject.optInt("isnew");
            kGSong.z0 = jSONObject.optInt("isInsertPlay");
            kGSong.A0 = jSONObject.optBoolean("isUserPlay");
            kGSong.B0 = jSONObject.optInt("typeTitle");
            kGSong.C0 = jSONObject.optInt("downloadState");
            kGSong.D0 = jSONObject.optInt("maskOfForceDownload");
            kGSong.E0 = jSONObject.optInt("extra");
            kGSong.F0 = jSONObject.optBoolean("isFromMyAsset");
            kGSong.G0 = jSONObject.optString("freeVote");
            kGSong.H0 = jSONObject.optString("ironVote");
            kGSong.J0 = jSONObject.optString("fullName");
            kGSong.K0 = jSONObject.optString("source", "未知来源");
            kGSong.L0 = jSONObject.optInt("localListId");
            kGSong.M0 = jSONObject.optInt("listversion");
            kGSong.N0 = jSONObject.optInt("isPlaylist");
            kGSong.O0 = jSONObject.optInt("srctype");
            kGSong.P0 = jSONObject.optInt("fileEncryptType");
            kGSong.R0 = jSONObject.optLong("addtime");
            kGSong.S0 = jSONObject.optLong("accompanimentTime");
            kGSong.T0 = jSONObject.optString("accompanimentHash");
            kGSong.U0 = jSONObject.optInt("accompanimentId");
            kGSong.V0 = jSONObject.optInt("has_accompany");
            kGSong.W0 = jSONObject.optString("remark");
            kGSong.X0 = jSONObject.optInt("musicLinkSource");
            kGSong.Q1 = jSONObject.optInt("audioType");
            kGSong.R1 = jSONObject.optInt("sort");
            kGSong.S1 = jSONObject.optInt("audioIndex");
            kGSong.e1 = jSONObject.optInt("charge");
            kGSong.f1 = jSONObject.optString("module");
            kGSong.g1 = jSONObject.optString("behavior");
            kGSong.h1 = jSONObject.optInt("expire");
            kGSong.j1 = jSONObject.optInt(CommNetSongUrlInfo.FAIL_PROCESS_BUY);
            kGSong.k1 = jSONObject.optInt("songSource");
            kGSong.l1 = jSONObject.optInt("inList");
            kGSong.m1 = jSONObject.optString("curMark");
            kGSong.o1 = jSONObject.optInt("buyCount");
            kGSong.p1 = jSONObject.optString("singerBuilder");
            kGSong.q1 = jSONObject.optString("songBuilder");
            kGSong.r1 = jSONObject.optString("topicBuider");
            kGSong.s1 = jSONObject.optInt("mHighlightColor");
            kGSong.t1 = jSONObject.optString("SongName");
            kGSong.u1 = jSONObject.optString("shareContent");
            kGSong.v1 = jSONObject.optInt("mSecondaryTextColor");
            kGSong.w1 = jSONObject.optInt("isSameWithOther");
            kGSong.x1 = jSONObject.optInt("ugcReviewed");
            kGSong.y1 = jSONObject.optInt("qualityFeeSource");
            kGSong.z1 = jSONObject.optString("coverUrl");
            kGSong.A1 = jSONObject.optString("deleteHash");
            kGSong.B1 = jSONObject.optInt("code");
            kGSong.C1 = jSONObject.optInt("musicFeeStatus");
            kGSong.D1 = jSONObject.optString("musicFeeType");
            kGSong.E1 = jSONObject.optInt("failProcess");
            kGSong.F1 = jSONObject.optInt("payType");
            kGSong.G1 = jSONObject.optLong("updateFeeStatusTime");
            kGSong.H1 = jSONObject.optInt("oldCpy");
            kGSong.I1 = K2(jSONObject.optJSONArray("singerInfos"));
            kGSong.O1 = MusicCloudInfo.a(jSONObject.optJSONObject("mMusicCloudInfo"));
            kGSong.n1 = jSONObject.optBoolean("isPlayMusicCloud");
            kGSong.T1 = jSONObject.optLong("Owner");
            kGSong.U1 = (float) jSONObject.optDouble("hotValue");
            kGSong.V1 = jSONObject.optInt("mHashType");
            kGSong.W1 = jSONObject.optString("thirdSongSource");
            kGSong.X1 = jSONObject.optLong("thirdSongSourceId");
            kGSong.b = jSONObject.optLong("requestTime");
            kGSong.P1 = jSONObject.optInt("musicSource", 0);
            kGSong.a1 = jSONObject.optString("sk", "0,9");
            kGSong.o = jSONObject.optLong("oldMixId", 0L);
            kGSong.d1 = jSONObject.optString("ext_params");
            kGSong.i4(RecSongInfo.parseRecSongInfo(jSONObject.optJSONObject("recSongInfo")));
            kGSong.b1(ExtraInfo.fromJsonObj(jSONObject.optJSONObject("extraInfo")));
            kGSong.I3(jSONObject.optInt("is_publish"));
            MusicTransParamEnenty.jsonToEnenty(jSONObject, kGSong);
        } catch (JSONException e2) {
            g0.k(e2);
        }
        return kGSong;
    }

    @Deprecated
    public static KGSong e1(KGMusic kGMusic) {
        if (kGMusic == null) {
            return new KGSong("");
        }
        KGSong kGSong = new KGSong(kGMusic.getSource());
        kGSong.e3(kGMusic.getDisplayName());
        kGSong.L4(kGMusic.getTrackName());
        kGSong.K4((int) kGMusic.getTrackID());
        kGSong.P2(kGMusic.getAlbumName());
        kGSong.O2((int) kGMusic.getAlbumID());
        kGSong.R2(kGMusic.getArtistName());
        kGSong.n3(kGMusic.getFeeAlbumId());
        kGSong.a3(kGMusic.getChannelCommentId());
        kGSong.Q3(kGMusic.getMixId());
        kGSong.S2(kGMusic.getAudioId());
        kGSong.Q2((int) kGMusic.getArtistID());
        kGSong.u3(kGMusic.getGenre());
        kGSong.o4(kGMusic.getSize());
        kGSong.M3((int) kGMusic.getM4aSize());
        kGSong.B3(kGMusic.getHashValue());
        kGSong.X2(kGMusic.getBitrate());
        kGSong.g3(kGMusic.getDuration());
        kGSong.L3(kGMusic.getM4aHash());
        kGSong.N3(kGMusic.getM4aUrl());
        kGSong.C3(kGMusic.getHash320());
        kGSong.p4((int) kGMusic.getSize320());
        kGSong.C4(kGMusic.getSqHash());
        kGSong.D4((int) kGMusic.getSqSize());
        kGSong.X3(kGMusic.getMvHashValue());
        kGSong.Z3(kGMusic.getMvTracks());
        kGSong.a4(kGMusic.getMvType());
        kGSong.Y3(kGMusic.getMvMatchTime());
        kGSong.A3(kGMusic.hashType);
        kGSong.b3(kGMusic.getCharge());
        kGSong.R3(kGMusic.getModule());
        kGSong.u4(kGMusic.getSongSource());
        kGSong.L2(kGMusic.getAccompanimentHash());
        kGSong.N2(kGMusic.getAccompanimentTime());
        kGSong.M2(kGMusic.getAccompanimentId());
        kGSong.y3(kGMusic.getHas_accompany());
        kGSong.V2(kGMusic.getAuthorId());
        kGSong.B4(kGMusic.getSpecialId());
        kGSong.h4(kGMusic.getRankId());
        kGSong.E3(kGMusic.getId());
        kGSong.d3(kGMusic.getCurMark());
        kGSong.A4(kGMusic.getSourceType());
        kGSong.z4(kGMusic.getSourceHash());
        kGSong.I4(kGMusic.getTopic());
        kGSong.N4(kGMusic.getUgcReviewed());
        kGSong.g4(kGMusic.getQualityFeeSource());
        kGSong.p3((int) kGMusic.getFileId());
        kGSong.s3(kGMusic.isFromMyAsset());
        kGSong.m3(kGMusic.getFailProcess());
        kGSong.U3(kGMusic.getMusicFeeType());
        kGSong.e4(kGMusic.getPayType());
        kGSong.O4(kGMusic.getUpdateFeeStatusTime());
        kGSong.b4(kGMusic.getOldCpy());
        kGSong.d3(kGMusic.getCurMark());
        kGSong.n4(kGMusic.getSingerInfos());
        kGSong.x3(kGMusic.getGuessYouLikeMark());
        kGSong.i4(kGMusic.getRecSongInfo());
        kGSong.b1(kGMusic.getExtraInfo());
        kGSong.w3(kGMusic.getGuessYouLikeBiString());
        kGSong.T3(kGMusic.getMusicCloudInfo());
        kGSong.f4(kGMusic.isPlayMusicCloud());
        kGSong.U2(kGMusic.getAudioType());
        kGSong.x4(kGMusic.getSort());
        kGSong.T2(kGMusic.getAudioIndex());
        kGSong.setMusicTransParamEnenty(kGMusic.getMusicTransParamEnenty());
        kGSong.v3(kGMusic.getGif_id());
        kGSong.W3(kGMusic.getMusicSource());
        kGSong.q4(kGMusic.getSk());
        kGSong.k3(kGSong.v1());
        kGSong.X0 = kGMusic.musicLinkSource;
        kGSong.c1 = kGMusic.getChannelCommentId();
        return kGSong;
    }

    public static String w2(KGSong kGSong) {
        if (TextUtils.isEmpty(kGSong.t2())) {
            return null;
        }
        return kGSong.t2();
    }

    public static String x2(KGSong kGSong) {
        if (TextUtils.isEmpty(kGSong.J1())) {
            return null;
        }
        return kGSong.J1() + kGSong.u1();
    }

    public String A1() {
        String str = this.A;
        return str == null ? "" : str;
    }

    public String A2() {
        if (TextUtils.isEmpty(this.u) || !TextUtils.isEmpty(this.f116i)) {
            return this.f116i;
        }
        int iIndexOf = this.u.indexOf(" - ");
        int i2 = iIndexOf + 3;
        if (iIndexOf == -1) {
            iIndexOf = this.u.indexOf("-");
            i2 = iIndexOf + 1;
        }
        if (iIndexOf <= 0) {
            return this.u;
        }
        String str = this.u;
        return str.substring(i2, str.length()).trim();
    }

    public void A3(int i2) {
        if (i2 == 1) {
            i2 = 100;
        } else if (i2 == 0) {
            i2 = -100;
        }
        this.V1 = i2;
    }

    public void A4(String str) {
        this.h0 = str;
    }

    public String B1() {
        return this.J0;
    }

    public int B2() {
        return this.f115h;
    }

    public void B3(String str) {
        this.v = str;
    }

    public void B4(int i2) {
        this.k0 = i2;
    }

    public String C1() {
        return this.t;
    }

    public long C2() {
        return this.G1;
    }

    public void C3(String str) {
        this.X = str;
    }

    public void C4(String str) {
        this.e0 = str;
    }

    public int D1() {
        return this.y0;
    }

    public String D2() {
        return this.Z0;
    }

    public void D3(int i2) {
        this.s1 = i2;
    }

    public void D4(int i2) {
        this.r0 = i2;
        if (i2 == 0) {
            this.S = "";
        } else {
            this.S = l1.B(i2);
        }
    }

    public String E1() {
        return this.a;
    }

    public boolean E2() {
        return this.u0;
    }

    public void E3(long j) {
        this.f113d = j;
    }

    public void E4(int i2) {
        this.O0 = i2;
    }

    public String F1() {
        return this.M1;
    }

    public boolean F2() {
        return this.v0;
    }

    public void F3(String str) {
        this.f0 = str;
    }

    public void F4(String str) {
        this.m = str;
    }

    public int G1() {
        return this.J1;
    }

    public boolean G2() {
        return this.F0;
    }

    public void G3(int i2) {
        this.l1 = i2;
    }

    public void G4(String str) {
        this.W1 = str;
    }

    public HashOffset H1() {
        return this.Y1;
    }

    public boolean H2() {
        return this.z0 == 1;
    }

    public void H3(boolean z) {
        if (z) {
            this.z0 = 1;
        } else {
            this.z0 = 0;
        }
    }

    public void H4(long j) {
        this.X1 = j;
    }

    public int I1() {
        if (!TextUtils.isEmpty(K1()) || !TextUtils.isEmpty(t2())) {
            this.V1 = 300;
        }
        return this.V1;
    }

    public boolean I2() {
        return this.n1;
    }

    public void I3(int i2) {
        this.I0 = i2;
    }

    public void I4(String str) {
        this.g0 = str;
    }

    public String J1() {
        String str = this.v;
        return str == null ? "" : str.toLowerCase();
    }

    public boolean J2() {
        return this.A0;
    }

    public void J3(int i2) {
        this.x0 = i2;
    }

    public void J4(CharSequence charSequence) {
        this.r1 = charSequence;
    }

    public String K1() {
        String str = this.X;
        if (str != null) {
            return str;
        }
        return null;
    }

    public void K3(int i2) {
        this.q0 = i2;
    }

    public void K4(int i2) {
        this.q = i2;
    }

    public long L1() {
        return this.f113d;
    }

    public void L2(String str) {
        this.T0 = str;
    }

    public void L3(String str) {
        this.V = d.e(str);
    }

    public void L4(String str) {
        this.f116i = str;
    }

    public String M1() {
        return this.f0;
    }

    public void M2(int i2) {
        this.U0 = i2;
    }

    public void M3(int i2) {
        if (i2 <= 0) {
            return;
        }
        this.U = i2;
        if (i2 == 0) {
            this.Q = "";
        } else {
            this.Q = l1.B(i2);
        }
    }

    public void M4(int i2) {
        this.f115h = i2;
    }

    public int N1() {
        return this.l1;
    }

    public void N2(long j) {
        this.S0 = j;
    }

    public void N3(String str) {
        this.w = str;
    }

    public void N4(int i2) {
        this.x1 = i2;
    }

    public String O1() {
        String str = this.V;
        if (str != null) {
            return str.toLowerCase();
        }
        return null;
    }

    public void O2(int i2) {
        this.k = i2;
    }

    public void O3(int i2) {
        this.D0 = i2;
    }

    public void O4(long j) {
        this.G1 = j;
    }

    public int P1() {
        return this.U;
    }

    public void P2(String str) {
        this.j = str;
    }

    public void P3(String str) {
        this.M = str;
    }

    public void P4(String str) {
        this.Z0 = str;
    }

    public String Q1() {
        return this.w;
    }

    public void Q2(int i2) {
        this.s = i2;
    }

    public void Q3(long j) {
        if (j > 0) {
            this.n = j;
        }
    }

    public final JSONArray Q4() {
        if (this.I1 == null) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        for (SingerInfo singerInfo : this.I1) {
            if (singerInfo != null) {
                jSONArray.put(singerInfo.f());
            }
        }
        return jSONArray;
    }

    public int R1() {
        return this.D0;
    }

    public void R2(String str) {
        this.r = str;
    }

    public void R3(String str) {
        this.f1 = str;
    }

    public JSONObject R4() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("id", this.f113d);
            jSONObject.put("sysid", this.f114f);
            jSONObject.put("type", this.f115h);
            jSONObject.put("trackName", this.f116i);
            jSONObject.put("albumName", this.j);
            jSONObject.put("albumId", this.k);
            jSONObject.put("feeAlbumId", this.l);
            jSONObject.put("channelCommentId", this.c1);
            jSONObject.put("mixId", this.n);
            jSONObject.put("audioId", this.p);
            jSONObject.put("trackId", this.q);
            jSONObject.put("artistName", this.r);
            jSONObject.put("artistId", this.s);
            jSONObject.put("genre", this.t);
            jSONObject.put("displayName", this.u);
            jSONObject.put("hashValue", this.v);
            jSONObject.put("m4aUrl", this.w);
            jSONObject.put("mvHashValue", this.x);
            jSONObject.put("size", this.y);
            jSONObject.put("duration", this.z);
            jSONObject.put("filePath", this.A);
            jSONObject.put("parentPath", this.B);
            jSONObject.put("error", this.C);
            jSONObject.put("netType", this.D);
            jSONObject.put("playCount", this.E);
            jSONObject.put("bitrate", this.F);
            jSONObject.put("extName", this.G);
            jSONObject.put("hasMV", this.H);
            jSONObject.put("mvTracks", this.I);
            jSONObject.put("mvType", this.J);
            jSONObject.put("mvMatchTime", this.K);
            jSONObject.put("isCloud", this.L);
            jSONObject.put("mimeType", this.M);
            jSONObject.put(ActivityChooserModel.ATTRIBUTE_WEIGHT, this.N);
            jSONObject.put("fileId", this.O);
            jSONObject.put("sizeString", this.P);
            jSONObject.put("m4aSizeString", this.Q);
            jSONObject.put("highSizeString", this.R);
            jSONObject.put("sqSizeString", this.S);
            jSONObject.put("songQuality", this.T);
            jSONObject.put("m4aSize", this.U);
            jSONObject.put("m4aHash", this.V);
            jSONObject.put("size_320", this.W);
            jSONObject.put("hash_320", this.X);
            jSONObject.put("playlistId", this.Y);
            jSONObject.put("pinyinName", this.Z);
            jSONObject.put("pinyinNameSimple", this.a0);
            jSONObject.put("digitName", this.b0);
            jSONObject.put("digitNameSimple", this.c0);
            jSONObject.put("songeTime", this.d0);
            jSONObject.put("sqHash", this.e0);
            jSONObject.put("imgUrl", this.f0);
            jSONObject.put("topic", this.g0);
            jSONObject.put("sourceType", this.h0);
            jSONObject.put("kugouId", this.i0);
            jSONObject.put("authorId", this.j0);
            jSONObject.put("specialId", this.k0);
            jSONObject.put("rankId", this.l0);
            jSONObject.put("sourceHash", this.m0);
            jSONObject.put("isOriginal", this.n0);
            jSONObject.put("isExclusivePublish", this.o0);
            jSONObject.put("first", this.p0);
            jSONObject.put("lyricPosition", this.q0);
            jSONObject.put("sqSize", this.r0);
            jSONObject.put("originalFileName", this.s0);
            jSONObject.put("songType", this.t0);
            jSONObject.put("isDownloaded", this.u0);
            jSONObject.put("isFileDownloaded", this.v0);
            jSONObject.put("feeType", this.w0);
            jSONObject.put("isnew", this.x0);
            jSONObject.put("isInsertPlay", this.z0);
            jSONObject.put("isUserPlay", this.A0);
            jSONObject.put("typeTitle", this.B0);
            jSONObject.put("downloadState", this.C0);
            jSONObject.put("maskOfForceDownload", this.D0);
            jSONObject.put("extra", this.E0);
            jSONObject.put("isFromMyAsset", this.F0);
            jSONObject.put("freeVote", this.G0);
            jSONObject.put("ironVote", this.H0);
            jSONObject.put("fullName", this.J0);
            jSONObject.put("source", this.K0);
            jSONObject.put("localListId", this.L0);
            jSONObject.put("listversion", this.M0);
            jSONObject.put("isPlaylist", this.N0);
            jSONObject.put("srctype", this.O0);
            jSONObject.put("fileEncryptType", this.P0);
            jSONObject.put("addtime", this.R0);
            jSONObject.put("accompanimentTime", this.S0);
            jSONObject.put("accompanimentHash", this.T0);
            jSONObject.put("accompanimentId", this.U0);
            jSONObject.put("has_accompany", this.V0);
            jSONObject.put("remark", this.W0);
            jSONObject.put("musicLinkSource", this.X0);
            jSONObject.put("audioType", this.Q1);
            jSONObject.put("sort", this.R1);
            jSONObject.put("audioIndex", this.S1);
            jSONObject.put("charge", this.e1);
            jSONObject.put("module", this.f1);
            jSONObject.put("behavior", this.g1);
            jSONObject.put("expire", this.h1);
            jSONObject.put(CommNetSongUrlInfo.FAIL_PROCESS_BUY, this.j1);
            jSONObject.put("songSource", this.k1);
            jSONObject.put("inList", this.l1);
            jSONObject.put("curMark", this.m1);
            jSONObject.put("buyCount", this.o1);
            jSONObject.put("singerBuilder", this.p1);
            jSONObject.put("songBuilder", this.q1);
            jSONObject.put("topicBuider", this.r1);
            jSONObject.put("mHighlightColor", this.s1);
            jSONObject.put("SongName", this.t1);
            jSONObject.put("shareContent", this.u1);
            jSONObject.put("mSecondaryTextColor", this.v1);
            jSONObject.put("isSameWithOther", this.w1);
            jSONObject.put("ugcReviewed", this.x1);
            jSONObject.put("qualityFeeSource", this.y1);
            jSONObject.put("coverUrl", this.z1);
            jSONObject.put("deleteHash", this.A1);
            jSONObject.put("code", this.B1);
            jSONObject.put("musicFeeStatus", this.C1);
            jSONObject.put("musicFeeType", this.D1);
            jSONObject.put("failProcess", this.E1);
            jSONObject.put("payType", this.F1);
            jSONObject.put("updateFeeStatusTime", this.G1);
            jSONObject.put("oldCpy", this.H1);
            jSONObject.put("singerInfos", Q4());
            MusicCloudInfo musicCloudInfo = this.O1;
            jSONObject.put("mMusicCloudInfo", musicCloudInfo == null ? null : musicCloudInfo.n());
            jSONObject.put("isPlayMusicCloud", this.n1);
            jSONObject.put("Owner", this.T1);
            jSONObject.put("hotValue", this.U1);
            jSONObject.put("mHashType", this.V1);
            jSONObject.put("thirdSongSource", this.W1);
            jSONObject.put("thirdSongSourceId", this.X1);
            jSONObject.put("requestTime", this.b);
            jSONObject.put("musicSource", this.P1);
            jSONObject.put("sk", this.a1);
            jSONObject.put("oldMixId", this.o);
            if (w1() != null) {
                jSONObject.put("extraInfo", w1().toJsonObj());
            }
            jSONObject.put("ext_params", this.d1);
            jSONObject.put("is_publish", this.I0);
            MusicTransParamEnenty.toJSONObject(jSONObject, this);
        } catch (JSONException e2) {
            g0.k(e2);
        }
        return jSONObject;
    }

    public String S1() {
        String str = this.M;
        return str == null ? "" : str;
    }

    public void S2(long j) {
        this.p = j;
    }

    public void S3(int i2, int i3, int i4) {
        this.e1 = i2 + (i3 << 4) + (i4 << 8);
    }

    @Deprecated
    public KGMusic S4() {
        KGMusic kGMusic = new KGMusic(this.K0);
        kGMusic.setSid(-1L);
        kGMusic.setDisplayName(s1());
        kGMusic.setTrackName(A2());
        kGMusic.setAlbumName(g1());
        kGMusic.setAlbumID(f1());
        kGMusic.setTrackID(z2());
        kGMusic.setArtistName(j1());
        kGMusic.setFeeAlbumId(y1());
        kGMusic.setChannelCommentId(p1());
        kGMusic.setMixId(T1());
        kGMusic.setAudioId(k1());
        kGMusic.setGenre(C1());
        kGMusic.setArtistID(i1());
        kGMusic.setSize(i2());
        kGMusic.setHashValue(J1());
        kGMusic.setBitrate(o1());
        kGMusic.setDuration(t1());
        kGMusic.setM4aHash(O1());
        kGMusic.setM4aSize(P1());
        kGMusic.setM4aUrl(Q1());
        kGMusic.setHash320(K1());
        kGMusic.setSize320(j2());
        kGMusic.setSqHash(t2());
        kGMusic.setSqSize(u2());
        kGMusic.setMvHashValue(Y1());
        kGMusic.setMvTracks(a2());
        kGMusic.setMvType(b2());
        kGMusic.setMvMatchTime(Z1());
        kGMusic.setHashType(I1());
        kGMusic.setImgUrl(M1());
        if (TextUtils.isEmpty(kGMusic.getImgUrl())) {
            kGMusic.setImgUrl(r1());
        }
        kGMusic.setSourceType(this.h0);
        kGMusic.setCharge(q1());
        kGMusic.setBehavior(n1());
        kGMusic.setModule(this.f1);
        kGMusic.setSongSource(n2());
        kGMusic.setAccompanimentHash(this.T0);
        kGMusic.setAccompanimentTime(this.S0);
        kGMusic.setAccompanimentId(this.U0);
        kGMusic.setHas_accompany(this.V0);
        kGMusic.setInList(N1());
        kGMusic.setAuthorId(this.j0);
        kGMusic.setSpecialId(this.k0);
        kGMusic.setRankId(this.l0);
        kGMusic.setId(this.f113d);
        kGMusic.setCurMark(this.m1);
        kGMusic.setRemark(this.W0);
        kGMusic.setSourceHash(this.m0);
        kGMusic.setFileId(this.O);
        kGMusic.setTopic(y2());
        kGMusic.setUgcReviewed(this.x1);
        kGMusic.setQualityFeeSource(this.y1);
        kGMusic.setFromMyAsset(this.F0);
        kGMusic.setSongType(this.t0);
        kGMusic.setFailProcess(this.E1);
        kGMusic.setPayType(this.F1);
        kGMusic.setMusicFeeType(this.D1);
        kGMusic.setUpdateFeeStatusTime(this.G1);
        kGMusic.setMaskOfForceDownload(this.D0);
        kGMusic.setOldCpy(this.H1);
        kGMusic.setUserPlay(this.A0);
        kGMusic.musicLinkSource = this.X0;
        kGMusic.setSingerInfos(g2());
        kGMusic.setGuessYouLikeMark(G1());
        kGMusic.setRecSongInfo(f2());
        kGMusic.applyExtraInfo(w1());
        kGMusic.setGuessYouLikeBiString(F1());
        kGMusic.setMusicCloudInfo(U1());
        kGMusic.applyExtraInfo(w1());
        kGMusic.setPlayMusicCloud(I2());
        kGMusic.setmSpecialOrAlbumName(D2());
        kGMusic.setAudioType(m1());
        kGMusic.setSort(p2());
        kGMusic.setAudioIndex(l1());
        kGMusic.setMusicTransParamEnenty(getMusicTransParamEnenty());
        kGMusic.setGif_id(D1());
        kGMusic.setMusicSource(X1());
        kGMusic.setSk(k2());
        kGMusic.setMusicLinkExtInfo(W1());
        kGMusic.setExtParams(v1());
        kGMusic.setGlobalCollectionId(E1());
        return kGMusic;
    }

    public long T1() {
        return (U1() == null || TextUtils.isEmpty(U1().c()) || U1().f() <= 0) ? this.n : U1().f();
    }

    public void T2(int i2) {
        this.S1 = i2;
    }

    public void T3(MusicCloudInfo musicCloudInfo) {
        this.O1 = musicCloudInfo;
    }

    public MusicCloudInfo U1() {
        return this.O1;
    }

    public void U2(int i2) {
        this.Q1 = i2;
    }

    public void U3(String str) {
        this.D1 = str;
    }

    public String V1() {
        return this.D1;
    }

    public void V2(int i2) {
        this.j0 = i2;
    }

    public void V3(String str) {
        this.Y0 = str;
    }

    public String W1() {
        return this.Y0;
    }

    public void W2(String str) {
        this.g1 = str;
    }

    public void W3(int i2) {
        this.P1 = i2;
    }

    public int X1() {
        return this.P1;
    }

    public void X2(int i2) {
        if (i2 <= 0) {
            i2 = (!"mp3".equals(this.G) && "m4a".equals(this.G)) ? 64 : 128;
        }
        this.F = i2;
        if (this.T == SongQuality.QUALITY_NONE.getType()) {
            this.T = d.a(i2, u1());
        }
    }

    public void X3(String str) {
        this.x = str;
    }

    public String Y1() {
        return this.x;
    }

    public void Y2(int i2) {
        this.j1 = i2;
    }

    public void Y3(long j) {
        this.K = j;
    }

    public long Z1() {
        return this.K;
    }

    public void Z2(int i2) {
        this.o1 = i2;
    }

    public void Z3(int i2) {
        this.I = i2;
    }

    public int a2() {
        return this.I;
    }

    public void a3(String str) {
        this.c1 = str;
    }

    public void a4(int i2) {
        this.J = i2;
    }

    public void b1(ExtraInfo extraInfo) {
        ExtraInfo extraInfo2 = this.L1;
        if (extraInfo2 == null) {
            this.L1 = extraInfo;
        } else {
            extraInfo2.apply(extraInfo);
        }
    }

    public int b2() {
        return this.J;
    }

    public void b3(int i2) {
        this.e1 = i2;
    }

    public void b4(int i2) {
        this.H1 = i2;
    }

    /* JADX INFO: renamed from: c1, reason: merged with bridge method [inline-methods] */
    public KGSong clone() {
        try {
            return (KGSong) super.clone();
        } catch (CloneNotSupportedException unused) {
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0046  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.kugou.android.watch.lite.common.music.entity.SongQuality c2(com.kugou.android.watch.lite.common.music.entity.SongQuality r2) {
        /*
            r1 = this;
            int[] r0 = com.kugou.android.watch.lite.common.music.entity.KGSong.b.a
            int r2 = r2.ordinal()
            r2 = r0[r2]
            r0 = 1
            if (r2 == r0) goto L15
            r0 = 2
            if (r2 == r0) goto L22
            r0 = 3
            if (r2 == r0) goto L2f
            r0 = 4
            if (r2 == r0) goto L3c
            goto L49
        L15:
            java.lang.String r2 = r1.t2()
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L22
            com.kugou.android.watch.lite.common.music.entity.SongQuality r2 = com.kugou.android.watch.lite.common.music.entity.SongQuality.QUALITY_SUPER
            return r2
        L22:
            java.lang.String r2 = r1.K1()
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L2f
            com.kugou.android.watch.lite.common.music.entity.SongQuality r2 = com.kugou.android.watch.lite.common.music.entity.SongQuality.QUALITY_HIGHEST
            return r2
        L2f:
            java.lang.String r2 = r1.J1()
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L3c
            com.kugou.android.watch.lite.common.music.entity.SongQuality r2 = com.kugou.android.watch.lite.common.music.entity.SongQuality.QUALITY_HIGH
            return r2
        L3c:
            java.lang.String r2 = r1.J1()
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L49
            com.kugou.android.watch.lite.common.music.entity.SongQuality r2 = com.kugou.android.watch.lite.common.music.entity.SongQuality.QUALITY_LOW
            return r2
        L49:
            com.kugou.android.watch.lite.common.music.entity.SongQuality r2 = com.kugou.android.watch.lite.common.music.entity.SongQuality.QUALITY_NONE
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kugou.android.watch.lite.common.music.entity.KGSong.c2(com.kugou.android.watch.lite.common.music.entity.SongQuality):com.kugou.android.watch.lite.common.music.entity.SongQuality");
    }

    public void c3(String str) {
        this.z1 = str;
    }

    public void c4(int i2) {
        this.n0 = i2;
    }

    public int d2() {
        return this.H1;
    }

    public void d3(String str) {
        this.m1 = str;
    }

    public void d4(long j) {
        this.T1 = j;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int e2() {
        return this.F1;
    }

    public void e3(String str) {
        this.u = str;
    }

    public void e4(int i2) {
        this.F1 = i2;
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof KGSong)) {
            return false;
        }
        KGSong kGSong = (KGSong) obj;
        if (this.n > 0 && kGSong.T1() > 0) {
            return this.n == kGSong.T1();
        }
        if (this.n > 0 || kGSong.T1() > 0) {
            return false;
        }
        if (TextUtils.isEmpty(this.v) || TextUtils.isEmpty(kGSong.J1()) || TextUtils.isEmpty(this.G) || TextUtils.isEmpty(kGSong.u1()) || TextUtils.isEmpty(this.u)) {
            return (this.f113d == -1 || kGSong.L1() == -1 || this.f113d != kGSong.L1()) ? false : true;
        }
        boolean z2 = this.v.equals(kGSong.J1()) && this.G.equals(kGSong.u1()) && this.u.equals(kGSong.s1());
        long j = this.n;
        if (j <= 0) {
            return z2;
        }
        if (z2 && j == kGSong.n) {
            z = true;
        }
        return z;
    }

    public int f1() {
        return this.k;
    }

    public RecSongInfo f2() {
        return this.K1;
    }

    public void f3(boolean z) {
        this.u0 = z;
    }

    public void f4(boolean z) {
        this.n1 = z;
    }

    public String g1() {
        return this.j;
    }

    public SingerInfo[] g2() {
        return this.I1;
    }

    public void g3(long j) {
        this.z = j;
        if (P1() <= 0) {
            M3(((((int) j) / 1000) * 32000) / 8);
        }
    }

    public void g4(int i2) {
        this.y1 = i2;
    }

    @Override // e.c.a.g.a.s.r0.a
    public MusicTransParamEnenty getMusicTransParamEnenty() {
        return this.i1;
    }

    public String h1() {
        if (!TextUtils.isEmpty(this.u) && ("未知歌手".equals(this.r) || TextUtils.isEmpty(this.r))) {
            int iIndexOf = this.u.indexOf(" - ");
            if (iIndexOf == -1) {
                iIndexOf = this.u.indexOf("-");
            }
            if (iIndexOf > 0) {
                this.r = this.u.substring(0, iIndexOf).trim();
            }
        }
        return TextUtils.isEmpty(this.r) ? "未知歌手" : this.r;
    }

    public String[] h2() {
        SingerInfo[] singerInfoArr = this.I1;
        if (singerInfoArr == null || singerInfoArr.length <= 0) {
            return !TextUtils.isEmpty(this.r) ? this.r.split("、") : new String[0];
        }
        ArrayList arrayList = new ArrayList(this.I1.length);
        for (SingerInfo singerInfo : this.I1) {
            if (!TextUtils.isEmpty(singerInfo.c())) {
                arrayList.add(singerInfo.c());
            }
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public void h3(boolean z) {
        this.o0 = z;
    }

    public void h4(int i2) {
        this.l0 = i2;
    }

    public int hashCode() {
        long j = this.n;
        int i2 = (int) (j ^ (j >>> 32));
        return !TextUtils.isEmpty(this.v) ? (i2 * 31) + this.v.hashCode() : i2;
    }

    public int i1() {
        return this.s;
    }

    public long i2() {
        return this.y;
    }

    public void i3(int i2) {
        this.h1 = i2;
    }

    public void i4(RecSongInfo recSongInfo) {
        String str;
        this.K1 = recSongInfo;
        if (recSongInfo == null || (str = recSongInfo.alg_path) == null) {
            return;
        }
        w3(str);
    }

    public String j1() {
        if (!TextUtils.isEmpty(this.u) && ("未知歌手".equals(this.r) || TextUtils.isEmpty(this.r))) {
            int iIndexOf = this.u.indexOf(" - ");
            if (iIndexOf == -1) {
                iIndexOf = this.u.indexOf("-");
            }
            if (iIndexOf > 0) {
                if (this.u.contains("、")) {
                    this.r = this.u.substring(0, this.u.indexOf("、")).trim();
                } else {
                    this.r = this.u.substring(0, iIndexOf).trim();
                }
            }
        }
        return TextUtils.isEmpty(this.r) ? "未知歌手" : this.r;
    }

    public int j2() {
        return this.W;
    }

    public void j3(String str) {
        this.G = str;
    }

    public void j4(String str) {
        this.W0 = str;
    }

    public long k1() {
        return this.p;
    }

    public String k2() {
        return this.a1;
    }

    public void k3(String str) {
        this.d1 = str;
    }

    public void k4(long j) {
        this.b = j;
    }

    public int l1() {
        return this.S1;
    }

    public String l2() {
        return this.t1;
    }

    public void l3(int i2) {
        this.E0 = i2;
    }

    public void l4(int i2) {
        this.v1 = i2;
    }

    public int m1() {
        return this.Q1;
    }

    public int m2() {
        return this.T;
    }

    public void m3(int i2) {
        this.E1 = i2;
    }

    public void m4(CharSequence charSequence) {
        this.p1 = charSequence;
    }

    public String n1() {
        return this.g1;
    }

    public int n2() {
        return this.k1;
    }

    public void n3(String str) {
        this.l = str;
    }

    public void n4(SingerInfo[] singerInfoArr) {
        this.I1 = singerInfoArr;
    }

    public int o1() {
        return this.F;
    }

    public String o2() {
        return this.t0;
    }

    public void o3(int i2) {
        this.w0 = i2;
    }

    public void o4(long j) {
        this.y = j;
        this.P = l1.B(j);
    }

    public String p1() {
        return this.c1;
    }

    public int p2() {
        return this.R1;
    }

    public void p3(int i2) {
        this.O = i2;
    }

    public void p4(int i2) {
        this.W = i2;
        if (i2 == 0) {
            this.R = "";
        } else {
            this.R = l1.B(i2);
        }
    }

    public int q1() {
        return this.e1;
    }

    public String q2() {
        if (TextUtils.isEmpty(this.K0)) {
            this.K0 = "未知来源";
        }
        return this.K0;
    }

    public void q3(String str) {
        this.A = str;
    }

    public void q4(String str) {
        this.a1 = str;
    }

    public String r1() {
        return this.z1;
    }

    public String r2() {
        return this.m0;
    }

    public void r3(int i2) {
        this.p0 = i2;
    }

    public void r4(CharSequence charSequence) {
        this.q1 = charSequence;
    }

    public String s1() {
        return this.u;
    }

    public String s2() {
        if (TextUtils.isEmpty(this.h0)) {
            this.h0 = "3";
        }
        return this.h0;
    }

    public void s3(boolean z) {
        this.F0 = z;
    }

    public void s4(String str) {
        this.t1 = str;
    }

    @Override // e.c.a.g.a.s.r0.a
    public void setMusicTransParamEnenty(MusicTransParamEnenty musicTransParamEnenty) {
        this.i1 = musicTransParamEnenty;
    }

    public long t1() {
        return this.z;
    }

    public String t2() {
        String str = this.e0;
        return str == null ? "" : str.toLowerCase();
    }

    public void t3(String str) {
        this.J0 = str;
    }

    public void t4(int i2) {
        this.T = i2;
    }

    public String u1() {
        String str = this.G;
        return str == null ? "" : str;
    }

    public int u2() {
        return this.r0;
    }

    public void u3(String str) {
        this.t = str;
    }

    public void u4(int i2) {
        this.k1 = i2;
    }

    public String v1() {
        return this.d1;
    }

    @Nullable
    public String v2() {
        return this.m;
    }

    public void v3(int i2) {
        this.y0 = i2;
    }

    public void v4(String str) {
        this.t0 = str;
    }

    public ExtraInfo w1() {
        return this.L1;
    }

    public void w3(String str) {
        this.M1 = str;
    }

    public void w4(String str) {
        this.d0 = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeLong(this.f113d);
        parcel.writeLong(this.f114f);
        parcel.writeInt(this.f115h);
        parcel.writeString(this.f116i);
        parcel.writeString(this.j);
        parcel.writeInt(this.k);
        parcel.writeInt(this.q);
        parcel.writeString(this.r);
        parcel.writeInt(this.s);
        parcel.writeString(this.t);
        parcel.writeString(this.u);
        parcel.writeString(this.v);
        parcel.writeString(this.w);
        parcel.writeString(this.x);
        parcel.writeLong(this.y);
        parcel.writeLong(this.z);
        parcel.writeString(this.A);
        parcel.writeString(this.B);
        parcel.writeInt(this.C);
        parcel.writeInt(this.D);
        parcel.writeInt(this.E);
        parcel.writeInt(this.F);
        parcel.writeString(this.G);
        parcel.writeInt(this.H ? 1 : 0);
        parcel.writeInt(this.I);
        parcel.writeInt(this.J);
        parcel.writeInt(this.L ? 1 : 0);
        parcel.writeString(this.M);
        parcel.writeInt(this.N);
        parcel.writeInt(this.O);
        parcel.writeString(this.P);
        parcel.writeInt(this.T);
        parcel.writeInt(this.U);
        parcel.writeInt(this.Y);
        parcel.writeString(this.Z);
        parcel.writeString(this.a0);
        parcel.writeString(this.b0);
        parcel.writeString(this.c0);
        parcel.writeString(this.Q);
        parcel.writeInt(this.x0);
        parcel.writeLong(this.K);
        parcel.writeString(this.V);
        parcel.writeInt(this.W);
        parcel.writeString(this.X);
        parcel.writeInt(this.z0);
        parcel.writeInt(this.E0);
        parcel.writeString(this.e0);
        parcel.writeString(this.K0);
        parcel.writeInt(this.w0);
        parcel.writeInt(this.u0 ? 1 : 0);
        parcel.writeInt(this.r0);
        parcel.writeInt(this.O0);
        parcel.writeInt(this.N0);
        parcel.writeString(this.f0);
        parcel.writeString(this.g0);
        parcel.writeString(this.h0);
        parcel.writeString(this.m0);
        parcel.writeLong(this.R0);
        parcel.writeInt(this.V1);
        parcel.writeInt(this.e1);
        parcel.writeString(this.f1);
        parcel.writeString(this.g1);
        parcel.writeInt(this.h1);
        parcel.writeInt(this.j1);
        parcel.writeInt(this.k1);
        parcel.writeString(this.T0);
        parcel.writeLong(this.S0);
        parcel.writeInt(this.U0);
        parcel.writeInt(this.V0);
        parcel.writeInt(this.l1);
        parcel.writeString(this.l);
        parcel.writeString(this.c1);
        parcel.writeLong(this.n);
        parcel.writeLong(this.p);
        parcel.writeInt(this.j0);
        parcel.writeInt(this.k0);
        parcel.writeInt(this.l0);
        parcel.writeString(this.m1);
        parcel.writeString(this.W0);
        parcel.writeString(this.u1);
        parcel.writeInt(this.w1);
        parcel.writeInt(this.x1);
        parcel.writeInt(this.y1);
        parcel.writeString(this.A1);
        parcel.writeInt(this.B1);
        parcel.writeString(this.t0);
        parcel.writeInt(this.F1);
        parcel.writeInt(this.E1);
        parcel.writeString(this.D1);
        parcel.writeLong(this.G1);
        parcel.writeInt(this.P0);
        parcel.writeInt(this.D0);
        parcel.writeInt(this.H1);
        parcel.writeInt(this.v0 ? 1 : 0);
        parcel.writeInt(this.X0);
        parcel.writeParcelableArray(this.I1, i2);
        parcel.writeParcelable(this.O1, i2);
        parcel.writeInt(this.n1 ? 1 : 0);
        parcel.writeString(this.Z0);
        parcel.writeInt(this.Q1);
        parcel.writeInt(this.R1);
        parcel.writeInt(this.S1);
        parcel.writeInt(this.J1);
        parcel.writeParcelable(this.K1, i2);
        parcel.writeString(this.M1);
        parcel.writeInt(this.N1 ? 1 : 0);
        parcel.writeInt(this.Q0);
        parcel.writeString(this.a1);
        MusicTransParamEnenty.toParcel(parcel, i2, this);
        parcel.writeInt(this.P1);
        parcel.writeLong(this.o);
        parcel.writeInt(this.b1);
        parcel.writeParcelable(this.L1, i2);
        parcel.writeString(this.d1);
        parcel.writeInt(this.I0);
        parcel.writeString(this.m);
    }

    public int x1() {
        return this.E1;
    }

    public void x3(int i2) {
        this.J1 = i2;
    }

    public void x4(int i2) {
        this.R1 = i2;
    }

    public String y1() {
        return this.l;
    }

    public String y2() {
        return this.g0;
    }

    public void y3(int i2) {
        this.V0 = i2;
    }

    public void y4(String str) {
        this.K0 = str;
    }

    public int z1() {
        return this.O;
    }

    public int z2() {
        return this.q;
    }

    public void z3(HashOffset hashOffset) {
        this.Y1 = hashOffset;
    }

    public void z4(String str) {
        this.m0 = str;
    }
}
