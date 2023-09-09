class Solution {
    public int combinationSum4(int[] nums, int target) {
        Map<Integer, Integer> memo = new HashMap<>();
        return solve(nums, target, memo);
    }
    public int solve(int[] nums, int target, Map<Integer, Integer> memo)
    {
        if(memo.containsKey(target)) return memo.get(target);
        int count = 0;
        if(target < 0) return 0;
        if(target == 0) return 1;
        for(int i=0; i<nums.length; i++)
        {
            count += solve(nums, target-nums[i], memo);
        }
        memo.put(target, count);
        return count;
    }
}