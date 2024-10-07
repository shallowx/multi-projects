package org.multi.projects;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * Unit tests for operations on multi-dimensional arrays.
 */
public class DimensionalArrayTests {
    /**
     * Tests the initialization and traversal of a multi-dimensional array.
     * The test initializes a 2D array with predefined integer values, and then prints each row and each element within the rows.
     */
    @Test
    public void testDimensionalInit() {
        int[][] arr = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };

        for (int i = 0; i < arr.length; i++) {
            System.out.printf("[%d]: %s \n", i, Arrays.toString(arr[i]));
            System.out.println("-".repeat(20));
            for (int j = 0; j < arr.length; j++) {
                System.out.printf("[%d][%d]: %d \n", i, j, arr[i][j]);
            }
            System.out.println("-".repeat(20));
        }
    }

    /**
     * Test method to validate the addition and initialization of a two-dimensional array.
     *
     * This method creates a 3x3 two-dimensional array, assigns values to each row,
     * and then prints the entire array using the Arrays.deepToString method.
     */
    @Test
    public void testDimensionalAdd() {
        int[][] arr = new int[3][3];
        arr[0] = new int[]{1,2,3};
        arr[1] = new int[]{4,5,6};
        arr[2] = new int[]{7,8,9};
        System.out.println(Arrays.deepToString(arr));
    }
}
