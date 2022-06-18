class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        int sum = 0;
        for(int x : nums)
        {
            sum+=x;
            if(sum == k) count++;
            
            if(map.containsKey(sum-k))count+=map.get(sum-k);
            
            map.put(sum, map.getOrDefault(sum, 0)+1);
        }
        return count;
    }
}