class Solution {
    public int trap(int[] height) {
        int i = 0, j = height.length-1;
        int leftmax = 0, rightmax = 0, res = 0;
        while(i < j)
        {
            if(height[i] <= height[j])
            {
                if(leftmax < height[i]) leftmax = height[i];
                else res+=leftmax-height[i];
                i++;
            }
            else
            {
                if(rightmax < height[j]) rightmax = height[j];
                else res+=rightmax-height[j];
                j--;
            }
        }
        return res;
    }
}