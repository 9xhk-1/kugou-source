package com.kugou.common.permission.checker;

import android.content.Context;
import android.media.MediaRecorder;
import java.io.File;

/* JADX INFO: loaded from: classes2.dex */
public class RecordAudioTest implements PermissionTest {
    private Context mContext;

    public RecordAudioTest(Context context) {
        this.mContext = context;
    }

    @Override // com.kugou.common.permission.checker.PermissionTest
    public boolean test() throws Throwable {
        MediaRecorder mediaRecorder = new MediaRecorder();
        File fileCreateTempFile = null;
        try {
            try {
                fileCreateTempFile = File.createTempFile("permission", "test");
                mediaRecorder.setAudioSource(1);
                mediaRecorder.setOutputFormat(3);
                mediaRecorder.setAudioEncoder(1);
                mediaRecorder.setOutputFile(fileCreateTempFile.getAbsolutePath());
                mediaRecorder.prepare();
                mediaRecorder.start();
                try {
                    mediaRecorder.stop();
                } catch (Exception unused) {
                }
                try {
                    mediaRecorder.release();
                } catch (Exception unused2) {
                }
                if (fileCreateTempFile != null && fileCreateTempFile.exists()) {
                    fileCreateTempFile.delete();
                }
                return true;
            } catch (Throwable th) {
                try {
                    mediaRecorder.stop();
                } catch (Exception unused3) {
                }
                try {
                    mediaRecorder.release();
                } catch (Exception unused4) {
                }
                if (fileCreateTempFile == null || !fileCreateTempFile.exists()) {
                    throw th;
                }
                fileCreateTempFile.delete();
                throw th;
            }
        } catch (Throwable unused5) {
            boolean zHasSystemFeature = true ^ this.mContext.getPackageManager().hasSystemFeature("android.hardware.microphone");
            try {
                mediaRecorder.stop();
            } catch (Exception unused6) {
            }
            try {
                mediaRecorder.release();
            } catch (Exception unused7) {
            }
            if (fileCreateTempFile != null && fileCreateTempFile.exists()) {
                fileCreateTempFile.delete();
            }
            return zHasSystemFeature;
        }
    }
}
