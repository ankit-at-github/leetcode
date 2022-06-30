class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int exp = nums.length/2;
        int mini = 0;
        for(int i=0; i<nums.length; i++)
        {
            mini+=Math.abs(nums[i] - nums[exp]);
        }
        return mini;
    }
}