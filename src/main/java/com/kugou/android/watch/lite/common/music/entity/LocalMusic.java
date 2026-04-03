package com.kugou.android.watch.lite.common.music.entity;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes.dex */
public class LocalMusic extends KGMusic {
    public static final int ALBUM_INFO_IS_EDIT = 1;
    public static final int ALBUM_INFO_IS_NOT_EDIT = 0;
    public static final int CORRECT_NAME_TYPE_ABORT_CORRECT = -2;
    public static final int CORRECT_NAME_TYPE_DEFAULT = 0;
    public static final int CORRECT_NAME_TYPE_HAS_CORRECT = 2;
    public static final int CORRECT_NAME_TYPE_RESTORE_CORRECT = -3;
    public static final int CORRECT_NAME_TYPE_UN_CORRECT = 1;
    public static final Parcelable.Creator<LocalMusic> CREATOR = new a();
    public static final int DEFECT_FAKE_QUELITY = 8;
    public static final int DEFECT_UNKNOW = -1;
    public static final int FINGER_PRINTER_FAIL_MATCH = -1;
    public static final int FINGER_PRINTER_HAS_MATCH = 1;
    public static final int FINGER_PRINTER_RESTORE = -2;
    public static final int HASH_MATCH_RESTORE = -3;
    public static final int MATCH_STATE_DEFAULT = 0;
    public static final int MATCH_TYPE_AUDIO_INFO_FOR_RESULT = 3;
    public static final int MATCH_TYPE_AUDIO_INFO_FOR_SCAN = 4;
    public static final int MATCH_TYPE_HASH_MATCH = 2;
    public static final int TYPE_DOWNLOAD = 2;
    public static final int TYPE_SCAN = 1;
    private static final long serialVersionUID = -1127035676698736161L;
    private float audioBpm;
    private long audioBpmMatchTime;
    private int correctNameStatus;
    private int defect;
    private long fileid;
    private String genre;
    private long genreMatchTime;
    private boolean isEditAlbumInfo;
    private boolean isFinishCorrectSong;
    private boolean isNeedCorrectSong;
    private boolean isUserAdd;
    private boolean isUserSetAudioBpm;
    private long kgMixId;
    private KGFile mFile;
    private int matchStatus;
    private long musicAddTime;
    private int musictype;
    private long oldSid;
    private long playCount;
    private int thirdSongState;
    private int weight;

    public class a implements Parcelable.Creator<LocalMusic> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public LocalMusic createFromParcel(Parcel parcel) {
            return new LocalMusic(parcel, null);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public LocalMusic[] newArray(int i2) {
            return new LocalMusic[i2];
        }
    }

    public /* synthetic */ LocalMusic(Parcel parcel, a aVar) {
        this(parcel);
    }

    @Override // com.kugou.android.watch.lite.common.music.entity.KGMusic, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.kugou.android.watch.lite.common.music.entity.KGMusic
    public String getAlbumName() {
        KGFile kGFile = this.mFile;
        return (kGFile == null || TextUtils.isEmpty(kGFile.getAlbumname()) || "未知专辑".equals(this.mFile.getAlbumname())) ? !TextUtils.isEmpty(super.getAlbumName()) ? super.getAlbumName() : "未知专辑" : this.mFile.getAlbumname();
    }

    @Override // com.kugou.android.watch.lite.common.music.entity.KGMusic
    public String getArtistName() {
        KGFile kGFile = this.mFile;
        return kGFile != null ? kGFile.getSinger() : super.getArtistName();
    }

    public float getAudioBpm() {
        return this.audioBpm;
    }

    public long getBpmMatchTime() {
        return this.audioBpmMatchTime;
    }

    public int getCorrectNameStatus() {
        return this.correctNameStatus;
    }

    @Deprecated
    public int getDefect() {
        return this.defect;
    }

    public KGFile getFile() {
        if (this.mFile != null && getAudioType() > 0) {
            this.mFile.setAudioType(getAudioType());
        }
        return this.mFile;
    }

    public String getFilePath() {
        KGFile kGFile = this.mFile;
        return kGFile != null ? kGFile.getFilepath() : "";
    }

    public long getFileid() {
        return this.fileid;
    }

    @Override // com.kugou.android.watch.lite.common.music.entity.KGMusic
    public String getGenre() {
        return this.genre;
    }

    public long getGenreMatchTime() {
        return this.genreMatchTime;
    }

    public String getIDisplayName() {
        return getDisplayName();
    }

    public long getIDuration() {
        return getDuration();
    }

    public String getIFilePath() {
        return getFilePath();
    }

    public int getISrctype() {
        return getSrctype();
    }

    public String getKgAlbumName() {
        return !TextUtils.isEmpty(super.getAlbumName()) ? super.getAlbumName() : "未知专辑";
    }

    public long getKgMixId() {
        return this.kgMixId;
    }

    public int getMatchStatus() {
        return this.matchStatus;
    }

    public long getMusicAddTime() {
        return this.musicAddTime;
    }

    public int getMusictype() {
        return this.musictype;
    }

    public long getOldSid() {
        return this.oldSid;
    }

    public long getPlayCount() {
        return this.playCount;
    }

    @Override // com.kugou.android.watch.lite.common.music.entity.KGMusic
    public String getSource() {
        KGFile kGFile = this.mFile;
        return (kGFile == null || kGFile.getSource() == null) ? this.source : this.mFile.getSource();
    }

    @Override // com.kugou.android.watch.lite.common.music.entity.KGMusic
    public String getSourceType() {
        KGFile kGFile = this.mFile;
        if (kGFile != null) {
            return kGFile.getSourceType();
        }
        if (TextUtils.isEmpty(this.sourceType)) {
            this.sourceType = "";
        }
        return this.sourceType;
    }

    public int getThirdSongState() {
        return this.thirdSongState;
    }

    @Override // com.kugou.android.watch.lite.common.music.entity.KGMusic
    public String getTrackName() {
        KGFile kGFile = this.mFile;
        return kGFile != null ? kGFile.getTrackName() : super.getTrackName();
    }

    public int getWeight() {
        return this.weight;
    }

    public boolean isEditAlbumInfo() {
        return this.isEditAlbumInfo;
    }

    public boolean isFinishCorrectSong() {
        return this.isFinishCorrectSong;
    }

    public boolean isNeedCorrectSong() {
        return this.isNeedCorrectSong;
    }

    public boolean isUserAdd() {
        return this.isUserAdd;
    }

    public boolean isUserSetAudioBpm() {
        return this.isUserSetAudioBpm;
    }

    public void setAudioBpm(float f2) {
        this.audioBpm = f2;
    }

    public void setBpmMatchTime(long j) {
        this.audioBpmMatchTime = j;
    }

    public void setCorrectNameStatus(int i2) {
        this.correctNameStatus = i2;
    }

    @Deprecated
    public void setDefect(int i2) {
        this.defect = i2;
    }

    public void setEditAlbumInfo(boolean z) {
        this.isEditAlbumInfo = z;
    }

    public void setFile(KGFile kGFile) {
        this.mFile = kGFile;
        if (kGFile != null) {
            kGFile.setSource(this.source);
            this.mFile.setSourceType(this.sourceType);
        }
    }

    public void setFileid(long j) {
        this.fileid = j;
    }

    public void setFinishCorrectSong(boolean z) {
        this.isFinishCorrectSong = z;
    }

    @Override // com.kugou.android.watch.lite.common.music.entity.KGMusic
    public void setGenre(String str) {
        this.genre = str;
    }

    public void setGenreMatchTime(long j) {
        this.genreMatchTime = j;
    }

    public void setKgMixId(long j) {
        this.kgMixId = j;
    }

    public void setMatchStatus(int i2) {
        this.matchStatus = i2;
    }

    public void setMusicAddTime(long j) {
        this.musicAddTime = j;
    }

    public void setMusictype(int i2) {
        this.musictype = i2;
    }

    public void setNeedCorrectSong(boolean z) {
        this.isNeedCorrectSong = z;
    }

    public void setOldSid(long j) {
        this.oldSid = j;
    }

    public void setPlayCount(long j) {
        this.playCount = j;
    }

    @Override // com.kugou.android.watch.lite.common.music.entity.KGMusic
    public void setSource(String str) {
        this.source = str;
        KGFile kGFile = this.mFile;
        if (kGFile != null) {
            kGFile.setSource(str);
        }
    }

    @Override // com.kugou.android.watch.lite.common.music.entity.KGMusic
    public void setSourceType(String str) {
        KGFile kGFile = this.mFile;
        if (kGFile != null) {
            kGFile.setSourceType(str);
        }
        this.sourceType = str;
    }

    public void setThirdSongState(int i2) {
        this.thirdSongState = i2;
    }

    public void setUserAdd(boolean z) {
        this.isUserAdd = z;
    }

    public void setUserSetAudioBpm(boolean z) {
        this.isUserSetAudioBpm = z;
    }

    public void setWeight(int i2) {
        this.weight = i2;
    }

    @Override // com.kugou.android.watch.lite.common.music.entity.KGMusic, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        super.writeToParcel(parcel, i2);
        parcel.writeLong(this.fileid);
        parcel.writeInt(this.musictype);
        parcel.writeParcelable(getFile(), i2);
        parcel.writeInt(this.isUserAdd ? 1 : 0);
        parcel.writeInt(this.thirdSongState);
        parcel.writeLong(this.playCount);
    }

    public LocalMusic() {
        this.fileid = -1L;
        this.weight = 0;
        this.isUserAdd = false;
        this.thirdSongState = -1;
        this.defect = -1;
        this.fileid = -1L;
        this.musictype = -1;
    }

    @Override // com.kugou.android.watch.lite.common.music.entity.KGMusic
    public LocalMusic clone() {
        try {
            return (LocalMusic) super.clone();
        } catch (CloneNotSupportedException unused) {
            return null;
        }
    }

    public LocalMusic(String str) {
        this.fileid = -1L;
        this.weight = 0;
        this.isUserAdd = false;
        this.thirdSongState = -1;
        this.defect = -1;
        this.fileid = -1L;
        this.musictype = -1;
        this.source = str;
    }

    private LocalMusic(Parcel parcel) {
        super(parcel);
        this.fileid = -1L;
        this.weight = 0;
        this.isUserAdd = false;
        this.thirdSongState = -1;
        this.defect = -1;
        this.fileid = parcel.readLong();
        this.musictype = parcel.readInt();
        this.mFile = (KGFile) parcel.readParcelable(KGFile.class.getClassLoader());
        this.isUserAdd = parcel.readInt() == 1;
        this.thirdSongState = parcel.readInt();
        this.playCount = parcel.readLong();
    }
}
