package org.multi.projects;

import org.junit.jupiter.api.Test;

/**
 * This class contains various unit tests for the SingleLinkedList class.
 */
public class LinkedTests {

    /**
     * Tests the addFirst method of the SingleLinkedList class.
     *
     * This method performs a series of operations on a SingleLinkedList instance:
     * - Adds elements to the front of the list using the addFirst method.
     * - Adds elements to the end of the list using the addLast method.
     * - Removes the first element of the list using the removeFirst method.
     * - Reverses the list using the reverse method.
     * - Prints the current state of the list to the standard output.
     *
     * This test helps verify that each of these methods operates correctly
     * both individually and in combination.
     */
    @Test
    public void testAddFirst() {
        SingleLinkedList<Integer> sl = new SingleLinkedList<>();
        sl.addFirst(1);
        sl.addFirst(2);
        sl.addFirst(3);

        sl.addLast(4);
        sl.addLast(5);

        sl.addAfter(6, 8);
        sl.addBefore(1, 9);
        sl.remove(4);

        sl.removeFirst();
        sl.reverse();
        System.out.println(sl);
    }
}
