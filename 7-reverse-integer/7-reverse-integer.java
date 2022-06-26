class Solution {
    public int reverse(int x) {
        boolean negative = false;
        if(x < 0) negative = true;
        x = Math.abs(x);
        
        long num = 0;
        
        while(x > 0)
        {
            int digit = x%10;
            num = num*10 + digit;
            x/=10;
        }
        if(negative) num*=-1;
        if(num > Integer.MAX_VALUE || num < Integer.MIN_VALUE) return 0;
        return (int)num;
    }
}