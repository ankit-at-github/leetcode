class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> m = new HashMap<>();
        int result [] = new int[2];
        for(int i=0; i<nums.length; i++)
        {
            if(m.containsKey(nums[i]))
            {
                result[0] = i;
                result[1] = m.get(nums[i]);
                return result;
            }
            m.put(target-nums[i],i);
        }
        return null;
    }
}