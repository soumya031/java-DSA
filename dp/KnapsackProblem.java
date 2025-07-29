package dp;

import java.util.*;

class KnapsackProblem {
    public int solve(int[] wt, int[] val, int W, int n, int[][] dp) {
        if (n == 0 || W == 0) return 0;
        if (dp[n][W] != -1) return dp[n][W];
        if (wt[n - 1] <= W) {
            return dp[n][W] = Math.max(
                val[n - 1] + solve(wt, val, W - wt[n - 1], n - 1, dp),
                solve(wt, val, W, n - 1, dp)
            );
        } else {
            return dp[n][W] = solve(wt, val, W, n - 1, dp);
        }
    }

    public int knapsack(int[] wt, int[] val, int W) {
        int n = wt.length;
        int[][] dp = new int[n + 1][W + 1];
        for (int[] row : dp) Arrays.fill(row, -1);
        return solve(wt, val, W, n, dp);
    }
//Tabulation (Bottom-Up)
/*
 * public int knapsack(int[] wt, int[] val, int W) {
        int n = wt.length;
        int[][] dp = new int[n + 1][W + 1];

        for (int i = 1; i <= n; i++) {
            for (int w = 0; w <= W; w++) {
                if (wt[i - 1] <= w) {
                    dp[i][w] = Math.max(
                        val[i - 1] + dp[i - 1][w - wt[i - 1]],
                        dp[i - 1][w]
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
        KnapsackProblem kp = new KnapsackProblem();
        int[] wt = {2, 3, 4};
        int[] val = {40, 50, 100};
        int W = 5;
        System.out.println(kp.knapsack(wt, val, W));
    }
}


