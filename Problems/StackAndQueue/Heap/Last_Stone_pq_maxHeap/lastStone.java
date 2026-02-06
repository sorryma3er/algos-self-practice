package StackAndQueue.Heap.Last_Stone_pq_maxHeap;

import java.util.*;

public class lastStone {
    public static void main(String[] args) {
        Solution sol = new Solution();

        // ---------------------- Test Case 1 ----------------------
        // stones = [2,7,4,1,8,1]
        // Expected: 1
        int[] stones1 = {2, 7, 4, 1, 8, 1};
        int ans1 = sol.lastStoneWeight(stones1);
        System.out.println("Test 1:");
        System.out.println("  stones  = " + Arrays.toString(stones1));
        System.out.println("  result  = " + ans1);
        System.out.println("  expect  = 1");
        System.out.println("-----------------------------------");

        // ---------------------- Test Case 2 ----------------------
        // stones = [1]
        // Expected: 1
        int[] stones2 = {1};
        int ans2 = sol.lastStoneWeight(stones2);
        System.out.println("Test 2:");
        System.out.println("  stones  = " + Arrays.toString(stones2));
        System.out.println("  result  = " + ans2);
        System.out.println("  expect  = 1");
        System.out.println("-----------------------------------");

        // ---------------------- Test Case 3 ----------------------
        // stones = [3,3]
        // Expected: 0 (3-3=0, nothing left)
        int[] stones3 = {3, 3};
        int ans3 = sol.lastStoneWeight(stones3);
        System.out.println("Test 3:");
        System.out.println("  stones  = " + Arrays.toString(stones3));
        System.out.println("  result  = " + ans3);
        System.out.println("  expect  = 0");
        System.out.println("-----------------------------------");

        // ---------------------- Test Case 4 ----------------------
        // stones = [10,4,2,10]
        // Process: 10-10=0, 4-2=2 => left 2
        // Expected: 2
        int[] stones4 = {10, 4, 2, 10};
        int ans4 = sol.lastStoneWeight(stones4);
        System.out.println("Test 4:");
        System.out.println("  stones  = " + Arrays.toString(stones4));
        System.out.println("  result  = " + ans4);
        System.out.println("  expect  = 2");
        System.out.println("-----------------------------------");
    }
}

class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxPq = new PriorityQueue<>(Collections.reverseOrder());

        for (int stone : stones) maxPq.offer(stone);

        while (maxPq.size() > 1) {
            int y = maxPq.poll(), x = maxPq.poll();

            if (x < y) {
                int sub = y - x;
                maxPq.offer(sub);
            } 
        }
        return maxPq.isEmpty() ? 0 : maxPq.poll();
    }
}
