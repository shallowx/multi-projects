package org.multi.projects;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class ComparableIntPriorityQueue {

    private int[] queue;
    private int size;
    private int capacity;

    public ComparableIntPriorityQueue(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("capacity must be a positive number");
        }

        this.capacity = capacity;
        this.queue = new int[capacity];
    }

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

    public int peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Comparable priority queue is empty");
        }
        return queue[0];
    }

    public int poll() {
        if (isEmpty()) {
            throw new NoSuchElementException("Comparable priority queue is empty");
        }
        int e = queue[0];
        queue[0] = queue[size - 1];
        queue[--size] = 0;
        sift(0);
        return e;
    }

    public void remove(int e) {
        if (isEmpty()) {
            throw new NoSuchElementException("Comparable priority queue is empty");
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

    private void lift(int i) {
        int parent;
        while (i > 0 && queue[parent = (i - 1) >> 1] > queue[i]) {
            swap(parent, i);
            i = parent;
        }
    }

    private void swap(int i, int j) {
        int temp = queue[i];
        queue[i] = queue[j];
        queue[j] = temp;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public int[] queue() {
        if (isEmpty()) {
            return new int[0];
        }
        int[] newQueue = new int[size];
        System.arraycopy(queue, 0, newQueue, 0, size);
        return newQueue;
    }
}
