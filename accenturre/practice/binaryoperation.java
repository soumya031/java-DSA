import java.util.*;

public class binaryoperation {
    public static int evaluate(String s) {
        int result = s.charAt(0) - '0';
        // Move two steps at a time: operator + next digit
        for (int i = 1; i < s.length(); i += 2) {
            char op = s.charAt(i);
            int next = s.charAt(i + 1) - '0';  // convert '0'/'1' to int
            // Strict left-to-right evaluation only
            if (op == 'A') {
                result = result & next;
            } else if (op == 'B') {
                result = result | next;
            } else if (op == 'C') {
                result = result ^ next;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the binary operation string: ");
        String input = sc.nextLine();
        System.out.println(evaluate(input));  
    }
}
