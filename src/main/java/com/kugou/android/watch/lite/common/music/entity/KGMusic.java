package com.kugou.android.watch.lite.common.music.entity;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;
import com.kugou.android.watch.lite.common.INoGuard;
import com.kugou.framework.lyric.loader.KrcLoader;
import com.tme.fireeye.crash.comm.db.DbOpenHelper;
import e.c.a.g.a.d.f.c.a.i;
import e.c.a.g.a.f.j.a.e;
import e.c.a.g.a.f.j.c.d;
import e.c.a.g.a.s.g0;
import e.c.a.g.a.s.h1;
import e.c.a.g.a.s.p1;
import e.c.a.g.a.s.r0;
import e.c.c.o.f;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@Entity(tableName = "kugou_songs")
@i(tableName = "kugou_songs")
public class KGMusic implements Parcelable, Serializable, Cloneable, r0.a, INoGuard {
    public static final int CAN_DOWNLOAD_FALSE = 2;
    public static final int CAN_DOWNLOAD_TRUE = 1;
    public static final int CAN_DOWNLOAD_UNKNOWN = 0;
    public static final int MUSIC_DOWNLOADED = 1;
    public static final int MUSIC_DOWNLOADING = 2;
    public static final int MUSIC_DOWNLOAD_UNKNOWN = 0;
    public static final int MUSIC_NOT_DOWNLOAD = 3;
    public static final String MUSIC_SOURCE_CLOUD = "网络收藏";
    public static final String MUSIC_SOURCE_INNER_PAGE = "内嵌页";
    public static final int TYPE_SRC_LYC = 2;
    public static final int TYPE_SRC_MUSIC = 1;
    private static final long serialVersionUID = -5837004380001017968L;
    public String accompanimentHash;
    public int accompanimentId;
    public long accompanimentTime;

    @ColumnInfo(name = "album_id")
    public long albumID;
    public long albumMatchTime;

    @ColumnInfo(name = "albumName")
    public String albumName;

    @ColumnInfo(name = "artist_id")
    public long artistID;

    @ColumnInfo(name = "artistName")
    public String artistName;

    @ColumnInfo(name = "audioId")
    public long audioId;
    private int audioIndex;
    private int audioType;
    private int audition;
    private int authorId;
    public String behavior;

    @ColumnInfo(name = "bitrate")
    public int bitrate;
    private String brief;
    public String channelCommentId;
    public int charge;
    public long collectTime;

    @ColumnInfo(name = "cur_remark")
    public String curMark;

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = DbOpenHelper.ID)
    public long dbId;

    @ColumnInfo(name = "display_name")
    public String displayName;

    @ColumnInfo(name = "duration")
    public long duration;
    public String extParams;

    @Ignore
    public int extUniqueId;
    public String extname;

    @Ignore
    private ExtraInfo extraInfo;
    public int failProcess;

    @ColumnInfo(name = "feeAlbumId")
    public String feeAlbumId;

    @ColumnInfo(name = "feeType")
    public int feeType;
    private int fileEncryptType;
    public long fileId;
    public int fileOrderWeight;
    private boolean fromLocalMusic;

    @ColumnInfo(name = "fullName")
    public String fullName;

    @ColumnInfo(name = "genre")
    public String genre;
    public int genreId;
    private int gif_id;
    private String globalCollectionId;
    private String guessYouLikeBiString;
    private int guessYouLikeMark;
    public int has_accompany;
    public String hash320;
    public int hashType;

    @ColumnInfo(name = "hashValue")
    public String hashValue;
    public long id;
    public String imgUrl;
    public int inList;
    public boolean isExclusivePublish;
    public boolean isFileDownloaded;
    private boolean isFromMyAsset;
    public int isInsertPlay;
    private boolean isLocalEncryptUpgradeMP3;
    public boolean isMusicCloudFile;
    public boolean isPlayMusicCloud;
    public boolean isReset;
    private boolean isUserPlay;
    public boolean isUserSetLanguage;
    public boolean isUserSetPublishYear;
    public int isnew;
    public String language;
    public long languageMatchTime;
    public long localMusicFeeId;

    @ColumnInfo(name = "m4aHash")
    public String m4aHash;
    public long m4aSize;
    public String m4aUrl;
    public int mDownloadStatus;
    private int mFlag;

    @Ignore
    private MusicCloudInfo mMusicCloudInfo;
    public String mPlayListPicPath;
    public String mSpecialOrAlbumName;
    private int maskOfForceDownload;

    @ColumnInfo(name = "mixId")
    public long mixId;
    public String module;
    public int musicFeeStatus;
    public String musicFeeType;
    public String musicLinkExtInfo;
    public int musicLinkSource;
    public int musicSource;

    @Ignore
    private MusicTransParamEnenty musicTransParamEnenty;
    public int musiclibId;

    @ColumnInfo(name = "musicpath")
    public String musicpath;
    public String mvHashValue;
    public long mvMatchTime;
    public int mvTracks;
    public int mvType;
    public int oldCpy;

    @ColumnInfo(name = "oldMixId")
    public long oldMixId;
    public int payType;
    public int playListCloudListId;
    public int playListCreateListId;
    public long playListCreateUserId;
    public String playListCreateUserName;
    public int playListId;
    public String playListName;
    public int playListSource;
    public int playListType;
    public String publishYear;
    public long publishYearMatchTime;
    private int qualityFeeSource;
    private int rankId;

    @Ignore
    private RecSongInfo recSongInfo;

    @ColumnInfo(name = "remark")
    public String remark;

    @ColumnInfo(name = "sid")
    public long sid;

    @Ignore
    private SingerInfo[] singerInfos;

    @ColumnInfo(name = "size")
    public long size;
    public long size320;
    public String sk;
    public int songSource;
    public String songType;
    private int sort;

    @ColumnInfo(name = "source")
    public String source;
    public String sourceHash;
    public int sourceMode;

    @ColumnInfo(name = "sourceType")
    public String sourceType;
    private int specialId;
    public String sqHash;
    public long sqSize;

    @ColumnInfo(name = "srctype")
    public int srctype;
    public int tag;
    private String topic;

    @ColumnInfo(name = "track_id")
    public long trackID;

    @ColumnInfo(name = "trackName")
    public String trackName;
    private int ugcReviewed;
    public long updateFeeStatusTime;
    public static final Parcelable.Creator<KGMusic> CREATOR = new a();
    private static final Pattern sDisplayNamePattern = Pattern.compile("\\(\\d+\\)\\s?$");

    public class a implements Parcelable.Creator<KGMusic> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public KGMusic createFromParcel(Parcel parcel) {
            return new KGMusic(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public KGMusic[] newArray(int i2) {
            return new KGMusic[i2];
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

    public KGMusic() {
        this.extUniqueId = -1;
        this.dbId = 0L;
        this.id = 0L;
        this.gif_id = -1;
        this.fileOrderWeight = -1;
        this.collectTime = 0L;
        this.sid = -1L;
        this.fileId = -1L;
        this.hashType = -100;
        this.feeType = -1;
        this.fullName = "";
        this.source = "未知来源";
        this.sourceType = "";
        this.genreId = -1;
        this.albumMatchTime = 0L;
        this.isInsertPlay = 0;
        this.sourceMode = -1;
        this.oldCpy = -1;
        this.mDownloadStatus = 0;
        this.fromLocalMusic = false;
        this.isUserPlay = false;
        this.audioType = 0;
        this.sort = 0;
        this.audioIndex = 0;
        this.maskOfForceDownload = -1;
        this.guessYouLikeMark = -1;
        this.guessYouLikeBiString = "";
    }

    public static KGMusic copyKGMusic(KGMusic kGMusic) {
        if (kGMusic == null) {
            return null;
        }
        KGMusic kGMusic2 = new KGMusic();
        kGMusic2.setHas_accompany(kGMusic.has_accompany);
        kGMusic2.setAccompanimentHash(kGMusic.accompanimentHash);
        kGMusic2.setAccompanimentTime(kGMusic.accompanimentTime);
        kGMusic2.setAccompanimentId(kGMusic.accompanimentId);
        kGMusic2.setAlbumID(kGMusic.albumID);
        kGMusic2.setAlbumMatchTime(kGMusic.albumMatchTime);
        kGMusic2.setAlbumName(kGMusic.albumName);
        kGMusic2.setArtistID(kGMusic.artistID);
        kGMusic2.setArtistName(kGMusic.artistName);
        kGMusic2.setCharge(kGMusic.charge);
        kGMusic2.setBitrate(kGMusic.bitrate);
        kGMusic2.setDisplayName(kGMusic.displayName);
        kGMusic2.setDuration(kGMusic.duration);
        kGMusic2.setFeeType(kGMusic.feeType);
        kGMusic2.setFullName(kGMusic.fullName);
        kGMusic2.setGenre(kGMusic.genre);
        kGMusic2.setGenreId(kGMusic.genreId);
        kGMusic2.setHash320(kGMusic.hash320);
        kGMusic2.setHashType(kGMusic.hashType);
        kGMusic2.setHashValue(kGMusic.hashValue);
        kGMusic2.setImgUrl(kGMusic.imgUrl);
        kGMusic2.setExclusivePublish(kGMusic.isExclusivePublish);
        kGMusic2.setIsInsertPlay(kGMusic.isInsertPlay());
        kGMusic2.setIsnew(kGMusic.isnew);
        kGMusic2.setM4aHash(kGMusic.m4aHash);
        kGMusic2.setM4aSize(kGMusic.m4aSize);
        kGMusic2.setM4aUrl(kGMusic.m4aUrl);
        kGMusic2.setMusicpath(kGMusic.musicpath);
        kGMusic2.setMvHashValue(kGMusic.mvHashValue);
        kGMusic2.setMvMatchTime(kGMusic.mvMatchTime);
        kGMusic2.setMvTracks(kGMusic.mvTracks);
        kGMusic2.setMvType(kGMusic.mvType);
        kGMusic2.setSid(kGMusic.sid);
        kGMusic2.setSize(kGMusic.size);
        kGMusic2.setSize320(kGMusic.size320);
        kGMusic2.setSource(kGMusic.source);
        kGMusic2.setSourceType(kGMusic.sourceType);
        kGMusic2.setSqHash(kGMusic.sqHash);
        kGMusic2.setSqSize(kGMusic.sqSize);
        kGMusic2.setSrctype(kGMusic.srctype);
        kGMusic2.setSongSource(kGMusic.getSongSource());
        kGMusic2.setTrackID(kGMusic.trackID);
        kGMusic2.setTrackName(kGMusic.trackName);
        kGMusic2.setChannelCommentId(kGMusic.getChannelCommentId());
        kGMusic2.setFeeAlbumId(kGMusic.feeAlbumId);
        kGMusic2.setMixId(kGMusic.mixId);
        kGMusic2.setAudioId(kGMusic.audioId);
        kGMusic2.setId(kGMusic.id);
        kGMusic2.setCurMark(kGMusic.curMark);
        kGMusic2.setRemark(kGMusic.remark);
        kGMusic2.setTopic(kGMusic.topic);
        kGMusic2.setUgcReviewed(kGMusic.ugcReviewed);
        kGMusic2.setQualityFeeSource(kGMusic.qualityFeeSource);
        kGMusic2.setPlayListId(kGMusic.getPlayListId());
        kGMusic2.setPlayListCreateListId(kGMusic.getPlayListCreateListId());
        kGMusic2.setPlayListType(kGMusic.getPlayListType());
        kGMusic2.setPlayListName(kGMusic.getPlayListName());
        kGMusic2.setPlayListCreateUserId(kGMusic.getPlayListCreateUserId());
        kGMusic2.setPlayListCloudListId(kGMusic.getPlayListCloudListId());
        kGMusic2.setPlayListSource(kGMusic.getPlayListSource());
        kGMusic2.musicLinkSource = kGMusic.musicLinkSource;
        kGMusic2.setMusicCloudInfo(kGMusic.getMusicCloudInfo());
        kGMusic2.setExtname(kGMusic.extname);
        kGMusic2.setmSpecialOrAlbumName(kGMusic.getmSpecialOrAlbumName());
        kGMusic2.setAudioType(kGMusic.getAudioType());
        kGMusic2.setSort(kGMusic.getSort());
        kGMusic2.setAudioIndex(kGMusic.getAudioIndex());
        kGMusic2.setPublishYear(kGMusic.getPublishYear());
        kGMusic2.setPublishYearMatchTime(kGMusic.getPublishYearMatchTime());
        kGMusic2.setLanguage(kGMusic.getLanguage());
        kGMusic2.setLanguageMatchTime(kGMusic.getLanguageMatchTime());
        kGMusic2.setUserSetLanguage(kGMusic.isUserSetLanguage());
        kGMusic2.setUserSetPublishYear(kGMusic.isUserSetPublishYear());
        kGMusic2.setReset(kGMusic.isReset);
        kGMusic2.setMusicTransParamEnenty(kGMusic.getMusicTransParamEnenty());
        kGMusic2.setMusicSource(kGMusic.getMusicSource());
        kGMusic2.setSk(kGMusic.getSk());
        kGMusic2.setOldMixId(kGMusic.getOldMixId());
        kGMusic2.setPlayMusicCloud(kGMusic.isPlayMusicCloud());
        kGMusic2.setMusicLinkExtInfo(kGMusic.getMusicLinkExtInfo());
        kGMusic2.setExtParams(kGMusic.getExtParams());
        return kGMusic2;
    }

    public static KGMusic createFromJson(JSONObject jSONObject) {
        KGMusic kGMusic = new KGMusic();
        kGMusic.setHas_accompany(jSONObject.optInt("has_accompany", 0));
        kGMusic.setAccompanimentHash(jSONObject.optString("accompanimentHash"));
        kGMusic.setAccompanimentTime(jSONObject.optLong("accompanimentTime"));
        kGMusic.setAccompanimentId(jSONObject.optInt("accompanimentId", 0));
        kGMusic.setAlbumID(jSONObject.optLong("albumID", -1L));
        kGMusic.setAlbumMatchTime(jSONObject.optLong("albumMatchTime", -1L));
        kGMusic.setAlbumName(jSONObject.optString("albumName"));
        kGMusic.setArtistID(jSONObject.optLong("artistID", -1L));
        kGMusic.setArtistName(jSONObject.optString("artistName"));
        kGMusic.setBitrate(jSONObject.optInt("bitrate"));
        kGMusic.setCharge(jSONObject.optInt("charge"));
        kGMusic.setDisplayName(jSONObject.optString("displayName"));
        kGMusic.setDuration(jSONObject.optLong("duration", -1L));
        kGMusic.setFeeType(jSONObject.optInt("feeType"));
        kGMusic.setFullName(jSONObject.optString("fullName"));
        kGMusic.setGenre(jSONObject.optString("genre"));
        kGMusic.setGenreId(jSONObject.optInt("genreId"));
        kGMusic.setHash320(jSONObject.optString("hash320"));
        kGMusic.setHashType(jSONObject.optInt("hashType"));
        kGMusic.setHashValue(jSONObject.optString("hashValue"));
        kGMusic.setImgUrl(jSONObject.optString("imgUrl"));
        kGMusic.setExclusivePublish(jSONObject.optBoolean("isExclusivePublish"));
        kGMusic.setIsInsertPlay(jSONObject.optBoolean("isInsertPlay"));
        kGMusic.setIsnew(jSONObject.optInt("isnew"));
        kGMusic.setM4aHash(jSONObject.optString("m4aHash"));
        kGMusic.setM4aSize(jSONObject.optLong("m4aSize", -1L));
        kGMusic.setM4aUrl(jSONObject.optString("m4aUrl"));
        kGMusic.setMusicpath(jSONObject.optString("musicpath"));
        kGMusic.setMvHashValue(jSONObject.optString("mvHashValue"));
        kGMusic.setMvMatchTime(jSONObject.optLong("mvMatchTime", -1L));
        kGMusic.setMvTracks(jSONObject.optInt("mvTracks"));
        kGMusic.setMvType(jSONObject.optInt("mvType"));
        kGMusic.setSid(jSONObject.optLong("sid", -1L));
        kGMusic.setSize(jSONObject.optLong("size", -1L));
        kGMusic.setSize320(jSONObject.optLong("size320", -1L));
        kGMusic.setSource(jSONObject.optString("source"));
        kGMusic.setSourceType(jSONObject.optString("sourceType"));
        kGMusic.setSongSource(jSONObject.optInt("songSource"));
        kGMusic.setSourceHash(jSONObject.optString("sourceHash"));
        kGMusic.setSqHash(jSONObject.optString("sqHash"));
        kGMusic.setSqSize(jSONObject.optLong("sqSize", -1L));
        kGMusic.setSrctype(jSONObject.optInt("srctype"));
        kGMusic.setTrackID(jSONObject.optLong("trackID"));
        kGMusic.setTrackName(jSONObject.optString("trackName"));
        kGMusic.setFeeAlbumId(jSONObject.optString("feeAlbumId"));
        kGMusic.setChannelCommentId(jSONObject.optString("channelCommentId"));
        kGMusic.setMixId(jSONObject.optLong("mixId"));
        kGMusic.setAudioId(jSONObject.optLong("audioId"));
        kGMusic.setAuthorId(jSONObject.optInt("authorId"));
        kGMusic.setSpecialId(jSONObject.optInt("specialId"));
        kGMusic.setGlobalCollectionId(jSONObject.optString("globalCollectionId"));
        kGMusic.setRankId(jSONObject.optInt("rankId"));
        kGMusic.setId(jSONObject.optLong("id", -1L));
        kGMusic.setCurMark(jSONObject.optString("curMark"));
        kGMusic.setCurMark(jSONObject.optString("remark"));
        kGMusic.setTopic(jSONObject.optString("topic"));
        kGMusic.setUgcReviewed(jSONObject.optInt("ugcReviewed"));
        kGMusic.setQualityFeeSource(jSONObject.optInt("qualityFeeSource"));
        kGMusic.setSongSource(jSONObject.optInt("songSource"));
        kGMusic.setFailProcess(jSONObject.optInt("failProcess"));
        kGMusic.setPayType(jSONObject.optInt("payType"));
        kGMusic.setMusicFeeType(jSONObject.optString("musicFeeType"));
        kGMusic.setUpdateFeeStatusTime(jSONObject.optLong("updateFeeStatusTime"));
        kGMusic.setMaskOfForceDownload(jSONObject.optInt("maskOfForceDownload", -1));
        kGMusic.setOldCpy(jSONObject.optInt("oldCpy", -1));
        kGMusic.setCurMark(jSONObject.optString("curMark"));
        kGMusic.setPlayListId(jSONObject.optInt("playListId"));
        kGMusic.setPlayListCreateListId(jSONObject.optInt("playListCreateListId"));
        kGMusic.setPlayListType(jSONObject.optInt("playListType"));
        kGMusic.setPlayListName(jSONObject.optString("playListName"));
        kGMusic.setPlayListCreateUserId(jSONObject.optLong("playListCreateUserId"));
        kGMusic.setPlayListCloudListId(jSONObject.optInt("playListCloudListId"));
        kGMusic.setPlayListSource(jSONObject.optInt("playListSource"));
        kGMusic.musicLinkSource = jSONObject.optInt("musicLinkSource");
        kGMusic.setMusiclibId(jSONObject.optInt("musiclibId"));
        kGMusic.setPlayListCreateUserName(jSONObject.optString("playListCreateUserName"));
        kGMusic.setPlayListPicPath(jSONObject.optString("mPlayListPicPath"));
        kGMusic.setmSpecialOrAlbumName(jSONObject.optString("mSpecialOrAlbumName"));
        kGMusic.setPublishYear(jSONObject.optString("publishYear", ""));
        kGMusic.setPublishYearMatchTime(jSONObject.optLong("publishYearMatchTime", 0L));
        kGMusic.setUserSetPublishYear(jSONObject.optBoolean("isUserSetPublishYear", false));
        kGMusic.setLanguage(jSONObject.optString(KrcLoader.TAG_LANGUAGE, ""));
        kGMusic.setLanguageMatchTime(jSONObject.optLong("languageMatchTime", 0L));
        kGMusic.setUserSetLanguage(jSONObject.optBoolean("isUserSetLanguage", false));
        kGMusic.setReset(jSONObject.optBoolean("isReset", false));
        kGMusic.setSk(jSONObject.optString("sk", "0,9"));
        kGMusic.setExtParams(jSONObject.optString("ext_params"));
        try {
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("singer_info");
            if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
                SingerInfo[] singerInfoArr = new SingerInfo[jSONArrayOptJSONArray.length()];
                for (int i2 = 0; i2 < jSONArrayOptJSONArray.length(); i2++) {
                    SingerInfo singerInfo = new SingerInfo();
                    JSONObject jSONObject2 = jSONArrayOptJSONArray.getJSONObject(i2);
                    singerInfo.d(jSONObject2.optInt("id"));
                    singerInfo.e(jSONObject2.optString("name"));
                    singerInfoArr[i2] = singerInfo;
                }
                kGMusic.setSingerInfos(singerInfoArr);
            }
        } catch (JSONException e2) {
            g0.k(e2);
        }
        MusicCloudInfo musicCloudInfo = new MusicCloudInfo();
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("mMusicCloudInfo");
        if (jSONObjectOptJSONObject != null) {
            musicCloudInfo.l(jSONObjectOptJSONObject.optLong("mixId"));
            musicCloudInfo.i(jSONObjectOptJSONObject.optString("fileHash"));
            musicCloudInfo.j(jSONObjectOptJSONObject.optLong("fileLength"));
            musicCloudInfo.m(jSONObjectOptJSONObject.optInt("qualityType"));
            musicCloudInfo.h(jSONObjectOptJSONObject.optString("cloudExtName"));
            musicCloudInfo.k(jSONObjectOptJSONObject.optString("fileName"));
            kGMusic.setMusicCloudInfo(musicCloudInfo);
        }
        kGMusic.setExtname(jSONObject.optString("extName"));
        kGMusic.setGuessYouLikeMark(jSONObject.optInt("guessYouLikeMark", -1));
        kGMusic.setAudioType(jSONObject.optInt("audioType", 0));
        kGMusic.setSort(jSONObject.optInt("sort", 0));
        kGMusic.setAudioIndex(jSONObject.optInt("audioIndex", 0));
        kGMusic.setRecSongInfo(RecSongInfo.parseRecSongInfo(jSONObject.optJSONObject("recSongInfo")));
        kGMusic.applyExtraInfo(ExtraInfo.fromJsonObj(jSONObject.optJSONObject("extraInfo")));
        kGMusic.setGuessYouLikeBiString(jSONObject.optString("guessYouLikeBiString"));
        kGMusic.setPlayMusicCloud(jSONObject.optBoolean("isPlayMusicCloud"));
        MusicTransParamEnenty.jsonToEnenty(jSONObject, kGMusic);
        kGMusic.setMusicSource(jSONObject.optInt("musicSource", 0));
        kGMusic.setOldMixId(jSONObject.optLong("oldMixId", 0L));
        kGMusic.setMusicLinkExtInfo(jSONObject.optString("musicLinkExtInfo"));
        return kGMusic;
    }

    public static KGMusic createKGMusic(e.c.a.g.a.g.k.c.a aVar, String str) {
        KGMusic kGMusic = new KGMusic();
        if (aVar != null) {
            kGMusic.fileId = aVar.o();
            kGMusic.fileOrderWeight = aVar.q();
            kGMusic.hashType = 100;
            kGMusic.source = str;
            kGMusic.duration = aVar.s();
            kGMusic.feeAlbumId = aVar.a();
            kGMusic.mixId = aVar.f();
            kGMusic.failProcess = aVar.e();
            kGMusic.updateFeeStatusTime = aVar.l();
            kGMusic.payType = aVar.j();
            kGMusic.musicFeeType = aVar.g();
            kGMusic.oldCpy = aVar.i();
            kGMusic.charge = aVar.k();
            kGMusic.mixId = aVar.f();
            if (!TextUtils.isEmpty(aVar.a())) {
                try {
                    kGMusic.albumID = Long.parseLong(aVar.a());
                } catch (Exception e2) {
                    g0.k(e2);
                }
            }
            String strP = aVar.p();
            if (!TextUtils.isEmpty(strP)) {
                int iLastIndexOf = strP.lastIndexOf(".");
                if (iLastIndexOf > 0) {
                    strP = strP.substring(0, iLastIndexOf);
                }
                if (!TextUtils.isEmpty(strP)) {
                    e eVarR = h1.r(strP);
                    kGMusic.displayName = eVarR.a();
                    kGMusic.fullName = eVarR.b();
                }
            }
            kGMusic.hashValue = aVar.n();
            kGMusic.size = aVar.r();
            kGMusic.mvHashValue = aVar.t();
            kGMusic.mvTracks = aVar.u();
            kGMusic.mvType = aVar.v();
            kGMusic.musicTransParamEnenty = aVar.h();
            if (aVar.s() > 0) {
                kGMusic.m4aSize = ((aVar.s() / 1000) * 32000) / 8;
            } else {
                kGMusic.m4aSize = 1048576L;
            }
            kGMusic.albumName = aVar.b();
            kGMusic.hashType = 100;
        }
        return kGMusic;
    }

    public static List<KGMusic> fromKgSongs(List<KGSong> list) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < list.size(); i2++) {
            arrayList.add(list.get(i2).S4());
        }
        return arrayList;
    }

    public static boolean isMusicDisplayNameTheSame(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            Pattern pattern = sDisplayNamePattern;
            Matcher matcher = pattern.matcher(str);
            Matcher matcher2 = pattern.matcher(str2);
            String strReplaceAll = matcher.replaceAll("");
            String strReplaceAll2 = matcher2.replaceAll("");
            if (!TextUtils.isEmpty(strReplaceAll) && !TextUtils.isEmpty(strReplaceAll2) && strReplaceAll.equals(strReplaceAll2)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isMusicWithSameHash(KGMusic kGMusic, KGMusic kGMusic2) {
        if (kGMusic == null || kGMusic2 == null) {
            return false;
        }
        return kGMusic.isHashOfThisMusic(kGMusic2.getHashValue()) || kGMusic.isHashOfThisMusic(kGMusic2.getHash320()) || kGMusic.isHashOfThisMusic(kGMusic2.getSqHash());
    }

    public static String makeInMemoryFileKey(String str) {
        return str + "-memoryonly";
    }

    public static String makeListenFileKey(String str) {
        return str + "-pary";
    }

    @Deprecated
    public static KGSong[] toKgSongArray(KGMusic[] kGMusicArr) {
        int length = kGMusicArr.length;
        KGSong[] kGSongArr = new KGSong[length];
        for (int i2 = 0; i2 < length; i2++) {
            kGSongArr[i2] = kGMusicArr[i2].buildKgSong();
        }
        return kGSongArr;
    }

    public static List<KGMusic> transforFromKGSongs(List<KGSong> list) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < list.size(); i2++) {
            arrayList.add(list.get(i2).S4());
        }
        return arrayList;
    }

    public void applyExtraInfo(ExtraInfo extraInfo) {
        ExtraInfo extraInfo2 = this.extraInfo;
        if (extraInfo2 == null) {
            this.extraInfo = extraInfo;
        } else {
            extraInfo2.apply(extraInfo);
        }
    }

    public void applyStanderMusicCharge(int i2) {
        this.charge = i2 | this.charge;
    }

    @Deprecated
    public KGSong buildKgSong() {
        KGSong kGSong = new KGSong("unknown");
        kGSong.M4(-1);
        kGSong.B3(getHashValue());
        kGSong.A3(this.hashType);
        kGSong.e3(getDisplayName());
        kGSong.X2(getBitrate());
        kGSong.g3(getDuration());
        kGSong.C3(getHash320());
        kGSong.C4(getSqHash());
        kGSong.L3(getM4aHash());
        kGSong.o4(getSize());
        kGSong.M3((int) getM4aSize());
        kGSong.p4((int) getSize320());
        kGSong.D4((int) getSqSize());
        kGSong.R2(getArtistName());
        kGSong.X2(getBitrate());
        kGSong.L4(getTrackName());
        kGSong.X3(getMvHashValue());
        kGSong.a4(getMvType());
        kGSong.b3(getCharge());
        kGSong.y4(getSource());
        kGSong.R3(getModule());
        kGSong.u4(getSongSource());
        kGSong.L2(getAccompanimentHash());
        kGSong.N2(getAccompanimentTime());
        kGSong.M2(getAccompanimentId());
        kGSong.n3(getFeeAlbumId());
        kGSong.F3(getImgUrl());
        kGSong.a3(getChannelCommentId());
        kGSong.Q3(getMixId());
        kGSong.S2(getAudioId());
        if (getAlbumID() > 0) {
            kGSong.O2((int) getAlbumID());
        }
        kGSong.E3(getId());
        kGSong.d3(getCurMark());
        kGSong.z4(getSourceHash());
        kGSong.p3((int) getFileId());
        kGSong.I4(getTopic());
        kGSong.N4(getUgcReviewed());
        kGSong.g4(getQualityFeeSource());
        kGSong.m3(getFailProcess());
        kGSong.e4(getPayType());
        kGSong.U3(getMusicFeeType());
        kGSong.O4(getUpdateFeeStatusTime());
        kGSong.O3(getMaskOfForceDownload());
        kGSong.b4(getOldCpy());
        kGSong.d3(getCurMark());
        kGSong.X0 = this.musicLinkSource;
        kGSong.n4(getSingerInfos());
        kGSong.T3(getMusicCloudInfo());
        kGSong.j3(getExtname());
        kGSong.B4(getSpecialId());
        kGSong.P4(this.mSpecialOrAlbumName);
        kGSong.x3(getGuessYouLikeMark());
        kGSong.U2(getAudioType());
        kGSong.x4(getSort());
        kGSong.T2(getAudioIndex());
        kGSong.i4(getRecSongInfo());
        kGSong.b1(getExtraInfo());
        kGSong.setMusicTransParamEnenty(getMusicTransParamEnenty());
        kGSong.w3(getGuessYouLikeBiString());
        kGSong.W3(getMusicSource());
        kGSong.q4(getSk());
        kGSong.f4(isPlayMusicCloud());
        kGSong.V3(getMusicLinkExtInfo());
        return kGSong;
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof KGMusic)) {
            return false;
        }
        KGMusic kGMusic = (KGMusic) obj;
        if (this.mixId > 0 && kGMusic.getMixId() > 0) {
            return this.mixId == kGMusic.getMixId();
        }
        if (this.mixId > 0 || kGMusic.getMixId() > 0) {
            return false;
        }
        return (TextUtils.isEmpty(this.hashValue) || TextUtils.isEmpty(kGMusic.getHashValue()) || TextUtils.isEmpty(this.displayName)) ? (this.sid == -1 || kGMusic.getSid() == -1 || this.sid != kGMusic.getSid()) ? false : true : this.hashValue.equalsIgnoreCase(kGMusic.getHashValue()) && this.displayName.equals(kGMusic.getDisplayName());
    }

    public String getAccompanimentHash() {
        return this.accompanimentHash;
    }

    public int getAccompanimentId() {
        return this.accompanimentId;
    }

    public long getAccompanimentTime() {
        return this.accompanimentTime;
    }

    public long getAlbumID() {
        return this.albumID;
    }

    public long getAlbumMatchTime() {
        return this.albumMatchTime;
    }

    public String getAlbumName() {
        return this.albumName;
    }

    public long getArtistID() {
        return this.artistID;
    }

    public String getArtistName() {
        if (!TextUtils.isEmpty(this.displayName) && ("未知歌手".equals(this.artistName) || TextUtils.isEmpty(this.artistName))) {
            int iIndexOf = this.displayName.indexOf(" - ");
            if (iIndexOf == -1) {
                iIndexOf = this.displayName.indexOf("-");
            }
            if (iIndexOf > 0) {
                this.artistName = this.displayName.substring(0, iIndexOf).trim();
            }
        }
        if (TextUtils.isEmpty(this.artistName)) {
            this.artistName = "未知歌手";
        }
        return this.artistName;
    }

    public long getAudioId() {
        return this.audioId;
    }

    public int getAudioIndex() {
        return this.audioIndex;
    }

    public int getAudioType() {
        return this.audioType;
    }

    public int getAudition() {
        return this.audition;
    }

    public int getAuthorId() {
        return this.authorId;
    }

    public String getBehavior() {
        return this.behavior;
    }

    public int getBitrate() {
        return this.bitrate;
    }

    public String getBrief() {
        return this.brief;
    }

    public String getChannelCommentId() {
        String str = this.channelCommentId;
        return str == null ? "" : str;
    }

    public int getCharge() {
        return this.charge;
    }

    public String getCurMark() {
        return this.curMark;
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public int getDownloadStatus() {
        return this.mDownloadStatus;
    }

    public long getDuration() {
        return this.duration;
    }

    public String getExtParams() {
        return this.extParams;
    }

    public String getExtname() {
        return this.extname;
    }

    public ExtraInfo getExtraInfo() {
        return this.extraInfo;
    }

    public int getFailProcess() {
        return this.failProcess;
    }

    public String getFeeAlbumId() {
        String str = this.feeAlbumId;
        return str == null ? "" : str;
    }

    public int getFeeType() {
        return this.feeType;
    }

    public int getFileEncryptType() {
        return this.fileEncryptType;
    }

    public long getFileId() {
        return this.fileId;
    }

    public int getFlag() {
        return this.mFlag;
    }

    public String getFullName() {
        return this.fullName;
    }

    public String getGenre() {
        return this.genre;
    }

    public int getGenreId() {
        return this.genreId;
    }

    public int getGif_id() {
        return this.gif_id;
    }

    public String getGlobalCollectionId() {
        return this.globalCollectionId;
    }

    public String getGuessYouLikeBiString() {
        return this.guessYouLikeBiString;
    }

    public int getGuessYouLikeMark() {
        return this.guessYouLikeMark;
    }

    public String getHasPintTrackName() {
        if (TextUtils.isEmpty(this.fullName)) {
            return this.trackName;
        }
        int iIndexOf = this.fullName.indexOf(" - ");
        int i2 = iIndexOf + 3;
        if (iIndexOf == -1) {
            iIndexOf = this.fullName.indexOf("-");
            i2 = iIndexOf + 1;
        }
        if (iIndexOf <= 0) {
            return this.fullName;
        }
        String str = this.fullName;
        return str.substring(i2, str.length()).trim();
    }

    public int getHas_accompany() {
        return this.has_accompany;
    }

    public String getHash320() {
        String str = this.hash320;
        if (str != null) {
            return str.toLowerCase();
        }
        return null;
    }

    public int getHashType() {
        if (!TextUtils.isEmpty(this.hash320) || !TextUtils.isEmpty(this.sqHash)) {
            this.hashType = 300;
            if (g0.f()) {
                Log.d("mhs_watch_favapm", "step 0 命中冷门或者高品");
            }
        }
        int i2 = this.hashType;
        if ((i2 == 1 || i2 == 0) && g0.f()) {
            g0.c("BLUE", "HashType error, hash type is of old hash type: " + this.hashType);
        }
        if (g0.f()) {
            Log.d("mhs_watch_favapm", "没命中 step 2 hashType = " + this.hashType);
        }
        return this.hashType;
    }

    public String getHashValue() {
        String str = this.hashValue;
        return str != null ? str.toLowerCase() : "";
    }

    public long getId() {
        return this.id;
    }

    public int getIfCanDownload() {
        int hashType = getHashType();
        if (hashType > 0) {
            return 1;
        }
        return e.c.a.g.a.f.j.a.b.a(hashType) ? 2 : 0;
    }

    public String getImgUrl() {
        return this.imgUrl;
    }

    public int getInList() {
        return this.inList;
    }

    public boolean getIsMusicCloud() {
        if (this.mMusicCloudInfo != null) {
            return !TextUtils.isEmpty(r0.c());
        }
        return false;
    }

    public int getIsnew() {
        return this.isnew;
    }

    public String getKey() {
        return !TextUtils.isEmpty(this.hashValue) ? getHashValue() : this.musicpath;
    }

    public String getLanguage() {
        return this.language;
    }

    public long getLanguageMatchTime() {
        return this.languageMatchTime;
    }

    public long getLocalMusicFeeId() {
        return this.localMusicFeeId;
    }

    public String getM4aHash() {
        String str = this.m4aHash;
        if (str != null) {
            return str.toLowerCase();
        }
        return null;
    }

    public long getM4aSize() {
        return this.m4aSize;
    }

    public String getM4aUrl() {
        return this.m4aUrl;
    }

    public int getMaskOfForceDownload() {
        return this.maskOfForceDownload;
    }

    public long getMixId() {
        return (!getIsMusicCloud() || getMusicCloudInfo().f() <= 0) ? this.mixId : getMusicCloudInfo().f();
    }

    public String getModule() {
        return this.module;
    }

    public MusicCloudInfo getMusicCloudInfo() {
        return this.mMusicCloudInfo;
    }

    public int getMusicFeeStatus() {
        return this.musicFeeStatus;
    }

    public String getMusicFeeType() {
        return this.musicFeeType;
    }

    public String getMusicLinkExtInfo() {
        return this.musicLinkExtInfo;
    }

    public int getMusicSource() {
        return this.musicSource;
    }

    @Override // e.c.a.g.a.s.r0.a
    public MusicTransParamEnenty getMusicTransParamEnenty() {
        return this.musicTransParamEnenty;
    }

    public int getMusiclibId() {
        return this.musiclibId;
    }

    public String getMusicpath() {
        return this.musicpath;
    }

    public String getMvHashValue() {
        return this.mvHashValue;
    }

    public long getMvMatchTime() {
        return this.mvMatchTime;
    }

    public int getMvTracks() {
        return this.mvTracks;
    }

    public int getMvType() {
        return this.mvType;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0046  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.kugou.android.watch.lite.common.music.entity.SongQuality getNearestSongQuality(com.kugou.android.watch.lite.common.music.entity.SongQuality r2) {
        /*
            r1 = this;
            int[] r0 = com.kugou.android.watch.lite.common.music.entity.KGMusic.b.a
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
            java.lang.String r2 = r1.getSqHash()
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L22
            com.kugou.android.watch.lite.common.music.entity.SongQuality r2 = com.kugou.android.watch.lite.common.music.entity.SongQuality.QUALITY_SUPER
            return r2
        L22:
            java.lang.String r2 = r1.getHash320()
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L2f
            com.kugou.android.watch.lite.common.music.entity.SongQuality r2 = com.kugou.android.watch.lite.common.music.entity.SongQuality.QUALITY_HIGHEST
            return r2
        L2f:
            java.lang.String r2 = r1.getHashValue()
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L3c
            com.kugou.android.watch.lite.common.music.entity.SongQuality r2 = com.kugou.android.watch.lite.common.music.entity.SongQuality.QUALITY_HIGH
            return r2
        L3c:
            java.lang.String r2 = r1.getHashValue()
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L49
            com.kugou.android.watch.lite.common.music.entity.SongQuality r2 = com.kugou.android.watch.lite.common.music.entity.SongQuality.QUALITY_LOW
            return r2
        L49:
            com.kugou.android.watch.lite.common.music.entity.SongQuality r2 = com.kugou.android.watch.lite.common.music.entity.SongQuality.QUALITY_NONE
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kugou.android.watch.lite.common.music.entity.KGMusic.getNearestSongQuality(com.kugou.android.watch.lite.common.music.entity.SongQuality):com.kugou.android.watch.lite.common.music.entity.SongQuality");
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x004c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String getNearestSongQualityHash(com.kugou.android.watch.lite.common.music.entity.SongQuality r2) {
        /*
            r1 = this;
            int[] r0 = com.kugou.android.watch.lite.common.music.entity.KGMusic.b.a
            int r2 = r2.ordinal()
            r2 = r0[r2]
            r0 = 1
            if (r2 == r0) goto L15
            r0 = 2
            if (r2 == r0) goto L24
            r0 = 3
            if (r2 == r0) goto L33
            r0 = 4
            if (r2 == r0) goto L42
            goto L51
        L15:
            java.lang.String r2 = r1.getSqHash()
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L24
            java.lang.String r2 = r1.getSqHash()
            return r2
        L24:
            java.lang.String r2 = r1.getHash320()
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L33
            java.lang.String r2 = r1.getHash320()
            return r2
        L33:
            java.lang.String r2 = r1.getHashValue()
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L42
            java.lang.String r2 = r1.getHashValue()
            return r2
        L42:
            java.lang.String r2 = r1.getHashValue()
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L51
            java.lang.String r2 = r1.getHashValue()
            return r2
        L51:
            java.lang.String r2 = r1.getHashValue()
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kugou.android.watch.lite.common.music.entity.KGMusic.getNearestSongQualityHash(com.kugou.android.watch.lite.common.music.entity.SongQuality):java.lang.String");
    }

    public int getOldCpy() {
        return this.oldCpy;
    }

    public long getOldMixId() {
        return this.oldMixId;
    }

    public int getPayType() {
        return this.payType;
    }

    public int getPlayListCloudListId() {
        return this.playListCloudListId;
    }

    public int getPlayListCreateListId() {
        return this.playListCreateListId;
    }

    public long getPlayListCreateUserId() {
        return this.playListCreateUserId;
    }

    public String getPlayListCreateUserName() {
        return this.playListCreateUserName;
    }

    public int getPlayListId() {
        return this.playListId;
    }

    public String getPlayListName() {
        return this.playListName;
    }

    public int getPlayListSource() {
        return this.playListSource;
    }

    public int getPlayListType() {
        return this.playListType;
    }

    public String getPublishYear() {
        return this.publishYear;
    }

    public long getPublishYearMatchTime() {
        return this.publishYearMatchTime;
    }

    public int getQualityFeeSource() {
        return this.qualityFeeSource;
    }

    public int getRankId() {
        return this.rankId;
    }

    public String getRealHashValue() {
        String str = this.hashValue;
        return str == null ? "" : str;
    }

    public RecSongInfo getRecSongInfo() {
        return this.recSongInfo;
    }

    public String getRemark() {
        return this.remark;
    }

    public long getSid() {
        return this.sid;
    }

    public SingerInfo[] getSingerInfos() {
        return this.singerInfos;
    }

    public long getSize() {
        return this.size;
    }

    public long getSize320() {
        return this.size320;
    }

    public String getSk() {
        return this.sk;
    }

    public int getSongSource() {
        return this.songSource;
    }

    public String getSongType() {
        return this.songType;
    }

    public int getSort() {
        return this.sort;
    }

    public String getSource() {
        return this.source;
    }

    public String getSourceHash() {
        return this.sourceHash;
    }

    public int getSourceMode() {
        return this.sourceMode;
    }

    public String getSourceType() {
        if (TextUtils.isEmpty(this.sourceType)) {
            this.sourceType = "";
        }
        return this.sourceType;
    }

    public int getSpecialId() {
        return this.specialId;
    }

    public String getSqHash() {
        String str = this.sqHash;
        if (str != null) {
            return str.toLowerCase();
        }
        return null;
    }

    public long getSqSize() {
        return this.sqSize;
    }

    public int getSrctype() {
        return this.srctype;
    }

    public int getTag() {
        return this.tag;
    }

    public String getTopic() {
        return this.topic;
    }

    public long getTrackID() {
        return this.trackID;
    }

    public String getTrackName() {
        if (!TextUtils.isEmpty(this.trackName) || TextUtils.isEmpty(this.displayName)) {
            return this.trackName;
        }
        int iIndexOf = this.displayName.indexOf(" - ");
        int i2 = iIndexOf + 3;
        if (iIndexOf == -1) {
            iIndexOf = this.displayName.indexOf("-");
            i2 = iIndexOf + 1;
        }
        if (iIndexOf <= 0) {
            return this.displayName;
        }
        String str = this.displayName;
        return str.substring(i2, str.length()).trim();
    }

    public int getUgcReviewed() {
        return this.ugcReviewed;
    }

    public long getUpdateFeeStatusTime() {
        return this.updateFeeStatusTime;
    }

    public String getmPlayListPicPath() {
        return this.mPlayListPicPath;
    }

    public String getmSpecialOrAlbumName() {
        return this.mSpecialOrAlbumName;
    }

    public boolean hasOrtherQuelityHash() {
        return (TextUtils.isEmpty(this.hash320) && TextUtils.isEmpty(this.sqHash)) ? false : true;
    }

    public int hashCode() {
        int i2;
        int i3 = 629;
        if (TextUtils.isEmpty(this.hashValue) || TextUtils.isEmpty(this.displayName)) {
            long j = this.sid;
            if (j == -1) {
                return super.hashCode();
            }
            i2 = (int) (j ^ (j >>> 32));
        } else {
            String str = this.displayName;
            int iHashCode = 629 + (str == null ? 0 : str.hashCode());
            String str2 = this.hashValue;
            int iHashCode2 = (iHashCode * 37) + (str2 != null ? str2.toLowerCase().hashCode() : 0);
            long j2 = this.mixId;
            i2 = (int) (j2 ^ (j2 >>> 32));
            i3 = iHashCode2 * 37;
        }
        return i3 + i2;
    }

    public boolean isDownloaded() {
        return this.mDownloadStatus == 1;
    }

    public boolean isDownloading() {
        return this.mDownloadStatus == 2;
    }

    public boolean isExclusivePublish() {
        return this.isExclusivePublish;
    }

    public boolean isFileDownloaded() {
        return this.isFileDownloaded;
    }

    public boolean isFromLocalMusic() {
        return this.fromLocalMusic;
    }

    public boolean isFromMyAsset() {
        return this.isFromMyAsset;
    }

    public boolean isHashOfThisMusic(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.equalsIgnoreCase(getHashValue()) || str.equalsIgnoreCase(getHash320()) || str.equalsIgnoreCase(getSqHash()) || str.equalsIgnoreCase(getM4aHash());
    }

    public boolean isInsertPlay() {
        return this.isInsertPlay == 1;
    }

    public boolean isLocalEncryptUpgradeMP3() {
        return this.isLocalEncryptUpgradeMP3;
    }

    public boolean isMusicCloudFile() {
        return this.isMusicCloudFile;
    }

    public boolean isPlayMusicCloud() {
        return this.isPlayMusicCloud;
    }

    public boolean isQualityExist(SongQuality songQuality) {
        int i2 = b.a[songQuality.ordinal()];
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 != 3) {
                    if (i2 == 4 && !TextUtils.isEmpty(getHashValue())) {
                        return true;
                    }
                } else if (!TextUtils.isEmpty(getHashValue())) {
                    return true;
                }
            } else if (!TextUtils.isEmpty(getHash320())) {
                return true;
            }
        } else if (!TextUtils.isEmpty(getSqHash())) {
            return true;
        }
        return false;
    }

    public boolean isReset() {
        return this.isReset;
    }

    public boolean isUserPlay() {
        return this.isUserPlay;
    }

    public boolean isUserSetLanguage() {
        return this.isUserSetLanguage;
    }

    public boolean isUserSetPublishYear() {
        return this.isUserSetPublishYear;
    }

    public String makeFileKey(SongQuality songQuality) {
        return makeFileKey(getHashValue(), songQuality, getMixId());
    }

    public void setAccompanimentHash(String str) {
        this.accompanimentHash = str;
    }

    public void setAccompanimentId(int i2) {
        this.accompanimentId = i2;
    }

    public void setAccompanimentTime(long j) {
        this.accompanimentTime = j;
    }

    public void setAlbumID(long j) {
        this.albumID = j;
    }

    public void setAlbumMatchTime(long j) {
        this.albumMatchTime = j;
    }

    public void setAlbumName(String str) {
        this.albumName = str;
    }

    public void setArtistID(long j) {
        this.artistID = j;
    }

    public void setArtistName(String str) {
        this.artistName = str;
    }

    public void setAudioId(long j) {
        if (j > 0 || this.isReset) {
            this.audioId = j;
        }
    }

    public void setAudioIndex(int i2) {
        this.audioIndex = i2;
    }

    public void setAudioType(int i2) {
        this.audioType = i2;
    }

    public void setAudition(int i2) {
        this.audition = i2;
    }

    public void setAuthorId(int i2) {
        this.authorId = i2;
    }

    public void setBehavior(String str) {
        this.behavior = str;
    }

    public void setBitrate(int i2) {
        this.bitrate = i2;
    }

    public void setBrief(String str) {
        this.brief = str;
    }

    public void setChannelCommentId(String str) {
        this.channelCommentId = str;
    }

    public void setCharge(int i2) {
        this.charge = i2;
    }

    public void setCurMark(String str) {
        this.curMark = str;
    }

    public void setDisplayName(String str) {
        this.displayName = str;
    }

    public void setDownloadStatus(int i2) {
        this.mDownloadStatus = i2;
    }

    public void setDuration(long j) {
        this.duration = j;
        if (getM4aSize() <= 0) {
            setM4aSize(((((int) j) / 1000) * 32000) / 8);
        }
    }

    public void setExclusivePublish(boolean z) {
        this.isExclusivePublish = z;
    }

    public void setExtParams(String str) {
        this.extParams = str;
    }

    public void setExtname(String str) {
        this.extname = str;
    }

    public void setFailProcess(int i2) {
        this.failProcess = i2;
    }

    public void setFeeAlbumId(String str) {
        if (g0.a && str == null) {
            p1.f(f.a(), "feeAlbumId can't be null, please check!!!");
        }
        this.feeAlbumId = str;
    }

    public void setFeeType(int i2) {
        this.feeType = i2;
    }

    public void setFileDownloaded(boolean z) {
        this.isFileDownloaded = z;
    }

    public void setFileEncryptType(int i2) {
        this.fileEncryptType = i2;
    }

    public void setFileId(long j) {
        this.fileId = j;
    }

    public void setFlag(int i2) {
        this.mFlag = i2;
    }

    public void setFromLocalMusic(boolean z) {
        this.fromLocalMusic = z;
    }

    public void setFromMyAsset(boolean z) {
        this.isFromMyAsset = z;
    }

    public void setFullName(String str) {
        this.fullName = str;
    }

    public void setGenre(String str) {
        this.genre = str;
    }

    public void setGenreId(int i2) {
        this.genreId = i2;
    }

    public void setGif_id(int i2) {
        this.gif_id = i2;
    }

    public void setGlobalCollectionId(String str) {
        this.globalCollectionId = str;
    }

    public void setGuessYouLikeBiString(String str) {
        this.guessYouLikeBiString = str;
    }

    public void setGuessYouLikeMark(int i2) {
        this.guessYouLikeMark = i2;
    }

    public void setHas_accompany(int i2) {
        this.has_accompany = i2;
    }

    public void setHash320(String str) {
        this.hash320 = str;
    }

    public void setHashType(int i2) {
        if (i2 == 1) {
            i2 = 100;
        } else if (i2 == 0) {
            i2 = -100;
        }
        this.hashType = i2;
    }

    public void setHashValue(String str) {
        this.hashValue = str;
    }

    public void setId(long j) {
        this.id = j;
    }

    public void setImgUrl(String str) {
        this.imgUrl = str;
    }

    public void setInList(int i2) {
        this.inList = i2;
    }

    public void setIsInsertPlay(boolean z) {
        if (z) {
            this.isInsertPlay = 1;
        } else {
            this.isInsertPlay = 0;
        }
    }

    public void setIsLocalEncryptUpgradeMP3(boolean z) {
        this.isLocalEncryptUpgradeMP3 = z;
    }

    public void setIsnew(int i2) {
        this.isnew = i2;
    }

    public void setLanguage(String str) {
        this.language = str;
    }

    public void setLanguageMatchTime(long j) {
        this.languageMatchTime = j;
    }

    public void setLocalMusicFeeId(long j) {
        this.localMusicFeeId = j;
    }

    public void setM4aHash(String str) {
        this.m4aHash = d.e(str);
    }

    public void setM4aSize(long j) {
        if (j <= 0) {
            return;
        }
        this.m4aSize = j;
    }

    public void setM4aUrl(String str) {
        this.m4aUrl = str;
    }

    public void setMaskOfForceDownload(int i2) {
        this.maskOfForceDownload = i2;
    }

    public void setMixId(long j) {
        if (j > 0 || this.isReset) {
            this.mixId = j;
        }
    }

    public void setModule(String str) {
        this.module = str;
    }

    public void setMusicCharge(int i2, int i3, int i4) {
        this.charge = i2 + (i3 << 4) + (i4 << 8);
    }

    public void setMusicCloudFile(boolean z) {
        this.isMusicCloudFile = z;
    }

    public void setMusicCloudInfo(MusicCloudInfo musicCloudInfo) {
        this.mMusicCloudInfo = musicCloudInfo;
    }

    public void setMusicFeeStatus(int i2) {
        this.musicFeeStatus = i2;
    }

    public void setMusicFeeType(String str) {
        this.musicFeeType = str;
    }

    public void setMusicLinkExtInfo(String str) {
        this.musicLinkExtInfo = str;
    }

    public void setMusicSource(int i2) {
        this.musicSource = i2;
    }

    @Override // e.c.a.g.a.s.r0.a
    public void setMusicTransParamEnenty(MusicTransParamEnenty musicTransParamEnenty) {
        MusicTransParamEnenty musicTransParamEnenty2 = this.musicTransParamEnenty;
        if (musicTransParamEnenty2 != null && musicTransParamEnenty2.isFromCache() && musicTransParamEnenty != null) {
            musicTransParamEnenty.setFromCache(true);
        }
        this.musicTransParamEnenty = musicTransParamEnenty;
    }

    public void setMusiclibId(int i2) {
        this.musiclibId = i2;
    }

    public void setMusicpath(String str) {
        this.musicpath = str;
    }

    public void setMvHashValue(String str) {
        this.mvHashValue = str;
    }

    public void setMvMatchTime(long j) {
        this.mvMatchTime = j;
    }

    public void setMvTracks(int i2) {
        this.mvTracks = i2;
    }

    public void setMvType(int i2) {
        this.mvType = i2;
    }

    public void setOldCpy(int i2) {
        this.oldCpy = i2;
    }

    public void setOldMixId(long j) {
        if (j > 0) {
            this.oldMixId = j;
        }
    }

    public void setPayType(int i2) {
        this.payType = i2;
    }

    public void setPlayListCloudListId(int i2) {
        this.playListCloudListId = i2;
    }

    public void setPlayListCreateListId(int i2) {
        this.playListCreateListId = i2;
    }

    public void setPlayListCreateUserId(long j) {
        this.playListCreateUserId = j;
    }

    public void setPlayListCreateUserName(String str) {
        this.playListCreateUserName = str;
    }

    public void setPlayListId(int i2) {
        this.playListId = i2;
    }

    public void setPlayListName(String str) {
        this.playListName = str;
    }

    public void setPlayListPicPath(String str) {
        this.mPlayListPicPath = str;
    }

    public void setPlayListSource(int i2) {
        this.playListSource = i2;
    }

    public void setPlayListType(int i2) {
        this.playListType = i2;
    }

    public void setPlayMusicCloud(boolean z) {
        this.isPlayMusicCloud = z;
    }

    public void setPublishYear(String str) {
        this.publishYear = str;
    }

    public void setPublishYearMatchTime(long j) {
        this.publishYearMatchTime = j;
    }

    public void setQualityFeeSource(int i2) {
        this.qualityFeeSource = i2;
    }

    public void setRankId(int i2) {
        this.rankId = i2;
    }

    public void setRecSongInfo(RecSongInfo recSongInfo) {
        this.recSongInfo = recSongInfo;
    }

    public void setRemark(String str) {
        this.remark = str;
    }

    public void setReset(boolean z) {
        this.isReset = z;
    }

    public void setSid(long j) {
        this.sid = j;
    }

    public void setSingerInfos(SingerInfo[] singerInfoArr) {
        this.singerInfos = singerInfoArr;
    }

    public void setSize(long j) {
        this.size = j;
    }

    public void setSize320(long j) {
        this.size320 = j;
    }

    public void setSk(String str) {
        this.sk = str;
    }

    public void setSongSource(int i2) {
        this.songSource = i2;
    }

    public void setSongType(String str) {
        this.songType = str;
    }

    public void setSort(int i2) {
        this.sort = i2;
    }

    public void setSource(String str) {
        this.source = str;
    }

    public void setSourceHash(String str) {
        this.sourceHash = str;
    }

    public void setSourceMode(int i2) {
        this.sourceMode = i2;
    }

    public void setSourceType(String str) {
        this.sourceType = str;
    }

    public void setSpecialId(int i2) {
        this.specialId = i2;
    }

    public void setSqHash(String str) {
        this.sqHash = str;
    }

    public void setSqSize(long j) {
        this.sqSize = j;
    }

    public void setSrctype(int i2) {
        this.srctype = i2;
    }

    public KGMusic setTag(int i2) {
        this.tag = i2;
        return this;
    }

    public void setTopic(String str) {
        this.topic = str;
    }

    public void setTrackID(long j) {
        this.trackID = j;
    }

    public void setTrackName(String str) {
        this.trackName = str;
    }

    public void setUgcReviewed(int i2) {
        this.ugcReviewed = i2;
    }

    public void setUpdateFeeStatusTime(long j) {
        this.updateFeeStatusTime = j;
    }

    public void setUserPlay(boolean z) {
        this.isUserPlay = z;
    }

    public void setUserSetLanguage(boolean z) {
        this.isUserSetLanguage = z;
    }

    public void setUserSetPublishYear(boolean z) {
        this.isUserSetPublishYear = z;
    }

    public void setmSpecialOrAlbumName(String str) {
        this.mSpecialOrAlbumName = str;
    }

    public String toHashRelatedString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.sid + ", ");
        sb.append(this.displayName + ", ");
        sb.append(this.hashValue + ", ");
        sb.append(this.hash320 + ", ");
        sb.append(this.sqHash + ", ");
        return sb.toString();
    }

    public JSONObject toJSONObject() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("has_accompany", this.has_accompany);
            jSONObject.put("accompanimentHash", this.accompanimentHash);
            jSONObject.put("accompanimentTime", this.accompanimentTime);
            jSONObject.put("accompanimentId", this.accompanimentId);
            jSONObject.put("albumID", this.albumID);
            jSONObject.put("albumMatchTime", this.albumMatchTime);
            jSONObject.put("albumName", this.albumName);
            jSONObject.put("artistID", this.artistID);
            jSONObject.put("artistName", this.artistName);
            jSONObject.put("bitrate", this.bitrate);
            jSONObject.put("charge", this.charge);
            jSONObject.put("displayName", this.displayName);
            jSONObject.put("duration", this.duration);
            jSONObject.put("feeType", this.feeType);
            jSONObject.put("fullName", this.fullName);
            jSONObject.put("genre", this.genre);
            jSONObject.put("genreId", this.genreId);
            jSONObject.put("hash320", this.hash320);
            jSONObject.put("hashType", this.hashType);
            jSONObject.put("hashValue", this.hashValue);
            jSONObject.put("imgUrl", this.imgUrl);
            jSONObject.put("isExclusivePublish", this.isExclusivePublish);
            jSONObject.put("isInsertPlay", this.isInsertPlay);
            jSONObject.put("isnew", this.isnew);
            jSONObject.put("m4aHash", this.m4aHash);
            jSONObject.put("m4aSize", this.m4aSize);
            jSONObject.put("m4aUrl", this.m4aUrl);
            jSONObject.put("musicpath", this.musicpath);
            jSONObject.put("mvHashValue", this.mvHashValue);
            jSONObject.put("mvMatchTime", this.mvMatchTime);
            jSONObject.put("mvTracks", this.mvTracks);
            jSONObject.put("mvType", this.mvType);
            jSONObject.put("sid", this.sid);
            jSONObject.put("size", this.size);
            jSONObject.put("size320", this.size320);
            jSONObject.put("source", this.source);
            jSONObject.put("sourceType", this.sourceType);
            jSONObject.put("songSource", this.songSource);
            jSONObject.put("sourceHash", this.sourceHash);
            jSONObject.put("sqHash", this.sqHash);
            jSONObject.put("sqSize", this.sqSize);
            jSONObject.put("srctype", this.srctype);
            jSONObject.put("trackID", this.trackID);
            jSONObject.put("trackName", this.trackName);
            jSONObject.put("feeAlbumId", this.feeAlbumId);
            jSONObject.put("channelCommentId", this.channelCommentId);
            jSONObject.put("mixId", this.mixId);
            jSONObject.put("audioId", this.audioId);
            jSONObject.put("authorId", this.authorId);
            jSONObject.put("specialId", this.specialId);
            jSONObject.put("globalCollectionId", this.globalCollectionId);
            jSONObject.put("rankId", this.rankId);
            jSONObject.put("id", this.id);
            jSONObject.put("curMark", this.curMark);
            jSONObject.put("remark", this.remark);
            jSONObject.put("topic", this.topic);
            jSONObject.put("ugcReviewed", this.ugcReviewed);
            jSONObject.put("qualityFeeSource", this.qualityFeeSource);
            jSONObject.put("songSource", this.songSource);
            jSONObject.put("failProcess", this.failProcess);
            jSONObject.put("payType", this.payType);
            jSONObject.put("musicFeeType", this.musicFeeType);
            jSONObject.put("updateFeeStatusTime", this.updateFeeStatusTime);
            jSONObject.put("maskOfForceDownload", this.maskOfForceDownload);
            jSONObject.put("oldCpy", this.oldCpy);
            jSONObject.put("curMark", this.curMark);
            jSONObject.put("playListId", this.playListId);
            jSONObject.put("playListCreateListId", this.playListCreateListId);
            jSONObject.put("playListType", this.playListType);
            jSONObject.put("playListName", this.playListName);
            jSONObject.put("playListCreateUserId", this.playListCreateUserId);
            jSONObject.put("playListCloudListId", this.playListCloudListId);
            jSONObject.put("playListSource", this.playListSource);
            jSONObject.put("musicLinkSource", this.musicLinkSource);
            jSONObject.put("mSpecialOrAlbumName", this.mSpecialOrAlbumName);
            jSONObject.put("musiclibId", this.musiclibId);
            jSONObject.put("playListCreateUserName", this.playListCreateUserName);
            jSONObject.put("mPlayListPicPath", this.mPlayListPicPath);
            jSONObject.put("publishYear", this.publishYear);
            jSONObject.put("publishYearMatchTime", this.publishYearMatchTime);
            jSONObject.put("isUserSetPublishYear", this.isUserSetPublishYear);
            jSONObject.put(KrcLoader.TAG_LANGUAGE, this.language);
            jSONObject.put("languageMatchTime", this.languageMatchTime);
            jSONObject.put("isUserSetLanguage", this.isUserSetLanguage);
            jSONObject.put("isReset", this.isReset);
            jSONObject.put("sk", this.sk);
            jSONObject.put("ext_params", this.extParams);
            MusicCloudInfo musicCloudInfo = getMusicCloudInfo();
            if (musicCloudInfo != null) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("mixId", musicCloudInfo.f());
                jSONObject2.put("fileHash", musicCloudInfo.c());
                jSONObject2.put("fileLength", musicCloudInfo.d());
                jSONObject2.put("qualityType", musicCloudInfo.g());
                jSONObject2.put("cloudExtName", musicCloudInfo.b());
                jSONObject2.put("fileName", musicCloudInfo.e());
                jSONObject.put("mMusicCloudInfo", jSONObject2);
            }
            if (getSingerInfos() != null) {
                JSONArray jSONArray = new JSONArray();
                for (int i2 = 0; i2 < getSingerInfos().length; i2++) {
                    JSONObject jSONObject3 = new JSONObject();
                    SingerInfo singerInfo = getSingerInfos()[i2];
                    jSONObject3.put("id", singerInfo.b());
                    jSONObject3.put("name", singerInfo.c());
                    jSONArray.put(jSONObject3);
                }
                jSONObject.put("singer_info", jSONArray);
            }
            jSONObject.put("isPlayMusicCloud", this.isPlayMusicCloud);
            jSONObject.put("extName", this.extname);
            jSONObject.put("guessYouLikeMark", getGuessYouLikeMark());
            jSONObject.put("audioType", getAudioType());
            jSONObject.put("sort", getSort());
            jSONObject.put("audioIndex", getAudioIndex());
            if (getRecSongInfo() != null) {
                jSONObject.put("recSongInfo", getRecSongInfo().toJsonObject());
            }
            if (getExtraInfo() != null) {
                jSONObject.put("extraInfo", getExtraInfo().toJsonObj());
            }
            jSONObject.put("guessYouLikeBiString", getGuessYouLikeBiString());
            MusicTransParamEnenty.toJSONObject(jSONObject, this);
            jSONObject.put("musicSource", getMusicSource());
            jSONObject.put("oldMixId", getMixId());
            jSONObject.put("musicLinkExtInfo", getMusicLinkExtInfo());
        } catch (JSONException e2) {
            g0.k(e2);
        }
        return jSONObject;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0158  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.kugou.android.watch.lite.common.music.entity.KGFile toKGFile(com.kugou.android.watch.lite.common.music.entity.SongQuality r7) {
        /*
            Method dump skipped, instruction units count: 491
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kugou.android.watch.lite.common.music.entity.KGMusic.toKGFile(com.kugou.android.watch.lite.common.music.entity.SongQuality):com.kugou.android.watch.lite.common.music.entity.KGFile");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeLong(this.sid);
        parcel.writeString(this.displayName);
        parcel.writeString(this.trackName);
        parcel.writeString(this.albumName);
        parcel.writeLong(this.albumID);
        parcel.writeLong(this.trackID);
        parcel.writeString(this.artistName);
        parcel.writeString(this.genre);
        parcel.writeLong(this.artistID);
        parcel.writeLong(this.size);
        parcel.writeString(this.hashValue);
        parcel.writeString(this.musicpath);
        parcel.writeInt(this.bitrate);
        parcel.writeLong(this.duration);
        parcel.writeString(this.m4aHash);
        parcel.writeLong(this.m4aSize);
        parcel.writeString(this.m4aUrl);
        parcel.writeString(this.hash320);
        parcel.writeLong(this.size320);
        parcel.writeString(this.sqHash);
        parcel.writeLong(this.sqSize);
        parcel.writeString(this.mvHashValue);
        parcel.writeInt(this.mvTracks);
        parcel.writeInt(this.mvType);
        parcel.writeLong(this.mvMatchTime);
        parcel.writeInt(this.isExclusivePublish ? 1 : 0);
        parcel.writeInt(this.feeType);
        parcel.writeInt(this.isnew);
        parcel.writeString(this.fullName);
        parcel.writeString(this.source);
        parcel.writeInt(this.srctype);
        parcel.writeInt(this.isInsertPlay);
        parcel.writeInt(this.hashType);
        parcel.writeString(this.imgUrl);
        parcel.writeString(this.sourceType);
        parcel.writeString(this.sourceHash);
        parcel.writeLong(this.fileId);
        parcel.writeInt(this.charge);
        parcel.writeInt(this.maskOfForceDownload);
        parcel.writeString(this.behavior);
        parcel.writeString(this.module);
        parcel.writeInt(this.songSource);
        parcel.writeString(this.accompanimentHash);
        parcel.writeLong(this.accompanimentTime);
        parcel.writeInt(this.accompanimentId);
        parcel.writeInt(this.has_accompany);
        parcel.writeInt(this.inList);
        parcel.writeString(this.feeAlbumId);
        parcel.writeString(this.channelCommentId);
        parcel.writeLong(this.mixId);
        parcel.writeLong(this.audioId);
        parcel.writeInt(this.authorId);
        parcel.writeInt(this.specialId);
        parcel.writeInt(this.rankId);
        parcel.writeLong(this.id);
        parcel.writeString(this.curMark);
        parcel.writeString(this.remark);
        parcel.writeString(this.topic);
        parcel.writeInt(this.ugcReviewed);
        parcel.writeInt(this.qualityFeeSource);
        parcel.writeString(this.songType);
        parcel.writeInt(this.failProcess);
        parcel.writeInt(this.payType);
        parcel.writeString(this.musicFeeType);
        parcel.writeLong(this.updateFeeStatusTime);
        parcel.writeInt(this.fileEncryptType);
        parcel.writeInt(this.oldCpy);
        parcel.writeInt(this.isFileDownloaded ? 1 : 0);
        parcel.writeInt(this.isPlayMusicCloud ? 1 : 0);
        parcel.writeString(this.curMark);
        parcel.writeInt(this.playListId);
        parcel.writeInt(this.playListCreateListId);
        parcel.writeInt(this.playListType);
        parcel.writeString(this.playListName);
        parcel.writeLong(this.playListCreateUserId);
        parcel.writeInt(this.playListCloudListId);
        parcel.writeInt(this.playListSource);
        parcel.writeInt(this.musicLinkSource);
        parcel.writeInt(this.musiclibId);
        parcel.writeString(this.playListCreateUserName);
        parcel.writeString(this.mPlayListPicPath);
        parcel.writeParcelableArray(this.singerInfos, i2);
        parcel.writeParcelable(this.mMusicCloudInfo, i2);
        parcel.writeString(this.extname);
        parcel.writeString(this.mSpecialOrAlbumName);
        parcel.writeInt(this.guessYouLikeMark);
        parcel.writeInt(this.audioType);
        parcel.writeInt(this.sort);
        parcel.writeInt(this.audioIndex);
        parcel.writeParcelable(this.recSongInfo, i2);
        parcel.writeString(this.publishYear);
        parcel.writeLong(this.publishYearMatchTime);
        parcel.writeInt(this.isUserSetPublishYear ? 1 : 0);
        parcel.writeString(this.language);
        parcel.writeLong(this.languageMatchTime);
        parcel.writeInt(this.isUserSetLanguage ? 1 : 0);
        parcel.writeInt(this.isReset ? 1 : 0);
        parcel.writeString(this.guessYouLikeBiString);
        parcel.writeString(this.sk);
        MusicTransParamEnenty.toParcel(parcel, i2, this);
        parcel.writeInt(this.musicSource);
        parcel.writeLong(this.oldMixId);
        parcel.writeParcelable(this.extraInfo, i2);
        parcel.writeString(this.musicLinkExtInfo);
        parcel.writeString(this.extParams);
        parcel.writeString(this.globalCollectionId);
    }

    public static String makeFileKey(String str, SongQuality songQuality, long j) {
        return str + "-" + songQuality.getType() + "-" + String.valueOf(j);
    }

    @Deprecated
    public static List<KGSong> toKgSongArray(List<? extends KGMusic> list) {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < list.size(); i2++) {
            arrayList.add(list.get(i2).buildKgSong());
        }
        return arrayList;
    }

    @Ignore
    public KGMusic(String str) {
        this.extUniqueId = -1;
        this.dbId = 0L;
        this.id = 0L;
        this.gif_id = -1;
        this.fileOrderWeight = -1;
        this.collectTime = 0L;
        this.sid = -1L;
        this.fileId = -1L;
        this.hashType = -100;
        this.feeType = -1;
        this.fullName = "";
        this.source = "未知来源";
        this.sourceType = "";
        this.genreId = -1;
        this.albumMatchTime = 0L;
        this.isInsertPlay = 0;
        this.sourceMode = -1;
        this.oldCpy = -1;
        this.mDownloadStatus = 0;
        this.fromLocalMusic = false;
        this.isUserPlay = false;
        this.audioType = 0;
        this.sort = 0;
        this.audioIndex = 0;
        this.maskOfForceDownload = -1;
        this.guessYouLikeMark = -1;
        this.guessYouLikeBiString = "";
        this.source = str;
    }

    @Ignore
    public KGMusic(Parcel parcel) {
        this.extUniqueId = -1;
        this.dbId = 0L;
        this.id = 0L;
        this.gif_id = -1;
        this.fileOrderWeight = -1;
        this.collectTime = 0L;
        this.sid = -1L;
        this.fileId = -1L;
        this.hashType = -100;
        this.feeType = -1;
        this.fullName = "";
        this.source = "未知来源";
        this.sourceType = "";
        this.genreId = -1;
        this.albumMatchTime = 0L;
        this.isInsertPlay = 0;
        this.sourceMode = -1;
        this.oldCpy = -1;
        this.mDownloadStatus = 0;
        this.fromLocalMusic = false;
        this.isUserPlay = false;
        this.audioType = 0;
        this.sort = 0;
        this.audioIndex = 0;
        this.maskOfForceDownload = -1;
        this.guessYouLikeMark = -1;
        this.guessYouLikeBiString = "";
        this.sid = parcel.readLong();
        this.displayName = parcel.readString();
        this.trackName = parcel.readString();
        this.albumName = parcel.readString();
        this.albumID = parcel.readLong();
        this.trackID = parcel.readLong();
        this.artistName = parcel.readString();
        this.genre = parcel.readString();
        this.artistID = parcel.readLong();
        this.size = parcel.readLong();
        this.hashValue = parcel.readString();
        this.musicpath = parcel.readString();
        this.bitrate = parcel.readInt();
        this.duration = parcel.readLong();
        setM4aHash(parcel.readString());
        this.m4aSize = parcel.readLong();
        this.m4aUrl = parcel.readString();
        this.hash320 = parcel.readString();
        this.size320 = parcel.readLong();
        this.sqHash = parcel.readString();
        this.sqSize = parcel.readLong();
        this.mvHashValue = parcel.readString();
        this.mvTracks = parcel.readInt();
        this.mvType = parcel.readInt();
        this.mvMatchTime = parcel.readLong();
        this.isExclusivePublish = parcel.readInt() == 1;
        this.feeType = parcel.readInt();
        this.isnew = parcel.readInt();
        this.fullName = parcel.readString();
        this.source = parcel.readString();
        this.srctype = parcel.readInt();
        this.isInsertPlay = parcel.readInt();
        setHashType(parcel.readInt());
        this.imgUrl = parcel.readString();
        this.sourceType = parcel.readString();
        this.sourceHash = parcel.readString();
        this.fileId = parcel.readLong();
        this.charge = parcel.readInt();
        this.maskOfForceDownload = parcel.readInt();
        this.behavior = parcel.readString();
        this.module = parcel.readString();
        this.songSource = parcel.readInt();
        this.accompanimentHash = parcel.readString();
        this.accompanimentTime = parcel.readLong();
        this.accompanimentId = parcel.readInt();
        this.has_accompany = parcel.readInt();
        this.inList = parcel.readInt();
        this.feeAlbumId = parcel.readString();
        this.channelCommentId = parcel.readString();
        this.mixId = parcel.readLong();
        this.audioId = parcel.readLong();
        this.authorId = parcel.readInt();
        this.specialId = parcel.readInt();
        this.rankId = parcel.readInt();
        this.id = parcel.readLong();
        this.curMark = parcel.readString();
        this.remark = parcel.readString();
        this.topic = parcel.readString();
        this.ugcReviewed = parcel.readInt();
        this.qualityFeeSource = parcel.readInt();
        this.songType = parcel.readString();
        this.failProcess = parcel.readInt();
        this.payType = parcel.readInt();
        this.musicFeeType = parcel.readString();
        this.updateFeeStatusTime = parcel.readLong();
        this.fileEncryptType = parcel.readInt();
        this.oldCpy = parcel.readInt();
        this.isFileDownloaded = parcel.readInt() == 1;
        this.isPlayMusicCloud = parcel.readInt() == 1;
        this.curMark = parcel.readString();
        this.playListId = parcel.readInt();
        this.playListCreateListId = parcel.readInt();
        this.playListType = parcel.readInt();
        this.playListName = parcel.readString();
        this.playListCreateUserId = parcel.readLong();
        this.playListCloudListId = parcel.readInt();
        this.playListSource = parcel.readInt();
        this.musicLinkSource = parcel.readInt();
        this.musiclibId = parcel.readInt();
        this.playListCreateUserName = parcel.readString();
        this.mPlayListPicPath = parcel.readString();
        Parcelable[] parcelableArray = parcel.readParcelableArray(SingerInfo.class.getClassLoader());
        if (parcelableArray != null) {
            this.singerInfos = (SingerInfo[]) Arrays.copyOf(parcelableArray, parcelableArray.length, SingerInfo[].class);
        }
        this.mMusicCloudInfo = (MusicCloudInfo) parcel.readParcelable(MusicCloudInfo.class.getClassLoader());
        this.extname = parcel.readString();
        this.mSpecialOrAlbumName = parcel.readString();
        this.guessYouLikeMark = parcel.readInt();
        setAudioType(parcel.readInt());
        setSort(parcel.readInt());
        setAudioIndex(parcel.readInt());
        this.recSongInfo = (RecSongInfo) parcel.readParcelable(RecSongInfo.class.getClassLoader());
        this.publishYear = parcel.readString();
        this.publishYearMatchTime = parcel.readLong();
        this.isUserSetPublishYear = parcel.readInt() == 1;
        this.language = parcel.readString();
        this.languageMatchTime = parcel.readLong();
        this.isUserSetLanguage = parcel.readInt() == 1;
        this.isReset = parcel.readInt() == 1;
        this.guessYouLikeBiString = parcel.readString();
        this.sk = parcel.readString();
        MusicTransParamEnenty.toEntity(parcel, this);
        this.musicSource = parcel.readInt();
        this.oldMixId = parcel.readLong();
        this.extraInfo = (ExtraInfo) parcel.readParcelable(ExtraInfo.class.getClassLoader());
        this.musicLinkExtInfo = parcel.readString();
        this.extParams = parcel.readString();
        this.globalCollectionId = parcel.readString();
    }
}
