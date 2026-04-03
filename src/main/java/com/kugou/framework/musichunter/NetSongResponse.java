package com.kugou.framework.musichunter;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class NetSongResponse {
    private Object extTag;
    private boolean isCurrentList = true;
    private boolean isGuess;
    private String originalContent;
    private int recordcount;
    private int requestType;
    private ArrayList<KGHunterSong> songs;
    private long timestamp;

    public Object getExtTag() {
        return this.extTag;
    }

    public String getOriginalContent() {
        return this.originalContent;
    }

    public int getRecordcount() {
        return this.recordcount;
    }

    public int getRequestType() {
        return this.requestType;
    }

    public ArrayList<KGHunterSong> getSongs() {
        return this.songs;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public boolean isCurrentList() {
        return this.isCurrentList;
    }

    public boolean isGuess() {
        return this.isGuess;
    }

    public void setCurrentList(boolean z) {
        this.isCurrentList = z;
    }

    public void setExtTag(Object obj) {
        this.extTag = obj;
    }

    public void setGuess(boolean z) {
        this.isGuess = z;
    }

    public void setOriginalContent(String str) {
        this.originalContent = str;
    }

    public void setRecordcount(int i2) {
        this.recordcount = i2;
    }

    public void setRequestType(int i2) {
        this.requestType = i2;
    }

    public void setSongs(ArrayList<KGHunterSong> arrayList) {
        this.songs = arrayList;
    }

    public void setTimestamp(long j) {
        this.timestamp = j;
    }
}
