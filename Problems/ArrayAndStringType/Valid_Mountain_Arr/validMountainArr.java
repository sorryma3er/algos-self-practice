package ArrayAndStringType.Valid_Mountain_Arr;

import java.util.Arrays;

public class validMountainArr {
    public static void main(String[] args) {
        Solution s = new Solution();

        // Valid mountain
        int[] t1 = {0, 3, 2, 1};                 // true
        System.out.println(Arrays.toString(t1) + " -> " + s.validMountainArray(t1));

        // Increasing only (no down slope)
        int[] t2 = {0, 1, 2, 3, 4, 5};           // false
        System.out.println(Arrays.toString(t2) + " -> " + s.validMountainArray(t2));

        // Decreasing only (no up slope)
        int[] t3 = {5, 4, 3, 2, 1};              // false
        System.out.println(Arrays.toString(t3) + " -> " + s.validMountainArray(t3));

        // Plateau at peak (equal adjacent values)
        int[] t4 = {0, 2, 2, 1};                 // false
        System.out.println(Arrays.toString(t4) + " -> " + s.validMountainArray(t4));

        // Valley / up again after descending
        int[] t5 = {0, 3, 2, 4, 1};              // false
        System.out.println(Arrays.toString(t5) + " -> " + s.validMountainArray(t5));

        // Peak at first index (starts descending immediately)
        int[] t6 = {3, 2, 1};                    // false
        System.out.println(Arrays.toString(t6) + " -> " + s.validMountainArray(t6));

        // Peak at last index (never descends)
        int[] t7 = {1, 2, 3};                    // false
        System.out.println(Arrays.toString(t7) + " -> " + s.validMountainArray(t7));

        // Too short
        int[] t8 = {1, 2};                       // false
        System.out.println(Arrays.toString(t8) + " -> " + s.validMountainArray(t8));
    }
}

class Solution {
    /**
     * Given an array of integers arr, return true if and only if it is a valid mountain array.
     * Recall that arr is a mountain array if and only if:
     * arr.length >= 3
     * There exists some i with 0 < i < arr.length - 1 such that:
     *      arr[0] < arr[1] < ... < arr[i - 1] < arr[i] 
     *      arr[i] > arr[i + 1] > ... > arr[arr.length - 1]
     

     * @param arr
     * @return
     */
    public boolean validMountainArray(int[] arr) {
        // want to find out the arr is monotonically increase => decrease
        int len = arr.length;
        if (len < 3) return false;
        boolean isDesc = false;

        for (int i = 1; i < len; i++) {
            int left = arr[i - 1];
            int right = arr[i];

            if (left < right && !isDesc) continue;
            else if (left == right) return false;
            else if (left >= right && !isDesc) {
                isDesc = true;
            }
            else if (left < right && isDesc) return false;
        }
        return arr[0] > arr[1] || arr[len - 2] < arr[len - 1] ? false : true;
    }
}
