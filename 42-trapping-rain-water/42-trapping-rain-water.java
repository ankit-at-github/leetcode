class Solution {
    public int trap(int[] height) {
        //Brute Force, water stored at each index;
        int leftMax = height[0], rightMax = 0, sum = 0;
        int[] trappedWater = new int[height.length];
        
        for(int i=1; i<height.length; i++)
        {
            leftMax = Math.max(leftMax, height[i]);
            
            rightMax = Math.max(height[i], getRightMax(height, i));
            
            trappedWater[i] = Math.min(leftMax, rightMax) - height[i];
            
            sum = sum + (trappedWater[i] > 0?trappedWater[i]:0);
        }
        return sum;
    }
    public int getRightMax(int[] height, int index)
    {
        int maxHeight = 0;
        for(int j=index+1; j<height.length; j++) maxHeight = Math.max(maxHeight, height[j]);
        return maxHeight;
    }
}