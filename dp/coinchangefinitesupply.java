package dp;

public class coinchangefinitesupply {
    static final int MOD = 1000000007;
    public static int coinChange(int n, int[] coins, int[] freq, int v) {
        int[] dp = new int[v + 1];
        dp[0] = 1; // One way to make 0 (no coins)
        // For each coin type
        for (int i = 0; i < n; i++) {
            int coin = coins[i];
            int count = freq[i];
            // Go from high to low to avoid overcounting (finite supply)
            for (int currSum = v; currSum >= 0; currSum--) {
                for (int k = 1; k <= count; k++) {
                    int nextSum = currSum + k * coin;
                    if (nextSum > v) break;
                    dp[nextSum] = (dp[nextSum] + dp[currSum]) % MOD;
                }
            }
        }
        return dp[v];
    }

    public static void main(String[] args){
        int n = 3;
        int[] coins = {1, 2, 3};
        int[] freq = {1, 1, 3};
        int v = 6;
        System.out.println(coinChange(n, coins, freq, v));
        // Output: 2
    }
}
