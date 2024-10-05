package org.multi.projects;

import java.util.Map;
import java.util.NoSuchElementException;

/**
 * A generic single linked list implementation.
 *
 * @param <T> the type of elements in this list
 */
public class SingleLinkedList<T> {

    /**
     * The current number of elements in the linked list.
     */
    private int size;
    /**
     * The first node in the singly linked list.
     */
    private Node<T> first;

    /**
     * Constructs an empty SingleLinkedList.
     */
    public SingleLinkedList() {
    }

    /**
     * Inserts the specified element at the beginning of this list.
     *
     * @param e the element to add
     */
    public void addFirst(T e) {
        Node<T> newNode = new Node<>(e, null);
        Node<T> f = first;
        if (f == null) {
            first = newNode;
        } else {
           newNode.next = f;
           first = newNode;
        }
        size++;
    }

    /**
     * Adds the specified element to the end of the list.
     *
     * @param e the element to be added to the end of the list
     */
    public void addLast(T e) {
        Node<T> newNode = new Node<>(e, null);
        Node<T> f = first;
        if (f == null) {
            first = newNode;
        } else {
            Node<T> current = f;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }

    /**
     * Adds the specified element to the list immediately before the first occurrence
     * of the given element. If the given element is not present in the list, the specified
     * element is added to the end of the list.
     *
     * @param before the element before which the new element should be added
     * @param e the element to be added to the list
     */
    public void addBefore(T before, T e) {
        Node<T> newNode = new Node<>(e, null);
        Node<T> f = first;
        if (f == null) {
            first = newNode;
        } else {
            Node<T> current = f;
            Node<T> prev = null;
            while (current != null) {
                if (current.element == before) {
                    break;
                }
                prev = current;
                current = current.next;
            }

            if (current == null) {
                addLast(e);
            } else {
                newNode.next = current;
                prev.next = newNode;
            }
            size++;
        }
    }

    /**
     * Adds the specified element immediately after the first occurrence of the given element
     * in this list. If the given element is not present in the list, the*/
    public void addAfter(T after, T e) {
        Node<T> newNode = new Node<>(e, null);
        Node<T> f = first;
        if (f == null) {
            first = newNode;
        } else {
            Node<T> current = f;
            while (current != null) {
                if (current.element == after) {
                    break;
                }
                current = current.next;
            }

            if (current == null) {
                addLast(e);
            } else {
                newNode.next = current.next;
                current.next = newNode;
            }
            size++;
        }
    }

    /**
     * Reverses the order of the nodes in the linked list.
     *
     * This method modifies the list such that the first node becomes the last node,
     * the second node becomes the second-to-last node, and so on. If the list is
     * empty, it throws a NoSuchElementException.
     *
     * @throws NoSuchElementException if the list is empty
     */
    public void reverse() {
        Node<T> f = first;
        if (f == null) {
            throw new NoSuchElementException();
        }

        Node<T> current = f;
        Node<T> target = null;
        while (current != null) {
            Node<T> continues = current.next;
            current.next = target;
            target = current;
            current = continues;
        }
        first = target;
    }

    /**
     * Removes the first element from this list.
     *
     * @throws NoSuchElementException if the list is empty
     */
    public void removeFirst() {
        if (first == null) {
           throw new NoSuchElementException();
        }
        first = first.next;
        size--;
    }

    /**
     * Removes the first occurrence of the specified element from this list if it is present.
     * If the list is empty, it throws a NoSuchElementException.
     *
     * @param e the element to be removed from the list
     * @throws NoSuchElementException if the list is empty
     */
    public void remove(T e) {
        if (first == null) {
            throw new NoSuchElementException();
        }

        Node<T> current = first;
        Node<T> prev = null;
        while (current != null) {
            Node<T> continues = current.next;
            if (current.element == e) {
                prev.next = continues;
                size--;
                break;
            }
            prev = current;
            current = continues;
        }
    }

    /**
     * Checks if the singly linked list contains a cycle.
     *
     * This method uses Floyd's Tortoise and Hare algorithm to detect cycles
     * in the linked list. It advances two pointers through the list at
     * different speeds and checks if they ever meet. If the list contains
     * a cycle, the fast pointer will eventually meet the slow pointer,
     * indicating the presence of a cycle.
     *
     * @return {@code true} if the list contains a cycle, {@code false} otherwise
     */
    public boolean hasCycle() {
        Node<T> f = first;
        if (f == null || f.next == null) {
            return false;
        }

        Node<T> slow = f;
        Node<T> fast = f;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    private static class Node<T> {
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
}
