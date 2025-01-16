package org.multi.projects.jdk;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;

public class BigIntegerTest {

    @Test
    public void test() {
        BigInteger b1 = new BigInteger("1234567890123456789012345678901234567890");
        BigInteger b2 = new BigInteger("9876543210987654321098765432109876543210");

        BigInteger result = b1.add(b2);
        System.out.println(result);
        System.out.println(result.toString(2));
        System.out.println(result.toString(8));
        System.out.println(result.toString(16));
    }
}
