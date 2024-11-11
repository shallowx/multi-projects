package org.multi.projects.geg;

import org.junit.jupiter.api.Test;
import java.util.Arrays;

public class BitsTests {

    @Test
    public void testMissInArray() {
        int[] arr = {1,2,3,4,7,6};
        int n = 7;
        int sum = 0;
        for (int i : arr) {
            sum += i;
        }
        System.out.println(((n*(n+1)) >> 1) - sum);
    }

    @Test
    public void testIsPower2() {
        int n = 8;
        boolean isPower2 = (n > 0) && (n & (n - 1)) == 0;
        System.out.println(isPower2);
    }

    @Test
    public void testCheckKthBit() {
        int n = 8;
        int k = 2;
        System.out.println(((n & (1 << k))) != 0);
    }

    @Test
    public void testCountSetBits() {
        int n = 17;
        int count = 0;
        int powerOf2 = 1;
        while (powerOf2 <= n) {
            int totalPairs = n / (powerOf2 << 1);
            int remainder = n % (powerOf2 << 1);
            count += totalPairs * powerOf2 + Math.max(0, remainder - powerOf2 + 1);
            powerOf2 <<= 1;
        }
        System.out.println(count);
    }

    @Test
    public void testMath() {
        System.out.println(nth(2,3));
    }

    private int nth (int a, int b) {
        return (a + b - 1) / b;
    }

    @Test
    public void testSingleNumber()
    {
        int[] nums = {1,2,1,3,2,5};
        int eor = 0;
        for (int i =0; i < nums.length;i++) {
            eor ^= nums[i];
        }

        int x = eor & ((~eor) + 1);
        int a = 0, b = 0;
        for(int i = 0; i < nums.length; i++) {
            if((nums[i] & x) == 0) {
                a ^= nums[i];
            } else {
                b ^= nums[i];
            }
        }

        if(a > b) {
            a = a ^ b;
            b = a ^ b;
            a = a ^ b;
        }
        int[] ret = {a,b};
        System.out.println(Arrays.toString(ret));
    }

    @Test
    public void testReversedBits() {
        long x = 10;
        long reversed = 0;
        for (int i = 0; i < 32; i++) {
            reversed <<= 1;
            reversed |= (x & 1);
            x >>= 1;
        }
        System.out.println(reversed);
    }

    @Test
    public void test0x01() {
        int a = 2;
        System.out.println((~a) + 1);

        int b = -2;
        System.out.println((~b) + 1);

        int c = Integer.MIN_VALUE;
        System.out.println(c);
        System.out.println((~c) + 1);
    }
}
