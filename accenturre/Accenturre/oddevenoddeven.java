package Accenturre;

import java.util.*;


public class oddevenoddeven {
    public static void main(String[] args) {

/* 
        String concat = " ";
        int[] arr = {4 , 2 , 3 , 1 , 6};
        for(int i = 0; i < arr.length; i++){
            if(arr[i] % 2 == 0){
                concat += "even"; 
            }else{
                concat += "odd";
            }
        }
        System.out.println(concat);
*/
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        StringBuilder sb = new StringBuilder();
        for (int num : arr) sb.append(num % 2 == 0 ? "even" : "odd");
        String result = sb.toString();
        System.out.println("Output: " + result);

    }
}


