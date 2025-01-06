package org.multi.projects.jdk;

import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Test;

import java.lang.ref.Cleaner;
import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.concurrent.ThreadFactory;

public class ReferenceTest {

    @Test
    public void testWeakReference() {
        WeakObject wo = new WeakObject("jimmy", 18);
        ReferenceQueue<WeakObject> rq = new ReferenceQueue<>();
        WeakReference<WeakObject> wr = new WeakReference<>(wo, rq);
        System.out.printf("rq.poll()-before-gc: %s%n", rq.poll());
        System.gc();
        System.out.println(wr.get());
        System.out.printf("rq.poll()-after-gc: %s%n", rq.poll());

        WeakObject wo1 = new WeakObject("jimmy", 18);
        Cleaner cleaner = Cleaner.create(new ThreadFactory() {
            @Override
            public Thread newThread(@NotNull Runnable r) {
                return new Thread(r);
            }
        });

        final WeakObject finalWo = wo1;
        cleaner.register(wo1, new Runnable() {
            @Override
            public void run() {
                System.out.printf("clean object: %s", finalWo);
            }
        });

        ReferenceQueue<WeakObject> rq2 = new ReferenceQueue<>();
        PhantomReference<WeakObject> pr = new PhantomReference<>(wo, rq2);
        System.gc();
        System.out.println(pr.get());
        System.out.println(rq2.poll());
    }

    sealed class Common permits WeakObject {
        private final String name;

        public Common(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        @Override
        public String toString() {
            return "Common{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }

    non-sealed class WeakObject extends Common {
        private final int age;

        public WeakObject(String name, int age) {
            super(name);
            this.age = age;
        }

        public int getAge() {
            return age;
        }

        @Override
        public String toString() {
            return "WeakObject{" +
                    "age=" + age +
                    ", name='" + super.name + '\'' +
                    '}';
        }
    }
}
