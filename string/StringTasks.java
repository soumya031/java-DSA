package string;

import java.util.*;

public class StringTasks {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.nextLine();
        String original = input;

        // 1. Print the piglatin form of a string
        System.out.print("PigLatin: ");
        String[] words = original.split(" ");
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (word.length() > 1) {
                String piglatin = word.substring(1) + word.charAt(0) + "ay";
                System.out.print(piglatin + " ");
            } else {
                System.out.print(word + "ay ");
            }
        }
        System.out.println();

        // 2. Count total number of consonants
        int consonantCount = 0;
        for (int i = 0; i < original.length(); i++) {
            char ch = Character.toLowerCase(original.charAt(i));
            if (Character.isLetter(ch) && "aeiou".indexOf(ch) == -1) {
                consonantCount++;
            }
        }
        System.out.println("Total consonants: " + consonantCount);

        // 3. Print odd position characters (1-based indexing)
        System.out.print("Odd position characters: ");
        for (int i = 0; i < original.length(); i++) {
            if ((i % 2) != 0) {
                System.out.print(original.charAt(i));
            }
        }
        System.out.println();

        // 4. Print string after removing spaces
        System.out.print("String without spaces: ");
        for (int i = 0; i < original.length(); i++) {
            if (original.charAt(i) != ' ') {
                System.out.print(original.charAt(i));
            }
        }
        System.out.println();
    }
}


