class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> st = new HashSet<>(wordDict);
        List<String> output = new ArrayList<>();
        solve(s, 0, st, new StringBuilder(), output);
        return output;
    }
    public void solve(String s, int index, Set<String> st, StringBuilder ans, List<String> output)
    {
        if(index == s.length())
        {
            output.add(ans.toString().trim());
            return;
        }
        StringBuilder sb = new StringBuilder();
        for(int i=index; i<s.length(); i++)
        {
            sb.append(s.charAt(i));
            if(st.contains(sb.toString()))
            {
                ans.append(sb+" ");
                solve(s, i+1, st, ans, output);
                ans.delete(ans.length()-sb.length()-1, ans.length());
            }
        }
    }
}