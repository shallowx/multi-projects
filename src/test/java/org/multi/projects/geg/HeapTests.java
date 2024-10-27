package org.multi.projects.geg;

import org.junit.jupiter.api.Test;
import java.util.PriorityQueue;

public class HeapTests {

    @Test
    public void testHeap() {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.offer(3);
        queue.offer(1);
        queue.offer(2);
        queue.offer(4);
        queue.offer(0);
        System.out.println(queue);
    }
}
