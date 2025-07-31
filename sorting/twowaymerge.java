package sorting;

public class twowaymerge{
    void mergeSort2Way(int[] arr, int l, int r) {
    if (l < r) {
        int m = (l + r) / 2;
        mergeSort2Way(arr, l, m);
        mergeSort2Way(arr, m + 1, r);
        merge(arr, l, m, r);
    }
}
void merge(int[] arr, int l, int m, int r) {
    int n1 = m - l + 1;
    int n2 = r - m;
    int[] L = new int[n1];
    int[] R = new int[n2];
    for (int i = 0; i < n1; i++)
    L[i] = arr[l + i];
    for (int j = 0; j < n2; j++)
    R[j] = arr[m + 1 + j];
    int i = 0, j = 0, k = l;
    while (i < n1 && j < n2) {
        if (L[i] <= R[j]) {
            arr[k] = L[i];
            i++;
            } else {
                arr[k] = R[j];
                j++;
            }
                k++;
        }
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
    public static void main(String[] args) {
        twowaymerge obj = new twowaymerge();
        int[] arr = {5, 3, 8, 4, 2};
        obj.mergeSort2Way(arr, 0, arr.length - 1);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}