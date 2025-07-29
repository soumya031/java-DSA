package linkedlist;

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

     public void findsmallandlarg() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        int small = head.data;
        int larg = head.data;
        Node current = head;
        while (current != null) {
            if (current.data < small) {
                small = current.data;
            }
            if (current.data > larg) {
                larg = current.data;
            }
            current = current.next;
        }
        System.out.println("Smallest element: " + small);
        System.out.println("Largest element: " + larg);
    }

    public void printList() {
        Node current = head;
        System.out.print("Linked List: ");
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
}


public class smallestelementlinkedlist {
    public static void main(String[] args) {
        linkedlist list = new linkedlist();
        list.add(5);
        list.add(10);
        list.add(20);
        list.add(30);

        list.printList(); 

        list.findsmallandlarg();
        

    }
} 
