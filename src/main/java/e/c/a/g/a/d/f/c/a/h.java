package e.c.a.g.a.d.f.c.a;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.StringUtil;
import androidx.sqlite.db.SupportSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.kugou.android.watch.lite.common.music.entity.KGMusic;
import com.kugou.framework.lyric.loader.KrcLoader;
import com.tme.fireeye.crash.comm.db.DbOpenHelper;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class h extends g {
    public final RoomDatabase c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final EntityInsertionAdapter<KGMusic> f394d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final EntityDeletionOrUpdateAdapter<KGMusic> f395e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final SharedSQLiteStatement f396f;

    public class a extends EntityInsertionAdapter<KGMusic> {
        public a(h hVar, RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.EntityInsertionAdapter
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void bind(SupportSQLiteStatement supportSQLiteStatement, KGMusic kGMusic) {
            supportSQLiteStatement.bindLong(1, kGMusic.dbId);
            supportSQLiteStatement.bindLong(2, kGMusic.id);
            supportSQLiteStatement.bindLong(3, kGMusic.playListId);
            String str = kGMusic.playListName;
            if (str == null) {
                supportSQLiteStatement.bindNull(4);
            } else {
                supportSQLiteStatement.bindString(4, str);
            }
            supportSQLiteStatement.bindLong(5, kGMusic.playListCreateListId);
            supportSQLiteStatement.bindLong(6, kGMusic.playListCreateUserId);
            supportSQLiteStatement.bindLong(7, kGMusic.playListCloudListId);
            supportSQLiteStatement.bindLong(8, kGMusic.playListType);
            supportSQLiteStatement.bindLong(9, kGMusic.playListSource);
            supportSQLiteStatement.bindLong(10, kGMusic.musiclibId);
            String str2 = kGMusic.playListCreateUserName;
            if (str2 == null) {
                supportSQLiteStatement.bindNull(11);
            } else {
                supportSQLiteStatement.bindString(11, str2);
            }
            String str3 = kGMusic.mPlayListPicPath;
            if (str3 == null) {
                supportSQLiteStatement.bindNull(12);
            } else {
                supportSQLiteStatement.bindString(12, str3);
            }
            supportSQLiteStatement.bindLong(13, kGMusic.isReset ? 1L : 0L);
            supportSQLiteStatement.bindLong(14, kGMusic.musicSource);
            if (kGMusic.getGlobalCollectionId() == null) {
                supportSQLiteStatement.bindNull(15);
            } else {
                supportSQLiteStatement.bindString(15, kGMusic.getGlobalCollectionId());
            }
            supportSQLiteStatement.bindLong(16, kGMusic.getAudition());
            supportSQLiteStatement.bindLong(17, kGMusic.getGif_id());
            supportSQLiteStatement.bindLong(18, kGMusic.fileOrderWeight);
            supportSQLiteStatement.bindLong(19, kGMusic.collectTime);
            String str4 = kGMusic.channelCommentId;
            if (str4 == null) {
                supportSQLiteStatement.bindNull(20);
            } else {
                supportSQLiteStatement.bindString(20, str4);
            }
            String str5 = kGMusic.extParams;
            if (str5 == null) {
                supportSQLiteStatement.bindNull(21);
            } else {
                supportSQLiteStatement.bindString(21, str5);
            }
            supportSQLiteStatement.bindLong(22, kGMusic.sid);
            String str6 = kGMusic.curMark;
            if (str6 == null) {
                supportSQLiteStatement.bindNull(23);
            } else {
                supportSQLiteStatement.bindString(23, str6);
            }
            String str7 = kGMusic.remark;
            if (str7 == null) {
                supportSQLiteStatement.bindNull(24);
            } else {
                supportSQLiteStatement.bindString(24, str7);
            }
            String str8 = kGMusic.displayName;
            if (str8 == null) {
                supportSQLiteStatement.bindNull(25);
            } else {
                supportSQLiteStatement.bindString(25, str8);
            }
            String str9 = kGMusic.trackName;
            if (str9 == null) {
                supportSQLiteStatement.bindNull(26);
            } else {
                supportSQLiteStatement.bindString(26, str9);
            }
            String str10 = kGMusic.albumName;
            if (str10 == null) {
                supportSQLiteStatement.bindNull(27);
            } else {
                supportSQLiteStatement.bindString(27, str10);
            }
            supportSQLiteStatement.bindLong(28, kGMusic.albumID);
            String str11 = kGMusic.feeAlbumId;
            if (str11 == null) {
                supportSQLiteStatement.bindNull(29);
            } else {
                supportSQLiteStatement.bindString(29, str11);
            }
            supportSQLiteStatement.bindLong(30, kGMusic.mixId);
            supportSQLiteStatement.bindLong(31, kGMusic.oldMixId);
            supportSQLiteStatement.bindLong(32, kGMusic.audioId);
            supportSQLiteStatement.bindLong(33, kGMusic.trackID);
            String str12 = kGMusic.artistName;
            if (str12 == null) {
                supportSQLiteStatement.bindNull(34);
            } else {
                supportSQLiteStatement.bindString(34, str12);
            }
            String str13 = kGMusic.genre;
            if (str13 == null) {
                supportSQLiteStatement.bindNull(35);
            } else {
                supportSQLiteStatement.bindString(35, str13);
            }
            supportSQLiteStatement.bindLong(36, kGMusic.artistID);
            supportSQLiteStatement.bindLong(37, kGMusic.size);
            String str14 = kGMusic.hashValue;
            if (str14 == null) {
                supportSQLiteStatement.bindNull(38);
            } else {
                supportSQLiteStatement.bindString(38, str14);
            }
            String str15 = kGMusic.musicpath;
            if (str15 == null) {
                supportSQLiteStatement.bindNull(39);
            } else {
                supportSQLiteStatement.bindString(39, str15);
            }
            supportSQLiteStatement.bindLong(40, kGMusic.bitrate);
            supportSQLiteStatement.bindLong(41, kGMusic.duration);
            String str16 = kGMusic.m4aHash;
            if (str16 == null) {
                supportSQLiteStatement.bindNull(42);
            } else {
                supportSQLiteStatement.bindString(42, str16);
            }
            supportSQLiteStatement.bindLong(43, kGMusic.m4aSize);
            String str17 = kGMusic.m4aUrl;
            if (str17 == null) {
                supportSQLiteStatement.bindNull(44);
            } else {
                supportSQLiteStatement.bindString(44, str17);
            }
            String str18 = kGMusic.hash320;
            if (str18 == null) {
                supportSQLiteStatement.bindNull(45);
            } else {
                supportSQLiteStatement.bindString(45, str18);
            }
            supportSQLiteStatement.bindLong(46, kGMusic.size320);
            String str19 = kGMusic.sqHash;
            if (str19 == null) {
                supportSQLiteStatement.bindNull(47);
            } else {
                supportSQLiteStatement.bindString(47, str19);
            }
            supportSQLiteStatement.bindLong(48, kGMusic.sqSize);
            String str20 = kGMusic.mvHashValue;
            if (str20 == null) {
                supportSQLiteStatement.bindNull(49);
            } else {
                supportSQLiteStatement.bindString(49, str20);
            }
            supportSQLiteStatement.bindLong(50, kGMusic.mvTracks);
            supportSQLiteStatement.bindLong(51, kGMusic.mvType);
            supportSQLiteStatement.bindLong(52, kGMusic.mvMatchTime);
            String str21 = kGMusic.accompanimentHash;
            if (str21 == null) {
                supportSQLiteStatement.bindNull(53);
            } else {
                supportSQLiteStatement.bindString(53, str21);
            }
            supportSQLiteStatement.bindLong(54, kGMusic.accompanimentTime);
            supportSQLiteStatement.bindLong(55, kGMusic.accompanimentId);
            supportSQLiteStatement.bindLong(56, kGMusic.has_accompany);
            String str22 = kGMusic.sourceHash;
            if (str22 == null) {
                supportSQLiteStatement.bindNull(57);
            } else {
                supportSQLiteStatement.bindString(57, str22);
            }
            supportSQLiteStatement.bindLong(58, kGMusic.fileId);
            supportSQLiteStatement.bindLong(59, kGMusic.musicLinkSource);
            String str23 = kGMusic.mSpecialOrAlbumName;
            if (str23 == null) {
                supportSQLiteStatement.bindNull(60);
            } else {
                supportSQLiteStatement.bindString(60, str23);
            }
            String str24 = kGMusic.musicLinkExtInfo;
            if (str24 == null) {
                supportSQLiteStatement.bindNull(61);
            } else {
                supportSQLiteStatement.bindString(61, str24);
            }
            supportSQLiteStatement.bindLong(62, kGMusic.hashType);
            String str25 = kGMusic.imgUrl;
            if (str25 == null) {
                supportSQLiteStatement.bindNull(63);
            } else {
                supportSQLiteStatement.bindString(63, str25);
            }
            String str26 = kGMusic.sk;
            if (str26 == null) {
                supportSQLiteStatement.bindNull(64);
            } else {
                supportSQLiteStatement.bindString(64, str26);
            }
            supportSQLiteStatement.bindLong(65, kGMusic.isExclusivePublish ? 1L : 0L);
            String str27 = kGMusic.extname;
            if (str27 == null) {
                supportSQLiteStatement.bindNull(66);
            } else {
                supportSQLiteStatement.bindString(66, str27);
            }
            supportSQLiteStatement.bindLong(67, kGMusic.feeType);
            supportSQLiteStatement.bindLong(68, kGMusic.isnew);
            String str28 = kGMusic.fullName;
            if (str28 == null) {
                supportSQLiteStatement.bindNull(69);
            } else {
                supportSQLiteStatement.bindString(69, str28);
            }
            String str29 = kGMusic.source;
            if (str29 == null) {
                supportSQLiteStatement.bindNull(70);
            } else {
                supportSQLiteStatement.bindString(70, str29);
            }
            String str30 = kGMusic.sourceType;
            if (str30 == null) {
                supportSQLiteStatement.bindNull(71);
            } else {
                supportSQLiteStatement.bindString(71, str30);
            }
            supportSQLiteStatement.bindLong(72, kGMusic.srctype);
            supportSQLiteStatement.bindLong(73, kGMusic.genreId);
            supportSQLiteStatement.bindLong(74, kGMusic.albumMatchTime);
            supportSQLiteStatement.bindLong(75, kGMusic.isInsertPlay);
            supportSQLiteStatement.bindLong(76, kGMusic.charge);
            String str31 = kGMusic.behavior;
            if (str31 == null) {
                supportSQLiteStatement.bindNull(77);
            } else {
                supportSQLiteStatement.bindString(77, str31);
            }
            String str32 = kGMusic.module;
            if (str32 == null) {
                supportSQLiteStatement.bindNull(78);
            } else {
                supportSQLiteStatement.bindString(78, str32);
            }
            supportSQLiteStatement.bindLong(79, kGMusic.songSource);
            supportSQLiteStatement.bindLong(80, kGMusic.inList);
            supportSQLiteStatement.bindLong(81, kGMusic.sourceMode);
            supportSQLiteStatement.bindLong(82, kGMusic.musicFeeStatus);
            String str33 = kGMusic.musicFeeType;
            if (str33 == null) {
                supportSQLiteStatement.bindNull(83);
            } else {
                supportSQLiteStatement.bindString(83, str33);
            }
            supportSQLiteStatement.bindLong(84, kGMusic.failProcess);
            supportSQLiteStatement.bindLong(85, kGMusic.payType);
            supportSQLiteStatement.bindLong(86, kGMusic.updateFeeStatusTime);
            supportSQLiteStatement.bindLong(87, kGMusic.localMusicFeeId);
            supportSQLiteStatement.bindLong(88, kGMusic.oldCpy);
            supportSQLiteStatement.bindLong(89, kGMusic.isFileDownloaded ? 1L : 0L);
            supportSQLiteStatement.bindLong(90, kGMusic.isMusicCloudFile ? 1L : 0L);
            supportSQLiteStatement.bindLong(91, kGMusic.mDownloadStatus);
            supportSQLiteStatement.bindLong(92, kGMusic.isPlayMusicCloud ? 1L : 0L);
            supportSQLiteStatement.bindLong(93, kGMusic.tag);
            String str34 = kGMusic.publishYear;
            if (str34 == null) {
                supportSQLiteStatement.bindNull(94);
            } else {
                supportSQLiteStatement.bindString(94, str34);
            }
            supportSQLiteStatement.bindLong(95, kGMusic.publishYearMatchTime);
            String str35 = kGMusic.language;
            if (str35 == null) {
                supportSQLiteStatement.bindNull(96);
            } else {
                supportSQLiteStatement.bindString(96, str35);
            }
            supportSQLiteStatement.bindLong(97, kGMusic.languageMatchTime);
            supportSQLiteStatement.bindLong(98, kGMusic.isUserSetLanguage ? 1L : 0L);
            supportSQLiteStatement.bindLong(99, kGMusic.isUserSetPublishYear ? 1L : 0L);
            supportSQLiteStatement.bindLong(100, kGMusic.getAuthorId());
            supportSQLiteStatement.bindLong(101, kGMusic.getSpecialId());
            supportSQLiteStatement.bindLong(102, kGMusic.getRankId());
            if (kGMusic.getTopic() == null) {
                supportSQLiteStatement.bindNull(103);
            } else {
                supportSQLiteStatement.bindString(103, kGMusic.getTopic());
            }
            if (kGMusic.getSongType() == null) {
                supportSQLiteStatement.bindNull(104);
            } else {
                supportSQLiteStatement.bindString(104, kGMusic.getSongType());
            }
            supportSQLiteStatement.bindLong(105, kGMusic.isFromLocalMusic() ? 1L : 0L);
            supportSQLiteStatement.bindLong(106, kGMusic.isUserPlay() ? 1L : 0L);
            supportSQLiteStatement.bindLong(107, kGMusic.getAudioType());
            supportSQLiteStatement.bindLong(108, kGMusic.getSort());
            supportSQLiteStatement.bindLong(109, kGMusic.getAudioIndex());
            supportSQLiteStatement.bindLong(110, kGMusic.getFlag());
            supportSQLiteStatement.bindLong(111, kGMusic.getUgcReviewed());
            supportSQLiteStatement.bindLong(112, kGMusic.getQualityFeeSource());
            supportSQLiteStatement.bindLong(113, kGMusic.isFromMyAsset() ? 1L : 0L);
            supportSQLiteStatement.bindLong(114, kGMusic.getFileEncryptType());
            supportSQLiteStatement.bindLong(115, kGMusic.isLocalEncryptUpgradeMP3() ? 1L : 0L);
            supportSQLiteStatement.bindLong(116, kGMusic.getMaskOfForceDownload());
            supportSQLiteStatement.bindLong(117, kGMusic.getGuessYouLikeMark());
            if (kGMusic.getGuessYouLikeBiString() == null) {
                supportSQLiteStatement.bindNull(118);
            } else {
                supportSQLiteStatement.bindString(118, kGMusic.getGuessYouLikeBiString());
            }
            if (kGMusic.getBrief() == null) {
                supportSQLiteStatement.bindNull(119);
            } else {
                supportSQLiteStatement.bindString(119, kGMusic.getBrief());
            }
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "INSERT OR REPLACE INTO `kugou_songs` (`_id`,`id`,`playListId`,`playListName`,`playListCreateListId`,`playListCreateUserId`,`playListCloudListId`,`playListType`,`playListSource`,`musiclibId`,`playListCreateUserName`,`mPlayListPicPath`,`isReset`,`musicSource`,`globalCollectionId`,`audition`,`gif_id`,`fileOrderWeight`,`collectTime`,`channelCommentId`,`extParams`,`sid`,`cur_remark`,`remark`,`display_name`,`trackName`,`albumName`,`album_id`,`feeAlbumId`,`mixId`,`oldMixId`,`audioId`,`track_id`,`artistName`,`genre`,`artist_id`,`size`,`hashValue`,`musicpath`,`bitrate`,`duration`,`m4aHash`,`m4aSize`,`m4aUrl`,`hash320`,`size320`,`sqHash`,`sqSize`,`mvHashValue`,`mvTracks`,`mvType`,`mvMatchTime`,`accompanimentHash`,`accompanimentTime`,`accompanimentId`,`has_accompany`,`sourceHash`,`fileId`,`musicLinkSource`,`mSpecialOrAlbumName`,`musicLinkExtInfo`,`hashType`,`imgUrl`,`sk`,`isExclusivePublish`,`extname`,`feeType`,`isnew`,`fullName`,`source`,`sourceType`,`srctype`,`genreId`,`albumMatchTime`,`isInsertPlay`,`charge`,`behavior`,`module`,`songSource`,`inList`,`sourceMode`,`musicFeeStatus`,`musicFeeType`,`failProcess`,`payType`,`updateFeeStatusTime`,`localMusicFeeId`,`oldCpy`,`isFileDownloaded`,`isMusicCloudFile`,`mDownloadStatus`,`isPlayMusicCloud`,`tag`,`publishYear`,`publishYearMatchTime`,`language`,`languageMatchTime`,`isUserSetLanguage`,`isUserSetPublishYear`,`authorId`,`specialId`,`rankId`,`topic`,`songType`,`fromLocalMusic`,`isUserPlay`,`audioType`,`sort`,`audioIndex`,`mFlag`,`ugcReviewed`,`qualityFeeSource`,`isFromMyAsset`,`fileEncryptType`,`isLocalEncryptUpgradeMP3`,`maskOfForceDownload`,`guessYouLikeMark`,`guessYouLikeBiString`,`brief`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        }
    }

    public class b extends EntityDeletionOrUpdateAdapter<KGMusic> {
        public b(h hVar, RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.EntityDeletionOrUpdateAdapter
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void bind(SupportSQLiteStatement supportSQLiteStatement, KGMusic kGMusic) {
            supportSQLiteStatement.bindLong(1, kGMusic.dbId);
        }

        @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "DELETE FROM `kugou_songs` WHERE `_id` = ?";
        }
    }

    public class c extends EntityDeletionOrUpdateAdapter<KGMusic> {
        public c(h hVar, RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.EntityDeletionOrUpdateAdapter
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void bind(SupportSQLiteStatement supportSQLiteStatement, KGMusic kGMusic) {
            supportSQLiteStatement.bindLong(1, kGMusic.dbId);
            supportSQLiteStatement.bindLong(2, kGMusic.id);
            supportSQLiteStatement.bindLong(3, kGMusic.playListId);
            String str = kGMusic.playListName;
            if (str == null) {
                supportSQLiteStatement.bindNull(4);
            } else {
                supportSQLiteStatement.bindString(4, str);
            }
            supportSQLiteStatement.bindLong(5, kGMusic.playListCreateListId);
            supportSQLiteStatement.bindLong(6, kGMusic.playListCreateUserId);
            supportSQLiteStatement.bindLong(7, kGMusic.playListCloudListId);
            supportSQLiteStatement.bindLong(8, kGMusic.playListType);
            supportSQLiteStatement.bindLong(9, kGMusic.playListSource);
            supportSQLiteStatement.bindLong(10, kGMusic.musiclibId);
            String str2 = kGMusic.playListCreateUserName;
            if (str2 == null) {
                supportSQLiteStatement.bindNull(11);
            } else {
                supportSQLiteStatement.bindString(11, str2);
            }
            String str3 = kGMusic.mPlayListPicPath;
            if (str3 == null) {
                supportSQLiteStatement.bindNull(12);
            } else {
                supportSQLiteStatement.bindString(12, str3);
            }
            supportSQLiteStatement.bindLong(13, kGMusic.isReset ? 1L : 0L);
            supportSQLiteStatement.bindLong(14, kGMusic.musicSource);
            if (kGMusic.getGlobalCollectionId() == null) {
                supportSQLiteStatement.bindNull(15);
            } else {
                supportSQLiteStatement.bindString(15, kGMusic.getGlobalCollectionId());
            }
            supportSQLiteStatement.bindLong(16, kGMusic.getAudition());
            supportSQLiteStatement.bindLong(17, kGMusic.getGif_id());
            supportSQLiteStatement.bindLong(18, kGMusic.fileOrderWeight);
            supportSQLiteStatement.bindLong(19, kGMusic.collectTime);
            String str4 = kGMusic.channelCommentId;
            if (str4 == null) {
                supportSQLiteStatement.bindNull(20);
            } else {
                supportSQLiteStatement.bindString(20, str4);
            }
            String str5 = kGMusic.extParams;
            if (str5 == null) {
                supportSQLiteStatement.bindNull(21);
            } else {
                supportSQLiteStatement.bindString(21, str5);
            }
            supportSQLiteStatement.bindLong(22, kGMusic.sid);
            String str6 = kGMusic.curMark;
            if (str6 == null) {
                supportSQLiteStatement.bindNull(23);
            } else {
                supportSQLiteStatement.bindString(23, str6);
            }
            String str7 = kGMusic.remark;
            if (str7 == null) {
                supportSQLiteStatement.bindNull(24);
            } else {
                supportSQLiteStatement.bindString(24, str7);
            }
            String str8 = kGMusic.displayName;
            if (str8 == null) {
                supportSQLiteStatement.bindNull(25);
            } else {
                supportSQLiteStatement.bindString(25, str8);
            }
            String str9 = kGMusic.trackName;
            if (str9 == null) {
                supportSQLiteStatement.bindNull(26);
            } else {
                supportSQLiteStatement.bindString(26, str9);
            }
            String str10 = kGMusic.albumName;
            if (str10 == null) {
                supportSQLiteStatement.bindNull(27);
            } else {
                supportSQLiteStatement.bindString(27, str10);
            }
            supportSQLiteStatement.bindLong(28, kGMusic.albumID);
            String str11 = kGMusic.feeAlbumId;
            if (str11 == null) {
                supportSQLiteStatement.bindNull(29);
            } else {
                supportSQLiteStatement.bindString(29, str11);
            }
            supportSQLiteStatement.bindLong(30, kGMusic.mixId);
            supportSQLiteStatement.bindLong(31, kGMusic.oldMixId);
            supportSQLiteStatement.bindLong(32, kGMusic.audioId);
            supportSQLiteStatement.bindLong(33, kGMusic.trackID);
            String str12 = kGMusic.artistName;
            if (str12 == null) {
                supportSQLiteStatement.bindNull(34);
            } else {
                supportSQLiteStatement.bindString(34, str12);
            }
            String str13 = kGMusic.genre;
            if (str13 == null) {
                supportSQLiteStatement.bindNull(35);
            } else {
                supportSQLiteStatement.bindString(35, str13);
            }
            supportSQLiteStatement.bindLong(36, kGMusic.artistID);
            supportSQLiteStatement.bindLong(37, kGMusic.size);
            String str14 = kGMusic.hashValue;
            if (str14 == null) {
                supportSQLiteStatement.bindNull(38);
            } else {
                supportSQLiteStatement.bindString(38, str14);
            }
            String str15 = kGMusic.musicpath;
            if (str15 == null) {
                supportSQLiteStatement.bindNull(39);
            } else {
                supportSQLiteStatement.bindString(39, str15);
            }
            supportSQLiteStatement.bindLong(40, kGMusic.bitrate);
            supportSQLiteStatement.bindLong(41, kGMusic.duration);
            String str16 = kGMusic.m4aHash;
            if (str16 == null) {
                supportSQLiteStatement.bindNull(42);
            } else {
                supportSQLiteStatement.bindString(42, str16);
            }
            supportSQLiteStatement.bindLong(43, kGMusic.m4aSize);
            String str17 = kGMusic.m4aUrl;
            if (str17 == null) {
                supportSQLiteStatement.bindNull(44);
            } else {
                supportSQLiteStatement.bindString(44, str17);
            }
            String str18 = kGMusic.hash320;
            if (str18 == null) {
                supportSQLiteStatement.bindNull(45);
            } else {
                supportSQLiteStatement.bindString(45, str18);
            }
            supportSQLiteStatement.bindLong(46, kGMusic.size320);
            String str19 = kGMusic.sqHash;
            if (str19 == null) {
                supportSQLiteStatement.bindNull(47);
            } else {
                supportSQLiteStatement.bindString(47, str19);
            }
            supportSQLiteStatement.bindLong(48, kGMusic.sqSize);
            String str20 = kGMusic.mvHashValue;
            if (str20 == null) {
                supportSQLiteStatement.bindNull(49);
            } else {
                supportSQLiteStatement.bindString(49, str20);
            }
            supportSQLiteStatement.bindLong(50, kGMusic.mvTracks);
            supportSQLiteStatement.bindLong(51, kGMusic.mvType);
            supportSQLiteStatement.bindLong(52, kGMusic.mvMatchTime);
            String str21 = kGMusic.accompanimentHash;
            if (str21 == null) {
                supportSQLiteStatement.bindNull(53);
            } else {
                supportSQLiteStatement.bindString(53, str21);
            }
            supportSQLiteStatement.bindLong(54, kGMusic.accompanimentTime);
            supportSQLiteStatement.bindLong(55, kGMusic.accompanimentId);
            supportSQLiteStatement.bindLong(56, kGMusic.has_accompany);
            String str22 = kGMusic.sourceHash;
            if (str22 == null) {
                supportSQLiteStatement.bindNull(57);
            } else {
                supportSQLiteStatement.bindString(57, str22);
            }
            supportSQLiteStatement.bindLong(58, kGMusic.fileId);
            supportSQLiteStatement.bindLong(59, kGMusic.musicLinkSource);
            String str23 = kGMusic.mSpecialOrAlbumName;
            if (str23 == null) {
                supportSQLiteStatement.bindNull(60);
            } else {
                supportSQLiteStatement.bindString(60, str23);
            }
            String str24 = kGMusic.musicLinkExtInfo;
            if (str24 == null) {
                supportSQLiteStatement.bindNull(61);
            } else {
                supportSQLiteStatement.bindString(61, str24);
            }
            supportSQLiteStatement.bindLong(62, kGMusic.hashType);
            String str25 = kGMusic.imgUrl;
            if (str25 == null) {
                supportSQLiteStatement.bindNull(63);
            } else {
                supportSQLiteStatement.bindString(63, str25);
            }
            String str26 = kGMusic.sk;
            if (str26 == null) {
                supportSQLiteStatement.bindNull(64);
            } else {
                supportSQLiteStatement.bindString(64, str26);
            }
            supportSQLiteStatement.bindLong(65, kGMusic.isExclusivePublish ? 1L : 0L);
            String str27 = kGMusic.extname;
            if (str27 == null) {
                supportSQLiteStatement.bindNull(66);
            } else {
                supportSQLiteStatement.bindString(66, str27);
            }
            supportSQLiteStatement.bindLong(67, kGMusic.feeType);
            supportSQLiteStatement.bindLong(68, kGMusic.isnew);
            String str28 = kGMusic.fullName;
            if (str28 == null) {
                supportSQLiteStatement.bindNull(69);
            } else {
                supportSQLiteStatement.bindString(69, str28);
            }
            String str29 = kGMusic.source;
            if (str29 == null) {
                supportSQLiteStatement.bindNull(70);
            } else {
                supportSQLiteStatement.bindString(70, str29);
            }
            String str30 = kGMusic.sourceType;
            if (str30 == null) {
                supportSQLiteStatement.bindNull(71);
            } else {
                supportSQLiteStatement.bindString(71, str30);
            }
            supportSQLiteStatement.bindLong(72, kGMusic.srctype);
            supportSQLiteStatement.bindLong(73, kGMusic.genreId);
            supportSQLiteStatement.bindLong(74, kGMusic.albumMatchTime);
            supportSQLiteStatement.bindLong(75, kGMusic.isInsertPlay);
            supportSQLiteStatement.bindLong(76, kGMusic.charge);
            String str31 = kGMusic.behavior;
            if (str31 == null) {
                supportSQLiteStatement.bindNull(77);
            } else {
                supportSQLiteStatement.bindString(77, str31);
            }
            String str32 = kGMusic.module;
            if (str32 == null) {
                supportSQLiteStatement.bindNull(78);
            } else {
                supportSQLiteStatement.bindString(78, str32);
            }
            supportSQLiteStatement.bindLong(79, kGMusic.songSource);
            supportSQLiteStatement.bindLong(80, kGMusic.inList);
            supportSQLiteStatement.bindLong(81, kGMusic.sourceMode);
            supportSQLiteStatement.bindLong(82, kGMusic.musicFeeStatus);
            String str33 = kGMusic.musicFeeType;
            if (str33 == null) {
                supportSQLiteStatement.bindNull(83);
            } else {
                supportSQLiteStatement.bindString(83, str33);
            }
            supportSQLiteStatement.bindLong(84, kGMusic.failProcess);
            supportSQLiteStatement.bindLong(85, kGMusic.payType);
            supportSQLiteStatement.bindLong(86, kGMusic.updateFeeStatusTime);
            supportSQLiteStatement.bindLong(87, kGMusic.localMusicFeeId);
            supportSQLiteStatement.bindLong(88, kGMusic.oldCpy);
            supportSQLiteStatement.bindLong(89, kGMusic.isFileDownloaded ? 1L : 0L);
            supportSQLiteStatement.bindLong(90, kGMusic.isMusicCloudFile ? 1L : 0L);
            supportSQLiteStatement.bindLong(91, kGMusic.mDownloadStatus);
            supportSQLiteStatement.bindLong(92, kGMusic.isPlayMusicCloud ? 1L : 0L);
            supportSQLiteStatement.bindLong(93, kGMusic.tag);
            String str34 = kGMusic.publishYear;
            if (str34 == null) {
                supportSQLiteStatement.bindNull(94);
            } else {
                supportSQLiteStatement.bindString(94, str34);
            }
            supportSQLiteStatement.bindLong(95, kGMusic.publishYearMatchTime);
            String str35 = kGMusic.language;
            if (str35 == null) {
                supportSQLiteStatement.bindNull(96);
            } else {
                supportSQLiteStatement.bindString(96, str35);
            }
            supportSQLiteStatement.bindLong(97, kGMusic.languageMatchTime);
            supportSQLiteStatement.bindLong(98, kGMusic.isUserSetLanguage ? 1L : 0L);
            supportSQLiteStatement.bindLong(99, kGMusic.isUserSetPublishYear ? 1L : 0L);
            supportSQLiteStatement.bindLong(100, kGMusic.getAuthorId());
            supportSQLiteStatement.bindLong(101, kGMusic.getSpecialId());
            supportSQLiteStatement.bindLong(102, kGMusic.getRankId());
            if (kGMusic.getTopic() == null) {
                supportSQLiteStatement.bindNull(103);
            } else {
                supportSQLiteStatement.bindString(103, kGMusic.getTopic());
            }
            if (kGMusic.getSongType() == null) {
                supportSQLiteStatement.bindNull(104);
            } else {
                supportSQLiteStatement.bindString(104, kGMusic.getSongType());
            }
            supportSQLiteStatement.bindLong(105, kGMusic.isFromLocalMusic() ? 1L : 0L);
            supportSQLiteStatement.bindLong(106, kGMusic.isUserPlay() ? 1L : 0L);
            supportSQLiteStatement.bindLong(107, kGMusic.getAudioType());
            supportSQLiteStatement.bindLong(108, kGMusic.getSort());
            supportSQLiteStatement.bindLong(109, kGMusic.getAudioIndex());
            supportSQLiteStatement.bindLong(110, kGMusic.getFlag());
            supportSQLiteStatement.bindLong(111, kGMusic.getUgcReviewed());
            supportSQLiteStatement.bindLong(112, kGMusic.getQualityFeeSource());
            supportSQLiteStatement.bindLong(113, kGMusic.isFromMyAsset() ? 1L : 0L);
            supportSQLiteStatement.bindLong(114, kGMusic.getFileEncryptType());
            supportSQLiteStatement.bindLong(115, kGMusic.isLocalEncryptUpgradeMP3() ? 1L : 0L);
            supportSQLiteStatement.bindLong(116, kGMusic.getMaskOfForceDownload());
            supportSQLiteStatement.bindLong(117, kGMusic.getGuessYouLikeMark());
            if (kGMusic.getGuessYouLikeBiString() == null) {
                supportSQLiteStatement.bindNull(118);
            } else {
                supportSQLiteStatement.bindString(118, kGMusic.getGuessYouLikeBiString());
            }
            if (kGMusic.getBrief() == null) {
                supportSQLiteStatement.bindNull(119);
            } else {
                supportSQLiteStatement.bindString(119, kGMusic.getBrief());
            }
            supportSQLiteStatement.bindLong(120, kGMusic.dbId);
        }

        @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "UPDATE OR ABORT `kugou_songs` SET `_id` = ?,`id` = ?,`playListId` = ?,`playListName` = ?,`playListCreateListId` = ?,`playListCreateUserId` = ?,`playListCloudListId` = ?,`playListType` = ?,`playListSource` = ?,`musiclibId` = ?,`playListCreateUserName` = ?,`mPlayListPicPath` = ?,`isReset` = ?,`musicSource` = ?,`globalCollectionId` = ?,`audition` = ?,`gif_id` = ?,`fileOrderWeight` = ?,`collectTime` = ?,`channelCommentId` = ?,`extParams` = ?,`sid` = ?,`cur_remark` = ?,`remark` = ?,`display_name` = ?,`trackName` = ?,`albumName` = ?,`album_id` = ?,`feeAlbumId` = ?,`mixId` = ?,`oldMixId` = ?,`audioId` = ?,`track_id` = ?,`artistName` = ?,`genre` = ?,`artist_id` = ?,`size` = ?,`hashValue` = ?,`musicpath` = ?,`bitrate` = ?,`duration` = ?,`m4aHash` = ?,`m4aSize` = ?,`m4aUrl` = ?,`hash320` = ?,`size320` = ?,`sqHash` = ?,`sqSize` = ?,`mvHashValue` = ?,`mvTracks` = ?,`mvType` = ?,`mvMatchTime` = ?,`accompanimentHash` = ?,`accompanimentTime` = ?,`accompanimentId` = ?,`has_accompany` = ?,`sourceHash` = ?,`fileId` = ?,`musicLinkSource` = ?,`mSpecialOrAlbumName` = ?,`musicLinkExtInfo` = ?,`hashType` = ?,`imgUrl` = ?,`sk` = ?,`isExclusivePublish` = ?,`extname` = ?,`feeType` = ?,`isnew` = ?,`fullName` = ?,`source` = ?,`sourceType` = ?,`srctype` = ?,`genreId` = ?,`albumMatchTime` = ?,`isInsertPlay` = ?,`charge` = ?,`behavior` = ?,`module` = ?,`songSource` = ?,`inList` = ?,`sourceMode` = ?,`musicFeeStatus` = ?,`musicFeeType` = ?,`failProcess` = ?,`payType` = ?,`updateFeeStatusTime` = ?,`localMusicFeeId` = ?,`oldCpy` = ?,`isFileDownloaded` = ?,`isMusicCloudFile` = ?,`mDownloadStatus` = ?,`isPlayMusicCloud` = ?,`tag` = ?,`publishYear` = ?,`publishYearMatchTime` = ?,`language` = ?,`languageMatchTime` = ?,`isUserSetLanguage` = ?,`isUserSetPublishYear` = ?,`authorId` = ?,`specialId` = ?,`rankId` = ?,`topic` = ?,`songType` = ?,`fromLocalMusic` = ?,`isUserPlay` = ?,`audioType` = ?,`sort` = ?,`audioIndex` = ?,`mFlag` = ?,`ugcReviewed` = ?,`qualityFeeSource` = ?,`isFromMyAsset` = ?,`fileEncryptType` = ?,`isLocalEncryptUpgradeMP3` = ?,`maskOfForceDownload` = ?,`guessYouLikeMark` = ?,`guessYouLikeBiString` = ?,`brief` = ? WHERE `_id` = ?";
        }
    }

    public class d extends SharedSQLiteStatement {
        public d(h hVar, RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "DELETE FROM kugou_songs WHERE mixId =?";
        }
    }

    public class e extends SharedSQLiteStatement {
        public e(h hVar, RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "DELETE FROM kugou_songs WHERE globalCollectionId =?";
        }
    }

    public h(RoomDatabase roomDatabase) {
        this.c = roomDatabase;
        this.f394d = new a(this, roomDatabase);
        new b(this, roomDatabase);
        this.f395e = new c(this, roomDatabase);
        new d(this, roomDatabase);
        this.f396f = new e(this, roomDatabase);
    }

    @Override // e.c.a.g.a.d.f.a
    public int b(SupportSQLiteQuery supportSQLiteQuery) {
        this.c.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.c, supportSQLiteQuery, false, null);
        try {
            return cursorQuery.moveToFirst() ? cursorQuery.getInt(0) : 0;
        } finally {
            cursorQuery.close();
        }
    }

    @Override // e.c.a.g.a.d.f.a
    public List<Long> e(List<? extends KGMusic> list) {
        this.c.assertNotSuspendingTransaction();
        this.c.beginTransaction();
        try {
            List<Long> listInsertAndReturnIdsList = this.f394d.insertAndReturnIdsList(list);
            this.c.setTransactionSuccessful();
            return listInsertAndReturnIdsList;
        } finally {
            this.c.endTransaction();
        }
    }

    @Override // e.c.a.g.a.d.f.c.a.g
    public void h(String str) {
        this.c.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.f396f.acquire();
        if (str == null) {
            supportSQLiteStatementAcquire.bindNull(1);
        } else {
            supportSQLiteStatementAcquire.bindString(1, str);
        }
        this.c.beginTransaction();
        try {
            supportSQLiteStatementAcquire.executeUpdateDelete();
            this.c.setTransactionSuccessful();
        } finally {
            this.c.endTransaction();
            this.f396f.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // e.c.a.g.a.d.f.c.a.g
    public Cursor i(List<String> list) {
        StringBuilder sbNewStringBuilder = StringUtil.newStringBuilder();
        sbNewStringBuilder.append("SELECT _id, hashValue FROM kugou_songs WHERE hashValue in (");
        int size = list.size();
        StringUtil.appendPlaceholders(sbNewStringBuilder, size);
        sbNewStringBuilder.append(")");
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire(sbNewStringBuilder.toString(), size + 0);
        int i2 = 1;
        for (String str : list) {
            if (str == null) {
                roomSQLiteQueryAcquire.bindNull(i2);
            } else {
                roomSQLiteQueryAcquire.bindString(i2, str);
            }
            i2++;
        }
        return this.c.query(roomSQLiteQueryAcquire);
    }

    @Override // e.c.a.g.a.d.f.c.a.g
    public Cursor j(List<String> list) {
        StringBuilder sbNewStringBuilder = StringUtil.newStringBuilder();
        sbNewStringBuilder.append("SELECT _id,hashValue FROM kugou_songs WHERE hashValue in (");
        int size = list.size();
        StringUtil.appendPlaceholders(sbNewStringBuilder, size);
        sbNewStringBuilder.append(") AND mixId <= 0 GROUP BY hashValue");
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire(sbNewStringBuilder.toString(), size + 0);
        int i2 = 1;
        for (String str : list) {
            if (str == null) {
                roomSQLiteQueryAcquire.bindNull(i2);
            } else {
                roomSQLiteQueryAcquire.bindString(i2, str);
            }
            i2++;
        }
        return this.c.query(roomSQLiteQueryAcquire);
    }

    @Override // e.c.a.g.a.d.f.c.a.g
    public Cursor k(List<Long> list) {
        StringBuilder sbNewStringBuilder = StringUtil.newStringBuilder();
        sbNewStringBuilder.append("SELECT _id FROM kugou_songs WHERE mixId in (");
        int size = list.size();
        StringUtil.appendPlaceholders(sbNewStringBuilder, size);
        sbNewStringBuilder.append(") GROUP BY mixId");
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire(sbNewStringBuilder.toString(), size + 0);
        int i2 = 1;
        for (Long l : list) {
            if (l == null) {
                roomSQLiteQueryAcquire.bindNull(i2);
            } else {
                roomSQLiteQueryAcquire.bindLong(i2, l.longValue());
            }
            i2++;
        }
        return this.c.query(roomSQLiteQueryAcquire);
    }

    @Override // e.c.a.g.a.d.f.c.a.g
    public Cursor l(List<Long> list) {
        StringBuilder sbNewStringBuilder = StringUtil.newStringBuilder();
        sbNewStringBuilder.append("SELECT _id,mixId FROM kugou_songs WHERE mixId in (");
        int size = list.size();
        StringUtil.appendPlaceholders(sbNewStringBuilder, size);
        sbNewStringBuilder.append(") GROUP BY mixId");
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire(sbNewStringBuilder.toString(), size + 0);
        int i2 = 1;
        for (Long l : list) {
            if (l == null) {
                roomSQLiteQueryAcquire.bindNull(i2);
            } else {
                roomSQLiteQueryAcquire.bindLong(i2, l.longValue());
            }
            i2++;
        }
        return this.c.query(roomSQLiteQueryAcquire);
    }

    @Override // e.c.a.g.a.d.f.c.a.g
    public KGMusic m(String str) throws Throwable {
        RoomSQLiteQuery roomSQLiteQuery;
        int columnIndexOrThrow;
        int columnIndexOrThrow2;
        int columnIndexOrThrow3;
        int columnIndexOrThrow4;
        int columnIndexOrThrow5;
        int columnIndexOrThrow6;
        int columnIndexOrThrow7;
        int columnIndexOrThrow8;
        int columnIndexOrThrow9;
        int columnIndexOrThrow10;
        int columnIndexOrThrow11;
        int columnIndexOrThrow12;
        int columnIndexOrThrow13;
        int columnIndexOrThrow14;
        KGMusic kGMusic;
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM kugou_songs WHERE hashValue =UPPER(?)", 1);
        if (str == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, str);
        }
        this.c.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.c, roomSQLiteQueryAcquire, false, null);
        try {
            columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, DbOpenHelper.ID);
            columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
            columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "playListId");
            columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "playListName");
            columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "playListCreateListId");
            columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "playListCreateUserId");
            columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "playListCloudListId");
            columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "playListType");
            columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "playListSource");
            columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "musiclibId");
            columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "playListCreateUserName");
            columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "mPlayListPicPath");
            columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "isReset");
            columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "musicSource");
            roomSQLiteQuery = roomSQLiteQueryAcquire;
        } catch (Throwable th) {
            th = th;
            roomSQLiteQuery = roomSQLiteQueryAcquire;
        }
        try {
            int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "globalCollectionId");
            int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "audition");
            int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "gif_id");
            int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "fileOrderWeight");
            int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "collectTime");
            int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "channelCommentId");
            int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "extParams");
            int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "sid");
            int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "cur_remark");
            int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "remark");
            int columnIndexOrThrow25 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "display_name");
            int columnIndexOrThrow26 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "trackName");
            int columnIndexOrThrow27 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "albumName");
            int columnIndexOrThrow28 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "album_id");
            int columnIndexOrThrow29 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "feeAlbumId");
            int columnIndexOrThrow30 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "mixId");
            int columnIndexOrThrow31 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "oldMixId");
            int columnIndexOrThrow32 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "audioId");
            int columnIndexOrThrow33 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "track_id");
            int columnIndexOrThrow34 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "artistName");
            int columnIndexOrThrow35 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "genre");
            int columnIndexOrThrow36 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "artist_id");
            int columnIndexOrThrow37 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "size");
            int columnIndexOrThrow38 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "hashValue");
            int columnIndexOrThrow39 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "musicpath");
            int columnIndexOrThrow40 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "bitrate");
            int columnIndexOrThrow41 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "duration");
            int columnIndexOrThrow42 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "m4aHash");
            int columnIndexOrThrow43 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "m4aSize");
            int columnIndexOrThrow44 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "m4aUrl");
            int columnIndexOrThrow45 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "hash320");
            int columnIndexOrThrow46 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "size320");
            int columnIndexOrThrow47 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "sqHash");
            int columnIndexOrThrow48 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "sqSize");
            int columnIndexOrThrow49 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "mvHashValue");
            int columnIndexOrThrow50 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "mvTracks");
            int columnIndexOrThrow51 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "mvType");
            int columnIndexOrThrow52 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "mvMatchTime");
            int columnIndexOrThrow53 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "accompanimentHash");
            int columnIndexOrThrow54 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "accompanimentTime");
            int columnIndexOrThrow55 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "accompanimentId");
            int columnIndexOrThrow56 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "has_accompany");
            int columnIndexOrThrow57 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "sourceHash");
            int columnIndexOrThrow58 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "fileId");
            int columnIndexOrThrow59 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "musicLinkSource");
            int columnIndexOrThrow60 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "mSpecialOrAlbumName");
            int columnIndexOrThrow61 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "musicLinkExtInfo");
            int columnIndexOrThrow62 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "hashType");
            int columnIndexOrThrow63 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "imgUrl");
            int columnIndexOrThrow64 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "sk");
            int columnIndexOrThrow65 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "isExclusivePublish");
            int columnIndexOrThrow66 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "extname");
            int columnIndexOrThrow67 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "feeType");
            int columnIndexOrThrow68 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "isnew");
            int columnIndexOrThrow69 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "fullName");
            int columnIndexOrThrow70 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "source");
            int columnIndexOrThrow71 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "sourceType");
            int columnIndexOrThrow72 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "srctype");
            int columnIndexOrThrow73 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "genreId");
            int columnIndexOrThrow74 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "albumMatchTime");
            int columnIndexOrThrow75 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "isInsertPlay");
            int columnIndexOrThrow76 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "charge");
            int columnIndexOrThrow77 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "behavior");
            int columnIndexOrThrow78 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "module");
            int columnIndexOrThrow79 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "songSource");
            int columnIndexOrThrow80 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "inList");
            int columnIndexOrThrow81 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "sourceMode");
            int columnIndexOrThrow82 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "musicFeeStatus");
            int columnIndexOrThrow83 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "musicFeeType");
            int columnIndexOrThrow84 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "failProcess");
            int columnIndexOrThrow85 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "payType");
            int columnIndexOrThrow86 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "updateFeeStatusTime");
            int columnIndexOrThrow87 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "localMusicFeeId");
            int columnIndexOrThrow88 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "oldCpy");
            int columnIndexOrThrow89 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "isFileDownloaded");
            int columnIndexOrThrow90 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "isMusicCloudFile");
            int columnIndexOrThrow91 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "mDownloadStatus");
            int columnIndexOrThrow92 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "isPlayMusicCloud");
            int columnIndexOrThrow93 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "tag");
            int columnIndexOrThrow94 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "publishYear");
            int columnIndexOrThrow95 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "publishYearMatchTime");
            int columnIndexOrThrow96 = CursorUtil.getColumnIndexOrThrow(cursorQuery, KrcLoader.TAG_LANGUAGE);
            int columnIndexOrThrow97 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "languageMatchTime");
            int columnIndexOrThrow98 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "isUserSetLanguage");
            int columnIndexOrThrow99 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "isUserSetPublishYear");
            int columnIndexOrThrow100 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "authorId");
            int columnIndexOrThrow101 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "specialId");
            int columnIndexOrThrow102 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "rankId");
            int columnIndexOrThrow103 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "topic");
            int columnIndexOrThrow104 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "songType");
            int columnIndexOrThrow105 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "fromLocalMusic");
            int columnIndexOrThrow106 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "isUserPlay");
            int columnIndexOrThrow107 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "audioType");
            int columnIndexOrThrow108 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "sort");
            int columnIndexOrThrow109 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "audioIndex");
            int columnIndexOrThrow110 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "mFlag");
            int columnIndexOrThrow111 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "ugcReviewed");
            int columnIndexOrThrow112 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "qualityFeeSource");
            int columnIndexOrThrow113 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "isFromMyAsset");
            int columnIndexOrThrow114 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "fileEncryptType");
            int columnIndexOrThrow115 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "isLocalEncryptUpgradeMP3");
            int columnIndexOrThrow116 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "maskOfForceDownload");
            int columnIndexOrThrow117 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "guessYouLikeMark");
            int columnIndexOrThrow118 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "guessYouLikeBiString");
            int columnIndexOrThrow119 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "brief");
            if (cursorQuery.moveToFirst()) {
                KGMusic kGMusic2 = new KGMusic();
                kGMusic2.dbId = cursorQuery.getLong(columnIndexOrThrow);
                kGMusic2.id = cursorQuery.getLong(columnIndexOrThrow2);
                kGMusic2.playListId = cursorQuery.getInt(columnIndexOrThrow3);
                kGMusic2.playListName = cursorQuery.getString(columnIndexOrThrow4);
                kGMusic2.playListCreateListId = cursorQuery.getInt(columnIndexOrThrow5);
                kGMusic2.playListCreateUserId = cursorQuery.getLong(columnIndexOrThrow6);
                kGMusic2.playListCloudListId = cursorQuery.getInt(columnIndexOrThrow7);
                kGMusic2.playListType = cursorQuery.getInt(columnIndexOrThrow8);
                kGMusic2.playListSource = cursorQuery.getInt(columnIndexOrThrow9);
                kGMusic2.musiclibId = cursorQuery.getInt(columnIndexOrThrow10);
                kGMusic2.playListCreateUserName = cursorQuery.getString(columnIndexOrThrow11);
                kGMusic2.mPlayListPicPath = cursorQuery.getString(columnIndexOrThrow12);
                kGMusic2.isReset = cursorQuery.getInt(columnIndexOrThrow13) != 0;
                kGMusic2.musicSource = cursorQuery.getInt(columnIndexOrThrow14);
                kGMusic2.setGlobalCollectionId(cursorQuery.getString(columnIndexOrThrow15));
                kGMusic2.setAudition(cursorQuery.getInt(columnIndexOrThrow16));
                kGMusic2.setGif_id(cursorQuery.getInt(columnIndexOrThrow17));
                kGMusic2.fileOrderWeight = cursorQuery.getInt(columnIndexOrThrow18);
                kGMusic2.collectTime = cursorQuery.getLong(columnIndexOrThrow19);
                kGMusic2.channelCommentId = cursorQuery.getString(columnIndexOrThrow20);
                kGMusic2.extParams = cursorQuery.getString(columnIndexOrThrow21);
                kGMusic2.sid = cursorQuery.getLong(columnIndexOrThrow22);
                kGMusic2.curMark = cursorQuery.getString(columnIndexOrThrow23);
                kGMusic2.remark = cursorQuery.getString(columnIndexOrThrow24);
                kGMusic2.displayName = cursorQuery.getString(columnIndexOrThrow25);
                kGMusic2.trackName = cursorQuery.getString(columnIndexOrThrow26);
                kGMusic2.albumName = cursorQuery.getString(columnIndexOrThrow27);
                kGMusic2.albumID = cursorQuery.getLong(columnIndexOrThrow28);
                kGMusic2.feeAlbumId = cursorQuery.getString(columnIndexOrThrow29);
                kGMusic2.mixId = cursorQuery.getLong(columnIndexOrThrow30);
                kGMusic2.oldMixId = cursorQuery.getLong(columnIndexOrThrow31);
                kGMusic2.audioId = cursorQuery.getLong(columnIndexOrThrow32);
                kGMusic2.trackID = cursorQuery.getLong(columnIndexOrThrow33);
                kGMusic2.artistName = cursorQuery.getString(columnIndexOrThrow34);
                kGMusic2.genre = cursorQuery.getString(columnIndexOrThrow35);
                kGMusic2.artistID = cursorQuery.getLong(columnIndexOrThrow36);
                kGMusic2.size = cursorQuery.getLong(columnIndexOrThrow37);
                kGMusic2.hashValue = cursorQuery.getString(columnIndexOrThrow38);
                kGMusic2.musicpath = cursorQuery.getString(columnIndexOrThrow39);
                kGMusic2.bitrate = cursorQuery.getInt(columnIndexOrThrow40);
                kGMusic2.duration = cursorQuery.getLong(columnIndexOrThrow41);
                kGMusic2.m4aHash = cursorQuery.getString(columnIndexOrThrow42);
                kGMusic2.m4aSize = cursorQuery.getLong(columnIndexOrThrow43);
                kGMusic2.m4aUrl = cursorQuery.getString(columnIndexOrThrow44);
                kGMusic2.hash320 = cursorQuery.getString(columnIndexOrThrow45);
                kGMusic2.size320 = cursorQuery.getLong(columnIndexOrThrow46);
                kGMusic2.sqHash = cursorQuery.getString(columnIndexOrThrow47);
                kGMusic2.sqSize = cursorQuery.getLong(columnIndexOrThrow48);
                kGMusic2.mvHashValue = cursorQuery.getString(columnIndexOrThrow49);
                kGMusic2.mvTracks = cursorQuery.getInt(columnIndexOrThrow50);
                kGMusic2.mvType = cursorQuery.getInt(columnIndexOrThrow51);
                kGMusic2.mvMatchTime = cursorQuery.getLong(columnIndexOrThrow52);
                kGMusic2.accompanimentHash = cursorQuery.getString(columnIndexOrThrow53);
                kGMusic2.accompanimentTime = cursorQuery.getLong(columnIndexOrThrow54);
                kGMusic2.accompanimentId = cursorQuery.getInt(columnIndexOrThrow55);
                kGMusic2.has_accompany = cursorQuery.getInt(columnIndexOrThrow56);
                kGMusic2.sourceHash = cursorQuery.getString(columnIndexOrThrow57);
                kGMusic2.fileId = cursorQuery.getLong(columnIndexOrThrow58);
                kGMusic2.musicLinkSource = cursorQuery.getInt(columnIndexOrThrow59);
                kGMusic2.mSpecialOrAlbumName = cursorQuery.getString(columnIndexOrThrow60);
                kGMusic2.musicLinkExtInfo = cursorQuery.getString(columnIndexOrThrow61);
                kGMusic2.hashType = cursorQuery.getInt(columnIndexOrThrow62);
                kGMusic2.imgUrl = cursorQuery.getString(columnIndexOrThrow63);
                kGMusic2.sk = cursorQuery.getString(columnIndexOrThrow64);
                kGMusic2.isExclusivePublish = cursorQuery.getInt(columnIndexOrThrow65) != 0;
                kGMusic2.extname = cursorQuery.getString(columnIndexOrThrow66);
                kGMusic2.feeType = cursorQuery.getInt(columnIndexOrThrow67);
                kGMusic2.isnew = cursorQuery.getInt(columnIndexOrThrow68);
                kGMusic2.fullName = cursorQuery.getString(columnIndexOrThrow69);
                kGMusic2.source = cursorQuery.getString(columnIndexOrThrow70);
                kGMusic2.sourceType = cursorQuery.getString(columnIndexOrThrow71);
                kGMusic2.srctype = cursorQuery.getInt(columnIndexOrThrow72);
                kGMusic2.genreId = cursorQuery.getInt(columnIndexOrThrow73);
                kGMusic2.albumMatchTime = cursorQuery.getLong(columnIndexOrThrow74);
                kGMusic2.isInsertPlay = cursorQuery.getInt(columnIndexOrThrow75);
                kGMusic2.charge = cursorQuery.getInt(columnIndexOrThrow76);
                kGMusic2.behavior = cursorQuery.getString(columnIndexOrThrow77);
                kGMusic2.module = cursorQuery.getString(columnIndexOrThrow78);
                kGMusic2.songSource = cursorQuery.getInt(columnIndexOrThrow79);
                kGMusic2.inList = cursorQuery.getInt(columnIndexOrThrow80);
                kGMusic2.sourceMode = cursorQuery.getInt(columnIndexOrThrow81);
                kGMusic2.musicFeeStatus = cursorQuery.getInt(columnIndexOrThrow82);
                kGMusic2.musicFeeType = cursorQuery.getString(columnIndexOrThrow83);
                kGMusic2.failProcess = cursorQuery.getInt(columnIndexOrThrow84);
                kGMusic2.payType = cursorQuery.getInt(columnIndexOrThrow85);
                kGMusic2.updateFeeStatusTime = cursorQuery.getLong(columnIndexOrThrow86);
                kGMusic2.localMusicFeeId = cursorQuery.getLong(columnIndexOrThrow87);
                kGMusic2.oldCpy = cursorQuery.getInt(columnIndexOrThrow88);
                kGMusic2.isFileDownloaded = cursorQuery.getInt(columnIndexOrThrow89) != 0;
                kGMusic2.isMusicCloudFile = cursorQuery.getInt(columnIndexOrThrow90) != 0;
                kGMusic2.mDownloadStatus = cursorQuery.getInt(columnIndexOrThrow91);
                kGMusic2.isPlayMusicCloud = cursorQuery.getInt(columnIndexOrThrow92) != 0;
                kGMusic2.tag = cursorQuery.getInt(columnIndexOrThrow93);
                kGMusic2.publishYear = cursorQuery.getString(columnIndexOrThrow94);
                kGMusic2.publishYearMatchTime = cursorQuery.getLong(columnIndexOrThrow95);
                kGMusic2.language = cursorQuery.getString(columnIndexOrThrow96);
                kGMusic2.languageMatchTime = cursorQuery.getLong(columnIndexOrThrow97);
                kGMusic2.isUserSetLanguage = cursorQuery.getInt(columnIndexOrThrow98) != 0;
                kGMusic2.isUserSetPublishYear = cursorQuery.getInt(columnIndexOrThrow99) != 0;
                kGMusic2.setAuthorId(cursorQuery.getInt(columnIndexOrThrow100));
                kGMusic2.setSpecialId(cursorQuery.getInt(columnIndexOrThrow101));
                kGMusic2.setRankId(cursorQuery.getInt(columnIndexOrThrow102));
                kGMusic2.setTopic(cursorQuery.getString(columnIndexOrThrow103));
                kGMusic2.setSongType(cursorQuery.getString(columnIndexOrThrow104));
                kGMusic2.setFromLocalMusic(cursorQuery.getInt(columnIndexOrThrow105) != 0);
                kGMusic2.setUserPlay(cursorQuery.getInt(columnIndexOrThrow106) != 0);
                kGMusic2.setAudioType(cursorQuery.getInt(columnIndexOrThrow107));
                kGMusic2.setSort(cursorQuery.getInt(columnIndexOrThrow108));
                kGMusic2.setAudioIndex(cursorQuery.getInt(columnIndexOrThrow109));
                kGMusic2.setFlag(cursorQuery.getInt(columnIndexOrThrow110));
                kGMusic2.setUgcReviewed(cursorQuery.getInt(columnIndexOrThrow111));
                kGMusic2.setQualityFeeSource(cursorQuery.getInt(columnIndexOrThrow112));
                kGMusic2.setFromMyAsset(cursorQuery.getInt(columnIndexOrThrow113) != 0);
                kGMusic2.setFileEncryptType(cursorQuery.getInt(columnIndexOrThrow114));
                kGMusic2.setIsLocalEncryptUpgradeMP3(cursorQuery.getInt(columnIndexOrThrow115) != 0);
                kGMusic2.setMaskOfForceDownload(cursorQuery.getInt(columnIndexOrThrow116));
                kGMusic2.setGuessYouLikeMark(cursorQuery.getInt(columnIndexOrThrow117));
                kGMusic2.setGuessYouLikeBiString(cursorQuery.getString(columnIndexOrThrow118));
                kGMusic2.setBrief(cursorQuery.getString(columnIndexOrThrow119));
                kGMusic = kGMusic2;
            } else {
                kGMusic = null;
            }
            cursorQuery.close();
            roomSQLiteQuery.release();
            return kGMusic;
        } catch (Throwable th2) {
            th = th2;
            cursorQuery.close();
            roomSQLiteQuery.release();
            throw th;
        }
    }

    @Override // e.c.a.g.a.d.f.c.a.g
    public KGMusic n(long j, String str) throws Throwable {
        RoomSQLiteQuery roomSQLiteQuery;
        int columnIndexOrThrow;
        int columnIndexOrThrow2;
        int columnIndexOrThrow3;
        int columnIndexOrThrow4;
        int columnIndexOrThrow5;
        int columnIndexOrThrow6;
        int columnIndexOrThrow7;
        int columnIndexOrThrow8;
        int columnIndexOrThrow9;
        int columnIndexOrThrow10;
        int columnIndexOrThrow11;
        int columnIndexOrThrow12;
        int columnIndexOrThrow13;
        int columnIndexOrThrow14;
        KGMusic kGMusic;
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM kugou_songs WHERE hashValue = UPPER(?) AND mixId =?", 2);
        if (str == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, str);
        }
        roomSQLiteQueryAcquire.bindLong(2, j);
        this.c.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.c, roomSQLiteQueryAcquire, false, null);
        try {
            columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, DbOpenHelper.ID);
            columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
            columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "playListId");
            columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "playListName");
            columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "playListCreateListId");
            columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "playListCreateUserId");
            columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "playListCloudListId");
            columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "playListType");
            columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "playListSource");
            columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "musiclibId");
            columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "playListCreateUserName");
            columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "mPlayListPicPath");
            columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "isReset");
            columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "musicSource");
            roomSQLiteQuery = roomSQLiteQueryAcquire;
        } catch (Throwable th) {
            th = th;
            roomSQLiteQuery = roomSQLiteQueryAcquire;
        }
        try {
            int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "globalCollectionId");
            int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "audition");
            int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "gif_id");
            int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "fileOrderWeight");
            int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "collectTime");
            int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "channelCommentId");
            int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "extParams");
            int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "sid");
            int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "cur_remark");
            int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "remark");
            int columnIndexOrThrow25 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "display_name");
            int columnIndexOrThrow26 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "trackName");
            int columnIndexOrThrow27 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "albumName");
            int columnIndexOrThrow28 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "album_id");
            int columnIndexOrThrow29 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "feeAlbumId");
            int columnIndexOrThrow30 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "mixId");
            int columnIndexOrThrow31 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "oldMixId");
            int columnIndexOrThrow32 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "audioId");
            int columnIndexOrThrow33 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "track_id");
            int columnIndexOrThrow34 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "artistName");
            int columnIndexOrThrow35 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "genre");
            int columnIndexOrThrow36 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "artist_id");
            int columnIndexOrThrow37 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "size");
            int columnIndexOrThrow38 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "hashValue");
            int columnIndexOrThrow39 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "musicpath");
            int columnIndexOrThrow40 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "bitrate");
            int columnIndexOrThrow41 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "duration");
            int columnIndexOrThrow42 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "m4aHash");
            int columnIndexOrThrow43 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "m4aSize");
            int columnIndexOrThrow44 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "m4aUrl");
            int columnIndexOrThrow45 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "hash320");
            int columnIndexOrThrow46 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "size320");
            int columnIndexOrThrow47 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "sqHash");
            int columnIndexOrThrow48 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "sqSize");
            int columnIndexOrThrow49 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "mvHashValue");
            int columnIndexOrThrow50 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "mvTracks");
            int columnIndexOrThrow51 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "mvType");
            int columnIndexOrThrow52 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "mvMatchTime");
            int columnIndexOrThrow53 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "accompanimentHash");
            int columnIndexOrThrow54 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "accompanimentTime");
            int columnIndexOrThrow55 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "accompanimentId");
            int columnIndexOrThrow56 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "has_accompany");
            int columnIndexOrThrow57 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "sourceHash");
            int columnIndexOrThrow58 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "fileId");
            int columnIndexOrThrow59 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "musicLinkSource");
            int columnIndexOrThrow60 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "mSpecialOrAlbumName");
            int columnIndexOrThrow61 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "musicLinkExtInfo");
            int columnIndexOrThrow62 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "hashType");
            int columnIndexOrThrow63 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "imgUrl");
            int columnIndexOrThrow64 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "sk");
            int columnIndexOrThrow65 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "isExclusivePublish");
            int columnIndexOrThrow66 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "extname");
            int columnIndexOrThrow67 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "feeType");
            int columnIndexOrThrow68 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "isnew");
            int columnIndexOrThrow69 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "fullName");
            int columnIndexOrThrow70 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "source");
            int columnIndexOrThrow71 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "sourceType");
            int columnIndexOrThrow72 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "srctype");
            int columnIndexOrThrow73 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "genreId");
            int columnIndexOrThrow74 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "albumMatchTime");
            int columnIndexOrThrow75 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "isInsertPlay");
            int columnIndexOrThrow76 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "charge");
            int columnIndexOrThrow77 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "behavior");
            int columnIndexOrThrow78 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "module");
            int columnIndexOrThrow79 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "songSource");
            int columnIndexOrThrow80 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "inList");
            int columnIndexOrThrow81 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "sourceMode");
            int columnIndexOrThrow82 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "musicFeeStatus");
            int columnIndexOrThrow83 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "musicFeeType");
            int columnIndexOrThrow84 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "failProcess");
            int columnIndexOrThrow85 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "payType");
            int columnIndexOrThrow86 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "updateFeeStatusTime");
            int columnIndexOrThrow87 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "localMusicFeeId");
            int columnIndexOrThrow88 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "oldCpy");
            int columnIndexOrThrow89 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "isFileDownloaded");
            int columnIndexOrThrow90 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "isMusicCloudFile");
            int columnIndexOrThrow91 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "mDownloadStatus");
            int columnIndexOrThrow92 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "isPlayMusicCloud");
            int columnIndexOrThrow93 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "tag");
            int columnIndexOrThrow94 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "publishYear");
            int columnIndexOrThrow95 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "publishYearMatchTime");
            int columnIndexOrThrow96 = CursorUtil.getColumnIndexOrThrow(cursorQuery, KrcLoader.TAG_LANGUAGE);
            int columnIndexOrThrow97 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "languageMatchTime");
            int columnIndexOrThrow98 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "isUserSetLanguage");
            int columnIndexOrThrow99 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "isUserSetPublishYear");
            int columnIndexOrThrow100 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "authorId");
            int columnIndexOrThrow101 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "specialId");
            int columnIndexOrThrow102 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "rankId");
            int columnIndexOrThrow103 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "topic");
            int columnIndexOrThrow104 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "songType");
            int columnIndexOrThrow105 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "fromLocalMusic");
            int columnIndexOrThrow106 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "isUserPlay");
            int columnIndexOrThrow107 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "audioType");
            int columnIndexOrThrow108 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "sort");
            int columnIndexOrThrow109 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "audioIndex");
            int columnIndexOrThrow110 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "mFlag");
            int columnIndexOrThrow111 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "ugcReviewed");
            int columnIndexOrThrow112 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "qualityFeeSource");
            int columnIndexOrThrow113 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "isFromMyAsset");
            int columnIndexOrThrow114 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "fileEncryptType");
            int columnIndexOrThrow115 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "isLocalEncryptUpgradeMP3");
            int columnIndexOrThrow116 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "maskOfForceDownload");
            int columnIndexOrThrow117 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "guessYouLikeMark");
            int columnIndexOrThrow118 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "guessYouLikeBiString");
            int columnIndexOrThrow119 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "brief");
            if (cursorQuery.moveToFirst()) {
                KGMusic kGMusic2 = new KGMusic();
                kGMusic2.dbId = cursorQuery.getLong(columnIndexOrThrow);
                kGMusic2.id = cursorQuery.getLong(columnIndexOrThrow2);
                kGMusic2.playListId = cursorQuery.getInt(columnIndexOrThrow3);
                kGMusic2.playListName = cursorQuery.getString(columnIndexOrThrow4);
                kGMusic2.playListCreateListId = cursorQuery.getInt(columnIndexOrThrow5);
                kGMusic2.playListCreateUserId = cursorQuery.getLong(columnIndexOrThrow6);
                kGMusic2.playListCloudListId = cursorQuery.getInt(columnIndexOrThrow7);
                kGMusic2.playListType = cursorQuery.getInt(columnIndexOrThrow8);
                kGMusic2.playListSource = cursorQuery.getInt(columnIndexOrThrow9);
                kGMusic2.musiclibId = cursorQuery.getInt(columnIndexOrThrow10);
                kGMusic2.playListCreateUserName = cursorQuery.getString(columnIndexOrThrow11);
                kGMusic2.mPlayListPicPath = cursorQuery.getString(columnIndexOrThrow12);
                kGMusic2.isReset = cursorQuery.getInt(columnIndexOrThrow13) != 0;
                kGMusic2.musicSource = cursorQuery.getInt(columnIndexOrThrow14);
                kGMusic2.setGlobalCollectionId(cursorQuery.getString(columnIndexOrThrow15));
                kGMusic2.setAudition(cursorQuery.getInt(columnIndexOrThrow16));
                kGMusic2.setGif_id(cursorQuery.getInt(columnIndexOrThrow17));
                kGMusic2.fileOrderWeight = cursorQuery.getInt(columnIndexOrThrow18);
                kGMusic2.collectTime = cursorQuery.getLong(columnIndexOrThrow19);
                kGMusic2.channelCommentId = cursorQuery.getString(columnIndexOrThrow20);
                kGMusic2.extParams = cursorQuery.getString(columnIndexOrThrow21);
                kGMusic2.sid = cursorQuery.getLong(columnIndexOrThrow22);
                kGMusic2.curMark = cursorQuery.getString(columnIndexOrThrow23);
                kGMusic2.remark = cursorQuery.getString(columnIndexOrThrow24);
                kGMusic2.displayName = cursorQuery.getString(columnIndexOrThrow25);
                kGMusic2.trackName = cursorQuery.getString(columnIndexOrThrow26);
                kGMusic2.albumName = cursorQuery.getString(columnIndexOrThrow27);
                kGMusic2.albumID = cursorQuery.getLong(columnIndexOrThrow28);
                kGMusic2.feeAlbumId = cursorQuery.getString(columnIndexOrThrow29);
                kGMusic2.mixId = cursorQuery.getLong(columnIndexOrThrow30);
                kGMusic2.oldMixId = cursorQuery.getLong(columnIndexOrThrow31);
                kGMusic2.audioId = cursorQuery.getLong(columnIndexOrThrow32);
                kGMusic2.trackID = cursorQuery.getLong(columnIndexOrThrow33);
                kGMusic2.artistName = cursorQuery.getString(columnIndexOrThrow34);
                kGMusic2.genre = cursorQuery.getString(columnIndexOrThrow35);
                kGMusic2.artistID = cursorQuery.getLong(columnIndexOrThrow36);
                kGMusic2.size = cursorQuery.getLong(columnIndexOrThrow37);
                kGMusic2.hashValue = cursorQuery.getString(columnIndexOrThrow38);
                kGMusic2.musicpath = cursorQuery.getString(columnIndexOrThrow39);
                kGMusic2.bitrate = cursorQuery.getInt(columnIndexOrThrow40);
                kGMusic2.duration = cursorQuery.getLong(columnIndexOrThrow41);
                kGMusic2.m4aHash = cursorQuery.getString(columnIndexOrThrow42);
                kGMusic2.m4aSize = cursorQuery.getLong(columnIndexOrThrow43);
                kGMusic2.m4aUrl = cursorQuery.getString(columnIndexOrThrow44);
                kGMusic2.hash320 = cursorQuery.getString(columnIndexOrThrow45);
                kGMusic2.size320 = cursorQuery.getLong(columnIndexOrThrow46);
                kGMusic2.sqHash = cursorQuery.getString(columnIndexOrThrow47);
                kGMusic2.sqSize = cursorQuery.getLong(columnIndexOrThrow48);
                kGMusic2.mvHashValue = cursorQuery.getString(columnIndexOrThrow49);
                kGMusic2.mvTracks = cursorQuery.getInt(columnIndexOrThrow50);
                kGMusic2.mvType = cursorQuery.getInt(columnIndexOrThrow51);
                kGMusic2.mvMatchTime = cursorQuery.getLong(columnIndexOrThrow52);
                kGMusic2.accompanimentHash = cursorQuery.getString(columnIndexOrThrow53);
                kGMusic2.accompanimentTime = cursorQuery.getLong(columnIndexOrThrow54);
                kGMusic2.accompanimentId = cursorQuery.getInt(columnIndexOrThrow55);
                kGMusic2.has_accompany = cursorQuery.getInt(columnIndexOrThrow56);
                kGMusic2.sourceHash = cursorQuery.getString(columnIndexOrThrow57);
                kGMusic2.fileId = cursorQuery.getLong(columnIndexOrThrow58);
                kGMusic2.musicLinkSource = cursorQuery.getInt(columnIndexOrThrow59);
                kGMusic2.mSpecialOrAlbumName = cursorQuery.getString(columnIndexOrThrow60);
                kGMusic2.musicLinkExtInfo = cursorQuery.getString(columnIndexOrThrow61);
                kGMusic2.hashType = cursorQuery.getInt(columnIndexOrThrow62);
                kGMusic2.imgUrl = cursorQuery.getString(columnIndexOrThrow63);
                kGMusic2.sk = cursorQuery.getString(columnIndexOrThrow64);
                kGMusic2.isExclusivePublish = cursorQuery.getInt(columnIndexOrThrow65) != 0;
                kGMusic2.extname = cursorQuery.getString(columnIndexOrThrow66);
                kGMusic2.feeType = cursorQuery.getInt(columnIndexOrThrow67);
                kGMusic2.isnew = cursorQuery.getInt(columnIndexOrThrow68);
                kGMusic2.fullName = cursorQuery.getString(columnIndexOrThrow69);
                kGMusic2.source = cursorQuery.getString(columnIndexOrThrow70);
                kGMusic2.sourceType = cursorQuery.getString(columnIndexOrThrow71);
                kGMusic2.srctype = cursorQuery.getInt(columnIndexOrThrow72);
                kGMusic2.genreId = cursorQuery.getInt(columnIndexOrThrow73);
                kGMusic2.albumMatchTime = cursorQuery.getLong(columnIndexOrThrow74);
                kGMusic2.isInsertPlay = cursorQuery.getInt(columnIndexOrThrow75);
                kGMusic2.charge = cursorQuery.getInt(columnIndexOrThrow76);
                kGMusic2.behavior = cursorQuery.getString(columnIndexOrThrow77);
                kGMusic2.module = cursorQuery.getString(columnIndexOrThrow78);
                kGMusic2.songSource = cursorQuery.getInt(columnIndexOrThrow79);
                kGMusic2.inList = cursorQuery.getInt(columnIndexOrThrow80);
                kGMusic2.sourceMode = cursorQuery.getInt(columnIndexOrThrow81);
                kGMusic2.musicFeeStatus = cursorQuery.getInt(columnIndexOrThrow82);
                kGMusic2.musicFeeType = cursorQuery.getString(columnIndexOrThrow83);
                kGMusic2.failProcess = cursorQuery.getInt(columnIndexOrThrow84);
                kGMusic2.payType = cursorQuery.getInt(columnIndexOrThrow85);
                kGMusic2.updateFeeStatusTime = cursorQuery.getLong(columnIndexOrThrow86);
                kGMusic2.localMusicFeeId = cursorQuery.getLong(columnIndexOrThrow87);
                kGMusic2.oldCpy = cursorQuery.getInt(columnIndexOrThrow88);
                kGMusic2.isFileDownloaded = cursorQuery.getInt(columnIndexOrThrow89) != 0;
                kGMusic2.isMusicCloudFile = cursorQuery.getInt(columnIndexOrThrow90) != 0;
                kGMusic2.mDownloadStatus = cursorQuery.getInt(columnIndexOrThrow91);
                kGMusic2.isPlayMusicCloud = cursorQuery.getInt(columnIndexOrThrow92) != 0;
                kGMusic2.tag = cursorQuery.getInt(columnIndexOrThrow93);
                kGMusic2.publishYear = cursorQuery.getString(columnIndexOrThrow94);
                kGMusic2.publishYearMatchTime = cursorQuery.getLong(columnIndexOrThrow95);
                kGMusic2.language = cursorQuery.getString(columnIndexOrThrow96);
                kGMusic2.languageMatchTime = cursorQuery.getLong(columnIndexOrThrow97);
                kGMusic2.isUserSetLanguage = cursorQuery.getInt(columnIndexOrThrow98) != 0;
                kGMusic2.isUserSetPublishYear = cursorQuery.getInt(columnIndexOrThrow99) != 0;
                kGMusic2.setAuthorId(cursorQuery.getInt(columnIndexOrThrow100));
                kGMusic2.setSpecialId(cursorQuery.getInt(columnIndexOrThrow101));
                kGMusic2.setRankId(cursorQuery.getInt(columnIndexOrThrow102));
                kGMusic2.setTopic(cursorQuery.getString(columnIndexOrThrow103));
                kGMusic2.setSongType(cursorQuery.getString(columnIndexOrThrow104));
                kGMusic2.setFromLocalMusic(cursorQuery.getInt(columnIndexOrThrow105) != 0);
                kGMusic2.setUserPlay(cursorQuery.getInt(columnIndexOrThrow106) != 0);
                kGMusic2.setAudioType(cursorQuery.getInt(columnIndexOrThrow107));
                kGMusic2.setSort(cursorQuery.getInt(columnIndexOrThrow108));
                kGMusic2.setAudioIndex(cursorQuery.getInt(columnIndexOrThrow109));
                kGMusic2.setFlag(cursorQuery.getInt(columnIndexOrThrow110));
                kGMusic2.setUgcReviewed(cursorQuery.getInt(columnIndexOrThrow111));
                kGMusic2.setQualityFeeSource(cursorQuery.getInt(columnIndexOrThrow112));
                kGMusic2.setFromMyAsset(cursorQuery.getInt(columnIndexOrThrow113) != 0);
                kGMusic2.setFileEncryptType(cursorQuery.getInt(columnIndexOrThrow114));
                kGMusic2.setIsLocalEncryptUpgradeMP3(cursorQuery.getInt(columnIndexOrThrow115) != 0);
                kGMusic2.setMaskOfForceDownload(cursorQuery.getInt(columnIndexOrThrow116));
                kGMusic2.setGuessYouLikeMark(cursorQuery.getInt(columnIndexOrThrow117));
                kGMusic2.setGuessYouLikeBiString(cursorQuery.getString(columnIndexOrThrow118));
                kGMusic2.setBrief(cursorQuery.getString(columnIndexOrThrow119));
                kGMusic = kGMusic2;
            } else {
                kGMusic = null;
            }
            cursorQuery.close();
            roomSQLiteQuery.release();
            return kGMusic;
        } catch (Throwable th2) {
            th = th2;
            cursorQuery.close();
            roomSQLiteQuery.release();
            throw th;
        }
    }

    @Override // e.c.a.g.a.d.f.c.a.g
    public KGMusic o(long j) throws Throwable {
        RoomSQLiteQuery roomSQLiteQuery;
        int columnIndexOrThrow;
        int columnIndexOrThrow2;
        int columnIndexOrThrow3;
        int columnIndexOrThrow4;
        int columnIndexOrThrow5;
        int columnIndexOrThrow6;
        int columnIndexOrThrow7;
        int columnIndexOrThrow8;
        int columnIndexOrThrow9;
        int columnIndexOrThrow10;
        int columnIndexOrThrow11;
        int columnIndexOrThrow12;
        int columnIndexOrThrow13;
        int columnIndexOrThrow14;
        KGMusic kGMusic;
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM kugou_songs WHERE mixId =?", 1);
        roomSQLiteQueryAcquire.bindLong(1, j);
        this.c.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.c, roomSQLiteQueryAcquire, false, null);
        try {
            columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, DbOpenHelper.ID);
            columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
            columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "playListId");
            columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "playListName");
            columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "playListCreateListId");
            columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "playListCreateUserId");
            columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "playListCloudListId");
            columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "playListType");
            columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "playListSource");
            columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "musiclibId");
            columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "playListCreateUserName");
            columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "mPlayListPicPath");
            columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "isReset");
            columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "musicSource");
            roomSQLiteQuery = roomSQLiteQueryAcquire;
        } catch (Throwable th) {
            th = th;
            roomSQLiteQuery = roomSQLiteQueryAcquire;
        }
        try {
            int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "globalCollectionId");
            int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "audition");
            int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "gif_id");
            int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "fileOrderWeight");
            int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "collectTime");
            int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "channelCommentId");
            int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "extParams");
            int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "sid");
            int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "cur_remark");
            int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "remark");
            int columnIndexOrThrow25 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "display_name");
            int columnIndexOrThrow26 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "trackName");
            int columnIndexOrThrow27 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "albumName");
            int columnIndexOrThrow28 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "album_id");
            int columnIndexOrThrow29 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "feeAlbumId");
            int columnIndexOrThrow30 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "mixId");
            int columnIndexOrThrow31 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "oldMixId");
            int columnIndexOrThrow32 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "audioId");
            int columnIndexOrThrow33 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "track_id");
            int columnIndexOrThrow34 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "artistName");
            int columnIndexOrThrow35 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "genre");
            int columnIndexOrThrow36 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "artist_id");
            int columnIndexOrThrow37 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "size");
            int columnIndexOrThrow38 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "hashValue");
            int columnIndexOrThrow39 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "musicpath");
            int columnIndexOrThrow40 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "bitrate");
            int columnIndexOrThrow41 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "duration");
            int columnIndexOrThrow42 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "m4aHash");
            int columnIndexOrThrow43 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "m4aSize");
            int columnIndexOrThrow44 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "m4aUrl");
            int columnIndexOrThrow45 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "hash320");
            int columnIndexOrThrow46 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "size320");
            int columnIndexOrThrow47 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "sqHash");
            int columnIndexOrThrow48 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "sqSize");
            int columnIndexOrThrow49 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "mvHashValue");
            int columnIndexOrThrow50 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "mvTracks");
            int columnIndexOrThrow51 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "mvType");
            int columnIndexOrThrow52 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "mvMatchTime");
            int columnIndexOrThrow53 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "accompanimentHash");
            int columnIndexOrThrow54 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "accompanimentTime");
            int columnIndexOrThrow55 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "accompanimentId");
            int columnIndexOrThrow56 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "has_accompany");
            int columnIndexOrThrow57 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "sourceHash");
            int columnIndexOrThrow58 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "fileId");
            int columnIndexOrThrow59 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "musicLinkSource");
            int columnIndexOrThrow60 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "mSpecialOrAlbumName");
            int columnIndexOrThrow61 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "musicLinkExtInfo");
            int columnIndexOrThrow62 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "hashType");
            int columnIndexOrThrow63 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "imgUrl");
            int columnIndexOrThrow64 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "sk");
            int columnIndexOrThrow65 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "isExclusivePublish");
            int columnIndexOrThrow66 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "extname");
            int columnIndexOrThrow67 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "feeType");
            int columnIndexOrThrow68 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "isnew");
            int columnIndexOrThrow69 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "fullName");
            int columnIndexOrThrow70 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "source");
            int columnIndexOrThrow71 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "sourceType");
            int columnIndexOrThrow72 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "srctype");
            int columnIndexOrThrow73 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "genreId");
            int columnIndexOrThrow74 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "albumMatchTime");
            int columnIndexOrThrow75 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "isInsertPlay");
            int columnIndexOrThrow76 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "charge");
            int columnIndexOrThrow77 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "behavior");
            int columnIndexOrThrow78 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "module");
            int columnIndexOrThrow79 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "songSource");
            int columnIndexOrThrow80 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "inList");
            int columnIndexOrThrow81 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "sourceMode");
            int columnIndexOrThrow82 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "musicFeeStatus");
            int columnIndexOrThrow83 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "musicFeeType");
            int columnIndexOrThrow84 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "failProcess");
            int columnIndexOrThrow85 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "payType");
            int columnIndexOrThrow86 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "updateFeeStatusTime");
            int columnIndexOrThrow87 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "localMusicFeeId");
            int columnIndexOrThrow88 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "oldCpy");
            int columnIndexOrThrow89 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "isFileDownloaded");
            int columnIndexOrThrow90 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "isMusicCloudFile");
            int columnIndexOrThrow91 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "mDownloadStatus");
            int columnIndexOrThrow92 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "isPlayMusicCloud");
            int columnIndexOrThrow93 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "tag");
            int columnIndexOrThrow94 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "publishYear");
            int columnIndexOrThrow95 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "publishYearMatchTime");
            int columnIndexOrThrow96 = CursorUtil.getColumnIndexOrThrow(cursorQuery, KrcLoader.TAG_LANGUAGE);
            int columnIndexOrThrow97 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "languageMatchTime");
            int columnIndexOrThrow98 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "isUserSetLanguage");
            int columnIndexOrThrow99 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "isUserSetPublishYear");
            int columnIndexOrThrow100 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "authorId");
            int columnIndexOrThrow101 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "specialId");
            int columnIndexOrThrow102 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "rankId");
            int columnIndexOrThrow103 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "topic");
            int columnIndexOrThrow104 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "songType");
            int columnIndexOrThrow105 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "fromLocalMusic");
            int columnIndexOrThrow106 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "isUserPlay");
            int columnIndexOrThrow107 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "audioType");
            int columnIndexOrThrow108 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "sort");
            int columnIndexOrThrow109 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "audioIndex");
            int columnIndexOrThrow110 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "mFlag");
            int columnIndexOrThrow111 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "ugcReviewed");
            int columnIndexOrThrow112 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "qualityFeeSource");
            int columnIndexOrThrow113 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "isFromMyAsset");
            int columnIndexOrThrow114 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "fileEncryptType");
            int columnIndexOrThrow115 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "isLocalEncryptUpgradeMP3");
            int columnIndexOrThrow116 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "maskOfForceDownload");
            int columnIndexOrThrow117 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "guessYouLikeMark");
            int columnIndexOrThrow118 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "guessYouLikeBiString");
            int columnIndexOrThrow119 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "brief");
            if (cursorQuery.moveToFirst()) {
                KGMusic kGMusic2 = new KGMusic();
                kGMusic2.dbId = cursorQuery.getLong(columnIndexOrThrow);
                kGMusic2.id = cursorQuery.getLong(columnIndexOrThrow2);
                kGMusic2.playListId = cursorQuery.getInt(columnIndexOrThrow3);
                kGMusic2.playListName = cursorQuery.getString(columnIndexOrThrow4);
                kGMusic2.playListCreateListId = cursorQuery.getInt(columnIndexOrThrow5);
                kGMusic2.playListCreateUserId = cursorQuery.getLong(columnIndexOrThrow6);
                kGMusic2.playListCloudListId = cursorQuery.getInt(columnIndexOrThrow7);
                kGMusic2.playListType = cursorQuery.getInt(columnIndexOrThrow8);
                kGMusic2.playListSource = cursorQuery.getInt(columnIndexOrThrow9);
                kGMusic2.musiclibId = cursorQuery.getInt(columnIndexOrThrow10);
                kGMusic2.playListCreateUserName = cursorQuery.getString(columnIndexOrThrow11);
                kGMusic2.mPlayListPicPath = cursorQuery.getString(columnIndexOrThrow12);
                kGMusic2.isReset = cursorQuery.getInt(columnIndexOrThrow13) != 0;
                kGMusic2.musicSource = cursorQuery.getInt(columnIndexOrThrow14);
                kGMusic2.setGlobalCollectionId(cursorQuery.getString(columnIndexOrThrow15));
                kGMusic2.setAudition(cursorQuery.getInt(columnIndexOrThrow16));
                kGMusic2.setGif_id(cursorQuery.getInt(columnIndexOrThrow17));
                kGMusic2.fileOrderWeight = cursorQuery.getInt(columnIndexOrThrow18);
                kGMusic2.collectTime = cursorQuery.getLong(columnIndexOrThrow19);
                kGMusic2.channelCommentId = cursorQuery.getString(columnIndexOrThrow20);
                kGMusic2.extParams = cursorQuery.getString(columnIndexOrThrow21);
                kGMusic2.sid = cursorQuery.getLong(columnIndexOrThrow22);
                kGMusic2.curMark = cursorQuery.getString(columnIndexOrThrow23);
                kGMusic2.remark = cursorQuery.getString(columnIndexOrThrow24);
                kGMusic2.displayName = cursorQuery.getString(columnIndexOrThrow25);
                kGMusic2.trackName = cursorQuery.getString(columnIndexOrThrow26);
                kGMusic2.albumName = cursorQuery.getString(columnIndexOrThrow27);
                kGMusic2.albumID = cursorQuery.getLong(columnIndexOrThrow28);
                kGMusic2.feeAlbumId = cursorQuery.getString(columnIndexOrThrow29);
                kGMusic2.mixId = cursorQuery.getLong(columnIndexOrThrow30);
                kGMusic2.oldMixId = cursorQuery.getLong(columnIndexOrThrow31);
                kGMusic2.audioId = cursorQuery.getLong(columnIndexOrThrow32);
                kGMusic2.trackID = cursorQuery.getLong(columnIndexOrThrow33);
                kGMusic2.artistName = cursorQuery.getString(columnIndexOrThrow34);
                kGMusic2.genre = cursorQuery.getString(columnIndexOrThrow35);
                kGMusic2.artistID = cursorQuery.getLong(columnIndexOrThrow36);
                kGMusic2.size = cursorQuery.getLong(columnIndexOrThrow37);
                kGMusic2.hashValue = cursorQuery.getString(columnIndexOrThrow38);
                kGMusic2.musicpath = cursorQuery.getString(columnIndexOrThrow39);
                kGMusic2.bitrate = cursorQuery.getInt(columnIndexOrThrow40);
                kGMusic2.duration = cursorQuery.getLong(columnIndexOrThrow41);
                kGMusic2.m4aHash = cursorQuery.getString(columnIndexOrThrow42);
                kGMusic2.m4aSize = cursorQuery.getLong(columnIndexOrThrow43);
                kGMusic2.m4aUrl = cursorQuery.getString(columnIndexOrThrow44);
                kGMusic2.hash320 = cursorQuery.getString(columnIndexOrThrow45);
                kGMusic2.size320 = cursorQuery.getLong(columnIndexOrThrow46);
                kGMusic2.sqHash = cursorQuery.getString(columnIndexOrThrow47);
                kGMusic2.sqSize = cursorQuery.getLong(columnIndexOrThrow48);
                kGMusic2.mvHashValue = cursorQuery.getString(columnIndexOrThrow49);
                kGMusic2.mvTracks = cursorQuery.getInt(columnIndexOrThrow50);
                kGMusic2.mvType = cursorQuery.getInt(columnIndexOrThrow51);
                kGMusic2.mvMatchTime = cursorQuery.getLong(columnIndexOrThrow52);
                kGMusic2.accompanimentHash = cursorQuery.getString(columnIndexOrThrow53);
                kGMusic2.accompanimentTime = cursorQuery.getLong(columnIndexOrThrow54);
                kGMusic2.accompanimentId = cursorQuery.getInt(columnIndexOrThrow55);
                kGMusic2.has_accompany = cursorQuery.getInt(columnIndexOrThrow56);
                kGMusic2.sourceHash = cursorQuery.getString(columnIndexOrThrow57);
                kGMusic2.fileId = cursorQuery.getLong(columnIndexOrThrow58);
                kGMusic2.musicLinkSource = cursorQuery.getInt(columnIndexOrThrow59);
                kGMusic2.mSpecialOrAlbumName = cursorQuery.getString(columnIndexOrThrow60);
                kGMusic2.musicLinkExtInfo = cursorQuery.getString(columnIndexOrThrow61);
                kGMusic2.hashType = cursorQuery.getInt(columnIndexOrThrow62);
                kGMusic2.imgUrl = cursorQuery.getString(columnIndexOrThrow63);
                kGMusic2.sk = cursorQuery.getString(columnIndexOrThrow64);
                kGMusic2.isExclusivePublish = cursorQuery.getInt(columnIndexOrThrow65) != 0;
                kGMusic2.extname = cursorQuery.getString(columnIndexOrThrow66);
                kGMusic2.feeType = cursorQuery.getInt(columnIndexOrThrow67);
                kGMusic2.isnew = cursorQuery.getInt(columnIndexOrThrow68);
                kGMusic2.fullName = cursorQuery.getString(columnIndexOrThrow69);
                kGMusic2.source = cursorQuery.getString(columnIndexOrThrow70);
                kGMusic2.sourceType = cursorQuery.getString(columnIndexOrThrow71);
                kGMusic2.srctype = cursorQuery.getInt(columnIndexOrThrow72);
                kGMusic2.genreId = cursorQuery.getInt(columnIndexOrThrow73);
                kGMusic2.albumMatchTime = cursorQuery.getLong(columnIndexOrThrow74);
                kGMusic2.isInsertPlay = cursorQuery.getInt(columnIndexOrThrow75);
                kGMusic2.charge = cursorQuery.getInt(columnIndexOrThrow76);
                kGMusic2.behavior = cursorQuery.getString(columnIndexOrThrow77);
                kGMusic2.module = cursorQuery.getString(columnIndexOrThrow78);
                kGMusic2.songSource = cursorQuery.getInt(columnIndexOrThrow79);
                kGMusic2.inList = cursorQuery.getInt(columnIndexOrThrow80);
                kGMusic2.sourceMode = cursorQuery.getInt(columnIndexOrThrow81);
                kGMusic2.musicFeeStatus = cursorQuery.getInt(columnIndexOrThrow82);
                kGMusic2.musicFeeType = cursorQuery.getString(columnIndexOrThrow83);
                kGMusic2.failProcess = cursorQuery.getInt(columnIndexOrThrow84);
                kGMusic2.payType = cursorQuery.getInt(columnIndexOrThrow85);
                kGMusic2.updateFeeStatusTime = cursorQuery.getLong(columnIndexOrThrow86);
                kGMusic2.localMusicFeeId = cursorQuery.getLong(columnIndexOrThrow87);
                kGMusic2.oldCpy = cursorQuery.getInt(columnIndexOrThrow88);
                kGMusic2.isFileDownloaded = cursorQuery.getInt(columnIndexOrThrow89) != 0;
                kGMusic2.isMusicCloudFile = cursorQuery.getInt(columnIndexOrThrow90) != 0;
                kGMusic2.mDownloadStatus = cursorQuery.getInt(columnIndexOrThrow91);
                kGMusic2.isPlayMusicCloud = cursorQuery.getInt(columnIndexOrThrow92) != 0;
                kGMusic2.tag = cursorQuery.getInt(columnIndexOrThrow93);
                kGMusic2.publishYear = cursorQuery.getString(columnIndexOrThrow94);
                kGMusic2.publishYearMatchTime = cursorQuery.getLong(columnIndexOrThrow95);
                kGMusic2.language = cursorQuery.getString(columnIndexOrThrow96);
                kGMusic2.languageMatchTime = cursorQuery.getLong(columnIndexOrThrow97);
                kGMusic2.isUserSetLanguage = cursorQuery.getInt(columnIndexOrThrow98) != 0;
                kGMusic2.isUserSetPublishYear = cursorQuery.getInt(columnIndexOrThrow99) != 0;
                kGMusic2.setAuthorId(cursorQuery.getInt(columnIndexOrThrow100));
                kGMusic2.setSpecialId(cursorQuery.getInt(columnIndexOrThrow101));
                kGMusic2.setRankId(cursorQuery.getInt(columnIndexOrThrow102));
                kGMusic2.setTopic(cursorQuery.getString(columnIndexOrThrow103));
                kGMusic2.setSongType(cursorQuery.getString(columnIndexOrThrow104));
                kGMusic2.setFromLocalMusic(cursorQuery.getInt(columnIndexOrThrow105) != 0);
                kGMusic2.setUserPlay(cursorQuery.getInt(columnIndexOrThrow106) != 0);
                kGMusic2.setAudioType(cursorQuery.getInt(columnIndexOrThrow107));
                kGMusic2.setSort(cursorQuery.getInt(columnIndexOrThrow108));
                kGMusic2.setAudioIndex(cursorQuery.getInt(columnIndexOrThrow109));
                kGMusic2.setFlag(cursorQuery.getInt(columnIndexOrThrow110));
                kGMusic2.setUgcReviewed(cursorQuery.getInt(columnIndexOrThrow111));
                kGMusic2.setQualityFeeSource(cursorQuery.getInt(columnIndexOrThrow112));
                kGMusic2.setFromMyAsset(cursorQuery.getInt(columnIndexOrThrow113) != 0);
                kGMusic2.setFileEncryptType(cursorQuery.getInt(columnIndexOrThrow114));
                kGMusic2.setIsLocalEncryptUpgradeMP3(cursorQuery.getInt(columnIndexOrThrow115) != 0);
                kGMusic2.setMaskOfForceDownload(cursorQuery.getInt(columnIndexOrThrow116));
                kGMusic2.setGuessYouLikeMark(cursorQuery.getInt(columnIndexOrThrow117));
                kGMusic2.setGuessYouLikeBiString(cursorQuery.getString(columnIndexOrThrow118));
                kGMusic2.setBrief(cursorQuery.getString(columnIndexOrThrow119));
                kGMusic = kGMusic2;
            } else {
                kGMusic = null;
            }
            cursorQuery.close();
            roomSQLiteQuery.release();
            return kGMusic;
        } catch (Throwable th2) {
            th = th2;
            cursorQuery.close();
            roomSQLiteQuery.release();
            throw th;
        }
    }

    @Override // e.c.a.g.a.d.f.c.a.g
    public List<KGMusic> p(List<String> list) throws Throwable {
        RoomSQLiteQuery roomSQLiteQuery;
        int columnIndexOrThrow;
        int columnIndexOrThrow2;
        int columnIndexOrThrow3;
        int columnIndexOrThrow4;
        int columnIndexOrThrow5;
        int columnIndexOrThrow6;
        int columnIndexOrThrow7;
        int columnIndexOrThrow8;
        int columnIndexOrThrow9;
        int columnIndexOrThrow10;
        int columnIndexOrThrow11;
        int columnIndexOrThrow12;
        int columnIndexOrThrow13;
        int columnIndexOrThrow14;
        int i2;
        boolean z;
        boolean z2;
        int i3;
        boolean z3;
        boolean z4;
        boolean z5;
        StringBuilder sbNewStringBuilder = StringUtil.newStringBuilder();
        sbNewStringBuilder.append("SELECT ");
        sbNewStringBuilder.append("*");
        sbNewStringBuilder.append(" FROM kugou_songs WHERE hashValue in (");
        int size = list.size();
        StringUtil.appendPlaceholders(sbNewStringBuilder, size);
        sbNewStringBuilder.append(")");
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire(sbNewStringBuilder.toString(), size + 0);
        int i4 = 1;
        for (String str : list) {
            if (str == null) {
                roomSQLiteQueryAcquire.bindNull(i4);
            } else {
                roomSQLiteQueryAcquire.bindString(i4, str);
            }
            i4++;
        }
        this.c.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.c, roomSQLiteQueryAcquire, false, null);
        try {
            columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, DbOpenHelper.ID);
            columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
            columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "playListId");
            columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "playListName");
            columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "playListCreateListId");
            columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "playListCreateUserId");
            columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "playListCloudListId");
            columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "playListType");
            columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "playListSource");
            columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "musiclibId");
            columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "playListCreateUserName");
            columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "mPlayListPicPath");
            columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "isReset");
            columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "musicSource");
            roomSQLiteQuery = roomSQLiteQueryAcquire;
        } catch (Throwable th) {
            th = th;
            roomSQLiteQuery = roomSQLiteQueryAcquire;
        }
        try {
            int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "globalCollectionId");
            int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "audition");
            int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "gif_id");
            int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "fileOrderWeight");
            int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "collectTime");
            int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "channelCommentId");
            int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "extParams");
            int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "sid");
            int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "cur_remark");
            int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "remark");
            int columnIndexOrThrow25 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "display_name");
            int columnIndexOrThrow26 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "trackName");
            int columnIndexOrThrow27 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "albumName");
            int columnIndexOrThrow28 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "album_id");
            int columnIndexOrThrow29 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "feeAlbumId");
            int columnIndexOrThrow30 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "mixId");
            int columnIndexOrThrow31 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "oldMixId");
            int columnIndexOrThrow32 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "audioId");
            int columnIndexOrThrow33 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "track_id");
            int columnIndexOrThrow34 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "artistName");
            int columnIndexOrThrow35 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "genre");
            int columnIndexOrThrow36 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "artist_id");
            int columnIndexOrThrow37 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "size");
            int columnIndexOrThrow38 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "hashValue");
            int columnIndexOrThrow39 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "musicpath");
            int columnIndexOrThrow40 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "bitrate");
            int columnIndexOrThrow41 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "duration");
            int columnIndexOrThrow42 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "m4aHash");
            int columnIndexOrThrow43 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "m4aSize");
            int columnIndexOrThrow44 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "m4aUrl");
            int columnIndexOrThrow45 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "hash320");
            int columnIndexOrThrow46 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "size320");
            int columnIndexOrThrow47 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "sqHash");
            int columnIndexOrThrow48 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "sqSize");
            int columnIndexOrThrow49 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "mvHashValue");
            int columnIndexOrThrow50 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "mvTracks");
            int columnIndexOrThrow51 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "mvType");
            int columnIndexOrThrow52 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "mvMatchTime");
            int columnIndexOrThrow53 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "accompanimentHash");
            int columnIndexOrThrow54 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "accompanimentTime");
            int columnIndexOrThrow55 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "accompanimentId");
            int columnIndexOrThrow56 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "has_accompany");
            int columnIndexOrThrow57 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "sourceHash");
            int columnIndexOrThrow58 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "fileId");
            int columnIndexOrThrow59 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "musicLinkSource");
            int columnIndexOrThrow60 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "mSpecialOrAlbumName");
            int columnIndexOrThrow61 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "musicLinkExtInfo");
            int columnIndexOrThrow62 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "hashType");
            int columnIndexOrThrow63 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "imgUrl");
            int columnIndexOrThrow64 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "sk");
            int columnIndexOrThrow65 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "isExclusivePublish");
            int columnIndexOrThrow66 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "extname");
            int columnIndexOrThrow67 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "feeType");
            int columnIndexOrThrow68 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "isnew");
            int columnIndexOrThrow69 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "fullName");
            int columnIndexOrThrow70 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "source");
            int columnIndexOrThrow71 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "sourceType");
            int columnIndexOrThrow72 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "srctype");
            int columnIndexOrThrow73 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "genreId");
            int columnIndexOrThrow74 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "albumMatchTime");
            int columnIndexOrThrow75 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "isInsertPlay");
            int columnIndexOrThrow76 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "charge");
            int columnIndexOrThrow77 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "behavior");
            int columnIndexOrThrow78 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "module");
            int columnIndexOrThrow79 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "songSource");
            int columnIndexOrThrow80 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "inList");
            int columnIndexOrThrow81 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "sourceMode");
            int columnIndexOrThrow82 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "musicFeeStatus");
            int columnIndexOrThrow83 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "musicFeeType");
            int columnIndexOrThrow84 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "failProcess");
            int columnIndexOrThrow85 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "payType");
            int columnIndexOrThrow86 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "updateFeeStatusTime");
            int columnIndexOrThrow87 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "localMusicFeeId");
            int columnIndexOrThrow88 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "oldCpy");
            int columnIndexOrThrow89 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "isFileDownloaded");
            int columnIndexOrThrow90 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "isMusicCloudFile");
            int columnIndexOrThrow91 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "mDownloadStatus");
            int columnIndexOrThrow92 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "isPlayMusicCloud");
            int columnIndexOrThrow93 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "tag");
            int columnIndexOrThrow94 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "publishYear");
            int columnIndexOrThrow95 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "publishYearMatchTime");
            int columnIndexOrThrow96 = CursorUtil.getColumnIndexOrThrow(cursorQuery, KrcLoader.TAG_LANGUAGE);
            int columnIndexOrThrow97 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "languageMatchTime");
            int columnIndexOrThrow98 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "isUserSetLanguage");
            int columnIndexOrThrow99 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "isUserSetPublishYear");
            int columnIndexOrThrow100 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "authorId");
            int columnIndexOrThrow101 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "specialId");
            int columnIndexOrThrow102 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "rankId");
            int columnIndexOrThrow103 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "topic");
            int columnIndexOrThrow104 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "songType");
            int columnIndexOrThrow105 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "fromLocalMusic");
            int columnIndexOrThrow106 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "isUserPlay");
            int columnIndexOrThrow107 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "audioType");
            int columnIndexOrThrow108 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "sort");
            int columnIndexOrThrow109 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "audioIndex");
            int columnIndexOrThrow110 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "mFlag");
            int columnIndexOrThrow111 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "ugcReviewed");
            int columnIndexOrThrow112 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "qualityFeeSource");
            int columnIndexOrThrow113 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "isFromMyAsset");
            int columnIndexOrThrow114 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "fileEncryptType");
            int columnIndexOrThrow115 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "isLocalEncryptUpgradeMP3");
            int columnIndexOrThrow116 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "maskOfForceDownload");
            int columnIndexOrThrow117 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "guessYouLikeMark");
            int columnIndexOrThrow118 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "guessYouLikeBiString");
            int columnIndexOrThrow119 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "brief");
            int i5 = columnIndexOrThrow14;
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                KGMusic kGMusic = new KGMusic();
                ArrayList arrayList2 = arrayList;
                int i6 = columnIndexOrThrow12;
                kGMusic.dbId = cursorQuery.getLong(columnIndexOrThrow);
                kGMusic.id = cursorQuery.getLong(columnIndexOrThrow2);
                kGMusic.playListId = cursorQuery.getInt(columnIndexOrThrow3);
                kGMusic.playListName = cursorQuery.getString(columnIndexOrThrow4);
                kGMusic.playListCreateListId = cursorQuery.getInt(columnIndexOrThrow5);
                kGMusic.playListCreateUserId = cursorQuery.getLong(columnIndexOrThrow6);
                kGMusic.playListCloudListId = cursorQuery.getInt(columnIndexOrThrow7);
                kGMusic.playListType = cursorQuery.getInt(columnIndexOrThrow8);
                kGMusic.playListSource = cursorQuery.getInt(columnIndexOrThrow9);
                kGMusic.musiclibId = cursorQuery.getInt(columnIndexOrThrow10);
                kGMusic.playListCreateUserName = cursorQuery.getString(columnIndexOrThrow11);
                kGMusic.mPlayListPicPath = cursorQuery.getString(i6);
                kGMusic.isReset = cursorQuery.getInt(columnIndexOrThrow13) != 0;
                int i7 = i5;
                int i8 = columnIndexOrThrow;
                kGMusic.musicSource = cursorQuery.getInt(i7);
                int i9 = columnIndexOrThrow15;
                kGMusic.setGlobalCollectionId(cursorQuery.getString(i9));
                columnIndexOrThrow15 = i9;
                int i10 = columnIndexOrThrow16;
                kGMusic.setAudition(cursorQuery.getInt(i10));
                columnIndexOrThrow16 = i10;
                int i11 = columnIndexOrThrow17;
                kGMusic.setGif_id(cursorQuery.getInt(i11));
                columnIndexOrThrow17 = i11;
                int i12 = columnIndexOrThrow18;
                kGMusic.fileOrderWeight = cursorQuery.getInt(i12);
                int i13 = columnIndexOrThrow19;
                kGMusic.collectTime = cursorQuery.getLong(i13);
                int i14 = columnIndexOrThrow20;
                kGMusic.channelCommentId = cursorQuery.getString(i14);
                int i15 = columnIndexOrThrow21;
                kGMusic.extParams = cursorQuery.getString(i15);
                int i16 = columnIndexOrThrow22;
                kGMusic.sid = cursorQuery.getLong(i16);
                int i17 = columnIndexOrThrow23;
                kGMusic.curMark = cursorQuery.getString(i17);
                int i18 = columnIndexOrThrow24;
                kGMusic.remark = cursorQuery.getString(i18);
                int i19 = columnIndexOrThrow25;
                kGMusic.displayName = cursorQuery.getString(i19);
                columnIndexOrThrow25 = i19;
                int i20 = columnIndexOrThrow26;
                kGMusic.trackName = cursorQuery.getString(i20);
                columnIndexOrThrow26 = i20;
                int i21 = columnIndexOrThrow27;
                kGMusic.albumName = cursorQuery.getString(i21);
                int i22 = columnIndexOrThrow13;
                int i23 = columnIndexOrThrow28;
                kGMusic.albumID = cursorQuery.getLong(i23);
                int i24 = columnIndexOrThrow29;
                kGMusic.feeAlbumId = cursorQuery.getString(i24);
                int i25 = columnIndexOrThrow30;
                kGMusic.mixId = cursorQuery.getLong(i25);
                int i26 = columnIndexOrThrow31;
                kGMusic.oldMixId = cursorQuery.getLong(i26);
                int i27 = columnIndexOrThrow2;
                int i28 = columnIndexOrThrow32;
                int i29 = columnIndexOrThrow3;
                kGMusic.audioId = cursorQuery.getLong(i28);
                int i30 = columnIndexOrThrow33;
                kGMusic.trackID = cursorQuery.getLong(i30);
                int i31 = columnIndexOrThrow34;
                kGMusic.artistName = cursorQuery.getString(i31);
                int i32 = columnIndexOrThrow35;
                kGMusic.genre = cursorQuery.getString(i32);
                int i33 = columnIndexOrThrow36;
                kGMusic.artistID = cursorQuery.getLong(i33);
                int i34 = columnIndexOrThrow37;
                kGMusic.size = cursorQuery.getLong(i34);
                int i35 = columnIndexOrThrow38;
                kGMusic.hashValue = cursorQuery.getString(i35);
                int i36 = columnIndexOrThrow39;
                kGMusic.musicpath = cursorQuery.getString(i36);
                int i37 = columnIndexOrThrow40;
                kGMusic.bitrate = cursorQuery.getInt(i37);
                int i38 = columnIndexOrThrow41;
                kGMusic.duration = cursorQuery.getLong(i38);
                int i39 = columnIndexOrThrow42;
                kGMusic.m4aHash = cursorQuery.getString(i39);
                int i40 = columnIndexOrThrow43;
                kGMusic.m4aSize = cursorQuery.getLong(i40);
                int i41 = columnIndexOrThrow44;
                kGMusic.m4aUrl = cursorQuery.getString(i41);
                int i42 = columnIndexOrThrow45;
                kGMusic.hash320 = cursorQuery.getString(i42);
                int i43 = columnIndexOrThrow46;
                kGMusic.size320 = cursorQuery.getLong(i43);
                int i44 = columnIndexOrThrow47;
                kGMusic.sqHash = cursorQuery.getString(i44);
                int i45 = columnIndexOrThrow48;
                kGMusic.sqSize = cursorQuery.getLong(i45);
                int i46 = columnIndexOrThrow49;
                kGMusic.mvHashValue = cursorQuery.getString(i46);
                int i47 = columnIndexOrThrow50;
                kGMusic.mvTracks = cursorQuery.getInt(i47);
                int i48 = columnIndexOrThrow51;
                kGMusic.mvType = cursorQuery.getInt(i48);
                int i49 = columnIndexOrThrow52;
                kGMusic.mvMatchTime = cursorQuery.getLong(i49);
                int i50 = columnIndexOrThrow53;
                kGMusic.accompanimentHash = cursorQuery.getString(i50);
                int i51 = columnIndexOrThrow54;
                kGMusic.accompanimentTime = cursorQuery.getLong(i51);
                int i52 = columnIndexOrThrow55;
                kGMusic.accompanimentId = cursorQuery.getInt(i52);
                int i53 = columnIndexOrThrow56;
                kGMusic.has_accompany = cursorQuery.getInt(i53);
                int i54 = columnIndexOrThrow57;
                kGMusic.sourceHash = cursorQuery.getString(i54);
                int i55 = columnIndexOrThrow58;
                kGMusic.fileId = cursorQuery.getLong(i55);
                int i56 = columnIndexOrThrow59;
                kGMusic.musicLinkSource = cursorQuery.getInt(i56);
                int i57 = columnIndexOrThrow60;
                kGMusic.mSpecialOrAlbumName = cursorQuery.getString(i57);
                int i58 = columnIndexOrThrow61;
                kGMusic.musicLinkExtInfo = cursorQuery.getString(i58);
                columnIndexOrThrow61 = i58;
                int i59 = columnIndexOrThrow62;
                kGMusic.hashType = cursorQuery.getInt(i59);
                columnIndexOrThrow62 = i59;
                int i60 = columnIndexOrThrow63;
                kGMusic.imgUrl = cursorQuery.getString(i60);
                columnIndexOrThrow63 = i60;
                int i61 = columnIndexOrThrow64;
                kGMusic.sk = cursorQuery.getString(i61);
                int i62 = columnIndexOrThrow65;
                columnIndexOrThrow65 = i62;
                kGMusic.isExclusivePublish = cursorQuery.getInt(i62) != 0;
                columnIndexOrThrow64 = i61;
                int i63 = columnIndexOrThrow66;
                kGMusic.extname = cursorQuery.getString(i63);
                columnIndexOrThrow66 = i63;
                int i64 = columnIndexOrThrow67;
                kGMusic.feeType = cursorQuery.getInt(i64);
                columnIndexOrThrow67 = i64;
                int i65 = columnIndexOrThrow68;
                kGMusic.isnew = cursorQuery.getInt(i65);
                columnIndexOrThrow68 = i65;
                int i66 = columnIndexOrThrow69;
                kGMusic.fullName = cursorQuery.getString(i66);
                columnIndexOrThrow69 = i66;
                int i67 = columnIndexOrThrow70;
                kGMusic.source = cursorQuery.getString(i67);
                columnIndexOrThrow70 = i67;
                int i68 = columnIndexOrThrow71;
                kGMusic.sourceType = cursorQuery.getString(i68);
                columnIndexOrThrow71 = i68;
                int i69 = columnIndexOrThrow72;
                kGMusic.srctype = cursorQuery.getInt(i69);
                columnIndexOrThrow72 = i69;
                int i70 = columnIndexOrThrow73;
                kGMusic.genreId = cursorQuery.getInt(i70);
                int i71 = columnIndexOrThrow74;
                kGMusic.albumMatchTime = cursorQuery.getLong(i71);
                int i72 = columnIndexOrThrow75;
                kGMusic.isInsertPlay = cursorQuery.getInt(i72);
                int i73 = columnIndexOrThrow76;
                kGMusic.charge = cursorQuery.getInt(i73);
                int i74 = columnIndexOrThrow77;
                kGMusic.behavior = cursorQuery.getString(i74);
                columnIndexOrThrow77 = i74;
                int i75 = columnIndexOrThrow78;
                kGMusic.module = cursorQuery.getString(i75);
                columnIndexOrThrow78 = i75;
                int i76 = columnIndexOrThrow79;
                kGMusic.songSource = cursorQuery.getInt(i76);
                columnIndexOrThrow79 = i76;
                int i77 = columnIndexOrThrow80;
                kGMusic.inList = cursorQuery.getInt(i77);
                columnIndexOrThrow80 = i77;
                int i78 = columnIndexOrThrow81;
                kGMusic.sourceMode = cursorQuery.getInt(i78);
                columnIndexOrThrow81 = i78;
                int i79 = columnIndexOrThrow82;
                kGMusic.musicFeeStatus = cursorQuery.getInt(i79);
                columnIndexOrThrow82 = i79;
                int i80 = columnIndexOrThrow83;
                kGMusic.musicFeeType = cursorQuery.getString(i80);
                columnIndexOrThrow83 = i80;
                int i81 = columnIndexOrThrow84;
                kGMusic.failProcess = cursorQuery.getInt(i81);
                columnIndexOrThrow84 = i81;
                int i82 = columnIndexOrThrow85;
                kGMusic.payType = cursorQuery.getInt(i82);
                int i83 = columnIndexOrThrow86;
                kGMusic.updateFeeStatusTime = cursorQuery.getLong(i83);
                int i84 = columnIndexOrThrow87;
                kGMusic.localMusicFeeId = cursorQuery.getLong(i84);
                int i85 = columnIndexOrThrow88;
                kGMusic.oldCpy = cursorQuery.getInt(i85);
                int i86 = columnIndexOrThrow89;
                if (cursorQuery.getInt(i86) != 0) {
                    i2 = i82;
                    z = true;
                } else {
                    i2 = i82;
                    z = false;
                }
                kGMusic.isFileDownloaded = z;
                int i87 = columnIndexOrThrow90;
                columnIndexOrThrow90 = i87;
                kGMusic.isMusicCloudFile = cursorQuery.getInt(i87) != 0;
                int i88 = columnIndexOrThrow91;
                kGMusic.mDownloadStatus = cursorQuery.getInt(i88);
                int i89 = columnIndexOrThrow92;
                if (cursorQuery.getInt(i89) != 0) {
                    columnIndexOrThrow91 = i88;
                    z2 = true;
                } else {
                    columnIndexOrThrow91 = i88;
                    z2 = false;
                }
                kGMusic.isPlayMusicCloud = z2;
                columnIndexOrThrow92 = i89;
                int i90 = columnIndexOrThrow93;
                kGMusic.tag = cursorQuery.getInt(i90);
                columnIndexOrThrow93 = i90;
                int i91 = columnIndexOrThrow94;
                kGMusic.publishYear = cursorQuery.getString(i91);
                int i92 = columnIndexOrThrow95;
                kGMusic.publishYearMatchTime = cursorQuery.getLong(i92);
                int i93 = columnIndexOrThrow96;
                kGMusic.language = cursorQuery.getString(i93);
                int i94 = columnIndexOrThrow97;
                kGMusic.languageMatchTime = cursorQuery.getLong(i94);
                int i95 = columnIndexOrThrow98;
                kGMusic.isUserSetLanguage = cursorQuery.getInt(i95) != 0;
                int i96 = columnIndexOrThrow99;
                if (cursorQuery.getInt(i96) != 0) {
                    i3 = i92;
                    z3 = true;
                } else {
                    i3 = i92;
                    z3 = false;
                }
                kGMusic.isUserSetPublishYear = z3;
                int i97 = columnIndexOrThrow100;
                kGMusic.setAuthorId(cursorQuery.getInt(i97));
                columnIndexOrThrow100 = i97;
                int i98 = columnIndexOrThrow101;
                kGMusic.setSpecialId(cursorQuery.getInt(i98));
                columnIndexOrThrow101 = i98;
                int i99 = columnIndexOrThrow102;
                kGMusic.setRankId(cursorQuery.getInt(i99));
                columnIndexOrThrow102 = i99;
                int i100 = columnIndexOrThrow103;
                kGMusic.setTopic(cursorQuery.getString(i100));
                columnIndexOrThrow103 = i100;
                int i101 = columnIndexOrThrow104;
                kGMusic.setSongType(cursorQuery.getString(i101));
                int i102 = columnIndexOrThrow105;
                if (cursorQuery.getInt(i102) != 0) {
                    columnIndexOrThrow104 = i101;
                    z4 = true;
                } else {
                    columnIndexOrThrow104 = i101;
                    z4 = false;
                }
                kGMusic.setFromLocalMusic(z4);
                int i103 = columnIndexOrThrow106;
                columnIndexOrThrow106 = i103;
                kGMusic.setUserPlay(cursorQuery.getInt(i103) != 0);
                columnIndexOrThrow105 = i102;
                int i104 = columnIndexOrThrow107;
                kGMusic.setAudioType(cursorQuery.getInt(i104));
                columnIndexOrThrow107 = i104;
                int i105 = columnIndexOrThrow108;
                kGMusic.setSort(cursorQuery.getInt(i105));
                columnIndexOrThrow108 = i105;
                int i106 = columnIndexOrThrow109;
                kGMusic.setAudioIndex(cursorQuery.getInt(i106));
                columnIndexOrThrow109 = i106;
                int i107 = columnIndexOrThrow110;
                kGMusic.setFlag(cursorQuery.getInt(i107));
                columnIndexOrThrow110 = i107;
                int i108 = columnIndexOrThrow111;
                kGMusic.setUgcReviewed(cursorQuery.getInt(i108));
                columnIndexOrThrow111 = i108;
                int i109 = columnIndexOrThrow112;
                kGMusic.setQualityFeeSource(cursorQuery.getInt(i109));
                int i110 = columnIndexOrThrow113;
                columnIndexOrThrow113 = i110;
                kGMusic.setFromMyAsset(cursorQuery.getInt(i110) != 0);
                columnIndexOrThrow112 = i109;
                int i111 = columnIndexOrThrow114;
                kGMusic.setFileEncryptType(cursorQuery.getInt(i111));
                int i112 = columnIndexOrThrow115;
                if (cursorQuery.getInt(i112) != 0) {
                    columnIndexOrThrow114 = i111;
                    z5 = true;
                } else {
                    columnIndexOrThrow114 = i111;
                    z5 = false;
                }
                kGMusic.setIsLocalEncryptUpgradeMP3(z5);
                columnIndexOrThrow115 = i112;
                int i113 = columnIndexOrThrow116;
                kGMusic.setMaskOfForceDownload(cursorQuery.getInt(i113));
                columnIndexOrThrow116 = i113;
                int i114 = columnIndexOrThrow117;
                kGMusic.setGuessYouLikeMark(cursorQuery.getInt(i114));
                columnIndexOrThrow117 = i114;
                int i115 = columnIndexOrThrow118;
                kGMusic.setGuessYouLikeBiString(cursorQuery.getString(i115));
                columnIndexOrThrow118 = i115;
                int i116 = columnIndexOrThrow119;
                kGMusic.setBrief(cursorQuery.getString(i116));
                arrayList2.add(kGMusic);
                columnIndexOrThrow119 = i116;
                arrayList = arrayList2;
                columnIndexOrThrow = i8;
                i5 = i7;
                columnIndexOrThrow18 = i12;
                columnIndexOrThrow19 = i13;
                columnIndexOrThrow20 = i14;
                columnIndexOrThrow21 = i15;
                columnIndexOrThrow22 = i16;
                columnIndexOrThrow23 = i17;
                columnIndexOrThrow24 = i18;
                columnIndexOrThrow28 = i23;
                columnIndexOrThrow29 = i24;
                columnIndexOrThrow30 = i25;
                columnIndexOrThrow31 = i26;
                columnIndexOrThrow48 = i45;
                columnIndexOrThrow52 = i49;
                columnIndexOrThrow53 = i50;
                columnIndexOrThrow54 = i51;
                columnIndexOrThrow57 = i54;
                columnIndexOrThrow59 = i56;
                columnIndexOrThrow73 = i70;
                columnIndexOrThrow74 = i71;
                columnIndexOrThrow75 = i72;
                columnIndexOrThrow76 = i73;
                columnIndexOrThrow86 = i83;
                columnIndexOrThrow89 = i86;
                columnIndexOrThrow97 = i94;
                columnIndexOrThrow12 = i6;
                columnIndexOrThrow49 = i46;
                columnIndexOrThrow13 = i22;
                columnIndexOrThrow27 = i21;
                columnIndexOrThrow34 = i31;
                columnIndexOrThrow35 = i32;
                columnIndexOrThrow36 = i33;
                columnIndexOrThrow38 = i35;
                columnIndexOrThrow40 = i37;
                columnIndexOrThrow44 = i41;
                columnIndexOrThrow45 = i42;
                columnIndexOrThrow46 = i43;
                int i117 = i3;
                columnIndexOrThrow98 = i95;
                columnIndexOrThrow2 = i27;
                columnIndexOrThrow37 = i34;
                columnIndexOrThrow39 = i36;
                columnIndexOrThrow41 = i38;
                columnIndexOrThrow42 = i39;
                columnIndexOrThrow43 = i40;
                columnIndexOrThrow51 = i48;
                columnIndexOrThrow55 = i52;
                columnIndexOrThrow56 = i53;
                columnIndexOrThrow58 = i55;
                columnIndexOrThrow60 = i57;
                columnIndexOrThrow85 = i2;
                columnIndexOrThrow88 = i85;
                columnIndexOrThrow96 = i93;
                columnIndexOrThrow99 = i96;
                columnIndexOrThrow3 = i29;
                columnIndexOrThrow32 = i28;
                columnIndexOrThrow33 = i30;
                columnIndexOrThrow47 = i44;
                columnIndexOrThrow50 = i47;
                columnIndexOrThrow87 = i84;
                columnIndexOrThrow94 = i91;
                columnIndexOrThrow95 = i117;
            }
            ArrayList arrayList3 = arrayList;
            cursorQuery.close();
            roomSQLiteQuery.release();
            return arrayList3;
        } catch (Throwable th2) {
            th = th2;
            cursorQuery.close();
            roomSQLiteQuery.release();
            throw th;
        }
    }

    @Override // e.c.a.g.a.d.f.c.a.g
    public List<KGMusic> q(List<Long> list) throws Throwable {
        RoomSQLiteQuery roomSQLiteQuery;
        int columnIndexOrThrow;
        int columnIndexOrThrow2;
        int columnIndexOrThrow3;
        int columnIndexOrThrow4;
        int columnIndexOrThrow5;
        int columnIndexOrThrow6;
        int columnIndexOrThrow7;
        int columnIndexOrThrow8;
        int columnIndexOrThrow9;
        int columnIndexOrThrow10;
        int columnIndexOrThrow11;
        int columnIndexOrThrow12;
        int columnIndexOrThrow13;
        int columnIndexOrThrow14;
        int i2;
        boolean z;
        boolean z2;
        int i3;
        boolean z3;
        boolean z4;
        boolean z5;
        StringBuilder sbNewStringBuilder = StringUtil.newStringBuilder();
        sbNewStringBuilder.append("SELECT ");
        sbNewStringBuilder.append("*");
        sbNewStringBuilder.append(" FROM kugou_songs WHERE mixId in (");
        int size = list.size();
        StringUtil.appendPlaceholders(sbNewStringBuilder, size);
        sbNewStringBuilder.append(")");
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire(sbNewStringBuilder.toString(), size + 0);
        int i4 = 1;
        for (Long l : list) {
            if (l == null) {
                roomSQLiteQueryAcquire.bindNull(i4);
            } else {
                roomSQLiteQueryAcquire.bindLong(i4, l.longValue());
            }
            i4++;
        }
        this.c.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.c, roomSQLiteQueryAcquire, false, null);
        try {
            columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, DbOpenHelper.ID);
            columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
            columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "playListId");
            columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "playListName");
            columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "playListCreateListId");
            columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "playListCreateUserId");
            columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "playListCloudListId");
            columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "playListType");
            columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "playListSource");
            columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "musiclibId");
            columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "playListCreateUserName");
            columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "mPlayListPicPath");
            columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "isReset");
            columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "musicSource");
            roomSQLiteQuery = roomSQLiteQueryAcquire;
        } catch (Throwable th) {
            th = th;
            roomSQLiteQuery = roomSQLiteQueryAcquire;
        }
        try {
            int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "globalCollectionId");
            int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "audition");
            int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "gif_id");
            int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "fileOrderWeight");
            int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "collectTime");
            int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "channelCommentId");
            int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "extParams");
            int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "sid");
            int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "cur_remark");
            int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "remark");
            int columnIndexOrThrow25 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "display_name");
            int columnIndexOrThrow26 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "trackName");
            int columnIndexOrThrow27 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "albumName");
            int columnIndexOrThrow28 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "album_id");
            int columnIndexOrThrow29 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "feeAlbumId");
            int columnIndexOrThrow30 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "mixId");
            int columnIndexOrThrow31 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "oldMixId");
            int columnIndexOrThrow32 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "audioId");
            int columnIndexOrThrow33 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "track_id");
            int columnIndexOrThrow34 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "artistName");
            int columnIndexOrThrow35 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "genre");
            int columnIndexOrThrow36 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "artist_id");
            int columnIndexOrThrow37 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "size");
            int columnIndexOrThrow38 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "hashValue");
            int columnIndexOrThrow39 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "musicpath");
            int columnIndexOrThrow40 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "bitrate");
            int columnIndexOrThrow41 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "duration");
            int columnIndexOrThrow42 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "m4aHash");
            int columnIndexOrThrow43 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "m4aSize");
            int columnIndexOrThrow44 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "m4aUrl");
            int columnIndexOrThrow45 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "hash320");
            int columnIndexOrThrow46 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "size320");
            int columnIndexOrThrow47 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "sqHash");
            int columnIndexOrThrow48 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "sqSize");
            int columnIndexOrThrow49 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "mvHashValue");
            int columnIndexOrThrow50 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "mvTracks");
            int columnIndexOrThrow51 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "mvType");
            int columnIndexOrThrow52 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "mvMatchTime");
            int columnIndexOrThrow53 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "accompanimentHash");
            int columnIndexOrThrow54 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "accompanimentTime");
            int columnIndexOrThrow55 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "accompanimentId");
            int columnIndexOrThrow56 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "has_accompany");
            int columnIndexOrThrow57 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "sourceHash");
            int columnIndexOrThrow58 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "fileId");
            int columnIndexOrThrow59 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "musicLinkSource");
            int columnIndexOrThrow60 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "mSpecialOrAlbumName");
            int columnIndexOrThrow61 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "musicLinkExtInfo");
            int columnIndexOrThrow62 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "hashType");
            int columnIndexOrThrow63 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "imgUrl");
            int columnIndexOrThrow64 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "sk");
            int columnIndexOrThrow65 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "isExclusivePublish");
            int columnIndexOrThrow66 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "extname");
            int columnIndexOrThrow67 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "feeType");
            int columnIndexOrThrow68 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "isnew");
            int columnIndexOrThrow69 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "fullName");
            int columnIndexOrThrow70 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "source");
            int columnIndexOrThrow71 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "sourceType");
            int columnIndexOrThrow72 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "srctype");
            int columnIndexOrThrow73 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "genreId");
            int columnIndexOrThrow74 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "albumMatchTime");
            int columnIndexOrThrow75 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "isInsertPlay");
            int columnIndexOrThrow76 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "charge");
            int columnIndexOrThrow77 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "behavior");
            int columnIndexOrThrow78 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "module");
            int columnIndexOrThrow79 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "songSource");
            int columnIndexOrThrow80 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "inList");
            int columnIndexOrThrow81 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "sourceMode");
            int columnIndexOrThrow82 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "musicFeeStatus");
            int columnIndexOrThrow83 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "musicFeeType");
            int columnIndexOrThrow84 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "failProcess");
            int columnIndexOrThrow85 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "payType");
            int columnIndexOrThrow86 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "updateFeeStatusTime");
            int columnIndexOrThrow87 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "localMusicFeeId");
            int columnIndexOrThrow88 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "oldCpy");
            int columnIndexOrThrow89 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "isFileDownloaded");
            int columnIndexOrThrow90 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "isMusicCloudFile");
            int columnIndexOrThrow91 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "mDownloadStatus");
            int columnIndexOrThrow92 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "isPlayMusicCloud");
            int columnIndexOrThrow93 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "tag");
            int columnIndexOrThrow94 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "publishYear");
            int columnIndexOrThrow95 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "publishYearMatchTime");
            int columnIndexOrThrow96 = CursorUtil.getColumnIndexOrThrow(cursorQuery, KrcLoader.TAG_LANGUAGE);
            int columnIndexOrThrow97 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "languageMatchTime");
            int columnIndexOrThrow98 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "isUserSetLanguage");
            int columnIndexOrThrow99 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "isUserSetPublishYear");
            int columnIndexOrThrow100 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "authorId");
            int columnIndexOrThrow101 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "specialId");
            int columnIndexOrThrow102 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "rankId");
            int columnIndexOrThrow103 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "topic");
            int columnIndexOrThrow104 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "songType");
            int columnIndexOrThrow105 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "fromLocalMusic");
            int columnIndexOrThrow106 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "isUserPlay");
            int columnIndexOrThrow107 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "audioType");
            int columnIndexOrThrow108 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "sort");
            int columnIndexOrThrow109 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "audioIndex");
            int columnIndexOrThrow110 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "mFlag");
            int columnIndexOrThrow111 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "ugcReviewed");
            int columnIndexOrThrow112 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "qualityFeeSource");
            int columnIndexOrThrow113 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "isFromMyAsset");
            int columnIndexOrThrow114 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "fileEncryptType");
            int columnIndexOrThrow115 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "isLocalEncryptUpgradeMP3");
            int columnIndexOrThrow116 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "maskOfForceDownload");
            int columnIndexOrThrow117 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "guessYouLikeMark");
            int columnIndexOrThrow118 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "guessYouLikeBiString");
            int columnIndexOrThrow119 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "brief");
            int i5 = columnIndexOrThrow14;
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                KGMusic kGMusic = new KGMusic();
                ArrayList arrayList2 = arrayList;
                int i6 = columnIndexOrThrow12;
                kGMusic.dbId = cursorQuery.getLong(columnIndexOrThrow);
                kGMusic.id = cursorQuery.getLong(columnIndexOrThrow2);
                kGMusic.playListId = cursorQuery.getInt(columnIndexOrThrow3);
                kGMusic.playListName = cursorQuery.getString(columnIndexOrThrow4);
                kGMusic.playListCreateListId = cursorQuery.getInt(columnIndexOrThrow5);
                kGMusic.playListCreateUserId = cursorQuery.getLong(columnIndexOrThrow6);
                kGMusic.playListCloudListId = cursorQuery.getInt(columnIndexOrThrow7);
                kGMusic.playListType = cursorQuery.getInt(columnIndexOrThrow8);
                kGMusic.playListSource = cursorQuery.getInt(columnIndexOrThrow9);
                kGMusic.musiclibId = cursorQuery.getInt(columnIndexOrThrow10);
                kGMusic.playListCreateUserName = cursorQuery.getString(columnIndexOrThrow11);
                kGMusic.mPlayListPicPath = cursorQuery.getString(i6);
                kGMusic.isReset = cursorQuery.getInt(columnIndexOrThrow13) != 0;
                int i7 = i5;
                int i8 = columnIndexOrThrow;
                kGMusic.musicSource = cursorQuery.getInt(i7);
                int i9 = columnIndexOrThrow15;
                kGMusic.setGlobalCollectionId(cursorQuery.getString(i9));
                columnIndexOrThrow15 = i9;
                int i10 = columnIndexOrThrow16;
                kGMusic.setAudition(cursorQuery.getInt(i10));
                columnIndexOrThrow16 = i10;
                int i11 = columnIndexOrThrow17;
                kGMusic.setGif_id(cursorQuery.getInt(i11));
                columnIndexOrThrow17 = i11;
                int i12 = columnIndexOrThrow18;
                kGMusic.fileOrderWeight = cursorQuery.getInt(i12);
                int i13 = columnIndexOrThrow19;
                kGMusic.collectTime = cursorQuery.getLong(i13);
                int i14 = columnIndexOrThrow20;
                kGMusic.channelCommentId = cursorQuery.getString(i14);
                int i15 = columnIndexOrThrow21;
                kGMusic.extParams = cursorQuery.getString(i15);
                int i16 = columnIndexOrThrow22;
                kGMusic.sid = cursorQuery.getLong(i16);
                int i17 = columnIndexOrThrow23;
                kGMusic.curMark = cursorQuery.getString(i17);
                int i18 = columnIndexOrThrow24;
                kGMusic.remark = cursorQuery.getString(i18);
                int i19 = columnIndexOrThrow25;
                kGMusic.displayName = cursorQuery.getString(i19);
                columnIndexOrThrow25 = i19;
                int i20 = columnIndexOrThrow26;
                kGMusic.trackName = cursorQuery.getString(i20);
                columnIndexOrThrow26 = i20;
                int i21 = columnIndexOrThrow27;
                kGMusic.albumName = cursorQuery.getString(i21);
                int i22 = columnIndexOrThrow13;
                int i23 = columnIndexOrThrow28;
                kGMusic.albumID = cursorQuery.getLong(i23);
                int i24 = columnIndexOrThrow29;
                kGMusic.feeAlbumId = cursorQuery.getString(i24);
                int i25 = columnIndexOrThrow30;
                kGMusic.mixId = cursorQuery.getLong(i25);
                int i26 = columnIndexOrThrow31;
                kGMusic.oldMixId = cursorQuery.getLong(i26);
                int i27 = columnIndexOrThrow2;
                int i28 = columnIndexOrThrow32;
                int i29 = columnIndexOrThrow3;
                kGMusic.audioId = cursorQuery.getLong(i28);
                int i30 = columnIndexOrThrow33;
                kGMusic.trackID = cursorQuery.getLong(i30);
                int i31 = columnIndexOrThrow34;
                kGMusic.artistName = cursorQuery.getString(i31);
                int i32 = columnIndexOrThrow35;
                kGMusic.genre = cursorQuery.getString(i32);
                int i33 = columnIndexOrThrow36;
                kGMusic.artistID = cursorQuery.getLong(i33);
                int i34 = columnIndexOrThrow37;
                kGMusic.size = cursorQuery.getLong(i34);
                int i35 = columnIndexOrThrow38;
                kGMusic.hashValue = cursorQuery.getString(i35);
                int i36 = columnIndexOrThrow39;
                kGMusic.musicpath = cursorQuery.getString(i36);
                int i37 = columnIndexOrThrow40;
                kGMusic.bitrate = cursorQuery.getInt(i37);
                int i38 = columnIndexOrThrow41;
                kGMusic.duration = cursorQuery.getLong(i38);
                int i39 = columnIndexOrThrow42;
                kGMusic.m4aHash = cursorQuery.getString(i39);
                int i40 = columnIndexOrThrow43;
                kGMusic.m4aSize = cursorQuery.getLong(i40);
                int i41 = columnIndexOrThrow44;
                kGMusic.m4aUrl = cursorQuery.getString(i41);
                int i42 = columnIndexOrThrow45;
                kGMusic.hash320 = cursorQuery.getString(i42);
                int i43 = columnIndexOrThrow46;
                kGMusic.size320 = cursorQuery.getLong(i43);
                int i44 = columnIndexOrThrow47;
                kGMusic.sqHash = cursorQuery.getString(i44);
                int i45 = columnIndexOrThrow48;
                kGMusic.sqSize = cursorQuery.getLong(i45);
                int i46 = columnIndexOrThrow49;
                kGMusic.mvHashValue = cursorQuery.getString(i46);
                int i47 = columnIndexOrThrow50;
                kGMusic.mvTracks = cursorQuery.getInt(i47);
                int i48 = columnIndexOrThrow51;
                kGMusic.mvType = cursorQuery.getInt(i48);
                int i49 = columnIndexOrThrow52;
                kGMusic.mvMatchTime = cursorQuery.getLong(i49);
                int i50 = columnIndexOrThrow53;
                kGMusic.accompanimentHash = cursorQuery.getString(i50);
                int i51 = columnIndexOrThrow54;
                kGMusic.accompanimentTime = cursorQuery.getLong(i51);
                int i52 = columnIndexOrThrow55;
                kGMusic.accompanimentId = cursorQuery.getInt(i52);
                int i53 = columnIndexOrThrow56;
                kGMusic.has_accompany = cursorQuery.getInt(i53);
                int i54 = columnIndexOrThrow57;
                kGMusic.sourceHash = cursorQuery.getString(i54);
                int i55 = columnIndexOrThrow58;
                kGMusic.fileId = cursorQuery.getLong(i55);
                int i56 = columnIndexOrThrow59;
                kGMusic.musicLinkSource = cursorQuery.getInt(i56);
                int i57 = columnIndexOrThrow60;
                kGMusic.mSpecialOrAlbumName = cursorQuery.getString(i57);
                int i58 = columnIndexOrThrow61;
                kGMusic.musicLinkExtInfo = cursorQuery.getString(i58);
                columnIndexOrThrow61 = i58;
                int i59 = columnIndexOrThrow62;
                kGMusic.hashType = cursorQuery.getInt(i59);
                columnIndexOrThrow62 = i59;
                int i60 = columnIndexOrThrow63;
                kGMusic.imgUrl = cursorQuery.getString(i60);
                columnIndexOrThrow63 = i60;
                int i61 = columnIndexOrThrow64;
                kGMusic.sk = cursorQuery.getString(i61);
                int i62 = columnIndexOrThrow65;
                columnIndexOrThrow65 = i62;
                kGMusic.isExclusivePublish = cursorQuery.getInt(i62) != 0;
                columnIndexOrThrow64 = i61;
                int i63 = columnIndexOrThrow66;
                kGMusic.extname = cursorQuery.getString(i63);
                columnIndexOrThrow66 = i63;
                int i64 = columnIndexOrThrow67;
                kGMusic.feeType = cursorQuery.getInt(i64);
                columnIndexOrThrow67 = i64;
                int i65 = columnIndexOrThrow68;
                kGMusic.isnew = cursorQuery.getInt(i65);
                columnIndexOrThrow68 = i65;
                int i66 = columnIndexOrThrow69;
                kGMusic.fullName = cursorQuery.getString(i66);
                columnIndexOrThrow69 = i66;
                int i67 = columnIndexOrThrow70;
                kGMusic.source = cursorQuery.getString(i67);
                columnIndexOrThrow70 = i67;
                int i68 = columnIndexOrThrow71;
                kGMusic.sourceType = cursorQuery.getString(i68);
                columnIndexOrThrow71 = i68;
                int i69 = columnIndexOrThrow72;
                kGMusic.srctype = cursorQuery.getInt(i69);
                columnIndexOrThrow72 = i69;
                int i70 = columnIndexOrThrow73;
                kGMusic.genreId = cursorQuery.getInt(i70);
                int i71 = columnIndexOrThrow74;
                kGMusic.albumMatchTime = cursorQuery.getLong(i71);
                int i72 = columnIndexOrThrow75;
                kGMusic.isInsertPlay = cursorQuery.getInt(i72);
                int i73 = columnIndexOrThrow76;
                kGMusic.charge = cursorQuery.getInt(i73);
                int i74 = columnIndexOrThrow77;
                kGMusic.behavior = cursorQuery.getString(i74);
                columnIndexOrThrow77 = i74;
                int i75 = columnIndexOrThrow78;
                kGMusic.module = cursorQuery.getString(i75);
                columnIndexOrThrow78 = i75;
                int i76 = columnIndexOrThrow79;
                kGMusic.songSource = cursorQuery.getInt(i76);
                columnIndexOrThrow79 = i76;
                int i77 = columnIndexOrThrow80;
                kGMusic.inList = cursorQuery.getInt(i77);
                columnIndexOrThrow80 = i77;
                int i78 = columnIndexOrThrow81;
                kGMusic.sourceMode = cursorQuery.getInt(i78);
                columnIndexOrThrow81 = i78;
                int i79 = columnIndexOrThrow82;
                kGMusic.musicFeeStatus = cursorQuery.getInt(i79);
                columnIndexOrThrow82 = i79;
                int i80 = columnIndexOrThrow83;
                kGMusic.musicFeeType = cursorQuery.getString(i80);
                columnIndexOrThrow83 = i80;
                int i81 = columnIndexOrThrow84;
                kGMusic.failProcess = cursorQuery.getInt(i81);
                columnIndexOrThrow84 = i81;
                int i82 = columnIndexOrThrow85;
                kGMusic.payType = cursorQuery.getInt(i82);
                int i83 = columnIndexOrThrow86;
                kGMusic.updateFeeStatusTime = cursorQuery.getLong(i83);
                int i84 = columnIndexOrThrow87;
                kGMusic.localMusicFeeId = cursorQuery.getLong(i84);
                int i85 = columnIndexOrThrow88;
                kGMusic.oldCpy = cursorQuery.getInt(i85);
                int i86 = columnIndexOrThrow89;
                if (cursorQuery.getInt(i86) != 0) {
                    i2 = i82;
                    z = true;
                } else {
                    i2 = i82;
                    z = false;
                }
                kGMusic.isFileDownloaded = z;
                int i87 = columnIndexOrThrow90;
                columnIndexOrThrow90 = i87;
                kGMusic.isMusicCloudFile = cursorQuery.getInt(i87) != 0;
                int i88 = columnIndexOrThrow91;
                kGMusic.mDownloadStatus = cursorQuery.getInt(i88);
                int i89 = columnIndexOrThrow92;
                if (cursorQuery.getInt(i89) != 0) {
                    columnIndexOrThrow91 = i88;
                    z2 = true;
                } else {
                    columnIndexOrThrow91 = i88;
                    z2 = false;
                }
                kGMusic.isPlayMusicCloud = z2;
                columnIndexOrThrow92 = i89;
                int i90 = columnIndexOrThrow93;
                kGMusic.tag = cursorQuery.getInt(i90);
                columnIndexOrThrow93 = i90;
                int i91 = columnIndexOrThrow94;
                kGMusic.publishYear = cursorQuery.getString(i91);
                int i92 = columnIndexOrThrow95;
                kGMusic.publishYearMatchTime = cursorQuery.getLong(i92);
                int i93 = columnIndexOrThrow96;
                kGMusic.language = cursorQuery.getString(i93);
                int i94 = columnIndexOrThrow97;
                kGMusic.languageMatchTime = cursorQuery.getLong(i94);
                int i95 = columnIndexOrThrow98;
                kGMusic.isUserSetLanguage = cursorQuery.getInt(i95) != 0;
                int i96 = columnIndexOrThrow99;
                if (cursorQuery.getInt(i96) != 0) {
                    i3 = i92;
                    z3 = true;
                } else {
                    i3 = i92;
                    z3 = false;
                }
                kGMusic.isUserSetPublishYear = z3;
                int i97 = columnIndexOrThrow100;
                kGMusic.setAuthorId(cursorQuery.getInt(i97));
                columnIndexOrThrow100 = i97;
                int i98 = columnIndexOrThrow101;
                kGMusic.setSpecialId(cursorQuery.getInt(i98));
                columnIndexOrThrow101 = i98;
                int i99 = columnIndexOrThrow102;
                kGMusic.setRankId(cursorQuery.getInt(i99));
                columnIndexOrThrow102 = i99;
                int i100 = columnIndexOrThrow103;
                kGMusic.setTopic(cursorQuery.getString(i100));
                columnIndexOrThrow103 = i100;
                int i101 = columnIndexOrThrow104;
                kGMusic.setSongType(cursorQuery.getString(i101));
                int i102 = columnIndexOrThrow105;
                if (cursorQuery.getInt(i102) != 0) {
                    columnIndexOrThrow104 = i101;
                    z4 = true;
                } else {
                    columnIndexOrThrow104 = i101;
                    z4 = false;
                }
                kGMusic.setFromLocalMusic(z4);
                int i103 = columnIndexOrThrow106;
                columnIndexOrThrow106 = i103;
                kGMusic.setUserPlay(cursorQuery.getInt(i103) != 0);
                columnIndexOrThrow105 = i102;
                int i104 = columnIndexOrThrow107;
                kGMusic.setAudioType(cursorQuery.getInt(i104));
                columnIndexOrThrow107 = i104;
                int i105 = columnIndexOrThrow108;
                kGMusic.setSort(cursorQuery.getInt(i105));
                columnIndexOrThrow108 = i105;
                int i106 = columnIndexOrThrow109;
                kGMusic.setAudioIndex(cursorQuery.getInt(i106));
                columnIndexOrThrow109 = i106;
                int i107 = columnIndexOrThrow110;
                kGMusic.setFlag(cursorQuery.getInt(i107));
                columnIndexOrThrow110 = i107;
                int i108 = columnIndexOrThrow111;
                kGMusic.setUgcReviewed(cursorQuery.getInt(i108));
                columnIndexOrThrow111 = i108;
                int i109 = columnIndexOrThrow112;
                kGMusic.setQualityFeeSource(cursorQuery.getInt(i109));
                int i110 = columnIndexOrThrow113;
                columnIndexOrThrow113 = i110;
                kGMusic.setFromMyAsset(cursorQuery.getInt(i110) != 0);
                columnIndexOrThrow112 = i109;
                int i111 = columnIndexOrThrow114;
                kGMusic.setFileEncryptType(cursorQuery.getInt(i111));
                int i112 = columnIndexOrThrow115;
                if (cursorQuery.getInt(i112) != 0) {
                    columnIndexOrThrow114 = i111;
                    z5 = true;
                } else {
                    columnIndexOrThrow114 = i111;
                    z5 = false;
                }
                kGMusic.setIsLocalEncryptUpgradeMP3(z5);
                columnIndexOrThrow115 = i112;
                int i113 = columnIndexOrThrow116;
                kGMusic.setMaskOfForceDownload(cursorQuery.getInt(i113));
                columnIndexOrThrow116 = i113;
                int i114 = columnIndexOrThrow117;
                kGMusic.setGuessYouLikeMark(cursorQuery.getInt(i114));
                columnIndexOrThrow117 = i114;
                int i115 = columnIndexOrThrow118;
                kGMusic.setGuessYouLikeBiString(cursorQuery.getString(i115));
                columnIndexOrThrow118 = i115;
                int i116 = columnIndexOrThrow119;
                kGMusic.setBrief(cursorQuery.getString(i116));
                arrayList2.add(kGMusic);
                columnIndexOrThrow119 = i116;
                arrayList = arrayList2;
                columnIndexOrThrow = i8;
                i5 = i7;
                columnIndexOrThrow18 = i12;
                columnIndexOrThrow19 = i13;
                columnIndexOrThrow20 = i14;
                columnIndexOrThrow21 = i15;
                columnIndexOrThrow22 = i16;
                columnIndexOrThrow23 = i17;
                columnIndexOrThrow24 = i18;
                columnIndexOrThrow28 = i23;
                columnIndexOrThrow29 = i24;
                columnIndexOrThrow30 = i25;
                columnIndexOrThrow31 = i26;
                columnIndexOrThrow48 = i45;
                columnIndexOrThrow52 = i49;
                columnIndexOrThrow53 = i50;
                columnIndexOrThrow54 = i51;
                columnIndexOrThrow57 = i54;
                columnIndexOrThrow59 = i56;
                columnIndexOrThrow73 = i70;
                columnIndexOrThrow74 = i71;
                columnIndexOrThrow75 = i72;
                columnIndexOrThrow76 = i73;
                columnIndexOrThrow86 = i83;
                columnIndexOrThrow89 = i86;
                columnIndexOrThrow97 = i94;
                columnIndexOrThrow12 = i6;
                columnIndexOrThrow49 = i46;
                columnIndexOrThrow13 = i22;
                columnIndexOrThrow27 = i21;
                columnIndexOrThrow34 = i31;
                columnIndexOrThrow35 = i32;
                columnIndexOrThrow36 = i33;
                columnIndexOrThrow38 = i35;
                columnIndexOrThrow40 = i37;
                columnIndexOrThrow44 = i41;
                columnIndexOrThrow45 = i42;
                columnIndexOrThrow46 = i43;
                int i117 = i3;
                columnIndexOrThrow98 = i95;
                columnIndexOrThrow2 = i27;
                columnIndexOrThrow37 = i34;
                columnIndexOrThrow39 = i36;
                columnIndexOrThrow41 = i38;
                columnIndexOrThrow42 = i39;
                columnIndexOrThrow43 = i40;
                columnIndexOrThrow51 = i48;
                columnIndexOrThrow55 = i52;
                columnIndexOrThrow56 = i53;
                columnIndexOrThrow58 = i55;
                columnIndexOrThrow60 = i57;
                columnIndexOrThrow85 = i2;
                columnIndexOrThrow88 = i85;
                columnIndexOrThrow96 = i93;
                columnIndexOrThrow99 = i96;
                columnIndexOrThrow3 = i29;
                columnIndexOrThrow32 = i28;
                columnIndexOrThrow33 = i30;
                columnIndexOrThrow47 = i44;
                columnIndexOrThrow50 = i47;
                columnIndexOrThrow87 = i84;
                columnIndexOrThrow94 = i91;
                columnIndexOrThrow95 = i117;
            }
            ArrayList arrayList3 = arrayList;
            cursorQuery.close();
            roomSQLiteQuery.release();
            return arrayList3;
        } catch (Throwable th2) {
            th = th2;
            cursorQuery.close();
            roomSQLiteQuery.release();
            throw th;
        }
    }

    @Override // e.c.a.g.a.d.f.c.a.g
    public List<KGMusic> r(List<String> list) throws Throwable {
        RoomSQLiteQuery roomSQLiteQuery;
        int columnIndexOrThrow;
        int columnIndexOrThrow2;
        int columnIndexOrThrow3;
        int columnIndexOrThrow4;
        int columnIndexOrThrow5;
        int columnIndexOrThrow6;
        int columnIndexOrThrow7;
        int columnIndexOrThrow8;
        int columnIndexOrThrow9;
        int columnIndexOrThrow10;
        int columnIndexOrThrow11;
        int columnIndexOrThrow12;
        int columnIndexOrThrow13;
        int columnIndexOrThrow14;
        int i2;
        boolean z;
        boolean z2;
        int i3;
        boolean z3;
        boolean z4;
        boolean z5;
        StringBuilder sbNewStringBuilder = StringUtil.newStringBuilder();
        sbNewStringBuilder.append("SELECT ");
        sbNewStringBuilder.append("*");
        sbNewStringBuilder.append(" FROM kugou_songs WHERE hashValue in (");
        int size = list.size();
        StringUtil.appendPlaceholders(sbNewStringBuilder, size);
        sbNewStringBuilder.append(") OR m4aHash in (");
        int size2 = list.size();
        StringUtil.appendPlaceholders(sbNewStringBuilder, size2);
        sbNewStringBuilder.append(") OR hash320 in (");
        int size3 = list.size();
        StringUtil.appendPlaceholders(sbNewStringBuilder, size3);
        sbNewStringBuilder.append(") OR sqHash in (");
        int size4 = list.size();
        StringUtil.appendPlaceholders(sbNewStringBuilder, size4);
        sbNewStringBuilder.append(")");
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire(sbNewStringBuilder.toString(), size + 0 + size2 + size3 + size4);
        int i4 = 1;
        for (String str : list) {
            if (str == null) {
                roomSQLiteQueryAcquire.bindNull(i4);
            } else {
                roomSQLiteQueryAcquire.bindString(i4, str);
            }
            i4++;
        }
        int i5 = size + 1;
        int i6 = i5;
        for (String str2 : list) {
            if (str2 == null) {
                roomSQLiteQueryAcquire.bindNull(i6);
            } else {
                roomSQLiteQueryAcquire.bindString(i6, str2);
            }
            i6++;
        }
        int i7 = i5 + size;
        int i8 = i7;
        for (String str3 : list) {
            if (str3 == null) {
                roomSQLiteQueryAcquire.bindNull(i8);
            } else {
                roomSQLiteQueryAcquire.bindString(i8, str3);
            }
            i8++;
        }
        int i9 = i7 + size;
        for (String str4 : list) {
            if (str4 == null) {
                roomSQLiteQueryAcquire.bindNull(i9);
            } else {
                roomSQLiteQueryAcquire.bindString(i9, str4);
            }
            i9++;
        }
        this.c.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.c, roomSQLiteQueryAcquire, false, null);
        try {
            columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, DbOpenHelper.ID);
            columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
            columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "playListId");
            columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "playListName");
            columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "playListCreateListId");
            columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "playListCreateUserId");
            columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "playListCloudListId");
            columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "playListType");
            columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "playListSource");
            columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "musiclibId");
            columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "playListCreateUserName");
            columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "mPlayListPicPath");
            columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "isReset");
            columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "musicSource");
            roomSQLiteQuery = roomSQLiteQueryAcquire;
        } catch (Throwable th) {
            th = th;
            roomSQLiteQuery = roomSQLiteQueryAcquire;
        }
        try {
            int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "globalCollectionId");
            int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "audition");
            int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "gif_id");
            int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "fileOrderWeight");
            int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "collectTime");
            int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "channelCommentId");
            int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "extParams");
            int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "sid");
            int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "cur_remark");
            int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "remark");
            int columnIndexOrThrow25 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "display_name");
            int columnIndexOrThrow26 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "trackName");
            int columnIndexOrThrow27 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "albumName");
            int columnIndexOrThrow28 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "album_id");
            int columnIndexOrThrow29 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "feeAlbumId");
            int columnIndexOrThrow30 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "mixId");
            int columnIndexOrThrow31 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "oldMixId");
            int columnIndexOrThrow32 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "audioId");
            int columnIndexOrThrow33 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "track_id");
            int columnIndexOrThrow34 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "artistName");
            int columnIndexOrThrow35 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "genre");
            int columnIndexOrThrow36 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "artist_id");
            int columnIndexOrThrow37 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "size");
            int columnIndexOrThrow38 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "hashValue");
            int columnIndexOrThrow39 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "musicpath");
            int columnIndexOrThrow40 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "bitrate");
            int columnIndexOrThrow41 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "duration");
            int columnIndexOrThrow42 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "m4aHash");
            int columnIndexOrThrow43 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "m4aSize");
            int columnIndexOrThrow44 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "m4aUrl");
            int columnIndexOrThrow45 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "hash320");
            int columnIndexOrThrow46 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "size320");
            int columnIndexOrThrow47 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "sqHash");
            int columnIndexOrThrow48 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "sqSize");
            int columnIndexOrThrow49 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "mvHashValue");
            int columnIndexOrThrow50 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "mvTracks");
            int columnIndexOrThrow51 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "mvType");
            int columnIndexOrThrow52 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "mvMatchTime");
            int columnIndexOrThrow53 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "accompanimentHash");
            int columnIndexOrThrow54 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "accompanimentTime");
            int columnIndexOrThrow55 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "accompanimentId");
            int columnIndexOrThrow56 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "has_accompany");
            int columnIndexOrThrow57 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "sourceHash");
            int columnIndexOrThrow58 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "fileId");
            int columnIndexOrThrow59 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "musicLinkSource");
            int columnIndexOrThrow60 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "mSpecialOrAlbumName");
            int columnIndexOrThrow61 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "musicLinkExtInfo");
            int columnIndexOrThrow62 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "hashType");
            int columnIndexOrThrow63 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "imgUrl");
            int columnIndexOrThrow64 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "sk");
            int columnIndexOrThrow65 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "isExclusivePublish");
            int columnIndexOrThrow66 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "extname");
            int columnIndexOrThrow67 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "feeType");
            int columnIndexOrThrow68 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "isnew");
            int columnIndexOrThrow69 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "fullName");
            int columnIndexOrThrow70 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "source");
            int columnIndexOrThrow71 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "sourceType");
            int columnIndexOrThrow72 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "srctype");
            int columnIndexOrThrow73 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "genreId");
            int columnIndexOrThrow74 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "albumMatchTime");
            int columnIndexOrThrow75 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "isInsertPlay");
            int columnIndexOrThrow76 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "charge");
            int columnIndexOrThrow77 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "behavior");
            int columnIndexOrThrow78 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "module");
            int columnIndexOrThrow79 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "songSource");
            int columnIndexOrThrow80 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "inList");
            int columnIndexOrThrow81 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "sourceMode");
            int columnIndexOrThrow82 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "musicFeeStatus");
            int columnIndexOrThrow83 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "musicFeeType");
            int columnIndexOrThrow84 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "failProcess");
            int columnIndexOrThrow85 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "payType");
            int columnIndexOrThrow86 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "updateFeeStatusTime");
            int columnIndexOrThrow87 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "localMusicFeeId");
            int columnIndexOrThrow88 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "oldCpy");
            int columnIndexOrThrow89 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "isFileDownloaded");
            int columnIndexOrThrow90 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "isMusicCloudFile");
            int columnIndexOrThrow91 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "mDownloadStatus");
            int columnIndexOrThrow92 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "isPlayMusicCloud");
            int columnIndexOrThrow93 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "tag");
            int columnIndexOrThrow94 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "publishYear");
            int columnIndexOrThrow95 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "publishYearMatchTime");
            int columnIndexOrThrow96 = CursorUtil.getColumnIndexOrThrow(cursorQuery, KrcLoader.TAG_LANGUAGE);
            int columnIndexOrThrow97 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "languageMatchTime");
            int columnIndexOrThrow98 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "isUserSetLanguage");
            int columnIndexOrThrow99 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "isUserSetPublishYear");
            int columnIndexOrThrow100 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "authorId");
            int columnIndexOrThrow101 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "specialId");
            int columnIndexOrThrow102 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "rankId");
            int columnIndexOrThrow103 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "topic");
            int columnIndexOrThrow104 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "songType");
            int columnIndexOrThrow105 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "fromLocalMusic");
            int columnIndexOrThrow106 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "isUserPlay");
            int columnIndexOrThrow107 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "audioType");
            int columnIndexOrThrow108 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "sort");
            int columnIndexOrThrow109 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "audioIndex");
            int columnIndexOrThrow110 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "mFlag");
            int columnIndexOrThrow111 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "ugcReviewed");
            int columnIndexOrThrow112 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "qualityFeeSource");
            int columnIndexOrThrow113 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "isFromMyAsset");
            int columnIndexOrThrow114 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "fileEncryptType");
            int columnIndexOrThrow115 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "isLocalEncryptUpgradeMP3");
            int columnIndexOrThrow116 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "maskOfForceDownload");
            int columnIndexOrThrow117 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "guessYouLikeMark");
            int columnIndexOrThrow118 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "guessYouLikeBiString");
            int columnIndexOrThrow119 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "brief");
            int i10 = columnIndexOrThrow14;
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                KGMusic kGMusic = new KGMusic();
                ArrayList arrayList2 = arrayList;
                int i11 = columnIndexOrThrow12;
                kGMusic.dbId = cursorQuery.getLong(columnIndexOrThrow);
                kGMusic.id = cursorQuery.getLong(columnIndexOrThrow2);
                kGMusic.playListId = cursorQuery.getInt(columnIndexOrThrow3);
                kGMusic.playListName = cursorQuery.getString(columnIndexOrThrow4);
                kGMusic.playListCreateListId = cursorQuery.getInt(columnIndexOrThrow5);
                kGMusic.playListCreateUserId = cursorQuery.getLong(columnIndexOrThrow6);
                kGMusic.playListCloudListId = cursorQuery.getInt(columnIndexOrThrow7);
                kGMusic.playListType = cursorQuery.getInt(columnIndexOrThrow8);
                kGMusic.playListSource = cursorQuery.getInt(columnIndexOrThrow9);
                kGMusic.musiclibId = cursorQuery.getInt(columnIndexOrThrow10);
                kGMusic.playListCreateUserName = cursorQuery.getString(columnIndexOrThrow11);
                kGMusic.mPlayListPicPath = cursorQuery.getString(i11);
                kGMusic.isReset = cursorQuery.getInt(columnIndexOrThrow13) != 0;
                int i12 = i10;
                int i13 = columnIndexOrThrow;
                kGMusic.musicSource = cursorQuery.getInt(i12);
                int i14 = columnIndexOrThrow15;
                kGMusic.setGlobalCollectionId(cursorQuery.getString(i14));
                columnIndexOrThrow15 = i14;
                int i15 = columnIndexOrThrow16;
                kGMusic.setAudition(cursorQuery.getInt(i15));
                columnIndexOrThrow16 = i15;
                int i16 = columnIndexOrThrow17;
                kGMusic.setGif_id(cursorQuery.getInt(i16));
                columnIndexOrThrow17 = i16;
                int i17 = columnIndexOrThrow18;
                kGMusic.fileOrderWeight = cursorQuery.getInt(i17);
                int i18 = columnIndexOrThrow19;
                kGMusic.collectTime = cursorQuery.getLong(i18);
                int i19 = columnIndexOrThrow20;
                kGMusic.channelCommentId = cursorQuery.getString(i19);
                int i20 = columnIndexOrThrow21;
                kGMusic.extParams = cursorQuery.getString(i20);
                int i21 = columnIndexOrThrow22;
                kGMusic.sid = cursorQuery.getLong(i21);
                int i22 = columnIndexOrThrow23;
                kGMusic.curMark = cursorQuery.getString(i22);
                int i23 = columnIndexOrThrow24;
                kGMusic.remark = cursorQuery.getString(i23);
                int i24 = columnIndexOrThrow25;
                kGMusic.displayName = cursorQuery.getString(i24);
                columnIndexOrThrow25 = i24;
                int i25 = columnIndexOrThrow26;
                kGMusic.trackName = cursorQuery.getString(i25);
                columnIndexOrThrow26 = i25;
                int i26 = columnIndexOrThrow27;
                kGMusic.albumName = cursorQuery.getString(i26);
                int i27 = columnIndexOrThrow13;
                int i28 = columnIndexOrThrow28;
                kGMusic.albumID = cursorQuery.getLong(i28);
                int i29 = columnIndexOrThrow29;
                kGMusic.feeAlbumId = cursorQuery.getString(i29);
                int i30 = columnIndexOrThrow30;
                kGMusic.mixId = cursorQuery.getLong(i30);
                int i31 = columnIndexOrThrow31;
                kGMusic.oldMixId = cursorQuery.getLong(i31);
                int i32 = columnIndexOrThrow32;
                int i33 = columnIndexOrThrow2;
                kGMusic.audioId = cursorQuery.getLong(i32);
                int i34 = columnIndexOrThrow33;
                kGMusic.trackID = cursorQuery.getLong(i34);
                int i35 = columnIndexOrThrow34;
                kGMusic.artistName = cursorQuery.getString(i35);
                int i36 = columnIndexOrThrow35;
                kGMusic.genre = cursorQuery.getString(i36);
                int i37 = columnIndexOrThrow36;
                kGMusic.artistID = cursorQuery.getLong(i37);
                int i38 = columnIndexOrThrow37;
                kGMusic.size = cursorQuery.getLong(i38);
                int i39 = columnIndexOrThrow38;
                kGMusic.hashValue = cursorQuery.getString(i39);
                int i40 = columnIndexOrThrow39;
                kGMusic.musicpath = cursorQuery.getString(i40);
                int i41 = columnIndexOrThrow40;
                kGMusic.bitrate = cursorQuery.getInt(i41);
                int i42 = columnIndexOrThrow41;
                kGMusic.duration = cursorQuery.getLong(i42);
                int i43 = columnIndexOrThrow42;
                kGMusic.m4aHash = cursorQuery.getString(i43);
                int i44 = columnIndexOrThrow43;
                kGMusic.m4aSize = cursorQuery.getLong(i44);
                int i45 = columnIndexOrThrow44;
                kGMusic.m4aUrl = cursorQuery.getString(i45);
                int i46 = columnIndexOrThrow45;
                kGMusic.hash320 = cursorQuery.getString(i46);
                int i47 = columnIndexOrThrow46;
                kGMusic.size320 = cursorQuery.getLong(i47);
                int i48 = columnIndexOrThrow47;
                kGMusic.sqHash = cursorQuery.getString(i48);
                int i49 = columnIndexOrThrow48;
                kGMusic.sqSize = cursorQuery.getLong(i49);
                int i50 = columnIndexOrThrow49;
                kGMusic.mvHashValue = cursorQuery.getString(i50);
                int i51 = columnIndexOrThrow50;
                kGMusic.mvTracks = cursorQuery.getInt(i51);
                int i52 = columnIndexOrThrow51;
                kGMusic.mvType = cursorQuery.getInt(i52);
                int i53 = columnIndexOrThrow52;
                kGMusic.mvMatchTime = cursorQuery.getLong(i53);
                int i54 = columnIndexOrThrow53;
                kGMusic.accompanimentHash = cursorQuery.getString(i54);
                int i55 = columnIndexOrThrow54;
                kGMusic.accompanimentTime = cursorQuery.getLong(i55);
                int i56 = columnIndexOrThrow55;
                kGMusic.accompanimentId = cursorQuery.getInt(i56);
                int i57 = columnIndexOrThrow56;
                kGMusic.has_accompany = cursorQuery.getInt(i57);
                int i58 = columnIndexOrThrow57;
                kGMusic.sourceHash = cursorQuery.getString(i58);
                int i59 = columnIndexOrThrow58;
                kGMusic.fileId = cursorQuery.getLong(i59);
                int i60 = columnIndexOrThrow59;
                kGMusic.musicLinkSource = cursorQuery.getInt(i60);
                int i61 = columnIndexOrThrow60;
                kGMusic.mSpecialOrAlbumName = cursorQuery.getString(i61);
                int i62 = columnIndexOrThrow61;
                kGMusic.musicLinkExtInfo = cursorQuery.getString(i62);
                columnIndexOrThrow61 = i62;
                int i63 = columnIndexOrThrow62;
                kGMusic.hashType = cursorQuery.getInt(i63);
                columnIndexOrThrow62 = i63;
                int i64 = columnIndexOrThrow63;
                kGMusic.imgUrl = cursorQuery.getString(i64);
                columnIndexOrThrow63 = i64;
                int i65 = columnIndexOrThrow64;
                kGMusic.sk = cursorQuery.getString(i65);
                int i66 = columnIndexOrThrow65;
                columnIndexOrThrow65 = i66;
                kGMusic.isExclusivePublish = cursorQuery.getInt(i66) != 0;
                columnIndexOrThrow64 = i65;
                int i67 = columnIndexOrThrow66;
                kGMusic.extname = cursorQuery.getString(i67);
                columnIndexOrThrow66 = i67;
                int i68 = columnIndexOrThrow67;
                kGMusic.feeType = cursorQuery.getInt(i68);
                columnIndexOrThrow67 = i68;
                int i69 = columnIndexOrThrow68;
                kGMusic.isnew = cursorQuery.getInt(i69);
                columnIndexOrThrow68 = i69;
                int i70 = columnIndexOrThrow69;
                kGMusic.fullName = cursorQuery.getString(i70);
                columnIndexOrThrow69 = i70;
                int i71 = columnIndexOrThrow70;
                kGMusic.source = cursorQuery.getString(i71);
                columnIndexOrThrow70 = i71;
                int i72 = columnIndexOrThrow71;
                kGMusic.sourceType = cursorQuery.getString(i72);
                columnIndexOrThrow71 = i72;
                int i73 = columnIndexOrThrow72;
                kGMusic.srctype = cursorQuery.getInt(i73);
                columnIndexOrThrow72 = i73;
                int i74 = columnIndexOrThrow73;
                kGMusic.genreId = cursorQuery.getInt(i74);
                int i75 = columnIndexOrThrow74;
                kGMusic.albumMatchTime = cursorQuery.getLong(i75);
                int i76 = columnIndexOrThrow75;
                kGMusic.isInsertPlay = cursorQuery.getInt(i76);
                int i77 = columnIndexOrThrow76;
                kGMusic.charge = cursorQuery.getInt(i77);
                int i78 = columnIndexOrThrow77;
                kGMusic.behavior = cursorQuery.getString(i78);
                columnIndexOrThrow77 = i78;
                int i79 = columnIndexOrThrow78;
                kGMusic.module = cursorQuery.getString(i79);
                columnIndexOrThrow78 = i79;
                int i80 = columnIndexOrThrow79;
                kGMusic.songSource = cursorQuery.getInt(i80);
                columnIndexOrThrow79 = i80;
                int i81 = columnIndexOrThrow80;
                kGMusic.inList = cursorQuery.getInt(i81);
                columnIndexOrThrow80 = i81;
                int i82 = columnIndexOrThrow81;
                kGMusic.sourceMode = cursorQuery.getInt(i82);
                columnIndexOrThrow81 = i82;
                int i83 = columnIndexOrThrow82;
                kGMusic.musicFeeStatus = cursorQuery.getInt(i83);
                columnIndexOrThrow82 = i83;
                int i84 = columnIndexOrThrow83;
                kGMusic.musicFeeType = cursorQuery.getString(i84);
                columnIndexOrThrow83 = i84;
                int i85 = columnIndexOrThrow84;
                kGMusic.failProcess = cursorQuery.getInt(i85);
                columnIndexOrThrow84 = i85;
                int i86 = columnIndexOrThrow85;
                kGMusic.payType = cursorQuery.getInt(i86);
                int i87 = columnIndexOrThrow86;
                kGMusic.updateFeeStatusTime = cursorQuery.getLong(i87);
                int i88 = columnIndexOrThrow87;
                kGMusic.localMusicFeeId = cursorQuery.getLong(i88);
                int i89 = columnIndexOrThrow88;
                kGMusic.oldCpy = cursorQuery.getInt(i89);
                int i90 = columnIndexOrThrow89;
                if (cursorQuery.getInt(i90) != 0) {
                    i2 = i86;
                    z = true;
                } else {
                    i2 = i86;
                    z = false;
                }
                kGMusic.isFileDownloaded = z;
                int i91 = columnIndexOrThrow90;
                columnIndexOrThrow90 = i91;
                kGMusic.isMusicCloudFile = cursorQuery.getInt(i91) != 0;
                int i92 = columnIndexOrThrow91;
                kGMusic.mDownloadStatus = cursorQuery.getInt(i92);
                int i93 = columnIndexOrThrow92;
                if (cursorQuery.getInt(i93) != 0) {
                    columnIndexOrThrow91 = i92;
                    z2 = true;
                } else {
                    columnIndexOrThrow91 = i92;
                    z2 = false;
                }
                kGMusic.isPlayMusicCloud = z2;
                columnIndexOrThrow92 = i93;
                int i94 = columnIndexOrThrow93;
                kGMusic.tag = cursorQuery.getInt(i94);
                columnIndexOrThrow93 = i94;
                int i95 = columnIndexOrThrow94;
                kGMusic.publishYear = cursorQuery.getString(i95);
                int i96 = columnIndexOrThrow95;
                kGMusic.publishYearMatchTime = cursorQuery.getLong(i96);
                int i97 = columnIndexOrThrow96;
                kGMusic.language = cursorQuery.getString(i97);
                int i98 = columnIndexOrThrow97;
                kGMusic.languageMatchTime = cursorQuery.getLong(i98);
                int i99 = columnIndexOrThrow98;
                kGMusic.isUserSetLanguage = cursorQuery.getInt(i99) != 0;
                int i100 = columnIndexOrThrow99;
                if (cursorQuery.getInt(i100) != 0) {
                    i3 = i96;
                    z3 = true;
                } else {
                    i3 = i96;
                    z3 = false;
                }
                kGMusic.isUserSetPublishYear = z3;
                int i101 = columnIndexOrThrow100;
                kGMusic.setAuthorId(cursorQuery.getInt(i101));
                columnIndexOrThrow100 = i101;
                int i102 = columnIndexOrThrow101;
                kGMusic.setSpecialId(cursorQuery.getInt(i102));
                columnIndexOrThrow101 = i102;
                int i103 = columnIndexOrThrow102;
                kGMusic.setRankId(cursorQuery.getInt(i103));
                columnIndexOrThrow102 = i103;
                int i104 = columnIndexOrThrow103;
                kGMusic.setTopic(cursorQuery.getString(i104));
                columnIndexOrThrow103 = i104;
                int i105 = columnIndexOrThrow104;
                kGMusic.setSongType(cursorQuery.getString(i105));
                int i106 = columnIndexOrThrow105;
                if (cursorQuery.getInt(i106) != 0) {
                    columnIndexOrThrow104 = i105;
                    z4 = true;
                } else {
                    columnIndexOrThrow104 = i105;
                    z4 = false;
                }
                kGMusic.setFromLocalMusic(z4);
                int i107 = columnIndexOrThrow106;
                columnIndexOrThrow106 = i107;
                kGMusic.setUserPlay(cursorQuery.getInt(i107) != 0);
                columnIndexOrThrow105 = i106;
                int i108 = columnIndexOrThrow107;
                kGMusic.setAudioType(cursorQuery.getInt(i108));
                columnIndexOrThrow107 = i108;
                int i109 = columnIndexOrThrow108;
                kGMusic.setSort(cursorQuery.getInt(i109));
                columnIndexOrThrow108 = i109;
                int i110 = columnIndexOrThrow109;
                kGMusic.setAudioIndex(cursorQuery.getInt(i110));
                columnIndexOrThrow109 = i110;
                int i111 = columnIndexOrThrow110;
                kGMusic.setFlag(cursorQuery.getInt(i111));
                columnIndexOrThrow110 = i111;
                int i112 = columnIndexOrThrow111;
                kGMusic.setUgcReviewed(cursorQuery.getInt(i112));
                columnIndexOrThrow111 = i112;
                int i113 = columnIndexOrThrow112;
                kGMusic.setQualityFeeSource(cursorQuery.getInt(i113));
                int i114 = columnIndexOrThrow113;
                columnIndexOrThrow113 = i114;
                kGMusic.setFromMyAsset(cursorQuery.getInt(i114) != 0);
                columnIndexOrThrow112 = i113;
                int i115 = columnIndexOrThrow114;
                kGMusic.setFileEncryptType(cursorQuery.getInt(i115));
                int i116 = columnIndexOrThrow115;
                if (cursorQuery.getInt(i116) != 0) {
                    columnIndexOrThrow114 = i115;
                    z5 = true;
                } else {
                    columnIndexOrThrow114 = i115;
                    z5 = false;
                }
                kGMusic.setIsLocalEncryptUpgradeMP3(z5);
                columnIndexOrThrow115 = i116;
                int i117 = columnIndexOrThrow116;
                kGMusic.setMaskOfForceDownload(cursorQuery.getInt(i117));
                columnIndexOrThrow116 = i117;
                int i118 = columnIndexOrThrow117;
                kGMusic.setGuessYouLikeMark(cursorQuery.getInt(i118));
                columnIndexOrThrow117 = i118;
                int i119 = columnIndexOrThrow118;
                kGMusic.setGuessYouLikeBiString(cursorQuery.getString(i119));
                columnIndexOrThrow118 = i119;
                int i120 = columnIndexOrThrow119;
                kGMusic.setBrief(cursorQuery.getString(i120));
                arrayList2.add(kGMusic);
                columnIndexOrThrow119 = i120;
                arrayList = arrayList2;
                columnIndexOrThrow = i13;
                i10 = i12;
                columnIndexOrThrow18 = i17;
                columnIndexOrThrow19 = i18;
                columnIndexOrThrow20 = i19;
                columnIndexOrThrow21 = i20;
                columnIndexOrThrow22 = i21;
                columnIndexOrThrow23 = i22;
                columnIndexOrThrow24 = i23;
                columnIndexOrThrow28 = i28;
                columnIndexOrThrow29 = i29;
                columnIndexOrThrow30 = i30;
                columnIndexOrThrow31 = i31;
                columnIndexOrThrow47 = i48;
                columnIndexOrThrow50 = i51;
                columnIndexOrThrow87 = i88;
                columnIndexOrThrow94 = i95;
                columnIndexOrThrow95 = i3;
                columnIndexOrThrow98 = i99;
                columnIndexOrThrow13 = i27;
                columnIndexOrThrow27 = i26;
                columnIndexOrThrow34 = i35;
                columnIndexOrThrow35 = i36;
                columnIndexOrThrow36 = i37;
                columnIndexOrThrow38 = i39;
                columnIndexOrThrow40 = i41;
                columnIndexOrThrow44 = i45;
                columnIndexOrThrow45 = i46;
                columnIndexOrThrow46 = i47;
                columnIndexOrThrow49 = i50;
                columnIndexOrThrow52 = i53;
                columnIndexOrThrow53 = i54;
                columnIndexOrThrow54 = i55;
                columnIndexOrThrow57 = i58;
                columnIndexOrThrow59 = i60;
                columnIndexOrThrow73 = i74;
                columnIndexOrThrow74 = i75;
                columnIndexOrThrow75 = i76;
                columnIndexOrThrow76 = i77;
                columnIndexOrThrow86 = i87;
                columnIndexOrThrow89 = i90;
                columnIndexOrThrow97 = i98;
                columnIndexOrThrow12 = i11;
                columnIndexOrThrow99 = i100;
                columnIndexOrThrow2 = i33;
                columnIndexOrThrow32 = i32;
                columnIndexOrThrow33 = i34;
                columnIndexOrThrow37 = i38;
                columnIndexOrThrow39 = i40;
                columnIndexOrThrow41 = i42;
                columnIndexOrThrow42 = i43;
                columnIndexOrThrow43 = i44;
                columnIndexOrThrow48 = i49;
                columnIndexOrThrow51 = i52;
                columnIndexOrThrow55 = i56;
                columnIndexOrThrow56 = i57;
                columnIndexOrThrow58 = i59;
                columnIndexOrThrow60 = i61;
                columnIndexOrThrow85 = i2;
                columnIndexOrThrow88 = i89;
                columnIndexOrThrow96 = i97;
            }
            ArrayList arrayList3 = arrayList;
            cursorQuery.close();
            roomSQLiteQuery.release();
            return arrayList3;
        } catch (Throwable th2) {
            th = th2;
            cursorQuery.close();
            roomSQLiteQuery.release();
            throw th;
        }
    }

    @Override // e.c.a.g.a.d.f.c.a.g
    public int s(List<? extends KGMusic> list) {
        this.c.assertNotSuspendingTransaction();
        this.c.beginTransaction();
        try {
            int iHandleMultiple = this.f395e.handleMultiple(list) + 0;
            this.c.setTransactionSuccessful();
            return iHandleMultiple;
        } finally {
            this.c.endTransaction();
        }
    }

    @Override // e.c.a.g.a.d.f.a
    /* JADX INFO: renamed from: t, reason: merged with bridge method [inline-methods] */
    public long f(KGMusic kGMusic) {
        this.c.assertNotSuspendingTransaction();
        this.c.beginTransaction();
        try {
            long jInsertAndReturnId = this.f394d.insertAndReturnId(kGMusic);
            this.c.setTransactionSuccessful();
            return jInsertAndReturnId;
        } finally {
            this.c.endTransaction();
        }
    }

    @Override // e.c.a.g.a.d.f.a
    /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
    public int g(KGMusic... kGMusicArr) {
        this.c.assertNotSuspendingTransaction();
        this.c.beginTransaction();
        try {
            int iHandleMultiple = this.f395e.handleMultiple(kGMusicArr) + 0;
            this.c.setTransactionSuccessful();
            return iHandleMultiple;
        } finally {
            this.c.endTransaction();
        }
    }
}
