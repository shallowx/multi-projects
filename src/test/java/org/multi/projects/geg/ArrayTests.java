package org.multi.projects.geg;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

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
}
