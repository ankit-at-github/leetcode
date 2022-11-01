class Solution {
    public int maxProfit(int[] prices) {
        int mini = prices[0], right = 0;
        int maxi = 0;
        while(right < prices.length)
        {
            mini = Math.min(mini, prices[right]);
            maxi = Math.max(maxi, prices[right]-mini);
            right++;
        }
        return maxi;
    }
}