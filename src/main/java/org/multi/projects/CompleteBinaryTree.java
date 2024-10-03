package org.multi.projects;

import java.lang.reflect.Array;
import java.util.*;

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

        ArrayDeque<Node<T>> nodes = new ArrayDeque<>();
        nodes.add(root);
        while (!nodes.isEmpty()) {
            Node<T> current = nodes.poll();
            Node<T> left = current.getLeft();
            Node<T> right = current.getRight();
            if (left == null) {
                current.setLeft(node);
                break;
            } else {
                nodes.add(left);
            }

            if (right == null) {
                current.setRight(node);
                break;
            } else {
                nodes.add(right);
            }
        }
    }

    /**
     * Performs a breadth-first search (BFS) traversal on the binary tree and returns an array of elements
     * in BFS order.
     *
     * @param clz The class type of the elements in the binary tree.
     * @return An array of elements in the binary tree following BFS order.
     */
    public  T[] bfs(Class<T> clz) {
        List<T> elements = new ArrayList<>();
        if (root == null) {
            return elements.toArray((T[]) Array.newInstance(clz, 0));
        }
        ArrayDeque<Node<T>> nodes = new ArrayDeque<>();
        nodes.add(root);
        while (!nodes.isEmpty()) {
            Node<T> current = nodes.poll();
            elements.add(current.getElemet());

            Node<T> left = current.getLeft();
            Node<T> right = current.getRight();
            if (left != null) {
                nodes.offer(left);
            }

            if (right != null) {
                nodes.offer(right);
            }
        }
        return elements.toArray( (T[]) Array.newInstance(clz, elements.size()));
    }

    /**
     * Performs a depth-first search (DFS) traversal on the binary tree starting from the root.
     *
     * @param clz The class type of the elements in the binary tree.
     * @return An array of elements in the binary tree following DFS order.
     */
    public T[] dfs(Class<T> clz) {
        List<T> elements = new ArrayList<>();
        if (root == null) {
            return elements.toArray((T[]) Array.newInstance(clz, 0));
        }
        preDfs(root, elements);
        return elements.toArray( (T[]) Array.newInstance(clz, elements.size()));
    }

    /**
     * Performs a pre-order depth-first search (DFS) traversal on the binary tree.
     *
     * @param node     The current node being visited in the binary tree.
     * @param elements The list where the elements of the visited nodes are collected.
     */
    private void preDfs(Node<T> node, List<T> elements) {
        if (node == null) {
            return;
        }
        elements.add(node.getElemet());
        preDfs(node.getLeft(), elements);
        preDfs(node.getRight(), elements);
    }

    /**
     * Performs a pre-order depth-first search (DFS) traversal on the binary tree
     * and returns an array of elements in pre-order.
     *
     * @param clz The class type of the elements in the binary tree.
     * @return An array of elements in the binary tree following pre-order DFS traversal.
     */
    public T[] preDfs(Class<T> clz) {
        List<T> elements = new ArrayList<>();
        if (root == null) {
            return elements.toArray((T[]) Array.newInstance(clz, 0));
        }
        Stack<Node<T>> nodes = new Stack<>();
        nodes.push(root);
        while (!nodes.isEmpty()) {
            Node<T> current = nodes.pop();
            elements.add(current.getElemet());
            if (current.getRight() != null) {
                nodes.push(current.getRight());
            }

            if (current.getLeft() != null) {
                nodes.push(current.getLeft());
            }
        }
        return elements.toArray( (T[]) Array.newInstance(clz, elements.size()));
    }

    /**
     * Performs an in-order traversal (DFS) on the binary tree and returns an array of elements in the tree
     * in in-order sequence.
     *
     * @param clz The class type of the elements in the binary tree.
     * @return An array of elements in the binary tree following in-order DFS sequence.
     */
    public T[] inDfs(Class<T> clz) {
        List<T> elements = new ArrayList<>();
        if (root == null) {
            return elements.toArray((T[]) Array.newInstance(clz, 0));
        }
        Stack<Node<T>> nodes = new Stack<>();
        Node<T> current = root;
        while (current != null || !nodes.isEmpty()) {
            while (current != null) {
                nodes.push(current);
                current = current.getLeft();
            }
            current = nodes.pop();
            elements.add(current.getElemet());
            current = current.getRight();
        }

        return elements.toArray( (T[]) Array.newInstance(clz, elements.size()));
    }

    /**
     * Performs a depth-first search (DFS) traversal in post-order
     * (left-right-root) on the binary tree and returns an array of elements.
     *
     * @param clz The class type of the elements in the binary tree.
     * @return An array of elements in the binary tree following post-order DFS.
     */
    public T[] suffixDfs(Class<T> clz) {
        List<T> elements = new ArrayList<>();
        if (root == null) {
            return elements.toArray((T[]) Array.newInstance(clz, 0));
        }
        Stack<Node<T>> nodes = new Stack<>();
        nodes.push(root);
        while (!nodes.isEmpty()) {
            Node<T> current = nodes.pop();
            elements.add(current.getElemet());

            if (current.getLeft() != null) {
                nodes.push(current.getLeft());
            }
            if (current.getRight() != null) {
                nodes.push(current.getRight());
            }
        }
        Collections.reverse(elements);
        return elements.toArray( (T[]) Array.newInstance(clz, elements.size()));
    }

}
