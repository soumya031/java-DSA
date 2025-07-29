package cognizent;

import java.util.*;
import java.text.*;

class q_1{
      	public static void main (String[] args) {
        DecimalFormat s =new DecimalFormat("0.00");
        Scanner sc= new Scanner (System.in);
	    System.out.println("Enter the no of liters to fill the tank: ");
	    int ltt =sc.nextInt();
	    double lt= (ltt*1.00);
	    if(ltt<1){
	         System.out.println(ltt+" is an Invalid Input");
	    }
	    System.out.println("Enter the distance covered: ");
	    int diss =sc.nextInt();
	    double dis= (diss*1.00);
	    if(diss<1){
	       System.out.println(diss+" is an Invalid Input");
	    }
	    double hundered = ((lt/dis)*100);
	    System.out.println("Liters/100KM");
	    System.out.println(s.format(hundered));
	    double miles = (dis*0.6214);
	    double gallons =(lt*0.2642);
	    double mg = miles/gallons;
	    System.out.println("Miles/gallons");
	    System.out.println(s.format(mg));
	}
}
