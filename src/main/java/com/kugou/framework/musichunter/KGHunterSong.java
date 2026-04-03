package com.kugou.framework.musichunter;

import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class KGHunterSong {
    private List<AlbumInfo> albums;
    private int charge;
    private List<Composer> composers;
    private String copyrightOwner;
    private long duration;
    private String hashValue;
    private String isrc;
    private List<LyricWriter> lyricWriters;
    private int mixSongId;
    private String singer;
    private long size;
    private String songName;
    private long timeOffset;
    private String trackId;
    private String upc;

    public static class AlbumInfo {
        public String albumname;
        public String publishDate;

        public String toString() {
            return "AlbumInfo{albumname='" + this.albumname + "', publishDate='" + this.publishDate + "'}";
        }
    }

    public static class Composer {
        public long authorId;
        public String authorName;
        public String isPublish;

        public String toString() {
            return "Composer{authorId=" + this.authorId + ", authorName='" + this.authorName + "', isPublish=" + this.isPublish + '}';
        }
    }

    public static class LyricWriter {
        public long authorId;
        public String authorName;
        public String isPublish;

        public String toString() {
            return "LyricWriter{authorId=" + this.authorId + ", authorName='" + this.authorName + "', isPublish=" + this.isPublish + '}';
        }
    }

    public String[] getAlbumname() {
        List<AlbumInfo> list = this.albums;
        if (list == null) {
            return new String[0];
        }
        String[] strArr = new String[list.size()];
        for (int i2 = 0; i2 < this.albums.size(); i2++) {
            strArr[i2] = this.albums.get(i2).albumname;
        }
        return strArr;
    }

    public List<AlbumInfo> getAlbums() {
        return this.albums;
    }

    public int getCharge() {
        return this.charge;
    }

    public List<Composer> getComposers() {
        return this.composers;
    }

    public String getCopyrightOwner() {
        return this.copyrightOwner;
    }

    public long getDuration() {
        return this.duration;
    }

    public String getHashValue() {
        return this.hashValue;
    }

    public String getIsrc() {
        return this.isrc;
    }

    public List<LyricWriter> getLyricWriters() {
        return this.lyricWriters;
    }

    public int getMixSongId() {
        return this.mixSongId;
    }

    public String getSinger() {
        return this.singer;
    }

    public long getSize() {
        return this.size;
    }

    public String getSongName() {
        return this.songName;
    }

    public long getTimeOffset() {
        return this.timeOffset;
    }

    public String getTrackId() {
        return this.trackId;
    }

    public String getUpc() {
        return this.upc;
    }

    public void setAlbums(List<AlbumInfo> list) {
        this.albums = list;
    }

    public void setComposers(List<Composer> list) {
        this.composers = list;
    }

    public void setCopyrightOwner(String str) {
        this.copyrightOwner = str;
    }

    public void setDuration(long j) {
        this.duration = j;
    }

    public void setHashValue(String str) {
        this.hashValue = str;
    }

    public void setIsrc(String str) {
        this.isrc = str;
    }

    public void setLyricWriters(List<LyricWriter> list) {
        this.lyricWriters = list;
    }

    public void setMixSongId(int i2) {
        this.mixSongId = i2;
    }

    public void setMusicCharge(int i2, int i3, int i4) {
        this.charge = i2 + (i3 << 4) + (i4 << 8);
    }

    public void setSinger(String str) {
        this.singer = str;
    }

    public void setSize(long j) {
        this.size = j;
    }

    public void setSongName(String str) {
        this.songName = str;
    }

    public void setTimeOffset(long j) {
        this.timeOffset = j;
    }

    public void setTrackId(String str) {
        this.trackId = str;
    }

    public void setUpc(String str) {
        this.upc = str;
    }

    public String toString() {
        return "KGSong{songName='" + this.songName + "', singer='" + this.singer + "', albums=" + this.albums + ", mixSongId=" + this.mixSongId + ", trackId='" + this.trackId + "', composers=" + this.composers + ", lyricWriters=" + this.lyricWriters + ", timeOffset=" + this.timeOffset + ", duration=" + this.duration + ", isrc='" + this.isrc + "', upc='" + this.upc + "', copyrightOwner='" + this.copyrightOwner + "'}";
    }
}
