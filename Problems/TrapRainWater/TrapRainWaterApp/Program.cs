/*

43 Trapping rain water
Given n non-negative integers representing an elevation map where the width of each bar is 1, 
compute how much water it can trap after raining.

*/
public class Solution
{
    public int Trap(int[] height)
    {
        int leftMax = height[0];
        int rightMax = height[height.Length - 1];
        int waterTrapped = 0;
        int left = 0, right = height.Length - 1; // keep two pointers at both sides
        while (left <= right)
        {
            if (leftMax <= rightMax) // the smaller sides decide curr water trapped val
            {
                leftMax = Math.Max(leftMax, height[left]); // update the leftMax based on the height[curr_idx] with leftMax
                waterTrapped += leftMax - height[left]; // since we just compared both value so at most 0, wont be negative
                left++; // move left pointer
            }
            else
            {
                rightMax = Math.Max(rightMax, height[right]);
                waterTrapped += rightMax - height[right];
                right--;
            }
        }
        return waterTrapped;
    }
}

public class Program
{
    public static void Main(string[] args)
    {
        int[] test = [0,1,0,2,1,0,1,3,2,1,2,1];
        Console.WriteLine(new Solution().Trap(test));
    }
}