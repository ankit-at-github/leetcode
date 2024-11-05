class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        int left = 0, right = 0;
        while(right < nums.length){
            if(right - left > k){
                set.remove(nums[left]);
                left++;
            }
            
            if(!set.isEmpty() && set.contains(nums[right])) return true;
            
            set.add(nums[right]);
            
            right++;
        }
        return false;
    }
}