package hashmap;

import java.util.*;

public class StudentRecordSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<String, Integer> studentMap = new HashMap<>();

        while (true) {
            System.out.println("\n1. Add Student\n2. Get Marks\n3. Remove Student\n4. Display All\n5. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();
            sc.nextLine();  // Clear buffer
            switch (choice) {
                case 1:
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Marks: ");
                    int marks = sc.nextInt();
                    studentMap.put(name, marks);
                    break;

                case 2:
                    System.out.print("Enter Name: ");
                    name = sc.nextLine();
                    if (studentMap.containsKey(name)) {
                        System.out.println("Marks: " + studentMap.get(name));
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;

                case 3:
                    System.out.print("Enter Name to Remove: ");
                    name = sc.nextLine();
                    studentMap.remove(name);
                    System.out.println("Removed if existed.");
                    break;

                case 4:
                    System.out.println("All Students:");
                    for (Map.Entry<String, Integer> entry : studentMap.entrySet()) {
                        System.out.println(entry.getKey() + ": " + entry.getValue());
                    }
                    break;

                case 5:
                    System.out.println("Exit");
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}

