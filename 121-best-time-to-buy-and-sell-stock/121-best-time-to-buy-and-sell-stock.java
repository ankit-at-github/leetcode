class Solution {
    public int maxProfit(int[] prices) {
        int mini = prices[0];
        int maxi = 0;
        for(int x : prices)
        {
            mini = Math.min(mini, x);
            maxi = Math.max(maxi, x - mini);
        }
        return maxi;
    }
}