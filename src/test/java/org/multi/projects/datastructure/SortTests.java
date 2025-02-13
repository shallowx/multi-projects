package org.multi.projects.datastructure;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class SortTests {

    private static final int[] unsorted = { 5, 4, 3, 2, 1, 0, 12, 12, 1, 9 };

    @Test
    public void sort0() {
        int l = unsorted.length;
        for (int i = 0; i < l - 1; i++) {
            for (int j = i + 1; j < l; j++) {
                if (unsorted[i] > unsorted[j]) {
                   swap(i, j);
                }
            }
        }
        System.out.println(Arrays.toString(unsorted));
    }

    @Test
    public void sort1() {
        int l = unsorted.length;
        for (int i = 0; i < l - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < l; j++) {
                if (unsorted[j] < unsorted[minIndex]) {
                    minIndex = j;
                }
            }

            if (minIndex != i) {
                swap(i, minIndex);
            }
        }
        System.out.println(Arrays.toString(unsorted));
    }

    @Test
    public void sort2() {
        int l = unsorted.length;
        int i, j , k;
        for (i = 1; i != l; ++i) {
            j = i - 1;
            k = unsorted[i];
            while (j >= 0 && unsorted[j] > k) {
                unsorted[j + 1] = unsorted[j];
                j--;
            }
            unsorted[j + 1] = k;
        }
        System.out.println(Arrays.toString(unsorted));
    }

    private void swap(int i, int j) {
        int temp = SortTests.unsorted[i];
        SortTests.unsorted[i] = SortTests.unsorted[j];
        SortTests.unsorted[j] = temp;
    }
}
