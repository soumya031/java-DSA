package array;

import java.util.*;

public class margetwoarroddnum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of elements in the first array: ");
        int n1 = sc.nextInt();
        int[] arr1 = new int[n1];
        System.out.println("Enter elements of the first array:");
        for (int i = 0; i < n1; i++) {
            arr1[i] = sc.nextInt();
        }
        System.out.print("Enter the number of elements in the second array: ");
        int n2 = sc.nextInt();
        int[] arr2 = new int[n2];

        System.out.println("Enter elements of the second array:");
        for (int i = 0; i < n2; i++) {
            arr2[i] = sc.nextInt();
        }
        ArrayList<Integer> oddList = new ArrayList<>();
        for (int num : arr1) {
            if (num % 2 != 0) {
                oddList.add(num);
            }
        }
        for (int num : arr2) {
            if (num % 2 != 0) {
                oddList.add(num);
            }
        }
        int[] oddArray = oddList.stream().mapToInt(Integer::intValue).toArray();
        System.out.println("Merged array with only odd numbers:");
        for (int num : oddArray) {
            System.out.print(num + " ");
        }
    }
}
