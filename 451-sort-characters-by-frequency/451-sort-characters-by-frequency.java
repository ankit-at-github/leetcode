class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> freq = new HashMap<>();
        for(char c : s.toCharArray()) freq.put(c, freq.getOrDefault(c, 0)+1);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> b[0] - a[0]);
        for(Map.Entry<Character, Integer> entry : freq.entrySet()) pq.add(new int[]{entry.getValue(), entry.getKey()});
        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty())
        {
            int count = pq.peek()[0];
            char c = (char)pq.poll()[1];
            while(count -- > 0) sb.append(c);
        }
        return sb.toString();
    }
}