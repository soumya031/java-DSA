package sorting;

import java.util.*;

public class heap {
    void heapSort(int[] arr) {
      int n = arr.length;
      for (int i = n / 2 - 1; i >= 0; i--)
          heapify(arr, n, i);
      for (int i = n - 1; i > 0; i--) {
          int temp = arr[0]; arr[0] = arr[i]; arr[i] = temp;
          heapify(arr, i, 0);
    }
}
void heapify(int[] arr, int n, int i) {
    int largest = i, left = 2 * i + 1, right = 2 * i + 2;
    if (left < n && arr[left] > arr[largest]) largest = left;
    if (right < n && arr[right] > arr[largest]) largest = right;
    if (largest != i) {
        int temp = arr[i]; arr[i] = arr[largest]; arr[largest] = temp;
        heapify(arr, n, largest);
    }
}

public static void main(String[] args) {
    heap h = new heap();
    int[] arr = {12, 11, 13, 5, 6};
    h.heapSort(arr);
    for (int i = 0; i < arr.length; i++)
        System.out.print(arr[i] + " ");
    
}
}
