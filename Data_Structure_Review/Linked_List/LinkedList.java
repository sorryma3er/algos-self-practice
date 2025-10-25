package Linked_List;

public class LinkedList {

    // in java OOP style, we need an entry point to be able to use this data structure
    private ListNode head;

    public LinkedList() {
        // initialize the nodes
        ListNode n0 = new ListNode(1);
        ListNode n1 = new ListNode(3);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(5);
        ListNode n4 = new ListNode(4);

        // connect these ListNodes
        n0.next = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;

        this.head = n0;
    }

    public void insertAfterKnownNode(ListNode n0, ListNode P){
        ListNode n1 = n0.next;
        n0.next = P;
        P.next = n1;
    }

    public void deleteAfterKnownNode(ListNode n0){
        if (n0.next == null){
            return;
        }

        // n0 -> n1 -> n2
        ListNode n1 = n0.next;
        ListNode n2 = n1.next;
        n0.next = n2;
    }

    public ListNode accessByIdx(ListNode head, int idx){
        for(int i = 0; i < idx; i++){
            if (head == null) return null;
            head = head.next;
        }
        return head;
    }

    public int findByVal(ListNode head, int val){
        int count = 0;
        while (head != null){
            if (head.val == val) return count;

            head = head.next;
            count++;
        }
        return -1;
    }

    public void printLinkedList(){
        System.out.print("[");

        ListNode curr = this.head;
        while(curr != null){
            System.out.print(curr.val);
            if (curr.next != null) System.out.print(" -> ");
            curr = curr.next;
        }

        System.out.print("]");
        System.out.println();
    }

    public ListNode head(){
        return head;
    }

    public static void main(String[] args){
        LinkedList list = new LinkedList();

        list.printLinkedList();

        ListNode newNode = new ListNode(713);
        list.insertAfterKnownNode(list.head(), newNode);

        list.printLinkedList();

        list.deleteAfterKnownNode(list.head());

        list.printLinkedList();

        ListNode third = list.accessByIdx(list.head(), 2);
        System.out.println("The third node has val: " + third.val);

        int idx = list.findByVal(list.head(), 5);
        System.out.println("The val that is 5 is at index: " + idx);
    }
}

class ListNode {
    int val;
    ListNode next;

    // constructor:
    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

class DoublyListNode {
    int val;
    DoublyListNode next;
    DoublyListNode prev;

    DoublyListNode(int val){
        this.val = val;
        this.next = null;
        this.prev = null;
    }
}


