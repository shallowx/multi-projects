package org.multi.projects;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.PriorityQueue;

public class QueueTests {

    @Test
    public void test() {
        ComparableIntPriorityQueue queue = new ComparableIntPriorityQueue(5);
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
