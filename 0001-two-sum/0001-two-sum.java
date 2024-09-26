class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hashMap = new HashMap<>();
        int[] ans = new int[2];
        for(int i=0; i<nums.length; i++){
            if(hashMap.containsKey(nums[i])){
                ans[0] = hashMap.get(nums[i]);
                ans[1] = i;
            }
            hashMap.put(target - nums[i], i);
        }
        return ans;
    }
}