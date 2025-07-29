package array;

import java.util.*;

public class duplicatearr {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of elements in the array: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter elements of the array:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int dupliCount = 0;
        int count = 1;
        boolean[] visi = new boolean[n]; 
        for (int i = 0; i < n; i++) {
            if (!visi[i]) { 
                for (int j = i + 1; j < n; j++) {
                    if (arr[i] == arr[j]) {
                        count++;
                        visi[j] = true; 
                    }
                }
                if (count > 1) {
                    dupliCount++;
                }
            }
        }
        System.out.println("Total number of duplicate elements: " + dupliCount);
    }
}

