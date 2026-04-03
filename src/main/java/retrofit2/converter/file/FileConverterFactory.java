package retrofit2.converter.file;

import java.io.File;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Retrofit;

/* JADX INFO: loaded from: classes2.dex */
public class FileConverterFactory extends Converter.Factory {
    private int bpsLimit;
    private final String savePath;

    private FileConverterFactory(String str) {
        this.savePath = str;
    }

    public static FileConverterFactory create(String str) {
        return new FileConverterFactory(str);
    }

    @Override // retrofit2.Converter.Factory
    public Converter<ResponseBody, File> responseBodyConverter(Type type, Annotation[] annotationArr, Retrofit retrofit) {
        FileConverter fileConverter = new FileConverter(this.savePath);
        int i2 = this.bpsLimit;
        if (i2 > 0) {
            fileConverter.setBpsLimit(i2);
        }
        return fileConverter;
    }

    public static FileConverterFactory create(String str, int i2) {
        FileConverterFactory fileConverterFactory = new FileConverterFactory(str);
        fileConverterFactory.bpsLimit = i2;
        return fileConverterFactory;
    }
}
