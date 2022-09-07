class Solution {
    public int reverse(int x) {
        long ans = 0;
        boolean negative = false;
        if(x < 0)
        {
            x*=-1;
            negative = true;
        }
        while(x > 0)
        {
            ans = ans*10+x%10;
            x/=10;
        }
        if(negative) ans = ans*-1;
        if(ans < Integer.MIN_VALUE || ans > Integer.MAX_VALUE) return 0;
        return (int)ans;
    }
}