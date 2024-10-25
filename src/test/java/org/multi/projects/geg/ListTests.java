package org.multi.projects.geg;

import org.junit.jupiter.api.Test;

public class ListTests {

    @Test
    public void test01() {
        Node<Integer> node2 = new Node<>(3,null);
        Node<Integer> node1 = new Node<>(2,node2);
        Node<Integer> root = new Node<>(1, node1);

        Node<Integer> node21 = new Node<>(5,null);
        Node<Integer> node11 = new Node<>(4,node21);
        Node<Integer> root1 = new Node<>(0, node11);
        Node<Integer> merge = merge(root, root1);
        System.out.println(merge);
    }

    private Node<Integer> merge(Node<Integer> root1, Node<Integer> root2) {
        Node<Integer> head = root1.element < root2.element ? root1 : root2;
        Node<Integer> c1 = head == root1 ? root2 : root1;
        Node<Integer> pre = head;

        return head;
    }
}

     class Node<T> {
        /**
         * The element stored in this node.
         * This can be any object of type T.
         */
        T element;
        /**
         * The next node in the linked list.
         */
        Node<T> next;

        /**
         * Constructs a new Node with the specified element and next node reference.
         *
         * @param element the element to be stored in this node
         * @param next the next node in the linked list
         */
        public Node(T element, Node<T> next) {
            this.element = element;
            this.next = next;
        }
}
