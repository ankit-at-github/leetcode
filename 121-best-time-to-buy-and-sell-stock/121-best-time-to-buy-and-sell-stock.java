class Solution {
    public int maxProfit(int[] prices) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);
        int maxi = 0;
        int i = prices.length-1;
        while(i>=0)
        {
            pq.add(prices[i]);
            maxi = Math.max(maxi, pq.peek() - prices[i]);
            i--;
        }
        return maxi;
    }
}