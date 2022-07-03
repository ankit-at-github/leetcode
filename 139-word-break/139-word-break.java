class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>();
        for(String d : wordDict) set.add(d);
        
        return findS(s, 0, set, new Boolean[s.length()]);
    }
    public boolean findS(String s, int index, Set<String> set, Boolean[] memo)
    {
        if(index == s.length()) return true;
        
        if(memo[index] != null) return memo[index];
        
        StringBuilder sb = new StringBuilder();
        
        for(int i=index; i<s.length(); i++)
        {
            sb.append(s.charAt(i));
            if(set.contains(sb.toString()))
            {
                if(findS(s, i+1, set, memo)) return memo[index] = true;
            }
        }
        return memo[index] = false;
    }
}