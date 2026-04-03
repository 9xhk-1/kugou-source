package com.kugou.common.permission.rationale;

import com.kugou.common.permission.Rationale;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public abstract class BaseKGRationale<T> implements Rationale<T> {
    public abstract String rationaleKey(List<String> list);
}
