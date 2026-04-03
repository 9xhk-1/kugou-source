package com.google.zxing.common;

/* JADX INFO: loaded from: classes.dex */
public final class BitArray {
    private int[] bits;
    private int size;

    public BitArray() {
        this.size = 0;
        this.bits = new int[1];
    }

    private void ensureCapacity(int i2) {
        if (i2 > (this.bits.length << 5)) {
            int[] iArrMakeArray = makeArray(i2);
            int[] iArr = this.bits;
            System.arraycopy(iArr, 0, iArrMakeArray, 0, iArr.length);
            this.bits = iArrMakeArray;
        }
    }

    private static int[] makeArray(int i2) {
        return new int[(i2 + 31) >> 5];
    }

    public void appendBit(boolean z) {
        ensureCapacity(this.size + 1);
        if (z) {
            int[] iArr = this.bits;
            int i2 = this.size;
            int i3 = i2 >> 5;
            iArr[i3] = (1 << (i2 & 31)) | iArr[i3];
        }
        this.size++;
    }

    public void appendBitArray(BitArray bitArray) {
        int i2 = bitArray.size;
        ensureCapacity(this.size + i2);
        for (int i3 = 0; i3 < i2; i3++) {
            appendBit(bitArray.get(i3));
        }
    }

    public void appendBits(int i2, int i3) {
        if (i3 < 0 || i3 > 32) {
            throw new IllegalArgumentException("Num bits must be between 0 and 32");
        }
        ensureCapacity(this.size + i3);
        while (i3 > 0) {
            boolean z = true;
            if (((i2 >> (i3 - 1)) & 1) != 1) {
                z = false;
            }
            appendBit(z);
            i3--;
        }
    }

    public void clear() {
        int length = this.bits.length;
        for (int i2 = 0; i2 < length; i2++) {
            this.bits[i2] = 0;
        }
    }

    public void flip(int i2) {
        int[] iArr = this.bits;
        int i3 = i2 >> 5;
        iArr[i3] = (1 << (i2 & 31)) ^ iArr[i3];
    }

    public boolean get(int i2) {
        return ((1 << (i2 & 31)) & this.bits[i2 >> 5]) != 0;
    }

    public int[] getBitArray() {
        return this.bits;
    }

    public int getNextSet(int i2) {
        int i3 = this.size;
        if (i2 >= i3) {
            return i3;
        }
        int i4 = i2 >> 5;
        int i5 = (((1 << (i2 & 31)) - 1) ^ (-1)) & this.bits[i4];
        while (i5 == 0) {
            i4++;
            int[] iArr = this.bits;
            if (i4 == iArr.length) {
                return this.size;
            }
            i5 = iArr[i4];
        }
        int iNumberOfTrailingZeros = (i4 << 5) + Integer.numberOfTrailingZeros(i5);
        int i6 = this.size;
        return iNumberOfTrailingZeros > i6 ? i6 : iNumberOfTrailingZeros;
    }

    public int getNextUnset(int i2) {
        int i3 = this.size;
        if (i2 >= i3) {
            return i3;
        }
        int i4 = i2 >> 5;
        int i5 = (((1 << (i2 & 31)) - 1) ^ (-1)) & (this.bits[i4] ^ (-1));
        while (i5 == 0) {
            i4++;
            int[] iArr = this.bits;
            if (i4 == iArr.length) {
                return this.size;
            }
            i5 = iArr[i4] ^ (-1);
        }
        int iNumberOfTrailingZeros = (i4 << 5) + Integer.numberOfTrailingZeros(i5);
        int i6 = this.size;
        return iNumberOfTrailingZeros > i6 ? i6 : iNumberOfTrailingZeros;
    }

    public int getSize() {
        return this.size;
    }

    public int getSizeInBytes() {
        return (this.size + 7) >> 3;
    }

    public boolean isRange(int i2, int i3, boolean z) {
        int i4;
        if (i3 < i2) {
            throw new IllegalArgumentException();
        }
        if (i3 == i2) {
            return true;
        }
        int i5 = i3 - 1;
        int i6 = i2 >> 5;
        int i7 = i5 >> 5;
        int i8 = i6;
        while (i8 <= i7) {
            int i9 = i8 > i6 ? 0 : i2 & 31;
            int i10 = i8 < i7 ? 31 : i5 & 31;
            if (i9 == 0 && i10 == 31) {
                i4 = -1;
            } else {
                i4 = 0;
                while (i9 <= i10) {
                    i4 |= 1 << i9;
                    i9++;
                }
            }
            int i11 = this.bits[i8] & i4;
            if (!z) {
                i4 = 0;
            }
            if (i11 != i4) {
                return false;
            }
            i8++;
        }
        return true;
    }

    public void reverse() {
        int[] iArr = new int[this.bits.length];
        int i2 = this.size;
        for (int i3 = 0; i3 < i2; i3++) {
            if (get((i2 - i3) - 1)) {
                int i4 = i3 >> 5;
                iArr[i4] = (1 << (i3 & 31)) | iArr[i4];
            }
        }
        this.bits = iArr;
    }

    public void set(int i2) {
        int[] iArr = this.bits;
        int i3 = i2 >> 5;
        iArr[i3] = (1 << (i2 & 31)) | iArr[i3];
    }

    public void setBulk(int i2, int i3) {
        this.bits[i2 >> 5] = i3;
    }

    public void setRange(int i2, int i3) {
        if (i3 < i2) {
            throw new IllegalArgumentException();
        }
        if (i3 != i2) {
            int i4 = i3 - 1;
            int i5 = i2 >> 5;
            int i6 = i4 >> 5;
            int i7 = i5;
            while (i7 <= i6) {
                int i8 = 0;
                int i9 = i7 > i5 ? 0 : i2 & 31;
                int i10 = i7 < i6 ? 31 : i4 & 31;
                if (i9 == 0 && i10 == 31) {
                    i8 = -1;
                } else {
                    while (i9 <= i10) {
                        i8 |= 1 << i9;
                        i9++;
                    }
                }
                int[] iArr = this.bits;
                iArr[i7] = i8 | iArr[i7];
                i7++;
            }
        }
    }

    public void toBytes(int i2, byte[] bArr, int i3, int i4) {
        for (int i5 = 0; i5 < i4; i5++) {
            int i6 = 0;
            for (int i7 = 0; i7 < 8; i7++) {
                if (get(i2)) {
                    i6 |= 1 << (7 - i7);
                }
                i2++;
            }
            bArr[i3 + i5] = (byte) i6;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(this.size);
        for (int i2 = 0; i2 < this.size; i2++) {
            if ((i2 & 7) == 0) {
                sb.append(' ');
            }
            sb.append(get(i2) ? 'X' : '.');
        }
        return sb.toString();
    }

    public void xor(BitArray bitArray) {
        if (this.bits.length != bitArray.bits.length) {
            throw new IllegalArgumentException("Sizes don't match");
        }
        int i2 = 0;
        while (true) {
            int[] iArr = this.bits;
            if (i2 >= iArr.length) {
                return;
            }
            iArr[i2] = iArr[i2] ^ bitArray.bits[i2];
            i2++;
        }
    }

    public BitArray(int i2) {
        this.size = i2;
        this.bits = makeArray(i2);
    }
}
