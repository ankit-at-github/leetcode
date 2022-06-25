class Solution {
    public int trap(int[] height) {
        int[] prefixMax = new int[height.length];
        prefixMax[0] = height[0];
        for(int i=1; i<height.length; i++) prefixMax[i] = Math.max(prefixMax[i-1], height[i]);
        
        int[] suffixMax = new int[height.length];
        suffixMax[height.length-1] = height[height.length-1];
        for(int i=height.length-2; i>=0; i--) suffixMax[i] = Math.max(suffixMax[i+1], height[i]);
        
        int sum = 0;
        for(int i=0; i<height.length; i++)
        {
            int value = Math.min(prefixMax[i], suffixMax[i]) - height[i];
            sum = sum + (value>0?value:0);
        }
        return sum;
        
    }
}