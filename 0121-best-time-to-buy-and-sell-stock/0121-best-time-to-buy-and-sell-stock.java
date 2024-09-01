class Solution {
    public int maxProfit(int[] prices) {
        int profit = Integer.MIN_VALUE;
        int mini = prices[0];
        for(int i=0; i<prices.length; i++){
            if(prices[i] < mini) mini = prices[i];
            profit = Math.max(profit, prices[i] - mini);
        }
        return profit;
    }
}