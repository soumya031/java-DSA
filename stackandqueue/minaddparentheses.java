package stackandqueue;

import java.util.*;

public class minaddparentheses {
    public static int minAddToMakeValid(String s) {
        int openCount = 0;
        int additions = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                openCount++;
            } else if (ch == ')') {
                if (openCount > 0) {
                    openCount--;
                } else {
                    additions++; 
                }
            }
        }
        return openCount + additions;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a parentheses string: ");
        String input = sc.nextLine();
        int result = minAddToMakeValid(input);
        System.out.println("Minimum parentheses needed to make valid: " + result);
    }
}

