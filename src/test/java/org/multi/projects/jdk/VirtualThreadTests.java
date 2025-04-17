package org.multi.projects.jdk;

import org.junit.jupiter.api.Test;

import java.util.Optional;

public class VirtualThreadTests {

    @Test
    public void testVirtualThread() {
        Thread.Builder.OfVirtual virtualThread = Thread.ofVirtual().name("testVirtualThread-", 1);
        Thread t = virtualThread.start(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        });
        System.out.println(t.getState());
        System.out.println(Thread.currentThread().getState());
    }

    @Test
    public void testOptional() {
        Optional<Object> o = Optional.ofNullable(null);
        System.out.println(o);
    }
}
