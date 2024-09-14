class Solution {
    public int majorityElement(int[] nums) {
        int majorityElement = 0;
        int count = 0;
        for(int i=0; i<nums.length; i++){
            if(count == 0){
                majorityElement = nums[i];
            }
            if(nums[i] == majorityElement) count++;
            else count--;
        }
        return majorityElement;
    }
}