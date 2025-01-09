package list;

import java.util.NoSuchElementException;

public class CircularLinkedList {
    private ListNode last;
    private int length;

    public static class ListNode {
        private int data;
        private ListNode next;

        public ListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public CircularLinkedList() {
        last = null;
        length = 0;
    }

    public int length() {
        return length;
    }

    public boolean isEmpty() {
        return length == 0;
    }

    public void createCircularLinkedList() {
        ListNode first = new ListNode(1);
        ListNode second = new ListNode(5);
        ListNode third = new ListNode(10);
        ListNode fourth = new ListNode(15);

        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = first;

        last = fourth;
    }

    public void print() {
        if (last == null) {
            return;
        }
        ListNode first = last.next;
        while (first != last) {
            System.out.print(first.data + " --> ");
            first = first.next;
        }
        System.out.println(first.data);
    }

    public void insertFirst(int data) {
        ListNode newNode = new ListNode(data);
        if (isEmpty()) {
            last = newNode;
        } else {
            newNode.next = last.next;
        }
        last.next = newNode;
        length++;
    }

    public void insertLast(int data) {
        ListNode newNode = new ListNode(data);
        if (isEmpty()) {
            last = newNode;
            last.next = last;
        } else {
            newNode.next = last.next;
            last.next = newNode;
            last = newNode;
        }
        length++;
    }

    public ListNode deleteFirst() {
        ListNode temp = last.next;
        if (isEmpty()) {
            throw new NoSuchElementException("Circular Singly Linked List is already empty");
        } else {
            last.next = temp.next;
        }
        temp.next = null;
        return temp;
    }

    // public ListNode deleteLast() {
    // ListNode temp = last;
    // if (isEmpty()) {
    // throw new NoSuchElementException("Circular Singly Linked List is already
    // empty");
    // }
    // return temp;

    // }

    public static void main(String[] args) {
        CircularLinkedList cll = new CircularLinkedList();
        // cll.createCircularLinkedList();
        cll.insertFirst(6);
        cll.insertFirst(3);
        cll.insertLast(9);
        cll.insertLast(11);
        cll.deleteFirst();

        cll.print();
    }
}
