package e.c.a.g.a.d.x.t;

import android.text.TextUtils;
import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.FieldNamingStrategy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.kugou.android.watch.lite.base.player.serialize.SkipDefaultBooleanTypeAdapter;
import com.kugou.android.watch.lite.base.player.serialize.SkipDefaultIntTypeAdapter;
import com.kugou.android.watch.lite.base.player.serialize.SkipDefaultLongTypeAdapter;
import com.kugou.android.watch.lite.common.music.entity.KGMusicWrapper;
import e.c.a.g.a.s.g0;
import e.c.a.g.a.s.l0;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class d implements e.c.a.g.a.d.x.t.a {
    public final List<String> a = new ArrayList();
    public final Map<String, String> b = new HashMap(68);
    public final Gson c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Gson f617d;

    public class a implements ExclusionStrategy {
        public a() {
        }

        @Override // com.google.gson.ExclusionStrategy
        public boolean shouldSkipClass(Class<?> cls) {
            return false;
        }

        @Override // com.google.gson.ExclusionStrategy
        public boolean shouldSkipField(FieldAttributes fieldAttributes) {
            String name = fieldAttributes.getName();
            boolean zContains = d.this.a.contains(name);
            if (g0.a) {
                g0.b("QueueSerializeStrategyV2", "shouldSkipField Serialization:  name=" + name + "  skip=" + zContains);
            }
            return zContains;
        }
    }

    public class b implements FieldNamingStrategy {
        public b() {
        }

        @Override // com.google.gson.FieldNamingStrategy
        public String translateName(Field field) {
            String name = field.getName();
            String str = d.this.b.containsKey(name) ? d.this.b.get(name) : name;
            if (g0.a) {
                g0.b("QueueSerializeStrategyV2", "translateName:field.name=" + name + "  finalName=" + str);
            }
            return str;
        }
    }

    public class c implements FieldNamingStrategy {
        public c() {
        }

        @Override // com.google.gson.FieldNamingStrategy
        public String translateName(Field field) {
            String name = field.getName();
            return d.this.b.containsKey(name) ? d.this.b.get(name) : name;
        }
    }

    /* JADX INFO: renamed from: e.c.a.g.a.d.x.t.d$d, reason: collision with other inner class name */
    public class C0094d extends TypeToken<List<KGMusicWrapper>> {
        public C0094d(d dVar) {
        }
    }

    public d() {
        a aVar = new a();
        SkipDefaultIntTypeAdapter skipDefaultIntTypeAdapter = new SkipDefaultIntTypeAdapter();
        SkipDefaultLongTypeAdapter skipDefaultLongTypeAdapter = new SkipDefaultLongTypeAdapter();
        SkipDefaultBooleanTypeAdapter skipDefaultBooleanTypeAdapter = new SkipDefaultBooleanTypeAdapter();
        this.c = new GsonBuilder().setFieldNamingStrategy(new b()).addSerializationExclusionStrategy(aVar).addDeserializationExclusionStrategy(aVar).registerTypeAdapter(Integer.TYPE, skipDefaultIntTypeAdapter).registerTypeAdapter(Integer.class, skipDefaultIntTypeAdapter).registerTypeAdapter(Long.TYPE, skipDefaultLongTypeAdapter).registerTypeAdapter(Long.class, skipDefaultLongTypeAdapter).registerTypeAdapter(Boolean.TYPE, skipDefaultBooleanTypeAdapter).registerTypeAdapter(Boolean.class, skipDefaultBooleanTypeAdapter).create();
        this.f617d = new GsonBuilder().setFieldNamingStrategy(new c()).addSerializationExclusionStrategy(aVar).addDeserializationExclusionStrategy(aVar).create();
        b();
        c();
    }

    public final void a(String str, String str2) {
        this.b.put(str2, str);
    }

    public final void b() {
        this.a.add("curPosition");
        this.a.add("disposableStartMs");
        this.a.add("personFmClimaxEnd");
        this.a.add("personFmClimaxStart");
        this.a.add("guessYouLikeMark");
        this.a.add("nameType");
        this.a.add("extUniqueId");
        this.a.add("feeType");
        this.a.add("fileOrderWeight");
        this.a.add("genreId");
        this.a.add("gif_id");
        this.a.add("sourceMode");
        this.a.add("reportState");
        this.a.add("userSelQuality");
        this.a.add("carries");
    }

    public final void c() {
        a("a1", "constructType");
        a("a2", "haveChargOf");
        a("a3", "isCurSelectedSong");
        a("a4", "isDownLocalorCache");
        a("a5", "songtype");
        a("a6", "isKGFileExist");
        a("a7", "isNeedCheckQuality");
        a("a8", "mPagePath");
        a("a9", "musicWrapperCode");
        a("a10", "userSelQuality");
        a("a11", "needCheckListenPartPermission");
        a("a12", "isListenPart");
        a("a13", "reportState");
        a("b1", "albumID");
        a("b2", "audioId");
        a("b3", "albumName");
        a("b4", "albumname");
        a("b5", "behavior");
        a("b6", "duration");
        a("b7", "filehash");
        a("b8", "fileuserkey");
        a("b9", "maskOfForceDownload");
        a("b10", "musicTransParamEnenty");
        a("b11", "pay_block_tpl");
        a("b12", "musichash");
        a("b13", "p2pSource");
        a("b14", "qualitytype");
        a("b15", "updateFeeStatusTime");
        a("b16", "musicFeeType");
        a("b17", "failProcess");
        a("b18", "musicname");
        a("b19", "privilege");
        a("b20", "guessYouLikeBiString");
        a("b21", "musicLinkSource");
        a("b22", "artistName");
        a("b23", "trackName");
        a("b24", "mvHashValue");
        a("b25", "feeAlbumId");
        a("b26", "displayName");
        a("b27", "recSongInfo");
        a("b28", "singerInfos");
        a("b29", "sourceType");
        a("b30", "songSource");
        a("b31", "mvTracks");
        a("b32", "filesize");
        a("b33", "isCharge");
        a("b34", "has_accompany");
        a("b35", "hashValue");
        a("b36", "hashType");
        a("b37", "bitrate");
        a("c1", "personFmClimaxEnd");
        a("c2", "personFmClimaxStart");
        a("c3", "offset_hash");
        a("c4", "alg_path");
        a("c5", "predict_v");
        a("c6", "rec_desc");
        a("c7", "rec_desc2");
        a("c8", "similar_desc");
        a("c9", "similarity");
        a("c10", "have_listen_part");
        a("c11", "musicpackAdvance");
        a("c12", "end_byte");
        a("c13", "module_id");
        a("c14", "open_time");
        a("c15", "displayRate");
        a("c16", "pageCode");
    }

    @Override // e.c.a.g.a.d.x.t.a
    public List<KGMusicWrapper> fromJson(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                return (List) this.f617d.fromJson(str, new C0094d(this).getType());
            } catch (Exception e2) {
                e2.printStackTrace();
                if (g0.a) {
                    g0.b("QueueSerializeStrategyV2", "fromJson: e=" + e2);
                }
            }
        }
        return new ArrayList();
    }

    @Override // e.c.a.g.a.d.x.t.a
    public String toJson(List<KGMusicWrapper> list) {
        if (l0.g(list)) {
            return "";
        }
        try {
            return this.c.toJson(list);
        } catch (Exception e2) {
            e2.printStackTrace();
            if (!g0.a) {
                return "";
            }
            g0.b("QueueSerializeStrategyV2", "toJson: e=" + e2);
            return "";
        }
    }
}
