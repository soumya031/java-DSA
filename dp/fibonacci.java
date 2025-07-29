package dp;

import java.util.*;

class Innerfibonacci {
      public int fibo(int n, int[] dp){
        if(n <= 1) return n;
        if(dp[n] != 0) return dp[n];
        return dp[n] = fibo(n - 1, dp) + fibo(n - 2, dp);
      }

      public int nthfibonacci(int n){
        int[] dp = new int[n + 1];
        for(int i = 0; i < n; i++) dp[i] = 0;
        return fibo(n, dp);
      }
}


public class fibonacci {
    @SuppressWarnings("resource")
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the position (n) to find the nth Fibonacci number: ");
        int n = sc.nextInt();
        Innerfibonacci fib = new Innerfibonacci();
        System.out.println("The " + n + "th Fibonacci number is: " + fib.nthfibonacci(n));
    }
}
