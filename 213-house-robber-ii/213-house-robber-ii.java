class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        
        List<Integer> temp1 = new ArrayList<>();
        List<Integer> temp2 = new ArrayList<>();
        
        for(int i=0; i<nums.length; i++)
        {
            if(i!=0) temp1.add(nums[i]);
            if(i!=nums.length-1) temp2.add(nums[i]);
        }
        
        return Math.max(maxProfit(temp1), maxProfit(temp2));
    }
    public int maxProfit(List<Integer> temp)
    {
        int n = temp.size();
        int prev1 = temp.get(0);
        int prev2 = 0;
        for(int i=1; i<n; i++)
        {
            int pick = temp.get(i) + prev2;
            int notpick = prev1;
            
            int current = Math.max(pick, notpick);
            
            prev2 = prev1;
            prev1 = current;
        }
        return prev1;
    }
}