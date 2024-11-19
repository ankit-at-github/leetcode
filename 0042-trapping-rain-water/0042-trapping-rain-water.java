class Solution {
    public int trap(int[] height) {
        int left = 0, right = height.length-1;
        int leftMax = 0, rightMax = 0;
        int total = 0;
        while(left < right){
            if(height[left] <= height[right]){
                leftMax = Math.max(leftMax, height[left]);
                total+= leftMax - height[left];
                left++;
            }else{
                rightMax = Math.max(rightMax, height[right]);
                total+= rightMax - height[right];
                right--;
            }
        }
        return total;
    }
}