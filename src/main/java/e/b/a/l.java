package e.b.a;

import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.FragmentTransaction;
import com.google.android.material.behavior.HideBottomViewOnScrollBehavior;
import com.kugou.common.filemanager.downloadengine.entity.FileManagerErrorCode;
import com.xtc.shareapi.share.constant.OpenApiConstant;
import org.apache.http.HttpStatus;

/* JADX INFO: loaded from: classes.dex */
public final class l {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int[] f318g = {96, 7, 256, 0, 8, 80, 0, 8, 16, 84, 8, 115, 82, 7, 31, 0, 8, 112, 0, 8, 48, 0, 9, 192, 80, 7, 10, 0, 8, 96, 0, 8, 32, 0, 9, 160, 0, 8, 0, 0, 8, 128, 0, 8, 64, 0, 9, 224, 80, 7, 6, 0, 8, 88, 0, 8, 24, 0, 9, 144, 83, 7, 59, 0, 8, 120, 0, 8, 56, 0, 9, 208, 81, 7, 17, 0, 8, 104, 0, 8, 40, 0, 9, 176, 0, 8, 8, 0, 8, FileManagerErrorCode.ENGINE_CANT_DECRYPT_FILE, 0, 8, 72, 0, 9, OpenApiConstant.DialogBitmapArgsConstant.DIALOG_WIDTH_3, 80, 7, 4, 0, 8, 84, 0, 8, 20, 85, 8, 227, 83, 7, 43, 0, 8, 116, 0, 8, 52, 0, 9, 200, 81, 7, 13, 0, 8, 100, 0, 8, 36, 0, 9, OpenApiConstant.MessageBitmapArgsConstant.MESSAGE_WIDTH_3, 0, 8, 4, 0, 8, FileManagerErrorCode.ENGINE_CANT_READ_SOURCE_FILE, 0, 8, 68, 0, 9, 232, 80, 7, 8, 0, 8, 92, 0, 8, 28, 0, 9, 152, 84, 7, 83, 0, 8, 124, 0, 8, 60, 0, 9, 216, 82, 7, 23, 0, 8, 108, 0, 8, 44, 0, 9, 184, 0, 8, 12, 0, 8, 140, 0, 8, 76, 0, 9, 248, 80, 7, 3, 0, 8, 82, 0, 8, 18, 85, 8, 163, 83, 7, 35, 0, 8, 114, 0, 8, 50, 0, 9, OpenApiConstant.DialogBitmapArgsConstant.DIALOG_WIDTH_4, 81, 7, 11, 0, 8, 98, 0, 8, 34, 0, 9, 164, 0, 8, 2, 0, 8, FileManagerErrorCode.ENGINE_TARGET_ALREADY_EXISTS, 0, 8, 66, 0, 9, 228, 80, 7, 7, 0, 8, 90, 0, 8, 26, 0, 9, 148, 84, 7, 67, 0, 8, 122, 0, 8, 58, 0, 9, 212, 82, 7, 19, 0, 8, 106, 0, 8, 42, 0, 9, 180, 0, 8, 10, 0, 8, 138, 0, 8, 74, 0, 9, 244, 80, 7, 5, 0, 8, 86, 0, 8, 22, 192, 8, 0, 83, 7, 51, 0, 8, 118, 0, 8, 54, 0, 9, HttpStatus.SC_NO_CONTENT, 81, 7, 15, 0, 8, 102, 0, 8, 38, 0, 9, 172, 0, 8, 6, 0, 8, FileManagerErrorCode.ENGINE_CANT_WRITE_TARGET_FILE, 0, 8, 70, 0, 9, 236, 80, 7, 9, 0, 8, 94, 0, 8, 30, 0, 9, OpenApiConstant.MessageBitmapArgsConstant.MESSAGE_HEIGHT_2, 84, 7, 99, 0, 8, 126, 0, 8, 62, 0, 9, 220, 82, 7, 27, 0, 8, 110, 0, 8, 46, 0, 9, 188, 0, 8, 14, 0, 8, 142, 0, 8, 78, 0, 9, 252, 96, 7, 256, 0, 8, 81, 0, 8, 17, 85, 8, FileManagerErrorCode.ENGINE_CANT_OPEN_SOURCE_FILE, 82, 7, 31, 0, 8, 113, 0, 8, 49, 0, 9, 194, 80, 7, 10, 0, 8, 97, 0, 8, 33, 0, 9, 162, 0, 8, 1, 0, 8, FileManagerErrorCode.ENGINE_P2P_FILE_SIZE_CONFLICT, 0, 8, 65, 0, 9, 226, 80, 7, 6, 0, 8, 89, 0, 8, 25, 0, 9, 146, 83, 7, 59, 0, 8, 121, 0, 8, 57, 0, 9, 210, 81, 7, 17, 0, 8, 105, 0, 8, 41, 0, 9, 178, 0, 8, 9, 0, 8, FileManagerErrorCode.ENGINE_BAD_CRYPTED_FILE, 0, 8, 73, 0, 9, 242, 80, 7, 4, 0, 8, 85, 0, 8, 21, 80, 8, 258, 83, 7, 43, 0, 8, 117, 0, 8, 53, 0, 9, 202, 81, 7, 13, 0, 8, 101, 0, 8, 37, 0, 9, 170, 0, 8, 5, 0, 8, FileManagerErrorCode.ENGINE_CANT_CREATE_TARGET_FILE, 0, 8, 69, 0, 9, 234, 80, 7, 8, 0, 8, 93, 0, 8, 29, 0, 9, OpenApiConstant.MessageBitmapArgsConstant.MESSAGE_HEIGHT_3, 84, 7, 83, 0, 8, 125, 0, 8, 61, 0, 9, 218, 82, 7, 23, 0, 8, 109, 0, 8, 45, 0, 9, 186, 0, 8, 13, 0, 8, FileManagerErrorCode.ENGINE_HUGE_STREAM_CONFLICT, 0, 8, 77, 0, 9, 250, 80, 7, 3, 0, 8, 83, 0, 8, 19, 85, 8, 195, 83, 7, 35, 0, 8, 115, 0, 8, 51, 0, 9, 198, 81, 7, 11, 0, 8, 99, 0, 8, 35, 0, 9, 166, 0, 8, 3, 0, 8, FileManagerErrorCode.ENGINE_CANT_OPEN_SOURCE_FILE, 0, 8, 67, 0, 9, 230, 80, 7, 7, 0, 8, 91, 0, 8, 27, 0, 9, 150, 84, 7, 67, 0, 8, 123, 0, 8, 59, 0, 9, OpenApiConstant.DialogBitmapArgsConstant.DIALOG_HEIGHT_1, 82, 7, 19, 0, 8, 107, 0, 8, 43, 0, 9, 182, 0, 8, 11, 0, 8, 139, 0, 8, 75, 0, 9, 246, 80, 7, 5, 0, 8, 87, 0, 8, 23, 192, 8, 0, 83, 7, 51, 0, 8, 119, 0, 8, 55, 0, 9, HttpStatus.SC_PARTIAL_CONTENT, 81, 7, 15, 0, 8, 103, 0, 8, 39, 0, 9, 174, 0, 8, 7, 0, 8, FileManagerErrorCode.ENGINE_CANT_CRYPT_FILE, 0, 8, 71, 0, 9, 238, 80, 7, 9, 0, 8, 95, 0, 8, 31, 0, 9, 158, 84, 7, 99, 0, 8, 127, 0, 8, 63, 0, 9, 222, 82, 7, 27, 0, 8, 111, 0, 8, 47, 0, 9, 190, 0, 8, 15, 0, 8, 143, 0, 8, 79, 0, 9, 254, 96, 7, 256, 0, 8, 80, 0, 8, 16, 84, 8, 115, 82, 7, 31, 0, 8, 112, 0, 8, 48, 0, 9, 193, 80, 7, 10, 0, 8, 96, 0, 8, 32, 0, 9, 161, 0, 8, 0, 0, 8, 128, 0, 8, 64, 0, 9, 225, 80, 7, 6, 0, 8, 88, 0, 8, 24, 0, 9, 145, 83, 7, 59, 0, 8, 120, 0, 8, 56, 0, 9, 209, 81, 7, 17, 0, 8, 104, 0, 8, 40, 0, 9, 177, 0, 8, 8, 0, 8, FileManagerErrorCode.ENGINE_CANT_DECRYPT_FILE, 0, 8, 72, 0, 9, 241, 80, 7, 4, 0, 8, 84, 0, 8, 20, 85, 8, 227, 83, 7, 43, 0, 8, 116, 0, 8, 52, 0, 9, 201, 81, 7, 13, 0, 8, 100, 0, 8, 36, 0, 9, 169, 0, 8, 4, 0, 8, FileManagerErrorCode.ENGINE_CANT_READ_SOURCE_FILE, 0, 8, 68, 0, 9, 233, 80, 7, 8, 0, 8, 92, 0, 8, 28, 0, 9, 153, 84, 7, 83, 0, 8, 124, 0, 8, 60, 0, 9, 217, 82, 7, 23, 0, 8, 108, 0, 8, 44, 0, 9, 185, 0, 8, 12, 0, 8, 140, 0, 8, 76, 0, 9, 249, 80, 7, 3, 0, 8, 82, 0, 8, 18, 85, 8, 163, 83, 7, 35, 0, 8, 114, 0, 8, 50, 0, 9, 197, 81, 7, 11, 0, 8, 98, 0, 8, 34, 0, 9, 165, 0, 8, 2, 0, 
    8, FileManagerErrorCode.ENGINE_TARGET_ALREADY_EXISTS, 0, 8, 66, 0, 9, 229, 80, 7, 7, 0, 8, 90, 0, 8, 26, 0, 9, 149, 84, 7, 67, 0, 8, 122, 0, 8, 58, 0, 9, 213, 82, 7, 19, 0, 8, 106, 0, 8, 42, 0, 9, 181, 0, 8, 10, 0, 8, 138, 0, 8, 74, 0, 9, 245, 80, 7, 5, 0, 8, 86, 0, 8, 22, 192, 8, 0, 83, 7, 51, 0, 8, 118, 0, 8, 54, 0, 9, HttpStatus.SC_RESET_CONTENT, 81, 7, 15, 0, 8, 102, 0, 8, 38, 0, 9, 173, 0, 8, 6, 0, 8, FileManagerErrorCode.ENGINE_CANT_WRITE_TARGET_FILE, 0, 8, 70, 0, 9, 237, 80, 7, 9, 0, 8, 94, 0, 8, 30, 0, 9, 157, 84, 7, 99, 0, 8, 126, 0, 8, 62, 0, 9, 221, 82, 7, 27, 0, 8, 110, 0, 8, 46, 0, 9, 189, 0, 8, 14, 0, 8, 142, 0, 8, 78, 0, 9, 253, 96, 7, 256, 0, 8, 81, 0, 8, 17, 85, 8, FileManagerErrorCode.ENGINE_CANT_OPEN_SOURCE_FILE, 82, 7, 31, 0, 8, 113, 0, 8, 49, 0, 9, 195, 80, 7, 10, 0, 8, 97, 0, 8, 33, 0, 9, 163, 0, 8, 1, 0, 8, FileManagerErrorCode.ENGINE_P2P_FILE_SIZE_CONFLICT, 0, 8, 65, 0, 9, 227, 80, 7, 6, 0, 8, 89, 0, 8, 25, 0, 9, 147, 83, 7, 59, 0, 8, 121, 0, 8, 57, 0, 9, 211, 81, 7, 17, 0, 8, 105, 0, 8, 41, 0, 9, 179, 0, 8, 9, 0, 8, FileManagerErrorCode.ENGINE_BAD_CRYPTED_FILE, 0, 8, 73, 0, 9, 243, 80, 7, 4, 0, 8, 85, 0, 8, 21, 80, 8, 258, 83, 7, 43, 0, 8, 117, 0, 8, 53, 0, 9, HttpStatus.SC_NON_AUTHORITATIVE_INFORMATION, 81, 7, 13, 0, 8, 101, 0, 8, 37, 0, 9, 171, 0, 8, 5, 0, 8, FileManagerErrorCode.ENGINE_CANT_CREATE_TARGET_FILE, 0, 8, 69, 0, 9, 235, 80, 7, 8, 0, 8, 93, 0, 8, 29, 0, 9, 155, 84, 7, 83, 0, 8, 125, 0, 8, 61, 0, 9, 219, 82, 7, 23, 0, 8, 109, 0, 8, 45, 0, 9, 187, 0, 8, 13, 0, 8, FileManagerErrorCode.ENGINE_HUGE_STREAM_CONFLICT, 0, 8, 77, 0, 9, 251, 80, 7, 3, 0, 8, 83, 0, 8, 19, 85, 8, 195, 83, 7, 35, 0, 8, 115, 0, 8, 51, 0, 9, 199, 81, 7, 11, 0, 8, 99, 0, 8, 35, 0, 9, 167, 0, 8, 3, 0, 8, FileManagerErrorCode.ENGINE_CANT_OPEN_SOURCE_FILE, 0, 8, 67, 0, 9, 231, 80, 7, 7, 0, 8, 91, 0, 8, 27, 0, 9, 151, 84, 7, 67, 0, 8, 123, 0, 8, 59, 0, 9, 215, 82, 7, 19, 0, 8, 107, 0, 8, 43, 0, 9, 183, 0, 8, 11, 0, 8, 139, 0, 8, 75, 0, 9, 247, 80, 7, 5, 0, 8, 87, 0, 8, 23, 192, 8, 0, 83, 7, 51, 0, 8, 119, 0, 8, 55, 0, 9, HttpStatus.SC_MULTI_STATUS, 81, 7, 15, 0, 8, 103, 0, 8, 39, 0, 9, HideBottomViewOnScrollBehavior.EXIT_ANIMATION_DURATION, 0, 8, 7, 0, 8, FileManagerErrorCode.ENGINE_CANT_CRYPT_FILE, 0, 8, 71, 0, 9, 239, 80, 7, 9, 0, 8, 95, 0, 8, 31, 0, 9, 159, 84, 7, 99, 0, 8, 127, 0, 8, 63, 0, 9, 223, 82, 7, 27, 0, 8, 111, 0, 8, 47, 0, 9, 191, 0, 8, 15, 0, 8, 143, 0, 8, 79, 0, 9, 255};

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int[] f319h = {80, 5, 1, 87, 5, 257, 83, 5, 17, 91, 5, FragmentTransaction.TRANSIT_FRAGMENT_OPEN, 81, 5, 5, 89, 5, InputDeviceCompat.SOURCE_GAMEPAD, 85, 5, 65, 93, 5, 16385, 80, 5, 3, 88, 5, InputDeviceCompat.SOURCE_DPAD, 84, 5, 33, 92, 5, 8193, 82, 5, 9, 90, 5, 2049, 86, 5, FileManagerErrorCode.ENGINE_P2P_FILE_SIZE_CONFLICT, 192, 5, 24577, 80, 5, 2, 87, 5, 385, 83, 5, 25, 91, 5, 6145, 81, 5, 7, 89, 5, 1537, 85, 5, 97, 93, 5, 24577, 80, 5, 4, 88, 5, 769, 84, 5, 49, 92, 5, 12289, 82, 5, 13, 90, 5, 3073, 86, 5, 193, 192, 5, 24577};

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int[] f320i = {3, 4, 5, 6, 7, 8, 9, 10, 11, 13, 15, 17, 19, 23, 27, 31, 35, 43, 51, 59, 67, 83, 99, 115, FileManagerErrorCode.ENGINE_CANT_OPEN_SOURCE_FILE, 163, 195, 227, 258, 0, 0};
    public static final int[] j = {0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 5, 0, 112, 112};
    public static final int[] k = {1, 2, 3, 4, 5, 7, 9, 13, 17, 25, 33, 49, 65, 97, FileManagerErrorCode.ENGINE_P2P_FILE_SIZE_CONFLICT, 193, 257, 385, InputDeviceCompat.SOURCE_DPAD, 769, InputDeviceCompat.SOURCE_GAMEPAD, 1537, 2049, 3073, FragmentTransaction.TRANSIT_FRAGMENT_OPEN, 6145, 8193, 12289, 16385, 24577};
    public static final int[] l = {0, 0, 0, 0, 1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7, 8, 8, 9, 9, 10, 10, 11, 11, 12, 12, 13, 13};
    public int[] a = null;
    public int[] b = null;
    public int[] c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int[] f321d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int[] f322e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int[] f323f = null;

    public static int d(int[] iArr, int[] iArr2, int[][] iArr3, int[][] iArr4, t tVar) {
        iArr[0] = 9;
        iArr2[0] = 5;
        iArr3[0] = f318g;
        iArr4[0] = f319h;
        return 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:49:0x00a9, code lost:
    
        r15 = r15 + 1;
        r9 = r5;
        r5 = r12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00b5, code lost:
    
        r14 = r23.f321d;
        r4 = r15 - r1;
        r21 = r13;
        r14[r10] = (byte) r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00be, code lost:
    
        if (r5 < r8) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00c0, code lost:
    
        r14[0] = 192;
        r10 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x00c7, code lost:
    
        r5 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x00cd, code lost:
    
        if (r34[r5] >= r2) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x00d3, code lost:
    
        if (r34[r5] >= 256) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00d5, code lost:
    
        r10 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00d7, code lost:
    
        r10 = 96;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x00d9, code lost:
    
        r14[0] = (byte) r10;
        r10 = r5 + 1;
        r14[2] = r34[r5];
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x00e4, code lost:
    
        r14[0] = (byte) ((r29[r34[r5] - r2] + 16) + 64);
        r10 = r5 + 1;
        r14[2] = r28[r34[r5] - r2];
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x00fc, code lost:
    
        r4 = 1 << r4;
        r13 = r12 >>> r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0100, code lost:
    
        if (r13 < r9) goto L76;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0102, code lost:
    
        r4 = r5 << (r15 - 1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x0108, code lost:
    
        if ((r12 & r4) != 0) goto L75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x010a, code lost:
    
        r13 = r12 ^ r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x0114, code lost:
    
        if ((((r5 << r1) - r5) & r13) != r23.f323f[r17]) goto L74;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x0121, code lost:
    
        r17 = r17 - 1;
        r1 = r1 - r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0125, code lost:
    
        r12 = r12 ^ r4;
        r4 = r4 >>> 1;
        r5 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x012a, code lost:
    
        java.lang.System.arraycopy(r23.f321d, 0, r32, (r11 + r13) * 3, 3);
        r13 = r13 + r4;
        r1 = r1;
        r2 = r27;
        r5 = 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int a(int[] r24, int r25, int r26, int r27, int[] r28, int[] r29, int[] r30, int[] r31, int[] r32, int[] r33, int[] r34) {
        /*
            Method dump skipped, instruction units count: 505
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: e.b.a.l.a(int[], int, int, int, int[], int[], int[], int[], int[], int[], int[]):int");
    }

    public int b(int[] iArr, int[] iArr2, int[] iArr3, int[] iArr4, t tVar) {
        e(19);
        int[] iArr5 = this.a;
        iArr5[0] = 0;
        int iA = a(iArr, 0, 19, 19, null, null, iArr3, iArr2, iArr4, iArr5, this.b);
        if (iA == -3) {
            tVar.f359i = "oversubscribed dynamic bit lengths tree";
            return iA;
        }
        if (iA != -5 && iArr2[0] != 0) {
            return iA;
        }
        tVar.f359i = "incomplete dynamic bit lengths tree";
        return -3;
    }

    public int c(int i2, int i3, int[] iArr, int[] iArr2, int[] iArr3, int[] iArr4, int[] iArr5, int[] iArr6, t tVar) {
        e(288);
        int[] iArr7 = this.a;
        iArr7[0] = 0;
        int iA = a(iArr, 0, i2, 257, f320i, j, iArr4, iArr2, iArr6, iArr7, this.b);
        if (iA != 0 || iArr2[0] == 0) {
            if (iA == -3) {
                tVar.f359i = "oversubscribed literal/length tree";
                return iA;
            }
            if (iA == -4) {
                return iA;
            }
            tVar.f359i = "incomplete literal/length tree";
            return -3;
        }
        e(288);
        int iA2 = a(iArr, i2, i3, 0, k, l, iArr5, iArr3, iArr6, this.a, this.b);
        if (iA2 == 0 && (iArr3[0] != 0 || i2 <= 257)) {
            return 0;
        }
        if (iA2 == -3) {
            tVar.f359i = "oversubscribed distance tree";
            return iA2;
        }
        if (iA2 == -5) {
            tVar.f359i = "incomplete distance tree";
        } else {
            if (iA2 == -4) {
                return iA2;
            }
            tVar.f359i = "empty distance tree with lengths";
        }
        return -3;
    }

    public final void e(int i2) {
        if (this.a == null) {
            this.a = new int[1];
            this.b = new int[i2];
            this.c = new int[16];
            this.f321d = new int[3];
            this.f322e = new int[15];
            this.f323f = new int[16];
        }
        if (this.b.length < i2) {
            this.b = new int[i2];
        }
        for (int i3 = 0; i3 < i2; i3++) {
            this.b[i3] = 0;
        }
        for (int i4 = 0; i4 < 16; i4++) {
            this.c[i4] = 0;
        }
        for (int i5 = 0; i5 < 3; i5++) {
            this.f321d[i5] = 0;
        }
        System.arraycopy(this.c, 0, this.f322e, 0, 15);
        System.arraycopy(this.c, 0, this.f323f, 0, 16);
    }
}
