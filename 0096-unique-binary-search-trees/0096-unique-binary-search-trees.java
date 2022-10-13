class Solution {
    public int numTrees(int n) {
        int[] memo = new int[n+1];
        return count(n, memo);
    }
    public int count(int n, int[] memo)
    {
        if(n==0 || n==1) return 1;
        
        if(memo[n] != 0) return memo[n];
        
        int total = 0;
        
        for(int i=0; i<n; i++)
        {
            total+=count(i, memo) * count(n-i-1, memo);
        }
        return memo[n] = total;
    }
}