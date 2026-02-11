package Prefix_Sum.Ways_Make_Fair_Arr;

import java.util.Arrays;

public class waysMakeFairArr {
    public static void main(String[] args) {
        Solution sol = new Solution();

        // ---------------------- Test Case 1 ----------------------
        // nums = [2,1,6,4]
        // remove index 1 -> [2,6,4] even=2+4=6 odd=6
        // remove index 3 -> [2,1,6] even=2+6=8 odd=1
        // expected = 1 (only index 1 works)
        int[] nums1 = {2, 1, 6, 4};
        int ans1 = sol.waysToMakeFair(nums1);
        System.out.println("Test 1:");
        System.out.println("  nums    = " + Arrays.toString(nums1));
        System.out.println("  result  = " + ans1);
        System.out.println("  expect  = 1");
        System.out.println("-----------------------------------");

        // ---------------------- Test Case 2 ----------------------
        // nums = [1,1,1]
        // remove any index -> remaining two 1s: even sum = 1, odd sum = 1
        // expected = 3
        int[] nums2 = {1, 1, 1};
        int ans2 = sol.waysToMakeFair(nums2);
        System.out.println("Test 2:");
        System.out.println("  nums    = " + Arrays.toString(nums2));
        System.out.println("  result  = " + ans2);
        System.out.println("  expect  = 3");
        System.out.println("-----------------------------------");

        // ---------------------- Test Case 3 ----------------------
        // nums = [1,2,3]
        // remove 0 -> [2,3] even=2 odd=3 no
        // remove 1 -> [1,3] even=1 odd=3 no
        // remove 2 -> [1,2] even=1 odd=2 no
        // expected = 0
        int[] nums3 = {1, 2, 3};
        int ans3 = sol.waysToMakeFair(nums3);
        System.out.println("Test 3:");
        System.out.println("  nums    = " + Arrays.toString(nums3));
        System.out.println("  result  = " + ans3);
        System.out.println("  expect  = 0");
        System.out.println("-----------------------------------");

        // ---------------------- Test Case 4 ----------------------
        // Example you mentioned earlier: [6,1,7,4,1]
        // expected = 0 (this is the known LC example)
        int[] nums4 = {6, 1, 7, 4, 1};
        int ans4 = sol.waysToMakeFair(nums4);
        System.out.println("Test 4:");
        System.out.println("  nums    = " + Arrays.toString(nums4));
        System.out.println("  result  = " + ans4);
        System.out.println("  expect  = 0");
        System.out.println("-----------------------------------");
    }
}

class Solution {
    public int waysToMakeFair(int[] nums) {
        int totalEven = 0, totalOdd = 0;

        for (int i = 0; i < nums.length; i++) {
            int curr = nums[i];

            if (i % 2 == 0) totalEven += curr;
            else totalOdd += curr;
        }

        int leftEven = 0, leftOdd = 0;
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            int curr = nums[i];

            // try to remove curr
            int rightEven = i % 2 == 0 ? totalOdd - leftOdd : totalOdd - leftOdd - curr;
            int rightOdd = i % 2 == 0 ? totalEven - leftEven - curr : totalEven - leftEven;

            if (leftEven + rightEven == leftOdd + rightOdd) count++;

            if (i % 2 == 0) leftEven += curr;
            else leftOdd += curr;
        }
        
        return count;
    }
}
