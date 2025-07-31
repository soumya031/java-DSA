package sorting;

import java.util.*;

public class radix {
    void radixSort(int[] arr) {
    int max = Arrays.stream(arr).max().getAsInt();
    for (int exp = 1; max / exp > 0; exp *= 10)
        countSort(arr, exp);
}
void countSort(int[] arr, int exp) {
    int n = arr.length;
    int[] output = new int[n];
    int[] count = new int[10];
    for (int i = 0; i < n; i++)
        count[(arr[i] / exp) % 10]++;
    for (int i = 1; i < 10; i++)
        count[i] += count[i - 1];
    for (int i = n - 1; i >= 0; i--) {
        int index = (arr[i] / exp) % 10;
        output[count[index] - 1] = arr[i];
        count[index]--;
    }
    for (int i = 0; i < n; i++)
        arr[i] = output[i];
}

public static void main(String[] args) {
    radix r = new radix();
    int[] arr = {170, 45, 75, 90, 802};
    r.radixSort(arr);
    System.out.println(Arrays.toString(arr));

}
}
