class Solution {
    public int findDuplicate(int[] nums) {
        int duplicate = -1;
        for(int i=0; i<nums.length; i++){
            if(nums[Math.abs(nums[i])] < 0){
                duplicate = Math.abs(nums[i]);
                break;
            }
            nums[Math.abs(nums[i])]*=-1;
        }
        return duplicate;
    }
}