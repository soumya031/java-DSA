/*given the array of integers, find the maximum sum for the 3 element repeatedly . */

package array;

import java.util.*;

public class sunofarray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of elements in the array: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter elements of the array:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int maxsum = Integer.MIN_VALUE;
        for(int i = 0; i <= arr.length - 3;i++){
            int sum = arr[i] + arr[i+1] + arr[i+2];
            if(sum > maxsum){
                maxsum = sum;
            }
        System.out.println("sum of the array is: "+maxsum);
        }
        System.out.println("maximun sum of 3 consecutive element is: "+maxsum);
    }
}

