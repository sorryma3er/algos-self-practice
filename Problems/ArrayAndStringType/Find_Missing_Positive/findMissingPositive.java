package ArrayAndStringType.Find_Missing_Positive;

import java.util.Arrays;

public class findMissingPositive {
    public static void main(String[] args) {
        Solution sol = new Solution();

        // ---------------------- Test Case 1 ----------------------
        // nums = [1,2,0] -> missing = 3
        int[] nums1 = {1, 2, 0};
        runTest(sol, nums1, 3, "Test 1");

        // ---------------------- Test Case 2 ----------------------
        // nums = [3,4,-1,1] -> missing = 2
        int[] nums2 = {3, 4, -1, 1};
        runTest(sol, nums2, 2, "Test 2");

        // ---------------------- Test Case 3 ----------------------
        // nums = [7,8,9,11,12] -> missing = 1
        int[] nums3 = {7, 8, 9, 11, 12};
        runTest(sol, nums3, 1, "Test 3");

        // ---------------------- Test Case 4 ----------------------
        // nums = [1,1] (duplicate) -> missing = 2
        int[] nums4 = {1, 1};
        runTest(sol, nums4, 2, "Test 4");

        // ---------------------- Test Case 5 ----------------------
        // nums = [2] -> missing = 1
        int[] nums5 = {2};
        runTest(sol, nums5, 1, "Test 5");

        // ---------------------- Test Case 6 ----------------------
        // nums = [1,2,3,4,5] -> missing = 6
        int[] nums6 = {1, 2, 3, 4, 5};
        runTest(sol, nums6, 6, "Test 6");
    }

    private static void runTest(Solution sol, int[] nums, int expect, String title) {
        int[] original = nums.clone(); // copy for printing before/after
        int ans = sol.firstMissingPositive(nums);

        System.out.println(title + ":");
        System.out.println("  input   = " + Arrays.toString(original));
        System.out.println("  after   = " + Arrays.toString(nums) + "   (in-place rearranged)");
        System.out.println("  result  = " + ans);
        System.out.println("  expect  = " + expect);
        System.out.println("-----------------------------------");
    }
}

class Solution {
    public int firstMissingPositive(int[] nums) {
        // use the arr itself as a hashMap [idx, val]
        int len = nums.length;
        for (int i = 0; i < len; i++) {

            while (nums[i] != i + 1) {
                int curr = nums[i];

                // filter out not just for pos range, also the duplicate prevent infinite loop
                if (curr <= 0 || curr > len || curr == nums[curr - 1]) break;

                // val 1 should be at the idx 0, becuz val 0 not positive
                nums[i] = nums[curr - 1];
                nums[curr - 1] = curr;
            }
        }

        for (int i = 0; i < len; i++) {
            if (nums[i] != i + 1) return i + 1;
        }

        return len + 1;
    }
}
