package okio;

/* JADX INFO: loaded from: classes2.dex */
public final class Segment {
    public static final int SHARE_MINIMUM = 1024;
    public static final int SIZE = 8192;
    public final byte[] data;
    public int limit;
    public Segment next;
    public boolean owner;
    public int pos;
    public Segment prev;
    public boolean shared;

    public Segment() {
        this.data = new byte[8192];
        this.owner = true;
        this.shared = false;
    }

    public void compact() {
        Segment segment = this.prev;
        if (segment == this) {
            throw new IllegalStateException();
        }
        if (segment.owner) {
            int i2 = this.limit - this.pos;
            if (i2 > (8192 - segment.limit) + (segment.shared ? 0 : segment.pos)) {
                return;
            }
            writeTo(segment, i2);
            pop();
            SegmentPool.recycle(this);
        }
    }

    public Segment pop() {
        Segment segment = this.next;
        Segment segment2 = segment != this ? segment : null;
        Segment segment3 = this.prev;
        segment3.next = segment;
        this.next.prev = segment3;
        this.next = null;
        this.prev = null;
        return segment2;
    }

    public Segment push(Segment segment) {
        segment.prev = this;
        segment.next = this.next;
        this.next.prev = segment;
        this.next = segment;
        return segment;
    }

    public Segment sharedCopy() {
        this.shared = true;
        return new Segment(this.data, this.pos, this.limit, true, false);
    }

    public Segment split(int i2) {
        Segment segmentTake;
        if (i2 <= 0 || i2 > this.limit - this.pos) {
            throw new IllegalArgumentException();
        }
        if (i2 >= 1024) {
            segmentTake = sharedCopy();
        } else {
            segmentTake = SegmentPool.take();
            System.arraycopy(this.data, this.pos, segmentTake.data, 0, i2);
        }
        segmentTake.limit = segmentTake.pos + i2;
        this.pos += i2;
        this.prev.push(segmentTake);
        return segmentTake;
    }

    public Segment unsharedCopy() {
        return new Segment((byte[]) this.data.clone(), this.pos, this.limit, false, true);
    }

    public void writeTo(Segment segment, int i2) {
        if (!segment.owner) {
            throw new IllegalArgumentException();
        }
        int i3 = segment.limit;
        if (i3 + i2 > 8192) {
            if (segment.shared) {
                throw new IllegalArgumentException();
            }
            int i4 = segment.pos;
            if ((i3 + i2) - i4 > 8192) {
                throw new IllegalArgumentException();
            }
            byte[] bArr = segment.data;
            System.arraycopy(bArr, i4, bArr, 0, i3 - i4);
            segment.limit -= segment.pos;
            segment.pos = 0;
        }
        System.arraycopy(this.data, this.pos, segment.data, segment.limit, i2);
        segment.limit += i2;
        this.pos += i2;
    }

    public Segment(byte[] bArr, int i2, int i3, boolean z, boolean z2) {
        this.data = bArr;
        this.pos = i2;
        this.limit = i3;
        this.shared = z;
        this.owner = z2;
    }
}
