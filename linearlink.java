import java.util.*;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class linkedlist {
    Node head;
    public void add(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }

        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }

    public void linearSearch(int target) {
        Node current = head;
        int index = 0;
        while (current != null) {
            if (current.data == target) {
                System.out.println("element " + target + " found at: " + index);
                return;
            }
            current = current.next;
            index++;
        }
        System.out.println("element " + target + " not found.");
    }

    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
}

public class linearlink {
    public static void main(String[] args) {
        linkedlist list = new linkedlist();

        list.add(5);
        list.add(10);
        list.add(20);
        list.add(30);

        list.printList();  

        list.linearSearch(10);  
        list.linearSearch(100);  
    }
}


