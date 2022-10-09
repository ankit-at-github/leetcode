class Solution {
    public int rob(int[] nums) {
        //Botttom - UP
        int n = nums.length;
        int prev1 = nums[0];
        int prev2 = 0;
        
        for(int i=1; i<n; i++)
        {
            int pick = nums[i];
            if(i > 1) pick+=prev2;
            
            int notpick = prev1;
            
            int current = Math.max(pick, notpick);
            
            prev2 = prev1;
            prev1 = current;
        }
        return prev1;
    }
}