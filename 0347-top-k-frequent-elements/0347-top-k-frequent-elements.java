class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        for(int n : nums){
            freq.put(n, freq.getOrDefault(n, 0) + 1);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> b[1] - a[1]);
        for(Map.Entry<Integer, Integer> m : freq.entrySet()){
            pq.add(new int[]{m.getKey(), m.getValue()});
        }
        int[] ans = new int[k];
        int index = 0;
        while(k-- > 0){
            ans[index++] = pq.poll()[0];
        }
        return ans;
    }
}