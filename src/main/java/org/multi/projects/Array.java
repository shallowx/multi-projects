package org.multi.projects;

import java.util.Arrays;

/**
 * This class provides a dynamically growing array structure. It ensures that the array
 * can keep growing as elements are added. Internally, it uses an array to store
 * elements and expands the array when it reaches capacity.
 */
public class Array {
    /**
     * The capacity of the internal array. This value determines how many elements
     * the array can initially hold and is dynamically increased when the number of
     * elements exceeds the current capacity.
     */
    private int capacity;
    /**
     * The current number of elements stored in the IdentityArray.
     */
    private int size;
    /**
     * An internal array that stores elements in the IdentityArray.
     * It is dynamically expanded when the current capacity is reached.
     */
    private Object[] table;

    /**
     * Constant representing a "not found" state, typically used as a sentinel value
     * to indicate that a requested operation did not find the desired element in
     * the array. This commonly occurs in search operations where a negative result
     * is indicated by this specific integer value.
     */
    private static final int NON_FOUND = -1;
    /**
     * The default capacity for the IdentityArray if no initial capacity is specified.
     * This value determines the initial size of the internal array.
     */
    private static final int DEFAULT_CAPACITY = 10;

    /**
     * Constructs an IdentityArray with the specified initial capacity.
     *
     * @param capacity the initial capacity of the array. Must be a positive integer.
     * @throws IllegalArgumentException if the specified capacity is not positive.
     */
    public Array(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity must be a positive number");
        }
        this.capacity = Math.max(capacity, DEFAULT_CAPACITY);
        this.table = new Object[capacity];
    }

    /**
     * Adds the specified element to the array. If the array has reached its current capacity,
     * it will be dynamically resized to accommodate additional elements.
     *
     * @param e the element to be added to the array
     */
    public void add(Object e) {
        if (size == capacity) {
            capacity = capacity << 1;
            table = Arrays.copyOf(table, capacity);
        }
        table[size++] = e;
    }

    /**
     * Retrieves the element at the specified position in this dynamically growing array.
     *
     * @param index the index of the element to return
     * @return the element at the specified position in this array
     */
    public Object get(int index) {
        return table[index];
    }

    /**
     * Returns the index of the specified object in the array. If the object is not found,
     * a constant indicating 'not found' is returned.
     *
     * @param o the object to search for in the array. It can be null.
     * @return the index of the object if found, otherwise returns a constant indicating 'not found'.
     */
    public int get(Object o) {
        if (o == null) {
            for (int i = 0; i < size; i++) {
                if (table[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (o.equals(table[i])) {
                    return i;
                }
            }
        }
        return NON_FOUND;
    }

    /**
     * Adds an element at the specified index, shifting existing elements to the right.
     * If the internal array is at capacity, its size is doubled.
     *
     * @param index The position at which the element should be inserted.
     * @param e The element to add.
     */
    public void add(int index, Object e) {
        if (size == capacity) {
            capacity = capacity << 1;
            table = Arrays.copyOf(table, capacity);
        }
        System.arraycopy(table, index, table, index + 1, size - index);
        table[index] = e;
        size++;
    }

    /**
     * Retrieves the internal array.
     *
     * @return the current internal Object array.
     */
    public Object[] getArray() {
        return table;
    }

    /**
     * Removes and returns the first element in the array.
     * This method shifts all remaining elements in the array one position to the left.
     * The last element in the array is set to null.
     *
     * @return the first element in the array that was removed
     */
    public Object remove() {
        Object o = table[0];
        System.arraycopy(table, 1, table, 0, size);
        table[size - 1] = null;
        return o;
    }

    /**
     * Removes the element at the specified position in the array.
     *
     * @param index the index of the element to be removed
     * @return the element that was removed from the array
     * @throws IllegalArgumentException if the index is out of range
     */
    public Object remove(int index) {
        if (index >= size) {
            throw new IllegalArgumentException("index of range");
        }
        Object o = table[index];
        System.arraycopy(table, index + 1, table, index, size - index);
        table[size - 1] = null;
        return o;
    }
}
