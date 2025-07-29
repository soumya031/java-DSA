//reverse word in a given string //
package string;

import java.util.*;

public class palindrome {

/*   public static boolean ispalindrome(String str){                               */
/*         return str.equals(new StringBuilder(str).reverse().toString());        */
/*    }                                                                          */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string: ");
        String str = sc.nextLine();
        int n = str.length();
        int c = 0;
        for(int i = 0; i < n ; i++){
            if (str.charAt(i) != str.charAt(n - i -1)) {
                c++;
                break;
            }
    }
        if (c == 0) {
            System.out.println(str+" is a palindrome.");
        } else {
            System.out.println(str+ " is not a palindrome.");
            }

 }
}  
