class Solution {
    public int trap(int[] height) {
        int water = 0;
        int leftMax = 0, rightMax = 0;
        int left = 0, right = height.length-1;
        while(left < right)
        {
            if(height[left] <= height[right])
            {
                if(leftMax <= height[left]) leftMax = height[left];
                else water+=leftMax-height[left];
                left++;
            }
            else
            {
                if(rightMax <= height[right]) rightMax = height[right];
                else water+=rightMax-height[right];
                right--;
            }
        }
        return water;
    }
}