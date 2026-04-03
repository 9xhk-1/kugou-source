package com.kugou.android.watch.lite.recommend.entity;

import com.kugou.android.watch.lite.common.INoGuard;
import com.kugou.android.watch.lite.common.music.entity.KGSong;
import e.c.a.g.a.s.h1;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class SheetMusicBean implements INoGuard {
    public String album_audio_id;
    public String album_id;
    public String album_name;
    public String album_sizable_cover;
    public AudioInfoBean audio_info;
    public String audio_name;
    public String author_name;
    public List<AuthorsBean> authors;
    public int is_vip_song;
    private KGSong kgSong;

    public static class AudioInfoBean implements INoGuard {
        public int duration;
        public String hash;
        public String hash_128;
    }

    public static class AuthorsBean implements INoGuard {
        public String author_id;
        public String author_name;
        public String is_publish;
        public String sizable_avatar;
    }

    public KGSong getKGSong() {
        if (this.kgSong == null) {
            this.kgSong = new KGSong("推荐内容");
            try {
                String str = this.author_name + " - " + this.audio_name;
                this.kgSong.A4("3");
                this.kgSong.M4(1);
                this.kgSong.Q3(h1.v(this.album_audio_id, 0L));
                this.kgSong.F3(this.album_sizable_cover);
                this.kgSong.e3(str);
                this.kgSong.s4(this.audio_name);
                this.kgSong.A3(300);
                this.kgSong.M4(1);
                this.kgSong.P2(this.album_name);
                this.kgSong.L4(str);
                this.kgSong.O2(h1.u(this.album_id, 0));
                this.kgSong.n3(this.album_id);
                this.kgSong.g3(this.audio_info.duration);
                this.kgSong.B3(this.audio_info.hash);
                this.kgSong.c3(this.album_sizable_cover);
                this.kgSong.t3(str);
            } catch (Exception unused) {
            }
        }
        return this.kgSong;
    }
}
