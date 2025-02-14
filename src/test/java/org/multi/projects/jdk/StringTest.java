package org.multi.projects.jdk;

import org.junit.jupiter.api.Test;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Locale;

public class StringTest {

    @Test
    public void test() {
        String abc = "abc";
        char[] chars = new char[]{'a', 'b', 'c'};
        String result = new String(chars);
        System.out.println(result.contentEquals(abc));
        System.out.println(result.equals(abc));

        String transform = abc.transform(String::toUpperCase);
        System.out.println(transform);

        String retTransform = result.transform(s -> {
            System.out.println("transform: " + s);
            StringBuilder sb = new StringBuilder();
            char[] chars1 = s.toCharArray();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                chars1[i] = c;
            }
            sb.append("transform:")
                    .append(s)
                    .append(",")
                    .append(new String(chars1).toUpperCase(Locale.ENGLISH));
            return sb.toString();
        });
        System.out.println(retTransform);

        String text = "  Hello, World!\u2000  ";
        String strippedText = text.strip();
        System.out.println("原始字符串: '" + text + "'");
        System.out.println("去除空白后的字符串: '" + strippedText + "'");
        System.out.println("trim() 结果: '" + text.strip() + "'");

        String text1 = "Hello, a!";
        char ch = text1.charAt(7);
        int codePoint = text1.codePointAt(7);
        System.out.println("索引 7 处的字符是: " + ch);
        System.out.println("索引 7 处的码点是: " + codePoint);

        String str = "汉字";
        byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
        byte[] bytes1 = str.getBytes(StandardCharsets.US_ASCII);
        byte[] bytes2 = str.getBytes(StandardCharsets.UTF_16);
        byte[] bytes3 = str.getBytes(StandardCharsets.UTF_16BE);
        byte[] bytes4 = str.getBytes(StandardCharsets.UTF_16LE);

        System.out.println(Arrays.toString(bytes));
        System.out.println(Arrays.toString(bytes1));
        System.out.println(Arrays.toString(bytes2));
        System.out.println(Arrays.toString(bytes3));
        System.out.println(Arrays.toString(bytes4));
    }

    @Test
    public void testImmutable() {
        String abc = "abc";
        immutable(abc);
        System.out.println(abc);

        StringBuilder sb = new StringBuilder(abc);
        mutable(sb);
        System.out.println(sb.toString());
    }

    private void immutable(String s) {
        s = s.toUpperCase(Locale.ENGLISH);
        System.out.println(s);
    }

    private void mutable(StringBuilder sb) {
        sb.append("abc0".toUpperCase(Locale.ENGLISH));
        System.out.println("method:" + sb.toString());
    }

    @Test
    public void test1() {
        int num = -5;
        byte[] bytes = new byte[32];
        for (int i = 0; i < 32; i++) {
            bytes[31-i] = (byte) ((num >> i) & 1);
        }
        System.out.println(Arrays.toString(bytes));
    }

    @Test
    public void test2() {
        String str = "abcdefghijkm";
        char[] chars = str.toCharArray();
        int start = 0;
        int last = chars.length - 1;
        while (start < last) {
            char temp = chars[start];
            chars[start++] = chars[last];
            chars[last--] = temp;
        }
        System.out.println(Arrays.toString(chars));
    }

    @Test
    public void test3() {
        String str = "abcdefghijkm";
        char[] chars = new char[str.length()];
        int index = 0;
        for (int i = str.length() - 1; i >= 0; i--) {
            char c = str.charAt(i);
            chars[index++] = c;
        }
        System.out.println(Arrays.toString(chars));
    }

    @Test
    public void test4() {
        System.out.println((~Integer.MIN_VALUE) + 1);
        System.out.println((~0) + 1);
        System.out.println((~5) + 1);
    }
}
