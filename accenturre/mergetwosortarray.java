import java.util.*;

public class mergetwosortarray {
    public int[] mergeSortedArrays(int[] a, int[] b) {
        int i = 0, j = 0, k = 0;
        int[] out = new int[a.length + b.length];

        while (i < a.length && j < b.length) {
            out[k++] = (a[i] < b[j]) ? a[i++] : b[j++];
    }
        while (i < a.length) out[k++] = a[i++];
        while (j < b.length) out[k++] = b[j++];

        return out;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of first sorted array: ");
        int n1 = sc.nextInt();
        int[] a = new int[n1];
        System.out.println("Enter " + n1 + " elements for first sorted array:");
        for (int i = 0; i < n1; i++) {
            a[i] = sc.nextInt();
        }
        System.out.print("Enter size of second sorted array: ");
        int n2 = sc.nextInt();
        int[] b = new int[n2];
        System.out.println("Enter " + n2 + " elements for second sorted array:");
        for (int i = 0; i < n2; i++) {
            b[i] = sc.nextInt();
        }
        mergetwosortarray ob = new mergetwosortarray();
        int[] mergedArray = ob.mergeSortedArrays(a, b);
        System.out.println("Merged Sorted Array: " + Arrays.toString(mergedArray));
    }
}