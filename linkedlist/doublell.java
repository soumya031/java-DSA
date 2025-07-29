package linkedlist;

class Node {
    int data;
    Node prev, next;

    Node(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

class DoublyLinkedList {
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
        newNode.prev = current;
    }

    public void search(int target) {
        Node current = head;
        int index = 0;

        while (current != null) {
            if (current.data == target) {
                System.out.println("Element " + target + " found at position: " + index);
                return;
            }
            current = current.next;
            index++;
        }
        System.out.println("Element " + target + " not found in the list.");
    }

    public void printList() {
        Node current = head;

        System.out.print("Doubly Linked List: ");
        while (current != null) {
            System.out.print(current.data + " <-> ");
            current = current.next;
        }
        System.out.println("null");
    }
}

public class doublell {
    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();

        dll.add(10);
        dll.add(20);
        dll.add(30);
        dll.add(40);

        dll.printList();           // 10 <-> 20 <-> 30 <-> 40 <-> null
        dll.search(30);            // Found at position: 2
        dll.search(100);           // Not found
    }
}
