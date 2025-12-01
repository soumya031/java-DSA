/*Reverse Entire String / Reverse Words (O(n)) */

import java.util.*;

public class reversestring {
    public String reverseString(String s) {
        return new StringBuilder(s).reverse().toString();
    }

    public static void main(String[] args) {
        reversestring ob = new reversestring();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.nextLine();
        String result = ob.reverseString(input);
        System.out.println("Original String: " + input);
        System.out.println("Reversed String: " + result);
    }
}
