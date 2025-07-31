package sorting;

import java.util.*;

public class quick {
    void quickSort(int[] arr, int low, int high) {
    if (low < high) {
        int pi = partition(arr, low, high);
        quickSort(arr, low, pi - 1);
        quickSort(arr, pi + 1, high);
    }
}
int partition(int[] arr, int low, int high) {
    int pivot = arr[high], i = low - 1;
    for (int j = low; j < high; j++) {
        if (arr[j] < pivot) {
            i++;
            int temp = arr[i]; arr[i] = arr[j]; arr[j] = temp;
        }
    }
    int temp = arr[i + 1]; arr[i + 1] = arr[high]; arr[high] = temp;
    return i + 1;
}

public static void main(String[] args) {
    quick q = new quick();
    int[] arr = { 5, 2, 9, 1, 7};
        q.quickSort(arr, 0, arr.length - 1);
        System.out.println("Sorted array:"); 
        for (int i = 0; i < arr.length; i++) {
        System.out.println(arr[i] + " ");
        }
}
}