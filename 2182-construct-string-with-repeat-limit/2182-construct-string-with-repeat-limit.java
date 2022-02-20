class Pair{
    char c;
    int freq;
    Pair(char _c, int _freq)
    {
        c = _c;
        freq = _freq;
    }
}
class Solution {
    public String repeatLimitedString(String s, int repeatLimit) {
        int[] count = new int[26];
        for(int i=0; i<s.length(); i++) count[s.charAt(i) - 'a']++;
        
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> b.c - a.c);
        for(int i=0; i<26; i++)
        {
            if(count[i] > 0) pq.offer(new Pair((char)(i + 'a'), count[i]));
        }
        
        StringBuilder ans = new StringBuilder();
        while(!pq.isEmpty())
        {
            Pair p1 = pq.poll();
            char c1 = p1.c;
            int freq1 = p1.freq;
            if(ans.length()==0 || ans.charAt(ans.length()-1) != c1)
            {
                int times = Math.min(freq1, repeatLimit);
                for(int i=0; i<times; i++) ans.append(c1);
                freq1-=times;
                if(freq1 != 0) pq.offer(new Pair(c1, freq1));
            }
            else
            {
                if(pq.size() == 0) break;
                Pair p2 = pq.poll();
                char c2 = p2.c;
                int freq2 = p2.freq;
                
                ans.append(c2);
                freq2--;
                
                if(freq2 != 0) pq.offer(new Pair(c2, freq2));
                pq.offer(p1);
                
            }
        }
        
        return ans.toString();
    }
}