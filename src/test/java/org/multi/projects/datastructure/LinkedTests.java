package org.multi.projects.datastructure;

import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.LinkedList;

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

    @Test
    public void test0() {

    }

    private LinkedNode addTwoNumbers(LinkedNode l1, LinkedNode l2) {
        if (l1 == null) {
            return l2;
        }

        if (l2 == null) {
            return l1;
        }

        LinkedNode ret = null;
        LinkedNode curr = null;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int v1 = l1 == null ? 0 : l1.v;
            int v2 = l2 == null ? 0 : l2.v;
            int sum = v1 + v2 + carry;

            int val = sum % 10;
            carry = sum / 10;

            if (ret == null) {
                curr = new LinkedNode(val);
                ret = curr;
            } else {
                curr.next = new LinkedNode(val);
                curr = curr.next;
            }
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }

        if (carry > 0) {
            curr.next = new LinkedNode(carry);
        }
        return ret;
    }

    private LinkedList<Integer> add(LinkedList<Integer> n1, LinkedList<Integer> n2) {
        if (n1 == null) {
            return n2;
        }

        if (n2 == null) {
            return n1;
        }

        LinkedList<Integer> ret = new LinkedList<>();
        Iterator<Integer> it1 = n1.iterator();
        Iterator<Integer> it2 = n2.iterator();
        int carry = 0;
        while (it1.hasNext() || it2.hasNext()) {
            int v1 = it1.next() == null ? 0 : it1.next();
            int v2 = it2.next() == null ? 0 : it2.next();

            int sum = v1 + v2;
            int val = sum % 10;
            carry = sum / 10;
            ret.add(val);
        }

        if (carry == 1) {
            ret.add(1);
        }
        return ret;
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

        LinkedNode(int v) {
            this.v = v;
        }
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
