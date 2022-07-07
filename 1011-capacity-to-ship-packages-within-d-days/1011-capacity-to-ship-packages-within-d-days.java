class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int[] lowAndHigh = new int[2];
        get(weights, lowAndHigh);
        
        long low = (long)lowAndHigh[0];
        long high = (long)lowAndHigh[1];
        
        long mini = 0;
        while(low <= high)
        {
            long mid = low + (high-low)/2;
            
            if(isValid(weights, days, mid))
            {
                mini = mid;
                high = mid-1;
            }
            else low = mid+1;
        }
        return (int)mini;
    }
    public void get(int[] weights, int[] ans)
    {
        for(int x : weights)
        {
            ans[0] = Math.max(ans[0], x);
            ans[1]+=x;
        }
    }
    public boolean isValid(int[] weights, int days, long mid)
    {
        int day = 1;
        long sum = 0;
        for(int i=0; i<weights.length; i++)
        {
            sum+=weights[i];
            if(sum > mid)
            {
                day++;
                sum = weights[i];
            }
            
            if(day > days) return false;
        }
        return true;
    }
}