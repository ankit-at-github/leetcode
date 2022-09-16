class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        if(s.length() == 0) return true;
        Set<String> st = new HashSet<>(wordDict);
        return solve(s, 0, new Boolean[s.length()+1], st);
    }
    public boolean solve(String s, int index, Boolean[] memo, Set<String> st)
    {
        if(index == s.length()) return memo[index] = true;
        
        if(memo[index]!=null) return memo[index];
        
        StringBuilder sb = new StringBuilder();
        for(int i=index; i<s.length(); i++)
        {
            sb.append(s.charAt(i));
            if(st.contains(sb.toString()))
            {
                if(solve(s, i+1, memo, st)) return memo[i] = true;
            }
        }
        return memo[index] = false;
    }
}