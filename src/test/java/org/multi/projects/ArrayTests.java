package org.multi.projects;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * The ArrayTests class contains unit tests for the IdentityArray class.
 * It verifies the correct functioning of methods in the IdentityArray class,
 * such as adding, removing, and inserting elements, as well as retrieving the internal array state.
 */
public class ArrayTests {
    /**
     * Tests the functionality of the IdentityArray class.
     * This test includes adding elements, inserting an element at a specific index,
     * removing elements from the end and from a specific position,
     * and printing the internal state of the array after each operation.
     */
    @Test
    public void test() {
        Array array = new Array(10);
        array.add(1);
        array.add(2);
        array.add(3);
        System.out.println(Arrays.toString(array.getArray()));

        array.add(1, 4);
        System.out.println(Arrays.toString(array.getArray()));

        Object remove = array.remove();
        System.out.println(remove);
        System.out.println(Arrays.toString(array.getArray()));

        Object remove1 = array.remove(1);
        System.out.println(remove1);
        System.out.println(Arrays.toString(array.getArray()));
    }
}
