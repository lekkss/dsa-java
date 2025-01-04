
public class SL {
    private ListNode head;

    public void print(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.data + " -> ");
            curr = curr.next;
        }
        System.out.println("null");
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int size() {
        if (isEmpty()) {
            return 0;
        }
        int count = 0;
        ListNode curr = head;
        while (curr != null) {
            count += 1;
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

        if (isEmpty()) {
            head = newNode;
            return;
        }
        ListNode curr = head;
        // 1-->2-->3-->4-->null
        while (curr.next != null) {
            curr = curr.next;
        }

        curr.next = newNode;
    }

    public void insertPosition(int el, int position) {
        // 1-->2--> (3) -->4-->5-->null
        ListNode newNode = new ListNode(el);
        if (position == 1) {
            insertFirst(el);
            return;
        }
        ListNode prev = head;
        for (int i = 1; i < position - 1; i++) {
            prev = prev.next;
        }

        ListNode curr = prev.next;
        newNode.next = curr;
        prev.next = newNode;
    }

    public ListNode deleteFirst() {
        if (isEmpty()) {
            return null;
        }

        ListNode temp = head;
        head = temp.next;
        return temp;

    }

    public ListNode deleteLast() {
        ListNode curr = head;
        if (head == null && head.next == null) {
            return null;
        }
        // 1-->2-->3-->4-->null

        while (curr.next.next != null) {
            curr = curr.next;
        }
        curr.next = null;
        return curr;

    }

    public ListNode deletePosition(int position) {
        if (position == 1) {
            return deleteFirst();

        }
        ListNode prev = head;
        // 1-->2-->3-->4-->null
        for (int i = 1; i < position - 1; i++) {
            prev = prev.next;
        }
        prev.next = prev.next.next;
        return prev;
    }

    public boolean find(int searchKey) {
        // 1-->2-->3-->4-->null
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
        ListNode curr = head;
        ListNode prev = null;
        ListNode next = null;
        // 1-->2-->3-->4-->null
        // 1 --> null
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    public ListNode middleNode() {
        if (isEmpty()) {
            return null;
        }

        ListNode fastPtr = head;
        ListNode slowPtr = head;

        // 1-->2-->3-->4-->null
        while (fastPtr != null && fastPtr.next != null) {
            fastPtr = fastPtr.next.next;
            slowPtr = slowPtr.next;
        }

        return slowPtr;
    }

    public ListNode getNthNodeFromEnd(int n) {
        if (isEmpty()) {
            return null;
        }
        ListNode refNode = head;
        ListNode main = head;

        // 1-->2-->3-->4-->null
        int count = 0;
        while (count < n) {
            refNode = refNode.next;
            count++;
        }
        while (refNode != null) {
            refNode = refNode.next;
            main = main.next;
        }
        return main;
    }

    public void removeDuplicates() {
        ListNode curr = head;

        // 1-->2-->3-->4-->4-->null
        while (curr != null && curr.next != null) {
            if (curr.data == curr.next.data) {
                curr.next = curr.next.next;
            }
            curr = curr.next;
        }
    }

    public ListNode insertInSortedList(int el) {
        ListNode newNode = new ListNode(el);
        if (isEmpty()) {
            head = newNode;
        }
        ListNode curr = head;
        ListNode temp = null;
        // 1-->2-->3-->4--> (5) -->6-->null

        while (curr != null && curr.data < newNode.data) {
            temp = curr;
            curr = curr.next;
        }
        newNode.next = curr;
        temp.next = newNode;
        return head;

    }

    public void deleteNode(int key) {
        // 1-->2-->3-->4-->5-->6-->null
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
        SL ls = new SL();
        ls.head = new ListNode(5);
        ls.head.next = new ListNode(6);
        ls.head.next.next = new ListNode(7);
        ls.head.next.next.next = new ListNode(8);
        ls.head.next.next.next.next = new ListNode(8);

        ls.print(ls.head);
        ls.insertFirst(4);
        ls.print(ls.head);
        ls.insertLast(9);
        ls.print(ls.head);
        ls.insertPosition(1, 1);
        ls.insertPosition(2, 2);
        ls.print(ls.head);
        System.out.println(ls.deleteFirst().data);
        System.out.println(ls.deleteLast().data);
        ls.print(ls.head);
        System.out.println(ls.deletePosition(4).data);
        ls.print(ls.head);

        System.out.println(ls.find(2));
        // ListNode test = ls.reverse(ls.head);
        // ls.print(test);

        System.out.println(ls.middleNode().data);
        System.out.println(ls.getNthNodeFromEnd(1).data);
        ls.removeDuplicates();
        ls.insertInSortedList(6);
        ls.deleteNode(9);
        ls.print(ls.head);

        System.out.println("Size " + ls.size());
    }
}
