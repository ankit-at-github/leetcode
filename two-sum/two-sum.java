class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++)
        {
            if(map.containsKey(nums[i]))
            {
                ans[0] = i;
                ans[1] = map.get(nums[i]);
                return ans;
            }
            map.put(target-nums[i], i);
        }
        return ans;
    }
}