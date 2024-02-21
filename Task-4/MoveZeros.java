//Move all zeros in a number to the end using a linked list(Ex: 1034035 ---> 1343500)

import java.util.*;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = next;
    }
}

public class MoveZeros {
    static Node head = null;
    static Node tail = null;
    static int size;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of List :");
        size = sc.nextInt();
        System.out.println("Enter List Elements :");
        for (int i = 0; i < size; i++) {
            InsertLast(sc.nextInt());
        }
        // display();
        moveZeros();
        System.out.println("Result : ");
        display();

    }

    // function to insert node at end
    public static void InsertLast(int data) {
        Node n = new Node(data);
        n.next = null;
        if (head == null) {
            head = n;
            tail = n;
        } else {
            tail.next = n;
            tail = tail.next;

        }
    }

    // function to display the linkedlist
    public static void display() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    // function to move zeros to the end of the list
    public static void moveZeros() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        int c = 0;
        Node temp = head;
        Node prev = head;
        while (c <= size && temp != null) {
            if (temp.data == 0) {
                Node z = temp;
                temp = temp.next; // zero node is removed from the list and added at the end
                prev.next = temp;
                z.next = null;
                tail.next = z;
                tail = z;
            } else {
                prev = temp;
                temp = temp.next;
            }
            c++;
        }

    }

}