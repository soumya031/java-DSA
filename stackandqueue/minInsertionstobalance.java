package stackandqueue;

import java.util.*;

public class minInsertionstobalance {
    public static int minInsertions(String s) {
        int insertions = 0; 
        int open = 0; 
        int i = 0;
        while (i < s.length()) {
            if (s.charAt(i) == '(') {
                open++;
                i++;
            } else { 
                if (i + 1 < s.length() && s.charAt(i + 1) == ')') {
                    if (open > 0) {
                        open--;
                    } else {
                        insertions++; 
                    }
                    i += 2;
                } else {
                    if (open > 0) {
                        open--;
                        insertions += 1; 
                    } else {
                        insertions += 2; 
                    }
                    i += 1;
                }
            }
        }
        insertions += 2 * open;
        return insertions;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter parentheses string: ");
        String input = sc.nextLine();
        int result = minInsertions(input);
        System.out.println("Minimum insertions needed to balance: " + result);
    }
}
