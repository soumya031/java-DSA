package dp;

import java.util.*;

class Sticker_thief {
    public int maxloot(int arr[], int idx, int[] dp) {
        if (idx >= arr.length) return 0;
        if (dp[idx] != -1) return dp[idx];
        int steal = arr[idx] + maxloot(arr, idx + 2, dp);
        int skip = maxloot(arr, idx + 1, dp);
        return dp[idx] = Math.max(steal, skip);
    }

    public int findMaxsum(int arr[]) {
        int[] dp = new int[arr.length];
        Arrays.fill(dp, -1);
        return maxloot(arr, 0, dp);
    }
}

public class sticker_thief {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of houses: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter amount of money in each house:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Sticker_thief thief = new Sticker_thief();
        int maxLoot = thief.findMaxsum(arr);
        System.out.println("Maximum money the thief can loot: " + maxLoot);
    }
}
