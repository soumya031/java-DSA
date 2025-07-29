package searching;

import java.util.*;

public class binary {
   
    public static void main(String[] args) {
         int[] arr = {2,3,4,15,16,18};
         int target = 18;
         int ans = binarysearch(arr, target);
         System.out.println(ans);
        
    }

    static int binarysearch(int[] arr, int target ){
        int start = 0;
        int end = arr.length - 1;
        int mid = (start + end) / 2;
        while(start <= end){
            mid = start + (end - start)/2;
            if(target < arr[mid]){
                end = mid -1;
            }else if(target > arr[mid]) {
                start = mid + 1;
            }else{
                return mid;
            }
        }
        return mid;
    }
}

