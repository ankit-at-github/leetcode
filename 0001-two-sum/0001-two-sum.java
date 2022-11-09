class Solution {
    public int[] twoSum(int[] nums, int target) {
        //elements are not sorted so we can not use classic two-pointer approach
        
        //brute force approach would be to use two for loops which gives o(n^2) time complexity.
        
        //optimized approach
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++)
        {
            if(map.containsKey(target-nums[i]))
            {
                return new int[]{i, map.get(target-nums[i])};
            }
            map.put(nums[i], i);
        }
        return new int[]{-1,-1};
    }
}