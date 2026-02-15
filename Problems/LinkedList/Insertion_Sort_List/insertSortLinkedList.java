package LinkedList.Insertion_Sort_List;

public class insertSortLinkedList {
    public static void main(String[] args) {
        Solution sol = new Solution();

        // ---------------------- Test Case 1 ----------------------
        // head = [4,2,1,3]
        // expect = [1,2,3,4]
        ListNode head1 = buildList(new int[]{4, 2, 1, 3});
        ListNode ans1 = sol.insertionSortList(cloneList(head1));

        System.out.println("Test 1:");
        System.out.print("  input   = "); printList(head1);
        System.out.print("  result  = "); printList(ans1);
        System.out.println("  expect  = [1 -> 2 -> 3 -> 4]");
        System.out.println("-----------------------------------");

        // ---------------------- Test Case 2 ----------------------
        // head = [-1,5,3,4,0]
        // expect = [-1,0,3,4,5]
        ListNode head2 = buildList(new int[]{-1, 5, 3, 4, 0});
        ListNode ans2 = sol.insertionSortList(cloneList(head2));

        System.out.println("Test 2:");
        System.out.print("  input   = "); printList(head2);
        System.out.print("  result  = "); printList(ans2);
        System.out.println("  expect  = [-1 -> 0 -> 3 -> 4 -> 5]");
        System.out.println("-----------------------------------");

        // ---------------------- Test Case 3 ----------------------
        // head = []
        // expect = []
        ListNode head3 = null;
        ListNode ans3 = sol.insertionSortList(cloneList(head3));

        System.out.println("Test 3:");
        System.out.print("  input   = "); printList(head3);
        System.out.print("  result  = "); printList(ans3);
        System.out.println("  expect  = []");
        System.out.println("-----------------------------------");

        // ---------------------- Test Case 4 ----------------------
        // head = [1]
        // expect = [1]
        ListNode head4 = buildList(new int[]{1});
        ListNode ans4 = sol.insertionSortList(cloneList(head4));

        System.out.println("Test 4:");
        System.out.print("  input   = "); printList(head4);
        System.out.print("  result  = "); printList(ans4);
        System.out.println("  expect  = [1]");
        System.out.println("-----------------------------------");

        // ---------------------- Test Case 5 ----------------------
        // head = [3,3,2,1,2]
        // expect = [1,2,2,3,3]
        ListNode head5 = buildList(new int[]{3, 3, 2, 1, 2});
        ListNode ans5 = sol.insertionSortList(cloneList(head5));

        System.out.println("Test 5:");
        System.out.print("  input   = "); printList(head5);
        System.out.print("  result  = "); printList(ans5);
        System.out.println("  expect  = [1 -> 2 -> 2 -> 3 -> 3]");
        System.out.println("-----------------------------------");
    }

    // Build list: arr[0] is head
    private static ListNode buildList(int[] arr) {
        if (arr == null || arr.length == 0) return null;
        ListNode head = new ListNode(arr[0]);
        ListNode curr = head;
        for (int i = 1; i < arr.length; i++) {
            curr.next = new ListNode(arr[i]);
            curr = curr.next;
        }
        return head;
    }

    // Print list: [a -> b -> c]
    private static void printList(ListNode node) {
        if (node == null) {
            System.out.println("[]");
            return;
        }
        System.out.print("[");
        while (node != null) {
            System.out.print(node.val);
            node = node.next;
            if (node != null) System.out.print(" -> ");
        }
        System.out.println("]");
    }

    // Clone list (so tests can show original unchanged)
    private static ListNode cloneList(ListNode head) {
        if (head == null) return null;
        ListNode sentinel = new ListNode(0);
        ListNode tail = sentinel;
        while (head != null) {
            tail.next = new ListNode(head.val);
            tail = tail.next;
            head = head.next;
        }
        return sentinel.next;
    }
}

class ListNode {
    int val;
    ListNode next;

    public ListNode(){}

    public ListNode(int val){
        this.val = val;
    }

    public ListNode(int val, ListNode next){
        this.val = val;
        this.next = next;
    }
}

class Solution {
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode sentinel = new ListNode(-1);

        while (head != null) {
            if (sentinel.next == null) {
                sentinel.next = new ListNode(head.val);
            } else {
                if (head.val <= sentinel.next.val) {
                    ListNode curr = new ListNode(head.val, sentinel.next);
                    sentinel.next = curr;
                } else {
                    ListNode curr = sentinel;
                    while (curr.next != null && head.val > curr.next.val) curr = curr.next;

                    // at this point curr.next.val < head.val, insert it
                    ListNode newNode = new ListNode(head.val, curr.next);
                    curr.next = newNode;
                }
            }

            head = head.next;
        }
        return sentinel.next;
    }
}