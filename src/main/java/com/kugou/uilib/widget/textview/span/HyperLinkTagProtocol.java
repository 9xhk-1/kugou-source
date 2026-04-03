package com.kugou.uilib.widget.textview.span;

import android.net.Uri;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class HyperLinkTagProtocol {
    public static final String AT_HEAD_END = "]";
    public static final String AT_HEAD_START = "[at_id=";
    public static final String AT_TAIL = "[/at]";
    private static final String HEAD_END = "]";
    private static final String HEAD_START = "[link=";
    private static final String TAIL = "[/link]";
    public static final int TYPE_AT = 1;
    public static final int TYPE_HTTP = 0;
    private String headEnd;
    private String headStart;
    private int linkType;
    private ArrayList<SuperLink> linkable;
    private String tail;
    private CharSequence textFormatted;
    private CharSequence textOrigin;

    public class SuperLink {
        private CharSequence link;
        private int posEnd;
        private int posHeadEndA;
        private int posHeadEndB;
        private int posHeadStartA;
        private int posHeadStartB;
        private int posStart;
        private int posTailStartA;
        private int posTailStartB;
        private CharSequence replacement;

        public SuperLink() {
        }

        public CharSequence getLink() {
            return this.link;
        }

        public int getPosEnd() {
            return this.posEnd;
        }

        public int getPosStart() {
            return this.posStart;
        }

        public CharSequence getReplacement() {
            return this.replacement;
        }

        public void setLink(CharSequence charSequence) {
            this.link = charSequence;
        }

        public void setPosHeadEndA(int i2) {
            this.posHeadEndA = i2;
            this.posHeadEndB = i2 + HyperLinkTagProtocol.this.headEnd.length();
        }

        public void setPosHeadStartA(int i2) {
            this.posHeadStartA = i2;
            this.posHeadStartB = i2 + HyperLinkTagProtocol.this.headStart.length();
        }

        public void setPosStart(int i2) {
            this.posStart = i2;
            if (TextUtils.isEmpty(this.replacement)) {
                return;
            }
            this.posEnd = i2 + this.replacement.length();
        }

        public void setPosTailStartA(int i2) {
            this.posTailStartA = i2;
            this.posTailStartB = i2 + HyperLinkTagProtocol.this.tail.length();
        }

        public void setReplacement(CharSequence charSequence) {
            this.replacement = charSequence;
        }
    }

    public HyperLinkTagProtocol() {
        this(0);
    }

    private void match(StringBuffer stringBuffer, int i2) {
        int iIndexOf;
        if (stringBuffer == null || i2 > stringBuffer.length() || (iIndexOf = stringBuffer.indexOf(this.headStart, i2)) == -1) {
            return;
        }
        SuperLink superLink = new SuperLink();
        superLink.setPosHeadStartA(iIndexOf);
        int iIndexOf2 = stringBuffer.indexOf(this.headEnd, iIndexOf + this.headStart.length());
        if (iIndexOf2 == -1) {
            return;
        }
        superLink.setPosHeadEndA(iIndexOf2);
        int iIndexOf3 = stringBuffer.indexOf(this.tail, iIndexOf2 + this.headEnd.length());
        if (iIndexOf3 == -1) {
            return;
        }
        superLink.setPosTailStartA(iIndexOf3);
        CharSequence charSequenceSubSequence = this.textOrigin.subSequence(superLink.posHeadStartB, superLink.posHeadEndA);
        if (!TextUtils.isEmpty(charSequenceSubSequence)) {
            int i3 = this.linkType;
            if (i3 == 0) {
                Uri uri = Uri.parse(charSequenceSubSequence.toString());
                if (uri != null) {
                    String host = uri.getHost();
                    if (!TextUtils.isEmpty(host) && (host.endsWith("kugou.com") || host.endsWith("kgimg.com"))) {
                        superLink.setLink(charSequenceSubSequence);
                        superLink.setReplacement(this.textOrigin.subSequence(superLink.posHeadEndB, superLink.posTailStartA));
                        this.linkable.add(superLink);
                    }
                }
            } else if (i3 == 1) {
                superLink.setLink(charSequenceSubSequence);
                superLink.setReplacement(this.textOrigin.subSequence(superLink.posHeadEndB, superLink.posTailStartA));
                this.linkable.add(superLink);
            }
        }
        match(stringBuffer, iIndexOf3);
    }

    public ArrayList<SuperLink> getLinkable() {
        int size = this.linkable.size();
        if (size < 1) {
            this.textFormatted = this.textOrigin;
        } else {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                SuperLink superLink = this.linkable.get(i3);
                if (superLink.posHeadStartA > i2) {
                    spannableStringBuilder.append(this.textOrigin.subSequence(i2, superLink.posHeadStartA));
                }
                superLink.setPosStart(spannableStringBuilder.length());
                spannableStringBuilder.append(superLink.replacement);
                i2 = superLink.posTailStartB;
                if (i3 == size - 1 && i2 < this.textOrigin.length()) {
                    CharSequence charSequence = this.textOrigin;
                    spannableStringBuilder.append(charSequence.subSequence(i2, charSequence.length()));
                }
            }
            this.textFormatted = spannableStringBuilder.subSequence(0, spannableStringBuilder.length());
        }
        return this.linkable;
    }

    public CharSequence getTextFormatted(boolean z) {
        if (TextUtils.isEmpty(this.textFormatted) || !z || this.textFormatted.toString().indexOf(AT_HEAD_START) == -1) {
            return this.textFormatted;
        }
        setLinkType(1);
        matchChars(this.textFormatted);
        getLinkable();
        return this.textFormatted;
    }

    public void matchChars(CharSequence charSequence) {
        if (charSequence == null || charSequence.length() < 1) {
            return;
        }
        this.linkable.clear();
        this.textOrigin = charSequence;
        match(new StringBuffer(charSequence), 0);
    }

    public void setLinkType(int i2) {
        this.linkType = i2;
        if (i2 == 1) {
            this.headStart = AT_HEAD_START;
            this.headEnd = "]";
            this.tail = AT_TAIL;
        } else if (i2 == 0) {
            this.headStart = HEAD_START;
            this.headEnd = "]";
            this.tail = TAIL;
        }
    }

    public HyperLinkTagProtocol(int i2) {
        this.linkType = 0;
        this.headStart = HEAD_START;
        this.headEnd = "]";
        this.tail = TAIL;
        this.textOrigin = null;
        this.textFormatted = null;
        this.linkable = new ArrayList<>();
        this.linkType = i2;
        if (i2 == 1) {
            this.headStart = AT_HEAD_START;
            this.headEnd = "]";
            this.tail = AT_TAIL;
        }
    }

    public CharSequence getTextFormatted() {
        return getTextFormatted(false);
    }
}
