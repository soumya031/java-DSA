package array;

import java.util.*;

public class minmaxarr {    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of elements: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int min = arr[0], max = arr[0];
        for (int i = 1; i < n; i++) {
            if (arr[i] < min) {
                min = arr[i]; 
            }
            if (arr[i] > max) {
                max = arr[i]; 
            }
        }
        System.out.println("Minimum element: " + min);
        System.out.println("Maximum element: " + max);

    }
}

