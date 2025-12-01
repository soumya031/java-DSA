
/*Remove Duplicate Characters from a String (O(n)) */

import java.util.*;

public class removeduplicate {
    public String removeDuplicates(String s) {
    boolean[] seen = new boolean[256];
    StringBuilder out = new StringBuilder();
    for (char c : s.toCharArray()) {
        if (!seen[c]) {
            seen[c] = true;
            out.append(c);
        }
    }
    return out.toString();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.nextLine();
        removeduplicate ob = new removeduplicate();
        String result = ob.removeDuplicates(input);
        System.out.println("String after removing duplicates: " + result);
    }
}
