"""

43 Trapping rain water
Given n non-negative integers representing an elevation map where the width of each bar is 1, 
compute how much water it can trap after raining.

"""

class Solution:
    def trap(self, height: list[int]) -> int:
        left = 0
        right = len(height) - 1
        left_max = height[0]
        right_max = height[len(height) - 1]
        trapped_water: int = 0
        
        while (left <= right):
            if (left_max <= right_max):
                left_max = max(left_max, height[left])
                trapped_water += left_max - height[left]
                left += 1
            else:
                right_max = max(right_max, height[right])
                trapped_water += right_max - height[right]
                right -= 1
    
        return trapped_water

if __name__ == "__main__":
    height:list[int] = [0,1,0,2,1,0,1,3,2,1,2,1]
    
    print(Solution().trap(height=height))