package e.c.a.g.a.o.c;

import androidx.core.app.NotificationCompat;
import com.google.gson.annotations.SerializedName;
import com.kugou.common.apm.sdk.ApmDataKey;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    @SerializedName("zone")
    public h a;

    @SerializedName("category")
    public List<Object> b;

    @SerializedName("module")
    public List<b> c;

    /* JADX INFO: renamed from: e.c.a.g.a.o.c.a$a, reason: collision with other inner class name */
    public static class C0171a {

        @SerializedName("resource_icon_small")
        public String a;

        @SerializedName("bg_video")
        public String b;

        @SerializedName("bg_image")
        public String c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @SerializedName("resource_source")
        public String f1124d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @SerializedName("singer_name")
        public String f1125e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        @SerializedName("lists")
        public List<Object> f1126f;
    }

    public static class b {

        @SerializedName("module_id")
        public int a;

        @SerializedName("module_name")
        public String b;

        @SerializedName("module_type")
        public int c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @SerializedName("is_more")
        public int f1127d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @SerializedName("style_type")
        public int f1128e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        @SerializedName("module_config")
        public c f1129f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @SerializedName("items")
        public List<d> f1130g;
    }

    public static class c {

        @SerializedName("module_name")
        public String a;

        @SerializedName("item_line")
        public int b;

        @SerializedName("item_count_line")
        public int c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @SerializedName("item_icon_shape")
        public int f1131d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @SerializedName("s_icon_show")
        public int f1132e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        @SerializedName("s_icon_big_count")
        public int f1133f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @SerializedName("title")
        public g f1134g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        @SerializedName("summary")
        public g f1135h;
    }

    public static class d {

        @SerializedName("resource_id")
        public String a;

        @SerializedName("resource_type")
        public int b;

        @SerializedName("resource_name")
        public String c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @SerializedName("resource_summary")
        public String f1136d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @SerializedName("resource_icon")
        public String f1137e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        @SerializedName("extend")
        public C0171a f1138f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @SerializedName(ApmDataKey.POSITION)
        public e f1139g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        @SerializedName("play_count")
        public int f1140h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        @SerializedName("song_count")
        public int f1141i;
    }

    public static class e {

        @SerializedName("left_top")
        public f a;

        @SerializedName("left_bottom")
        public f b;

        @SerializedName("right_top")
        public f c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @SerializedName("right_bottom")
        public f f1142d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @SerializedName("title")
        public g f1143e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        @SerializedName("summary")
        public g f1144f;
    }

    public static class f {

        @SerializedName("type")
        public int a;

        @SerializedName("field")
        public String b;
    }

    public static class g {

        @SerializedName(NotificationCompat.CATEGORY_STATUS)
        public int a;

        @SerializedName("line")
        public int b;
    }

    public static class h {

        @SerializedName("id")
        public int a;

        @SerializedName("type")
        public int b;

        @SerializedName("name")
        public String c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @SerializedName("summary")
        public String f1145d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @SerializedName("show_tab")
        public int f1146e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        @SerializedName("is_shortcut")
        public int f1147f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @SerializedName("shortcut_name")
        public String f1148g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        @SerializedName("shortcut_icon")
        public String f1149h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        @SerializedName("is_share")
        public int f1150i;

        @SerializedName("share_title")
        public String j;

        @SerializedName("share_icon")
        public String k;

        @SerializedName("share_summary")
        public String l;

        @SerializedName("head_icon")
        public String m;

        @SerializedName("show_head_icon")
        public int n;

        @SerializedName("is_comment")
        public int o;

        @SerializedName("comment_hot")
        public int p;

        @SerializedName("resource_type")
        public int q;

        @SerializedName("resource_id")
        public String r;

        @SerializedName("is_collect")
        public int s;

        @SerializedName("comment_source")
        public String t;

        @SerializedName("is_jump")
        public int u;
    }
}
