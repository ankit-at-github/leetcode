class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int maxi = Integer.MIN_VALUE;
        for(int p : piles) maxi = Math.max(maxi, p);
        
        int left = 1, right = maxi;
        
        while(left < right)
        {
            int mid = left + (right-left)/2;
            
            int hourspent = 0;
            
            for(int p : piles) hourspent+=Math.ceil((double)p/mid);
            
            if(hourspent <= h) right = mid;
            else left = mid+1;
        }
        return right;
    }
}