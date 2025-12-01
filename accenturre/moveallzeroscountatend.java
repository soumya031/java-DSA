import java.util.*;

public class moveallzeroscountatend {
    public void moveAllZerosToEnd(int[] arr, int n) {
        int idx = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] != 0) {
                arr[idx++] = arr[i];
            }
        }
        while (idx < n) {
            arr[idx++] = 0;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter array size: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter " + n + " elements (space or newline separated):");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        moveallzeroscountatend ob = new moveallzeroscountatend();
        ob.moveAllZerosToEnd(arr, n);
        System.out.println("Array after moving all zeros to the end: " + Arrays.toString(arr));
    }
}
