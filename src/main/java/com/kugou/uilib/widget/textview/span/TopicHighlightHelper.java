package com.kugou.uilib.widget.textview.span;

import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.EditText;
import com.kugou.uilib.utils.KGUIListUtil;
import com.kugou.uilib.utils.KGUILog;
import com.kugou.uilib.widget.textview.emotion.CommentEmojiHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public class TopicHighlightHelper {
    public static final String AT = "@";
    public static final String AT_TAIL = " ";
    public static final String AT_USER_END = "]";
    public static final String AT_USER_START = "[at=";
    public static final String SHARP = "#";
    public static final String TAG = "TopicHighlightHelper";
    public static final String TAIL = " ";
    public static final int TOPIC_MAX_LEN = 50;
    public static HashMap<String, Long> nameAndIdMap = new HashMap<>();

    public static class AtUserSpanWrapper {
        private int end;
        private int start;
        private long userId;
        private String userName;

        public int getEnd() {
            return this.end;
        }

        public int getStart() {
            return this.start;
        }

        public long getUserId() {
            return this.userId;
        }

        public String getUserName() {
            return this.userName;
        }

        public void setEnd(int i2) {
            this.end = i2;
        }

        public void setStart(int i2) {
            this.start = i2;
        }

        public void setUserId(long j) {
            this.userId = j;
        }

        public void setUserName(String str) {
            this.userName = str;
        }
    }

    public interface OnSelectNewTopicListener {
        void onSelectNewTopic();
    }

    public interface OnSelectUserListener {
        void onSelectUser();
    }

    public interface OnTopicClickListener {
        void onTopicClick(View view, String str);
    }

    public static class TopicSpanWrapper {
        private int end;
        private int start;
        private String topic;

        public int getEnd() {
            return this.end;
        }

        public int getStart() {
            return this.start;
        }

        public String getTopic() {
            return this.topic;
        }

        public void setEnd(int i2) {
            this.end = i2;
        }

        public void setStart(int i2) {
            this.start = i2;
        }

        public void setTopic(String str) {
            this.topic = str;
        }
    }

    public static void applyAtHighlightSpan(SpannableStringBuilder spannableStringBuilder, int i2) {
        ArrayList<AtUserSpanWrapper> atUserHighlightList;
        if (TextUtils.isEmpty(spannableStringBuilder) || (atUserHighlightList = getAtUserHighlightList(spannableStringBuilder)) == null || atUserHighlightList.size() <= 0) {
            return;
        }
        for (AtUserSpanWrapper atUserSpanWrapper : atUserHighlightList) {
            spannableStringBuilder.setSpan(new ForegroundColorSpan(i2), atUserSpanWrapper.getStart(), atUserSpanWrapper.getEnd(), 33);
        }
    }

    public static void applyTopicHighlightSpan(SpannableStringBuilder spannableStringBuilder, int i2) {
        ArrayList<TopicSpanWrapper> topicHighlightList;
        if (TextUtils.isEmpty(spannableStringBuilder) || (topicHighlightList = getTopicHighlightList(spannableStringBuilder)) == null || topicHighlightList.size() <= 0) {
            return;
        }
        for (TopicSpanWrapper topicSpanWrapper : topicHighlightList) {
            spannableStringBuilder.setSpan(new ForegroundColorSpan(i2), topicSpanWrapper.getStart(), topicSpanWrapper.getEnd(), 33);
        }
    }

    public static void atUserHighlight(EditText editText, CharSequence charSequence, int i2, int i3, int i4, int i5, OnSelectUserListener onSelectUserListener) {
        int iIndexOf;
        String string = charSequence.toString();
        if (TextUtils.isEmpty(string)) {
            return;
        }
        if (string.indexOf(AT) == -1) {
            return;
        }
        int i6 = i2 + i4;
        String strSubstring = string.substring(i2, i6);
        if (i3 != i4 && AT.equals(strSubstring) && onSelectUserListener != null) {
            onSelectUserListener.onSelectUser();
        }
        StringBuilder sb = new StringBuilder(string);
        int iIndexOf2 = sb.indexOf(AT, 0);
        int iIndexOf3 = iIndexOf2 != -1 ? sb.indexOf(" ", iIndexOf2 + 1) : -1;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(CommentEmojiHelper.getSongCommentEmotionString(editText.getContext(), editText, string));
        applyTopicHighlightSpan(spannableStringBuilder, i5);
        int i7 = 0;
        for (int i8 = -1; iIndexOf2 != i8 && iIndexOf3 != i8; i8 = -1) {
            int i9 = iIndexOf2 + 1;
            if (userNameMatched(sb.substring(i9, iIndexOf3))) {
                int i10 = i7 + 1;
                int i11 = iIndexOf3 + 1;
                int i12 = iIndexOf3;
                spannableStringBuilder.setSpan(new ForegroundColorSpan(i5), iIndexOf2, i11, 17);
                iIndexOf = sb.indexOf(AT, i11);
                if (iIndexOf != -1) {
                    iIndexOf3 = sb.indexOf(" ", iIndexOf + 1);
                    i7 = i10;
                } else {
                    i7 = i10;
                    iIndexOf3 = i12;
                }
            } else {
                iIndexOf = sb.indexOf(AT, i9);
                iIndexOf3 = sb.indexOf(" ", iIndexOf + 1);
            }
            iIndexOf2 = iIndexOf;
        }
        if (i7 <= 0) {
            if (i2 == 0 && (i3 == i4 || i3 == i4 - 1)) {
                return;
            }
            SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(CommentEmojiHelper.getSongCommentEmotionString(editText.getContext(), editText, editText.getText().toString()));
            spannableStringBuilder2.setSpan(new ForegroundColorSpan(editText.getCurrentTextColor()), 0, string.length(), 18);
            applyTopicHighlightSpan(spannableStringBuilder2, i5);
            editText.setText(spannableStringBuilder2);
            editText.setSelection(i6);
            return;
        }
        if (i2 != 0 || (!(i3 == i4 || i3 == i4 - 1) || (i2 == 0 && i3 == 0 && i4 == 1))) {
            if (strSubstring.contains(" ") || i3 > i4) {
                KGUILog.e(TAG, "user match setText str = " + ((Object) spannableStringBuilder));
                editText.setText(spannableStringBuilder);
            }
            editText.setSelection(i6);
        }
    }

    public static ArrayList<AtUserSpanWrapper> getAtUserHighlightList(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            return null;
        }
        ArrayList<AtUserSpanWrapper> arrayList = new ArrayList<>();
        String string = charSequence.toString();
        int iIndexOf = string.indexOf(AT, 0);
        int iIndexOf2 = iIndexOf != -1 ? string.indexOf(" ", iIndexOf + 1) : -1;
        while (iIndexOf != -1 && iIndexOf2 != -1) {
            int i2 = iIndexOf + 1;
            String strSubstring = string.substring(i2, iIndexOf2);
            if (userNameMatched(strSubstring)) {
                AtUserSpanWrapper atUserSpanWrapper = new AtUserSpanWrapper();
                atUserSpanWrapper.setStart(iIndexOf);
                atUserSpanWrapper.setEnd(iIndexOf2);
                atUserSpanWrapper.setUserId(nameAndIdMap.get(strSubstring).longValue());
                atUserSpanWrapper.setUserName(strSubstring);
                arrayList.add(atUserSpanWrapper);
                iIndexOf = string.indexOf(AT, iIndexOf2 + 1);
                if (iIndexOf != -1) {
                    iIndexOf2 = string.indexOf(" ", iIndexOf + 1);
                }
            } else {
                iIndexOf = string.indexOf(AT, i2);
                iIndexOf2 = string.indexOf(" ", iIndexOf + 1);
            }
        }
        return arrayList;
    }

    public static ArrayList<AtUserSpanWrapper> getAvaiableAtUserList(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            return null;
        }
        ArrayList<AtUserSpanWrapper> arrayList = new ArrayList<>();
        ArrayList<TopicSpanWrapper> topicHighlightList = getTopicHighlightList(charSequence);
        ArrayList<AtUserSpanWrapper> atUserHighlightList = getAtUserHighlightList(charSequence);
        if (!KGUIListUtil.isEmpty(atUserHighlightList)) {
            for (AtUserSpanWrapper atUserSpanWrapper : atUserHighlightList) {
                if (KGUIListUtil.isEmpty(topicHighlightList)) {
                    arrayList.add(atUserSpanWrapper);
                } else {
                    for (TopicSpanWrapper topicSpanWrapper : topicHighlightList) {
                        if (atUserSpanWrapper.getStart() < topicSpanWrapper.getStart() || atUserSpanWrapper.getStart() > topicSpanWrapper.getEnd()) {
                            arrayList.add(atUserSpanWrapper);
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    public static ArrayList<TopicSpanWrapper> getTopicHighlightList(CharSequence charSequence) {
        return getTopicHighlightList(charSequence, 50);
    }

    public static SpannableStringBuilder getTopicHighlightSpan(CharSequence charSequence, int i2) {
        if (TextUtils.isEmpty(charSequence)) {
            return null;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(charSequence);
        ArrayList<TopicSpanWrapper> topicHighlightList = getTopicHighlightList(spannableStringBuilder);
        if (topicHighlightList != null && topicHighlightList.size() > 0) {
            for (TopicSpanWrapper topicSpanWrapper : topicHighlightList) {
                spannableStringBuilder.setSpan(new ForegroundColorSpan(i2), topicSpanWrapper.getStart(), topicSpanWrapper.getEnd(), 33);
            }
        }
        return spannableStringBuilder;
    }

    public static String replaceAtSymbolToAtTags(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            return "";
        }
        StringBuilder sb = new StringBuilder(charSequence);
        ArrayList<AtUserSpanWrapper> avaiableAtUserList = getAvaiableAtUserList(charSequence);
        if (!KGUIListUtil.isEmpty(avaiableAtUserList)) {
            Iterator<AtUserSpanWrapper> it = avaiableAtUserList.iterator();
            if (it.hasNext()) {
                AtUserSpanWrapper next = it.next();
                return replaceAtSymbolToAtTags(sb.replace(next.getStart(), next.getEnd() + 1, AT_USER_START + nameAndIdMap.get(next.getUserName()) + "]"));
            }
        }
        return sb.toString();
    }

    public static void topicHighlight(EditText editText, CharSequence charSequence, int i2, int i3, int i4, int i5, OnSelectNewTopicListener onSelectNewTopicListener) {
        topicHighlight(editText, charSequence, i2, i3, i4, i5, 50, onSelectNewTopicListener);
    }

    private static boolean userNameMatched(String str) {
        return !TextUtils.isEmpty(str) && nameAndIdMap.containsKey(str);
    }

    public static ArrayList<TopicSpanWrapper> getTopicHighlightList(CharSequence charSequence, int i2) {
        if (TextUtils.isEmpty(charSequence)) {
            return null;
        }
        ArrayList<TopicSpanWrapper> arrayList = new ArrayList<>();
        String string = charSequence.toString();
        int iIndexOf = string.indexOf(SHARP, 0);
        int iIndexOf2 = iIndexOf != -1 ? string.indexOf(SHARP, iIndexOf + 1) : -1;
        while (iIndexOf != -1 && iIndexOf2 != -1) {
            int i3 = iIndexOf2 + 1;
            String strSubstring = string.substring(iIndexOf, i3);
            if (TextUtils.isEmpty(strSubstring.replaceAll(SHARP, "").trim()) || strSubstring.replaceAll(SHARP, "").length() > i2) {
                int i4 = iIndexOf2;
                iIndexOf2 = string.indexOf(SHARP, i3);
                iIndexOf = i4;
            } else {
                TopicSpanWrapper topicSpanWrapper = new TopicSpanWrapper();
                topicSpanWrapper.setStart(iIndexOf);
                topicSpanWrapper.setEnd(i3);
                topicSpanWrapper.setTopic(strSubstring.replaceAll(SHARP, ""));
                arrayList.add(topicSpanWrapper);
                iIndexOf = string.indexOf(SHARP, i3);
                if (iIndexOf != -1) {
                    iIndexOf2 = string.indexOf(SHARP, iIndexOf + 1);
                }
            }
        }
        return arrayList;
    }

    public static void topicHighlight(EditText editText, CharSequence charSequence, int i2, int i3, int i4, int i5, int i6, OnSelectNewTopicListener onSelectNewTopicListener) {
        int i7;
        boolean zEndsWith;
        String str;
        int i8;
        boolean z;
        String string = charSequence.toString();
        if (TextUtils.isEmpty(string) || string.indexOf(SHARP) == -1) {
            return;
        }
        int i9 = i2 + i4;
        String strSubstring = string.substring(i2, i9);
        String str2 = "";
        int length = string.length() - string.replaceAll(SHARP, "").length();
        if (i3 != i4 && SHARP.equals(strSubstring) && length % 2 == 1 && onSelectNewTopicListener != null) {
            onSelectNewTopicListener.onSelectNewTopic();
        }
        StringBuilder sb = new StringBuilder(string);
        int iIndexOf = sb.indexOf(SHARP, 0);
        int iIndexOf2 = iIndexOf != -1 ? sb.indexOf(SHARP, iIndexOf + 1) : -1;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(CommentEmojiHelper.getSongCommentEmotionString(editText.getContext(), editText, string));
        applyAtHighlightSpan(spannableStringBuilder, i5);
        int iIndexOf3 = iIndexOf;
        int i10 = 0;
        int iIndexOf4 = iIndexOf2;
        boolean z2 = false;
        while (true) {
            i7 = length;
            if (iIndexOf3 == -1 || iIndexOf4 == -1) {
                break;
            }
            int i11 = iIndexOf4 + 1;
            boolean z3 = z2;
            String strSubstring2 = sb.substring(iIndexOf3, i11);
            if (TextUtils.isEmpty(strSubstring2.replaceAll(SHARP, str2).trim())) {
                str = str2;
            } else {
                str = str2;
                if (strSubstring2.replaceAll(SHARP, str2).length() <= i6) {
                    int i12 = i10 + 1;
                    if (i2 < iIndexOf3 || i2 > iIndexOf4) {
                        z2 = z3;
                        i8 = i12;
                    } else {
                        i8 = i12;
                        z2 = true;
                    }
                    ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(i5);
                    if (i2 >= iIndexOf3 && i2 <= iIndexOf4) {
                        try {
                            z = !" ".equals(spannableStringBuilder.subSequence(i11, iIndexOf4 + 2).toString());
                        } catch (Exception unused) {
                            z = true;
                        }
                        if (z) {
                            sb.insert(i11, " ");
                            spannableStringBuilder.insert(i11, (CharSequence) " ");
                        }
                    }
                    spannableStringBuilder.setSpan(foregroundColorSpan, iIndexOf3, i11, 17);
                    iIndexOf3 = sb.indexOf(SHARP, i11);
                    if (iIndexOf3 != -1) {
                        iIndexOf4 = sb.indexOf(SHARP, iIndexOf3 + 1);
                    }
                    i10 = i8;
                }
                length = i7;
                str2 = str;
            }
            z2 = z3;
            int i13 = iIndexOf4;
            iIndexOf4 = sb.indexOf(SHARP, i11);
            iIndexOf3 = i13;
            length = i7;
            str2 = str;
        }
        boolean z4 = z2;
        if (i10 <= 0) {
            if (i2 == 0 && (i3 == i4 || i3 == i4 - 1)) {
                return;
            }
            SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(CommentEmojiHelper.getSongCommentEmotionString(editText.getContext(), editText, string));
            spannableStringBuilder2.setSpan(new ForegroundColorSpan(editText.getCurrentTextColor()), 0, string.length(), 18);
            applyAtHighlightSpan(spannableStringBuilder2, i5);
            if (i3 <= i4 || !string.contains(SHARP)) {
                editText.getText().setSpan(spannableStringBuilder2, 0, spannableStringBuilder2.length() - 1, 18);
            } else {
                editText.setText(spannableStringBuilder2);
            }
            editText.setSelection(i9);
            return;
        }
        if (i2 != 0 || (!(i3 == i4 || i3 == i4 - 1) || (i2 == 0 && i3 == 0 && i4 == 1))) {
            if (strSubstring.contains(SHARP) || i3 > i4) {
                editText.setText(spannableStringBuilder);
            }
            if (!z4 || i7 % 2 != 0 || !strSubstring.contains(SHARP)) {
                editText.setSelection(i9);
                return;
            }
            int i14 = i9 + 1;
            try {
                zEndsWith = spannableStringBuilder.subSequence(i2 + 1, i14).toString().endsWith(" ");
            } catch (Exception unused2) {
                zEndsWith = true;
            }
            if (!zEndsWith) {
                i14 = i9;
            }
            if (i14 <= spannableStringBuilder.length()) {
                editText.setSelection(Math.min(i14, editText.length()));
            } else {
                editText.setSelection(i9);
            }
        }
    }
}
