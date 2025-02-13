package org.multi.projects.datastructure;

import org.junit.jupiter.api.Test;

public class LinkedTests {

    @Test
    public void test() {
        LinkedNode n1 = new LinkedNode(1, null);
        LinkedNode n2 = new LinkedNode(2, n1);
        LinkedNode n3 = new LinkedNode(3, n2);
        LinkedNode n4 = new LinkedNode(4, n3);
        System.out.println(n4);

        LinkedNode ret = reverse(n4);
        System.out.println(ret);
    }

    private LinkedNode reverse(LinkedNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        LinkedNode vNode = null;
        LinkedNode next;
        while (head != null) {
            next = head.next;
            head.next = vNode;
            vNode = head;
            head = next;
        }
        return vNode;
    }

    static class LinkedNode {
        int v;
        LinkedNode next;

        public LinkedNode(int v, LinkedNode next) {
            this.v = v;
            this.next = next;
        }

        @Override
        public String toString() {
            return "[" +
                    "v=" + v +
                    ", next=" + next +
                    ']';
        }
    }
}
