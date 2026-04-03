package androidx.core.graphics;

import android.graphics.Path;
import androidx.annotation.RequiresApi;
import f.z.d.j;
import java.util.Collection;

/* JADX INFO: loaded from: classes.dex */
public final class PathKt {
    @RequiresApi(19)
    public static final Path and(Path path, Path path2) {
        j.f(path, "$this$and");
        j.f(path2, "p");
        Path path3 = new Path();
        path3.op(path, path2, Path.Op.INTERSECT);
        return path3;
    }

    @RequiresApi(26)
    public static final Iterable<PathSegment> flatten(Path path, float f2) {
        j.f(path, "$this$flatten");
        Collection<PathSegment> collectionFlatten = PathUtils.flatten(path, f2);
        j.b(collectionFlatten, "PathUtils.flatten(this, error)");
        return collectionFlatten;
    }

    public static /* synthetic */ Iterable flatten$default(Path path, float f2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            f2 = 0.5f;
        }
        return flatten(path, f2);
    }

    @RequiresApi(19)
    public static final Path minus(Path path, Path path2) {
        j.f(path, "$this$minus");
        j.f(path2, "p");
        Path path3 = new Path(path);
        path3.op(path2, Path.Op.DIFFERENCE);
        return path3;
    }

    @RequiresApi(19)
    public static final Path or(Path path, Path path2) {
        j.f(path, "$this$or");
        j.f(path2, "p");
        Path path3 = new Path(path);
        path3.op(path2, Path.Op.UNION);
        return path3;
    }

    @RequiresApi(19)
    public static final Path plus(Path path, Path path2) {
        j.f(path, "$this$plus");
        j.f(path2, "p");
        Path path3 = new Path(path);
        path3.op(path2, Path.Op.UNION);
        return path3;
    }

    @RequiresApi(19)
    public static final Path xor(Path path, Path path2) {
        j.f(path, "$this$xor");
        j.f(path2, "p");
        Path path3 = new Path(path);
        path3.op(path2, Path.Op.XOR);
        return path3;
    }
}
