class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> tm = new HashMap<>();
        
        for(int i=0; i<s.length(); i++)
        {
            if(!tm.containsKey(s.charAt(i))) tm.put(s.charAt(i), 1);
            else tm.put(s.charAt(i), tm.get(s.charAt(i))+1);
        }
        
        Queue<Character> pq = new PriorityQueue<>((a,b) -> (tm.get(b)-tm.get(a)));
        
        for(char c : tm.keySet()) pq.add(c);
        
        StringBuilder sb = new StringBuilder();
        while(pq.size() > 0)
        {
            char c = pq.poll();
            for(int i=0; i<tm.get(c); i++) sb.append(c);
        }
        
        return sb.toString();
        
    }
}