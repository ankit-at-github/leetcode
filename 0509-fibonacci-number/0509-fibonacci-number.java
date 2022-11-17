class Solution {
    public int fib(int n) {
        int[] memo = new int[n+1];
        Arrays.fill(memo, -1);
        
        return fibo(n, memo);
    }
    public int fibo(int n, int[] memo)
    {
        if(n == 0) return 0;
        if(n == 1) return 1;
        
        if(memo[n] != -1) return memo[n];
        
        return memo[n] = fibo(n-1, memo) + fibo(n-2, memo);
    }
}