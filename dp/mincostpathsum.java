package dp;

import java.util.*;

class Solution {
    static int[][] dp;
    public int path(int[][] arr, int r, int c){
        int n = arr.length, m = arr[0].length;
        if(r = n || c < 0 || c == 0) return Integer.MIN_VALUE;
        if(r == n - 1) return arr[r][c];
        if(dp[r][c]!= 0) return dp[r][c];
        int down = path(arr, r - 1, c-1);
        int right = path(arr , r + 1, c +1);
        return dp[r][c] = arr[r][c] + Math.max(left.Math.max(down , right));
    }
    public int minPathCost(int[][] arr) {
        int n = arr.length , m = arr[0].length;
        dp = new int[n][m];
        int ans = -1;
        for(int i= 0; i< m; i++){
            ans = Math.max(ans, path(arr,0,i));
        }
        return ans;
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] arr = {{1,2,3},{4,5,6},{7,4,5}};
        System.out.println(s.minPathCost(arr));
        
    }
}