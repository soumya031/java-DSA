package graph;

import java.util.*;

public class graphcolouring {

    // ---------- 1. Is Graph Bipartite (BFS) ----------
    public static boolean isBipartite(List<List<Integer>> graph, int V) {
        int[] color = new int[V];
        Arrays.fill(color, -1);
        for (int start = 0; start < V; start++) {
            if (color[start] == -1) {
                Queue<Integer> q = new LinkedList<>();
                q.offer(start);
                color[start] = 0;
                while (!q.isEmpty()) {
                    int node = q.poll();
                    for (int neighbor : graph.get(node)) {
                        if (color[neighbor] == -1) {
                            color[neighbor] = 1 - color[node];
                            q.offer(neighbor);
                        } else if (color[neighbor] == color[node]) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    // ---------- 2. M-Coloring Problem ----------
    public static boolean graphColoring(boolean[][] graph, int m) {
        int V = graph.length;
        int[] color = new int[V];
        return solve(0, graph, color, m, V);
    }

    private static boolean solve(int node, boolean[][] graph, int[] color, int m, int V) {
        if (node == V) return true;

        for (int c = 1; c <= m; c++) {
            if (isSafe(node, graph, color, c, V)) {
                color[node] = c;
                if (solve(node + 1, graph, color, m, V)) return true;
                color[node] = 0;
            }
        }
        return false;
    }

    private static boolean isSafe(int node, boolean[][] graph, int[] color, int c, int V) {
        for (int i = 0; i < V; i++) {
            if (graph[node][i] && color[i] == c)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of vertices: ");
        int V = sc.nextInt();
        System.out.print("Enter number of edges: ");
        int E = sc.nextInt();
        List<List<Integer>> adjList = new ArrayList<>();
        boolean[][] mcolorGraph = new boolean[V][V];
        for (int i = 0; i < V; i++) {
            adjList.add(new ArrayList<>());
            Arrays.fill(mcolorGraph[i], false);
        }
        System.out.println("Enter edges (u v):");
        for (int i = 0; i < E; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            adjList.get(u).add(v);
            adjList.get(v).add(u); // undirected
            mcolorGraph[u][v] = true;
            mcolorGraph[v][u] = true;
        }
        System.out.print("Enter number of colors for M-Coloring: ");
        int m = sc.nextInt();
        System.out.println("\nGraph Coloring Checks:");
        System.out.println("Is Bipartite: " + isBipartite(adjList, V));
        System.out.println("M-Coloring possible: " + graphColoring(mcolorGraph, m));
    }
}
