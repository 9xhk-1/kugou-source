package com.kugou.framework.lyricanim;

import com.kugou.framework.lyric.LyricData;
import com.kugou.framework.lyric.debug.LyricDebug;
import com.kugou.framework.lyric4.utils.Utils;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes2.dex */
public class LyricDataUtils {
    private static Pattern pattern = Pattern.compile("[\\S\\s]*(原创|乐手|翻唱|和声|伴唱|合音|和音|詞|词|曲|编|混(?!唱)|监|笛|箫|琴|album|arragement|artist|background|bass|drum|engineer|flute|guitar|harmony|Instrument|isrc|keyboad|medley|mix|pgm|piano|produc|program|publish|sax|singer|writer|string|synthesize|sythn|title|trumpet|vocal|宣传|宣发|推广|顾问|封面|剪辑|鸣谢|出品|企划|营销|发行|出品|制作|统筹|字幕|策划|秀导|海报|摄影|mv合成|影视|母带|录音|后期|画师|调教|音响师|美工|题字|助理|乐务|经理|嘉宾|歌手|演奏|艺人|原唱|演唱|主唱|女声独唱|童声合唱|女声合唱|配唱| 配器师|合唱团|乐团|乐队|合声|歌曲语言|所属语言|语言类别|首席|唤醒师|歌姬|领舞|编舞|伴舞|舞蹈|舞团|原调|中阮|吉他|吉它|鼓|贝司|贝斯|键盘|器乐|弦琴|二胡|三弦|弦乐|古筝|琵琶|管乐|木管|铜管|管子|管弦|低音管|双簧管|黑管|单簧管|克拉管|大号|长号|小号|圆号|柔音号|萨克斯|打击|小打|时长|歌名|专辑|群号|企鹅号|uc号|短号|版权|qq|唱吧|酷狗|公众号|地址|上传|共享|krc|lrc|lyric|http|OP|produced|composed|lyrics|Op|by)[\\S\\s]*[:：][\\S\\s]+");
    private static String[] FILTER_WORD = {"未经许可", "不得翻唱"};

    public static int calculatePreludeLine(LyricData lyricData) {
        int i2 = -1;
        if (lyricData != null) {
            long[] rowBeginTime = lyricData.getRowBeginTime();
            long[] rowDelayTime = lyricData.getRowDelayTime();
            String[][] words = lyricData.getWords();
            if (words != null && words.length != 0 && rowBeginTime != null && rowBeginTime.length != 0 && rowDelayTime != null && rowDelayTime.length != 0) {
                int length = words.length - 1;
                while (true) {
                    if (length < 0) {
                        break;
                    }
                    String[] strArr = words[length];
                    if (checkBefore40s(length, lyricData) && isPreduleLine(strArr)) {
                        i2 = length;
                        break;
                    }
                    length--;
                }
                LyricDebug.d("markIndex:" + i2);
            }
        }
        return i2;
    }

    public static long calculatePreludeTime(LyricData lyricData) {
        long[] rowBeginTime;
        int iCalculatePreludeLine = calculatePreludeLine(lyricData);
        if (iCalculatePreludeLine == -1 || (rowBeginTime = lyricData.getRowBeginTime()) == null) {
            return 0L;
        }
        return rowBeginTime[Math.min(iCalculatePreludeLine + 1, rowBeginTime.length - 1)];
    }

    private static boolean checkBefore40s(int i2, LyricData lyricData) {
        long[] rowBeginTime = lyricData.getRowBeginTime();
        return i2 < rowBeginTime.length && rowBeginTime[i2] <= 40000;
    }

    private static boolean isPreduleLine(String[] strArr) {
        StringBuilder sb = new StringBuilder();
        for (String str : strArr) {
            sb.append(str);
        }
        if (pattern.matcher(sb).matches()) {
            return true;
        }
        for (String str2 : FILTER_WORD) {
            if (sb.indexOf(str2) >= 0) {
                return true;
            }
        }
        return false;
    }

    public static boolean isPrelude(String str) {
        return !Utils.isEmpty(str) && pattern.matcher(str).matches();
    }
}
