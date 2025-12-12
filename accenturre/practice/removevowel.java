import java.util.*;

public class removevowel {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the string to remove vowels: ");
        String input = sc.nextLine();
        System.out.println(removeVowels(input));
    }
    static String removeVowels(String s) {
        StringBuilder result = new StringBuilder();
        String vowels = "aeiouAEIOU";
        for (char c : s.toCharArray()) {
            if (vowels.indexOf(c) == -1) {     
                result.append(c);
            }
        }
        return result.toString();
    }
}
 
