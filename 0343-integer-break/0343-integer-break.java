class Solution {
    public int integerBreak(int n) {
        if(n <= 3) return n-1;
        int[] memo = new int[n+1];
        return helper(n, memo);
    }
    public int helper(int n, int[] memo)
    {
        if(n == 0) return 1;
        
        if(memo[n] != 0) return memo[n];
        
        int max_product = n;
        
        for(int i=1; i<n; i++)
            max_product = Math.max(max_product, i * helper(n-i, memo));
        
        memo[n] = max_product;
        return memo[n];
    }
}