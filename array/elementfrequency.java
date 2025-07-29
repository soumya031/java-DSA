package array;

import java.util.HashMap;
import java.util.Scanner;

public class elementfrequency {
    public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of elements in the array: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter elements of the array:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        for (int num : arr) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }
        System.out.println("Repeating elements:");
           for (int key : freqMap.keySet()) {
               if (freqMap.get(key) > 1) {
                    System.out.println(key + " occurs " + freqMap.get(key) + " times");
                }
           }
    }
}