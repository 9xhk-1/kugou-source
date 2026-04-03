package com.kugou.common.permission.checker;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import com.kugou.common.permission.checker.OuterAccessors;
import com.kugou.common.permission.checker.PermissionTest;
import com.tme.fireeye.crash.comm.db.DbOpenHelper;

/* JADX INFO: loaded from: classes2.dex */
public class ContactsReadTest implements PermissionTest {
    private ContentResolver mResolver;

    public ContactsReadTest(Context context) {
        this.mResolver = context.getContentResolver();
    }

    @Override // com.kugou.common.permission.checker.PermissionTest
    public boolean test() throws Throwable {
        Uri uri = ContactsContract.CommonDataKinds.Phone.CONTENT_URI;
        String[] strArr = {DbOpenHelper.ID, "data1"};
        OuterAccessors.Provider providerPickProvider = PermissionTest.ACCESSOR.pickProvider();
        Cursor cursorQuery = providerPickProvider != null ? providerPickProvider.query(this.mResolver, uri, strArr, null, null, null) : this.mResolver.query(uri, strArr, null, null, null);
        if (cursorQuery == null) {
            return false;
        }
        try {
            PermissionTest.CursorTest.read(cursorQuery);
            cursorQuery.close();
            return true;
        } catch (Throwable th) {
            cursorQuery.close();
            throw th;
        }
    }
}
