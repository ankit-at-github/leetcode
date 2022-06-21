class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int i=0, j=0;
        int count = 0;
        while(j < nums.length)
        {
            if(nums[j] == 0)
            {
                i = j+1;
            }
            count = Math.max(count, j-i+1);
            j++;
        }
        
        return count;
    }
}