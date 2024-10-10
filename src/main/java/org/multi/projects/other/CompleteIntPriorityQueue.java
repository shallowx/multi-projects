package org.multi.projects.other;

import java.util.Arrays;
import java.util.NoSuchElementException;

/**
 * A priority queue implementation for integers that uses an array-based binary heap.
 * The elements are ordered according to their natural ordering,
 * with the smallest integer being the highest priority.
 */
public class CompleteIntPriorityQueue {

    /**
     * The internal array used to store the priority queue elements.
     * This array is dynamically resized as elements are added or removed from the queue.
     */
    private int[] queue;
    /**
     * The number of elements currently held in the priority queue.
     */
    private int size;
    /**
     * The maximum number of elements that the CompleteIntPriorityQueue can hold.
     */
    private int capacity;

    /**
     * Constructor for creating a new CompleteIntPriorityQueue with a given capacity.
     *
     * @param capacity the initial capacity of the priority queue; must be a positive number.
     * @throws IllegalArgumentException if the capacity is less than or equal to zero.
     */
    public CompleteIntPriorityQueue(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity must be a positive number");
        }

        this.capacity = capacity;
        this.queue = new int[capacity];
    }

    /**
     * Adds an element to the priority queue. If the internal array is full,
     * it resizes to accommodate additional elements.
     *
     * @param e the element to be added to the queue
     */
    public void offer(int e) {
        int[] temp = queue;
        if (size == capacity) {
            capacity = 1 + (size - 1) << 1;
            temp = Arrays.copyOf(queue, capacity);
        }
        temp[size++] = e;
        this.queue = temp;
        lift(size - 1);
    }

    /**
     * Retrieves and returns the highest-priority (minimum) element from the priority queue without removing it.
     * Throws a NoSuchElementException if the queue is empty.
     *
     * @return the highest-priority (minimum) element in the priority queue.
     * @throws NoSuchElementException if the priority queue is empty.
     */
    public int peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Complete priority queue is empty");
        }
        return queue[0];
    }

    /**
     * Removes the element at the head of the queue and returns it.
     *
     * @return the element removed from the head of the queue
     * @throws NoSuchElementException if the queue is empty
     */
    public int poll() {
        if (isEmpty()) {
            throw new NoSuchElementException("Complete priority queue is empty");
        }
        int e = queue[0];
        queue[0] = queue[size - 1];
        queue[--size] = 0;
        sift(0);
        return e;
    }

    /**
     * Removes the specified element from the priority queue if it is present.
     *
     * @param e the element to be removed from the priority queue
     * @throws NoSuchElementException if the queue is empty
     */
    public void remove(int e) {
        if (isEmpty()) {
            throw new NoSuchElementException("Complete priority queue is empty");
        }

        for (int i = size; i > 0; i--) {
            if (e == queue[i]) {
                queue[i] = queue[--size];
                queue[size] = 0;
                lift(i);
                sift(i);
                break;
            }
        }
    }

    /**
     * Sifts down the element at the specified index in the priority queue.
     *
     * This method is called to restore the heap invariant after the removal or replacement
     * of the root element. During the sift down process, the method ensures that the
     * element at the index follows the min-heap property by swapping it with its child
     * if necessary.
     *
     * @param i the index of the element to sift down
     */
    private void sift(int i) {
        int child;
        while ((child = (i << 1) + 1) < size) {
            if (child < size -1 && queue[child] > queue[child + 1]) {
                child++;
            }

            if (queue[i] <= queue[child]) {
                break;
            }
            swap(i, child);
            i = child;
        }
    }

    /**
     * Adjusts the position of the element at the given index upwards in the priority queue
     * to maintain the heap property.
     *
     * @param i the index of the element to be lifted up in the priority queue
     */
    private void lift(int i) {
        int parent;
        while (i > 0 && queue[parent = (i - 1) >> 1] > queue[i]) {
            swap(parent, i);
            i = parent;
        }
    }

    /**
     * Swaps the elements at the specified indices in the queue.
     *
     * @param i the index of the first element to be swapped
     * @param j the index of the second element to be swapped
     */
    private void swap(int i, int j) {
        int temp = queue[i];
        queue[i] = queue[j];
        queue[j] = temp;
    }

    /**
     * Checks if the priority queue is empty.
     *
     * @return true if the priority queue contains no elements, false otherwise
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Returns the current number of elements in the priority queue.
     *
     * @return the number of elements in the queue
     */
    public int size() {
        return size;
    }

    /**
     * Returns a copy of the current queue as an array of integers.
     *
     * @return an array representing the elements in the queue. If the queue is empty,
     * it returns an empty array.
     */
    public int[] queue() {
        if (isEmpty()) {
            return new int[0];
        }
        int[] newQueue = new int[size];
        System.arraycopy(queue, 0, newQueue, 0, size);
        return newQueue;
    }
}
