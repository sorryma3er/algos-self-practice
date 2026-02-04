package ArrayAndStringType.Plus_One;

import java.util.Arrays;

public class plusOne {
    public static void main(String[] args) {
        Solution s = new Solution();

        // Case 1: no carry
        int[] a1 = {1, 2, 3};
        System.out.println(Arrays.toString(a1) + " -> " + Arrays.toString(s.plusOne(a1))); // [1, 2, 4]

        // Case 2: carry in the middle
        int[] a2 = {1, 2, 9};
        System.out.println(Arrays.toString(a2) + " -> " + Arrays.toString(s.plusOne(a2))); // [1, 3, 0]

        // Case 3: trailing 9s
        int[] a3 = {4, 9, 9};
        System.out.println(Arrays.toString(a3) + " -> " + Arrays.toString(s.plusOne(a3))); // [5, 0, 0]

        // Case 4: all 9s (length increases)
        int[] a4 = {9, 9, 9};
        System.out.println(Arrays.toString(a4) + " -> " + Arrays.toString(s.plusOne(a4))); // [1, 0, 0, 0]

        // Case 5: single digit
        int[] a5 = {0}; // if allowed by your test, otherwise use {5}
        System.out.println(Arrays.toString(a5) + " -> " + Arrays.toString(s.plusOne(a5))); // [1]
    }  
}

class Solution {
    /**
     * You are given a large integer represented as an integer array digits, where each digits[i] is the ith digit of the integer. 
     * The digits are ordered from most significant to least significant in left-to-right order. 
     * The large integer does not contain any leading 0's.
     * Increment the large integer by one and return the resulting array of digits.

     * @param digits
     * @return
     */
    public int[] plusOne(int[] digits) {
        int len = digits.length;

        for (int i = len - 1; i >= 0; i--){
            int curr = digits[i];

            if (curr + 1 <= 9) {
                digits[i] = curr + 1;
                return digits; // short return, so we dont add to every digit + 1
            } else {
                digits[i] = 0;
            }
        }

        int[] res = new int[len + 1];
        res[0] = 1;
        return res;
    }
}
