package bitmanipulation;

import java.util.Scanner;

public class updateBit {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int oper = sc.nextInt();
        //oper = 1 : set oper = 0 : clear
        System.out.println("Enter the number: ");
        int n = sc.nextInt();
        System.out.println("Enter the position: ");
        int pos = sc.nextInt();
        int bitmask = 1 << pos;
        if(oper == 1){
            //set
            int newnum = bitmask / n;
            System.out.println(newnum);
        }else{
            //clear 
            int newbitmask = ~(bitmask);
            int newnum = newbitmask & n;
            System.out.println(newnum);
        }
    }
}
