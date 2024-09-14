class Solution {
    public double myPow(double x, int n) {
        double ans = 1;
        if(n == 0) return ans;
        long N = n;
        if(N < 0) N*=-1;
        
        while(N > 0){
            if(N%2 == 0){
                x = x*x;
                N/=2;
            }
            else{
                ans = ans * x;
                N--;
            }
        }
        
        if(n < 0) return 1/ans;
        else return ans;
        
    }
}