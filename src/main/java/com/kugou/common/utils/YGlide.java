package com.kugou.common.utils;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import androidx.annotation.DrawableRes;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import androidx.fragment.app.Fragment;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.target.Target;

/* JADX INFO: loaded from: classes2.dex */
public class YGlide {
    private Activity mActivity;
    private Context mContext;
    private Fragment mFragment;

    public static abstract class Builder<T> {
        public final RequestBuilder<Drawable> request;

        public Builder(RequestBuilder<Drawable> requestBuilder) {
            this.request = requestBuilder;
        }

        public abstract Target<T> into(ImageView imageView);

        public abstract Target<T> into(Target<T> target);

        public abstract Target<T> preload();

        @Nullable
        @WorkerThread
        public abstract T preloadSync();
    }

    public static class DrawableBuilder extends Builder<Drawable> {
        public DrawableBuilder(RequestBuilder<Drawable> requestBuilder) {
            super(requestBuilder);
        }

        public DrawableBuilder error(@DrawableRes int i2) {
            this.request.error(i2);
            return this;
        }

        @Override // com.kugou.common.utils.YGlide.Builder
        public Target<Drawable> into(ImageView imageView) {
            return this.request.diskCacheStrategy(DiskCacheStrategy.ALL).into(imageView);
        }

        @Override // com.kugou.common.utils.YGlide.Builder
        public Target<Drawable> preload() {
            return this.request.diskCacheStrategy(DiskCacheStrategy.ALL).preload();
        }

        @Override // com.kugou.common.utils.YGlide.Builder
        public Target<Drawable> into(Target<Drawable> target) {
            return this.request.diskCacheStrategy(DiskCacheStrategy.ALL).into(target);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.kugou.common.utils.YGlide.Builder
        @Nullable
        @WorkerThread
        public Drawable preloadSync() {
            try {
                return (Drawable) this.request.diskCacheStrategy(DiskCacheStrategy.ALL).into(Integer.MIN_VALUE, Integer.MIN_VALUE).get();
            } catch (Exception e2) {
                e2.printStackTrace();
                return null;
            }
        }
    }

    private YGlide(Fragment fragment) {
        this.mFragment = fragment;
    }

    private RequestBuilder<Drawable> buildRequest(String str) {
        RequestManager requestManagerWith;
        Fragment fragment = this.mFragment;
        if (fragment != null) {
            requestManagerWith = Glide.with(fragment);
        } else {
            Activity activity = this.mActivity;
            requestManagerWith = activity != null ? Glide.with(activity) : Glide.with(this.mContext);
        }
        return requestManagerWith.load(str);
    }

    public static YGlide with(Fragment fragment) {
        return new YGlide(fragment);
    }

    public DrawableBuilder load(String str) {
        return new DrawableBuilder(buildRequest(str));
    }

    public static YGlide with(Activity activity) {
        return new YGlide(activity);
    }

    public YGlide(Activity activity) {
        this.mActivity = activity;
    }

    public static YGlide with(Context context) {
        return new YGlide(context);
    }

    public YGlide(Context context) {
        this.mContext = context;
    }
}
