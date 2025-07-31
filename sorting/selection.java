package sorting;

import java.util.*;

public class selection {
    void selectionSort(int[] arr) {
    int n = arr.length;
    for (int i = 0; i < n - 1; i++) {
        int minIdx = i;
        for (int j = i + 1; j < n; j++) {
            if (arr[j] < arr[minIdx])
                minIdx = j;
        }
        int temp = arr[minIdx]; arr[minIdx] = arr[i]; arr[i] = temp;
    }
}


public static void main(String[] args) {
    selection s = new selection();
    int[] arr = {64, 25, 12, 22, 11};
    s.selectionSort(arr);
}
}

