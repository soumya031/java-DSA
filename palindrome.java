import java.util.*;

public class palindrome {

/*   public static boolean ispalindrome(String str){                                 */
/*         return str.equals(new StringBuilder(str).reverse().toString());          */
/*    }                                                                            */
    public static void main(String[] args) {
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number");
        int num = sc.nextInt();
        int reversedNum = 0, remainder;
        int originalNum = num;
        while (num != 0) {
          remainder = num % 10;
          reversedNum = reversedNum * 10 + remainder;
          num /= 10;
        }
        if (originalNum == reversedNum) {
          System.out.println(originalNum + " is Palindrome.");
        }
        else {
          System.out.println(originalNum + " is not Palindrome.");
        }
    }
}
