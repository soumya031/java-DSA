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

    public void insertAt(int index, int data) {
        Node newNode = new Node(data);

        if (index == 0) {
            newNode.next = head;
            head = newNode;
            return;
        }

        Node current = head;
        for (int i = 0; current != null && i < index - 1; i++) {
            current = current.next;
        }

        if (current == null) {
            System.out.println("Index out of bounds.");
            return;
        }

        newNode.next = current.next;
        current.next = newNode;
    }

    public void delete(int value) {
        if (head == null) return;

        if (head.data == value) {
            head = head.next;
            return;
        }

        Node current = head;
        while (current.next != null && current.next.data != value) {
            current = current.next;
        }

        if (current.next == null) {
            System.out.println("Value not found.");
            return;
        }

        current.next = current.next.next;
    }

    public boolean search(int value) {
        Node current = head;
        int index = 0;

        while (current != null) {
            if (current.data == value) {
                System.out.println("Found at index: " + index);
                return true;
            }
            current = current.next;
            index++;
        }

        System.out.println("Not found.");
        return false;
    }

    public void reverse() {
        Node prev = null;
        Node current = head;
        Node nextNode;

        while (current != null) {
            nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }

        head = prev;
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

public class ll {
    public static void main(String[] args) {
           linkedlist list = new linkedlist();

        list.add(10);
        list.add(20);
        list.add(30);
        list.printList();  

        list.insertAt(1, 15);
        list.printList(); 

        list.delete(20);
        list.printList();  

        list.search(15);   
        list.search(99);   

        list.reverse();
        list.printList();  
    }
}

