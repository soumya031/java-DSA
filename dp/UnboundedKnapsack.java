package dp;

import java.util.*;

public class UnboundedKnapsack {
    public int solve(int[] wt, int[] val, int W, int n, int[][] dp) {
        if (n == 0 || W == 0) return 0;
        if (dp[n][W] != -1) return dp[n][W];
        if (wt[n - 1] <= W) {
            return dp[n][W] = Math.max(
                val[n - 1] + solve(wt, val, W - wt[n - 1], n, dp),
                solve(wt, val, W, n - 1, dp)
            );
        } else {
            return dp[n][W] = solve(wt, val, W, n - 1, dp);
        }
    }

    public int unboundedKnapsack(int[] wt, int[] val, int W) {
        int n = wt.length;
        int[][] dp = new int[n + 1][W + 1];
        for (int[] row : dp) Arrays.fill(row, -1);
        return solve(wt, val, W, n, dp);
    }
//Tabulation (Bottom-Up)
/*
 * public int unboundedKnapsack(int[] wt, int[] val, int W) {
        int n = wt.length;
        int[][] dp = new int[n + 1][W + 1];

        for (int i = 1; i <= n; i++) {
            for (int w = 0; w <= W; w++) {
                if (wt[i - 1] <= w) {
                    dp[i][w] = Math.max(
                        val[i - 1] + dp[i][w - wt[i - 1]], // reuse same item
                        dp[i - 1][w]                        // skip
                    );
                } else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }

        return dp[n][W];
    }
}
 */
    public static void main(String[] args) {
        UnboundedKnapsack uk = new UnboundedKnapsack();
        int[] wt = {2, 3, 4};
        int[] val = {40, 50, 100};
        int W = 5;
        System.out.println(uk.unboundedKnapsack(wt, val, W));
    }
}
 
