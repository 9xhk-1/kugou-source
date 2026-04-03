package com.kugou.framework.musichunter;

import android.util.Log;
import com.kugou.framework.musichunter.fp2013.Fingerprint2013;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class BufferedResampler {
    private Fingerprint2013 fp2013 = new Fingerprint2013();
    private ArrayList<byte[]> pcm8ks = new ArrayList<>();
    private int bufferMS = 1000;
    private int samples = 44100;
    private byte[] sliceBuffer = new byte[((44100 * 1000) * 2) / 1000];
    private int sliceBufferSize = 0;

    private static byte[] copyOfRange(byte[] bArr, int i2, int i3) {
        int i4 = i3 - i2;
        byte[] bArr2 = new byte[i4];
        System.arraycopy(bArr, i2, bArr2, 0, i4);
        return bArr2;
    }

    private boolean pushBuffer(byte[] bArr, int i2, int i3) {
        byte[] bArrCopyOfRange;
        boolean z;
        if (bArr == null) {
            int i4 = this.sliceBufferSize;
            if (i4 > 0) {
                bArrCopyOfRange = copyOfRange(this.sliceBuffer, 0, i4);
                z = true;
            }
            bArrCopyOfRange = null;
            z = false;
        } else {
            System.arraycopy(bArr, i2, this.sliceBuffer, this.sliceBufferSize, i3);
            int i5 = this.sliceBufferSize + i3;
            this.sliceBufferSize = i5;
            byte[] bArr2 = this.sliceBuffer;
            if (i5 >= bArr2.length) {
                bArrCopyOfRange = copyOfRange(bArr2, 0, i5);
                z = true;
            }
            bArrCopyOfRange = null;
            z = false;
        }
        if (!z) {
            return false;
        }
        this.sliceBufferSize = 0;
        if (this.samples == MusicRecord.samples) {
            this.pcm8ks.add(bArrCopyOfRange);
        } else {
            if (!Fingerprint2013.loadOK()) {
                return false;
            }
            int i6 = MusicRecord.samples;
            byte[] bArr3 = new byte[i6 * 2];
            int iResample = this.fp2013.resample(this.samples, 1, bArrCopyOfRange, i6, bArr3);
            if (iResample > 0) {
                if (iResample != ((this.bufferMS * MusicRecord.samples) * 2) / 1000) {
                    Log.e("fp2103", "buffer resample wrong: input " + bArrCopyOfRange.length + " bytes to output " + iResample + "bytes");
                }
                this.pcm8ks.add(copyOfRange(bArr3, 0, iResample));
            }
        }
        return true;
    }

    public void clear() {
        this.pcm8ks.clear();
        this.sliceBufferSize = 0;
    }

    public int getOutputSliceSize(int i2) {
        return (RecordType.isHunterType(i2) ? this.bufferMS * 8 : this.bufferMS * 16) * 2;
    }

    public boolean push(byte[] bArr, int i2) {
        boolean zPushBuffer = false;
        if (bArr == null) {
            pushBuffer(null, 0, 0);
            return true;
        }
        int i3 = 0;
        while (i2 > 0) {
            int length = this.sliceBuffer.length - this.sliceBufferSize;
            if (length > i2) {
                length = i2;
            }
            zPushBuffer |= pushBuffer(bArr, i3, length);
            i3 += length;
            i2 -= length;
        }
        return zPushBuffer;
    }

    public int read(int i2, int i3, byte[] bArr, int i4) {
        int length = bArr.length - i4;
        if (length <= 0) {
            return 0;
        }
        int i5 = 0;
        for (int i6 = 0; i6 < i3; i6++) {
            int i7 = i2 + i6;
            if (i7 >= this.pcm8ks.size()) {
                return i5;
            }
            byte[] bArr2 = this.pcm8ks.get(i7);
            int iMin = Math.min(length, bArr2.length);
            System.arraycopy(bArr2, 0, bArr, i4 + i5, iMin);
            i5 += iMin;
            length -= iMin;
        }
        return i5;
    }

    public void reset(int i2) {
        this.samples = i2;
        this.sliceBuffer = new byte[((i2 * this.bufferMS) * 2) / 1000];
        clear();
    }

    public int validSlices() {
        return this.pcm8ks.size();
    }
}
