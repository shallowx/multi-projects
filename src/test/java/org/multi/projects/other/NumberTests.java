package org.multi.projects.other;

import org.junit.jupiter.api.Test;

public class NumberTests {

    @Test
    public void test() {
        int a = 1111;
        int b = 2222;

        long result = 0;
        result |= a;
        result <<= 31;
        result |= b;
        System.out.println(result);

        long br = 0x7fffffff & result;
        System.out.println(br);
        System.out.println(result >> 31);
    }
}
