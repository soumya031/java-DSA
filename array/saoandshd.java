//*sort 1st half in assendring order 2nd half in descending order
package array;

public class saoandshd {
    public static void main(String[] args) {
        int[] arr = {5, 2, 8, 1, 9, 3, 7, 4, 6};
        int mid = arr.length / 2;
        for (int i = 0; i < mid - 1; i++) {
            for (int j = 0; j < mid - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        for (int i = mid; i < arr.length - 1; i++) {
            for (int j = mid; j < arr.length - (i - mid) - 1; j++) {
                if (arr[j] < arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        System.out.println("Array after sorting:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
