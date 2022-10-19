class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> freq = new HashMap<>();
        for(String w : words) freq.put(w, freq.getOrDefault(w, 0)+1);
        
        TreeMap<Integer, PriorityQueue<String>> tmap = new TreeMap<>(Collections.reverseOrder());
        
        for(Map.Entry<String, Integer> entry : freq.entrySet())
        {
            int f = entry.getValue();
            if(!tmap.containsKey(f)) tmap.put(f, new PriorityQueue<String>());
            tmap.get(f).add(entry.getKey());
        }
        
        List<String> ans = new ArrayList<>();
        
        for(PriorityQueue<String> pq : tmap.values())
        {
            while(k > 0 && !pq.isEmpty())
            {
                ans.add(pq.poll());
                k--;
            }
            
            if(k == 0) return ans;
        }
        return ans;
    }
}