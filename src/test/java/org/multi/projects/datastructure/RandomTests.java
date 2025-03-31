package org.multi.projects.datastructure;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class RandomTests {

    @Test
    public void testRandom() {
        Random r = new Random();
        List<Integer> lists = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            lists.add(r.nextInt(11));
        }
        System.out.println(lists);

        System.out.println("-----------------");

        lists.clear();
        ThreadLocalRandom random = ThreadLocalRandom.current();
        for (int i = 0; i < 100; i++) {
            lists.add(random.nextInt(3,11));
        }
        System.out.println(lists);
    }
}
