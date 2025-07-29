package cognizent;

import java.util.*;

public class q_2 {
    public static void main(String[] args) {
        int totalprice;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the no of pizzas bought: ");
        int pizzas = sc.nextInt();
        System.out.println("Enter the no of puffs bought: ");
        int puffs = sc.nextInt();
        System.out.println("Enter the no of cool drinks bought: ");
        int cooldrinks = sc.nextInt();
        pizzas = Math.abs(pizzas)*100;
        puffs = Math.abs(puffs)*20;
        cooldrinks = Math.abs(cooldrinks)*10;
        totalprice = pizzas + puffs + cooldrinks;
        System.out.println("Bill details");
        System.out.println("No of Pizzas: "+pizzas);
        System.out.println("No of puffs: "+puffs);
        System.out.println("No of cool drinks: "+cooldrinks);
        System.out.println("Total price is: "+totalprice);
        System .out.println("Enjoy the food");
    }
}
