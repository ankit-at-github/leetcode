class Solution {
    public long countBadPairs(int[] nums) {
        long n = (long)nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        long goodPairs = 0;
        for(int i=0; i<n; i++)
        {
            int diff = nums[i]-i;
            if(map.containsKey(diff)) goodPairs+=map.get(diff);
            map.put(diff, map.getOrDefault(diff, 0)+1);
        }
        return 1L*(n*(n-1)/2)-goodPairs;
    }
}