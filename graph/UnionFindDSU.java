package graph;

// Union Find (Disjoint Set Union) - Java Implementation
// Covers: Redundant Connection, Network Connection, Provinces, Kruskal's MST

import java.util.*;

public class UnionFindDSU {
    static class DSU {
        int[] parent, rank;
        DSU(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) parent[i] = i;
        }

        int find(int x) {
            if (parent[x] != x)
                parent[x] = find(parent[x]);
            return parent[x];
        }

        boolean union(int x, int y) {
            int px = find(x), py = find(y);
            if (px == py) return false;
            if (rank[px] < rank[py]) parent[px] = py;
            else if (rank[px] > rank[py]) parent[py] = px;
            else {
                parent[py] = px;
                rank[px]++;
            }
            return true;
        }
    }

    // ---------- Redundant Connection ----------
    public static int[] findRedundantConnection(int[][] edges, int n) {
        DSU dsu = new DSU(n + 1);
        for (int[] edge : edges) {
            if (!dsu.union(edge[0], edge[1])) return edge;
        }
        return new int[0];
    }

    // ---------- Number of Operations to Make Network Connected ----------
    public static int makeConnected(int n, int[][] connections) {
        if (connections.length < n - 1) return -1;
        DSU dsu = new DSU(n);
        int components = n;
        for (int[] conn : connections) {
            if (dsu.union(conn[0], conn[1])) components--;
        }
        return components - 1;
    }

    // ---------- Number of Provinces ----------
    public static int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        DSU dsu = new DSU(n);
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (isConnected[i][j] == 1) {
                    dsu.union(i, j);
                }
            }
        }
        Set<Integer> provinces = new HashSet<>();
        for (int i = 0; i < n; i++) provinces.add(dsu.find(i));
        return provinces.size();
    }

    // ---------- Kruskal's Algorithm ----------
    public static int kruskalMST(int V, int[][] edges) {
        Arrays.sort(edges, Comparator.comparingInt(a -> a[2]));
        DSU dsu = new DSU(V);
        int mstCost = 0;
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], w = edge[2];
            if (dsu.union(u, v)) {
                mstCost += w;
            }
        }
        return mstCost;
    }

    // ---------- Main Method with User Input ----------
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of nodes: ");
        int n = sc.nextInt();
        System.out.print("Enter number of edges: ");
        int e = sc.nextInt();
        int[][] edges = new int[e][3];
        System.out.println("Enter edges (u v w) for Kruskal & Redundant Check:");
        for (int i = 0; i < e; i++) {
            edges[i][0] = sc.nextInt();
            edges[i][1] = sc.nextInt();
            edges[i][2] = sc.nextInt();
        }

        // Redundant Connection Check
        System.out.println("\nRedundant Connection (ignoring weights):");
        int[][] unweighted = new int[e][2];
        for (int i = 0; i < e; i++) {
            unweighted[i][0] = edges[i][0];
            unweighted[i][1] = edges[i][1];
        }
        int[] redundant = findRedundantConnection(unweighted, n);
        System.out.println(redundant.length > 0 ? Arrays.toString(redundant) : "None");
        // Kruskal MST
        System.out.println("\nKruskal's MST Total Cost: " + kruskalMST(n, edges));
        // Network Connected
        System.out.print("\nEnter number of connections for network: ");
        int m = sc.nextInt();
        int[][] connections = new int[m][2];
        System.out.println("Enter each connection (u v):");
        for (int i = 0; i < m; i++) {
            connections[i][0] = sc.nextInt();
            connections[i][1] = sc.nextInt();
        }
        System.out.println("Operations to Connect All: " + makeConnected(n, connections));
        System.out.print("\nEnter number of cities for provinces: ");
        int c = sc.nextInt();
        int[][] provinceMat = new int[c][c];
        System.out.println("Enter connectivity matrix:");
        for (int i = 0; i < c; i++) {
            for (int j = 0; j < c; j++) {
                provinceMat[i][j] = sc.nextInt();
            }
        }
        System.out.println("Number of Provinces: " + findCircleNum(provinceMat));
    }
} 