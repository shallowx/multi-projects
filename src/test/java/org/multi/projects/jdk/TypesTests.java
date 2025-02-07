package org.multi.projects.jdk;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

@SuppressWarnings("all")
public class TypesTests {

    private static final int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};

    /**
     *  <a href="https://docs.oracle.com/javase/specs/jvms/se23/html/jvms-2.html">array types is reference types</a>
     */
    @Test
    public void test() {
        System.out.println(Arrays.toString(arr));
        update(arr);
        System.out.println(Arrays.toString(arr));
    }

    private void update(int[] arr) {
        arr[0] = 100;
    }
}
