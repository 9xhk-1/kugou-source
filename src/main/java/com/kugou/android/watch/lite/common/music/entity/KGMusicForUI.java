package com.kugou.android.watch.lite.common.music.entity;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class KGMusicForUI extends KGMusic {
    private boolean isEncryptLocalFile;
    private int isHasAsynCover;
    private int isHasCover;
    private String mLocalFilePath;
    private int mPlaylistMusicId;
    private long playCount;
    private String singerDigitName;
    private String singerDigitNameSimple;
    private String singerPinyinName;
    private String singerPinyinNameSimple;
    private String songDigitName;
    private String songDigitNameSimple;
    private String songPinyinName;
    private String songPinyinNameSimple;
    private int mBestFileQuality = -1;
    private int mCloudFileId = 0;
    private int mFileOrderWeight = -1;
    private int mIsLocal = 0;
    private long mAddTime = -1;
    private int nameType = -1;

    public KGMusicForUI() {
    }

    public static KGMusic[] toKGMusicArray(List<KGMusicForUI> list) {
        if (list == null) {
            return null;
        }
        int size = list.size();
        KGMusic[] kGMusicArr = new KGMusic[size];
        for (int i2 = 0; i2 < size; i2++) {
            kGMusicArr[i2] = list.get(i2);
        }
        return kGMusicArr;
    }

    public int getBestFileQuality() {
        return this.mBestFileQuality;
    }

    public int getCloudFileId() {
        return this.mCloudFileId;
    }

    public long getFileAddTime() {
        return this.mAddTime;
    }

    public int getFileOrderWeight() {
        return this.mFileOrderWeight;
    }

    public int getIsLocal() {
        return this.mIsLocal;
    }

    public String getLocalFilePath() {
        return this.mLocalFilePath;
    }

    public int getNameType() {
        return this.nameType;
    }

    public long getPlayCount() {
        return this.playCount;
    }

    public int getPlaylistMusicId() {
        return this.mPlaylistMusicId;
    }

    public String getSingerDigitName() {
        return this.singerDigitName;
    }

    public String getSingerDigitNameSimple() {
        return this.singerDigitNameSimple;
    }

    public String getSingerPinyinName() {
        return this.singerPinyinName;
    }

    public String getSingerPinyinNameSimple() {
        return this.singerPinyinNameSimple;
    }

    public String getSongDigitName() {
        return this.songDigitName;
    }

    public String getSongDigitNameSimple() {
        return this.songDigitNameSimple;
    }

    public String getSongPinyinName() {
        return this.songPinyinName;
    }

    public String getSongPinyinNameSimple() {
        return this.songPinyinNameSimple;
    }

    public void hasAsynCover() {
        this.isHasAsynCover = 2;
    }

    public void hasCover() {
        this.isHasCover = 2;
    }

    public void hasNotAsynCover() {
        this.isHasAsynCover = 1;
    }

    public void hasNotCover() {
        this.isHasCover = 1;
    }

    public boolean isEncryptLocalFile() {
        return this.isEncryptLocalFile;
    }

    public boolean loadCover() {
        return (this.isHasCover == 1 || this.isHasAsynCover == 1) ? false : true;
    }

    public void setBestFileQuality(int i2) {
        this.mBestFileQuality = i2;
    }

    public void setCloudFileId(int i2) {
        this.mCloudFileId = i2;
    }

    public void setEncryptLocalFile(boolean z) {
        this.isEncryptLocalFile = z;
    }

    public void setFileAddTime(long j) {
        this.mAddTime = j;
    }

    public void setFileOrderWeight(int i2) {
        this.mFileOrderWeight = i2;
    }

    public void setIsLocal(int i2) {
        this.mIsLocal = i2;
    }

    public void setLocalFilePath(String str) {
        this.mLocalFilePath = str;
    }

    public void setNameType(int i2) {
        this.nameType = i2;
    }

    public void setPlayCount(long j) {
        this.playCount = j;
    }

    public void setPlaylistMusicId(int i2) {
        this.mPlaylistMusicId = i2;
    }

    public void setSingerDigitName(String str) {
        this.singerDigitName = str;
    }

    public void setSingerDigitNameSimple(String str) {
        this.singerDigitNameSimple = str;
    }

    public void setSingerPinyinName(String str) {
        this.singerPinyinName = str;
    }

    public void setSingerPinyinNameSimple(String str) {
        this.singerPinyinNameSimple = str;
    }

    public void setSongDigitName(String str) {
        this.songDigitName = str;
    }

    public void setSongDigitNameSimple(String str) {
        this.songDigitNameSimple = str;
    }

    public void setSongPinyinName(String str) {
        this.songPinyinName = str;
    }

    public void setSongPinyinNameSimple(String str) {
        this.songPinyinNameSimple = str;
    }

    @Deprecated
    public KGSong toKgSong() {
        KGSong kGSongBuildKgSong = buildKgSong();
        kGSongBuildKgSong.f3(isDownloaded());
        kGSongBuildKgSong.M4(isDownloaded() ? 1 : 2);
        return kGSongBuildKgSong;
    }

    public KGMusicForUI(KGMusic kGMusic) {
        setSid(kGMusic.getSid());
        setDisplayName(kGMusic.getDisplayName());
        setTrackName(kGMusic.getTrackName());
        setAlbumName(kGMusic.getAlbumName());
        setAlbumID(kGMusic.getAlbumID());
        setFeeAlbumId(kGMusic.getFeeAlbumId());
        setTrackID(kGMusic.getTrackID());
        setArtistName(kGMusic.getArtistName());
        setGenre(kGMusic.getGenre());
        setArtistID(kGMusic.getArtistID());
        setSize(kGMusic.getSize());
        setHashValue(kGMusic.getHashValue());
        setMusicpath(kGMusic.getMusicpath());
        setBitrate(kGMusic.getBitrate());
        setDuration(kGMusic.getDuration());
        setM4aHash(kGMusic.getM4aHash());
        setM4aSize(kGMusic.getM4aSize());
        setM4aUrl(kGMusic.getM4aUrl());
        setHash320(kGMusic.getHash320());
        setSize320(kGMusic.getSize320());
        setSqHash(kGMusic.getSqHash());
        setSqSize(kGMusic.getSqSize());
        setMvHashValue(kGMusic.getMvHashValue());
        setMvTracks(kGMusic.getMvTracks());
        setMvType(kGMusic.getMvType());
        setMvMatchTime(kGMusic.getMvMatchTime());
        setExclusivePublish(kGMusic.isExclusivePublish());
        setFeeType(kGMusic.getFeeType());
        setIsnew(kGMusic.getIsnew());
        setFullName(kGMusic.getFullName());
        setSongSource(kGMusic.getSongSource());
        setSource(kGMusic.getSource());
        setSourceHash(kGMusic.getSourceHash());
        setSrctype(kGMusic.getSrctype());
        setIsInsertPlay(isInsertPlay());
        setHashType(kGMusic.getHashType());
        setSourceType(kGMusic.getSourceType());
        setCharge(kGMusic.getCharge());
        setModule(kGMusic.getModule());
        setRemark(kGMusic.getRemark());
        setAccompanimentHash(kGMusic.getAccompanimentHash());
        setAccompanimentTime(kGMusic.getAccompanimentTime());
        setHas_accompany(kGMusic.getHas_accompany());
        setInList(kGMusic.getInList());
        setSpecialId(kGMusic.getSpecialId());
        setRankId(kGMusic.getRankId());
        setMixId(kGMusic.getMixId());
        setFailProcess(kGMusic.getFailProcess());
        setPayType(kGMusic.getPayType());
        setMusicFeeType(kGMusic.getMusicFeeType());
        setOldCpy(kGMusic.getOldCpy());
        setCurMark(kGMusic.getCurMark());
        setSingerInfos(kGMusic.getSingerInfos());
        setGuessYouLikeMark(kGMusic.getGuessYouLikeMark());
        setRecSongInfo(kGMusic.getRecSongInfo());
        applyExtraInfo(kGMusic.getExtraInfo());
        setGuessYouLikeBiString(kGMusic.getGuessYouLikeBiString());
        setUpdateFeeStatusTime(kGMusic.getUpdateFeeStatusTime());
        setImgUrl(kGMusic.getImgUrl());
        setMusicTransParamEnenty(kGMusic.getMusicTransParamEnenty());
        setMusicSource(kGMusic.getMusicSource());
        setOldMixId(kGMusic.getOldMixId());
        setMusicLinkExtInfo(kGMusic.getMusicLinkExtInfo());
        setChannelCommentId(kGMusic.getChannelCommentId());
        setGlobalCollectionId(kGMusic.getGlobalCollectionId());
        this.musicLinkSource = kGMusic.musicLinkSource;
    }
}
