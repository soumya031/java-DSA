package dp;

import java.util.*;

public class longestincreasingsub {
     public int lengthOfLIS(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for(int n: nums){
            if(res.isEmpty() || res.get(res.size() - 1) < n){
                res.add(n);
            }else{
                int idx = binarysearch(res, n);
                res.set(idx,n);
            }
        }
        return res.size();
    }
    private int binarysearch(List<Integer> arr, int target){
        int left = 0;
        int right = arr.size() - 1;
        while(left <= right){
            int mid = (left + right) / 2;
            if(arr.get(mid) == target){
                return mid;
            }else if(arr.get(mid) > target){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return left;
    }
    public static void main(String[] args) {
        longestincreasingsub lis = new longestincreasingsub();
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println("Length of LIS is " + lis.lengthOfLIS(nums));
    }
}
