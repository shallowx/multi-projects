package org.multi.projects;

import org.junit.jupiter.api.Test;
import java.util.Arrays;

public class SortTests {

    @Test
    public void test01() {
        int[] arr = {1,4,3,6,0,9,8};
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1 ; j < n; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void test02() {
        int[] arr = {1,4,3,6,0,9,8};
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            if (min != i) {
                int temp = arr[i];
                arr[i] = arr[min];
                arr[min] = temp;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void test04() {
        int[] arr = {1,1,2,2,3,3,4,4,5};
        int k = 2;
        int low = 0, high = arr.length - 1;
        int index = -1;
        while(low < high) {
            int mid = low + ((high - low) >> 1);
            if (arr[mid] >= k) {
                index = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        System.out.println(index);
    }

    @Test
    public void test05() {
        int[] arr = {1,1,2,2,3,3,4,4,5,6};
        int xor = 0;
        for (int num : arr) {
            xor ^= num;
        }

        int mask = xor & ((~xor) + 1);
        int a = 0, b = 0;
        for (int num : arr) {
            if ((num & mask) == 0) {
                a ^= num;
            } else {
                b ^= num;
            }
        }
        System.out.println(a);
        System.out.println(b);
    }
}
