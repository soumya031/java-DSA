
import java.util.*;

public class stringdecoder {
	public static void main(String[] args) {
	       String s = "1011";
           StringBuilder o = new StringBuilder();
           int currcount = 0;
           for(int i = 0; i < s.length(); i++){
             if(s.charAt(i) == '1'){
                currcount++;
             }else{
                if(currcount > 0){
                    o.append((char)(64 + currcount));
                    currcount = 0;
                }
             }
           }
           if(currcount > 0){
             o.append((char)(64 + currcount));
           }
           System.out.println(o.toString());
	}
}
