package array;

import java.util.*;

public class sort {
    public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of elements in the array: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter elements of the array:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        } 
        Arrays.sort(arr); 
        System.out.println("Sorted array:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
}
}
//bubble sort
//for (int i = 0; i < arr.length - 1; i++) {
//            for (int j = 0; j < arr.length - 1 - i; j++) {
//                if (arr[j] > arr[j + 1]) {
                    // Swap
 //                   int temp = arr[j];
 //                   arr[j] = arr[j + 1];
 //                   arr[j + 1] = temp;
  //              }
   //         }
    //    }

    //    System.out.println("Sorted array:");
    //    for (int num : arr) {
    //        System.out.print(num + " ");
    //    }