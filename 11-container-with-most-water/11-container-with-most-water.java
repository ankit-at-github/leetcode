class Solution {
    public int maxArea(int[] height) {
        int start = 0;
        int end = height.length-1;
        int maxArea = 0;
        while(start<=end)
        {
            int l = end-start;
            int h = Math.min(height[start], height[end]);
            maxArea = Math.max(maxArea, l*h);
            if(height[start] > height[end]) end--;
            else start++;
        }
        
        return maxArea;
    }
}