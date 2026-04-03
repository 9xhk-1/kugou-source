package com.kugou.android.watch.lite.common.music.entity;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kugou.android.watch.lite.base.musicfees.mediastore.entity.HashOffset;
import com.kugou.android.watch.lite.base.musicfees.mediastore.entity.TrackerInfo;
import com.kugou.android.watch.lite.base.player.Initiator;
import com.kugou.android.watch.lite.base.uistructure.PageKey;
import com.kugou.android.watch.lite.common.INoGuard;
import com.kugou.common.filemanager.downloadengine.utils.FileUtil;
import e.c.a.g.a.f.j.a.d;
import e.c.a.g.a.f.j.c.c;
import e.c.a.g.a.r.b;
import e.c.a.g.a.s.g0;
import e.c.a.g.a.s.i0;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class KGMusicWrapper extends Media implements INoGuard {
    public static final int COUPON_BUY = 4;
    public static final Parcelable.Creator<KGMusicWrapper> CREATOR = new a();
    public static final int FREE = 0;
    private static final String KEY_PAGE_PATH = "KEY_PAGE_PATH";
    private static final String Key_CONSTRUCT_TYPE = "constructType";
    private static final String Key_KGFILE = "jsong_kgfile";
    private static final String Key_KGMUSIC = "json_kgmusic";
    private static final String Key_TYPE = "type";
    public static final int NEED_ALBUM_BUY = 3;
    public static final int NEED_MUSICPACKADVANCE_BUY = 1;
    public static final int NON_MUSICPACKADVANCE_BUY = 2;
    public static final int TYPE_LOCAL = 0;
    public static final int TYPE_NET = 1;
    public static final int TYPE_NONE = -1;
    private int constructType;
    private String couponID;
    private int disposableStartMs;
    private boolean forceNext;
    private HashOffset hashOffset;
    private boolean haveChargOf;
    private boolean isCurSelectedSong;
    private int isDownloadOrCache;
    private int isFree;
    private boolean isInsertPlay;
    private boolean isInsertPlayForNewsongStatistics;
    private boolean isKGFileExist;
    private boolean isListenPart;
    private boolean isNeedCheckQuality;
    private boolean isUserPlay;
    private boolean isUserSelQuality;
    private KGFile kgfile;
    private KGMusic kgmusic;
    private String mPagePath;
    private String mUserSelHash;
    private String musicLinkExtInfo;
    private int musicLinkSource;
    private int musicWrapperCode;
    private boolean needCheckListenPartPermission;
    private int playChareStatus;
    private String reportState;
    private int songtype;
    private TrackerInfo trackerInfo;
    private SongQuality userSelQuality;
    private long wrapperUserId;

    public class a implements Parcelable.Creator<KGMusicWrapper> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public KGMusicWrapper createFromParcel(Parcel parcel) {
            KGMusic kGMusic;
            KGMusicWrapper kGMusicWrapper;
            int i2 = parcel.readInt();
            boolean z = parcel.readInt() == 1;
            boolean z2 = parcel.readInt() == 1;
            int i3 = parcel.readInt();
            boolean z3 = parcel.readInt() == 1;
            String string = parcel.readString();
            SongQuality songQualityIntToSongQuality = SongQuality.intToSongQuality(parcel.readInt());
            boolean z4 = parcel.readInt() == 1;
            String string2 = parcel.readString();
            KGFile kGFile = 1 == parcel.readInt() ? (KGFile) parcel.readParcelable(KGFile.class.getClassLoader()) : null;
            if (1 == parcel.readInt()) {
                kGMusic = (KGMusic) parcel.readParcelable(KGMusic.class.getClassLoader());
                if (kGMusic == null) {
                    return null;
                }
            } else {
                kGMusic = null;
            }
            if (i2 == 1) {
                kGMusicWrapper = new KGMusicWrapper(kGFile, string2);
            } else {
                if (kGMusic == null) {
                    return null;
                }
                KGMusicWrapper kGMusicWrapper2 = new KGMusicWrapper(kGMusic, string2);
                if (z4) {
                    kGMusicWrapper2.setKgfile(kGFile);
                }
                kGMusicWrapper = kGMusicWrapper2;
            }
            kGMusicWrapper.isInsertPlay = z;
            kGMusicWrapper.isUserPlay = z2;
            kGMusicWrapper.constructType = i2;
            kGMusicWrapper.songtype = i3;
            kGMusicWrapper.isUserSelQuality = z3;
            kGMusicWrapper.mUserSelHash = string;
            kGMusicWrapper.userSelQuality = songQualityIntToSongQuality;
            if (1 == parcel.readInt()) {
                kGMusicWrapper.hashOffset = (HashOffset) parcel.readParcelable(HashOffset.class.getClassLoader());
            }
            kGMusicWrapper.haveChargOf = parcel.readInt() == 1;
            kGMusicWrapper.playChareStatus = parcel.readInt();
            kGMusicWrapper.isNeedCheckQuality = parcel.readInt() == 1;
            kGMusicWrapper.musicLinkSource = parcel.readInt();
            kGMusicWrapper.wrapperUserId = parcel.readLong();
            kGMusicWrapper.initiator.update((Initiator) parcel.readParcelable(Initiator.class.getClassLoader()));
            kGMusicWrapper.musicWrapperCode = parcel.readInt();
            kGMusicWrapper.needCheckListenPartPermission = parcel.readInt() == 1;
            kGMusicWrapper.isListenPart = parcel.readInt() == 1;
            kGMusicWrapper.musicLinkExtInfo = parcel.readString();
            kGMusicWrapper.couponID = parcel.readString();
            kGMusicWrapper.disposableStartMs = parcel.readInt();
            return kGMusicWrapper;
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public KGMusicWrapper[] newArray(int i2) {
            return new KGMusicWrapper[i2];
        }
    }

    private KGMusicWrapper() {
        this.isKGFileExist = false;
        this.isInsertPlay = false;
        this.isInsertPlayForNewsongStatistics = false;
        this.isUserPlay = false;
        this.isUserSelQuality = false;
        this.mUserSelHash = "";
        this.userSelQuality = SongQuality.QUALITY_NONE;
        this.songtype = -1;
        this.isCurSelectedSong = false;
        this.isFree = 0;
        this.isDownloadOrCache = 0;
        this.forceNext = false;
        this.isNeedCheckQuality = true;
        this.haveChargOf = false;
        this.disposableStartMs = -1;
        this.playChareStatus = 0;
        this.mPagePath = "0";
        this.reportState = "被终止";
        KGMusic kGMusic = new KGMusic();
        this.kgmusic = kGMusic;
        kGMusic.setBehavior("play");
        this.constructType = 0;
        this.isKGFileExist = false;
        this.songtype = -1;
    }

    private void deleteLocalFile(boolean z) {
        getFileid();
    }

    private void keepMixId(@NonNull KGFile kGFile, long j) {
        if (kGFile.getMixId() != j) {
            kGFile.setMixId(j);
        }
        KGMusic kGMusic = this.kgmusic;
        if (kGMusic == null || kGMusic.getMixId() == j) {
            return;
        }
        this.kgmusic.setMixId(j);
    }

    public void configInnerFileTrackerInfo(boolean z) {
        KGFile innerKGfile = getInnerKGfile();
        if (innerKGfile != null) {
            innerKGfile.setTrackerInfo(getTrackerInfo());
            innerKGfile.setClassid(1);
            if (z && innerKGfile.getQualitytype() == SongQuality.QUALITY_NONE.getType()) {
                innerKGfile.setQualitytype(SongQuality.QUALITY_HIGH.getType());
                if (isConstructFromKGmusic()) {
                    innerKGfile.setFilehash(getKgmusic().getHashValue());
                }
            }
            if (isConstructFromKGmusic()) {
                innerKGfile.setFileuserkey(String.format("%s-%s-%s", innerKGfile.getFilehash(), "force", Integer.valueOf(innerKGfile.getTrackerInfo().getMoudleId())));
                innerKGfile.setForcePlay(true);
            }
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(KGMusicWrapper kGMusicWrapper) {
        if (kGMusicWrapper != null && this.constructType == kGMusicWrapper.constructType) {
            if (isConstructFromKGFile() && kGMusicWrapper.isConstructFromKGFile()) {
                return getInnerKGfile().equals(kGMusicWrapper.getInnerKGfile());
            }
            if (isConstructFromKGmusic() && kGMusicWrapper.isConstructFromKGmusic()) {
                return getKgmusic().equals(kGMusicWrapper.getKgmusic());
            }
        }
        return false;
    }

    public void forceMakeKGFile(boolean z) {
        String str;
        setSongtype(1);
        if (g0.a) {
            g0.e("zlx_quality", "forceMakeKGFile isUserSel: " + this.isUserSelQuality);
        }
        if (g0.a) {
            g0.e("xtc_testttt", "forceMakeKGFile 1");
        }
        if (c.a()) {
            if (isConstructFromKGmusic()) {
                getKgmusic().setMaskOfForceDownload(-1);
            } else if (isConstructFromKGFile()) {
                getInnerKGfile().setMaskOfForceDownload(-1);
            }
        }
        getMixId();
        if (g0.a) {
            g0.e("xtc_feealbummid", "start feealbummid = " + getFeeAlbumID());
        }
        if (this.kgmusic != null && this.constructType != 1) {
            if (g0.a) {
                g0.e("xtc_testttt", "forceMakeKGFile 2");
            }
            if (this.isUserSelQuality) {
                this.kgmusic = null;
            } else if (TextUtils.isEmpty(getCouponID())) {
                if (isNeedListenPart()) {
                    if (g0.a) {
                        g0.e("xtc_testttt", "forceMakeKGFile 2");
                    }
                } else if (g0.a) {
                    g0.e("xtc_testttt", "forceMakeKGFile 3");
                }
            }
            if (g0.a) {
                g0.e("xtc_testttt", "forceMakeKGFile 4");
            }
        } else if (isConstructFromKGFile()) {
            if (g0.a) {
                g0.e("xtc_testttt", "forceMakeKGFile 17");
            }
            String musichash = this.kgfile.getMusichash();
            if (this.isUserSelQuality) {
                if (g0.a) {
                    g0.b("zlx_quality", "forceMakeKGFile kgFile UserSelHash: " + this.mUserSelHash);
                }
                this.kgfile.setMusichash(this.mUserSelHash);
            }
            if (TextUtils.isEmpty(musichash)) {
                System.currentTimeMillis();
                this.kgfile.getMusichash();
                if (g0.a) {
                    g0.e("xtc_testttt", "forceMakeKGFile 8");
                }
            }
            if (this.kgfile.getMaskOfForceDownload() >= 0) {
                if (g0.a) {
                    g0.e("xtc_testttt", "forceMakeKGFile 9");
                }
            } else if (TextUtils.isEmpty(this.kgfile.getFilepath()) || !new e.c.a.g.a.f.g.a(this.kgfile.getFilepath()).exists() || (this.isUserSelQuality && this.kgfile.getQualitytype() != this.userSelQuality.getType())) {
                if (g0.a) {
                    g0.e("xtc_testttt", "forceMakeKGFile 14");
                }
                if (this.isUserSelQuality) {
                    if (g0.a) {
                        g0.e("xtc_testttt", "forceMakeKGFile 17");
                    }
                    if (g0.a) {
                        g0.e("xtc_testttt", "forceMakeKGFile 18");
                    }
                } else if (g0.a) {
                    g0.b("zlx_quality", "kgFile不存在，但是未找到本地的可播放文件");
                }
            }
        }
        if (g0.a) {
            StringBuilder sb = new StringBuilder();
            sb.append("forceMakeKGFile 23");
            if (this.kgfile != null) {
                str = "" + this.kgfile.getClassid();
            } else {
                str = "kgfile is null";
            }
            sb.append(str);
            g0.e("xtc_testttt", sb.toString());
        }
        setSongtype(1);
        if (g0.a) {
            g0.e("xtc_feealbummid", "end feealbummid = " + getFeeAlbumID());
        }
    }

    public long getAlbumID() {
        if (isConstructFromKGmusic()) {
            return this.kgmusic.getAlbumID();
        }
        return -1L;
    }

    public String getAlbumName() {
        return isConstructFromKGmusic() ? this.kgmusic.getAlbumName() : "";
    }

    public long getArtistId() {
        if (isConstructFromKGmusic()) {
            return this.kgmusic.getArtistID();
        }
        return -1L;
    }

    public String getArtistName() {
        return isConstructFromKGmusic() ? this.kgmusic.getArtistName() : isConstructFromKGFile() ? getInnerKGfile().getSinger() : "";
    }

    public long getAudioId() {
        KGMusic kGMusic = this.kgmusic;
        if (kGMusic != null) {
            return kGMusic.getAudioId();
        }
        KGFile kGFile = this.kgfile;
        if (kGFile != null) {
            return kGFile.getAudioId();
        }
        return 0L;
    }

    public int getAudioIndex() {
        if (isConstructFromKGmusic()) {
            return this.kgmusic.getAudioIndex();
        }
        if (isConstructFromKGFile()) {
            return this.kgfile.getAudioIndex();
        }
        return 0;
    }

    public int getAudioType() {
        if (isConstructFromKGmusic()) {
            return this.kgmusic.getAudioType();
        }
        if (isConstructFromKGFile()) {
            return this.kgfile.getAudioType();
        }
        return 0;
    }

    public int getAuthorId() {
        KGMusic kgmusic;
        int authorId = getInnerKGfile().getAuthorId();
        return (authorId > 0 || (kgmusic = getKgmusic()) == null) ? authorId : kgmusic.getAuthorId();
    }

    public int getBitrate() {
        return getInnerKGfile().getBitrate();
    }

    public String getChannelCommentId() {
        return isConstructFromKGmusic() ? this.kgmusic.getChannelCommentId() : isConstructFromKGFile() ? this.kgfile.getChannelCommentId() : "";
    }

    public int getCharge() {
        return isConstructFromKGmusic() ? getKgmusic().getCharge() : getInnerKGfile().getPrivilege();
    }

    public String getCouponID() {
        return this.couponID;
    }

    public String getDisplayName() {
        return isConstructFromKGmusic() ? this.kgmusic.getDisplayName() : getInnerKGfile().getMusicname();
    }

    public int getDisposableStartMs() {
        int i2 = this.disposableStartMs;
        this.disposableStartMs = -1;
        return i2;
    }

    public long getDuration() {
        return getInnerKGfile().getDuration();
    }

    public String getExtName() {
        return getInnerKGfile().getExtname();
    }

    public int getFailProcess() {
        return isConstructFromKGmusic() ? getKgmusic().getFailProcess() : getInnerKGfile().getFailProcess();
    }

    public String getFeeAlbumID() {
        return isConstructFromKGmusic() ? this.kgmusic.getFeeAlbumId() : isConstructFromKGFile() ? this.kgfile.getAlbumID() : "";
    }

    public int getFileEncryptType() {
        if (isConstructFromKGmusic()) {
            return this.kgmusic.getFileEncryptType();
        }
        if (isConstructFromKGFile()) {
            return this.kgfile.getFileEncryptType();
        }
        return 0;
    }

    public String getFileHashValue() {
        return getInnerKGfile().getFilehash();
    }

    public String getFileKey() {
        return getInnerKGfile().getFileuserkey();
    }

    public String getFilePath() {
        return getInnerKGfile().getFilepath();
    }

    public long getFileSize() {
        return getInnerKGfile().getFilesize();
    }

    public long getFileid() {
        return getInnerKGfile().getFileid();
    }

    public String getGlobalCollectionId() {
        return isConstructFromKGmusic() ? this.kgmusic.getGlobalCollectionId() : "";
    }

    public String getGuessYouLikeBiString() {
        return isConstructFromKGmusic() ? this.kgmusic.getGuessYouLikeBiString() : "";
    }

    public int getGuessYoulikeMarkForBi() {
        if (isConstructFromKGmusic()) {
            return this.kgmusic.getGuessYouLikeMark();
        }
        return -1;
    }

    public HashOffset getHashOffset() {
        return this.hashOffset;
    }

    public int getHashType() {
        KGMusic kGMusic = this.kgmusic;
        if (kGMusic != null) {
            return kGMusic.getHashType();
        }
        return -100;
    }

    public String getHashValue() {
        KGMusic kgmusic;
        String musichash = getInnerKGfile().getMusichash();
        return (!TextUtils.isEmpty(musichash) || (kgmusic = getKgmusic()) == null) ? musichash : kgmusic.getHashValue();
    }

    public String getHashValueV2() {
        return isConstructFromKGmusic() ? getKgmusic().getHashValue() : getInnerKGfile().getMusichash();
    }

    public String getHashWithAlbumId() {
        return TextUtils.isEmpty(getHashValue()) ? "" : getHashValue().concat("_".concat(String.valueOf(getAlbumID())));
    }

    @Nullable
    public String getImgUrl() {
        return this.kgmusic.getImgUrl();
    }

    public KGFile getInnerKGfile() {
        makeKGFileWhenNoExist();
        KGFile kGFile = this.kgfile;
        if (kGFile != null) {
            kGFile.setCouponID(this.couponID);
            return this.kgfile;
        }
        KGFile kGFile2 = new KGFile();
        kGFile2.setCouponID(this.couponID);
        return kGFile2;
    }

    public int getIsDownloadOrCache() {
        return this.isDownloadOrCache;
    }

    public int getIsFree() {
        return this.isFree;
    }

    public KGMusic getKgmusic() {
        return this.kgmusic;
    }

    public String getListenHash() {
        HashOffset hashOffset = this.hashOffset;
        if (hashOffset != null) {
            return hashOffset.offset_hash;
        }
        return null;
    }

    public int getMaskOfForceDownload() {
        if (isConstructFromKGmusic()) {
            return this.kgmusic.getMaskOfForceDownload();
        }
        if (isConstructFromKGFile()) {
            return this.kgfile.getMaskOfForceDownload();
        }
        return 0;
    }

    public String getMimeType() {
        return getInnerKGfile().getMimetype();
    }

    public long getMixId() {
        if (isConstructFromKGmusic()) {
            return this.kgmusic.getMixId();
        }
        KGFile kGFile = this.kgfile;
        if (kGFile != null) {
            return kGFile.getMixId();
        }
        return 0L;
    }

    public String getModule() {
        return isConstructFromKGmusic() ? this.kgmusic.getModule() : isConstructFromKGFile() ? this.kgfile.getModule() : "";
    }

    public String getMusicFeeType() {
        return isConstructFromKGmusic() ? getKgmusic().getMusicFeeType() : getInnerKGfile().getMusicFeeType();
    }

    public String getMusicLinkExtInfo() {
        if (TextUtils.isEmpty(this.musicLinkExtInfo)) {
            if (isConstructFromKGmusic()) {
                this.musicLinkExtInfo = this.kgmusic.getMusicLinkExtInfo();
            } else if (isConstructFromKGFile()) {
                this.musicLinkExtInfo = this.kgfile.getMusicLinkExtInfo();
            }
        }
        return this.musicLinkExtInfo;
    }

    public int getMusicLinkSource() {
        if (this.musicLinkSource <= 0) {
            if (isConstructFromKGmusic()) {
                this.musicLinkSource = this.kgmusic.musicLinkSource;
            } else if (isConstructFromKGFile()) {
                this.musicLinkSource = this.kgfile.getMusicLinkSource();
            }
        }
        return this.musicLinkSource;
    }

    public int getMusicSource() {
        KGFile kGFile;
        int i2 = d.a;
        if (!isConstructFromKGmusic()) {
            return (!isConstructFromKGFile() || (kGFile = this.kgfile) == null) ? i2 : kGFile.getMusicSource();
        }
        KGMusic kGMusic = this.kgmusic;
        return kGMusic != null ? kGMusic.getMusicSource() : i2;
    }

    public MusicTransParamEnenty getMusicTransParamEnenty() {
        if (isConstructFromKGmusic()) {
            return this.kgmusic.getMusicTransParamEnenty();
        }
        if (isConstructFromKGFile()) {
            return this.kgfile.getMusicTransParamEnenty();
        }
        return null;
    }

    public int getMusicWrapperCode() {
        return this.musicWrapperCode;
    }

    public PageKey getPageKey() {
        try {
            return PageKey.make(getInitiator().url, (int) getInitiator().pageCode, getInitiator().stack);
        } catch (Exception unused) {
            return null;
        }
    }

    public String getPagePath() {
        return this.mPagePath;
    }

    public int getPayType() {
        return isConstructFromKGmusic() ? getKgmusic().getPayType() : getInnerKGfile().getPayType();
    }

    public int getPlayChareStatus() {
        return this.playChareStatus;
    }

    public int getRankId() {
        if (isConstructFromKGmusic()) {
            return this.kgmusic.getRankId();
        }
        return 0;
    }

    public String getReportState() {
        return this.reportState;
    }

    public String getSk() {
        KGFile kGFile = this.kgfile;
        if (kGFile != null && !TextUtils.isEmpty(kGFile.getSk())) {
            return this.kgfile.getSk();
        }
        KGMusic kGMusic = this.kgmusic;
        return (kGMusic == null || TextUtils.isEmpty(kGMusic.getSk())) ? "0,9" : this.kgmusic.getSk();
    }

    public int getSongQuality() {
        return getInnerKGfile().getQualitytype();
    }

    public int getSongSource() {
        if (isConstructFromKGmusic()) {
            return this.kgmusic.getSongSource();
        }
        if (isConstructFromKGFile()) {
            return this.kgfile.getSongSource();
        }
        return 0;
    }

    public int getSongType() {
        this.songtype = 1;
        if (c.a()) {
            if (isConstructFromKGmusic()) {
                getKgmusic().setMaskOfForceDownload(-1);
            } else if (isConstructFromKGFile()) {
                getInnerKGfile().setMaskOfForceDownload(-1);
            }
        }
        return ((!isConstructFromKGmusic() || getKgmusic().getMaskOfForceDownload() < 0) && (!isConstructFromKGFile() || getInnerKGfile().getMaskOfForceDownload() < 0)) ? this.songtype : this.songtype;
    }

    public int getSort() {
        if (isConstructFromKGmusic()) {
            return this.kgmusic.getSort();
        }
        if (isConstructFromKGFile()) {
            return this.kgfile.getSort();
        }
        return 0;
    }

    public String getSource() {
        return isConstructFromKGmusic() ? this.kgmusic.getSource() : (getInnerKGfile() == null || getInnerKGfile().getSource() == null) ? "未知来源" : getInnerKGfile().getSource();
    }

    public String getSourceType() {
        return isConstructFromKGmusic() ? this.kgmusic.getSourceType() : (getInnerKGfile() == null || getInnerKGfile().getSource() == null) ? "" : getInnerKGfile().getSourceType();
    }

    public int getSpecialId() {
        if (isConstructFromKGmusic()) {
            return this.kgmusic.getSpecialId();
        }
        return 0;
    }

    public String getTrackName() {
        return isConstructFromKGmusic() ? this.kgmusic.getTrackName() : isConstructFromKGFile() ? getInnerKGfile().getTrackName() : "";
    }

    public TrackerInfo getTrackerInfo() {
        return this.trackerInfo;
    }

    public String getUnSafeFilepath() {
        KGFile kGFile = this.kgfile;
        if (kGFile != null) {
            return kGFile.getFilepath();
        }
        return null;
    }

    public String getUserSelHash() {
        return this.mUserSelHash;
    }

    public SongQuality getUserSelQuality() {
        return this.userSelQuality;
    }

    public long getWrapperUserId() {
        return this.wrapperUserId;
    }

    public boolean hasStartMs() {
        return this.disposableStartMs > 0;
    }

    public int hashCode() {
        return isConstructFromKGmusic() ? getKgmusic().hashCode() : getInnerKGfile().hashCode();
    }

    public boolean haveChargOf() {
        return this.haveChargOf;
    }

    public boolean isConstructFromKGFile() {
        return this.kgfile != null && this.constructType == 1;
    }

    public boolean isConstructFromKGmusic() {
        return this.kgmusic != null && this.constructType == 2;
    }

    public boolean isCurSelectedSong() {
        return this.isCurSelectedSong;
    }

    public boolean isForceNext() {
        boolean z = this.forceNext;
        this.forceNext = false;
        return z;
    }

    public boolean isFromLocalMusic() {
        KGFile kGFile = this.kgfile;
        if (kGFile != null) {
            return kGFile.isFromLocalMusic();
        }
        return false;
    }

    public boolean isHashMarry(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (isConstructFromKGmusic()) {
            if (!str.equals(getKgmusic().getHashValue()) && !str.equals(getKgmusic().getHash320()) && !str.equals(getKgmusic().getSqHash())) {
                return false;
            }
        } else if (!getInnerKGfile().getMusichash().equals(str) && !getInnerKGfile().getFilehash().equals(str)) {
            return false;
        }
        return true;
    }

    public boolean isInsertPlay() {
        return this.isInsertPlay;
    }

    public boolean isInsertPlayForNewsongStatistics() {
        return this.isInsertPlayForNewsongStatistics;
    }

    public boolean isListenPart() {
        return this.isListenPart;
    }

    public boolean isNeedCheckListenPartPermission() {
        return this.needCheckListenPartPermission;
    }

    public boolean isNeedCheckQuality() {
        return this.isNeedCheckQuality;
    }

    public boolean isNeedListenPart() {
        return this.hashOffset != null && TextUtils.isEmpty(this.couponID);
    }

    public boolean isUserPlay() {
        return this.isUserPlay;
    }

    public boolean isUserSelQuality() {
        return this.isUserSelQuality;
    }

    public void makeKGFileWhenNoExist() {
        KGFile kGFileG;
        if (this.kgfile == null && isConstructFromKGmusic() && (kGFileG = i0.g(this.kgmusic, new SongQuality[0])) != null) {
            kGFileG.setCouponID(this.couponID);
            if (c.a()) {
                if (isConstructFromKGmusic()) {
                    getKgmusic().setMaskOfForceDownload(-1);
                } else if (isConstructFromKGFile()) {
                    getInnerKGfile().setMaskOfForceDownload(-1);
                }
            } else if (FileUtil.isEncryptPath(kGFileG.getFilepath()) || TextUtils.isEmpty(kGFileG.getFilepath())) {
                kGFileG.setMaskOfForceDownload(0);
            }
            setKgfile(kGFileG);
        }
    }

    public void setAudioType(int i2) {
        KGMusic kGMusic = this.kgmusic;
        if (kGMusic != null) {
            kGMusic.setAudioType(i2);
        }
        KGFile kGFile = this.kgfile;
        if (kGFile != null) {
            kGFile.setAudioType(i2);
        }
    }

    public void setAuthorId(int i2) {
        if (isConstructFromKGmusic()) {
            this.kgmusic.setAuthorId(i2);
        } else {
            getInnerKGfile().setAuthorId(i2);
        }
    }

    public void setCharge(int i2) {
        if (isConstructFromKGmusic()) {
            getKgmusic().setCharge(i2);
        }
    }

    public void setContructType(int i2) {
        this.constructType = i2;
        if (isConstructFromKGFile()) {
            setSongtype(0);
        } else {
            setSongtype(1);
        }
    }

    public void setCouponID(String str) {
        this.couponID = str;
    }

    public void setCurSelectedSong(boolean z) {
        this.isCurSelectedSong = z;
    }

    public void setDisplayName(String str) {
        if (isConstructFromKGmusic()) {
            this.kgmusic.setDisplayName(str);
        } else {
            getInnerKGfile().setMusicname(str);
        }
    }

    public void setDisposableStartMs(int i2) {
        this.disposableStartMs = i2;
    }

    public void setForceNext(boolean z) {
        this.forceNext = z;
    }

    public void setHashOffset(HashOffset hashOffset) {
        this.hashOffset = hashOffset;
    }

    public void setHaveChargOf(boolean z) {
        this.haveChargOf = z;
    }

    public void setInsertPlayForNewsongStatistics(boolean z) {
        this.isInsertPlayForNewsongStatistics = z;
    }

    public void setIsDownloadOrCache(int i2) {
        this.isDownloadOrCache = i2;
    }

    public void setIsFree(int i2) {
        this.isFree = i2;
    }

    public void setIsInsertPlay(boolean z) {
        this.isInsertPlay = z;
        if (z) {
            this.isInsertPlayForNewsongStatistics = z;
        }
    }

    public void setIsListenPart(boolean z) {
        this.isListenPart = z;
    }

    public void setKgfile(KGFile kGFile) {
        if (kGFile != null) {
            kGFile.setBehavior("play");
            if (isConstructFromKGmusic()) {
                kGFile.setModule(this.kgmusic.getModule());
            }
            if (!TextUtils.isEmpty(getFeeAlbumID())) {
                kGFile.setAlbumID(getFeeAlbumID());
            }
            setMusicLinkSource(kGFile.getMusicLinkSource());
            setMusicLinkExtInfo(kGFile.getMusicLinkExtInfo());
            if (getMusicSource() != d.a && kGFile.getMusicSource() == d.a) {
                kGFile.setMusicSource(getMusicSource());
            }
        }
        KGFile kGFile2 = this.kgfile;
        if (kGFile2 != null && kGFile != null) {
            kGFile.setMemoryOnly(kGFile2.isMemoryOnly());
            kGFile.setCloudVersion(kGFile2.getCloudVersion());
        }
        this.kgfile = kGFile;
        if (kGFile != null && kGFile.getClass() != KGFile.class) {
            throw new IllegalArgumentException("only KGFile or  KGFileForUI is accepted");
        }
        this.isKGFileExist = true;
        if (isConstructFromKGFile()) {
            setSongtype(0);
        } else {
            setSongtype(1);
        }
    }

    public void setKgmusic(KGMusic kGMusic) {
        TrackerInfo trackerInfo;
        if (kGMusic != null && kGMusic.getClass() != KGMusic.class) {
            throw new IllegalArgumentException("only KGMusic subclass is accepted");
        }
        if (kGMusic != null) {
            ExtraInfo extraInfo = kGMusic.getExtraInfo();
            if (extraInfo != null && (trackerInfo = extraInfo.trackerInfo) != null) {
                setTrackerInfo(trackerInfo);
            }
            kGMusic.setBehavior("play");
            setMusicLinkSource(kGMusic.musicLinkSource);
            setMusicLinkExtInfo(kGMusic.getMusicLinkExtInfo());
            if (getMusicSource() != d.a && kGMusic.getMusicSource() == d.a) {
                kGMusic.setMusicSource(getMusicSource());
            }
        }
        if (kGMusic == null && g0.f()) {
            throw new IllegalArgumentException("kgmusic is null ,please make sure");
        }
        KGMusic kGMusic2 = this.kgmusic;
        if (kGMusic2 != null && kGMusic != null) {
            kGMusic.applyExtraInfo(kGMusic2.getExtraInfo());
        }
        this.kgmusic = kGMusic;
    }

    public void setMusicLinkExtInfo(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (isConstructFromKGmusic()) {
            this.kgmusic.setMusicLinkExtInfo(str);
            this.musicLinkExtInfo = str;
        } else if (isConstructFromKGFile()) {
            this.kgfile.setMusicLinkExtInfo(str);
            this.musicLinkExtInfo = str;
        }
    }

    public void setMusicLinkSource(int i2) {
        setMusicLinkSource(false, i2);
    }

    public void setMusicSource(int i2) {
        KGFile kGFile;
        if (isConstructFromKGmusic()) {
            KGMusic kGMusic = this.kgmusic;
            if (kGMusic != null) {
                kGMusic.setMusicSource(i2);
                return;
            }
            return;
        }
        if (!isConstructFromKGFile() || (kGFile = this.kgfile) == null) {
            return;
        }
        kGFile.setMusicSource(i2);
    }

    public void setMusicWrapperCode(int i2) {
        this.musicWrapperCode = i2;
    }

    public void setNeedCheckListenPartPermission(boolean z) {
        this.needCheckListenPartPermission = z;
    }

    public void setNeedCheckQuality(boolean z) {
        this.isNeedCheckQuality = z;
    }

    public void setPlayChareStatus(int i2) {
        this.playChareStatus = i2;
    }

    public void setReportState(String str) {
        this.reportState = str;
    }

    public void setSongtype(int i2) {
        this.songtype = i2;
    }

    public void setSource(String str) {
        if (isConstructFromKGmusic()) {
            this.kgmusic.setSource(str);
        } else {
            if (getInnerKGfile() == null || getInnerKGfile().getSource() == null) {
                return;
            }
            getInnerKGfile().setSource(str);
        }
    }

    public void setTrackerInfo(TrackerInfo trackerInfo) {
        this.trackerInfo = trackerInfo;
    }

    public void setUserPlay(boolean z) {
        this.isUserPlay = z;
    }

    public void setUserSelQuality(String str, SongQuality songQuality) {
        if (g0.a) {
            g0.b("zlx_quality", "user set quality " + songQuality);
        }
        this.isUserSelQuality = true;
        this.mUserSelHash = str;
        this.userSelQuality = songQuality;
    }

    public void setWrapperUserId(long j) {
        this.wrapperUserId = j;
    }

    public JSONObject toJSONObject() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(Key_CONSTRUCT_TYPE, this.constructType);
            jSONObject.put("haveChargOf", this.haveChargOf);
            jSONObject.put("playChareStatus", this.playChareStatus);
            jSONObject.put("isNeedCheckQuality", this.isNeedCheckQuality);
            jSONObject.put(KEY_PAGE_PATH, this.mPagePath);
            jSONObject.put("initiator", Initiator.toJson(this.initiator, Initiator.espCreate(4096L)));
            jSONObject.put("wrapperuserid", this.wrapperUserId);
            jSONObject.put("musicWrapperCode", this.musicWrapperCode);
            jSONObject.put("needCheckListenPartPermission", this.needCheckListenPartPermission ? 1 : 0);
            HashOffset hashOffset = this.hashOffset;
            if (hashOffset != null) {
                jSONObject.put("hashOffset", hashOffset.toJSONObject());
            }
            TrackerInfo trackerInfo = this.trackerInfo;
            if (trackerInfo != null) {
                jSONObject.put("trackerInfo", trackerInfo.toJson());
            }
        } catch (JSONException e2) {
            g0.k(e2);
        }
        try {
            if (this.kgfile != null && this.isKGFileExist) {
                jSONObject.put(Key_KGFILE, getInnerKGfile().toJSONObject());
            }
        } catch (JSONException unused) {
        }
        try {
            if (this.kgmusic != null && isConstructFromKGmusic()) {
                jSONObject.put(Key_KGMUSIC, this.kgmusic.toJSONObject());
            }
        } catch (JSONException unused2) {
        }
        return jSONObject;
    }

    public String toString() {
        return "{constructType=" + this.constructType + ", mixSongId=" + getMixId() + ", kgfile=" + this.kgfile + ", isKGFileExist=" + this.isKGFileExist + ", isInsertPlay=" + this.isInsertPlay + ", iipfn=" + this.isInsertPlayForNewsongStatistics + ", isUserPlay=" + this.isUserPlay + ", songtype=" + this.songtype + ", wrapperUserId=" + this.wrapperUserId + ", musicLinkSource=" + this.musicLinkSource + ", musicLinkExtInfo='" + this.musicLinkExtInfo + "', isCurSelectedSong=" + this.isCurSelectedSong + ", isFree=" + this.isFree + ", isDownloadOrCache=" + this.isDownloadOrCache + ", forceNext=" + this.forceNext + ", incq=" + this.isNeedCheckQuality + ", haveChargOf=" + this.haveChargOf + ", nclpp=" + this.needCheckListenPartPermission + ", isListenPart=" + this.isListenPart + ", hashOffset=" + this.hashOffset + ", trackerInfo=" + this.trackerInfo + ", musicWrapperCode=" + this.musicWrapperCode + ", disposableStartMs=" + this.disposableStartMs + ", playChareStatus=" + this.playChareStatus + ", mPagePath='" + this.mPagePath + "', reportState='" + this.reportState + "'}";
    }

    public void updateInnerKGFile(KGFile kGFile) {
        if (this.kgmusic != null) {
            setKgfile(kGFile);
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.constructType);
        parcel.writeInt(this.isInsertPlay ? 1 : 0);
        parcel.writeInt(this.isUserPlay ? 1 : 0);
        parcel.writeInt(this.songtype);
        parcel.writeInt(this.isUserSelQuality ? 1 : 0);
        parcel.writeString(this.mUserSelHash);
        parcel.writeInt(this.userSelQuality.getType());
        boolean z = this.isKGFileExist;
        parcel.writeInt(z ? 1 : 0);
        parcel.writeString(this.mPagePath);
        if (isConstructFromKGFile() || z) {
            parcel.writeInt(1);
            parcel.writeParcelable(this.kgfile, i2);
        } else {
            parcel.writeInt(0);
        }
        if (isConstructFromKGmusic()) {
            parcel.writeInt(1);
            parcel.writeParcelable(this.kgmusic, i2);
        } else {
            parcel.writeInt(0);
        }
        if (this.hashOffset != null) {
            parcel.writeInt(1);
            parcel.writeParcelable(this.hashOffset, i2);
        } else {
            parcel.writeInt(0);
        }
        parcel.writeInt(this.haveChargOf ? 1 : 0);
        parcel.writeInt(this.playChareStatus);
        parcel.writeInt(this.isNeedCheckQuality ? 1 : 0);
        parcel.writeInt(this.musicLinkSource);
        parcel.writeLong(this.wrapperUserId);
        parcel.writeParcelable(this.initiator, i2);
        parcel.writeInt(this.musicWrapperCode);
        parcel.writeInt(this.needCheckListenPartPermission ? 1 : 0);
        parcel.writeInt(this.isListenPart ? 1 : 0);
        parcel.writeString(this.musicLinkExtInfo);
        parcel.writeString(this.couponID);
        parcel.writeInt(this.disposableStartMs);
    }

    public void setMusicLinkSource(boolean z, int i2) {
        if ((z || this.musicLinkSource <= 0) && i2 > 0) {
            if (isConstructFromKGmusic()) {
                this.kgmusic.musicLinkSource = i2;
                this.musicLinkSource = i2;
            } else if (isConstructFromKGFile()) {
                this.kgfile.setMusicLinkSource(i2);
                this.musicLinkSource = i2;
            }
        }
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (obj instanceof KGMusicWrapper) {
            return equals((KGMusicWrapper) obj);
        }
        return false;
    }

    public KGFile getInnerKGfile(boolean z) {
        if (z) {
            return getInnerKGfile();
        }
        return this.kgfile;
    }

    public KGMusicWrapper(JSONObject jSONObject) {
        this();
        boolean z = false;
        try {
            this.haveChargOf = jSONObject.optBoolean("haveChargOf", true);
            this.isNeedCheckQuality = jSONObject.optBoolean("isNeedCheckQuality", true);
            this.wrapperUserId = jSONObject.optLong("wrapperuserid", 0L);
            this.musicWrapperCode = jSONObject.optInt("musicWrapperCode", 0);
            this.needCheckListenPartPermission = jSONObject.optInt("needCheckListenPartPermission", 0) == 1;
            if (jSONObject.optInt("needJump", 0) == 1) {
                this.playChareStatus = 1;
            }
            this.playChareStatus = jSONObject.optInt("playChareStatus", 0);
            this.hashOffset = HashOffset.jsonToHashOffset(jSONObject.optJSONObject("hashOffset"));
            this.trackerInfo = TrackerInfo.fromJsonObj(jSONObject.optJSONObject("trackerInfo"));
            int i2 = jSONObject.getInt(Key_CONSTRUCT_TYPE);
            this.mPagePath = jSONObject.optString(KEY_PAGE_PATH, this.mPagePath);
            this.initiator.update(Initiator.fromJson(jSONObject.optJSONObject("initiator"), Initiator.espCreate(2048L)));
            if (i2 == 2) {
                if (!jSONObject.isNull(Key_KGFILE)) {
                    KGFile kGFileCreateFromJson = KGFile.createFromJson(jSONObject.getJSONObject(Key_KGFILE));
                    kGFileCreateFromJson.setBehavior("play");
                    setKgfile(kGFileCreateFromJson);
                    z = true;
                }
                if (!jSONObject.isNull(Key_KGMUSIC)) {
                    KGMusic kGMusicCreateFromJson = KGMusic.createFromJson(jSONObject.getJSONObject(Key_KGMUSIC));
                    kGMusicCreateFromJson.setBehavior("play");
                    setKgmusic(kGMusicCreateFromJson);
                    setContructType(2);
                    z = true;
                }
            } else if (!jSONObject.isNull(Key_KGFILE)) {
                KGFile kGFileCreateFromJson2 = KGFile.createFromJson(jSONObject.getJSONObject(Key_KGFILE));
                kGFileCreateFromJson2.setBehavior("play");
                setKgfile(kGFileCreateFromJson2);
                setContructType(1);
                z = true;
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        if (!z) {
            throw new IllegalArgumentException("there is no data in jsonObj");
        }
    }

    public KGMusicWrapper(KGMusic kGMusic, String str) {
        this();
        if (kGMusic != null && kGMusic.getIsMusicCloud()) {
            this.wrapperUserId = b.o();
        }
        setKgmusic(kGMusic);
        setContructType(2);
        this.mPagePath = str;
    }

    public KGMusicWrapper(KGFile kGFile, String str) {
        this();
        setKgfile(kGFile);
        setContructType(1);
        this.mPagePath = str;
    }
}
