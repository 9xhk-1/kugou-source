package com.kugou.uilib.widget.textview.emotion;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import android.widget.TextView;
import com.kugou.common.network.retrystatics.RetryStaticsLOG;
import com.kugou.uilib.KGUI;
import com.kugou.uilib.R;
import com.kugou.uilib.utils.KGUIImageUtil;
import com.kugou.uilib.utils.KGUILog;
import com.kugou.uilib.widget.textview.span.VerticalCenterImageSpan;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes2.dex */
public class EmotionHelper {
    public static int[] EMOTION_DRAWABLE_LIST = {R.drawable.common_m1, R.drawable.common_m2, R.drawable.common_m3, R.drawable.common_m4, R.drawable.common_m5, R.drawable.common_m6, R.drawable.common_m7, R.drawable.common_m8, R.drawable.common_m9, R.drawable.common_m10, R.drawable.common_m11, R.drawable.common_m12, R.drawable.common_m13, R.drawable.common_m14, R.drawable.common_m15, R.drawable.common_m16, R.drawable.common_m17, R.drawable.common_m18, R.drawable.common_m19, R.drawable.common_m20, R.drawable.common_m21, R.drawable.common_m22, R.drawable.common_m23, R.drawable.common_m24, R.drawable.common_m25, R.drawable.common_m26, R.drawable.common_m27, R.drawable.common_m28, R.drawable.common_m29, R.drawable.common_m30, R.drawable.common_m31, R.drawable.common_m32, R.drawable.common_m33, R.drawable.common_m34, R.drawable.common_m35, R.drawable.common_m36, R.drawable.common_m37, R.drawable.common_m38, R.drawable.common_m39, R.drawable.common_m40, R.drawable.common_m41, R.drawable.common_m42, R.drawable.common_m43, R.drawable.common_m44, R.drawable.common_m45, R.drawable.common_m46, R.drawable.common_m47, R.drawable.common_m48, R.drawable.common_m49, R.drawable.common_m50, R.drawable.common_m51, R.drawable.common_m52, R.drawable.common_m53, R.drawable.common_m54, R.drawable.common_m55, R.drawable.common_m56, R.drawable.common_m57, R.drawable.common_m58, R.drawable.common_m59, R.drawable.common_m60, R.drawable.common_m61, R.drawable.common_m62, R.drawable.common_m63, R.drawable.common_m64, R.drawable.common_m65, R.drawable.common_m66, R.drawable.common_m67, R.drawable.common_m68, R.drawable.common_m69, R.drawable.common_m70, R.drawable.common_m71, R.drawable.common_m72, R.drawable.common_m73, R.drawable.common_m74, R.drawable.common_m75, R.drawable.common_m76, R.drawable.common_m77, R.drawable.common_m78, R.drawable.common_m79, R.drawable.common_m80, R.drawable.common_m81, R.drawable.common_m82, R.drawable.common_m83, R.drawable.common_m84, R.drawable.common_m85, R.drawable.common_m86, R.drawable.common_m87, R.drawable.common_m88, R.drawable.common_m89, R.drawable.common_m90, R.drawable.common_m91, R.drawable.common_m92, R.drawable.common_m93, R.drawable.common_m94, R.drawable.common_m95, R.drawable.common_m96, R.drawable.common_m97};
    public static String[] EMOTION_TEXT_LIST = {"微笑", "撇嘴", "色", "发呆", "得意", "流泪", "害羞", "闭嘴", "睡", "大哭", "尴尬", "发怒", "调皮", "呲牙", "惊讶", "难过", "酷", "冷汗", "抓狂", "撅嘴", "偷笑", "可爱", "白眼", "傲慢", "饥饿", "困", "惊恐", "流汗", "憨笑", "大兵", "奋斗", "咒骂", "疑问", "嘘", "晕", "折磨", "衰", "骷髅", "敲打", "再见", "擦汗", "抠鼻", "鼓掌", "糗大了", "坏笑", "左哼哼", "右哼哼", "哈欠", "鄙视", "委屈", "快哭了", "阴险", "亲亲", "吓", "可怜", "菜刀", "西瓜", "啤酒", "篮球", "乒乓", "咖啡", "饭", "猪头", "玫瑰", "凋谢", "示爱", "爱心", "心碎", "蛋糕", "闪电", "炸弹", "刀", "足球", "瓢虫", "手机", "月亮", "太阳", "礼物", "抱抱", "强", "喝彩", "握手", "胜利", "抱拳", "勾引", "拳头", "差劲", "爱你", "NO", "OK", "擦鼻血", "哼哼哼", "吐舌头", "哇啊啊", "猥琐笑", "呦呦呦", "眨眼"};

    public static class EmotionString {
        public int emotinRid;
        public String emotinText;
        public int textEndPos;
        public int textStartPos;

        public String toString() {
            return "emotinText: " + this.emotinText + RetryStaticsLOG.MARK_SEPERATE + "textStartPos: " + this.textStartPos + RetryStaticsLOG.MARK_SEPERATE + "textEndPos: " + this.textEndPos + RetryStaticsLOG.MARK_SEPERATE + "emotinRid: " + this.emotinRid;
        }
    }

    public static class SpannableOrString {
        public SpannableStringBuilder builder;
        public String str;
    }

    private static int findIndex(String str) {
        int i2 = 0;
        while (true) {
            String[] strArr = EMOTION_TEXT_LIST;
            if (i2 >= strArr.length) {
                return 0;
            }
            if (str.equals(strArr[i2])) {
                return i2;
            }
            i2++;
        }
    }

    public static SpannableString getEmotionString(Context context, TextPaint textPaint, String str) {
        if (str == null) {
            str = "";
        }
        try {
            SpannableString spannableString = new SpannableString(str);
            ArrayList<EmotionString> emotion = parseEmotion(str);
            if (emotion == null || emotion.size() <= 0) {
                return spannableString;
            }
            for (EmotionString emotionString : emotion) {
                Bitmap bitmapDecodeResource = BitmapFactory.decodeResource(context.getResources(), emotionString.emotinRid);
                int textSize = (int) (textPaint.getTextSize() * 1.2f);
                spannableString.setSpan(new ImageSpan(context, KGUIImageUtil.zoomBitmap(bitmapDecodeResource, textSize, textSize)), emotionString.textStartPos, emotionString.textEndPos, 33);
            }
            return spannableString;
        } catch (Error unused) {
            return new SpannableString(str);
        } catch (Exception unused2) {
            return new SpannableString(str);
        }
    }

    public static SpannableString getSongCommentEmotionString(Context context, TextView textView, String str, boolean z) throws ArrayIndexOutOfBoundsException {
        if (str == null) {
            str = "";
        }
        try {
            SpannableString spannableString = new SpannableString(str);
            ArrayList<EmotionString> commentEmotion = parseCommentEmotion(str, "[", "]");
            if (commentEmotion == null || commentEmotion.size() <= 0) {
                return spannableString;
            }
            for (EmotionString emotionString : commentEmotion) {
                Bitmap bitmapDecodeResource = BitmapFactory.decodeResource(context.getResources(), emotionString.emotinRid);
                int textSize = (int) (textView.getTextSize() * 1.2f);
                Bitmap bitmapZoomBitmap = KGUIImageUtil.zoomBitmap(bitmapDecodeResource, textSize, textSize);
                spannableString.setSpan(z ? new VerticalCenterImageSpan(context, bitmapZoomBitmap) : new ImageSpan(context, bitmapZoomBitmap), emotionString.textStartPos, emotionString.textEndPos, 33);
            }
            return spannableString;
        } catch (Error unused) {
            return new SpannableString(str);
        } catch (Exception unused2) {
            return new SpannableString(str);
        }
    }

    public static SpannableStringBuilder highlight(String str, String str2, int i2) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        Matcher matcher = Pattern.compile(str2).matcher(str);
        while (matcher.find()) {
            spannableStringBuilder.setSpan(new ForegroundColorSpan(i2), matcher.start(), matcher.end(), 33);
        }
        return spannableStringBuilder;
    }

    public static ArrayList<EmotionString> parseCommentEmotion(CharSequence charSequence, String str, String str2) {
        if (TextUtils.isEmpty(charSequence)) {
            return null;
        }
        String string = charSequence.toString();
        ArrayList<EmotionString> arrayList = new ArrayList<>();
        int length = 0;
        while (true) {
            int iIndexOf = string.indexOf(str, length);
            int iIndexOf2 = string.indexOf(str2, iIndexOf);
            if (iIndexOf == -1 || iIndexOf2 == -1 || iIndexOf2 <= iIndexOf) {
                break;
            }
            EmotionString emotionString = new EmotionString();
            String strSubstring = string.substring(str.length() + iIndexOf, iIndexOf2);
            emotionString.emotinText = strSubstring;
            int iFindIndex = findIndex(strSubstring, -1);
            if (iFindIndex > -1) {
                emotionString.emotinRid = EMOTION_DRAWABLE_LIST[iFindIndex];
                emotionString.textEndPos = str2.length() + iIndexOf2;
                emotionString.textStartPos = iIndexOf;
                arrayList.add(emotionString);
            }
            length = str2.length() + iIndexOf2;
        }
        if (arrayList.size() > 0) {
            return arrayList;
        }
        return null;
    }

    public static ArrayList<EmotionString> parseEmotion(String str) {
        return parseEmotion(str, "[/", "]");
    }

    public static void setEmotionString(Context context, TextView textView, String str) {
        SpannableString emotionString = getEmotionString(context, textView, str);
        try {
            try {
                textView.setText(emotionString);
            } catch (Exception e2) {
                if (KGUILog.DEBUG) {
                    KGUILog.e("kugou", e2.getMessage());
                }
                textView.setText(emotionString.toString());
            }
        } catch (Throwable th) {
            if (KGUILog.DEBUG) {
                KGUILog.e("kugou", th.getMessage());
            }
            textView.setText(str);
        }
    }

    public static void transform(Context context, TextView textView, String str) {
        if (str == null) {
            str = "";
        }
        SpannableString spannableString = new SpannableString(str);
        try {
            ArrayList<EmotionString> emotion = parseEmotion(str);
            if (emotion != null && emotion.size() > 0) {
                for (EmotionString emotionString : emotion) {
                    Bitmap bitmapDecodeResource = BitmapFactory.decodeResource(context.getResources(), emotionString.emotinRid);
                    int textSize = (int) (textView.getTextSize() * 1.2f);
                    spannableString.setSpan(new ImageSpan(context, KGUIImageUtil.zoomBitmap(bitmapDecodeResource, textSize, textSize)), emotionString.textStartPos, emotionString.textEndPos, 33);
                }
            }
            textView.setText(spannableString);
        } catch (IndexOutOfBoundsException unused) {
            textView.setText(spannableString.toString());
        } catch (OutOfMemoryError unused2) {
            textView.setText(spannableString.toString());
        }
    }

    private static ArrayList<EmotionString> parseEmotion(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        ArrayList<EmotionString> arrayList = new ArrayList<>();
        int length = 0;
        while (true) {
            int iIndexOf = str.indexOf(str2, length);
            int iIndexOf2 = str.indexOf(str3, iIndexOf);
            if (iIndexOf == -1 || iIndexOf2 == -1 || iIndexOf2 <= iIndexOf) {
                break;
            }
            EmotionString emotionString = new EmotionString();
            emotionString.emotinText = str.substring(str2.length() + iIndexOf, iIndexOf2);
            emotionString.textStartPos = iIndexOf;
            emotionString.textEndPos = str3.length() + iIndexOf2;
            emotionString.emotinRid = EMOTION_DRAWABLE_LIST[findIndex(emotionString.emotinText)];
            arrayList.add(emotionString);
            length = str3.length() + iIndexOf2;
        }
        if (arrayList.size() > 0) {
            return arrayList;
        }
        return null;
    }

    private static int findIndex(String str, int i2) {
        int i3 = 0;
        while (true) {
            String[] strArr = EMOTION_TEXT_LIST;
            if (i3 >= strArr.length) {
                return i2;
            }
            if (str.equals(strArr[i3])) {
                return i3;
            }
            i3++;
        }
    }

    public static SpannableOrString getEmotionString(Context context, String str, float f2) throws ArrayIndexOutOfBoundsException {
        if (str == null) {
            str = "";
        }
        SpannableOrString spannableOrString = new SpannableOrString();
        try {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
            ArrayList<EmotionString> emotion = parseEmotion(str, "[", "]");
            if (emotion != null && emotion.size() > 0) {
                for (EmotionString emotionString : emotion) {
                    int i2 = (int) f2;
                    spannableStringBuilder.setSpan(new ImageSpan(context, KGUIImageUtil.zoomBitmap(BitmapFactory.decodeResource(context.getResources(), emotionString.emotinRid), i2, i2)), emotionString.textStartPos, emotionString.textEndPos, 33);
                }
                spannableOrString.builder = spannableStringBuilder;
            } else {
                spannableOrString.str = str;
            }
        } catch (Error unused) {
            spannableOrString.str = str;
        } catch (Exception unused2) {
            spannableOrString.str = str;
        }
        return spannableOrString;
    }

    public static SpannableString getEmotionString(Context context, TextView textView, String str) throws ArrayIndexOutOfBoundsException {
        if (str == null) {
            str = "";
        }
        try {
            SpannableString spannableString = new SpannableString(str);
            ArrayList<EmotionString> emotion = parseEmotion(str);
            if (emotion == null || emotion.size() <= 0) {
                return spannableString;
            }
            for (EmotionString emotionString : emotion) {
                Bitmap bitmapDecodeResource = BitmapFactory.decodeResource(context.getResources(), emotionString.emotinRid);
                int textSize = (int) (textView.getTextSize() * 1.2f);
                spannableString.setSpan(new VerticalCenterImageSpan(context, KGUIImageUtil.zoomBitmap(bitmapDecodeResource, textSize, textSize)), emotionString.textStartPos, emotionString.textEndPos, 33);
            }
            return spannableString;
        } catch (Error unused) {
            return new SpannableString(str);
        } catch (Exception unused2) {
            return new SpannableString(str);
        }
    }

    public static SpannableString getEmotionString(Context context, TextView textView, Spanned spanned) {
        try {
            SpannableString spannableString = new SpannableString(spanned);
            ArrayList<EmotionString> emotion = parseEmotion(spanned.toString());
            if (emotion == null || emotion.size() <= 0) {
                return spannableString;
            }
            for (EmotionString emotionString : emotion) {
                Bitmap bitmapDecodeResource = BitmapFactory.decodeResource(context.getResources(), emotionString.emotinRid);
                int textSize = (int) (textView.getTextSize() * 1.2f);
                spannableString.setSpan(new ImageSpan(context, KGUIImageUtil.zoomBitmap(bitmapDecodeResource, textSize, textSize)), emotionString.textStartPos, emotionString.textEndPos, 33);
            }
            return spannableString;
        } catch (Error unused) {
            return new SpannableString(spanned);
        } catch (Exception unused2) {
            return new SpannableString(spanned);
        }
    }

    public static SpannableString getEmotionString(String str, float f2) {
        Context appContext = KGUI.getInstance().getAppContext();
        try {
            SpannableString spannableString = new SpannableString(str);
            ArrayList<EmotionString> emotion = parseEmotion(str);
            if (emotion == null || emotion.size() <= 0) {
                return spannableString;
            }
            for (EmotionString emotionString : emotion) {
                int i2 = (int) f2;
                spannableString.setSpan(new ImageSpan(appContext, KGUIImageUtil.zoomBitmap(BitmapFactory.decodeResource(appContext.getResources(), emotionString.emotinRid), i2, i2)), emotionString.textStartPos, emotionString.textEndPos, 33);
            }
            return spannableString;
        } catch (Error unused) {
            return new SpannableString(str);
        } catch (Exception unused2) {
            return new SpannableString(str);
        }
    }
}
