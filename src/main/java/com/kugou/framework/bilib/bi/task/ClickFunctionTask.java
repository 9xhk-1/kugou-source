package com.kugou.framework.bilib.bi.task;

import android.text.TextUtils;
import com.kugou.common.apm.sdk.ApmDataKey;
import com.kugou.framework.bilib.bi.easytrace.AbstractFunction;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class ClickFunctionTask extends CommonFunctionTask {
    public String fo;
    public String fs;
    public String hash;
    public String ip;
    public String ivar1;
    public String ivar10;
    public String ivar2;
    public String ivar3;
    public String ivar4;
    public String ivar5;
    public String ivar6;
    public String ivar7;
    public String ivar8;
    public String ivar9;
    public String kw;
    public String lm;
    public String ltp;
    public String mixsongid;
    public String sbr;
    public String scid;
    public String sn;
    public String spt;
    public String ss;
    public String st;
    public String svar1;
    public String svar2;
    public String svar3;
    public String svar4;
    public String svar5;

    public ClickFunctionTask(AbstractFunction abstractFunction) {
        super(abstractFunction);
    }

    @Override // com.kugou.framework.bilib.bi.task.CommonFunctionTask, com.kugou.framework.bilib.bi.AbsFunctionTask, com.kugou.framework.bilib.bi.AbstractTraceTask
    public void assembleKeyValueList() {
        super.assembleKeyValueList();
        if (!TextUtils.isEmpty(this.ip)) {
            this.mKeyValueList.add("ip", this.ip);
        }
        if (!TextUtils.isEmpty(this.fo)) {
            this.mKeyValueList.add("fo", this.fo);
        }
        if (!TextUtils.isEmpty(this.lm)) {
            this.mKeyValueList.add("lm", this.lm);
        }
        if (!TextUtils.isEmpty(this.ltp)) {
            this.mKeyValueList.add("ltp", this.ltp);
        }
        if (!TextUtils.isEmpty(this.spt)) {
            this.mKeyValueList.add("spt", this.spt);
        }
        if (!TextUtils.isEmpty(this.fs)) {
            this.mKeyValueList.add(ApmDataKey.FS, this.fs);
        }
        if (!TextUtils.isEmpty(this.hash)) {
            this.mKeyValueList.add("hash", this.hash);
        }
        if (!TextUtils.isEmpty(this.scid)) {
            this.mKeyValueList.add("scid", this.scid);
        }
        if (!TextUtils.isEmpty(this.mixsongid)) {
            this.mKeyValueList.add("mixsongid", this.mixsongid);
        }
        if (!TextUtils.isEmpty(this.sn)) {
            this.mKeyValueList.add("sn", this.sn);
        }
        if (!TextUtils.isEmpty(this.ss)) {
            this.mKeyValueList.add("ss", this.ss);
        }
        if (!TextUtils.isEmpty(this.st)) {
            this.mKeyValueList.add("st", this.st);
        }
        if (!TextUtils.isEmpty(this.sbr)) {
            this.mKeyValueList.add("sbr", this.sbr);
        }
        if (!TextUtils.isEmpty(this.kw)) {
            this.mKeyValueList.add("kw", this.kw);
        }
        if (!TextUtils.isEmpty(this.ivar1)) {
            this.mKeyValueList.add("ivar1", this.ivar1);
        }
        if (!TextUtils.isEmpty(this.ivar2)) {
            this.mKeyValueList.add("ivar2", this.ivar2);
        }
        if (!TextUtils.isEmpty(this.ivar3)) {
            this.mKeyValueList.add("ivar3", this.ivar3);
        }
        if (!TextUtils.isEmpty(this.ivar4)) {
            this.mKeyValueList.add("ivar4", this.ivar4);
        }
        if (!TextUtils.isEmpty(this.ivar5)) {
            this.mKeyValueList.add("ivar5", this.ivar5);
        }
        if (!TextUtils.isEmpty(this.ivar6)) {
            this.mKeyValueList.add("ivar6", this.ivar6);
        }
        if (!TextUtils.isEmpty(this.ivar7)) {
            this.mKeyValueList.add("ivar7", this.ivar7);
        }
        if (!TextUtils.isEmpty(this.ivar8)) {
            this.mKeyValueList.add("ivar8", this.ivar8);
        }
        if (!TextUtils.isEmpty(this.ivar9)) {
            this.mKeyValueList.add("ivar9", this.ivar9);
        }
        if (!TextUtils.isEmpty(this.ivar10)) {
            this.mKeyValueList.add("ivar10", this.ivar10);
        }
        if (!TextUtils.isEmpty(this.svar1)) {
            this.mKeyValueList.add("svar1", this.svar1);
        }
        if (!TextUtils.isEmpty(this.svar2)) {
            this.mKeyValueList.add("svar2", this.svar2);
        }
        if (!TextUtils.isEmpty(this.svar3)) {
            this.mKeyValueList.add("svar3", this.svar3);
        }
        if (!TextUtils.isEmpty(this.svar4)) {
            this.mKeyValueList.add("svar4", this.svar4);
        }
        if (TextUtils.isEmpty(this.svar5)) {
            return;
        }
        this.mKeyValueList.add("svar5", this.svar5);
    }

    public ClickFunctionTask setFo(String str) {
        this.fo = str;
        return this;
    }

    public ClickFunctionTask setFs(String str) {
        this.fs = str;
        return this;
    }

    public ClickFunctionTask setHash(String str) {
        this.hash = str;
        return this;
    }

    public ClickFunctionTask setIp(String str) {
        this.ip = str;
        return this;
    }

    public ClickFunctionTask setIvar1(String str) {
        this.ivar1 = str;
        return this;
    }

    public ClickFunctionTask setIvar10(String str) {
        this.ivar10 = str;
        return this;
    }

    public ClickFunctionTask setIvar2(String str) {
        this.ivar2 = str;
        return this;
    }

    public ClickFunctionTask setIvar3(String str) {
        this.ivar3 = str;
        return this;
    }

    public ClickFunctionTask setIvar4(String str) {
        this.ivar4 = str;
        return this;
    }

    public ClickFunctionTask setIvar5(String str) {
        this.ivar5 = str;
        return this;
    }

    public ClickFunctionTask setIvar6(String str) {
        this.ivar6 = str;
        return this;
    }

    public ClickFunctionTask setIvar7(String str) {
        this.ivar7 = str;
        return this;
    }

    public ClickFunctionTask setIvar8(String str) {
        this.ivar8 = str;
        return this;
    }

    public ClickFunctionTask setIvar9(String str) {
        this.ivar9 = str;
        return this;
    }

    public ClickFunctionTask setKw(String str) {
        this.kw = str;
        return this;
    }

    public ClickFunctionTask setLm(String str) {
        this.lm = str;
        return this;
    }

    public ClickFunctionTask setLtp(String str) {
        this.ltp = str;
        return this;
    }

    public ClickFunctionTask setMixsongid(String str) {
        this.mixsongid = str;
        return this;
    }

    public ClickFunctionTask setSbr(String str) {
        this.sbr = str;
        return this;
    }

    public ClickFunctionTask setScid(String str) {
        this.scid = str;
        return this;
    }

    public ClickFunctionTask setSn(String str) {
        this.sn = str;
        return this;
    }

    public ClickFunctionTask setSpt(String str) {
        this.spt = str;
        return this;
    }

    public ClickFunctionTask setSs(String str) {
        this.ss = str;
        return this;
    }

    public ClickFunctionTask setSt(String str) {
        this.st = str;
        return this;
    }

    public ClickFunctionTask setSvar1(String str) {
        this.svar1 = str;
        return this;
    }

    public ClickFunctionTask setSvar2(String str) {
        this.svar2 = str;
        return this;
    }

    public ClickFunctionTask setSvar3(String str) {
        this.svar3 = str;
        return this;
    }

    public ClickFunctionTask setSvar4(String str) {
        this.svar4 = str;
        return this;
    }

    public ClickFunctionTask setSvar5(String str) {
        this.svar5 = str;
        return this;
    }

    public ClickFunctionTask(AbstractFunction abstractFunction, String str) {
        super(abstractFunction, str);
    }

    public ClickFunctionTask setIp(List<String> list) {
        this.ip = null;
        if (list != null && list.size() > 0) {
            this.ip = "";
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                this.ip += it.next() + ",";
            }
            if (this.ip != null && list.size() > 0) {
                this.ip = this.ip.substring(0, r5.length() - 1);
            }
        }
        return this;
    }
}
