package com.kugou.uilib.widget.textview.span;

import android.text.SpannableString;
import android.view.View;
import com.kugou.uilib.KGUI;
import com.kugou.uilib.utils.KGUILog;
import com.kugou.uilib.utils.KGUIToastUtils;
import com.kugou.uilib.widget.textview.emotion.CommentEmojiHelper;
import com.kugou.uilib.widget.textview.span.HyperLinkTagProtocol;
import com.kugou.uilib.widget.textview.span.TopicHighlightHelper;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class SpanStrGenUtil {
    public static SpannableString genSp(String str, int i2, int i3, int i4, int i5) {
        return getTopicSpannableString(getAtUserContent(getSuperLinkableContent(CommentEmojiHelper.getSongCommentEmotionString(KGUI.getInstance().getAppContext(), 50.0f, new SpannableString(str)), i2, i3, i4, i5), i2, i3, i4, i5), i2, i3, i4, i5);
    }

    private static SpannableString getAtUserContent(CharSequence charSequence, int i2, int i3, int i4, int i5) {
        HyperLinkTagProtocol hyperLinkTagProtocol = new HyperLinkTagProtocol(1);
        hyperLinkTagProtocol.matchChars(charSequence);
        ArrayList<HyperLinkTagProtocol.SuperLink> linkable = hyperLinkTagProtocol.getLinkable();
        CharSequence textFormatted = hyperLinkTagProtocol.getTextFormatted();
        SpannableString spannableString = textFormatted == null ? new SpannableString("") : new SpannableString(textFormatted.subSequence(0, textFormatted.length()));
        for (final HyperLinkTagProtocol.SuperLink superLink : linkable) {
            if (superLink != null) {
                spannableString.setSpan(new KGUITouchableSpan(i2, i3, i4, i5) { // from class: com.kugou.uilib.widget.textview.span.SpanStrGenUtil.3
                    @Override // com.kugou.uilib.widget.textview.span.KGUITouchableSpan
                    public void onSpanClick(View view) {
                        if (KGUILog.DEBUG) {
                            KGUIToastUtils.show(KGUI.getInstance().getAppContext(), "点击" + ((Object) superLink.getLink()));
                        }
                    }
                }, superLink.getPosStart(), superLink.getPosEnd(), 33);
            }
        }
        return spannableString;
    }

    private static SpannableString getSuperLinkableContent(CharSequence charSequence, int i2, int i3, int i4, int i5) {
        HyperLinkTagProtocol hyperLinkTagProtocol = new HyperLinkTagProtocol();
        hyperLinkTagProtocol.matchChars(charSequence);
        ArrayList<HyperLinkTagProtocol.SuperLink> linkable = hyperLinkTagProtocol.getLinkable();
        CharSequence textFormatted = hyperLinkTagProtocol.getTextFormatted();
        SpannableString spannableString = textFormatted == null ? new SpannableString("") : new SpannableString(textFormatted.subSequence(0, textFormatted.length()));
        for (final HyperLinkTagProtocol.SuperLink superLink : linkable) {
            if (superLink != null) {
                spannableString.setSpan(new KGUITouchableSpan(i2, i3, i4, i5) { // from class: com.kugou.uilib.widget.textview.span.SpanStrGenUtil.1
                    @Override // com.kugou.uilib.widget.textview.span.KGUITouchableSpan
                    public void onSpanClick(View view) {
                        if (KGUILog.DEBUG) {
                            KGUIToastUtils.show(KGUI.getInstance().getAppContext(), "点击" + ((Object) superLink.getLink()));
                        }
                    }
                }, superLink.getPosStart(), superLink.getPosEnd(), 33);
            }
        }
        return spannableString;
    }

    private static SpannableString getTopicSpannableString(SpannableString spannableString, int i2, int i3, int i4, int i5) {
        ArrayList<TopicHighlightHelper.TopicSpanWrapper> topicHighlightList = TopicHighlightHelper.getTopicHighlightList(spannableString);
        if (topicHighlightList != null && topicHighlightList.size() > 0) {
            for (final TopicHighlightHelper.TopicSpanWrapper topicSpanWrapper : topicHighlightList) {
                spannableString.setSpan(new KGUITouchableSpan(i2, i3, i4, i5) { // from class: com.kugou.uilib.widget.textview.span.SpanStrGenUtil.2
                    @Override // com.kugou.uilib.widget.textview.span.KGUITouchableSpan
                    public void onSpanClick(View view) {
                        if (KGUILog.DEBUG) {
                            KGUIToastUtils.show(KGUI.getInstance().getAppContext(), "点击" + topicSpanWrapper.getTopic());
                        }
                    }
                }, topicSpanWrapper.getStart(), topicSpanWrapper.getEnd(), 33);
            }
        }
        return spannableString;
    }
}
