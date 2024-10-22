class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> remainder = new HashMap<>();
        remainder.put(0, -1);
        int total = 0;
        for(int i=0; i<nums.length; i++){
            total+=nums[i];
            int r = total % k;
            if(!remainder.containsKey(r)){
                remainder.put(r, i);
            }
            else if(i - remainder.get(r) > 1) return true;
        }
        return false;
    }
}