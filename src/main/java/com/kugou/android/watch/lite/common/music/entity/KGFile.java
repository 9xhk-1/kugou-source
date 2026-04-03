package com.kugou.android.watch.lite.common.music.entity;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.kugou.android.watch.lite.base.musicfees.mediastore.entity.TrackerInfo;
import com.kugou.android.watch.lite.common.INoGuard;
import com.kugou.common.filemanager.downloadengine.HashSource;
import com.kugou.common.filemanager.downloadengine.HashSourceUtil;
import e.c.a.g.a.s.f0;
import e.c.a.g.a.s.g0;
import e.c.a.g.a.s.r0;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class KGFile implements Parcelable, r0.a, INoGuard {
    public static final String BEH_DOWNLOAD = "download";
    public static final String BEH_PLAY = "play";
    public static final Parcelable.Creator<KGFile> CREATOR = new a();
    private String addedTime;
    private String albumname;
    private int bitrate;
    private String channelCommentId;
    private int classid;
    private int cloudVersion;
    private String couponID;
    private long duration;
    private String extParams;
    private String extname;
    private ExtraInfo extraInfo;
    private int failProcess;
    private int fileEncryptType;
    private String filehash;
    private String filepath;
    private long filesize;
    private String fileuserkey;
    private String guessYouLikeBiString;
    private int guessYouLikeMark;
    private boolean hasCharged;
    private boolean isEncryptDownload;
    private boolean isFromLocalMusic;
    private boolean isFromYueKu;
    private boolean isPlayMusicCloud;
    private boolean isReset;
    private boolean isUnusualSong;
    private String lastModifyTime;
    private String mSpecialOrAlbumName;
    private long maxSpeed;
    private boolean memoryOnly;
    private String mimetype;
    private String musicFeeType;
    private String musicLinkExtInfo;
    private int musicLinkSource;
    private int musicSource;
    private MusicTransParamEnenty musicTransParamEnenty;
    private String musichash;
    private String musicname;
    private String oldUserKeyForMemoryOnly;
    private int p2pTurnCDNMilliseconds;
    private String parenPath;
    private int payType;
    private boolean priorityCDN;
    private int privilege;
    private String singer;
    private String sk;
    private int songSource;
    private String source;
    private String sourceHash;
    private String targetDir;
    private String targetPath;
    private String trackName;
    private TrackerInfo trackerInfo;
    private long updateFeeStatusTime;
    private String userDownloadUrl;
    private String[] userDownloadUrls;
    private long fileid = -1;

    @HashSource
    private int p2pSource = 1;
    private int qualitytype = -1;
    private String sourceType = "";
    private boolean isCharge = false;
    private String behavior = "play";
    private String module = "";
    private int authorId = 0;
    private String albumID = "";
    private long mixId = 0;
    private long audioId = 0;
    private int maskOfForceDownload = -1;
    private boolean isFree = false;
    private int nameType = -1;
    private boolean p2pCacheOnly = false;
    private int headSeconds = 0;
    private int audioType = 0;
    private int sort = 0;
    private int audioIndex = 0;
    private int oldCpy = -1;
    public boolean forcePlay = false;

    public class a implements Parcelable.Creator<KGFile> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public KGFile createFromParcel(Parcel parcel) {
            KGFile kGFile = new KGFile();
            kGFile.readFromParcel(parcel);
            return kGFile;
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public KGFile[] newArray(int i2) {
            return new KGFile[i2];
        }
    }

    public static KGFile createFromJson(JSONObject jSONObject) {
        KGFile kGFile = new KGFile();
        kGFile.setAlbumname(jSONObject.optString("albumname"));
        kGFile.setBitrate(jSONObject.optInt("bitrate"));
        kGFile.setClassid(jSONObject.optInt("classid"));
        kGFile.setDuration(jSONObject.optLong("duration"));
        kGFile.setExtname(jSONObject.optString("extname"));
        kGFile.setP2pSource(HashSourceUtil.valueOfInt(jSONObject.optInt("p2pSource")));
        kGFile.setFilehash(jSONObject.optString("filehash"));
        kGFile.setFileid(jSONObject.optLong("fileid", -1L));
        kGFile.setFilepath(jSONObject.optString("filepath"));
        kGFile.setFilesize(jSONObject.optLong("filesize"));
        kGFile.setFileuserkey(jSONObject.optString("fileuserkey"));
        kGFile.setMimetype(jSONObject.optString("mimetype"));
        kGFile.setMusichash(jSONObject.optString("musichash"));
        kGFile.setMusicname(jSONObject.optString("musicname"));
        kGFile.setParenPath(jSONObject.optString("parenPath"));
        kGFile.setTargetPath(jSONObject.optString("targetPath"));
        kGFile.setTargetDir(jSONObject.optString("targetDir"));
        kGFile.setQualitytype(jSONObject.optInt("qualitytype", -1));
        kGFile.setSinger(jSONObject.optString("singer"));
        kGFile.setSource(jSONObject.optString("source"));
        kGFile.setSourceType(jSONObject.optString("sourceType"));
        kGFile.setTrackName(jSONObject.optString("trackName"));
        kGFile.setUserDownloadUrl(jSONObject.optString("userDownloadUrl"));
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("userDownloadUrls");
        if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
            int length = jSONArrayOptJSONArray.length();
            String[] strArr = new String[length];
            for (int i2 = 0; i2 < length; i2++) {
                strArr[i2] = jSONArrayOptJSONArray.optString(i2);
            }
            kGFile.setUserDownloadUrls(strArr);
        }
        kGFile.setCharge(jSONObject.optInt("isCharge") == 1);
        kGFile.setBehavior(jSONObject.optString("behavior"));
        kGFile.setModule(jSONObject.optString("module"));
        kGFile.setAlbumID(jSONObject.optString("albumID"));
        kGFile.setMixId(jSONObject.optLong("mixId"));
        kGFile.setMemoryOnly(jSONObject.optInt("memoryOnly") == 1);
        kGFile.setCloudVersion(jSONObject.optInt("cloudVersion"));
        kGFile.setAuthorId(jSONObject.optInt("authorId", 0));
        kGFile.setIsFromYueKu(jSONObject.optInt("isfromyueku") == 1);
        kGFile.setFromLocalMusic(jSONObject.optInt("isFromLocalMusic") == 1);
        kGFile.setNameType(jSONObject.optInt("nameType", -1));
        kGFile.setTrackName(jSONObject.optString("trackName"));
        kGFile.setSongSource(jSONObject.optInt("songSource"));
        kGFile.setFailProcess(jSONObject.optInt("failProcess"));
        kGFile.setPayType(jSONObject.optInt("payType"));
        kGFile.setMusicFeeType(jSONObject.optString("musicFeeType"));
        kGFile.setMaskOfForceDownload(jSONObject.optInt("maskOfForceDownload", -1));
        kGFile.setUpdateFeeStatusTime(jSONObject.optLong("updateFeeStatusTime"));
        kGFile.setOldCpy(jSONObject.optInt("oldCpy", -1));
        kGFile.setPrivilege(jSONObject.optInt("privilege"));
        kGFile.setMusicLinkSource(jSONObject.optInt("musicLinkSource"));
        kGFile.setPriorityCDN(jSONObject.optInt("priorityCDN") == 1);
        kGFile.setAudioId(jSONObject.optLong("audioId"));
        kGFile.setmSpecialOrAlbumName(jSONObject.optString("specialOrAlbumName"));
        kGFile.setGuessYouLikeMark(jSONObject.optInt("guessYouLikeMark"));
        kGFile.setReset(jSONObject.optBoolean("isReset", false));
        kGFile.setAudioType(jSONObject.optInt("audioType", 0));
        kGFile.setSort(jSONObject.optInt("sort", 0));
        kGFile.setMusicSource(jSONObject.optInt("musicSource", 0));
        kGFile.setSk(jSONObject.optString("sk", "0,9"));
        kGFile.setTrackerInfo(TrackerInfo.fromJsonObj(jSONObject.optJSONObject("trackerInfo")));
        kGFile.setCouponID(jSONObject.optString("couponID"));
        MusicTransParamEnenty.jsonToEnenty(jSONObject, kGFile);
        kGFile.setGuessYouLikeBiString(jSONObject.optString("guessYouLikeBiString"));
        kGFile.setMusicLinkExtInfo(jSONObject.optString("musicLinkExtInfo"));
        kGFile.setExtParams(jSONObject.optString("ext_params"));
        kGFile.applyExtraInfo(ExtraInfo.fromJsonObj(jSONObject.optJSONObject("extraInfo")));
        kGFile.setMusicLinkSource(jSONObject.optInt("musicLinkSource"));
        kGFile.setChannelCommentId(jSONObject.optString("channelId"));
        return kGFile;
    }

    public void applyExtraInfo(ExtraInfo extraInfo) {
        ExtraInfo extraInfo2 = this.extraInfo;
        if (extraInfo2 == null) {
            this.extraInfo = extraInfo;
        } else {
            extraInfo2.apply(extraInfo);
        }
    }

    public boolean canUseEncryptDownload() {
        return this.maskOfForceDownload < 0;
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
        if (!(obj instanceof KGFile)) {
            return false;
        }
        KGFile kGFile = (KGFile) obj;
        if (this.fileid == -1 || kGFile.getFileid() == -1 || this.fileid != kGFile.getFileid()) {
            return false;
        }
        return (this.mixId <= 0 || kGFile.getMixId() <= 0) ? this.mixId <= 0 && kGFile.getMixId() <= 0 && !TextUtils.isEmpty(this.musichash) && !TextUtils.isEmpty(kGFile.getMusichash()) && !TextUtils.isEmpty(this.musicname) && !TextUtils.isEmpty(kGFile.getMusicname()) && this.musichash.equals(kGFile.getMusichash()) && this.musicname.equals(kGFile.getMusicname()) : this.mixId == kGFile.getMixId();
    }

    public String getAddedTime() {
        return this.addedTime;
    }

    public String getAlbumID() {
        String str = this.albumID;
        return str == null ? "" : str;
    }

    public String getAlbumname() {
        return this.albumname;
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

    public int getAuthorId() {
        return this.authorId;
    }

    public String getBehavior() {
        return this.behavior;
    }

    public int getBitrate() {
        return this.bitrate;
    }

    public String getChannelCommentId() {
        return this.channelCommentId;
    }

    public int getClassid() {
        return this.classid;
    }

    public int getCloudVersion() {
        return this.cloudVersion;
    }

    public String getCouponID() {
        return this.couponID;
    }

    public long getDuration() {
        return this.duration;
    }

    public long getDurationSeconds() {
        return this.duration / 1000;
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

    public int getFileEncryptType() {
        return this.fileEncryptType;
    }

    public String getFilehash() {
        if (getQualitytype() == SongQuality.QUALITY_LOW.getType() && !TextUtils.isEmpty(getMusichash()) && getClassid() != 20) {
            return getMusichash().toLowerCase();
        }
        String str = this.filehash;
        if (str != null) {
            return str.toLowerCase();
        }
        return null;
    }

    public long getFileid() {
        return this.fileid;
    }

    public String getFilepath() {
        return this.filepath;
    }

    public long getFilesize() {
        return this.filesize;
    }

    public String getFileuserkey() {
        return this.fileuserkey;
    }

    public int getForcePlayModuleId() {
        TrackerInfo trackerInfo = getTrackerInfo();
        if (trackerInfo == null) {
            return Integer.MIN_VALUE;
        }
        return trackerInfo.getMoudleId();
    }

    public String getGuessYouLikeBiString() {
        return this.guessYouLikeBiString;
    }

    public int getGuessYouLikeMark() {
        return this.guessYouLikeMark;
    }

    public int getHeadSeconds() {
        return this.headSeconds;
    }

    public boolean getIsFree() {
        return this.isFree;
    }

    public boolean getIsFromYueKu() {
        return this.isFromYueKu;
    }

    public String getLastModifyTime() {
        return this.lastModifyTime;
    }

    public String getLocalUpdateDataName() {
        return this.trackName;
    }

    public int getMaskOfForceDownload() {
        return this.maskOfForceDownload;
    }

    public long getMaxSpeed() {
        return this.maxSpeed;
    }

    public String getMimetype() {
        return this.mimetype;
    }

    public long getMixId() {
        return this.mixId;
    }

    public String getModule() {
        return this.module;
    }

    public String getMusicFeeType() {
        return this.musicFeeType;
    }

    public String getMusicLinkExtInfo() {
        return this.musicLinkExtInfo;
    }

    public int getMusicLinkSource() {
        return this.musicLinkSource;
    }

    public int getMusicSource() {
        return this.musicSource;
    }

    @Override // e.c.a.g.a.s.r0.a
    public MusicTransParamEnenty getMusicTransParamEnenty() {
        return this.musicTransParamEnenty;
    }

    public String getMusichash() {
        String str = this.musichash;
        return str != null ? str.toLowerCase() : "";
    }

    public String getMusicname() {
        return this.musicname;
    }

    public int getNameType() {
        return this.nameType;
    }

    public int getOldCpy() {
        return this.oldCpy;
    }

    public int getP2PTurnCDNMilliseconds() {
        return this.p2pTurnCDNMilliseconds;
    }

    @HashSource
    public int getP2pSource() {
        return this.p2pSource;
    }

    public String getParenPath() {
        return this.parenPath;
    }

    public int getPayType() {
        return this.payType;
    }

    public int getPrivilege() {
        return this.privilege;
    }

    public int getQualitytype() {
        return this.qualitytype;
    }

    public String getRealFilehash() {
        String str = this.filehash;
        if (str != null) {
            return str.toLowerCase();
        }
        return null;
    }

    public String getSinger() {
        String musicname = getMusicname();
        if (!TextUtils.isEmpty(musicname) && TextUtils.isEmpty(this.singer)) {
            int iIndexOf = musicname.indexOf(" - ");
            if (iIndexOf == -1) {
                iIndexOf = musicname.indexOf("-");
            }
            if (iIndexOf > 0) {
                this.singer = musicname.substring(0, iIndexOf).trim();
            }
        }
        if (TextUtils.isEmpty(this.singer)) {
            this.singer = "未知歌手";
        }
        return this.singer;
    }

    public String getSk() {
        return this.sk;
    }

    public int getSongSource() {
        return this.songSource;
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

    public String getSourceType() {
        if (TextUtils.isEmpty(this.sourceType)) {
            this.sourceType = "";
        }
        return this.sourceType;
    }

    public String getTargetDir() {
        return this.targetDir;
    }

    public String getTargetPath() {
        return this.targetPath;
    }

    public String getTrackName() {
        String musicname = getMusicname();
        if (TextUtils.isEmpty(this.trackName) && !TextUtils.isEmpty(musicname)) {
            int iIndexOf = musicname.indexOf(" - ");
            int i2 = iIndexOf + 3;
            if (iIndexOf == -1) {
                iIndexOf = musicname.indexOf("-");
                i2 = iIndexOf + 1;
            }
            if (iIndexOf <= 0 || musicname.length() <= iIndexOf) {
                this.trackName = musicname;
            } else {
                this.trackName = musicname.substring(i2).trim();
            }
        }
        return this.trackName;
    }

    public TrackerInfo getTrackerInfo() {
        return this.trackerInfo;
    }

    public long getUpdateFeeStatusTime() {
        return this.updateFeeStatusTime;
    }

    public String getUserDownloadUrl() {
        return this.userDownloadUrl;
    }

    public String[] getUserDownloadUrls() {
        return this.userDownloadUrls;
    }

    public String getmSpecialOrAlbumName() {
        return this.mSpecialOrAlbumName;
    }

    public boolean hasCharged() {
        return this.hasCharged;
    }

    public int hashCode() {
        if (TextUtils.isEmpty(this.musicname) || TextUtils.isEmpty(this.musichash)) {
            return super.hashCode();
        }
        long j = this.fileid;
        int iHashCode = ((((((int) (j ^ (j >>> 32))) * 31) + this.musicname.hashCode()) * 31) + this.musichash.hashCode()) * 31;
        long j2 = this.mixId;
        return iHashCode + ((int) (j2 ^ (j2 >>> 32)));
    }

    public boolean isCharge() {
        return this.isCharge;
    }

    public boolean isEncryptDownload() {
        return this.isEncryptDownload;
    }

    public boolean isForcePlay() {
        return this.forcePlay;
    }

    public boolean isFromLocalMusic() {
        return this.isFromLocalMusic;
    }

    public boolean isMemoryOnly() {
        return this.memoryOnly;
    }

    public boolean isP2PCacheOnly() {
        return this.p2pCacheOnly;
    }

    public boolean isPlayMusicCloud() {
        return this.isPlayMusicCloud;
    }

    public boolean isPriorityCDN() {
        return this.priorityCDN;
    }

    public boolean isUnusualSong() {
        return this.isUnusualSong;
    }

    public void readFromParcel(Parcel parcel) {
        this.fileid = parcel.readLong();
        this.fileuserkey = parcel.readString();
        this.p2pSource = HashSourceUtil.valueOfInt(parcel.readInt());
        this.filehash = parcel.readString();
        this.filesize = parcel.readLong();
        this.extname = parcel.readString();
        this.filepath = parcel.readString();
        this.parenPath = parcel.readString();
        this.targetPath = parcel.readString();
        this.targetDir = parcel.readString();
        this.source = parcel.readString();
        this.musicname = parcel.readString();
        this.musichash = parcel.readString();
        this.qualitytype = parcel.readInt();
        this.bitrate = parcel.readInt();
        this.duration = parcel.readLong();
        this.singer = parcel.readString();
        this.albumname = parcel.readString();
        this.mimetype = parcel.readString();
        this.classid = parcel.readInt();
        this.userDownloadUrl = parcel.readString();
        this.userDownloadUrls = parcel.createStringArray();
        this.sourceType = parcel.readString();
        this.addedTime = parcel.readString();
        this.lastModifyTime = parcel.readString();
        this.isCharge = parcel.readInt() == 1;
        this.behavior = parcel.readString();
        this.module = parcel.readString();
        this.albumID = parcel.readString();
        this.mixId = parcel.readLong();
        this.hasCharged = parcel.readInt() == 1;
        this.isEncryptDownload = parcel.readInt() == 1;
        this.maskOfForceDownload = parcel.readInt();
        this.memoryOnly = parcel.readInt() == 1;
        this.cloudVersion = parcel.readInt();
        this.isFree = parcel.readInt() == 1;
        this.maxSpeed = parcel.readLong();
        this.authorId = parcel.readInt();
        this.isFromYueKu = parcel.readInt() == 1;
        this.isFromLocalMusic = parcel.readInt() == 1;
        this.nameType = parcel.readInt();
        this.trackName = parcel.readString();
        this.sourceHash = parcel.readString();
        this.songSource = parcel.readInt();
        this.failProcess = parcel.readInt();
        this.musicFeeType = parcel.readString();
        this.payType = parcel.readInt();
        this.fileEncryptType = parcel.readInt();
        this.updateFeeStatusTime = parcel.readLong();
        this.oldCpy = parcel.readInt();
        this.privilege = parcel.readInt();
        this.musicLinkSource = parcel.readInt();
        this.priorityCDN = parcel.readInt() == 1;
        this.audioId = parcel.readLong();
        this.p2pCacheOnly = parcel.readInt() == 1;
        this.isPlayMusicCloud = parcel.readInt() == 1;
        this.p2pTurnCDNMilliseconds = parcel.readInt();
        this.headSeconds = parcel.readInt();
        this.mSpecialOrAlbumName = parcel.readString();
        this.guessYouLikeMark = parcel.readInt();
        this.isReset = parcel.readInt() == 1;
        setAudioType(parcel.readInt());
        setSort(parcel.readInt());
        this.guessYouLikeBiString = parcel.readString();
        this.sk = parcel.readString();
        MusicTransParamEnenty.toEntity(parcel, this);
        this.musicSource = parcel.readInt();
        this.trackerInfo = (TrackerInfo) parcel.readParcelable(TrackerInfo.class.getClassLoader());
        this.forcePlay = parcel.readInt() == 1;
        this.couponID = parcel.readString();
        this.musicLinkExtInfo = parcel.readString();
        this.extParams = parcel.readString();
        this.extraInfo = (ExtraInfo) parcel.readParcelable(ExtraInfo.class.getClassLoader());
        this.musicLinkSource = parcel.readInt();
        this.channelCommentId = parcel.readString();
    }

    public void setAddedTime(String str) {
        this.addedTime = str;
    }

    public void setAlbumID(String str) {
        if (g0.a && str == null) {
            f0.h("albumID can't be null, please check!!!");
        }
        this.albumID = str;
    }

    public void setAlbumname(String str) {
        this.albumname = str;
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

    public void setAuthorId(int i2) {
        this.authorId = i2;
    }

    public void setBehavior(String str) {
        this.behavior = str;
    }

    public void setBitrate(int i2) {
        this.bitrate = i2;
    }

    public void setChannelCommentId(String str) {
        this.channelCommentId = str;
    }

    public void setCharge(boolean z) {
        this.isCharge = z;
    }

    public void setClassid(int i2) {
        this.classid = i2;
    }

    public void setCloudVersion(int i2) {
        this.cloudVersion = i2;
    }

    public void setCouponID(String str) {
        this.couponID = str;
    }

    public void setDuration(long j) {
        this.duration = j;
    }

    public void setEncryptDownload(boolean z) {
        this.isEncryptDownload = z;
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

    public void setFileEncryptType(int i2) {
        this.fileEncryptType = i2;
    }

    public void setFilehash(String str) {
        this.filehash = str;
    }

    public KGFile setFileid(long j) {
        this.fileid = j;
        return this;
    }

    public void setFilepath(String str) {
        this.filepath = str;
    }

    public void setFilesize(long j) {
        this.filesize = j;
    }

    public void setFileuserkey(String str) {
        this.fileuserkey = str;
    }

    public void setForcePlay(boolean z) {
        this.forcePlay = z;
    }

    public void setFromLocalMusic(boolean z) {
        this.isFromLocalMusic = z;
    }

    public void setGuessYouLikeBiString(String str) {
        this.guessYouLikeBiString = str;
    }

    public void setGuessYouLikeMark(int i2) {
        this.guessYouLikeMark = i2;
    }

    public void setHasCharged(boolean z) {
        this.hasCharged = z;
    }

    public void setHeadSeconds(int i2) {
        this.headSeconds = i2;
    }

    public void setIsFree(boolean z) {
        this.isFree = z;
    }

    public void setIsFromYueKu(boolean z) {
        this.isFromYueKu = z;
    }

    public void setLastModifyTime(String str) {
        this.lastModifyTime = str;
    }

    public void setMaskOfForceDownload(int i2) {
        this.maskOfForceDownload = i2;
    }

    public void setMaxSpeed(long j) {
        this.maxSpeed = j;
    }

    public void setMemoryOnly(boolean z) {
        if (z && !this.memoryOnly) {
            this.oldUserKeyForMemoryOnly = getFileuserkey();
            setFileuserkey(KGMusic.makeInMemoryFileKey(getFilehash()));
        } else if (!z && this.memoryOnly) {
            setFileuserkey(this.oldUserKeyForMemoryOnly);
        }
        this.memoryOnly = z;
    }

    public void setMimetype(String str) {
        this.mimetype = str;
    }

    public void setMixId(long j) {
        if (j > 0 || this.isReset) {
            this.mixId = j;
        }
    }

    public void setModule(String str) {
        this.module = str;
    }

    public void setMusicFeeType(String str) {
        this.musicFeeType = str;
    }

    public void setMusicLinkExtInfo(String str) {
        this.musicLinkExtInfo = str;
    }

    public void setMusicLinkSource(int i2) {
        if (this.musicLinkSource > 0 || i2 <= 0) {
            return;
        }
        this.musicLinkSource = i2;
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

    public void setMusichash(String str) {
        this.musichash = str;
    }

    public void setMusicname(String str) {
        this.musicname = str;
    }

    public void setNameType(int i2) {
        this.nameType = i2;
    }

    public void setOldCpy(int i2) {
        this.oldCpy = i2;
    }

    public void setP2PCacheOnly(boolean z) {
        this.p2pCacheOnly = z;
    }

    public void setP2PTurnCDNMilliseconds(int i2) {
        this.p2pTurnCDNMilliseconds = i2;
    }

    public void setP2pSource(@HashSource int i2) {
        this.p2pSource = i2;
    }

    public void setParenPath(String str) {
        this.parenPath = str;
    }

    public void setPayType(int i2) {
        this.payType = i2;
    }

    public void setPlayMusicCloud(boolean z) {
        this.isPlayMusicCloud = z;
    }

    public void setPriorityCDN(boolean z) {
        this.priorityCDN = z;
    }

    public void setPrivilege(int i2) {
        this.privilege = i2;
    }

    public void setQualitytype(int i2) {
        this.qualitytype = i2;
    }

    public void setReset(boolean z) {
        this.isReset = z;
    }

    public void setSinger(String str) {
        this.singer = str;
    }

    public void setSk(String str) {
        this.sk = str;
    }

    public void setSongSource(int i2) {
        this.songSource = i2;
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

    public void setSourceType(String str) {
        this.sourceType = str;
    }

    public void setTargetDir(String str) {
        this.targetDir = str;
    }

    public void setTargetPath(String str) {
        this.targetPath = str;
    }

    public void setTrackName(String str) {
        this.trackName = str;
    }

    public void setTrackerInfo(TrackerInfo trackerInfo) {
        this.trackerInfo = trackerInfo;
    }

    public void setUnusualSong(boolean z) {
        this.isUnusualSong = z;
    }

    public void setUpdateFeeStatusTime(long j) {
        this.updateFeeStatusTime = j;
    }

    public void setUserDownloadUrl(String str) {
        this.userDownloadUrl = str;
        if (TextUtils.isEmpty(str) || this.userDownloadUrls != null) {
            return;
        }
        this.userDownloadUrls = new String[]{str};
    }

    public void setUserDownloadUrls(String[] strArr) {
        if (strArr != null && strArr.length == 0) {
            strArr = null;
        }
        this.userDownloadUrls = strArr;
        if (!TextUtils.isEmpty(this.userDownloadUrl) || strArr == null || strArr.length <= 0 || TextUtils.isEmpty(strArr[0])) {
            return;
        }
        this.userDownloadUrl = strArr[0];
    }

    public void setmSpecialOrAlbumName(String str) {
        this.mSpecialOrAlbumName = str;
    }

    public JSONObject toJSONObject() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("albumname", this.albumname);
            jSONObject.put("bitrate", this.bitrate);
            jSONObject.put("classid", this.classid);
            jSONObject.put("duration", this.duration);
            jSONObject.put("extname", this.extname);
            jSONObject.put("p2pSource", this.p2pSource);
            jSONObject.put("filehash", this.filehash);
            jSONObject.put("fileid", this.fileid);
            jSONObject.put("filepath", this.filepath);
            jSONObject.put("filesize", this.filesize);
            jSONObject.put("fileuserkey", this.fileuserkey);
            jSONObject.put("mimetype", this.mimetype);
            jSONObject.put("musichash", this.musichash);
            jSONObject.put("musicname", this.musicname);
            jSONObject.put("parenPath", this.parenPath);
            jSONObject.put("targetPath", this.targetPath);
            jSONObject.put("targetDir", this.targetDir);
            jSONObject.put("qualitytype", this.qualitytype);
            jSONObject.put("singer", this.singer);
            jSONObject.put("source", this.source);
            jSONObject.put("sourceType", this.sourceType);
            jSONObject.put("trackName", this.trackName);
            jSONObject.put("userDownloadUrl", this.userDownloadUrl);
            String[] strArr = this.userDownloadUrls;
            if (strArr != null && strArr.length > 0) {
                JSONArray jSONArray = new JSONArray();
                for (String str : this.userDownloadUrls) {
                    jSONArray.put(str);
                }
                jSONObject.put("userDownloadUrls", jSONArray);
            }
            jSONObject.put("isCharge", this.isCharge ? 1 : 0);
            jSONObject.put("behavior", this.behavior);
            jSONObject.put("module", this.module);
            jSONObject.put("albumID", this.albumID);
            jSONObject.put("mixId", this.mixId);
            jSONObject.put("memoryOnly", this.memoryOnly ? 1 : 0);
            jSONObject.put("cloudVersion", this.cloudVersion);
            jSONObject.put("authorId", this.authorId);
            jSONObject.put("isfromyueku", this.isFromYueKu);
            jSONObject.put("isFromLocalMusic", this.isFromLocalMusic);
            jSONObject.put("nameType", this.nameType);
            jSONObject.put("trackName", this.trackName);
            jSONObject.put("songSource", this.songSource);
            jSONObject.put("failProcess", this.failProcess);
            jSONObject.put("payType", this.payType);
            jSONObject.put("musicFeeType", this.musicFeeType);
            jSONObject.put("maskOfForceDownload", this.maskOfForceDownload);
            jSONObject.put("updateFeeStatusTime", this.updateFeeStatusTime);
            jSONObject.put("oldCpy", this.oldCpy);
            jSONObject.put("privilege", this.privilege);
            jSONObject.put("musicLinkSource", this.musicLinkSource);
            jSONObject.put("priorityCDN", this.priorityCDN ? 1 : 0);
            jSONObject.put("audioId", this.audioId);
            jSONObject.put("specialOrAlbumName", this.mSpecialOrAlbumName);
            jSONObject.put("guessYouLikeMark", this.guessYouLikeMark);
            jSONObject.put("isReset", this.isReset);
            jSONObject.put("audioType", this.audioType);
            jSONObject.put("sort", this.sort);
            jSONObject.put("guessYouLikeBiString", this.guessYouLikeBiString);
            jSONObject.put("musicSource", this.musicSource);
            jSONObject.put("sk", this.sk);
            jSONObject.put("ext_params", this.extParams);
            MusicTransParamEnenty.toJSONObject(jSONObject, this);
            TrackerInfo trackerInfo = this.trackerInfo;
            if (trackerInfo != null) {
                jSONObject.put("trackerInfo", trackerInfo.toJson());
            }
            jSONObject.put("musicLinkExtInfo", this.musicLinkExtInfo);
            jSONObject.put("couponID", this.couponID);
            if (getExtraInfo() != null) {
                jSONObject.put("extraInfo", getExtraInfo().toJsonObj());
            }
            jSONObject.put("musicLinkSource", this.musicLinkSource);
            jSONObject.put("channelId", this.channelCommentId);
        } catch (JSONException e2) {
            g0.k(e2);
        }
        return jSONObject;
    }

    public void toParcelString() {
        Parcel.obtain().marshall();
    }

    public String toString() {
        return "KGFile [fileid=" + this.fileid + ", fileuserkey=" + this.fileuserkey + ", p2pSource=" + this.p2pSource + ", filehash=" + this.filehash + ", filesize=" + this.filesize + ", extname=" + this.extname + ", filepath=" + this.filepath + ", parenPath=" + this.parenPath + ", source=" + this.source + ", musicname=" + this.musicname + ", musichash=" + this.musichash + ", qualitytype=" + this.qualitytype + ", bitrate=" + this.bitrate + ", mixid=" + this.mixId + ", duration=" + this.duration + ", singer=" + this.singer + ", albumname=" + this.albumname + ", mimetype=" + this.mimetype + ", classid=" + this.classid + ", sourceType=" + this.sourceType + ", userDownloadUrl=" + this.userDownloadUrl + "]";
    }

    public String withTrackerInfoString() {
        StringBuilder sb = new StringBuilder();
        sb.append("fileuserkey:");
        sb.append(this.fileuserkey);
        sb.append(" musichash:");
        sb.append(this.musichash);
        sb.append(" trackerInfo:");
        TrackerInfo trackerInfo = this.trackerInfo;
        if (trackerInfo != null) {
            sb.append(trackerInfo.toJson());
        } else {
            sb.append("null");
        }
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeLong(this.fileid);
        parcel.writeString(this.fileuserkey);
        parcel.writeInt(this.p2pSource);
        parcel.writeString(this.filehash);
        parcel.writeLong(this.filesize);
        parcel.writeString(this.extname);
        parcel.writeString(this.filepath);
        parcel.writeString(this.parenPath);
        parcel.writeString(this.targetPath);
        parcel.writeString(this.targetDir);
        parcel.writeString(this.source);
        parcel.writeString(this.musicname);
        parcel.writeString(this.musichash);
        parcel.writeInt(this.qualitytype);
        parcel.writeInt(this.bitrate);
        parcel.writeLong(this.duration);
        parcel.writeString(this.singer);
        parcel.writeString(this.albumname);
        parcel.writeString(this.mimetype);
        parcel.writeInt(this.classid);
        parcel.writeString(this.userDownloadUrl);
        parcel.writeStringArray(this.userDownloadUrls);
        parcel.writeString(this.sourceType);
        parcel.writeString(this.addedTime);
        parcel.writeString(this.lastModifyTime);
        parcel.writeInt(this.isCharge ? 1 : 0);
        parcel.writeString(this.behavior);
        parcel.writeString(this.module);
        parcel.writeString(this.albumID);
        parcel.writeLong(this.mixId);
        parcel.writeInt(this.hasCharged ? 1 : 0);
        parcel.writeInt(this.isEncryptDownload ? 1 : 0);
        parcel.writeInt(this.maskOfForceDownload);
        parcel.writeInt(this.memoryOnly ? 1 : 0);
        parcel.writeInt(this.cloudVersion);
        parcel.writeInt(this.isFree ? 1 : 0);
        parcel.writeLong(this.maxSpeed);
        parcel.writeInt(this.authorId);
        parcel.writeInt(this.isFromYueKu ? 1 : 0);
        parcel.writeInt(this.isFromLocalMusic ? 1 : 0);
        parcel.writeInt(this.nameType);
        parcel.writeString(this.trackName);
        parcel.writeString(this.sourceHash);
        parcel.writeInt(this.songSource);
        parcel.writeInt(this.failProcess);
        parcel.writeString(this.musicFeeType);
        parcel.writeInt(this.payType);
        parcel.writeInt(this.fileEncryptType);
        parcel.writeLong(this.updateFeeStatusTime);
        parcel.writeInt(this.oldCpy);
        parcel.writeInt(this.privilege);
        parcel.writeInt(this.musicLinkSource);
        parcel.writeInt(this.priorityCDN ? 1 : 0);
        parcel.writeLong(this.audioId);
        parcel.writeInt(this.p2pCacheOnly ? 1 : 0);
        parcel.writeInt(this.isPlayMusicCloud ? 1 : 0);
        parcel.writeInt(this.p2pTurnCDNMilliseconds);
        parcel.writeInt(this.headSeconds);
        parcel.writeString(this.mSpecialOrAlbumName);
        parcel.writeInt(this.guessYouLikeMark);
        parcel.writeInt(this.isReset ? 1 : 0);
        parcel.writeInt(this.audioType);
        parcel.writeInt(this.sort);
        parcel.writeString(this.guessYouLikeBiString);
        parcel.writeString(this.sk);
        MusicTransParamEnenty.toParcel(parcel, i2, this);
        parcel.writeInt(this.musicSource);
        parcel.writeParcelable(this.trackerInfo, 0);
        parcel.writeInt(this.forcePlay ? 1 : 0);
        parcel.writeString(this.couponID);
        parcel.writeString(this.musicLinkExtInfo);
        parcel.writeString(this.extParams);
        parcel.writeParcelable(this.extraInfo, 0);
        parcel.writeInt(this.musicLinkSource);
        parcel.writeString(this.channelCommentId);
    }
}
