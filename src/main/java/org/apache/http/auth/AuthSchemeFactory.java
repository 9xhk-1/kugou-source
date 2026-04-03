package org.apache.http.auth;

import org.apache.http.params.HttpParams;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated
public interface AuthSchemeFactory {
    AuthScheme newInstance(HttpParams httpParams);
}
