class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        for(int num : nums){
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> freq.get(a) - freq.get(b));
        for(int num : freq.keySet()){
            pq.add(num);
            if(pq.size() > k) pq.poll();
        }
        int[] ans = new int[pq.size()];
        int index = 0;
        while(!pq.isEmpty()){
            ans[index++] = pq.poll();
        }
        return ans;
    }
}