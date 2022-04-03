class Solution {
    public int maximumCandies(int[] candies, long k) {
        int max = Integer.MIN_VALUE;
        for(int x : candies) if(max < x) max = x;
        
        int start = 0, high = max;
        
        while(start < high)
        {
            int mid = (start+high+1)/2;
            if(mid==0) return 0;
            long sum = 0;
            for(int piles : candies) sum+=piles/mid;
            
            if(sum >= k) start = mid;
            else high = mid-1;
        }
        
        return start;
        
        
        
    }
}