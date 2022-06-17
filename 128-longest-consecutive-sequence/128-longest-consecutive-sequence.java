class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int x : nums) set.add(x);
        
        int count = 0;
        int maxiCount = 0;
        for(int x : nums)
        {
            if(!set.contains(x-1))
            {
                while(set.contains(x++)) count++;
                maxiCount = Math.max(maxiCount, count);
                count = 0;
            }
        }
        return maxiCount;
    }
}