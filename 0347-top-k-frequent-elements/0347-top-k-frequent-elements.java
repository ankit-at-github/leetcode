class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        for(int x : nums) freq.put(x, freq.getOrDefault(x, 0)+1);
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> b[1]-a[1]);
        
        for(Map.Entry<Integer, Integer> entry : freq.entrySet())
        {
            pq.add(new int[]{entry.getKey(), entry.getValue()});
        }
        
        int[] ans = new int[k];
        int index = 0;
        while(k > 0)
        {
            ans[index++] = pq.poll()[0];
            k--;
        }
        return ans;
    }
}