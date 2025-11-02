package sorting;

public class insertion {
    void insertionSort(int[] arr) {
    int n = arr.length;
    for (int i = 1; i < n; ++i) {
        int key = arr[i];
        int j = i - 1;

        while (j >= 0 && arr[j] > key) {
            arr[j + 1] = arr[j];
            j--;
        }
        arr[j + 1] = key;
    }
}
public static void main(String[] args) {
    insertion obj = new insertion();
    int[] arr = {12, 11, 13, 5, 6};
    obj.insertionSort(arr);
    System.out.println("Sorted array: ");
    for (int i = 0; i < arr.length; i++) {
        System.out.print(arr[i] + " ");
        }
    }
}