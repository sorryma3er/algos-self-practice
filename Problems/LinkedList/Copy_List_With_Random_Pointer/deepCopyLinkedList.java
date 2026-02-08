package LinkedList.Copy_List_With_Random_Pointer;

import java.util.*;

public class deepCopyLinkedList {
    public static void main(String[] args) {
        Solution sol = new Solution();

        // ---------------------- Test 1 ----------------------
        // head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
        Node n0 = new Node(7);
        Node n1 = new Node(13);
        Node n2 = new Node(11);
        Node n3 = new Node(10);
        Node n4 = new Node(1);

        // next links: 7 -> 13 -> 11 -> 10 -> 1
        n0.next = n1; n1.next = n2; n2.next = n3; n3.next = n4;

        // random links:
        // 7.random = null
        // 13.random = 7
        // 11.random = 1
        // 10.random = 11
        // 1.random = 7
        n0.random = null;
        n1.random = n0;
        n2.random = n4;
        n3.random = n2;
        n4.random = n0;

        System.out.println("Test 1 (original):");
        printAsValAndRandomIndex(n0);

        Node copy1 = sol.copyRandomList(n0);

        System.out.println("Test 1 (copied):");
        printAsValAndRandomIndex(copy1);

        System.out.println("Test 1 check (should be true):");
        System.out.println("  Structure equal? " + sameStructure(n0, copy1));
        System.out.println("  Deep copy?       " + noSharedNodes(n0, copy1));
        System.out.println("-----------------------------------");

        // ---------------------- Test 2 ----------------------
        // head = [[1,1],[2,1]]
        Node a0 = new Node(1);
        Node a1 = new Node(2);
        a0.next = a1;

        a0.random = a1;
        a1.random = a1; // points to itself (index 1)

        System.out.println("Test 2 (original):");
        printAsValAndRandomIndex(a0);

        Node copy2 = sol.copyRandomList(a0);

        System.out.println("Test 2 (copied):");
        printAsValAndRandomIndex(copy2);

        System.out.println("Test 2 check (should be true):");
        System.out.println("  Structure equal? " + sameStructure(a0, copy2));
        System.out.println("  Deep copy?       " + noSharedNodes(a0, copy2));
        System.out.println("-----------------------------------");

        // ---------------------- Test 3 ----------------------
        // head = []
        Node copy3 = sol.copyRandomList(null);
        System.out.println("Test 3 (null input): " + (copy3 == null ? "null" : "not null"));
    }

    /**
     * Print list in LeetCode-like format: [[val, random_index], ...]
     * random_index is the index of the node random points to, or null.
     */
    private static void printAsValAndRandomIndex(Node head) {
        if (head == null) {
            System.out.println("[]");
            return;
        }

        // Map each node to its index by walking next pointers
        Map<Node, Integer> idxMap = new HashMap<>();
        List<Node> nodes = new ArrayList<>();

        Node curr = head;
        int idx = 0;
        while (curr != null) {
            idxMap.put(curr, idx++);
            nodes.add(curr);
            curr = curr.next;
        }

        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < nodes.size(); i++) {
            Node node = nodes.get(i);
            sb.append("[")
              .append(node.val)
              .append(", ");

            if (node.random == null) sb.append("null");
            else sb.append(idxMap.get(node.random));

            sb.append("]");
            if (i < nodes.size() - 1) sb.append(", ");
        }
        sb.append("]");

        System.out.println(sb);
    }

    /**
     * Check if two lists have the same val / random structure (by index),
     * assuming both are reachable by next pointers.
     */
    private static boolean sameStructure(Node head1, Node head2) {
        if (head1 == null && head2 == null) return true;
        if (head1 == null || head2 == null) return false;

        Map<Node, Integer> idx1 = indexMap(head1);
        Map<Node, Integer> idx2 = indexMap(head2);

        List<Node> list1 = linearize(head1);
        List<Node> list2 = linearize(head2);

        if (list1.size() != list2.size()) return false;

        for (int i = 0; i < list1.size(); i++) {
            Node a = list1.get(i);
            Node b = list2.get(i);

            if (a.val != b.val) return false;

            Integer aRand = (a.random == null) ? null : idx1.get(a.random);
            Integer bRand = (b.random == null) ? null : idx2.get(b.random);

            if (!Objects.equals(aRand, bRand)) return false;
        }
        return true;
    }

    /**
     * Check there is no shared node object between original and copy.
     */
    private static boolean noSharedNodes(Node head1, Node head2) {
        Set<Node> seen = new HashSet<>(linearize(head1));
        for (Node node : linearize(head2)) {
            if (seen.contains(node)) return false;
        }
        return true;
    }

    private static List<Node> linearize(Node head) {
        List<Node> out = new ArrayList<>();
        Node curr = head;
        while (curr != null) {
            out.add(curr);
            curr = curr.next;
        }
        return out;
    }

    private static Map<Node, Integer> indexMap(Node head) {
        Map<Node, Integer> map = new HashMap<>();
        int i = 0;
        Node curr = head;
        while (curr != null) {
            map.put(curr, i++);
            curr = curr.next;
        }
        return map;
    }
}

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) return null;

        Node curr = head;
        HashMap<Node, Node> oldToNew = new HashMap<>();

        // first traversal just create the mapping bet old node => new node
        while (curr != null) {
            oldToNew.put(curr, new Node(curr.val));
            curr = curr.next;
        }

        // second traversal build the two sides that connect to Node
        curr = head;
        while (curr != null) {
            Node random = curr.random, next = curr.next;
            Node copied = oldToNew.get(curr);

            copied.random = oldToNew.get(random);
            copied.next = oldToNew.get(next);

            curr = curr.next;
        }

        return oldToNew.get(head);
    }
}
