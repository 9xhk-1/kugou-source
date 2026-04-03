package com.google.protobuf;

import com.google.protobuf.GeneratedMessageLite;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

/* JADX INFO: loaded from: classes.dex */
public final class MessageLiteToString {
    private static final String BUILDER_LIST_SUFFIX = "OrBuilderList";
    private static final String BYTES_SUFFIX = "Bytes";
    private static final String LIST_SUFFIX = "List";

    private static final String camelCaseToSnakeCase(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < str.length(); i2++) {
            char cCharAt = str.charAt(i2);
            if (Character.isUpperCase(cCharAt)) {
                sb.append("_");
            }
            sb.append(Character.toLowerCase(cCharAt));
        }
        return sb.toString();
    }

    private static boolean isDefaultValue(Object obj) {
        return obj instanceof Boolean ? !((Boolean) obj).booleanValue() : obj instanceof Integer ? ((Integer) obj).intValue() == 0 : obj instanceof Float ? ((Float) obj).floatValue() == 0.0f : obj instanceof Double ? ((Double) obj).doubleValue() == 0.0d : obj instanceof String ? obj.equals("") : obj instanceof ByteString ? obj.equals(ByteString.EMPTY) : obj instanceof MessageLite ? obj == ((MessageLite) obj).getDefaultInstanceForType() : (obj instanceof java.lang.Enum) && ((java.lang.Enum) obj).ordinal() == 0;
    }

    public static final void printField(StringBuilder sb, int i2, String str, Object obj) {
        if (obj instanceof List) {
            Iterator it = ((List) obj).iterator();
            while (it.hasNext()) {
                printField(sb, i2, str, it.next());
            }
            return;
        }
        sb.append('\n');
        for (int i3 = 0; i3 < i2; i3++) {
            sb.append(' ');
        }
        sb.append(str);
        if (obj instanceof String) {
            sb.append(": \"");
            sb.append(TextFormatEscaper.escapeText((String) obj));
            sb.append('\"');
            return;
        }
        if (obj instanceof ByteString) {
            sb.append(": \"");
            sb.append(TextFormatEscaper.escapeBytes((ByteString) obj));
            sb.append('\"');
        } else {
            if (!(obj instanceof GeneratedMessageLite)) {
                sb.append(": ");
                sb.append(obj.toString());
                return;
            }
            sb.append(" {");
            reflectivePrintWithIndent((GeneratedMessageLite) obj, sb, i2 + 2);
            sb.append("\n");
            for (int i4 = 0; i4 < i2; i4++) {
                sb.append(' ');
            }
            sb.append("}");
        }
    }

    private static void reflectivePrintWithIndent(MessageLite messageLite, StringBuilder sb, int i2) {
        HashMap map = new HashMap();
        HashMap map2 = new HashMap();
        TreeSet treeSet = new TreeSet();
        for (java.lang.reflect.Method method : messageLite.getClass().getDeclaredMethods()) {
            map2.put(method.getName(), method);
            if (method.getParameterTypes().length == 0) {
                map.put(method.getName(), method);
                if (method.getName().startsWith("get")) {
                    treeSet.add(method.getName());
                }
            }
        }
        Iterator it = treeSet.iterator();
        while (it.hasNext()) {
            String strReplaceFirst = ((String) it.next()).replaceFirst("get", "");
            boolean zBooleanValue = true;
            if (strReplaceFirst.endsWith(LIST_SUFFIX) && !strReplaceFirst.endsWith(BUILDER_LIST_SUFFIX)) {
                String str = strReplaceFirst.substring(0, 1).toLowerCase() + strReplaceFirst.substring(1, strReplaceFirst.length() - 4);
                java.lang.reflect.Method method2 = (java.lang.reflect.Method) map.get("get" + strReplaceFirst);
                if (method2 != null && method2.getReturnType().equals(List.class)) {
                    printField(sb, i2, camelCaseToSnakeCase(str), GeneratedMessageLite.invokeOrDie(method2, messageLite, new Object[0]));
                }
            }
            if (((java.lang.reflect.Method) map2.get("set" + strReplaceFirst)) != null) {
                if (strReplaceFirst.endsWith(BYTES_SUFFIX)) {
                    if (map.containsKey("get" + strReplaceFirst.substring(0, strReplaceFirst.length() - 5))) {
                    }
                }
                String str2 = strReplaceFirst.substring(0, 1).toLowerCase() + strReplaceFirst.substring(1);
                java.lang.reflect.Method method3 = (java.lang.reflect.Method) map.get("get" + strReplaceFirst);
                java.lang.reflect.Method method4 = (java.lang.reflect.Method) map.get("has" + strReplaceFirst);
                if (method3 != null) {
                    Object objInvokeOrDie = GeneratedMessageLite.invokeOrDie(method3, messageLite, new Object[0]);
                    if (method4 != null) {
                        zBooleanValue = ((Boolean) GeneratedMessageLite.invokeOrDie(method4, messageLite, new Object[0])).booleanValue();
                    } else if (isDefaultValue(objInvokeOrDie)) {
                        zBooleanValue = false;
                    }
                    if (zBooleanValue) {
                        printField(sb, i2, camelCaseToSnakeCase(str2), objInvokeOrDie);
                    }
                }
            }
        }
        if (messageLite instanceof GeneratedMessageLite.ExtendableMessage) {
            Iterator<Map.Entry<FieldDescriptorType, Object>> it2 = ((GeneratedMessageLite.ExtendableMessage) messageLite).extensions.iterator();
            while (it2.hasNext()) {
                Map.Entry entry = (Map.Entry) it2.next();
                printField(sb, i2, "[" + ((GeneratedMessageLite.ExtensionDescriptor) entry.getKey()).getNumber() + "]", entry.getValue());
            }
        }
        UnknownFieldSetLite unknownFieldSetLite = ((GeneratedMessageLite) messageLite).unknownFields;
        if (unknownFieldSetLite != null) {
            unknownFieldSetLite.printWithIndent(sb, i2);
        }
    }

    public static String toString(MessageLite messageLite, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("# ");
        sb.append(str);
        reflectivePrintWithIndent(messageLite, sb, 0);
        return sb.toString();
    }
}
