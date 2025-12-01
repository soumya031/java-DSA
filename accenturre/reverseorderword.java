public class reverseorderword {
    public static String reverseWords(String s) {
        String[] parts = s.trim().split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (int i = parts.length - 1; i >= 0; i--) {
            sb.append(parts[i]).append(" ");
        }
        return sb.toString().trim();
    }
    public static void main(String[] args) {
        String input = "Hello World from Java";
        String result = reverseWords(input);
        System.out.println("Original: \"" + input + "\"");
        System.out.println("Reversed: \"" + result + "\"");
    }
}
