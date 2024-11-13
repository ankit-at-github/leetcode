class Solution {
    public int maxArea(int[] height) {
        int left = 0, right = height.length-1;
        int maxi = 0;
        while(left < right){
            int min = Math.min(height[left], height[right]);
            int area = min * (right - left);
            maxi = Math.max(maxi, area);
            while(left < right && height[left]<=min)
                left++;
            while(left < right && height[right]<=min)
                right--;
        }
        return maxi;
    }
}