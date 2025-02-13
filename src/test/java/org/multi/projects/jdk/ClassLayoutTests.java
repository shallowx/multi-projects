package org.multi.projects.jdk;

import org.junit.jupiter.api.Test;

public class ClassLayoutTests {

    @Test
    public void test() {
        Layout layout = new Layout(1);
        System.out.println(System.identityHashCode(layout));
        System.out.println("-".repeat(20));

        change(layout);
        System.out.println(layout.x);
        System.out.println("-".repeat(20));

        change0(layout);
        System.out.println(layout.x);
    }

    // actually this params named 'l' is not original 'Layout', it's a replica from original Layout
    // so they are not equals use hashcode
    private void change(Layout l) {
        System.out.println("l-hashcode: " + System.identityHashCode(l));
        l = null;
        System.out.println("l-hashcode: " + System.identityHashCode(l));
    }

    private void change0(Layout l) {
        l.x = 10;
        System.out.println("l0-hashcode: " + System.identityHashCode(l));
    }

    static class Layout {
        private int x;

        public Layout(int x) {
            this.x = x;
        }
    }
}
