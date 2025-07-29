package stackandqueue;

import java.util.*;

class QueueUsingStacks {
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    void enqueue(int item) {
        stack1.push(item);
        System.out.println(item + " enqueued to queue.");
    }

    int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Cannot dequeue.");
            return -1;
        }
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        int item = stack2.pop();
        System.out.println(item + " dequeued from queue.");
        return item;
    }

    boolean isEmpty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }

    void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }
        Stack<Integer> temp1 = new Stack<>();
        Stack<Integer> temp2 = new Stack<>();
        temp1.addAll(stack2);
        while (!stack1.isEmpty()) {
            temp2.push(stack1.pop());
        }

        System.out.print("Queue elements: ");
        for (int val : temp1) {
            System.out.print(val + " ");
        }
        while (!temp2.isEmpty()) {
            int val = temp2.pop();
            System.out.print(val + " ");
            stack1.push(val); 
        }
        System.out.println();
    }
}

public class queueusingstack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        QueueUsingStacks q = new QueueUsingStacks();

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Display Queue");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter element to enqueue: ");
                    int element = sc.nextInt();
                    q.enqueue(element);
                    break;
                case 2:
                    q.dequeue();
                    break;
                case 3:
                    q.display();
                    break;
                case 4:
                    System.out.println("Exit");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}

