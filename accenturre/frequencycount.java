
import java.util.*;

public class frequencycount {
    public int[] frequencyCount(String s) {
        int[] freq = new int[256];
        for (char c : s.toCharArray()) {
            freq[c]++;
        }
        return freq;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.nextLine();
        frequencycount ob = new frequencycount();
        int[] result = ob.frequencyCount(input);
        System.out.println("Character Frequencies:");
        for (int i = 0; i < result.length; i++) {
            if (result[i] > 0) {
                System.out.println((char) i + ": " + result[i]);
            }
        }
    }
}
