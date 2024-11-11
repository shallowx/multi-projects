package org.multi.projects.geg;

import org.junit.jupiter.api.Test;
import java.util.Stack;

public class StackTests {

    @Test
    public void test() {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(1);
        minStack.push(2);
        minStack.push(-3);

        System.out.println(minStack);
    }

    static class MinStack{
        private final Stack<Integer> items;
        private final Stack<Integer> minItems;

        public MinStack(Stack<Integer> items) {
            this.items = items;
            this.minItems = new Stack<>();
        }

        public MinStack() {
            this.items = new Stack<>();
            this.minItems = new Stack<>();
        }

        public void push(int item) {
            items.push(item);
            if (minItems.isEmpty()) {
                minItems.push(item);
            } else {
                Integer min = minItems.peek();
                minItems.push(item < min ? item : min);
            }
        }

        public int pop() {
            Integer item = items.pop();
            minItems.pop();
            return item;
        }

        public int min() {
            return minItems.peek();
        }
    }

    static class Stack0 {
        private final Object[] items;
        private int length;

        public Stack0(Object[] item) {
            this.items = item;
        }

        public Stack0(int l) {
            items = new Object[l];
        }

        public void push(Object item) {
            items[length++] = item;
        }

        public Object pop() {
            Object e = items[length];
            items[length--] = null;
            return e;
        }
    }
}
