package org.multi.projects.geg;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

public class QueueTests {

    @Test
    public void testQueue() {
        Queue queue = new Queue(4);
        queue.offer(1);
        queue.offer(10);
        queue.offer(100);
        Assertions.assertFalse(queue.isEmpty());
        Assertions.assertEquals(1, queue.poll());
        Assertions.assertEquals(10, queue.peek());
        Assertions.assertEquals(10, queue.poll());
        Assertions.assertEquals(100, queue.poll());
        Assertions.assertTrue(queue.isEmpty());
    }

    @Test
    public void testRingQueue() {
        RingQueue ringQueue = new RingQueue(4);
        ringQueue.offer(1);
        ringQueue.offer(10);
        ringQueue.offer(100);
        ringQueue.offer(1000);

        Assertions.assertFalse(ringQueue.isEmpty());
        Assertions.assertEquals(1, ringQueue.poll());
        Assertions.assertEquals(10, ringQueue.poll());
        ringQueue.offer(10000);
        Assertions.assertFalse(ringQueue.isEmpty());
    }

    static class RingQueue {
        private final int[] queue;
        private int size;
        private int head;
        private int tail;
        private final int limit;

        public RingQueue(int limit) {
            this.queue = new int[limit];
            this.limit = limit;
        }

        public RingQueue(int[] queue) {
            this.queue = queue;
            this.limit = queue.length;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public int size() {
            return size;
        }

        public boolean offer(int value) {
            if (size == limit) {
                return false;
            } else {
                queue[tail] = value;
                tail = (tail == limit - 1) ? 0 : tail + 1;
                size++;
            }
           return true;
        }

        public int poll() {
            if (isEmpty()) {
                throw new NoSuchElementException();
            }
            int value = queue[head];
            head = (head + 1) == limit ? 0 : head + 1;
            size--;
            return value;
        }
    }

    static class Queue {
        private final int[] queue;
        private int left;
        private int right;

        public Queue(int[] queue) {
            this.queue = queue;
        }

        public Queue(int size) {
            this.queue = new int[size];
        }

        public boolean isEmpty() {
            return left == right;
        }

        public int size() {
            return right - left;
        }

        public int peek() {
            if (isEmpty()) {
                throw new NoSuchElementException();
            }
            return queue[left];
        }

        public void offer(int value) {
            queue[right++] = value;
        }

        public int poll() {
            if (isEmpty()) {
                throw new NoSuchElementException();
            }
            return queue[left++];
        }
    }
}
