package com.kage.kotlin.ch03;

public class KtTest {

    public static void main(String[] args) {
        System.out.println(StringUtils.joinToString(CollectionsKt.getList()));

        System.out.println(StringUtils.UNIX_LINE_SEPARATOR);

        System.out.println(StringUtils.getUnixLineSeparator());

        System.out.println(ExtentionsKt.lastChar("Kotlin"));
    }
}
