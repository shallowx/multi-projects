package org.multi.projects;


import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * The GraphTests class contains unit tests for different graph implementations and miscellaneous utility methods.
 */
public class GraphTests {

    /**
     * Tests the extraction and conversion of digit characters from a string to an integer.
     *
     * This method processes each character in the given string {@code s}
     * and checks if it is a digit. If the character is a digit, it converts
     * it to an integer and accumulates it in {@code num}.
     */
    @Test
    public void testDigit() {
        String s = "12345";
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                num = num * 10 + s.charAt(i) - '0';
            }
        }
        System.out.println(num);
    }

    /**
     * Tests the calculation of a simple arithmetic expression without considering operator precedence.
     * The expression is given as a string and contains only positive integers and operators (+, -, *, /).
     *
     * The method uses a stack to store intermediate results based on the current and previous operators.
     * It then evaluates the expression from left to right, considering one operator at a time.
     * Finally, it computes the total result by summing up the values in the stack.
     */
    @Test
    public void testCal() {
        String s = "1+2*3-4/5";
        Deque<Integer> stack = new ArrayDeque<>();
        char preSign = '+';
        int num = 0;
        int n = s.length();
        for (int i = 0; i < n; ++i) {
            if (Character.isDigit(s.charAt(i))) {
                num = num * 10 + s.charAt(i) - '0';
            }
            if (!Character.isDigit(s.charAt(i)) && s.charAt(i) != ' ' || i == n - 1) {
                switch (preSign) {
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                    case '*':
                        stack.push(stack.pop() * num);
                        break;
                    default:
                        stack.push(stack.pop() / num);
                }
                preSign = s.charAt(i);
                num = 0;
            }
        }
        int ans = 0;
        while (!stack.isEmpty()) {
            ans += stack.pop();
        }
        System.out.println(ans);
    }

    /**
     * This method tests the functionality of the GraphWithArray class.
     * It creates an instance of a graph with a given number of vertices,
     * adds edges between specified vertices, and prints the adjacency
     * matrix of the graph.
     *
     * The test performs the following operations:
     * 1. Initializes a graph with 5 vertices.
     * 2. Adds edges between vertices (0,1), (0,2), (1,2), (2,0), and (2,3).
     * 3. Prints the adjacency matrix of the graph.
     *
     * The expected result is an adjacency matrix that correctly
     * represents the added edges.
     */
    @Test
    public void testGraphWithArray() {
        GraphWithArray graph = new GraphWithArray(5);
        int[][] adj = graph.adj;

        graph.addEdge(adj, 0, 1);
        graph.addEdge(adj, 0, 2);
        graph.addEdge(adj, 1, 2);
        graph.addEdge(adj, 2, 0);
        graph.addEdge(adj, 2, 3);

        graph.printGraph(adj);
    }

    static class GraphWithArray {
        private final int[][] adj;

        public GraphWithArray(int k) {
            this.adj = new int[k][k];
        }

        public void addEdge(int[][] graph, int v, int e) {
            graph[v][e] = 1;
        }

        public void printGraph(int[][] graph) {
            for (int i = 0; i < graph.length; i++) {
                for (int j = 0; j < graph.length; j++) {
                    System.out.printf("%d ", graph[i][j]);
                }
                System.out.println();
            }
        }

        public void bfs() {
            Set<Integer> visited = new HashSet<>();
            List<Integer> vertices = new ArrayList<>();

        }
    }

    /**
     * Tests the functionality of creating and displaying a graph using an adjacency list representation.
     *
     * This method performs the following actions:
     * - Creates an instance of the GraphWithList class.
     * - Adds vertices to the graph.
     * - Establishes edges (connections) between the vertices.
     * - Displays the graph.
     *
     * Specifically, this method:
     * - Adds vertices 0 and 1.
     * - Adds edges between vertices (0, 1), (1, 0), (0, 2), and (2, 3).
     * - Finally, it calls the displayGraph method to print the graph's adjacency list to the console.
     */
    @Test
    public void testGraphWithList() {
        GraphWithList graph = new GraphWithList();
        graph.addVertex(graph.adj, 0);
        graph.addVertex(graph.adj, 1);

        graph.addEdge(graph.adj, 0, 1);
        graph.addEdge(graph.adj, 1, 0);
        graph.addEdge(graph.adj, 0, 2);
        graph.addEdge(graph.adj, 2, 3);

        graph.displayGraph();
    }

    static class GraphWithList {
        private final Map<Integer, List<Integer>> adj;

        public GraphWithList() {
            this.adj = new HashMap<>();
        }

        public void addVertex(Map<Integer, List<Integer>> adj, int v) {
            adj.computeIfAbsent(v, k -> new ArrayList<>());
        }

        public void addEdge(Map<Integer, List<Integer>> adj, int v, int e) {
            List<Integer> edges = adj.get(v);
            if (edges == null) {
                addVertex(adj, v);
                edges = adj.get(v);
            }
            edges.add(e);
        }

        public void displayGraph() {
            for (Map.Entry<Integer, List<Integer>> entry : adj.entrySet()) {
                System.out.println(entry.getKey() + " -> " + Arrays.toString(entry.getValue().toArray(new Integer[0])));
            }
        }
    }
}
