package graph;

import java.util.*;

public class dsf {
     private int V; // Number of vertices
    private List<List<Integer>> adj; // Adjacency list

    // Constructor
    public dsf(int V) {
        this.V = V;
        adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
    }

    // Add edge
    public void addEdge(int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u); // For undirected graph
    }


public  void DFS(int start) {
    boolean[] visited = new boolean[V];
    dfsHelper(start, visited);
}

private void dfsHelper(int node, boolean[] visited) {
    visited[node] = true;
    System.out.print(node + " ");

    for (int neighbor : adj.get(node)) {
        if (!visited[neighbor]) {
            dfsHelper(neighbor, visited); // recursive call
        }
    }

}
public static void main(String[] args) {
        bfs g = new bfs(5);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 4);
        System.out.print("Dsf starting from node 0: ");
        g.bfs(0);
    }
}
