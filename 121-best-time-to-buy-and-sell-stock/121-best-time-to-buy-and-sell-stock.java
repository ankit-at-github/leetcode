class Solution {
    public int maxProfit(int[] prices) {
        int maxi = 0;
        Stack<Integer> st = new Stack<>();
        st.push(prices[prices.length-1]);
        for(int i=prices.length-1; i>=0; i--)
        {
            maxi = Math.max(maxi, st.peek() - prices[i]);
            
            if(prices[i] > st.peek())
                st.push(prices[i]);
        }
        return maxi;
    }
}