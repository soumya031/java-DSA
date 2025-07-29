package array;

import java.util.*;

public class second_min {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of elements: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the elements: "); 
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int min = Integer.MAX_VALUE, secondMin = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (arr[i] < min) {
                secondMin = min; 
                min = arr[i]; 
            } else if (arr[i] < secondMin && arr[i] != min) {
                secondMin = arr[i]; 
            }
        }
        if (n < 2) {
            System.out.println("Array must have at least two elements.");
            return;
        }
        if (secondMin == Integer.MAX_VALUE) {
            System.out.println("No second minimum element found.");
        } else {
            System.out.println("Second Minimum element: " + secondMin);
        }
}
}