class Solution {
    public int mySqrt(int x) {
        if(x < 2) return x;
        long low = 1, high = x/2+1;
        while(low < high)
        {
            long mid = low + (high-low)/2;
            long ans = mid*mid;
            if(ans == x) return (int)mid;
            else
            {
                if(ans > x) high = mid;
                else low = mid+1;
            }
        }
        return (int)low-1;
    }
}