package org.multi.projects;

/**
 * Represents a node in a binary tree.
 *
 * @param <T> The type of the element stored in the node.
 */
public class TreeNode<T> {
    /**
     * The element stored in this node of the binary tree.
     */
    private T elemet;
    /**
     * The left child node in a binary tree. It refers to the subtree
     * rooted at this child node.
     */
    private TreeNode<T> left;
    /**
     * The right child node in the binary tree.
     */
    private TreeNode<T> right;

    /**
     * Constructs a Node with the specified element.
     *
     * @param elemet The element to be stored in the node.
     */
    public TreeNode(T elemet) {
        this.elemet = elemet;
    }

    /**
     * Retrieves the element stored in this node.
     *
     * @return the element stored in this node
     */
    public T getElemet() {
        return elemet;
    }

    /**
     * Sets the value of the element stored in this node.
     *
     * @param elemet The element to be stored in this node.
     */
    public void setElemet(T elemet) {
        this.elemet = elemet;
    }

    /**
     * Retrieves the left child of this node.
     *
     * @return the left child of this node, or null if there is no left child
     */
    public TreeNode<T> getLeft() {
        return left;
    }

    /**
     * Sets the left child node of this node.
     *
     * @param left the node to be set as the left child
     */
    public void setLeft(TreeNode<T> left) {
        this.left = left;
    }

    /**
     * Returns the right child of this node.
     *
     * @return the right child of the node, or null if there is no right child
     */
    public TreeNode<T> getRight() {
        return right;
    }

    /**
     * Sets the right child of this node.
     *
     * @param right The right child node to be set.
     */
    public void setRight(TreeNode<T> right) {
        this.right = right;
    }
}
