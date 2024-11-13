class Solution {
    public int maxArea(int[] height) {
        int left = 0, right = height.length-1;
        int maxi = 0;
        while(left < right){
            int area = Math.min(height[left], height[right]) * (right - left);
            maxi = Math.max(maxi, area);
            if(height[left] < height[right]){
                left++;
            }else if(height[left] > height[right]){
                right--;
            }
            else{
                left++;
                right--;
            }
        }
        return maxi;
    }
}