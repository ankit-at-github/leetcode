class Solution {
    public int findDuplicate(int[] nums) {
        //Repeated Number will access same index, if number is negative that means it was already accessed earlier.
        
        for(int i=0; i<nums.length; i++){
            
            if(nums[Math.abs(nums[i]) - 1] < 0) return Math.abs(nums[i]);
            
            nums[Math.abs(nums[i]) - 1]*= -1; 
            
        }
        return -1;
    }
}