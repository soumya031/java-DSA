package sorting;

import java.util.*;

public class shell {
    void shellSort(int[] arr) {
    int n = arr.length;
    for (int gap = n / 2; gap > 0; gap /= 2) {
        for (int i = gap; i < n; i++) {
            int temp = arr[i];
            int j = i;
            while (j >= gap && arr[j - gap] > temp) {
                arr[j] = arr[j - gap];
                j -= gap;
            }
            arr[j] = temp;
        }
    }
}
public static void main(String[] args) {
    shell s = new shell();
    int[] arr = {12, 34, 54, 2, 3};
    s.shellSort(arr);
    for (int i = 0; i < arr.length; i++) {
        System.out.print(arr[i] + " ");
        }
}
}
