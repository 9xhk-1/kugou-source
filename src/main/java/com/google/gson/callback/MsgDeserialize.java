package com.google.gson.callback;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class MsgDeserialize {
    public static final int FLAG_ERROR_VALUE_NECESSARY = 4;
    public static final int FLAG_FAILED_JSON_SYNTAX = 8;
    public static final int FLAG_FAILED_MISS_NECESSARY = 2;
    public static final int FLAG_SUCCESS = 1;
    private ArrayList<Throwable> errors;
    private int flag;
    private StringBuilder msgNecessary = null;
    public StringBuilder msgErrorValue = null;

    public void appendMsgErrorValue(String str) {
        if (str == null || str == "") {
            return;
        }
        if (this.msgErrorValue == null) {
            this.msgErrorValue = new StringBuilder();
        }
        this.msgErrorValue.append(String.valueOf(str) + "\n");
    }

    public void appendMsgNecessary(String str) {
        if (str == null || str == "") {
            return;
        }
        if (this.msgNecessary == null) {
            this.msgNecessary = new StringBuilder();
        }
        this.msgNecessary.append(str);
    }

    public StringBuilder getMsgErrorVaule() {
        return this.msgErrorValue;
    }

    public StringBuilder getMsgNecessary() {
        return this.msgNecessary;
    }

    public ArrayList<Throwable> getThrowables() {
        return this.errors;
    }

    public boolean hasTypeError() {
        return hasTypeError(this.flag);
    }

    public boolean hasTypeError(int i2) {
        return (i2 & 4) > 0;
    }

    public boolean isJsonSyntaxError() {
        return isJsonSyntaxError(this.flag);
    }

    public boolean isJsonSyntaxError(int i2) {
        return (i2 & 8) > 0;
    }

    public boolean isMissNecessary() {
        return isMissNecessary(this.flag);
    }

    public boolean isMissNecessary(int i2) {
        return (i2 & 2) > 0;
    }

    public boolean isSucess() {
        return (this.flag & 1) > 0;
    }

    public void missNecessary() {
        this.flag |= 2;
    }

    public void putThrowable(Throwable th) {
        if (this.errors == null) {
            this.errors = new ArrayList<>();
        }
        this.errors.add(th);
    }

    public void setHasTypeError() {
        this.flag |= 4;
    }

    public void setJsonSyntaxError() {
        this.flag |= 8;
    }

    public void success() {
        this.flag |= 1;
    }

    public String toString() {
        String str = "hasTypeError " + hasTypeError() + ",missNecessary " + isMissNecessary() + ",isJsonSyntaxError " + isJsonSyntaxError();
        if (this.errors != null) {
            String str2 = String.valueOf(str) + "; errors.size:" + this.errors.size();
            for (int i2 = 0; i2 < this.errors.size(); i2++) {
                this.errors.get(i2).printStackTrace();
            }
            str = str2;
        }
        return "msgNecessary:" + ((Object) this.msgNecessary) + "; msgErrorValue " + ((Object) this.msgErrorValue) + "; \nexcption " + str;
    }
}
