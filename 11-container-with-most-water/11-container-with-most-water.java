class Solution {
    public int maxArea(int[] height) {
        //Optimized
        int maxArea = Integer.MIN_VALUE;
        int i=0, j = height.length-1;
        while(i<j)
        {
            int l = j-i;
            int h = Math.min(height[i], height[j]);
            maxArea = Math.max(maxArea, l*h);
            
            if(height[i] < height[j])
                i++;
            else j--;
        }
        return maxArea;
    }
}