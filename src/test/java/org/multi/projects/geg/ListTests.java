package org.multi.projects.geg;

import org.junit.jupiter.api.Test;

public class ListTests {

    @Test
    public void testMerge() {
        Node node4 = new Node(6, null);
        Node node3 = new Node(4, node4);
        Node node2 = new Node(2, node3);
        Node node1 = new Node(1, node2);

        Node node25 = new Node(8, null);
        Node node24 = new Node(7, node25);
        Node node23 = new Node(5, node24);
        Node node22 = new Node(3, node23);
        Node node21 = new Node(0, node22);

        Node merge = merge(node1, node21);
        // 0 -> 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7
        System.out.println(merge);
    }

    // reference
    private Node merge(Node node1, Node node2) {
        Node head = new Node(-1, null);
        Node move = head;
        while (node1 != null && node2 != null) {
            if (node1.data < node2.data) {
                move.next = node1;
                node1 = node1.next;
            } else {
                move.next = node2;
                node2 = node2.next;
            }
            move = move.next;
        }
        move.next = node1 == null ? node2 : node1;
        return head.next;
    }

    static class Node{
        private final int data;
        private Node next;

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }

        @Override
        public String toString() {
            return this.getClass().getSimpleName() + '{' +
                    "data=" + data +
                    ", next=" + next +
                    '}';
        }
   }
}
