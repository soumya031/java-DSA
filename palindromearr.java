import java.util.*;

public class palindromearr{    
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter the size of the array: ");
            int n = sc.nextInt();
            int[] arr = new int[n];
            System.out.println("Enter " + n + " elements:");
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            sc.close();
            boolean isPalindrome = true;
            for (int i = 0; i < n / 2; i++) {
               if (arr[i] != arr[n - 1 - i]) {
                   isPalindrome = false;
                   break;
            }
        }
        if (isPalindrome) {
            System.out.println("The array is a Palindrome.");
        } else {
            System.out.println("The array is NOT a Palindrome.");
        }
    
}


}