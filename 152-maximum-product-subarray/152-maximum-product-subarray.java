class Solution {
    public int maxProduct(int[] nums) {
        int prev_maxProduct = nums[0];
        int prev_minProduct = nums[0];
        int current_maxProduct = nums[0];
        int current_minProduct = nums[0];
        int ans = nums[0];
        
        
        for(int i=1; i<nums.length; i++)
        {
            
            current_maxProduct = Math.max(Math.max(prev_maxProduct*nums[i], prev_minProduct*nums[i]), nums[i]);
            current_minProduct = Math.min(Math.min(prev_maxProduct*nums[i], prev_minProduct*nums[i]), nums[i]);
            
            prev_maxProduct = current_maxProduct;
            prev_minProduct = current_minProduct;
            
            ans = Math.max(current_maxProduct, ans);
            
        }
        
        return ans;
    }
}