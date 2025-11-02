package practice;

import java.util.*;

public class countdigit {
    public static int count(int n){
        n = Math.abs(n);
        if (n == 0) return 1;
        int c = 0;
        while (n > 0) {
            c++;
            n /= 10;
        }
        return c;
    }
    public static void main(string[] args){
        
    }
