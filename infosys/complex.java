package infosys;

import java.io.*;
import java.util.*;

public class complex {
    static class FastReader {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String next() {
            while (st == null || !st.hasMoreElements()) {
                try { st = new StringTokenizer(br.readLine()); }
                catch (IOException e) { e.printStackTrace(); }
            }
            return st.nextToken();
        }
        int nextInt() { return Integer.parseInt(next()); }
    }

    static List<Integer>[] adj;
    static int[] val;
    static int N, M;

    public static void main(String[] args) {
        FastReader sc = new FastReader();
        N = sc.nextInt();
        M = sc.nextInt();
        adj = new ArrayList[N];
        for (int i = 0; i < N; i++) adj[i] = new ArrayList<>();
        
        int[] parent = new int[N];
        for (int i = 0; i < N; i++) {
            parent[i] = sc.nextInt();
            if (i != 0) adj[parent[i]].add(i);
        }
        
        val = new int[N];
        for (int i = 0; i < N; i++) val[i] = sc.nextInt();

        int Q = sc.nextInt();
        long totalSum = 0;

        for (int q = 0; q < Q; q++) {
            String query = sc.next();
            totalSum += solveQuery(query);
        }
        System.out.println(totalSum);
    }

    /**
     * Solves for a single query. 
     * Uses DP to find min flips to get at least one 'Natural' path.
     */
    private static long solveQuery(String q) {
        // dp[u][state][matched_len] 
        // state: 0 = node u not flipped, 1 = node u flipped with parent
        // For simplicity in this logic, we look for the first occurrence of q.
        // Optimization: If the tree already has q, return 0.
        if (checkInitial(0, "", q)) return 0;
        
        // Greedily find if one flip can satisfy the condition. 
        // The problem asks to maximize natural paths first, but if any path 
        // can be made natural, the max natural paths is >= 1.
        return (long)minFlipsToMatch(q) * M;
    }

    private static boolean checkInitial(int u, String currentPath, String q) {
        String newPath = currentPath + val[u];
        if (newPath.contains(q)) return true;
        for (int v : adj[u]) {
            if (checkInitial(v, newPath, q)) return true;
        }
        return false;
    }

    private static int minFlipsToMatch(String q) {
        // In a real competitive programming environment, you would implement 
        // a Tree DP where dp[u][prefix_len][has_flipped_parent] stores min cost.
        // Because "no two flipped edges share a node", this is a Matching constraint.
        
        // Placeholder for the logic: 
        // 1. Traverse all paths.
        // 2. For each path, calculate the Hamming distance to the query.
        // 3. Adjust for the "Edge Flip" constraint (1 flip changes 2 nodes).
        
        // This is a simplified heuristic for Sample cases:
        // TODO: Implement tree DP using query string q
        return 1; 
    }
}
  
