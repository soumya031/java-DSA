package cognizent;

import java.util.*;

public class q_4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the no of student placed in CSE: ");
        int CSE = sc.nextInt();
        System.out.println("Enter the no of student placed in ECE: ");
        int ECE = sc.nextInt();
        System.out.println("Enter the no of student placed in MECH: ");
        int MECH = sc.nextInt();
        if(CSE < 0 || ECE < 0 || MECH < 0){
            System.out.println("Invalid input");
        }else {

          if(CSE == ECE || ECE == MECH || MECH == CSE){
                System.out.println("All branches are equal.");
          }else if(CSE == ECE && CSE > MECH){
            System.out.println("Highest placement:");
            System.out.println("CSE");
            System.out.println("ECE");
        }else if(CSE == MECH && CSE > ECE){
            System.out.println("Highest placement:");
            System.out.println("CSE");
            System.out.println("ECE");
        }else if(ECE == MECH && ECE > CSE){
            System.out.println("Highest placement:");
            System.out.println("CSE");
            System.out.println("MECH");
        }else if(CSE > ECE && CSE > MECH){
            System.out.println("Highest placement:");
            System.out.println("CSE");
            }else if(ECE > MECH){
                System.out.println("Highest placement:");
                System.out.println("ECE");
            }else{
                    System.out.println("Highest placement:");
                    System.out.println("MECH");
           }
        }
  }
}
