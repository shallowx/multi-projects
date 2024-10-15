package org.multi.projects.other;

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

    @Test
    public void test06() {
        int[] arr = {13,5,4,6,1,9,10};
        for (int i = 0; i < arr.length; i++) {
            int x = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] > arr[x]) {
                    x = j;
                }
            }
            if (x != i) {
                int temp = arr[i];
                arr[i] = arr[x];
                arr[x] = temp;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void test07() {
        int[] arr = {13,5,4,6,1,9,10};
        for (int i = 0; i < arr.length; i++) {
            boolean isChanged = false;
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    isChanged = true;
                }
            }
            if (!isChanged) {
                break;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void test08() {
        int[] arr = {13,5,4,6,1,9,10};
        for (int i = 0; i < arr.length; i++) {
            int min = arr[i];
            int j = i - 1;
            for (; j > 0 ; j--) {
                if (arr[j] < min) {
                    arr[j + 1] = arr[j];
                }
            }
            arr[j + 1] = min;
        }
        System.out.println(Arrays.toString(arr));
    }
}
