package androidx.core.view;

import android.content.ClipData;
import android.content.ClipDescription;
import android.net.Uri;
import android.os.Bundle;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.util.Preconditions;
import androidx.core.util.Predicate;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class ContentInfoCompat {
    public static final int FLAG_CONVERT_TO_PLAIN_TEXT = 1;
    public static final int SOURCE_APP = 0;
    public static final int SOURCE_CLIPBOARD = 1;
    public static final int SOURCE_DRAG_AND_DROP = 3;
    public static final int SOURCE_INPUT_METHOD = 2;

    @NonNull
    public final ClipData mClip;

    @Nullable
    public final Bundle mExtras;
    public final int mFlags;

    @Nullable
    public final Uri mLinkUri;
    public final int mSource;

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public @interface Flags {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public @interface Source {
    }

    public ContentInfoCompat(Builder builder) {
        this.mClip = (ClipData) Preconditions.checkNotNull(builder.mClip);
        this.mSource = Preconditions.checkArgumentInRange(builder.mSource, 0, 3, "source");
        this.mFlags = Preconditions.checkFlagsArgument(builder.mFlags, 1);
        this.mLinkUri = builder.mLinkUri;
        this.mExtras = builder.mExtras;
    }

    private static ClipData buildClipData(ClipDescription clipDescription, List<ClipData.Item> list) {
        ClipData clipData = new ClipData(new ClipDescription(clipDescription), list.get(0));
        for (int i2 = 1; i2 < list.size(); i2++) {
            clipData.addItem(list.get(i2));
        }
        return clipData;
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static String flagsToString(int i2) {
        return (i2 & 1) != 0 ? "FLAG_CONVERT_TO_PLAIN_TEXT" : String.valueOf(i2);
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static String sourceToString(int i2) {
        return i2 != 0 ? i2 != 1 ? i2 != 2 ? i2 != 3 ? String.valueOf(i2) : "SOURCE_DRAG_AND_DROP" : "SOURCE_INPUT_METHOD" : "SOURCE_CLIPBOARD" : "SOURCE_APP";
    }

    @NonNull
    public ClipData getClip() {
        return this.mClip;
    }

    @Nullable
    public Bundle getExtras() {
        return this.mExtras;
    }

    public int getFlags() {
        return this.mFlags;
    }

    @Nullable
    public Uri getLinkUri() {
        return this.mLinkUri;
    }

    public int getSource() {
        return this.mSource;
    }

    @NonNull
    public Pair<ContentInfoCompat, ContentInfoCompat> partition(@NonNull Predicate<ClipData.Item> predicate) {
        if (this.mClip.getItemCount() == 1) {
            boolean zTest = predicate.test(this.mClip.getItemAt(0));
            return Pair.create(zTest ? this : null, zTest ? null : this);
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (int i2 = 0; i2 < this.mClip.getItemCount(); i2++) {
            ClipData.Item itemAt = this.mClip.getItemAt(i2);
            if (predicate.test(itemAt)) {
                arrayList.add(itemAt);
            } else {
                arrayList2.add(itemAt);
            }
        }
        return arrayList.isEmpty() ? Pair.create(null, this) : arrayList2.isEmpty() ? Pair.create(this, null) : Pair.create(new Builder(this).setClip(buildClipData(this.mClip.getDescription(), arrayList)).build(), new Builder(this).setClip(buildClipData(this.mClip.getDescription(), arrayList2)).build());
    }

    @NonNull
    public String toString() {
        return "ContentInfoCompat{clip=" + this.mClip + ", source=" + sourceToString(this.mSource) + ", flags=" + flagsToString(this.mFlags) + ", linkUri=" + this.mLinkUri + ", extras=" + this.mExtras + "}";
    }

    public static final class Builder {

        @NonNull
        public ClipData mClip;

        @Nullable
        public Bundle mExtras;
        public int mFlags;

        @Nullable
        public Uri mLinkUri;
        public int mSource;

        public Builder(@NonNull ContentInfoCompat contentInfoCompat) {
            this.mClip = contentInfoCompat.mClip;
            this.mSource = contentInfoCompat.mSource;
            this.mFlags = contentInfoCompat.mFlags;
            this.mLinkUri = contentInfoCompat.mLinkUri;
            this.mExtras = contentInfoCompat.mExtras;
        }

        @NonNull
        public ContentInfoCompat build() {
            return new ContentInfoCompat(this);
        }

        @NonNull
        public Builder setClip(@NonNull ClipData clipData) {
            this.mClip = clipData;
            return this;
        }

        @NonNull
        public Builder setExtras(@Nullable Bundle bundle) {
            this.mExtras = bundle;
            return this;
        }

        @NonNull
        public Builder setFlags(int i2) {
            this.mFlags = i2;
            return this;
        }

        @NonNull
        public Builder setLinkUri(@Nullable Uri uri) {
            this.mLinkUri = uri;
            return this;
        }

        @NonNull
        public Builder setSource(int i2) {
            this.mSource = i2;
            return this;
        }

        public Builder(@NonNull ClipData clipData, int i2) {
            this.mClip = clipData;
            this.mSource = i2;
        }
    }
}
