
import java.util.*;

public class program {
    public static String replaceZeroswithfives(String input) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (ch == '0') {
                result.append('5');
            } else {
                result.append(ch);
            }
        }
        return result.toString();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter input:");
        String input = sc.nextLine();
        System.out.println("You entered: " + input);
        String output = replaceZeroswithfives(input);
        System.out.println(output);
    }
}

/*
def replaceZeroswithfives(input):
    result = ""
    for ch in input:
        if ch == '0':
            result += '5'
        else:
            result += ch
    return result

    input_str = input("Enter input: ")
    print("You entered:", input_str)
    output_str = replaceZeroswithfives(input_str)
    print(output_str)
 */