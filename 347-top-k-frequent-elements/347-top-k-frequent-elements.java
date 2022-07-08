class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        for(int x : nums) freq.put(x, freq.getOrDefault(x, 0)+1);
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        
        for(Map.Entry<Integer,Integer> entry : freq.entrySet())
        {
            pq.add(new int[]{entry.getKey(), entry.getValue()});
            if(pq.size() > k) pq.poll();
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