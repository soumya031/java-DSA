package tree;

import java.util.*;

public class UniqueBST {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = sc.nextInt();

        Solution solution = new Solution();
        System.out.println("Number of unique BSTs with " + n + " nodes: " + solution.numTrees(n));
    }
}

class Solution {
    public int numTrees(int n) {
        int[] uniqTree = new int[n + 1];
        uniqTree[0] = 1;
        uniqTree[1] = 1;

        for (int nodes = 2; nodes <= n; nodes++) {
            uniqTree[nodes] = 0;
            for (int root = 1; root <= nodes; root++) {
                uniqTree[nodes] += uniqTree[root - 1] * uniqTree[nodes - root];
            }
        }

        return uniqTree[n];        
    }
}

/* run the file
 javac tree/UniqueBST.java
 java tree.UniqueBST 
 */ 