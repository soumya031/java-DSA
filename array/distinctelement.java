package array;

import java.util.*;

public class distinctelement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of elements in the array: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter elements of the array:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println("Distinct elements:");
        Arrays.stream(arr).distinct().forEach(e -> System.out.print(e + " "));
    }
}

//using hashset
//        HashSet<Integer> distinct = new HashSet<>();
//        for (int num : arr) {
//            distinct.add(num);
//        }
//        System.out.println("Distinct elements:");
//        for (int num : distinct) {
//            System.out.print(num + " ");
//        }