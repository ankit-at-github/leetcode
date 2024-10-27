class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int maxi = Integer.MIN_VALUE;
        for(int p : piles) maxi = Math.max(maxi, p);
        
        int left = 1, right = maxi;
        while(left < right){
            
            int k = left + (right - left) / 2;
            
            int hourSpent = 0;
            
            for(int p : piles){
                hourSpent+= p/k;
                if(p % k != 0) hourSpent++;
            }
            
            if(hourSpent <= h){
                right = k;
            }
            else left = k+1;
        }
        return left;
    }
}