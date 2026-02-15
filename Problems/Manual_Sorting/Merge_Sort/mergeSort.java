package Manual_Sorting.Merge_Sort;

import java.util.Arrays;

public class mergeSort {
    public static void main(String[] args) {
        Solution sol = new Solution();

        // ---------------------- Test Case 1 ----------------------
        int[] nums1 = {5, 2, 3, 1};
        int[] sorted1 = sol.sortArray(nums1.clone()); // clone 防止影响原数组展示
        System.out.println("Test 1:");
        System.out.println("  input   = " + Arrays.toString(nums1));
        System.out.println("  result  = " + Arrays.toString(sorted1));
        System.out.println("  expect  = [1, 2, 3, 5]");
        System.out.println("-----------------------------------");

        // ---------------------- Test Case 2 ----------------------
        int[] nums2 = {5, 1, 1, 2, 0, 0};
        int[] sorted2 = sol.sortArray(nums2.clone());
        System.out.println("Test 2:");
        System.out.println("  input   = " + Arrays.toString(nums2));
        System.out.println("  result  = " + Arrays.toString(sorted2));
        System.out.println("  expect  = [0, 0, 1, 1, 2, 5]");
        System.out.println("-----------------------------------");

        // ---------------------- Test Case 3 ----------------------
        int[] nums3 = {1};
        int[] sorted3 = sol.sortArray(nums3.clone());
        System.out.println("Test 3:");
        System.out.println("  input   = " + Arrays.toString(nums3));
        System.out.println("  result  = " + Arrays.toString(sorted3));
        System.out.println("  expect  = [1]");
        System.out.println("-----------------------------------");

        // ---------------------- Test Case 4 ----------------------
        int[] nums4 = {-1, 2, -8, 0, 5, 3};
        int[] sorted4 = sol.sortArray(nums4.clone());
        System.out.println("Test 4:");
        System.out.println("  input   = " + Arrays.toString(nums4));
        System.out.println("  result  = " + Arrays.toString(sorted4));
        System.out.println("  expect  = [-8, -1, 0, 2, 3, 5]");
        System.out.println("-----------------------------------");

        // ---------------------- Test Case 5 ----------------------
        int[] nums5 = {4, 3, 2, 1};
        int[] sorted5 = sol.sortArray(nums5.clone());
        System.out.println("Test 5:");
        System.out.println("  input   = " + Arrays.toString(nums5));
        System.out.println("  result  = " + Arrays.toString(sorted5));
        System.out.println("  expect  = [1, 2, 3, 4]");
        System.out.println("-----------------------------------");
    }
}

class Solution {
    public int[] sortArray(int[] nums) {
        // use merge sort inplace sort it
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }

    private void mergeSort(int[] nums, int l, int r) {
        // divide step - break the arr into small pieces
        if (l >= r) return;
        int mid = l + (r - l) / 2;

        // recursively goes to the single element
        mergeSort(nums, l, mid);
        mergeSort(nums, mid + 1, r);

        merge(nums, l, mid, r);
    }

    private void merge(int[] nums, int l, int mid, int r) {
        // conquer step - form the merged arr
        int[] temp = new int[r - l + 1]; // merged results
        int i = l, j = mid + 1, k = 0; // left half pointer / right half / buf index

        while (i <= mid && j <= r) {
            if (nums[i] <= nums[j]) temp[k++] = nums[i++];
            else temp[k++] = nums[j++];
        }

        while (i <= mid) temp[k++] = nums[i++];
        while (j <= r) temp[k++] = nums[j++];

        // copy back to ori arr
        for (int x = 0; x < temp.length; x++){
            nums[l + x] = temp[x];
        }
    }
}