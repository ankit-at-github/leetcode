class Solution {
    public int removeDuplicates(int[] nums) {
        Map<Integer, Integer> hmap = new TreeMap<>();
        for(int x : nums)
        {
            hmap.put(x, hmap.getOrDefault(x, 0)+1);
        }
        int index = 0;
        for(Map.Entry<Integer, Integer> e : hmap.entrySet())
        {
            int n = e.getKey();
            int c = Math.min(e.getValue(), 2);
            while(c>0)
            {
                nums[index++] = n;
                c--;
            }
        }
        
        return index;
    }
}