package dp;

import java.util.*;

class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n]; 
        dp[0] = nums[0];
        int maxSum = dp[0];

        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
            maxSum = Math.max(maxSum, dp[i]);
        }

        return maxSum;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {-2, 1, -3, 4, -1, 2, 1};
        System.out.println(s.maxSubArray(nums)); // Output: 6
    }
}
