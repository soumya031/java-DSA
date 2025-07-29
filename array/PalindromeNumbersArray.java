package array;
//Store only the palindrome numbers in an array

import java.util.*;

public class PalindromeNumbersArray {
    public static boolean isPalindrome(int num) {
        int original = num, reversed = 0;
        while (num > 0) {
            int digit = num % 10;
            reversed = reversed * 10 + digit;
            num /= 10;
        }
        return original == reversed;
    }
    public static void main(String[] args) {
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> palindromeList = new ArrayList<>();
        System.out.print("Enter the number of elements: ");
        int n = sc.nextInt();
        System.out.println("Enter the numbers:");
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            if (isPalindrome(num)) {
                palindromeList.add(num);
            }
        }
        int[] palindromeArray = palindromeList.stream().mapToInt(Integer::intValue).toArray();
        System.out.println("Palindrome numbers stored in the array:");
        for (int num : palindromeArray) {
            System.out.print(num + " ");
        }
    }
}
