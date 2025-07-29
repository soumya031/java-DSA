package array;

import java.util.*;

public class repeatedelement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of elements in the array: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter elements of the array:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        
//        HashSet<Integer> seen = new HashSet<>();
//        HashSet<Integer> duplicates = new HashSet<>();
//        for (int num : arr) {
//            if (!seen.add(num)) {
//                duplicates.add(num);
//            }
//        }
//
//        System.out.println("Repeating elements: " + duplicates);
//    }
//}

//Brute Force (Simple but O(n²)):-

       System.out.println("Repeating elements:");
       for (int i = 0; i < arr.length; i++) {
           for (int j = i + 1; j < arr.length; j++) {
               if (arr[i] == arr[j]) {
                   System.out.println(arr[i]);
                    break; 

               }
            }
        }
    }
}  
 //Using a HashMap (To count frequency):-
 // HashMap<Integer, Integer> freqMap = new HashMap<>();
 //       for (int num : arr) {
  //          freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
 //       }

 //       System.out.println("Repeating elements:");
  //      for (int key : freqMap.keySet()) {
  //          if (freqMap.get(key) > 1) {
  //              System.out.println(key + " occurs " + freqMap.get(key) + " times");