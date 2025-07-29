package graph;

import java.util.*;

public class bsfdsf {
    private int V; // Number of vertices
    private List<List<Integer>> adj;

    // Constructor
    public bsfdsf(int V) {
        this.V = V;
        adj = new ArrayList<>();
        for(int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
    }

    // Add edge
    public void addEdge(int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u); // For undirected graph
    }

    // BFS Traversal
    public void BFS(int start) {
        boolean[] visited = new boolean[V];
        Queue<Integer> queue = new LinkedList<>();

        visited[start] = true;
        queue.add(start);

        while(!queue.isEmpty()) {
            int node = queue.poll();
            System.out.print(node + " ");

            for(int neighbor : adj.get(node)) {
                if(!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
    }

    // DFS Traversal
    public void DFS(int start) {
        boolean[] visited = new boolean[V];
        dfsHelper(start, visited);
    }

    private void dfsHelper(int node, boolean[] visited) {
        visited[node] = true;
        System.out.print(node + " ");

        for(int neighbor : adj.get(node)) {
            if(!visited[neighbor]) {
                dfsHelper(neighbor, visited);
            }
        }
    }

    // Main method to test
    public static void main(String[] args) {
        bsfdsf g = new bsfdsf(5);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 4);
        System.out.print("BFS starting from node 0: ");
        g.BFS(0);
        System.out.println();
        System.out.print("DFS starting from node 0: ");
        g.DFS(0);
    }
}

