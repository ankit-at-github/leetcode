class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> st = new HashSet<>(wordDict);
        return solve(s, 0, st, new Boolean[s.length()]);
    }
    public boolean solve(String s, int index, Set<String> st, Boolean[] memo)
    {
        if(index == s.length()) return true;
        
        if(memo[index]!=null) return memo[index];
        
        StringBuilder sb = new StringBuilder();
        for(int i = index; i<s.length(); i++)
        {
            sb.append(s.charAt(i));
            if(st.contains(sb.toString()))
            {
                if(solve(s, i+1, st, memo)) return memo[i] = true;
            }
        }
        return memo[index] = false;
    }
}