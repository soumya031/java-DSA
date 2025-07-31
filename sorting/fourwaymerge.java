package sorting;

import java.util.*;

public class fourwaymerge {
    void mergeSort4Way(int[] arr, int left, int right) {
    if (right - left <= 1) return;

    int quarter = (right - left) / 4;
    int q1 = left + quarter;
    int q2 = left + 2 * quarter;
    int q3 = left + 3 * quarter;

    mergeSort4Way(arr, left, q1);
    mergeSort4Way(arr, q1, q2);
    mergeSort4Way(arr, q2, q3);
    mergeSort4Way(arr, q3, right);

    merge4Ways(arr, left, q1, q2 , q3, right);  // Use min-heap for merging
}

void merge4Ways(int[] arr, int left, int q1, int q2, int q3 , int right) {
    int[] temp = new int[right - left];
    int i = left, j = q1, k = q2, l = q3;
    int index = 0;
    while (i < q1 && j < q2 && k < q3 && l < right) {
      temp[index++] = Math.min(Math.min(arr[i], arr[j]), Math.min(arr[k],arr[l]));
       i++; j++; k++; l++;
    }
    while (i < q1 && j < q2 && k < q3) {
        temp[index++] = Math.min(Math.min(arr[i], arr[j]), arr[k]);
        i++; j++; k++;
    }
    while (i < q1 && j < q2 && l < q3) {
        temp[index++] = Math.min(Math.min(arr[i], arr[j]), arr[l]);
        i++; j++; l++;
    }
    while (i < q1 && k < q2 && l < q3) {
        temp[index++] = Math.min(Math.min(arr[i], arr[k]), arr[l]);
        i++; k++; l++;
    }
    while (j < q2 && k < q3 && l < right) {
        temp[index++] = Math.min(Math.min(arr[j], arr[k]), arr[l]);
        j++; k++; l++;
    }
        System.arraycopy(temp, 0, arr, left, right - left);
        System.out.println(Arrays.toString(arr));
}

    public static void main(String[] args) {
        fourwaymerge obj = new fourwaymerge();
        int[] arr = { 5, 2, 8, 1, 9 , 4, 7, 6, 3 };
        obj.mergeSort4Way(arr, 0, arr.length);
        }


}
