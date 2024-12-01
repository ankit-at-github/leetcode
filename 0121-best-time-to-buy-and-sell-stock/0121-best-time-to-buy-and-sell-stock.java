class Solution {
    public int maxProfit(int[] prices) {
        int mini = prices[0];
        int maxi = 0;
        for(int price : prices){
            mini = Math.min(mini, price);
            maxi = Math.max(maxi, price - mini);
        }
        return maxi;
    }
}