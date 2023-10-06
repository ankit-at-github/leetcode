class Solution {
    public int integerBreak(int n) {
        if(n <= 3) return n-1;
        
        int[] memo = new int[n+1];
        
        return helper(n, memo);
    }
    public int helper(int n, int[] memo)
    {   
        if(n <= 3) return n;
        
        if(memo[n] != 0) return memo[n];
        
        int ans = n;
        
        for(int i=2; i<n; i++)
        {
            ans = Math.max(ans, i * helper(n-i, memo));
        }
        memo[n] = ans;
        return ans;
    }
}