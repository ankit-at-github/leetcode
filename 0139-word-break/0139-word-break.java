class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> st = new HashSet<>(wordDict);
        
        return find(0, s, st, new Boolean[s.length()]);
    }
    public boolean find(int index, String s, Set<String> st, Boolean[] memo)
    {
        if(index >= s.length()) return true;
        
        if(memo[index] != null) return memo[index];
        
        StringBuilder sb = new StringBuilder();
        for(int i=index; i<s.length(); i++)
        {
            sb.append(s.charAt(i));
            if(st.contains(sb.toString()))
            {
                if(find(i+1, s, st, memo)) return memo[i] = true;
            }
        }
        return memo[index] = false;
    }
}