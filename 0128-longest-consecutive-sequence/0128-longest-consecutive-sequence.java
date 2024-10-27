class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) return 0;
        Arrays.sort(nums);
        int maxi = 0, count = 1;
        int expectedNum = nums[0];
        for(int i=1; i<nums.length; i++){
            if(nums[i] == nums[i-1]) continue;
            expectedNum++;
            if(nums[i] != expectedNum){
                expectedNum = nums[i];
                maxi = Math.max(maxi, count);
                count = 1;
            }
            else
                count++;
        }
        maxi = Math.max(maxi, count);
        return maxi;
    }
}