import java.util.*;

public class HalloumiBoxes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextInt()) {
            int t = sc.nextInt(); 
            while (t-- > 0) {
                int n = sc.nextInt(); 
                int k = sc.nextInt(); 
                int[] a = new int[n];
                boolean isSorted = true;
                for (int i = 0; i < n; i++) {
                    a[i] = sc.nextInt();
                    if (i > 0 && a[i] < a[i - 1]) {
                        isSorted = false;
                    }
                }
                if (k >= 2 || isSorted) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        }
    }
}