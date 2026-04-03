package com.kugou.common.config;

import android.text.TextUtils;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes2.dex */
public class ConfigValue {
    public static final int INDEX_NONE = -1;
    private int index;
    private Object lock = new Object();
    public String schemeCode = "";
    private final State[] states;

    public static class State {
        public int failCount = 0;
        public final int retryCount;
        public final String value;

        public State(String str, int i2) {
            this.value = str;
            this.retryCount = i2;
        }
    }

    public ConfigValue(String str) {
        this.index = -1;
        if (TextUtils.isEmpty(str)) {
            this.states = null;
            return;
        }
        String[] strArrSplit = str.split("\\|");
        int length = strArrSplit.length;
        this.states = new State[length];
        for (int i2 = 0; i2 < length; i2++) {
            String strUpdateSchemeCode = updateSchemeCode(strArrSplit[i2]);
            if (i2 == 0) {
                this.states[i2] = new State(strUpdateSchemeCode, 0);
            } else {
                this.states[i2] = new State(strUpdateSchemeCode, 0);
            }
        }
        this.index = 0;
    }

    private boolean hasValidStates() {
        State[] stateArr = this.states;
        return stateArr != null && stateArr.length > 0;
    }

    public boolean equals(Object obj) {
        return (obj == null || !(obj instanceof ConfigValue)) ? super.equals(obj) : getInternalValue().equals(((ConfigValue) obj).getInternalValue());
    }

    public String[] getAllValues() {
        String[] strArr;
        if (!hasValidStates()) {
            KGConfigLog.d("ConfigValue", "getAllValues null");
            return null;
        }
        synchronized (this.lock) {
            strArr = new String[this.states.length];
            int i2 = 0;
            while (true) {
                State[] stateArr = this.states;
                if (i2 < stateArr.length) {
                    strArr[i2] = stateArr[i2].value;
                    i2++;
                }
            }
        }
        return strArr;
    }

    public int getCurIndex() {
        return this.index;
    }

    public String getInternalValue() {
        if (!hasValidStates()) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (State state : this.states) {
            stringBuffer.append(state.value);
        }
        return stringBuffer.toString();
    }

    public int getTryCount() {
        if (!hasValidStates()) {
            return 0;
        }
        State[] stateArr = this.states;
        int length = stateArr.length + 0;
        for (State state : stateArr) {
            length += state.retryCount;
        }
        return length;
    }

    public String getValue() {
        String str;
        if (!hasValidStates()) {
            return "";
        }
        synchronized (this.lock) {
            str = this.states[this.index].value;
        }
        return str;
    }

    public int hashCode() {
        return getInternalValue().hashCode();
    }

    public String toString() {
        return getInternalValue().toString();
    }

    public void triggerFail(String str) {
        if (!hasValidStates() || TextUtils.isEmpty(str)) {
            return;
        }
        synchronized (this.lock) {
            int i2 = 0;
            while (true) {
                State[] stateArr = this.states;
                if (i2 >= stateArr.length) {
                    break;
                }
                State state = stateArr[i2];
                if (str.equals(state.value)) {
                    state.failCount++;
                    KGConfigLog.d(BaseConfigManager.TAG, "[" + state.failCount + "/" + (state.retryCount + 1) + "]次失败url:" + state.value);
                    break;
                }
                i2++;
            }
            State[] stateArr2 = this.states;
            int i3 = this.index;
            State state2 = stateArr2[i3];
            if (state2.failCount > state2.retryCount) {
                state2.failCount = 0;
                this.index = (i3 + 1) % stateArr2.length;
                KGConfigLog.d(BaseConfigManager.TAG, "切换url:" + this.states[this.index].value);
            }
        }
    }

    public String updateSchemeCode(String str) {
        if (!str.startsWith("http:") && !str.startsWith("https:")) {
            return str;
        }
        Matcher matcher = Pattern.compile("\\{(.*)\\}").matcher(str);
        if (matcher.find()) {
            this.schemeCode = matcher.group(1);
        }
        return str.replace("{" + this.schemeCode + "}", "");
    }

    public String getValue(int i2) {
        String str;
        if (!hasValidStates() || i2 >= this.states.length) {
            return "";
        }
        synchronized (this.lock) {
            str = this.states[i2].value;
        }
        return str;
    }
}
