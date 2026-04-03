package com.example.mockcard.player;

public class MockSong {
    public final long id;
    public final String title;
    public final String artist;
    public final int durationMs;

    public MockSong(long id, String title, String artist, int durationMs) {
        this.id = id;
        this.title = title;
        this.artist = artist;
        this.durationMs = durationMs;
    }
}
