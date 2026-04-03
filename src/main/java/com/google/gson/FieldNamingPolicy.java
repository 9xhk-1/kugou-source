package com.google.gson;

import java.lang.reflect.Field;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public enum FieldNamingPolicy implements FieldNamingStrategy {
    IDENTITY { // from class: com.google.gson.FieldNamingPolicy.1
        @Override // com.google.gson.FieldNamingStrategy
        public String translateName(Field field) {
            return field.getName();
        }
    },
    UPPER_CAMEL_CASE { // from class: com.google.gson.FieldNamingPolicy.2
        @Override // com.google.gson.FieldNamingStrategy
        public String translateName(Field field) {
            return FieldNamingPolicy.upperCaseFirstLetter(field.getName());
        }
    },
    UPPER_CAMEL_CASE_WITH_SPACES { // from class: com.google.gson.FieldNamingPolicy.3
        @Override // com.google.gson.FieldNamingStrategy
        public String translateName(Field field) {
            return FieldNamingPolicy.upperCaseFirstLetter(FieldNamingPolicy.separateCamelCase(field.getName(), " "));
        }
    },
    LOWER_CASE_WITH_UNDERSCORES { // from class: com.google.gson.FieldNamingPolicy.4
        @Override // com.google.gson.FieldNamingStrategy
        public String translateName(Field field) {
            return FieldNamingPolicy.separateCamelCase(field.getName(), "_").toLowerCase(Locale.ENGLISH);
        }
    },
    LOWER_CASE_WITH_DASHES { // from class: com.google.gson.FieldNamingPolicy.5
        @Override // com.google.gson.FieldNamingStrategy
        public String translateName(Field field) {
            return FieldNamingPolicy.separateCamelCase(field.getName(), "-").toLowerCase(Locale.ENGLISH);
        }
    };

    private static String modifyString(char c, String str, int i2) {
        if (i2 >= str.length()) {
            return String.valueOf(c);
        }
        return String.valueOf(c) + str.substring(i2);
    }

    public static String separateCamelCase(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < str.length(); i2++) {
            char cCharAt = str.charAt(i2);
            if (Character.isUpperCase(cCharAt) && sb.length() != 0) {
                sb.append(str2);
            }
            sb.append(cCharAt);
        }
        return sb.toString();
    }

    public static String upperCaseFirstLetter(String str) {
        StringBuilder sb = new StringBuilder();
        int i2 = 0;
        char cCharAt = str.charAt(0);
        while (i2 < str.length() - 1 && !Character.isLetter(cCharAt)) {
            sb.append(cCharAt);
            i2++;
            cCharAt = str.charAt(i2);
        }
        if (i2 == str.length()) {
            return sb.toString();
        }
        if (Character.isUpperCase(cCharAt)) {
            return str;
        }
        sb.append(modifyString(Character.toUpperCase(cCharAt), str, i2 + 1));
        return sb.toString();
    }

    /* JADX INFO: renamed from: values, reason: to resolve conflict with enum method */
    public static FieldNamingPolicy[] valuesCustom() {
        FieldNamingPolicy[] fieldNamingPolicyArrValuesCustom = values();
        int length = fieldNamingPolicyArrValuesCustom.length;
        FieldNamingPolicy[] fieldNamingPolicyArr = new FieldNamingPolicy[length];
        System.arraycopy(fieldNamingPolicyArrValuesCustom, 0, fieldNamingPolicyArr, 0, length);
        return fieldNamingPolicyArr;
    }

    /* synthetic */ FieldNamingPolicy(FieldNamingPolicy fieldNamingPolicy) {
        this();
    }
}
