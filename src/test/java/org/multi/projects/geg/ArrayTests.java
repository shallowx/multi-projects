package org.multi.projects.geg;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayTests {

    @Test
    public void testSubarraySum() {
        int[] arr = {1, 23, 3, 4, 5, 6, 7, 8, 9, 10};
        int s = 30;
        ArrayList<Integer> res = new ArrayList<>();
        int sum = 0, start = 0, end = 0;
        for ( ; end < arr.length; end++) {
            sum += arr[end];
            if (sum == s) {
                res.add(start);
                res.add(end);
                break;
            } else if (sum > s) {
                do {
                    sum -= arr[start++];
                }while (sum > s);

                if (sum == s && end >= start) {
                    res.add(start);
                    res.add(end);
                    break;
                }
            }
        }

        if(res.isEmpty()) {
            res.add(-1);
        }
        System.out.println(res);
    }

    @Test
    public void testMaxSubarraySum() {
        int[] arr = {1, 23, 3, 4, 5, 6, 7, 8, 9, 10};
        int max = arr[0];
        int curr = arr[0];
        for (int i = 1; i < arr.length; i++) {
            curr += arr[i];
            if (curr < arr[i]) {
                curr = arr[i];
            }
            max = Math.max(curr, max);
        }
        System.out.println(max);
    }

    @Test
    public void testReverseArray01() {
        int[] arr = {1, 23, 3, 4, 5, 6, 7, 8, 9, 10, 11};
        int n = arr.length;
        for (int i = 0; i < (n >> 1); i++) {
            int temp = arr[i];
            arr[i] = arr[n - 1 - i];
            arr[n - 1 - i] = temp;
        }
        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void testReverseArray02() {
        int[] arr = {1, 23, 3, 4, 5, 6, 7, 8, 9, 10, 11};
        int left = 0, right = arr.length - 1;
        while (left < right) {
            arr[left] = arr[right] ^ arr[left];
            arr[right] = arr[right] ^ arr[left];
            arr[left] = arr[right] ^ arr[left];

            left++;
            right--;
        }
        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void testLeaders01() {
        int[] arr = {1, 23, 3, 4, 5, 6, 11, 8, 9, 10};
        List<Integer> res = new ArrayList<>();
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int j;
            for (j = i + 1; j < n; j++) {
                if (arr[i] < arr[j]) {
                    break;
                }
            }
            if (j == n) {
                res.add(arr[i]);
            }
        }
        System.out.println(res);
    }

    @Test
    public void testLeaders02() {
        int[] arr = {1, 23, 3, 4, 5, 6, 11, 8, 9, 10};
        List<Integer> res = new ArrayList<>();
        int max = arr[arr.length - 1];
        res.add(max);
        for (int i = arr.length - 2; i > 0; i--) {
            if (arr[i] > max) {
                max = arr[i];
                res.addFirst(max);
            }
        }
        System.out.println(res);
    }

    @Test
    public void test2Sum() {
        int[] arr = {1, 23, 3, 4, 5, 6, 7, 8, 9, 10};
        int target = 15;
        Arrays.sort(arr);
        int left = 0, right = arr.length - 1;
        boolean isExists = false;
        while (left < right) {
            int sum = arr[left] + arr[right];
            if (sum == target) {
                isExists = true;
                System.out.println("TRUE");
                break;
            } else if (sum > target) {
                right--;
            } else {
                left++;
            }
        }
        if (!isExists) {
            System.out.println("FALSE");
        }
    }

    @Test
    public void testLargestSum() {
        int[] arr = {2, 3, -8, 7, -1, 2, 3};
        int sum = arr[0];
        int largest = arr[0];
        for (int i = 1; i < arr.length; i++) {
            sum += arr[i];
            if (sum < arr[i]) {
                sum = arr[i];
            }
            largest = Math.max(largest, sum);
        }
        System.out.println(largest);
    }

    @Test
    public void testLargestSumOfSubArray() {
        int[] arr = {2, 7, -18, 1, 7, -1, 2, 3};
        int left = 0, right = 0, move = 0;
        int sum = arr[0];
        int largest = arr[0];
        for (int i = 1; i < arr.length; i++) {
            sum += arr[i];
            if (sum < arr[i]) {
                sum = arr[i];
                move = i;
            }

            if (sum > largest) {
                largest = sum;
                right = i;
                left = move;
            }
        }
        System.out.println("left: " + left + ", right: " + right);
    }

    @Test
   public void testMerge() {
       int[] arr1 = {1,2,3,5,7,13};
       int[] arr2 = {2,4,6,8,10,11,12};

       int l1 = arr1.length, l2 = arr2.length;
       int[] ret = new int[l1 + l2];
       int i = 0, j = 0, k = 0;
       while (i < l1 && j < l2) {
            if (arr1[i] <= arr2[j]) {
                ret[k++] = arr1[i++];
            } else {
                ret[k++] = arr2[j++];
            }
       }

       if (i < l1) {
           System.arraycopy(arr1, i, ret, k, l1 - i);
       }

       if (j < l2) {
           System.arraycopy(arr2, j, ret, k, l2 - j);
       }
       System.out.println(Arrays.toString(ret));
   }
}
