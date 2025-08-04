package sorting;

import java.util.*;

public class bucket {
     public static void bucketSort(float[] arr) {
        int n = arr.length;
        if (n <= 0) return;
        // Step 1: Create n empty buckets
        @SuppressWarnings("unchecked")
        List<Float>[] buckets = new List[n];
        for (int i = 0; i < n; i++)
            buckets[i] = new ArrayList<>();
        // Step 2: Put array elements into buckets
        for (float num : arr) {
            int bucketIndex = (int)(num * n);  // assumes [0,1)
            buckets[bucketIndex].add(num);
        }
        // Step 3: Sort individual buckets
        for (List<Float> bucket : buckets)
            Collections.sort(bucket);
        // Step 4: Concatenate all buckets
        int index = 0;
        for (List<Float> bucket : buckets) {
            for (float num : bucket) {
                arr[index++] = num;
            }
        }
    }

    
    public static void main(String[] args) {
        float[] arr = {0.42f, 0.32f, 0.23f, 0.52f, 0.25f, 0.47f, 0.51f};
        bucketSort(arr);
        System.out.println("Sorted: " + Arrays.toString(arr));
    }
}
