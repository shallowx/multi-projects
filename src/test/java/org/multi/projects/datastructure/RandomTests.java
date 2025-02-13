package org.multi.projects.datastructure;

import org.junit.jupiter.api.Test;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class RandomTests {

    @Test
    public void testRandom() {
        Random r = new Random();
        for (int i = 0; i < 100; i++) {
            System.out.println(r.nextInt(11));
        }

        System.out.println("-----------------");

        ThreadLocalRandom random = ThreadLocalRandom.current();
        for (int i = 0; i < 100; i++) {
            System.out.println(random.nextInt(3,11));
        }
    }
}
