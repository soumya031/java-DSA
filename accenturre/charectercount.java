
import java.util.*;

public class charectercount {
	public static void main(String[] args) {
        String st = "Hello world";
        char ch = 'l';
        int c = 0;
        for(int i = 0; i < st.length(); i++){
            if(st.charAt(i) == ch){
                c += 1;
            }
        }
        System.out.println(c);
    }
}
