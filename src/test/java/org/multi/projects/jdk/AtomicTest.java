package org.multi.projects.jdk;

import org.junit.jupiter.api.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

public class AtomicTest {

    @Test
    public void testAtomicIntegerFieldUpdater() {
        A a = new A(2);
        System.out.println(a.getCount());

        a.setCount(10, Thread.currentThread().getName());
        System.out.println(a.getCount());

        CountDownLatch latch = new CountDownLatch(2);

        Thread.Builder.OfPlatform platform = Thread.ofPlatform();
        platform.daemon(true);
        Thread pThread = platform.start(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    a.setCount(i, Thread.currentThread().getName());
                }
                latch.countDown();
            }
        });

        Thread.Builder.OfVirtual virtual = Thread.ofVirtual();
        Thread vThread = virtual.start(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    a.setCount(i + 10, virtual.toString());
                }
                latch.countDown();
            }
        });
        System.out.printf("v-thread: %s", vThread);

        try {
            latch.await();
        } catch (InterruptedException e) {
            if (!Thread.interrupted()) {
                Thread.currentThread().interrupt();
            }

            if (!pThread.isInterrupted()) {
                pThread.interrupt();
            }

            if (vThread.isInterrupted()) {
                vThread.interrupt();
            }
            System.out.println(e.getMessage());
        }

        System.out.println(a.getCount());
    }

    @Test
    public void testAtomicReferenceFieldUpdater() {
        A a = new A(2);
        System.out.println(a.getCount());

        B b = new B(a);
        b.setA(new A(4));
        System.out.println(b.getA().getCount());
    }

    static class A {

        private static final AtomicIntegerFieldUpdater<A> UPDATER = AtomicIntegerFieldUpdater.newUpdater(A.class, "count");
        private volatile int count;

        public A(int count) {
            this.count = count;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int c, String name) {
            if (UPDATER.compareAndSet(this, count, c)) {
                System.out.printf("thread-name: %s, count-setting: %d%n", name, c);
            }
        }
    }

    static class B {
        private static final AtomicReferenceFieldUpdater<B, A> UPDATER = AtomicReferenceFieldUpdater.newUpdater(B.class, A.class, "a");

        private volatile A a;
        public B(A a) {
            this.a = a;
        }
        public A getA() {
            return a;
        }
        public void setA(A a) {
            UPDATER.compareAndSet(this, this.a, a);
        }
    }
}
