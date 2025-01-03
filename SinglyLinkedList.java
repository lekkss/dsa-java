
public class SinglyLinkedList {

    private ListNode head;

    // print a node
    public void print(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ->");
            curr = curr.next;
        }
        System.out.println("null");
    }

    // get the size of a linked list
    public int size() {
        if (head == null) {
            return 0;
        }
        int count = 0;
        ListNode curr = head;
        while (curr != null) {
            count++;
            curr = curr.next;
        }
        return count;
    }

    // insert at head of a linkedlist
    public void insertFirst(int el) {
        ListNode newNode = new ListNode(el);
        newNode.next = head;
        head = newNode;
    }

    // insert at the tail of a linkedlist
    public void insertLast(int el) {
        ListNode newNode = new ListNode(el);
        if (head == null) {
            head = newNode;
            return;
        }
        ListNode curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = newNode;
    }

    // insert node at a given position
    public void insertPosition(int el, int position) {
        if (position > size()) {
            throw new RuntimeException("Invalid index");
        }
        ListNode newNode = new ListNode(el);
        if (position == 1) {
            newNode.next = head;
            head = newNode;
        } else {
            ListNode prev = head;
            for (int i = 1; i < position - 1; i++) {
                prev = prev.next;
            }
            ListNode curr = prev.next;
            newNode.next = curr;
            prev.next = newNode;

        }
    }

    // delete the head of a linkedlist
    public ListNode deleteFirst() {
        if (head == null) {
            return null;
        }
        ListNode temp = head;
        head = head.next;
        temp.next = null;
        return temp;
    }

    // delete the last node in a linkedlist
    public ListNode deleteLast() {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode curr = head;
        // ListNode prev = null;
        while (curr.next.next != null) {
            // curr = prev;
            curr = curr.next;
        }
        curr.next = null;
        return curr;
    }

    // delete node at a given position
    public ListNode deletePosition(int position) {
        ListNode prev = head;
        if (position == 1) {
            head = head.next;
        } else {
            for (int i = 1; i < position - 1; i++) {
                prev = prev.next;
            }
            ListNode curr = prev.next;
            prev.next = curr.next;
        }
        return prev;
    }

    // fint a given element in a linkedlist
    public boolean find(int searchKey) {
        ListNode curr = head;
        while (curr.next != null) {
            if (curr.data == searchKey) {
                return true;
            }
            curr = curr.next;
        }
        return false;
    }

    // reverse a linkedlist
    public ListNode reverse(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode curr = head;
        ListNode prev = null;
        ListNode next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    // fint the middle node i a linkedlist
    public ListNode middleNode() {
        if (head == null) {
            return null;
        }
        ListNode fstPtr = head;
        ListNode slwPtr = head;
        while (fstPtr != null && fstPtr.next != null) {
            slwPtr = slwPtr.next;
            fstPtr = fstPtr.next.next;
        }
        return slwPtr;
    }

    // fint the nth node from the end of a linkedlist
    public ListNode getNthNodeFromEnd(int n) {
        if (head == null) {
            return null;
        }
        ListNode mainPtr = head;
        ListNode refPtr = head;
        int count = 0;
        while (count < n) {
            refPtr = refPtr.next;
            count++;
        }
        while (refPtr != null) {
            refPtr = refPtr.next;
            mainPtr = mainPtr.next;
        }
        return mainPtr;
    }

    // remove duplicate node from a ordered linkedlist
    public void removeDuplicated() {
        ListNode curr = head;
        while (curr != null && curr.next != null) {
            if (curr.data == curr.next.data) {
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }
    }

    // insert element into a sorted linkedlist
    public ListNode insertInSortedList(int el) {
        ListNode newNode = new ListNode(el);
        ListNode curr = head;
        ListNode temp = null;
        if (head == null) {
            return newNode;
        }
        while (curr != null && curr.data < newNode.data) {
            temp = curr;
            curr = curr.next;
        }
        newNode.next = curr;
        temp.next = newNode;
        return head;
    }

    // deletr a given element from a linkedlist
    public void deleteNode(int key) {
        ListNode curr = head;
        ListNode temp = null;
        if (curr != null && curr.data == key) {
            head = curr.next;
            return;
        }
        while (curr != null && curr.data != key) {
            temp = curr;
            curr = curr.next;
        }
        if (curr == null) {
            return;
        }
        temp.next = curr.next;
    }

    public boolean containsLoop() {
        if (head == null) {
            return false;
        }
        ListNode fastPtr = head;
        ListNode slowPtr = head;

        while (fastPtr != null && fastPtr.next != null) {
            fastPtr = fastPtr.next.next;
            slowPtr = slowPtr.next;
            if (slowPtr == fastPtr) {
                return true;
            }
        }
        return false;
    }

    private void createLoopInLinkedList() {
        ListNode first = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(3);
        ListNode fourth = new ListNode(4);
        ListNode fifth = new ListNode(5);
        ListNode sixt = new ListNode(6);

        head = first;
        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        fifth.next = sixt;
        sixt.next = third;
    }

    public ListNode startNodeInALoop() {
        if (head == null) {
            return null;
        }
        ListNode fastPtr = head;
        ListNode slowPtr = head;

        while (fastPtr != null && fastPtr.next != null) {
            fastPtr = fastPtr.next.next;
            slowPtr = slowPtr.next;
            if (slowPtr == fastPtr) {
                return getStartingNode(slowPtr);
            }
        }
        return null;
    }

    public ListNode getStartingNode(ListNode slowPtr) {
        ListNode temp = head;
        while (slowPtr != temp) {
            temp = temp.next;
            slowPtr = slowPtr.next;
        }
        return temp;
    }

    public void removeLoopInList() {
        ListNode fastPtr = head;
        ListNode slowPtr = head;

        while (fastPtr != null && fastPtr.next != null) {
            fastPtr = fastPtr.next.next;
            slowPtr = slowPtr.next;
            if (slowPtr == fastPtr) {
                removeLoop(slowPtr);
            }
        }
    }

    public void removeLoop(ListNode slowPtr) {
        ListNode temp = head;
        while (slowPtr.next != temp.next) {
            temp = temp.next;
            slowPtr = slowPtr.next;
        }
        slowPtr.next = null;
    }

    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();

        // list.insertFirst(16);
        // list.insertFirst(10);
        // list.insertFirst(8);
        // list.insertFirst(1);

        // // // list.deleteFirst();
        // // list.deletePosition(1);

        // list.print(list.head);
        // System.out.println(list.size());
        // System.out.println(list.find(12));

        // ListNode rev = list.reverse(list.head);
        // list.print(rev);

        // ListNode middle = list.middleNode();
        // System.out.println(middle.data);

        // ListNode find = list.getNthNodeFromEnd(1);
        // System.out.println(find.data);

        // list.insertInSortedList(11);
        // list.print(list.head);

        // list.deleteNode(1);

        // list.removeDuplicated();
        list.createLoopInLinkedList();
        // list.print(list.head);
        System.out.println(list.containsLoop());
        System.out.println(list.startNodeInALoop().data);
        list.removeLoopInList();
        System.out.println(list.containsLoop());

    }
}
