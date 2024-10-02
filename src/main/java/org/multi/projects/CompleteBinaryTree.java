package org.multi.projects;

import java.util.ArrayDeque;

/**
 * Represents a complete binary tree data structure where every level,
 * except possibly the last, is completely filled, and all nodes are
 * as far left as possible.
 *
 * @param <T> the type of elements held in this tree
 */
public class CompleteBinaryTree<T> {

    /**
     * The root node of this complete binary tree.
     */
    private final Node<T> root;

    /**
     * Constructs a CompleteBinaryTree with the specified root node.
     *
     * @param root the root node of the tree
     */
    public CompleteBinaryTree(Node<T> root) {
        this.root = root;
    }

    /**
     * Checks if the binary tree is complete.
     * A binary tree is considered complete if every level, except possibly the last,
     * is completely filled, and all nodes are as far left as possible.
     *
     * @return true if the binary tree is complete, false otherwise
     */
    public boolean isComplete() {
        ArrayDeque<Node<T>> nodes = new ArrayDeque<>();
        nodes.add(root);
        boolean isComplete = false;
        while (!nodes.isEmpty()) {
            Node<T> node = nodes.poll();
            Node<T> left = node.getLeft();
            Node<T> right = node.getRight();
            if (left != null) {
                if (isComplete) {
                    return false;
                }
                nodes.add(left);
            } else {
                isComplete = true;
            }

            if (right != null) {
                if (isComplete) {
                    return false;
                }
                nodes.add(right);
            } else {
                isComplete = true;
            }
        }
        return true;
    }

    /**
     * Adds a node to the binary tree while maintaining its completeness.
     * The new node is inserted at the first available position in level-order.
     *
     * @param node The node to be added to the tree. The node must not be null.
     * @throws NullPointerException If the provided node is null.
     */
    public void offer(Node<T> node) {
        if (node == null) {
            throw new NullPointerException("Not allowed to be null");
        }
        Node<T> current = root;
        while (current != null) {
            Node<T> left = current.getLeft();
            if (left == null) {
                current.setLeft(node);
                break;
            } else {
                Node<T> right = current.getRight();
                if (right == null) {
                    current.setRight(node);
                    break;
                }
            }
            current = left;
        }
    }
}
