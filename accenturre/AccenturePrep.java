import java.util.*;


public class AccenturePrep {

    // 1. Remove duplicate characters from a string
 
    public static String removeDuplicates(String s) {
        StringBuilder result = new StringBuilder();
        boolean[] seen = new boolean[256];

        for (char c : s.toCharArray()) {
            if (!seen[c]) {
                seen[c] = true;
                result.append(c);
            }
        }
        return result.toString();
    }

    // 2. Print frequency of each character

    public static void printFrequency(String s) {
        int[] freq = new int[256];
        for (char c : s.toCharArray()) freq[c]++;
        for (int i = 0; i < 256; i++) {
            if (freq[i] > 0) {
                System.out.println((char) i + " = " + freq[i]);
            }
        }
    }


    // 3. Shift zeroes to the end

    public static int[] shiftZeroes(int[] arr) {
        int index = 0;
        for (int i : arr) {
            if (i != 0) arr[index++] = i;
        }
        while (index < arr.length) arr[index++] = 0;
        return arr;
    }


    // 4. Rotate array by K positions (right rotation)

    public static void rotateArray(int[] arr, int k) {
        int n = arr.length;
        k = k % n;

        reverse(arr, 0, n - 1);
        reverse(arr, 0, k - 1);
        reverse(arr, k, n - 1);
    }

    public static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int t = arr[start];
            arr[start] = arr[end];
            arr[end] = t;
            start++;
            end--;
        }
    }


    // 5. Check if two strings are anagrams

    public static boolean isAnagram(String a, String b) {
        if (a.length() != b.length()) return false;

        int[] freq = new int[256];
        for (char c : a.toCharArray()) freq[c]++;
        for (char c : b.toCharArray()) freq[c]--;

        for (int x : freq) if (x != 0) return false;

        return true;
    }


    // 6. Count vowels and consonants

    public static void countVowelsConsonants(String s) {
        int vowels = 0, consonants = 0;
        s = s.toLowerCase();

        for (char c : s.toCharArray()) {
            if (Character.isLetter(c)) {
                if ("aeiou".indexOf(c) != -1) vowels++;
                else consonants++;
            }
        }

        System.out.println("Vowels = " + vowels);
        System.out.println("Consonants = " + consonants);
    }


    // 7. Sum of digits of a number

    public static int sumOfDigits(int n) {
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }


    // 8. Reverse words in a sentence

    public static String reverseWords(String s) {
        String[] parts = s.split(" ");
        StringBuilder result = new StringBuilder();

        for (int i = parts.length - 1; i >= 0; i--) {
            result.append(parts[i]).append(" ");
        }
        return result.toString().trim();
    }


    // 9. Find second largest number in array

    public static int secondLargest(int[] arr) {
        int max = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;

        for (int n : arr) {
            if (n > max) {
                second = max;
                max = n;
            } else if (n > second && n != max) {
                second = n;
            }
        }

        return second;
    }


    // 10. Merge two sorted arrays

    public static int[] mergeArrays(int[] a, int[] b) {
        int i = 0, j = 0, k = 0;
        int[] result = new int[a.length + b.length];

        while (i < a.length && j < b.length) {
            if (a[i] < b[j]) result[k++] = a[i++];
            else result[k++] = b[j++];
        }
        while (i < a.length) result[k++] = a[i++];
        while (j < b.length) result[k++] = b[j++];

        return result;
    }


    public static void main(String[] args) {

        // 1
        System.out.println(removeDuplicates("programming"));

        // 2
        printFrequency("hello");

        // 3
        System.out.println(Arrays.toString(shiftZeroes(new int[]{0, 1, 0, 3, 12})));

        // 4
        int[] r = {1, 2, 3, 4, 5};
        rotateArray(r, 2);
        System.out.println(Arrays.toString(r));

        // 5
        System.out.println(isAnagram("listen", "silent"));

        // 6
        countVowelsConsonants("engineering");

        // 7
        System.out.println(sumOfDigits(789));

        // 8
        System.out.println(reverseWords("I love programming"));

        // 9
        System.out.println(secondLargest(new int[]{10, 5, 20, 8, 12}));

        // 10
        System.out.println(Arrays.toString(mergeArrays(
            new int[]{1, 3, 5}, new int[]{2, 4, 6}
        )));
    }
}