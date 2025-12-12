import java.util.*;

public class reverseword {
    public String reverseWords(String s) {
        String[] words = s.split("\\s+");
        StringBuilder res = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            res.append(words[i]);
            if (i != 0) {
                res.append(" ");
            }
        }
        return res.toString().trim();
    }
    public static void main(String[] args) {
        reverseword rw = new reverseword();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the string to reverse words: ");
        String input = sc.nextLine();
        String output = rw.reverseWords(input);
        System.out.println("Reversed words: '" + output + "'");
    }
}
