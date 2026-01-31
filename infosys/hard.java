import java.util.*;

public class hard {
    public static int get_ans(int N, int M, int[] A) {
        // Max possible XOR value for N=1000 is 1023 (next power of 2)
        int maxXor = 1024;
        int maxVal = 0;
        for(int x : A) maxVal = Math.max(maxVal, x);
        
        // dp[value][xor_sum]
        int[][] dp = new int[maxVal + 1][maxXor];
        
        // Initialize with -1 to represent unreachable states
        for (int[] row : dp) Arrays.fill(row, -1);

        for (int i = 0; i < N; i++) {
            int currentVal = A[i];
            
            // Temporary storage for updates from this element specifically
            // to avoid using the same element twice in one subsequence
            int[] currentXors = new int[maxXor];
            Arrays.fill(currentXors, -1);
            
            // 1. Start a new subsequence with just A[i]
            currentXors[currentVal] = Math.max(currentXors[currentVal], 1);
            
            // 2. Extend existing subsequences that end with a value <= currentVal
            for (int v = 1; v <= currentVal; v++) {
                for (int x = 0; x < maxXor; x++) {
                    if (dp[v][x] != -1) {
                        int nextXor = x ^ currentVal;
                        currentXors[nextXor] = Math.max(currentXors[nextXor], dp[v][x] + 1);
                    }
                }
            }
            
            // 3. Update the main DP table with results from current element
            for (int x = 0; x < maxXor; x++) {
                dp[currentVal][x] = Math.max(dp[currentVal][x], currentXors[x]);
            }
        }

        int maxLength = 0;
        for (int v = 0; v <= maxVal; v++) {
            for (int x = M; x < maxXor; x++) { // XOR must be at least M
                maxLength = Math.max(maxLength, dp[v][x]);
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if(!sc.hasNextInt()) return;
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] A = new int[N];
        for (int i = 0; i < N; i++) A[i] = sc.nextInt();
        System.out.println(get_ans(N, M, A));
    }
}


