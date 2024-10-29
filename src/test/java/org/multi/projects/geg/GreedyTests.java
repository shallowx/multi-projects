package org.multi.projects.geg;

import org.junit.jupiter.api.Test;

import java.security.SecureRandom;

public class GreedyTests {

    @Test
    public void test() {
        SecureRandom r = new SecureRandom();
        int amt = r.nextInt(0, Integer.MAX_VALUE);
        int k = r.nextInt(20);
        int[] coins = new int[k];
        for (int i = 0; i < k; i++) {
            coins[i] = r.nextInt(0, Integer.MAX_VALUE);
        }
        int step = step(coins, amt);
        System.out.println(step);
    }

    private int step(int[] coins, int amt) {
        int i = coins.length - 1;
        int step = 0;
        if (coins.length == 0 || amt < 0) {
            return ~step;
        }

        while (amt > 0) {
            while (i > 0 && coins[i] > amt) {
                i--;
            }
            amt -= coins[i];
            step++;
        }
        return step;
    }
}
