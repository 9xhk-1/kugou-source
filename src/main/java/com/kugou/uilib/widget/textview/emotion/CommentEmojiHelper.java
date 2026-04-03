package com.kugou.uilib.widget.textview.emotion;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import android.widget.TextView;
import com.kugou.uilib.utils.KGUIImageUtil;
import com.kugou.uilib.utils.KGUILog;
import com.kugou.uilib.widget.textview.emotion.EmotionHelper;
import com.kugou.uilib.widget.textview.span.VerticalCenterImageSpan;
import java.util.ArrayList;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes2.dex */
public class CommentEmojiHelper {
    private static WeakHashMap<String, Bitmap> bitmapCache = new WeakHashMap<>();

    public static CharSequence getSongCommentEmotionString(Context context, TextView textView, String str) {
        return getSongCommentEmotionString(context, textView.getTextSize(), str);
    }

    public static int getWatchableSize(SpannableStringBuilder spannableStringBuilder) {
        if (spannableStringBuilder == null || spannableStringBuilder.length() < 1) {
            return 0;
        }
        ImageSpan[] imageSpanArr = (ImageSpan[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), ImageSpan.class);
        if (imageSpanArr == null || imageSpanArr.length < 1) {
            return spannableStringBuilder.length();
        }
        int length = spannableStringBuilder.length();
        for (ImageSpan imageSpan : imageSpanArr) {
            if (imageSpan != null) {
                int spanEnd = spannableStringBuilder.getSpanEnd(imageSpan) - spannableStringBuilder.getSpanStart(imageSpan);
                if (spanEnd > 0) {
                    length = (length - spanEnd) + 1;
                }
            }
        }
        return length;
    }

    public static SpannableString getSongCommentEmotionString(Context context, float f2, CharSequence charSequence) {
        SpannableString spannableString;
        synchronized (bitmapCache) {
            if (TextUtils.isEmpty(charSequence)) {
                return new SpannableString("");
            }
            float fCeil = (float) Math.ceil(f2 * 1.2f);
            try {
                spannableString = new SpannableString(charSequence);
                ArrayList<EmotionHelper.EmotionString> commentEmotion = EmotionHelper.parseCommentEmotion(charSequence, "[", "]");
                if (commentEmotion != null && commentEmotion.size() > 0) {
                    for (EmotionHelper.EmotionString emotionString : commentEmotion) {
                        String str = emotionString.emotinRid + " - " + fCeil;
                        Bitmap bitmap = bitmapCache.containsKey(str) ? bitmapCache.get(str) : null;
                        if (KGUILog.DEBUG) {
                            if (bitmap == null) {
                                KGUILog.d("log.test.span", "No bitmap existed in cache for reusing.[" + emotionString.emotinText + "]");
                            } else {
                                KGUILog.d("log.test.span", "Bitmap existed in cache for reusing.[" + emotionString.emotinText + "]");
                            }
                            KGUILog.d("log.test.span.textsize", "Current Text Size: " + fCeil);
                        }
                        if (bitmap == null) {
                            Bitmap bitmapDecodeResource = BitmapFactory.decodeResource(context.getResources(), emotionString.emotinRid);
                            int i2 = (int) fCeil;
                            Bitmap bitmapZoomBitmap = KGUIImageUtil.zoomBitmap(bitmapDecodeResource, i2, i2);
                            bitmapDecodeResource.recycle();
                            bitmapCache.put(str, bitmapZoomBitmap);
                            bitmap = bitmapZoomBitmap;
                        }
                        spannableString.setSpan(new VerticalCenterImageSpan(context, bitmap), emotionString.textStartPos, emotionString.textEndPos, 33);
                    }
                }
            } catch (Exception unused) {
                spannableString = new SpannableString(charSequence);
            } catch (OutOfMemoryError unused2) {
                spannableString = new SpannableString(charSequence);
            }
            return spannableString;
        }
    }
}
