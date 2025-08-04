package searching;

import java.util.*;

public class zeroscount {
    int countZeroes(int[] arr) {
        // code here
        int  n = arr.length;
        for(int i = 0; i < n; i++){
            if(arr[i] == 0){
               return n - i;
            }
        }
        return 0;
    }

/*// 
    int countZeroes(int[] arr) {
        // code here
        int n = arr.length;
        int start = 0;
        int end = n - 1;
        int lastIndexOfOne = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == 1) {
                lastIndexOfOne = mid;
                start = mid + 1;
            } else
                end = mid - 1;
        }
        return n - lastIndexOfOne - 1;
    }
 */
   public static void main(String[] args) {
        zeroscount obj = new zeroscount();
        int[] arr = {1, 2, 3, 4, 5,
                       0, 0, 0, 0, 0,
                       0, 0, 0, 0, 0};
        System.out.println("Count of zeroes is " + obj.countZeroes(arr));

   }
}

