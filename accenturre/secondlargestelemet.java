public class secondlargestelemet {
    public static int secondLargest(int[] arr) {
    int max = Integer.MIN_VALUE;
    int second = Integer.MIN_VALUE;
    for (int n : arr) {
        if (n > max) {
            second = max;
            max = n;
        } else if (n > second && n != max) {
            second = n;
        }
    }
    return second;
}
    public static void main(String[] args) {
        int[] arr = {12, 35, 1, 10, 34, 1};
        int result = secondLargest(arr);
        if (result != Integer.MIN_VALUE) {
            System.out.println("The second largest element is: " + result);
        } else {
            System.out.println("There is no second largest element.");
        }
    }
}
