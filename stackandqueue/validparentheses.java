package stackandqueue;

import java.util.*;

public class validparentheses {
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else {
                if (stack.isEmpty()) return false;
                char top = stack.pop();
                if ((ch == ')' && top != '(') ||
                    (ch == '}' && top != '{') ||
                    (ch == ']' && top != '[')) {
                    return false;
                }
            }
        }
        return stack.isEmpty(); 
    }
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       System.out.println("Enter the valid parentheeses: ");
       String input = sc.nextLine();
        if (isValid(input)) {
            System.out.println("Valid parentheses");
        } else {
            System.out.println("Invalid parentheses");
        }
    }
}
 

