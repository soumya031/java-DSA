package searching;

import java.util.*;

public class orderAgnosticBs {
    private static int start;

    public static void main(String[] args) {
        int[] arr = {2,3,4,15,16,18};
        int target = 18;
        int ans = orderAgnosticBs(arr, target);
        System.out.println(ans);
    }

    static int orderAgnosticBs(int[] arr, int target){
        int s = 0;
        int end = arr.length - 1;
        
        boolean isAsc;
        if(arr[start] < arr[end]){
            isAsc = true;
        }else{
            isAsc = false;
        }

        while(start <= end){
            int mid = start +(end - start)/2;
            if(arr[mid] == target){
                return mid;
            }
            if(isAsc){
                if(target < arr[mid]){
                    end = mid - 1;
                }else{
                    start = mid + 1;
                }else {
                    end = mid - 1;
                }else{
                    if(target > arr[mid]){
                        end = mid - 1;
                    }else{
                        start = mid + 1;
                    }
                }
            }
        }
        return -1;
        
    }
}
