package com.kugou.framework.bilib.bi.task;

import android.text.TextUtils;
import com.kugou.framework.bilib.bi.AbsFunctionTask;
import com.kugou.framework.bilib.bi.easytrace.AbstractFunction;

/* JADX INFO: loaded from: classes2.dex */
public class CommonFunctionTask extends AbsFunctionTask {
    private long castTime;
    public String userid;

    public CommonFunctionTask(AbstractFunction abstractFunction) {
        super(abstractFunction);
        this.castTime = abstractFunction.getCastTime();
        abstractFunction.end();
    }

    @Override // com.kugou.framework.bilib.bi.AbsFunctionTask, com.kugou.framework.bilib.bi.AbstractTraceTask
    public void assembleKeyValueList() {
        super.assembleKeyValueList();
        if (!TextUtils.isEmpty(this.userid)) {
            this.mKeyValueList.add("userid", this.userid);
        }
        long j = this.castTime;
        if (j != 0) {
            this.mKeyValueList.add("spt", j);
        }
    }

    public CommonFunctionTask(AbstractFunction abstractFunction, String str) {
        super(abstractFunction, str);
        this.castTime = this.mItem.getCastTime();
        this.mItem.end();
    }
}
