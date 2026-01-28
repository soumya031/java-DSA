package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 
public class Stringmatching {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String textLine = br.readLine();
        String patternLine = br.readLine();
        if (textLine == null || patternLine == null) {
            System.out.println(0);
            return;
        }
        char[] text = textLine.toCharArray();
        char[] pattern = patternLine.toCharArray();

        int n = text.length;
        int m = pattern.length;
        if (m > n) {
            System.out.println(0);
            return;
        }

        int[] pi = computePi(pattern);
        int count = 0;
        int j = 0;
        for (int i = 0; i < n; i++) {
            while (j > 0 && text[i] != pattern[j]) j = pi[j - 1];
            if (text[i] == pattern[j]) j++;
            if (j == m) {
                count++;
                j = pi[j - 1];
            }
        }

        System.out.println(count);
    }

    private static int[] computePi(char[] P) {
        int m = P.length;
        int[] pi = new int[m];
        int j = 0;
        for (int i = 1; i < m; i++) {
            while (j > 0 && P[i] != P[j]) j = pi[j - 1];
            if (P[i] == P[j]) j++;
            pi[i] = j;
        }
        return pi;
    }
}