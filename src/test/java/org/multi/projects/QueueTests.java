package org.multi.projects;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Unit tests for the ComparableIntPriorityQueue class.
 *
 * Contains tests to verify the functionality of the priority queue,
 * including adding elements, polling the highest-priority element,
 * and removing specific elements. The tests also compare the behavior
 * of ComparableIntPriorityQueue with the standard PriorityQueue from
 * the Java Collections Framework.
 */
public class QueueTests {

    /**
     * Tests the functionality of the ComparableIntPriorityQueue implementation
     * by comparing it with the standard Java PriorityQueue. This test evaluates
     * the following operations:
     *
     * - Adding elements to both queues
     * - Polling the highest-priority element from both queues
     * - Removing specific elements from both queues
     * - Converting the queue state to an array and displaying it
     */
    @Test
    public void test() {
        CompleteIntPriorityQueue queue = new CompleteIntPriorityQueue(5);
        queue.offer(2);
        queue.offer(1);
        queue.offer(4);
        queue.offer(-1);
        queue.offer(5);
        System.out.println(queue);

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(2);
        pq.offer(1);
        pq.offer(4);
        pq.offer(-1);
        pq.offer(5);
        System.out.println(pq);

        int poll = queue.poll();
        System.out.println(poll);

        Integer poll1 = pq.poll();
        System.out.println(poll1);

        queue.remove(4);
        System.out.println(queue);


        pq.remove(4);
        System.out.println(pq);

        int[] newQueue = queue.queue();
        System.out.println(Arrays.toString(newQueue));
    }
}
