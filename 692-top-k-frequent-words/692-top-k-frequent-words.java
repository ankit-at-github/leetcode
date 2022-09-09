class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for(String word : words) map.put(word, map.getOrDefault(word, 0)+1);
        
        TreeMap<Integer, PriorityQueue<String>> tmap = new TreeMap<>(Collections.reverseOrder());
        for(Map.Entry<String, Integer> entry : map.entrySet())
        {
            if(!tmap.containsKey(entry.getValue())) tmap.put(entry.getValue(), new PriorityQueue<>());
            tmap.get(entry.getValue()).add(entry.getKey());
        }
        List<String> ans = new ArrayList<>();
        for(PriorityQueue<String> pq : tmap.values())
        {
            while(!pq.isEmpty() && k > 0)
            {
                ans.add(pq.poll());
                k--;
            }
            if(k == 0) break;
        }
        return ans;
    }
}