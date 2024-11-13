package org.multi.projects.geg;

import org.junit.jupiter.api.Test;

public class TreeTests {

    @Test
    public void testCreateBinaryTree() {
        Node rl = new Node(2, null, null);
        Node rr = new Node(3, null, null);
        Node root = new Node(1, rl, rr);

        System.out.println(root);
    }

    @Test
    public void testFullBinaryTree() {
        Node rrl = new Node(4, null, null);
        Node rl = new Node(2, rrl, null);
        Node rr = new Node(3, null, null);
        Node root = new Node(1, rl, rr);

        System.out.println(root);
    }

    @Test
    public void testInorderTraversal() {
        Node rrl = new Node(4, null, null);
        Node rl = new Node(2, rrl, null);
        Node rr = new Node(3, null, null);
        Node root = new Node(1, rl, rr);
        inorderTraversal(root);
    }

    private void inorderTraversal(Node root) {
        if (root == null) {
            return;
        }
        inorderTraversal(root.left);
        System.out.println("data: " + root.item);
        inorderTraversal(root.right);
    }

    @Test
    public void testDegenerateBinaryTree() {
        Node rr = new Node(3, null, null);
        Node rl = new Node(2, rr, null);
        Node root = new Node(1, rl, null);

        System.out.println(root);
    }

    static class Node {
        int item;
        Node left, right;

        public Node(int item, Node left, Node right) {
            this.item = item;
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString() {
            return this.getClass().getSimpleName() + '{' +
                    "item=" + item +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }
}
