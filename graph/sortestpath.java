package graph;
// Graph Shortest Path Algorithms 
// Includes: BFS, Dijkstra, Bellman-Ford, Floyd-Warshall 

import java.util.*;

public class sortestpath {

    // ---------- 1. BFS for Unweighted Graph ----------
    public static int bfsUnweighted(List<List<Integer>> adj, int src, int dest, int V) {
        boolean[] visited = new boolean[V];
        int[] dist = new int[V];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(src);
        visited[src] = true;
        dist[src] = 0;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int neighbor : adj.get(node)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    dist[neighbor] = dist[node] + 1;
                    queue.add(neighbor);
                }
            }
        }
        return dist[dest];
    }


    // ---------- 2. Dijkstra's Algorithm (Min-Heap) ----------
    public static int dijkstra(int V, List<List<int[]>> graph, int src, int dest) {
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.add(new int[]{src, 0});
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int u = curr[0];
            int d = curr[1];
            if (d > dist[u]) continue;
            for (int[] edge : graph.get(u)) {
                int v = edge[0], w = edge[1];
                if (dist[u] + w < dist[v]) {
                    dist[v] = dist[u] + w;
                    pq.add(new int[]{v, dist[v]});
                }
            }
        }
        return dist[dest];
    }


    // ---------- 3. Bellman-Ford Algorithm ----------
    public static int bellmanFord(int V, int[][] edges, int src, int dest) {
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        for (int i = 0; i < V - 1; i++) {
            for (int[] edge : edges) {
                int u = edge[0], v = edge[1], w = edge[2];
                if (dist[u] != Integer.MAX_VALUE && dist[u] + w < dist[v]) {
                    dist[v] = dist[u] + w;
                }
            }
        }
        return dist[dest];
    }


    // ---------- 4. Floyd-Warshall Algorithm ----------
    public static int[][] floydWarshall(int V, int[][] matrix) {
        int[][] dist = new int[V][V];

        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                dist[i][j] = matrix[i][j];
            }
        }
        for (int k = 0; k < V; k++) {
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    if (dist[i][k] != Integer.MAX_VALUE && dist[k][j] != Integer.MAX_VALUE)
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }
        return dist;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of vertices: ");
        int V = sc.nextInt();
        System.out.print("Enter number of edges: ");
        int E = sc.nextInt();
        List<List<Integer>> adjList = new ArrayList<>();
        List<List<int[]>> weightedGraph = new ArrayList<>();
        int[][] edgeList = new int[E][3];
        int[][] matrix = new int[V][V];
        for (int i = 0; i < V; i++) {
            adjList.add(new ArrayList<>());
            weightedGraph.add(new ArrayList<>());
            for (int j = 0; j < V; j++) {
                matrix[i][j] = (i == j) ? 0 : Integer.MAX_VALUE;
            }
        }
        System.out.println("Enter edges (u v w):");
        for (int i = 0; i < E; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();
            adjList.get(u).add(v);
            adjList.get(v).add(u); // For BFS (undirected)
            weightedGraph.get(u).add(new int[]{v, w});
            edgeList[i][0] = u;
            edgeList[i][1] = v;
            edgeList[i][2] = w;
            matrix[u][v] = w;
        }
        System.out.print("Enter source node: ");
        int src = sc.nextInt();
        System.out.print("Enter destination node: ");
        int dest = sc.nextInt();
        System.out.println("\nShortest Path Results:");
        System.out.println("BFS (unweighted): " + bfsUnweighted(adjList, src, dest, V));
        System.out.println("Dijkstra: " + dijkstra(V, weightedGraph, src, dest));
        System.out.println("Bellman-Ford: " + bellmanFord(V, edgeList, src, dest));
        int[][] fw = floydWarshall(V, matrix);
        System.out.println("Floyd-Warshall: " + (fw[src][dest] == Integer.MAX_VALUE ? "INF" : fw[src][dest]));
    }
} // End of GraphShortestPath



