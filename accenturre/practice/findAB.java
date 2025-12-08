
/*the logic is based on string here is the input is : ABCBCAB and the output is : AB. 
now you can find the return the count value of AB and return 1 otherwise return 0. */

package accenturre.practice;

import java.util.*;

public class findAB {
    public static int checkAB(String s) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the target substring to search for:");
        String target = sc.nextLine();
        int count = 0;
        for (int i = 0; i <= s.length() - target.length(); i++) {
            if (s.substring(i, i + target.length()).equals(target)) {
                count++;
            }
        }

        return count > 0 ? 1 : 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the input string:");
        String input = sc.nextLine();
        int result = checkAB(input);
        System.out.println(result); 
    }
}

