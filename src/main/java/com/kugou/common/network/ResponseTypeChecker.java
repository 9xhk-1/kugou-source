package com.kugou.common.network;

import com.kugou.common.network.protocol.response.CheckIgnore;
import com.kugou.common.network.protocol.response.CheckImage;
import com.kugou.common.network.protocol.response.CheckJson;
import com.kugou.common.network.protocol.response.CheckNotEmpty;
import com.kugou.common.network.protocol.response.IResponseTypeChecker;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes2.dex */
public class ResponseTypeChecker {
    public static final int IGNORE = 4;
    public static final int IMAGE = 3;
    public static final int JSON = 1;
    public static final int LYRIC = 2;
    public static final int NOT_EMPTY = 0;

    /* JADX INFO: loaded from: classes.dex */
    @Retention(RetentionPolicy.SOURCE)
    public @interface CheckType {
    }

    public static class ResponseType {
        private IResponseTypeChecker checker;
        public static ResponseType NOT_EMPTY = new ResponseType(new CheckNotEmpty());
        public static ResponseType JSON = new ResponseType(new CheckJson());
        public static ResponseType LYRIC = null;
        public static ResponseType IMAGE = new ResponseType(new CheckImage());
        public static ResponseType IGNORE = new ResponseType(new CheckIgnore());

        public ResponseType(IResponseTypeChecker iResponseTypeChecker) {
            this.checker = iResponseTypeChecker;
        }

        public boolean checkResponseType(byte[] bArr) {
            return this.checker.checkResponseType(bArr);
        }

        public int getCheckType() {
            return this.checker.getCheckType();
        }
    }
}
