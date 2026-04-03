package com.kugou.framework.bilib.bi;

import android.text.TextUtils;
import com.kugou.framework.bilib.bi.easytrace.AbstractFunction;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public class AbsFunctionTask extends AbstractTraceTask {
    public String action;
    private HashMap<String, Object> customParamMap;
    public String ft;
    public AbstractFunction mItem;

    public AbsFunctionTask(AbstractFunction abstractFunction) {
        this.customParamMap = new HashMap<>();
        this.mItem = abstractFunction;
        if (abstractFunction != null) {
            this.ft = abstractFunction.getDest();
        }
    }

    @Override // com.kugou.framework.bilib.bi.AbstractTraceTask
    public void assembleKeyValueList() {
        AbstractFunction abstractFunction = this.mItem;
        if (abstractFunction != null) {
            this.mKeyValueList.add("a", abstractFunction.getId());
            this.mKeyValueList.add("b", this.mItem.getName());
            this.mKeyValueList.add("r", this.mItem.getCategory());
        }
        if (!TextUtils.isEmpty(this.ft)) {
            this.mKeyValueList.add("ft", this.ft);
        }
        if (!TextUtils.isEmpty(this.action)) {
            this.mKeyValueList.add("action", this.action);
        }
        if (this.customParamMap.isEmpty()) {
            return;
        }
        for (String str : this.customParamMap.keySet()) {
            this.mKeyValueList.add(str, this.customParamMap.get(str).toString());
        }
    }

    public AbsFunctionTask setAction(String str) {
        this.action = str;
        return this;
    }

    public void setCustomParamMap(HashMap<String, Object> map) {
        this.customParamMap = map;
    }

    public AbsFunctionTask setFt(String str) {
        this.ft = str;
        return this;
    }

    public AbsFunctionTask(AbstractFunction abstractFunction, String str) {
        this(abstractFunction);
        this.ft = str;
    }
}
