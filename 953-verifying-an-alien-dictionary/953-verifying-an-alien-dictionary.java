class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        if(words.length==1) return true;
        
        Map<Character, Integer> m =new HashMap<>();
        for(int i=0; i<order.length(); i++) m.put(order.charAt(i),i);
        
        for(int i=0; i<words.length-1; i++)
        {
            if(!checkSorted(words[i], words[i+1], m)) return false;
        }
        return true;
    }
    boolean checkSorted(String a, String b, Map<Character, Integer> m)
    {
        for(int i=0; i<Math.min(a.length(), b.length()); i++)
        {
            if(a.charAt(i) != b.charAt(i))
            {
                return m.get(a.charAt(i)) < m.get(b.charAt(i));
            }
        }
        
        return a.length() <= b.length();
    }
}