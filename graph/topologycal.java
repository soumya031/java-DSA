
package graph;

import java.util.*;


public class topologycal{
        // ---------- Kahn's Algorithm (BFS) ----------
    public static List<Integer> kahnTopologicalSort(int V, List<List<Integer>> adj) {
        int[] inDegree = new int[V];
        for (int u = 0; u < V; u++) {
            for (int v : adj.get(u)) {
                inDegree[v]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (inDegree[i] == 0) queue.add(i);
        }

        List<Integer> topo = new ArrayList<>();
        while (!queue.isEmpty()) {
            int u = queue.poll();
            topo.add(u);

            for (int v : adj.get(u)) {
                inDegree[v]--;
                if (inDegree[v] == 0) queue.add(v);
            }
        }

        if (topo.size() != V) {
            System.out.println("Graph has a cycle. Topological sorting not possible.");
            return new ArrayList<>();
        }

        return topo;
    }

    // ---------- Cycle Detection in Directed Graph (DFS + RecStack) ----------
    public static boolean hasCycle(int V, List<List<Integer>> adj) {
        boolean[] visited = new boolean[V];
        boolean[] recStack = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (dfsCycle(i, adj, visited, recStack)) return true;
            }
        }
        return false;
    }

    private static boolean dfsCycle(int node, List<List<Integer>> adj, boolean[] visited, boolean[] recStack) {
        visited[node] = true;
        recStack[node] = true;

        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor] && dfsCycle(neighbor, adj, visited, recStack))
                return true;
            else if (recStack[neighbor])
                return true;
        }

        recStack[node] = false;
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of vertices: ");
        int V = sc.nextInt();
        System.out.print("Enter number of edges: ");
        int E = sc.nextInt();
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        System.out.println("Enter edges (u v): (u -> v)");
        for (int i = 0; i < E; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            adj.get(u).add(v);
        }
        // Detect Cycle
        System.out.println("\nCycle Detection:");
        boolean cycle = hasCycle(V, adj);
        System.out.println(cycle ? "Cycle detected!" : "No cycle detected.");

        // Topological Sort
        System.out.println("\nTopological Sort using Kahn's Algorithm:");
        List<Integer> topo = kahnTopologicalSort(V, adj);
        if (!topo.isEmpty()) {
            for (int node : topo) System.out.print(node + " ");
            System.out.println();
        }
    }
}