package accenturre.practice;

import java.util.*;

public class question {
    public static int findIndex(int[] arr, int d, int q, int r, int N) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == (d * q + r * N)) {
                return i; // Return the index if found
            }
        }
        return -1; // Return -1 if not found
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of elements in the array:");
        int n = sc.nextInt();
        System.out.println("Enter the elements of the array:");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int d = sc.nextInt();
        int q = sc.nextInt();
        int r = sc.nextInt();
        int N = sc.nextInt();
        int resultIndex = findIndex(arr, d, q, r, N);
        System.out.println(resultIndex);
    }
}
