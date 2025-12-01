
import java.util.*;

public class passwordChecker {
    public static int chackpassword(String str, int n) {
        if (n < 4){
            return 0; 
        }
        if(str.charAt(0) >= '0' && str.charAt(0) <= '9'){
            return 0; 
        }
        int num = 0 , cap = 0;
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) >= '0' && str.charAt(i) <= '9'){
                num++;
            }
            if(str.charAt(i) >= 'A' && str.charAt(i) <= 'Z'){
                cap++;
            }
        }
        if(cap > 0 && num > 0){
            return 1; 
        } else {
            return 0; 
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter password: ");
        String password = sc.nextLine();
        int n = password.length();
        int result = chackpassword(password, n);
        if(result == 1){
            System.out.println("Valid Password");
        } else {
            System.out.println("Invalid Password");
        }
    }
}
