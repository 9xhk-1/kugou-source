package com.kugou.android.watch.lite.base.db.core;

import androidx.appcompat.widget.ActivityChooserModel;
import androidx.core.app.NotificationCompat;
import androidx.core.provider.FontsContractCompat;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomMasterTable;
import androidx.room.RoomOpenHelper;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import com.kugou.framework.lyric.loader.KrcLoader;
import com.tme.fireeye.crash.comm.db.DbOpenHelper;
import e.c.a.g.a.d.f.c.a.b;
import e.c.a.g.a.d.f.c.a.c;
import e.c.a.g.a.d.f.c.a.e;
import e.c.a.g.a.d.f.c.a.g;
import e.c.a.g.a.d.f.c.a.h;
import e.c.a.g.a.d.f.c.a.k;
import e.c.a.g.a.d.f.c.a.l;
import e.c.a.g.a.d.f.c.a.m;
import e.c.a.g.a.d.f.c.a.n;
import e.c.a.g.a.d.f.c.a.o;
import e.c.a.g.a.d.f.c.a.p;
import e.c.a.g.a.d.s.f;
import java.util.HashMap;
import java.util.HashSet;
import org.apache.http.cookie.ClientCookie;

/* JADX INFO: loaded from: classes.dex */
public final class CoreDatabase_Impl extends CoreDatabase {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile k f21e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile m f22f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public volatile g f23g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public volatile b f24h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public volatile o f25i;
    public volatile e j;
    public volatile f k;

    public class a extends RoomOpenHelper.Delegate {
        public a(int i2) {
            super(i2);
        }

        @Override // androidx.room.RoomOpenHelper.Delegate
        public void createAllTables(SupportSQLiteDatabase supportSQLiteDatabase) {
            supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `kugou_playlists` (`_id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `type` INTEGER NOT NULL, `global_id` TEXT NOT NULL, `name` TEXT NOT NULL, `create_type` INTEGER NOT NULL, `list_id` INTEGER NOT NULL, `weight` INTEGER NOT NULL, `version` INTEGER NOT NULL, `add_date` INTEGER NOT NULL, `modified_date` INTEGER NOT NULL, `status` INTEGER NOT NULL, `userAccount` TEXT NOT NULL, `list_type` INTEGER NOT NULL, `list_create_userid` TEXT NOT NULL, `list_create_listid` TEXT NOT NULL, `list_create_username` TEXT NOT NULL, `list_ico` TEXT NOT NULL, `list_tags` TEXT NOT NULL, `list_intro` TEXT NOT NULL, `list_create_version` INTEGER NOT NULL, `list_create_source` INTEGER NOT NULL, `list_special_id` INTEGER NOT NULL, `list_album_id` INTEGER NOT NULL, `list_create_time` INTEGER NOT NULL, `list_fav_version` INTEGER NOT NULL, `download_song_num` INTEGER NOT NULL, `list_new_sort` INTEGER NOT NULL, `list_sync_user_ids` TEXT NOT NULL, `list_musiclib_id` INTEGER NOT NULL, `origin_red_dot` TEXT NOT NULL, `local_red_dot` TEXT NOT NULL, `is_new` INTEGER NOT NULL, `is_private` INTEGER NOT NULL, `post_state` INTEGER NOT NULL, `pub_type` INTEGER NOT NULL, `is_custom_pic` INTEGER NOT NULL, `unique_code` TEXT NOT NULL, `numOfSongs` INTEGER NOT NULL)");
            supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `playlistsong` (`_id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `playlistMusicId` INTEGER NOT NULL, `playlistId` INTEGER NOT NULL, `playlistServerId` INTEGER NOT NULL, `mMusicId` INTEGER NOT NULL, `file_id` INTEGER NOT NULL, `fileOrderWeight` INTEGER NOT NULL, `fileAddTime` INTEGER NOT NULL, `isLocal` INTEGER NOT NULL, `isMusicCloud` INTEGER NOT NULL, `audioId` INTEGER NOT NULL, `musicSource` INTEGER NOT NULL, `flag` INTEGER NOT NULL, `feeAlbumId` TEXT, `mixId` INTEGER NOT NULL, `isNeedUpdateMixid` INTEGER NOT NULL, `singerPinyinName` TEXT, `singerPinyinNameSimple` TEXT, `singerDigitName` TEXT, `singerDigitNameSimple` TEXT, `songPinyinName` TEXT, `songPinyinNameSimple` TEXT, `songDigitName` TEXT, `songDigitNameSimple` TEXT, `songSyncUserIds` TEXT, `lastUserManualOperateTime` INTEGER NOT NULL, `collectTime` INTEGER NOT NULL, `maskOfForceDownload` INTEGER NOT NULL, `global_id` TEXT NOT NULL, `hash` TEXT)");
            supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `kugou_songs` (`_id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `id` INTEGER NOT NULL, `playListId` INTEGER NOT NULL, `playListName` TEXT, `playListCreateListId` INTEGER NOT NULL, `playListCreateUserId` INTEGER NOT NULL, `playListCloudListId` INTEGER NOT NULL, `playListType` INTEGER NOT NULL, `playListSource` INTEGER NOT NULL, `musiclibId` INTEGER NOT NULL, `playListCreateUserName` TEXT, `mPlayListPicPath` TEXT, `isReset` INTEGER NOT NULL, `musicSource` INTEGER NOT NULL, `globalCollectionId` TEXT, `audition` INTEGER NOT NULL, `gif_id` INTEGER NOT NULL, `fileOrderWeight` INTEGER NOT NULL, `collectTime` INTEGER NOT NULL, `channelCommentId` TEXT, `extParams` TEXT, `sid` INTEGER NOT NULL, `cur_remark` TEXT, `remark` TEXT, `display_name` TEXT, `trackName` TEXT, `albumName` TEXT, `album_id` INTEGER NOT NULL, `feeAlbumId` TEXT, `mixId` INTEGER NOT NULL, `oldMixId` INTEGER NOT NULL, `audioId` INTEGER NOT NULL, `track_id` INTEGER NOT NULL, `artistName` TEXT, `genre` TEXT, `artist_id` INTEGER NOT NULL, `size` INTEGER NOT NULL, `hashValue` TEXT, `musicpath` TEXT, `bitrate` INTEGER NOT NULL, `duration` INTEGER NOT NULL, `m4aHash` TEXT, `m4aSize` INTEGER NOT NULL, `m4aUrl` TEXT, `hash320` TEXT, `size320` INTEGER NOT NULL, `sqHash` TEXT, `sqSize` INTEGER NOT NULL, `mvHashValue` TEXT, `mvTracks` INTEGER NOT NULL, `mvType` INTEGER NOT NULL, `mvMatchTime` INTEGER NOT NULL, `accompanimentHash` TEXT, `accompanimentTime` INTEGER NOT NULL, `accompanimentId` INTEGER NOT NULL, `has_accompany` INTEGER NOT NULL, `sourceHash` TEXT, `fileId` INTEGER NOT NULL, `musicLinkSource` INTEGER NOT NULL, `mSpecialOrAlbumName` TEXT, `musicLinkExtInfo` TEXT, `hashType` INTEGER NOT NULL, `imgUrl` TEXT, `sk` TEXT, `isExclusivePublish` INTEGER NOT NULL, `extname` TEXT, `feeType` INTEGER NOT NULL, `isnew` INTEGER NOT NULL, `fullName` TEXT, `source` TEXT, `sourceType` TEXT, `srctype` INTEGER NOT NULL, `genreId` INTEGER NOT NULL, `albumMatchTime` INTEGER NOT NULL, `isInsertPlay` INTEGER NOT NULL, `charge` INTEGER NOT NULL, `behavior` TEXT, `module` TEXT, `songSource` INTEGER NOT NULL, `inList` INTEGER NOT NULL, `sourceMode` INTEGER NOT NULL, `musicFeeStatus` INTEGER NOT NULL, `musicFeeType` TEXT, `failProcess` INTEGER NOT NULL, `payType` INTEGER NOT NULL, `updateFeeStatusTime` INTEGER NOT NULL, `localMusicFeeId` INTEGER NOT NULL, `oldCpy` INTEGER NOT NULL, `isFileDownloaded` INTEGER NOT NULL, `isMusicCloudFile` INTEGER NOT NULL, `mDownloadStatus` INTEGER NOT NULL, `isPlayMusicCloud` INTEGER NOT NULL, `tag` INTEGER NOT NULL, `publishYear` TEXT, `publishYearMatchTime` INTEGER NOT NULL, `language` TEXT, `languageMatchTime` INTEGER NOT NULL, `isUserSetLanguage` INTEGER NOT NULL, `isUserSetPublishYear` INTEGER NOT NULL, `authorId` INTEGER NOT NULL, `specialId` INTEGER NOT NULL, `rankId` INTEGER NOT NULL, `topic` TEXT, `songType` TEXT, `fromLocalMusic` INTEGER NOT NULL, `isUserPlay` INTEGER NOT NULL, `audioType` INTEGER NOT NULL, `sort` INTEGER NOT NULL, `audioIndex` INTEGER NOT NULL, `mFlag` INTEGER NOT NULL, `ugcReviewed` INTEGER NOT NULL, `qualityFeeSource` INTEGER NOT NULL, `isFromMyAsset` INTEGER NOT NULL, `fileEncryptType` INTEGER NOT NULL, `isLocalEncryptUpgradeMP3` INTEGER NOT NULL, `maskOfForceDownload` INTEGER NOT NULL, `guessYouLikeMark` INTEGER NOT NULL, `guessYouLikeBiString` TEXT, `brief` TEXT)");
            supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `downloadtask` (`_id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `downloadsize` INTEGER NOT NULL, `filesize` INTEGER NOT NULL, `downloadstate` INTEGER NOT NULL, `download_error_code` INTEGER NOT NULL, `downloadkey` TEXT NOT NULL, `quality` INTEGER NOT NULL, `downloadmode` INTEGER NOT NULL, `addtime` INTEGER NOT NULL, `songid` INTEGER NOT NULL, `fileid` INTEGER NOT NULL, `iscover` INTEGER NOT NULL, `module` TEXT NOT NULL, `statuscode` INTEGER NOT NULL, `uploadstate` INTEGER NOT NULL, `filetype` INTEGER NOT NULL, `downloadtype` INTEGER NOT NULL, `fee_album_id` TEXT NOT NULL, `mix_id` INTEGER NOT NULL, `source_hash` TEXT NOT NULL, `file_path` TEXT NOT NULL, `tmp_cache_path` TEXT NOT NULL)");
            supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `recent_songs` (`lastPlayTime` INTEGER NOT NULL, `mixId` INTEGER NOT NULL, `hash` TEXT NOT NULL, PRIMARY KEY(`lastPlayTime`))");
            supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `history_record` (`opTime` INTEGER NOT NULL, `mixId` INTEGER NOT NULL, `playCount` INTEGER NOT NULL, `action` INTEGER NOT NULL, `userId` INTEGER NOT NULL, PRIMARY KEY(`opTime`))");
            supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `fee_kubi_buy_info_tab` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL DEFAULT 0, `fileHash` TEXT, `mixid` INTEGER NOT NULL DEFAULT 0, `userid` INTEGER NOT NULL DEFAULT 0, `updateTime` INTEGER NOT NULL DEFAULT 0, `createTime` INTEGER NOT NULL DEFAULT 0, `albumId` INTEGER NOT NULL DEFAULT 0)");
            supportSQLiteDatabase.execSQL(RoomMasterTable.CREATE_QUERY);
            supportSQLiteDatabase.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'cfd2ddaa41773b1805d91ecb24d01398')");
        }

        @Override // androidx.room.RoomOpenHelper.Delegate
        public void dropAllTables(SupportSQLiteDatabase supportSQLiteDatabase) {
            supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `kugou_playlists`");
            supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `playlistsong`");
            supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `kugou_songs`");
            supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `downloadtask`");
            supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `recent_songs`");
            supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `history_record`");
            supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `fee_kubi_buy_info_tab`");
            if (CoreDatabase_Impl.this.mCallbacks != null) {
                int size = CoreDatabase_Impl.this.mCallbacks.size();
                for (int i2 = 0; i2 < size; i2++) {
                    ((RoomDatabase.Callback) CoreDatabase_Impl.this.mCallbacks.get(i2)).onDestructiveMigration(supportSQLiteDatabase);
                }
            }
        }

        @Override // androidx.room.RoomOpenHelper.Delegate
        public void onCreate(SupportSQLiteDatabase supportSQLiteDatabase) {
            if (CoreDatabase_Impl.this.mCallbacks != null) {
                int size = CoreDatabase_Impl.this.mCallbacks.size();
                for (int i2 = 0; i2 < size; i2++) {
                    ((RoomDatabase.Callback) CoreDatabase_Impl.this.mCallbacks.get(i2)).onCreate(supportSQLiteDatabase);
                }
            }
        }

        @Override // androidx.room.RoomOpenHelper.Delegate
        public void onOpen(SupportSQLiteDatabase supportSQLiteDatabase) {
            CoreDatabase_Impl.this.mDatabase = supportSQLiteDatabase;
            CoreDatabase_Impl.this.internalInitInvalidationTracker(supportSQLiteDatabase);
            if (CoreDatabase_Impl.this.mCallbacks != null) {
                int size = CoreDatabase_Impl.this.mCallbacks.size();
                for (int i2 = 0; i2 < size; i2++) {
                    ((RoomDatabase.Callback) CoreDatabase_Impl.this.mCallbacks.get(i2)).onOpen(supportSQLiteDatabase);
                }
            }
        }

        @Override // androidx.room.RoomOpenHelper.Delegate
        public void onPostMigrate(SupportSQLiteDatabase supportSQLiteDatabase) {
        }

        @Override // androidx.room.RoomOpenHelper.Delegate
        public void onPreMigrate(SupportSQLiteDatabase supportSQLiteDatabase) {
            DBUtil.dropFtsSyncTriggers(supportSQLiteDatabase);
        }

        @Override // androidx.room.RoomOpenHelper.Delegate
        public RoomOpenHelper.ValidationResult onValidateSchema(SupportSQLiteDatabase supportSQLiteDatabase) {
            HashMap map = new HashMap(38);
            map.put(DbOpenHelper.ID, new TableInfo.Column(DbOpenHelper.ID, "INTEGER", true, 1, null, 1));
            map.put("type", new TableInfo.Column("type", "INTEGER", true, 0, null, 1));
            map.put("global_id", new TableInfo.Column("global_id", "TEXT", true, 0, null, 1));
            map.put("name", new TableInfo.Column("name", "TEXT", true, 0, null, 1));
            map.put("create_type", new TableInfo.Column("create_type", "INTEGER", true, 0, null, 1));
            map.put("list_id", new TableInfo.Column("list_id", "INTEGER", true, 0, null, 1));
            map.put(ActivityChooserModel.ATTRIBUTE_WEIGHT, new TableInfo.Column(ActivityChooserModel.ATTRIBUTE_WEIGHT, "INTEGER", true, 0, null, 1));
            map.put(ClientCookie.VERSION_ATTR, new TableInfo.Column(ClientCookie.VERSION_ATTR, "INTEGER", true, 0, null, 1));
            map.put("add_date", new TableInfo.Column("add_date", "INTEGER", true, 0, null, 1));
            map.put("modified_date", new TableInfo.Column("modified_date", "INTEGER", true, 0, null, 1));
            map.put(NotificationCompat.CATEGORY_STATUS, new TableInfo.Column(NotificationCompat.CATEGORY_STATUS, "INTEGER", true, 0, null, 1));
            map.put("userAccount", new TableInfo.Column("userAccount", "TEXT", true, 0, null, 1));
            map.put("list_type", new TableInfo.Column("list_type", "INTEGER", true, 0, null, 1));
            map.put("list_create_userid", new TableInfo.Column("list_create_userid", "TEXT", true, 0, null, 1));
            map.put("list_create_listid", new TableInfo.Column("list_create_listid", "TEXT", true, 0, null, 1));
            map.put("list_create_username", new TableInfo.Column("list_create_username", "TEXT", true, 0, null, 1));
            map.put("list_ico", new TableInfo.Column("list_ico", "TEXT", true, 0, null, 1));
            map.put("list_tags", new TableInfo.Column("list_tags", "TEXT", true, 0, null, 1));
            map.put("list_intro", new TableInfo.Column("list_intro", "TEXT", true, 0, null, 1));
            map.put("list_create_version", new TableInfo.Column("list_create_version", "INTEGER", true, 0, null, 1));
            map.put("list_create_source", new TableInfo.Column("list_create_source", "INTEGER", true, 0, null, 1));
            map.put("list_special_id", new TableInfo.Column("list_special_id", "INTEGER", true, 0, null, 1));
            map.put("list_album_id", new TableInfo.Column("list_album_id", "INTEGER", true, 0, null, 1));
            map.put("list_create_time", new TableInfo.Column("list_create_time", "INTEGER", true, 0, null, 1));
            map.put("list_fav_version", new TableInfo.Column("list_fav_version", "INTEGER", true, 0, null, 1));
            map.put("download_song_num", new TableInfo.Column("download_song_num", "INTEGER", true, 0, null, 1));
            map.put("list_new_sort", new TableInfo.Column("list_new_sort", "INTEGER", true, 0, null, 1));
            map.put("list_sync_user_ids", new TableInfo.Column("list_sync_user_ids", "TEXT", true, 0, null, 1));
            map.put("list_musiclib_id", new TableInfo.Column("list_musiclib_id", "INTEGER", true, 0, null, 1));
            map.put("origin_red_dot", new TableInfo.Column("origin_red_dot", "TEXT", true, 0, null, 1));
            map.put("local_red_dot", new TableInfo.Column("local_red_dot", "TEXT", true, 0, null, 1));
            map.put("is_new", new TableInfo.Column("is_new", "INTEGER", true, 0, null, 1));
            map.put("is_private", new TableInfo.Column("is_private", "INTEGER", true, 0, null, 1));
            map.put("post_state", new TableInfo.Column("post_state", "INTEGER", true, 0, null, 1));
            map.put("pub_type", new TableInfo.Column("pub_type", "INTEGER", true, 0, null, 1));
            map.put("is_custom_pic", new TableInfo.Column("is_custom_pic", "INTEGER", true, 0, null, 1));
            map.put("unique_code", new TableInfo.Column("unique_code", "TEXT", true, 0, null, 1));
            map.put("numOfSongs", new TableInfo.Column("numOfSongs", "INTEGER", true, 0, null, 1));
            TableInfo tableInfo = new TableInfo("kugou_playlists", map, new HashSet(0), new HashSet(0));
            TableInfo tableInfo2 = TableInfo.read(supportSQLiteDatabase, "kugou_playlists");
            if (!tableInfo.equals(tableInfo2)) {
                return new RoomOpenHelper.ValidationResult(false, "kugou_playlists(com.kugou.android.watch.lite.base.db.core.table.Playlist).\n Expected:\n" + tableInfo + "\n Found:\n" + tableInfo2);
            }
            HashMap map2 = new HashMap(30);
            map2.put(DbOpenHelper.ID, new TableInfo.Column(DbOpenHelper.ID, "INTEGER", true, 1, null, 1));
            map2.put("playlistMusicId", new TableInfo.Column("playlistMusicId", "INTEGER", true, 0, null, 1));
            map2.put("playlistId", new TableInfo.Column("playlistId", "INTEGER", true, 0, null, 1));
            map2.put("playlistServerId", new TableInfo.Column("playlistServerId", "INTEGER", true, 0, null, 1));
            map2.put("mMusicId", new TableInfo.Column("mMusicId", "INTEGER", true, 0, null, 1));
            map2.put(FontsContractCompat.Columns.FILE_ID, new TableInfo.Column(FontsContractCompat.Columns.FILE_ID, "INTEGER", true, 0, null, 1));
            map2.put("fileOrderWeight", new TableInfo.Column("fileOrderWeight", "INTEGER", true, 0, null, 1));
            map2.put("fileAddTime", new TableInfo.Column("fileAddTime", "INTEGER", true, 0, null, 1));
            map2.put("isLocal", new TableInfo.Column("isLocal", "INTEGER", true, 0, null, 1));
            map2.put("isMusicCloud", new TableInfo.Column("isMusicCloud", "INTEGER", true, 0, null, 1));
            map2.put("audioId", new TableInfo.Column("audioId", "INTEGER", true, 0, null, 1));
            map2.put("musicSource", new TableInfo.Column("musicSource", "INTEGER", true, 0, null, 1));
            map2.put("flag", new TableInfo.Column("flag", "INTEGER", true, 0, null, 1));
            map2.put("feeAlbumId", new TableInfo.Column("feeAlbumId", "TEXT", false, 0, null, 1));
            map2.put("mixId", new TableInfo.Column("mixId", "INTEGER", true, 0, null, 1));
            map2.put("isNeedUpdateMixid", new TableInfo.Column("isNeedUpdateMixid", "INTEGER", true, 0, null, 1));
            map2.put("singerPinyinName", new TableInfo.Column("singerPinyinName", "TEXT", false, 0, null, 1));
            map2.put("singerPinyinNameSimple", new TableInfo.Column("singerPinyinNameSimple", "TEXT", false, 0, null, 1));
            map2.put("singerDigitName", new TableInfo.Column("singerDigitName", "TEXT", false, 0, null, 1));
            map2.put("singerDigitNameSimple", new TableInfo.Column("singerDigitNameSimple", "TEXT", false, 0, null, 1));
            map2.put("songPinyinName", new TableInfo.Column("songPinyinName", "TEXT", false, 0, null, 1));
            map2.put("songPinyinNameSimple", new TableInfo.Column("songPinyinNameSimple", "TEXT", false, 0, null, 1));
            map2.put("songDigitName", new TableInfo.Column("songDigitName", "TEXT", false, 0, null, 1));
            map2.put("songDigitNameSimple", new TableInfo.Column("songDigitNameSimple", "TEXT", false, 0, null, 1));
            map2.put("songSyncUserIds", new TableInfo.Column("songSyncUserIds", "TEXT", false, 0, null, 1));
            map2.put("lastUserManualOperateTime", new TableInfo.Column("lastUserManualOperateTime", "INTEGER", true, 0, null, 1));
            map2.put("collectTime", new TableInfo.Column("collectTime", "INTEGER", true, 0, null, 1));
            map2.put("maskOfForceDownload", new TableInfo.Column("maskOfForceDownload", "INTEGER", true, 0, null, 1));
            map2.put("global_id", new TableInfo.Column("global_id", "TEXT", true, 0, null, 1));
            map2.put("hash", new TableInfo.Column("hash", "TEXT", false, 0, null, 1));
            TableInfo tableInfo3 = new TableInfo("playlistsong", map2, new HashSet(0), new HashSet(0));
            TableInfo tableInfo4 = TableInfo.read(supportSQLiteDatabase, "playlistsong");
            if (!tableInfo3.equals(tableInfo4)) {
                return new RoomOpenHelper.ValidationResult(false, "playlistsong(com.kugou.android.watch.lite.component.playlist.entity.KGPlaylistMusic).\n Expected:\n" + tableInfo3 + "\n Found:\n" + tableInfo4);
            }
            HashMap map3 = new HashMap(119);
            map3.put(DbOpenHelper.ID, new TableInfo.Column(DbOpenHelper.ID, "INTEGER", true, 1, null, 1));
            map3.put("id", new TableInfo.Column("id", "INTEGER", true, 0, null, 1));
            map3.put("playListId", new TableInfo.Column("playListId", "INTEGER", true, 0, null, 1));
            map3.put("playListName", new TableInfo.Column("playListName", "TEXT", false, 0, null, 1));
            map3.put("playListCreateListId", new TableInfo.Column("playListCreateListId", "INTEGER", true, 0, null, 1));
            map3.put("playListCreateUserId", new TableInfo.Column("playListCreateUserId", "INTEGER", true, 0, null, 1));
            map3.put("playListCloudListId", new TableInfo.Column("playListCloudListId", "INTEGER", true, 0, null, 1));
            map3.put("playListType", new TableInfo.Column("playListType", "INTEGER", true, 0, null, 1));
            map3.put("playListSource", new TableInfo.Column("playListSource", "INTEGER", true, 0, null, 1));
            map3.put("musiclibId", new TableInfo.Column("musiclibId", "INTEGER", true, 0, null, 1));
            map3.put("playListCreateUserName", new TableInfo.Column("playListCreateUserName", "TEXT", false, 0, null, 1));
            map3.put("mPlayListPicPath", new TableInfo.Column("mPlayListPicPath", "TEXT", false, 0, null, 1));
            map3.put("isReset", new TableInfo.Column("isReset", "INTEGER", true, 0, null, 1));
            map3.put("musicSource", new TableInfo.Column("musicSource", "INTEGER", true, 0, null, 1));
            map3.put("globalCollectionId", new TableInfo.Column("globalCollectionId", "TEXT", false, 0, null, 1));
            map3.put("audition", new TableInfo.Column("audition", "INTEGER", true, 0, null, 1));
            map3.put("gif_id", new TableInfo.Column("gif_id", "INTEGER", true, 0, null, 1));
            map3.put("fileOrderWeight", new TableInfo.Column("fileOrderWeight", "INTEGER", true, 0, null, 1));
            map3.put("collectTime", new TableInfo.Column("collectTime", "INTEGER", true, 0, null, 1));
            map3.put("channelCommentId", new TableInfo.Column("channelCommentId", "TEXT", false, 0, null, 1));
            map3.put("extParams", new TableInfo.Column("extParams", "TEXT", false, 0, null, 1));
            map3.put("sid", new TableInfo.Column("sid", "INTEGER", true, 0, null, 1));
            map3.put("cur_remark", new TableInfo.Column("cur_remark", "TEXT", false, 0, null, 1));
            map3.put("remark", new TableInfo.Column("remark", "TEXT", false, 0, null, 1));
            map3.put("display_name", new TableInfo.Column("display_name", "TEXT", false, 0, null, 1));
            map3.put("trackName", new TableInfo.Column("trackName", "TEXT", false, 0, null, 1));
            map3.put("albumName", new TableInfo.Column("albumName", "TEXT", false, 0, null, 1));
            map3.put("album_id", new TableInfo.Column("album_id", "INTEGER", true, 0, null, 1));
            map3.put("feeAlbumId", new TableInfo.Column("feeAlbumId", "TEXT", false, 0, null, 1));
            map3.put("mixId", new TableInfo.Column("mixId", "INTEGER", true, 0, null, 1));
            map3.put("oldMixId", new TableInfo.Column("oldMixId", "INTEGER", true, 0, null, 1));
            map3.put("audioId", new TableInfo.Column("audioId", "INTEGER", true, 0, null, 1));
            map3.put("track_id", new TableInfo.Column("track_id", "INTEGER", true, 0, null, 1));
            map3.put("artistName", new TableInfo.Column("artistName", "TEXT", false, 0, null, 1));
            map3.put("genre", new TableInfo.Column("genre", "TEXT", false, 0, null, 1));
            map3.put("artist_id", new TableInfo.Column("artist_id", "INTEGER", true, 0, null, 1));
            map3.put("size", new TableInfo.Column("size", "INTEGER", true, 0, null, 1));
            map3.put("hashValue", new TableInfo.Column("hashValue", "TEXT", false, 0, null, 1));
            map3.put("musicpath", new TableInfo.Column("musicpath", "TEXT", false, 0, null, 1));
            map3.put("bitrate", new TableInfo.Column("bitrate", "INTEGER", true, 0, null, 1));
            map3.put("duration", new TableInfo.Column("duration", "INTEGER", true, 0, null, 1));
            map3.put("m4aHash", new TableInfo.Column("m4aHash", "TEXT", false, 0, null, 1));
            map3.put("m4aSize", new TableInfo.Column("m4aSize", "INTEGER", true, 0, null, 1));
            map3.put("m4aUrl", new TableInfo.Column("m4aUrl", "TEXT", false, 0, null, 1));
            map3.put("hash320", new TableInfo.Column("hash320", "TEXT", false, 0, null, 1));
            map3.put("size320", new TableInfo.Column("size320", "INTEGER", true, 0, null, 1));
            map3.put("sqHash", new TableInfo.Column("sqHash", "TEXT", false, 0, null, 1));
            map3.put("sqSize", new TableInfo.Column("sqSize", "INTEGER", true, 0, null, 1));
            map3.put("mvHashValue", new TableInfo.Column("mvHashValue", "TEXT", false, 0, null, 1));
            map3.put("mvTracks", new TableInfo.Column("mvTracks", "INTEGER", true, 0, null, 1));
            map3.put("mvType", new TableInfo.Column("mvType", "INTEGER", true, 0, null, 1));
            map3.put("mvMatchTime", new TableInfo.Column("mvMatchTime", "INTEGER", true, 0, null, 1));
            map3.put("accompanimentHash", new TableInfo.Column("accompanimentHash", "TEXT", false, 0, null, 1));
            map3.put("accompanimentTime", new TableInfo.Column("accompanimentTime", "INTEGER", true, 0, null, 1));
            map3.put("accompanimentId", new TableInfo.Column("accompanimentId", "INTEGER", true, 0, null, 1));
            map3.put("has_accompany", new TableInfo.Column("has_accompany", "INTEGER", true, 0, null, 1));
            map3.put("sourceHash", new TableInfo.Column("sourceHash", "TEXT", false, 0, null, 1));
            map3.put("fileId", new TableInfo.Column("fileId", "INTEGER", true, 0, null, 1));
            map3.put("musicLinkSource", new TableInfo.Column("musicLinkSource", "INTEGER", true, 0, null, 1));
            map3.put("mSpecialOrAlbumName", new TableInfo.Column("mSpecialOrAlbumName", "TEXT", false, 0, null, 1));
            map3.put("musicLinkExtInfo", new TableInfo.Column("musicLinkExtInfo", "TEXT", false, 0, null, 1));
            map3.put("hashType", new TableInfo.Column("hashType", "INTEGER", true, 0, null, 1));
            map3.put("imgUrl", new TableInfo.Column("imgUrl", "TEXT", false, 0, null, 1));
            map3.put("sk", new TableInfo.Column("sk", "TEXT", false, 0, null, 1));
            map3.put("isExclusivePublish", new TableInfo.Column("isExclusivePublish", "INTEGER", true, 0, null, 1));
            map3.put("extname", new TableInfo.Column("extname", "TEXT", false, 0, null, 1));
            map3.put("feeType", new TableInfo.Column("feeType", "INTEGER", true, 0, null, 1));
            map3.put("isnew", new TableInfo.Column("isnew", "INTEGER", true, 0, null, 1));
            map3.put("fullName", new TableInfo.Column("fullName", "TEXT", false, 0, null, 1));
            map3.put("source", new TableInfo.Column("source", "TEXT", false, 0, null, 1));
            map3.put("sourceType", new TableInfo.Column("sourceType", "TEXT", false, 0, null, 1));
            map3.put("srctype", new TableInfo.Column("srctype", "INTEGER", true, 0, null, 1));
            map3.put("genreId", new TableInfo.Column("genreId", "INTEGER", true, 0, null, 1));
            map3.put("albumMatchTime", new TableInfo.Column("albumMatchTime", "INTEGER", true, 0, null, 1));
            map3.put("isInsertPlay", new TableInfo.Column("isInsertPlay", "INTEGER", true, 0, null, 1));
            map3.put("charge", new TableInfo.Column("charge", "INTEGER", true, 0, null, 1));
            map3.put("behavior", new TableInfo.Column("behavior", "TEXT", false, 0, null, 1));
            map3.put("module", new TableInfo.Column("module", "TEXT", false, 0, null, 1));
            map3.put("songSource", new TableInfo.Column("songSource", "INTEGER", true, 0, null, 1));
            map3.put("inList", new TableInfo.Column("inList", "INTEGER", true, 0, null, 1));
            map3.put("sourceMode", new TableInfo.Column("sourceMode", "INTEGER", true, 0, null, 1));
            map3.put("musicFeeStatus", new TableInfo.Column("musicFeeStatus", "INTEGER", true, 0, null, 1));
            map3.put("musicFeeType", new TableInfo.Column("musicFeeType", "TEXT", false, 0, null, 1));
            map3.put("failProcess", new TableInfo.Column("failProcess", "INTEGER", true, 0, null, 1));
            map3.put("payType", new TableInfo.Column("payType", "INTEGER", true, 0, null, 1));
            map3.put("updateFeeStatusTime", new TableInfo.Column("updateFeeStatusTime", "INTEGER", true, 0, null, 1));
            map3.put("localMusicFeeId", new TableInfo.Column("localMusicFeeId", "INTEGER", true, 0, null, 1));
            map3.put("oldCpy", new TableInfo.Column("oldCpy", "INTEGER", true, 0, null, 1));
            map3.put("isFileDownloaded", new TableInfo.Column("isFileDownloaded", "INTEGER", true, 0, null, 1));
            map3.put("isMusicCloudFile", new TableInfo.Column("isMusicCloudFile", "INTEGER", true, 0, null, 1));
            map3.put("mDownloadStatus", new TableInfo.Column("mDownloadStatus", "INTEGER", true, 0, null, 1));
            map3.put("isPlayMusicCloud", new TableInfo.Column("isPlayMusicCloud", "INTEGER", true, 0, null, 1));
            map3.put("tag", new TableInfo.Column("tag", "INTEGER", true, 0, null, 1));
            map3.put("publishYear", new TableInfo.Column("publishYear", "TEXT", false, 0, null, 1));
            map3.put("publishYearMatchTime", new TableInfo.Column("publishYearMatchTime", "INTEGER", true, 0, null, 1));
            map3.put(KrcLoader.TAG_LANGUAGE, new TableInfo.Column(KrcLoader.TAG_LANGUAGE, "TEXT", false, 0, null, 1));
            map3.put("languageMatchTime", new TableInfo.Column("languageMatchTime", "INTEGER", true, 0, null, 1));
            map3.put("isUserSetLanguage", new TableInfo.Column("isUserSetLanguage", "INTEGER", true, 0, null, 1));
            map3.put("isUserSetPublishYear", new TableInfo.Column("isUserSetPublishYear", "INTEGER", true, 0, null, 1));
            map3.put("authorId", new TableInfo.Column("authorId", "INTEGER", true, 0, null, 1));
            map3.put("specialId", new TableInfo.Column("specialId", "INTEGER", true, 0, null, 1));
            map3.put("rankId", new TableInfo.Column("rankId", "INTEGER", true, 0, null, 1));
            map3.put("topic", new TableInfo.Column("topic", "TEXT", false, 0, null, 1));
            map3.put("songType", new TableInfo.Column("songType", "TEXT", false, 0, null, 1));
            map3.put("fromLocalMusic", new TableInfo.Column("fromLocalMusic", "INTEGER", true, 0, null, 1));
            map3.put("isUserPlay", new TableInfo.Column("isUserPlay", "INTEGER", true, 0, null, 1));
            map3.put("audioType", new TableInfo.Column("audioType", "INTEGER", true, 0, null, 1));
            map3.put("sort", new TableInfo.Column("sort", "INTEGER", true, 0, null, 1));
            map3.put("audioIndex", new TableInfo.Column("audioIndex", "INTEGER", true, 0, null, 1));
            map3.put("mFlag", new TableInfo.Column("mFlag", "INTEGER", true, 0, null, 1));
            map3.put("ugcReviewed", new TableInfo.Column("ugcReviewed", "INTEGER", true, 0, null, 1));
            map3.put("qualityFeeSource", new TableInfo.Column("qualityFeeSource", "INTEGER", true, 0, null, 1));
            map3.put("isFromMyAsset", new TableInfo.Column("isFromMyAsset", "INTEGER", true, 0, null, 1));
            map3.put("fileEncryptType", new TableInfo.Column("fileEncryptType", "INTEGER", true, 0, null, 1));
            map3.put("isLocalEncryptUpgradeMP3", new TableInfo.Column("isLocalEncryptUpgradeMP3", "INTEGER", true, 0, null, 1));
            map3.put("maskOfForceDownload", new TableInfo.Column("maskOfForceDownload", "INTEGER", true, 0, null, 1));
            map3.put("guessYouLikeMark", new TableInfo.Column("guessYouLikeMark", "INTEGER", true, 0, null, 1));
            map3.put("guessYouLikeBiString", new TableInfo.Column("guessYouLikeBiString", "TEXT", false, 0, null, 1));
            map3.put("brief", new TableInfo.Column("brief", "TEXT", false, 0, null, 1));
            TableInfo tableInfo5 = new TableInfo("kugou_songs", map3, new HashSet(0), new HashSet(0));
            TableInfo tableInfo6 = TableInfo.read(supportSQLiteDatabase, "kugou_songs");
            if (!tableInfo5.equals(tableInfo6)) {
                return new RoomOpenHelper.ValidationResult(false, "kugou_songs(com.kugou.android.watch.lite.common.music.entity.KGMusic).\n Expected:\n" + tableInfo5 + "\n Found:\n" + tableInfo6);
            }
            HashMap map4 = new HashMap(22);
            map4.put(DbOpenHelper.ID, new TableInfo.Column(DbOpenHelper.ID, "INTEGER", true, 1, null, 1));
            map4.put("downloadsize", new TableInfo.Column("downloadsize", "INTEGER", true, 0, null, 1));
            map4.put("filesize", new TableInfo.Column("filesize", "INTEGER", true, 0, null, 1));
            map4.put("downloadstate", new TableInfo.Column("downloadstate", "INTEGER", true, 0, null, 1));
            map4.put("download_error_code", new TableInfo.Column("download_error_code", "INTEGER", true, 0, null, 1));
            map4.put("downloadkey", new TableInfo.Column("downloadkey", "TEXT", true, 0, null, 1));
            map4.put("quality", new TableInfo.Column("quality", "INTEGER", true, 0, null, 1));
            map4.put("downloadmode", new TableInfo.Column("downloadmode", "INTEGER", true, 0, null, 1));
            map4.put("addtime", new TableInfo.Column("addtime", "INTEGER", true, 0, null, 1));
            map4.put("songid", new TableInfo.Column("songid", "INTEGER", true, 0, null, 1));
            map4.put("fileid", new TableInfo.Column("fileid", "INTEGER", true, 0, null, 1));
            map4.put("iscover", new TableInfo.Column("iscover", "INTEGER", true, 0, null, 1));
            map4.put("module", new TableInfo.Column("module", "TEXT", true, 0, null, 1));
            map4.put("statuscode", new TableInfo.Column("statuscode", "INTEGER", true, 0, null, 1));
            map4.put("uploadstate", new TableInfo.Column("uploadstate", "INTEGER", true, 0, null, 1));
            map4.put("filetype", new TableInfo.Column("filetype", "INTEGER", true, 0, null, 1));
            map4.put("downloadtype", new TableInfo.Column("downloadtype", "INTEGER", true, 0, null, 1));
            map4.put("fee_album_id", new TableInfo.Column("fee_album_id", "TEXT", true, 0, null, 1));
            map4.put("mix_id", new TableInfo.Column("mix_id", "INTEGER", true, 0, null, 1));
            map4.put("source_hash", new TableInfo.Column("source_hash", "TEXT", true, 0, null, 1));
            map4.put("file_path", new TableInfo.Column("file_path", "TEXT", true, 0, null, 1));
            map4.put("tmp_cache_path", new TableInfo.Column("tmp_cache_path", "TEXT", true, 0, null, 1));
            TableInfo tableInfo7 = new TableInfo("downloadtask", map4, new HashSet(0), new HashSet(0));
            TableInfo tableInfo8 = TableInfo.read(supportSQLiteDatabase, "downloadtask");
            if (!tableInfo7.equals(tableInfo8)) {
                return new RoomOpenHelper.ValidationResult(false, "downloadtask(com.kugou.android.watch.lite.base.db.core.table.DownloadSong).\n Expected:\n" + tableInfo7 + "\n Found:\n" + tableInfo8);
            }
            HashMap map5 = new HashMap(3);
            map5.put("lastPlayTime", new TableInfo.Column("lastPlayTime", "INTEGER", true, 1, null, 1));
            map5.put("mixId", new TableInfo.Column("mixId", "INTEGER", true, 0, null, 1));
            map5.put("hash", new TableInfo.Column("hash", "TEXT", true, 0, null, 1));
            TableInfo tableInfo9 = new TableInfo("recent_songs", map5, new HashSet(0), new HashSet(0));
            TableInfo tableInfo10 = TableInfo.read(supportSQLiteDatabase, "recent_songs");
            if (!tableInfo9.equals(tableInfo10)) {
                return new RoomOpenHelper.ValidationResult(false, "recent_songs(com.kugou.android.watch.lite.base.db.core.table.RecentPlaySong).\n Expected:\n" + tableInfo9 + "\n Found:\n" + tableInfo10);
            }
            HashMap map6 = new HashMap(5);
            map6.put("opTime", new TableInfo.Column("opTime", "INTEGER", true, 1, null, 1));
            map6.put("mixId", new TableInfo.Column("mixId", "INTEGER", true, 0, null, 1));
            map6.put("playCount", new TableInfo.Column("playCount", "INTEGER", true, 0, null, 1));
            map6.put("action", new TableInfo.Column("action", "INTEGER", true, 0, null, 1));
            map6.put("userId", new TableInfo.Column("userId", "INTEGER", true, 0, null, 1));
            TableInfo tableInfo11 = new TableInfo("history_record", map6, new HashSet(0), new HashSet(0));
            TableInfo tableInfo12 = TableInfo.read(supportSQLiteDatabase, "history_record");
            if (!tableInfo11.equals(tableInfo12)) {
                return new RoomOpenHelper.ValidationResult(false, "history_record(com.kugou.android.watch.lite.base.db.core.table.HistoryPlaySong).\n Expected:\n" + tableInfo11 + "\n Found:\n" + tableInfo12);
            }
            HashMap map7 = new HashMap(7);
            map7.put("id", new TableInfo.Column("id", "INTEGER", true, 1, "0", 1));
            map7.put("fileHash", new TableInfo.Column("fileHash", "TEXT", false, 0, null, 1));
            map7.put("mixid", new TableInfo.Column("mixid", "INTEGER", true, 0, "0", 1));
            map7.put("userid", new TableInfo.Column("userid", "INTEGER", true, 0, "0", 1));
            map7.put("updateTime", new TableInfo.Column("updateTime", "INTEGER", true, 0, "0", 1));
            map7.put("createTime", new TableInfo.Column("createTime", "INTEGER", true, 0, "0", 1));
            map7.put("albumId", new TableInfo.Column("albumId", "INTEGER", true, 0, "0", 1));
            TableInfo tableInfo13 = new TableInfo("fee_kubi_buy_info_tab", map7, new HashSet(0), new HashSet(0));
            TableInfo tableInfo14 = TableInfo.read(supportSQLiteDatabase, "fee_kubi_buy_info_tab");
            if (tableInfo13.equals(tableInfo14)) {
                return new RoomOpenHelper.ValidationResult(true, null);
            }
            return new RoomOpenHelper.ValidationResult(false, "fee_kubi_buy_info_tab(com.kugou.android.watch.lite.base.myassets.FeeKubiBuyInfo).\n Expected:\n" + tableInfo13 + "\n Found:\n" + tableInfo14);
        }
    }

    @Override // androidx.room.RoomDatabase
    public void clearAllTables() {
        super.assertNotMainThread();
        SupportSQLiteDatabase writableDatabase = super.getOpenHelper().getWritableDatabase();
        try {
            super.beginTransaction();
            writableDatabase.execSQL("DELETE FROM `kugou_playlists`");
            writableDatabase.execSQL("DELETE FROM `playlistsong`");
            writableDatabase.execSQL("DELETE FROM `kugou_songs`");
            writableDatabase.execSQL("DELETE FROM `downloadtask`");
            writableDatabase.execSQL("DELETE FROM `recent_songs`");
            writableDatabase.execSQL("DELETE FROM `history_record`");
            writableDatabase.execSQL("DELETE FROM `fee_kubi_buy_info_tab`");
            super.setTransactionSuccessful();
        } finally {
            super.endTransaction();
            writableDatabase.query("PRAGMA wal_checkpoint(FULL)").close();
            if (!writableDatabase.inTransaction()) {
                writableDatabase.execSQL("VACUUM");
            }
        }
    }

    @Override // androidx.room.RoomDatabase
    public InvalidationTracker createInvalidationTracker() {
        return new InvalidationTracker(this, new HashMap(0), new HashMap(0), "kugou_playlists", "playlistsong", "kugou_songs", "downloadtask", "recent_songs", "history_record", "fee_kubi_buy_info_tab");
    }

    @Override // androidx.room.RoomDatabase
    public SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration databaseConfiguration) {
        return databaseConfiguration.sqliteOpenHelperFactory.create(SupportSQLiteOpenHelper.Configuration.builder(databaseConfiguration.context).name(databaseConfiguration.name).callback(new RoomOpenHelper(databaseConfiguration, new a(3), "cfd2ddaa41773b1805d91ecb24d01398", "d0b6220a90260e1e5549ddb8c78093bf")).build());
    }

    @Override // com.kugou.android.watch.lite.base.db.core.CoreDatabase
    public b e() {
        b bVar;
        if (this.f24h != null) {
            return this.f24h;
        }
        synchronized (this) {
            if (this.f24h == null) {
                this.f24h = new c(this);
            }
            bVar = this.f24h;
        }
        return bVar;
    }

    @Override // com.kugou.android.watch.lite.base.db.core.CoreDatabase
    public f f() {
        f fVar;
        if (this.k != null) {
            return this.k;
        }
        synchronized (this) {
            if (this.k == null) {
                this.k = new e.c.a.g.a.d.s.g(this);
            }
            fVar = this.k;
        }
        return fVar;
    }

    @Override // com.kugou.android.watch.lite.base.db.core.CoreDatabase
    public e g() {
        e eVar;
        if (this.j != null) {
            return this.j;
        }
        synchronized (this) {
            if (this.j == null) {
                this.j = new e.c.a.g.a.d.f.c.a.f(this);
            }
            eVar = this.j;
        }
        return eVar;
    }

    @Override // com.kugou.android.watch.lite.base.db.core.CoreDatabase
    public g h() {
        g gVar;
        if (this.f23g != null) {
            return this.f23g;
        }
        synchronized (this) {
            if (this.f23g == null) {
                this.f23g = new h(this);
            }
            gVar = this.f23g;
        }
        return gVar;
    }

    @Override // com.kugou.android.watch.lite.base.db.core.CoreDatabase
    public k i() {
        k kVar;
        if (this.f21e != null) {
            return this.f21e;
        }
        synchronized (this) {
            if (this.f21e == null) {
                this.f21e = new l(this);
            }
            kVar = this.f21e;
        }
        return kVar;
    }

    @Override // com.kugou.android.watch.lite.base.db.core.CoreDatabase
    public m j() {
        m mVar;
        if (this.f22f != null) {
            return this.f22f;
        }
        synchronized (this) {
            if (this.f22f == null) {
                this.f22f = new n(this);
            }
            mVar = this.f22f;
        }
        return mVar;
    }

    @Override // com.kugou.android.watch.lite.base.db.core.CoreDatabase
    public o k() {
        o oVar;
        if (this.f25i != null) {
            return this.f25i;
        }
        synchronized (this) {
            if (this.f25i == null) {
                this.f25i = new p(this);
            }
            oVar = this.f25i;
        }
        return oVar;
    }
}
