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
                   swap(unsorted, i, j);
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
                swap(unsorted, i, minIndex);
            }
        }
        System.out.println(Arrays.toString(unsorted));
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
