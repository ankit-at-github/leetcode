class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int j=0;
        int currentSum = 0;
        int maxiSum = 0;
        for(int i=0; i<nums.length; i++)
        {
            currentSum+=nums[i];
            while(set.contains(nums[i]))
            {
                currentSum-=nums[j];
                set.remove(nums[j]);
                j++;
            }
            set.add(nums[i]);
            maxiSum = Math.max(maxiSum, currentSum);
        }
        return maxiSum;
    }
}