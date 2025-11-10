function trap(height: number[]): number {
  let left = 0, right = height.length - 1;
  let leftMax = 0, rightMax = 0, water = 0;

  while (left <= right) {
    if (leftMax <= rightMax) {
      leftMax = Math.max(leftMax, height[left]);
      water += leftMax - height[left];
      left++;
    } else {
      rightMax = Math.max(rightMax, height[right]);
      water += rightMax - height[right];
      right--;
    }
  }
  return water;
}

const sample = [0,1,0,2,1,0,1,3,2,1,2,1];
console.log(trap(sample));