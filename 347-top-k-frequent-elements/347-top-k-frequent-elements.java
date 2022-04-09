class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int x : nums)
        {
            if(map.containsKey(x)) map.put(x, map.get(x)+1);
            else map.put(x, 1);
        }
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> b[1]-a[1]);
        for(Map.Entry<Integer, Integer> entry : map.entrySet())
        {
            pq.add(new int[]{entry.getKey(),entry.getValue()});
        }
        
        
        
        int[] ans = new int[k];
        int index = 0;
        while(k!=0)
        {
            ans[index++] = pq.poll()[0];
            k--;
        }
        return ans;
    }
}