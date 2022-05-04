class Solution {
    public int maxOperations(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        int op=0;
        for(int i=0; i<nums.length; i++)
        {
            int find = k-nums[i];
            if(map.getOrDefault(find,0) > 0)
            {
                op++;
                map.put(find, map.get(find)-1);
            }
            else map.put(nums[i], map.getOrDefault(nums[i],0)+1);
        }
        return op;
        
    }
}