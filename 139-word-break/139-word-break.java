class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length()+1];
        //empty string
        dp[0] = true;
        
        for(int i=1; i<=s.length(); i++)
        {
            //checking substring
            for(int j=0; j<i; j++)
            {
                String sub = s.substring(j, i);
                if(set.contains(sub) && dp[j])
                {
                    dp[i] = true;
                    break;
                }
            }
        }
        
        return dp[s.length()];
    }
}