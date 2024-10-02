package org.multi.projects;

import org.junit.jupiter.api.Test;

/**
 * A test class to verify the functionalities of a CompleteBinaryTree data structure.
 */
public class TreeTest {

    /**
     * Tests the functionalities of the CompleteBinaryTree data structure by constructing
     * a specific tree and verifying its completeness.
     *
     * This method:
     * 1. Creates a root node and several child nodes.
     * 2. Constructs a CompleteBinaryTree with the root node.
     * 3. Adds child nodes to the tree using the offer method.
     * 4. Prints the tree structure.
     * 5. Checks and prints whether the tree is a complete binary tree using the isComplete method.
     */
    @Test
    public void testTree() {
        Node<Integer> root = new Node<>(1);
        Node<Integer> left = new Node<>(2);
        Node<Integer> right = new Node<>(3);
        Node<Integer> leftLeft = new Node<>(4);
        Node<Integer> leftRight = new Node<>(5);

        CompleteBinaryTree<Integer> tree1 = new CompleteBinaryTree<>(root);
        tree1.offer(left);
        tree1.offer(right);
        tree1.offer(leftLeft);
        tree1.offer(leftRight);
        System.out.println(tree1);

        System.out.println(tree1.isComplete());
    }
}
