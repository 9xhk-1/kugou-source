package org.apache.http.auth;

import java.security.Principal;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated
public interface Credentials {
    String getPassword();

    Principal getUserPrincipal();
}
