package array;

import java.util.*;

public class byfrequencyofsortelement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of elements in the array: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter elements of the array:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        // Step 1: Count frequencies
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : arr) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }
        // Step 2: Sort by frequency using a list of map entries
        List<Map.Entry<Integer, Integer>> sortedList = new ArrayList<>(freqMap.entrySet());
        sortedList.sort((a, b) -> b.getValue().compareTo(a.getValue())); 
        // Step 3: Print result
        System.out.println("Elements sorted by frequency:");
        for (Map.Entry<Integer, Integer> entry : sortedList) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}
