package StackAndQueue.Heap.Find_K_Smallest_Sum_Pair;

import java.util.*;

public class findKSmallestSumPair {
    public static void main(String[] args) {
        Solution sol = new Solution();

        // ---------------------- Test Case 1 ----------------------
        // nums1 = [1,7,11], nums2 = [2,4,6], k = 3
        // Expected: [[1,2],[1,4],[1,6]]
        int[] nums1_1 = {1, 7, 11};
        int[] nums2_1 = {2, 4, 6};
        int k1 = 3;

        List<List<Integer>> ans1 = sol.kSmallestPairs(nums1_1, nums2_1, k1);
        System.out.println("Test 1:");
        System.out.println("  nums1 = " + Arrays.toString(nums1_1));
        System.out.println("  nums2 = " + Arrays.toString(nums2_1));
        System.out.println("  k     = " + k1);
        System.out.println("  result= " + ans1);
        System.out.println("  expect= [[1, 2], [1, 4], [1, 6]]");
        System.out.println("-----------------------------------");

        // ---------------------- Test Case 2 ----------------------
        // nums1 = [1,1,2], nums2 = [1,2,3], k = 5
        // One typical expected order for k smallest sums:
        // [[1,1],[1,1],[1,2],[1,2],[2,1]]
        // (Note: duplicates are allowed; the exact order among equal sums can vary, but this algorithm is a standard accepted one.)
        int[] nums1_2 = {1, 1, 2};
        int[] nums2_2 = {1, 2, 3};
        int k2 = 5;

        List<List<Integer>> ans2 = sol.kSmallestPairs(nums1_2, nums2_2, k2);
        System.out.println("Test 2:");
        System.out.println("  nums1 = " + Arrays.toString(nums1_2));
        System.out.println("  nums2 = " + Arrays.toString(nums2_2));
        System.out.println("  k     = " + k2);
        System.out.println("  result= " + ans2);
        System.out.println("  expect~ (one valid)= [[1, 1], [1, 1], [1, 2], [1, 2], [2, 1]]");
        System.out.println("-----------------------------------");

        // ---------------------- Test Case 3 ----------------------
        // nums1 = [1,2], nums2 = [3], k = 3
        // Total pairs = 2, so it should return only 2 pairs: [[1,3],[2,3]]
        int[] nums1_3 = {1, 2};
        int[] nums2_3 = {3};
        int k3 = 3;

        List<List<Integer>> ans3 = sol.kSmallestPairs(nums1_3, nums2_3, k3);
        System.out.println("Test 3:");
        System.out.println("  nums1 = " + Arrays.toString(nums1_3));
        System.out.println("  nums2 = " + Arrays.toString(nums2_3));
        System.out.println("  k     = " + k3);
        System.out.println("  result= " + ans3);
        System.out.println("  expect= [[1, 3], [2, 3]]");
        System.out.println("-----------------------------------");

        // ---------------------- Test Case 4 ----------------------
        // nums1 = [1], nums2 = [1,2,3], k = 2
        // Expected: [[1,1],[1,2]]
        int[] nums1_4 = {1};
        int[] nums2_4 = {1, 2, 3};
        int k4 = 2;

        List<List<Integer>> ans4 = sol.kSmallestPairs(nums1_4, nums2_4, k4);
        System.out.println("Test 4:");
        System.out.println("  nums1 = " + Arrays.toString(nums1_4));
        System.out.println("  nums2 = " + Arrays.toString(nums2_4));
        System.out.println("  k     = " + k4);
        System.out.println("  result= " + ans4);
        System.out.println("  expect= [[1, 1], [1, 2]]");
        System.out.println("-----------------------------------");
    }
}

class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> res = new ArrayList<>();

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            // the int[] store idx not val
            (a, b) -> Integer.compare(nums1[a[0]] + nums2[a[1]], nums1[b[0]] + nums2[b[1]])
        );

        for (int i = 0; i < nums1.length; i++) {
            // enqueue the idx of row-wise, think of all mutations with nums[i] with nums[0]
            pq.offer(new int[]{ i, 0 });
        }

        while (k > 0 && !pq.isEmpty()) {
            int[] smallestIdx = pq.poll();
            int left = smallestIdx[0], right = smallestIdx[1];
            res.add(List.of(nums1[left], nums2[right]));
            k--;

            if (right + 1 < nums2.length) pq.offer(new int[] { left, right + 1 });
        }

        return res;
    }
}
