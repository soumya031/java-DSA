package practice;

import java.util.*;

public class largestele {
    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 5, 6, 4};
        largestele sol = new largestele();
        System.out.println("1st largest: " + sol.findKthLargest(nums, 1));
        System.out.println("2nd largest: " + sol.findKthLargest(nums, 2));
        System.out.println("3rd largest: " + sol.findKthLargest(nums, 3));
    }

    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }
}


