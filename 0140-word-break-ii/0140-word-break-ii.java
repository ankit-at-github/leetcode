class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> st = new HashSet<>(wordDict);
        List<String> ans = new ArrayList<>();
        
        solve(0, s, st, new StringBuilder(), ans);
        
        return ans;
    }
    public void solve(int index, String s, Set<String> st, StringBuilder temp, List<String> ans)
    {
        if(index == s.length())
        {
            ans.add(temp.toString().trim());
            return;
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i=index; i<s.length(); i++)
        {
            sb.append(s.charAt(i));
            if(st.contains(sb.toString()))
            {
                temp.append(sb+" ");
                solve(i+1, s, st, temp, ans);
                temp.delete(temp.length()-sb.length()-1, temp.length());
            }
        }
    }
}