
public class SinglyLinkedList {

    private ListNode head;

    public void print(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ->");
            curr = curr.next;
        }
        System.out.println("null");
    }

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

    public void insertFirst(int el) {
        ListNode newNode = new ListNode(el);
        newNode.next = head;
        head = newNode;
    }

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

    public ListNode deleteFirst() {
        if (head == null) {
            return null;
        }
        ListNode temp = head;
        head = head.next;
        temp.next = null;
        return temp;
    }

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

    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();

        list.insertFirst(16);
        list.insertFirst(10);
        list.insertFirst(8);
        list.insertFirst(1);

        // // list.deleteFirst();
        // list.deletePosition(1);

        list.print(list.head);
        System.out.println(list.size());
        // System.out.println(list.find(12));

        // ListNode rev = list.reverse(list.head);
        // list.print(rev);

        // ListNode middle = list.middleNode();
        // System.out.println(middle.data);

        // ListNode find = list.getNthNodeFromEnd(1);
        // System.out.println(find.data);

        list.insertInSortedList(11);
        list.print(list.head);

        list.deleteNode(1);

        // list.removeDuplicated();
        list.print(list.head);
    }
}
