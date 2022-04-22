class Solution {
    public int maxProfit(int[] prices) {
        int min = prices[0];
        int maxi = 0;
        for(int i=0; i<prices.length; i++)
        {
            if(min > prices[i]) min = prices[i];
            maxi = Math.max(maxi, prices[i]-min);
        }
        return maxi;
    }
}