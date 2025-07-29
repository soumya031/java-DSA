package array;

import java.util.*;

//um all even position numbers and Product of all odd numbers in an Array
public class sumprod {
    public static void main(String[] args) {
      @SuppressWarnings("resource")
      Scanner sc= new Scanner(System.in);
        System.out.println("Enter the size of array: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter " + n + " elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println("Array elements are:"+Arrays.toString(arr));
        int sumEven = 0; 
        int productOdd = 1; 
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) { 
                sumEven += arr[i];
            } else { 
                productOdd *= arr[i];
            }
        }
        System.out.println("Sum of numbers at even positions: " + sumEven);
        System.out.println("Product of numbers at odd positions: " + productOdd);
      }
      }

