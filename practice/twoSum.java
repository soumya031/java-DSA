package 100 practice;
/*2 sum */

import java.util.*;

public class twoSum {


    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length;i++){
            map.put(nums[i], i);
        }
        for(int i = 0; i < nums.length;i++){
            int complement = target - nums[i];
            if(map.containsKey(complement)){
                return new int[]{i, map.get(complement)};
            }
        }
        return new int[]{-1,-1};
    }
    public static void main(String[] args) {
        twoSum ts = new twoSum();
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] result = ts.twoSum(nums, target);
        System.out.println(result);
    }
}
