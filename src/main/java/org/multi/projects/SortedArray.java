package org.multi.projects;

import java.util.Arrays;

/**
 * A class representing a dynamically resizing sorted array.
 * The array maintains its elements in sorted order upon insertion.
 */
public class SortedArray {
    /**
     * The internal array that holds the elements of the SortedArray.
     * This array dynamically resizes as elements are added to ensure there is always
     * enough space for new elements while maintaining sorted order.
     */
    private int[] table;
    /**
     * The current number of elements in the sorted array.
     */
    private int size;
    /**
     * The current capacity of the array.
     * This represents the total number of elements the array can hold before needing to resize.
     */
    private int capacity;
    /**
     * The default initial capacity of the SortedArray.
     * This is used when no specific capacity is provided.
     */
    private static final int DEFAULT_CAPACITY = 10;
    /**
     * A constant representing a non-found value in the array search operations.
     * This value is returned when the search function does not find the target element.
     */
    private static final int NON_FOUND = -1;

    /**
     * Creates a new SortedArray instance with a specified initial capacity.
     *
     * @param capacity the initial capacity of the array; must be a positive number
     * @throws IllegalArgumentException if the specified capacity is non-positive
     */
    public SortedArray(int capacity) {
        if ( capacity <= 0) {
            throw new IllegalArgumentException("Capacity must be a positive number");
        }
        this.capacity = Math.max(capacity, DEFAULT_CAPACITY);
        this.table = new int[capacity];
    }

    /**
     * Adds an element to the sorted array, maintaining the order.
     * If the array reaches its capacity, it is resized to a larger size.
     *
     * @param e The element to be added to the sorted array.
     * @return The index where the element was inserted.
     */
    public int add(int e) {
        if (size == 0) {
            table[size++] = e;
            return 0;
        }
        int i = search(e);
         if (size + 1 >= capacity) {
             table = Arrays.copyOf(table, (capacity = capacity << 1));
         }

        for (int j = size + 1; j > i; j--) {
            table[j] = table[j - 1];
        }
        table[i] = e;
        size++;
        return i;
    }

    /**
     * Retrieves the internal array used in the SortedArray class.
     *
     * @return the current internal array of the SortedArray.
     */
    public int[] getArray() {
        return table;
    }

    /**
     * Reverses the elements of the array and returns a new array with the elements
     * in reverse order, leaving the original array unchanged.
     *
     * @return a new array containing the elements of the original array in reverse order.
     */
    public int[] reverseArray() {
        int[] newTable = new int[size];
        for (int i = 0; i < size; i++) {
            newTable[i] = table[size - 1 - i];
        }
        return newTable;
    }

    /**
     * Reverses the current array in place.
     *
     * This method iterates from both ends of the array towards the center,
     * swapping elements until the entire array is reversed.
     *
     * @return the array after being reversed
     */
    public int[] reverseArray0() {
        int low = 0;
        int high = size - 1;
        for (;low < high; low++, high--) {
            int temp = table[low];
            table[low] = table[high];
            table[high] = temp;
        }
        return table;
    }

    /**
     * Searches for the specified element in the sorted array.
     *
     * @param e the element to search for
     * @return the index of the element if found; otherwise, the index where the element should be inserted to maintain sorted order
     */
    private int search(int e) {
        int low = 0;
        int high = size - 1;
        while (low <= high) {
            int mid = low + (high - low) >> 1;
            if (e < table[mid]) {
                high = mid - 1;
            } else if (e > table[mid]) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return low;
    }
}
