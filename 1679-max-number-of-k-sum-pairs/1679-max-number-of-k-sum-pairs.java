class Solution {
    public int maxOperations(int[] nums, int k) {
        //maximum number of unique pairs whose sum is equal to k
        Map<Integer,Integer> map = new HashMap<>();
        int count =0 ;
        for(int i=0; i<nums.length; i++)
        {
            if(map.containsKey(k-nums[i]))
            {
                count++;
                if(map.get(k-nums[i]) == 1) map.remove(k-nums[i]);
                else map.put(k-nums[i], map.get(k-nums[i])-1);
            }
            else map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        }
        return count;
    }
}