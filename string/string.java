package string;

import java.util.*;

class string_program{
    public static void main(String [] args) {
    {
        Scanner sc =new Scanner(System.in);
        String ch;
        int l=0;
        System.out.print("Enter a string:");
        ch=sc.nextLine();
        System.out.println("The input string is:"+ch);
        //System.out.println("Length is:"+ch.length());
        for(char c:ch.toCharArray())
        l++;
        System.out.println("The length is:"+l);
        System.out.println("The characters are:");
        for(int i=0;i<l;i++)
        {
            System.out.println(ch.charAt(i));
        }
    }
}
}