class Solution {
    public int concatenatedBinary(int n) {
        int modulo = 1000000007;
        int length = 0;
        long ans = 0;
        for(int i=1; i<=n; i++)
        {
            if((i & (i-1)) == 0) length++;
            
            ans = (ans << length | i )%modulo;
        }
        return (int)ans;
    }
}