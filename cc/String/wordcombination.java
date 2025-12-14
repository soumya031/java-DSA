package String;
import java.util.*;

public class wordcombination {
    // Assuming s, dp, and wordSet are defined elsewhere in the class
    public static int wordCombination(int index, String s, int[] dp, Set<String> wordSet){
        if(index == s.length()){
            return dp[index] = 1;
        }
        if(dp[index] != -1){
            return dp[index + 1];
        }
        int count = 0;
        int n = s.length();
        while(index < n){
            s += s.charAt(index);
            if(wordSet.contains(s)){
                count += wordCombination(index + 1, s, dp, wordSet);
                index++;
            }
            index++;
            
        }
        return dp[index] = count;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the string:");
        String s = sc.nextLine();
        Set<String> wordSet = new HashSet<>(Arrays.asList("a", "b","c", "ab", "abc", "bc"));
        int[] dp = new int[s.length() + 1];
        Arrays.fill(dp, -1);
        int result = wordCombination(0, s, dp, wordSet);
        System.out.println("Number of combinations: " + result);
    }
}